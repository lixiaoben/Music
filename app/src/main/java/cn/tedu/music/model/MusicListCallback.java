package cn.tedu.music.model;

import java.util.List;

import cn.tedu.music.entity.Song_list;
import cn.tedu.music.entity.Song_list;
import cn.tedu.music.entity.Song_list;

public interface MusicListCallback {
    /**
     * 当列表加载完毕后回调该方法
     */
    void onMusicListLoaded(List<Song_list>songs);
}
