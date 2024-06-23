package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KProperty1Impl;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0003*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "V", "Lkotlin/reflect/jvm/internal/KProperty1Impl$a;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$a;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KProperty1Impl$_getter$1 extends Lambda implements Function0<KProperty1Impl.a<T, ? extends V>> {
    final /* synthetic */ KProperty1Impl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KProperty1Impl$_getter$1(KProperty1Impl kProperty1Impl) {
        super(0);
        this.this$0 = kProperty1Impl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final KProperty1Impl.a<T, V> invoke() {
        return new KProperty1Impl.a<>(this.this$0);
    }
}
