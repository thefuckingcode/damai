package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.huawei.hms.opendevice.c;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.SequencesKt___SequencesKt;
import tb.en0;
import tb.i31;
import tb.k21;
import tb.m40;
import tb.x61;

public final class LazyJavaAnnotations implements Annotations {
    private final x61 a;
    private final JavaAnnotationOwner b;
    private final boolean c;
    private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> d;

    public LazyJavaAnnotations(x61 x61, JavaAnnotationOwner javaAnnotationOwner, boolean z) {
        k21.i(x61, c.a);
        k21.i(javaAnnotationOwner, "annotationOwner");
        this.a = x61;
        this.b = javaAnnotationOwner;
        this.c = z;
        this.d = x61.a().t().createMemoizedFunctionWithNullableValues(new LazyJavaAnnotations$annotationDescriptors$1(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public AnnotationDescriptor findAnnotation(en0 en0) {
        k21.i(en0, "fqName");
        JavaAnnotation findAnnotation = this.b.findAnnotation(en0);
        AnnotationDescriptor invoke = findAnnotation == null ? null : this.d.invoke(findAnnotation);
        return invoke == null ? i31.INSTANCE.a(en0, this.b, this.a) : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(en0 en0) {
        return Annotations.b.b(this, en0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return this.b.getAnnotations().isEmpty() && !this.b.isDeprecatedInJavaDoc();
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt___SequencesKt.q(SequencesKt___SequencesKt.y(SequencesKt___SequencesKt.v(CollectionsKt___CollectionsKt.I(this.b.getAnnotations()), this.d), i31.INSTANCE.a(c.a.deprecated, this.b, this.a))).iterator();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaAnnotations(x61 x61, JavaAnnotationOwner javaAnnotationOwner, boolean z, int i, m40 m40) {
        this(x61, javaAnnotationOwner, (i & 4) != 0 ? false : z);
    }
}
