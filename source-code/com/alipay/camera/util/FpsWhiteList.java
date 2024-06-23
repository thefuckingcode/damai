package com.alipay.camera.util;

import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import java.util.HashSet;
import java.util.Iterator;
import tb.jl1;

/* compiled from: Taobao */
public class FpsWhiteList {
    public static final String TAG = "FpsWhiteList";
    private static HashSet<String> a;

    public static boolean inWhiteList(String str, String str2) {
        boolean z;
        if (a == null) {
            return false;
        }
        String str3 = str + "/" + str2;
        if (str3 == null) {
            return false;
        }
        String lowerCase = str3.toLowerCase();
        HashSet<String> hashSet = a;
        if (hashSet != null && !hashSet.isEmpty()) {
            Iterator<String> it = a.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (lowerCase.startsWith(it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        MPaasLogger.d(TAG, new Object[]{"FpsWhiteList Contained(", Boolean.valueOf(z), jl1.BRACKET_END_STR});
        return z;
    }

    public static void refreshCurrentDeviceInList(String str) {
        if (BQCCameraParam.VALUE_YES.equalsIgnoreCase(str)) {
            String str2 = Build.getBRAND() + "/" + Build.getMODEL();
            if (str2 != null) {
                String lowerCase = str2.toLowerCase();
                if (a == null) {
                    a = new HashSet<>();
                }
                a.add(lowerCase);
            }
        }
    }
}
