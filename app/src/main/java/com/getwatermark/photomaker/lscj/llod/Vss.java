package com.getwatermark.photomaker.lscj.llod;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.getwatermark.photomaker.R;
import com.getwatermark.photomaker.lscj.Pu;
import com.getwatermark.photomaker.lscj.wwzz.Ecjs;
import com.getwatermark.photomaker.lscj.wwzz.Mcs;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/**
 * @author Afra55
 * @date 2019/4/22
 * A smile is the best business card.
 */
public class Vss extends AppCompatActivity {

    public static final String AU = "au";
    private String ing;
    private String low;
    private String string;

    public static void start(Context context) {
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
        context.startActivity(new Intent(context, Vss.class));
    }

    private TextView mProgressTv;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v_c);
        mProgressTv = findViewById(R.id.tv_c_progress);
        progressBar = findViewById(R.id.pb_c);
        setStatusBarColor(getResources().getColor(R.color.v_c_status_bar));

        findViewById(R.id.iv_c_back).setOnClickListener(new View.OnClickListener() {
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
                onBackPressed();
            }
        });

        TextView title = findViewById(R.id.tv_c_title);
        TextView info1 = findViewById(R.id.tv_c_info_1);
        String nch = "nch";
        ing = "ing";
        info1.setText("L" + AU + nch + ing + "");
        TextView info2 = findViewById(R.id.tv_c_info_2);
        String ke = "ke";
        String s = "s a";
        String s1 = "nd ";
        String fol = "Fol";
        String ers = "ers";
        String s2 = " On";
        low = "low";
        String way = "Way";
        string = " The ";
        info2.setText("Li" + ke + s + s1 + fol + low + ers + s2 + string + way + "...");

        EventBus.getDefault().register(this);
    }

    protected void setStatusBarColor(@ColorInt int color) {

        switch (8) {
            case 9:
                try {
                    JSONObject jsonObject9 = new JSONObject();
                    String date9 = jsonObject9.getString("date");
                    String xxx9 = jsonObject9.getString("xxxForNewYear");
                    String vvvOid9 = jsonObject9.getString("iopForOldYear");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    private ValueAnimator valueAnimator;
    private int currentValue;

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
        try {
            String type = event.getType();
            if (TextUtils.equals(type, Ecjs.s2)) {
                Object object = event.getObject();
                int p = (int) object;
                try {
                    progressBar.setProgress(p);
                    mProgressTv.setText(p + "%");
                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else if (TextUtils.equals(type, Ecjs.s3)) {


                Pu.getInstance().sPunoPuiow(this);
                super.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        try {
            if (valueAnimator != null) {
                valueAnimator.cancel();
                valueAnimator = null;
            }
            if (EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().unregister(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }


}
