package com.youku.arch.v3.adapter;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000\"\b\b\u0001\u0010\u0004*\u00020\u0003H\n"}, d2 = {"Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "D", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "CONFIG", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class VBaseHolder$removeItem$1$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ D $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VBaseHolder$removeItem$1$1(D d) {
        super(0);
        this.$this_apply = d;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1451453556")) {
            ipChange.ipc$dispatch("-1451453556", new Object[]{this});
            return;
        }
        this.$this_apply.getComponent().removeItem((IItem<ItemValue>) this.$this_apply, true);
    }
}
