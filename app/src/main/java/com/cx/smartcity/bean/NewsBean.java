package com.cx.smartcity.bean;

import java.util.List;

public class NewsBean {
    /**
     * total : 2
     * rows : [{"searchValue":null,"createBy":"1","createTime":"2021-05-06 14:38:26","updateBy":"1","updateTime":"2022-11-30 16:42:20","remark":null,"params":{},"id":8,"appType":"smart_city","cover":"/prod-api/profile/upload/image/2021/05/06/2bfc61d3-5d6e-4157-ba5f-a9dfe23af07f.jpg","title":"六城市成智慧城市基础设施与智能网联汽车协同发展试点","subTitle":null,"content":"<p class=\"ql-align-justify\">据住建部网站消息，近日，住建部、工信部联合发布关于确定智慧城市基础设施与智能网联汽车协同发展第一批试点城市的通知。通知提到，在各城市申报和省级主管部门审核基础上，经组织专家评审和实地调研，确定北京、上海、广州、武汉、长沙、无锡等6个城市为智慧城市基础设施与智能网联汽车协同发展第一批试点城市。<\/p><p class=\"ql-align-justify\"><br><\/p><p class=\"ql-align-justify\">通知指出，请试点城市按照相关要求，制定完善试点工作方案，经专家评审通过后报住房和城乡建设部、工业和信息化部备案。试点城市要建立健全统筹协调机制，落实资金等保障措施，确保试点工作取得成效，形成可复制可推广的经验。有关省级住房和城乡建设、工业和信息化部门要加大对试点城市的指导支持力度。<\/p>","status":"Y","publishDate":"2021-05-06","tags":null,"commentNum":222,"likeNum":1501,"readNum":1232,"type":"22","top":"Y","hot":"Y"},{"searchValue":null,"createBy":"1","createTime":"2021-05-06 16:54:12","updateBy":"1","updateTime":"2022-11-28 15:35:41","remark":null,"params":{},"id":21,"appType":"smart_city","cover":"/prod-api/profile/upload/image/2021/05/06/794615b6-a9ea-44d5-9780-b999daff4185.png","title":"一组数字告诉你 这个\u201c五一\u201d小长假有多火！","subTitle":null,"content":"<p>今年的\u201c五一\u201d小长假似乎格外火爆<\/p><p>\u201c补偿式出游\u201d热度爆棚<\/p><p>各大景区游人如织<\/p><p>消费市场热闹非凡<\/p><p>旅游新趋势不断显现<\/p><p>一组数字告诉你<\/p><p>这个小长假有多火<\/p><p class=\"ql-align-center\"><br><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/5d76d464-0932-40a4-a91a-839bafa7792e.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/06bcd8ac-3567-46e7-925e-94a57819148f.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/319ebde6-f9ce-4ad0-a7c1-2e1c18bcd719.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/29683435-bcba-4564-971a-01134251ccf2.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/4a185845-63ac-4e9a-9858-30a7ed88b437.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/1d8538e8-f175-44a7-83b7-181ae68c7df6.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/6628b0b5-f1ad-49f0-acd7-ab61fe62b563.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/e4f05a81-385e-44eb-ae6f-0e112d93a984.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/3bb9290e-b278-4258-a4fb-50194ef08e64.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/43a51afd-c222-4024-8288-ddf3dfb4352a.png\"><\/p><p class=\"ql-align-center\"><br><\/p><p class=\"ql-align-center\"><br><\/p><p class=\"ql-align-center\"><br><\/p><p class=\"ql-align-center\"><br><\/p><p class=\"ql-align-center\"><br><\/p><p class=\"ql-align-center\"><br><\/p>","status":"Y","publishDate":"2021-05-06","tags":null,"commentNum":33,"likeNum":328,"readNum":2468,"type":"21","top":"N","hot":"Y"}]
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
         * createBy : 1
         * createTime : 2021-05-06 14:38:26
         * updateBy : 1
         * updateTime : 2022-11-30 16:42:20
         * remark : null
         * params : {}
         * id : 8
         * appType : smart_city
         * cover : /prod-api/profile/upload/image/2021/05/06/2bfc61d3-5d6e-4157-ba5f-a9dfe23af07f.jpg
         * title : 六城市成智慧城市基础设施与智能网联汽车协同发展试点
         * subTitle : null
         * content : <p class="ql-align-justify">据住建部网站消息，近日，住建部、工信部联合发布关于确定智慧城市基础设施与智能网联汽车协同发展第一批试点城市的通知。通知提到，在各城市申报和省级主管部门审核基础上，经组织专家评审和实地调研，确定北京、上海、广州、武汉、长沙、无锡等6个城市为智慧城市基础设施与智能网联汽车协同发展第一批试点城市。</p><p class="ql-align-justify"><br></p><p class="ql-align-justify">通知指出，请试点城市按照相关要求，制定完善试点工作方案，经专家评审通过后报住房和城乡建设部、工业和信息化部备案。试点城市要建立健全统筹协调机制，落实资金等保障措施，确保试点工作取得成效，形成可复制可推广的经验。有关省级住房和城乡建设、工业和信息化部门要加大对试点城市的指导支持力度。</p>
         * status : Y
         * publishDate : 2021-05-06
         * tags : null
         * commentNum : 222
         * likeNum : 1501
         * readNum : 1232
         * type : 22
         * top : Y
         * hot : Y
         */

        private Object searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private String appType;
        private String cover;
        private String title;
        private Object subTitle;
        private String content;
        private String status;
        private String publishDate;
        private Object tags;
        private int commentNum;
        private int likeNum;
        private int readNum;
        private String type;
        private String top;
        private String hot;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
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

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(Object subTitle) {
            this.subTitle = subTitle;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public Object getTags() {
            return tags;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public int getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(int likeNum) {
            this.likeNum = likeNum;
        }

        public int getReadNum() {
            return readNum;
        }

        public void setReadNum(int readNum) {
            this.readNum = readNum;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTop() {
            return top;
        }

        public void setTop(String top) {
            this.top = top;
        }

        public String getHot() {
            return hot;
        }

        public void setHot(String hot) {
            this.hot = hot;
        }

        public static class ParamsDTO {
        }
    }
}
