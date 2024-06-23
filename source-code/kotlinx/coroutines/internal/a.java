package kotlinx.coroutines.internal;

import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;
import tb.jh2;

/* compiled from: Taobao */
public final class a {
    public static final int FAILURE = 2;
    public static final int SUCCESS = 1;
    public static final int UNDECIDED = 0;
    @NotNull
    private static final Object a = new jh2("CONDITION_FALSE");
    @NotNull
    private static final Object b = new jh2("LIST_EMPTY");

    @NotNull
    public static final Object a() {
        return a;
    }

    @NotNull
    public static final Object b() {
        return b;
    }

    @PublishedApi
    @NotNull
    public static final b c(@NotNull Object obj) {
        b bVar = null;
        c cVar = obj instanceof c ? (c) obj : null;
        if (cVar != null) {
            bVar = cVar.a;
        }
        return bVar == null ? (b) obj : bVar;
    }
}
