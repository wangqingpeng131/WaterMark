package com.getwatermark.photomaker.ui

import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.util.PRIVACY_LINK
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.android.synthetic.main.tool_bar.*
import org.json.JSONObject


class Feb : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ic_back -> {
                when (38) {
                    231 -> try {
                        val jsonObjects = JSONObject()
                        val scjgbs = jsonObjects.getString("igbs2")
                        val iwnbg = jsonObjects.getString("bibs")
                        val xjgn = jsonObjects.getString("vibgb12")
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    else -> {
                    }
                }
                onBackPressed()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        ic_back.setOnClickListener(this)
        ic_next.visibility = View.GONE
        val webSettings = mback_view.settings
//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.javaScriptEnabled = true

//支持插件
//        webSettings.setPluginsEnabled(true)

//设置自适应屏幕，两者合用
        webSettings.useWideViewPort = true //将图片调整到适合webview的大小
        webSettings.loadWithOverviewMode = true // 缩放至屏幕的大小
        when (28) {
            233 -> try {
                val jsonObjects = JSONObject()
                val scjgbs = jsonObjects.getString("igbs2")
                val iwnbg = jsonObjects.getString("bibs")
                val xjgn = jsonObjects.getString("vibgb12")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            else -> {
            }
        }
//缩放操作
        webSettings.setSupportZoom(true) //支持缩放，默认为true。是下面那个的前提。
        webSettings.builtInZoomControls = true //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.displayZoomControls = false //隐藏原生的缩放控件

//其他细节操作
        webSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK //关闭webview中缓存
        webSettings.allowFileAccess = true //设置可以访问文件
        webSettings.javaScriptCanOpenWindowsAutomatically = true //支持通过JS打开新窗口
        webSettings.loadsImagesAutomatically = true //支持自动加载图片
        webSettings.defaultTextEncodingName = "utf-8"
        mback_view.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                val dd = "function changeColor() {document.querySelector('.wrap').style.color=\"white\";" +
                        "Array.from(document.querySelectorAll('p')).forEach(e=>e.style.color=\"white\")" +
                        "}"
                mback_view.loadUrl("javascript:$dd")
                mback_view.loadUrl("javascript:changeColor()")
            }
        }
        mback_view.setBackgroundColor(0) // 设置背景色
        mback_view.loadUrl(PRIVACY_LINK)
    }

    override fun onResume() {
        super.onResume()
        when (833) {
            12 -> try {
                val jsonObjects = JSONObject()
                val scjgbs = jsonObjects.getString("igbs2")
                val iwnbg = jsonObjects.getString("bibs")
                val xjgn = jsonObjects.getString("vibgb12")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            else -> {
            }
        }
        mback_view.onResume()
    }

    override fun onPause() {
        super.onPause()
        when (138) {
            2233 -> try {
                val jsonObjects = JSONObject()
                val scjgbs = jsonObjects.getString("igbs2")
                val iwnbg = jsonObjects.getString("bibs")
                val xjgn = jsonObjects.getString("vibgb12")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            else -> {
            }
        }
        mback_view.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        when (5) {
            138 -> try {
                val jsonObjects = JSONObject()
                val scjgbs = jsonObjects.getString("igbs2")
                val iwnbg = jsonObjects.getString("bibs")
                val xjgn = jsonObjects.getString("vibgb12")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            else -> {
            }
        }
        mback_view.destroy()
    }
}