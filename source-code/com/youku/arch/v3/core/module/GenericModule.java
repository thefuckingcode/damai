package com.youku.arch.v3.core.module;

import android.app.Activity;
import android.taobao.windvane.connect.api.ApiResponse;
import android.util.SparseArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.ChildState;
import com.youku.arch.v3.GenericFactory;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ChildIndexUpdater;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.Coordinate;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.OnChildAttachStateChangeListener;
import com.youku.arch.v3.core.parser.DefaultModuleParser;
import com.youku.arch.v3.core.parser.IParser;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.PagingLoader;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.util.PerformanceLogUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ur2;
import tb.wj2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u0001*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002\u0001B\u0019\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010B\u001a\u00020\u0005¢\u0006\u0006\b\u0001\u0010\u0001J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\u0007J2\u0010\u001c\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u001b0\u001a0\u00170\u0016H\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0004H\u0016J\u0016\u0010 \u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050!H\u0016J\b\u0010#\u001a\u00020\u0007H\u0014J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014J\u001e\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J&\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010)\u001a\u00020\u0012H\u0016J(\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0016\u0010,\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u001e\u0010,\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010)\u001a\u00020\u0012H\u0016J \u0010,\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u001c\u0010.\u001a\u00020\u00072\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0004H\u0016J\u001e\u0010/\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u0010\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u00020\u0007H\u0016J\b\u00104\u001a\u00020\u0007H\u0016J\b\u00105\u001a\u00020\u0007H\u0016J&\u00108\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u000e2\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0016J\u0016\u0010:\u001a\u00020\u00122\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\"\u0010<\u001a\u00020;8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u00106\u001a\u00020%8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b6\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001a\u00028\u00008\u0016@\u0016X.¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR(\u0010U\u001a\b\u0012\u0004\u0012\u00020T0S8\u0016@\u0016X.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR.\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000[8\u0016@\u0016X.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010c\u001a\u0004\u0018\u00010b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR6\u0010j\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\u0004\u0012\u00020\u0005\u0018\u00010i8V@\u0016X\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00168\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b-\u0010pR\"\u0010q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00048\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bq\u0010pR@\u0010r\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u001b0\u001a0\u00170\u00168\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\br\u0010pR@\u0010s\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u001b0\u001a0\u00170\u00168\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bs\u0010pR\"\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\"\u0010&\u001a\u00020%8V@\u0016X\u000e¢\u0006\u0012\n\u0004\b&\u0010H\u001a\u0004\bw\u0010J\"\u0004\bx\u0010LR\"\u0010z\u001a\u00020y8\u0016@\u0016X.¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R\u001f\u0010\u0001\u001a\u00020%8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010H\u001a\u0005\b\u0001\u0010JR,\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0016@\u0016X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R,\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0016@\u0016X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018V@\u0016X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/youku/arch/v3/core/module/GenericModule;", "Lcom/youku/arch/v3/core/ModuleValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/IModule;", "", "Lcom/youku/arch/v3/core/Node;", "nodes", "Ltb/ur2;", "createComponentsImpl", "Lcom/youku/arch/v3/io/IRequest;", "request", "Lcom/youku/arch/v3/io/Callback;", WXBridgeManager.METHOD_CALLBACK, "", "", "", Constants.CONFIG, "createRequest", "", "loadMore", wj2.HAS_NEXT, "reload", "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "getAdapters", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "getComponents", "createComponents", "Lcom/youku/arch/v3/core/Config;", "createComponent", "handleTitleComponent", "washData", "", "index", "component", "addComponent", "notifyUiUpdate", "Lcom/youku/arch/v3/core/OnChildAttachStateChangeListener;", "listener", "removeComponent", com.youku.arch.v3.data.Constants.COMPONENT, "updateComponents", "replaceComponent", "data", "initProperties", "updateChildIndex", "clearComponents", "onAdd", "onRemove", "type", "params", "onMessage", "target", "diff", "Lcom/youku/arch/v3/core/IContext;", com.youku.arch.v3.data.Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/IContext;", "getPageContext", "()Lcom/youku/arch/v3/core/IContext;", "setPageContext", "(Lcom/youku/arch/v3/core/IContext;)V", "node", "Lcom/youku/arch/v3/core/Node;", "getNode", "()Lcom/youku/arch/v3/core/Node;", "setNode", "(Lcom/youku/arch/v3/core/Node;)V", "I", "getType", "()I", "setType", "(I)V", "property", "Lcom/youku/arch/v3/core/ModuleValue;", "getProperty", "()Lcom/youku/arch/v3/core/ModuleValue;", "setProperty", "(Lcom/youku/arch/v3/core/ModuleValue;)V", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "container", "Lcom/youku/arch/v3/IContainer;", "getContainer", "()Lcom/youku/arch/v3/IContainer;", "setContainer", "(Lcom/youku/arch/v3/IContainer;)V", "Lcom/youku/arch/v3/core/parser/IParser;", "parser", "Lcom/youku/arch/v3/core/parser/IParser;", "getParser", "()Lcom/youku/arch/v3/core/parser/IParser;", "setParser", "(Lcom/youku/arch/v3/core/parser/IParser;)V", "Lcom/youku/arch/v3/loader/PagingLoader;", "moduleLoader", "Lcom/youku/arch/v3/loader/PagingLoader;", "getModuleLoader", "()Lcom/youku/arch/v3/loader/PagingLoader;", "setModuleLoader", "(Lcom/youku/arch/v3/loader/PagingLoader;)V", "Lcom/youku/arch/v3/GenericFactory;", "componentFactory", "Lcom/youku/arch/v3/GenericFactory;", "getComponentFactory", "()Lcom/youku/arch/v3/GenericFactory;", "setComponentFactory", "(Lcom/youku/arch/v3/GenericFactory;)V", "Ljava/util/List;", "unmodifiableComponents", "adapters", "unmodifiableAdapters", "Lcom/youku/arch/v3/core/ChildIndexUpdater;", "childIndexUpdater", "Lcom/youku/arch/v3/core/ChildIndexUpdater;", "getIndex", "setIndex", "Lcom/youku/arch/v3/ChildState;", "childState", "Lcom/youku/arch/v3/ChildState;", "getChildState", "()Lcom/youku/arch/v3/ChildState;", "setChildState", "(Lcom/youku/arch/v3/ChildState;)V", "childCount", "getChildCount", "Lcom/youku/arch/v3/io/RequestBuilder;", "requestBuilder", "Lcom/youku/arch/v3/io/RequestBuilder;", "getRequestBuilder", "()Lcom/youku/arch/v3/io/RequestBuilder;", "setRequestBuilder", "(Lcom/youku/arch/v3/io/RequestBuilder;)V", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", "Lcom/youku/arch/v3/event/EventHandler;", "getEventHandler", "()Lcom/youku/arch/v3/event/EventHandler;", "setEventHandler", "(Lcom/youku/arch/v3/event/EventHandler;)V", "Lcom/youku/arch/v3/core/Coordinate;", "getCoordinate", "()Lcom/youku/arch/v3/core/Coordinate;", "coordinate", "<init>", "(Lcom/youku/arch/v3/core/IContext;Lcom/youku/arch/v3/core/Node;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class GenericModule<VALUE extends ModuleValue> implements IModule<VALUE> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.GenericModule";
    @JvmField
    @NotNull
    public final List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> adapters;
    private final int childCount;
    @NotNull
    private final ChildIndexUpdater<IComponent<ComponentValue>> childIndexUpdater;
    public ChildState childState;
    @Nullable
    private GenericFactory<IComponent<ComponentValue>, Node> componentFactory;
    @JvmField
    @NotNull
    public final List<IComponent<ComponentValue>> components;
    public IContainer<ModelValue> container;
    @Nullable
    private EventHandler eventHandler;
    private volatile int index;
    @Nullable
    private PagingLoader moduleLoader;
    @NotNull
    private Node node;
    @NotNull
    private IContext pageContext;
    public IParser<Node, VALUE> parser;
    public VALUE property;
    @Nullable
    private RequestBuilder requestBuilder;
    private int type = -1;
    @JvmField
    @NotNull
    public final List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> unmodifiableAdapters;
    @JvmField
    @NotNull
    public final List<IComponent<ComponentValue>> unmodifiableComponents;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/core/module/GenericModule$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    public GenericModule(@NotNull IContext iContext, @NotNull Node node2) {
        k21.i(iContext, com.youku.arch.v3.data.Constants.PAGE_CONTEXT);
        k21.i(node2, "node");
        this.pageContext = iContext;
        this.node = node2;
        ArrayList arrayList = new ArrayList();
        this.components = arrayList;
        List<IComponent<ComponentValue>> unmodifiableList = Collections.unmodifiableList(arrayList);
        k21.h(unmodifiableList, "unmodifiableList(components)");
        this.unmodifiableComponents = unmodifiableList;
        ArrayList arrayList2 = new ArrayList();
        this.adapters = arrayList2;
        List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> unmodifiableList2 = Collections.unmodifiableList(arrayList2);
        k21.h(unmodifiableList2, "unmodifiableList(adapters)");
        this.unmodifiableAdapters = unmodifiableList2;
        this.childIndexUpdater = new ChildIndexUpdater<>();
        this.index = -1;
        this.childCount = arrayList.size();
    }

    private final void createComponentsImpl(List<? extends Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "166414143")) {
            ipChange.ipc$dispatch("166414143", new Object[]{this, list});
            return;
        }
        PerformanceLogUtil performanceLogUtil = PerformanceLogUtil.INSTANCE;
        performanceLogUtil.markStartPoint(getClass().getSimpleName() + ' ' + this + " createComponents");
        handleTitleComponent();
        int size = list.size() + -1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Node node2 = (Node) list.get(i);
                try {
                    IComponent<ComponentValue> createComponent = createComponent(new Config<>(getPageContext(), node2.getType(), node2, 0, false, 24, null));
                    if (createComponent != null) {
                        addComponent(this.components.size(), createComponent, false);
                    }
                } catch (Exception e) {
                    LogUtil.e(TAG, k21.r("createComponent exception ", e.getMessage()));
                    if (AppInfoProviderProxy.isDebuggable()) {
                        throw new RuntimeException(e);
                    }
                }
                if (i2 > size) {
                    break;
                }
                i = i2;
            }
        }
        PerformanceLogUtil performanceLogUtil2 = PerformanceLogUtil.INSTANCE;
        performanceLogUtil2.markEndPoint(getClass().getSimpleName() + ' ' + this + " createComponents");
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void addComponent(int i, @NotNull IComponent<ComponentValue> iComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891235443")) {
            ipChange.ipc$dispatch("-891235443", new Object[]{this, Integer.valueOf(i), iComponent});
            return;
        }
        k21.i(iComponent, "component");
        addComponent(i, iComponent, (OnChildAttachStateChangeListener) null);
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void clearComponents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "676831719")) {
            ipChange.ipc$dispatch("676831719", new Object[]{this});
            return;
        }
        getPageContext().runOnLoaderThreadLocked(new GenericModule$clearComponents$1(this));
    }

    @Override // com.youku.arch.v3.IComponentManager
    @Nullable
    public IComponent<ComponentValue> createComponent(@NotNull Config<Node> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1433942193")) {
            return (IComponent) ipChange.ipc$dispatch("1433942193", new Object[]{this, config});
        }
        k21.i(config, Constants.CONFIG);
        GenericFactory<IComponent<ComponentValue>, Node> componentFactory2 = getComponentFactory();
        IComponent<ComponentValue> create = componentFactory2 == null ? null : componentFactory2.create(config);
        if (create != null) {
            create.initProperties(config.getData());
            create.setModule(this);
            create.createItems();
        }
        return create;
    }

    @Override // com.youku.arch.v3.IModule
    public void createComponents(@NotNull List<? extends Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950500353")) {
            ipChange.ipc$dispatch("-1950500353", new Object[]{this, list});
            return;
        }
        k21.i(list, "nodes");
        createComponentsImpl(washData(list));
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public IRequest createRequest(@NotNull Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1849403613")) {
            return (IRequest) ipChange.ipc$dispatch("1849403613", new Object[]{this, map});
        }
        k21.i(map, Constants.CONFIG);
        RequestBuilder requestBuilder2 = getRequestBuilder();
        if (requestBuilder2 == null) {
            return null;
        }
        return requestBuilder2.build(map);
    }

    @Override // com.youku.arch.v3.Diff
    public /* bridge */ /* synthetic */ boolean diff(Object obj) {
        return diff((IModule) ((IModule) obj));
    }

    @Override // com.youku.arch.v3.IModule
    @NotNull
    public List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> getAdapters() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "666848887")) {
            return (List) ipChange.ipc$dispatch("666848887", new Object[]{this});
        }
        synchronized (this.components) {
            this.adapters.clear();
            for (T t : this.components) {
                if (t.getChildCount() > 0) {
                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = t.getAdapter();
                    if (adapter != null) {
                        this.adapters.add(adapter);
                    }
                }
            }
            ur2 ur2 = ur2.INSTANCE;
        }
        return this.unmodifiableAdapters;
    }

    @Override // com.youku.arch.v3.DomainObject
    public int getChildCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "410050900")) {
            return this.childCount;
        }
        return ((Integer) ipChange.ipc$dispatch("410050900", new Object[]{this})).intValue();
    }

    @Override // com.youku.arch.v3.IModule
    @NotNull
    public ChildState getChildState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171076764")) {
            return (ChildState) ipChange.ipc$dispatch("-1171076764", new Object[]{this});
        }
        ChildState childState2 = this.childState;
        if (childState2 != null) {
            return childState2;
        }
        k21.A("childState");
        return null;
    }

    @Override // com.youku.arch.v3.IComponentManager
    @Nullable
    public GenericFactory<IComponent<ComponentValue>, Node> getComponentFactory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1388149630")) {
            return (GenericFactory) ipChange.ipc$dispatch("1388149630", new Object[]{this});
        }
        if (this.componentFactory == null) {
            this.componentFactory = PageUtil.INSTANCE.getDefaultComponentFactory(getPageContext());
        }
        return this.componentFactory;
    }

    @Override // com.youku.arch.v3.IComponentManager
    @NotNull
    public List<IComponent<ComponentValue>> getComponents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-522691127")) {
            return this.unmodifiableComponents;
        }
        return (List) ipChange.ipc$dispatch("-522691127", new Object[]{this});
    }

    @Override // com.youku.arch.v3.IModule
    @NotNull
    public IContainer<ModelValue> getContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "38563723")) {
            return (IContainer) ipChange.ipc$dispatch("38563723", new Object[]{this});
        }
        IContainer<ModelValue> iContainer = this.container;
        if (iContainer != null) {
            return iContainer;
        }
        k21.A("container");
        return null;
    }

    @Override // com.youku.arch.v3.Addressable
    @NotNull
    public Coordinate getCoordinate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-351390798")) {
            return new Coordinate(getIndex(), -2, -2);
        }
        return (Coordinate) ipChange.ipc$dispatch("-351390798", new Object[]{this});
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public EventHandler getEventHandler() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1979055921")) {
            return this.eventHandler;
        }
        return (EventHandler) ipChange.ipc$dispatch("-1979055921", new Object[]{this});
    }

    @Override // com.youku.arch.v3.Addressable
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030477353")) {
            return ((Integer) ipChange.ipc$dispatch("-1030477353", new Object[]{this})).intValue();
        }
        getContainer().updateChildIndex();
        return this.index;
    }

    @Nullable
    public PagingLoader getModuleLoader() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1122322120")) {
            return this.moduleLoader;
        }
        return (PagingLoader) ipChange.ipc$dispatch("-1122322120", new Object[]{this});
    }

    @NotNull
    public final Node getNode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-33225442")) {
            return this.node;
        }
        return (Node) ipChange.ipc$dispatch("-33225442", new Object[]{this});
    }

    @Override // com.youku.arch.v3.DomainObject
    @NotNull
    public IContext getPageContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1803532702")) {
            return this.pageContext;
        }
        return (IContext) ipChange.ipc$dispatch("1803532702", new Object[]{this});
    }

    @Override // com.youku.arch.v3.IModule
    @NotNull
    public IParser<Node, VALUE> getParser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010458965")) {
            return (IParser) ipChange.ipc$dispatch("-1010458965", new Object[]{this});
        }
        IParser<Node, VALUE> iParser = this.parser;
        if (iParser != null) {
            return iParser;
        }
        k21.A("parser");
        return null;
    }

    @Override // com.youku.arch.v3.IModule
    @NotNull
    public VALUE getProperty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "953948484")) {
            return (VALUE) ((ModuleValue) ipChange.ipc$dispatch("953948484", new Object[]{this}));
        }
        VALUE value = this.property;
        if (value != null) {
            return value;
        }
        k21.A("property");
        return null;
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public RequestBuilder getRequestBuilder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1288547631")) {
            return this.requestBuilder;
        }
        return (RequestBuilder) ipChange.ipc$dispatch("-1288547631", new Object[]{this});
    }

    @Override // com.youku.arch.v3.IModule
    public int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1444203187")) {
            return this.type;
        }
        return ((Integer) ipChange.ipc$dispatch("-1444203187", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public void handleTitleComponent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043189997")) {
            ipChange.ipc$dispatch("-2043189997", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.DomainObject
    public boolean hasNext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2043479231")) {
            return getProperty().getMore();
        }
        return ((Boolean) ipChange.ipc$dispatch("-2043479231", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.arch.v3.DomainObject
    public void initProperties(@NotNull Node node2) {
        IParser<?, ?> iParser;
        ConfigManager.ParserConfig parserConfig;
        SparseArray<IParser<?, ?>> parsers;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-600785665")) {
            ipChange.ipc$dispatch("-600785665", new Object[]{this, node2});
            return;
        }
        k21.i(node2, "data");
        ConfigManager configManager = getPageContext().getConfigManager();
        List<Node> list = null;
        if (configManager == null || (parserConfig = configManager.getParserConfig(1)) == null || (parsers = parserConfig.getParsers()) == null || (iParser = parsers.get(0)) == null) {
            iParser = null;
        } else {
            setParser(iParser);
        }
        if (iParser == null) {
            setParser(new DefaultModuleParser());
        }
        setProperty(getParser().parseElement(node2));
        setType(node2.getType());
        List<Node> children = getProperty().getChildren();
        if (children != null && !children.isEmpty()) {
            z = false;
        }
        if (z) {
            list = children;
        }
        if (list != null) {
            VALUE property2 = getProperty();
            HashMap hashMap = new HashMap();
            hashMap.put("id", Long.valueOf(property2.getId()));
            hashMap.put("type", Integer.valueOf(property2.getType()));
            JSONObject data = property2.getData();
            if (data != null) {
                hashMap.put("data", data);
            }
            JSONObject rawJson = property2.getRawJson();
            if (rawJson != null) {
                hashMap.put("rawJson", rawJson);
            }
            EventDispatcher eventDispatcher = getPageContext().getEventDispatcher();
            if (eventDispatcher != null) {
                eventDispatcher.dispatchEvent(ArchExceptionEvent.MODULE_CHILDREN_EMPTY, hashMap);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r0.get(r0.size() - 1).loadMore() != false) goto L_0x0037;
     */
    @Override // com.youku.arch.v3.DomainObject
    public boolean loadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1801177929")) {
            return ((Boolean) ipChange.ipc$dispatch("1801177929", new Object[]{this})).booleanValue();
        }
        if (!this.components.isEmpty()) {
            List<IComponent<ComponentValue>> list = this.components;
        }
        if (!(getRequestBuilder() == null || getModuleLoader() == null)) {
            PagingLoader moduleLoader2 = getModuleLoader();
            k21.f(moduleLoader2);
            if (moduleLoader2.canLoadNextPage() && hasNext()) {
                PagingLoader moduleLoader3 = getModuleLoader();
                k21.f(moduleLoader3);
                moduleLoader3.loadNextPage();
            }
        }
        if (getModuleLoader() == null) {
            return false;
        }
        PagingLoader moduleLoader4 = getModuleLoader();
        k21.f(moduleLoader4);
        return moduleLoader4.isLoading();
    }

    @Override // com.youku.arch.v3.DomainObject
    public void onAdd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340933432")) {
            ipChange.ipc$dispatch("-1340933432", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2047154461")) {
            return ((Boolean) ipChange.ipc$dispatch("2047154461", new Object[]{this, str, map})).booleanValue();
        }
        k21.i(str, "type");
        if (getEventHandler() != null) {
            EventHandler eventHandler2 = getEventHandler();
            k21.f(eventHandler2);
            if (eventHandler2.onMessage(str, map)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void onRemove() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969298339")) {
            ipChange.ipc$dispatch("-1969298339", new Object[]{this});
            return;
        }
        setIndex(getIndex() - 1);
    }

    public final void reload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569804551")) {
            ipChange.ipc$dispatch("1569804551", new Object[]{this});
            return;
        }
        PagingLoader moduleLoader2 = getModuleLoader();
        if (moduleLoader2 != null) {
            moduleLoader2.reload();
        }
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void removeComponent(@NotNull IComponent<ComponentValue> iComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "951063871")) {
            ipChange.ipc$dispatch("951063871", new Object[]{this, iComponent});
            return;
        }
        k21.i(iComponent, "component");
        removeComponent(iComponent, (OnChildAttachStateChangeListener) null);
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void replaceComponent(int i, @NotNull IComponent<ComponentValue> iComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-387147494")) {
            ipChange.ipc$dispatch("-387147494", new Object[]{this, Integer.valueOf(i), iComponent});
            return;
        }
        k21.i(iComponent, "component");
        iComponent.setIndex(this.components.get(i).getIndex());
        this.components.get(i).onRemove();
        this.components.set(i, iComponent);
        this.components.get(i).setModule(this);
        this.components.get(i).getModule().setPageContext(iComponent.getPageContext());
        iComponent.onAdd();
        getPageContext().runOnUIThreadLocked(new GenericModule$replaceComponent$1(this, iComponent));
    }

    @Override // com.youku.arch.v3.io.RequestClient
    public void request(@NotNull IRequest iRequest, @NotNull Callback callback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224309700")) {
            ipChange.ipc$dispatch("-224309700", new Object[]{this, iRequest, callback});
            return;
        }
        k21.i(iRequest, "request");
        k21.i(callback, WXBridgeManager.METHOD_CALLBACK);
        getPageContext().runOnLoaderThread(new GenericModule$request$1(iRequest, callback));
    }

    @Override // com.youku.arch.v3.IModule
    public void setChildState(@NotNull ChildState childState2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2020417952")) {
            ipChange.ipc$dispatch("-2020417952", new Object[]{this, childState2});
            return;
        }
        k21.i(childState2, "<set-?>");
        this.childState = childState2;
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void setComponentFactory(@Nullable GenericFactory<IComponent<ComponentValue>, Node> genericFactory) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1652729590")) {
            ipChange.ipc$dispatch("-1652729590", new Object[]{this, genericFactory});
            return;
        }
        this.componentFactory = genericFactory;
    }

    @Override // com.youku.arch.v3.IModule
    public void setContainer(@NotNull IContainer<ModelValue> iContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1760407797")) {
            ipChange.ipc$dispatch("-1760407797", new Object[]{this, iContainer});
            return;
        }
        k21.i(iContainer, "<set-?>");
        this.container = iContainer;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setEventHandler(@Nullable EventHandler eventHandler2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253750453")) {
            ipChange.ipc$dispatch("1253750453", new Object[]{this, eventHandler2});
            return;
        }
        this.eventHandler = eventHandler2;
    }

    @Override // com.youku.arch.v3.Addressable
    public void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-331004397")) {
            ipChange.ipc$dispatch("-331004397", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.index = i;
    }

    public void setModuleLoader(@Nullable PagingLoader pagingLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140697226")) {
            ipChange.ipc$dispatch("1140697226", new Object[]{this, pagingLoader});
            return;
        }
        this.moduleLoader = pagingLoader;
    }

    public final void setNode(@NotNull Node node2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584587370")) {
            ipChange.ipc$dispatch("-584587370", new Object[]{this, node2});
            return;
        }
        k21.i(node2, "<set-?>");
        this.node = node2;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setPageContext(@NotNull IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1775328630")) {
            ipChange.ipc$dispatch("1775328630", new Object[]{this, iContext});
            return;
        }
        k21.i(iContext, "<set-?>");
        this.pageContext = iContext;
    }

    @Override // com.youku.arch.v3.IModule
    public void setParser(@NotNull IParser<Node, VALUE> iParser) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196250813")) {
            ipChange.ipc$dispatch("196250813", new Object[]{this, iParser});
            return;
        }
        k21.i(iParser, "<set-?>");
        this.parser = iParser;
    }

    public void setProperty(@NotNull VALUE value) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596683904")) {
            ipChange.ipc$dispatch("-1596683904", new Object[]{this, value});
            return;
        }
        k21.i(value, "<set-?>");
        this.property = value;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setRequestBuilder(@Nullable RequestBuilder requestBuilder2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1339847389")) {
            ipChange.ipc$dispatch("1339847389", new Object[]{this, requestBuilder2});
            return;
        }
        this.requestBuilder = requestBuilder2;
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1909175819")) {
            ipChange.ipc$dispatch("-1909175819", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.type = i;
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void updateChildIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1980396641")) {
            ipChange.ipc$dispatch("1980396641", new Object[]{this});
        } else if (this.childIndexUpdater.hasChanged()) {
            this.childIndexUpdater.updateChildIndex(this.components);
        }
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void updateComponents(@NotNull List<? extends IComponent<ComponentValue>> list) {
        int size;
        int size2;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-823922350")) {
            ipChange.ipc$dispatch("-823922350", new Object[]{this, list});
            return;
        }
        k21.i(list, com.youku.arch.v3.data.Constants.COMPONENT);
        if (list.size() < this.components.size() && (size2 = list.size()) <= (size = this.components.size() - 1)) {
            while (true) {
                int i2 = size - 1;
                removeComponent(this.components.get(size), true);
                if (size == size2) {
                    break;
                }
                size = i2;
            }
        }
        Activity activity = getPageContext().getActivity();
        if (activity != null) {
            Iterator<T> it = this.components.iterator();
            while (true) {
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter = null;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = next.getAdapter();
                if (adapter != null) {
                    adapter.setContext(activity);
                }
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter2 = next.getAdapter();
                if (adapter2 != null) {
                    vBaseAdapter = adapter2.getInnerAdapter();
                }
                if (vBaseAdapter != null) {
                    vBaseAdapter.setContext(activity);
                }
            }
            for (T t : list) {
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter3 = t.getAdapter();
                if (adapter3 != null) {
                    adapter3.setContext(activity);
                }
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter4 = t.getAdapter();
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = adapter4 == null ? null : adapter4.getInnerAdapter();
                if (innerAdapter != null) {
                    innerAdapter.setContext(activity);
                }
            }
        }
        int size3 = list.size() - 1;
        if (size3 >= 0) {
            while (true) {
                int i3 = i + 1;
                if (this.components.size() <= i) {
                    PerformanceLogUtil performanceLogUtil = PerformanceLogUtil.INSTANCE;
                    performanceLogUtil.markStartPoint(k21.r("add component for type: ", Integer.valueOf(((IComponent) list.get(i)).getType())));
                    addComponent(i, (IComponent) list.get(i), true);
                    performanceLogUtil.markEndPoint(k21.r("add component for type: ", Integer.valueOf(((IComponent) list.get(i)).getType())));
                } else if (((IComponent) list.get(i)).diff(this.components.get(i))) {
                    PerformanceLogUtil performanceLogUtil2 = PerformanceLogUtil.INSTANCE;
                    performanceLogUtil2.markStartPoint(k21.r("diff component to replaceComponent for type: ", Integer.valueOf(((IComponent) list.get(i)).getType())));
                    replaceComponent(i, (IComponent) list.get(i));
                    performanceLogUtil2.markEndPoint(k21.r("diff component to replaceComponent for type: ", Integer.valueOf(((IComponent) list.get(i)).getType())));
                } else {
                    PerformanceLogUtil performanceLogUtil3 = PerformanceLogUtil.INSTANCE;
                    performanceLogUtil3.markStartPoint(k21.r("same component to updateItems for type: ", Integer.valueOf(((IComponent) list.get(i)).getType())));
                    this.components.get(i).updateItems(((IComponent) list.get(i)).getItems());
                    performanceLogUtil3.markEndPoint(k21.r("same component to updateItems for type: ", Integer.valueOf(((IComponent) list.get(i)).getType())));
                }
                if (i3 <= size3) {
                    i = i3;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.youku.arch.v3.core.Node> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @NotNull
    public List<Node> washData(@NotNull List<? extends Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328008031")) {
            return (List) ipChange.ipc$dispatch("1328008031", new Object[]{this, list});
        }
        k21.i(list, "nodes");
        return list;
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void addComponent(int i, @NotNull IComponent<ComponentValue> iComponent, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1858449177")) {
            ipChange.ipc$dispatch("-1858449177", new Object[]{this, Integer.valueOf(i), iComponent, Boolean.valueOf(z)});
            return;
        }
        k21.i(iComponent, "component");
        addComponent(i, iComponent, new GenericModule$addComponent$1(z, this, iComponent));
    }

    public boolean diff(@NotNull IModule<VALUE> iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1145704258")) {
            return ((Boolean) ipChange.ipc$dispatch("1145704258", new Object[]{this, iModule})).booleanValue();
        }
        k21.i(iModule, "target");
        return !k21.d(getProperty(), iModule.getProperty());
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void removeComponent(@NotNull IComponent<ComponentValue> iComponent, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-581745291")) {
            ipChange.ipc$dispatch("-581745291", new Object[]{this, iComponent, Boolean.valueOf(z)});
            return;
        }
        k21.i(iComponent, "component");
        removeComponent(iComponent, new GenericModule$removeComponent$1(z, this, iComponent));
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void addComponent(int i, @NotNull IComponent<ComponentValue> iComponent, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064239010")) {
            ipChange.ipc$dispatch("-1064239010", new Object[]{this, Integer.valueOf(i), iComponent, onChildAttachStateChangeListener});
            return;
        }
        k21.i(iComponent, "component");
        getPageContext().runOnLoaderThreadLocked(new GenericModule$addComponent$2(this, iComponent, onChildAttachStateChangeListener, i));
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void removeComponent(@NotNull IComponent<ComponentValue> iComponent, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-715459860")) {
            ipChange.ipc$dispatch("-715459860", new Object[]{this, iComponent, onChildAttachStateChangeListener});
            return;
        }
        k21.i(iComponent, "component");
        getPageContext().runOnLoaderThreadLocked(new GenericModule$removeComponent$2(this, iComponent, onChildAttachStateChangeListener));
    }
}
