package com.cx.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class PetDoctorBean implements Serializable {
    /**
     * total : 1
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"typeId":11,"name":"梁宇宽","avatar":"/prod-api/profile/upload/image/2022/03/14/5b5ba0ac-3adc-4bf8-b1cc-b606981943ec.png","jobName":"主治兽医师","practiceNo":"A012020430057","workingYears":6,"goodAt":"国家执业兽医师，湖南农业大学本科毕业，具备6年的临床诊断经验，擅长犬猫皮肤病，猫内科，仓鼠疾病诊断，兔科疾病诊断，犬猫行为学，从事网络问诊1年多，具有良好的网络问诊能力与沟通经验，帮助宠主解决问题。"}]
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

    public static class RowsDTO implements Serializable{
        /**
         * searchValue : null
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 12
         * typeId : 11
         * name : 梁宇宽
         * avatar : /prod-api/profile/upload/image/2022/03/14/5b5ba0ac-3adc-4bf8-b1cc-b606981943ec.png
         * jobName : 主治兽医师
         * practiceNo : A012020430057
         * workingYears : 6
         * goodAt : 国家执业兽医师，湖南农业大学本科毕业，具备6年的临床诊断经验，擅长犬猫皮肤病，猫内科，仓鼠疾病诊断，兔科疾病诊断，犬猫行为学，从事网络问诊1年多，具有良好的网络问诊能力与沟通经验，帮助宠主解决问题。
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private int typeId;
        private String name;
        private String avatar;
        private String jobName;
        private String practiceNo;
        private int workingYears;
        private String goodAt;

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

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getJobName() {
            return jobName;
        }

        public void setJobName(String jobName) {
            this.jobName = jobName;
        }

        public String getPracticeNo() {
            return practiceNo;
        }

        public void setPracticeNo(String practiceNo) {
            this.practiceNo = practiceNo;
        }

        public int getWorkingYears() {
            return workingYears;
        }

        public void setWorkingYears(int workingYears) {
            this.workingYears = workingYears;
        }

        public String getGoodAt() {
            return goodAt;
        }

        public void setGoodAt(String goodAt) {
            this.goodAt = goodAt;
        }

        public static class ParamsDTO implements Serializable{
        }
    }
}
