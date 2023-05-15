package com.cx.smartcity.smart.produce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cx.smartcity.R;

public class FacDetailActivity extends AppCompatActivity {
    private TextView title;
    private ImageView img;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fac_detail);
        int id = getIntent().getIntExtra("id", 11);

        title = (TextView) findViewById(R.id.title);
        img = (ImageView) findViewById(R.id.img);
        content = (TextView) findViewById(R.id.content);

        switch (id){
            case 1:
                title.setText("中国航天");
                img.setImageResource(R.mipmap.zhizao_res1);
                content.setText("中国航天科技集团有限公司是中国航天科技工业的主导力量，主要从事运载火箭、各类卫星、载人飞船、货运飞船、深空探测器、空间站等宇航产品和战略、战术导弹武器系统的研究、设计、生产、试验和发射服务。中国航天科技集团有限公司也是中国唯一的洲际战略核导弹研制生产单位。");
                break;
            case 2:
                title.setText("华为");
                img.setImageResource(R.mipmap.zhizao_res2);
                content.setText("华为消费者业务产品全面覆盖手机、移动宽带终端、终端云等，凭借自身的全球化网络优势、全球化运营能力，致力于将最新的科技带给消费者，让世界各地享受到技术进步的喜悦，以行践言，实现梦想。");
                break;
            case 3:
                title.setText("中芯科技");
                img.setImageResource(R.mipmap.zhizao_res3);
                content.setText("中芯国际（证券代码：00981.HK/688981.SH）是世界领先的集成电路晶圆代工企业之一，也是中国大陆集成电路制造业领导者，拥有领先的工艺制造能力、产能优势、服务配套，向全球客户提供0.35微米到14纳米不同技术节点的晶圆代工与技术服务。中芯国际总部位于中国上海，拥有全球化的制造和服务基地，在上海、北京、天津、深圳建有三座8吋晶圆厂和三座12吋晶圆厂；在上海、北京、深圳各有一座12吋晶圆厂在建中。中芯国际还在美国、欧洲、日本和中国台湾设立营销办事处、提供客户服务，同时在中国香港设立了代表处。");
                break;
        }
    }

    public void back(View view) {
        finish();
    }
}