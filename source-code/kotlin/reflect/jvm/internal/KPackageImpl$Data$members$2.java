package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001 \u0002*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/Collection;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class KPackageImpl$Data$members$2 extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
    final /* synthetic */ KPackageImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KPackageImpl$Data$members$2(KPackageImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    /* Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Collection<? extends KCallableImpl<?>> invoke() {
        KPackageImpl.Data data = this.this$0;
        return KPackageImpl.this.l(data.g(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
    }
}
