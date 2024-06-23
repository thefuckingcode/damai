package com.taobao.login4android.utils;

import java.lang.reflect.Method;

/* compiled from: Taobao */
public class ReflectionHelper {
    public static <T> T invokeMethod(Class cls, Method method, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            return (T) method.invoke(cls, objArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
