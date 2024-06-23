package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class NestedBannerItemPresent extends AbsPresenter<GenericItem<ItemValue>, NestedBannerItemModel, NestedBannerItemView> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedBannerItemPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }
}
