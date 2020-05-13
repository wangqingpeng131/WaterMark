package com.getwatermark.photomaker.config

import android.content.Context
import com.getwatermark.photomaker.ui.MyApplication

open class MySp(name: String = "watermark") {
    private val sp = MyApplication.getInstance().getSharedPreferences(name, Context.MODE_PRIVATE)
    fun setValue(key: String, value: Any) {
        val edit = sp.edit()
        when (value) {
            is Boolean ->
                edit.putBoolean(key, value)
            is Int ->
                edit.putInt(key, value)
            is Float ->
                edit.putFloat(key, value)
            is Long ->
                edit.putLong(key, value)
            is String ->
                edit.putString(key, value)
        }
        edit.apply()
    }

    fun getBooleanValue(key: String, default: Boolean): Boolean {
        return sp.getBoolean(key, default)
    }

    fun getStringValue(key: String, default: String = ""): String {
        return sp.getString(key, default) ?: default
    }

    fun getIntValue(key: String, default: Int): Int {
        return sp.getInt(key, default)
    }

    fun getLongValue(key: String, default: Long): Long {
        return sp.getLong(key, default)
    }

    fun getFloatValue(key: String, default: Float): Float {
        return sp.getFloat(key, default)
    }

    fun clearAll() {
        sp.edit().clear().apply()
    }
}