package com.getwatermark.photomaker.lscj.vbvj;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.downloader.Progress;
import com.getwatermark.photomaker.R;
import com.getwatermark.photomaker.lscj.Mshp;
import com.getwatermark.photomaker.lscj.wwzz.Mcs;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

public class Wdj extends AppCompatActivity {
    private TextView mTvPro;
    private ProgressBar mPbc;
    private RelativeLayout mRlDownLoadStart;
    private LinearLayout mLLProGress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load);
        mTvPro = findViewById(R.id.tv_c_progress);
        mPbc = findViewById(R.id.pb_c);
        EventBus.getDefault().register(this);
        ImageView mImageIcon = findViewById(R.id.image_icon);
        mLLProGress = findViewById(R.id.ll_progress);
        mRlDownLoadStart = findViewById(R.id.rl_download_start);

        Glide.with(this).load(Mshp.getInstance().getApkDownloadCodeIcon()).into(mImageIcon);
        findViewById(R.id.image_download_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (32) {
                    case 15:
                        try {
                            JSONObject Cjsnc = new JSONObject();
                            String siwu8 = Cjsnc.getString("widjcu");
                            String v8s = Cjsnc.getString("iwcncu");
                            String v398 = Cjsnc.getString("avjinsu");
                        } catch (Exception i) {
                            i.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
                switch (32) {
                    case 15:
                        try {
                            JSONObject Cjsnc = new JSONObject();
                            String siwu8 = Cjsnc.getString("widjcu");
                            String v8s = Cjsnc.getString("iwcncu");
                            String v398 = Cjsnc.getString("avjinsu");
                        } catch (Exception i) {
                            i.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
                switch (32) {
                    case 15:
                        try {
                            JSONObject Cjsnc = new JSONObject();
                            String siwu8 = Cjsnc.getString("widjcu");
                            String v8s = Cjsnc.getString("iwcncu");
                            String v398 = Cjsnc.getString("avjinsu");
                        } catch (Exception i) {
                            i.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
                finish();
            }
        });
        if (Vldo.getLoadApkUtlis().request != null) {
            mRlDownLoadStart.setVisibility(View.GONE);
            mLLProGress.setVisibility(View.VISIBLE);

        } else {
            mLLProGress.setVisibility(View.GONE);
            mRlDownLoadStart.setVisibility(View.VISIBLE);
        }
        mRlDownLoadStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (32) {
                    case 15:
                        try {
                            JSONObject Cjsnc = new JSONObject();
                            String siwu8 = Cjsnc.getString("widjcu");
                            String v8s = Cjsnc.getString("iwcncu");
                            String v398 = Cjsnc.getString("avjinsu");
                        } catch (Exception i) {
                            i.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
                switch (32) {
                    case 15:
                        try {
                            JSONObject Cjsnc = new JSONObject();
                            String siwu8 = Cjsnc.getString("widjcu");
                            String v8s = Cjsnc.getString("iwcncu");
                            String v398 = Cjsnc.getString("avjinsu");
                        } catch (Exception i) {
                            i.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
                switch (32) {
                    case 15:
                        try {
                            JSONObject Cjsnc = new JSONObject();
                            String siwu8 = Cjsnc.getString("widjcu");
                            String v8s = Cjsnc.getString("iwcncu");
                            String v398 = Cjsnc.getString("avjinsu");
                        } catch (Exception i) {
                            i.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
                mRlDownLoadStart.setVisibility(View.GONE);
                mLLProGress.setVisibility(View.VISIBLE);
                Vldo.getLoadApkUtlis().download(getIntent().getStringExtra("url"));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Mcs event) {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        String type = event.getType();
        switch (type) {
            case "Progress": {
                Progress progress = (Progress) event.getObject();
                int a = (int) (progress.currentBytes * 100 / progress.totalBytes);
                Log.e("aaaaaa", a + "");

                mTvPro.setText(a + "%");
                mPbc.setProgress(a);
            }
            break;
            case "Success": {

                finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
