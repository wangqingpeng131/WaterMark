package com.getwatermark.photomaker.ui

import android.app.Application
import android.content.Context
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.adjust.sdk.LogLevel
import com.didi.virtualapk.PluginManager
import com.downloader.PRDownloader
import com.downloader.PRDownloaderConfig
import com.getwatermark.photomaker.BuildConfig
import com.getwatermark.photomaker.plugin.KernelId
import com.getwatermark.photomaker.plugin.PCache
import com.getwatermark.photomaker.util.TOKEN

class MyApplication : Application() {
    companion object {
        private lateinit var application: Context
        fun getInstance(): Context {
            return application
        }
    }

    override fun onCreate() {
     /*   super.onCreate()
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
        Adjust.onCreate(config)*/




        val environment: String
        val logLevel: LogLevel
        if (BuildConfig.DEBUG || BuildConfig.Test) {
            PCache.setIsDebugMode(true)
            environment = AdjustConfig.ENVIRONMENT_SANDBOX
            logLevel = LogLevel.VERBOSE
        }else {
            environment = AdjustConfig.ENVIRONMENT_PRODUCTION
            logLevel = LogLevel.SUPRESS
        }
        val mPRDownloaderConfig = PRDownloaderConfig.newBuilder()
                .setDatabaseEnabled(true)
                .build()
        PRDownloader.initialize(this, mPRDownloaderConfig)
        super.onCreate()
        PCache.setContext(this)

        // adjust
        // adjust
        val debugMode: Boolean = PCache.isDebugMode()
        val token: String = KernelId.ADJUST_TOKEN
        val config = AdjustConfig(this, token, environment)
        config.setLogLevel(logLevel)
        config.setSendInBackground(true)
        Adjust.onCreate(config)

//        MoPubDefault.initAdjust(this, token, debugMode)

        // TA
        // TA
//        MoPubDefault.initTA(this, KernelId.TA_APP_ID)
        application = this
    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        PluginManager.getInstance(base).init()
    }
}