package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KClassImpl$Data$typeParameters$2 extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$typeParameters$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KTypeParameterImpl>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends KTypeParameterImpl> invoke() {
        List<TypeParameterDescriptor> declaredTypeParameters = this.this$0.n().getDeclaredTypeParameters();
        k21.h(declaredTypeParameters, "descriptor.declaredTypeParameters");
        ArrayList arrayList = new ArrayList(n.q(declaredTypeParameters, 10));
        for (T t : declaredTypeParameters) {
            KClassImpl kClassImpl = KClassImpl.this;
            k21.h(t, "descriptor");
            arrayList.add(new KTypeParameterImpl(kClassImpl, t));
        }
        return arrayList;
    }
}
