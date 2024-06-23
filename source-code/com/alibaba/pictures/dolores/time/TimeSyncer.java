package com.alibaba.pictures.dolores.time;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.uc.webview.export.extension.UCCore;
import io.flutter.wpkbridge.WPKFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$LongRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ta0;
import tb.vp;

/* compiled from: Taobao */
public final class TimeSyncer {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final TimeSyncer INSTANCE = new TimeSyncer();
    private static final String a;
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static long c;
    private static final AppTimeChangeReceiver d = new AppTimeChangeReceiver();
    private static boolean e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/dolores/time/TimeSyncer$AppTimeChangeReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "dolores_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class AppTimeChangeReceiver extends BroadcastReceiver {
        private static transient /* synthetic */ IpChange $ipChange;

        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2116163874")) {
                ipChange.ipc$dispatch("-2116163874", new Object[]{this, context, intent});
                return;
            }
            k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
            k21.i(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            TimeSyncer timeSyncer = TimeSyncer.INSTANCE;
            String str = TimeSyncer.a;
            vp.a(str, "onReceive " + intent.getAction());
            TimeSyncer.b.set(false);
            timeSyncer.f();
        }
    }

    static {
        String simpleName = TimeSyncer.class.getSimpleName();
        k21.h(simpleName, "TimeSyncer::class.java.simpleName");
        a = simpleName;
    }

    private TimeSyncer() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175741835")) {
            ipChange.ipc$dispatch("1175741835", new Object[]{this});
            return;
        }
        vp.a(a, "sync time start ...");
        b.set(true);
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = System.currentTimeMillis();
        ta0.Companion.b(new SyncTimeRequest()).a().doOnKTStart(new TimeSyncer$asyncTime$1(ref$LongRef)).doOnKTSuccess(new TimeSyncer$asyncTime$2(ref$LongRef)).doOnKTFail(TimeSyncer$asyncTime$3.INSTANCE);
    }

    private final void i(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189605327")) {
            ipChange.ipc$dispatch("-189605327", new Object[]{this, context});
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        if (context != null) {
            context.registerReceiver(d, intentFilter);
        }
    }

    public final long g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "899598519")) {
            return System.currentTimeMillis() + c;
        }
        return ((Long) ipChange.ipc$dispatch("899598519", new Object[]{this})).longValue();
    }

    public final void h(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794158686")) {
            ipChange.ipc$dispatch("-1794158686", new Object[]{this, context});
        } else if (e) {
            Log.d(a, "has init = true,return");
        } else {
            Log.d(a, UCCore.LEGACY_EVENT_INIT);
            i(context);
            e = true;
        }
    }

    public final void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894495445")) {
            ipChange.ipc$dispatch("-1894495445", new Object[]{this});
        } else if (!b.get()) {
            vp.a(a, "syncTime");
            f();
        }
    }
}
