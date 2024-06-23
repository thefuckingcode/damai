package tb;

import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class d6 implements Annotations {
    @NotNull
    private final List<AnnotationDescriptor> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    public d6(@NotNull List<? extends AnnotationDescriptor> list) {
        k21.i(list, "annotations");
        this.a = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull en0 en0) {
        return Annotations.b.a(this, en0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull en0 en0) {
        return Annotations.b.b(this, en0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return this.a.iterator();
    }

    @NotNull
    public String toString() {
        return this.a.toString();
    }
}
