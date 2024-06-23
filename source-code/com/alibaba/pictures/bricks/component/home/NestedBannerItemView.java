package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class NestedBannerItemView extends AbsView<GenericItem<ItemValue>, NestedBannerItemModel, NestedBannerItemPresent> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedBannerItemView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1243412116")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("-1243412116", new Object[]{this});
    }
}
