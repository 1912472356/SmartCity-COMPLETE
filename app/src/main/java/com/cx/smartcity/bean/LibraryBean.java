package com.cx.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class LibraryBean implements Serializable {
    /**
     * total : 50
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"name":"贵港市图书馆","address":"广西壮族自治区贵港市港北区民主路185号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/3971d94c-68ee-4744-8ae0-3c1b66aa953e.jpeg","mapUrl":"","businessHours":"每天 09:00-21:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"name":"贺州市图书馆","address":" 贺州市八步区八步镇体育路67号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/60380c09-2098-4258-a584-85e99109980e.jpeg","mapUrl":"","businessHours":"周一至周四,周六至周日 08:30-17:30","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"name":"长沙图书馆","address":"新河三角洲滨江文化园","imgUrl":"/prod-api/profile/upload/image/2022/03/13/0157758f-f206-467c-9bed-6c40a6290789.jpeg","mapUrl":"","businessHours":"周二至周六 09:00-21:00 周日 09:00-17:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"name":"普宁市图书馆","address":"流沙西街道广南路教育局西100米","imgUrl":"/prod-api/profile/upload/image/2022/03/13/1ecfaaa9-0bc7-403f-8562-3573866790af.jpeg","mapUrl":"","businessHours":"工作日08:00-15:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"name":"潮州市潮安区图书馆","address":" 潮州市潮安区庵埠镇廉泉街4号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/50f0f872-2908-4f8f-97bb-0ca785d61f33.jpeg","mapUrl":"","businessHours":"工作日08:00-18:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"name":"云浮市图书馆","address":"云浮市云城区世纪大道中(市政府旁边)","imgUrl":"/prod-api/profile/upload/image/2022/03/13/9935ba69-a24a-46bb-90e1-a3190a60be45.jpeg","mapUrl":"","businessHours":"每天09:00 - 21:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":16,"name":"广州从化图书馆","address":" 广州市从化区河滨北路616号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/5dccf512-56c5-4cf4-8cb0-8b63b3a7a988.jpeg","mapUrl":"","businessHours":"08:30-18:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":17,"name":"昆山市图书馆","address":"江苏省苏州市昆山市前进中路353号瑞士大酒店旁边","imgUrl":"/prod-api/profile/upload/image/2022/03/13/2fe439b6-9b8b-4c46-a088-6f50907bf2fb.jpeg","mapUrl":"","businessHours":"周二至周日 09:00-20:30","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":18,"name":"南方医科大学","address":"广州市白云区广州大道北1838号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/308c645b-40c9-43d3-bfbe-dba716cdc954.jpeg","mapUrl":"","businessHours":"08:00-22:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":19,"name":"安徽省图书馆","address":"合肥市包河区芜湖路74号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/17b83907-188d-468b-bbd3-1748bd6d0907.jpeg","mapUrl":"","businessHours":"周二至周日 08:30-18:20","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":20,"name":"安徽新华学院图书馆","address":"合肥市蜀山区望江西路555号安徽新华学院内","imgUrl":"/prod-api/profile/upload/image/2022/03/13/5b909e49-aaee-4300-9167-01a298c86ea2.jpeg","mapUrl":"","businessHours":"工作日8:00-22:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":21,"name":"广州市白云区图书馆","address":"广州市白云区云城西路1211号(2号线萧岗站B出口)","imgUrl":"/prod-api/profile/upload/image/2022/03/13/177eeda4-7d0a-44c7-86fd-641e8d631a58.jpeg","mapUrl":"","businessHours":"周二至周日 09:00-18:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":22,"name":"北京市东城区图书馆","address":"北京市东城区交道口东大街85号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/668abc01-4c8c-4213-bd5a-537f109b0c8e.jpeg","mapUrl":"","businessHours":"周二至周日 09:00-12:00,13:30-17:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":23,"name":"北京邮电大学图书馆","address":" 北京市海淀区西土城路10号北京邮电大学内","imgUrl":"/prod-api/profile/upload/image/2022/03/13/7183631e-bdbb-4726-87d0-8adf78b9ceae.jpeg","mapUrl":"","businessHours":"10:00-22:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":24,"name":"长春图书馆","address":"春市朝阳区同志街1956号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/e517425f-b01f-4095-86a8-471f4a0d0bc7.jpeg","mapUrl":"","businessHours":"周一至周二,周四至周日 08:30-20:30","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":25,"name":"成都图书馆","address":"成都市青羊区文翁路98号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/b9bf8d36-7377-40cb-9cc0-f4beb98f1c33.jpeg","mapUrl":"","businessHours":"周四至周日 09:00-20:30 周三 09:00-12:00 周一至周二 09:00-20:30","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":26,"name":"重庆图书馆","address":"重庆市沙坪坝区凤天大道106号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/e8960805-d8f6-432d-80d8-e40d58cdfecd.jpeg","mapUrl":"","businessHours":"周二至周日 09:00-19:45 周一 14:00-19:45","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":29,"name":"肇庆市端州图书馆","address":"广东省肇庆市端州区宝月路30号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/55559ef9-8553-4f0d-888a-ed119591b945.jpeg","mapUrl":"","businessHours":"周一 闭馆,周一至周日：11:30-14:30 周二至周日 08:00-17:30","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":30,"name":"佛山市图书馆","address":"广东省佛山市顺德区佛山新城华康道11号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/88fcda38-72e6-4931-b632-9e3f5fbae5f3.jpeg","mapUrl":"","businessHours":"周二至周日 09:00-17:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":31,"name":"广东海洋大学图书馆","address":"广州市番禺区大学城外环西路230号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/4e8a21dc-3507-48d7-9b35-c0894745a29d.jpeg","mapUrl":"","businessHours":"8:00-22:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":32,"name":"广州体育学院图书馆","address":"广州市天河区广州大道中1268号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/f5ce66ae-5f1a-4273-93ec-47f1b960f3eb.jpeg","mapUrl":"","businessHours":"8:00-22:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":33,"name":"桂林图书馆","address":"桂林市临桂区公园北路和凤凰路交叉口","imgUrl":"/prod-api/profile/upload/image/2022/03/13/01326575-5338-4498-b9df-58d45d5bc951.jpeg","mapUrl":"","businessHours":"周二至周日 09:00-17:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":34,"name":"甘肃省图书馆","address":"甘肃省兰州市城关区南滨河东路488号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/8117efcf-ad86-4160-a5dc-6aafe57e254d.jpeg","mapUrl":"","businessHours":"周二至周日 08:30-18:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":35,"name":"广州铁路职业技术学院图书馆","address":"广州市白云区庆隆中路100号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/f2d2773f-1151-4f72-a586-7ccc13a964d1.jpeg","mapUrl":"","businessHours":"8:00-22:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":36,"name":"灌云县图书馆","address":" 连云港市灌云县建设中路6号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/b3e22c7e-77d4-4a74-8ecd-167a7c0622b6.jpeg","mapUrl":"","businessHours":"8:30-22:30","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":37,"name":"贵州省图书馆","address":"贵州省贵阳市云岩区北京路130号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/41d5c7a0-2b02-4ec6-beac-f3236d3ee87f.jpeg","mapUrl":"","businessHours":"周五 14:00-20:00 周一至周四,周六至周日 09:00-20:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":39,"name":"河北省图书馆","address":"石家庄市长安区东大街16号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/94c7aea9-11bd-432d-9bfc-57f1e4a158d4.jpeg","mapUrl":"","businessHours":"周二至周日 09:00-12:30,13:30-17:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":40,"name":"海南省图书馆","address":"海口市琼山区国兴大道36号(大润发国兴店斜对面)","imgUrl":"/prod-api/profile/upload/image/2022/03/13/0bcb4837-6021-4101-a9c1-8055ce503d76.jpeg","mapUrl":"","businessHours":"周五 09:00-12:00 周一至周四,周六至周日 09:00-20:30","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":41,"name":"黑龙江省图书馆","address":"黑龙江省哈尔滨市南岗区长江路216号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/ba01b297-27b7-44fa-ba39-1837297d1f96.jpeg","mapUrl":"","businessHours":"8:00 - 22;00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":42,"name":"哈尔滨市图书馆","address":"哈尔滨市南岗区学府路49号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/e40c7c2d-bcd7-4e5f-80a0-6c894e1cc836.jpeg","mapUrl":"","businessHours":"09:00-19:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":43,"name":"河源市图书馆","address":"河源市源城区客家文化公园","imgUrl":"/prod-api/profile/upload/image/2022/03/13/64e6373d-fd1d-45e4-85fb-9dd27d6c714a.jpeg","mapUrl":"","businessHours":"09:00-19:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":44,"name":"惠州慈云图书馆","address":"广东省惠州市惠城区江北三新南路15号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/2c4d9f6c-4355-4a56-8952-a51d912bcdc4.jpeg","mapUrl":"","businessHours":"周二至周日 开放时间 09:00-21:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":45,"name":"杭州图书馆","address":" 杭州市上城区解放东路58号(市民中心J楼)","imgUrl":"/prod-api/profile/upload/image/2022/03/13/4cde3abf-c6a8-40a1-98ef-377363c60afd.jpeg","mapUrl":"","businessHours":"周二至周日 09:00-21:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":46,"name":"武汉市江汉区图书馆","address":" 武汉市江汉区新华路275号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/1ed09230-4ae1-45e7-8429-011279427dda.jpeg","mapUrl":"","businessHours":"8:00-22:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":48,"name":"金陵图书馆","address":"南京市建邺区乐山路158号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/c86ce52b-340a-41b7-9dde-b37003bc52a6.jpeg","mapUrl":"","businessHours":"周一至周三，周五9:00 - 20:30，周四9:00 - 12:00;法定节假日9:00-17:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":50,"name":"济南市图书馆","address":"山东省济南市腊山河东路与威海路交叉口","imgUrl":"/prod-api/profile/upload/image/2022/03/13/7d8e6673-7467-4eff-bd1d-b2b7c81e36d6.jpeg","mapUrl":"","businessHours":"周二至周日 09:00-17:30","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":51,"name":"开封市图书馆","address":"河南省开封市龙亭区东湖南路1号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/d02426ab-9795-421a-a8da-d6241b73f165.jpeg","mapUrl":"","businessHours":"周二至周日 09:00-17:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":52,"name":"绵阳师范学院图书馆","address":"绵阳市游仙区游仙镇绵阳师范学院(北校区)图书馆","imgUrl":"/prod-api/profile/upload/image/2022/03/13/f6b8e257-8be8-4008-bb95-a3a908fa4ad8.jpeg","mapUrl":"","businessHours":"周一至周日 08:00-21:30","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":53,"name":"山西省图书馆","address":"山西省太原市晋源区长风商务区广经路5号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/606c955e-cf17-490d-b889-b642ddaa37a5.jpeg","mapUrl":"","businessHours":"周二至周日 08:30-19:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":54,"name":"成都市龙泉驿区图书馆","address":"龙泉驿区图书馆位于龙泉驿区龙泉镇。全馆坐落龙泉山西麓，馆内绿化错落有致，读书环境优雅清静。","imgUrl":"/prod-api/profile/upload/image/2022/03/13/b0e18f82-f11f-41b6-b93f-989be5c6ae67.jpeg","mapUrl":"","businessHours":"8:00-22:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":55,"name":"广东茂名市图书馆","address":"茂名市茂南区河东街道高凉中路文化广场内","imgUrl":"/prod-api/profile/upload/image/2022/03/13/91758e18-0da9-4a4d-a8b1-cd9783d870c3.jpeg","mapUrl":"","businessHours":"周六至周日 08:30-21:00 周二至周五 08:30-12:00,15:00-21:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":56,"name":"山东省图书馆","address":"济南市历城区二环东路2912号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/46d5ceae-c6f5-4da0-b113-fb307ef7bc43.jpeg","mapUrl":"","businessHours":"周二至周日 08:30-19:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":57,"name":"辽宁省图书馆","address":"沈阳市浑南区智慧二街168号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/e6576e31-b83a-48cd-87a7-82ab71d41f64.jpeg","mapUrl":"","businessHours":"周一至周二,周四至周日 08:30-17:00 周三 08:30-12:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":58,"name":"大连市图书馆","address":"大连市西岗区长白街7号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/ecf29bc9-aaf8-478b-bd56-83cb2b6b3c1a.jpeg","mapUrl":"","businessHours":"周二至周日 09:00-17:50","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"name":"南宁市图书馆","address":"广西壮族自治区南宁市良庆区玉洞大道32号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/e6279b0f-dd4d-4d69-abbc-d18f2013d012.jpeg","mapUrl":"","businessHours":"周一至周四,周六至周日 09:00-17:00","businessState":"0","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":27,"name":"常州图书馆","address":"江苏省常州市新北区锦绣路2号常州文化广场","imgUrl":"/prod-api/profile/upload/image/2022/03/13/baf9bbb6-751a-406d-8d11-1e0ca37255a6.jpeg","mapUrl":"","businessHours":"暂停营业","businessState":"0","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":28,"name":"东莞图书馆","address":"广东省东莞市鸿福路98号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/873d1813-8035-4c3a-a8fc-9853d92d6960.jpeg","mapUrl":"","businessHours":"暂停营业","businessState":"0","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":38,"name":"沧州市图书馆","address":"沧州市运河区御河西路","imgUrl":"/prod-api/profile/upload/image/2022/03/13/3049e030-9870-4c25-88e1-f7cb0e76166a.jpeg","mapUrl":"","businessHours":"暂停营业","businessState":"0","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":47,"name":"吉林市图书馆","address":"吉林市昌邑区解放东路63号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/4430204b-7d5a-4e34-8d23-481e96eadf51.jpeg","mapUrl":"","businessHours":"暂停营业","businessState":"0","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":49,"name":"江门市图书馆","address":" 江门市蓬江区港口路102号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/36b18e0a-1ea8-43cb-a2ab-3486a443fd32.jpeg","mapUrl":"","businessHours":"维修中，暂停营业","businessState":"0","description":""}]
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
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 10
         * name : 贵港市图书馆
         * address : 广西壮族自治区贵港市港北区民主路185号
         * imgUrl : /prod-api/profile/upload/image/2022/03/13/3971d94c-68ee-4744-8ae0-3c1b66aa953e.jpeg
         * mapUrl :
         * businessHours : 每天 09:00-21:00
         * businessState : 1
         * description :
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
        private String address;
        private String imgUrl;
        private String mapUrl;
        private String businessHours;
        private String businessState;
        private String description;

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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getMapUrl() {
            return mapUrl;
        }

        public void setMapUrl(String mapUrl) {
            this.mapUrl = mapUrl;
        }

        public String getBusinessHours() {
            return businessHours;
        }

        public void setBusinessHours(String businessHours) {
            this.businessHours = businessHours;
        }

        public String getBusinessState() {
            return businessState;
        }

        public void setBusinessState(String businessState) {
            this.businessState = businessState;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public static class ParamsDTO implements Serializable{
        }
    }
}
