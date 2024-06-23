package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class tr1 {
    @NotNull
    private final ClassifierDescriptorWithTypeParameters a;
    @NotNull
    private final List<TypeProjection> b;
    @Nullable
    private final tr1 c;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
    /* JADX WARN: Multi-variable type inference failed */
    public tr1(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, @NotNull List<? extends TypeProjection> list, @Nullable tr1 tr1) {
        k21.i(classifierDescriptorWithTypeParameters, "classifierDescriptor");
        k21.i(list, "arguments");
        this.a = classifierDescriptorWithTypeParameters;
        this.b = list;
        this.c = tr1;
    }

    @NotNull
    public final List<TypeProjection> a() {
        return this.b;
    }

    @NotNull
    public final ClassifierDescriptorWithTypeParameters b() {
        return this.a;
    }

    @Nullable
    public final tr1 c() {
        return this.c;
    }
}
