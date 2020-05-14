package com.getwatermark.photomaker.plugin.ccnicegreate.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 */

public class CRequestQuery {

    private Map<String, Object> data = new HashMap<>();

    public static Build getBuildInstance() {
        return new Build();
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }


    public static class Build {
        private Map<String, Object> buildData = new HashMap<>();

        public Build() {
        }

        public Build withParam(String param, Object obj) {
            if (obj != null) {
                buildData.put(param, obj);
            }
            return this;
        }

        public Map<String, Object> build() {
            CRequestQuery query = new CRequestQuery();
            query.setData(buildData);
            return query.getData();
        }

    }
}
