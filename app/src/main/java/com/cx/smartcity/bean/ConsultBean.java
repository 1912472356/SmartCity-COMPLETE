package com.cx.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class ConsultBean implements Serializable {
    /**
     * total : 2
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2022-11-10 16:19:32","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":137,"fromUserId":1112696,"lawyerId":10,"legalExpertiseId":7,"content":"要把沙发装冰箱，总共分几步？","imageUrls":"/prod-api/profile/upload/image/2022/02/25/19d10a51-2950-46b0-ad70-daf7c5160320.jpg","phone":"18842656666","state":"0","score":0,"evaluate":null,"lawyerName":"陈宇律师","legalExpertiseName":null,"likeCount":249},{"searchValue":null,"createBy":null,"createTime":"2022-11-11 19:14:20","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":162,"fromUserId":1112696,"lawyerId":10,"legalExpertiseId":16,"content":"人工费当地人员工作人员工作人员工作人员工作人员工程部分享有人员以后方法律师事务所有点儿子宫心计算器材质疑惑身上是否广告位置于是乎人工费当地人员工作人员工作人员工作人员工作人员工程部分享有人员以后方法律师事务所有人工费当地人员工作人员工作人员工作人员工作人员工子宫心计算器材质疑惑身上是否广告位置于是乎","imageUrls":"/storage/emulated/0/DCIM/Camera/IMG_20221108_145059.jpg","phone":"553332215511","state":"0","score":0,"evaluate":null,"lawyerName":"陈宇律师","legalExpertiseName":"工伤赔偿","likeCount":249}]
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
         * createTime : 2022-11-10 16:19:32
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 137
         * fromUserId : 1112696
         * lawyerId : 10
         * legalExpertiseId : 7
         * content : 要把沙发装冰箱，总共分几步？
         * imageUrls : /prod-api/profile/upload/image/2022/02/25/19d10a51-2950-46b0-ad70-daf7c5160320.jpg
         * phone : 18842656666
         * state : 0
         * score : 0
         * evaluate : null
         * lawyerName : 陈宇律师
         * legalExpertiseName : null
         * likeCount : 249
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private int fromUserId;
        private int lawyerId;
        private int legalExpertiseId;
        private String content;
        private String imageUrls;
        private String phone;
        private String state;
        private int score;
        private Object evaluate;
        private String lawyerName;
        private Object legalExpertiseName;
        private int likeCount;

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

        public int getFromUserId() {
            return fromUserId;
        }

        public void setFromUserId(int fromUserId) {
            this.fromUserId = fromUserId;
        }

        public int getLawyerId() {
            return lawyerId;
        }

        public void setLawyerId(int lawyerId) {
            this.lawyerId = lawyerId;
        }

        public int getLegalExpertiseId() {
            return legalExpertiseId;
        }

        public void setLegalExpertiseId(int legalExpertiseId) {
            this.legalExpertiseId = legalExpertiseId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImageUrls() {
            return imageUrls;
        }

        public void setImageUrls(String imageUrls) {
            this.imageUrls = imageUrls;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public Object getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(Object evaluate) {
            this.evaluate = evaluate;
        }

        public String getLawyerName() {
            return lawyerName;
        }

        public void setLawyerName(String lawyerName) {
            this.lawyerName = lawyerName;
        }

        public Object getLegalExpertiseName() {
            return legalExpertiseName;
        }

        public void setLegalExpertiseName(Object legalExpertiseName) {
            this.legalExpertiseName = legalExpertiseName;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public static class ParamsDTO implements Serializable{
        }
    }
}
