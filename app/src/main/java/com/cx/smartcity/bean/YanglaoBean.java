package com.cx.smartcity.bean;

import java.io.Serializable;

public class YanglaoBean implements Serializable {
    private String name;
    private String content;
    private int img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public YanglaoBean(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public YanglaoBean(String name, int img, String content) {
        this.name = name;
        this.content = content;
        this.img = img;
    }
}
