package com.uc.webview.export.internal.utility;

import android.content.Context;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.internal.setup.UCSetupException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public final class h {
    private static ConcurrentHashMap<ClassLoader, a> a = new ConcurrentHashMap<>();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        public String a;
        public String b;
        public String c;
        public String[][] d;
        public String[][] e;

        private a() {
        }

        public final String toString() {
            return "coreVersion:" + this.a + ", ucmVersion:" + this.b + ", supportSdkMinVersion:" + this.c;
        }
    }

    public static String a(ClassLoader classLoader) {
        a aVar = a.get(classLoader);
        if (aVar != null) {
            return aVar.a;
        }
        return (String) a(classLoader, "com.uc.webview.browser.shell.Build", "CORE_VERSION");
    }

    public static String b(ClassLoader classLoader) {
        a aVar = a.get(classLoader);
        if (aVar != null) {
            return aVar.b;
        }
        return (String) a(classLoader, "com.uc.webview.browser.shell.Build$Version", "NAME");
    }

    public static String c(ClassLoader classLoader) {
        a aVar = a.get(classLoader);
        if (aVar != null) {
            return aVar.c;
        }
        return (String) a(classLoader, "com.uc.webview.browser.shell.Build$Version", "SUPPORT_SDK_MIN");
    }

    public static String[][] d(ClassLoader classLoader) {
        a aVar = a.get(classLoader);
        if (aVar != null) {
            return aVar.d;
        }
        return (String[][]) a(classLoader, "com.uc.webview.browser.shell.NativeLibraries", "LIBRARIES");
    }

    public static String[][] e(ClassLoader classLoader) {
        a aVar = a.get(classLoader);
        if (aVar != null) {
            return aVar.e;
        }
        return (String[][]) a(classLoader, "com.uc.webview.browser.shell.PakAssets", "ASSETS");
    }

    public static String[] f(ClassLoader classLoader) {
        try {
            ArrayList arrayList = new ArrayList();
            String[][] d = d(classLoader);
            for (String[] strArr : d) {
                if (!(strArr == null || strArr[0] == null)) {
                    arrayList.add(strArr[0]);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        } catch (Exception e) {
            Log.d("SdkShellUtils", "getCoreSoList failed", e);
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:1|2|3|4|5|6|7|8|9|10|(1:12)(2:13|14)) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008f, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        throw new com.uc.webview.export.internal.setup.UCSetupException(4015, r9);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0034 */
    public static void a(UCMPackageInfo uCMPackageInfo, Context context, ClassLoader classLoader, ConcurrentHashMap<String, Object> concurrentHashMap) {
        int indexOf;
        try {
            Class<?> cls = Class.forName("com.uc.webview.browser.shell.SdkAuthentication", true, classLoader);
            int i = 0;
            Method method = cls.getMethod("tryLoadUCCore", Context.class, UCMPackageInfo.class, HashMap.class);
            HashMap hashMap = new HashMap(concurrentHashMap.size());
            hashMap.putAll(concurrentHashMap);
            Object[] objArr = {context, uCMPackageInfo, hashMap};
            method = cls.getMethod("tryLoadUCCore", Context.class, UCMPackageInfo.class);
            objArr = new Object[]{context, uCMPackageInfo};
            try {
                if (!(!p.b((Boolean) ReflectionUtil.invoke((Object) null, cls, method, objArr)))) {
                    throw new UCSetupException(4017, "tryLoadUCCore return false.");
                }
            } catch (UCKnownException e) {
                throw e;
            } catch (Throwable th) {
                String message = th.getMessage();
                if (message != null && (indexOf = message.indexOf("9")) == 0) {
                    try {
                        i = p.c(message.substring(indexOf, indexOf + 4));
                    } catch (Exception unused) {
                    }
                }
                if (i >= 9000) {
                    throw new UCSetupException(i, th);
                }
                throw new UCSetupException(4016, th);
            }
        } catch (ClassNotFoundException e2) {
            throw new UCSetupException(4014, e2);
        }
    }

    private static Object a(ClassLoader classLoader, String str, String str2) {
        try {
            Field declaredField = Class.forName(str, true, classLoader).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            Log.d("SdkShellUtils", "getValue failed, loader:" + classLoader, e);
            return null;
        }
    }
}
