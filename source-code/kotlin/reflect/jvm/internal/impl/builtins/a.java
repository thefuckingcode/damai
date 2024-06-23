package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;
import tb.m40;

/* compiled from: Taobao */
public final class a extends b {
    @NotNull
    public static final C0265a Companion = new C0265a(null);
    @NotNull
    private static final a f = new a(false, 1, null);

    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0265a {
        private C0265a() {
        }

        public /* synthetic */ C0265a(m40 m40) {
            this();
        }

        @NotNull
        public final a a() {
            return a.f;
        }
    }

    public a(boolean z) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z) {
            f(false);
        }
    }

    @NotNull
    public static final a N0() {
        return Companion.a();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(boolean z, int i, m40 m40) {
        this((i & 1) != 0 ? true : z);
    }
}
