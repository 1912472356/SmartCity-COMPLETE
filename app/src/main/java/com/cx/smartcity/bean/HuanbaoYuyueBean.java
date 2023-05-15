package com.cx.smartcity.bean;

public class HuanbaoYuyueBean {

    private String type;
    private String date;
    private String phone;
    private String address;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HuanbaoYuyueBean(String type, String date, String phone, String address) {
        this.type = type;
        this.date = date;
        this.phone = phone;
        this.address = address;
    }
}
