package com.alibaba.aliweex.utils;

import android.text.TextUtils;
import android.util.Log;
import com.ali.watchmem.core.IJavaLowMemoryListener;
import com.ali.watchmem.core.INativeLowMemoryListener;
import com.ali.watchmem.core.WatchmemJavaMemoryManager;
import com.ali.watchmem.core.WatchmemNativeMemoryManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.av;
import tb.i4;

/* compiled from: Taobao */
public class MemoryMonitor {
    private static MemoryStatus a;
    private static MemoryStatus b;
    private static String c = "MemoryMonitor";
    private static Map<String, MemoryListener> d = new ConcurrentHashMap();
    private static boolean e = true;

    /* compiled from: Taobao */
    public interface MemoryListener {
        void onChange(String str);
    }

    /* compiled from: Taobao */
    enum MemoryStatus {
        NORMAL("good"),
        HIGH("normal"),
        DANGEROUS("dangerous"),
        CRITICAL("fatal");
        
        String status;

        private MemoryStatus(String str) {
            this.status = str;
        }

        /* access modifiers changed from: package-private */
        public boolean dangerous() {
            return equals(DANGEROUS);
        }

        /* access modifiers changed from: package-private */
        public boolean fatal() {
            return equals(CRITICAL);
        }

        /* access modifiers changed from: package-private */
        public boolean good() {
            return equals(NORMAL);
        }

        /* access modifiers changed from: package-private */
        public boolean normal() {
            return equals(HIGH);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements INativeLowMemoryListener {
        a() {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b implements IJavaLowMemoryListener {
        b() {
        }
    }

    static {
        MemoryStatus memoryStatus = MemoryStatus.NORMAL;
        a = memoryStatus;
        b = memoryStatus;
        String str = memoryStatus.status;
    }

    public static void a(String str, MemoryListener memoryListener) {
        if (!TextUtils.isEmpty(str) && memoryListener != null) {
            d.put(str, memoryListener);
        }
    }

    public static String b() {
        i4.e f;
        int i;
        if (!e) {
            return "unknown";
        }
        try {
            i4 d2 = i4.d();
            if (d2 == null || (f = d2.f()) == null || (i = f.a) == -1) {
                return "unknown";
            }
            return i != 0 ? i != 2 ? av.PARAM_LEVEL_MEDIUM : "low_end" : "high_end";
        } catch (Throwable unused) {
            e = false;
            return "unknown";
        }
    }

    public static String c() {
        if (a.good() && b.good()) {
            return MemoryStatus.NORMAL.status;
        }
        if (a.fatal() || b.fatal()) {
            return MemoryStatus.CRITICAL.status;
        }
        if (a.dangerous() || b.dangerous()) {
            return MemoryStatus.DANGEROUS.status;
        }
        if (a.normal() || b.normal()) {
            return MemoryStatus.HIGH.status;
        }
        return MemoryStatus.NORMAL.status;
    }

    public static void d() {
        try {
            WatchmemNativeMemoryManager.instance().addNativeLowMemoryListener(new a());
            WatchmemJavaMemoryManager.instance().addJavaLowMemoryListener(new b());
        } catch (Throwable th) {
            Log.e(c, th.getMessage());
        }
    }

    public static void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.remove(str);
        }
    }
}
