package com.getwatermark.photomaker.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustEvent
import com.getwatermark.photomaker.BuildConfig
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.util.*
import com.mopub.common.MoPub
import com.mopub.common.SdkConfiguration
import com.mopub.common.SdkInitializationListener
import com.mopub.common.logging.MoPubLog
import com.mopub.mobileads.MoPubErrorCode
import com.mopub.mobileads.MoPubInterstitial
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : BaseActivity(), MoPubInterstitial.InterstitialAdListener {
    private lateinit var mInterstitial: MoPubInterstitial
    private var loadNum: Int = 0
    private val permissionUtil = PermissionUtil()
    private val cameraPermissions = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    )
    private val albumPermissions = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onInterstitialLoaded(interstitial: MoPubInterstitial?) {
    }

    override fun onInterstitialShown(interstitial: MoPubInterstitial?) {
    }

    override fun onInterstitialFailed(interstitial: MoPubInterstitial?, errorCode: MoPubErrorCode?) {
        loadNum += 1
        if (loadNum < 5) {
            mInterstitial.load()
        }
    }

    override fun onInterstitialDismissed(interstitial: MoPubInterstitial?) {
        loadNum += 1
        if (loadNum < 5) {
            mInterstitial.load()
        }
    }

    override fun onInterstitialClicked(interstitial: MoPubInterstitial?) {
    }

    private fun initSdkListener(): SdkInitializationListener {
        return SdkInitializationListener {
            mInterstitial = MoPubInterstitial(this, DAOLIANG)
            mInterstitial.interstitialAdListener = this
        }
    }

    private fun setMoPub() {
        val configBuilder = SdkConfiguration.Builder(DAOLIANG)
        if (BuildConfig.DEBUG) {
            configBuilder.withLogLevel(MoPubLog.LogLevel.DEBUG)
        } else {
            configBuilder.withLogLevel(MoPubLog.LogLevel.INFO)
        }
        MoPub.initializeSdk(this, configBuilder.build(), initSdkListener())

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val event = AdjustEvent(PIAPP_LAUNCH)
        Adjust.trackEvent(event)
        setMoPub()
        setTextViewStyles(main_title)
        photo_bt.setOnClickListener {
//            startActivity(Intent(this, EdActivity::class.java))
                openAlbum()
        }
        camera_bt.setOnClickListener { openCamera() }
        main_set.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
        }
        main_coins_group.setOnClickListener {
            startActivity(Intent(this, ShoppingActivity::class.java))
        }
    }

    private fun openCamera() {
        if (permissionUtil.haveStoragePermission(*cameraPermissions)) {
            permissionUtil.openCamera(this)
        } else {
            permissionUtil.requestCameraPermission(this, *cameraPermissions)
        }
    }

    private fun openAlbum() {
        if (permissionUtil.haveStoragePermission(*albumPermissions)) {
            permissionUtil.openAlbum(this)
        } else {
            permissionUtil.requestAlbumPermission(this, *albumPermissions)
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var fileUri: Uri? = null
        if (resultCode == RESULT_OK) {
            if (data != null) {
                if (data.clipData != null) {
                    if (data.clipData!!.itemCount > 0) {
                        fileUri = data.clipData!!.getItemAt(0).uri
                    }
                } else {
                    fileUri = data.data
                }
            }
            when (requestCode) {
                PICK_REQUEST -> try {
                    if (fileUri != null) {
                        startActivity(fileUri.let { EdActivity.callingIntent(this, it) })
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                CAMERA_REQUEST -> try{
                    val contentUri: Uri?
                    val cameraSavePath = PermissionUtil().generateCachePicturePath(this)
                    contentUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        cameraSavePath?.let {
                            FileProvider.getUriForFile(this,
                                    PermissionUtil().getFileProviderName(this), it)
                        }
                    } else {
                        Uri.fromFile(cameraSavePath)
                    }
                    if (contentUri != null) {
                        startActivity(contentUri.let { EdActivity.callingIntent(this, it) })
                    }
                }catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSIONS_REQUEST_CAMERA -> {
                if (grantResults.isNotEmpty()) {
                    grantResults.forEach {
                        val boolean = it == PackageManager.PERMISSION_GRANTED
                        if (!boolean) return
                    }
                    permissionUtil.openCamera(this)
                } else {
                    var showRationale = true
                    cameraPermissions.forEach {
                        val boolean = ActivityCompat.shouldShowRequestPermissionRationale(
                                this,
                                it
                        )
                        showRationale = showRationale && boolean
                        if (!showRationale) return@forEach
                    }
                    if (showRationale) {
                        permissionUtil.openCamera(this)
                    } else {
                        permissionUtil.goToSettings(this)
                    }

                }
                return
            }
            PERMISSIONS_REQUEST_ALBUM -> {
                if (grantResults.isNotEmpty()) {
                    grantResults.forEach {
                        val boolean = it == PackageManager.PERMISSION_GRANTED
                        if (!boolean) return
                    }
                    permissionUtil.openAlbum(this)
                } else {
                    var showRationale = true
                    cameraPermissions.forEach {
                        val boolean = ActivityCompat.shouldShowRequestPermissionRationale(
                                this,
                                it
                        )
                        showRationale = boolean && showRationale
                        if (!showRationale) return@forEach
                    }
                    if (showRationale) {
                        permissionUtil.openAlbum(this)
                    } else {
                        permissionUtil.goToSettings(this)
                    }

                }
                return
            }

        }
    }

    private fun setTextViewStyles(text: TextView) {
        text.setTextColor(Color.parseColor("#FFFFC491"))
        val spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        text.measure(spec, spec)
        val width = text.measuredWidth
        val linearGradient = LinearGradient(0.toFloat(), 0.toFloat(), width.toFloat(),
                0.toFloat(),
                Color.parseColor("#FFFFC491"),
                Color.parseColor("#FF2D2D2D"),
                Shader.TileMode.CLAMP)
        text.paint.shader = linearGradient
        text.invalidate()
    }


    override fun onResume() {
        super.onResume()
        main_gold_num.text = Util.getCoins()
        if (::mInterstitial.isInitialized) {
            if (mInterstitial.isReady) {
                mInterstitial.show()
            } else {
                mInterstitial.load()
            }
        }
        MoPub.onResume(this)
        try {
            Adjust.onResume()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override fun onPause() {
        super.onPause()
        try {
            loadNum = 0
            Adjust.onPause()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
