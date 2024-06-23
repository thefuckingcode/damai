package com.alipay.mobile.bqcscanservice.behavior;

import android.os.AsyncTask;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
public class WalletBury {
    public static final String TAG = "WalletBury";

    public static void addWalletBury(final String str, final Class[] clsArr, final Object[] objArr) {
        new AsyncTask<Object, Object, Object>() {
            /* class com.alipay.mobile.bqcscanservice.behavior.WalletBury.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Object doInBackground(Object... objArr) {
                try {
                    Class.forName("com.alipay.mobile.bqcscanservice.behavior.BehaviorBury").getMethod(str, clsArr).invoke(null, objArr);
                } catch (IllegalAccessException e) {
                    MPaasLogger.e(WalletBury.TAG, new Object[]{e.getMessage()});
                } catch (InvocationTargetException e2) {
                    MPaasLogger.e(WalletBury.TAG, new Object[]{e2.getMessage()});
                } catch (ClassNotFoundException e3) {
                    MPaasLogger.e(WalletBury.TAG, new Object[]{e3.getMessage()});
                } catch (NoSuchMethodException e4) {
                    MPaasLogger.e(WalletBury.TAG, new Object[]{e4.getMessage()});
                }
                return null;
            }
        }.execute(new Object[0]);
    }
}
