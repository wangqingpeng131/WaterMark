package com.getwatermark.photomaker.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.getwatermark.photomaker.BuildConfig;
import com.getwatermark.photomaker.plugin.ccnicegreate.dd.Pp;
import com.getwatermark.photomaker.plugin.eventbus.EventBusHelper;
import com.getwatermark.photomaker.plugin.eventbus.EventConsts;

import java.io.File;


/**
 * @author Afra55
 * @date 2019/3/5
 * A smile is the best business card.
 */
public class PpUtils {


    private static PpUtils instance = null;
    private static final String END_HAHA = ".q123";





    public interface PpDownloadListener {
        void startRun();

        void onSuccess();

        void onFail();
    }


    public static PpUtils getInstance() {
        if (instance == null) {
            instance = new PpUtils();
        }
        return instance;
    }

    private Pp mPp;
    private PpDownloadListener ppDownloadListener;

    public void setPpDownloadListener(PpDownloadListener ppDownloadListener) {
        this.ppDownloadListener = ppDownloadListener;
    }

    public PpUtils() {

    }

    private static Context getContext() {
        return PCache.getContext();
    }

    private static boolean isDebugMode() {
        return false;
    }

    public static String getPpStoreDir() {
        if (isDebugMode()) {
            File filesDir = getContext().getExternalFilesDir("pp");
            if (filesDir == null) {
                return getContext().getFilesDir().getAbsolutePath();
            }
            return filesDir.getAbsolutePath();
        } else {
            return getContext().getFilesDir().getAbsolutePath();
        }
    }

    public void start(String url, String name) {

        if (ppDownloadListener != null) {
            ppDownloadListener.startRun();
        }

        PRDownloader
                .download(url, getPpStoreDir(), name + END_HAHA)
                .build()
                .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                    @Override
                    public void onStartOrResume() {
                        try {
                            EventBusHelper.post(EventConsts.s1, null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                })
                .setOnProgressListener(new OnProgressListener() {
                    @Override
                    public void onProgress(Progress progress) {
                        if (BuildConfig.Test){
                            Log.e("pprogressro",""+(progress.currentBytes*100/progress.totalBytes));
                        }
                        ppDownloadListener.startRun();
                        EventBusHelper.post(EventConsts.s2, (int)(progress.currentBytes*100/progress.totalBytes));

                    }
                })
                .start(new OnDownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        String downloadPath = getPpStoreDir()+"/"+name + END_HAHA;
                        File savedFile = new File(downloadPath);

                        if (savedFile.exists()) {
                            File dest = new File(downloadPath.replace(END_HAHA, ""));
                            boolean b = savedFile.renameTo(dest);
                            if (b) {
                                pppPPP(dest.getAbsolutePath());
                            }
                        }
                        try {
                            EventBusHelper.post(EventConsts.s3, null);
                            // 记录下载事件
                            AdjustEvent event = new AdjustEvent(MasterSharePreference.getInstance().getAdjustDownLoadSuccess());
                            Adjust.trackEvent(event);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (ppDownloadListener != null) {
                            ppDownloadListener.onSuccess();
                        }

                    }



                    @Override
                    public void onError(Error error) {
                        if (ppDownloadListener != null) {
                            ppDownloadListener.onFail();
                        }
                        try {
                            EventBusHelper.post(EventConsts.s3, null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });


    }





    public void pppPPP(String path) {
        if (mPp!=null){
            PppUtils.installPlugin(path, mPp);

        }

    }

    public boolean nPpppP() {
        return jPjP(gPpunliv());
    }

    public boolean jPjP(String name) {
        return PppUtils.checkPluginInstall(name);
    }

    public int cPppP(String name) {
        return PppUtils.checkPluginVersionCode(name);
    }

    public void sPpnuP(String name, String filePath, int pluginVCode) {
        PppUtils.saveInstalledPluginName(name, filePath, pluginVCode);

    }

    public String gPpunliv() {
        return PppUtils.getInstalledPluginName();
    }

    public void handlePpInfo(Context context, Pp pp) {
        try {
            if (pp == null) {
                return;
            }
            mPp = pp;
            String pluginBundleId = mPp.getPluginBundleId();
            boolean b = jPjP(pluginBundleId);
            if (pp.isBFlag()) {
                // 安装

                if (!b || cPppP(pluginBundleId) < mPp.getVersionCode()) {
                    int updateWay = mPp.getUpdateWay();
                    if (updateWay == 1) {
                        // 静默下载
                        start(mPp.getUrl(), mPp.getPluginName());
                    } else if (updateWay == 2) {
                        // 提示下载
                        new AlertDialog.Builder(context)
                                .setTitle("")
                                .setMessage(pp.getDescription())
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        start(mPp.getUrl(), mPp.getPluginName());
                                    }
                                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                                .create().show();

                    } else {
                        start(pp.getUrl(), pp.getPluginName());
                    }

                } else {
                    if (b) {
                        // 如果已经安装
                        if (ppDownloadListener != null) {
                            ppDownloadListener.onSuccess();
                        }
                    }
                }
            } else {
                // 卸载
                sPpnuP("", "", 0);
                if (b) {
                    PppUtils.unInstall(pluginBundleId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean sPunoPuiow(Context context) {
        boolean b = PppUtils.startPlugin(context);
        if (b) {
            MasterSharePreference.getInstance().saveEnterKernel(true);
        }
        return b;
    }
}