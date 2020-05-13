package com.getwatermark.photomaker.config

object SplashSp : MySp() {
    fun setShow(isShow: Boolean) {
        setValue("is_show", isShow)
    }

    fun isShow(): Boolean {
        return getBooleanValue("is_show",true)
    }
}