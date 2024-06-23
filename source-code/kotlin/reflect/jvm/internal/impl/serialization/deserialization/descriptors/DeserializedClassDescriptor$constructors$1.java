package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedClassDescriptor$constructors$1 extends Lambda implements Function0<Collection<? extends ClassConstructorDescriptor>> {
    final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedClassDescriptor$constructors$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
    }

    /* Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Collection<? extends ClassConstructorDescriptor> invoke() {
        return this.this$0.m();
    }
}
