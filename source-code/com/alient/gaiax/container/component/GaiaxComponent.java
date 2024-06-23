package com.alient.gaiax.container.component;

import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.parser.component.BasicComponentParser;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.ArchExceptionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016R\u001d\u0010\u000f\u001a\u00020\n8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/alient/gaiax/container/component/GaiaxComponent;", "Lcom/youku/arch/v3/core/component/GenericComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "Lcom/youku/arch/v3/core/Node;", "data", "Ltb/ur2;", "initProperties", "", "nodes", "createItems", "Lcom/alient/onearch/adapter/parser/component/BasicComponentParser;", "componentParser$delegate", "Lkotlin/Lazy;", "getComponentParser", "()Lcom/alient/onearch/adapter/parser/component/BasicComponentParser;", "componentParser", "Lcom/youku/arch/v3/core/IContext;", Constants.PAGE_CONTEXT, "node", "<init>", "(Lcom/youku/arch/v3/core/IContext;Lcom/youku/arch/v3/core/Node;)V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaxComponent extends GenericComponent<ComponentValue> {
    @NotNull
    private final Lazy componentParser$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, GaiaxComponent$componentParser$2.INSTANCE);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GaiaxComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        k21.i(iContext, Constants.PAGE_CONTEXT);
        k21.i(node, "node");
    }

    private final BasicComponentParser getComponentParser() {
        return (BasicComponentParser) this.componentParser$delegate.getValue();
    }

    @Override // com.youku.arch.v3.IComponent, com.youku.arch.v3.core.component.GenericComponent
    public void createItems(@NotNull List<Node> list) {
        k21.i(list, "nodes");
        getPageContext().runOnLoaderThreadLocked(new GaiaxComponent$createItems$1(this));
    }

    @Override // com.youku.arch.v3.DomainObject, com.youku.arch.v3.core.component.GenericComponent
    public void initProperties(@NotNull Node node) {
        k21.i(node, "data");
        setProperty(getComponentParser().parseElement(node));
        setNode(node);
        setType(node.getType());
        List<Node> children = getProperty().getChildren();
        if (!(children == null || children.isEmpty())) {
            children = null;
        }
        if (children != null) {
            ComponentValue property = getProperty();
            HashMap hashMap = new HashMap();
            hashMap.put("id", Long.valueOf(property.getId()));
            hashMap.put("type", Integer.valueOf(property.getType()));
            JSONObject data = property.getData();
            Objects.requireNonNull(data, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
            hashMap.put("data", data);
            JSONObject rawJson = property.getRawJson();
            Objects.requireNonNull(rawJson, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
            hashMap.put("rawJson", rawJson);
            EventDispatcher eventDispatcher = getPageContext().getEventDispatcher();
            if (eventDispatcher != null) {
                eventDispatcher.dispatchEvent(ArchExceptionEvent.COMPONENT_CHILDREN_EMPTY, hashMap);
            }
        }
    }
}
