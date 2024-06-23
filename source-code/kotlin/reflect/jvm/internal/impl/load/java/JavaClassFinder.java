package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.k21;
import tb.m40;
import tb.oi;

/* compiled from: Taobao */
public interface JavaClassFinder {
    @Nullable
    JavaClass findClass(@NotNull a aVar);

    @Nullable
    JavaPackage findPackage(@NotNull en0 en0);

    @Nullable
    Set<String> knownClassNamesInPackage(@NotNull en0 en0);

    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        private final oi a;
        @Nullable
        private final byte[] b;
        @Nullable
        private final JavaClass c;

        public a(@NotNull oi oiVar, @Nullable byte[] bArr, @Nullable JavaClass javaClass) {
            k21.i(oiVar, "classId");
            this.a = oiVar;
            this.b = bArr;
            this.c = javaClass;
        }

        @NotNull
        public final oi a() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return k21.d(this.a, aVar.a) && k21.d(this.b, aVar.b) && k21.d(this.c, aVar.c);
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            byte[] bArr = this.b;
            int i = 0;
            int hashCode2 = (hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            JavaClass javaClass = this.c;
            if (javaClass != null) {
                i = javaClass.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            return "Request(classId=" + this.a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.b) + ", outerClass=" + this.c + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(oi oiVar, byte[] bArr, JavaClass javaClass, int i, m40 m40) {
            this(oiVar, (i & 2) != 0 ? null : bArr, (i & 4) != 0 ? null : javaClass);
        }
    }
}
