package com.cx.smartcity.smart.relief;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.FupingBean;

import java.util.ArrayList;
import java.util.List;

public class ReliefCaseActivity extends AppCompatActivity {
    private RecyclerView caseRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relief_case);
        caseRecyc = (RecyclerView) findViewById(R.id.case_recyc);

        caseRecyc.setLayoutManager(new LinearLayoutManager(this));
        List<FupingBean> list = new ArrayList<>();
        list.add(new FupingBean("走进精准扶贫“首倡地”——湖南湘西十八洞村", "2021-02-01", R.mipmap.fuping6, "“决战决胜2020——走进‘精准扶贫’首倡地”，近日，《先锋》作为全国党刊全媒体采访团一员，来到湘西州十八洞村，聚焦精准扶贫的湘西经验，挖掘湘西州精准扶贫故事，近距离感受“首倡之地”的发展变化。\n" +
                " \n" +
                "十八洞村地处中国武陵山脉腹地，是一个藏在偏僻幽静山谷中的苗族聚居贫困村。过去，因为基础设施差、闭塞落后，外村女子不愿嫁入，村里鲜有陌生面孔。到2013年，全村贫困发生率高达57%，集体经济空白。2013年11月3日，习近平总书记在湖南湘西十八洞村视察时首次提出“精准扶贫”重要论述。经过7年的努力，目前十八洞村的贫困发生率已降至“0”，贫困人口全部脱贫。\n" +
                " \n" +
                "风起十八洞村\n" +
                "在湖南西北角的大山褶皱里，藏着一个个风情独特、纯情美丽的土家、苗寨，她们拥有一个共同的文化符号和地理标识——湘西。\n" +
                "湘西美，美得大气。\n" +
                "这里，山水风光神奇秀丽。森林覆盖率70.24%，拥有小溪、高望界、白云山国家自然生态保护区，南华山、不二门、坐龙峡国家森林公园，德夯、猛洞河国家风景名胜区……\n" +
                "这里，历史文化悠久厚重。拥有世界文化遗产老司城，国家历史文化名城凤凰古城，国家历史文化名镇里耶古镇、芙蓉镇、浦市镇、边城镇以及6个国家重点文物保护单位等各类历史文化古迹1517处……\n" +
                "这里，民族风情浓郁独特。土家族、苗族两个主体少数民族都有各自独特的语言、习俗、服饰、建筑、音乐、舞蹈，拥有26个国家级非物质文化遗产保护名录……\n" +
                " \n" +
                "湘西美，美得让人心痛。痛，在贫困。\n" +
                "未摆脱千年贫困的湘西，历史上贫困人口长期徘徊在60多万人，减不下。湘西州，是湖南省脱贫攻坚主战场。去年，湘西州所有贫困县摘帽、贫困村退出，累计减贫64万余人，贫困发生率由31.93%降至0.65%，农村居民人均可支配收入年均增长11.5%，千百年来的贫困问题一去不复返。\n" +
                "这一切的改变，源于精准扶贫。湘西，是习近平总书记精准扶贫重要论述的首倡地。这一场“劲风”，从十八洞村吹来，拂遍湘西大地。\n" +
                " \n" +
                "回望首倡地，7年来，十八洞村党支部带领群众，坚持聚焦“两不愁三保障”突出问题，凝心聚力攻克贫困堡垒，摆脱了千年贫困，村容村貌、群众生活发生了翻天覆地的变化。\n" +
                "2016年，全村人均纯收入达到8313元。2017年2月，经湖南省人民政府审核批准，十八洞村成功脱贫出列。2019年，全村人均纯收入由2013年的1668元增加到14668元，130户521名贫困人口全部实现脱贫，贫困发生率由2013年的56.76%下降到0，村集体经济收入达126.4万元，基础设施和公共服务不断完善，全村实现了稳定脱贫，正在向乡村振兴的路上大步前进。\n" +
                "不久前，国家脱贫攻坚普查，十八洞村以“零问题”顺利通过了严格考验。十八洞的脱贫实践，将成为中国精准扶贫的生动注脚。\n"));
        list.add(new FupingBean("精准扶贫助力“三区三州”脱贫攻坚", "2022-02-01", R.mipmap.fuping5, "“眼看刚刚长成的蓝莓烂在地里，一年的辛苦打了水漂。幸好广发银行成都分行的及时帮助，帮我们重新打开了销路。”凉山州会东县的蓝莓种植户杨大婶不止一次地感慨。\n" +
                "2020年是全国脱贫攻坚战的关键一年，也是最后一年。地处“三区三州”的凉山州会东县受疫情影响，蓝莓销售困难重重。广发银行成都分行聚焦“三区三州”深度贫困地区，联合总行、中国人寿四川分公司、中国人寿财险四川分公司兄弟单位、发动各级党组织、团委青年干部力量，通过搭建电商平台，实现田间到餐桌的“鲜直达”供应通道。一粒凝聚全体广发人真心真情的蓝莓，叩开了广发银行成都分行扶贫攻坚新路径，助力“三区三州”脱贫攻坚顺利收官。\n" +
                " \n" +
                "不能让农户的希望“烂”在地里\n" +
                "作为水果市场的新宠，蓝莓由于其口感和营养价值一直深受消费者喜爱。然而，由于其种植对土壤的酸碱度要求高，国内可以建蓝莓基地的地方不多，凉山州会东县就是其中之一。凉山州具有得天独厚的气候资源、冬春光热条件优越，种植蓝莓成为当地农户的主要经济来源。\n" +
                "每年3-4月，本应是当地蓝莓销售的一个旺季，但受疫情影响，多地封村封路，采购商进不去、大型农产交易中心关闭、蓝莓市场需求量急剧下降，精心培育一年的蓝莓果子严重滞销，农户面临较大经济损失。\n" +
                "“蓝莓是当地农户的经济来源，绝不能眼睁睁看着一年的收成和希望就这样烂在地里!”当获知这一消息后，广发银行成都分行立即召开“三区三州”四川扶贫工作专题联席会议，拟定广发慈善金助力教育扶贫、金融科技创新扶贫、支持国企发展夯实经济基础扶贫、摸清信息精准扶贫、保银协同合力扶贫、以购代捐消费扶贫六项扶贫工作思路，明确了以帮扶凉山会东县蓝莓销售为抓手，以银保联动发挥协同整合资源共享，形成助推“三区三州”脱贫攻坚战合力。\n" +
                " \n" +
                "电商平台为“好果子”打通“好销路”\n" +
                "会议思路一明确，广发银行成都分行扶贫团队立即驱车奔赴到650公里外的凉山州会东县，深入田间地头，实地考察蓝莓基地的培育规模和种植产量，确定帮扶和销售计划。通过实地调研发现，会东县蓝莓集多国技术为一体，来自英国的大棚、荷兰的基质和以色列的灌溉系统等现代化设备和先进技术，其产出符合欧盟标准。\n" +
                "然而，由于当地农户文化水平有限，传统销路仅仅依靠大型交易市场或水果商进村收购。疫情之下，为了让“好果子”找到“好销路”，广发银行成都分行积极运用电商平台，搭建凉山州扶贫产品直供平台微店，从蓝莓采摘、筛选、装箱和运输环节全程把关和监督，实现打通最优品质、最快速度的蓝莓餐桌“鲜直达”供应通道。发动总行、国寿兄弟单位共同以员工内购、客户营销、平台销售等渠道打响了一场“蓝莓爱心销售”战，仅仅一周时间就成功完成700余斤蓝莓订单，通过总行整合协调全国力量，打通扶贫产品全国销售直通车。\n"));
        list.add(new FupingBean("潜山县扶贫开发典型案例", "2021-01-01", R.mipmap.fuping4, "发布时间：2014-04-2017:18:46来源：潜山扶贫办阅读次数：944\n" +
                "特色产业舞龙头，对症扶贫阔步走\n" +
                "一、案例背景\n" +
                "潜山县位于大别山东南麓，属国家扶贫开发工作重点县。全县总面积1686平方公里，耕地面积32.1万亩，宜林山场面积131万亩，水面9.2万亩。县域地形地貌复杂，西北部为大别山余脉，山区面积占全县总面积59.2%，中部的丘陵区占全县面积的23.9%，东南部为圩畈区，地势平坦，河湖穿插，耕地集中，占全县总面积的16.9%。全县辖16个乡镇164个行政村，其中山区村为158个。2004年年末总人口57.2万人，其中农业人口52.3万人，占总人口91.4%。由于我县山区面积较大，地形地貌复杂，自然条件恶劣，基础薄弱，农民收入增长缓慢，贫困人口数量较大。2004年全县人均收入668元以下的绝对贫困人口\n" +
                "3.75万人，人均收入668-924元的低收入人口6.38万人。并且有相当一部分人口在温饱线上挣扎。而且贫困人口居住分散，扶贫开发成本高。该县人均收入924元以下的贫困人口还有10.13万人，且多分布在自然条件极为恶劣的深山区和自然灾害频发区，居住分散，缺乏基本的生产生活条件，短时间内还很难摆脱贫困，改善这部分人口的生产生活条件，解决其温饱问题需要付出的扶贫开发成本较大。山区多是以保持生态效益为主的公益林，经济效益较低。农民主要以种植水稻为主，其他经济作物如茶叶、蚕桑、板栗、瓜蒌等规模小，产业化水平低，市场影响因素大，缺乏促进群众收入稳定增长的主导产品。2004年农民人均纯收入为1680元，山区人均纯收入仅为1200元左右，除绝对贫困人口外，尚有相当一部分群众在温饱线徘徊，生活条件和质量较差。脱离贫困的群众也只是一种低层次、低标准、低水平解决温饱，基础不牢，稍遇自然灾害极易返贫，需要继续扶持进行巩固。\n" +
                "近年来，潜山县根据不断变化的新形势和扶贫开发面临的新情况，在国家扶贫开发方针政策的指引下，创新扶贫开发方式，探索实施符合贫困地区实际的“六大产业对症扶贫模式”，即根据当地不同的资源禀赋，采取不同的扶贫措施；根据不同地势的土质地貌，实行不同的产业扶贫，扶贫项目和资金向真正需要扶持的贫困户重点倾斜。这种扶贫模式的特点在于突出以人为本的扶贫理念，重视贫困人口的脱贫问题，使不同环境、不同特点的贫\n" +
                "困户合理地享受到政府和社会给予的扶贫资源，从而使脱贫致富步伐更坚实、更协调。\n" +
                "二、主要做法\n" +
                "一是因地制宜，立足资源禀赋和产业特色，打造特色经济板块。该县整合县扶贫、发改、农委、交运、水利等相关部门资源和力量，组织专业技术人员实地考察，对扶持项目进行论证，结合各村实际，因地制宜，做规划、选产业、定项目，对六大特色产业提出包含基地建设、质量建设、龙头企业建设、市场开拓等内容的总体要求，制订新的发展规划，并按年度分解各阶段性目标，指导全县特色农业的发展，优化产业布局，提升产业素质。并严格按照项目规划实施，强化项目资金监管，确保各项目科学合理有序推进。立足资源禀赋和产业特色，坚持实行“一个产业、一名县级牵头领导、一个主抓部门、一套班子、一块资金”的“五个一”捆绑推进机制，围绕茶叶、瓜蒌、蚕桑、食用菌、油茶、畜禽等农业六大特色产业做文章，打造特色经济板块。\n" +
                "二是扶贫项目跟着特色产业走。该县2009年成立了茶叶、瓜蒌、油茶、食用菌、畜禽、蚕桑六大特色产业指挥部，强化具体措施，安排千万元资金，扶持产业基地规模发展、龙头企业培育和农产品品牌建设。在项目村修公路、改水渠、建塘堰，发展茶园、桑园和畜禽等特色种养业，使项目村基础设施得到极大改善，生产发展能力得到较大提高，为农民增收致富拓宽了新天地。先后在158个重点贫困村实施了整村推进工程，累计投入5763万元，占县扶贫资金总额的70%，平均每个村综合投入52万元。累计新建乡村道路210公里，实施农村公路“村村通”工程640公里，新建平板桥18痤，除险加固病险水库12座，建自来水塔108座，铺设引水管道720千米，解决18万人饮水困难，干渠整修安装u型槽37千米，恢复水毁农田护岸67千米，修建当家塘251口，改善灌溉面积2.2万亩，改善低产茶园3700亩，发展茶园2600亩，新建厂房1890平方米，添置机械设备87套。\n" +
                "三是为确保扶贫工作取得成效，该县建立了政府主导、部门联动、定期考核、民主监管为一体的长效机制，推动扶贫开发健康有序发展。各大产业指挥部科学制定发展规划，出台有力推进措施，加大督查验收力度；各乡镇加大政策宣传引导，细化分解发展目标，将工作任务落实到村组、农户，并突出各自的特色，一村一品、一乡一业的产业格局初具规模，有力促进了农业特色产业的可持续发展。\n" +
                "四是抓基地建设，注重规模化和标准化。在基地建设中，充分发挥大户带动作用，走“公司或专业合作社+基地+农户”之路，实施连片开发、规模化发展，至目前，全县已有50亩以上规模化基地4处，5亩以上生产大户20余家。龙头企业、专业合作社和种植大户积极探索发展规律，注重规避风险，龙头企业、合作社、种植大户根据区域特点和资源优势，把握季节、气候特征，因地制宜，适地适种。\n" +
                "五是抓龙头企业发展，注重品牌建设。全县六大产业已有龙头企业40家，其中省级龙头企业5家，市级15家。按照特色农业发展需要，多层次、多渠道、多形式培植发展\n" +
                "龙头企业，充分发挥龙头企业、农民专业合作组织在发展特色农业中的带动作用。注重加强能人大户和农民经纪人队伍培育，抓好与扶贫有联系、能带动群众增收的农业产业化龙头企业培育，在资金和项目安排等方面予以重点倾斜。至目前，全县农业产业化企业实现产值由2009年的21.9亿元发展到33亿元，农民经纪人队伍发展到1700多人，带动6000余户2.5万人脱贫致富。\n"));
        list.add(new FupingBean("合作社撑起“茶叶楼”", "2021-02-14", R.mipmap.fuping3, "“黄柏到塔畈，九十九道弯”一曲民谣唱出了80年代塔畈人的艰辛。而位于塔畈中心地的彭河，更是可想而知。由于是三分水田七分山的地形，这里的农民粮食不能自给。常常是“守着青柴当米钱”。如今，一提及自家盖起的小洋楼，倪天喜便要提及一个人和他的合作社——江成生和彭河茶叶专业合作经济组织。“我40多岁了，没有一技之长，只能干点苦力活。”倪天喜一家四口人，因为他和妻子都是老实巴交的庄家人，生活只能勉强维持温饱。“江总让我负责收购鲜茶草”今年，近收鲜茶草这一项收入，倪天喜一家收入在9万元。“如今，我是手中有茶，心里不慌。”倪天喜憨憨的说道。江成生，安徽省劳模，全国农村青年致富带头人标兵，彭河茶叶专业合作社的牵头人，他却清楚的记得，第一次与茶农的订单，源于“看见锄头挖茶树心在痛”。\n" +
                "濒临长江的潜山县彭河，属亚热带湿润季风气候。这里平均海拔900米，年平均气温16.3度，空气相对湿度85%以上，故山高雾绕，风光秀丽。其光照、温度、湿度、土壤均适宜茶叶生长。所产名茶，更是自唐代以来一直被列为贡茶。但是由于地处深山，这里的茶产业采用传统粗放经营模式，主要通过分布在各地的同乡和批发商销售。产品也主要依靠散装形式销售，茶企普遍缺乏品牌意识。“茶树叶子能包盐，茶树杆子能撑船”说的就是当年的茶叶质量。在当地，茶叶大部分是老百姓饭后用来说天聊地的饮料。2004年的一个秋日午后，江成生正准备到自家茶地干活，看见一位老大爷用锄头挖茶树，江成生便问他“干嘛要砍茶树呢？种着不挺好的吗？”“又不能当饭吃，还不如挖掉种点小麦实惠！”看着好好的茶树要无端受灭门之灾，江成生很是心疼。“你把茶树留着，等茶叶长出来了我来收购”“你空口讲话以后不算数咋办？”江成生说“那我们签合同”也就是这场偶然，让江成生和他的同行慢慢走上了一种新的模式。2008年，由潜山县彭河幸福茶场牵头，联合塔畈乡炳峰、观音洞、广西园等18家初制茶场、茶叶经纪人和1058户茶农自愿组成的茶叶专业合作经济组织。以加强诚信建设为重点，实行风险共担，利益共享，推行“专业合作社+龙头企业+专业大户”三位一体的茶叶产业化经营模式，采用订单农业方式，与广大茶农签订合同，公司对茶农进行二次返利，极大提高了农户发展茶叶的积极性。目前，加入该合作社的户数已达1200户。加入合作社的茶农人均茶叶纯收入达到4000元。近期，该合作社已申报省级龙头企业。\n" +
                "茶曲悠悠唱发展。为引导茶叶发展，潜山县政府每年安排茶业发展专项资金120\n" +
                "万，其中60万用于扶持茶叶基地建设、30万用于培育发展龙头企业、10万元用于茶叶技术培训和指导，对当年成片新发展茶园10亩、50亩、100亩以上，经验收合格，每亩以奖代补200元、300元、400元。奖补点燃了茶农的激情，至2012年，潜山县茶园面积增加到10.06万亩，无性系茶园面积增加到3.08万亩，全县130余家茶场通过更新改造，加工水平明显提高。取得qs认证的茶叶公司、茶厂22家，通过统一标准收购，统一工艺加工，名优茶质量稳中有升,茶叶销售均价达123.8元/公斤，最高价4400元/公斤，茶叶生产比较效益明显，成为茶农增收的亮点。\n"));
        list.add(new FupingBean("龙头企业引领养鸡户致富", "2022-05-02", R.mipmap.fuping2, "余井镇天圣村地区原先农户也有养鸡的传统，只是没有形成规模，处于家庭副业状态，再加上没有龙头企业作为市场经营主体的带动，畜禽产品的销路没有保证。作为“安庆市农业产业化龙头企业”，潜山县天胜农业生态科技发展有限公司本着“服务农民、富裕农民”的宗旨，坚持做到“四到户”服务，为广大养鸡养殖户提供全方位的优质服务。所谓“四到户”，即一是对养殖户实行送苗鸭和饲料到户。统一引进良种，该品种品系纯正，抗病力强，生长迅速，深受加工厂和广大消费者欢迎。二是技术服务到户。将自己掌握的养殖技术经验一家一户地传授到农民家中，确保养殖成功。三是防疫治病到户。将自己专门聘请的18名中高级技术人员负责技术服务、巡回咨询，及时到户解决养殖过程中的突出性技术问题，同时每月为社员讲授新知识，为养殖户提供可靠的技术保障。四是收购到户，挨家挨户上门收购。现金结算到户，销售由合作社安排。组织并指导周边村民科学养鸡、水产养殖和苗木种植。这种以公司为龙头，采取“统一品种，统一饲料，统一技术，统一销售”的方式，不断壮大专业合作组织，克服了一家一户小规模、低投入、低产出的小农经济局限性和对土地等资源过分依赖性。提高了农民进入市场的组织化程度，加快了现代农业发展进程。目前，随着专业合作社影响不断扩大，经济效益的不断增强，合作社成员由最初的104户增加到200户，另外辐射带动了本地及周边乡镇养鸭户500余户。从合作社成立至今，专业合作社通过合作社+农户紧密型合作方式，短短三四年时间，帮助120多户困难家庭摆脱了贫困。\n" +
                "阡陌交通，鸡犬相闻。为推进畜禽标准化生产，指挥部产业技术指导组成员深入乡村，按照省畜禽养殖技术规范的要求，引导养殖户、养殖小区按照标准化进行建设和改造，帮助建立并完善养殖档案，提高生产者质量标准意识和应用能力。中泰六和养殖有限公司、天胜农业生态科技发展有限公司被评为安庆市市级规模养殖示范场，为推进畜禽标准化生产起了带头示范作用。\n" +
                "至2012年，潜山县出栏生猪20.92万头，出栏家禽332万只，出栏肉牛0.41万头，禽蛋产量8420吨，肉类总产22620吨。同期相比分别增长：2.05%、8.85%、2%、4.1%、4.5%。畜禽生产基地建设稳步发展，目前全县已发展畜牧合作组织22家，入会会员1200多人。潜山\n" +
                "县绿色养殖有限公司、天柱鸭业有限公司分别新申报了市、省级龙头企业。\n" +
                "丘陵，油茶挂果累累。截止目前，全县已新建50亩以上成片油茶基地6.5万亩，已兑现奖补资金近1600万元。该县注重良种繁育和推广，加快繁育推广省认定的“皖潜1号”和“皖潜2号”油茶新品种，确保高品质油茶基地建设。狠抓重点项目、建设示范基地。全县油茶基地达万亩以上乡镇3个，千亩以上村10个，全县涌现油茶基地建设大户220余户，其中有千亩以上承包大户7个，已组建油茶专业合作社15个，2012年全县共完成油茶新造林11000亩，完成县级技术培训200人次，发放培训材料2000册。\n" +
                "圩区，瓜蒌架下话丰收。瓜蒌俗称野葫芦，潜山一带民间早有将瓜蒌籽炒制招待客人的习俗，但真正作为食品摆上桌面还是近十多年的事情。上世纪９０年代中期，该县农民李德祥等大胆提出了瓜蒌籽的食用性研究，在科研部门的支持下，该县对瓜蒌开发利用进行科技攻关，初步掌握了育种、栽培方法，这一技术填补了国内空白，从而开辟了瓜蒌产业的新天地。为发展瓜蒌种植，促进山乡致富，该县拿出百万元财政资金扶持种植大户，并相继建立了１０多个瓜蒌示范片。农业科技部门组织专家深入田间地头，指导农户生产。大力开展种苗繁育，推广换垄轮作、间作，土壤消毒技术，推广高密度栽培及地膜覆盖栽培技术。该县探索“公司＋基地＋农户”、“协会＋基地＋农户”的新路子，不断打造瓜蒌产业链。各瓜蒌公司以科研单位为技术依托，与瓜蒌农户签订生产合同，与超市签订购销协议，形成产学研、产加销一条龙。全县现有标准化生产基地近5万亩。瓜蒌产业农民经纪人百余人，农民瓜蒌种植专业合作社4个，痘姆新农生态农业合作社以瓜蒌种植为主，社员有200人，2011年被评为安庆市示范合作社。有2家企业获中国绿色食品发展中心a级证书。天柱山牌、传文牌瓜蒌籽荣获安徽省著名商标。近年来该县与南京野生植物利用研究院、合肥工业大学、安徽省农科院、安徽农业大学进行技术合作，培育出的“瓜蒌新品种“皖蒌6号”获县政府科技一等奖、获安徽省科技三等奖，2012年潜山县施行的瓜蒌种植保险，为保护农民利益筑起了一道防火墙。至目前，有半数种植户投保。\n" +
                "食用菌打开致富门。潜山县将食用菌产业列入重点扶持的农业特色产业，在各项激励政策推动下，目前，全县新增食用菌生产农户150户，新发展食用菌面积800亩（其中竹荪230亩）。全县从事食用菌生产的农户近600户，食用菌种植面积达600余亩。预计全年食用菌产值2600万元，菇农纯收入1200万元，户均增收2万元。\n" +
                "该县对新发展食用菌基地继续实行以奖代补，对种植香菇5亩以上的给予重点扶持，种植竹荪50亩以上给予每亩100元补助。对通过绿色认证或qs认证的龙头企业也给予适当奖励。目前，全县规模化基地18个，食用菌公司4家，合作社10家。各龙头企业推行“公司+基地+农户”的运作模式，发展订单生产，完善产供销服务体系，建立保鲜库收购。如水吼天宜菌业公司向农户提供菌棒和生产技术，并负责以保护价回收，有效规避了种植户的市场风险。\n"));

        caseRecyc.setAdapter(new FupingAdapter(this, list));
    }

    public void back(View view) {
        finish();
    }
}