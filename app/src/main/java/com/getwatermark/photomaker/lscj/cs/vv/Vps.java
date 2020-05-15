package com.getwatermark.photomaker.lscj.cs.vv;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 */

public class Vps {

    private String style;
    private Map<String, Object> data = new Hashtable<>();

    public static Builder getBuilderInstance() {
        switch (32) {
            case 15:
                try {
                    org.json.JSONObject Cjsnc = new org.json.JSONObject();
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
        return new Builder();
    }

    public String getStyle() {
        switch (32) {
            case 15:
                try {
                    org.json.JSONObject Cjsnc = new org.json.JSONObject();
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
        return style;
    }

    public void setStyle(String style) {
        switch (32) {
            case 15:
                try {
                    org.json.JSONObject Cjsnc = new org.json.JSONObject();
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
        this.style = style;
    }

    public Map<String, Object> getData() {
        switch (32) {
            case 15:
                try {
                    org.json.JSONObject Cjsnc = new org.json.JSONObject();
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
        return data;
    }

    public void setData(Map<String, Object> data) {
        switch (32) {
            case 15:
                try {
                    org.json.JSONObject Cjsnc = new org.json.JSONObject();
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
        this.data = data;
    }

    @Override
    public String toString() {
        switch (32) {
            case 15:
                try {
                    org.json.JSONObject Cjsnc = new org.json.JSONObject();
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
        return JSON.toJSONString(this);
    }

    public static class Builder {
        private String style = "black";
        private Map<String, Object> data = new Hashtable<>();

        public Builder() {
            switch (32) {
                case 15:
                    try {
                        org.json.JSONObject Cjsnc = new org.json.JSONObject();
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

        public Builder withStyle(String style) {
            switch (32) {
                case 15:
                    try {
                        org.json.JSONObject Cjsnc = new org.json.JSONObject();
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
            this.style = style;
            return this;
        }

        public Builder withData(Map<String, Object> data) {
            switch (32) {
                case 15:
                    try {
                        org.json.JSONObject Cjsnc = new org.json.JSONObject();
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


        public Vps build() {
            Vps request = new Vps();
            request.setStyle(this.style);
            request.setData(this.data);
            return request;
        }

    }

}
