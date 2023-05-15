package com.cx.smartcity.bean;

import java.util.List;

public class PetTypeBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"name":"小猫咪","imgUrl":"/prod-api/profile/upload/image/2022/03/14/11e442ce-9d6b-4ae1-9a6d-01d93450d8d5.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"name":"小狗","imgUrl":"/prod-api/profile/upload/image/2022/03/14/cc103d6d-8e82-4720-9eb3-f2d1209a6640.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"name":"鹦鹉","imgUrl":"/prod-api/profile/upload/image/2022/03/14/a3a628f3-baf7-472e-9834-0b038bcd7164.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"name":"金鱼","imgUrl":"/prod-api/profile/upload/image/2022/03/14/0446739d-7b1e-4b76-a024-f2dd4cedde01.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"name":"兔子","imgUrl":"/prod-api/profile/upload/image/2022/03/14/11f345ba-6ca9-4d1f-a3a1-76f17bb42d3d.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"name":"宠物猪","imgUrl":"/prod-api/profile/upload/image/2022/03/14/bb14baef-0bf0-4c19-a96a-39140ae71cd7.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"name":"仓鼠","imgUrl":"/prod-api/profile/upload/image/2022/03/14/71b54f9f-23e4-4613-98cb-ce1dc1bfd36f.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":16,"name":"爬虫类","imgUrl":"/prod-api/profile/upload/image/2022/03/14/d8d0adc8-eb1b-4ce8-a136-3c7e4fab82ef.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":17,"name":"小鸡","imgUrl":"/prod-api/profile/upload/image/2022/03/14/6809e976-f32f-4be3-9c10-db9ffc18941a.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":18,"name":"其他","imgUrl":"/prod-api/profile/upload/image/2022/03/14/25876ced-9adb-4a77-a1e9-100befde3788.png"}]
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
         * id : 9
         * name : 小猫咪
         * imgUrl : /prod-api/profile/upload/image/2022/03/14/11e442ce-9d6b-4ae1-9a6d-01d93450d8d5.png
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
