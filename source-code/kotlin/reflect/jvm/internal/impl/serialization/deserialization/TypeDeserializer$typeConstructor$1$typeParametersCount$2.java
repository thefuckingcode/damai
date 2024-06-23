package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* access modifiers changed from: package-private */
/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer$typeConstructor$1$typeParametersCount$2 extends Lambda implements Function1<ProtoBuf.Type, Integer> {
    public static final TypeDeserializer$typeConstructor$1$typeParametersCount$2 INSTANCE = new TypeDeserializer$typeConstructor$1$typeParametersCount$2();

    TypeDeserializer$typeConstructor$1$typeParametersCount$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(ProtoBuf.Type type) {
        return Integer.valueOf(invoke(type));
    }

    public final int invoke(ProtoBuf.Type type) {
        Intrinsics.checkParameterIsNotNull(type, "it");
        return type.getArgumentCount();
    }
}
