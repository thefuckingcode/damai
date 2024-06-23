package com.ali.ha.fulltrace.dump;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import tb.jl1;
import tb.kv1;
import tb.lg0;
import tb.p91;

/* compiled from: Taobao */
public class DumpManager {
    public static final String LOG_PATH = "log";
    public static final String TAG = "FULLTRACE";
    private static volatile byte b = -1;
    public static long c;
    private volatile boolean a;

    /* compiled from: Taobao */
    private static final class a {
        private static final DumpManager a = new DumpManager();
    }

    static {
        try {
            System.loadLibrary("fulltrace");
            b = 0;
        } catch (Throwable th) {
            th.printStackTrace();
            b = 1;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void appendBytesBody(short s, long j, byte[] bArr);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void appendNoBody(short s, long j);

    public static final DumpManager c() {
        return a.a;
    }

    public static String d(Context context) {
        String replace = lg0.p.replace(jl1.CONDITION_IF_MIDDLE, '.');
        if (TextUtils.isEmpty(replace)) {
            return "";
        }
        return com.ali.ha.fulltrace.a.c(context, LOG_PATH + File.separator + replace);
    }

    public static String e(Context context) {
        String replace = lg0.p.replace(jl1.CONDITION_IF_MIDDLE, '.');
        if (TextUtils.isEmpty(replace)) {
            return "";
        }
        return com.ali.ha.fulltrace.a.b(context, LOG_PATH + File.separator + replace);
    }

    private native boolean init(String str, String str2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, String> hashMap3);

    private native void trim(String str, String str2);

    public void f(Application application, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        if (!this.a) {
            this.a = true;
            if (b != 0) {
                p91.b(TAG, "initing, but so was loaded failed!");
                return;
            }
            HashMap<String, String> a2 = kv1.a();
            String e = e(application);
            String d = d(application);
            c = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append(d);
            String str = File.separator;
            sb.append(str);
            sb.append(c);
            String sb2 = sb.toString();
            if (!init(sb2, e + str + c, hashMap, hashMap2, a2)) {
                b = 2;
            }
        }
    }

    public void g(String str, String str2) {
        if (b != 0) {
            p91.b(TAG, "Triming, but so was loaded failed!");
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            trim(str, str2);
        }
    }

    private DumpManager() {
        this.a = false;
    }
}
