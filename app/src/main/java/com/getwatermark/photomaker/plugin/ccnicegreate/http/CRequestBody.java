package com.getwatermark.photomaker.plugin.ccnicegreate.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 */

public class CRequestBody {

    private String style;
    private Map<String, Object> data = new Hashtable<>();

    public static Builder getBuilderInstance() {
        return new Builder();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static class Builder {
        private String style = "black";
        private Map<String, Object> data = new Hashtable<>();

        public Builder() {
        }

        public Builder withStyle(String style) {
            this.style = style;
            return this;
        }

        public Builder withData(Map<String, Object> data) {
            if (data != null) {
                this.data = data;
            }
            return this;
        }

        public Builder withParam(String key, Object value) {
            if (value != null) {
                this.data.put(key, value);
            }
            return this;
        }

        /**
         * .withObject(JSON.toJSONString(bean))
         *
         * @param jsonStr JSON.toJSONString(bean)
         * @return this
         */
        public Builder withObject(String jsonStr) {
            if (jsonStr != null) {
                JSONObject jasonObject = JSON.parseObject(jsonStr);
                @SuppressWarnings("unchecked")
                Map<String, Object> map = (Map) jasonObject;
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    this.data.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }


        public CRequestBody build() {
            CRequestBody request = new CRequestBody();
            request.setStyle(this.style);
            request.setData(this.data);
            return request;
        }

    }

}
