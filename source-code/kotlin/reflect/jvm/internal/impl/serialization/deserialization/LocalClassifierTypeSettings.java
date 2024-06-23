package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ib2;

/* compiled from: Taobao */
public interface LocalClassifierTypeSettings {

    /* compiled from: Taobao */
    public static final class a implements LocalClassifierTypeSettings {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings
        @Nullable
        public ib2 getReplacementTypeForLocalClassifiers() {
            return null;
        }
    }

    @Nullable
    ib2 getReplacementTypeForLocalClassifiers();
}
