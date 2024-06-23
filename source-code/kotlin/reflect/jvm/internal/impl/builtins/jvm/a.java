package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;
import tb.m40;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class a extends b {
    @NotNull
    public static final C0268a Companion = new C0268a(null);
    @NotNull
    private static final b f = new a();

    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0268a {
        private C0268a() {
        }

        public /* synthetic */ C0268a(m40 m40) {
            this();
        }

        @NotNull
        public final b a() {
            return a.f;
        }
    }

    private a() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        f(true);
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: N0 */
    public PlatformDependentDeclarationFilter.a M() {
        return PlatformDependentDeclarationFilter.a.INSTANCE;
    }
}
