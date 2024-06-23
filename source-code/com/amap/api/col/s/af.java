package com.amap.api.col.s;

import com.amap.api.col.s.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class af {
    private boolean a = true;
    private long b = 86400;
    private int c = 10;
    private long d = 0;
    private final LinkedHashMap<ae.b, Object> e = new LinkedHashMap<>();
    private final Object f = new Object();
    private final LinkedHashMap<ae.b, Object> g = new LinkedHashMap<>();
    private final Object h = new Object();
    private ArrayList<String> i = new ArrayList<>();

    public af(String... strArr) {
        a(strArr);
    }

    private void a(String... strArr) {
        this.d = System.currentTimeMillis();
        this.e.clear();
        this.i.clear();
        for (String str : strArr) {
            if (str != null) {
                this.i.add(str);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Object b(LinkedHashMap<ae.b, Object> linkedHashMap, ae.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.get(bVar);
    }

    /* access modifiers changed from: protected */
    public Object c(LinkedHashMap<ae.b, Object> linkedHashMap, ae.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.remove(bVar);
    }

    private void b(ae.b bVar, Object obj) {
        synchronized (this.f) {
            a();
            b();
            this.e.put(bVar, obj);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(LinkedHashMap<ae.b, Object> linkedHashMap, ae.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return false;
        }
        return linkedHashMap.containsKey(bVar);
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if ((currentTimeMillis - this.d) / 1000 > this.b) {
            this.e.clear();
            this.d = currentTimeMillis;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        r2 = r5.h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        if (a(r5.g, r6) == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        if (a(r5.e, r6) != false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (a(r5.g, r6) == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r5.h.wait(1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0050, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0054, code lost:
        r5.g.put(r6, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0066, code lost:
        return new com.amap.api.col.s.ae.c(b(r5.e, r6), false);
     */
    public final ae.c a(ae.b bVar) {
        if (!this.a || bVar == null || !b(bVar)) {
            return null;
        }
        b();
        synchronized (this.f) {
            if (a(this.e, bVar)) {
                return new ae.c(b(this.e, bVar), true);
            }
        }
    }

    public final boolean b(ae.b bVar) {
        if (!(bVar == null || bVar.a == null)) {
            Iterator<String> it = this.i.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && bVar.a.contains(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(ae.b bVar, Object obj) {
        if (this.a && bVar != null && b(bVar)) {
            b(bVar, obj);
            synchronized (this.h) {
                c(this.g, bVar);
                this.h.notify();
            }
        }
    }

    private void a() {
        int size = this.e.size();
        if (size > 0 && size >= this.c) {
            ae.b bVar = null;
            Iterator<ae.b> it = this.e.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    ae.b next = it.next();
                    if (next != null) {
                        bVar = next;
                        break;
                    }
                } else {
                    break;
                }
            }
            c(this.e, bVar);
        }
    }

    public void a(ae.a aVar) {
        if (aVar != null) {
            this.a = aVar.a();
            this.b = aVar.b();
            this.c = aVar.c();
        }
    }
}
