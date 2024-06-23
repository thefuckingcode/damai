package com.alibaba.pictures.bricks.component.scriptmurder;

import android.view.View;
import com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoContract;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class ShopInfoView extends AbsView<GenericItem<ItemValue>, ShopInfoModel, ShopInfoPresent> implements ShopInfoContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final ShopInfoViewHolder viewHolder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopInfoView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.viewHolder = new ShopInfoViewHolder(view);
    }

    @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoContract.View
    @NotNull
    public ShopInfoViewHolder getViewHolder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1054599083")) {
            return this.viewHolder;
        }
        return (ShopInfoViewHolder) ipChange.ipc$dispatch("1054599083", new Object[]{this});
    }
}
