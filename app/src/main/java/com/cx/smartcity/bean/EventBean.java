package com.cx.smartcity.bean;

import java.util.List;

public class EventBean{

    /**
     * total : 12
     * rows : [{"searchValue":null,"createBy":"admin","createTime":"2021-05-08 13:24:04","updateBy":"1114887","updateTime":"2022-12-15 16:10:19","remark":null,"params":{},"id":15,"name":"现金流桌游","content":"<p><spac=\"http://cdn.huodongxing.com/file/20191029/1763588454447/654120683912539.jpeg\" alt=\"http://www.huodongxing.com/file/20191029/1763588454447/654120-300 万，目前会员数量超过 3000 万。<\/span><\/p><p>看了这么多私域运营的成功案例，你也想成为这样的成功案例之一吗？想知道他们都是怎么做的吗？来学习企微私域运营、精细化运营管理、私域运营案例拆解，你也可以搭上私域运营火箭！<\/p>","imgUrl":"/prod-api/profile/upload/image/2021/05/08/2be11ad5-c8c9-44a1-aa04-6f13010f1d26.jpg","categoryId":1,"recommend":"Y","signupNum":183,"likeNum":232,"status":"1","publishTime":"2021-05-08 13:10:04","categoryName":"商务"}]
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

    public static class RowsDTO implements Comparable<RowsDTO>{
        /**
         * searchValue : null
         * createBy : admin
         * createTime : 2021-05-08 13:24:04
         * updateBy : 1114887
         * updateTime : 2022-12-15 16:10:19
         * remark : null
         * params : {}
         * id : 15
         * name : 现金流桌游
         * content : <p><span style="color: rgb(51, 51, 51);">活动流程：</span></p><p><br></p><p><span style="color: rgb(51, 51, 51);">1.破冰环节，自我介绍</span></p><p><br></p><p><span style="color: rgb(51, 51, 51);">2.讲解现金流游戏的规则</span></p><p><br></p><p><span style="color: rgb(51, 51, 51);">3.开始游戏</span></p><p><br></p><p><span style="color: rgb(51, 51, 51);">49.jpeg" width="100%">&nbsp;<img src="http://cdn.huodongxing.com/file/20191029/1763588454447/524120684792769.png" alt="http://www.huodongxing.com/file/20191029/1763588454447/524120684792769.png" width="100%">&nbsp;</span></p>
         * imgUrl : /prod-api/profile/upload/image/2021/05/08/9945032d-bf14-4dc6-94eb-817be4c5bef3.jpg
         * categoryId : 1
         * recommend : N
         * signupNum : 1787
         * likeNum : 2556
         * status : 1
         * publishTime : 2021-05-08 13:24:04
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

        @Override
        public int compareTo(RowsDTO rowsDTO) {
            return rowsDTO.getPublishTime().compareTo(this.getPublishTime());
        }

        public static class ParamsDTO {
        }
    }
}
