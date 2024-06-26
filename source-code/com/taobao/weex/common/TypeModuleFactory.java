package com.taobao.weex.common;

import android.text.TextUtils;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.Invoker;
import com.taobao.weex.bridge.MethodInvoker;
import com.taobao.weex.bridge.ModuleFactory;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class TypeModuleFactory<T extends WXModule> implements ModuleFactory<T> {
    public static final String TAG = "TypeModuleFactory";
    Class<T> mClazz;
    private boolean mHasRebuild = false;
    Map<String, Invoker> mMethodMap;
    private Map<String, Boolean> methodCheckMap = new ConcurrentHashMap();

    public TypeModuleFactory(Class<T> cls) {
        this.mClazz = cls;
    }

    private void generateMethodMap() {
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d(TAG, "extractMethodNames:" + this.mClazz.getSimpleName());
        }
        HashMap hashMap = new HashMap();
        try {
            Method[] methods = this.mClazz.getMethods();
            for (Method method : methods) {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                int length = declaredAnnotations.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Annotation annotation = declaredAnnotations[i];
                    if (annotation != null) {
                        if (annotation instanceof JSMethod) {
                            JSMethod jSMethod = (JSMethod) annotation;
                            hashMap.put(JSMethod.NOT_SET.equals(jSMethod.alias()) ? method.getName() : jSMethod.alias(), new MethodInvoker(method, jSMethod.uiThread()));
                        } else if (annotation instanceof WXModuleAnno) {
                            hashMap.put(method.getName(), new MethodInvoker(method, ((WXModuleAnno) annotation).runOnUIThread()));
                            break;
                        }
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
            WXLogUtils.e("[WXModuleManager] extractMethodNames:", th);
        }
        this.mMethodMap = hashMap;
    }

    @Override // com.taobao.weex.bridge.ModuleFactory
    public T buildInstance() throws IllegalAccessException, InstantiationException {
        return this.mClazz.newInstance();
    }

    public String className() {
        Class<T> cls = this.mClazz;
        return cls == null ? "" : cls.getName();
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public Invoker getMethodInvoker(String str) {
        if (this.mMethodMap == null) {
            generateMethodMap();
        }
        return this.mMethodMap.get(str);
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public String[] getMethods() {
        if (this.mMethodMap == null) {
            generateMethodMap();
        }
        Set<String> keySet = this.mMethodMap.keySet();
        return (String[]) keySet.toArray(new String[keySet.size()]);
    }

    public boolean hasMethodInClass(String str) {
        boolean z;
        boolean z2 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Boolean bool = this.methodCheckMap.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Method[] methods = this.mClazz.getMethods();
            z = false;
            for (Method method : methods) {
                try {
                    if (method != null && TextUtils.equals(str, method.getName())) {
                        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                        for (Annotation annotation : declaredAnnotations) {
                            z = (annotation instanceof JSMethod) || (annotation instanceof WXModuleAnno);
                        }
                    }
                } catch (Throwable unused) {
                    z2 = z;
                    z = z2;
                    this.methodCheckMap.put(str, Boolean.valueOf(z));
                    return z;
                }
            }
        } catch (Throwable unused2) {
            z = z2;
            this.methodCheckMap.put(str, Boolean.valueOf(z));
            return z;
        }
        this.methodCheckMap.put(str, Boolean.valueOf(z));
        return z;
    }

    public boolean hasRebuild() {
        return this.mHasRebuild;
    }

    public void reBuildMethodMap() {
        if (!this.mHasRebuild) {
            this.mHasRebuild = true;
            generateMethodMap();
        }
    }
}
