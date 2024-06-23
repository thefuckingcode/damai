package tb;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class gy1 extends zx1 implements JavaClassObjectAnnotationArgument {
    @NotNull
    private final Class<?> b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public gy1(@Nullable og1 og1, @NotNull Class<?> cls) {
        super(og1);
        k21.i(cls, "klass");
        this.b = cls;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument
    @NotNull
    public JavaType getReferencedType() {
        return ry1.Factory.a(this.b);
    }
}
