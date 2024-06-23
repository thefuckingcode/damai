package com.alipay.camera.util;

import android.os.AsyncTask;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
public class WalletBehaviorBury {
    public static final String TAG = "WalletBehaviorBury";

    public static void bury(final String str, final Class[] clsArr, final Object[] objArr) {
        CameraLog.d(TAG, "bury, method:" + str);
        new AsyncTask<Object, Object, Object>() {
            /* class com.alipay.camera.util.WalletBehaviorBury.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Object doInBackground(Object... objArr) {
                try {
                    Class.forName("com.alipay.mobile.bqcscanservice.behavior.BehaviorBury").getMethod(str, clsArr).invoke(null, objArr);
                } catch (IllegalAccessException e) {
                    CameraLog.e(WalletBehaviorBury.TAG, e.getMessage());
                } catch (InvocationTargetException e2) {
                    CameraLog.e(WalletBehaviorBury.TAG, e2.getMessage());
                } catch (ClassNotFoundException e3) {
                    CameraLog.e(WalletBehaviorBury.TAG, e3.getMessage());
                } catch (NoSuchMethodException e4) {
                    CameraLog.e(WalletBehaviorBury.TAG, e4.getMessage());
                }
                return null;
            }
        }.execute(new Object[0]);
    }
}
