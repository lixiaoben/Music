package cn.tedu.music.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cn.tedu.music.R;
import cn.tedu.music.adapter.MusicAdapter;
import cn.tedu.music.app.MusicApplication;
import cn.tedu.music.entity.Bitrate;
import cn.tedu.music.entity.Song_list;
import cn.tedu.music.entity.Songinfo;
import cn.tedu.music.model.MusicListCallback;
import cn.tedu.music.model.MusicModel;
import cn.tedu.music.model.SongCallback;
import cn.tedu.music.service.PlayMusicService;

public class NewMusicListFragment extends androidx.fragment.app.Fragment {
    private ListView lvNewMusic;
    private MusicModel model;
    private List<Song_list>songs;
    private MusicAdapter adapter;
    private PlayMusicService.MusicBinder binder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_music_list,null);
        setViews(view);
        //调用业务层的方法加载所有新歌榜音乐
        model=new MusicModel();
        //异步需要接口的回调,同步可以给返回值
        model.loadMusicList(0, 100, new MusicListCallback() {
            @Override
            public void onMusicListLoaded(List<Song_list> songs) {
                //当列表加载完毕会回调该方法
                NewMusicListFragment.this.songs=songs;
                setAdapter();
            }
        });
        setListeners();
        return view;
    }

    /**
     * 添加监听
     */
    private void setListeners() {
        lvNewMusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Song_list music=songs.get(position);
                //把musics与position都存入applicaton
                MusicApplication app = MusicApplication.getApp();
                app.setMusics(songs);
                app.setPosition(position);

                //通过music的songId加载这首音乐的基本信息
                String songId = music.getSong_id();
                model.loadSongBySongId(songId, new SongCallback() {
                    @Override
                    public void onSongInfoLoaded(Songinfo songinfo, Bitrate bitrate) {
                        //把解析出来的urls与songinfo存入music对象
                        music.setSonginfo(songinfo);
                        music.setBitrate(bitrate);
                        //播放音乐
                        String fileLink=bitrate.getFile_link();
                        binder.playMusic(fileLink);

                    }
                });
            }
        });
    }


    private void setViews(View view) {
        lvNewMusic=view.findViewById(R.id.lv_music);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //把adapter中的线程给停掉
        adapter.stopThread();
    }
    private void setAdapter() {
        adapter=new MusicAdapter(getActivity(),songs,lvNewMusic);
        lvNewMusic.setAdapter(adapter);
    }
    /**
     * 接收传递过来的binder对象
     */
    public void setBinder(PlayMusicService.MusicBinder binder) {
        this.binder = binder;
    }

}
