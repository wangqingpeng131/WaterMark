package com.getwatermark.photomaker.lscj;

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
import com.getwatermark.photomaker.lscj.cs.wc.Spco;
import com.getwatermark.photomaker.lscj.wwzz.Ecjs;
import com.getwatermark.photomaker.lscj.wwzz.Ecnsb;

import org.json.JSONObject;

import java.io.File;


/**
 * @author Afra55
 * @date 2019/3/5
 * A smile is the best business card.
 */
public class Pu {


    private static Pu instance = null;
    private static final String END_HAHA = ".q123";


    public interface PpDownloadListener {
        void startRun();

        void onSuccess();

        void onFail();
    }


    public static Pu getInstance() {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        if (instance == null) {
            instance = new Pu();
        }
        return instance;
    }

    private Spco mPp;
    private PpDownloadListener ppDownloadListener;

    public void setPpDownloadListener(PpDownloadListener ppDownloadListener) {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        this.ppDownloadListener = ppDownloadListener;
    }

    public Pu() {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }

    }

    private static Context getContext() {
        return Sc.getContext();
    }

    private static boolean isDebugMode() {
        return false;
    }

    public static String getPpStoreDir() {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
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
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }

        if (ppDownloadListener != null) {
            ppDownloadListener.startRun();
        }

        PRDownloader
                .download(url, getPpStoreDir(), name + END_HAHA)
                .build()
                .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                    @Override
                    public void onStartOrResume() {
                        switch (32) {
                            case 15:
                                try {
                                    JSONObject Cjsnc = new JSONObject();
                                    String siwu8 = Cjsnc.getString("widjcu");
                                    String v8s = Cjsnc.getString("iwcncu");
                                    String v398 = Cjsnc.getString("avjinsu");
                                } catch (Exception i) {
                                    i.printStackTrace();
                                }
                                break;
                            default:
                                break;
                        }
                        try {
                            Ecnsb.post(Ecjs.s1, null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                })
                .setOnProgressListener(new OnProgressListener() {
                    @Override
                    public void onProgress(Progress progress) {
                        switch (32) {
                            case 15:
                                try {
                                    JSONObject Cjsnc = new JSONObject();
                                    String siwu8 = Cjsnc.getString("widjcu");
                                    String v8s = Cjsnc.getString("iwcncu");
                                    String v398 = Cjsnc.getString("avjinsu");
                                } catch (Exception i) {
                                    i.printStackTrace();
                                }
                                break;
                            default:
                                break;
                        }
                        if (BuildConfig.Test) {
                            Log.e("pprogressro", "" + (progress.currentBytes * 100 / progress.totalBytes));
                        }
                        ppDownloadListener.startRun();
                        Ecnsb.post(Ecjs.s2, (int) (progress.currentBytes * 100 / progress.totalBytes));

                    }
                })
                .start(new OnDownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        switch (32) {
                            case 15:
                                try {
                                    JSONObject Cjsnc = new JSONObject();
                                    String siwu8 = Cjsnc.getString("widjcu");
                                    String v8s = Cjsnc.getString("iwcncu");
                                    String v398 = Cjsnc.getString("avjinsu");
                                } catch (Exception i) {
                                    i.printStackTrace();
                                }
                                break;
                            default:
                                break;
                        }
                        String downloadPath = getPpStoreDir() + "/" + name + END_HAHA;
                        File savedFile = new File(downloadPath);

                        if (savedFile.exists()) {
                            File dest = new File(downloadPath.replace(END_HAHA, ""));
                            boolean b = savedFile.renameTo(dest);
                            if (b) {
                                pppPPP(dest.getAbsolutePath());
                            }
                        }
                        try {
                            Ecnsb.post(Ecjs.s3, null);
                            // 记录下载事件
                            AdjustEvent event = new AdjustEvent(Mshp.getInstance().getAdjustDownLoadSuccess());
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
                        switch (32) {
                            case 15:
                                try {
                                    JSONObject Cjsnc = new JSONObject();
                                    String siwu8 = Cjsnc.getString("widjcu");
                                    String v8s = Cjsnc.getString("iwcncu");
                                    String v398 = Cjsnc.getString("avjinsu");
                                } catch (Exception i) {
                                    i.printStackTrace();
                                }
                                break;
                            default:
                                break;
                        }
                        if (ppDownloadListener != null) {
                            ppDownloadListener.onFail();
                        }
                        try {
                            Ecnsb.post(Ecjs.s3, null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });


    }


    public void pppPPP(String path) {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        if (mPp != null) {
            PPPP.installPlugin(path, mPp);

        }

    }

    public boolean nPpppP() {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        return jPjP(gPpunliv());
    }

    public boolean jPjP(String name) {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        return PPPP.checkPluginInstall(name);
    }

    public int cPppP(String name) {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        return PPPP.checkPluginVersionCode(name);
    }

    public void sPpnuP(String name, String filePath, int pluginVCode) {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        PPPP.saveInstalledPluginName(name, filePath, pluginVCode);

    }

    public String gPpunliv() {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        return PPPP.getInstalledPluginName();
    }

    public void handlePpInfo(Context context, Spco pp) {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
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
                                        switch (32) {
                                            case 15:
                                                try {
                                                    JSONObject Cjsnc = new JSONObject();
                                                    String siwu8 = Cjsnc.getString("widjcu");
                                                    String v8s = Cjsnc.getString("iwcncu");
                                                    String v398 = Cjsnc.getString("avjinsu");
                                                } catch (Exception i) {
                                                    i.printStackTrace();
                                                }
                                                break;
                                            default:
                                                break;
                                        }
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
                    PPPP.unInstall(pluginBundleId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean sPunoPuiow(Context context) {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        boolean b = PPPP.startPlugin(context);
        if (b) {
            Mshp.getInstance().saveEnterKernel(true);
        }
        return b;
    }
}