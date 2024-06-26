package com.taobao.aranger.utils;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.wrapper.BaseWrapper;
import com.taobao.aranger.core.wrapper.MethodWrapper;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.exception.IPCException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class d {
    private static volatile d d;
    private final ConcurrentHashMap<String, Class<?>> a = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Method>> b = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Constructor<?>> c = new ConcurrentHashMap<>();

    private d() {
    }

    public static d e() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    public Class<?> a(BaseWrapper baseWrapper) throws IPCException {
        String name = baseWrapper.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        return b(name);
    }

    public Class<?> b(String str) throws IPCException {
        Class<?> cls;
        Class<?> cls2 = this.a.get(str);
        if (cls2 != null) {
            return cls2;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1325958191:
                if (str.equals("double")) {
                    c2 = 0;
                    break;
                }
                break;
            case 104431:
                if (str.equals("int")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3039496:
                if (str.equals("byte")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3052374:
                if (str.equals("char")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3327612:
                if (str.equals("long")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3625364:
                if (str.equals(Constants.VOID)) {
                    c2 = 5;
                    break;
                }
                break;
            case 64711720:
                if (str.equals(TypedValues.Custom.S_BOOLEAN)) {
                    c2 = 6;
                    break;
                }
                break;
            case 97526364:
                if (str.equals(TypedValues.Custom.S_FLOAT)) {
                    c2 = 7;
                    break;
                }
                break;
            case 109413500:
                if (str.equals("short")) {
                    c2 = '\b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                cls = Double.TYPE;
                break;
            case 1:
                cls = Integer.TYPE;
                break;
            case 2:
                cls = Byte.TYPE;
                break;
            case 3:
                cls = Character.TYPE;
                break;
            case 4:
                cls = Long.TYPE;
                break;
            case 5:
                cls = Void.TYPE;
                break;
            case 6:
                cls = Boolean.TYPE;
                break;
            case 7:
                cls = Float.TYPE;
                break;
            case '\b':
                cls = Short.TYPE;
                break;
            default:
                try {
                    cls = Class.forName(str);
                    break;
                } catch (ClassNotFoundException e) {
                    throw new IPCException(21, e);
                }
        }
        this.a.putIfAbsent(str, cls);
        return cls;
    }

    public Class<?>[] c(ParameterWrapper[] parameterWrapperArr) throws IPCException {
        if (parameterWrapperArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[parameterWrapperArr.length];
        for (int i = 0; i < parameterWrapperArr.length; i++) {
            clsArr[i] = a(parameterWrapperArr[i]);
        }
        return clsArr;
    }

    /* access modifiers changed from: package-private */
    public Constructor d(String str) {
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        return null;
    }

    public Method f(Class<?> cls, MethodWrapper methodWrapper, ParameterWrapper[] parameterWrapperArr) throws IPCException {
        String methodId = TypeUtils.getMethodId(methodWrapper.getName(), parameterWrapperArr);
        ConcurrentHashMap<String, Method> concurrentHashMap = this.b.get(cls.getName());
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        Method method = concurrentHashMap.get(methodId);
        if (method != null) {
            return method;
        }
        Method method2 = TypeUtils.getMethod(cls, methodId.substring(0, methodId.indexOf(40)), c(parameterWrapperArr), b(TextUtils.isEmpty(methodWrapper.getReturnType()) ? Constants.VOID : methodWrapper.getReturnType()));
        if (method2 != null) {
            concurrentHashMap.putIfAbsent(methodId, method2);
            this.b.putIfAbsent(cls.getName(), concurrentHashMap);
            return method2;
        }
        throw new IPCException(12, "Method not found: " + methodId + " in class " + cls.getName());
    }

    /* access modifiers changed from: package-private */
    public void g(String str, Constructor constructor) {
        this.c.putIfAbsent(str, constructor);
    }
}
