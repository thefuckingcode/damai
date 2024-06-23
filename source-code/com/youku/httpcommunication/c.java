package com.youku.httpcommunication;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: Taobao */
public class c {
    public static String a = (Environment.getExternalStorageDirectory().getPath() + "/youku/cacheData/");
    static volatile boolean b = false;
    private static final String[] c;
    private static String[] d;
    private static int e = 0;
    private static final String f = System.getProperty("line.separator");

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements Comparator<File> {
        a() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            if (file.lastModified() > file2.lastModified()) {
                return 1;
            }
            return file.lastModified() == file2.lastModified() ? 0 : -1;
        }
    }

    static {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String[] strArr = {"statis.api.3g.youku.com", "api.mobile.youku.com", "openapi.youku.com", "count.atm.youku.com", "v2html.atm.youku.com", "account.youku.com", "v.youku.com", "c.yes.youku.com", "www.youku.com", "iku.youku.com", "myes.youku.com", "iyes.youku.com", "valf.atm.youku.com", "cm.miaozhen.atm.youku.com", "tip.soku.com", "pcclient.relay.youku.com", "ups.youku.com", "huodong.m.taobao.com"};
        c = strArr;
        d = strArr;
    }

    public static void a() {
        if (!b) {
            b = true;
            new Utils$1().start();
        }
    }

    public static void a(File file, File file2) {
        if (file != null) {
            File[] listFiles = file.listFiles();
            int i = e;
            if (i == 0) {
                if (listFiles != null) {
                    int i2 = 0;
                    for (File file3 : listFiles) {
                        i2 = (int) (((long) i2) + file3.length());
                    }
                    e = i2;
                } else {
                    return;
                }
            } else if (file2 != null) {
                e = (int) (((long) i) + file2.length());
                a.b("HttpCommunication.Utils", "cacheData after add file " + e);
            }
            if (e >= 10485760 && listFiles != null) {
                int length = (int) ((((double) listFiles.length) * 0.4d) + 1.0d);
                System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
                try {
                    Arrays.sort(listFiles, new a());
                } catch (Exception e2) {
                    a.a("HttpCommunication.Utils", "NetworkUtils", e2);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    listFiles[i3].delete();
                }
                e = 0;
                a(file, null);
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : d) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void b() {
        if (c()) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public static boolean b(String str) {
        return !c(str);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT < 8;
    }

    public static boolean c(String str) {
        int length;
        if (!(str == null || (length = str.length()) == 0)) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String d(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        } catch (NullPointerException e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static boolean d() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.a.getSystemService("connectivity");
            if (connectivityManager == null) {
                a.b("NetWorkState", "Unavailabel");
                return false;
            }
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        a.b("NetWorkState", "Availabel");
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
