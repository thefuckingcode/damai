package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ky1 extends zx1 implements JavaEnumValueAnnotationArgument {
    @NotNull
    private final Enum<?> b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ky1(@Nullable og1 og1, @NotNull Enum<?> r3) {
        super(og1);
        k21.i(r3, "value");
        this.b = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
    @Nullable
    public og1 getEntryName() {
        return og1.f(this.b.name());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
    @Nullable
    public oi getEnumClassId() {
        Class<?> cls = this.b.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        k21.h(cls, "enumClass");
        return ReflectClassUtilKt.b(cls);
    }
}
