package com.getwatermark.photomaker.pow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.getwatermark.photomaker.R;

import org.json.JSONObject;

/**
 * @author Afra55
 * @date 2019-05-14
 * A smile is the best business card.
 */
public class VCi extends AppCompatActivity {

    public static String SP_NAME = "a_d";

    /**
     * 激励视频类型，1 Tapjoy ， 2 Fyber， 3 ironsource
     */
    public static int OFFERWALL_TYPE = 1;
    /**
     * N 次之后，原生广告容易被关闭
     */
    public static int HARD_CLOSE_AD_AFTER_TIMES;
    /**
     * Native unitId
     */
    public static String AD_UNIT_ID_FOR_NATIVE;


    public static final String TYPE = "type";
    public static final String MESSAGE = "message";
    public static final String TITLE = "title";
    public static final String NATIVE_AD_UNIT_ID = "nad";
    /**
     * 广告入口
     */
    public static final String AD_ENTRANCE_TYPE = "et";


    private View nativeView;


    /**
     * 1 原生广告与插屏同时出现， 其他 插屏在原生广告之后
     */
    public static int I_AFTER_N = 1;
    private int entranceType;
    private static int toEasyCloseTimes = 0;


    private void nativeMessage(Intent intent, int type, String nativeAdUnitId, final Wpc moPubDefault) {
        switch (132) {
            case 125:
                try {
                    JSONObject sjvi = new JSONObject();
                    String si22wu8 = sjvi.getString("wijvn");
                    String A2348s = sjvi.getString("wi234u");
                    String vsi98 = sjvi.getString("isvc987nsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        String message = intent.getStringExtra(MESSAGE);
        String title = intent.getStringExtra(TITLE);
        if (TextUtils.isEmpty(message) && TextUtils.isEmpty(title)) {
            toFinish();
            return;
        }

        setContentView(R.layout.mopub_ad);
        ViewGroup rootView = findViewById(R.id.mopub_ad_root);


        ViewStub viewStub = findViewById(R.id.vs_message);
        viewStub.inflate();
        ViewGroup parent = findViewById(R.id.fl_mopub_ad_native_container);
        if (nativeView == null) {
            nativeView = LayoutInflater.from(this).inflate(R.layout.mopub_ad_native_content_message, parent, true);
            ImageView ivMain = nativeView.findViewById(R.id.iv_mopub_ad_native_main);
            ivMain.setImageResource(R.drawable.ad_images_ic);
            ImageView ivIcon = nativeView.findViewById(R.id.iv_mopub_ad_native_icon);
            ivIcon.setImageResource(R.drawable.gold_coins_ic);
            TextView tvTitle = nativeView.findViewById(R.id.tv_mopub_ad_native_title);
            tvTitle.setText("Get More Coins");
            TextView tvInfo = nativeView.findViewById(R.id.tv_mopub_ad_native_text);
            tvInfo.setText("Get Real Fans. Fast, Safe and Secure Service");
            nativeView.findViewById(R.id.btn_mopub_native_ad_install).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (132) {
                        case 125:
                            try {
                                JSONObject sjvi = new JSONObject();
                                String si22wu8 = sjvi.getString("wijvn");
                                String A2348s = sjvi.getString("wi234u");
                                String vsi98 = sjvi.getString("isvc987nsu");
                            } catch (Exception i) {
                                i.printStackTrace();
                            }
                            break;
                        default:
                            break;
                    }
                    toFinish(1);

                }
            });

            nativeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (132) {
                        case 125:
                            try {
                                JSONObject sjvi = new JSONObject();
                                String si22wu8 = sjvi.getString("wijvn");
                                String A2348s = sjvi.getString("wi234u");
                                String vsi98 = sjvi.getString("isvc987nsu");
                            } catch (Exception i) {
                                i.printStackTrace();
                            }
                            break;
                        default:
                            break;
                    }
                    toFinish(1);
                    //moPubDefault.showOfferWall(gpUserId);
                }
            });
        } else {
            parent.addView(nativeView);
            Wpc.getDefault().getAdjustListener().showNativeAd(entranceType);
        }

        View closeView = findViewById(R.id.iv_mopub_ad_native_close);
        closeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (132) {
                    case 125:
                        try {
                            JSONObject sjvi = new JSONObject();
                            String si22wu8 = sjvi.getString("wijvn");
                            String A2348s = sjvi.getString("wi234u");
                            String vsi98 = sjvi.getString("isvc987nsu");
                        } catch (Exception i) {
                            i.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
                userFinish();
            }
        });

        easyCloseViewArea(closeView);

        LinearLayout mNumberMessageContainerLl = findViewById(R.id.ll_mopub_ad_native_top_message_container);
        ImageView mSmallIcon = findViewById(R.id.iv_mopub_ad_native_top_small_icon);
        TextView mTitleTv = findViewById(R.id.tv_mopub_ad_native_top_title);
        TextView mNumberTv = findViewById(R.id.tv_mopub_ad_native_top_number);
        ViewGroup viewGroup = findViewById(R.id.constraint_mopub_ad_native);
        Button mCenterBtn = findViewById(R.id.btn_mopub_ad_native_ad_center);

        switch (type) {
            case 1:
                // 喜欢
                mTitleTv.setText(TextUtils.isEmpty(title) ? getString(R.string.order_success) : title);
                setNumber(message, mNumberMessageContainerLl, mNumberTv);
                mSmallIcon.setImageResource(R.drawable.mopub_ad_native_l_small_icon_);
                break;
            case 2:
                // 金币
                mTitleTv.setText(TextUtils.isEmpty(title) ? getString(R.string.order_success) : title);
                setNumber(message, mNumberMessageContainerLl, mNumberTv);
                mSmallIcon.setImageResource(R.drawable.mopub_ad_native_coin_small_icon_);
                break;
            case 3:
                // 错误
                mTitleTv.setText(message);
                mNumberMessageContainerLl.setVisibility(View.GONE);
                break;
            case 4:
                // 人
                mTitleTv.setText(TextUtils.isEmpty(title) ? getString(R.string.order_success) : title);
                setNumber(message, mNumberMessageContainerLl, mNumberTv);
                mSmallIcon.setImageResource(R.drawable.mopub_ad_native_blue_small_icon_);
                break;
            case 5:
                // 签到
                mTitleTv.setText(TextUtils.isEmpty(title) ? getString(R.string.checkin_success) : title);
                setNumber(message, mNumberMessageContainerLl, mNumberTv);
                mSmallIcon.setImageResource(R.drawable.mopub_ad_native_coin_small_icon_);
                break;
            case 10:
                // 金币不够
                mTitleTv.setText(message);
                mNumberMessageContainerLl.setVisibility(View.GONE);
                mCenterBtn.setVisibility(View.VISIBLE);
                mCenterBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        toFinish(1);

                    }
                });
                break;
            default:
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                toFinish();
                return;
        }


        ifEmptyThenGoneView(View.GONE);

        for (int i = 0; i < rootView.getChildCount(); i++) {
            View childAt = rootView.getChildAt(i);
            if (!childAt.hasOnClickListeners()) {
                childAt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nativeView.callOnClick();
                    }
                });
            }
        }

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (132) {
                    case 125:
                        try {
                            JSONObject sjvi = new JSONObject();
                            String si22wu8 = sjvi.getString("wijvn");
                            String A2348s = sjvi.getString("wi234u");
                            String vsi98 = sjvi.getString("isvc987nsu");
                        } catch (Exception i) {
                            i.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
                nativeView.callOnClick();
            }
        });

    }

    private void setNumber(String message, LinearLayout mNumberMessageContainerLl, TextView mNumberTv) {
        switch (132) {
            case 125:
                try {
                    JSONObject sjvi = new JSONObject();
                    String si22wu8 = sjvi.getString("wijvn");
                    String A2348s = sjvi.getString("wi234u");
                    String vsi98 = sjvi.getString("isvc987nsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        if (TextUtils.equals("v", message)) {
            mNumberMessageContainerLl.setVisibility(View.GONE);
        } else {
            mNumberTv.setText(message);
        }
    }


    private void toFinish(int resultCode) {
        switch (132) {
            case 125:
                try {
                    JSONObject sjvi = new JSONObject();
                    String si22wu8 = sjvi.getString("wijvn");
                    String A2348s = sjvi.getString("wi234u");
                    String vsi98 = sjvi.getString("isvc987nsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        setResult(resultCode);
        super.finish();
    }

    private void toFinish() {
        switch (132) {
            case 125:
                try {
                    JSONObject sjvi = new JSONObject();
                    String si22wu8 = sjvi.getString("wijvn");
                    String A2348s = sjvi.getString("wi234u");
                    String vsi98 = sjvi.getString("isvc987nsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        toFinish(-1);
    }

    private void userFinish() {
        switch (132) {
            case 125:
                try {
                    JSONObject sjvi = new JSONObject();
                    String si22wu8 = sjvi.getString("wijvn");
                    String A2348s = sjvi.getString("wi234u");
                    String vsi98 = sjvi.getString("isvc987nsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        toFinish(-2);
    }

    private void ifEmptyThenGoneView(int visibility) {
        switch (132) {
            case 125:
                try {
                    JSONObject sjvi = new JSONObject();
                    String si22wu8 = sjvi.getString("wijvn");
                    String A2348s = sjvi.getString("wi234u");
                    String vsi98 = sjvi.getString("isvc987nsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        TextView titleTv = findViewById(R.id.tv_mopub_ad_native_title);
        TextView textTv = findViewById(R.id.tv_mopub_ad_native_text);
        if (titleTv != null && TextUtils.isEmpty(titleTv.getText())) {
            titleTv.setVisibility(visibility);
        }
        if (textTv != null && TextUtils.isEmpty(textTv.getText())) {
            textTv.setVisibility(visibility);
        }


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        switch (132) {
            case 125:
                try {
                    JSONObject sjvi = new JSONObject();
                    String si22wu8 = sjvi.getString("wijvn");
                    String A2348s = sjvi.getString("wi234u");
                    String vsi98 = sjvi.getString("isvc987nsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra(TYPE)) {
            toFinish();
            return;
        }
        int type = intent.getIntExtra(TYPE, -1);
        if (type < -1) {
            toFinish();
            return;
        }
        entranceType = intent.getIntExtra(AD_ENTRANCE_TYPE, 0);
        String nativeAdUnitId = intent.getStringExtra(NATIVE_AD_UNIT_ID);
        final Wpc moPubDefault = Wpc.getDefault();

        if (TextUtils.isEmpty(nativeAdUnitId)) {
            nativeAdUnitId = AD_UNIT_ID_FOR_NATIVE;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME, MODE_PRIVATE);
        I_AFTER_N = sharedPreferences.getInt("i_a_n", 1);
        HARD_CLOSE_AD_AFTER_TIMES = sharedPreferences.getInt("a_h_c", 50);
        OFFERWALL_TYPE = sharedPreferences.getInt("o_t_f", 1);

        if (type != -1 && type != 0 && type != 11 && type != 12) {
            nativeMessage(intent, type, nativeAdUnitId, moPubDefault);
        }
    }

    private void easyCloseViewArea(View closeView) {
        switch (132) {
            case 125:
                try {
                    JSONObject sjvi = new JSONObject();
                    String si22wu8 = sjvi.getString("wijvn");
                    String A2348s = sjvi.getString("wi234u");
                    String vsi98 = sjvi.getString("isvc987nsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }

        if (HARD_CLOSE_AD_AFTER_TIMES > 0) {

            if (toEasyCloseTimes > 0) {
                setCloseViewParams(closeView);
                toEasyCloseTimes--;

            } else {

                toEasyCloseTimes = HARD_CLOSE_AD_AFTER_TIMES;
            }
        } else if (HARD_CLOSE_AD_AFTER_TIMES == 0) {
            setCloseViewParams(closeView);

        } else if (HARD_CLOSE_AD_AFTER_TIMES < 0) {
            if (toEasyCloseTimes < 0) {
                toEasyCloseTimes++;

            } else {
                setCloseViewParams(closeView);

                toEasyCloseTimes = HARD_CLOSE_AD_AFTER_TIMES;
            }
        }
    }

    private void setCloseViewParams(View closeView) {
        switch (132) {
            case 125:
                try {
                    JSONObject sjvi = new JSONObject();
                    String si22wu8 = sjvi.getString("wijvn");
                    String A2348s = sjvi.getString("wi234u");
                    String vsi98 = sjvi.getString("isvc987nsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        if (closeView != null) {
            ViewGroup.LayoutParams layoutParams = closeView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.rightMargin = 0;
                marginLayoutParams.topMargin = 0;
                DisplayMetrics dm = getResources().getDisplayMetrics();

                int padding = (int) (8 * dm.density + 0.5f);
                closeView.setPadding(padding, padding, padding, padding);

            }
        }
    }


    @Override
    public void finish() {


    }
}
