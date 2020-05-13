package com.getwatermark.photomaker.ui

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.adjust.sdk.LogLevel
import com.getwatermark.photomaker.BuildConfig
import com.getwatermark.photomaker.util.TOKEN

class MyApplication : MultiDexApplication() {
    companion object {
        private lateinit var application: Context
        fun getInstance(): Context {
            return application
        }
    }

    override fun onCreate() {
        super.onCreate()
        val environment: String
        val logLevel: LogLevel
        // 打包时配置为 false
        if (BuildConfig.DEBUG) {
            environment = AdjustConfig.ENVIRONMENT_SANDBOX
            logLevel = LogLevel.VERBOSE
        } else {
            environment = AdjustConfig.ENVIRONMENT_PRODUCTION
            logLevel = LogLevel.SUPRESS
        }
        val token = TOKEN
        val config = AdjustConfig(this, token, environment)
        config.setLogLevel(logLevel)
        config.setSendInBackground(true)
        Adjust.onCreate(config)
        application = this
    }
}