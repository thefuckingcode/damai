package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.util.ALog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.a90;
import tb.b90;
import tb.ss0;

/* compiled from: Taobao */
public class HttpDispatcher {
    private CopyOnWriteArraySet<IDispatchEventListener> a;
    private AmdcTaskExecutor b;
    private volatile boolean c;
    private Set<String> d;
    private Set<String> e;
    private AtomicBoolean f;

    /* compiled from: Taobao */
    public interface IDispatchEventListener {
        void onEvent(b90 b90);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        static HttpDispatcher a = new HttpDispatcher();
    }

    private void c() {
        if (!this.f.get() && ss0.c() != null && this.f.compareAndSet(false, true)) {
            this.e.add(a90.a());
            if (ss0.j()) {
                this.e.addAll(Arrays.asList(a90.a));
            }
        }
    }

    public static HttpDispatcher f() {
        return b.a;
    }

    public synchronized void a(List<String> list) {
        if (list != null) {
            this.e.addAll(list);
            this.d.clear();
        }
    }

    public void b(IDispatchEventListener iDispatchEventListener) {
        this.a.add(iDispatchEventListener);
    }

    /* access modifiers changed from: package-private */
    public void d(b90 b90) {
        Iterator<IDispatchEventListener> it = this.a.iterator();
        while (it.hasNext()) {
            try {
                it.next().onEvent(b90);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized Set<String> e() {
        c();
        return new HashSet(this.e);
    }

    public boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.d.contains(str);
        if (!contains) {
            this.d.add(str);
        }
        return !contains;
    }

    public void h(Set<String> set, int i) {
        if (!this.c || set == null || set.isEmpty()) {
            ALog.e("awcn.HttpDispatcher", "invalid parameter", null, new Object[0]);
            return;
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!AmdcRuntimeInfo.d(next)) {
                ALog.e("awcn.HttpDispatcher", "Not allow to send send amdc request.", null, "host", next);
                it.remove();
            }
        }
        if (!set.isEmpty()) {
            if (ALog.g(2)) {
                ALog.f("awcn.HttpDispatcher", "sendAmdcRequest", null, "hosts", set.toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("hosts", set);
            hashMap.put(a90.CONFIG_VERSION, String.valueOf(i));
            this.b.c(hashMap);
        }
    }

    public void i() {
        this.d.clear();
        this.e.clear();
        this.f.set(false);
    }

    private HttpDispatcher() {
        this.a = new CopyOnWriteArraySet<>();
        this.b = new AmdcTaskExecutor();
        this.c = true;
        this.d = Collections.newSetFromMap(new ConcurrentHashMap());
        this.e = new TreeSet();
        this.f = new AtomicBoolean();
        c();
    }
}
