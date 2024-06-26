package com.uc.sandboxExport;

import android.os.Build;

@Api
/* compiled from: Taobao */
public class DexFileResolver {
    private static boolean a;

    public static Object loadDexByFd(int i) {
        if (!a) {
            System.loadLibrary("servicedexloader");
            a = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return Long.valueOf(nativeLoadDexByFdOnL(i));
        }
        return nativeLoadDexByFdOnLAbove(i);
    }

    private static native long nativeLoadDexByFdOnL(int i);

    private static native Object nativeLoadDexByFdOnLAbove(int i);
}
