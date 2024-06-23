package com.uc.webview.export.internal.uc;

import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.ReflectionUtil;

/* compiled from: Taobao */
public class CoreClassPreLoader {
    @Reflection
    protected static LazyClass Lazy;
    @Reflection
    protected static Runnable sLazyUpdateCallback;

    /* compiled from: Taobao */
    public static class LazyClass {
        final ReflectionUtil.BindingMethod<Boolean> a;
        ReflectionUtil.BindingMethod<Boolean> b = null;
        @Reflection
        public final Class<?> sCoreClassLoaderImpl;

        public LazyClass(ClassLoader classLoader) {
            Class<?> a2 = a(classLoader);
            this.sCoreClassLoaderImpl = a2;
            this.a = new ReflectionUtil.BindingMethod<>(a2, "loadCoreClass", new Class[]{ClassLoader.class});
            try {
                this.b = new ReflectionUtil.BindingMethod<>(a2, "loadCoreClassLevel", new Class[]{ClassLoader.class, Integer.class});
            } catch (Throwable unused) {
            }
        }

        private static Class<?> a(ClassLoader classLoader) {
            try {
                return Class.forName("com.uc.webkit.sdk.CoreClassPreLoaderImpl", true, classLoader);
            } catch (ClassNotFoundException e) {
                throw new UCSetupException(4028, e);
            }
        }
    }

    public static boolean a(ClassLoader classLoader) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class.forName("com.uc.webkit.sdk.CoreFactoryImpl", true, classLoader);
            Class.forName("com.uc.webkit.sdk.CoreClassPreLoaderImpl", true, classLoader);
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        Log.i("CoreClassPreLoader", "loadCoreClassUrgent result:" + z + ", cost:" + (System.currentTimeMillis() - currentTimeMillis));
        updateLazy(classLoader);
        ReflectionUtil.BindingMethod<Boolean> bindingMethod = Lazy.b;
        if (bindingMethod == null) {
            return z;
        }
        return z & bindingMethod.invoke(new Object[]{classLoader, 3}).booleanValue();
    }

    @Reflection
    public static boolean loadCoreClass(ClassLoader classLoader) {
        return Lazy.a.invoke(new Object[]{classLoader}).booleanValue();
    }

    @Reflection
    public static synchronized void updateLazy(ClassLoader classLoader) {
        synchronized (CoreClassPreLoader.class) {
            if (Lazy == null) {
                Lazy = new LazyClass(classLoader);
                Runnable runnable = sLazyUpdateCallback;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }
}
