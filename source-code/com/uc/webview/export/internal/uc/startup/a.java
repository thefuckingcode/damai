package com.uc.webview.export.internal.uc.startup;

import android.content.Context;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.interfaces.InvokeObject;
import com.uc.webview.export.internal.setup.af;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import com.uc.webview.export.internal.utility.e;
import com.uc.webview.export.internal.utility.m;
import com.uc.webview.export.internal.utility.n;
import java.util.HashMap;
import tb.jl1;

/* compiled from: Taobao */
public final class a implements InvokeObject {
    private static final a a = new a();
    private static InvokeObject b = null;

    public static synchronized void a() {
        synchronized (a.class) {
            if (b == null) {
                try {
                    b = (InvokeObject) ReflectionUtil.invoke(Class.forName("com.uc.sdk_glue.StartupBridge", true, af.e()), "doBridge", new Class[]{InvokeObject.class}, new Object[]{a});
                    if (b()) {
                        e.a();
                    }
                } catch (Throwable th) {
                    a("sdk.StartupBridge", "setupBridge fail.", th);
                }
            }
        }
    }

    public static boolean b() {
        return b != null;
    }

    @Override // com.uc.webview.export.internal.interfaces.InvokeObject
    public final Object invoke(int i, Object[] objArr) {
        switch (i) {
            case 9100:
                n.a((Runnable) objArr[0]);
                break;
            case 9101:
                a((String) objArr[0], (String) objArr[1], (Throwable) objArr[2]);
                break;
            case 9102:
                Integer num = (Integer) objArr[0];
                if (objArr.length != 1) {
                    b.a(num.intValue(), (String) objArr[1]);
                    break;
                } else {
                    b.a(num.intValue());
                    break;
                }
            case 9103:
                return b.c();
            case 9104:
                Integer num2 = (Integer) objArr[0];
                if (num2 != null) {
                    af.a(num2.intValue());
                    break;
                }
                break;
            case 9105:
            case 9106:
                try {
                    if (af.c != null) {
                        Log.i("sdk.StartupBridge", "UCMPackageInfo:" + af.c.toString());
                    }
                    Log.i("sdk.StartupBridge", "QuickPathInfo:" + m.a(af.a));
                    Log.printAndFlushCachedLogs();
                    break;
                } catch (Throwable th) {
                    a("sdk.StartupBridge", "onCalled failed", th);
                    break;
                }
            default:
                a("sdk.StartupBridge", "error methodID:" + i, null);
                break;
        }
        return null;
    }

    private static Object b(int i, Object[] objArr) {
        if (i != 9002) {
            try {
                a("sdk.StartupBridge", "fallback error no fallback methodID:" + i, null);
            } catch (Throwable unused) {
                a("sdk.StartupBridge", "fallback to corefactroy error. methodID:" + i, null);
            }
        } else {
            a("sdk.StartupBridge", "fallback to corefactroy methodID:" + i, null);
            CoreFactory.initUCMobileWebkitCoreSoEnv((Context) objArr[0], (HashMap) objArr[1]);
        }
        return null;
    }

    public static Object a(int i, Object[] objArr) {
        a("sdk.StartupBridge", "StartupBridge call methodID:" + i, null);
        if (b()) {
            return b.invoke(i, objArr);
        }
        a("sdk.StartupBridge", "StartupBridge not enable. fallback to corefactroy methodID:" + i, null);
        return b(i, objArr);
    }

    private static void a(String str, String str2, Throwable th) {
        Thread currentThread = Thread.currentThread();
        Log.i("sdk.StartupBridge", jl1.BRACKET_START_STR + currentThread.getId() + " " + currentThread.getName() + ") " + str + "." + str2, th);
    }
}
