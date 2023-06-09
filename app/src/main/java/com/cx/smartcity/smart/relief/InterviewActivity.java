package com.cx.smartcity.smart.relief;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.FupingBean;

import java.util.ArrayList;
import java.util.List;

public class InterviewActivity extends AppCompatActivity {
    private RecyclerView interviewRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);
        interviewRecyc = (RecyclerView) findViewById(R.id.interview_recyc);
        interviewRecyc.setLayoutManager(new LinearLayoutManager(this));
        List<FupingBean> list = new ArrayList<>();
        list.add(new FupingBean("汝南县板店乡：精准扶贫 入户走访暖人心", "2022-10-1", R.mipmap.fuping_banner2, "“最近家里情况怎么样，发展养殖业有没有困难.......”11月8日，汝南县板店乡党委书记王留印来到该乡刘营村脱贫户马忠于家走访，与马忠于夫妇亲切交谈。\n" +
                " \n" +
                "根据汝南县委县政府统一部署，板店乡组织乡、村干部对全乡14个行政村、2541户贫困户集中开展“大走访、大排查、大整改”活动，一句句关切的问候，一张张幸福的笑脸，一缕缕温暖的目光，无不在展现板店乡党群干群的融洽关系，让群众对打赢脱贫攻坚战、全面推进乡村振兴充满信心与期待。\n" +
                "“为确保此次走访取得实效，板店乡第一时间召开扶贫工作专题推进会，以发现问题、解决问题为导向，明确要求乡村干部务必家家走、户户到，扎扎实实做好这次入户走访排查工作。”板店乡乡长池红军介绍说。\n" +
                "此次走访，要求乡村干部围绕“一看、二问、三查”的基本内容进行逐项核实。\n" +
                " \n" +
                "在走访过程中，乡村干部每到一户都和贫困群众亲切交流，细心讲解扶贫政策，详细核查贫困户人均收入、义务教育、健康扶贫、住房保障、安全饮水、兜底保障、务工需求、扶贫满意度等情况，认真做好数据核查比对，对走访过程中发现的即知即改问题当场解决，其余问题做好记录。\n" +
                "入户走访只是“大走访、大排查、大整改”工作的第一步，走访过程中板店乡定期召开各村脱贫攻坚责任组组长、驻村第一书记、党支部书记参加的走访发现问题交办会和问题整改推进会，根据走访掌握的最新情况和排查出的问题和短板逐一分析研判，建立问题台账，有针对性地制定整改措施、明确责任人和整改期限，做到边走访边排查边整改，确保所有问题全部销号清零，工作短板全部补齐，织密脱贫“保障网”，力求让贫困群众真脱贫、脱真贫，切实巩固提升脱贫攻坚成果，确保如期打赢脱贫攻坚收官战。\n"));
        list.add(new FupingBean("精准扶贫零距离 入户走访暖人心", "2022-10-15", R.mipmap.fuping_banner3, "“最近生活怎么样啊？”“一年能挣多少钱”“家里有什么困难吗？”“孩子学习怎么样”……结对帮扶的贫困户家里情况怎么样，日子过得好不好，桩桩件件的小事，成了夏河县人民法院领导们心头的挂念。\n" +
                "        为进一步将精准扶贫工作落到实处，感知群众的冷暖，了解群众的心声，宣传党的帮扶政策，带着对困难群众的关心和牵挂，11月16日上午，夏河县人民法院党组书记、院长乔拉目前往夏河县阿木去乎镇牙利吉办事处，率领扶贫结对帮扶干部到精准扶贫户家中进行实地走访，开展入户走访慰问活动。牙利吉乡办事处负责人陪同走访。\n" +
                "    走访过程中，乔院长与贫困群众促膝长谈，嘘寒问暖，关切询问他们的收入情况、身体健康状况、遇到的困难和问题等，认真听取他们的愿望诉求，同时宣传国家的扶贫政策，并为他们送上米、面、油、水果等慰问品。鼓励他们坚定信心，在党和政府的关怀下，用双手勤劳致富，把日子过得更好!\n" +
                "         在贫困户家中，乔院长细心叮嘱老人：“现在的天气早晚温差大，您一定要多穿衣服，注意保暖啊！而且不要担心，党和国家的政策这么好，生活肯定会越过越好的！”\n" +
                "                \t 走访中，乔院长关切询问贫困户家中孩子们的学习情况，认真翻阅孩子的毕业证书和荣誉证书，鼓励孩子们认真复习，努力考取工作。贫困户拉着乔院长的手说：“谢谢党，谢谢政府，谢谢你们这么关心我们……”用朴实话语表达着自己的感激之情。\n" +
                "         入户走访慰问活动，在严冬为贫困群众送去了温暖和关怀，不仅进一步加强了结对帮扶双方的沟通和了解，同时加深了彼此之间的感情。夏河县人民法院将继续深入落实党的各项方针政策，创新法治扶贫，坚持巩固精准扶贫成果。充分发挥司法服务职能，着力依法审判，依法妥善审判涉及农民工工资、留守人员的医疗、教育等涉民生领域的案件，举全院之力，破冰前行，为全县打赢脱贫攻坚收官之战提供有力的司法保障，营造良好的法治环境。\n"));
        list.add(new FupingBean("【中院动态】芜湖中院：精准扶贫再发力 入户走访暖人心", "2022-10-19", R.mipmap.fuping_banner1, "10月17日\n" +
                "是我国第7个扶贫日\n" +
                "也是第28个国际消除贫困日\n" +
                "为切实为贫困群体提供有力保障，坚决打赢脱贫攻坚战，芜湖中院面向广大干警发起扶贫捐款活动并于10月20日上午，在院党组书记、院长胡敏带领下，院领导班子成员以及县处级领导干部来到无为市姚沟镇太白村开展扶贫帮扶、动态监测、双联系、捐款等工作。\n" +
                "慰问走访中，胡敏亲切询问了贫困户目前的生活、生产情况，了解脱贫及脱贫后的生活生产需求。在丁铮多家中，胡敏仔细询问了他目前的生产生活情况，关切地询问还有什么困难，同时还送上米、油等帮扶慰问物资。看到他新建的蔬菜园、养鸡棚以及孵鸡机器，看到丁铮多等家庭通过政府的帮扶，收入有了稳定来源，生活有了保障，胡敏感慨的说道：“看到你们的日子一天天好起来，我们是发自内心的感到高兴”。其他院领导班子成员分别看望了各自的帮扶户及联系户，关注他们的生活生产情况，送上慰问品。\n" +
                "  \n" +
                "随后，胡敏一行来到太白村部，看望慰问驻村扶贫工作队及村干部，深入了解乡村振兴、脱贫攻坚总体情况及存在的困难和需要解决的问题，对下一步工作提出指导意见和要求。\n" +
                "  \n" +
                "会上，院党组副书记、副院长丁必勇代表院党组将芜湖中院2020年“10.17”扶贫日捐款四万余元捐赠给太白村，为决战决胜脱贫攻坚再助力。\n"));
        list.add(new FupingBean("进村入户常走访 精准扶贫再行动", "2022-11-2", R.mipmap.fuping_banner4, "青春酒泉\n" +
                "有厚度 有温度\n" +
                "新时代青年新态度\n" +
                "为进一步扎实推进精准扶贫工作，10月29日,团市委书记肖文祥带领机关全体干部再次深入到玉门市独山子乡金旺村，开展贫困户入户调查走访活动。\n" +
                "由团市委领导班子成员带队，分成3个小组分别到金旺村三组、六组的11户联系贫困户家中进行入户走访。采取“一看、二问、三核”等方式，紧紧围绕“两不愁、三保障”工作内容，全面掌握贫困户详细数据，全面检视今年各项指标完成情况，确保各项扶贫政策措施落实落细，做到真脱贫、脱真贫。\n" +
                " \n" +
                "今年7月，帮扶户马十二巴的家人联系到团市委帮扶干部，反映家中失火的情况。团市委得知后第一时间联系村干部核实情况并积极联系相关保险理赔事宜。在此次入户走访中，肖文祥书记专门来到马十二巴的家中，详细询问了相关情况，并叮嘱他们一定要注意生产生活安全，提高防范意识，按照村委会要求做好房前屋后柴草清理，消除安全隐患。\n"));
        list.add(new FupingBean("【精准扶贫】市镇领导赴三垛镇督查精准扶贫工作并入户走访调查", "2022-12-3", R.mipmap.fuping5, "11月21日上午，市委常委、市政府党组成员、市委统战部部长杨文喜赴三垛镇南丰村督查精准扶贫工作，镇长王勋、政协工作召集人孙如标、副镇长左伍琴参加活动。\n" +
                "杨文喜一行首先查看了南丰村精准扶贫工作的村档户档资料，随后，走访了两户低收入农户，现场询问了其家庭收入情况和帮扶政策的享受情况。杨文喜要求，要将每一户帮扶贫困户核查到位，确保升级考核圆满过关。\n" +
                " \n" +
                "11月23日上午，政协工作召集人孙如标赴村督查精准扶贫工作，并入户走访调查帮扶贫困户情况，农业农村局局长吴静波、副局长陈高军陪同督查。\n" +
                " \n" +
                " \n" +
                "政协工作召集人孙如标一行先后来到林阳村、春生村、柳南村、柘垛村督查精准扶贫工作，主要检查低收入农户信息采集表，孙如标要求，要仔细核对采集表内容，保证内容的准确性；要入户帮扶，做好政策宣传和解释。\n"));

        interviewRecyc.setAdapter(new FupingAdapter(this, list,true));
    }

    public void back(View view) {
        finish();
    }

    public void add(View view) {
        startActivity(new Intent(this, InterviewMsgActivity.class));
    }
}