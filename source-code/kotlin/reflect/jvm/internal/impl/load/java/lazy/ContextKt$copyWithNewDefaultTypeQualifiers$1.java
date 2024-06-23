package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.x61;

/* compiled from: Taobao */
final class ContextKt$copyWithNewDefaultTypeQualifiers$1 extends Lambda implements Function0<b41> {
    final /* synthetic */ Annotations $additionalAnnotations;
    final /* synthetic */ x61 $this_copyWithNewDefaultTypeQualifiers;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextKt$copyWithNewDefaultTypeQualifiers$1(x61 x61, Annotations annotations) {
        super(0);
        this.$this_copyWithNewDefaultTypeQualifiers = x61;
        this.$additionalAnnotations = annotations;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final b41 invoke() {
        return ContextKt.g(this.$this_copyWithNewDefaultTypeQualifiers, this.$additionalAnnotations);
    }
}
