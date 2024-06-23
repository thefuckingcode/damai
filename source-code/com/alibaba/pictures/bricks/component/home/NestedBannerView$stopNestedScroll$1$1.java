package com.alibaba.pictures.bricks.component.home;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class NestedBannerView$stopNestedScroll$1$1 extends Lambda implements Function1<Boolean, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ boolean $doExpand;
    final /* synthetic */ NestedBannerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NestedBannerView$stopNestedScroll$1$1(boolean z, NestedBannerView nestedBannerView) {
        super(1);
        this.$doExpand = z;
        this.this$0 = nestedBannerView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return ur2.INSTANCE;
    }

    public final void invoke(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1365790261")) {
            ipChange.ipc$dispatch("1365790261", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (this.$doExpand) {
            if (!(this.this$0.isInSuperFrameState)) {
                this.this$0.showBannerView(true);
            }
        } else if (this.this$0.isInSuperFrameState) {
            this.this$0.showBannerView(false);
        }
        this.this$0.mBanner.startAnimation();
    }
}
