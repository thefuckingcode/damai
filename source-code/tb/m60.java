package tb;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class m60 implements Annotations {
    static final /* synthetic */ KProperty<Object>[] b = {dz1.i(new PropertyReference1Impl(dz1.b(m60.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    @NotNull
    private final NotNullLazyValue a;

    public m60(@NotNull StorageManager storageManager, @NotNull Function0<? extends List<? extends AnnotationDescriptor>> function0) {
        k21.i(storageManager, "storageManager");
        k21.i(function0, "compute");
        this.a = storageManager.createLazyValue(function0);
    }

    private final List<AnnotationDescriptor> a() {
        return (List) te2.a(this.a, this, b[0]);
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
        return a().isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return a().iterator();
    }
}
