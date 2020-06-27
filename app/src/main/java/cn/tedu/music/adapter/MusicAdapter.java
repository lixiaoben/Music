package cn.tedu.music.adapter;

import java.io.File;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import cn.tedu.music.R;
import cn.tedu.music.entity.Song_list;
import cn.tedu.music.util.ImageLoader;

public class MusicAdapter extends BaseAdapter{
    private Context context;
    private List<Song_list> musics;
    private LayoutInflater inflater;
    private ImageLoader imageLoader;

    public MusicAdapter(Context context, List<Song_list> musics, ListView listView) {
        this.context = context;
        this.musics = musics;
        this.imageLoader = new ImageLoader(context, listView);
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return musics.size();
    }

    @Override
    public Song_list getItem(int position) {
        return musics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_lv_music, null);
            holder = new ViewHolder();
            holder.ivAlbum = convertView.findViewById(R.id.ivAlbum);
            holder.tvTitle = convertView.findViewById(R.id.tvTitle);
            holder.tvSinger =  convertView.findViewById(R.id.tvSinger);
            convertView.setTag(holder);
        }
        holder=(ViewHolder) convertView.getTag();
        //控件的赋值
        Song_list m = getItem(position);
        holder.tvTitle.setText(m.getTitle());
        holder.tvSinger.setText(m.getAuthor());
        //使用ImageLoader工具类加载网络图片
        imageLoader.displayImage(holder.ivAlbum, m.getPic_small());
        return convertView;
    }


    class ViewHolder{
        ImageView ivAlbum;
        TextView tvTitle;
        TextView tvSinger;
    }

    /**
     * 停止工作线程
     */
    public void stopThread() {
        imageLoader.stopThread();
    }

}
