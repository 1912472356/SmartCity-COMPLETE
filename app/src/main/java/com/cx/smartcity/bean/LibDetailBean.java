package com.cx.smartcity.bean;

public class LibDetailBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":23,"name":"北京邮电大学图书馆","address":" 北京市海淀区西土城路10号北京邮电大学内","imgUrl":"/prod-api/profile/upload/image/2022/03/13/7183631e-bdbb-4726-87d0-8adf78b9ceae.jpeg","mapUrl":"/dev-api/profile/upload/image/2022/03/13/11091040-9043-4b2e-84bb-8e7c9a53c15d.png","businessHours":"10:00-22:00","businessState":"1","description":"北京邮电大学具有\u201c信息黄埔\u201d的美誉，而其图书馆馆藏资源丰富，具有鲜明的邮电通信和电子学专业特色，尤其是世界上一些享有盛誉的电信专业书刊收藏较全，在全国堪称第一。"}
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
         * id : 23
         * name : 北京邮电大学图书馆
         * address :  北京市海淀区西土城路10号北京邮电大学内
         * imgUrl : /prod-api/profile/upload/image/2022/03/13/7183631e-bdbb-4726-87d0-8adf78b9ceae.jpeg
         * mapUrl : /dev-api/profile/upload/image/2022/03/13/11091040-9043-4b2e-84bb-8e7c9a53c15d.png
         * businessHours : 10:00-22:00
         * businessState : 1
         * description : 北京邮电大学具有“信息黄埔”的美誉，而其图书馆馆藏资源丰富，具有鲜明的邮电通信和电子学专业特色，尤其是世界上一些享有盛誉的电信专业书刊收藏较全，在全国堪称第一。
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
        private String address;
        private String imgUrl;
        private String mapUrl;
        private String businessHours;
        private String businessState;
        private String description;

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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getMapUrl() {
            return mapUrl;
        }

        public void setMapUrl(String mapUrl) {
            this.mapUrl = mapUrl;
        }

        public String getBusinessHours() {
            return businessHours;
        }

        public void setBusinessHours(String businessHours) {
            this.businessHours = businessHours;
        }

        public String getBusinessState() {
            return businessState;
        }

        public void setBusinessState(String businessState) {
            this.businessState = businessState;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public static class ParamsDTO {
        }
    }
}
