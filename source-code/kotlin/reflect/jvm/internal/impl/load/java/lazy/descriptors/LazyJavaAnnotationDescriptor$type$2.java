package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.ib2;
import tb.k21;
import tb.me0;
import tb.x31;

/* compiled from: Taobao */
final class LazyJavaAnnotationDescriptor$type$2 extends Lambda implements Function0<ib2> {
    final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaAnnotationDescriptor$type$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.this$0 = lazyJavaAnnotationDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ib2 invoke() {
        en0 fqName = this.this$0.getFqName();
        if (fqName == null) {
            return me0.j(k21.r("No fqName: ", LazyJavaAnnotationDescriptor.c(this.this$0)));
        }
        ClassDescriptor h = x31.h(x31.INSTANCE, fqName, LazyJavaAnnotationDescriptor.b(this.this$0).d().getBuiltIns(), null, 4, null);
        if (h == null) {
            JavaClass resolve = LazyJavaAnnotationDescriptor.c(this.this$0).resolve();
            h = resolve == null ? null : LazyJavaAnnotationDescriptor.b(this.this$0).a().m().resolveClass(resolve);
            if (h == null) {
                h = LazyJavaAnnotationDescriptor.a(this.this$0, fqName);
            }
        }
        return h.getDefaultType();
    }
}
