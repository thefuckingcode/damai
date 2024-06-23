package com.alient.onearch.adapter.loader;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.decorate.ComponentDecorator;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.ViewTypeConfig;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.state.State;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;
import tb.wj2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=¢\u0006\u0004\b@\u0010AJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\r\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\"\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u001a\u0010 \u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\nH&J\u001c\u0010'\u001a\u00020&2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010(\u001a\u00020&H\u0016J\u0018\u0010+\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0014R\u001c\u0010/\u001a\u00020.8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001c\u00104\u001a\u0002038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u00109\u001a\u0002088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<¨\u0006B"}, d2 = {"Lcom/alient/onearch/adapter/loader/BasePageLoader;", "Lcom/youku/arch/v3/loader/PageLoader;", "Lcom/youku/arch/v3/core/Node;", "pageNode", "", "index", "Ltb/ur2;", "handleFirstLoad", "handleLoadMore", "", "", "", Constants.CONFIG, "load", "Lcom/alibaba/fastjson/JSONObject;", "response", "parseNode", "Lcom/alibaba/fastjson/JSONArray;", "layers", "parseLayers", "layerNode", "sections", "parseSections", "section", "parseSection", "sectionNode", "items", "limit", "parseItems", "item", "parseItem", "createHeaderSection", "createFooterSection", "Lcom/alient/onearch/adapter/decorate/ComponentDecorateItem;", "componentDecorateItemNode", "createDecorateSection", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "parseComponentType", "", "isInterceptCreateSection", "force", "createNoMoreSectionNode", "Lcom/youku/arch/v3/io/IResponse;", "handleLoadSuccess", "jsonObject", "findRootDataNode", "Lcom/alient/onearch/adapter/loader/ComponentTitleFilter;", "componentTitleFilter", "Lcom/alient/onearch/adapter/loader/ComponentTitleFilter;", "getComponentTitleFilter", "()Lcom/alient/onearch/adapter/loader/ComponentTitleFilter;", "Lcom/alient/onearch/adapter/loader/ComponentItemDisplayLimiter;", "componentItemDisplayLimiter", "Lcom/alient/onearch/adapter/loader/ComponentItemDisplayLimiter;", "getComponentItemDisplayLimiter", "()Lcom/alient/onearch/adapter/loader/ComponentItemDisplayLimiter;", "Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "componentDecorator", "Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "getComponentDecorator", "()Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "pageContainer", "<init>", "(Lcom/youku/arch/v3/IContainer;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public abstract class BasePageLoader extends PageLoader {
    @NotNull
    private final ComponentDecorator componentDecorator = new ComponentDecorator();
    @NotNull
    private final ComponentItemDisplayLimiter componentItemDisplayLimiter = new ComponentItemDisplayLimiter();
    @NotNull
    private final ComponentTitleFilter componentTitleFilter = new ComponentTitleFilter();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasePageLoader(@NotNull IContainer<ModelValue> iContainer) {
        super(iContainer);
        k21.i(iContainer, "pageContainer");
    }

    public static final /* synthetic */ IContainer access$getHost$p(BasePageLoader basePageLoader) {
        return (IContainer) basePageLoader.getHost();
    }

    /* access modifiers changed from: private */
    public final void handleFirstLoad(Node node, int i) {
        createNoMoreSectionNode(node, false);
        List<Node> children = node.getChildren();
        checkDuplicateModule(node, i);
        if (i == 1) {
            Bundle bundle = ((IContainer) getHost()).getPageContext().getBundle();
            if (bundle != null) {
                bundle.putSerializable("pageData", node);
            }
            ConcurrentMap<String, Object> concurrentMap = ((IContainer) getHost()).getPageContext().getConcurrentMap();
            if (concurrentMap != null) {
                concurrentMap.put("pageData", node);
            }
            EventBus eventBus = ((IContainer) getHost()).getPageContext().getEventBus();
            if (eventBus != null) {
                eventBus.post(new Event("CHANNEL_FIRST_PAGE_LOADED"));
            }
        }
        if (children == null || !(!children.isEmpty())) {
            ((IContainer) getHost()).clearModules();
            ((IContainer) getHost()).getPageContext().runOnUIThreadLocked(new BasePageLoader$handleFirstLoad$3(this));
            return;
        }
        tryCreateModules(node, i);
        IContext pageContext = ((IContainer) getHost()).getPageContext();
        pageContext.runOnUIThreadLocked(new BasePageLoader$handleFirstLoad$2$1(pageContext));
    }

    /* access modifiers changed from: private */
    public final void handleLoadMore(Node node, int i) {
        if (node.getChildren() != null) {
            List<Node> children = node.getChildren();
            k21.f(children);
            if (!children.isEmpty()) {
                List<Node> children2 = node.getChildren();
                k21.f(children2);
                List<Node> children3 = node.getChildren();
                k21.f(children3);
                Node node2 = children2.get(children3.size() - 1);
                List<Node> children4 = node2.getChildren();
                k21.f(children4);
                List<Node> children5 = node2.getChildren();
                k21.f(children5);
                Node node3 = children4.get(children5.size() - 1);
                IModule<ModuleValue> iModule = ((IContainer) getHost()).getModules().get(((IContainer) getHost()).getModules().size() - 1);
                IComponent<ComponentValue> iComponent = iModule.getComponents().get(iModule.getComponents().size() - 1);
                iComponent.getProperty().setMore(node3.getMore());
                int childCount = iComponent.getChildCount();
                List<Node> children6 = node3.getChildren();
                k21.f(children6);
                iComponent.createItems(children6);
                IContext pageContext = ((IContainer) getHost()).getPageContext();
                pageContext.runOnLoaderThreadLocked(new BasePageLoader$$special$$inlined$apply$lambda$1(pageContext, iComponent, childCount));
                ((IContainer) getHost()).getPageContext().runOnLoaderThread(new BasePageLoader$handleLoadMore$2(this, node, iModule));
                return;
            }
        }
        List<Node> children7 = node.getChildren();
        if (children7 != null) {
            Node node4 = new Node();
            node4.setChildren(new ArrayList());
            node4.setLevel(1);
            node4.setData(new JSONObject());
            node4.setId((long) UUID.randomUUID().hashCode());
            ur2 ur2 = ur2.INSTANCE;
            children7.add(node4);
        }
        createNoMoreSectionNode(node, true);
        tryCreateModules(node, i);
    }

    @NotNull
    public Node createDecorateSection(@NotNull Node node, @NotNull ComponentDecorateItem componentDecorateItem) {
        k21.i(node, "layerNode");
        k21.i(componentDecorateItem, "componentDecorateItemNode");
        Node node2 = new Node();
        node2.setLevel(2);
        node2.setType(componentDecorateItem.getComponentType());
        node2.setId(IdGenerator.getId());
        node2.setParent(node);
        node2.setChildren(new ArrayList());
        List<Node> children = node2.getChildren();
        k21.f(children);
        Node node3 = new Node();
        node3.setLevel(3);
        node3.setData(componentDecorateItem.getData());
        node3.setParent(node2);
        node3.setType(componentDecorateItem.getComponentType());
        node3.setId(IdGenerator.getId());
        ur2 ur2 = ur2.INSTANCE;
        children.add(node3);
        List<Node> children2 = node.getChildren();
        if (children2 != null) {
            children2.add(node2);
        }
        return node2;
    }

    public void createFooterSection(@NotNull Node node, @Nullable JSONObject jSONObject) {
        k21.i(node, "layerNode");
        List<Node> children = node.getChildren();
        if (children != null) {
            Node node2 = new Node();
            node2.setLevel(2);
            node2.setType(parseComponentType(OneArchConstants.SectionFooterType.NORMAL));
            node2.setId(IdGenerator.getId());
            node2.setParent(node);
            node2.setChildren(new ArrayList());
            List<Node> children2 = node2.getChildren();
            k21.f(children2);
            Node node3 = new Node();
            node3.setLevel(3);
            node3.setData(jSONObject);
            node3.setParent(node2);
            node3.setType(parseComponentType(OneArchConstants.SectionFooterType.NORMAL));
            node3.setId(IdGenerator.getId());
            ur2 ur2 = ur2.INSTANCE;
            children2.add(node3);
            children.add(node2);
        }
    }

    public void createHeaderSection(@NotNull Node node, @NotNull JSONObject jSONObject) {
        k21.i(node, "layerNode");
        k21.i(jSONObject, "section");
        List<Node> children = node.getChildren();
        if (children != null) {
            Node node2 = new Node();
            node2.setLevel(2);
            node2.setType(parseComponentType(OneArchConstants.SectionHeaderType.NORMAL));
            node2.setId(IdGenerator.getId());
            node2.setParent(node);
            node2.setChildren(new ArrayList());
            List<Node> children2 = node2.getChildren();
            k21.f(children2);
            Node node3 = new Node();
            node3.setLevel(3);
            node3.setData(new JSONObject());
            JSONObject data = node3.getData();
            k21.f(data);
            data.put((Object) "title", (Object) jSONObject.getJSONObject("style").getString("title"));
            node3.setParent(node2);
            node3.setType(parseComponentType(OneArchConstants.SectionHeaderType.NORMAL));
            node3.setId(IdGenerator.getId());
            ur2 ur2 = ur2.INSTANCE;
            children2.add(node3);
            ComponentDecorateItem componentDecorate = getComponentDecorator().getComponentDecorate(node2.getType(), ComponentDecorateItem.Indexer.Before);
            if (componentDecorate != null) {
                createDecorateSection(node, componentDecorate);
            }
            children.add(node2);
        }
    }

    @Nullable
    public Node createNoMoreSectionNode(@Nullable Node node, boolean z) {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.loader.PageLoader
    @NotNull
    public JSONObject findRootDataNode(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "jsonObject");
        if (jSONObject.containsKey("data")) {
            jSONObject = jSONObject.getJSONObject("data");
            k21.h(jSONObject, "jsonObject.getJSONObject(\"data\")");
        }
        return super.findRootDataNode(jSONObject);
    }

    @NotNull
    public ComponentDecorator getComponentDecorator() {
        return this.componentDecorator;
    }

    @NotNull
    public ComponentItemDisplayLimiter getComponentItemDisplayLimiter() {
        return this.componentItemDisplayLimiter;
    }

    @NotNull
    public ComponentTitleFilter getComponentTitleFilter() {
        return this.componentTitleFilter;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
    public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
        k21.i(iResponse, "response");
        IContext pageContext = ((IContainer) getHost()).getPageContext();
        pageContext.runOnLoaderThreadLocked(new BasePageLoader$handleLoadSuccess$$inlined$apply$lambda$1(pageContext, this, iResponse, i));
    }

    public boolean isInterceptCreateSection(@Nullable Node node, @Nullable JSONObject jSONObject) {
        return false;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public void load(@NotNull Map<String, ? extends Object> map) {
        GenericFragment fragment;
        k21.i(map, Constants.CONFIG);
        Integer num = (Integer) map.get("index");
        if (!(num == null || num.intValue() > 1 || (fragment = ((IContainer) getHost()).getPageContext().getFragment()) == null)) {
            RecyclerView recyclerView = fragment.getRecyclerView();
            RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter instanceof DelegateAdapter) {
                ((DelegateAdapter) adapter).clear();
                adapter.notifyDataSetChanged();
            }
            fragment.getPageStateManager().setState(State.LOADING);
        }
        super.load(map);
    }

    public abstract int parseComponentType(@NotNull String str);

    public void parseItem(@NotNull Node node, @NotNull JSONObject jSONObject) {
        ViewTypeConfig viewTypeConfig;
        HashMap<String, Object> params;
        Object obj;
        k21.i(node, "sectionNode");
        k21.i(jSONObject, "item");
        Node node2 = new Node();
        node2.setLevel(3);
        node2.setData(new JSONObject());
        node2.setChildren(new ArrayList());
        node2.setType(node.getType());
        node2.setId(node.getId());
        if (node2.getConfig() == null) {
            node2.setConfig(new JSONObject());
        }
        ViewTypeSupport viewTypeSupport = ((IContainer) getHost()).getPageContext().getViewTypeSupport();
        if (!(viewTypeSupport == null || (viewTypeConfig = viewTypeSupport.getViewTypeConfig(node2.getType())) == null || (params = viewTypeConfig.getParams()) == null || (obj = params.get("bean")) == null)) {
            JSONObject config = node2.getConfig();
            k21.f(config);
            config.put((Object) "bean", obj);
        }
        for (String str : jSONObject.keySet()) {
            JSONObject data = node2.getData();
            k21.f(data);
            data.put((Object) str, jSONObject.get(str));
        }
        node2.setParent(node);
        List<Node> children = node.getChildren();
        if (children != null) {
            children.add(node2);
        }
    }

    public void parseItems(@NotNull Node node, @Nullable JSONArray jSONArray, int i) {
        k21.i(node, "sectionNode");
        if (jSONArray != null) {
            for (int i2 = 0; i2 < i; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                k21.h(jSONObject, "getJSONObject(index)");
                parseItem(node, jSONObject);
            }
        }
    }

    public void parseLayers(@NotNull Node node, @NotNull JSONArray jSONArray) {
        k21.i(node, "pageNode");
        k21.i(jSONArray, "layers");
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.getJSONArray("sections") != null) {
                Node node2 = new Node();
                node2.setLevel(1);
                node2.setData(new JSONObject());
                node2.setId((long) jSONObject.getString("layerId").hashCode());
                node2.setChildren(new ArrayList());
                for (String str : jSONObject.keySet()) {
                    if (o.w(str, "sections", true)) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("sections");
                        k21.h(jSONArray2, "getJSONArray(\"sections\")");
                        parseSections(node2, jSONArray2);
                    } else {
                        JSONObject data = node2.getData();
                        k21.f(data);
                        data.put((Object) str, jSONObject.get(str));
                    }
                }
                List<Node> children = node2.getChildren();
                k21.f(children);
                if (!children.isEmpty()) {
                    node2.setParent(node);
                    List<Node> children2 = node.getChildren();
                    if (children2 != null) {
                        children2.add(node2);
                    }
                }
            }
        }
    }

    @Override // com.youku.arch.v3.loader.PageLoader
    @NotNull
    public Node parseNode(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "response");
        Node node = new Node();
        node.setLevel(0);
        node.setData(new JSONObject());
        node.setChildren(new ArrayList());
        for (String str : jSONObject.keySet()) {
            if (o.w(str, "layers", true)) {
                JSONArray jSONArray = jSONObject.getJSONArray("layers");
                k21.h(jSONArray, "response.getJSONArray(\"layers\")");
                parseLayers(node, jSONArray);
            } else {
                JSONObject data = node.getData();
                k21.f(data);
                data.put((Object) str, jSONObject.get(str));
            }
        }
        return node;
    }

    public void parseSection(@NotNull Node node, @NotNull JSONObject jSONObject) {
        ComponentDecorateItem componentDecorate;
        JSONArray jSONArray;
        k21.i(node, "layerNode");
        k21.i(jSONObject, "section");
        if (!isInterceptCreateSection(node, jSONObject)) {
            String string = jSONObject.getString("componentId");
            boolean z = false;
            if (!(string == null || string.length() == 0)) {
                String string2 = jSONObject.getString("sectionId");
                if (!(string2 == null || string2.length() == 0)) {
                    Node node2 = new Node();
                    node2.setLevel(2);
                    node2.setData(new JSONObject());
                    String string3 = jSONObject.getString("componentId");
                    k21.h(string3, "section.getString(\"componentId\")");
                    node2.setType(parseComponentType(string3));
                    node2.setId((long) jSONObject.getString("sectionId").hashCode());
                    node2.setChildren(new ArrayList());
                    if (jSONObject.containsKey("item") && jSONObject.getJSONObject("item") != null) {
                        for (String str : jSONObject.keySet()) {
                            if (o.w(str, "item", true)) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("item");
                                for (String str2 : jSONObject2.keySet()) {
                                    if (!(jSONObject2.containsKey("list") || jSONObject2.containsKey("result"))) {
                                        return;
                                    }
                                    if ((o.w(str2, "list", true)) || (o.w(str2, "result", true))) {
                                        if (jSONObject2.getJSONArray("list") == null) {
                                            jSONArray = jSONObject2.getJSONArray("result");
                                        } else {
                                            jSONArray = jSONObject2.getJSONArray("list");
                                        }
                                        if (jSONArray != null && !jSONArray.isEmpty()) {
                                            if (getComponentItemDisplayLimiter().hasComponentLimitSize(node2.getType())) {
                                                Integer geComponentLimitSize = getComponentItemDisplayLimiter().geComponentLimitSize(node2.getType());
                                                if (geComponentLimitSize != null) {
                                                    int intValue = geComponentLimitSize.intValue();
                                                    if (intValue <= 0) {
                                                        parseItems(node2, jSONArray, jSONArray.size());
                                                        if (jSONObject2.containsKey(wj2.HAS_NEXT) && jSONObject2.getBooleanValue(wj2.HAS_NEXT)) {
                                                            node2.setMore(true);
                                                        }
                                                    } else {
                                                        parseItems(node2, jSONArray, Math.min(intValue, jSONArray.size()));
                                                        if (intValue < jSONArray.size()) {
                                                            node2.setMore(true);
                                                            z = true;
                                                        }
                                                        if (jSONObject2.containsKey(wj2.HAS_NEXT) && jSONObject2.getBooleanValue(wj2.HAS_NEXT)) {
                                                            node2.setMore(true);
                                                        }
                                                    }
                                                    z = true;
                                                }
                                            } else {
                                                parseItems(node2, jSONArray, jSONArray.size());
                                                if (jSONObject2.containsKey(wj2.HAS_NEXT)) {
                                                    Boolean bool = jSONObject2.getBoolean(wj2.HAS_NEXT);
                                                    k21.h(bool, "sectionItemsData.getBool…                        )");
                                                    if (bool.booleanValue()) {
                                                        node2.setMore(true);
                                                    }
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        JSONObject data = node2.getData();
                                        if (data != null) {
                                            data.put((Object) str2, jSONObject2.get(str2));
                                        }
                                    }
                                }
                                continue;
                            } else {
                                JSONObject data2 = node2.getData();
                                if (data2 != null) {
                                    data2.put((Object) str, jSONObject.get(str));
                                }
                            }
                        }
                        ComponentDecorateItem componentDecorate2 = getComponentDecorator().getComponentDecorate(node2.getType(), ComponentDecorateItem.Indexer.Before);
                        if (componentDecorate2 != null) {
                            createDecorateSection(node, componentDecorate2);
                        }
                        if (jSONObject.containsKey("style") && !TextUtils.isEmpty(jSONObject.getJSONObject("style").getString("title")) && !getComponentTitleFilter().isFilterTitle(node2.getType())) {
                            createHeaderSection(node, jSONObject);
                        }
                        node2.setParent(node);
                        List<Node> children = node.getChildren();
                        if (children != null) {
                            children.add(node2);
                        }
                        if (z) {
                            createFooterSection(node, jSONObject);
                        }
                        if (!(node2.getMore() || (componentDecorate = getComponentDecorator().getComponentDecorate(node2.getType(), ComponentDecorateItem.Indexer.After)) == null)) {
                            createDecorateSection(node, componentDecorate);
                        }
                    }
                }
            }
        }
    }

    public void parseSections(@NotNull Node node, @NotNull JSONArray jSONArray) {
        k21.i(node, "layerNode");
        k21.i(jSONArray, "sections");
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            k21.h(jSONObject, "sections.getJSONObject(index)");
            parseSection(node, jSONObject);
        }
    }
}
