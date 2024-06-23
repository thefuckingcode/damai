package com.alibaba.security.biometrics.service.util.params;

import android.os.Bundle;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: Taobao */
public abstract class ParamsHelper<T> {
    private static final String TAG = "ParamsHelper";
    protected Parceler<T> paramsParceler;

    public ParamsHelper(Bundle bundle) {
        createParamsByBundle(bundle);
    }

    public void clear() {
        this.paramsParceler = null;
    }

    public void copyParams(Bundle bundle) {
        if (!(bundle == null || this.paramsParceler == null)) {
            for (String str : bundle.keySet()) {
                this.paramsParceler.put(str, bundle.get(str));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.alibaba.security.biometrics.service.util.params.Parceler */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public void createParamsByBundle(Bundle bundle) {
        Class<Object> cls = Object.class;
        if (bundle != null) {
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                if (actualTypeArguments.length > 0 && (actualTypeArguments[0] instanceof Class)) {
                    cls = (Class) actualTypeArguments[0];
                }
            }
            this.paramsParceler = new Parceler().createParceler(cls).addAll(bundle);
        }
    }

    public Object getParam(String str) {
        Parceler<T> parceler = this.paramsParceler;
        if (parceler == null) {
            return null;
        }
        return parceler.get(str);
    }

    public T getParams() {
        Parceler<T> parceler = this.paramsParceler;
        if (parceler == null) {
            return null;
        }
        return parceler.getParamsObject();
    }

    public void setParam(String str, Object obj) {
        Parceler<T> parceler = this.paramsParceler;
        if (parceler != null) {
            parceler.put(str, obj);
        }
    }

    public void setParams(Bundle bundle) {
        createParamsByBundle(bundle);
    }
}
