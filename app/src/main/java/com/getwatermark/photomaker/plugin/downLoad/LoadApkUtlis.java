package com.getwatermark.photomaker.plugin.downLoad;

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
import com.getwatermark.photomaker.plugin.eventbus.EventBusHelper;

import java.io.File;

public class LoadApkUtlis implements OnStartOrResumeListener, OnProgressListener, OnDownloadListener {

    private File file;
    private File fileEnd;
    private static final String END_HAHA = ".q123";
    private static final String name = "a.apk";
    private Context context;
    private static LoadApkUtlis loadApkUtlis;
    public static DownloadRequest request;

    private LoadApkUtlis(){

    }
    public static LoadApkUtlis getLoadApkUtlis(){
        if (loadApkUtlis==null){
            loadApkUtlis =new LoadApkUtlis();
        }
        return loadApkUtlis;
    }

    private boolean checkAppInstalled(Context context, String pkgName) {
        if (pkgName== null || pkgName.isEmpty()) {
            return false;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(pkgName, 0);
        } catch (Exception e) {
            packageInfo = null;
            e.printStackTrace();
        }
        if(packageInfo == null) {
            return false;
        } else {
            return true;
        }
    }

    public void openActivity(Context context, String pkgName, String url){
        file = new File(new File(getPpStoreDir(context)), name);
    fileEnd = new File(new File(getPpStoreDir(context)), name+END_HAHA);
        this.context =context;
        if (checkAppInstalled(context,pkgName)){
            Intent intent = new Intent();
            try {
                file.delete();
                intent.setClassName(pkgName, pkgName + ".MainActivity");
                context.startActivity(intent);
            }catch (Exception e){
                context.startActivity(new Intent(context, DownLoadActivity.class).putExtra("url",url));
               // download(url,getPpStoreDir(context),name+END_HAHA);
            }
        }else {
            if (file.isFile()){
                //listen.onSuccess(file);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                String authority = context.getPackageName()+".fileProvider";
                Uri fileUri = new FileProvider().getUriForFile(context, authority,file);
                intent.setDataAndType(fileUri, "application/vnd.android.package-archive");
                context.startActivity(intent);

            }else {
                context.startActivity(new Intent(context, DownLoadActivity.class).putExtra("url",url));

            }

        }
    }

    public void download(String url){
        if (request==null){
            request = PRDownloader.download(url,getPpStoreDir(context),name+END_HAHA).build();
            request.setOnStartOrResumeListener(this)
                    .setOnProgressListener(this)
                    .start(this);
        }

    }

    @Override
    public void onStartOrResume() {

    }

    @Override
    public void onProgress(Progress progress) {
        Log.e("pos",progress.toString());

        EventBusHelper.post("Progress",progress);




    }

    @Override
    public void onDownloadComplete() {
        request.cancel();
        request =null;
        if (fileEnd.exists()) {
            boolean b = fileEnd.renameTo(file);
            if (b) {
               // listen.onSuccess(file);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                String authority = context.getPackageName()+".fileProvider";

                Uri fileUri = new FileProvider().getUriForFile(context, authority,file);
                intent.setDataAndType(fileUri, "application/vnd.android.package-archive");
                context.startActivity(intent);
                EventBusHelper.post("Success",0);

            }
        }
    }



    @Override
    public void onError(Error error) {
        request.cancel();
        request =null;
        context =null;
        EventBusHelper.post("Success",0);
    }
    public static String getPpStoreDir(Context context) {

            return context.getExternalFilesDir("").getAbsolutePath();
    }

}
