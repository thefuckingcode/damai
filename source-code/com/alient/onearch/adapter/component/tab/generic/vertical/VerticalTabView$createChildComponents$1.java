package com.alient.onearch.adapter.component.tab.generic.vertical;

import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class VerticalTabView$createChildComponents$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ List $componentNodes;
    final /* synthetic */ VerticalTabView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerticalTabView$createChildComponents$1(VerticalTabView verticalTabView, List list) {
        super(0);
        this.this$0 = verticalTabView;
        this.$componentNodes = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        int size = this.$componentNodes.size();
        for (int i = 0; i < size; i++) {
            Node node = (Node) this.$componentNodes.get(i);
            try {
                IComponent<ComponentValue> createComponent = this.this$0.getContainerItem().getComponent().getModule().createComponent(new Config<>(this.this$0.getContainerItem().getPageContext(), node.getType(), node, 0, false, 24, null));
                if (createComponent != null) {
                    this.this$0.childComponents.add(createComponent);
                }
            } catch (Exception e) {
                LogUtil.e(VerticalTabView.TAG, "createComponent exception " + e.getMessage());
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
