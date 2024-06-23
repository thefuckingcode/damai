package com.alibaba.pictures.bricks.component.scriptmurder;

import android.view.View;
import com.alient.onearch.adapter.component.banner.base.BaseBannerPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.view.IContract;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class CouponBannerPresenterExt extends BaseBannerPresenter {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private GenericItem<ItemValue> lastItem;
    @NotNull
    private String totalSize = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CouponBannerPresenterExt(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    public final void disPatch(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773968545")) {
            ipChange.ipc$dispatch("-1773968545", new Object[]{this, str});
            return;
        }
        k21.i(str, "msg");
        EventDispatcher eventDispatcher = ((GenericItem) getItem()).getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(str, null);
        }
    }

    @Nullable
    public final GenericItem<ItemValue> getLastItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-731743780")) {
            return this.lastItem;
        }
        return (GenericItem) ipChange.ipc$dispatch("-731743780", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerPresenter, com.alient.onearch.adapter.component.banner.base.BaseBannerContract.Presenter
    public void onPageChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2087078546")) {
            ipChange.ipc$dispatch("-2087078546", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onPageChanged(i);
        IContract.View view = getView();
        k21.g(view, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.CouponBannerViewExt");
        ((CouponBannerViewExt) view).updateImgLength(this.totalSize, String.valueOf(i + 1));
    }

    public final void setLastItem(@Nullable GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704599552")) {
            ipChange.ipc$dispatch("-1704599552", new Object[]{this, genericItem});
            return;
        }
        this.lastItem = genericItem;
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerPresenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        Node node;
        List<Node> children;
        Node node2;
        List<Node> children2;
        String valueOf;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1637185647")) {
            ipChange.ipc$dispatch("-1637185647", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init(genericItem);
        if (this.lastItem != genericItem) {
            this.lastItem = genericItem;
            IContainer<ModelValue> container = genericItem.getContainer();
            List<Node> list = null;
            ModelValue property = container != null ? container.getProperty() : null;
            k21.g(property, "null cannot be cast to non-null type com.youku.arch.v3.core.Node");
            List<Node> children3 = property.getChildren();
            if (children3 != null) {
                if (children3.isEmpty()) {
                    children3 = null;
                }
                if (children3 != null && (node = children3.get(0)) != null && (children = node.getChildren()) != null) {
                    if (children.isEmpty()) {
                        children = null;
                    }
                    if (children != null && (node2 = children.get(0)) != null && (children2 = node2.getChildren()) != null) {
                        if (!children2.isEmpty()) {
                            list = children2;
                        }
                        if (list != null && (valueOf = String.valueOf(list.size())) != null) {
                            this.totalSize = valueOf;
                            IContract.View view = getView();
                            k21.g(view, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.CouponBannerViewExt");
                            ((CouponBannerViewExt) view).updateImgLength(valueOf, "1");
                        }
                    }
                }
            }
        }
    }
}
