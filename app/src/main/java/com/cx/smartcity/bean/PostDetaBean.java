package com.cx.smartcity.bean;

import java.util.List;

public class PostDetaBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"name":"大连开发区金马路驿站","coverImgUrl":"/prod-api/profile/upload/image/2022/03/14/31f7b6bf-3e68-4736-930b-1e60dac2b0ac.jpg","imageUrls":"/prod-api/profile/upload/image/2022/03/14/e0b34775-e8b9-47d6-8ab9-bd97d43e9da0.jpg,/prod-api/profile/upload/image/2022/03/14/ac55b604-1836-4fb4-be3d-f1e3c1fcbe92.jpg,/prod-api/profile/upload/image/2022/03/14/e8c86da3-9c1c-4315-94db-0b29ada6c2fe.jpg,/prod-api/profile/upload/image/2022/03/14/72302733-aafb-485a-ac84-0328f4ad6fbd.jpg,/prod-api/profile/upload/image/2022/03/14/e5db8e07-2755-421c-86aa-946c4b3e678b.jpg,/prod-api/profile/upload/image/2022/03/14/68920148-7719-4534-9016-ba8800b0d172.jpg,/prod-api/profile/upload/image/2022/03/14/94944793-8a07-4f3f-af06-8303f6a7e625.jpg","bedsCountBoy":68,"bedsCountGirl":23,"address":"大连金州区恒安里-2号楼 , 大连","phone":"021-80187829-2818146","workTime":"8:00-22:00","introduce":"你好，房屋位于开发区核心地带房屋配有空调，WiFi，电视，洗衣机，淋浴，厨房全套设备，干净整洁，温馨舒适。周边距离轻轨站万达广场不到两公里的距离。诚挚欢迎您的入住找到家一样的感觉。房间卫生都是一可以扫，保证干净整洁。在大连，如此公寓，还真是不多见。关键是我们的价格要低于其他的很多很多。24小时热水+独立卫生间+独立厨房+免费上网宽带！公寓位于开发区丽娇湾滨海旅游路中段，毗邻铜牛岭,体育公园，白石湾浴场。周边银行超市齐 全。距离大型商业中心一公里多，闹市中的海上世外桃源也。","internalFacilities":"暖气 小冰箱 洗衣机 电热水壶 免费有线上网 拖鞋 吹风机 免费wifi 全套厨房 独立卫浴 淋浴房 电视","surroundingFacilities":"林海滑雪场，AC超市","specialService":"自动取款机 电梯","imageUrlList":["/prod-api/profile/upload/image/2022/03/14/e0b34775-e8b9-47d6-8ab9-bd97d43e9da0.jpg","/prod-api/profile/upload/image/2022/03/14/ac55b604-1836-4fb4-be3d-f1e3c1fcbe92.jpg","/prod-api/profile/upload/image/2022/03/14/e8c86da3-9c1c-4315-94db-0b29ada6c2fe.jpg","/prod-api/profile/upload/image/2022/03/14/72302733-aafb-485a-ac84-0328f4ad6fbd.jpg","/prod-api/profile/upload/image/2022/03/14/e5db8e07-2755-421c-86aa-946c4b3e678b.jpg","/prod-api/profile/upload/image/2022/03/14/68920148-7719-4534-9016-ba8800b0d172.jpg","/prod-api/profile/upload/image/2022/03/14/94944793-8a07-4f3f-af06-8303f6a7e625.jpg"]}
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
         * name : 大连开发区金马路驿站
         * coverImgUrl : /prod-api/profile/upload/image/2022/03/14/31f7b6bf-3e68-4736-930b-1e60dac2b0ac.jpg
         * imageUrls : /prod-api/profile/upload/image/2022/03/14/e0b34775-e8b9-47d6-8ab9-bd97d43e9da0.jpg,/prod-api/profile/upload/image/2022/03/14/ac55b604-1836-4fb4-be3d-f1e3c1fcbe92.jpg,/prod-api/profile/upload/image/2022/03/14/e8c86da3-9c1c-4315-94db-0b29ada6c2fe.jpg,/prod-api/profile/upload/image/2022/03/14/72302733-aafb-485a-ac84-0328f4ad6fbd.jpg,/prod-api/profile/upload/image/2022/03/14/e5db8e07-2755-421c-86aa-946c4b3e678b.jpg,/prod-api/profile/upload/image/2022/03/14/68920148-7719-4534-9016-ba8800b0d172.jpg,/prod-api/profile/upload/image/2022/03/14/94944793-8a07-4f3f-af06-8303f6a7e625.jpg
         * bedsCountBoy : 68
         * bedsCountGirl : 23
         * address : 大连金州区恒安里-2号楼 , 大连
         * phone : 021-80187829-2818146
         * workTime : 8:00-22:00
         * introduce : 你好，房屋位于开发区核心地带房屋配有空调，WiFi，电视，洗衣机，淋浴，厨房全套设备，干净整洁，温馨舒适。周边距离轻轨站万达广场不到两公里的距离。诚挚欢迎您的入住找到家一样的感觉。房间卫生都是一可以扫，保证干净整洁。在大连，如此公寓，还真是不多见。关键是我们的价格要低于其他的很多很多。24小时热水+独立卫生间+独立厨房+免费上网宽带！公寓位于开发区丽娇湾滨海旅游路中段，毗邻铜牛岭,体育公园，白石湾浴场。周边银行超市齐 全。距离大型商业中心一公里多，闹市中的海上世外桃源也。
         * internalFacilities : 暖气 小冰箱 洗衣机 电热水壶 免费有线上网 拖鞋 吹风机 免费wifi 全套厨房 独立卫浴 淋浴房 电视
         * surroundingFacilities : 林海滑雪场，AC超市
         * specialService : 自动取款机 电梯
         * imageUrlList : ["/prod-api/profile/upload/image/2022/03/14/e0b34775-e8b9-47d6-8ab9-bd97d43e9da0.jpg","/prod-api/profile/upload/image/2022/03/14/ac55b604-1836-4fb4-be3d-f1e3c1fcbe92.jpg","/prod-api/profile/upload/image/2022/03/14/e8c86da3-9c1c-4315-94db-0b29ada6c2fe.jpg","/prod-api/profile/upload/image/2022/03/14/72302733-aafb-485a-ac84-0328f4ad6fbd.jpg","/prod-api/profile/upload/image/2022/03/14/e5db8e07-2755-421c-86aa-946c4b3e678b.jpg","/prod-api/profile/upload/image/2022/03/14/68920148-7719-4534-9016-ba8800b0d172.jpg","/prod-api/profile/upload/image/2022/03/14/94944793-8a07-4f3f-af06-8303f6a7e625.jpg"]
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
        private String coverImgUrl;
        private String imageUrls;
        private int bedsCountBoy;
        private int bedsCountGirl;
        private String address;
        private String phone;
        private String workTime;
        private String introduce;
        private String internalFacilities;
        private String surroundingFacilities;
        private String specialService;
        private List<String> imageUrlList;

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

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public String getImageUrls() {
            return imageUrls;
        }

        public void setImageUrls(String imageUrls) {
            this.imageUrls = imageUrls;
        }

        public int getBedsCountBoy() {
            return bedsCountBoy;
        }

        public void setBedsCountBoy(int bedsCountBoy) {
            this.bedsCountBoy = bedsCountBoy;
        }

        public int getBedsCountGirl() {
            return bedsCountGirl;
        }

        public void setBedsCountGirl(int bedsCountGirl) {
            this.bedsCountGirl = bedsCountGirl;
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

        public String getWorkTime() {
            return workTime;
        }

        public void setWorkTime(String workTime) {
            this.workTime = workTime;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getInternalFacilities() {
            return internalFacilities;
        }

        public void setInternalFacilities(String internalFacilities) {
            this.internalFacilities = internalFacilities;
        }

        public String getSurroundingFacilities() {
            return surroundingFacilities;
        }

        public void setSurroundingFacilities(String surroundingFacilities) {
            this.surroundingFacilities = surroundingFacilities;
        }

        public String getSpecialService() {
            return specialService;
        }

        public void setSpecialService(String specialService) {
            this.specialService = specialService;
        }

        public List<String> getImageUrlList() {
            return imageUrlList;
        }

        public void setImageUrlList(List<String> imageUrlList) {
            this.imageUrlList = imageUrlList;
        }

        public static class ParamsDTO {
        }
    }
}
