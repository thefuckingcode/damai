package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/Collection;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KClassImpl$Data$declaredStaticMembers$2 extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$declaredStaticMembers$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    /* Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Collection<? extends KCallableImpl<?>> invoke() {
        KClassImpl kClassImpl = KClassImpl.this;
        return kClassImpl.l(kClassImpl.A(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
    }
}
