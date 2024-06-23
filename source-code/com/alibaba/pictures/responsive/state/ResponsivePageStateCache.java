package com.alibaba.pictures.responsive.state;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.e12;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class ResponsivePageStateCache {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final HashMap<Integer, e12> a = new HashMap<>();
    @NotNull
    private static final Lazy<ResponsivePageStateCache> b = b.a(LazyThreadSafetyMode.SYNCHRONIZED, ResponsivePageStateCache$Companion$instance$2.INSTANCE);

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final ResponsivePageStateCache a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-825988061")) {
                return (ResponsivePageStateCache) ResponsivePageStateCache.b.getValue();
            }
            return (ResponsivePageStateCache) ipChange.ipc$dispatch("-825988061", new Object[]{this});
        }
    }

    public final void b(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698169755")) {
            ipChange.ipc$dispatch("-1698169755", new Object[]{this, context});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        a.remove(Integer.valueOf(context.hashCode()));
    }

    public final int c(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "780832584")) {
            return ((Integer) ipChange.ipc$dispatch("780832584", new Object[]{this, context})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int hashCode = context.hashCode();
        HashMap<Integer, e12> hashMap = a;
        e12 e12 = hashMap.get(Integer.valueOf(hashCode));
        if (e12 == null) {
            e12 = new e12();
            hashMap.put(Integer.valueOf(hashCode), e12);
        }
        return e12.a();
    }

    public final int d(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "704124457")) {
            return ((Integer) ipChange.ipc$dispatch("704124457", new Object[]{this, context})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int hashCode = context.hashCode();
        HashMap<Integer, e12> hashMap = a;
        e12 e12 = hashMap.get(Integer.valueOf(hashCode));
        if (e12 == null) {
            e12 = new e12();
            hashMap.put(Integer.valueOf(hashCode), e12);
        }
        return e12.b();
    }

    public final int e(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1068552616")) {
            return ((Integer) ipChange.ipc$dispatch("-1068552616", new Object[]{this, context})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int hashCode = context.hashCode();
        HashMap<Integer, e12> hashMap = a;
        e12 e12 = hashMap.get(Integer.valueOf(hashCode));
        if (e12 == null) {
            e12 = new e12();
            hashMap.put(Integer.valueOf(hashCode), e12);
        }
        return e12.c();
    }

    public final int f(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1817621137")) {
            return ((Integer) ipChange.ipc$dispatch("-1817621137", new Object[]{this, context})).intValue();
        } else if (context == null) {
            return 1000;
        } else {
            int hashCode = context.hashCode();
            HashMap<Integer, e12> hashMap = a;
            e12 e12 = hashMap.get(Integer.valueOf(hashCode));
            if (e12 == null) {
                e12 = new e12();
                hashMap.put(Integer.valueOf(hashCode), e12);
            }
            return e12.d();
        }
    }

    public final void g(@NotNull Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602779133")) {
            ipChange.ipc$dispatch("-1602779133", new Object[]{this, context, Integer.valueOf(i)});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int hashCode = context.hashCode();
        HashMap<Integer, e12> hashMap = a;
        e12 e12 = hashMap.get(Integer.valueOf(hashCode));
        if (e12 == null) {
            e12 = new e12();
            hashMap.put(Integer.valueOf(hashCode), e12);
        }
        e12.e(i);
    }

    public final void h(@NotNull Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251741678")) {
            ipChange.ipc$dispatch("1251741678", new Object[]{this, context, Integer.valueOf(i)});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int hashCode = context.hashCode();
        HashMap<Integer, e12> hashMap = a;
        e12 e12 = hashMap.get(Integer.valueOf(hashCode));
        if (e12 == null) {
            e12 = new e12();
            hashMap.put(Integer.valueOf(hashCode), e12);
        }
        e12.f(i);
    }

    public final void i(@NotNull Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1495781907")) {
            ipChange.ipc$dispatch("-1495781907", new Object[]{this, context, Integer.valueOf(i)});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int hashCode = context.hashCode();
        HashMap<Integer, e12> hashMap = a;
        e12 e12 = hashMap.get(Integer.valueOf(hashCode));
        if (e12 == null) {
            e12 = new e12();
            hashMap.put(Integer.valueOf(hashCode), e12);
        }
        e12.g(i);
    }

    public final void j(@Nullable Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2143213805")) {
            ipChange.ipc$dispatch("-2143213805", new Object[]{this, context, Integer.valueOf(i)});
        } else if (context != null) {
            int hashCode = context.hashCode();
            HashMap<Integer, e12> hashMap = a;
            e12 e12 = hashMap.get(Integer.valueOf(hashCode));
            if (e12 == null) {
                e12 = new e12();
                hashMap.put(Integer.valueOf(hashCode), e12);
            }
            e12.h(i);
        }
    }
}
