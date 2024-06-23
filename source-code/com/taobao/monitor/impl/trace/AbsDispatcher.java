package com.taobao.monitor.impl.trace;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import tb.fd0;
import tb.qs0;
import tb.t91;

/* compiled from: Taobao */
public class AbsDispatcher<LISTENER> implements IDispatcher<LISTENER> {
    private final Class a = d();
    protected final List<LISTENER> b = new ArrayList();

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public interface ListenerCaller<LISTENER> {
        void callListener(LISTENER listener);
    }

    protected AbsDispatcher() {
        t91.d("AbsDispatcher", getClass().getSimpleName(), " init");
    }

    private void a(Runnable runnable) {
        qs0.e().d().post(runnable);
    }

    private boolean b(LISTENER listener) {
        return e(listener, this.a);
    }

    private Class d() {
        Type[] actualTypeArguments;
        try {
            Type genericSuperclass = getClass().getGenericSuperclass();
            if ((genericSuperclass instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) != null) {
                if (actualTypeArguments.length != 0) {
                    return (Class) actualTypeArguments[0];
                }
            }
        } catch (Throwable unused) {
        }
        return Object.class;
    }

    private boolean e(LISTENER listener, Class cls) {
        if (cls == null) {
            return false;
        }
        return cls.isInstance(listener);
    }

    @Override // com.taobao.monitor.impl.trace.IDispatcher
    public final void addListener(final LISTENER listener) {
        if (!(this instanceof fd0) && listener != null && b(listener)) {
            a(new Runnable() {
                /* class com.taobao.monitor.impl.trace.AbsDispatcher.AnonymousClass1 */

                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.List<LISTENER> */
                /* JADX WARN: Multi-variable type inference failed */
                public void run() {
                    if (!AbsDispatcher.this.b.contains(listener)) {
                        AbsDispatcher.this.b.add(listener);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final void c(final ListenerCaller<LISTENER> listenerCaller) {
        a(new Runnable() {
            /* class com.taobao.monitor.impl.trace.AbsDispatcher.AnonymousClass3 */

            public void run() {
                for (LISTENER listener : AbsDispatcher.this.b) {
                    listenerCaller.callListener(listener);
                }
            }
        });
    }

    @Override // com.taobao.monitor.impl.trace.IDispatcher
    public final void removeListener(final LISTENER listener) {
        if (!(this instanceof fd0) && listener != null) {
            a(new Runnable() {
                /* class com.taobao.monitor.impl.trace.AbsDispatcher.AnonymousClass2 */

                public void run() {
                    AbsDispatcher.this.b.remove(listener);
                }
            });
        }
    }
}
