package com.cx.smartcity.bean;

import java.util.List;

public class EventCommentBean {
    /**
     * total : 1
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2022-12-11 13:02:45","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":4098,"userId":1114889,"activityId":11,"content":"第一","commentTime":"2022-12-11 13:02:45","activityName":"40节互联网运营课程免费学习！","userName":"joshua","nickName":"joshua","avatar":"http://124.93.196.45/profile/upload/2022/12/13/0b696b69-16b6-4563-97f2-0eebcc6d2e90.jpg"}]
     * code : 200
     * msg : 查询成功
     */

    private int total;
    private int code;
    private String msg;
    private List<RowsDTO> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<RowsDTO> getRows() {
        return rows;
    }

    public void setRows(List<RowsDTO> rows) {
        this.rows = rows;
    }

    public static class RowsDTO {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2022-12-11 13:02:45
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 4098
         * userId : 1114889
         * activityId : 11
         * content : 第一
         * commentTime : 2022-12-11 13:02:45
         * activityName : 40节互联网运营课程免费学习！
         * userName : joshua
         * nickName : joshua
         * avatar : http://124.93.196.45/profile/upload/2022/12/13/0b696b69-16b6-4563-97f2-0eebcc6d2e90.jpg
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private int userId;
        private int activityId;
        private String content;
        private String commentTime;
        private String activityName;
        private String userName;
        private String nickName;
        private String avatar;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public ParamsDTO getParams() {
            return params;
        }

        public void setParams(ParamsDTO params) {
            this.params = params;
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

        public int getActivityId() {
            return activityId;
        }

        public void setActivityId(int activityId) {
            this.activityId = activityId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(String commentTime) {
            this.commentTime = commentTime;
        }

        public String getActivityName() {
            return activityName;
        }

        public void setActivityName(String activityName) {
            this.activityName = activityName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public static class ParamsDTO {
        }
    }
}
