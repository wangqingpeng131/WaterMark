package com.getwatermark.photomaker.plugin.ccnicegreate.http;

/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 */

public interface CBasePresenter<T extends CIActionListener.ViewAction> {

    /**
     * 添加view
     *
     * @param view
     */
    void addView(T view);

    /**
     * 移除view
     */
    void removeView();

}
