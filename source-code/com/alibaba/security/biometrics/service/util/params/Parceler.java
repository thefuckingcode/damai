package com.alibaba.security.biometrics.service.util.params;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.security.common.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class Parceler<T> {
    private static final String TAG = "Parceler";
    private Bundle bundle = new Bundle();
    private Class<T> cls;
    private Map<String, Parceler<T>.BundleSerializerBean> fieldBundleKeyMap = new HashMap();
    private BundleConverter normalBundleConverter = new BundleConverter();
    private T object;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class BundleSerializerBean {
        public BundleConverter bundleConverter;
        public Field field;

        public BundleSerializerBean(Field field2, BundleKey bundleKey) throws InstantiationException, IllegalAccessException {
            this.field = field2;
            if (bundleKey != null) {
                Class<? extends BundleConverter> converter = bundleKey.converter();
                if (TextUtils.equals(converter.getSimpleName(), BundleConverter.class.getSimpleName())) {
                    this.bundleConverter = Parceler.this.normalBundleConverter;
                }
                if (TextUtils.equals(converter.getSimpleName(), JsonBundleConverter.class.getSimpleName())) {
                    this.bundleConverter = (BundleConverter) converter.newInstance();
                }
            } else {
                this.bundleConverter = Parceler.this.normalBundleConverter;
            }
            this.bundleConverter.setType(field2.getType());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    private Field[] getAllFields(Class cls2) {
        ArrayList arrayList = new ArrayList();
        while (cls2 != null) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls2.getDeclaredFields())));
            cls2 = cls2.getSuperclass();
        }
        Field[] fieldArr = new Field[arrayList.size()];
        arrayList.toArray(fieldArr);
        return fieldArr;
    }

    public Parceler<T> addAll(Bundle bundle2) {
        this.bundle = bundle2;
        for (String str : bundle2.keySet()) {
            put(str, bundle2.get(str));
        }
        return this;
    }

    public Parceler<T> createParceler(Class<T> cls2) {
        try {
            this.cls = cls2;
            this.object = cls2.newInstance();
            Field[] allFields = getAllFields(cls2);
            for (Field field : allFields) {
                field.setAccessible(true);
                BundleKey bundleKey = (BundleKey) field.getAnnotation(BundleKey.class);
                this.fieldBundleKeyMap.put(bundleKey == null ? field.getName() : bundleKey.key(), new BundleSerializerBean(field, bundleKey));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
        return this;
    }

    public Object get(String str) {
        Parceler<T>.BundleSerializerBean bundleSerializerBean;
        Map<String, Parceler<T>.BundleSerializerBean> map = this.fieldBundleKeyMap;
        if (!(map == null || !map.containsKey(str) || (bundleSerializerBean = this.fieldBundleKeyMap.get(str)) == null)) {
            T t = this.object;
            if (t == null) {
                a.d(TAG, "check your createParceler before get");
                return this;
            }
            try {
                return bundleSerializerBean.field.get(t);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public T getParamsObject() {
        T t;
        Class<T> cls2 = this.cls;
        if (cls2 == null || (t = this.object) == null || !cls2.isInstance(t)) {
            return null;
        }
        return this.object;
    }

    public Parceler<T> put(String str, Object obj) {
        Parceler<T>.BundleSerializerBean bundleSerializerBean;
        Map<String, Parceler<T>.BundleSerializerBean> map = this.fieldBundleKeyMap;
        if (!(map == null || !map.containsKey(str) || (bundleSerializerBean = this.fieldBundleKeyMap.get(str)) == null)) {
            Object deserialize = bundleSerializerBean.bundleConverter.deserialize(obj);
            Field field = bundleSerializerBean.field;
            try {
                T t = this.object;
                if (t == null) {
                    a.d(TAG, "check your createParceler before put");
                    return this;
                }
                field.set(t, deserialize);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public Parceler<T> setByObject(Object obj) {
        if (obj == null) {
            return this;
        }
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                BundleKey bundleKey = (BundleKey) field.getAnnotation(BundleKey.class);
                put(bundleKey == null ? field.getName() : bundleKey.key(), field.get(obj));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return this;
    }
}
