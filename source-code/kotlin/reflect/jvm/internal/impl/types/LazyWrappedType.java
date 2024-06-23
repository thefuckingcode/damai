package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.i61;
import tb.k21;
import tb.sz2;

/* compiled from: Taobao */
public final class LazyWrappedType extends sz2 {
    @NotNull
    private final StorageManager b;
    @NotNull
    private final Function0<g61> c;
    @NotNull
    private final NotNullLazyValue<g61> d;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function0<? extends tb.g61> */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyWrappedType(@NotNull StorageManager storageManager, @NotNull Function0<? extends g61> function0) {
        k21.i(storageManager, "storageManager");
        k21.i(function0, "computation");
        this.b = storageManager;
        this.c = function0;
        this.d = storageManager.createLazyValue(function0);
    }

    /* access modifiers changed from: protected */
    @Override // tb.sz2
    @NotNull
    public g61 g() {
        return (g61) this.d.invoke();
    }

    @Override // tb.sz2
    public boolean h() {
        return this.d.isComputed();
    }

    @NotNull
    /* renamed from: j */
    public LazyWrappedType e(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return new LazyWrappedType(this.b, new LazyWrappedType$refine$1(i61, this));
    }
}
