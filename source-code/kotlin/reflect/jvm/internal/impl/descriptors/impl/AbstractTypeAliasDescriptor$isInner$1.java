package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import tb.es2;
import tb.h61;
import tb.k21;

/* compiled from: Taobao */
final class AbstractTypeAliasDescriptor$isInner$1 extends Lambda implements Function1<es2, Boolean> {
    final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeAliasDescriptor$isInner$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        super(1);
        this.this$0 = abstractTypeAliasDescriptor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        if (((r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) && !tb.k21.d(((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5).getContainingDeclaration(), r0)) != false) goto L_0x002e;
     */
    public final Boolean invoke(es2 es2) {
        k21.h(es2, "type");
        boolean z = true;
        if (!h61.a(es2)) {
            AbstractTypeAliasDescriptor abstractTypeAliasDescriptor = this.this$0;
            ClassifierDescriptor declarationDescriptor = es2.c().getDeclarationDescriptor();
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
