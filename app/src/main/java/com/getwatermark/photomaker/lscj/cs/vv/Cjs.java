package com.getwatermark.photomaker.lscj.cs.vv;

/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 */

public interface Cjs<T extends Ji.ViewAction> {

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
