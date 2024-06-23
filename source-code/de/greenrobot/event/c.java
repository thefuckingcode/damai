package de.greenrobot.event;

import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class c {
    private static final List<c> d = new ArrayList();
    Object a;
    g b;
    c c;

    private c(Object obj, g gVar) {
        this.a = obj;
        this.b = gVar;
    }

    static c a(g gVar, Object obj) {
        List<c> list = d;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new c(obj, gVar);
            }
            c remove = list.remove(size - 1);
            remove.a = obj;
            remove.b = gVar;
            remove.c = null;
            return remove;
        }
    }

    static void b(c cVar) {
        cVar.a = null;
        cVar.b = null;
        cVar.c = null;
        List<c> list = d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(cVar);
            }
        }
    }
}
