package com.getwatermark.photomaker.util

object FastClickUtil {

    private var lastClickTime: Long = 0

    /**
     * 防暴力点击
     *
     * @param dur 时间间隔
     * @return true:多次点击
     */
    fun isFastDoubleClick(dur: Long): Boolean {
        val time = System.currentTimeMillis()
        val timeD = time - lastClickTime
        if (timeD in 1 until dur) {
            lastClickTime = time
            return true
        }
        lastClickTime = time
        return false
    }

}
