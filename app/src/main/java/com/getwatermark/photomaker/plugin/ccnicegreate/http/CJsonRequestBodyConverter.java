package com.getwatermark.photomaker.plugin.ccnicegreate.http;

import android.text.TextUtils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 */

public class CJsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private String mediaType;

    public CJsonRequestBodyConverter(String mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public RequestBody convert(T value) throws IOException {
        try {
            Buffer buffer = new Buffer();
            Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
            writer.write(value.toString());
            writer.close();
            MediaType tempMediaType;
            try {
                tempMediaType = TextUtils.isEmpty(mediaType) ? MEDIA_TYPE : MediaType.parse(mediaType);
            } catch (Exception e) {
                tempMediaType = MEDIA_TYPE;
                e.printStackTrace();
            }
            return RequestBody.create(tempMediaType, buffer.readByteString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}