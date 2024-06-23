package tb;

import java.util.Collection;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.reflect.KCallable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.1")
/* compiled from: Taobao */
public final class ln1 implements ClassBasedDeclarationContainer {
    @NotNull
    private final Class<?> a;

    public ln1(@NotNull Class<?> cls, @NotNull String str) {
        k21.i(cls, "jClass");
        k21.i(str, "moduleName");
        this.a = cls;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ln1) && k21.d(getJClass(), ((ln1) obj).getJClass());
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    public Class<?> getJClass() {
        return this.a;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        throw new KotlinReflectionNotSupportedError();
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    @NotNull
    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
