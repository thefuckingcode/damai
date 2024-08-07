package com.amap.api.location;

import android.content.Context;
import android.os.Handler;
import com.loc.j1;
import com.loc.o;

/* compiled from: Taobao */
public class UmidtokenInfo {
    static Handler a = new Handler();
    static String b = null;
    static boolean c = true;
    private static AMapLocationClient d;
    private static long e = 30000;

    /* compiled from: Taobao */
    static class a implements AMapLocationListener {
        a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (UmidtokenInfo.d != null) {
                    UmidtokenInfo.a.removeCallbacksAndMessages(null);
                    UmidtokenInfo.d.onDestroy();
                }
            } catch (Throwable th) {
                j1.h(th, "UmidListener", "onLocationChanged");
            }
        }
    }

    public static String getUmidtoken() {
        return b;
    }

    public static void setLocAble(boolean z) {
        c = z;
    }

    public static synchronized void setUmidtoken(Context context, String str) {
        synchronized (UmidtokenInfo.class) {
            try {
                b = str;
                o.B(str);
                if (d == null && c) {
                    a aVar = new a();
                    d = new AMapLocationClient(context);
                    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                    aMapLocationClientOption.setOnceLocation(true);
                    aMapLocationClientOption.setNeedAddress(false);
                    d.setLocationOption(aMapLocationClientOption);
                    d.setLocationListener(aVar);
                    d.startLocation();
                    a.postDelayed(new Runnable() {
                        /* class com.amap.api.location.UmidtokenInfo.AnonymousClass1 */

                        public final void run() {
                            try {
                                if (UmidtokenInfo.d != null) {
                                    UmidtokenInfo.d.onDestroy();
                                }
                            } catch (Throwable th) {
                                j1.h(th, "UmidListener", "postDelayed");
                            }
                        }
                    }, 30000);
                }
            } catch (Throwable th) {
                j1.h(th, "UmidListener", "setUmidtoken");
            }
        }
    }
}
