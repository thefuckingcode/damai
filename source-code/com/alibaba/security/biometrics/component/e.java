package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.view.KeyEvent;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.logic.a;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class e {
    private static final String a = "e";
    private static final LinkedHashMap<Class<? extends d>, d> b = new LinkedHashMap<>();
    private static final List<Class<? extends d>> c = new ArrayList();

    public static <T extends d> T a(Class<T> cls) {
        LinkedHashMap<Class<? extends d>, d> linkedHashMap = b;
        T t = linkedHashMap.containsKey(cls) ? (T) linkedHashMap.get(cls) : null;
        if (t != null) {
            return t;
        }
        T t2 = (T) b(cls);
        linkedHashMap.put(cls, t2);
        return t2;
    }

    public static void b() {
        List<Class<? extends d>> list = c;
        if (!(list == null || list.isEmpty())) {
            for (Class<? extends d> cls : list) {
                d dVar = b.get(cls);
                if (dVar != null && dVar.b()) {
                    return;
                }
            }
        }
    }

    public static void c() {
        List<Class<? extends d>> list = c;
        if (list != null && !list.isEmpty()) {
            Iterator<Class<? extends d>> it = list.iterator();
            while (it.hasNext() && ((r1 = b.get(it.next())) == null || !r1.c())) {
            }
            b.clear();
        }
    }

    private static void d() {
        LinkedHashMap<Class<? extends d>, d> linkedHashMap = b;
        linkedHashMap.clear();
        c.clear();
        linkedHashMap.put(AudioSettingComponent.class, null);
        linkedHashMap.put(c.class, null);
        linkedHashMap.put(MediaSystemComponent.class, null);
        linkedHashMap.put(g.class, null);
        linkedHashMap.put(a.class, null);
        linkedHashMap.put(b.class, null);
        for (Map.Entry<Class<? extends d>, d> entry : linkedHashMap.entrySet()) {
            c.add(entry.getKey());
        }
        Collections.sort(c, new Comparator<Class<? extends d>>() {
            /* class com.alibaba.security.biometrics.component.e.AnonymousClass1 */

            private static int a(Class<? extends d> cls, Class<? extends d> cls2) {
                if (cls == null || cls2 == null) {
                    return 0;
                }
                f fVar = (f) cls.getAnnotation(f.class);
                f fVar2 = (f) cls2.getAnnotation(f.class);
                if (fVar == null && fVar2 == null) {
                    return 0;
                }
                if (fVar != null && fVar2 == null) {
                    return -1;
                }
                if (fVar == null && fVar2 != null) {
                    return 1;
                }
                if (fVar.a() == fVar2.a()) {
                    return 0;
                }
                return fVar.a() > fVar2.a() ? -1 : 1;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Class<? extends d> cls, Class<? extends d> cls2) {
                Class<? extends d> cls3 = cls;
                Class<? extends d> cls4 = cls2;
                if (cls3 == null || cls4 == null) {
                    return 0;
                }
                f fVar = (f) cls3.getAnnotation(f.class);
                f fVar2 = (f) cls4.getAnnotation(f.class);
                if (fVar == null && fVar2 == null) {
                    return 0;
                }
                if (fVar != null && fVar2 == null) {
                    return -1;
                }
                if (fVar == null && fVar2 != null) {
                    return 1;
                }
                if (fVar.a() == fVar2.a()) {
                    return 0;
                }
                if (fVar.a() > fVar2.a()) {
                    return -1;
                }
                return 1;
            }
        });
    }

    private static void e() {
        LinkedHashMap<Class<? extends d>, d> linkedHashMap = b;
        linkedHashMap.clear();
        c.clear();
        linkedHashMap.put(AudioSettingComponent.class, null);
        linkedHashMap.put(c.class, null);
        linkedHashMap.put(MediaSystemComponent.class, null);
        linkedHashMap.put(g.class, null);
        linkedHashMap.put(a.class, null);
        linkedHashMap.put(b.class, null);
        for (Map.Entry<Class<? extends d>, d> entry : linkedHashMap.entrySet()) {
            c.add(entry.getKey());
        }
        Collections.sort(c, new Comparator<Class<? extends d>>() {
            /* class com.alibaba.security.biometrics.component.e.AnonymousClass1 */

            private static int a(Class<? extends d> cls, Class<? extends d> cls2) {
                if (cls == null || cls2 == null) {
                    return 0;
                }
                f fVar = (f) cls.getAnnotation(f.class);
                f fVar2 = (f) cls2.getAnnotation(f.class);
                if (fVar == null && fVar2 == null) {
                    return 0;
                }
                if (fVar != null && fVar2 == null) {
                    return -1;
                }
                if (fVar == null && fVar2 != null) {
                    return 1;
                }
                if (fVar.a() == fVar2.a()) {
                    return 0;
                }
                return fVar.a() > fVar2.a() ? -1 : 1;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Class<? extends d> cls, Class<? extends d> cls2) {
                Class<? extends d> cls3 = cls;
                Class<? extends d> cls4 = cls2;
                if (cls3 == null || cls4 == null) {
                    return 0;
                }
                f fVar = (f) cls3.getAnnotation(f.class);
                f fVar2 = (f) cls4.getAnnotation(f.class);
                if (fVar == null && fVar2 == null) {
                    return 0;
                }
                if (fVar != null && fVar2 == null) {
                    return -1;
                }
                if (fVar == null && fVar2 != null) {
                    return 1;
                }
                if (fVar.a() == fVar2.a()) {
                    return 0;
                }
                if (fVar.a() > fVar2.a()) {
                    return -1;
                }
                return 1;
            }
        });
        for (Map.Entry<Class<? extends d>, d> entry2 : b.entrySet()) {
            Class<? extends d> key = entry2.getKey();
            d value = entry2.getValue();
            if (value == null) {
                value = b(key);
            }
            b.put(key, value);
        }
    }

    private static void f() {
        b.clear();
    }

    public static void a() {
        List<Class<? extends d>> list = c;
        if (!(list == null || list.isEmpty())) {
            for (Class<? extends d> cls : list) {
                d dVar = b.get(cls);
                if (dVar != null && dVar.a()) {
                    return;
                }
            }
        }
    }

    private static <T extends d> T b(Class<? extends d> cls) {
        try {
            return (T) ((d) cls.newInstance());
        } catch (IllegalAccessException unused) {
            com.alibaba.security.common.c.a.b();
            return null;
        } catch (InstantiationException unused2) {
            com.alibaba.security.common.c.a.b();
            return null;
        }
    }

    public static boolean a(int i, KeyEvent keyEvent) {
        List<Class<? extends d>> list = c;
        if (list == null || list.isEmpty()) {
            return true;
        }
        Iterator<Class<? extends d>> it = list.iterator();
        while (it.hasNext() && ((r1 = b.get(it.next())) == null || r1.a(i, keyEvent))) {
        }
        return false;
    }

    public static void a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        LinkedHashMap<Class<? extends d>, d> linkedHashMap = b;
        linkedHashMap.clear();
        c.clear();
        linkedHashMap.put(AudioSettingComponent.class, null);
        linkedHashMap.put(c.class, null);
        linkedHashMap.put(MediaSystemComponent.class, null);
        linkedHashMap.put(g.class, null);
        linkedHashMap.put(a.class, null);
        linkedHashMap.put(b.class, null);
        for (Map.Entry<Class<? extends d>, d> entry : linkedHashMap.entrySet()) {
            c.add(entry.getKey());
        }
        Collections.sort(c, new Comparator<Class<? extends d>>() {
            /* class com.alibaba.security.biometrics.component.e.AnonymousClass1 */

            private static int a(Class<? extends d> cls, Class<? extends d> cls2) {
                if (cls == null || cls2 == null) {
                    return 0;
                }
                f fVar = (f) cls.getAnnotation(f.class);
                f fVar2 = (f) cls2.getAnnotation(f.class);
                if (fVar == null && fVar2 == null) {
                    return 0;
                }
                if (fVar != null && fVar2 == null) {
                    return -1;
                }
                if (fVar == null && fVar2 != null) {
                    return 1;
                }
                if (fVar.a() == fVar2.a()) {
                    return 0;
                }
                return fVar.a() > fVar2.a() ? -1 : 1;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Class<? extends d> cls, Class<? extends d> cls2) {
                Class<? extends d> cls3 = cls;
                Class<? extends d> cls4 = cls2;
                if (cls3 == null || cls4 == null) {
                    return 0;
                }
                f fVar = (f) cls3.getAnnotation(f.class);
                f fVar2 = (f) cls4.getAnnotation(f.class);
                if (fVar == null && fVar2 == null) {
                    return 0;
                }
                if (fVar != null && fVar2 == null) {
                    return -1;
                }
                if (fVar == null && fVar2 != null) {
                    return 1;
                }
                if (fVar.a() == fVar2.a()) {
                    return 0;
                }
                if (fVar.a() > fVar2.a()) {
                    return -1;
                }
                return 1;
            }
        });
        for (Map.Entry<Class<? extends d>, d> entry2 : b.entrySet()) {
            Class<? extends d> key = entry2.getKey();
            d value = entry2.getValue();
            if (value == null) {
                value = b(key);
            }
            b.put(key, value);
        }
        List<Class<? extends d>> list = c;
        if (!(list == null || list.isEmpty())) {
            for (Class<? extends d> cls : list) {
                d dVar = b.get(cls);
                if (dVar != null && dVar.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener)) {
                    return;
                }
            }
        }
    }
}
