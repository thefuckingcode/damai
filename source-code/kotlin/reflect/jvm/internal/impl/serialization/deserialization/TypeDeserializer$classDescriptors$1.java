package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* access modifiers changed from: package-private */
/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer$classDescriptors$1 extends Lambda implements Function1<Integer, ClassDescriptor> {
    final /* synthetic */ TypeDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeDeserializer$classDescriptors$1(TypeDeserializer typeDeserializer) {
        super(1);
        this.this$0 = typeDeserializer;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ClassDescriptor invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final ClassDescriptor invoke(int i) {
        return this.this$0.computeClassDescriptor(i);
    }
}
