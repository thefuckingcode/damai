package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.huawei.hms.opendevice.c;
import java.util.Collection;
import java.util.Map;
import kotlin.collections.k;
import kotlin.collections.x;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.en0;
import tb.ib2;
import tb.k21;
import tb.og1;
import tb.om;
import tb.te2;
import tb.x61;

/* compiled from: Taobao */
public class JavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] f = {dz1.i(new PropertyReference1Impl(dz1.b(JavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    @NotNull
    private final en0 a;
    @NotNull
    private final SourceElement b;
    @NotNull
    private final NotNullLazyValue c;
    @Nullable
    private final JavaAnnotationArgument d;
    private final boolean e;

    public JavaAnnotationDescriptor(@NotNull x61 x61, @Nullable JavaAnnotation javaAnnotation, @NotNull en0 en0) {
        SourceElement sourceElement;
        JavaAnnotationArgument javaAnnotationArgument;
        Collection<JavaAnnotationArgument> arguments;
        k21.i(x61, c.a);
        k21.i(en0, "fqName");
        this.a = en0;
        Boolean bool = null;
        if (javaAnnotation == null) {
            sourceElement = null;
        } else {
            sourceElement = x61.a().s().source(javaAnnotation);
        }
        if (sourceElement == null) {
            sourceElement = SourceElement.NO_SOURCE;
            k21.h(sourceElement, "NO_SOURCE");
        }
        this.b = sourceElement;
        this.c = x61.e().createLazyValue(new JavaAnnotationDescriptor$type$2(x61, this));
        if (javaAnnotation == null || (arguments = javaAnnotation.getArguments()) == null) {
            javaAnnotationArgument = null;
        } else {
            javaAnnotationArgument = (JavaAnnotationArgument) k.Q(arguments);
        }
        this.d = javaAnnotationArgument;
        this.e = k21.d(javaAnnotation != null ? Boolean.valueOf(javaAnnotation.isIdeExternalAnnotation()) : bool, Boolean.TRUE);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final JavaAnnotationArgument a() {
        return this.d;
    }

    @NotNull
    /* renamed from: b */
    public ib2 getType() {
        return (ib2) te2.a(this.c, this, f[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<og1, om<?>> getAllValueArguments() {
        return x.i();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public en0 getFqName() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public SourceElement getSource() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.e;
    }
}
