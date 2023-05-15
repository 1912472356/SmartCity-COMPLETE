package com.cx.smartcity.bean;

import java.util.List;

public class RubNewsBean {
    /**
     * total : 5
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2022-03-14 07:54:52","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"type":7,"title":"邢台市首个垃圾分类宣教站启用","imgUrl":"/prod-api/profile/upload/image/2022/03/14/3a1b689e-b2f7-48ee-8e73-80e84e1828fd.jpeg","content":"","author":"李博"},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 07:53:28","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"type":7,"title":"中敖幼儿园2021年垃圾分类系列活动总结","imgUrl":"/prod-api/profile/upload/image/2022/03/14/20236be5-f7ff-4aaf-9749-f366b08a7c01.jpeg","content":"","author":"张洪强"},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 07:52:32","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"type":7,"title":"迎元宵、助冬奥垃圾分类我先行","imgUrl":"/prod-api/profile/upload/image/2022/03/14/8b8f4566-cb91-44e5-a8e6-8ee932716a88.jpeg","content":"","author":"垃圾分类网"},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 07:51:04","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"type":7,"title":"富平县实验小学开展生活垃圾分类培训会","imgUrl":"/prod-api/profile/upload/image/2022/03/14/74ffe3d4-e508-4612-88f9-7e467e5338ba.jpeg","content":"","author":"垃圾分类网"},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 07:50:00","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"type":7,"title":"朝天：弘扬雷锋精神 践行垃圾分类生活新时尚","imgUrl":"/prod-api/profile/upload/image/2022/03/14/0e8cb914-398b-442e-9b48-b6feb9134b44.jpeg","content":"","author":"九派新闻官方帐号"}]
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
         * createTime : 2022-03-14 07:54:52
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 13
         * type : 7
         * title : 邢台市首个垃圾分类宣教站启用
         * imgUrl : /prod-api/profile/upload/image/2022/03/14/3a1b689e-b2f7-48ee-8e73-80e84e1828fd.jpeg
         * content :
         * author : 李博
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private int type;
        private String title;
        private String imgUrl;
        private String content;
        private String author;

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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public static class ParamsDTO {
        }
    }
}
