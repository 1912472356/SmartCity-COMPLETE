package com.cx.smartcity.bean;

import java.util.List;

public class BusOrderBean {
    /**
     * total : 3
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2022-11-20 15:01:37","updateBy":null,"updateTime":"2022-11-20 21:46:14","remark":null,"params":{},"id":1297,"orderNum":"92769688","path":"一号线","start":"光谷金融街","end":"解放路","price":8,"userName":"dream","userTel":"15180015807","userId":1112696,"status":1,"paymentType":"电子支付","payTime":"2022-11-20 21:46:14"},{"searchValue":null,"createBy":null,"createTime":"2022-11-20 15:41:19","updateBy":null,"updateTime":"2022-12-14 22:03:53","remark":null,"params":{},"id":1299,"orderNum":"93007938","path":"一号线","start":"光谷金融街","end":"解放路","price":8,"userName":"dream","userTel":"15180015807","userId":1112696,"status":1,"paymentType":"电子支付","payTime":"2022-12-14 22:03:53"},{"searchValue":null,"createBy":null,"createTime":"2022-11-20 15:42:37","updateBy":null,"updateTime":"2022-11-20 15:43:14","remark":null,"params":{},"id":1300,"orderNum":"93015735","path":"二号线","start":"光谷金融街","end":"西安路","price":8,"userName":"dream","userTel":"15180015807","userId":1112696,"status":1,"paymentType":"电子支付","payTime":"2022-11-20 15:43:14"}]
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
         * createTime : 2022-11-20 15:01:37
         * updateBy : null
         * updateTime : 2022-11-20 21:46:14
         * remark : null
         * params : {}
         * id : 1297
         * orderNum : 92769688
         * path : 一号线
         * start : 光谷金融街
         * end : 解放路
         * price : 8.0
         * userName : dream
         * userTel : 15180015807
         * userId : 1112696
         * status : 1
         * paymentType : 电子支付
         * payTime : 2022-11-20 21:46:14
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private String updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private String orderNum;
        private String path;
        private String start;
        private String end;
        private double price;
        private String userName;
        private String userTel;
        private int userId;
        private int status;
        private String paymentType;
        private String payTime;

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

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
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

        public String getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(String orderNum) {
            this.orderNum = orderNum;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserTel() {
            return userTel;
        }

        public void setUserTel(String userTel) {
            this.userTel = userTel;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getPaymentType() {
            return paymentType;
        }

        public void setPaymentType(String paymentType) {
            this.paymentType = paymentType;
        }

        public String getPayTime() {
            return payTime;
        }

        public void setPayTime(String payTime) {
            this.payTime = payTime;
        }

        public static class ParamsDTO {
        }
    }
}
