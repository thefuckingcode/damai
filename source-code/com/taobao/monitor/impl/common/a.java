package com.taobao.monitor.impl.common;

import android.app.ActivityManager;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Observer;
import tb.gl1;
import tb.nh0;
import tb.t91;

/* compiled from: Taobao */
public class a {
    public static void a(List<Observer> list) {
        Object obj;
        Log.d("ActivityManagerHook", "start Hook IActivityManager...");
        try {
            Class<?> cls = Class.forName("android.app.ActivityManagerNative");
            if (Build.VERSION.SDK_INT >= 26) {
                obj = nh0.a(null, ActivityManager.class.getDeclaredField("IActivityManagerSingleton"));
            } else {
                obj = nh0.a(null, cls.getDeclaredField("gDefault"));
            }
            Class<?> cls2 = Class.forName("android.util.Singleton");
            try {
                Method declaredMethod = cls2.getDeclaredMethod(gl1.TYPE_OPEN_URL_METHOD_GET, new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(obj, new Object[0]);
            } catch (Exception unused) {
            }
            Field declaredField = cls2.getDeclaredField("mInstance");
            Object a = nh0.a(obj, declaredField);
            if (a != null) {
                Class<?> cls3 = Class.forName("android.app.IActivityManager");
                b bVar = new b(a);
                for (Observer observer : list) {
                    bVar.addObserver(observer);
                }
                nh0.b(obj, declaredField, a, Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{cls3}, bVar));
                t91.a("ActivityManagerHook", "Hook IActivityManager success");
            }
        } catch (Exception unused2) {
            t91.a("ActivityManagerHook", "Hook IActivityManager failed");
        }
    }
}
