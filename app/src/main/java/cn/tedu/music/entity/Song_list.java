/**
  * Copyright 2020 bejson.com 
  */
package cn.tedu.music.entity;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.HashMap;

/**
 * Auto-generated: 2020-06-26 13:40:33
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Song_list implements Parcelable {

    private String artist_id;
    private String language;
    private String pic_big;
    private String pic_small;
    private String country;
    private String area;
    private String publishtime;
    private String album_no;
    private String lrclink;
    private String copy_type;
    private String hot;
    private String all_artist_ting_uid;
    private String resource_type;
    private String is_new;
    private String rank_change;
    private String rank;
    private String all_artist_id;
    private String style;
    private String del_status;
    private String relate_status;
    private String toneid;
    private String all_rate;
    private int file_duration;
    private int has_mv_mobile;
    private String versions;
    private String bitrate_fee;
    private String biaoshi;
    private String info;
    private String has_filmtv;
    private String si_proxycompany;
    private String res_encryption_flag;
    private String song_id;
    private String title;
    private String ting_uid;
    private String author;
    private String album_id;
    private String album_title;
    private int is_first_publish;
    private int havehigh;
    private int charge;
    private int has_mv;
    private int learn;
    private String song_source;
    private String piao_id;
    private String korean_bb_song;
    private String resource_type_ext;
    private String mv_provider;
    private String artist_name;
    private String pic_radio;
    private String pic_s500;
    private String pic_premium;
    private String pic_huge;
    private String album_500_500;
    private String album_800_800;
    private String album_1000_1000;
    private Songinfo songinfo;
    private Bitrate bitrate;
    private HashMap<String, String> lrc;
    public HashMap<String, String> getLrc() {
        return lrc;
    }

    public void setLrc(HashMap<String, String> lrc) {
        this.lrc = lrc;
    }

    public Song_list() {
    }

    protected Song_list(Parcel in) {
        artist_id = in.readString();
        language = in.readString();
        pic_big = in.readString();
        pic_small = in.readString();
        country = in.readString();
        area = in.readString();
        publishtime = in.readString();
        album_no = in.readString();
        lrclink = in.readString();
        copy_type = in.readString();
        hot = in.readString();
        all_artist_ting_uid = in.readString();
        resource_type = in.readString();
        is_new = in.readString();
        rank_change = in.readString();
        rank = in.readString();
        all_artist_id = in.readString();
        style = in.readString();
        del_status = in.readString();
        relate_status = in.readString();
        toneid = in.readString();
        all_rate = in.readString();
        file_duration = in.readInt();
        has_mv_mobile = in.readInt();
        versions = in.readString();
        bitrate_fee = in.readString();
        biaoshi = in.readString();
        info = in.readString();
        has_filmtv = in.readString();
        si_proxycompany = in.readString();
        res_encryption_flag = in.readString();
        song_id = in.readString();
        title = in.readString();
        ting_uid = in.readString();
        author = in.readString();
        album_id = in.readString();
        album_title = in.readString();
        is_first_publish = in.readInt();
        havehigh = in.readInt();
        charge = in.readInt();
        has_mv = in.readInt();
        learn = in.readInt();
        song_source = in.readString();
        piao_id = in.readString();
        korean_bb_song = in.readString();
        resource_type_ext = in.readString();
        mv_provider = in.readString();
        artist_name = in.readString();
        pic_radio = in.readString();
        pic_s500 = in.readString();
        pic_premium = in.readString();
        pic_huge = in.readString();
        album_500_500 = in.readString();
        album_800_800 = in.readString();
        album_1000_1000 = in.readString();
        songinfo = in.readParcelable(Songinfo.class.getClassLoader());
        bitrate = in.readParcelable(Bitrate.class.getClassLoader());
    }

    public static final Creator<Song_list> CREATOR = new Creator<Song_list>() {
        @Override
        public Song_list createFromParcel(Parcel in) {
            return new Song_list(in);
        }

        @Override
        public Song_list[] newArray(int size) {
            return new Song_list[size];
        }
    };

    public String getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPic_big() {
        return pic_big;
    }

    public void setPic_big(String pic_big) {
        this.pic_big = pic_big;
    }

    public String getPic_small() {
        return pic_small;
    }

    public void setPic_small(String pic_small) {
        this.pic_small = pic_small;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getAlbum_no() {
        return album_no;
    }

    public void setAlbum_no(String album_no) {
        this.album_no = album_no;
    }

    public String getLrclink() {
        return lrclink;
    }

    public void setLrclink(String lrclink) {
        this.lrclink = lrclink;
    }

    public String getCopy_type() {
        return copy_type;
    }

    public void setCopy_type(String copy_type) {
        this.copy_type = copy_type;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getAll_artist_ting_uid() {
        return all_artist_ting_uid;
    }

    public void setAll_artist_ting_uid(String all_artist_ting_uid) {
        this.all_artist_ting_uid = all_artist_ting_uid;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public String getRank_change() {
        return rank_change;
    }

    public void setRank_change(String rank_change) {
        this.rank_change = rank_change;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAll_artist_id() {
        return all_artist_id;
    }

    public void setAll_artist_id(String all_artist_id) {
        this.all_artist_id = all_artist_id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDel_status() {
        return del_status;
    }

    public void setDel_status(String del_status) {
        this.del_status = del_status;
    }

    public String getRelate_status() {
        return relate_status;
    }

    public void setRelate_status(String relate_status) {
        this.relate_status = relate_status;
    }

    public String getToneid() {
        return toneid;
    }

    public void setToneid(String toneid) {
        this.toneid = toneid;
    }

    public String getAll_rate() {
        return all_rate;
    }

    public void setAll_rate(String all_rate) {
        this.all_rate = all_rate;
    }

    public int getFile_duration() {
        return file_duration;
    }

    public void setFile_duration(int file_duration) {
        this.file_duration = file_duration;
    }

    public int getHas_mv_mobile() {
        return has_mv_mobile;
    }

    public void setHas_mv_mobile(int has_mv_mobile) {
        this.has_mv_mobile = has_mv_mobile;
    }

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

    public String getBitrate_fee() {
        return bitrate_fee;
    }

    public void setBitrate_fee(String bitrate_fee) {
        this.bitrate_fee = bitrate_fee;
    }

    public String getBiaoshi() {
        return biaoshi;
    }

    public void setBiaoshi(String biaoshi) {
        this.biaoshi = biaoshi;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHas_filmtv() {
        return has_filmtv;
    }

    public void setHas_filmtv(String has_filmtv) {
        this.has_filmtv = has_filmtv;
    }

    public String getSi_proxycompany() {
        return si_proxycompany;
    }

    public void setSi_proxycompany(String si_proxycompany) {
        this.si_proxycompany = si_proxycompany;
    }

    public String getRes_encryption_flag() {
        return res_encryption_flag;
    }

    public void setRes_encryption_flag(String res_encryption_flag) {
        this.res_encryption_flag = res_encryption_flag;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTing_uid() {
        return ting_uid;
    }

    public void setTing_uid(String ting_uid) {
        this.ting_uid = ting_uid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_title() {
        return album_title;
    }

    public void setAlbum_title(String album_title) {
        this.album_title = album_title;
    }

    public int getIs_first_publish() {
        return is_first_publish;
    }

    public void setIs_first_publish(int is_first_publish) {
        this.is_first_publish = is_first_publish;
    }

    public int getHavehigh() {
        return havehigh;
    }

    public void setHavehigh(int havehigh) {
        this.havehigh = havehigh;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public int getHas_mv() {
        return has_mv;
    }

    public void setHas_mv(int has_mv) {
        this.has_mv = has_mv;
    }

    public int getLearn() {
        return learn;
    }

    public void setLearn(int learn) {
        this.learn = learn;
    }

    public String getSong_source() {
        return song_source;
    }

    public void setSong_source(String song_source) {
        this.song_source = song_source;
    }

    public String getPiao_id() {
        return piao_id;
    }

    public void setPiao_id(String piao_id) {
        this.piao_id = piao_id;
    }

    public String getKorean_bb_song() {
        return korean_bb_song;
    }

    public void setKorean_bb_song(String korean_bb_song) {
        this.korean_bb_song = korean_bb_song;
    }

    public String getResource_type_ext() {
        return resource_type_ext;
    }

    public void setResource_type_ext(String resource_type_ext) {
        this.resource_type_ext = resource_type_ext;
    }

    public String getMv_provider() {
        return mv_provider;
    }

    public void setMv_provider(String mv_provider) {
        this.mv_provider = mv_provider;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getPic_radio() {
        return pic_radio;
    }

    public void setPic_radio(String pic_radio) {
        this.pic_radio = pic_radio;
    }

    public String getPic_s500() {
        return pic_s500;
    }

    public void setPic_s500(String pic_s500) {
        this.pic_s500 = pic_s500;
    }

    public String getPic_premium() {
        return pic_premium;
    }

    public void setPic_premium(String pic_premium) {
        this.pic_premium = pic_premium;
    }

    public String getPic_huge() {
        return pic_huge;
    }

    public void setPic_huge(String pic_huge) {
        this.pic_huge = pic_huge;
    }

    public String getAlbum_500_500() {
        return album_500_500;
    }

    public void setAlbum_500_500(String album_500_500) {
        this.album_500_500 = album_500_500;
    }

    public String getAlbum_800_800() {
        return album_800_800;
    }

    public void setAlbum_800_800(String album_800_800) {
        this.album_800_800 = album_800_800;
    }

    public String getAlbum_1000_1000() {
        return album_1000_1000;
    }

    public void setAlbum_1000_1000(String album_1000_1000) {
        this.album_1000_1000 = album_1000_1000;
    }

    public Songinfo getSonginfo() {
        return songinfo;
    }

    public void setSonginfo(Songinfo songinfo) {
        this.songinfo = songinfo;
    }

    public Bitrate getBitrate() {
        return bitrate;
    }

    public void setBitrate(Bitrate bitrate) {
        this.bitrate = bitrate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(artist_id);
        parcel.writeString(language);
        parcel.writeString(pic_big);
        parcel.writeString(pic_small);
        parcel.writeString(country);
        parcel.writeString(area);
        parcel.writeString(publishtime);
        parcel.writeString(album_no);
        parcel.writeString(lrclink);
        parcel.writeString(copy_type);
        parcel.writeString(hot);
        parcel.writeString(all_artist_ting_uid);
        parcel.writeString(resource_type);
        parcel.writeString(is_new);
        parcel.writeString(rank_change);
        parcel.writeString(rank);
        parcel.writeString(all_artist_id);
        parcel.writeString(style);
        parcel.writeString(del_status);
        parcel.writeString(relate_status);
        parcel.writeString(toneid);
        parcel.writeString(all_rate);
        parcel.writeInt(file_duration);
        parcel.writeInt(has_mv_mobile);
        parcel.writeString(versions);
        parcel.writeString(bitrate_fee);
        parcel.writeString(biaoshi);
        parcel.writeString(info);
        parcel.writeString(has_filmtv);
        parcel.writeString(si_proxycompany);
        parcel.writeString(res_encryption_flag);
        parcel.writeString(song_id);
        parcel.writeString(title);
        parcel.writeString(ting_uid);
        parcel.writeString(author);
        parcel.writeString(album_id);
        parcel.writeString(album_title);
        parcel.writeInt(is_first_publish);
        parcel.writeInt(havehigh);
        parcel.writeInt(charge);
        parcel.writeInt(has_mv);
        parcel.writeInt(learn);
        parcel.writeString(song_source);
        parcel.writeString(piao_id);
        parcel.writeString(korean_bb_song);
        parcel.writeString(resource_type_ext);
        parcel.writeString(mv_provider);
        parcel.writeString(artist_name);
        parcel.writeString(pic_radio);
        parcel.writeString(pic_s500);
        parcel.writeString(pic_premium);
        parcel.writeString(pic_huge);
        parcel.writeString(album_500_500);
        parcel.writeString(album_800_800);
        parcel.writeString(album_1000_1000);
        parcel.writeParcelable(songinfo, i);
        parcel.writeParcelable(bitrate, i);
    }

    @Override
    public String toString() {
        return "Song_list{" +
                "artist_id='" + artist_id + '\'' +
                ", language='" + language + '\'' +
                ", pic_big='" + pic_big + '\'' +
                ", pic_small='" + pic_small + '\'' +
                ", country='" + country + '\'' +
                ", area='" + area + '\'' +
                ", publishtime='" + publishtime + '\'' +
                ", album_no='" + album_no + '\'' +
                ", lrclink='" + lrclink + '\'' +
                ", copy_type='" + copy_type + '\'' +
                ", hot='" + hot + '\'' +
                ", all_artist_ting_uid='" + all_artist_ting_uid + '\'' +
                ", resource_type='" + resource_type + '\'' +
                ", is_new='" + is_new + '\'' +
                ", rank_change='" + rank_change + '\'' +
                ", rank='" + rank + '\'' +
                ", all_artist_id='" + all_artist_id + '\'' +
                ", style='" + style + '\'' +
                ", del_status='" + del_status + '\'' +
                ", relate_status='" + relate_status + '\'' +
                ", toneid='" + toneid + '\'' +
                ", all_rate='" + all_rate + '\'' +
                ", file_duration=" + file_duration +
                ", has_mv_mobile=" + has_mv_mobile +
                ", versions='" + versions + '\'' +
                ", bitrate_fee='" + bitrate_fee + '\'' +
                ", biaoshi='" + biaoshi + '\'' +
                ", info='" + info + '\'' +
                ", has_filmtv='" + has_filmtv + '\'' +
                ", si_proxycompany='" + si_proxycompany + '\'' +
                ", res_encryption_flag='" + res_encryption_flag + '\'' +
                ", song_id='" + song_id + '\'' +
                ", title='" + title + '\'' +
                ", ting_uid='" + ting_uid + '\'' +
                ", author='" + author + '\'' +
                ", album_id='" + album_id + '\'' +
                ", album_title='" + album_title + '\'' +
                ", is_first_publish=" + is_first_publish +
                ", havehigh=" + havehigh +
                ", charge=" + charge +
                ", has_mv=" + has_mv +
                ", learn=" + learn +
                ", song_source='" + song_source + '\'' +
                ", piao_id='" + piao_id + '\'' +
                ", korean_bb_song='" + korean_bb_song + '\'' +
                ", resource_type_ext='" + resource_type_ext + '\'' +
                ", mv_provider='" + mv_provider + '\'' +
                ", artist_name='" + artist_name + '\'' +
                ", pic_radio='" + pic_radio + '\'' +
                ", pic_s500='" + pic_s500 + '\'' +
                ", pic_premium='" + pic_premium + '\'' +
                ", pic_huge='" + pic_huge + '\'' +
                ", album_500_500='" + album_500_500 + '\'' +
                ", album_800_800='" + album_800_800 + '\'' +
                ", album_1000_1000='" + album_1000_1000 + '\'' +
                ", songinfo=" + songinfo +
                ", bitrate=" + bitrate +
                '}';
    }
}