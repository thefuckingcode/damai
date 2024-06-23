package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface JavaResolverSettings {
    @NotNull
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    /* compiled from: Taobao */
    public static final class b implements JavaResolverSettings {
        @NotNull
        public static final b INSTANCE = new b();

        private b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
        public boolean getCorrectNullabilityForNotNullTypeParameter() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
        public boolean getTypeEnhancementImprovements() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
        public boolean isReleaseCoroutines() {
            return false;
        }
    }

    boolean getCorrectNullabilityForNotNullTypeParameter();

    boolean getTypeEnhancementImprovements();

    boolean isReleaseCoroutines();
}
