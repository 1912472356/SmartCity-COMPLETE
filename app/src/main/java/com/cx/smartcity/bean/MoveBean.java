package com.cx.smartcity.bean;

import java.util.List;

public class MoveBean {
    /**
     * msg : 操作成功
     * code : 200
     * data : {"createTime":"2022-03-07 11:32:51","id":6,"companyId":6,"infoNo":"ST0000001","company":{"id":6,"name":"申通物流","sort":1,"imgUrl":"/prod-api/profile/upload/image/2022/03/07/14ae50ff-9326-44de-a127-75c7bf61eae0.jpeg","introduce":"申通快递品牌初创于 1993 年，公司致力于民族品牌的建设和发展，不断完善终端网络、中转运输网络和信息网络三网一体的立体运行体系，立足传统快递业务，全面进入电子商务领域，以专业的服务和严格的质量管。","shippingMethod":"空运,陆运,海运,大件慢速物流","phone":"18842424242","priceList":null,"newsList":null},"stepList":[{"id":7,"infoId":6,"eventAt":"2022-03-02","stateName":"快递发出","addressAt":"辽宁省大连市甘井子区中转站"},{"id":6,"infoId":6,"eventAt":"2022-03-01","stateName":"快递被揽收","addressAt":"辽宁省大连市中转场"}]}
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
         * createTime : 2022-03-07 11:32:51
         * id : 6
         * companyId : 6
         * infoNo : ST0000001
         * company : {"id":6,"name":"申通物流","sort":1,"imgUrl":"/prod-api/profile/upload/image/2022/03/07/14ae50ff-9326-44de-a127-75c7bf61eae0.jpeg","introduce":"申通快递品牌初创于 1993 年，公司致力于民族品牌的建设和发展，不断完善终端网络、中转运输网络和信息网络三网一体的立体运行体系，立足传统快递业务，全面进入电子商务领域，以专业的服务和严格的质量管。","shippingMethod":"空运,陆运,海运,大件慢速物流","phone":"18842424242","priceList":null,"newsList":null}
         * stepList : [{"id":7,"infoId":6,"eventAt":"2022-03-02","stateName":"快递发出","addressAt":"辽宁省大连市甘井子区中转站"},{"id":6,"infoId":6,"eventAt":"2022-03-01","stateName":"快递被揽收","addressAt":"辽宁省大连市中转场"}]
         */

        private String createTime;
        private int id;
        private int companyId;
        private String infoNo;
        private CompanyDTO company;
        private List<StepListDTO> stepList;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public String getInfoNo() {
            return infoNo;
        }

        public void setInfoNo(String infoNo) {
            this.infoNo = infoNo;
        }

        public CompanyDTO getCompany() {
            return company;
        }

        public void setCompany(CompanyDTO company) {
            this.company = company;
        }

        public List<StepListDTO> getStepList() {
            return stepList;
        }

        public void setStepList(List<StepListDTO> stepList) {
            this.stepList = stepList;
        }

        public static class CompanyDTO {
            /**
             * id : 6
             * name : 申通物流
             * sort : 1
             * imgUrl : /prod-api/profile/upload/image/2022/03/07/14ae50ff-9326-44de-a127-75c7bf61eae0.jpeg
             * introduce : 申通快递品牌初创于 1993 年，公司致力于民族品牌的建设和发展，不断完善终端网络、中转运输网络和信息网络三网一体的立体运行体系，立足传统快递业务，全面进入电子商务领域，以专业的服务和严格的质量管。
             * shippingMethod : 空运,陆运,海运,大件慢速物流
             * phone : 18842424242
             * priceList : null
             * newsList : null
             */

            private int id;
            private String name;
            private int sort;
            private String imgUrl;
            private String introduce;
            private String shippingMethod;
            private String phone;
            private Object priceList;
            private Object newsList;

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

            public String getShippingMethod() {
                return shippingMethod;
            }

            public void setShippingMethod(String shippingMethod) {
                this.shippingMethod = shippingMethod;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Object getPriceList() {
                return priceList;
            }

            public void setPriceList(Object priceList) {
                this.priceList = priceList;
            }

            public Object getNewsList() {
                return newsList;
            }

            public void setNewsList(Object newsList) {
                this.newsList = newsList;
            }
        }

        public static class StepListDTO {
            /**
             * id : 7
             * infoId : 6
             * eventAt : 2022-03-02
             * stateName : 快递发出
             * addressAt : 辽宁省大连市甘井子区中转站
             */

            private int id;
            private int infoId;
            private String eventAt;
            private String stateName;
            private String addressAt;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getInfoId() {
                return infoId;
            }

            public void setInfoId(int infoId) {
                this.infoId = infoId;
            }

            public String getEventAt() {
                return eventAt;
            }

            public void setEventAt(String eventAt) {
                this.eventAt = eventAt;
            }

            public String getStateName() {
                return stateName;
            }

            public void setStateName(String stateName) {
                this.stateName = stateName;
            }

            public String getAddressAt() {
                return addressAt;
            }

            public void setAddressAt(String addressAt) {
                this.addressAt = addressAt;
            }
        }
    }
}
