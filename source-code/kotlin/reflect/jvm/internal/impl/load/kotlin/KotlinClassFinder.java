package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.oi;

/* compiled from: Taobao */
public interface KotlinClassFinder extends KotlinMetadataFinder {

    /* compiled from: Taobao */
    public static abstract class a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0275a extends a {
            @NotNull
            private final byte[] a;

            @NotNull
            public final byte[] b() {
                return this.a;
            }
        }

        /* compiled from: Taobao */
        public static final class b extends a {
            @NotNull
            private final KotlinJvmBinaryClass a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass, @Nullable byte[] bArr) {
                super(null);
                k21.i(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.a = kotlinJvmBinaryClass;
            }

            @NotNull
            public final KotlinJvmBinaryClass b() {
                return this.a;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ b(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr, int i, m40 m40) {
                this(kotlinJvmBinaryClass, (i & 2) != 0 ? null : bArr);
            }
        }

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @Nullable
        public final KotlinJvmBinaryClass a() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar == null) {
                return null;
            }
            return bVar.b();
        }
    }

    @Nullable
    a findKotlinClassOrContent(@NotNull JavaClass javaClass);

    @Nullable
    a findKotlinClassOrContent(@NotNull oi oiVar);
}
