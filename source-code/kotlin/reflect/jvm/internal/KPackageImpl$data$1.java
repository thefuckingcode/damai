package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPackageImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0012 \u0002*\b\u0018\u00010\u0000R\u00020\u00010\u0000R\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KPackageImpl;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class KPackageImpl$data$1 extends Lambda implements Function0<KPackageImpl.Data> {
    final /* synthetic */ KPackageImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KPackageImpl$data$1(KPackageImpl kPackageImpl) {
        super(0);
        this.this$0 = kPackageImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final KPackageImpl.Data invoke() {
        return new KPackageImpl.Data();
    }
}
