package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;

/* access modifiers changed from: package-private */
/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer$typeConstructor$1$typeParametersCount$1 extends Lambda implements Function1<ProtoBuf.Type, ProtoBuf.Type> {
    final /* synthetic */ TypeDeserializer$typeConstructor$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeDeserializer$typeConstructor$1$typeParametersCount$1(TypeDeserializer$typeConstructor$1 typeDeserializer$typeConstructor$1) {
        super(1);
        this.this$0 = typeDeserializer$typeConstructor$1;
    }

    public final ProtoBuf.Type invoke(ProtoBuf.Type type) {
        Intrinsics.checkParameterIsNotNull(type, "it");
        return ProtoTypeTableUtilKt.outerType(type, this.this$0.this$0.c.getTypeTable());
    }
}
