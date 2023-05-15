package com.cx.smartcity.bean;

public class RecentCallBean {
    private String tell;
    private String type;
    private String date;

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

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

    public RecentCallBean(String tell, String type, String date) {
        this.tell = tell;
        this.type = type;
        this.date = date;
    }
}
