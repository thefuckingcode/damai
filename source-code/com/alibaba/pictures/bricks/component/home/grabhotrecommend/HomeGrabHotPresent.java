package com.alibaba.pictures.bricks.component.home.grabhotrecommend;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.bean.HomeGrabHotBean;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class HomeGrabHotPresent extends AbsPresenter<GenericItem<ItemValue>, HomeGrabHotModel, HomeCardGrabView> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private GenericItem<ItemValue> oldItem;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeGrabHotPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        ComponentValue property;
        JSONObject data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-217964392")) {
            ipChange.ipc$dispatch("-217964392", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        long currentTimeMillis = System.currentTimeMillis();
        super.init((IItem) genericItem);
        if (k21.d(this.oldItem, genericItem)) {
            LogUtil.e("bricks $" + HomeGrabHotPresent.class.getName() + " old", new Object[0]);
            return;
        }
        this.oldItem = genericItem;
        IComponent<ComponentValue> component = genericItem.getComponent();
        int intValue = (component == null || (property = component.getProperty()) == null || (data = property.getData()) == null) ? 0 : data.getIntValue("childWidth");
        ((HomeCardGrabView) getView()).bindView((HomeGrabHotBean) ((HomeGrabHotModel) getModel()).getValue(), intValue);
        LogUtil.e("bricks childWidth = " + intValue, new Object[0]);
        LogUtil.e("bricks $" + HomeGrabHotPresent.class.getName() + ' ' + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }
}
