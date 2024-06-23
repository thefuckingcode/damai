package kotlin.reflect.jvm.internal.impl.resolve;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tb.bc2;
import tb.k21;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1 extends Lambda implements Function1<H, ur2> {
    final /* synthetic */ bc2<H> $conflictedHandles;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(bc2<H> bc2) {
        super(1);
        this.$conflictedHandles = bc2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final void invoke(H h) {
        bc2<H> bc2 = this.$conflictedHandles;
        k21.h(h, AdvanceSetting.NETWORK_TYPE);
        bc2.add(h);
    }
}
