package cn.tedu.music.util;

/**
 * URL工厂
 */
public class UrlFactory {
    public static String getNewMusicListUrl(int offset,int size){
            String url="http://tingapi.ting.baidu.com/v1/restserver/ting?format=json&calback=&from=webapp_music&method=baidu.ting.billboard.billList&type=1&offset="+offset+"&size="+size;
        return url;
    }

    public static String getSong(String songId){
        String url="http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.song.play&songid="+songId;
        return url;
    }
}
