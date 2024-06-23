package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import tb.k21;
import tb.wt2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003 \u0004*\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KClassImpl$Data$sealedSubclasses$2 extends Lambda implements Function0<List<? extends KClassImpl<? extends T>>> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$sealedSubclasses$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<KClassImpl<? extends T>> invoke() {
        Collection<ClassDescriptor> sealedSubclasses = this.this$0.n().getSealedSubclasses();
        k21.h(sealedSubclasses, "descriptor.sealedSubclasses");
        ArrayList arrayList = new ArrayList();
        for (T t : sealedSubclasses) {
            Objects.requireNonNull(t, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> n = wt2.n(t);
            KClassImpl kClassImpl = n != null ? new KClassImpl(n) : null;
            if (kClassImpl != null) {
                arrayList.add(kClassImpl);
            }
        }
        return arrayList;
    }
}
