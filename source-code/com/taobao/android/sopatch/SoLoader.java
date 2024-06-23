package com.taobao.android.sopatch;

import androidx.annotation.Keep;
import com.taobao.android.sopatch.common.Constants;
import com.taobao.android.sopatch.exception.VerifyErrorException;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.util.HashMap;
import java.util.Map;
import tb.hc2;
import tb.ih2;
import tb.lc2;
import tb.mc2;
import tb.oc2;
import tb.rc2;
import tb.s91;

@Keep
/* compiled from: Taobao */
public final class SoLoader {
    private static final Object DEFAULT_LOADED_OBJECT = new Object();
    private static final String TAG = "SoLoader";
    private static final Map<String, a> loadedObjectMap = new HashMap();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private volatile Object a;

        private a() {
        }
    }

    private static String getFullLibName(String str) {
        int i;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1 && str.length() > (i = lastIndexOf + 1)) {
            return str.substring(i);
        }
        if (str.endsWith(".so")) {
            return str;
        }
        return SolidMonitor.CHECK_TYPE_LIB + str + ".so";
    }

    private static a getLoadedObject(String str) {
        a aVar;
        Map<String, a> map = loadedObjectMap;
        synchronized (map) {
            aVar = map.get(str);
            if (aVar == null) {
                aVar = new a();
                map.put(str, aVar);
            }
        }
        return aVar;
    }

    private static void innerLoad(String str, Runnable runnable) {
        Object obj;
        String fullLibName = getFullLibName(str);
        a loadedObject = getLoadedObject(str);
        lc2 lc2 = null;
        if (loadedObject.a == null) {
            synchronized (loadedObjectMap) {
                if (loadedObject.a == null) {
                    lc2 = mc2.c().b(fullLibName);
                    loadedObject.a = matchBrothersPatchMode(lc2, fullLibName);
                }
            }
        }
        if (lc2 == null || loadedObject.a == (obj = DEFAULT_LOADED_OBJECT)) {
            runnable.run();
            return;
        }
        hc2 b = lc2.b(fullLibName);
        if (b != null) {
            try {
                loadSoPatch(b);
                oc2.a(true, lc2.d(), Constants.Stage.EFFECTIVE, 0, 0, lc2.toString(), (long) lc2.e());
                s91.b(TAG, "patch load success", b.toString());
            } catch (Throwable th) {
                oc2.a(false, lc2.d(), Constants.Stage.EFFECTIVE, 0, -1, lc2.toString(), (long) lc2.e());
                s91.b(TAG, "patch load fail", th.getMessage());
                runnable.run();
                loadedObject.a = DEFAULT_LOADED_OBJECT;
            }
        } else {
            runnable.run();
            loadedObject.a = obj;
        }
    }

    @Keep
    public static void load(final String str) {
        if (!ih2.a(Constants.NEED_SO_PATCH, false)) {
            System.load(str);
            s91.b(TAG, "before so patch start", str);
            return;
        }
        innerLoad(str, new Runnable() {
            /* class com.taobao.android.sopatch.SoLoader.AnonymousClass1 */

            public void run() {
                System.load(str);
                s91.a(SoLoader.TAG, "system load success", str);
            }
        });
    }

    @Keep
    public static void loadLibrary(final String str) {
        if (!ih2.a(Constants.NEED_SO_PATCH, false)) {
            System.loadLibrary(str);
            s91.b(TAG, "before so patch start", str);
            return;
        }
        innerLoad(str, new Runnable() {
            /* class com.taobao.android.sopatch.SoLoader.AnonymousClass2 */

            public void run() {
                System.loadLibrary(str);
                s91.a(SoLoader.TAG, "system load success", str);
            }
        });
    }

    private static void loadSoPatch(hc2 hc2) throws VerifyErrorException, UnsatisfiedLinkError {
        if (!ih2.a("forceVerify", false) || rc2.d(hc2)) {
            System.load(hc2.c());
            return;
        }
        throw new VerifyErrorException();
    }

    private static Object matchBrothersPatchMode(lc2 lc2, String str) {
        a aVar;
        if (lc2 == null) {
            return DEFAULT_LOADED_OBJECT;
        }
        for (String str2 : lc2.c().keySet()) {
            if (!(str.equals(str2) || (aVar = loadedObjectMap.get(str2)) == null || aVar.a == lc2)) {
                if (!(aVar.a instanceof lc2) || ((lc2) aVar.a).b(str) != null) {
                    return aVar.a;
                }
                return lc2;
            }
        }
        return lc2;
    }
}
