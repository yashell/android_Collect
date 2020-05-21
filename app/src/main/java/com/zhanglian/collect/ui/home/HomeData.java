package com.zhanglian.collect.ui.home;

public class HomeData {
    private String name;
    private int imageId;
    private int status;
    private String time;
    public HomeData(String name, int imageId, int status,String time) {
        this.name = name;
        this.imageId = imageId;
        this.status = status;
        this.time = time;
    }
    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
    public int getStatus() { return status; }
    public String getTime() {
        return time;
    }


}
