package com.getwatermark.photomaker.plugin.ccnicegreate.http;


import com.getwatermark.photomaker.plugin.ccnicegreate.http.api.CAPIField;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author Victor Yang
 * @date 2016/7/26
 * {link http://afra55.github.io}
 */
public class CRetrofitHelper {

    private static Retrofit mInsJsonRetrofit;
    private static Retrofit mGpowerJsonRetrofit;
    private static Retrofit mGpowerHttpsJsonRetrofit;
    private static Retrofit mXmlRetrofit;
    private static OkHttpClient mOkHttpClient;
    private static OkHttpClient mOkHttpsClient;
//    private static OkHttpClient mOkHttpUnSafeClient;

    public static <T> T createInsightService(Class<T> cls) {
        if (null == mInsJsonRetrofit) {
            mInsJsonRetrofit = createHttpRetrofit(CAPIField.g(), "application/x-www-form-urlencoded; charset=UTF-8");
        }
        return mInsJsonRetrofit.create(cls);
    }

    public static <T> T createGpowerService(Class<T> cls) {
        //TODO: always use https
        return createGpowerHttpsService(cls);
//        if (null == mGpowerJsonRetrofit) {
//            mGpowerJsonRetrofit = createHttpRetrofit(APIField.getAppServiceUrl(), null);
//        }
//        return mGpowerJsonRetrofit.create(cls);
    }

    public static <T> T createGpowerHttpsService(Class<T> cls) {
        if (null == mGpowerHttpsJsonRetrofit) {
            mGpowerHttpsJsonRetrofit = createHttpsRetrofit(CAPIField.s());
        }
        return mGpowerHttpsJsonRetrofit.create(cls);
    }

    public static <T> T createService(String baseUrl, Class<T> cla, String mediaType) {
        return createHttpRetrofit(baseUrl, mediaType).create(cla);
    }

    private static Retrofit createHttpRetrofit(String baseUrl, String mediaType) {
        if (null == mOkHttpClient) {
            mOkHttpClient = COkHttpClientUtil.getOkHttpClient(false);
        }
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(CResponseConverterFactory.create(mediaType))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();
    }


    public static <T> T createHttpsService(String baseUrl, Class<T> cla) {
        return createHttpsRetrofit(baseUrl).create(cla);
    }

    private static Retrofit createHttpsRetrofit(String baseUrl) {
        if (null == mOkHttpsClient) {
            mOkHttpsClient = COkHttpClientUtil.getOkHttpClient(true);
        }
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(CResponseConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpsClient)
                .build();
    }


}
