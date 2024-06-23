package com.meizu.cloud.pushsdk.c.e;

import com.meizu.cloud.pushsdk.c.a.b;
import com.meizu.cloud.pushsdk.c.a.e;
import com.meizu.cloud.pushsdk.c.b.a;
import com.meizu.cloud.pushsdk.c.c.k;

/* compiled from: Taobao */
public final class c {
    public static <T> com.meizu.cloud.pushsdk.c.a.c<T> a(b bVar) {
        int g = bVar.g();
        return g != 0 ? g != 1 ? g != 2 ? new com.meizu.cloud.pushsdk.c.a.c<>(new a()) : d(bVar) : c(bVar) : b(bVar);
    }

    private static <T> com.meizu.cloud.pushsdk.c.a.c<T> b(b bVar) {
        k kVar = null;
        try {
            kVar = a.a(bVar);
            if (kVar == null) {
                return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new a()));
            }
            if (bVar.f() == e.OK_HTTP_RESPONSE) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar = new com.meizu.cloud.pushsdk.c.a.c<>(kVar);
                cVar.a(kVar);
                com.meizu.cloud.pushsdk.c.h.a.a(kVar, bVar);
                return cVar;
            } else if (kVar.a() >= 400) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new a(kVar), bVar, kVar.a()));
                cVar2.a(kVar);
                com.meizu.cloud.pushsdk.c.h.a.a(kVar, bVar);
                return cVar2;
            } else {
                com.meizu.cloud.pushsdk.c.a.c<T> a = bVar.a(kVar);
                a.a(kVar);
                com.meizu.cloud.pushsdk.c.h.a.a(kVar, bVar);
                return a;
            }
        } catch (a e) {
            return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new a(e)));
        } catch (Exception e2) {
            return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e2));
        } finally {
            com.meizu.cloud.pushsdk.c.h.a.a(kVar, bVar);
        }
    }

    private static <T> com.meizu.cloud.pushsdk.c.a.c<T> c(b bVar) {
        try {
            k b = a.b(bVar);
            if (b == null) {
                return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new a()));
            }
            if (b.a() >= 400) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new a(b), bVar, b.a()));
                cVar.a(b);
                return cVar;
            }
            com.meizu.cloud.pushsdk.c.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.c.a.c<>("success");
            cVar2.a(b);
            return cVar2;
        } catch (a e) {
            return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new a(e)));
        } catch (Exception e2) {
            return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e2));
        }
    }

    private static <T> com.meizu.cloud.pushsdk.c.a.c<T> d(b bVar) {
        k kVar = null;
        try {
            kVar = a.c(bVar);
            if (kVar == null) {
                return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new a()));
            }
            if (bVar.f() == e.OK_HTTP_RESPONSE) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar = new com.meizu.cloud.pushsdk.c.a.c<>(kVar);
                cVar.a(kVar);
                com.meizu.cloud.pushsdk.c.h.a.a(kVar, bVar);
                return cVar;
            } else if (kVar.a() >= 400) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new a(kVar), bVar, kVar.a()));
                cVar2.a(kVar);
                com.meizu.cloud.pushsdk.c.h.a.a(kVar, bVar);
                return cVar2;
            } else {
                com.meizu.cloud.pushsdk.c.a.c<T> a = bVar.a(kVar);
                a.a(kVar);
                com.meizu.cloud.pushsdk.c.h.a.a(kVar, bVar);
                return a;
            }
        } catch (a e) {
            return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e));
        } catch (Exception e2) {
            return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e2));
        } finally {
            com.meizu.cloud.pushsdk.c.h.a.a(kVar, bVar);
        }
    }
}
