package com.taobao.monitor.adapter;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.login4android.api.Login;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.broadcast.LoginBroadcastHelper;
import com.taobao.login4android.session.SessionManager;
import com.taobao.orange.OrangeConfig;
import java.io.Serializable;
import java.util.HashMap;
import tb.dm2;
import tb.l6;
import tb.o3;
import tb.qh2;
import tb.t91;
import tb.uk2;
import tb.uu0;

/* compiled from: Taobao */
public class TBAPMAdapterLauncherPart2 implements Serializable {
    private static final float DEFAULT_SAMPLE = 1.0f;
    private static final String IS_APM = "isApm";
    private static final String TAG = "TBAPMAdapterLauncherPart2";
    private static boolean init;
    private long apmStartTime = dm2.a();

    private void configOrange() {
        o3.b().a().post(new Runnable() {
            /* class com.taobao.monitor.adapter.TBAPMAdapterLauncherPart2.AnonymousClass1 */

            public void run() {
                OrangeConfig.getInstance().getConfigs(l6.ORANGE_NAMESPACE);
                OrangeConfig.getInstance().registerListener(new String[]{l6.ORANGE_NAMESPACE}, new l6(), true);
            }
        });
    }

    private void initAPMFunction(Application application, HashMap<String, Object> hashMap) {
        initLogin(application);
    }

    private void initLogin(final Context context) {
        uk2.d(new Runnable() {
            /* class com.taobao.monitor.adapter.TBAPMAdapterLauncherPart2.AnonymousClass2 */

            public void run() {
                uu0.n = SessionManager.getInstance(context).getNick();
                uu0.m = SessionManager.getInstance(context).getUserId();
            }
        });
        LoginBroadcastHelper.registerLoginReceiver(context, new BroadcastReceiver(this) {
            /* class com.taobao.monitor.adapter.TBAPMAdapterLauncherPart2.AnonymousClass3 */

            public void onReceive(Context context, Intent intent) {
                if (intent != null && LoginAction.valueOf(intent.getAction()) != null) {
                    uu0.n = Login.getNick();
                    uu0.m = Login.getUserId();
                }
            }
        });
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        if (!init && qh2.e) {
            init = true;
            t91.d(TAG, "init start");
            if (qh2.a) {
                initAPMFunction(application, hashMap);
            }
            configOrange();
            t91.d(TAG, "init end");
        }
        t91.d(TAG, "apmStartTime:" + (dm2.a() - this.apmStartTime));
    }
}
