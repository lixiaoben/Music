/**
  * Copyright 2020 bejson.com 
  */
package cn.tedu.music.entity;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Auto-generated: 2020-06-26 13:40:33
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Billboard implements Parcelable {

    private String billboard_type;
    private String billboard_no;
    private String update_date;
    private String billboard_songnum;
    private int havemore;
    private String name;
    private String comment;
    private String pic_s192;
    private String pic_s640;
    private String pic_s444;
    private String pic_s260;
    private String pic_s210;
    private String web_url;
    private String color;
    private String bg_color;
    private String bg_pic;

    protected Billboard(Parcel in) {
        billboard_type = in.readString();
        billboard_no = in.readString();
        billboard_songnum = in.readString();
        havemore = in.readInt();
        name = in.readString();
        comment = in.readString();
        pic_s192 = in.readString();
        pic_s640 = in.readString();
        pic_s444 = in.readString();
        pic_s260 = in.readString();
        pic_s210 = in.readString();
        web_url = in.readString();
        color = in.readString();
        bg_color = in.readString();
        bg_pic = in.readString();
    }

    public static final Creator<Billboard> CREATOR = new Creator<Billboard>() {
        @Override
        public Billboard createFromParcel(Parcel in) {
            return new Billboard(in);
        }

        @Override
        public Billboard[] newArray(int size) {
            return new Billboard[size];
        }
    };

    public void setBillboard_type(String billboard_type) {
         this.billboard_type = billboard_type;
     }
     public String getBillboard_type() {
         return billboard_type;
     }

    public void setBillboard_no(String billboard_no) {
         this.billboard_no = billboard_no;
     }
     public String getBillboard_no() {
         return billboard_no;
     }

    public void setUpdate_date(String update_date) {
         this.update_date = update_date;
     }
     public String getUpdate_date() {
         return update_date;
     }

    public void setBillboard_songnum(String billboard_songnum) {
         this.billboard_songnum = billboard_songnum;
     }
     public String getBillboard_songnum() {
         return billboard_songnum;
     }

    public void setHavemore(int havemore) {
         this.havemore = havemore;
     }
     public int getHavemore() {
         return havemore;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setComment(String comment) {
         this.comment = comment;
     }
     public String getComment() {
         return comment;
     }

    public void setPic_s192(String pic_s192) {
         this.pic_s192 = pic_s192;
     }
     public String getPic_s192() {
         return pic_s192;
     }

    public void setPic_s640(String pic_s640) {
         this.pic_s640 = pic_s640;
     }
     public String getPic_s640() {
         return pic_s640;
     }

    public void setPic_s444(String pic_s444) {
         this.pic_s444 = pic_s444;
     }
     public String getPic_s444() {
         return pic_s444;
     }

    public void setPic_s260(String pic_s260) {
         this.pic_s260 = pic_s260;
     }
     public String getPic_s260() {
         return pic_s260;
     }

    public void setPic_s210(String pic_s210) {
         this.pic_s210 = pic_s210;
     }
     public String getPic_s210() {
         return pic_s210;
     }

    public void setWeb_url(String web_url) {
         this.web_url = web_url;
     }
     public String getWeb_url() {
         return web_url;
     }

    public void setColor(String color) {
         this.color = color;
     }
     public String getColor() {
         return color;
     }

    public void setBg_color(String bg_color) {
         this.bg_color = bg_color;
     }
     public String getBg_color() {
         return bg_color;
     }

    public void setBg_pic(String bg_pic) {
         this.bg_pic = bg_pic;
     }
     public String getBg_pic() {
         return bg_pic;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(billboard_type);
        parcel.writeString(billboard_no);
        parcel.writeString(billboard_songnum);
        parcel.writeInt(havemore);
        parcel.writeString(name);
        parcel.writeString(comment);
        parcel.writeString(pic_s192);
        parcel.writeString(pic_s640);
        parcel.writeString(pic_s444);
        parcel.writeString(pic_s260);
        parcel.writeString(pic_s210);
        parcel.writeString(web_url);
        parcel.writeString(color);
        parcel.writeString(bg_color);
        parcel.writeString(bg_pic);
    }
}