package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "kotlin/reflect/jvm/internal/KTypeParameterImpl$upperBounds$2$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: KTypeParameterImpl.kt */
public final class KTypeParameterImpl$upperBounds$2$$special$$inlined$map$lambda$1 extends Lambda implements Function0 {
    final /* synthetic */ KTypeParameterImpl$upperBounds$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KTypeParameterImpl$upperBounds$2$$special$$inlined$map$lambda$1(KTypeParameterImpl$upperBounds$2 kTypeParameterImpl$upperBounds$2) {
        super(0);
        this.this$0 = kTypeParameterImpl$upperBounds$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Void invoke() {
        throw new NotImplementedError("An operation is not implemented: " + ("Java type is not yet supported for type parameters: " + this.this$0.this$0.getDescriptor()));
    }
}
