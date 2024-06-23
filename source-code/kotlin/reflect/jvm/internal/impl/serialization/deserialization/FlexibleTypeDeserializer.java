package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.ib2;
import tb.k21;

/* compiled from: Taobao */
public interface FlexibleTypeDeserializer {

    /* compiled from: Taobao */
    public static final class a implements FlexibleTypeDeserializer {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
        @NotNull
        public g61 create(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull String str, @NotNull ib2 ib2, @NotNull ib2 ib22) {
            k21.i(protoBuf$Type, "proto");
            k21.i(str, "flexibleId");
            k21.i(ib2, "lowerBound");
            k21.i(ib22, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    @NotNull
    g61 create(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull String str, @NotNull ib2 ib2, @NotNull ib2 ib22);
}
