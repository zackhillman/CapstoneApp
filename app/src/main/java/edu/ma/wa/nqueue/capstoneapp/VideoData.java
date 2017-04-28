package edu.ma.wa.nqueue.capstoneapp;

/**
 * Created by Josh on 4/28/2017.
 */

public class VideoData {
    private String description;
    private String videolink;

    public VideoData(String desc, String vid){
        description = desc;
        videolink = vid;
    }

    public void setDescription(String desc){
        description = desc;
    }

    public String getDescription(){
        return description;
    }

    public void setVideo(String vid){
        videolink = vid;
    }

    public String getVideo(){
        return videolink;
    }

    public VideoData getVideoObject(){
        return this;
    }

}
