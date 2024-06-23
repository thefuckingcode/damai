package com.youku.arch.v3.core.component;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ComponentValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GenericComponent$createItems$2 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ List<Node> $nodes;
    final /* synthetic */ GenericComponent<VALUE> this$0;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends com.youku.arch.v3.core.Node> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenericComponent$createItems$2(List<? extends Node> list, GenericComponent<VALUE> genericComponent) {
        super(0);
        this.$nodes = list;
        this.this$0 = genericComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-195072370")) {
            ipChange.ipc$dispatch("-195072370", new Object[]{this});
            return;
        }
        for (Node node : this.$nodes) {
            try {
                GenericComponent<VALUE> genericComponent = this.this$0;
                IItem<ItemValue> createItem = genericComponent.createItem(new Config<>(genericComponent.getPageContext(), node.getType(), node, 0, false, 24, null));
                if (createItem != null) {
                    GenericComponent<VALUE> genericComponent2 = this.this$0;
                    genericComponent2.addItem(genericComponent2.childItems.size(), createItem, false);
                }
            } catch (Exception e) {
                LogUtil.e("OneArch.GenericComponent", "create item error " + node.getType() + ((Object) e.getMessage()));
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
            }
        }
    }
}
