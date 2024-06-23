package com.youku.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.taobao.atlas.runtime.RuntimeVariables;
import android.widget.Toast;

/* compiled from: Taobao */
public class FlowLimit {
    private static final String FLOW_LIMIT_TIP = "被挤爆了，请稍候再试";
    private static long TIP_TIME_INTERVAL = 2000;
    private static Handler handler = new Handler(Looper.getMainLooper());
    public static volatile boolean isForeGround = true;
    private static long previousToastShow;

    public static void showFlotLimitTip(Context context) {
        showTips(context, "被挤爆了，请稍候再试");
    }

    private static void showTips(Context context, final String str) {
        if (context != null && isForeGround) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - previousToastShow > TIP_TIME_INTERVAL) {
                handler.post(new Runnable() {
                    /* class com.youku.widget.FlowLimit.AnonymousClass1 */

                    public void run() {
                        Toast.makeText(RuntimeVariables.androidApplication, str, 0).show();
                    }
                });
                previousToastShow = currentTimeMillis;
            }
        }
    }
}
