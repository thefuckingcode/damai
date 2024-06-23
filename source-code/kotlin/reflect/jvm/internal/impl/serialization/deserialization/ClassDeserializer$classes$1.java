package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ClassDeserializer$classes$1 extends Lambda implements Function1<ClassDeserializer.a, ClassDescriptor> {
    final /* synthetic */ ClassDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClassDeserializer$classes$1(ClassDeserializer classDeserializer) {
        super(1);
        this.this$0 = classDeserializer;
    }

    @Nullable
    public final ClassDescriptor invoke(@NotNull ClassDeserializer.a aVar) {
        k21.i(aVar, "key");
        return this.this$0.c(aVar);
    }
}
