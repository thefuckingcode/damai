package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.wt2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KParameterImpl$annotations$2 extends Lambda implements Function0<List<? extends Annotation>> {
    final /* synthetic */ KParameterImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KParameterImpl$annotations$2(KParameterImpl kParameterImpl) {
        super(0);
        this.this$0 = kParameterImpl;
    }

    /* Return type fixed from 'java.util.List<java.lang.annotation.Annotation>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends Annotation> invoke() {
        return wt2.d(this.this$0.c());
    }
}
