package com.getwatermark.photomaker.plugin;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.didi.virtualapk.PluginManager;
import com.getwatermark.photomaker.plugin.ccnicegreate.dd.Pp;

import java.io.File;


/**
 * @author Afra55
 * @date 2019/3/7
 * A smile is the best business card.
 */
public class PppUtils {
    private static final String PS_NAME = "pp_ps";
    private static    Boolean  isInstall =false;
    public static boolean installPlugin(String path, Pp pp) {

        MasterSharePreference.getInstance().saveStartKernel();


        String  pluginBundleId = pp.getPluginBundleId();
            return installPlugin(path, pluginBundleId, pp.getVersionCode());

    }



    public static boolean installPlugin(String path, String pluginBundleId, int pluginVCode) {
        File file = new File(path);

        if (file.exists() && file.isFile() && file.getName().endsWith(".apk")) {
            try {

                PluginManager.getInstance(PCache.getContext()).loadPlugin(file);
                saveInstalledPluginName(pluginBundleId, path, pluginVCode);
                isInstall =true;

                return true;
            } catch (Exception e) {
                if (PCache.isDebugMode()) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private static Context getContext() {
        return PCache.getContext();
    }
    public static boolean checkPluginInstall() {
        return checkPluginInstall(getInstalledPluginName());
    }

    public static boolean checkPluginInstall(String name) {
        if (TextUtils.isEmpty(name)) {
            return false;
        }
        try {
            String installedPluginFilePath = getInstalledPluginFilePath(name);
            if (!TextUtils.isEmpty(installedPluginFilePath)) {
                File file = new File(installedPluginFilePath);
                return file.exists();
            }
        } catch (Exception e) {
            if (PCache.isDebugMode()) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static int checkPluginVersionCode(String name) {
        if (TextUtils.isEmpty(name)) {
            return -1;
        }
        try {
            return getInstalledPluginVCode(name);
        } catch (Exception e) {
            if (PCache.isDebugMode()) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static void saveInstalledPluginName(String name, String filePath, int pluginVCode) {
        try {
            getContext().getSharedPreferences(PS_NAME, Context.MODE_PRIVATE)
                    .edit().putString("pp_name", name).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveInstalledPluginFilePath(name, filePath);

        saveInstalledPluginVCode(name, pluginVCode);
    }
    public static void saveInstalledPluginFilePath(String name, String path) {
        try {
            getContext().getSharedPreferences(PS_NAME, Context.MODE_PRIVATE)
                    .edit().putString(name + "_pp_path", path).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void saveInstalledPluginVCode(String name, int pluginVCode) {
        try {
            getContext().getSharedPreferences(PS_NAME, Context.MODE_PRIVATE)
                    .edit().putInt(name + "_pp_VCode", pluginVCode).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getInstalledPluginName() {
        try {
            return getContext().getSharedPreferences(PS_NAME, Context.MODE_PRIVATE).getString("pp_name", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String getInstalledPluginFilePath(String name) {
        try {
            return getContext().getSharedPreferences(PS_NAME, Context.MODE_PRIVATE).getString(name + "_pp_path", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int getInstalledPluginVCode(String name) {
        try {
            return getContext().getSharedPreferences(PS_NAME, Context.MODE_PRIVATE).getInt(name + "_pp_VCode", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }




    public static boolean startPlugin(Context context) {
        String installPluginName = getInstalledPluginName();
        if (TextUtils.isEmpty(installPluginName)) {
            return false;
        }
        if (!checkPluginInstall(installPluginName)) {
            return false;
        }

//        try {
//            openRealPlugin(context, installPluginName);
//            return true;
//        } catch (Exception e) {
            try {
                String installedPluginFilePath = getInstalledPluginFilePath(installPluginName);

                if (isInstall){
                    openRealPlugin(context, installPluginName);
                    return true;

                }
                if (!TextUtils.isEmpty(installedPluginFilePath)) {
                    boolean b = installPlugin(installedPluginFilePath, installPluginName, getInstalledPluginVCode(installPluginName));
                    if (b) {
                        openRealPlugin(context, installPluginName);
                        return true;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
//        }
        return false;

    }

    private static void openRealPlugin(Context context, String installPluginName) {
        Intent intent = new Intent();
        intent.setClassName(installPluginName, installPluginName + ".MainActivity");
        context.startActivity(intent);
    }

    public static void unInstall(String pluginBundleId) {
    }
}
