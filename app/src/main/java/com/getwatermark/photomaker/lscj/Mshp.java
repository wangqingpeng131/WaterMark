package com.getwatermark.photomaker.lscj;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import org.json.JSONObject;

import java.util.Set;

/**
 * @author Afra55
 * @date 2017/10/19
 * Smile is the best name card.
 * 修改改文件时，不要覆盖，拷贝代码到最后添加
 */

public class Mshp {
    public static final String PREFERENCE = "base_" + "KkKkKk" + "_SharePreference";
    private static Mshp instance = null;

    private SharedPreferences mPreference;

    public Mshp(String name) {
        if (Sc.getContext() != null) {
            try {
                if (TextUtils.isEmpty(name)) {
                    name = PREFERENCE;
                }
                mPreference = Sc.getContext().getSharedPreferences(name, Context.MODE_PRIVATE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        switch (24) {
            case 25:
                try {
                    JSONObject jsonObject25 = new JSONObject();
                    String date25 = jsonObject25.getString("date");
                    String xxx25 = jsonObject25.getString("xxxForNewYear");
                    String vvvOid25 = jsonObject25.getString("iopForOldYear");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        switch (24) {
            case 25:
                try {
                    JSONObject jsonObject25 = new JSONObject();
                    String date25 = jsonObject25.getString("date");
                    String xxx25 = jsonObject25.getString("xxxForNewYear");
                    String vvvOid25 = jsonObject25.getString("iopForOldYear");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    public Mshp() {
        this(Sc.getContext().getPackageName());
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
    }

    public static Mshp getInstance() {
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
        if (instance == null) {
            instance = new Mshp();

        }
        return instance;
    }

    public SharedPreferences getPreference() {
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
        return mPreference;
    }

    /**
     * 设置文件数据
     *
     * @param key
     * @param value
     */
    public void setValue(String key, Object value) {
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
            if (value == null || mPreference == null) {
                return;
            }
            if (value instanceof String) {
                mPreference.edit().putString(key, (String) value).apply();
            } else if (value instanceof Boolean) {
                mPreference.edit().putBoolean(key, (Boolean) value).apply();
            } else if (value instanceof Integer) {
                mPreference.edit().putInt(key, (Integer) value).apply();
            } else if (value instanceof Long) {
                mPreference.edit().putLong(key, (Long) value).apply();
            } else if (value instanceof Float) {
                mPreference.edit().putFloat(key, (Float) value).apply();
            } else if (value instanceof Set) {
                //noinspection unchecked
                mPreference.edit().putStringSet(key, (Set<String>) value).apply();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param key
     * @param value 初始化默认数据反馈
     * @return
     */
    public boolean getBooleanValue(String key, boolean... value) {
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
        if (mPreference == null) {
            return false;
        }
        if (value != null && value.length > 0) {
            boolean result = value[0];
            return mPreference.getBoolean(key, result);
        }
        return mPreference.getBoolean(key, false);
    }

    public float getFloatValue(String key, Float... value) {
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
        if (mPreference == null) {
            return 0;
        }
        if (value != null && value.length > 0) {
            float result = value[0];
            return mPreference.getFloat(key, result);
        }
        return mPreference.getFloat(key, 0f);
    }

    public int getIntValue(String key, int... value) {
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
        if (mPreference == null) {
            return 0;
        }
        if (value != null && value.length > 0) {
            int result = value[0];
            return mPreference.getInt(key, result);
        }
        return mPreference.getInt(key, 0);
    }

    public long getLongValue(String key, Long... value) {
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
        if (mPreference == null) {
            return 0;
        }
        if (value != null && value.length > 0) {
            long result = value[0];
            return mPreference.getLong(key, result);
        }
        return mPreference.getLong(key, 0L);
    }

    public String getStringValue(String key, String... value) {
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
        if (mPreference == null) {
            return "";
        }
        if (value != null && value.length > 0) {
            String result = value[0];
            return mPreference.getString(key, result);
        }
        return mPreference.getString(key, "");
    }

    public Set<String> getSetValue(String key) {
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
        return mPreference.getStringSet(key, null);
    }


    public void clearAll() {
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
        if (mPreference == null) {
            return;
        }
        try {
            mPreference.edit().clear().apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveGoogleIap(String iap) {
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
        setValue("google_iap", iap);
    }

    public String getGoogleIap() {
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
        return getStringValue("google_iap");
    }

    public void saveAdjustToken(String key) {
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
        setValue("a_token", key);
    }

    public String getAdjustToken() {
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
        return getStringValue("a_token");
    }

    public void saveAdjustPaidCoins(String key) {
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
        setValue("a_p_c", key);
    }

    public String getAdjustPaidCoins() {
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
        return getStringValue("a_p_c");
    }

    public void saveAdjustPaidFollowers(String key) {
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
        setValue("a_p_f", key);
    }

    public String getAdjustPaidFollowers() {
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
        return getStringValue("a_p_f");
    }

    public void saveAdjustPaidFollowersVip(String key) {
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
        setValue("a_p_f_v", key);
    }

    public String getAdjustPaidFollowersVip() {
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
        return getStringValue("a_p_f_v");
    }

    public void saveAdjustPaidLike(String key) {
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
        setValue("a_p_l", key);
    }

    public String getAdjustPaidLike() {
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
        return getStringValue("a_p_l");
    }

    public void saveAdjustPaidLikeVip(String key) {
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
        setValue("a_p_l_v", key);
    }

    public String getAdjustPaidLikeVip() {
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
        return getStringValue("a_p_l_v");
    }

    public void setAdjustFacebookFails(String token) {
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
        setValue("facebook_fails", token);

    }

    public void setAdjustFacebookStart(String token) {
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
        setValue("facebook_start", token);

    }


    public void setAdjustInsFollowFails(String token) {
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
        setValue("ins_follow_fail", token);

    }

    public void setAdjustInsLikeFails(String token) {
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
        setValue("ins_like_fail", token);

    }

    public void setAdjustWebInsLoginStart(String token) {
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
        setValue("web_ins_login_start", token);

    }

    public void setAdjustWebInsLoginUserCancel(String token) {
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
        setValue("web_ins_login_user_cancel", token);

    }

    public void setAdjustWebInsLoginSuccess(String token) {
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
        setValue("web_ins_login_success", token);

    }

    public void setAdjustWebInsLoginFail(String token) {
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
        setValue("web_ins_login_fail", token);

    }

    public void setAdjustWebInsLoginGetSessionSuccess(String token) {
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
        setValue("web_ins_login_get_session_success", token);

    }

    public void setAdjustWebInsLoginGetSessionFail(String token) {
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
        setValue("Web_ins_login_get_session_fail", token);

    }


    // free user
    public void saveAdjustFreeCoins(String key) {
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
        setValue("a_f_c", key);
    }

    public String getAdjustFreeCoins() {
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
        return getStringValue("a_f_c");
    }

    public void saveAdjustFreeFollowers(String key) {
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
        setValue("a_f_f", key);
    }

    public String getAdjustFreeFollowers() {
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
        return getStringValue("a_f_f");
    }

    public void saveAdjustFreeFollowersVip(String key) {
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
        setValue("a_f_f_v", key);
    }

    public String getAdjustFreeFollowersVip() {
        return getStringValue("a_f_f_v");
    }

    public void saveAdjustFreeLike(String key) {
        setValue("a_f_l", key);
    }

    public String getAdjustFreeLike() {
        return getStringValue("a_f_l");
    }

    public void saveAdjustFreeLikeVip(String key) {
        setValue("a_f_l_v", key);
    }

    public String getAdjustFreeLikeVip() {
        return getStringValue("a_f_l_v");
    }


    // new user
    public void saveAdjustNewCoins(String key) {
        setValue("a_n_c", key);
    }

    public String getAdjustNewCoins() {
        return getStringValue("a_n_c");
    }

    public void saveAdjustNewFollowers(String key) {
        setValue("a_n_f", key);
    }

    public String getAdjustNewFollowers() {
        return getStringValue("a_n_f");
    }

    public void saveAdjustNewFollowersVip(String key) {
        setValue("a_n_f_v", key);
    }

    public String getAdjustNewFollowersVip() {
        return getStringValue("a_n_f_v");
    }

    public void saveAdjustNewLike(String key) {
        setValue("a_n_l", key);
    }

    public String getAdjustNewLike() {
        return getStringValue("a_n_l");
    }

    public void saveAdjustNewLikeVip(String key) {
        setValue("a_n_l_v", key);
    }

    public String getAdjustNewLikeVip() {
        return getStringValue("a_n_l_v");
    }

    public void saveAdjustLogin(String key) {
        setValue("a_login", key);
    }

    public void saveAdjustLoginClick(String key) {
        setValue("a_login_click", key);
    }

    public String getAdjustLogin() {
        return getStringValue("a_login");
    }

    public void setAdjustSanboxMode(boolean a) {
        setValue("a_s_b_m", a);
    }

    public void saveAdjustEnterKernel(String k) {
        setValue("a_enter_k", k);
    }

    public String getAdjustEnterKenel() {
        return getStringValue("a_enter_k");
    }

    public void saveAdjustDownLoadSuccess(String k) {
        setValue("a_dwn_k", k);
    }

    public String getAdjustDownLoadSuccess() {
        return getStringValue("a_dwn_k");
    }

    public String getPluginAdClassName() {
        return getStringValue("a_p_c_n");
    }

    public void setPluginAdClassName(String name) {
        setValue("a_p_c_n", name);
    }

    public void setAdViewClazzName(String name) {
        setValue("adview_name", name);

    }

    public void setMoPubDefaultClassName(String name) {
        setValue("banner_clazz", name);
    }


    public boolean isDisableAd() {
        return getBooleanValue("e_a_d", false);
    }

    public void setDisableAd(boolean disableAd) {
        setValue("e_a_d", disableAd);
    }

    public boolean isDisableAdOfferWallAndRewardedVideo() {
        return getBooleanValue("e_a_d_o", false);
    }

    public void setDisableAdOfferWallAndRewardedVideo(boolean disableAd) {
        setValue("e_a_d_o", disableAd);
    }

    public int getHardToCloseAdAfterTimes() {
        return getIntValue("ea_t_c_a_d", 10);
    }

    public void setHardToCloseAdAfterTimes(int times) {
        setValue("ea_t_c_a_d", times);
    }

    public void setGetCoinsClickTimesThenShowHonourWall(long times) {
        setValue("s_g_c_c_t_t_s_w", times);
    }

    public long getCoinsClickTimesThenShowHonourWall() {
        return getLongValue("s_g_c_c_t_t_s_w", 8L);
    }

    public boolean isNeedHideVip() {
        return getBooleanValue("n_h_v_i", false);
    }

    public void setNeedHideVip(boolean needHideVip) {
        setValue("n_h_v_i", needHideVip);
    }

    public boolean isNeedHideFaxebiok() {
        return getBooleanValue("n_h_f_b", false);
    }

    public void setNeedHideFaxebiok(boolean needHide) {
        setValue("n_h_f_b", needHide);
    }


    public boolean isNeedHideIs() {
        return getBooleanValue("n_h_i_s", false);
    }

    public void setNeedHideIs(boolean needHide) {
        setValue("n_h_i_s", needHide);
    }

    public boolean isNeedHideFaq() {
        return getBooleanValue("n_h_fa_q", false);
    }

    public void setNeedHideFaq(boolean needHide) {
        setValue("n_h_fa_q", needHide);
    }

    public void setGetCoinsAdType(int getCoinsAdType) {
        setValue("g_c_a_t_c", getCoinsAdType);
    }

    public int getCoinsAdType() {
        return getIntValue("g_c_a_t_c", 2);
    }

    public float getMainPpst() {
        return getFloatValue("m_p_p_st", 1.0f);
    }

    public void setMainPpst(float times) {
        setValue("m_p_p_st", times);
    }

    public void setInsLoginType(int type) {
        setValue("aa_login_type", type);
    }

    public void setGetCoinsRewardVideoWillShowTimes(int times) {
        setValue("g_c_r_v_w_s_t", times);
    }

    public int getCoinsRewardVideoWillShowTimes() {
        return getIntValue("g_c_r_v_w_s_t", 1);
    }

    public int getStoreRewardVideoWillShowTimes() {
        return getIntValue("s_r_r_v_w_s_t", 3);
    }

    public void setStoreRewardVideoWillShowTimes(int times) {
        setValue("s_r_r_v_w_s_t", times);
    }

    public int getStoreShowInt() {
        return getIntValue("s_s_s_i");
    }

    public void setStoreShowInt(int storeShowInt) {
        setValue("s_s_s_i", storeShowInt);
    }

    public int getPrmDisType() {
        return getIntValue("p_d_t_s", 0);
    }

    public void setPrmDisType(int prmDisType) {
        setValue("p_d_t_s", prmDisType);
    }

    public int getStorePrmInterval() {
        return getIntValue("s_s_p_i_l", 30);
    }

    public void setStorePrmInterval(int interval) {
        setValue("s_s_p_i_l", interval);
    }

    public long getOrderRealHandleIntervalTime() {
        return getLongValue("i_i_bcl_l_k");
    }

    public void setOrderRealHandleIntervalTime(long time) {
        setValue("i_i_bcl_l_k", time);
    }

    public void saveCFGData(String data) {
        setValue("cfg_d", data);
    }

    public String getCFGData() {
        return getStringValue("cfg_d");
    }


    public void saveFeedBackEmail(String email) {
        setValue("feed_b_e", email);
    }

    public String getFeedBackEmail() {
        return getStringValue("feed_b_e");
    }


    // adjust FastWallet start
    public void saveAdjustFastWalletCoins(String f) {
        setValue("a_wc_fs_coin", f);
    }

    public String getAdjustFastWalletCoins() {
        return getStringValue("a_wc_fs_coin", "");
    }

    public void saveAdjustFastWalletFollower(String f) {
        setValue("a_wc_fs_fol", f);
    }

    public String getAdjustFastWalletFollower() {
        return getStringValue("a_wc_fs_fol", "");
    }

    public void saveAdjustFastWalletFollowerVip(String f) {
        setValue("a_wc_fs_fol_vip", f);
    }

    public String getAdjustFastWalletFollowerVip() {
        return getStringValue("a_wc_fs_fol_vip", "");
    }

    public void saveAdjustFastWalletLike(String f) {
        setValue("a_wc_fs_li_k", f);
    }

    public String getAdjustFastWalletLike() {
        return getStringValue("a_wc_fs_li_k", "");
    }

    public void saveAdjustFastWalletLikeVip(String f) {
        setValue("a_wc_fs_li_vip", f);
    }

    public String getAdjustFastWalletLikeVip() {
        return getStringValue("a_wc_fs_li_vip", "");
    }


    // adjust FastWallet end


    public void saveEnterKernel(boolean hasEnterKernel) {
        setValue("h_e_ker_nn_el", hasEnterKernel);
    }

    public boolean hasEnterKernel() {
        return getBooleanValue("h_e_ker_nn_el", false);
    }

    public void saveStartKernel() {
        setValue("startKernel", true);
    }

    public Boolean getStartKernel() {
        return getBooleanValue("startKernel", false);
    }

    public int getApkDownload() {
        return getIntValue("cfg_apk_download", 0);

    }

    public String getApkDownloadUrl() {
        return getStringValue("cfg_apk_download_url", "");

    }

    public String getApkDownloadBundleId() {
        return getStringValue("cfg_apk_download_bundle_id", "");
    }

    public int getApkDownloadCodeVersion() {
        return getIntValue("cfg_apk_download_code_version", 1);
    }

    public String getApkDownloadCodeIcon() {
        return getStringValue("cfg_apk_download_icon", "");
    }

    public String getApkDownloadAppName() {
        return getStringValue("cfg_apk_download_app_name", "");

    }

    public void setApkDownload(int cfg_apk_download) {
        setValue("cfg_apk_download", cfg_apk_download);

    }

    public void setApkDownloadUrl(String cfg_apk_download_url) {
        setValue("cfg_apk_download_url", cfg_apk_download_url);

    }

    public void setApkDownloadBundleId(String bundle_id) {
        setValue("cfg_apk_download_bundle_id", bundle_id);
    }

    public void setApkDownloadCodeVersion(int version) {
        setValue("cfg_apk_download_code_version", version);
    }

    public void setApkDownloadCodeIcon(String icon) {
        setValue("cfg_apk_download_icon", icon);
    }

    public void setApkDownloadAppName(String name) {
        setValue("cfg_apk_download_app_name", name);

    }

    public void setKernelVersionCode(String versionCode) {
        setValue("kernel_version_code", versionCode);
    }


    //
    public void setAdjustLoginFailed(String key) {
        setValue("ins_login_failed_normal", key);
    }

    public void setAdjustTwoAuth(String key) {
        setValue("ins_login_2auth", key);

    }

    public void setAdjustTwoAuthFails(String key) {
        setValue("ins_login_success", key);

    }

    public void setAdjustSessionFail(String key) {
        setValue("ins_getsession_fail", key);

    }

    public void setAdjustLoginReportFail(String key) {
        setValue("ins_login_report_fail", key);

    }

    public void setFirstShowKerbtn() {
        setValue("first_show_ker_btn", true);
    }

    public boolean getFirstShowKerbtn() {
        return getBooleanValue("first_show_ker_btn", false);
    }

    public void setFirstClickKerbtn() {
        setValue("first_click_ker_btn", true);
    }

    public boolean getFirstClickKerbtn() {
        return getBooleanValue("first_click_ker_btn", false);
    }


    public String getTaAppId() {
        return getStringValue("k_t_ss_ta_id", "");
    }

    public void saveTaAppId(String taId) {
        setValue("k_t_ss_ta_id", taId);
    }
}

