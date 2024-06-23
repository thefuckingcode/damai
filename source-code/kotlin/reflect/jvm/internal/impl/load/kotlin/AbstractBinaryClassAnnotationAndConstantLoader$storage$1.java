package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class AbstractBinaryClassAnnotationAndConstantLoader$storage$1 extends Lambda implements Function1<KotlinJvmBinaryClass, AbstractBinaryClassAnnotationAndConstantLoader.a<? extends A, ? extends C>> {
    final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractBinaryClassAnnotationAndConstantLoader$storage$1(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader) {
        super(1);
        this.this$0 = abstractBinaryClassAnnotationAndConstantLoader;
    }

    @NotNull
    public final AbstractBinaryClassAnnotationAndConstantLoader.a<A, C> invoke(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        k21.i(kotlinJvmBinaryClass, "kotlinClass");
        return AbstractBinaryClassAnnotationAndConstantLoader.b(this.this$0, kotlinJvmBinaryClass);
    }
}
