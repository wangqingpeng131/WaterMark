package com.getwatermark.photomaker.lscj.cs.vv;


import com.getwatermark.photomaker.lscj.cs.vv.wwc.Bs;

import org.json.JSONObject;

/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 */

public class Ji {
    /**
     * viewAction 接口的监听
     */
    public interface ViewAction<T> extends Bs {
        void showInfoView(String type, Object obj);
    }

    /**
     * presenter 接口的监听
     */
    interface PresenterAciton extends Cjs {

    }
}
