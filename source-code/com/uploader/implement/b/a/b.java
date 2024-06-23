package com.uploader.implement.b.a;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.uploader.implement.b.c;
import com.uploader.implement.b.d;
import com.uploader.implement.b.e;
import java.util.ArrayList;
import java.util.Iterator;
import tb.g13;

/* compiled from: Taobao */
public class b implements c {
    private ArrayList<e> a = new ArrayList<>();
    private ArrayList<RunnableC0249b> b = new ArrayList<>();
    private ArrayList<a> c = new ArrayList<>();
    private ArrayList<Pair<a, e>> d = new ArrayList<>();
    private final Handler e;
    private final int f;
    private final com.uploader.implement.c g;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        final com.uploader.implement.d.b a;
        final com.uploader.implement.a.e b;
        final d c;

        a(com.uploader.implement.d.b bVar, com.uploader.implement.a.e eVar, d dVar) {
            this.a = bVar;
            this.b = eVar;
            this.c = dVar;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.uploader.implement.b.a.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class RunnableC0249b implements Runnable {
        final e a;
        final ArrayList<e> b;
        final ArrayList<RunnableC0249b> c;

        RunnableC0249b(e eVar, ArrayList<e> arrayList, ArrayList<RunnableC0249b> arrayList2) {
            this.a = eVar;
            this.b = arrayList;
            this.c = arrayList2;
        }

        public void run() {
            this.b.remove(this.a);
            this.c.remove(this);
            this.a.c();
        }
    }

    public b(com.uploader.implement.c cVar, Looper looper) {
        this.g = cVar;
        this.e = new Handler(looper);
        this.f = hashCode();
    }

    private static int a(e eVar, ArrayList<RunnableC0249b> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).a.equals(eVar)) {
                return i;
            }
        }
        return -1;
    }

    private static int b(com.uploader.implement.d.b bVar, com.uploader.implement.a.e eVar, ArrayList<Pair<a, e>> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) arrayList.get(i).first;
            if (aVar.b.equals(eVar) && aVar.a.equals(bVar)) {
                return i;
            }
        }
        return -1;
    }

    private static int c(g13 g13, ArrayList<e> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).a().equals(g13)) {
                return i;
            }
        }
        return -1;
    }

    private e d(g13 g13, e eVar, boolean z) {
        int c2;
        int a2;
        if (!(eVar != null || (c2 = c(g13, this.a)) == -1 || (a2 = a((eVar = this.a.remove(c2)), this.b)) == -1)) {
            this.e.removeCallbacks(this.b.remove(a2));
        }
        if (eVar != null) {
            eVar.a(null);
            if (!z) {
                eVar.c();
            }
            if (eVar.d()) {
                eVar = g13.a(this.g);
            }
        } else {
            eVar = g13.a(this.g);
        }
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " retrieve, connection:" + eVar.hashCode() + " keepAlive:" + z);
        }
        return eVar;
    }

    private void f(e eVar) {
        int h = h(eVar.a(), this.c);
        if (h != -1) {
            a remove = this.c.remove(h);
            this.d.add(new Pair<>(remove, eVar));
            remove.c.a(remove.a, remove.b, eVar);
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " rebind, onAvailable:" + remove.a.hashCode() + " request:" + remove.b.hashCode());
                return;
            }
            return;
        }
        this.a.add(eVar);
        RunnableC0249b bVar = new RunnableC0249b(eVar, this.a, this.b);
        this.e.postDelayed(bVar, 27000);
        this.b.add(bVar);
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " rebind, start timeout connection:" + eVar.hashCode());
        }
    }

    private static int g(com.uploader.implement.d.b bVar, com.uploader.implement.a.e eVar, ArrayList<a> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a aVar = arrayList.get(i);
            if (aVar.b.equals(eVar) && aVar.a.equals(bVar)) {
                return i;
            }
        }
        return -1;
    }

    private static int h(g13 g13, ArrayList<a> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).b.a().equals(g13)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean i(g13 g13, ArrayList<Pair<a, e>> arrayList) {
        int size = arrayList.size();
        int i = 2;
        for (int i2 = 0; i2 < size; i2++) {
            if (((a) arrayList.get(i2).first).b.a().equals(g13) && i - 1 == 0) {
                return false;
            }
        }
        return true;
    }

    public void e() {
        this.c.clear();
        for (int size = this.b.size() - 1; size >= 0; size--) {
            this.e.removeCallbacks(this.b.get(size));
        }
        this.b.clear();
        int size2 = this.d.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            e eVar = (e) this.d.get(size2).second;
            eVar.a(null);
            eVar.c();
        }
        this.d.clear();
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            e eVar2 = this.a.get(size3);
            eVar2.a(null);
            eVar2.c();
        }
        this.a.clear();
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " reset");
        }
    }

    @Override // com.uploader.implement.b.c
    public boolean a(@NonNull com.uploader.implement.d.b bVar, @NonNull com.uploader.implement.a.e eVar, @NonNull com.uploader.implement.a.e eVar2, @NonNull d dVar, boolean z) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " replace start, session:" + bVar.hashCode() + " request:" + eVar.hashCode() + " newRequest:" + eVar2.hashCode() + " keepAlive:" + z);
        }
        g13 a2 = eVar.a();
        if (!a2.equals(eVar2.a())) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " replace:failure, false !=, request:" + eVar.hashCode() + " newRequest:" + eVar2.hashCode());
            }
            return false;
        } else if (!a2.e) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " replace:false, !isLongLived");
            }
            return false;
        } else {
            int g2 = g(bVar, eVar, this.c);
            if (g2 != -1) {
                this.c.set(g2, new a(bVar, eVar2, dVar));
                if (com.uploader.implement.a.d(2)) {
                    com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " replace, waiting, request:" + eVar.hashCode() + " newRequest:" + eVar2.hashCode());
                }
                return true;
            }
            int b2 = b(bVar, eVar, this.d);
            if (b2 == -1) {
                if (com.uploader.implement.a.d(2)) {
                    com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " replace failure, !bounding, request:" + eVar.hashCode());
                }
                return false;
            }
            e d2 = d(a2, (e) this.d.get(b2).second, z);
            this.d.set(b2, new Pair<>(new a(bVar, eVar2, dVar), d2));
            dVar.a(bVar, eVar2, d2);
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "ConnectionRecycler", this.f + " replace, bounding, request:" + eVar.hashCode() + " newRequest:" + eVar2.hashCode() + " available connection:" + d2.hashCode());
            }
            return true;
        }
    }

    @Override // com.uploader.implement.b.c
    public boolean a(@NonNull com.uploader.implement.d.b bVar, @NonNull com.uploader.implement.a.e eVar, @NonNull d dVar) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " register start, session:" + bVar.hashCode() + " request:" + eVar.hashCode());
        }
        g13 a2 = eVar.a();
        if (!a2.e) {
            e a3 = a2.a(this.g);
            dVar.a(bVar, eVar, a3);
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " register, onAvailable short lived connection:" + a3.hashCode() + " request:" + eVar.hashCode());
            }
            return true;
        }
        if (b(bVar, eVar, this.d) != -1 && com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "ConnectionRecycler", this.f + " register, is bounding, request:" + eVar.hashCode());
        }
        if (g(bVar, eVar, this.c) != -1 && com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "ConnectionRecycler", this.f + " register, is waiting, request:" + eVar.hashCode());
        }
        a aVar = new a(bVar, eVar, dVar);
        if (3 <= this.d.size() || !i(a2, this.d)) {
            this.c.add(aVar);
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " register, waiting request:" + eVar.hashCode());
            }
            return true;
        }
        e d2 = d(a2, null, true);
        this.d.add(new Pair<>(aVar, d2));
        dVar.a(bVar, eVar, d2);
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " register, onAvailable long lived connection:" + d2.hashCode() + " request:" + eVar.hashCode());
        }
        return true;
    }

    @Override // com.uploader.implement.b.c
    public boolean a(@NonNull com.uploader.implement.d.b bVar, @NonNull com.uploader.implement.a.e eVar, boolean z) {
        g13 a2 = eVar.a();
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " unregister start, session:" + bVar.hashCode() + " request:" + eVar.hashCode());
        }
        if (!a2.e) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " unregister, !isLongLived, session:" + bVar.hashCode() + " request:" + eVar.hashCode());
            }
            return false;
        }
        int g2 = g(bVar, eVar, this.c);
        if (g2 != -1) {
            this.c.remove(g2);
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " unregister, waiting, session:" + bVar.hashCode() + " request:" + eVar.hashCode());
            }
            return true;
        }
        int b2 = b(bVar, eVar, this.d);
        if (b2 == -1) {
            return false;
        }
        Pair<a, e> remove = this.d.remove(b2);
        e d2 = d(((a) remove.first).b.a(), (e) remove.second, z);
        f(d2);
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " unregister, session:" + bVar.hashCode() + " request:" + eVar.hashCode() + " connection:" + d2.hashCode());
        }
        return true;
    }

    @Override // com.uploader.implement.b.c
    public boolean a(@NonNull com.uploader.implement.d.b bVar) {
        boolean z = false;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            if (this.c.get(size).a.equals(bVar)) {
                this.c.remove(size);
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int size2 = this.d.size() - 1; size2 >= 0; size2--) {
            Pair<a, e> pair = this.d.get(size2);
            if (((a) pair.first).a.equals(bVar)) {
                this.d.remove(size2);
                arrayList.add(d(((a) pair.first).b.a(), (e) pair.second, false));
                z = true;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f((e) it.next());
        }
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "ConnectionRecycler", this.f + " unregister, session:" + bVar.hashCode() + " removed:" + z);
        }
        return z;
    }
}
