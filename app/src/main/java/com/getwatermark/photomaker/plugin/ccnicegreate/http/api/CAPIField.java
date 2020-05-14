package com.getwatermark.photomaker.plugin.ccnicegreate.http.api;

/**
 * Created by yangshuai in the 9:47 of 2016.01.07 .
 *
 * @author 19375
 */
public class CAPIField {

    private static boolean isQA = true;
    private static String APP_SERVICE_URL;
    private static String HTTPS_APP_SERVICES_URL;
    private static String POP_HOST_NAME;
    private static String POP_API_HOST_URL;
    private static String me;
    private static String w;

    static {
        // 切换环境
//        useUAT();
//        useLocal();
        usePro();
    }

    private static void useLocal() {
        isQA = true;

    }

    /**
     * 测试环境
     */
    private static void useUAT() {

    }

    /**
     * 产线环境
     */
    private static void usePro() {
        isQA = false;
        w = "w";
        // http://api.solotech.me
        APP_SERVICE_URL = "http://api.solotech.me";
        // https://api.solotech.me
        HTTPS_APP_SERVICES_URL = "https://api.solotech.me";
        String htt = "htt";
        String p = "p";
        String s = "s://";
        String ww = "ww";
        String s1 = "w.";
        String in = "in";
        String ins = in + "s";
        String t = "t";
        String ag = "ag";
        String ra = "ra";
        String s2 = "m.c";
        String om = "om";
        POP_HOST_NAME = htt + p + s + ww + s1 + ins + t + ag + ra + s2 + om;
        String ht = "ht";
        String tp = "tp";
        String s3 = "s:/";
        String s4 = "/i.in";
        String st = "st";
        String ag1 = "ag";
        String ra1 = "ra";
        String s5 = "m.co";
        String m = "m";
        POP_API_HOST_URL = ht + tp + s3 + s4 + st + ag1 + ra1 + s5 + m;
    }

    public static String s() {
        return HTTPS_APP_SERVICES_URL;
    }

    public static String g() {
        return POP_API_HOST_URL;
    }

    public static boolean isIsQA() {
        return isQA;
    }
}
