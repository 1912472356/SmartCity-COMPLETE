package com.cx.smartcity.bean;

import java.util.List;

public class LoveBannerBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":8,"title":"共同战疫，一起加油","sort":1,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/aa55c97a-201f-4c3c-8434-cae5f5e50f00.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"title":"关注温暖，幸福每个家","sort":2,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/7c5da30c-bfc0-43a3-af34-8dcb1db55a32.jpeg"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"title":"冬日送温暖，献爱心活动","sort":3,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/bc456d48-c162-4887-9a01-5ed296ef7f8f.jpeg"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"title":"树木是地球的灵魂，共同植树是我们的责任","sort":4,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/0f55551f-f299-4fb2-b79d-b58002e97fe0.jpeg"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"title":"莘莘学子，国家未来","sort":5,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/63068fbb-d1d7-4a54-9d6d-7d6b37a59af4.jpeg"}]
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
         * id : 8
         * title : 共同战疫，一起加油
         * sort : 1
         * imgUrl : /prod-api/profile/upload/image/2022/03/14/aa55c97a-201f-4c3c-8434-cae5f5e50f00.png
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
