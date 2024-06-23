package com.taobao.slide.api;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ta.utdid2.device.UTDevice;
import com.taobao.orange.OConstant;
import com.taobao.slide.core.SlideReceiver;
import com.taobao.slide.core.b;
import com.taobao.slide.plugin.SlideWVPlugin;
import com.taobao.slide.task.PushTask;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.core.Constants;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.as1;
import tb.d11;
import tb.dv2;
import tb.e21;
import tb.ff2;
import tb.hj2;
import tb.if1;
import tb.j81;
import tb.kg2;
import tb.mu0;
import tb.o22;
import tb.uk;
import tb.yb2;

/* compiled from: Taobao */
public class SlideLoad {
    public static boolean f;
    AtomicBoolean a;
    Context b;
    String c;
    b d;
    Map<kg2, SlideSubscriber> e;

    /* compiled from: Taobao */
    private static class a {
        private static final SlideLoad a = new SlideLoad();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences(if1.POINT_UTDID, 0);
        String string = sharedPreferences.getString("local", "");
        if (!this.c.equals(string)) {
            sharedPreferences.edit().putString("local", this.c).commit();
            if (TextUtils.isEmpty(string)) {
                if1.c(if1.POINT_UTDID, null);
                return;
            }
            o22.k("Load", "init utdid has changed", new Object[0]);
            if1.b(if1.POINT_UTDID, null, null, null);
            return;
        }
        if1.c(if1.POINT_UTDID, null);
    }

    public static SlideLoad h() {
        return a.a;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k() {
        try {
            com.taobao.slide.request.b.d = true;
        } catch (Throwable unused) {
            o22.k("Load", "init not found taobao networksdk", new Object[0]);
        }
        try {
            e21.a(new yb2(this.d));
        } catch (Throwable unused2) {
            o22.k("Load", "init not found networksdk interceptor", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(SlideConfig slideConfig) {
        ff2 ff2 = new ff2();
        com.taobao.slide.control.a.a(new j81("did_hash", this.c, new mu0()).e(true), new j81("ttid", slideConfig.getTtid(), ff2).e(true), new j81("app_ver", slideConfig.getAppVersion(), new dv2()).e(true), new j81(OConstant.CANDIDATE_OSVER, String.valueOf(Build.VERSION.SDK_INT), new dv2()).e(true), new j81("m_vendor", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER(), ff2).e(true), new j81(OConstant.CANDIDATE_BRAND, com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND(), ff2).e(true), new j81(OConstant.CANDIDATE_MODEL, com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL(), ff2).e(true));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
        this.b.registerReceiver(new SlideReceiver(), intentFilter);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n() {
        try {
            WVPluginManager.registerPlugin(SlideWVPlugin.SLIDE_PLUGIN_NAME, (Class<? extends WVApiPlugin>) SlideWVPlugin.class);
        } catch (Throwable unused) {
            o22.k("Load", "SlideWVPlugin register fail, can not find WV", new Object[0]);
        }
    }

    @AnyThread
    public JSONObject g() {
        b bVar = this.d;
        if (bVar != null) {
            return JSON.parseObject(JSON.toJSONString(bVar.d()));
        }
        return null;
    }

    @AnyThread
    public void i(String str) {
        hj2.b(new PushTask(str, this.d));
    }

    @AnyThread
    public void j(@NonNull Context context, @NonNull final SlideConfig slideConfig) {
        final long currentTimeMillis = System.currentTimeMillis();
        as1.e(context, "init error as context is null");
        as1.e(slideConfig, "init error as slideConfig is null");
        if (this.a.get()) {
            o22.c("Load", "init already", new Object[0]);
            return;
        }
        this.b = context.getApplicationContext();
        hj2.b(new Runnable() {
            /* class com.taobao.slide.api.SlideLoad.AnonymousClass1 */

            public void run() {
                if (!SlideLoad.this.a.get()) {
                    try {
                        if (!uk.i(SlideLoad.this.b)) {
                            o22.k("Load", "init broken as not in main process", new Object[0]);
                            return;
                        }
                        SlideLoad.this.m();
                        SlideLoad slideLoad = SlideLoad.this;
                        slideLoad.c = UTDevice.getUtdid(slideLoad.b);
                        boolean z = (SlideLoad.this.b.getApplicationInfo().flags & 2) != 0;
                        SlideLoad.f = z;
                        o22.h(!z);
                        o22.g("Load", "init start", "sdkVersion", "1.0.0", "utdid", SlideLoad.this.c, Constants.CONFIG, slideConfig.toString());
                        SlideLoad.this.l(slideConfig);
                        SlideLoad slideLoad2 = SlideLoad.this;
                        slideLoad2.d = new b(slideLoad2.b, slideConfig);
                        SlideLoad.this.d.h();
                        SlideLoad.this.k();
                        SlideLoad.this.a.set(true);
                        for (Map.Entry<kg2, SlideSubscriber> entry : SlideLoad.this.e.entrySet()) {
                            SlideLoad.this.d.p(entry.getKey(), entry.getValue());
                        }
                        SlideLoad.this.e.clear();
                        SlideLoad.this.f();
                        SlideLoad.this.n();
                        o22.g("Load", UCCore.LEGACY_EVENT_INIT, "time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    } catch (Throwable th) {
                        d11.c(null, 1000);
                        o22.j("Load", UCCore.LEGACY_EVENT_INIT, th, new Object[0]);
                    }
                }
            }
        });
    }

    private SlideLoad() {
        this.a = new AtomicBoolean(false);
        this.e = new ConcurrentHashMap();
    }
}
