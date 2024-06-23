package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public interface PackagePartProvider {

    /* compiled from: Taobao */
    public static final class a implements PackagePartProvider {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider
        @NotNull
        public List<String> findPackageParts(@NotNull String str) {
            k21.i(str, "packageFqName");
            return m.g();
        }
    }

    @NotNull
    List<String> findPackageParts(@NotNull String str);
}
