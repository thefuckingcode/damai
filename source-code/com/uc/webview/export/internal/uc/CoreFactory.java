package com.uc.webview.export.internal.uc;

import android.content.Context;
import android.util.AttributeSet;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.extension.ARManager;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.ICookieManager;
import com.uc.webview.export.internal.interfaces.IGeolocationPermissions;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IMimeTypeMap;
import com.uc.webview.export.internal.interfaces.IServiceWorkerController;
import com.uc.webview.export.internal.interfaces.IWebStorage;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.uc.startup.b;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import java.util.HashMap;

/* compiled from: Taobao */
public class CoreFactory {
    protected static a a;
    protected static Runnable b;

    /* compiled from: Taobao */
    public static class a {
        public final Class<?> a;
        final ReflectionUtil.BindingMethod<IGlobalSettings> b;
        final ReflectionUtil.BindingMethod<ICookieManager> c;
        final ReflectionUtil.BindingMethod<IServiceWorkerController> d;
        final ReflectionUtil.BindingMethod<UCMobileWebKit> e;
        final ReflectionUtil.BindingMethod<IGeolocationPermissions> f;
        final ReflectionUtil.BindingMethod<IWebStorage> g;
        final ReflectionUtil.BindingMethod<IMimeTypeMap> h;
        final ReflectionUtil.BindingMethod<IWebView> i;
        final ReflectionUtil.BindingMethod<IWebView> j;
        final ReflectionUtil.BindingMethod<UCMobileWebKit> k;
        final ReflectionUtil.BindingMethod<Boolean> l;
        final ReflectionUtil.BindingMethod<Integer> m;
        final ReflectionUtil.BindingMethod<Object> n;
        final ReflectionUtil.BindingMethod<Object> o;
        final ReflectionUtil.BindingMethod<WebResourceResponse> p;
        final ReflectionUtil.BindingMethod<ARManager> q;

        public a() {
            ReflectionUtil.BindingMethod<IWebView> bindingMethod;
            Class<?> a2 = a();
            this.a = a2;
            this.b = new ReflectionUtil.BindingMethod<>(a2, "getGlobalSettings");
            this.c = new ReflectionUtil.BindingMethod<>(a2, "getCookieManager");
            this.d = new ReflectionUtil.BindingMethod<>(a2, "getServiceWorkerController");
            this.e = new ReflectionUtil.BindingMethod<>(a2, "getUCMobileWebKit");
            this.f = new ReflectionUtil.BindingMethod<>(a2, "getGeolocationPermissions");
            this.g = new ReflectionUtil.BindingMethod<>(a2, "getWebStorage");
            this.h = new ReflectionUtil.BindingMethod<>(a2, "getMimeTypeMap");
            this.i = new ReflectionUtil.BindingMethod<>(a2, "createWebView", new Class[]{Context.class});
            ReflectionUtil.BindingMethod<ARManager> bindingMethod2 = null;
            try {
                bindingMethod = new ReflectionUtil.BindingMethod<>(a2, "createWebView", new Class[]{Context.class, AttributeSet.class});
            } catch (Throwable unused) {
                bindingMethod = null;
            }
            this.j = bindingMethod;
            Class<?> cls = this.a;
            Class cls2 = Boolean.TYPE;
            this.k = new ReflectionUtil.BindingMethod<>(cls, "initUCMobileWebKit", new Class[]{Context.class, cls2, cls2});
            this.m = new ReflectionUtil.BindingMethod<>(this.a, "getCoreType");
            this.n = new ReflectionUtil.BindingMethod<>(this.a, "initSDK", new Class[]{Context.class});
            this.o = new ReflectionUtil.BindingMethod<>(this.a, "handlePerformanceTests", new Class[]{String.class});
            this.p = new ReflectionUtil.BindingMethod<>(this.a, "getResponseByUrl", new Class[]{String.class});
            try {
                bindingMethod2 = new ReflectionUtil.BindingMethod<>(this.a, "getARManager");
            } catch (Throwable unused2) {
            }
            this.q = bindingMethod2;
            this.l = new ReflectionUtil.BindingMethod<>(this.a, "initUCMobileWebkitCoreSoEnv", new Class[]{Context.class, HashMap.class});
        }

        private static Class<?> a() {
            try {
                return Class.forName("com.uc.webkit.sdk.CoreFactoryImpl", true, SDKFactory.c);
            } catch (ClassNotFoundException e2) {
                throw new UCSetupException((int) GlobalErrorCode.ERROR_CTID_APP_ERROR, e2);
            }
        }
    }

    public static void a() {
        h();
    }

    public static IGlobalSettings b() {
        return h().b.getInstance();
    }

    public static IGeolocationPermissions c() {
        return h().f.getInstance();
    }

    @Reflection
    public static IWebView createWebView(Context context, AttributeSet attributeSet) {
        if (h().j == null) {
            return h().i.invoke(new Object[]{context});
        }
        return h().j.invoke(new Object[]{context, attributeSet});
    }

    public static IWebStorage d() {
        return h().g.getInstance();
    }

    public static IMimeTypeMap e() {
        return h().h.getInstance();
    }

    public static boolean f() {
        return h().j != null;
    }

    public static ARManager g() {
        return h().q.invoke();
    }

    @Reflection
    public static ICookieManager getCookieManager() {
        return h().c.getInstance();
    }

    @Reflection
    public static Integer getCoreType() {
        return h().m.invoke();
    }

    @Reflection
    public static IServiceWorkerController getServiceWorkerController() {
        return h().d.getInstance();
    }

    @Reflection
    public static UCMobileWebKit getUCMobileWebKit() {
        return h().e.getInstance();
    }

    private static synchronized a h() {
        a aVar;
        synchronized (CoreFactory.class) {
            if (a == null) {
                b.a(145);
                a = new a();
                Runnable runnable = b;
                if (runnable != null) {
                    runnable.run();
                }
                b.a(146);
            }
            aVar = a;
        }
        return aVar;
    }

    @Reflection
    public static UCMobileWebKit initUCMobileWebKit(Context context, boolean z, boolean z2) {
        return h().k.invoke(new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    @Reflection
    public static boolean initUCMobileWebkitCoreSoEnv(Context context, HashMap<String, String> hashMap) throws RuntimeException {
        return h().l.invoke(new Object[]{context, hashMap}).booleanValue();
    }

    public static void a(Context context) {
        h().n.invoke(new Object[]{context});
    }

    public static WebResourceResponse b(String str) {
        return h().p.invoke(new Object[]{str});
    }

    public static void a(String str) {
        h().o.invoke(new Object[]{str});
    }
}
