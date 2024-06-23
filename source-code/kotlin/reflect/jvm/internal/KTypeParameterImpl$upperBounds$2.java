package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.g61;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KTypeParameterImpl$upperBounds$2 extends Lambda implements Function0<List<? extends KTypeImpl>> {
    final /* synthetic */ KTypeParameterImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KTypeParameterImpl$upperBounds$2(KTypeParameterImpl kTypeParameterImpl) {
        super(0);
        this.this$0 = kTypeParameterImpl;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KTypeImpl>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends KTypeImpl> invoke() {
        List<g61> upperBounds = this.this$0.getDescriptor().getUpperBounds();
        k21.h(upperBounds, "descriptor.upperBounds");
        ArrayList arrayList = new ArrayList(n.q(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(new KTypeImpl(it.next(), null, 2, null));
        }
        return arrayList;
    }
}
