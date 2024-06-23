package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class gv2 {
    public static final boolean a(@NotNull nb nbVar) {
        k21.i(nbVar, "version");
        return nbVar.a() == 1 && nbVar.b() >= 4;
    }

    public static final boolean b(@NotNull nb nbVar) {
        k21.i(nbVar, "version");
        return a(nbVar);
    }
}
