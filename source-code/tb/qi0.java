package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class qi0 implements Annotations {
    @NotNull
    private final Annotations a;
    private final boolean b;
    @NotNull
    private final Function1<en0, Boolean> c;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super tb.en0, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public qi0(@NotNull Annotations annotations, boolean z, @NotNull Function1<? super en0, Boolean> function1) {
        k21.i(annotations, "delegate");
        k21.i(function1, "fqNameFilter");
        this.a = annotations;
        this.b = z;
        this.c = function1;
    }

    private final boolean a(AnnotationDescriptor annotationDescriptor) {
        en0 fqName = annotationDescriptor.getFqName();
        return fqName != null && this.c.invoke(fqName).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        if (this.c.invoke(en0).booleanValue()) {
            return this.a.findAnnotation(en0);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        if (this.c.invoke(en0).booleanValue()) {
            return this.a.hasAnnotation(en0);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        boolean z;
        Annotations annotations = this.a;
        if (!(annotations instanceof Collection) || !((Collection) annotations).isEmpty()) {
            Iterator it = annotations.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (a((AnnotationDescriptor) it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        if (!this.b) {
            return z;
        }
        if (!z) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        Annotations annotations = this.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : annotations) {
            if (a((AnnotationDescriptor) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList.iterator();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public qi0(@NotNull Annotations annotations, @NotNull Function1<? super en0, Boolean> function1) {
        this(annotations, false, function1);
        k21.i(annotations, "delegate");
        k21.i(function1, "fqNameFilter");
    }
}
