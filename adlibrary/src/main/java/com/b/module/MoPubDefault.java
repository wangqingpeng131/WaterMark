package com.b.module;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Afra55
 * @date 2019-05-13
 * A smile is the best business card.
 * 注意，尽量在一个 Activity 使用
 */
public class MoPubDefault {
    private static MoPubDefault instance = null;
    private final String EXTRA_AD_UNIT_ID = "EXTRA_AD_UNIT_ID";
    private MoPubDefault() {

    }

    public static MoPubDefault getDefault() {
        if (instance == null) {
            synchronized (MoPubDefault.class) {
                instance = new MoPubDefault();
            }
        }
        return instance;
    }

    public static MoPubDefault getFresh() {
        return new MoPubDefault();
    }



    public interface NativeAdNetworkListener{
        void onNativeLoad();

        void onNativeFail();

        void onNativeLoading();
    }

    public interface MoPubNativeEventListener{
        void onImpression();

        void onClick();
    }

    private MoPubAdjustListener adjustListener;


    private boolean isDebugMode;
    private Activity activity;


    private Handler delayHandler;


    private NativeAdNetworkListener userAdNetworkListener;

    public MoPubAdjustListener getAdjustListener() {
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
        this.adjustListener = adjustListener;
    }

    public interface MoPubAdjustListener{

        /**
         * 原生广告有两个入口：1 下单成功，0 其他
         */
        void showNativeAd(int entranceType);
        void loadNativeAd(int entranceType);

    }







    private boolean checkNotOk() {
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

        if (isNativeAdLoading) {
            if (userAdNetworkListener != null) {
                userAdNetworkListener.onNativeLoading();
            }
            return;
        }

        isNativeAdLoading = true;

    }









}
