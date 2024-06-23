package com.alibaba.pictures.bricks.component.home.ball;

import android.view.View;
import com.alibaba.pictures.bricks.bean.HomeBallBean;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class HomeBallPresent extends AbsPresenter<GenericItem<ItemValue>, HomeBallModel, HomeBallView> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private GenericItem<ItemValue> oldItem;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeBallPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1461606268")) {
            ipChange.ipc$dispatch("1461606268", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        long currentTimeMillis = System.currentTimeMillis();
        super.init((IItem) genericItem);
        if (k21.d(this.oldItem, genericItem)) {
            LogUtil.e("bricks $" + HomeBallPresent.class.getName() + " old", new Object[0]);
            return;
        }
        this.oldItem = genericItem;
        ((HomeBallView) getView()).bindView((HomeBallBean) ((HomeBallModel) getModel()).getValue());
        LogUtil.e("bricks $" + HomeBallPresent.class.getName() + ' ' + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }
}
