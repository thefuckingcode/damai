package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.text.SimpleDateFormat;
import java.util.Locale;
import tb.jl1;
import tb.v00;

/* compiled from: Taobao */
public class c {
    public final StringBuilder a = new StringBuilder();
    public String b = null;
    public String c = "HMS";
    public int d = 0;
    public long e = 0;
    public long f = 0;
    public String g;
    public int h;
    public int i;
    public int j = 0;

    public c(int i2, String str, int i3, String str2) {
        this.j = i2;
        this.b = str;
        this.d = i3;
        if (str2 != null) {
            this.c = str2;
        }
        b();
    }

    public static String a(int i2) {
        if (i2 == 3) {
            return "D";
        }
        if (i2 == 4) {
            return "I";
        }
        if (i2 != 5) {
            return i2 != 6 ? String.valueOf(i2) : ExifInterface.LONGITUDE_EAST;
        }
        return ExifInterface.LONGITUDE_WEST;
    }

    public final c b() {
        this.e = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f = currentThread.getId();
        this.h = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i2 = this.j;
        if (length > i2) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            this.g = stackTraceElement.getFileName();
            this.i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        a(sb);
        return sb.toString();
    }

    public <T> c a(T t) {
        this.a.append((Object) t);
        return this;
    }

    public c a(Throwable th) {
        a((Object) '\n').a(Log.getStackTraceString(th));
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    public final StringBuilder a(StringBuilder sb) {
        sb.append(' ');
        sb.append(this.a.toString());
        return sb;
    }

    public final StringBuilder b(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append(jl1.ARRAY_START);
        sb.append(simpleDateFormat.format(Long.valueOf(this.e)));
        String a2 = a(this.d);
        sb.append(' ');
        sb.append(a2);
        sb.append(v00.DIR);
        sb.append(this.c);
        sb.append(v00.DIR);
        sb.append(this.b);
        sb.append(' ');
        sb.append(this.h);
        sb.append(jl1.CONDITION_IF_MIDDLE);
        sb.append(this.f);
        sb.append(' ');
        sb.append(this.g);
        sb.append(jl1.CONDITION_IF_MIDDLE);
        sb.append(this.i);
        sb.append(jl1.ARRAY_END);
        return sb;
    }
}
