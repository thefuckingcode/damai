package com.alibaba.pictures.bricks.component.home.feed;

import android.view.View;
import com.alibaba.pictures.bricks.bean.CircleCard;
import com.alibaba.pictures.bricks.component.home.feed.CircleGroupContract;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class CircleGroupPresent extends AbsPresenter<GenericItem<ItemValue>, CircleGroupModel, CircleGroupView> implements CircleGroupContract.Present {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CircleGroupPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.CircleGroupContract.Present
    public void onClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1400001737")) {
            ipChange.ipc$dispatch("1400001737", new Object[]{this});
            return;
        }
        Action action = new Action();
        action.setActionType(1);
        Action itemAction = getItemAction();
        action.setActionUrl(itemAction != null ? itemAction.getActionUrl() : null);
        NavProviderProxy.getProxy().toUri(((GenericItem) getItem()).getPageContext().getActivity(), action);
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348730264")) {
            ipChange.ipc$dispatch("-1348730264", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        Object value = ((CircleGroupModel) getModel()).getValue();
        k21.h(value, "model.value");
        ((CircleGroupView) getView()).bindView((CircleCard) value);
    }
}
