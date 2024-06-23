package com.tencent.smtt.export.external;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.util.ArrayList;

public class LibraryLoader {
    private static String[] sLibrarySearchPaths;

    public static String[] getLibrarySearchPaths(Context context) {
        String[] strArr = sLibrarySearchPaths;
        if (strArr != null) {
            return strArr;
        }
        if (context == null) {
            return new String[]{"/system/lib"};
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(getNativeLibraryDir(context));
        arrayList.add("/system/lib");
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        sLibrarySearchPaths = strArr2;
        return strArr2;
    }

    public static String getNativeLibraryDir(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 9) {
            return context.getApplicationInfo().nativeLibraryDir;
        }
        if (i >= 4) {
            return context.getApplicationInfo().dataDir + "/lib";
        }
        return "/data/data/" + context.getPackageName() + "/lib";
    }

    public static void loadLibrary(Context context, String str) throws UnsatisfiedLinkError {
        String[] librarySearchPaths = getLibrarySearchPaths(context);
        String mapLibraryName = System.mapLibraryName(str);
        for (String str2 : librarySearchPaths) {
            String str3 = str2 + "/" + mapLibraryName;
            if (new File(str3).exists()) {
                try {
                    System.load(str3);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        try {
            System.loadLibrary(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
