package com.getwatermark.photomaker.plugin.ccnicegreate.http;

import org.json.JSONObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 */

public class CResponseConverterFactory extends Converter.Factory {

    private String mediaType;

    private CResponseConverterFactory(JSONObject jsonObject, String mediaType) {
        if (jsonObject == null) {
            throw new NullPointerException("json == null");
        }
        this.mediaType = mediaType;
    }

    public static CResponseConverterFactory create() {
        return create(new JSONObject(), null);
    }

    public static CResponseConverterFactory create(String mediaType) {
        return create(new JSONObject(), mediaType);
    }

    private static CResponseConverterFactory create(JSONObject jsonObject, String mediaType) {
        return new CResponseConverterFactory(jsonObject, mediaType);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type,
                                                            Annotation[] annotations,
                                                            Retrofit retrofit) {
        return new CJsonResponseBodyConverter<>(type);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations,
                                                          Annotation[] methodAnnotations,
                                                          Retrofit retrofit) {
        return new CJsonRequestBodyConverter<>(mediaType);
    }

}
