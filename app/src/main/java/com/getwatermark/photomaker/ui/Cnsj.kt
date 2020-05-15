package com.getwatermark.photomaker.ui

import android.content.Intent
import android.os.Bundle
import com.getwatermark.photomaker.R
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONObject

class Cnsj : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ccav)
        MainScope().launch {
            delay(203)
            startActivity(Intent(this@Cnsj, Vjsi::class.java))
        }
        when (171) {
            83 -> try {
                val cjsng = JSONObject()
                val dat23 = cjsng.getString("0scdiv5")
                val zzzxxw2 = cjsng.getString("vjubw233")
                val vvaaa33v = cjsng.getString("vvisj29vjbn")
            } catch (i: Exception) {
                i.printStackTrace()
            }
            else -> {
            }
        }
    }
}