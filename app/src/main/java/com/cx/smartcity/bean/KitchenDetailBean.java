package com.cx.smartcity.bean;

import java.util.List;

public class KitchenDetailBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"name":"抹茶草莓卷，清新抹茶，甜蜜草莓，香浓奶油","imgUrl":"/prod-api/profile/upload/image/2022/03/14/586df449-f95a-4e6e-b790-c935125947d6.jpg","authorId":9,"ingredients":"鸡蛋4个，植物油55克，牛奶55克，低筋面粉60克，抹茶粉6克，细砂糖65克，柠檬汁","likeCount":7,"collectionCount":8,"myLikeState":false,"myCollectionState":false,"stepList":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":16,"content":"先把植物油55克、牛奶55克，放一起搅拌均匀。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/a05f2298-db9f-4744-8053-b30a02d67173.jpg","sort":1,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":17,"content":"筛入低筋面粉60克、抹茶粉6克，，放一起按Z字型搅拌均匀后备用。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/64202cbe-bec1-426d-9d87-6005c81bc42f.jpg","sort":2,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":18,"content":"鸡蛋4个，把蛋清和蛋黄分离，蛋清放冰箱冷冻10分钟。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/a9c9c806-0ad9-4095-afb8-b7c561cf2b25.jpg","sort":3,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":19,"content":"蛋黄4个加入面糊里。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/35757d8d-8216-4690-99f7-7905f6c43665.jpg","sort":4,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":20,"content":"接着我们做草莓奶油馅，取草莓酱50克，搅拌至没有大颗粒状态。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/18280fb8-ee94-4c3a-be47-7576ec0a016b.jpg","sort":5,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":21,"content":"再加入红丝绒液10滴、淡奶油40克，继续搅拌均匀。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/0a6c782b-e51d-4f56-9877-650612c181c5.jpg","sort":6,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":22,"content":"取出完全放凉的蛋糕胚，在收口处斜45°角切一刀，这样卷起来会比较圆。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/52291ef2-f3dc-4250-a897-5561004f0c52.jpg","sort":7,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":23,"content":"提起油纸，用手帮助着往前推，然后卷起来。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/9f483716-0f59-45e1-85a0-40bea0160cb5.jpg","sort":8,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":24,"content":"草莓酱淡奶油有着酸酸甜甜的滋味，冷藏后有冰激凌般口感，抹茶控们不容错过！","imgUrl":"/prod-api/profile/upload/image/2022/03/14/906ac00c-624b-44c5-8001-2560c10f508b.jpg","sort":9,"dishesId":11}],"author":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"name":"王糖糖","avatar":"/prod-api/profile/upload/image/2022/03/14/ea944b89-d1b0-4374-b54a-cb68b17dbd91.png"}}
     */

    private String msg;
    private int code;
    private DataDTO data;

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

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        /**
         * searchValue : null
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 11
         * name : 抹茶草莓卷，清新抹茶，甜蜜草莓，香浓奶油
         * imgUrl : /prod-api/profile/upload/image/2022/03/14/586df449-f95a-4e6e-b790-c935125947d6.jpg
         * authorId : 9
         * ingredients : 鸡蛋4个，植物油55克，牛奶55克，低筋面粉60克，抹茶粉6克，细砂糖65克，柠檬汁
         * likeCount : 7
         * collectionCount : 8
         * myLikeState : false
         * myCollectionState : false
         * stepList : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":16,"content":"先把植物油55克、牛奶55克，放一起搅拌均匀。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/a05f2298-db9f-4744-8053-b30a02d67173.jpg","sort":1,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":17,"content":"筛入低筋面粉60克、抹茶粉6克，，放一起按Z字型搅拌均匀后备用。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/64202cbe-bec1-426d-9d87-6005c81bc42f.jpg","sort":2,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":18,"content":"鸡蛋4个，把蛋清和蛋黄分离，蛋清放冰箱冷冻10分钟。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/a9c9c806-0ad9-4095-afb8-b7c561cf2b25.jpg","sort":3,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":19,"content":"蛋黄4个加入面糊里。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/35757d8d-8216-4690-99f7-7905f6c43665.jpg","sort":4,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":20,"content":"接着我们做草莓奶油馅，取草莓酱50克，搅拌至没有大颗粒状态。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/18280fb8-ee94-4c3a-be47-7576ec0a016b.jpg","sort":5,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":21,"content":"再加入红丝绒液10滴、淡奶油40克，继续搅拌均匀。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/0a6c782b-e51d-4f56-9877-650612c181c5.jpg","sort":6,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":22,"content":"取出完全放凉的蛋糕胚，在收口处斜45°角切一刀，这样卷起来会比较圆。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/52291ef2-f3dc-4250-a897-5561004f0c52.jpg","sort":7,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":23,"content":"提起油纸，用手帮助着往前推，然后卷起来。","imgUrl":"/prod-api/profile/upload/image/2022/03/14/9f483716-0f59-45e1-85a0-40bea0160cb5.jpg","sort":8,"dishesId":11},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":24,"content":"草莓酱淡奶油有着酸酸甜甜的滋味，冷藏后有冰激凌般口感，抹茶控们不容错过！","imgUrl":"/prod-api/profile/upload/image/2022/03/14/906ac00c-624b-44c5-8001-2560c10f508b.jpg","sort":9,"dishesId":11}]
         * author : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"name":"王糖糖","avatar":"/prod-api/profile/upload/image/2022/03/14/ea944b89-d1b0-4374-b54a-cb68b17dbd91.png"}
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
        private String imgUrl;
        private int authorId;
        private String ingredients;
        private int likeCount;
        private int collectionCount;
        private boolean myLikeState;
        private boolean myCollectionState;
        private AuthorDTO author;
        private List<StepListDTO> stepList;

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

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getAuthorId() {
            return authorId;
        }

        public void setAuthorId(int authorId) {
            this.authorId = authorId;
        }

        public String getIngredients() {
            return ingredients;
        }

        public void setIngredients(String ingredients) {
            this.ingredients = ingredients;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public int getCollectionCount() {
            return collectionCount;
        }

        public void setCollectionCount(int collectionCount) {
            this.collectionCount = collectionCount;
        }

        public boolean isMyLikeState() {
            return myLikeState;
        }

        public void setMyLikeState(boolean myLikeState) {
            this.myLikeState = myLikeState;
        }

        public boolean isMyCollectionState() {
            return myCollectionState;
        }

        public void setMyCollectionState(boolean myCollectionState) {
            this.myCollectionState = myCollectionState;
        }

        public AuthorDTO getAuthor() {
            return author;
        }

        public void setAuthor(AuthorDTO author) {
            this.author = author;
        }

        public List<StepListDTO> getStepList() {
            return stepList;
        }

        public void setStepList(List<StepListDTO> stepList) {
            this.stepList = stepList;
        }

        public static class ParamsDTO {
        }

        public static class AuthorDTO {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * id : 9
             * name : 王糖糖
             * avatar : /prod-api/profile/upload/image/2022/03/14/ea944b89-d1b0-4374-b54a-cb68b17dbd91.png
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
            private String avatar;

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

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public static class ParamsDTO {
            }
        }

        public static class StepListDTO {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * id : 16
             * content : 先把植物油55克、牛奶55克，放一起搅拌均匀。
             * imgUrl : /prod-api/profile/upload/image/2022/03/14/a05f2298-db9f-4744-8053-b30a02d67173.jpg
             * sort : 1
             * dishesId : 11
             */

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsDTO params;
            private int id;
            private String content;
            private String imgUrl;
            private int sort;
            private int dishesId;

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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getDishesId() {
                return dishesId;
            }

            public void setDishesId(int dishesId) {
                this.dishesId = dishesId;
            }

            public static class ParamsDTO {
            }
        }
    }
}
