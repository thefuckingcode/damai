package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.internal.KPropertyImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0007\u001a/\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0003*\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"getExtensionDelegate", "", "Lkotlin/reflect/KProperty1;", "D", "Lkotlin/reflect/KProperty2;", "receiver", "(Lkotlin/reflect/KProperty2;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 2, mv = {1, 1, 16})
/* compiled from: KProperties.kt */
public final class KProperties {
    public static final Object getExtensionDelegate(KProperty1<?, ?> kProperty1) {
        Intrinsics.checkParameterIsNotNull(kProperty1, "$this$getExtensionDelegate");
        return kProperty1.getDelegate(KPropertyImpl.Companion.getEXTENSION_PROPERTY_DELEGATE());
    }

    public static final <D> Object getExtensionDelegate(KProperty2<D, ?, ?> kProperty2, D d) {
        Intrinsics.checkParameterIsNotNull(kProperty2, "$this$getExtensionDelegate");
        return kProperty2.getDelegate(d, KPropertyImpl.Companion.getEXTENSION_PROPERTY_DELEGATE());
    }
}
