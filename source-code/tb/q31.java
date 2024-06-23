package tb;

import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class q31 implements FlexibleTypeDeserializer {
    @NotNull
    public static final q31 INSTANCE = new q31();

    private q31() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
    @NotNull
    public g61 create(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull String str, @NotNull ib2 ib2, @NotNull ib2 ib22) {
        k21.i(protoBuf$Type, "proto");
        k21.i(str, "flexibleId");
        k21.i(ib2, "lowerBound");
        k21.i(ib22, "upperBound");
        if (!k21.d(str, "kotlin.jvm.PlatformType")) {
            ib2 j = me0.j("Error java flexible type with id: " + str + ". (" + ib2 + ".." + ib22 + ')');
            k21.h(j, "createErrorType(\"Error java flexible type with id: $flexibleId. ($lowerBound..$upperBound)\")");
            return j;
        } else if (protoBuf$Type.hasExtension(JvmProtoBuf.isRaw)) {
            return new RawTypeImpl(ib2, ib22);
        } else {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return KotlinTypeFactory.d(ib2, ib22);
        }
    }
}
