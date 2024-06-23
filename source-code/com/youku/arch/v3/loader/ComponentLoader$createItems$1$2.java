package com.youku.arch.v3.loader;

import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ComponentLoader$createItems$1$2 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ int $oldChildCount;
    final /* synthetic */ IComponent<ComponentValue> $this_apply;
    final /* synthetic */ ComponentLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComponentLoader$createItems$1$2(IComponent<ComponentValue> iComponent, ComponentLoader componentLoader, int i, int i2) {
        super(0);
        this.$this_apply = iComponent;
        this.this$0 = componentLoader;
        this.$index = i;
        this.$oldChildCount = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1375278457")) {
            ipChange.ipc$dispatch("1375278457", new Object[]{this});
            return;
        }
        try {
            List<Node> children = this.$this_apply.getProperty().getChildren();
            if (children != null) {
                IComponent<ComponentValue> iComponent = this.$this_apply;
                ComponentLoader componentLoader = this.this$0;
                int i = 0;
                for (T t : children) {
                    int i2 = i + 1;
                    if (i < 0) {
                        m.p();
                    }
                    T t2 = t;
                    IItem<ItemValue> createItem = iComponent.createItem(new Config<>(iComponent.getPageContext(), t2.getType(), t2, 0, false, 24, null));
                    if (createItem != null) {
                        ((GenericComponent) componentLoader.getHost()).childItems.add(createItem);
                        createItem.setIndex(i);
                        createItem.onAdd();
                        ((GenericComponent) componentLoader.getHost()).getChildIndexUpdater().onChildAdded(createItem);
                    }
                    i = i2;
                }
            }
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = this.$this_apply.getAdapter();
            if (adapter != null) {
                adapter.dataCount = this.$this_apply.getChildCount();
            }
            GenericFragment fragment = this.$this_apply.getPageContext().getFragment();
            if (fragment != null) {
                RecyclerView recyclerView = fragment.getRecyclerView();
                if (recyclerView != null) {
                    int i3 = this.$index;
                    IComponent<ComponentValue> iComponent2 = this.$this_apply;
                    int i4 = this.$oldChildCount;
                    if (!recyclerView.isComputingLayout()) {
                        if (i3 == 1) {
                            IContainer<ModelValue> pageContainer = iComponent2.getPageContext().getPageContainer();
                            if (pageContainer != null) {
                                pageContainer.updateContentAdapter();
                            }
                            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter2 = iComponent2.getAdapter();
                            if (adapter2 != null) {
                                adapter2.notifyItemRangeChanged(0, iComponent2.getChildCount());
                            }
                        } else {
                            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter3 = iComponent2.getAdapter();
                            if (adapter3 != null) {
                                adapter3.notifyItemRangeInserted(i4, iComponent2.getChildCount() - i4);
                            }
                        }
                    }
                }
            }
            this.this$0.setLoadingPage(this.$index);
            this.this$0.setLoadingViewState();
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw new RuntimeException(e);
            }
        }
    }
}
