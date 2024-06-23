package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import tb.i61;
import tb.ib2;

/* compiled from: Taobao */
final class AbstractTypeAliasDescriptor$computeDefaultType$1 extends Lambda implements Function1<i61, ib2> {
    final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeAliasDescriptor$computeDefaultType$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        super(1);
        this.this$0 = abstractTypeAliasDescriptor;
    }

    public final ib2 invoke(i61 i61) {
        ClassifierDescriptor e = i61.e(this.this$0);
        if (e == null) {
            return null;
        }
        return e.getDefaultType();
    }
}
