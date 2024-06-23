package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.d2;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class LazyScopeAdapter extends d2 {
    @NotNull
    private final NotNullLazyValue<MemberScope> a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LazyScopeAdapter(@NotNull Function0<? extends MemberScope> function0) {
        this(null, function0, 1, null);
        k21.i(function0, "getScope");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ LazyScopeAdapter(StorageManager storageManager, Function0 function0, int i, m40 m40) {
        this(storageManager, function0);
        if ((i & 1) != 0) {
            storageManager = LockBasedStorageManager.NO_LOCKS;
            k21.h(storageManager, "NO_LOCKS");
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.d2
    @NotNull
    public MemberScope b() {
        return (MemberScope) this.a.invoke();
    }

    @JvmOverloads
    public LazyScopeAdapter(@NotNull StorageManager storageManager, @NotNull Function0<? extends MemberScope> function0) {
        k21.i(storageManager, "storageManager");
        k21.i(function0, "getScope");
        this.a = storageManager.createLazyValue(new LazyScopeAdapter$lazyScope$1(function0));
    }
}
