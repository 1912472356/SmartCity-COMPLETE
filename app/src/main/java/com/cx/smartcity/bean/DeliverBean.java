package com.cx.smartcity.bean;

import java.util.List;

public class DeliverBean {
    /**
     * total : 9
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"userId":1,"postId":null,"companyId":11,"postName":"寝室长","companyName":"有家舒舍","money":"5000","satrTime":"2021-05-05","userName":"admin"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":503,"userId":1111882,"postId":11,"companyId":11,"postName":"寝室长","companyName":"有家舒舍","money":"700","satrTime":"2022-11-01","userName":"lalisa"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":537,"userId":1112699,"postId":0,"companyId":11,"postName":"寝室长","companyName":"有家舒舍","money":"面议","satrTime":"2022-11-04","userName":"qinali"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":559,"userId":1112699,"postId":0,"companyId":11,"postName":"寝室长","companyName":"有家舒舍","money":"面议","satrTime":"2022-11-06","userName":"qinali"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1030,"userId":1113108,"postId":11,"companyId":11,"postName":null,"companyName":"有家舒舍","money":"面议","satrTime":"2022-11-23","userName":"DDDD"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1078,"userId":1113136,"postId":11,"companyId":11,"postName":"寝室长","companyName":"有家舒舍","money":"面议","satrTime":"2022-11-25","userName":"zld"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1242,"userId":1111132,"postId":11,"companyId":11,"postName":"寝室长","companyName":"有家舒舍","money":"123","satrTime":"2022-12-03","userName":"123"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1253,"userId":1113358,"postId":11,"companyId":11,"postName":"快递员","companyName":"有家舒舍","money":null,"satrTime":"2022-12-03","userName":"黄nq"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1279,"userId":1113523,"postId":11,"companyId":11,"postName":"寝室长","companyName":"有家舒舍","money":null,"satrTime":"2022-12-05","userName":"xwd666"}]
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
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 13
         * userId : 1
         * postId : null
         * companyId : 11
         * postName : 寝室长
         * companyName : 有家舒舍
         * money : 5000
         * satrTime : 2021-05-05
         * userName : admin
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
        private Object postId;
        private int companyId;
        private String postName;
        private String companyName;
        private String money;
        private String satrTime;
        private String userName;

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

        public Object getPostId() {
            return postId;
        }

        public void setPostId(Object postId) {
            this.postId = postId;
        }

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public String getPostName() {
            return postName;
        }

        public void setPostName(String postName) {
            this.postName = postName;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getSatrTime() {
            return satrTime;
        }

        public void setSatrTime(String satrTime) {
            this.satrTime = satrTime;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public static class ParamsDTO {
        }
    }
}
