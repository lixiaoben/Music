package cn.tedu.music.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.tedu.music.R;
import cn.tedu.music.app.MusicApplication;
import cn.tedu.music.entity.Bitrate;
import cn.tedu.music.entity.Song_list;
import cn.tedu.music.entity.Songinfo;
import cn.tedu.music.fragment.HotMusicListFragment;
import cn.tedu.music.fragment.NewMusicListFragment;
import cn.tedu.music.model.LrcCallback;
import cn.tedu.music.model.MusicModel;
import cn.tedu.music.model.SongCallback;
import cn.tedu.music.service.PlayMusicService;
import cn.tedu.music.util.BitmapCallback;
import cn.tedu.music.util.BitmapUtils;
import cn.tedu.music.util.DateUtils;
import cn.tedu.music.util.GlobalConsts;

public class MainActivity extends AppCompatActivity {
    private ViewPager vpContainer;
    private RadioGroup rgRadioGroup;
    private RadioButton rbNew;
    private RadioButton rbHot;
    private ImageView ivCMPic;
    private TextView tvCMTitle;

    private RelativeLayout rlPlayMusic;
    private TextView tvPMTitle, tvPMSinger, tvPMLrc, tvPMCurrentTime, tvPMTotalTime;
    private ImageView ivPMBackground, ivPMAlbum;
    private SeekBar seekBar;

    private List<Fragment>fragments;
    private ServiceConnection conn;
    private MusicInfoReceiver receiver;
    protected PlayMusicService.MusicBinder binder;
    private MusicModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new MusicModel();
        //初始化控件
        setViews();
        //初始化viewPager适配器
        setPagerAdapter();
        //监听
        setListener();
        //绑定service
        bindMusicService();
        //注册组件
        registComponents();

    }

    @Override
    protected void onDestroy() {
        //取消service的绑定
        this.unbindService(conn);
        //取消广播接收器的注册
        this.unregisterReceiver(receiver);

        super.onDestroy();
    }
    /**
     * 当点击后退键时执行
     */
    public void onBackPressed() {
        if(rlPlayMusic.getVisibility() == View.VISIBLE){
            //隐藏
            rlPlayMusic.setVisibility(View.INVISIBLE);
            ScaleAnimation anim = new ScaleAnimation(1, 0, 1, 0, 0, rlPlayMusic.getHeight());
            anim.setDuration(300);
            rlPlayMusic.startAnimation(anim);

        }else{
            super.onBackPressed();
        }
    }

    /**
     * 注册组件
     */
    private void registComponents() {
        receiver = new MusicInfoReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(GlobalConsts.ACTION_MUSIC_STARTED);
        filter.addAction(GlobalConsts.ACTION_UPDATE_MUSIC_PROGRESS);
        this.registerReceiver(receiver, filter);
    }

    /**
     * 绑定Service组件
     */
    private void bindMusicService() {
        Intent intent = new Intent(this, PlayMusicService.class);
        conn = new ServiceConnection() {
            /** 连接异常断开时执行 */
            public void onServiceDisconnected(ComponentName name) {
            }
            /** 连接建立完成后执行 */
            public void onServiceConnected(ComponentName name, IBinder service) {
                 binder = (PlayMusicService.MusicBinder)service;
                //把binder对象传给NewMusicListFragment
                NewMusicListFragment f1=(NewMusicListFragment) fragments.get(0);
                f1.setBinder(binder);
            }
        };
        this.bindService(intent, conn, Service.BIND_AUTO_CREATE);
    }

    //监听
    @SuppressLint("ClickableViewAccessibility")
    private void setListener() {
        //给rlPlayMusic添加touch事件  拦截事件
        rlPlayMusic.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                //自己消费touch事件
                return true;
            }
        });

        //给seekBar添加事件监听
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){ //进度条的更新是由用户引起的
                    binder.seekTo(progress);
                }
            }
        });

        //给圆形ImageView添加事件监听 点击后弹出rlPlayMusic
        ivCMPic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rlPlayMusic.setVisibility(View.VISIBLE);
                //使用动画显示整个rlPlayMusic
                ScaleAnimation anim = new ScaleAnimation(0, 1, 0, 1, 0, rlPlayMusic.getHeight());
                anim.setDuration(300);
                rlPlayMusic.startAnimation(anim);
            }
        });


        //viewpager控制radioGroup
        vpContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0://选中了第一个页面
                        rbNew.setChecked(true);
                        break;
                    case 1://选中了第二个页面
                        rbHot.setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
        });
        //radioGroup控制viewpager
        rgRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.rb_new: //选中了新歌榜
                        vpContainer.setCurrentItem(0);
                        break;
                    case R.id.rb_hot: //选中了热歌榜
                        vpContainer.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    /**
     * 三个按钮的监听
     * @param view
     */
    public void controllMusic(View view){
        MusicApplication app = MusicApplication.getApp();
        switch (view.getId()) {
            case R.id.ivPMPre: //上一曲
                app.preMusic();  //让application执行上一曲的操作
                final Song_list m = app.getCurrentMusic();
                model.loadSongBySongId(m.getSong_id(), new SongCallback() {
                    public void onSongInfoLoaded(Songinfo songinfo, Bitrate bitrate) {
                        m.setSonginfo(songinfo);
                        m.setBitrate(bitrate);
                        //播放音乐
                        String filelink = m.getBitrate().getFile_link();
                        binder.playMusic(filelink);
                    }
                });
                break;
            case R.id.ivPMStart:  //暂停或播放
                binder.startOrPause();
                break;
            case R.id.ivPMNext://下一曲
                app.nextMusic(); //跳转到下一曲
                final Song_list m2=app.getCurrentMusic();
                model.loadSongBySongId(m2.getSong_id(), new SongCallback() {
                    public void onSongInfoLoaded(Songinfo songinfo, Bitrate bitrate) {
                        m2.setSonginfo(songinfo);
                        m2.setBitrate(bitrate);
                        String url = m2.getBitrate().getFile_link();
                        binder.playMusic(url);
                    }
                });

                break;
        }
    }

    /*
     *初始化viewpager的适配器
     */
    private void setPagerAdapter() {
        fragments=new ArrayList<>();
        fragments.add(new NewMusicListFragment());
        fragments.add(new HotMusicListFragment());
        //创建PagerAdapter
        PagerAdapter pagerAdapter=new MainPagerAdapter(getSupportFragmentManager());
        vpContainer.setAdapter(pagerAdapter);
    }
    /**
     * 初始化控件
     */
    private void setViews() {
        vpContainer=findViewById(R.id.vp_container);
        rgRadioGroup=findViewById(R.id.rg_radiogroup);
        rbNew=findViewById(R.id.rb_new);
        rbHot=findViewById(R.id.rb_hot);
        ivCMPic =  findViewById(R.id.ivCMPic);
        tvCMTitle = findViewById(R.id.tvCMTitle);

        rlPlayMusic = (RelativeLayout) findViewById(R.id.rlPlayMusic);
        tvPMTitle = (TextView) findViewById(R.id.tvPMTitle);
        tvPMSinger = (TextView) findViewById(R.id.tvPMSinger);
        tvPMLrc = (TextView) findViewById(R.id.tvPMLrc);
        tvPMCurrentTime = (TextView) findViewById(R.id.tvPMCurrentTime);
        tvPMTotalTime = (TextView) findViewById(R.id.tvPMTotalTime);
        ivPMBackground = (ImageView) findViewById(R.id.ivPMBackground);
        ivPMAlbum = (ImageView) findViewById(R.id.ivPMAlbum);
        seekBar = (SeekBar) findViewById(R.id.seekBar);


    }

    //声明ViewPager的适配器类
    class MainPagerAdapter extends FragmentPagerAdapter{

        public MainPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        /**
         * 返回当前显示的Item(Fragment)
         * @param position
         * @return
         */
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        /**
         * 返回值为fragment的个数
         * @return
         */
        @Override
        public int getCount() {
            return fragments.size();
        }
    }
    /**
     * 广播接收器 接收音乐信息相关的广播
     */
    class MusicInfoReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(GlobalConsts.ACTION_UPDATE_MUSIC_PROGRESS)) {
                //接收到了更新音乐进度的广播
                int total = intent.getIntExtra("total", 0);
                int progress = intent.getIntExtra("progress", 0);
                //更新进度条
                seekBar.setMax(total);
                seekBar.setProgress(progress);
                //更新两个textView
                String time=DateUtils.parseTime(progress);
                tvPMCurrentTime.setText(time);
                tvPMTotalTime.setText(DateUtils.parseTime(total));
                //如果歌词已经加载完毕更新歌词信息
                Song_list m = MusicApplication.getApp().getCurrentMusic();
                HashMap<String, String> lrc = m.getLrc();
                if(lrc!=null){ //歌词是存在的
                    String content=lrc.get(time);
                    if(content!=null){ //当前时间需要更新歌词
                        tvPMLrc.setText(content);
                    }
                }


            }else if(action.equals(GlobalConsts.ACTION_MUSIC_STARTED)){
                //音乐开始播放  获取音乐的基本信息
                final Song_list m= MusicApplication.getApp().getCurrentMusic();
                //更新底部栏中的imageView 与 TextView
                String smallPicPath=m.getPic_small();
                String title = m.getTitle();
                tvCMTitle.setText(title);
                BitmapUtils.loadBitmap(smallPicPath, new BitmapCallback() {
                    public void onBitmapLoaded(Bitmap bitmap) {
                        if(bitmap!=null){ //下载成功
                            ivCMPic.setImageBitmap(bitmap);
                            //让imageView转起来
                            RotateAnimation anim = new RotateAnimation(0, 360, ivCMPic.getWidth()/2, ivCMPic.getHeight()/2);
                            anim.setDuration(10000);
                            //匀速旋转
                            anim.setInterpolator(new LinearInterpolator());
                            //无限重复
                            anim.setRepeatCount(Animation.INFINITE);
                            ivCMPic.startAnimation(anim);

                        }else{
                            ivCMPic.setImageResource(R.mipmap.ic_launcher);
                        }
                    }
                });
                //更新播放界面中的ivPMAlbum
                String albumPic=m.getAlbum_500_500();
                if(albumPic.equals("")){
                    albumPic = m.getAlbum_1000_1000();
                }
                BitmapUtils.loadBitmap(albumPic, new BitmapCallback() {
                    public void onBitmapLoaded(Bitmap bitmap) {
                        if(bitmap!=null){ //下载
                            ivPMAlbum.setImageBitmap(bitmap);
                        }else{
                            ivPMAlbum.setImageResource(R.mipmap.default_music_pic);
                        }
                    }
                });
                //更新背景图片 ivPMBackground
                String backPic = m.getPic_radio();
                if(backPic.equals("")){
                    backPic = m.getPic_s500();
                }
                if(backPic.equals("")){
                    backPic = m.getAlbum_500_500();
                }
                if(backPic.equals("")){
                    backPic = albumPic;
                }
                BitmapUtils.loadBitmap(backPic, 8, new BitmapCallback() {
                    public void onBitmapLoaded(Bitmap bitmap) {
                        if(bitmap!=null){ //背景图片下载成功
                            //把背景图片模糊化处理
                            BitmapUtils.loadBlurBitmap(bitmap, 10, new BitmapCallback() {
                                public void onBitmapLoaded(Bitmap bitmap) {
                                    ivPMBackground.setImageBitmap(bitmap);
                                }
                            });
                        }else{
                            ivPMBackground.setImageResource(R.mipmap.default_music_background);
                        }
                    }
                });
                //更新tvPMTitle  tvPMSinger
                tvPMTitle.setText(m.getTitle());
                tvPMSinger.setText(m.getAuthor());
                //下载歌词 并且解析歌词
                if(m.getLrc()!=null){ //以前已经下载过了
                    return;
                }
                String lrcPath = m.getLrclink();
                if(lrcPath==null || lrcPath.equals("")){
                    Toast.makeText(context, "该歌曲没有歌词", Toast.LENGTH_SHORT).show();
                    return;
                }
                model.loadLrc(lrcPath, new LrcCallback(){
                    public void onLrcLoaded(HashMap<String, String> lrc) {
                        m.setLrc(lrc);  //歌词加载解析保存完毕
                    }
                });

            }
        }
    }

}
