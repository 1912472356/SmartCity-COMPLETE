package com.cx.smartcity.bean;

import java.util.List;

public class SubCarBean {
    /**
     * total : 15
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1,"placeName":"丰台区潘北昊盛汽车检测有限公司","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:00","address":"北京市丰台区新发地潘家庙518号院","phone":"010-87504440"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":2,"placeName":"朝阳区公共交通第二机动车检测场","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:01","address":"北京市朝阳区高碑店半壁店南里西区甲10号","phone":"010-87744720"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":3,"placeName":"房山区燕山燕联机动车检测有限公司","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:02","address":"北京市房山区燕山双泉路3号","phone":"010-69341100"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":4,"placeName":"昌平区朝开小关汽车检测有限公司","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:03","address":"北京市昌平区东三旗新亚运村汽车交易市场北门东侧","phone":"010-64915851"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":5,"placeName":"密云区龙涛检测场","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:04","address":"北京市密云县十里堡镇双井村西北京万博诚印刷有限公司院内平房","phone":"010-69097677"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":6,"placeName":"石景山区公共交通第一机动车检测场","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:05","address":"北京市石景山区鲁谷路55号","phone":"010-68665929"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":7,"placeName":"昌平区宏远南口机动车检测场","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:06","address":"北京市昌平南口镇马坊村西2号院","phone":"010-69773415"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":8,"placeName":"昌平区中宇汽车服务中心机动车检测场","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:07","address":"北京市昌平区东小口镇中滩村393号","phone":"010-84811613"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"placeName":"大兴区富多鑫天德机动车检测有限公司","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:08","address":"北京市大兴区黄村镇刘村桥北团桂路26号","phone":"010-61260118"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"placeName":"大兴区天龙大田机动车检测有限公司","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:09","address":"北京市大兴区旧宫镇成寿寺路8号","phone":"010-87605277"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"placeName":"东城区德安汽车修理厂德安利民检测场","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:10","address":"北京市东城区安德里北街25号","phone":"010-51695061"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"placeName":"朝阳区望京北机动车检测场","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:11","address":"北京市朝阳区崔各庄乡善各庄村西","phone":"010-84568919"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"placeName":"平谷机动车检测场","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:12","address":"北京市平谷区大发路8号","phone":"010-69987358"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"placeName":"丰台区国兴汽车服务中心机动车检测场","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:13","address":"北京市丰台区西五里店178号","phone":"010-83667984"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"placeName":"石景山区京西五环检测场","remarks":"周一至周五:上午8:00\u201412:00;下午13:00\u201417:14","address":"北京市石景山区鲁谷路61号","phone":"010-68664799"}]
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
         * id : 1
         * placeName : 丰台区潘北昊盛汽车检测有限公司
         * remarks : 周一至周五:上午8:00—12:00;下午13:00—17:00
         * address : 北京市丰台区新发地潘家庙518号院
         * phone : 010-87504440
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private String placeName;
        private String remarks;
        private String address;
        private String phone;

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

        public String getPlaceName() {
            return placeName;
        }

        public void setPlaceName(String placeName) {
            this.placeName = placeName;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public static class ParamsDTO {
        }
    }
}
