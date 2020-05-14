package com.getwatermark.photomaker.plugin;

import android.content.Context;

/**
 * @author Afra55
 * @date 2019/4/2
 * A smile is the best business card.
 */
public class PCache {

    private static Context context;

    private static boolean isDebugMode;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        PCache.context = context;
    }

    public static boolean isDebugMode() {
        return isDebugMode;
    }

    public static void setIsDebugMode(boolean isDebugMode) {
        PCache.isDebugMode = isDebugMode;
    }
}
