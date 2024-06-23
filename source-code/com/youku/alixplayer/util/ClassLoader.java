package com.youku.alixplayer.util;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class ClassLoader {
    private static ClassLoader sApplicationClassLoader = null;
    private static int sDebuggable = -1;

    public static boolean isDebug() {
        if (sDebuggable == -1) {
            try {
                Context applicationContext = SystemUtil.getApplicationContext();
                if (applicationContext != null) {
                    if ((applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 0).flags & 2) != 0) {
                        sDebuggable = 1;
                    } else {
                        sDebuggable = 0;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return sDebuggable == 1;
    }

    public static Class<?> loadClass(String str) {
        try {
            ClassLoader classLoader = sApplicationClassLoader;
            return classLoader != null ? classLoader.loadClass(str) : Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setApplicationClassLoader(ClassLoader classLoader) {
        if (sApplicationClassLoader == null && classLoader != null) {
            sApplicationClassLoader = classLoader;
        }
    }
}
