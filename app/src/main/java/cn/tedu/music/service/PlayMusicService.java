package cn.tedu.music.service;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Binder;
import android.os.IBinder;

import cn.tedu.music.util.GlobalConsts;

/** 播放音乐的组件 */
public class PlayMusicService extends Service{
    private MediaPlayer player = new MediaPlayer();
    private boolean isLoop = true;

    /**
     * 当Service创建时执行1次
     */
    public void onCreate() {
        super.onCreate();
        //给mediaplayer添加监听
        player.setOnPreparedListener(new OnPreparedListener() {
            //当音乐准备完毕后执行的监听方法
            public void onPrepared(MediaPlayer mp) {
                player.start();
                //发出自定义广播  音乐开始播放
                Intent intent = new Intent(GlobalConsts.ACTION_MUSIC_STARTED);
                sendBroadcast(intent);

            }
        });
        //启动工作线程  每1s发一次更新进度的广播
        //线程不能启动太多  所有在onCreate中启动
        //保证run方法 可以正常执行完毕 防止内存泄漏
        new Thread(){
            public void run() {
                while(isLoop){
                    try {
                        Thread.sleep(1000);
                        //当音乐正在播放时 发送自定义广播
                        if(player.isPlaying()){
                            int total=player.getDuration();
                            int progress=player.getCurrentPosition();
                            Intent intent = new Intent(GlobalConsts.ACTION_UPDATE_MUSIC_PROGRESS);
                            intent.putExtra("total", total);
                            intent.putExtra("progress", progress);
                            sendBroadcast(intent);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    public void onDestroy() {
        //释放mediaplayer
        player.release();
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return new MusicBinder();
    }

    public class MusicBinder extends Binder{
        /**
         * 跳转到position的位置 继续播放/暂停
         */
        public void seekTo(int position){
            player.seekTo(position);
        }

        /**  播放音乐的接口方法  */
        public void playMusic(String url){
            try {
                player.reset();
                player.setDataSource(url);
                player.prepareAsync(); //异步的准备
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /**
         * 暂停或播放
         */
        public void startOrPause() {
            if(player.isPlaying()){
                player.pause();
            }else{
                player.start();
            }
        }

    }

}
