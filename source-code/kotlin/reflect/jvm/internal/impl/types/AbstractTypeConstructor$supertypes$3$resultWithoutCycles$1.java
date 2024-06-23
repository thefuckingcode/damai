package kotlin.reflect.jvm.internal.impl.types;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1 extends Lambda implements Function1<TypeConstructor, Iterable<? extends g61>> {
    final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.this$0 = abstractTypeConstructor;
    }

    @NotNull
    public final Iterable<g61> invoke(@NotNull TypeConstructor typeConstructor) {
        k21.i(typeConstructor, AdvanceSetting.NETWORK_TYPE);
        return this.this$0.b(typeConstructor, false);
    }
}
