package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import org.jetbrains.annotations.NotNull;
import tb.ib2;
import tb.k21;
import tb.oi;

/* compiled from: Taobao */
public interface PlatformDependentTypeTransformer {

    /* compiled from: Taobao */
    public static final class a implements PlatformDependentTypeTransformer {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer
        @NotNull
        public ib2 transformPlatformType(@NotNull oi oiVar, @NotNull ib2 ib2) {
            k21.i(oiVar, "classId");
            k21.i(ib2, "computedType");
            return ib2;
        }
    }

    @NotNull
    ib2 transformPlatformType(@NotNull oi oiVar, @NotNull ib2 ib2);
}
