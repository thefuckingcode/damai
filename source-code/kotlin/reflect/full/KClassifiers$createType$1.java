package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClassifier;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: KClassifiers.kt */
final class KClassifiers$createType$1 extends Lambda implements Function0 {
    final /* synthetic */ KClassifier $this_createType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassifiers$createType$1(KClassifier kClassifier) {
        super(0);
        this.$this_createType = kClassifier;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Void invoke() {
        throw new NotImplementedError("An operation is not implemented: " + ("Java type is not yet supported for types created with createType (classifier = " + this.$this_createType + ')'));
    }
}
