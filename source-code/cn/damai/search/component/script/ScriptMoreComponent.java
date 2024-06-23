package cn.damai.search.component.script;

import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.ComponentTypeMapper;
import com.alient.onearch.adapter.loader.BasePageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.arch.v3.util.IdGenerator;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import kotlin.collections.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jl1;
import tb.k21;

/* compiled from: Taobao */
public final class ScriptMoreComponent extends GenericComponent<ComponentValue> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final IContext context;
    @NotNull
    private JSONObject noMoreNodeData = new JSONObject();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScriptMoreComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        Object obj;
        k21.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(node, Constants.CONFIG);
        this.context = iContext;
        ConcurrentMap<String, Object> concurrentMap = iContext.getConcurrentMap();
        if (concurrentMap != null && (obj = concurrentMap.get("keyword")) != null) {
            this.noMoreNodeData.put((Object) "content", (Object) (jl1.QUOTE + obj + "\"相关剧本杀只有这么多啦～"));
        }
    }

    private final Node createNoMoreNode(Node node, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-517961960")) {
            return (Node) ipChange.ipc$dispatch("-517961960", new Object[]{this, node, jSONObject});
        }
        Node node2 = new Node();
        node2.setLevel(2);
        node2.setType(3);
        node2.setId(IdGenerator.getId());
        node2.setData(jSONObject);
        node2.setParent(node);
        node2.setChildren(new ArrayList());
        List<Node> children = node2.getChildren();
        k21.f(children);
        Node node3 = new Node();
        node3.setLevel(3);
        node3.setData(this.noMoreNodeData);
        node3.setParent(node2);
        node3.setType(3);
        node3.setId(IdGenerator.getId());
        children.add(node3);
        return node2;
    }

    private final void replaceOrRemove(int i) {
        String string;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-372293184")) {
            ipChange.ipc$dispatch("-372293184", new Object[]{this, Integer.valueOf(i)});
        } else if (!getModule().getContainer().getModules().isEmpty()) {
            IModule iModule = (IModule) k.b0(getModule().getContainer().getModules());
            if (!iModule.getComponents().isEmpty()) {
                IComponent iComponent = (IComponent) k.b0(iModule.getComponents());
                JSONObject data = iComponent.getProperty().getData();
                if (data != null && (string = data.getString("componentId")) != null) {
                    if (i == ComponentTypeMapper.INSTANCE.convertComponentTypeToInt(string)) {
                        IContainer<ModelValue> pageContainer = getPageContext().getPageContainer();
                        BasePageLoader basePageLoader = null;
                        PageLoader pageLoader = pageContainer != null ? pageContainer.getPageLoader() : null;
                        if (pageLoader instanceof BasePageLoader) {
                            basePageLoader = (BasePageLoader) pageLoader;
                        }
                        if (basePageLoader != null) {
                            Node createNoMoreNode = createNoMoreNode(iModule.getProperty(), iComponent.getProperty().getData());
                            getPageContext().runOnLoaderThread(new ScriptMoreComponent$replaceOrRemove$1$1$1(iModule.createComponent(new Config<>(getPageContext(), createNoMoreNode.getType(), createNoMoreNode, 0, false, 24, null)), iModule));
                            return;
                        }
                        return;
                    }
                    getModule().removeComponent((IComponent<ComponentValue>) this, true);
                }
            }
        }
    }

    @NotNull
    public final IContext getContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-613338853")) {
            return this.context;
        }
        return (IContext) ipChange.ipc$dispatch("-613338853", new Object[]{this});
    }

    @Override // com.youku.arch.v3.event.EventHandler, com.youku.arch.v3.core.component.GenericComponent
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        JSONObject data;
        String string;
        int intValue;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "748332041")) {
            return ((Boolean) ipChange.ipc$dispatch("748332041", new Object[]{this, str, map})).booleanValue();
        }
        k21.i(str, "type");
        if (!(!k21.d(str, "script_all_loaded") || (data = getProperty().getData()) == null || (string = data.getString("componentId")) == null)) {
            Integer num = null;
            Object obj = map != null ? map.get("componentId") : null;
            if (obj instanceof Integer) {
                num = (Integer) obj;
            }
            if (num != null && (intValue = num.intValue()) == ComponentTypeMapper.INSTANCE.convertComponentTypeToInt(string)) {
                replaceOrRemove(intValue);
                return true;
            }
        }
        return super.onMessage(str, map);
    }
}
