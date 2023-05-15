package com.cx.smartcity.bean;

public class EventDetailBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":"admin","createTime":"2021-05-08 13:21:05","updateBy":"1112158","updateTime":"2022-12-12 07:58:04","remark":null,"params":{},"id":11,"name":"40节互联网运营课程免费学习！","content":"<p><span style=\"color: rgb(51, 51, 51);\"><img src=\"http://cdn.huodongxing.com/file/ue/20150917/11993DAD922894634F2461ED192158FC20/30984077452099614.jpg\" alt=\"活动行长图.jpg\"><\/span><\/p>","imgUrl":"/prod-api/profile/upload/image/2021/05/08/6536083e-faef-483b-b6f6-6e4e56a43dca.jpg","categoryId":1,"recommend":"N","signupNum":327,"likeNum":232,"status":"1","publishTime":"2021-05-08 13:21:05","categoryName":"商务"}
     */

    private String msg;
    private int code;
    private DataDTO data;

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

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        /**
         * searchValue : null
         * createBy : admin
         * createTime : 2021-05-08 13:21:05
         * updateBy : 1112158
         * updateTime : 2022-12-12 07:58:04
         * remark : null
         * params : {}
         * id : 11
         * name : 40节互联网运营课程免费学习！
         * content : <p><span style="color: rgb(51, 51, 51);"><img src="http://cdn.huodongxing.com/file/ue/20150917/11993DAD922894634F2461ED192158FC20/30984077452099614.jpg" alt="活动行长图.jpg"></span></p>
         * imgUrl : /prod-api/profile/upload/image/2021/05/08/6536083e-faef-483b-b6f6-6e4e56a43dca.jpg
         * categoryId : 1
         * recommend : N
         * signupNum : 327
         * likeNum : 232
         * status : 1
         * publishTime : 2021-05-08 13:21:05
         * categoryName : 商务
         */

        private Object searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private String name;
        private String content;
        private String imgUrl;
        private int categoryId;
        private String recommend;
        private int signupNum;
        private int likeNum;
        private String status;
        private String publishTime;
        private String categoryName;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
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

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getRecommend() {
            return recommend;
        }

        public void setRecommend(String recommend) {
            this.recommend = recommend;
        }

        public int getSignupNum() {
            return signupNum;
        }

        public void setSignupNum(int signupNum) {
            this.signupNum = signupNum;
        }

        public int getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(int likeNum) {
            this.likeNum = likeNum;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public static class ParamsDTO {
        }
    }
}
