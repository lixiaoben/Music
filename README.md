##接口参考:

###百度音乐全接口

	http://tingapi.ting.baidu.com/v1/restserver/ting

请求方式：GET

参数处理：format=json&calback=&from=webapp_music&method=以下不同的参数获得不同的数据


####获取歌曲列表

	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0

 >参数： type = 1-新歌榜,2-热歌榜,11-摇滚榜,12-爵士,16-流行,21-欧美金曲榜,22-经典老歌榜,23-情歌对唱榜,24-影视金曲榜,25-网络歌曲榜

>size = 10 //返回条目数量

>offset = 0 //获取偏移

####根据songId获取音乐信息

	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.song.play&songid=675216983

>参数：songid 

####搜索功能

	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.search.catalogSug&query=%E6%B5%B7%E9%98%94%E5%A4%A9%E7%A9%BA

>参数：query = 搜索关键字
	


####获取歌手歌曲列表

	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.artist.getSongList&tinguid=340642446&limits=6&use_cluster=1&order=2

>参数： tinguid = 340642446 歌曲列表中的 all\_artist\_ting\_uid
>
>limits = 6//返回条目数量

###Github下载地址
 
	https://github.com/lixiaoben/Music
>Android Studio版本3.5.2 
>
>Gradle Version 5.4.1
>
>compileSdkVersion 29(Android 10)
	
