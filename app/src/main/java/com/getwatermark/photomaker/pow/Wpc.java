package com.getwatermark.photomaker.pow;

import android.app.Activity;
import android.os.Handler;

import org.json.JSONObject;

/**
 * @author Afra55
 * @date 2019-05-13
 * A smile is the best business card.
 * 注意，尽量在一个 Activity 使用
 */
public class Wpc {
    private static Wpc instance = null;
    private final String EXTRA_AD_UNIT_ID = "EXTRA_AD_UNIT_ID";

    private Wpc() {

    }

    public static Wpc getDefault() {
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
        if (instance == null) {
            synchronized (Wpc.class) {
                instance = new Wpc();
            }
        }
        return instance;
    }

    public static Wpc getFresh() {
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
        return new Wpc();
    }


    public interface NativeAdNetworkListener {
        void onNativeLoad();

        void onNativeFail();

        void onNativeLoading();
    }

    public interface MoPubNativeEventListener {
        void onImpression();

        void onClick();
    }

    private MoPubAdjustListener adjustListener;


    private boolean isDebugMode;
    private Activity activity;


    private Handler delayHandler;


    private NativeAdNetworkListener userAdNetworkListener;

    public MoPubAdjustListener getAdjustListener() {
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
        if (adjustListener == null) {
            adjustListener = new MoPubAdjustListener() {
                @Override
                public void showNativeAd(int entranceType) {

                }

                @Override
                public void loadNativeAd(int entranceType) {

                }
            };
        }
        return adjustListener;
    }

    public void setAdjustListener(MoPubAdjustListener adjustListener) {
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
        this.adjustListener = adjustListener;
    }

    public interface MoPubAdjustListener {

        /**
         * 原生广告有两个入口：1 下单成功，0 其他
         */
        void showNativeAd(int entranceType);

        void loadNativeAd(int entranceType);

    }


    private boolean checkNotOk() {
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
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }


    private boolean isNativeAdLoading;

    public void loadNativeAd(
            String adUnitId,
            int nativeAdListItem,
            int nativeMainImage,
            int adMobMainImage,
            int nativeIconImage,
            int nativeTitle,
            int nativeText,
            int nativePrivacyInformationIconImage,
            int callToActionId
    ) {
        if (checkNotOk()) {
            return;
        }
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

        if (isNativeAdLoading) {
            if (userAdNetworkListener != null) {
                userAdNetworkListener.onNativeLoading();
            }
            return;
        }

        isNativeAdLoading = true;

    }


}
