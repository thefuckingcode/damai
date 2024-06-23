package com.alibaba.pictures.bricks.component.home.horizonrawcontract;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.alibaba.pictures.bricks.component.home.horizonrawcontract.HorizontalRawContract;
import com.alient.onearch.adapter.component.raw.RawPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public class HorizontalRawPresenter extends RawPresenter<HorizontalRawModel, HorizontalRawView> implements HorizontalRawContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isInited;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalRawPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    public final boolean isInited() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1185527322")) {
            return this.isInited;
        }
        return ((Boolean) ipChange.ipc$dispatch("1185527322", new Object[]{this})).booleanValue();
    }

    public final void setInited(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1769020522")) {
            ipChange.ipc$dispatch("1769020522", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isInited = z;
    }

    @Override // com.alient.onearch.adapter.component.raw.RawPresenter
    public void showComponentsInView(@NotNull List<? extends VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-926415933")) {
            ipChange.ipc$dispatch("-926415933", new Object[]{this, list});
            return;
        }
        k21.i(list, "viewHolders");
        ((HorizontalRawView) getView()).showComponents(list);
    }

    @Override // com.alient.onearch.adapter.component.raw.RawPresenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        ComponentConfigBean.ComponentBean.LayoutBean layout;
        String pathConfig;
        ComponentConfigBean.ComponentBean componentBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-813442351")) {
            ipChange.ipc$dispatch("-813442351", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        ConfigManager configManager = genericItem.getPageContext().getConfigManager();
        HashMap<String, Object> hashMap = null;
        if (!(configManager == null || (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) == null)) {
            ComponentConfigManager instance = ComponentConfigManager.Companion.getInstance();
            Context context = ((HorizontalRawView) getView()).getHorizontalRaw().getContext();
            k21.h(context, "view.horizontalRaw.context");
            SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = instance.getComponentConfigs(context, pathConfig);
            if (componentConfigs != null) {
                componentBean = componentConfigs.get(genericItem.getType() > 32768 ? genericItem.getType() >> 16 : genericItem.getType());
            } else {
                componentBean = null;
            }
            setComponentConfig(componentBean);
        }
        HorizontalRawView horizontalRawView = (HorizontalRawView) getView();
        if (!this.isInited) {
            ComponentConfigBean.ComponentBean componentConfig = getComponentConfig();
            if (!(componentConfig == null || (layout = componentConfig.getLayout()) == null)) {
                hashMap = layout.getParams();
            }
            horizontalRawView.initHorizontalRawSettings(hashMap);
            this.isInited = true;
        }
        super.init(genericItem);
    }
}
