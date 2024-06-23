package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m70;
import tb.nq0;

/* compiled from: Taobao */
public final class zq0 {
    @NotNull
    public static final m70 a(@Nullable m70 m70) {
        if (m70 instanceof m70.c) {
            return new m70.c(((m70.c) m70).c());
        }
        if (m70 instanceof m70.b) {
            return new m70.b(((m70.b) m70).c());
        }
        if (m70 instanceof m70.d) {
            return m70.d.INSTANCE;
        }
        if (m70 instanceof m70.a) {
            return m70.a.INSTANCE;
        }
        return m70.d.INSTANCE;
    }

    @NotNull
    public static final nq0 b(@Nullable nq0 nq0) {
        if (nq0 instanceof nq0.e) {
            nq0.e eVar = (nq0.e) nq0;
            return new nq0.e(eVar.e(), eVar.f());
        } else if (nq0 instanceof nq0.d) {
            nq0.d dVar = (nq0.d) nq0;
            return new nq0.d(dVar.e(), dVar.f());
        } else if (nq0 instanceof nq0.c) {
            nq0.c cVar = (nq0.c) nq0;
            return new nq0.c(cVar.e(), cVar.f());
        } else if (nq0 instanceof nq0.a) {
            return nq0.a.INSTANCE;
        } else {
            if (nq0 instanceof nq0.f) {
                return nq0.f.INSTANCE;
            }
            return nq0.f.INSTANCE;
        }
    }
}
