package com.getwatermark.photomaker.ui

import android.content.Intent
import android.os.Bundle
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.config.SplashSp
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        MainScope().launch {
            if (SplashSp.isShow()) {
                delay(2000)
                SplashSp.setShow(false)
            }
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }
}