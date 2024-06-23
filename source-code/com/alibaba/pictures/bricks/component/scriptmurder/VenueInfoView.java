package com.alibaba.pictures.bricks.component.scriptmurder;

import android.view.View;
import com.alibaba.pictures.bricks.component.scriptmurder.VenueInfoContract;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class VenueInfoView extends AbsView<GenericItem<ItemValue>, VenueInfoModel, VenueInfoPresent> implements VenueInfoContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final VenueInfoViewHolder viewHolder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VenueInfoView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.viewHolder = new VenueInfoViewHolder(view);
    }

    @Override // com.alibaba.pictures.bricks.component.scriptmurder.VenueInfoContract.View
    @NotNull
    public VenueInfoViewHolder getViewHolder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "120226443")) {
            return this.viewHolder;
        }
        return (VenueInfoViewHolder) ipChange.ipc$dispatch("120226443", new Object[]{this});
    }
}
