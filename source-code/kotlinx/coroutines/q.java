package kotlinx.coroutines;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jh2;

/* compiled from: Taobao */
public final class q {
    @JvmField
    @NotNull
    public static final jh2 COMPLETING_WAITING_CHILDREN = new jh2("COMPLETING_WAITING_CHILDREN");
    @NotNull
    private static final jh2 a = new jh2("COMPLETING_ALREADY");
    @NotNull
    private static final jh2 b = new jh2("COMPLETING_RETRY");
    @NotNull
    private static final jh2 c = new jh2("TOO_LATE_TO_CANCEL");
    @NotNull
    private static final jh2 d = new jh2("SEALED");
    @NotNull
    private static final j e = new j(false);
    @NotNull
    private static final j f = new j(true);

    @Nullable
    public static final Object g(@Nullable Object obj) {
        return obj instanceof Incomplete ? new m((Incomplete) obj) : obj;
    }

    @Nullable
    public static final Object h(@Nullable Object obj) {
        Incomplete incomplete;
        m mVar = obj instanceof m ? (m) obj : null;
        return (mVar == null || (incomplete = mVar.a) == null) ? obj : incomplete;
    }
}
