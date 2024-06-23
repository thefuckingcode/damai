package com.alibaba.pictures.bricks.component.home.grabhotrecommend;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class HomeCardHotView extends HomeCardGrabView {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeCardHotView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
    }

    @Override // com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeCardGrabView
    public boolean isGrabHotProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-352502360")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-352502360", new Object[]{this})).booleanValue();
    }
}
