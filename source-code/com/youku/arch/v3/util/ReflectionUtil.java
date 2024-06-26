package com.youku.arch.v3.util;

import android.util.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.vivo.push.PushClientConstants;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.ReflectException;
import org.joor.a;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ*\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007JA\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b2\u001e\u0010\f\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u000b\"\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0007J\u0016\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J,\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b2\f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u0002J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R&\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/youku/arch/v3/util/ReflectionUtil;", "", "", PushClientConstants.TAG_CLASS_NAME, "", "initialize", "Ljava/lang/ClassLoader;", "loader", "Ljava/lang/Class;", "tryGetClassForName", "theClass", "", "parameterTypes", "Ljava/lang/reflect/Constructor;", "tryGetConstructor", "(Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/reflect/Constructor;", "location", "tryGetClassLoader", "paramsClass", "object", "newInstance", "classLoader", "TAG", "Ljava/lang/String;", "Landroid/util/LruCache;", "sCachedClass", "Landroid/util/LruCache;", "sClazzLoader", "useJoor", "Z", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ReflectionUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final ReflectionUtil INSTANCE = new ReflectionUtil();
    @NotNull
    private static final String TAG = "OneArch.ReflectionUtil";
    @NotNull
    private static LruCache<String, Class<?>> sCachedClass = new LruCache<>(64);
    @NotNull
    private static final LruCache<String, ClassLoader> sClazzLoader = new LruCache<>(8);
    private static final boolean useJoor = false;

    private ReflectionUtil() {
    }

    @JvmStatic
    @Nullable
    public static final Constructor<?> tryGetConstructor(@NotNull Class<?> cls, @NotNull Class<?>... clsArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "121351329")) {
            return (Constructor) ipChange.ipc$dispatch("121351329", new Object[]{cls, clsArr});
        }
        k21.i(cls, "theClass");
        k21.i(clsArr, "parameterTypes");
        try {
            return cls.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(e, "Could not retrieve constructor from %s", cls);
            }
            throw new IllegalArgumentException(e);
        }
    }

    @Nullable
    public final Object newInstance(@NotNull Class<?> cls, @Nullable Class<?> cls2, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251543947")) {
            return ipChange.ipc$dispatch("251543947", new Object[]{this, cls, cls2, obj});
        }
        k21.i(cls, "theClass");
        try {
            return cls.getConstructor(cls2).newInstance(obj);
        } catch (NoSuchMethodException e) {
            if (!AppInfoProviderProxy.isDebuggable()) {
                return null;
            }
            LogUtil.e(e, "Could not retrieve constructor from %s", cls);
            return null;
        } catch (InvocationTargetException e2) {
            if (!AppInfoProviderProxy.isDebuggable()) {
                return null;
            }
            LogUtil.e(e2, "Could not retrieve constructor from %s", cls);
            return null;
        } catch (InstantiationException e3) {
            if (!AppInfoProviderProxy.isDebuggable()) {
                return null;
            }
            LogUtil.e(e3, "Could not retrieve constructor from %s", cls);
            return null;
        } catch (IllegalAccessException e4) {
            if (!AppInfoProviderProxy.isDebuggable()) {
                return null;
            }
            LogUtil.e(e4, "Could not retrieve constructor from %s", cls);
            return null;
        } catch (LinkageError e5) {
            LogUtil.e(e5, "OneArch.ReflectionUtil.newInstance: err %s", e5.getMessage());
            return null;
        }
    }

    @Nullable
    public final Class<?> tryGetClassForName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1528762294")) {
            return (Class) ipChange.ipc$dispatch("-1528762294", new Object[]{this, str});
        } else if (str == null) {
            return null;
        } else {
            try {
                Class<?> cls = sCachedClass.get(str);
                if (cls == null) {
                    cls = Class.forName(str);
                    sCachedClass.put(str, cls);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (!AppInfoProviderProxy.isDebuggable()) {
                    return null;
                }
                LogUtil.e(e, "Could not found class from %s", str);
                return null;
            } catch (LinkageError e2) {
                if (!AppInfoProviderProxy.isDebuggable()) {
                    return null;
                }
                LogUtil.e(e2, "Could not found class from %s", str);
                return null;
            }
        }
    }

    @Deprecated(message = "")
    @Nullable
    public final ClassLoader tryGetClassLoader(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287006380")) {
            return (ClassLoader) ipChange.ipc$dispatch("-287006380", new Object[]{this, str});
        }
        ClassLoader classLoader = null;
        if (str != null) {
            classLoader = sClazzLoader.get(str);
        }
        return classLoader == null ? ReflectionUtil.class.getClassLoader() : classLoader;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> tryGetClassForName(@Nullable String str, boolean z, @Nullable ClassLoader classLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-52782496")) {
            return (Class) ipChange.ipc$dispatch("-52782496", new Object[]{str, Boolean.valueOf(z), classLoader});
        }
        Class<?> cls = null;
        if (str != null && (cls = sCachedClass.get(str)) == null) {
            try {
                cls = Class.forName(str, z, classLoader);
                if (cls != null) {
                    sCachedClass.put(str, cls);
                }
            } catch (ClassNotFoundException e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    LogUtil.e(e, "Could not found class from %s", str);
                }
            } catch (LinkageError e2) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    LogUtil.e(e2, "Could not found class from %s", str);
                }
            }
        }
        return cls;
    }

    @Nullable
    public final Object newInstance(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1238160323")) {
            return ipChange.ipc$dispatch("-1238160323", new Object[]{this, str});
        }
        k21.i(str, "theClass");
        try {
            Class<?> tryGetClassForName = tryGetClassForName(str);
            if (tryGetClassForName != null) {
                return tryGetClassForName.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
        } catch (NoSuchMethodException e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(e, "Could not retrieve constructor from %s", str);
                e.printStackTrace();
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        } catch (LinkageError e5) {
            LogUtil.e(e5, "OneArch.ReflectionUtil.newInstance: err %s", e5.getMessage());
        }
        LogUtil.e(TAG, k21.r("theClass return null: ", str));
        return null;
    }

    @Nullable
    public final Object newInstance(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-944209165")) {
            return ipChange.ipc$dispatch("-944209165", new Object[]{this, str, str2});
        }
        ClassLoader classLoader = AppInfoProviderProxy.getAppContext().getClassLoader();
        if (classLoader == null) {
            return null;
        }
        try {
            return a.k(str, classLoader).b().f();
        } catch (ReflectException e) {
            LogUtil.e(TAG, k21.r("newInstance(String theClass, String location)  ", e));
            return null;
        }
    }

    @Nullable
    public final Object newInstance(@NotNull String str, @Nullable ClassLoader classLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1147082595")) {
            return ipChange.ipc$dispatch("-1147082595", new Object[]{this, str, classLoader});
        }
        k21.i(str, "theClass");
        try {
            Class<?> tryGetClassForName = tryGetClassForName(str, false, classLoader);
            if (tryGetClassForName != null) {
                return tryGetClassForName.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            if (!AppInfoProviderProxy.isDebuggable()) {
                return null;
            }
            LogUtil.e(TAG, k21.r(str, " newInstance clazz reflection failed"));
            return null;
        } catch (NoSuchMethodException e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(e, "Could not retrieve constructor from %s", str);
            }
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        } catch (LinkageError e5) {
            LogUtil.e(e5, "OneArch.ReflectionUtil.newInstance: err %s", e5.getMessage());
            return null;
        }
    }
}
