package de.greenrobot.event;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import tb.sg2;
import tb.vi1;

/* compiled from: Taobao */
public class EventBus {
    public static String p = "Event";
    static volatile EventBus q;
    private static final a r = new a();
    private static final Map<Class<?>, List<Class<?>>> s = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<g>> a;
    private final Map<Object, List<Class<?>>> b;
    private final Map<Class<?>, Object> c;
    private final ThreadLocal<c> d;
    private final b e;
    private final BackgroundPoster f;
    private final AsyncPoster g;
    private final f h;
    private final ExecutorService i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    /* compiled from: Taobao */
    interface PostCallback {
        void onPostCompleted(List<sg2> list);
    }

    /* compiled from: Taobao */
    class a extends ThreadLocal<c> {
        a(EventBus eventBus) {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public c initialValue() {
            return new c();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[ThreadMode.values().length];
            a = iArr;
            iArr[ThreadMode.PostThread.ordinal()] = 1;
            a[ThreadMode.MainThread.ordinal()] = 2;
            a[ThreadMode.BackgroundThread.ordinal()] = 3;
            try {
                a[ThreadMode.Async.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class c {
        final List<Object> a = new ArrayList();
        boolean b;
        boolean c;
        Object d;
        boolean e;

        c() {
        }
    }

    public EventBus() {
        this(r);
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static EventBus b() {
        if (q == null) {
            synchronized (EventBus.class) {
                if (q == null) {
                    q = new EventBus();
                }
            }
        }
        return q;
    }

    private void d(g gVar, Object obj, Throwable th) {
        if (obj instanceof sg2) {
            if (this.k) {
                String str = p;
                Log.e(str, "SubscriberExceptionEvent subscriber " + gVar.a.getClass() + " threw an exception", th);
                sg2 sg2 = (sg2) obj;
                String str2 = p;
                Log.e(str2, "Initial event " + sg2.b + " caused exception in " + sg2.c, sg2.a);
            }
        } else if (!this.j) {
            if (this.k) {
                String str3 = p;
                Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + gVar.a.getClass(), th);
            }
            if (this.m) {
                i(new sg2(this, th, obj, gVar.a));
            }
        } else {
            throw new EventBusException("Invoking subscriber failed", th);
        }
    }

    private List<Class<?>> h(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = s;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                s.put(cls, list);
            }
        }
        return list;
    }

    private void j(Object obj, c cVar) throws Error {
        boolean z;
        Class<?> cls = obj.getClass();
        if (this.o) {
            List<Class<?>> h2 = h(cls);
            int size = h2.size();
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= k(obj, cVar, h2.get(i2));
            }
        } else {
            z = k(obj, cVar, cls);
        }
        if (!z) {
            if (this.l) {
                String str = p;
                Log.d(str, "No subscribers registered for event " + cls);
            }
            if (!(!this.n || cls == vi1.class || cls == sg2.class)) {
                i(new vi1(this, obj));
            }
        }
    }

    private boolean k(Object obj, c cVar, Class<?> cls) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<g> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            cVar.d = obj;
            try {
                l(next, obj, cVar.c);
                if (cVar.e) {
                    return true;
                }
            } finally {
                cVar.e = false;
            }
        }
        return true;
    }

    private void l(g gVar, Object obj, boolean z) {
        int i2 = b.a[gVar.b.b.ordinal()];
        if (i2 == 1) {
            f(gVar, obj);
        } else if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    this.g.enqueue(gVar, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + gVar.b.b);
            } else if (z) {
                this.f.enqueue(gVar, obj);
            } else {
                f(gVar, obj);
            }
        } else if (z) {
            f(gVar, obj);
        } else {
            this.e.a(gVar, obj);
        }
    }

    private synchronized void n(Object obj, boolean z, int i2) {
        for (e eVar : this.h.a(obj.getClass())) {
            o(obj, eVar, z, i2);
        }
    }

    private void o(Object obj, e eVar, boolean z, int i2) {
        Object obj2;
        Class<?> cls = eVar.c;
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.a.get(cls);
        g gVar = new g(obj, eVar, i2);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(gVar)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 > size) {
                break;
            } else if (i3 == size || gVar.c > copyOnWriteArrayList.get(i3).c) {
                copyOnWriteArrayList.add(i3, gVar);
            } else {
                i3++;
            }
        }
        copyOnWriteArrayList.add(i3, gVar);
        List<Class<?>> list = this.b.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(obj, list);
        }
        list.add(cls);
        if (z) {
            synchronized (this.c) {
                obj2 = this.c.get(cls);
            }
            if (obj2 != null) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    z2 = true;
                }
                l(gVar, obj2, z2);
            }
        }
    }

    private void q(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i2 = 0;
            while (i2 < size) {
                g gVar = copyOnWriteArrayList.get(i2);
                if (gVar.a == obj) {
                    gVar.d = false;
                    copyOnWriteArrayList.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ExecutorService c() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public void e(c cVar) {
        Object obj = cVar.a;
        g gVar = cVar.b;
        c.b(cVar);
        if (gVar.d) {
            f(gVar, obj);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(g gVar, Object obj) {
        try {
            gVar.b.a.invoke(gVar.a, obj);
        } catch (InvocationTargetException e2) {
            d(gVar, obj, e2.getCause());
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }

    public synchronized boolean g(Object obj) {
        return this.b.containsKey(obj);
    }

    public void i(Object obj) {
        c cVar = this.d.get();
        List<Object> list = cVar.a;
        list.add(obj);
        if (!cVar.b) {
            cVar.c = Looper.getMainLooper() == Looper.myLooper();
            cVar.b = true;
            if (!cVar.e) {
                while (!list.isEmpty()) {
                    try {
                        j(list.remove(0), cVar);
                    } finally {
                        cVar.b = false;
                        cVar.c = false;
                    }
                }
                return;
            }
            throw new EventBusException("Internal error. Abort state was not reset");
        }
    }

    public void m(Object obj) {
        n(obj, false, 0);
    }

    public synchronized void p(Object obj) {
        List<Class<?>> list = this.b.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                q(obj, cls);
            }
            this.b.remove(obj);
        } else {
            String str = p;
            Log.w(str, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    EventBus(a aVar) {
        this.d = new a(this);
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new ConcurrentHashMap();
        this.e = new b(this, Looper.getMainLooper(), 10);
        this.f = new BackgroundPoster(this);
        this.g = new AsyncPoster(this);
        this.h = new f(aVar.h);
        this.k = aVar.a;
        this.l = aVar.b;
        this.m = aVar.c;
        this.n = aVar.d;
        this.j = aVar.e;
        this.o = aVar.f;
        this.i = aVar.g;
    }
}
