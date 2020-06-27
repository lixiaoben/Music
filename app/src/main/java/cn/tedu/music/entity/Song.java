/**
  * Copyright 2020 bejson.com 
  */
package cn.tedu.music.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Auto-generated: 2020-06-27 13:22:17
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Song implements Parcelable {

    private Songinfo songinfo;
    private int error_code;
    private Bitrate bitrate;

    protected Song(Parcel in) {
        songinfo = in.readParcelable(Songinfo.class.getClassLoader());
        error_code = in.readInt();
        bitrate = in.readParcelable(Bitrate.class.getClassLoader());
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public void setSonginfo(Songinfo songinfo) {
         this.songinfo = songinfo;
     }
     public Songinfo getSonginfo() {
         return songinfo;
     }

    public void setError_code(int error_code) {
         this.error_code = error_code;
     }
     public int getError_code() {
         return error_code;
     }

    public void setBitrate(Bitrate bitrate) {
         this.bitrate = bitrate;
     }
     public Bitrate getBitrate() {
         return bitrate;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(songinfo, i);
        parcel.writeInt(error_code);
        parcel.writeParcelable(bitrate, i);
    }

    @Override
    public String toString() {
        return "Song{" +
                "songinfo=" + songinfo +
                ", error_code=" + error_code +
                ", bitrate=" + bitrate +
                '}';
    }
}