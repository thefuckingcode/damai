package tb;

import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class un extends l1 implements ThreadContextElement<String> {
    @NotNull
    public static final a Key = new a(null);
    private final long a;

    /* compiled from: Taobao */
    public static final class a implements CoroutineContext.Key<un> {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public un(long j) {
        super(Key);
        this.a = j;
    }

    public final long a() {
        return this.a;
    }

    /* renamed from: b */
    public void restoreThreadContext(@NotNull CoroutineContext coroutineContext, @NotNull String str) {
        Thread.currentThread().setName(str);
    }

    @NotNull
    /* renamed from: c */
    public String updateThreadContext(@NotNull CoroutineContext coroutineContext) {
        String name;
        vn vnVar = (vn) coroutineContext.get(vn.Key);
        String str = "coroutine";
        if (!(vnVar == null || (name = vnVar.getName()) == null)) {
            str = name;
        }
        Thread currentThread = Thread.currentThread();
        String name2 = currentThread.getName();
        int i = StringsKt__StringsKt.l0(name2, " @", 0, false, 6, null);
        if (i < 0) {
            i = name2.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + i + 10);
        Objects.requireNonNull(name2, "null cannot be cast to non-null type java.lang.String");
        String substring = name2.substring(0, i);
        k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(a());
        ur2 ur2 = ur2.INSTANCE;
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return name2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof un) && this.a == ((un) obj).a;
    }

    public int hashCode() {
        return tn.a(this.a);
    }

    @NotNull
    public String toString() {
        return "CoroutineId(" + this.a + ')';
    }
}
