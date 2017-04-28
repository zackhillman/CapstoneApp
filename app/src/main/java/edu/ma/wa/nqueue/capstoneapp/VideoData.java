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


    public String getDescription(){
        return description;
    }

    public String getVideo(){
        return videolink;
    }


}
