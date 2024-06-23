package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.ib2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class BuiltInAnnotationDescriptor$type$2 extends Lambda implements Function0<ib2> {
    final /* synthetic */ BuiltInAnnotationDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuiltInAnnotationDescriptor$type$2(BuiltInAnnotationDescriptor builtInAnnotationDescriptor) {
        super(0);
        this.this$0 = builtInAnnotationDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ib2 invoke() {
        return this.this$0.a.o(this.this$0.getFqName()).getDefaultType();
    }
}
