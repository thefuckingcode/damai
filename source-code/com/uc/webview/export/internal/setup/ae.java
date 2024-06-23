package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.n;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/* compiled from: Taobao */
public class ae {
    private static final String b = "ae";
    private static ae c;
    protected ConcurrentHashMap<b, c> a;

    /* compiled from: Taobao */
    public class a<V, T> implements Callable<V> {
        ValueCallback<T> a;
        Callable<V> b;

        public a(Callable<V> callable, ValueCallback<T> valueCallback) {
            this.a = valueCallback;
            this.b = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [com.uc.webview.export.internal.setup.UCSetupException] */
        /* JADX WARN: Type inference failed for: r2v0, types: [com.uc.webview.export.internal.setup.UCSetupException] */
        /* JADX WARNING: Unknown variable types count: 2 */
        @Override // java.util.concurrent.Callable
        public final V call() throws Exception {
            V v;
            T t = null;
            try {
                v = this.b.call();
            } catch (UCSetupException e) {
                v = null;
                t = e;
            } catch (Throwable th) {
                ?? uCSetupException = new UCSetupException(3003, th);
                v = null;
                t = uCSetupException;
            }
            if (t == null) {
                return v;
            }
            ValueCallback<T> valueCallback = this.a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(t);
            }
            return (V) Integer.valueOf(e.b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum b {
        SETUP_GLOBAL,
        CHECK_OLD_KERNEL,
        VERIFY_SDK_SHELL,
        VERIFY_CORE_JAR,
        LOAD_SDK_SHELL,
        CHECK_VERSION,
        CHECK_SO,
        CHECK_PAK,
        INIT_SDK_SETTINGS,
        SETUP_CORE_FACTORY,
        INIT_UCMOBILE_WEBKIT,
        SETUP_PRINT_LOG
    }

    /* compiled from: Taobao */
    public class c {
        public b a;
        public int b;
        public volatile int c;
        public volatile Object d;
        public Future<?> e = null;
        public ValueCallback<Object> f;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.uc.webview.export.internal.setup.UCAsyncTask */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.concurrent.Future<?> */
        /* JADX WARN: Multi-variable type inference failed */
        public c(int i, UCAsyncTask uCAsyncTask, Future<?> future) {
            this.b = i;
            this.a = uCAsyncTask;
            this.f = future;
            this.c = f.a;
            this.d = Integer.valueOf(e.a);
        }

        public final String toString() {
            Object[] objArr = new Object[5];
            objArr[0] = this.a.toString();
            objArr[1] = Integer.valueOf(this.b);
            objArr[2] = Integer.valueOf(this.c);
            objArr[3] = this.d;
            Future<?> future = this.e;
            objArr[4] = future != null ? future.toString() : "";
            return String.format("Task name: %s, policy: %d, status: %d, result: %s, future: %s", objArr);
        }
    }

    /* compiled from: Taobao */
    public static class d {
        public static int a = 0;
        public static int b = 1;
    }

    /* compiled from: Taobao */
    public static class e {
        public static int a = -2;
        public static int b = -1;
        public static int c;
    }

    /* compiled from: Taobao */
    public static class f {
        public static int a = -1;
        public static int b = 1;
        public static int c = 2;
    }

    private ae() {
        if (this.a == null) {
            this.a = new ConcurrentHashMap<>();
        }
    }

    public static ae a() {
        if (c == null) {
            synchronized (ae.class) {
                if (c == null) {
                    c = new ae();
                }
            }
        }
        return c;
    }

    private c c(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        for (Map.Entry<b, c> entry : this.a.entrySet()) {
            if (entry.getValue().e.equals(runnable)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public final void b(Runnable runnable) {
        c c2 = c(runnable);
        if (c2 != null) {
            try {
                c2.c = f.c;
                c2.d = c2.e.get();
                ValueCallback<Object> valueCallback = c2.f;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(c2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void a(b bVar) {
        this.a.remove(bVar);
    }

    public final Object b(b bVar) {
        c cVar = this.a.get(bVar);
        if (cVar != null) {
            Integer num = (Integer) cVar.d;
            if (num.intValue() == e.a) {
                num = (Integer) a(cVar);
            }
            if (num.equals(Integer.valueOf(e.c))) {
                return num;
            }
            throw new UCSetupException(4032, String.format("task %s failed. result: %d", bVar.toString(), cVar.d));
        }
        throw new UCSetupException(4033, String.format("没有找到%s任务", bVar.toString()));
    }

    private static Object a(c cVar) {
        try {
            return cVar.e.get();
        } catch (Exception e2) {
            throw new UCSetupException(4032, e2);
        }
    }

    public final void a(b[] bVarArr) throws UCSetupException {
        for (int i = 0; i <= 0; i++) {
            b(bVarArr[0]);
        }
    }

    public final void a(Runnable runnable) {
        c c2 = c(runnable);
        if (c2 != null) {
            try {
                c2.c = f.b;
                ValueCallback<Object> valueCallback = c2.f;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(c2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final c a(int i, b bVar, Callable<?> callable, ValueCallback<Object> valueCallback) {
        com.uc.webview.export.internal.uc.startup.b.a(bVar.ordinal() + 400);
        c cVar = new c(i, bVar, valueCallback);
        if ((i & d.b) != 0) {
            try {
                cVar.c = f.b;
                callable.call();
                cVar.c = f.c;
                valueCallback.onReceiveValue(cVar);
                return null;
            } catch (Exception e2) {
                throw new UCSetupException(e2);
            }
        } else {
            cVar.e = n.a(callable);
            this.a.put(cVar.a, cVar);
            return cVar;
        }
    }
}
