package com.cx.smartcity.bean;

import java.util.List;

public class LawTypeBean {
    /**
     * total : 16
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"name":"拆迁安置","sort":1,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/c97db288-c13d-4d62-9027-418b402bbc01.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"name":"债务追讨","sort":2,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/e5499ece-ea2b-4f31-b97c-3309fd2eb5ec.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"name":"医疗纠纷","sort":3,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/3308177d-cba4-4f7c-addf-9abb59f9d688.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"name":"交通事故","sort":4,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/8e4816c6-f859-40bc-b827-290b0efbeeb6.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"name":"合同纠纷","sort":5,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/e0fc5eb0-ec50-4f08-b268-5e4cf9ea6e28.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"name":"劳动纠纷","sort":6,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/792b1950-bf09-42ae-b14a-b8ab76d1878a.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":16,"name":"工伤赔偿","sort":7,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/87bc2209-13f7-4944-b6ba-3c28ea2051dc.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":17,"name":"人身损害","sort":8,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/f1867ba3-44f4-4f02-9c2d-4fcfaace58bd.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":18,"name":"保险理赔","sort":9,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/5f591c5c-729f-472b-942b-80b4cd45e1fb.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":19,"name":"新闻侵权","sort":10,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/a18bae36-d315-4c67-8e11-785f0fb9d441.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":20,"name":"婚姻家庭","sort":11,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/6bc12058-681d-49da-a06a-aa756293652c.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":21,"name":"遗产继承","sort":12,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/343e065d-2406-463a-829c-dc652e926d42.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":22,"name":"旅游纠纷","sort":13,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/f9a599aa-cf67-450d-8764-ccfecad0fbf9.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":23,"name":"农村承包","sort":14,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/69533fe3-0e71-4d2e-9cdd-4ccbc6fe8086.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":24,"name":"消费权益","sort":15,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/dbac7f17-a3d2-4fad-9146-b6982a291a78.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":25,"name":"抵押担保","sort":16,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/c75014a1-6f78-4e1a-8d8f-33518bd80de8.png"}]
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
         * id : 10
         * name : 拆迁安置
         * sort : 1
         * imgUrl : /prod-api/profile/upload/image/2022/03/12/c97db288-c13d-4d62-9027-418b402bbc01.png
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

        public static class ParamsDTO {
        }
    }
}
