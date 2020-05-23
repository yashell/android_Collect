package com.zhanglian.collect.ui.home;

public class PeopleListData {
    private String name;
    private String id;
    private String phone;
    public PeopleListData(String name, String id, String phone) {
        this.name = name;
        this.id = id;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public String getId() { return id; }
    public String getPhone() {
        return phone;
    }


}
