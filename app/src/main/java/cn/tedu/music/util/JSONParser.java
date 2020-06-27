package cn.tedu.music.util;

import com.google.gson.Gson;

import java.util.List;

import cn.tedu.music.entity.JsonRootBean;
import cn.tedu.music.entity.JsonRootBean;
import cn.tedu.music.entity.Song;
import cn.tedu.music.entity.Song_list;
import cn.tedu.music.entity.Song_list;

public class JSONParser {
    public static List<Song_list> parseMusicList(String data) throws  Exception{
        Gson gson=new Gson();
        JsonRootBean jsonRootBean = gson.fromJson(data, JsonRootBean.class);
        List<Song_list> song_list = jsonRootBean.getSong_list();
        return song_list;
    }
    public static Song parseSongUrl(String data) throws  Exception{
        Gson gson=new Gson();
        Song song = gson.fromJson(data, Song.class);
        return song;

    }
}
