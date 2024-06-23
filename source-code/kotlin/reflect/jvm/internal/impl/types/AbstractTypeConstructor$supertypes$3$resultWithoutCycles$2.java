package kotlin.reflect.jvm.internal.impl.types;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2 extends Lambda implements Function1<g61, ur2> {
    final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.this$0 = abstractTypeConstructor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(g61 g61) {
        invoke(g61);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull g61 g61) {
        k21.i(g61, AdvanceSetting.NETWORK_TYPE);
        this.this$0.k(g61);
    }
}
