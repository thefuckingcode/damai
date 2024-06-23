package com.alibaba.pictures.bricks.component.home;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.bricks.bean.HeadAtmosphereBean;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class NewHeadAtmospherePresent extends AbsPresenter<GenericItem<ItemValue>, NewHeadAtmosphereModel, NewHeadAtmosphereView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewHeadAtmospherePresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    private final boolean isLargeScreenMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1090221822")) {
            return ((Boolean) ipChange.ipc$dispatch("1090221822", new Object[]{this})).booleanValue();
        } else if (getCurrentResponsiveLayoutState() == 0 || 1000 == getCurrentResponsiveLayoutState()) {
            return false;
        } else {
            return true;
        }
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1160891248")) {
            ipChange.ipc$dispatch("-1160891248", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        GenericFragment fragment = genericItem.getPageContext().getFragment();
        RecyclerView recyclerView = fragment != null ? fragment.getRecyclerView() : null;
        Activity activity = genericItem.getPageContext().getActivity();
        if (activity != null) {
            ((NewHeadAtmosphereView) getView()).bindView(recyclerView, isLargeScreenMode(), activity, genericItem.getPageContext().getEventBus(), (HeadAtmosphereBean) ((NewHeadAtmosphereModel) getModel()).getValue());
        }
    }
}
