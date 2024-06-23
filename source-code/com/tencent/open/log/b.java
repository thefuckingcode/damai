package com.tencent.open.log;

import android.text.TextUtils;
import com.tencent.open.log.d;
import com.tencent.open.utils.m;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: Taobao */
public class b {
    private static SimpleDateFormat a = d.C0241d.a("yy.MM.dd.HH");
    private String b = "Tracer.File";
    private int c = Integer.MAX_VALUE;
    private int d = Integer.MAX_VALUE;
    private int e = 4096;
    private long f = 10000;
    private File g;
    private int h = 10;
    private String i = ".log";
    private long j = AbsPerformance.LONG_NIL;

    public b(File file, int i2, int i3, int i4, String str, long j2, int i5, String str2, long j3) {
        a(file);
        b(i2);
        a(i3);
        c(i4);
        a(str);
        b(j2);
        d(i5);
        b(str2);
        c(j3);
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    private File[] d(long j2) {
        File b2 = b();
        String c2 = c(a(j2));
        try {
            b2 = new File(b2, c2);
        } catch (Throwable th) {
            SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
        }
        String b3 = m.b();
        File file = null;
        if (!TextUtils.isEmpty(b3) || b3 != null) {
            try {
                File file2 = new File(b3, c.o);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, c2);
            } catch (Exception e2) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e2);
            }
        }
        return new File[]{b2, file};
    }

    public File[] a() {
        return d(System.currentTimeMillis());
    }

    public File b() {
        File e2 = e();
        if (e2 != null) {
            e2.mkdirs();
        }
        return e2;
    }

    public File e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    public static String a(long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        return new SimpleDateFormat("yy.MM.dd.HH").format(instance.getTime());
    }

    public String c() {
        return this.b;
    }

    public void b(int i2) {
        this.d = i2;
    }

    public void c(int i2) {
        this.e = i2;
    }

    public void b(long j2) {
        this.f = j2;
    }

    public void c(long j2) {
        this.j = j2;
    }

    public void b(String str) {
        this.i = str;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(int i2) {
        this.c = i2;
    }

    public void a(File file) {
        this.g = file;
    }

    public int d() {
        return this.e;
    }

    public void d(int i2) {
        this.h = i2;
    }
}
