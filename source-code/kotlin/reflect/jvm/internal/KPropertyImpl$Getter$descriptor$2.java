package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import tb.z50;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001\"\u0006\b\u0001\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"V", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KPropertyImpl$Getter$descriptor$2 extends Lambda implements Function0<PropertyGetterDescriptor> {
    final /* synthetic */ KPropertyImpl.Getter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KPropertyImpl$Getter$descriptor$2(KPropertyImpl.Getter getter) {
        super(0);
        this.this$0 = getter;
    }

    @Override // kotlin.jvm.functions.Function0
    public final PropertyGetterDescriptor invoke() {
        PropertyGetterDescriptor getter = this.this$0.m().i().getGetter();
        return getter != null ? getter : z50.b(this.this$0.m().i(), Annotations.Companion.b());
    }
}
