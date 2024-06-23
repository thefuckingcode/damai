package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i61;
import tb.ib2;
import tb.k21;
import tb.oi;
import tb.y31;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2 extends Lambda implements Function1<i61, ib2> {
    final /* synthetic */ y31 $attr;
    final /* synthetic */ ClassDescriptor $declaration;
    final /* synthetic */ ib2 $type;
    final /* synthetic */ RawSubstitution this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2(ClassDescriptor classDescriptor, RawSubstitution rawSubstitution, ib2 ib2, y31 y31) {
        super(1);
        this.$declaration = classDescriptor;
        this.this$0 = rawSubstitution;
        this.$type = ib2;
        this.$attr = y31;
    }

    @Nullable
    public final ib2 invoke(@NotNull i61 i61) {
        ClassDescriptor a;
        k21.i(i61, "kotlinTypeRefiner");
        ClassDescriptor classDescriptor = this.$declaration;
        if (!(classDescriptor instanceof ClassDescriptor)) {
            classDescriptor = null;
        }
        oi h = classDescriptor == null ? null : DescriptorUtilsKt.h(classDescriptor);
        if (h == null || (a = i61.a(h)) == null || k21.d(a, this.$declaration)) {
            return null;
        }
        return (ib2) this.this$0.k(this.$type, a, this.$attr).getFirst();
    }
}
