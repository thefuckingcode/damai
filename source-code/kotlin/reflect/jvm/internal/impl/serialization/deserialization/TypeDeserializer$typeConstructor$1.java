package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.sequences.SequencesKt;

/* access modifiers changed from: package-private */
/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer$typeConstructor$1 extends Lambda implements Function1<Integer, ClassDescriptor> {
    final /* synthetic */ ProtoBuf.Type $proto;
    final /* synthetic */ TypeDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeDeserializer$typeConstructor$1(TypeDeserializer typeDeserializer, ProtoBuf.Type type) {
        super(1);
        this.this$0 = typeDeserializer;
        this.$proto = type;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ClassDescriptor invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final ClassDescriptor invoke(int i) {
        ClassId classId = NameResolverUtilKt.getClassId(this.this$0.c.getNameResolver(), i);
        List<Integer> mutableList = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.generateSequence(this.$proto, new TypeDeserializer$typeConstructor$1$typeParametersCount$1(this)), TypeDeserializer$typeConstructor$1$typeParametersCount$2.INSTANCE));
        int count = SequencesKt.count(SequencesKt.generateSequence(classId, TypeDeserializer$typeConstructor$1$classNestingLevel$1.INSTANCE));
        while (mutableList.size() < count) {
            mutableList.add(0);
        }
        return this.this$0.c.getComponents().getNotFoundClasses().getClass(classId, mutableList);
    }
}
