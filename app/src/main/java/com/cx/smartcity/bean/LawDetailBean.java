package com.cx.smartcity.bean;

public class LawDetailBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"name":"龙成律师","legalExpertiseId":10,"avatarUrl":"/prod-api/profile/upload/2022/03/12/7a5a7304-afb3-4f1b-ab28-be91ae355101.jpeg","baseInfo":"办案13年。处理各类案件上千件，能办好案才是真的好。电话（微信）：18200100787","eduInfo":"龙成律师，曾在四川省人民政府机关事务管理局工作近五年，中华全国律师协会会员、四川省律师协会员，四川法奥律师事务所高级合伙人，熟悉各级政府及相关部门包括公安机关及法院和检察院的办事流程，具备办大案、要案一般律师不具备的独特的优势。","licenseNo":"15101200810544893","certificateImgUrl":"/dev-api/profile/upload/2022/03/12/133da140-6f57-4db3-8390-8dd4fa3ce621.jpeg","workStartAt":"2020-11-01","serviceTimes":49,"favorableRate":100,"legalExpertiseName":"拆迁安置","favorableCount":0,"sort":"favorableRate"}
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
         * id : 11
         * name : 龙成律师
         * legalExpertiseId : 10
         * avatarUrl : /prod-api/profile/upload/2022/03/12/7a5a7304-afb3-4f1b-ab28-be91ae355101.jpeg
         * baseInfo : 办案13年。处理各类案件上千件，能办好案才是真的好。电话（微信）：18200100787
         * eduInfo : 龙成律师，曾在四川省人民政府机关事务管理局工作近五年，中华全国律师协会会员、四川省律师协会员，四川法奥律师事务所高级合伙人，熟悉各级政府及相关部门包括公安机关及法院和检察院的办事流程，具备办大案、要案一般律师不具备的独特的优势。
         * licenseNo : 15101200810544893
         * certificateImgUrl : /dev-api/profile/upload/2022/03/12/133da140-6f57-4db3-8390-8dd4fa3ce621.jpeg
         * workStartAt : 2020-11-01
         * serviceTimes : 49
         * favorableRate : 100
         * legalExpertiseName : 拆迁安置
         * favorableCount : 0
         * sort : favorableRate
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
        private int legalExpertiseId;
        private String avatarUrl;
        private String baseInfo;
        private String eduInfo;
        private String licenseNo;
        private String certificateImgUrl;
        private String workStartAt;
        private int serviceTimes;
        private int favorableRate;
        private String legalExpertiseName;
        private int favorableCount;
        private String sort;

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

        public int getLegalExpertiseId() {
            return legalExpertiseId;
        }

        public void setLegalExpertiseId(int legalExpertiseId) {
            this.legalExpertiseId = legalExpertiseId;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getBaseInfo() {
            return baseInfo;
        }

        public void setBaseInfo(String baseInfo) {
            this.baseInfo = baseInfo;
        }

        public String getEduInfo() {
            return eduInfo;
        }

        public void setEduInfo(String eduInfo) {
            this.eduInfo = eduInfo;
        }

        public String getLicenseNo() {
            return licenseNo;
        }

        public void setLicenseNo(String licenseNo) {
            this.licenseNo = licenseNo;
        }

        public String getCertificateImgUrl() {
            return certificateImgUrl;
        }

        public void setCertificateImgUrl(String certificateImgUrl) {
            this.certificateImgUrl = certificateImgUrl;
        }

        public String getWorkStartAt() {
            return workStartAt;
        }

        public void setWorkStartAt(String workStartAt) {
            this.workStartAt = workStartAt;
        }

        public int getServiceTimes() {
            return serviceTimes;
        }

        public void setServiceTimes(int serviceTimes) {
            this.serviceTimes = serviceTimes;
        }

        public int getFavorableRate() {
            return favorableRate;
        }

        public void setFavorableRate(int favorableRate) {
            this.favorableRate = favorableRate;
        }

        public String getLegalExpertiseName() {
            return legalExpertiseName;
        }

        public void setLegalExpertiseName(String legalExpertiseName) {
            this.legalExpertiseName = legalExpertiseName;
        }

        public int getFavorableCount() {
            return favorableCount;
        }

        public void setFavorableCount(int favorableCount) {
            this.favorableCount = favorableCount;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public static class ParamsDTO {
        }
    }
}
