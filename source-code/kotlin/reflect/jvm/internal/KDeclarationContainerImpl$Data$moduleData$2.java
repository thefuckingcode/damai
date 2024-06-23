package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import tb.f22;
import tb.ze1;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ltb/f22;", "kotlin.jvm.PlatformType", "invoke", "()Ltb/f22;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KDeclarationContainerImpl$Data$moduleData$2 extends Lambda implements Function0<f22> {
    final /* synthetic */ KDeclarationContainerImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KDeclarationContainerImpl$Data$moduleData$2(KDeclarationContainerImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // kotlin.jvm.functions.Function0
    public final f22 invoke() {
        return ze1.a(KDeclarationContainerImpl.this.getJClass());
    }
}
