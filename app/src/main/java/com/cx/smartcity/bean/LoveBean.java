package com.cx.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class LoveBean implements Serializable {
    /**
     * total : 5
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2022-03-14 11:50:53","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/15df470e-f691-4c78-b4cb-3d0b3ea0d49b.jpeg","typeId":15,"name":"橙色计划助听障儿童","author":"腾讯公益","activityAt":"2018-03-13","moneyTotal":14300000,"moneyNow":1020532104,"description":"","isRecommend":"1","detailsList":null,"type":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"name":"残障病人","sort":6,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/fc16a4b5-9520-45fb-be7a-9dd7c2d7d196.png"},"donateCount":352},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 11:54:15","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/8176e63f-5052-4345-a701-cfc2771760f5.jpeg","typeId":11,"name":"帮被拐孩子回家","author":"腾讯公益","activityAt":"2017-03-23","moneyTotal":11300000,"moneyNow":1058485737,"description":"","isRecommend":"1","detailsList":null,"type":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"name":"济困救灾","sort":2,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/a96e593f-e482-40d6-9da2-9a0462f90056.png"},"donateCount":126},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 11:30:27","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/ab556880-9c65-4a52-a2d2-a16dfdab75e1.jpeg","typeId":17,"name":"被拐儿童成长呵护","author":"腾讯公益","activityAt":"2017-03-22","moneyTotal":12000000,"moneyNow":3215323,"description":"","isRecommend":"1","detailsList":null,"type":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":17,"name":"其他","sort":8,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/7c53f458-c34a-4535-a28a-fb60e0afb525.png"},"donateCount":92},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 11:32:30","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/70b837d0-0c5e-492d-9365-9fa4bf82489a.jpeg","typeId":11,"name":"关爱深圳困难社工","author":"腾讯公益","activityAt":"2016-03-22","moneyTotal":300000,"moneyNow":1037185840,"description":"","isRecommend":"1","detailsList":null,"type":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"name":"济困救灾","sort":2,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/a96e593f-e482-40d6-9da2-9a0462f90056.png"},"donateCount":78},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 11:25:30","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/0a927ca2-142c-4b3b-8779-38965931213a.png","typeId":10,"name":"壹基金海洋天堂计划","author":"腾讯公益","activityAt":"2016-03-14","moneyTotal":13900000,"moneyNow":22222,"description":"","isRecommend":"1","detailsList":null,"type":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"name":"疾病救助","sort":1,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/380a9465-d483-4a73-9f14-892db2e13b7a.png"},"donateCount":120}]
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
         * createTime : 2022-03-14 11:50:53
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 14
         * imgUrl : /prod-api/profile/upload/image/2022/03/14/15df470e-f691-4c78-b4cb-3d0b3ea0d49b.jpeg
         * typeId : 15
         * name : 橙色计划助听障儿童
         * author : 腾讯公益
         * activityAt : 2018-03-13
         * moneyTotal : 14300000
         * moneyNow : 1020532104
         * description :
         * isRecommend : 1
         * detailsList : null
         * type : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"name":"残障病人","sort":6,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/fc16a4b5-9520-45fb-be7a-9dd7c2d7d196.png"}
         * donateCount : 352
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private String imgUrl;
        private int typeId;
        private String name;
        private String author;
        private String activityAt;
        private int moneyTotal;
        private int moneyNow;
        private String description;
        private String isRecommend;
        private Object detailsList;
        private TypeDTO type;
        private int donateCount;

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

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
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

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getActivityAt() {
            return activityAt;
        }

        public void setActivityAt(String activityAt) {
            this.activityAt = activityAt;
        }

        public int getMoneyTotal() {
            return moneyTotal;
        }

        public void setMoneyTotal(int moneyTotal) {
            this.moneyTotal = moneyTotal;
        }

        public int getMoneyNow() {
            return moneyNow;
        }

        public void setMoneyNow(int moneyNow) {
            this.moneyNow = moneyNow;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(String isRecommend) {
            this.isRecommend = isRecommend;
        }

        public Object getDetailsList() {
            return detailsList;
        }

        public void setDetailsList(Object detailsList) {
            this.detailsList = detailsList;
        }

        public TypeDTO getType() {
            return type;
        }

        public void setType(TypeDTO type) {
            this.type = type;
        }

        public int getDonateCount() {
            return donateCount;
        }

        public void setDonateCount(int donateCount) {
            this.donateCount = donateCount;
        }

        public static class ParamsDTO implements Serializable{
        }

        public static class TypeDTO implements Serializable{
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * id : 15
             * name : 残障病人
             * sort : 6
             * imgUrl : /prod-api/profile/upload/image/2022/03/14/fc16a4b5-9520-45fb-be7a-9dd7c2d7d196.png
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
            private int sort;
            private String imgUrl;

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

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public static class ParamsDTO implements Serializable{
            }
        }
    }
}
