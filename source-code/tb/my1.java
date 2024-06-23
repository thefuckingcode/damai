package tb;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class my1 extends zx1 implements JavaLiteralAnnotationArgument {
    @NotNull
    private final Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public my1(@Nullable og1 og1, @NotNull Object obj) {
        super(og1);
        k21.i(obj, "value");
        this.b = obj;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument
    @NotNull
    public Object getValue() {
        return this.b;
    }
}
