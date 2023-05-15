package com.cx.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class HouseBean implements Serializable {
    /**
     * total : 4
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1,"sourceName":"泉水B6区泉水小学北站附近多层一室一厅得房率高\n","address":"泉水B6区泉水小学北站附近多层一室一厅得房率高","areaSize":52,"tel":"18546474545","price":"16262/㎡","houseType":"二手","pic":"/prod-api/profile/upload/image/2021/05/17/71ac2d26-4504-412d-81f1-0749f64b42d7.png","description":"房主现在比较着急 房子如果真看好的话 价格可议 手续这边齐全 房子没有抵押 产权证在手 随时配合过户 房主现在已经搬走了 房子现在是空置状态"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":3,"sourceName":"大华实验双学 区长江路 好楼层 单价超低 看房方便","address":"数码路118号","areaSize":100,"tel":"18546474549","price":"21000/㎡","houseType":"二手","pic":"/prod-api/profile/upload/image/2021/05/17/ca7d9a19-143d-4579-9cbe-574bb3be737f.jpg","description":"我去看过这个房子，位置好，不挡光，中间楼层，精装修赠送全部家具家电，拎包即住，看房方便，照片视频等都是实景拍摄，欢迎随时咨询。"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":32,"sourceName":"西安路08年框架电梯房 70年LOFT 一室一厅封闭小区","address":"西安路08年框架电梯房 70年LOFT 一室一厅封闭小区","areaSize":89,"tel":"18546474547","price":"28300/㎡","houseType":"二手","pic":null,"description":null},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":37,"sourceName":"阳光生态城一","address":"数码路118号","areaSize":121,"tel":"18546474543","price":"21000/㎡","houseType":"二手","pic":null,"description":null}]
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
         * sourceName : 泉水B6区泉水小学北站附近多层一室一厅得房率高
         * address : 泉水B6区泉水小学北站附近多层一室一厅得房率高
         * areaSize : 52
         * tel : 18546474545
         * price : 16262/㎡
         * houseType : 二手
         * pic : /prod-api/profile/upload/image/2021/05/17/71ac2d26-4504-412d-81f1-0749f64b42d7.png
         * description : 房主现在比较着急 房子如果真看好的话 价格可议 手续这边齐全 房子没有抵押 产权证在手 随时配合过户 房主现在已经搬走了 房子现在是空置状态
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private String sourceName;
        private String address;
        private int areaSize;
        private String tel;
        private String price;
        private String houseType;
        private String pic;
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

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAreaSize() {
            return areaSize;
        }

        public void setAreaSize(int areaSize) {
            this.areaSize = areaSize;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getHouseType() {
            return houseType;
        }

        public void setHouseType(String houseType) {
            this.houseType = houseType;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public static class ParamsDTO implements Serializable{
        }
    }
}
