package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.k21;

/* compiled from: Taobao */
public final class CompositeAnnotations implements Annotations {
    @NotNull
    private final List<Annotations> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations> */
    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(@NotNull List<? extends Annotations> list) {
        k21.i(list, "delegates");
        this.a = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        return (AnnotationDescriptor) d.s(SequencesKt___SequencesKt.w(CollectionsKt___CollectionsKt.I(this.a), new CompositeAnnotations$findAnnotation$1(en0)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        for (Annotations annotations : CollectionsKt___CollectionsKt.I(this.a)) {
            if (annotations.hasAnnotation(en0)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        List<Annotations> list = this.a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt___SequencesKt.t(CollectionsKt___CollectionsKt.I(this.a), CompositeAnnotations$iterator$1.INSTANCE).iterator();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CompositeAnnotations(@NotNull Annotations... annotationsArr) {
        this(ArraysKt___ArraysKt.X(annotationsArr));
        k21.i(annotationsArr, "delegates");
    }
}
