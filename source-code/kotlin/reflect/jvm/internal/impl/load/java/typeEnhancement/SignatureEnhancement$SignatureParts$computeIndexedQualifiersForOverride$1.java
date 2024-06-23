package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.a41;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1 extends Lambda implements Function1<Integer, a41> {
    final /* synthetic */ a41[] $computedResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1(a41[] a41Arr) {
        super(1);
        this.$computedResult = a41Arr;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ a41 invoke(Integer num) {
        return invoke(num.intValue());
    }

    @NotNull
    public final a41 invoke(int i) {
        a41[] a41Arr = this.$computedResult;
        return (i < 0 || i > ArraysKt___ArraysKt.x(a41Arr)) ? a41.Companion.a() : a41Arr[i];
    }
}
