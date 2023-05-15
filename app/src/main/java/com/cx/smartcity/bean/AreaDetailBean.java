package com.cx.smartcity.bean;

public class AreaDetailBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"name":"大连市高新园区","imgUrl":"/prod-api/profile/upload/image/2022/03/14/6cade496-951a-4a23-b6a6-d250c067ea16.jpeg","introduce":"大连高新技术产业园区（Dalian High-tech Industrial Zone），简称大连高新区，1991年3月经国家批准建立的首批国家级高新技术产业开发区。代管甘井子区凌水街道、七贤岭街道和旅顺口区龙王塘街道。\n大连高新区是国务院1991年3月首批批准的国家级高新技术产业开发区之一，2008年被科技部评为\u201c国家先进高新区\u201d，是大连市高新技术产业基地、自主创新平台、软件和服务外包的核心区，也是大连市的对外开放先导区、科技兴市的示范区。大连高新区是大连市域内8个国家级开发区之一。\n2018年，大连高新区与大连生态科技创新城合并。大连高新区分为七贤岭产业化基地、海外学子创业园、软件园、旅顺南路软件产业带、龙头分园等发展区域。"}
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
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 9
         * name : 大连市高新园区
         * imgUrl : /prod-api/profile/upload/image/2022/03/14/6cade496-951a-4a23-b6a6-d250c067ea16.jpeg
         * introduce : 大连高新技术产业园区（Dalian High-tech Industrial Zone），简称大连高新区，1991年3月经国家批准建立的首批国家级高新技术产业开发区。代管甘井子区凌水街道、七贤岭街道和旅顺口区龙王塘街道。
         大连高新区是国务院1991年3月首批批准的国家级高新技术产业开发区之一，2008年被科技部评为“国家先进高新区”，是大连市高新技术产业基地、自主创新平台、软件和服务外包的核心区，也是大连市的对外开放先导区、科技兴市的示范区。大连高新区是大连市域内8个国家级开发区之一。
         2018年，大连高新区与大连生态科技创新城合并。大连高新区分为七贤岭产业化基地、海外学子创业园、软件园、旅顺南路软件产业带、龙头分园等发展区域。
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
        private String introduce;

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

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public static class ParamsDTO {
        }
    }
}
