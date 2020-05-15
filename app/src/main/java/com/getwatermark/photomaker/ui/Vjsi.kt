package com.getwatermark.photomaker.ui

import android.os.Bundle
import android.view.View
import com.getwatermark.photomaker.R
import kotlinx.android.synthetic.main.wicj.*
import org.greenrobot.eventbus.EventBus
import org.json.JSONObject


class Vjsi : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wicj)
        cjcs.setOnClickListener(this)
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


    override fun onDestroy() {
        super.onDestroy()
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

        EventBus.getDefault().unregister(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.cjcs -> {
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
                finish()

            }
        }
    }
}