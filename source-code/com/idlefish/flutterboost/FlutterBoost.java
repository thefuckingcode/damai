package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.idlefish.flutterboost.Messages;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.view.FlutterMain;
import java.util.HashMap;
import java.util.Map;
import tb.kl0;
import tb.xl0;
import tb.yl0;

/* compiled from: Taobao */
public class FlutterBoost {
    public static final String APP_LIFECYCLE_CHANGED_KEY = "app_lifecycle_changed_key";
    public static final String ENGINE_ID = "flutter_boost_default_engine";
    public static final int FLUTTER_APP_STATE_PAUSED = 2;
    public static final int FLUTTER_APP_STATE_RESUMED = 0;
    public static final String LIFECYCLE_STATE = "lifecycleState";
    private Activity a;
    private b b;
    private boolean c;

    /* compiled from: Taobao */
    public interface Callback {
        void onStart(FlutterEngine flutterEngine);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class a implements Application.ActivityLifecycleCallbacks {
        private int a = 0;
        private boolean b = false;
        private boolean c = false;

        public a(boolean z) {
            this.c = z;
        }

        private void a() {
            if (!this.c) {
                FlutterBoost.h().l(true);
                FlutterBoost.h().g().A();
            }
        }

        private void b() {
            if (!this.c) {
                FlutterBoost.h().l(false);
                FlutterBoost.h().g().H();
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            FlutterBoost.this.a = activity;
        }

        public void onActivityDestroyed(Activity activity) {
            if (FlutterBoost.this.a == activity) {
                FlutterBoost.this.a = null;
            }
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            FlutterBoost.this.a = activity;
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            int i = this.a + 1;
            this.a = i;
            if (i == 1 && !this.b) {
                b();
            }
        }

        public void onActivityStopped(Activity activity) {
            boolean isChangingConfigurations = activity.isChangingConfigurations();
            this.b = isChangingConfigurations;
            int i = this.a - 1;
            this.a = i;
            if (i == 0 && !isChangingConfigurations) {
                a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        static final FlutterBoost a = new FlutterBoost(null);
    }

    /* synthetic */ FlutterBoost(a aVar) {
        this();
    }

    public static FlutterBoost h() {
        return b.a;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void i(Void r0) {
    }

    private void n(Application application, boolean z) {
        application.registerActivityLifecycleCallbacks(new a(z));
    }

    public void d(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(LIFECYCLE_STATE, Integer.valueOf(i));
        k(APP_LIFECYCLE_CHANGED_KEY, hashMap);
    }

    public Activity e() {
        return this.a;
    }

    public FlutterEngine f() {
        return FlutterEngineCache.getInstance().get(ENGINE_ID);
    }

    public b g() {
        if (this.b == null) {
            FlutterEngine f = f();
            if (f != null) {
                this.b = yl0.d(f);
            } else {
                throw new RuntimeException("FlutterBoost might *not* have been initialized yet!!!");
            }
        }
        return this.b;
    }

    public void j(c cVar) {
        g().n().pushFlutterRoute(cVar);
    }

    public void k(String str, Map<Object, Object> map) {
        Messages.a aVar = new Messages.a();
        aVar.h(str);
        aVar.g(map);
        g().m().A(aVar, kl0.a);
    }

    /* access modifiers changed from: package-private */
    public void l(boolean z) {
    }

    public void m(Application application, FlutterBoostDelegate flutterBoostDelegate, Callback callback, xl0 xl0) {
        if (xl0 == null) {
            xl0 = xl0.a();
        }
        this.c = xl0.f();
        FlutterEngine f = f();
        if (f == null) {
            if (xl0.c() != null) {
                f = xl0.c().provideFlutterEngine(application);
            }
            if (f == null) {
                f = new FlutterEngine(application, xl0.e());
            }
            FlutterEngineCache.getInstance().put(ENGINE_ID, f);
        }
        if (!f.getDartExecutor().isExecutingDart()) {
            f.getNavigationChannel().setInitialRoute(xl0.d());
            f.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), xl0.b()));
        }
        if (callback != null) {
            callback.onStart(f);
        }
        g().K(flutterBoostDelegate);
        n(application, this.c);
    }

    private FlutterBoost() {
        this.a = null;
        this.c = false;
    }
}
