package tb;

import cn.damai.common.db.db.annotation.Column;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
public final class ti2 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static void a(Class<?> cls, HashMap<String, ak> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-273427918")) {
            ipChange.ipc$dispatch("-273427918", new Object[]{cls, hashMap});
        } else if (!Object.class.equals(cls)) {
            try {
                Field[] declaredFields = cls.getDeclaredFields();
                for (Field field : declaredFields) {
                    int modifiers = field.getModifiers();
                    if (!Modifier.isStatic(modifiers)) {
                        if (!Modifier.isTransient(modifiers)) {
                            Column column = (Column) field.getAnnotation(Column.class);
                            if (column != null && zj.c(field.getType())) {
                                ak akVar = new ak(cls, field, column);
                                if (!hashMap.containsKey(akVar.d())) {
                                    hashMap.put(akVar.d(), akVar);
                                }
                            }
                        }
                    }
                }
                a(cls.getSuperclass(), hashMap);
            } catch (Throwable th) {
                k91.c(th.getMessage(), th);
            }
        }
    }

    static synchronized LinkedHashMap<String, ak> b(Class<?> cls) {
        synchronized (ti2.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1450790050")) {
                return (LinkedHashMap) ipChange.ipc$dispatch("-1450790050", new Object[]{cls});
            }
            LinkedHashMap<String, ak> linkedHashMap = new LinkedHashMap<>();
            a(cls, linkedHashMap);
            return linkedHashMap;
        }
    }
}
