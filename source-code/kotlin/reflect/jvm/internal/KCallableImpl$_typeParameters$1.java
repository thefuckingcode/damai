package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KCallableImpl$_typeParameters$1 extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {
    final /* synthetic */ KCallableImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KCallableImpl$_typeParameters$1(KCallableImpl kCallableImpl) {
        super(0);
        this.this$0 = kCallableImpl;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KTypeParameterImpl>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends KTypeParameterImpl> invoke() {
        List<TypeParameterDescriptor> typeParameters = this.this$0.i().getTypeParameters();
        k21.h(typeParameters, "descriptor.typeParameters");
        ArrayList arrayList = new ArrayList(n.q(typeParameters, 10));
        for (T t : typeParameters) {
            KCallableImpl kCallableImpl = this.this$0;
            k21.h(t, "descriptor");
            arrayList.add(new KTypeParameterImpl(kCallableImpl, t));
        }
        return arrayList;
    }
}
