package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.oi;

/* compiled from: Taobao */
final class LazyJavaAnnotationDescriptor$fqName$2 extends Lambda implements Function0<en0> {
    final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaAnnotationDescriptor$fqName$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.this$0 = lazyJavaAnnotationDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final en0 invoke() {
        oi classId = LazyJavaAnnotationDescriptor.c(this.this$0).getClassId();
        if (classId == null) {
            return null;
        }
        return classId.b();
    }
}
