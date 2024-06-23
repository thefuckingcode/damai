package anetwork.channel.http;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import anet.channel.c;
import anet.channel.entity.ENV;
import anet.channel.util.ALog;
import anetwork.channel.cookie.CookieManager;
import anetwork.channel.monitor.Monitor;
import com.uc.webview.export.extension.UCCore;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.h9;
import tb.sh1;
import tb.ss0;
import tb.y60;

/* compiled from: Taobao */
public class NetworkSdkSetting implements Serializable {
    public static ENV CURRENT_ENV = ENV.ONLINE;
    private static final String TAG = "anet.NetworkSdkSetting";
    private static Context context;
    private static HashMap<String, Object> initParams = null;
    private static AtomicBoolean isInit = new AtomicBoolean(false);

    public static Context getContext() {
        return context;
    }

    public static void init(Context context2) {
        if (context2 != null) {
            try {
                if (isInit.compareAndSet(false, true)) {
                    ALog.e(TAG, "NetworkSdkSetting init", null, new Object[0]);
                    context = context2;
                    ss0.o(System.currentTimeMillis());
                    ss0.l(context2);
                    sh1.e();
                    h9.f(context2);
                    initTaobaoAdapter();
                    Monitor.init();
                    if (!h9.O()) {
                        CookieManager.n(context2);
                    }
                    c.y(context2);
                    y60.a();
                }
            } catch (Throwable th) {
                ALog.d(TAG, "Network SDK initial failed!", null, th, new Object[0]);
            }
        }
    }

    private static void initTaobaoAdapter() {
        try {
            anet.channel.util.c.i("anet.channel.TaobaoNetworkAdapter", UCCore.LEGACY_EVENT_INIT, new Class[]{Context.class, HashMap.class}, context, initParams);
            ALog.f(TAG, "init taobao adapter success", null, new Object[0]);
        } catch (Exception e) {
            ALog.f(TAG, "initTaobaoAdapter failed. maybe not taobao app", null, e);
        }
    }

    public static void setTtid(String str) {
        ss0.p(str);
    }

    public static void init(Application application, HashMap<String, Object> hashMap) {
        try {
            ss0.p((String) hashMap.get("ttid"));
            ss0.r((String) hashMap.get("deviceId"));
            String str = (String) hashMap.get("process");
            if (!TextUtils.isEmpty(str)) {
                ss0.m(str);
            }
            initParams = new HashMap<>(hashMap);
            init(application.getApplicationContext());
            initParams = null;
        } catch (Exception e) {
            ALog.d(TAG, "Network SDK initial failed!", null, e, new Object[0]);
        }
    }
}
