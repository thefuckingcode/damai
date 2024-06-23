package tb;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class d61 {
    @Nullable
    public static final KotlinJvmBinaryClass a(@NotNull KotlinClassFinder kotlinClassFinder, @NotNull JavaClass javaClass) {
        k21.i(kotlinClassFinder, "<this>");
        k21.i(javaClass, "javaClass");
        KotlinClassFinder.a findKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(javaClass);
        if (findKotlinClassOrContent == null) {
            return null;
        }
        return findKotlinClassOrContent.a();
    }

    @Nullable
    public static final KotlinJvmBinaryClass b(@NotNull KotlinClassFinder kotlinClassFinder, @NotNull oi oiVar) {
        k21.i(kotlinClassFinder, "<this>");
        k21.i(oiVar, "classId");
        KotlinClassFinder.a findKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(oiVar);
        if (findKotlinClassOrContent == null) {
            return null;
        }
        return findKotlinClassOrContent.a();
    }
}
