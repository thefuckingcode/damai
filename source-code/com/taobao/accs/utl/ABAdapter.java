package com.taobao.accs.utl;

import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.android.ab.api.ABGlobal;

/* compiled from: Taobao */
public class ABAdapter {
    private static final String TAG = "ABAdapter-";
    public static boolean mABValid;

    static {
        try {
            Class.forName("com.taobao.android.ab.api.ABGlobal");
            mABValid = true;
        } catch (Exception unused) {
            mABValid = false;
            ALog.e(TAG, "mABValid=" + mABValid, new Object[0]);
        }
    }

    public static boolean isFeatureOpened(String str) {
        boolean z;
        Throwable th;
        if (!mABValid) {
            return false;
        }
        try {
            z = ABGlobal.isFeatureOpened(GlobalClientInfo.getContext(), str);
            try {
                ALog.i(TAG, "isFeatureOpened", "featureName", str, "opened", Boolean.valueOf(z));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
            ALog.e(TAG, "isFeatureOpened", th, new Object[0]);
            return z;
        }
        return z;
    }
}
