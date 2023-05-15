package com.cx.smartcity.bean;

import java.util.List;

public class CallPayRecordBean {
    /**
     * total : 4
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":76,"title":"话费充值","phonenumber":"13800000000","rechargeAmount":200,"paymentAmount":200,"paymentType":"电子支付","rechargeTime":"2022-11-13 21:45:11","userId":1112696},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":75,"title":"话费充值","phonenumber":"13800000000","rechargeAmount":50,"paymentAmount":50,"paymentType":"电子支付","rechargeTime":"2022-11-13 21:45:00","userId":1112696},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":65,"title":"话费充值","phonenumber":"13800000000","rechargeAmount":50,"paymentAmount":50,"paymentType":"电子支付","rechargeTime":"2022-11-13 11:21:27","userId":1112696},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":64,"title":"话费充值","phonenumber":"13800000000","rechargeAmount":50,"paymentAmount":49,"paymentType":"电子支付","rechargeTime":"2022-11-13 11:04:32","userId":1112696}]
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
         * id : 76
         * title : 话费充值
         * phonenumber : 13800000000
         * rechargeAmount : 200.0
         * paymentAmount : 200.0
         * paymentType : 电子支付
         * rechargeTime : 2022-11-13 21:45:11
         * userId : 1112696
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
        private String phonenumber;
        private double rechargeAmount;
        private double paymentAmount;
        private String paymentType;
        private String rechargeTime;
        private int userId;

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

        public String getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public double getRechargeAmount() {
            return rechargeAmount;
        }

        public void setRechargeAmount(double rechargeAmount) {
            this.rechargeAmount = rechargeAmount;
        }

        public double getPaymentAmount() {
            return paymentAmount;
        }

        public void setPaymentAmount(double paymentAmount) {
            this.paymentAmount = paymentAmount;
        }

        public String getPaymentType() {
            return paymentType;
        }

        public void setPaymentType(String paymentType) {
            this.paymentType = paymentType;
        }

        public String getRechargeTime() {
            return rechargeTime;
        }

        public void setRechargeTime(String rechargeTime) {
            this.rechargeTime = rechargeTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public static class ParamsDTO {
        }
    }
}
