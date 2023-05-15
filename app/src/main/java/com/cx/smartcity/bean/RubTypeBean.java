package com.cx.smartcity.bean;

import java.util.List;

public class RubTypeBean {
    /**
     * total : 4
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":8,"name":"可回收垃圾","sort":1,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/e211e261-3653-4247-a82a-59558b2fda8b.jpeg","introduce":"可回收物是指废纸张、废塑料、废玻璃制品、废金属、废织物等适宜回收、可循环利用的生活废弃物。","guide":"投放可回收物时，应尽量保持清洁干燥。避免污染。立体包装应清空内容物。清洁后压扁投放。已破损，或有裹尖锐边角的，应包装后投放。"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"name":"有害垃圾","sort":2,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/4b7e31cc-f3a5-4277-a730-4512e3b44dd5.jpeg","introduce":"有害垃圾，就是不可回收，对环境有害的生活垃圾。","guide":"分类投放有害垃圾时应注意轻放。已破碎的，及废弃药品，应连带包装或包裹后投放。压力罐装容器应排空内容物后投放。"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"name":"厨余垃圾","sort":3,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/1c665f8b-8119-4047-9149-0f48addf710c.png","introduce":"上海称湿垃圾）包括剩菜剩饭、骨头、菜根菜叶、果皮等食品类废物。经生物技术就地处理堆肥，每吨可生产0.6~0.7吨有机肥料。","guide":"该类型垃圾自产生时候就与其他品种垃圾分离、分开收集。投放前应尽量沥干水分。有外包装的应去除外包装投放。"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"name":"其他垃圾","sort":4,"imgUrl":"/prod-api/profile/upload/image/2022/03/14/f8f95347-2f6f-49f5-afd8-1369904264a5.png","introduce":"其他垃圾，是指除了上述三类可回收物、有害垃圾和厨余垃圾以外的其他生活垃圾。","guide":"应投入干垃圾收集容器，并保持周边环境整洁。"}]
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
         * id : 8
         * name : 可回收垃圾
         * sort : 1
         * imgUrl : /prod-api/profile/upload/image/2022/03/14/e211e261-3653-4247-a82a-59558b2fda8b.jpeg
         * introduce : 可回收物是指废纸张、废塑料、废玻璃制品、废金属、废织物等适宜回收、可循环利用的生活废弃物。
         * guide : 投放可回收物时，应尽量保持清洁干燥。避免污染。立体包装应清空内容物。清洁后压扁投放。已破损，或有裹尖锐边角的，应包装后投放。
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
        private String introduce;
        private String guide;

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

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getGuide() {
            return guide;
        }

        public void setGuide(String guide) {
            this.guide = guide;
        }

        public static class ParamsDTO {
        }
    }
}
