package com.zhanglian.collect.ui.news;

public class NewsData {
    private String name;
    private int status;
    private String identity;
    private String task;
    private String add;
    private String time;
    public NewsData(String name, int status, String identity, String task, String add, String time) {
        this.name = name;
        this.status = status;
        this.identity = identity;
        this.task = task;
        this.add = add;
        this.time = time;
    }
    public String getName() {
        return name;
    }
    public int getStatus() { return status; }
    public String getIdentity() {
        return identity;
    }
    public String getTask() { return task; }
    public String getAdd() { return add; }
    public String getTime() {
        return time;
    }


}
