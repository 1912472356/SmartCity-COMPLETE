package com.cx.smartcity.bean;

import java.io.Serializable;

public class FupingBean implements Serializable {
    String title;
    String date;
    Integer img = null;
    String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FupingBean(String title, String date, String path, String content) {
        this.title = title;
        this.date = date;
        this.path = path;
        this.content = content;
    }

    String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FupingBean(String title, String date, Integer img, String content) {
        this.title = title;
        this.date = date;
        this.img = img;
        this.content = content;
    }
}
