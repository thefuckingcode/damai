package com.alibaba.analytics.core.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import tb.tq2;

/* compiled from: Taobao */
public class NetworkOperatorUtil {
    private static String a = "Unknown";
    private static SubscriptionManager b;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends SubscriptionManager.OnSubscriptionsChangedListener {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        public void onSubscriptionsChanged() {
            super.onSubscriptionsChanged();
            Logger.f("NetworkOperatorUtil", "onSubscriptionsChanged");
            NetworkOperatorUtil.f(this.a);
            Logger.f("NetworkOperatorUtil", "CurrentNetworkOperator", NetworkOperatorUtil.a);
            tq2.k(this.a);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public void a(Runnable runnable) {
            Logger.q();
            if (runnable != null) {
                try {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = runnable;
                    sendMessage(obtain);
                } catch (Throwable unused) {
                }
            }
        }

        public void handleMessage(Message message) {
            try {
                Object obj = message.obj;
                if (obj != null && (obj instanceof Runnable)) {
                    try {
                        ((Runnable) obj).run();
                    } catch (Throwable th) {
                        Logger.h("NetworkOperatorUtil", th, new Object[0]);
                    }
                }
            } catch (Throwable th2) {
                Logger.h("NetworkOperatorUtil", th2, new Object[0]);
            }
            super.handleMessage(message);
        }
    }

    public static synchronized String c() {
        String str;
        synchronized (NetworkOperatorUtil.class) {
            str = a;
        }
        return str;
    }

    /* access modifiers changed from: private */
    @TargetApi(22)
    public static synchronized void d(Context context) {
        synchronized (NetworkOperatorUtil.class) {
            if (Build.VERSION.SDK_INT >= 22) {
                if (b == null) {
                    try {
                        SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
                        b = subscriptionManager;
                        if (subscriptionManager == null) {
                            Logger.f("NetworkOperatorUtil", "SubscriptionManager is null");
                            return;
                        }
                        b.addOnSubscriptionsChangedListener(new a(context));
                        Logger.f("NetworkOperatorUtil", "addOnSubscriptionsChangedListener");
                    } catch (Throwable th) {
                        Logger.h("NetworkOperatorUtil", th, new Object[0]);
                    }
                }
            }
        }
    }

    static synchronized void e(final Context context) throws Exception {
        synchronized (NetworkOperatorUtil.class) {
            if (Build.VERSION.SDK_INT >= 22) {
                if (b == null) {
                    Looper.prepare();
                    new b(Looper.getMainLooper()).a(new Runnable() {
                        /* class com.alibaba.analytics.core.network.NetworkOperatorUtil.AnonymousClass1 */

                        public void run() {
                            NetworkOperatorUtil.d(context);
                        }
                    });
                }
            }
        }
    }

    static synchronized void f(Context context) {
        synchronized (NetworkOperatorUtil.class) {
            Logger.r("NetworkOperatorUtil", "updateNetworkOperatorName");
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    a = NetworkUtil.NETWORK_CLASS_UNKNOWN;
                    return;
                }
                if (telephonyManager.getSimState() == 5) {
                    String simOperator = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperator(telephonyManager);
                    if (TextUtils.isEmpty(simOperator)) {
                        String simOperatorName = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperatorName(telephonyManager);
                        if (TextUtils.isEmpty(simOperatorName)) {
                            a = NetworkUtil.NETWORK_CLASS_UNKNOWN;
                            return;
                        } else {
                            a = simOperatorName;
                            return;
                        }
                    } else if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007") || simOperator.equals("46008")) {
                        a = "中国移动";
                        return;
                    } else if (simOperator.equals("46001") || simOperator.equals("46006") || simOperator.equals("46009")) {
                        a = "中国联通";
                        return;
                    } else if (simOperator.equals("46003") || simOperator.equals("46005") || simOperator.equals("46011")) {
                        a = "中国电信";
                        return;
                    } else {
                        String simOperatorName2 = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperatorName(telephonyManager);
                        if (TextUtils.isEmpty(simOperatorName2)) {
                            a = NetworkUtil.NETWORK_CLASS_UNKNOWN;
                            return;
                        } else {
                            a = simOperatorName2;
                            return;
                        }
                    }
                }
                a = NetworkUtil.NETWORK_CLASS_UNKNOWN;
            } catch (Exception e) {
                Logger.h("NetworkOperatorUtil", e, new Object[0]);
            }
        }
    }
}
