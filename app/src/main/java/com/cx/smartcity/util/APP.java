package com.cx.smartcity.util;

import android.app.Application;
import android.icu.text.NumberingSystem;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.HuanbaoYuyueBean;
import com.cx.smartcity.bean.YanglaoBean;
import com.google.gson.Gson;

import java.util.ArrayList;

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SPUtil.init(getApplicationContext());
        if (SPUtil.get(SPUtil.HTTP) != null) {
            RetrofitUtil.init(getApplicationContext());
        }
        if (SPUtil.get(SPUtil.SHEQU_YOULING) == null) {
            SPUtil.put(SPUtil.SHEQU_YOULING, new Gson().toJson(new ArrayList<>()));
        }
        if (SPUtil.get(SPUtil.SHEQU_CHELIANG) == null) {
            SPUtil.put(SPUtil.SHEQU_CHELIANG, new Gson().toJson(new ArrayList<>()));
        }
        if (SPUtil.get(SPUtil.HUANBAO_YUYUE) == null) {
            SPUtil.put(SPUtil.HUANBAO_YUYUE, new Gson().toJson(new ArrayList<>()));
        }
        if (SPUtil.get(SPUtil.HUANBAO_PRE_MSg) == null) {
            SPUtil.put(SPUtil.HUANBAO_PRE_MSg, new Gson().toJson(new HuanbaoYuyueBean("", "0","", "")));
        }
        if (SPUtil.get(SPUtil.KAIMO_GONGYI) == null) {
            SPUtil.put(SPUtil.KAIMO_GONGYI, new Gson().toJson(new ArrayList<>()));
        }
        if (SPUtil.get(SPUtil.KAIMO_NEAR_HERO) == null) {
            SPUtil.put(SPUtil.KAIMO_NEAR_HERO, new Gson().toJson(new ArrayList<>()));
        }
        if (SPUtil.get(SPUtil.ZHIZAO_ZHANHUI) == null) {
            SPUtil.put(SPUtil.ZHIZAO_ZHANHUI, new Gson().toJson(new ArrayList<>()));
        }
        if (SPUtil.get(SPUtil.FUPING_CASE) == null) {
            SPUtil.put(SPUtil.FUPING_CASE, new Gson().toJson(new ArrayList<>()));
        }
        if (SPUtil.get(SPUtil.RECENT_CALL) == null) {
            SPUtil.put(SPUtil.RECENT_CALL, new Gson().toJson(new ArrayList<>()));
        }
        if (SPUtil.get(SPUtil.YANGLAO) == null) {
            ArrayList<YanglaoBean> list = new ArrayList<>();
            list.add(new YanglaoBean("1.\t同辉养老", R.mipmap.yanglao1, "同辉养老（集团）是一家有梦想、有强烈社会责任感的医养健康服务型企业，定位于一家连锁化的医养结合型中高端养老服务品牌。我们坚持以“同辉医养，让长者生命更健康”的根本服务宗旨，以打造“中国一流医养服务品牌”为发展愿景，以“代忙碌儿女尽孝，替孤独父母解愁，为党和政府分忧”为己任，致力于“提供高品质、专业化的医养健康服务，履行社会责任”的企业使命，为离退休长者提供无微不至的“医养康护娱居”一站式服务，像爱自己的孩子一样爱长者，替天下忙碌儿女尽一份爱心，为国家社会贡献一份责任。\n" +
                    " \n" +
                    "人人会变老，家家有老人。同辉养老（集团）崇尚的是天底下最崇高的为老服务事业。做人做事成功的关键，就是从构建长者健康美好幸福新生活开始；服务长者，服务老人，就是在创造美好幸福生活！\n" +
                    "立足重庆主城以夯实基础，逐步拓展构建覆盖全市的服务网络。近期以机构养老为主体，配套建设市级、区级社区养老服务中心，利用杰佳通智慧养老平台为核心平台，连锁开展居家养老服务，适时承接公建民营项目，逐步开办养老职业培训、养老专业咨询服务等业务，逐步实现机构养老社区化、社区养老专业化、连锁养老品质化发展目标。\n"));
            list.add(new YanglaoBean("2.\t赣州幸福村智慧养老平台", R.mipmap.yanglao2, "赣州幸福村智慧养老平台养老版块涵盖居家养老和机构养老，其中机构养老包括赣州添立养老院，大公路养老院，水东养老院，蟠龙养老院，赣州三附院永昌院区；居家养老以各机构园区为中心覆盖周边居家养老区域，杰佳通为添立医养建设的智慧健康养老平台，以养老平台为中心，融合居家和机构养老大数据，医养结合的养老模式、虚拟养老院、智慧养老运作模式、养老评估管理系统、慢病管理系统、老人安全保障系统、社区养老管理系统、老年大学系统、志愿者管理系统、养老政府监管平台等等。"));
            list.add(new YanglaoBean("3.\t佳林养老院", R.mipmap.yanglao3, "佳林养老院设计合理,环境优美、空气新鲜.院内设有绿色休闲长廊、绿树成荫,四季常青.同时为满足住院老人的绿色饮食和业余生活,规划了休闲养殖园等。同时根据入住老人需要配置多媒体教室、图书阅览室、康复健身室、文化娱乐室等活动场所,确保入住老人业余生活丰富多彩、颐养天年。\n" +
                    " \n" +
                    "  \n" +
                    "1. 对三环内老人入住免费车接。\n" +
                    "2. 残疾老人、无儿女老人、智障人员入住,享受相应优惠政策。\n" +
                    "3. 入住老人可按公寓管理规定,分得一块田地用于自主种植。\n" +
                    "4. 为老人建立健康档案,配备专业资格医师进行诊断,护理人员持认证资格上岗。\n" +
                    "5. 全护专区的设立,不止为老人提供及时、便利 、精准的医疗服务,并将生活\n" +
                    "6. 照料与身体康复相结合。\n" +
                    "7. 专业厨师根据季节及老人身体情况进行营养配餐。\n"));
            list.add(new YanglaoBean("4.\t河北枫叶老年公寓", R.mipmap.yanglao4, "长安区枫叶老年公寓位于动力医院三、四楼,是集医疗、护理、托管、娱乐、康复为一体的大型医疗养老机构,老年公寓将养老和医疗完美结合,让入住的老人在养老的同时加上一份及时的医疗保障。\n" +
                    " \n" +
                    " \n" +
                    "1. 医保定点单位。\n" +
                    "2. 建立健康档案，医生随时査诊。\n" +
                    "3. 全方位提供专业的医疗支持。\n" +
                    "4. 可为入住老人提供针灸、按摩、康复等特色理疗服务，使老人可以足不出户得到方便就医。\n"));
            list.add(new YanglaoBean("5.\t石家庄藁城区盛德老年公寓", R.mipmap.yanglao5, "藁城区盛德老年公寓依据生态养老标准,以园林建筑风格为特色,根据老年人对亲近生态环境,享受自然环境的生活和养生需求开设园林观赏区、休闲区、健身区、种植区等多个特色小园区,让老年人充分融入春天赏花、夏天收菜、秋天摘果、冬天观景的四季风光中.是一家集养老、照护、医疗、康复、文化、娱乐为一体的亲情化老年公寓。\n" +
                    " \n" +
                    " \n" +
                    "特色服务\n" +
                    "1. 对藁城市区及周边地区老人入住免费车接\n" +
                    "2. 残疾老人、无儿女老人、智障人员入住,享受相应优惠政策\n" +
                    "3. 为老人建立健康档案，配备专业资格医生进行诊断，护理人员持证上岗\n" +
                    "4. 专业厨师根据季节及老人身体情况进行营养配餐\n"));
            SPUtil.put(SPUtil.YANGLAO, new Gson().toJson(list));
        }
    }
}
