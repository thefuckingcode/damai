package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tb.lf;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class r extends w {
    @NotNull
    private final Continuation<ur2> a;

    public r(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super ur2>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.a = IntrinsicsKt__IntrinsicsJvmKt.b(function2, this, this);
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public void onStart() {
        lf.a(this.a, this);
    }
}
