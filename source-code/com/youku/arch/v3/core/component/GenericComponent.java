package com.youku.arch.v3.core.component;

import android.taobao.windvane.connect.api.ApiResponse;
import android.util.SparseArray;
import com.alibaba.android.vlayout.a;
import com.alibaba.android.vlayout.layout.FixAreaLayoutHelper;
import com.alibaba.android.vlayout.layout.c;
import com.alibaba.android.vlayout.layout.h;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
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
import com.youku.arch.v3.core.Render;
import com.youku.arch.v3.core.parser.ComponentParser;
import com.youku.arch.v3.core.parser.DefaultComponentParser;
import com.youku.arch.v3.core.parser.IParser;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.PagingLoader;
import com.youku.arch.v3.recyclerview.layouthelper.GridFixAutoStatLayoutHelper;
import com.youku.arch.v3.typeconvert.TypeConvertManager;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.wj2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 ³\u0001*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002³\u0001B\u0019\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010>\u001a\u00020\u000b¢\u0006\u0006\b±\u0001\u0010²\u0001J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J&\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J(\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0016\u0010\u0018\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u001e\u0010\u0018\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J \u0010\u0018\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001a\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nH\u0016J\u001e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J.\u0010\u001f\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u001cH\u0016J\u0018\u0010!\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\u001e\u0010)\u001a\u0004\u0018\u00010 2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&H\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020\bH\u0016J\b\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\bH\u0016J\b\u0010/\u001a\u00020\bH\u0016J&\u00102\u001a\u00020\u00142\u0006\u00100\u001a\u00020'2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0018\u00010&H\u0016J\u001a\u00104\u001a\u00020\b2\u0012\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nJ\u0016\u00106\u001a\u00020\u00142\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0016R\"\u00108\u001a\u0002078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u00100\u001a\u00020\u00108F@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u00028\u00008\u0016@\u0016X.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR(\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0O8\u0016@\u0016X.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bY\u0010XR*\u0010[\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010\n8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b[\u0010X\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001e\u0010`\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cRC\u0010h\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u001c8V@\u0016X\u0002¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gRH\u0010i\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u001c8V@\u0016X\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010g\"\u0004\bl\u0010mR6\u0010o\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010n8V@\u0016X\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u0010v\u001a\u0004\u0018\u00010u8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R1\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000|8\u0016@\u0016X.¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u0010\u0001\"\u0006\b\u0001\u0010\u0001R6\u0010\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R$\u0010\u0011\u001a\u00020\u00108V@\u0016X\u000e¢\u0006\u0014\n\u0004\b\u0011\u0010D\u001a\u0005\b\u0001\u0010F\"\u0005\b\u0001\u0010HR,\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0016@\u0016X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R,\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R!\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030 \u00010\u00018V@\u0016X\u0004¢\u0006\b\u001a\u0006\b¡\u0001\u0010¢\u0001R#\u0010¥\u0001\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\n8F@\u0006¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010]R\u0018\u0010¨\u0001\u001a\u0004\u0018\u00010\u00108F@\u0006¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R\u0018\u0010ª\u0001\u001a\u00020\u00108V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b©\u0001\u0010FR\u0018\u0010¬\u0001\u001a\u00020\u00108V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b«\u0001\u0010FR\u001a\u0010°\u0001\u001a\u00030­\u00018V@\u0016X\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001¨\u0006´\u0001"}, d2 = {"Lcom/youku/arch/v3/core/component/GenericComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/IComponent;", "", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "getItems", "Ltb/ur2;", "createItems", "", "Lcom/youku/arch/v3/core/Node;", "nodes", "Lcom/youku/arch/v3/core/Config;", Constants.CONFIG, "createItem", "", "index", "item", "addItem", "", "notifyUiUpdate", "Lcom/youku/arch/v3/core/OnChildAttachStateChangeListener;", "listener", "removeItem", "items", "updateItems", "replaceItem", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "createAdapter", "Lcom/youku/arch/v3/io/IRequest;", "request", "Lcom/youku/arch/v3/io/Callback;", WXBridgeManager.METHOD_CALLBACK, "loadMore", wj2.HAS_NEXT, "", "", "", "createRequest", "data", "initProperties", "updateChildIndex", "clearItems", "onAdd", "onRemove", "type", "params", "onMessage", "newList", "notifyLocalDataSetChanged", "target", "diff", "Lcom/youku/arch/v3/core/IContext;", com.youku.arch.v3.data.Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/IContext;", "getPageContext", "()Lcom/youku/arch/v3/core/IContext;", "setPageContext", "(Lcom/youku/arch/v3/core/IContext;)V", "node", "Lcom/youku/arch/v3/core/Node;", "getNode", "()Lcom/youku/arch/v3/core/Node;", "setNode", "(Lcom/youku/arch/v3/core/Node;)V", "I", "getType", "()I", "setType", "(I)V", "property", "Lcom/youku/arch/v3/core/ComponentValue;", "getProperty", "()Lcom/youku/arch/v3/core/ComponentValue;", "setProperty", "(Lcom/youku/arch/v3/core/ComponentValue;)V", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "module", "Lcom/youku/arch/v3/IModule;", "getModule", "()Lcom/youku/arch/v3/IModule;", "setModule", "(Lcom/youku/arch/v3/IModule;)V", "childItems", "Ljava/util/List;", "unmodifiableChildItems", "Lcom/youku/arch/v3/core/Render;", "renders", "getRenders", "()Ljava/util/List;", "setRenders", "(Ljava/util/List;)V", "rawJson", "Ljava/lang/String;", "getRawJson", "()Ljava/lang/String;", "adapter$delegate", "Lkotlin/Lazy;", "getAdapter", "()Lcom/youku/arch/v3/adapter/VBaseAdapter;", "adapter", "innerAdapter", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "getInnerAdapter", "setInnerAdapter", "(Lcom/youku/arch/v3/adapter/VBaseAdapter;)V", "Lcom/youku/arch/v3/GenericFactory;", "itemFactory", "Lcom/youku/arch/v3/GenericFactory;", "getItemFactory", "()Lcom/youku/arch/v3/GenericFactory;", "setItemFactory", "(Lcom/youku/arch/v3/GenericFactory;)V", "Lcom/youku/arch/v3/io/RequestBuilder;", "requestBuilder", "Lcom/youku/arch/v3/io/RequestBuilder;", "getRequestBuilder", "()Lcom/youku/arch/v3/io/RequestBuilder;", "setRequestBuilder", "(Lcom/youku/arch/v3/io/RequestBuilder;)V", "Lcom/youku/arch/v3/core/parser/ComponentParser;", "parser", "Lcom/youku/arch/v3/core/parser/ComponentParser;", "getParser", "()Lcom/youku/arch/v3/core/parser/ComponentParser;", "setParser", "(Lcom/youku/arch/v3/core/parser/ComponentParser;)V", "Lcom/youku/arch/v3/core/ChildIndexUpdater;", "childIndexUpdater", "Lcom/youku/arch/v3/core/ChildIndexUpdater;", "getChildIndexUpdater", "()Lcom/youku/arch/v3/core/ChildIndexUpdater;", "setChildIndexUpdater", "(Lcom/youku/arch/v3/core/ChildIndexUpdater;)V", "getIndex", "setIndex", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", "Lcom/youku/arch/v3/event/EventHandler;", "getEventHandler", "()Lcom/youku/arch/v3/event/EventHandler;", "setEventHandler", "(Lcom/youku/arch/v3/event/EventHandler;)V", "isDataBound", "Z", "()Z", "setDataBound", "(Z)V", "Lcom/youku/arch/v3/loader/PagingLoader;", "componentLoader", "Lcom/youku/arch/v3/loader/PagingLoader;", "getComponentLoader", "()Lcom/youku/arch/v3/loader/PagingLoader;", "setComponentLoader", "(Lcom/youku/arch/v3/loader/PagingLoader;)V", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "getContainer", "()Lcom/youku/arch/v3/IContainer;", "container", "getRenderChildItems", "renderChildItems", "getRenderChildCount", "()Ljava/lang/Integer;", "renderChildCount", "getChildCount", "childCount", "getPosInRenderList", "posInRenderList", "Lcom/youku/arch/v3/core/Coordinate;", "getCoordinate", "()Lcom/youku/arch/v3/core/Coordinate;", "coordinate", "<init>", "(Lcom/youku/arch/v3/core/IContext;Lcom/youku/arch/v3/core/Node;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class GenericComponent<VALUE extends ComponentValue> implements IComponent<VALUE> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.GenericComponent";
    @NotNull
    private final Lazy adapter$delegate;
    @NotNull
    private ChildIndexUpdater<IItem<ItemValue>> childIndexUpdater;
    @JvmField
    @NotNull
    public List<IItem<ItemValue>> childItems;
    @Nullable
    private PagingLoader componentLoader;
    @Nullable
    private EventHandler eventHandler;
    private volatile int index;
    @Nullable
    private VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter;
    private boolean isDataBound;
    @Nullable
    private GenericFactory<IItem<ItemValue>, Node> itemFactory;
    public IModule<ModuleValue> module;
    @NotNull
    private Node node;
    @NotNull
    private IContext pageContext;
    public ComponentParser<Node, VALUE> parser;
    public VALUE property;
    @Nullable
    private final String rawJson;
    @Nullable
    private List<? extends Render> renders;
    @Nullable
    private RequestBuilder requestBuilder;
    private int type = -1;
    @JvmField
    @NotNull
    public List<IItem<ItemValue>> unmodifiableChildItems;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/core/component/GenericComponent$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    public GenericComponent(@NotNull IContext iContext, @NotNull Node node2) {
        k21.i(iContext, com.youku.arch.v3.data.Constants.PAGE_CONTEXT);
        k21.i(node2, "node");
        this.pageContext = iContext;
        this.node = node2;
        ArrayList arrayList = new ArrayList();
        this.childItems = arrayList;
        List<IItem<ItemValue>> unmodifiableList = Collections.unmodifiableList(arrayList);
        k21.h(unmodifiableList, "unmodifiableList(childItems)");
        this.unmodifiableChildItems = unmodifiableList;
        JSONObject data = this.node.getData();
        this.rawJson = data == null ? null : data.toJSONString();
        this.adapter$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, new GenericComponent$adapter$2(this));
        this.childIndexUpdater = new ChildIndexUpdater<>();
        this.index = -1;
    }

    @Override // com.youku.arch.v3.IItemManager
    public void addItem(int i, @NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928615347")) {
            ipChange.ipc$dispatch("-928615347", new Object[]{this, Integer.valueOf(i), iItem});
            return;
        }
        k21.i(iItem, "item");
        addItem(i, iItem, false);
    }

    @Override // com.youku.arch.v3.IComponent
    public void clearItems() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1088667")) {
            ipChange.ipc$dispatch("-1088667", new Object[]{this});
            return;
        }
        getPageContext().runOnLoaderThreadLocked(new GenericComponent$clearItems$1(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0075  */
    @Nullable
    public VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> createAdapter() {
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter;
        JSONObject data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598039215")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1598039215", new Object[]{this});
        }
        HashMap hashMap = new HashMap(8);
        hashMap.put("data", this.childItems);
        hashMap.put("render", getRenders());
        hashMap.put("pageName", getPageContext().getPageName());
        hashMap.put(com.youku.arch.v3.data.Constants.PAGE_CONTEXT, getPageContext());
        Config<Map<String, Object>> config = new Config<>(getPageContext(), getType(), hashMap, 0, false, 24, null);
        a aVar = null;
        try {
            GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> adapterFactory = getContainer().getAdapterFactory();
            if (adapterFactory == null) {
                vBaseAdapter = null;
                if (vBaseAdapter != null) {
                    aVar = vBaseAdapter.getLayoutHelper();
                }
                if (aVar != null && (((vBaseAdapter.getLayoutHelper() instanceof GridFixAutoStatLayoutHelper) || (vBaseAdapter.getLayoutHelper() instanceof c)) && (data = getProperty().getData()) != null && data.containsKey(com.youku.arch.v3.data.Constants.DISPLAY_NUM))) {
                    vBaseAdapter.setRenderCount(data.getIntValue(com.youku.arch.v3.data.Constants.DISPLAY_NUM));
                }
                return vBaseAdapter;
            }
            vBaseAdapter = adapterFactory.create(config);
            if (vBaseAdapter != null) {
            }
            vBaseAdapter.setRenderCount(data.getIntValue(com.youku.arch.v3.data.Constants.DISPLAY_NUM));
            return vBaseAdapter;
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
    }

    @Override // com.youku.arch.v3.IItemManager
    @Nullable
    public IItem<ItemValue> createItem(@NotNull Config<Node> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1859826763")) {
            return (IItem) ipChange.ipc$dispatch("-1859826763", new Object[]{this, config});
        }
        k21.i(config, Constants.CONFIG);
        GenericFactory<IItem<ItemValue>, Node> itemFactory2 = getItemFactory();
        IItem<ItemValue> create = itemFactory2 == null ? null : itemFactory2.create(config);
        if (create != null) {
            create.setComponent(this);
            create.initProperties(config.getData());
        }
        return create;
    }

    @Override // com.youku.arch.v3.IComponent
    public void createItems() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1307566830")) {
            ipChange.ipc$dispatch("1307566830", new Object[]{this});
            return;
        }
        getPageContext().runOnLoaderThreadLocked(new GenericComponent$createItems$1(this));
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public IRequest createRequest(@NotNull Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782022357")) {
            return (IRequest) ipChange.ipc$dispatch("782022357", new Object[]{this, map});
        }
        k21.i(map, Constants.CONFIG);
        RequestBuilder requestBuilder2 = getRequestBuilder();
        if (requestBuilder2 == null) {
            return null;
        }
        return requestBuilder2.build(map);
    }

    public boolean diff(@NotNull IComponent<ComponentValue> iComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413560571")) {
            return ((Boolean) ipChange.ipc$dispatch("-413560571", new Object[]{this, iComponent})).booleanValue();
        }
        k21.i(iComponent, "target");
        return true;
    }

    @Override // com.youku.arch.v3.IComponent
    @Nullable
    public VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> getAdapter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-286863855")) {
            return (VBaseAdapter) this.adapter$delegate.getValue();
        }
        return (VBaseAdapter) ipChange.ipc$dispatch("-286863855", new Object[]{this});
    }

    @Override // com.youku.arch.v3.DomainObject
    public int getChildCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1902731172")) {
            return this.childItems.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-1902731172", new Object[]{this})).intValue();
    }

    @NotNull
    public final ChildIndexUpdater<IItem<ItemValue>> getChildIndexUpdater() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1738184134")) {
            return this.childIndexUpdater;
        }
        return (ChildIndexUpdater) ipChange.ipc$dispatch("-1738184134", new Object[]{this});
    }

    @Nullable
    public final PagingLoader getComponentLoader() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1920525343")) {
            return this.componentLoader;
        }
        return (PagingLoader) ipChange.ipc$dispatch("-1920525343", new Object[]{this});
    }

    @Override // com.youku.arch.v3.IComponent
    @NotNull
    public IContainer<ModelValue> getContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1693242003")) {
            return getModule().getContainer();
        }
        return (IContainer) ipChange.ipc$dispatch("1693242003", new Object[]{this});
    }

    @Override // com.youku.arch.v3.Addressable
    @NotNull
    public Coordinate getCoordinate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2050346822")) {
            return new Coordinate(getModule().getIndex(), getIndex(), -2);
        }
        return (Coordinate) ipChange.ipc$dispatch("-2050346822", new Object[]{this});
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public EventHandler getEventHandler() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "871033031")) {
            return this.eventHandler;
        }
        return (EventHandler) ipChange.ipc$dispatch("871033031", new Object[]{this});
    }

    @Override // com.youku.arch.v3.Addressable
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778722255")) {
            return ((Integer) ipChange.ipc$dispatch("1778722255", new Object[]{this})).intValue();
        }
        getModule().updateChildIndex();
        return this.index;
    }

    @Override // com.youku.arch.v3.IComponent
    @Nullable
    public VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> getInnerAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1159741587")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1159741587", new Object[]{this});
        }
        if (this.innerAdapter == null) {
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getAdapter();
            this.innerAdapter = adapter == null ? null : adapter.getInnerAdapter();
        }
        return this.innerAdapter;
    }

    @Override // com.youku.arch.v3.IItemManager
    @Nullable
    public GenericFactory<IItem<ItemValue>, Node> getItemFactory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2055554574")) {
            return (GenericFactory) ipChange.ipc$dispatch("2055554574", new Object[]{this});
        }
        if (this.itemFactory == null) {
            this.itemFactory = PageUtil.INSTANCE.getDefaultItemFactory(getPageContext());
        }
        return this.itemFactory;
    }

    @Override // com.youku.arch.v3.IItemManager
    @NotNull
    public List<IItem<ItemValue>> getItems() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1187174489")) {
            return this.unmodifiableChildItems;
        }
        return (List) ipChange.ipc$dispatch("1187174489", new Object[]{this});
    }

    @Override // com.youku.arch.v3.IComponent
    @NotNull
    public IModule<ModuleValue> getModule() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544303705")) {
            return (IModule) ipChange.ipc$dispatch("544303705", new Object[]{this});
        }
        IModule<ModuleValue> iModule = this.module;
        if (iModule != null) {
            return iModule;
        }
        k21.A("module");
        return null;
    }

    @NotNull
    public final Node getNode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1833848358")) {
            return this.node;
        }
        return (Node) ipChange.ipc$dispatch("1833848358", new Object[]{this});
    }

    @Override // com.youku.arch.v3.DomainObject
    @NotNull
    public IContext getPageContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1437860970")) {
            return this.pageContext;
        }
        return (IContext) ipChange.ipc$dispatch("-1437860970", new Object[]{this});
    }

    @Override // com.youku.arch.v3.IComponent
    @NotNull
    public ComponentParser<Node, VALUE> getParser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1061064863")) {
            return (ComponentParser) ipChange.ipc$dispatch("1061064863", new Object[]{this});
        }
        ComponentParser<Node, VALUE> componentParser = this.parser;
        if (componentParser != null) {
            return componentParser;
        }
        k21.A("parser");
        return null;
    }

    @Override // com.youku.arch.v3.IComponent
    public int getPosInRenderList() {
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> next;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "742847156")) {
            return ((Integer) ipChange.ipc$dispatch("742847156", new Object[]{this})).intValue();
        }
        if (getAdapter() == null) {
            return -1;
        }
        if (getContainer().isChildStateDirty()) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.d(TAG, k21.r("isChildStateDirty getPosInRenderList pos ", 0));
            }
            getPageContext().runOnUIThreadLocked(new GenericComponent$posInRenderList$1(this));
        }
        Iterator<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> it = getContainer().getChildAdapters().iterator();
        int i = 0;
        while (it.hasNext() && getAdapter() != (next = it.next())) {
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getAdapter();
            k21.f(adapter);
            if (adapter.data == next.data) {
                break;
            }
            if (!(next.getLayoutHelper() instanceof com.alibaba.android.vlayout.layout.b) && !(next.getLayoutHelper() instanceof GridFixAutoStatLayoutHelper)) {
                next.getLayoutHelper();
                if (!(next.getLayoutHelper() instanceof c)) {
                    if ((next.getLayoutHelper() instanceof h) || (next.getLayoutHelper() instanceof FixAreaLayoutHelper)) {
                        i++;
                    }
                }
            }
            i += next.getItemCount();
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.d(TAG, k21.r("getPosInRenderList pos ", Integer.valueOf(i)));
        }
        return i;
    }

    @Override // com.youku.arch.v3.IComponent
    @NotNull
    public VALUE getProperty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "675416513")) {
            return (VALUE) ((ComponentValue) ipChange.ipc$dispatch("675416513", new Object[]{this}));
        }
        VALUE value = this.property;
        if (value != null) {
            return value;
        }
        k21.A("property");
        return null;
    }

    @Override // com.youku.arch.v3.IComponent
    @Nullable
    public String getRawJson() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "82900450")) {
            return this.rawJson;
        }
        return (String) ipChange.ipc$dispatch("82900450", new Object[]{this});
    }

    @Nullable
    public final Integer getRenderChildCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-936840806")) {
            return (Integer) ipChange.ipc$dispatch("-936840806", new Object[]{this});
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getAdapter();
        if (adapter == null) {
            return null;
        }
        return Integer.valueOf(adapter.getItemCount());
    }

    @Nullable
    public final List<IItem<ItemValue>> getRenderChildItems() {
        int renderStart;
        int itemCount;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1203796261")) {
            return (List) ipChange.ipc$dispatch("1203796261", new Object[]{this});
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getAdapter();
        if (adapter != null && this.unmodifiableChildItems.size() >= (itemCount = adapter.getItemCount() + (renderStart = adapter.getRenderStart()))) {
            return this.unmodifiableChildItems.subList(renderStart, itemCount);
        }
        return null;
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<? extends com.youku.arch.v3.core.Render>, java.util.List<com.youku.arch.v3.core.Render> */
    @Override // com.youku.arch.v3.IComponent
    @Nullable
    public List<Render> getRenders() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2048325834")) {
            return this.renders;
        }
        return (List) ipChange.ipc$dispatch("-2048325834", new Object[]{this});
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public RequestBuilder getRequestBuilder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1164863961")) {
            return this.requestBuilder;
        }
        return (RequestBuilder) ipChange.ipc$dispatch("1164863961", new Object[]{this});
    }

    @Override // com.youku.arch.v3.IComponent
    public final int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "586078805")) {
            return TypeConvertManager.INSTANCE.convertType(this.type, getProperty(), this.node.getData());
        }
        return ((Integer) ipChange.ipc$dispatch("586078805", new Object[]{this})).intValue();
    }

    @Override // com.youku.arch.v3.DomainObject
    public boolean hasNext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-13197239")) {
            return getProperty().getMore();
        }
        return ((Boolean) ipChange.ipc$dispatch("-13197239", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.arch.v3.DomainObject
    public void initProperties(@NotNull Node node2) {
        IParser<?, ?> iParser;
        ConfigManager.ParserConfig parserConfig;
        SparseArray<IParser<?, ?>> parsers;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "407141895")) {
            ipChange.ipc$dispatch("407141895", new Object[]{this, node2});
            return;
        }
        k21.i(node2, "data");
        ConfigManager configManager = getPageContext().getConfigManager();
        List<Node> list = null;
        if (configManager == null || (parserConfig = configManager.getParserConfig(2)) == null || (parsers = parserConfig.getParsers()) == null || (iParser = parsers.get(0)) == null) {
            iParser = null;
        } else {
            setParser((ComponentParser) iParser);
        }
        if (iParser == null) {
            setParser(new DefaultComponentParser());
        }
        setProperty(getParser().parseElement(node2));
        this.type = node2.getType();
        setRenders(getParser().parseConfig(node2));
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
            JSONObject rawJson2 = property2.getRawJson();
            if (rawJson2 != null) {
                hashMap.put("rawJson", rawJson2);
            }
            EventDispatcher eventDispatcher = getPageContext().getEventDispatcher();
            if (eventDispatcher != null) {
                eventDispatcher.dispatchEvent(ArchExceptionEvent.COMPONENT_CHILDREN_EMPTY, hashMap);
            }
        }
    }

    public final boolean isDataBound() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1952121708")) {
            return this.isDataBound;
        }
        return ((Boolean) ipChange.ipc$dispatch("1952121708", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.arch.v3.DomainObject
    public boolean loadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "315410241")) {
            return ((Boolean) ipChange.ipc$dispatch("315410241", new Object[]{this})).booleanValue();
        }
        PagingLoader pagingLoader = this.componentLoader;
        if (pagingLoader == null) {
            return false;
        }
        if (getRequestBuilder() == null || !pagingLoader.canLoadNextPage() || !hasNext()) {
            return pagingLoader.isLoading();
        }
        pagingLoader.loadNextPage();
        return true;
    }

    public final void notifyLocalDataSetChanged(@NotNull List<? extends IItem<ItemValue>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1753759109")) {
            ipChange.ipc$dispatch("1753759109", new Object[]{this, list});
            return;
        }
        k21.i(list, "newList");
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyLocalDataSetChanged(this.childItems, list);
        }
    }

    @Override // com.youku.arch.v3.DomainObject
    public void onAdd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766754352")) {
            ipChange.ipc$dispatch("-766754352", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1802573589")) {
            return ((Boolean) ipChange.ipc$dispatch("1802573589", new Object[]{this, str, map})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "839901269")) {
            ipChange.ipc$dispatch("839901269", new Object[]{this});
            return;
        }
        setIndex(getIndex() - 1);
    }

    @Override // com.youku.arch.v3.IItemManager
    public void removeItem(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1720777295")) {
            ipChange.ipc$dispatch("-1720777295", new Object[]{this, iItem});
            return;
        }
        k21.i(iItem, "item");
        removeItem(iItem, (OnChildAttachStateChangeListener) null);
    }

    @Override // com.youku.arch.v3.IItemManager
    public void replaceItem(int i, @NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1664586266")) {
            ipChange.ipc$dispatch("1664586266", new Object[]{this, Integer.valueOf(i), iItem});
            return;
        }
        k21.i(iItem, "item");
        iItem.setComponent(this);
        this.childItems.set(i, iItem);
        getPageContext().runOnUIThreadLocked(new GenericComponent$replaceItem$1(this, i));
    }

    @Override // com.youku.arch.v3.io.RequestClient
    public void request(@NotNull IRequest iRequest, @NotNull Callback callback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1428051268")) {
            ipChange.ipc$dispatch("1428051268", new Object[]{this, iRequest, callback});
            return;
        }
        k21.i(iRequest, "request");
        k21.i(callback, WXBridgeManager.METHOD_CALLBACK);
        getPageContext().runOnLoaderThread(new GenericComponent$request$1(iRequest, callback));
    }

    public final void setChildIndexUpdater(@NotNull ChildIndexUpdater<IItem<ItemValue>> childIndexUpdater2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397937286")) {
            ipChange.ipc$dispatch("1397937286", new Object[]{this, childIndexUpdater2});
            return;
        }
        k21.i(childIndexUpdater2, "<set-?>");
        this.childIndexUpdater = childIndexUpdater2;
    }

    public final void setComponentLoader(@Nullable PagingLoader pagingLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "106608489")) {
            ipChange.ipc$dispatch("106608489", new Object[]{this, pagingLoader});
            return;
        }
        this.componentLoader = pagingLoader;
    }

    public final void setDataBound(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455216526")) {
            ipChange.ipc$dispatch("455216526", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isDataBound = z;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setEventHandler(@Nullable EventHandler eventHandler2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-587805251")) {
            ipChange.ipc$dispatch("-587805251", new Object[]{this, eventHandler2});
            return;
        }
        this.eventHandler = eventHandler2;
    }

    @Override // com.youku.arch.v3.Addressable
    public void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854837531")) {
            ipChange.ipc$dispatch("854837531", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.index = i;
    }

    @Override // com.youku.arch.v3.IComponent
    public void setInnerAdapter(@Nullable VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1339008783")) {
            ipChange.ipc$dispatch("-1339008783", new Object[]{this, vBaseAdapter});
            return;
        }
        this.innerAdapter = vBaseAdapter;
    }

    @Override // com.youku.arch.v3.IItemManager
    public void setItemFactory(@Nullable GenericFactory<IItem<ItemValue>, Node> genericFactory) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1968676078")) {
            ipChange.ipc$dispatch("-1968676078", new Object[]{this, genericFactory});
            return;
        }
        this.itemFactory = genericFactory;
    }

    @Override // com.youku.arch.v3.IComponent
    public void setModule(@NotNull IModule<ModuleValue> iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1203490517")) {
            ipChange.ipc$dispatch("1203490517", new Object[]{this, iModule});
            return;
        }
        k21.i(iModule, "<set-?>");
        this.module = iModule;
    }

    public final void setNode(@NotNull Node node2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1460125582")) {
            ipChange.ipc$dispatch("1460125582", new Object[]{this, node2});
            return;
        }
        k21.i(node2, "<set-?>");
        this.node = node2;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setPageContext(@NotNull IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "76372606")) {
            ipChange.ipc$dispatch("76372606", new Object[]{this, iContext});
            return;
        }
        k21.i(iContext, "<set-?>");
        this.pageContext = iContext;
    }

    @Override // com.youku.arch.v3.IComponent
    public void setParser(@NotNull ComponentParser<Node, VALUE> componentParser) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1855957599")) {
            ipChange.ipc$dispatch("-1855957599", new Object[]{this, componentParser});
            return;
        }
        k21.i(componentParser, "<set-?>");
        this.parser = componentParser;
    }

    public void setProperty(@NotNull VALUE value) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-195425937")) {
            ipChange.ipc$dispatch("-195425937", new Object[]{this, value});
            return;
        }
        k21.i(value, "<set-?>");
        this.property = value;
    }

    public void setRenders(@Nullable List<? extends Render> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "28355566")) {
            ipChange.ipc$dispatch("28355566", new Object[]{this, list});
            return;
        }
        this.renders = list;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setRequestBuilder(@Nullable RequestBuilder requestBuilder2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86195413")) {
            ipChange.ipc$dispatch("86195413", new Object[]{this, requestBuilder2});
            return;
        }
        this.requestBuilder = requestBuilder2;
    }

    public final void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "900023789")) {
            ipChange.ipc$dispatch("900023789", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.type = i;
    }

    @Override // com.youku.arch.v3.IItemManager
    public void updateChildIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755052121")) {
            ipChange.ipc$dispatch("1755052121", new Object[]{this});
        } else if (this.childIndexUpdater.hasChanged()) {
            this.childIndexUpdater.updateChildIndex(this.childItems);
        }
    }

    @Override // com.youku.arch.v3.IItemManager
    public void updateItems(@NotNull List<? extends IItem<ItemValue>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142994260")) {
            ipChange.ipc$dispatch("-142994260", new Object[]{this, list});
            return;
        }
        k21.i(list, "items");
        if (list.size() < this.childItems.size()) {
            List<IItem<ItemValue>> list2 = this.childItems;
            list2.removeAll(list2.subList(list.size(), this.childItems.size()));
        }
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (this.childItems.size() <= i) {
                    addItem(i, (IItem) list.get(i), true);
                } else if (((IItem) list.get(i)).diff(this.childItems.get(i))) {
                    replaceItem(i, (IItem) list.get(i));
                } else {
                    LogUtil.v(TAG, k21.r("same item type:", Integer.valueOf(((IItem) list.get(i)).getType())));
                }
                if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.youku.arch.v3.IItemManager
    public void addItem(int i, @NotNull IItem<ItemValue> iItem, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1277741095")) {
            ipChange.ipc$dispatch("1277741095", new Object[]{this, Integer.valueOf(i), iItem, Boolean.valueOf(z)});
            return;
        }
        k21.i(iItem, "item");
        addItem(i, iItem, new GenericComponent$addItem$1(z, this, i));
    }

    @Override // com.youku.arch.v3.IComponent
    public void createItems(@NotNull List<? extends Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "784782303")) {
            ipChange.ipc$dispatch("784782303", new Object[]{this, list});
            return;
        }
        k21.i(list, "nodes");
        getPageContext().runOnLoaderThreadLocked(new GenericComponent$createItems$2(list, this));
    }

    @Override // com.youku.arch.v3.IItemManager
    public void removeItem(@NotNull IItem<ItemValue> iItem, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804442813")) {
            ipChange.ipc$dispatch("-1804442813", new Object[]{this, iItem, Boolean.valueOf(z)});
            return;
        }
        k21.i(iItem, "item");
        removeItem(iItem, new GenericComponent$removeItem$1(z, this, iItem));
    }

    @Override // com.youku.arch.v3.IItemManager
    public void addItem(int i, @NotNull IItem<ItemValue> iItem, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246462366")) {
            ipChange.ipc$dispatch("246462366", new Object[]{this, Integer.valueOf(i), iItem, onChildAttachStateChangeListener});
            return;
        }
        k21.i(iItem, "item");
        iItem.setComponent(this);
        this.childItems.add(i, iItem);
        iItem.setIndex(i);
        iItem.onAdd();
        this.childIndexUpdater.onChildAdded(iItem);
        if (onChildAttachStateChangeListener != null) {
            onChildAttachStateChangeListener.onChildAdded(iItem);
        }
    }

    @Override // com.youku.arch.v3.IItemManager
    public void removeItem(@NotNull IItem<ItemValue> iItem, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1516351814")) {
            ipChange.ipc$dispatch("-1516351814", new Object[]{this, iItem, onChildAttachStateChangeListener});
            return;
        }
        k21.i(iItem, "item");
        getPageContext().runOnLoaderThreadLocked(new GenericComponent$removeItem$2(this, iItem, onChildAttachStateChangeListener));
    }
}
