package cn.tedu.music.model;

import cn.tedu.music.entity.Bitrate;
import cn.tedu.music.entity.Songinfo;

public interface SongCallback {
    /**
     * 回调方法
     * 当音乐基本信息加载完毕后执行
     * @param songinfo
     * @param bitrate
     */
    public void onSongInfoLoaded(Songinfo songinfo, Bitrate bitrate);
}

