package com.alient.onearch.adapter.loader;

import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Node;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/youku/arch/v3/core/Node;", "invoke", "()Lcom/youku/arch/v3/core/Node;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class BasePageLoader$handleLoadMore$2 extends Lambda implements Function0<Node> {
    final /* synthetic */ IModule $lastModule;
    final /* synthetic */ Node $pageNode;
    final /* synthetic */ BasePageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasePageLoader$handleLoadMore$2(BasePageLoader basePageLoader, Node node, IModule iModule) {
        super(0);
        this.this$0 = basePageLoader;
        this.$pageNode = node;
        this.$lastModule = iModule;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Node invoke() {
        Node createNoMoreSectionNode = this.this$0.createNoMoreSectionNode(this.$pageNode, false);
        if (createNoMoreSectionNode == null) {
            return null;
        }
        try {
            IComponent<ComponentValue> createComponent = this.$lastModule.createComponent(new Config<>(BasePageLoader.access$getHost$p(this.this$0).getPageContext(), createNoMoreSectionNode.getType(), createNoMoreSectionNode, 0, false, 24, null));
            if (createComponent == null) {
                return createNoMoreSectionNode;
            }
            IModule iModule = this.$lastModule;
            iModule.addComponent(iModule.getComponents().size(), createComponent, true);
            return createNoMoreSectionNode;
        } catch (Exception e) {
            if (!AppInfoProviderProxy.isDebuggable()) {
                return createNoMoreSectionNode;
            }
            throw new RuntimeException(e);
        }
    }
}
