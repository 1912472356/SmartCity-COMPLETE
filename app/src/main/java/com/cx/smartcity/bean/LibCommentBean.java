package com.cx.smartcity.bean;

import java.util.List;

public class LibCommentBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : [{"createTime":"2022-03-02 17:41:05","id":10,"userId":1,"libraryId":8,"content":"嗯嗯嗯，很不错的图书馆，书很全","myLikeState":true,"userName":"admin"},{"createTime":"2022-03-02 17:40:13","id":9,"userId":1,"libraryId":8,"content":"嗯嗯嗯，很不错的图书馆，书很全","myLikeState":false,"userName":"admin"},{"createTime":"2022-03-02 17:14:10","id":8,"userId":1,"libraryId":8,"content":"这个图书馆挺不错的","myLikeState":false,"userName":"admin"}]
     */

    private String msg;
    private int code;
    private List<DataDTO> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO implements Comparable<DataDTO> {
        /**
         * createTime : 2022-03-02 17:41:05
         * id : 10
         * userId : 1
         * libraryId : 8
         * content : 嗯嗯嗯，很不错的图书馆，书很全
         * myLikeState : true
         * userName : admin
         */

        private String createTime;
        private int id;
        private int userId;
        private int libraryId;
        private String content;
        private boolean myLikeState;
        private String userName;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getLibraryId() {
            return libraryId;
        }

        public void setLibraryId(int libraryId) {
            this.libraryId = libraryId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public boolean isMyLikeState() {
            return myLikeState;
        }

        public void setMyLikeState(boolean myLikeState) {
            this.myLikeState = myLikeState;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        @Override
        public int compareTo(DataDTO dataDTO) {
            return dataDTO.getUserId() - this.getUserId();
        }
    }
}
