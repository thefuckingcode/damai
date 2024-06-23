package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class HomeProjectItemViewWannaSee extends HomeProjectItemView {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeProjectItemViewWannaSee(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemView
    public boolean getPriceVisibility() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1793515032")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1793515032", new Object[]{this})).booleanValue();
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemView
    public boolean getSubTitleVisibility() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1972425659")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1972425659", new Object[]{this})).booleanValue();
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemView
    public boolean getWantSeeVisibility() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-935898418")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-935898418", new Object[]{this})).booleanValue();
    }
}
