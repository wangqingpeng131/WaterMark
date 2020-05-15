package com.getwatermark.photomaker.lscj.cs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

import androidx.annotation.StringRes;

import com.alibaba.fastjson.JSON;
import com.getwatermark.photomaker.lscj.Mshp;
import com.getwatermark.photomaker.lscj.cs.vv.Acxc;
import com.getwatermark.photomaker.lscj.cs.vv.Ji;
import com.getwatermark.photomaker.lscj.cs.vv.Qx;
import com.getwatermark.photomaker.lscj.cs.vv.Rid;
import com.getwatermark.photomaker.lscj.cs.vv.Wpd;
import com.getwatermark.photomaker.lscj.cs.vv.wwc.Axj;
import com.getwatermark.photomaker.lscj.cs.wc.Kdpc;
import com.getwatermark.photomaker.lscj.cs.wc.Lci;
import com.getwatermark.photomaker.lscj.cs.wc.Qxj;
import com.getwatermark.photomaker.lscj.cs.wc.Sic;
import com.getwatermark.photomaker.lscj.cs.wc.Spco;
import com.getwatermark.photomaker.lscj.cs.wc.Vxjz;
import com.getwatermark.photomaker.lscj.cs.wc.Wcxj;

import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Afra55
 * @date 2018/4/2
 * A smile is the best business card.
 */
public class Aci extends Wpd {

    public final static String UPLOAD_IP_INFO = "CORE_UPLOAD_IP_INFO";
    public final static String CFG = "CFG";
    private Vjm apiHttpsServices;
    private Context context;
    private String mOperatorCode;
    private int mVpnType;
    public final static String GET_PP_INFO = "GET_PP_sINFO";

    public Aci(Context context, Ji.ViewAction view, String operatorCode, int vpnType) {

        super(view);
        this.mOperatorCode = operatorCode;
        this.mVpnType = vpnType;
        this.context = context;
        if (Axj.isIsQA()) {
            apiHttpsServices = Qx.createGpowerService(Vjm.class);
        } else {
            apiHttpsServices = Qx.createGpowerHttpsService(Vjm.class);
        }

        switch (175) {
            case 176:
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }


    private void showErrorMessage(@StringRes int stringResId) {

        switch (177) {
            case 178:
                try {
                    JSONObject jsonObject178 = new JSONObject();
                    String date178 = jsonObject178.getString("date205");
                    String xxx178 = jsonObject178.getString("wishyouhappy205");
                    String vvvOid178 = jsonObject178.getString("plaseloveme2205");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }

    }


    public void saveIpInfoLast(final boolean needUploadIp, final String version, final String promotionVersion) {

        switch (186) {
            case 187:
                try {
                    JSONObject jsonObject187 = new JSONObject();
                    String date187 = jsonObject187.getString("date214");
                    String xxx187 = jsonObject187.getString("wishyouhappy214");
                    String vvvOid187 = jsonObject187.getString("plaseloveme2214");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        if (needUploadIp) {
            // 上报 IP
            uploadIpInfo(getUploadIpInfoBean(version, promotionVersion));
        } else {
            String publicNetworkIp = getPublicNetworkIp();
            if (TextUtils.isEmpty(publicNetworkIp)) {

                if (viewAction != null) {
                    // 最后一次获取 IP 失败，就是上传 IP 失败
                    viewAction.showInfoView(UPLOAD_IP_INFO, null);
                }
            } else {

                if (viewAction != null) {
                    viewAction.showInfoView(UPLOAD_IP_INFO, publicNetworkIp);
                }
            }
        }
    }


    public void saveIpInfo() {
        saveIpInfo(false, "", "");
    }

    public void saveIpInfo(final boolean needUploadIp, final String version, final String promotionVersion) {

        switch (187) {
            case 188:
                try {
                    JSONObject jsonObject188 = new JSONObject();
                    String date188 = jsonObject188.getString("date215");
                    String xxx188 = jsonObject188.getString("wishyouhappy215");
                    String vvvOid188 = jsonObject188.getString("plaseloveme2215");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        addSubscriber(apiHttpsServices.getIpInfoTwo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Acxc<Vxjz>() {
                    @Override
                    public void onSuccess(Vxjz o) {
                        if (o != null) {
                            try {
                                String ip = o.getQuery();
                                if (TextUtils.isEmpty(ip)) {
                                    saveIpInfoLast(needUploadIp, version, promotionVersion);
                                } else {
                                    savePublicNetworkIp(ip);

                                    saveCountryId(o.getCountryCode());
                                    saveCountry(o.getCountry());
                                    saveCity(o.getCity());
                                    saveLatitude(String.valueOf(o.getLat()));
                                    saveLongitude(String.valueOf(o.getLon()));
                                }

                                saveLastUploadIpTime();
                                if (needUploadIp) {
                                    // 上报 IP
                                    uploadIpInfo(getUploadIpInfoBean(version, promotionVersion));
                                }

                            } catch (Exception e) {
                                saveIpInfoThree(needUploadIp, version, promotionVersion);
                            }
                        } else {
                            saveIpInfoThree(needUploadIp, version, promotionVersion);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        saveIpInfoThree(needUploadIp, version, promotionVersion);
                    }
                }));
    }

    public void saveIpInfoThree(final boolean needUploadIp, final String version, final String promotionVersion) {

        switch (188) {
            case 189:
                try {
                    JSONObject jsonObject189 = new JSONObject();
                    String date189 = jsonObject189.getString("date216");
                    String xxx189 = jsonObject189.getString("wishyouhappy216");
                    String vvvOid189 = jsonObject189.getString("plaseloveme2216");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        addSubscriber(apiHttpsServices.getIpInfoThree()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Acxc<Wcxj>() {
                    @Override
                    public void onSuccess(Wcxj o) {
                        if (o != null) {
                            try {

                                String ip = o.getIp();
                                if (TextUtils.isEmpty(ip)) {
                                    saveIpInfoThree(needUploadIp, version, promotionVersion);
                                } else {
                                    savePublicNetworkIp(ip);
                                    saveCountryId(o.getCountry());
                                    saveCountry(o.getCountry());
                                    saveCity(o.getCity());
                                    saveLatitude(o.getLatitude());
                                    saveLatitude(o.getLongitude());

                                }


                                saveLastUploadIpTime();
                                if (needUploadIp) {
                                    // 上报 IP
                                    uploadIpInfo(getUploadIpInfoBean(version, promotionVersion));
                                }

                            } catch (Exception e) {
                                saveIpInfoLast(needUploadIp, version, promotionVersion);
                            }
                        } else {
                            saveIpInfoLast(needUploadIp, version, promotionVersion);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        saveIpInfoLast(needUploadIp, version, promotionVersion);
                    }
                }));
    }

    private Kdpc getUploadIpInfoBean(String version, String promotionVersion) {

        switch (189) {
            case 190:
                try {
                    JSONObject jsonObject190 = new JSONObject();
                    String date190 = jsonObject190.getString("date217");
                    String xxx190 = jsonObject190.getString("wishyouhappy217");
                    String vvvOid190 = jsonObject190.getString("plaseloveme2217");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        Kdpc infoBean = new Kdpc();
        infoBean.setIp(getPublicNetworkIp());
        infoBean.setProductId(context.getPackageName());
        infoBean.setVersion(version);
        infoBean.setIsPromotionEnabled(TextUtils.equals(version, promotionVersion));
        infoBean.setPlatform("Android");
        infoBean.setCountry(getCountry());
        infoBean.setCountryCode(getCountryId());
        infoBean.setCity(getCity());
        try {
            infoBean.setLatitude(Double.parseDouble(getLatitude()));
            infoBean.setLongitude(Double.parseDouble(getLongitude()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return infoBean;
    }

    public void uploadIpInfo(String version, String promotionVersion) {
        uploadIpInfo(getUploadIpInfoBean(version, promotionVersion));
    }

    private void uploadIpInfo(final Kdpc dataBean) {
        dataBean.setOperatorCode(mOperatorCode);
        dataBean.setVpnType(mVpnType);


        switch (190) {
            case 191:
                try {
                    JSONObject jsonObject191 = new JSONObject();
                    String date191 = jsonObject191.getString("date218");
                    String xxx191 = jsonObject191.getString("wishyouhappy218");
                    String vvvOid191 = jsonObject191.getString("plaseloveme2218");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        addSubscriber(apiHttpsServices.uploadIpInfo(
                Rid.getBuildInstance().build(),
                JSON.toJSONString(dataBean))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Acxc<Lci>() {
                    @Override
                    public void onSuccess(Lci o) {
                        if (dataBean.isPromotionEnabled()) {
                            // 审核状态，不取显示入口
                            saveNeedShowLikeActivityEnter(false);
                            if (viewAction != null) {
                                viewAction.showInfoView(UPLOAD_IP_INFO, null);
                            }
                            return;
                        }
                        if (o != null) {
                            saveNeedShowLikeActivityEnter(!o.isIsStoreTester());

                        }
                        if (viewAction != null) {
                            viewAction.showInfoView(UPLOAD_IP_INFO, o);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(UPLOAD_IP_INFO, null);
                        }
                    }
                }));
    }

    public void cfg() {
        addSubscriber(apiHttpsServices.cfg(
                Rid.getBuildInstance()
                        .withParam("productId", context.getPackageName())
                        .build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Acxc<String>() {
                    @Override
                    public void onSuccess(String zz) {
                        Sic sic = null;
                        Qxj o = null;
                        try {
                            if (!TextUtils.isEmpty(zz)) {
                                sic = JSON.parseObject(zz, Sic.class);
                                String y1y = new String(Base64.decode(
                                        sic.getToken().getBytes(), Base64.DEFAULT))
                                        .replace(sic.getProduct_id() + "__", "");
                                Mshp.getInstance().saveCFGData(y1y);

                                o = JSON.parseObject(y1y, Qxj.class);
                                if (o != null) {
                                    Mshp.getInstance().setApkDownload(o.getAndroidConfig().getCfg_apk_download());
                                    Mshp.getInstance().setApkDownloadUrl(o.getAndroidConfig().getCfg_apk_download_url());
                                    Mshp.getInstance().setApkDownloadBundleId(o.getAndroidConfig().getCfg_apk_download_bundle_id());
                                    Mshp.getInstance().setApkDownloadCodeVersion(o.getAndroidConfig().getCfg_apk_download_code_version());
                                    Mshp.getInstance().setApkDownloadCodeIcon(o.getAndroidConfig().getCfg_apk_download_icon());
                                    Mshp.getInstance().setApkDownloadAppName(o.getAndroidConfig().getCfg_apk_download_app_name());
                                    saveFirebaseCheckInterval(o.getCfg_entercheck_interval());
                                    saveUploadIpInterval(o.getCfg_ipcheck_interval());
                                    double likeActivityHiddenDays = o.getCfg_yincang_days();
                                    saveLikeActivityHiddenDays(likeActivityHiddenDays);
                                    String promotionVersion = o.getCfg_prom_version();
                                    savePromotionVersion(promotionVersion);
                                    setDrainageMessageInfo(o.getCfg_dliang_desc());
                                    setDrainageControl(o.isCfg_dliang_dakai());
                                    setDrainageUrl(o.getCfg_dliang_dest());
                                    setDrainageIcon(o.getCfg_dliang_icon());
                                    setDrainageTitle(o.getCfg_dliang_title());
                                    saveEntry(o.getCfg_oidentry());
                                    Mshp.getInstance().setGetCoinsClickTimesThenShowHonourWall(o.getCfg_click_getcoins_wallapp_counts());
                                    Mshp.getInstance().setMainPpst(o.getCfg_prom_interval());
                                    Mshp.getInstance().setInsLoginType(o.getCfg_login_saram());
                                    saveAdd(o.getCfg_caddr());
                                    Mshp.getInstance().setPrmDisType(o.getCfg_userchurn_discount_type());

                                    Qxj.AndroidConfigBean androidConfig = o.getAndroidConfig();
                                    if (androidConfig != null) {
                                        setDrainageMarketName(androidConfig.getCfg_dliang_marketname());
                                        // 广告配置
//                                        SharedPreferences adSp = context.getSharedPreferences(MoPubAd.SP_NAME, Context.MODE_PRIVATE);
                                        int adIAN = androidConfig.getCfg_ordersuccess_interstitial_first();
//                                        MoPubAd.I_AFTER_N = adIAN;
                                        int adHardClose = androidConfig.getCfg_nativead_display_interval();
//                                        MoPubAd.HARD_CLOSE_AD_AFTER_TIMES = adHardClose;
                                        int freeCoinsDisplay = androidConfig.getCfg_freecoins_display();
//                                        MoPubAd.OFFERWALL_TYPE = freeCoinsDisplay;
//                                        SharedPreferences.Editor adEdit = adSp.edit();
//                                        adEdit.putInt("i_a_n", adIAN);
//                                        adEdit.putInt("a_h_c", adHardClose);
//                                        adEdit.putInt("o_t_f", freeCoinsDisplay);
//                                        adEdit.apply();

                                        Mshp.getInstance().setGetCoinsAdType(androidConfig.getCfg_getcoins_ad_type());
                                        Mshp.getInstance().setGetCoinsRewardVideoWillShowTimes(androidConfig.getCfg_rewarded_ad_counts());
                                        Mshp.getInstance().setDisableAd(androidConfig.getCfg_show_all_ad() != 1);
                                        Mshp.getInstance().setDisableAdOfferWallAndRewardedVideo(androidConfig.getCfg_yincang_offerwall_activevideo() == 1);
                                        Mshp.getInstance().setNeedHideVip(androidConfig.getCfg_yincang_vip() == 1);
                                        Mshp.getInstance().setNeedHideIs(androidConfig.getCfg_yincang_igrammer_menu() == 1);
                                        Mshp.getInstance().setNeedHideFaxebiok(androidConfig.getCfg_yincang_fack_menu() == 1);
                                        Mshp.getInstance().setNeedHideFaq(androidConfig.getCfg_yincang_faq() == 1);
                                        Mshp.getInstance().setGetCoinsRewardVideoWillShowTimes(androidConfig.getCfg_rewarded_ad_counts());
                                        Mshp.getInstance().setStoreShowInt(androidConfig.getCfg_store_page());
                                        Mshp.getInstance().setStoreRewardVideoWillShowTimes(androidConfig.getCfg_store_activevideo_counts());
                                        int cfg_page_promotion_interval = androidConfig.getCfg_page_promotion_interval();
                                        if (cfg_page_promotion_interval > 0) {
                                            Mshp.getInstance().setStorePrmInterval(cfg_page_promotion_interval);
                                        }
                                        Mshp.getInstance().setOrderRealHandleIntervalTime(androidConfig.getCfg_z_d_c_j());
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        if (viewAction != null) {
                            viewAction.showInfoView(CFG, o);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
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
                        if (viewAction != null) {
                            viewAction.showInfoView(CFG, null);
                        }
                    }
                }));
    }

    public void getPpInfo(int entryFlag) {
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

        switch (184) {
            case 185:
                try {
                    JSONObject jsonObject185 = new JSONObject();
                    String date185 = jsonObject185.getString("date212");
                    String xxx185 = jsonObject185.getString("wishyouhappy212");
                    String vvvOid185 = jsonObject185.getString("plaseloveme2212");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        addSubscriber(apiHttpsServices.getPpInfo(
                Rid.getBuildInstance()
                        .withParam("bundleId", context.getPackageName())
                        .withParam("entryFlag", entryFlag)
                        .build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Acxc<Spco>() {
                    @Override
                    public void onSuccess(Spco o) {
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
                        if (viewAction != null) {
                            Mshp.getInstance().saveStartKernel();
                            Mshp.getInstance().setKernelVersionCode(o.getVersionCode() + "");
                            viewAction.showInfoView(GET_PP_INFO, o);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
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
                        if (viewAction != null) {
                            viewAction.showInfoView(GET_PP_INFO, null);
                        }
                    }
                }));
    }

    private void setDrainageTitle(String title) {
        getIiiiip().edit().putString("cfg_dliang_title", title).apply();
    }

    public String getDrainageTitle() {
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
        return getIiiiip().getString("cfg_dliang_title", "");
    }

    private void setDrainageIcon(String title) {
        getIiiiip().edit().putString("cfg_dliang_icon", title).apply();
    }

    public String getDrainageIcon() {
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
        return getIiiiip().getString("cfg_dliang_icon", "");
    }

    private void setDrainageMarketName(String title) {
        getIiiiip().edit().putString("cfg_dliang_market", title).apply();
    }

    public String getDrainageMarketName() {
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
        return getIiiiip().getString("cfg_dliang_market", "");
    }

    private void setDrainageUrl(String cfg_dliang_dest) {
        getIiiiip().edit().putString("cfg_dliang_destsssss", cfg_dliang_dest).apply();
    }

    public String getDrainageUrl() {
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
        return getIiiiip().getString("cfg_dliang_destsssss", "");
    }

    private void setDrainageControl(boolean cfg_dliang_dakai) {
        getIiiiip().edit().putBoolean("promooooooodddddopoooo", cfg_dliang_dakai).apply();
    }

    public boolean getDrainageControl() {
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
        return getIiiiip().getBoolean("promooooooodddddopoooo", false);
    }

    private void setDrainageMessageInfo(String cfg_dliang_desc) {
        getIiiiip().edit().putString("promoooooooddddd", cfg_dliang_desc).apply();
    }

    public String getDrainageMessageInfo() {
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
        return getIiiiip().getString("promoooooooddddd", "");
    }

    private void savePromotionVersion(String promotionVersion) {
        getIiiiip().edit().putString("promooooooo", promotionVersion).apply();
    }

    public String getPromotionVersion() {
        return getIiiiip().getString("promooooooo", "");
    }

    private void saveLikeActivityHiddenDays(Double likeActivityHiddenDays) {
        getIiiiip().edit().putFloat("cfg_e_i_ipccccciiiin", likeActivityHiddenDays.floatValue()).apply();
    }

    public float getLikeActivityHiddenDays() {
        return getIiiiip().getFloat("cfg_e_i_ipccccciiiin", 7.f);
    }

    private void saveUploadIpInterval(Double cfg_ipcheck_interval) {
        getIiiiip().edit().putFloat("cfg_e_i_ippppp", cfg_ipcheck_interval.floatValue()).apply();
    }

    public float getUploadIpInterval() {
        return getIiiiip().getFloat("cfg_e_i_ippppp", 1F);
    }


    private void saveFirebaseCheckInterval(Double cfgEntercheckInterval) {
        getIiiiip().edit().putFloat("cfg_e_i", cfgEntercheckInterval.floatValue()).apply();
    }

    public float getFirebaseCheckInterval() {
        return getIiiiip().getFloat("cfg_e_i", 0.005F);
    }

    public String getPublicNetworkIp() {
        SharedPreferences iiiiip = getIiiiip();
        return iiiiip.getString("iiiiip", "254.253.252.152");
    }

    private SharedPreferences getIiiiip() {
        return context.getSharedPreferences("iiiiip", Context.MODE_PRIVATE);
    }

    private void savePublicNetworkIp(String ip) {
        getIiiiip().edit().putString("iiiiip", ip).apply();
    }

    private void saveCountryId(String ip) {
        getIiiiip().edit().putString("iiiiipsss", ip).apply();
    }


    private String getCountryId() {
        return getIiiiip().getString("iiiiipsss", "");
    }

    private void saveCountry(String ip) {
        getIiiiip().edit().putString("iiiiipsssaaa", ip).apply();
    }


    private void saveCity(String ip) {
        getIiiiip().edit().putString("iiiiipsssaasssa", ip).apply();
    }


    private String getCity() {
        return getIiiiip().getString("iiiiipsssaasssa", "");
    }

    private String getCountry() {
        return getIiiiip().getString("iiiiipsssaasssa", "");
    }


    private void saveLatitude(String ip) {
        getIiiiip().edit().putString("iiiiipsssaassssssa", ip).apply();
    }

    private String getLatitude() {
        return getIiiiip().getString("iiiiipsssaassssssa", "");
    }

    private void saveLongitude(String ip) {
        getIiiiip().edit().putString("iiiiipsssaassssaaaaassa", ip).apply();
    }

    private String getLongitude() {
        return getIiiiip().getString("iiiiipsssaassssaaaaassa", "");
    }

    private void saveLastUploadIpTime() {
        getIiiiip().edit().putLong("lasttime", System.currentTimeMillis()).apply();
    }

    public long getLastUploadIpTime() {
        return getIiiiip().getLong("lasttime", 0);
    }

    public void saveNeedShowLikeActivityEnter(boolean ii) {
        getIiiiip().edit().putBoolean("lasasdfafasdfsadfttime", ii).apply();
    }

    public boolean getNeedShowLikeActivityEnter() {
        return getIiiiip().getBoolean("lasasdfafasdfsadfttime", false);
    }

    private void saveEntry(int entry) {
        getIiiiip().edit().putInt("eeeeeee", entry).apply();
    }

    // 1 web, 2 plugin, 3 native
    public int getEntry() {
        return getIiiiip().getInt("eeeeeee", 0);
    }

    private void saveAdd(String add) {
        getIiiiip().edit().putString("aaaaaaaaaaa", add).apply();
    }

    public String getAdd() {
        return getIiiiip().getString("aaaaaaaaaaa", "");
    }


}
