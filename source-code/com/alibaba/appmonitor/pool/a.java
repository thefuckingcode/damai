package com.alibaba.appmonitor.pool;

import com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder;
import java.util.HashMap;
import java.util.Map;
import tb.m12;

/* compiled from: Taobao */
public class a implements IPool {
    private static a b = new a();
    private Map<Class<? extends Reusable>, m12<? extends Reusable>> a = new HashMap();

    private a() {
    }

    public static a a() {
        return b;
    }

    private synchronized <T extends Reusable> m12<T> b(Class<T> cls) {
        m12<T> m12;
        m12 = (m12<T>) this.a.get(cls);
        if (m12 == null) {
            m12 = new m12<>();
            this.a.put(cls, m12);
        }
        return m12;
    }

    @Override // com.alibaba.appmonitor.pool.IPool
    public <T extends Reusable> void offer(T t) {
        if (t != null) {
            b(t.getClass()).a(t);
        }
    }

    @Override // com.alibaba.appmonitor.pool.IPool
    public <T extends Reusable> T poll(Class<T> cls, Object... objArr) {
        T b2 = b(cls).b();
        if (b2 == null) {
            try {
                b2 = cls.newInstance();
            } catch (Exception e) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, e);
            }
        }
        if (b2 != null) {
            b2.fill(objArr);
        }
        return b2;
    }
}
