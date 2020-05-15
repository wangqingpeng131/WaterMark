package com.getwatermark.photomaker.lscj.cs.vv;


import com.getwatermark.photomaker.lscj.cs.vv.wwc.Axj;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author Victor Yang
 * @date 2016/7/26
 * {link http://afra55.github.io}
 */
public class Qx {

    private static Retrofit mInsJsonRetrofit;
    private static Retrofit mGpowerJsonRetrofit;
    private static Retrofit mGpowerHttpsJsonRetrofit;
    private static Retrofit mXmlRetrofit;
    private static OkHttpClient mOkHttpClient;
    private static OkHttpClient mOkHttpsClient;
//    private static OkHttpClient mOkHttpUnSafeClient;

    public static <T> T createInsightService(Class<T> cls) {
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
        if (null == mInsJsonRetrofit) {
            mInsJsonRetrofit = createHttpRetrofit(Axj.g(), "application/x-www-form-urlencoded; charset=UTF-8");
        }
        return mInsJsonRetrofit.create(cls);
    }

    public static <T> T createGpowerService(Class<T> cls) {
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
        //TODO: always use https
        return createGpowerHttpsService(cls);
//        if (null == mGpowerJsonRetrofit) {
//            mGpowerJsonRetrofit = createHttpRetrofit(APIField.getAppServiceUrl(), null);
//        }
//        return mGpowerJsonRetrofit.create(cls);
    }

    public static <T> T createGpowerHttpsService(Class<T> cls) {
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
        if (null == mGpowerHttpsJsonRetrofit) {
            mGpowerHttpsJsonRetrofit = createHttpsRetrofit(Axj.s());
        }
        return mGpowerHttpsJsonRetrofit.create(cls);
    }

    public static <T> T createService(String baseUrl, Class<T> cla, String mediaType) {
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
        return createHttpRetrofit(baseUrl, mediaType).create(cla);
    }

    private static Retrofit createHttpRetrofit(String baseUrl, String mediaType) {
        if (null == mOkHttpClient) {
            mOkHttpClient = Vjsd.getOkHttpClient(false);
        }
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(Qwpc.create(mediaType))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();
    }


    public static <T> T createHttpsService(String baseUrl, Class<T> cla) {
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
        return createHttpsRetrofit(baseUrl).create(cla);
    }

    private static Retrofit createHttpsRetrofit(String baseUrl) {
        if (null == mOkHttpsClient) {
            mOkHttpsClient = Vjsd.getOkHttpClient(true);
        }
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(Qwpc.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpsClient)
                .build();
    }


}
