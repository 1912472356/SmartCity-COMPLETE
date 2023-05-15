package com.cx.smartcity.smart.relief;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.FupingBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class FupingActivity extends AppCompatActivity implements View.OnClickListener {
    private Banner banner;
    private LinearLayout reliefCase;
    private LinearLayout village;
    private LinearLayout help;
    private LinearLayout interview;
    private LinearLayout casePub;
    private RecyclerView newsRecyc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuping);

        banner = (Banner) findViewById(R.id.banner);
        reliefCase = (LinearLayout) findViewById(R.id.relief_case);
        village = (LinearLayout) findViewById(R.id.village);
        help = (LinearLayout) findViewById(R.id.help);
        interview = (LinearLayout) findViewById(R.id.interview);
        casePub = (LinearLayout) findViewById(R.id.case_pub);
        newsRecyc = (RecyclerView) findViewById(R.id.news_recyc);

        initBanner();
        reliefCase.setOnClickListener(this);
        village.setOnClickListener(this);
        help.setOnClickListener(this);
        interview.setOnClickListener(this);
        casePub.setOnClickListener(this);
        initNews();
    }

    private void initNews() {
        newsRecyc.setLayoutManager(new LinearLayoutManager(this));
        List<FupingBean> list = new ArrayList<>();
        list.add(new FupingBean("致力于农村基础设施建设，瑞因智控获百万级别种子轮投资", "2020-01-01", R.mipmap.fuping1, "农业装备研发新星黑龙江瑞因智控科技有限公司完成种子轮融资，投资额度数百万元投资方系杭州某电子商务有限公司。\n" +
                "瑞因智控科技是一家致力于农村基础设施建设，提供科技创新型节能减排产品的创业公司。其产品研发与各地方政府政策相适应，以“精准扶贫”作为核心内容，基于电子信息智控技术，帮助农村中小型养殖中心达到低耗、低污染的生产效果。在科技创新方面，据查，公司拥有软件著作权一项，专利受理两项，其研发产品曾获节能减排大赛二等奖，具有长期研发价值。\n" +
                "根据官方提供的数据，瑞因科技已在浙江省获得第一批机器订单，其产品本身直接响应当地“五水共治”号召，为养殖业污物处理提供了对应的解决方案。“农业的发展离不开政府的支持。”在农业发达的美国、日本，政府补贴达到40%以上。相比之下，我国的农业补贴虽只占20%左右，但仍不断上涨。1月29日，国务院办公厅印发《关于推进农业高新技术产业示范区建设发展的指导意见》，首次以农业高新技术产业为主题,明确到2025年,要布局建设一批国家农业高新技术产业示范区。\n"));
        list.add(new FupingBean("开阳信息锁进：饮水思源，精准扶贫", "2020-02-01", R.mipmap.fuping2, "近日，秦峰镇新塘村村民委员会为感谢锁进先生为秦峰镇新塘村的扶贫事业做出的杰出贡献，特聘锁进先生为新塘村的“名誉村主任”。锁进先生是江西渝网科技股份有限公司董事长，上饶开阳即渝网旗下全资子公司，此前一直专注于扶贫事业，经商的同时不忘回馈社会，积极履行应尽的社会责任，呼吁更多社会人士共同营造互相关心、互相帮助、互相支持的良好社会氛围。"));
        list.add(new FupingBean("常德联通：精准扶贫暖人心 感恩帮扶送锦旗", "2020-03-01", R.mipmap.fuping3, "“吃饭莫忘种田人，吃水不忘挖井人，非常感谢常德联通驻村工作队人员的辛勤付出”。近日，常德汉寿县洞庭村村委一行5人，将一面写有“联通扶贫用真情 洞庭人民永记心”的锦旗专程送到常德联通，党委委员周海华同志代表全体党员干部接收了锦旗，并与村支两委、扶贫工作队共同回顾了2020年帮扶工作，对2021年推进脱贫攻坚与乡村振兴有效衔接交流了意见和建议。\n" +
                " \n" +
                "汉寿县洞庭村村委一行送来锦旗。\n" +
                "常德联通一直以来都冲锋在脱贫攻坚的第一线，以“真扶贫、扶真贫”为原则，注重帮扶实效，成立以党委书记为第一责任人的帮扶领导小组，零距离开展帮扶工作。党员干部多次到村入户进行调研、走访、慰问，深入了解贫困户的家庭情况、致贫原因，多次召开党委会研究发展和资金投入，安排得力干部周训金同志加入驻村工作队，为帮扶责任村汉寿县周家村的脱贫攻坚做出应有的贡献。\n" +
                "近年来，常德联通共向挂钩帮扶村和贫困户拨付款项近百万元，用于支持村委道路建设、文体广场修建、平安监控安装、环境卫生整治等，帮助全村主干道清除淤泥8KM, 让62户238人稳定脱贫，贫困人口实现全部脱贫，错评错退率实现0%，群众满意度达到了100%，脱贫攻坚工作取得决定性成效。\n" +
                "一面锦旗凝聚着一片真情，是一份认可，一份信赖，更是一份责任。常德联通主要负责人表示：“锦旗承载着村民们的感激与信任，我们将以更高的标准、更实的行动、更大的热情推进为乡村振兴工作，为群众办好事、办实事。\n"));
        newsRecyc.setAdapter(new FupingAdapter(this, list));
    }

    private void initBanner() {
        List<Integer> arr = new ArrayList<>();
        arr.add(R.mipmap.fuping_banner1);
        arr.add(R.mipmap.fuping_banner2);
        arr.add(R.mipmap.fuping_banner3);
        arr.add(R.mipmap.fuping_banner4);
        arr.add(R.mipmap.fuping_banner5);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                imageView.setImageResource((Integer) o);
            }
        });
        banner.setImages(arr);
        banner.start();
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.relief_case:
                startActivity(new Intent(this, ReliefCaseActivity.class));
                break;
            case R.id.village:
                startActivity(new Intent(this, VillageActivity.class));
                break;
            case R.id.help:
                startActivity(new Intent(this, HelpActivity.class));
                break;
            case R.id.interview:
                startActivity(new Intent(this, InterviewActivity.class));
                break;
            case R.id.case_pub:
                startActivity(new Intent(this, CasePubActivity.class));
                break;
        }
    }
}