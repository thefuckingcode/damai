package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.k21;
import tb.og1;
import tb.om;
import tb.te2;
import tb.x61;

/* compiled from: Taobao */
public final class JavaDeprecatedAnnotationDescriptor extends JavaAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] h = {dz1.i(new PropertyReference1Impl(dz1.b(JavaDeprecatedAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @NotNull
    private final NotNullLazyValue g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JavaDeprecatedAnnotationDescriptor(@Nullable JavaAnnotation javaAnnotation, @NotNull x61 x61) {
        super(x61, javaAnnotation, c.a.deprecated);
        k21.i(x61, com.huawei.hms.opendevice.c.a);
        this.g = x61.e().createLazyValue(JavaDeprecatedAnnotationDescriptor$allValueArguments$2.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<og1, om<?>> getAllValueArguments() {
        return (Map) te2.a(this.g, this, h[0]);
    }
}
