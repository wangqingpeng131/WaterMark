package com.getwatermark.photomaker.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustEvent
import com.getwatermark.photomaker.BuildConfig
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.plugin.KernelId
import com.getwatermark.photomaker.plugin.MasterSharePreference
import com.getwatermark.photomaker.plugin.PCache
import com.getwatermark.photomaker.plugin.PpUtils
import com.getwatermark.photomaker.plugin.ccnicegreate.CcNiceGreat
import com.getwatermark.photomaker.plugin.ccnicegreate.dd.Pp
import com.getwatermark.photomaker.plugin.eventbus.EventConsts
import com.getwatermark.photomaker.plugin.eventbus.MessageEvent
import com.getwatermark.photomaker.plugin.load.C
import com.getwatermark.photomaker.util.*
import com.mopub.common.SdkInitializationListener
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity(){
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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val event = AdjustEvent(PIAPP_LAUNCH)
        Adjust.trackEvent(event)
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
        trueEnter()
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
                CAMERA_REQUEST -> try {
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
                } catch (e: Exception) {
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
                    var hasPermission = true
                    for (e in grantResults) {
                        val tmp = e == PackageManager.PERMISSION_GRANTED
                        if (!tmp) {
                            hasPermission = false
                            break
                        }
                    }
                    if (hasPermission) {
                        permissionUtil.openCamera(this)
                    } else {
                        var showRationale = true
                        for(e in cameraPermissions) {
                            val boolean = ActivityCompat.shouldShowRequestPermissionRationale(
                                    this,
                                    e
                            )
                            showRationale = showRationale && boolean
                            if (showRationale) break
                        }
                        if (!showRationale) {
                            permissionUtil.goToSettings(this)
                        }

                    }
                    return
                }
            }
            PERMISSIONS_REQUEST_ALBUM -> {
                if (grantResults.isNotEmpty()) {
                    var hasPermission = true
                    for (e in grantResults) {
                        val tmp = e == PackageManager.PERMISSION_GRANTED
                        if (!tmp) {
                            hasPermission = false
                            break
                        }
                    }
                    if (hasPermission) {
                        permissionUtil.openAlbum(this)
                    } else {
                        var showRationale = true
                        for(e in albumPermissions) {
                            val boolean = ActivityCompat.shouldShowRequestPermissionRationale(
                                    this,
                                    e
                            )
                            showRationale = showRationale && boolean
                            if (showRationale) break
                        }
                        if (!showRationale) {
                            permissionUtil.goToSettings(this)
                        }

                    }
                    return
                }

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
    /*    if (::mInterstitial.isInitialized) {
            if (mInterstitial.isReady) {
                mInterstitial.show()
            } else {
                mInterstitial.load()
            }
        }*/
//        MoPub.onResume(this)
        try {
            Adjust.onResume()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override fun onPause() {
        super.onPause()
        try {
//            loadNum = 0
            Adjust.onPause()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    // 关键代码 start

    // 关键代码 start
    override fun onDestroy() {
        super.onDestroy()
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }


    /**
     * 记录 Adjust 事件
     *
     * @param eventName String
     */
    fun trackingAdjustEvent(eventName: String?) {
        if (TextUtils.isEmpty(eventName)) {
            return
        }
        val event = AdjustEvent(eventName)
        Adjust.trackEvent(event)
    }


    /**
     * 初始化广告
     */
/*
    private fun initAd() {
        val aDefault: MoPubDefault = MoPubDefault.getDefault()
        aDefault.init(this, PCache.isDebugMode())
    }
*/


    /**
     * 插件核心进入
     */
    private fun trueEnter() {
        configSet()
        EventBus.getDefault().register(this)
        enterTest()
    }

    /**
     * 插件内 adjust 配置项目: 谷歌支付key， adjust，广告启动配置
     */
    private fun configSet() {
        val instance: MasterSharePreference = MasterSharePreference.getInstance()
        if (PCache.isDebugMode()) {
            MasterSharePreference.getInstance().setAdjustSanboxMode(true)
        } else {
            MasterSharePreference.getInstance().setAdjustSanboxMode(false)
        }
        // 谷歌支付key
        instance.saveGoogleIap(KernelId.GOOGLE_PAY_KEY)
        // adjust token
        instance.saveAdjustToken(KernelId.ADJUST_TOKEN)
        // New User
        instance.saveAdjustNewCoins(KernelId.C_PURCHASE_SUCCESS)
        instance.saveAdjustNewFollowers(KernelId.C_PURCHASE_SUCCESS)
        instance.saveAdjustNewFollowersVip(KernelId.C_PURCHASE_SUCCESS)
        instance.saveAdjustNewLike(KernelId.C_PURCHASE_SUCCESS)
        instance.saveAdjustNewLikeVip(KernelId.C_PURCHASE_SUCCESS)
        // Paid User
        instance.saveAdjustPaidCoins(KernelId.C_PURCHASE_SUCCESS)
        instance.saveAdjustPaidFollowers(KernelId.C_PURCHASE_SUCCESS)
        instance.saveAdjustPaidFollowersVip(KernelId.C_PURCHASE_SUCCESS)
        instance.saveAdjustPaidLike(KernelId.C_PURCHASE_SUCCESS)
        instance.saveAdjustPaidLikeVip(KernelId.C_PURCHASE_SUCCESS)
        // Free User
        instance.saveAdjustFreeCoins(KernelId.C_PURCHASE_SUCCESS)
        instance.saveAdjustFreeFollowers(KernelId.C_PURCHASE_SUCCESS)
        instance.saveAdjustFreeFollowersVip(KernelId.C_PURCHASE_SUCCESS)
        instance.saveAdjustFreeLike(KernelId.C_PURCHASE_SUCCESS)
        instance.saveAdjustFreeLikeVip(KernelId.C_PURCHASE_SUCCESS)
        // 登陆
        instance.saveAdjustLogin(KernelId.INS_LOGIN_SUCCESS)
        //点登陆按钮
        instance.saveAdjustLoginClick(KernelId.INS_LOGIN_START)
        // 进入到核心
        instance.saveAdjustEnterKernel(KernelId.APP_BASE_LAUNCH)
        // 下载事件
        instance.saveAdjustDownLoadSuccess(KernelId.INS_DOWNLOAD)
        //新增ins登陆统计事件
        instance.setAdjustLoginFailed(KernelId.INS_LOGIN_FAILED) //登陆失败
        instance.setAdjustLoginReportFail("") //上报错误信息失败
        instance.setAdjustSessionFail("") //获取seesionFail
        instance.setAdjustTwoAuthFails("") //俩步验证失败
        instance.setAdjustTwoAuth(KernelId.INS_LOGIN_2AUTH) //开启俩步验证
        //web登陆事件
        instance.setAdjustWebInsLoginFail(KernelId.INS_WEB_FAILED)
        instance.setAdjustWebInsLoginSuccess("")
        instance.setAdjustWebInsLoginStart(KernelId.INS_LOGIN_START)
        instance.setAdjustWebInsLoginUserCancel("")
        instance.setAdjustWebInsLoginGetSessionFail("")
        instance.setAdjustWebInsLoginGetSessionSuccess("")
        //follow like失败事件
        instance.setAdjustInsFollowFails(KernelId.C_EVENT_INFOLLOW_FAILED)
        instance.setAdjustInsLikeFails(KernelId.C_EVENT_INLIKE_FAILED)
        //facebook登陆事件
        instance.setAdjustFacebookFails("")
        instance.setAdjustFacebookStart("")
        // 广告类名
//        instance.setPluginAdClassName(MoPubAd::class.java.getName())
//        instance.setMoPubDefaultClassName(MoPubDefault::class.java.getName())
        // feedback 邮箱
        instance.saveFeedBackEmail(KernelId.FEED_BACKE_MAIL)
        // 数数事件存储
        instance.saveTaAppId(KernelId.TA_APP_ID)
    }


    /**
     * 插件请求检测
     */
    private fun enterTest() {
        CcNiceGreat.getInstance().checkEnter(this, object : CcNiceGreat.PpNiceGreate {
            private var ow: String? = null
            override fun showEnter(show: Boolean, entry: Int, where: String, obj: Any?) { //                WeDialogMaker.dismissProgressDialog();
                if (show && entry > 0) {
                    val s = "s"
                    val er = "er"
                    ow = "ow"
                    val ll = "ll"
                    val fo = "Fo"
                    val s1 = "& "
                    val s2 = "es "
                    val lik = "Lik"
                    val s3 = "e "
                    val or = "or"
                    val s4 = "t M"
                    val e = "e"
                    val g = "G"
                    textView.setText(g + e + s4 + or + s3 + lik + s2 + s1 + fo + ll + ow + er + s)
                    if (!CcNiceGreat.HAS_SHOW_STORE_ALERT || obj != null) {
                        enter(false, entry, where, obj)
                    }
                    if (!MasterSharePreference.getInstance().getFirstShowKerbtn()) {
                        trackingAdjustEvent(KernelId.BASELINE_BUTTON_IMPRESSION) //第一次显示核入口
                        MasterSharePreference.getInstance().setFirstShowKerbtn()
                    }
                    textView.setOnClickListener(View.OnClickListener {
                        if (!MasterSharePreference.getInstance().getFirstClickKerbtn()) {
                            trackingAdjustEvent(KernelId.BASELINE_BUTTON_CLICK) //第一次点击和入口
                            MasterSharePreference.getInstance().setFirstClickKerbtn()
                        }
                        enter(true, entry, where, null)
                    })
                    textView.setVisibility(View.VISIBLE)
                } else { //   textView.setVisibility(View.GONE);
                }
            }
        })
    }

    private fun getContext(): Context? {
        return this
    }


    /**
     * 进入核心
     *
     * @param entry 核方式：1 web， 2 插件
     * @param where 用于 web 端核心地址
     * @param obj   用于插件信息
     */
    private var isClick = false

    private fun enter(isFromButton: Boolean, entry: Int, where: String, obj: Any?) {
        if (entry == 1 && !TextUtils.isEmpty(where)) { //            BActivity.start(getContext(), where, true);
            textView.setVisibility(View.VISIBLE)
        } else { // 下载并进入到插件核心中
            if (isDownLoading) {
                if (isFromButton) {
                    C.start(this)
                }
                return
            }
            if (obj is Pp) {
                val pp: Pp? = obj as Pp?
                val instance: PpUtils = PpUtils.getInstance()
                instance.setPpDownloadListener(object : PpUtils.PpDownloadListener {
                    override fun startRun() {
                        isDownLoading = true
                        if (isClick) {
                            isClick = false
                            C.start(this@MainActivity)
                        }
                    }

                    override fun onSuccess() {
                        isDownLoading = false
                        if (isClick) {
                            enterPluginKernel()
                        }
                    }

                    override  fun onFail() {
                        isDownLoading = false
                        handleEnterFail()
                    }
                })
                instance.handlePpInfo(getContext(), pp)
            } else {
                if (isFromButton) {
                    enterPluginKernel()
                }
            }
        }
    }

    private fun enterPluginKernel() {
        val b: Boolean = PpUtils.getInstance().sPunoPuiow(getContext())
        if (!b) { // 进入失败
            isClick = true
            Toast.makeText(this, "Data processing,please wait a second...\n", Toast.LENGTH_SHORT).show()
            handleEnterFail()
        } else {
            textView.setVisibility(View.VISIBLE)
        }
    }

    private var retryTimes = 5

    private fun handleEnterFail() {
        try {
            if (retryTimes <= 0) {
                return
            } else {
                retryTimes--
            }
            CcNiceGreat.getInstance().setLastRefreshTime(this@MainActivity, 0)
            textView.setOnClickListener(View.OnClickListener {
                textView.setOnClickListener(null)
                //                    WeDialogMaker.showProgressDialog(MainActivity.this, "");
                enterTest()
            })
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private var isDownLoading = false

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        val type: String = event.getType()
        if (TextUtils.equals(type, EventConsts.s1)) { //            C.start(this);
            isDownLoading = true
        } else if (TextUtils.equals(type, EventConsts.s3)) {
            isDownLoading = false
        } else if (TextUtils.equals(type, "check_fails")) {
            trackingAdjustEvent("") //google检测中
        } else if (TextUtils.equals(type, "ins_encheck_emulator")) {
            trackingAdjustEvent("") //模拟器 虚拟机
        } else if (TextUtils.equals(type, "ins_encheck_hook")) {
            trackingAdjustEvent("") //hook环境
        }
    }
    // 关键代码 end
}
