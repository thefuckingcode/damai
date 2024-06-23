package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
/* compiled from: signatureEnhancement.kt */
public final class SignatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1 extends Lambda implements Function1<Integer, JavaTypeQualifiers> {
    final /* synthetic */ TypeEnhancementInfo $predefined$inlined;
    final /* synthetic */ Function1 $qualifiers$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1(TypeEnhancementInfo typeEnhancementInfo, Function1 function1) {
        super(1);
        this.$predefined$inlined = typeEnhancementInfo;
        this.$qualifiers$inlined = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ JavaTypeQualifiers invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final JavaTypeQualifiers invoke(int i) {
        JavaTypeQualifiers javaTypeQualifiers = this.$predefined$inlined.getMap().get(Integer.valueOf(i));
        return javaTypeQualifiers != null ? javaTypeQualifiers : (JavaTypeQualifiers) this.$qualifiers$inlined.invoke(Integer.valueOf(i));
    }
}
