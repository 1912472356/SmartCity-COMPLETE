package com.cx.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class ParkBean implements Serializable {
    /**
     * total : 24
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1,"parkName":"国际大厦停车场","vacancy":"30","priceCaps":"30","imgUrl":"/dev-api/profile/upload/image/2021/04/11/ac978c51-d75a-4797-9845-86a73527c55d.jpg","rates":"5","address":"大连市国际大厦F1楼","distance":"20","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":2,"parkName":"金辉大厦停车场","vacancy":"60","priceCaps":"60","imgUrl":"/profile/p2.jpg","rates":"6","address":"金辉大厦","distance":"15","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":3,"parkName":"广达停车场","vacancy":"30","priceCaps":"30","imgUrl":"/profile/p3.jpg","rates":"5","address":"广达","distance":"20","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":4,"parkName":"天津市邦仓储威物流停车场","vacancy":"60","priceCaps":"60","imgUrl":"/profile/p4.jpg","rates":"6","address":"天津市邦仓储威物流","distance":"15","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":5,"parkName":"蓬莱义利水泥磨粉有限公司停车场","vacancy":"30","priceCaps":"30","imgUrl":"/profile/p5.jpg","rates":"5","address":"蓬莱义利水泥磨粉有限公司","distance":"20","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":6,"parkName":"武鸣县海成停车场","vacancy":"60","priceCaps":"60","imgUrl":"/profile/2020/10/27/h1.jpg","rates":"6","address":"武鸣县海成","distance":"15","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":7,"parkName":"遵化如意停车场","vacancy":"30","priceCaps":"30","imgUrl":"/profile/2020/10/27/h3.jpg","rates":"5","address":"遵化如意","distance":"20","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":8,"parkName":"红运停车场","vacancy":"60","priceCaps":"60","imgUrl":"/profile/2020/10/26/h2.jpg","rates":"6","address":"红运","distance":"15","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"parkName":"晋州市高速口停车场","vacancy":"30","priceCaps":"30","imgUrl":"/profile/p1.jpg","rates":"5","address":"晋州市高速口","distance":"20","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"parkName":"公主岭市光大物流停车场","vacancy":"60","priceCaps":"60","imgUrl":"/profile/p4.jpg","rates":"6","address":"公主岭市光大物流","distance":"15","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"parkName":"上海在顺物流停车场","vacancy":"30","priceCaps":"30","imgUrl":"/profile/p5.jpg","rates":"5","address":"上海在顺物流","distance":"20","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"parkName":"山东潍坊诸城翔鹤家具经营部停车场","vacancy":"60","priceCaps":"60","imgUrl":"/profile/p6.jpg","rates":"6","address":"山东潍坊诸城翔鹤家具经营部","distance":"15","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"parkName":"固丰停车场","vacancy":"30","priceCaps":"30","imgUrl":"/profile/p1.jpg","rates":"5","address":"固丰","distance":"20","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"parkName":"新乡市国宇挂车车辆有限公司停车场","vacancy":"60","priceCaps":"60","imgUrl":"/profile/p2.jpg","rates":"6","address":"新乡市国宇挂车车辆有限公司","distance":"15","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"parkName":"吉城置业人才咨询停车有限公司停车场","vacancy":"30","priceCaps":"30","imgUrl":"/profile/p1.jpg","rates":"5","address":"吉城置业人才咨询停车有限公司","distance":"20","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":16,"parkName":"天津市滨海新区汉沽汇通源储运场停车场","vacancy":"60","priceCaps":"60","imgUrl":"/profile/p4.jpg","rates":"6","address":"天津市滨海新区汉沽汇通源储运场","distance":"15","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":17,"parkName":"大丰停车场","vacancy":"30","priceCaps":"30","imgUrl":"/profile/p3.jpg","rates":"5","address":"大丰","distance":"20","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":18,"parkName":"霍山县开发区货运停车场","vacancy":"60","priceCaps":"60","imgUrl":"/profile/p2.jpg","rates":"6","address":"霍山县开发区货运","distance":"15","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":19,"parkName":"扶沟县崔桥镇南街车场","vacancy":"30","priceCaps":"30","imgUrl":"/profile/p1.jpg","rates":"5","address":"扶沟县崔桥镇南街","distance":"20","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":20,"parkName":"宁波常洪停车场","vacancy":"60","priceCaps":"60","imgUrl":"/profile/p3.jpg","rates":"6","address":"宁波常洪","distance":"15","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":21,"parkName":"深圳市佳维思科技有限公司停车场","vacancy":"30","priceCaps":"30","imgUrl":"/profile/p4.jpg","rates":"5","address":"深圳市佳维思科技有限公司","distance":"20","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":22,"parkName":"沈阳三源色试驾基地停车场","vacancy":"60","priceCaps":"60","imgUrl":"/profile/p5.jpg","rates":"6","address":"沈阳三源色试驾基地","distance":"15","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":23,"parkName":"精诚站停车场","vacancy":"30","priceCaps":"30","imgUrl":"/profile/p6.jpg","rates":"5","address":"精诚站","distance":"20","allPark":"90","open":"Y"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":24,"parkName":"深圳市捷益顺交通设施有限公司停车场","vacancy":"60","priceCaps":"60","imgUrl":"/profile/p4.jpg","rates":"6","address":"深圳市捷益顺交通设施有限公司","distance":"15","allPark":"90","open":"Y"}]
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
         * id : 1
         * parkName : 国际大厦停车场
         * vacancy : 30
         * priceCaps : 30
         * imgUrl : /dev-api/profile/upload/image/2021/04/11/ac978c51-d75a-4797-9845-86a73527c55d.jpg
         * rates : 5
         * address : 大连市国际大厦F1楼
         * distance : 20
         * allPark : 90
         * open : Y
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private String parkName;
        private String vacancy;
        private String priceCaps;
        private String imgUrl;
        private String rates;
        private String address;
        private String distance;
        private String allPark;
        private String open;

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

        public String getParkName() {
            return parkName;
        }

        public void setParkName(String parkName) {
            this.parkName = parkName;
        }

        public String getVacancy() {
            return vacancy;
        }

        public void setVacancy(String vacancy) {
            this.vacancy = vacancy;
        }

        public String getPriceCaps() {
            return priceCaps;
        }

        public void setPriceCaps(String priceCaps) {
            this.priceCaps = priceCaps;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getRates() {
            return rates;
        }

        public void setRates(String rates) {
            this.rates = rates;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getAllPark() {
            return allPark;
        }

        public void setAllPark(String allPark) {
            this.allPark = allPark;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public static class ParamsDTO implements Serializable{
        }
    }
}
