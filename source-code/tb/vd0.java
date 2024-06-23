package tb;

import java.util.Iterator;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
final class vd0 implements Annotations {
    @NotNull
    private final en0 a;

    public vd0(@NotNull en0 en0) {
        k21.i(en0, "fqNameToMatch");
        this.a = en0;
    }

    @Nullable
    /* renamed from: a */
    public ud0 findAnnotation(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        if (k21.d(en0, this.a)) {
            return ud0.INSTANCE;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull en0 en0) {
        return Annotations.b.b(this, en0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return m.g().iterator();
    }
}
