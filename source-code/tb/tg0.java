package tb;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class tg0 extends a2 {
    @NotNull
    private final a a = new a();

    /* compiled from: Taobao */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* access modifiers changed from: protected */
        @NotNull
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // tb.a2
    @NotNull
    public Random getImpl() {
        Object obj = this.a.get();
        k21.h(obj, "implStorage.get()");
        return (Random) obj;
    }
}
