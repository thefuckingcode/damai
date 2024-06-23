package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KProperty0Impl;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"V", "Lkotlin/reflect/jvm/internal/KProperty0Impl$a;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$a;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KProperty0Impl$_getter$1 extends Lambda implements Function0<KProperty0Impl.a<? extends V>> {
    final /* synthetic */ KProperty0Impl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KProperty0Impl$_getter$1(KProperty0Impl kProperty0Impl) {
        super(0);
        this.this$0 = kProperty0Impl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final KProperty0Impl.a<V> invoke() {
        return new KProperty0Impl.a<>(this.this$0);
    }
}
