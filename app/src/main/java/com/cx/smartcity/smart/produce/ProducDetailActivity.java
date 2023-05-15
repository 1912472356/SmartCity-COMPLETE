package com.cx.smartcity.smart.produce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cx.smartcity.R;

public class ProducDetailActivity extends AppCompatActivity {
    private TextView title;
    private ImageView img;
    private TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produc_detail);

        title = (TextView) findViewById(R.id.title);
        img = (ImageView) findViewById(R.id.img);
        content = (TextView) findViewById(R.id.content);

        int id = getIntent().getIntExtra("id", 11);

        switch (id){
            case 1:
                title.setText("智慧边海防整体解决方案");
                img.setImageResource(R.mipmap.zhizao_res4);
                content.setText("智慧边海防整体解决方案则利用物联网、大数据、云计算、边缘计算、人工智能、移动互联网等新一代信息技术，构建基于陆、海、空、天并结合边民大众的五类立体化感知系统。将多种航天高性能、高质量和高可靠性的智能化装备应用到了海域防护方面。");
                break;
            case 2:
                title.setText("华为智慧园区解决方案");
                img.setImageResource(R.mipmap.zhizao_res5);
                content.setText("园区是工作与生活的载体，是经济发展的核心抓手，是构建万物互联的智能世界的落脚点。\n" +
                        "传统园区的信息化往往是孤立的烟囱式子系统建设，数据不互通，业务难融合，长期面临着服务体验差、综合安防弱、运营效率低、管理成本高、业务创新难等痛点。\n" +
                        "华为智慧园区解决方案源于自身管理变革和数字化转型实践，依托数字平台，联合生态伙伴，实现园区整体智慧化，使能业务创新，提升运营效率，引领至简体验。\n");
                break;
            case 3:
                title.setText("晶圆代工解决方案");
                img.setImageResource(R.mipmap.zhizao_res2);
                content.setText("中芯国际是一家纯晶圆代工厂，向全球客户提供0.35微米到14纳米8寸和12寸芯片代工与技术服务。中芯国际除高端的制造能力之外，还为客户提供全方位的晶圆代工解决方案，包括光罩制造、IP研发及后段辅助设计服务等一站式服务(包含凸块加工服务、晶圆探测，以及最终的封装、测试等)。全面一体的晶圆代工解决方案,目标是更有效的帮助客户降低成本,以缩短产品上市时间。 ");
                break;
        }
    }

    public void back(View view) {
        finish();
    }
}