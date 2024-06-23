package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import tb.es2;
import tb.k21;
import tb.og1;
import tb.w31;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1 extends Lambda implements Function1<es2, Boolean> {
    public static final SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1 INSTANCE = new SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1();

    SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1() {
        super(1);
    }

    public final Boolean invoke(es2 es2) {
        ClassifierDescriptor declarationDescriptor = es2.c().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return Boolean.FALSE;
        }
        og1 name = declarationDescriptor.getName();
        w31 w31 = w31.INSTANCE;
        return Boolean.valueOf(k21.d(name, w31.i().g()) && k21.d(DescriptorUtilsKt.e(declarationDescriptor), w31.i()));
    }
}
