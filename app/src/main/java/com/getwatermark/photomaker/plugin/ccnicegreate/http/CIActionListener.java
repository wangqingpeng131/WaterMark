package com.getwatermark.photomaker.plugin.ccnicegreate.http;


import com.getwatermark.photomaker.plugin.ccnicegreate.http.api.BaseView;

/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 */

public class CIActionListener {
    /**
     * viewAction 接口的监听
     */
    public interface ViewAction<T> extends BaseView {
        void showInfoView(String type, Object obj);
    }

    /**
     * presenter 接口的监听
     */
    interface PresenterAciton extends CBasePresenter {

    }
}
