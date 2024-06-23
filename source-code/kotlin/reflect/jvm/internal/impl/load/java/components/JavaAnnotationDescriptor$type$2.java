package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.ib2;
import tb.k21;
import tb.x61;

/* compiled from: Taobao */
final class JavaAnnotationDescriptor$type$2 extends Lambda implements Function0<ib2> {
    final /* synthetic */ x61 $c;
    final /* synthetic */ JavaAnnotationDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaAnnotationDescriptor$type$2(x61 x61, JavaAnnotationDescriptor javaAnnotationDescriptor) {
        super(0);
        this.$c = x61;
        this.this$0 = javaAnnotationDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ib2 invoke() {
        ib2 defaultType = this.$c.d().getBuiltIns().o(this.this$0.getFqName()).getDefaultType();
        k21.h(defaultType, "c.module.builtIns.getBuiltInClassByFqName(fqName).defaultType");
        return defaultType;
    }
}
