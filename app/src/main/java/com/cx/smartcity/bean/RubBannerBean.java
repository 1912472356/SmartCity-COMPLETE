package com.cx.smartcity.bean;

import java.util.List;

public class RubBannerBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":6,"title":"配合垃圾分类 争做文明学生","sort":1,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/9c200a47-aaf3-4382-952a-887229ff0f68.jpeg"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":7,"title":"智能垃圾分类箱，未来垃圾分类之趋势","sort":2,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/d06f53fa-dc9a-4c0c-9857-5507d8f3f620.jpeg"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":8,"title":"倡导垃圾分类 守护美好环境","sort":3,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/3d94145e-45c5-4bd7-82bd-9593316f6447.jpeg"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"title":"垃圾分类我最棒","sort":4,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/e98997e2-56b6-40bf-8042-bb40af7b6bcb.jpeg"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"title":"分类齐用心，垃圾变成金","sort":5,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/c2cf9a79-c999-4863-b6ed-2c5c7943b057.jpeg"}]
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

    public static class DataDTO {
        /**
         * searchValue : null
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 6
         * title : 配合垃圾分类 争做文明学生
         * sort : 1
         * imgUrl : /prod-api/profile/upload/image/2022/03/14/9c200a47-aaf3-4382-952a-887229ff0f68.jpeg
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private String title;
        private int sort;
        private String imgUrl;

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

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public static class ParamsDTO {
        }
    }
}
