package cn.tedu.music.model;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import cn.tedu.music.app.MusicApplication;
import cn.tedu.music.entity.Song;
import cn.tedu.music.entity.Song_list;
import cn.tedu.music.util.HttpUtils;
import cn.tedu.music.util.JSONParser;
import cn.tedu.music.util.UrlFactory;

/**
 * 音乐相关的业务类
 */
public class MusicModel {
    public void loadMusicList(final int offset, final int size,final MusicListCallback callback){
        /**
         * Params-->Void 执行doInBackground方法传入的参数,传入Void表示没有参数,如果传递参数需要在execute()方法中传入参数
         * Progress,Void 执行onProgressUpdate方传入的参数,传入Void表示没有参数,如果传递参数需要在doInBackground()方法传入参数
         * Result,String doInBackground方法的返回值,该返回值可以在onPostExecute获取
         */
        @SuppressLint("StaticFieldLeak") AsyncTask<Void,Void,List<Song_list>> task=new AsyncTask<Void, Void, List<Song_list>>() {
            //后台执行可以执行耗时操作
            @Override
            protected List<Song_list> doInBackground(Void... voids) {
                try {
                    //发送http请求
                    String url= UrlFactory.getNewMusicListUrl(offset,size);
                    String result= HttpUtils.getStringForOkHttp(url);
                    List<Song_list> songs = JSONParser.parseMusicList(result);

                    return songs;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            //doInBackground方法执行后执行,接收doInBackground的返回结果，用于更新UI
            @Override
            protected void onPostExecute(List<Song_list> songs) {
//                Log.e("tedu","song_lists="+song_lists);
                //主线程,更新UI
                callback.onMusicListLoaded(songs);
            }
        };
        task.execute();
    }

    public void loadSongBySongId(final String songId,final SongCallback callback) {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void,Void,Song> task=new AsyncTask<Void, Void, Song>() {
            //后台执行可以执行耗时操作
            @Override
            protected Song doInBackground(Void... voids) {
                try {
                    //发送http请求
                    String url= UrlFactory.getSong(songId);
                    String result= HttpUtils.getStringForOkHttp(url);
                    Song song = JSONParser.parseSongUrl(result);
                    return song ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            //doInBackground方法执行后执行,接收doInBackground的返回结果，用于更新UI
            @Override
            protected void onPostExecute(Song result) {
                if(result!=null){
                    callback.onSongInfoLoaded(result.getSonginfo(),result.getBitrate());
                }else{
                    callback.onSongInfoLoaded(null,null);
                }
            }
        };
        task.execute();
    }
    /**
     * 加载歌词数据  解析歌词文本  封装为
     * HashMap<String, String> lrc;
     * @param lrcPath
     * @param callback
     */
    @SuppressLint("StaticFieldLeak")
    public void loadLrc(final String lrcPath, final LrcCallback callback) {
        AsyncTask<String, String, HashMap<String, String> > task;
        task = new AsyncTask<String, String, HashMap<String,String>>(){
            protected HashMap<String, String> doInBackground(String... params) {
                try {
                    if(lrcPath == null || lrcPath.equals("")){ //歌词目录不存在
                        return null;
                    }
                    //声明歌词缓存文件对象
                    String filename = lrcPath.substring(lrcPath.lastIndexOf("/"));
                    File file = new File(MusicApplication.getApp().getCacheDir(), "lrc"+filename);
                    PrintWriter out = null;
                    if(!file.getParentFile().exists()){ //父目录不存在
                        file.getParentFile().mkdirs();
                    }
                    InputStream is = null;
                    boolean isFromFile=false;
                    if(file.exists()){ //缓存目录中已经下载过歌词了
                        is = new FileInputStream(file);
                        isFromFile = true;
                    }else{// 缓存目录中没有则下载歌词
                        is = HttpUtils.getInputStream(lrcPath);
                        out = new PrintWriter(file);
                        isFromFile = false;
                    }
                    //解析输入流
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line = null;
                    HashMap<String, String> lrc = new HashMap<String, String>();
                    while((line=reader.readLine())!=null){
                        if(!isFromFile){
                            //把line 保存到歌词缓存文件中
                            out.println(line);
                            out.flush();
                        }
                        //判断格式是否是:
                        //  [title]歌名 ...
                        if(!line.startsWith("[") || !line.contains(":") || !line.contains(".")){
                            continue;
                        }
                        //  [00:00.00]歌词内容
                        String time = line.substring(1, line.indexOf("."));
                        String content = line.substring(line.lastIndexOf("]")+1);
                        lrc.put(time, content);
                    }
                    if(out!=null){ //关闭输出流
                        out.close();
                    }
                    return lrc;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            protected void onPostExecute(HashMap<String, String> result) {
                //调用回调方法
                callback.onLrcLoaded(result);
            }
        };
        task.execute();
    }

}
