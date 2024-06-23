package tb;

import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class k31 implements ClassDataFinder {
    @NotNull
    private final KotlinClassFinder a;
    @NotNull
    private final DeserializedDescriptorResolver b;

    public k31(@NotNull KotlinClassFinder kotlinClassFinder, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver) {
        k21.i(kotlinClassFinder, "kotlinClassFinder");
        k21.i(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.a = kotlinClassFinder;
        this.b = deserializedDescriptorResolver;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    @Nullable
    public li findClassData(@NotNull oi oiVar) {
        k21.i(oiVar, "classId");
        KotlinJvmBinaryClass b2 = d61.b(this.a, oiVar);
        if (b2 == null) {
            return null;
        }
        k21.d(b2.getClassId(), oiVar);
        return this.b.k(b2);
    }
}
