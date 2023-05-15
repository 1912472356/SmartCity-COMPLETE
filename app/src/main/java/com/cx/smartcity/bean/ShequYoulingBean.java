package com.cx.smartcity.bean;

import java.util.List;

public class ShequYoulingBean {
    private String img;
    private String content;
    private String date;
    private List<SimpleCommentBean> commentList;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<SimpleCommentBean> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<SimpleCommentBean> commentList) {
        this.commentList = commentList;
    }

    public ShequYoulingBean(String img, String content, String date, List<SimpleCommentBean> commentList) {
        this.img = img;
        this.content = content;
        this.date = date;
        this.commentList = commentList;
    }

    public static class SimpleCommentBean{
        private String name;
        private String content;

        public SimpleCommentBean(String name, String content) {
            this.name = name;
            this.content = content;
        }

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
    }
}
