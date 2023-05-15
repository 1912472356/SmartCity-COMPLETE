package com.cx.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class IllegalBean implements Serializable {
    /**
     * code : 200
     * msg : 查询成功
     * rows : [{"id":1,"licencePlate":"辽 B123456","disposeState":"已缴款","badTime":"2021-04-20 11:51:17","money":"200","deductMarks":"6","illegalSites":"大连市万达广场","noticeNo":"2021042110040387379","engineNumber":"12345611","trafficOffence":"闯红灯","catType":"大型汽车","performOffice":"交警队","performDate":"2021-04-20","imgUrl":"/dev-api/profile/upload/image/2021/05/01/31fefb9a-a06b-47bd-bf71-8624e89b5044.jpg"}]
     * total : 1
     */

    private int code;
    private String msg;
    private int total;
    private List<RowsDTO> rows;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsDTO> getRows() {
        return rows;
    }

    public void setRows(List<RowsDTO> rows) {
        this.rows = rows;
    }

    public static class RowsDTO implements Serializable{
        /**
         * id : 1
         * licencePlate : 辽 B123456
         * disposeState : 已缴款
         * badTime : 2021-04-20 11:51:17
         * money : 200
         * deductMarks : 6
         * illegalSites : 大连市万达广场
         * noticeNo : 2021042110040387379
         * engineNumber : 12345611
         * trafficOffence : 闯红灯
         * catType : 大型汽车
         * performOffice : 交警队
         * performDate : 2021-04-20
         * imgUrl : /dev-api/profile/upload/image/2021/05/01/31fefb9a-a06b-47bd-bf71-8624e89b5044.jpg
         */

        private int id;
        private String licencePlate;
        private String disposeState;
        private String badTime;
        private String money;
        private String deductMarks;
        private String illegalSites;
        private String noticeNo;
        private String engineNumber;
        private String trafficOffence;
        private String catType;
        private String performOffice;
        private String performDate;
        private String imgUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLicencePlate() {
            return licencePlate;
        }

        public void setLicencePlate(String licencePlate) {
            this.licencePlate = licencePlate;
        }

        public String getDisposeState() {
            return disposeState;
        }

        public void setDisposeState(String disposeState) {
            this.disposeState = disposeState;
        }

        public String getBadTime() {
            return badTime;
        }

        public void setBadTime(String badTime) {
            this.badTime = badTime;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getDeductMarks() {
            return deductMarks;
        }

        public void setDeductMarks(String deductMarks) {
            this.deductMarks = deductMarks;
        }

        public String getIllegalSites() {
            return illegalSites;
        }

        public void setIllegalSites(String illegalSites) {
            this.illegalSites = illegalSites;
        }

        public String getNoticeNo() {
            return noticeNo;
        }

        public void setNoticeNo(String noticeNo) {
            this.noticeNo = noticeNo;
        }

        public String getEngineNumber() {
            return engineNumber;
        }

        public void setEngineNumber(String engineNumber) {
            this.engineNumber = engineNumber;
        }

        public String getTrafficOffence() {
            return trafficOffence;
        }

        public void setTrafficOffence(String trafficOffence) {
            this.trafficOffence = trafficOffence;
        }

        public String getCatType() {
            return catType;
        }

        public void setCatType(String catType) {
            this.catType = catType;
        }

        public String getPerformOffice() {
            return performOffice;
        }

        public void setPerformOffice(String performOffice) {
            this.performOffice = performOffice;
        }

        public String getPerformDate() {
            return performDate;
        }

        public void setPerformDate(String performDate) {
            this.performDate = performDate;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
