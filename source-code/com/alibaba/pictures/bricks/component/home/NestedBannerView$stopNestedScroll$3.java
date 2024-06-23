package com.alibaba.pictures.bricks.component.home;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class NestedBannerView$stopNestedScroll$3 extends Lambda implements Function1<Boolean, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ NestedBannerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NestedBannerView$stopNestedScroll$3(NestedBannerView nestedBannerView) {
        super(1);
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
        if (AndroidInstantRuntime.support(ipChange, "277744800")) {
            ipChange.ipc$dispatch("277744800", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (this.this$0.isInSuperFrameState) {
            this.this$0.showBannerView(false);
        }
        this.this$0.mBanner.startAnimation();
    }
}
