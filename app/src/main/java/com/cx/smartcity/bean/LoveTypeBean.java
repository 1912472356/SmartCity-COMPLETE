package com.cx.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class LoveTypeBean implements Serializable {
    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"name":"疾病救助","sort":1,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/380a9465-d483-4a73-9f14-892db2e13b7a.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"name":"济困救灾","sort":2,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/a96e593f-e482-40d6-9da2-9a0462f90056.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"name":"教育助学","sort":3,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/d1c229a7-7a62-4462-888e-0dc9fdbafde7.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"name":"自然保护","sort":4,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/c30b1103-fc68-4f96-aa3b-8a133f28516b.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"name":"关爱留守儿童","sort":5,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/3146861b-4c85-4c29-98b1-9f8e39dd8bff.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"name":"残障病人","sort":6,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/fc16a4b5-9520-45fb-be7a-9dd7c2d7d196.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":16,"name":"夕阳老人","sort":7,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/712ae235-ff2c-4e9a-b953-69e2451ed89f.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":17,"name":"其他","sort":8,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/7c53f458-c34a-4535-a28a-fb60e0afb525.png"}]
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

    public static class DataDTO implements Serializable{
        /**
         * searchValue : null
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 10
         * name : 疾病救助
         * sort : 1
         * imgUrl : /prod-api/profile/upload/image/2022/03/14/380a9465-d483-4a73-9f14-892db2e13b7a.png
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private String name;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public static class ParamsDTO implements Serializable{
        }
    }
}
