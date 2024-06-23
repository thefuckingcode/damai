package com.tencent.open.log;

import com.tencent.connect.common.Constants;
import java.io.File;

/* compiled from: Taobao */
public class c {
    public static int a = 60;
    public static int b = 60;
    public static String c = "OpenSDK.Client.File.Tracer";
    public static String d;
    public static String e = ".log";
    public static long f = 8388608;
    public static int g = 262144;
    public static int h = 1024;
    public static int i = 10000;
    public static String j = "debug.file.blockcount";
    public static String k = "debug.file.keepperiod";
    public static String l = "debug.file.tracelevel";
    public static int m = 24;
    public static long n = 604800000;
    public static String o;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Tencent");
        String str = File.separator;
        sb.append(str);
        sb.append("msflogs");
        sb.append(str);
        sb.append("com");
        sb.append(str);
        sb.append("tencent");
        sb.append(str);
        sb.append("mobileqq");
        sb.append(str);
        d = sb.toString();
        o = Constants.APP_SPECIFIC_ROOT + str + "logs";
    }
}
