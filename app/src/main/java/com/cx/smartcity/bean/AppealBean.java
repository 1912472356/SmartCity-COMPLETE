package com.cx.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class AppealBean implements Serializable {
    /**
     * total : 3
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2022-12-14 17:15:01","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1093,"userId":1112696,"appealCategoryId":5,"title":"测试诉求 001","content":"诉求内容诉求内容诉求内容诉求内容诉求内容","undertaker":"大连市政府","state":"0","detailResult":"","imgUrl":"/profile/abc.png","appealCategoryName":null},{"searchValue":null,"createBy":null,"createTime":"2022-12-14 18:23:55","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1103,"userId":1112696,"appealCategoryId":15,"title":"123123","content":"123123","undertaker":"123123","state":"0","detailResult":"","imgUrl":"/storage/emulated/0/DCIM/Camera/IMG_20221124_131555.jpg","appealCategoryName":"公共交通问题"},{"searchValue":null,"createBy":null,"createTime":"2022-12-14 18:34:58","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1107,"userId":1112696,"appealCategoryId":14,"title":"123","content":"456465","undertaker":"15132","state":"0","detailResult":"","imgUrl":"/profile/abc.png","appealCategoryName":"疫情问题"}]
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

    public static class RowsDTO implements Serializable,Comparable<RowsDTO>{
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2022-12-14 17:15:01
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 1093
         * userId : 1112696
         * appealCategoryId : 5
         * title : 测试诉求 001
         * content : 诉求内容诉求内容诉求内容诉求内容诉求内容
         * undertaker : 大连市政府
         * state : 0
         * detailResult :
         * imgUrl : /profile/abc.png
         * appealCategoryName : null
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private int userId;
        private int appealCategoryId;
        private String title;
        private String content;
        private String undertaker;
        private String state;
        private String detailResult;
        private String imgUrl;
        private Object appealCategoryName;

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

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getAppealCategoryId() {
            return appealCategoryId;
        }

        public void setAppealCategoryId(int appealCategoryId) {
            this.appealCategoryId = appealCategoryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUndertaker() {
            return undertaker;
        }

        public void setUndertaker(String undertaker) {
            this.undertaker = undertaker;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getDetailResult() {
            return detailResult;
        }

        public void setDetailResult(String detailResult) {
            this.detailResult = detailResult;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public Object getAppealCategoryName() {
            return appealCategoryName;
        }

        public void setAppealCategoryName(Object appealCategoryName) {
            this.appealCategoryName = appealCategoryName;
        }

        @Override
        public int compareTo(RowsDTO rowsDTO) {
            return this.getState().compareTo(rowsDTO.getState());
        }

        public static class ParamsDTO implements Serializable{
        }
    }
}
