package cn.tedu.music.app;

import java.util.List;

import android.app.Application;

import cn.tedu.music.entity.Song_list;


public class MusicApplication extends Application {
	private List<Song_list> musics; // 当前播放列表
	private int position; // 当前正在播放音乐的位置
	private static MusicApplication app;

	@Override
	public void onCreate() {
		super.onCreate();
		app = this;
	}

	public static MusicApplication getApp(){
		return app;
	}

	public void setMusics(List<Song_list> musics) {
		this.musics = musics;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * 获取当前正在播放的音乐
	 *
	 * @return
	 */
	public Song_list getCurrentMusic() {
		return musics.get(position);
	}
	/**
	 * 换到上一首歌曲
	 */
	public void preMusic() {
		position = position == 0 ? 0 : position-1;
	}
	/**
	 * 换到下一首歌曲
	 */
	public void nextMusic() {
		position = position == musics.size()-1 ? 0 : position+1;
	}

}
