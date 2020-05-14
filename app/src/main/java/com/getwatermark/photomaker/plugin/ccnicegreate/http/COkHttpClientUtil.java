package com.getwatermark.photomaker.plugin.ccnicegreate.http;


import androidx.annotation.NonNull;

import com.getwatermark.photomaker.plugin.PCache;
import com.getwatermark.photomaker.plugin.ccnicegreate.http.api.CAPIField;
import com.getwatermark.photomaker.plugin.ccnicegreate.http.api.CrtField;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;

/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 */
public class COkHttpClientUtil {

    private static OkHttpClient mOkHttpClient;
    private static OkHttpClient mOkHttpsClient;
//    private static OkHttpClient mUnSafeOkHttpClient;
    private static long SecondTime = 1000;
    /**
     * 设置缓存目录
     */
    private static File cacheDirectory ;
    private static Cache cache;


    /**
     * 获取OkHttpClient对象
     *
     * @return
     */
    public static OkHttpClient getOkHttpClient(boolean isHttps) {
        if (cacheDirectory == null || cache == null) {
            cacheDirectory = PCache.getContext().getApplicationContext().getCacheDir();
            cache = new Cache(cacheDirectory, 10 * 1024 * 1024);
        }
        if (isHttps) {
            if (null == mOkHttpsClient) {
                getOkHttpsBuild();
            }
            return mOkHttpsClient;
        } else {
            if (null == mOkHttpClient) {
                getOkHttpBuild();
            }
            return mOkHttpClient;
        }
    }

    private static void getOkHttpsBuild() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (PCache.isDebugMode()) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory sslSocketFactory = null;
        try {
            InputStream inputStream = new Buffer().writeUtf8(CrtField.getInstance().crt).inputStream();
            sslSocketFactory = getSocketFactory(inputStream);
            if (sslSocketFactory != null) {
                builder.sslSocketFactory(sslSocketFactory);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mOkHttpsClient = builder
                .addInterceptor(new TokenInterceptor())
                //设置请求读写的超时时间
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    private static void getOkHttpBuild() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (PCache.isDebugMode()) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor())
//                .addInterceptor(new LocalCacheInterceptor(60 * 60 * 1000))
//                .addNetworkInterceptor(new NetCacheInterceptor(60 * 60 * 1000))
                //设置请求读写的超时时间
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

//    public static OkHttpClient getUnsafeOkHttpClient() {
//        if (mUnSafeOkHttpClient != null) {
//            return mUnSafeOkHttpClient;
//        }
//        try {
//            // Create a trust manager that does not validate certificate chains
//            final TrustManager[] trustAllCerts = new TrustManager[]{
//                    new X509TrustManager() {
//                        @Override
//                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
//                        }
//
//                        @Override
//                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
//                        }
//
//                        @Override
//                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                            return new java.security.cert.X509Certificate[]{};
//                        }
//                    }
//            };
//
//            // Install the all-trusting trust manager
//            final SSLContext sslContext = SSLContext.getInstance("SSL");
//            sslContext.init(null, trustAllCerts, new SecureRandom());
//
//            // Create an ssl socket factory with our all-trusting manager
//            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
//
//            OkHttpClient.Builder builder = new OkHttpClient.Builder();
//            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
//            builder.hostnameVerifier(new HostnameVerifier() {
//                @Override
//                public boolean verify(String hostname, SSLSession session) {
//                    return true;
//                }
//            });
//            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//            if (BaseCache.isDebugMode()) {
//                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            }
//
//            mUnSafeOkHttpClient = builder.build();
//            mUnSafeOkHttpClient = new OkHttpClient.Builder()
//                    .addInterceptor(new TokenInterceptor())
//                    .connectTimeout(60, TimeUnit.SECONDS)
//                    .writeTimeout(30, TimeUnit.SECONDS)
//                    .readTimeout(30, TimeUnit.SECONDS)
//                    .addInterceptor(loggingInterceptor)
//                    .cache(cache)
//                    .build();
//            return mUnSafeOkHttpClient;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    private static SSLSocketFactory getSocketFactory(InputStream... certificates) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates) {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));

                try {
                    if (certificate != null) {
                        certificate.close();
                    }
                } catch (IOException e) {
                }
            }

            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            trustManagerFactory.init(keyStore);
            sslContext.init
                    (
                            null,
                            trustManagerFactory.getTrustManagers(),
                            new SecureRandom()
                    );

            return sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    private static final String string1 = "0d";
    private static String string;
    private static String ce;

    public static String getLaString(String value) {
        String d8 = "d8";
        string = "766";
        String ea = "ea";
        ce = "ce";
        String ad = "ad";
        String s = "33";
        String a9 = "a9";
        String s1 = "245c";
        String d6 = "d6";
        String s2 = "28";
        return encryptSHA1ToString("3" + d8 + string + "fb" + ea + "67" + ce + "31" + "0c" + s + "a3" + "c7" + string1 + ad + d6 + "42" + a9 + s2 + s1 + value).toLowerCase();
    }
    public static String encryptSHA1ToString(String data) {
        return encryptSHA1ToString(data.getBytes());
    }
    public static String encryptSHA1ToString(byte[] data) {
        return bytes2HexString(encryptSHA1(data));
    }
    /**
     * SHA1加密
     *
     * @param data 明文字节数组
     * @return 密文字节数组
     */
    public static byte[] encryptSHA1(byte[] data) {
        return encryptAlgorithm(data, "SHA-1");
    }
    private static byte[] encryptAlgorithm(byte[] data, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(data);
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
    static final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 每1个byte转为2个hex字符
     * <p>例如：</p>
     * bytes2HexString(new byte[] { 0, (byte) 0xa8 }) returns 00A8
     *
     * @param src byte数组
     * @return 16进制大写字符串
     */
    public static String bytes2HexString(byte[] src) {
        char[] res = new char[src.length << 1];
        for (int i = 0, j = 0; i < src.length; i++) {
            res[j++] = hexDigits[src[i] >>> 4 & 0x0f];
            res[j++] = hexDigits[src[i] & 0x0f];
        }
        return new String(res);
    }
    /**
     * 自定义链接地址中包含token的添加
     */
    private static class TokenInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder newBuilder = request.newBuilder();
            HttpUrl url = request.url();
            Headers headers = request.headers();
            try {
                if (url != null) {
                    String urlStr = url.toString();
                    boolean b = (urlStr.contains(CAPIField.s()));
                    if (b) {
                        String tempUrl;

                        // http://www.baidu.com/ssss?fff=fff&vvvv=oooo
                        if (urlStr.startsWith(CAPIField.s())) {
                            tempUrl = urlStr.replaceFirst(CAPIField.s(), "");
                        } else {
                            tempUrl = urlStr.replaceFirst(CAPIField.s(), "");
                        }
                        //   /ssss?fff=fff&vvvv=oooo
                        if (urlStr.contains("?")) {
                            newBuilder.url(url + "&gsid=" + getLaString(tempUrl));
                        } else {
                            newBuilder.url(url + "?gsid=" + getLaString(tempUrl));
                        }
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return chain.proceed(newBuilder.build());
        }
    }



    public static class LocalCacheInterceptor implements Interceptor {
        private int maxCacheSeconds;

        public LocalCacheInterceptor(int maxCacheSeconds) {
            this.maxCacheSeconds = maxCacheSeconds;
        }

        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            CacheControl cacheControl = new CacheControl.Builder().maxAge(maxCacheSeconds, TimeUnit.SECONDS).maxStale(0, TimeUnit.SECONDS).build();
            Request request = chain.request();
            Request.Builder builder = request.newBuilder().cacheControl(cacheControl);
            request = builder.build();
            if (CDisposableObserver.isNetAvailable(PCache.getContext())) {
                try {
                    Response response = chain.proceed(request);
                    if (response.isSuccessful()) {
                        return response;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } //if request failed. always load in cache
            cacheControl = new CacheControl.Builder().maxAge(Integer.MAX_VALUE, TimeUnit.SECONDS).maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
            request = builder.cacheControl(cacheControl).build();
            return chain.proceed(request);
        }
    }

    public static class NetCacheInterceptor implements Interceptor {
        private int maxCacheSeconds;

        public NetCacheInterceptor(int maxCacheSeconds) {
            this.maxCacheSeconds = maxCacheSeconds;
        }

        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder builder = request.newBuilder();
            request = builder.build();
            Response originalResponse = chain.proceed(request);
            if (CDisposableObserver.isNetAvailable(PCache.getContext())) {
                return originalResponse.newBuilder().header("Cache-Control", "public, max-age=" + 60 * 60 * 1000).build();
            } else {
                return originalResponse.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + Integer.MAX_VALUE).build();
            }
        }
    }


}
