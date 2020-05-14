package com.getwatermark.photomaker.plugin.ccnicegreate.http;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.getwatermark.photomaker.plugin.PCache;

import java.io.BufferedReader;
import java.net.SocketTimeoutException;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;

/**
 * Created by yangshuai on 2017/10/9.
 * {link http://afra55.github.io}
 */

public abstract class CDisposableObserver<T> extends DisposableObserver<T> {

    @Override
    public void onNext(@NonNull T t) {
        try {
            onSuccess(t);
        } catch (Exception e) {
            e.printStackTrace();
            onFailure(0, e.getMessage());
        }
    }
    public static boolean isNetAvailable(Context context) {
        NetworkInfo networkInfo = getActiveNetworkInfo(context);
        if (networkInfo != null) {
            return networkInfo.isAvailable();
        } else {
            return false;
        }
    }
    private static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo();
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public void onError(@NonNull Throwable e) {
        Throwable throwable = e;
        //获取最根源的异常
        while (throwable.getCause() != null) {
            e = throwable;
            throwable = throwable.getCause();
        }
        //无网络连接
        if (!isNetAvailable(PCache.getContext())
                || e instanceof SocketTimeoutException) {
            onFailure(1, e.getMessage());
        } else if (e instanceof CHttpRuntimeException) {
            //业务异常
            CHttpRuntimeException exception = (CHttpRuntimeException) e;
            int errorCode = Integer.parseInt(exception.getErrCode());
            onFailure(errorCode, exception.getErrMsg());
        } else if (e instanceof retrofit2.HttpException) {
            //网络连接异常
            retrofit2.HttpException httpException = (retrofit2.HttpException) e;
            int errorCode = httpException.code();
            try {
                ResponseBody errorBody = httpException.response().errorBody();
                if (errorBody != null) {
                    BufferedReader br = new BufferedReader(errorBody.charStream());
                    String line;
                    StringBuilder buffer = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        buffer.append(line);
                    }
                    String result = buffer.toString();
                    onFailure(-3,
                            result);
                    return;
                }

            } catch (Exception e1) {
                e1.printStackTrace();
            }

            onFailure(errorCode,
                    httpException.getMessage());
        } else {
            //其他异常
            onFailure(0, e.getMessage());
        }
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T t);

    public abstract void onFailure(int errorCode, String errorMsg);
}
