package com.cx.smartcity.bean;

public class WorkProfileBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":113,"userId":1112696,"mostEducation":"博士","education":"本科","address":"北京","experience":"2 年","individualResume":"性格有点内向、乐观上进、有爱心并善于施教并行;对待工作认真负责，善于沟通、协调有较强的组织能力与团队精神;上进心强、勤于学习能不断进步自身的能力与综合素质。在未来的工作中，我将以充沛的精力，刻苦钻研的精神来努力工作，稳定地进步自己的工作能力，与公司同步发展。","money":"7000","positionId":1,"files":"/dev-api/profile/upload/2021/04/22/1ac5e66a-0381-4867-9026-3ec00fff3ecf.pdf","positionName":null,"userName":null}
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
         * id : 113
         * userId : 1112696
         * mostEducation : 博士
         * education : 本科
         * address : 北京
         * experience : 2 年
         * individualResume : 性格有点内向、乐观上进、有爱心并善于施教并行;对待工作认真负责，善于沟通、协调有较强的组织能力与团队精神;上进心强、勤于学习能不断进步自身的能力与综合素质。在未来的工作中，我将以充沛的精力，刻苦钻研的精神来努力工作，稳定地进步自己的工作能力，与公司同步发展。
         * money : 7000
         * positionId : 1
         * files : /dev-api/profile/upload/2021/04/22/1ac5e66a-0381-4867-9026-3ec00fff3ecf.pdf
         * positionName : null
         * userName : null
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private int userId;
        private String mostEducation;
        private String education;
        private String address;
        private String experience;
        private String individualResume;
        private String money;
        private int positionId;
        private String files;
        private Object positionName;
        private Object userName;

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

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getMostEducation() {
            return mostEducation;
        }

        public void setMostEducation(String mostEducation) {
            this.mostEducation = mostEducation;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getExperience() {
            return experience;
        }

        public void setExperience(String experience) {
            this.experience = experience;
        }

        public String getIndividualResume() {
            return individualResume;
        }

        public void setIndividualResume(String individualResume) {
            this.individualResume = individualResume;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public int getPositionId() {
            return positionId;
        }

        public void setPositionId(int positionId) {
            this.positionId = positionId;
        }

        public String getFiles() {
            return files;
        }

        public void setFiles(String files) {
            this.files = files;
        }

        public Object getPositionName() {
            return positionName;
        }

        public void setPositionName(Object positionName) {
            this.positionName = positionName;
        }

        public Object getUserName() {
            return userName;
        }

        public void setUserName(Object userName) {
            this.userName = userName;
        }

        public static class ParamsDTO {
        }
    }
}
