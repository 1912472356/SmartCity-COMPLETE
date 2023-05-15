package com.cx.smartcity.bean;

import java.util.List;

public class AreaFileBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":"2022-03-14 08:30:30","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":18,"areaId":7,"title":"大连市就业重点群体政府补贴技能培训操作流程","author":"大连市人社局","content":""},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 08:30:00","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":17,"areaId":7,"title":"大连市企业职工申请安全技能提升培训补贴操作流程","author":"大连市人社局","content":""},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 08:29:32","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":16,"areaId":7,"title":"关于2021年以工代训具体经办工作的通知","author":"中山区人社局","content":""},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 08:28:30","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"areaId":7,"title":"职业技能竞赛补贴申报流程","author":"中山区人社局","content":""},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 08:27:21","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"areaId":7,"title":"大连市保障政策","author":"中山区人社局","content":""},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 08:26:51","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"areaId":7,"title":"大连市培训政策","author":"中山区人社局","content":""},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 08:26:20","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"areaId":7,"title":"大连市创业政策","author":"中山区人社局","content":""},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 08:25:55","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"areaId":7,"title":"大连市就业政策","author":"中山区人社局","content":""},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 08:25:04","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"areaId":7,"title":"稳就业相关政策落实经办细则","author":"中山区人社局","content":""},{"searchValue":null,"createBy":null,"createTime":"2022-03-14 08:24:34","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"areaId":7,"title":"关于进一步做好稳就业促发展工作的通知","author":"中山区政府","content":""}]
     */

    private String msg;
    private int code;
    private List<DataDTO> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2022-03-14 08:30:30
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 18
         * areaId : 7
         * title : 大连市就业重点群体政府补贴技能培训操作流程
         * author : 大连市人社局
         * content :
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private int areaId;
        private String title;
        private String author;
        private String content;

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

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public static class ParamsDTO {
        }
    }
}
