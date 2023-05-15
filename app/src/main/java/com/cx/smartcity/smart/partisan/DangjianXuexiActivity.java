package com.cx.smartcity.smart.partisan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.Voice;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.ShequYoulingBean;
import com.cx.smartcity.smart.community.SimpleCommentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DangjianXuexiActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private CardView card1;
    private VideoView videoView1;
    private RecyclerView commentRecyc1;
    private SearchView commentEt1;
    private CardView card2;
    private VideoView videoView2;
    private RecyclerView commentRecyc2;
    private SearchView commentEt2;
    private CardView card3;
    private Button playBtn3;
    private RecyclerView commentRecyc3;
    private SearchView commentEt3;

    MediaPlayer player;

    List<ShequYoulingBean.SimpleCommentBean> commentList[] = new ArrayList[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangjian_xuexi);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        card1 = (CardView) findViewById(R.id.card1);
        videoView1 = (VideoView) findViewById(R.id.video_view1);
        commentRecyc1 = (RecyclerView) findViewById(R.id.comment_recyc_1);
        commentEt1 = (SearchView) findViewById(R.id.comment_et_1);
        card2 = (CardView) findViewById(R.id.card2);
        videoView2 = (VideoView) findViewById(R.id.video_view2);
        commentRecyc2 = (RecyclerView) findViewById(R.id.comment_recyc_2);
        commentEt2 = (SearchView) findViewById(R.id.comment_et_2);
        card3 = (CardView) findViewById(R.id.card3);
        playBtn3 = (Button) findViewById(R.id.play_btn3);
        commentRecyc3 = (RecyclerView) findViewById(R.id.comment_recyc_3);
        commentEt3 = (SearchView) findViewById(R.id.comment_et_3);


        initComment();
        initTab();
        initVideo();
    }

    private void initVideo() {
        videoView1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/raw/"+R.raw.video01));
        videoView1.setMediaController(new MediaController(this));
        videoView2.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/raw/"+R.raw.video02));
        videoView2.setMediaController(new MediaController(this));
        player = MediaPlayer.create(DangjianXuexiActivity.this, R.raw.music);
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

                setListener();
            }
        });
        setListener();
    }

    private void setListener() {
        playBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!player.isPlaying()){
                    playBtn3.setText("暂停播放");
                    player.start();
                }else{
                    playBtn3.setText("播放音频");
                    player.pause();
                }

            }
        });
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                player.stop();
                player.release();
                player = MediaPlayer.create(DangjianXuexiActivity.this, R.raw.music);
                playBtn3.setText("播放音频");
            }
        });
    }

    private void initTab() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    card1.setVisibility(View.VISIBLE);
                    card2.setVisibility(View.VISIBLE);
                    card3.setVisibility(View.VISIBLE);
                }else {
                    card1.setVisibility(View.GONE);
                    card2.setVisibility(View.GONE);
                    card3.setVisibility(View.GONE);

                    switch (tab.getPosition()){
                        case 1:
                            card1.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            card2.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            card3.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initComment() {
        commentList[0] = new ArrayList<>();
        commentList[1] = new ArrayList<>();
        commentList[2] = new ArrayList<>();

        commentRecyc1.setLayoutManager(new LinearLayoutManager(this));
        commentRecyc2.setLayoutManager(new LinearLayoutManager(this));
        commentRecyc3.setLayoutManager(new LinearLayoutManager(this));

        commentEt1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                comment(query, 0);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        commentEt2.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                comment(query, 1);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        commentEt3.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                comment(query, 2);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void comment(String query, int i) {
        commentList[i].add(new ShequYoulingBean.SimpleCommentBean("评论用户", query));
        loadCommnetAda();
    }

    private void loadCommnetAda() {
        commentRecyc1.setAdapter(new SimpleCommentAdapter(this, commentList[0]));
        commentRecyc2.setAdapter(new SimpleCommentAdapter(this, commentList[1]));
        commentRecyc3.setAdapter(new SimpleCommentAdapter(this, commentList[2]));
    }
    public void back(View view) {
        finish();
    }
}