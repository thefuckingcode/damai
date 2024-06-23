package com.alibaba.analytics.core.config;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.gj2;
import tb.yi;
import tb.zf2;

/* compiled from: Taobao */
public class UTClientConfigMgr {
    private static UTClientConfigMgr d;
    private Map<String, String> a = Collections.synchronizedMap(new HashMap());
    private Map<String, List<IConfigChangeListener>> b = Collections.synchronizedMap(new HashMap());
    private boolean c = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class ConfigReceiver extends BroadcastReceiver {
        ConfigReceiver() {
        }

        public void onReceive(final Context context, final Intent intent) {
            gj2.c().f(new Runnable() {
                /* class com.alibaba.analytics.core.config.UTClientConfigMgr.ConfigReceiver.AnonymousClass1 */

                public void run() {
                    try {
                        String packageName = context.getPackageName();
                        if (!TextUtils.isEmpty(packageName)) {
                            String str = intent.getPackage();
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            if (packageName.equalsIgnoreCase(str)) {
                                UTClientConfigMgr.this.b(intent.getStringExtra("key"), intent.getStringExtra("value"));
                            }
                        }
                    } catch (Throwable th) {
                        Logger.h("UTClientConfigMgr", th, new Object[0]);
                    }
                }
            });
        }
    }

    /* compiled from: Taobao */
    public interface IConfigChangeListener {
        String getKey();

        void onChange(String str);
    }

    private UTClientConfigMgr() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void b(String str, String str2) {
        Logger.f("UTClientConfigMgr", "dispatchConfig key", str, "value", str2);
        if (!TextUtils.isEmpty(str)) {
            this.a.put(str, str2);
            List<IConfigChangeListener> list = this.b.get(str);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).onChange(str2);
                }
            }
        }
    }

    public static UTClientConfigMgr d() {
        if (d == null) {
            synchronized (UTClientConfigMgr.class) {
                if (d == null) {
                    d = new UTClientConfigMgr();
                }
            }
        }
        return d;
    }

    public synchronized String c(String str) {
        return this.a.get(str);
    }

    public synchronized void e() {
        if (!this.c) {
            try {
                Context b2 = yi.c().b();
                if (b2 != null) {
                    b2.registerReceiver(new ConfigReceiver(), new IntentFilter("com.alibaba.analytics.config.change"));
                    this.c = true;
                    Logger.f("UTClientConfigMgr", "registerReceiver");
                }
            } catch (Throwable th) {
                Logger.u("UTClientConfigMgr", th, new Object[0]);
            }
        }
    }

    public synchronized void f(IConfigChangeListener iConfigChangeListener) {
        List<IConfigChangeListener> list;
        if (iConfigChangeListener != null) {
            if (!zf2.f(iConfigChangeListener.getKey())) {
                String key = iConfigChangeListener.getKey();
                if (this.a.containsKey(key)) {
                    iConfigChangeListener.onChange(this.a.get(key));
                }
                if (this.b.get(key) == null) {
                    list = new ArrayList<>();
                } else {
                    list = this.b.get(key);
                }
                if (!list.contains(iConfigChangeListener)) {
                    list.add(iConfigChangeListener);
                }
                this.b.put(key, list);
            }
        }
    }
}
