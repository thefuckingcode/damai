package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.a41;
import tb.no2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 extends Lambda implements Function1<Integer, a41> {
    final /* synthetic */ no2 $predefined;
    final /* synthetic */ Function1<Integer, a41> $qualifiers;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, tb.a41> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1(no2 no2, Function1<? super Integer, a41> function1) {
        super(1);
        this.$predefined = no2;
        this.$qualifiers = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ a41 invoke(Integer num) {
        return invoke(num.intValue());
    }

    @NotNull
    public final a41 invoke(int i) {
        a41 a41 = this.$predefined.a().get(Integer.valueOf(i));
        return a41 == null ? this.$qualifiers.invoke(Integer.valueOf(i)) : a41;
    }
}
