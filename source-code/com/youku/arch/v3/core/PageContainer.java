package com.youku.arch.v3.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Looper;
import android.taobao.windvane.connect.api.ApiResponse;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.ChildState;
import com.youku.arch.v3.GenericFactory;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.ICreator;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.adapter.VDefaultAdapter;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.parser.DefaultModelParser;
import com.youku.arch.v3.core.parser.IParser;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.recyclerview.GenericRecycledViewPool;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.util.PerformanceLogUtil;
import com.youku.arch.v3.util.Util;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.wj2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 ¤\u0001*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002¤\u0001B\u001b\u0012\u0006\u0010B\u001a\u00020A\u0012\b\u0010H\u001a\u0004\u0018\u00010'¢\u0006\u0006\b¢\u0001\u0010£\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J$\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000eH\u0002JF\u0010\u0017\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00160\u00150\u00120\u00112\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u001e\u0010 \u001a\u0004\u0018\u00010\u00182\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\nH\u0016J\u0014\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0011H\u0016J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016J\u001e\u0010*\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J(\u0010*\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J&\u0010*\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010-\u001a\u00020!H\u0016J\u001e\u0010.\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J(\u0010.\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0016\u0010/\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J \u0010/\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u001e\u0010/\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010-\u001a\u00020!H\u0016J\u0016\u00100\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020'0\u0011H\u0016J\u0016\u00102\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00020'0\u0011H\u0016J\u001c\u00103\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0011H\u0016J\b\u00104\u001a\u00020\nH\u0016J:\u00106\u001a\u00020\n20\u00105\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00160\u00150\u00120\u0011H\u0016J\b\u00107\u001a\u00020\nH\u0016J\u0010\u00109\u001a\u00020\n2\u0006\u00108\u001a\u00020'H\u0016J&\u0010<\u001a\u00020!2\u0006\u0010:\u001a\u00020\u001d2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cH\u0016J\b\u0010=\u001a\u00020\nH\u0016J\b\u0010>\u001a\u00020\nH\u0016J\b\u0010?\u001a\u00020\nH\u0016J\b\u0010@\u001a\u00020\nH\u0017R\"\u0010B\u001a\u00020A8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0016@\u0016X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0016@\u0016X.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[Rd\u0010]\u001aD\u0012*\u0012(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0012\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001c\u0018\u00010\\8V@\u0016X\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR@\u00105\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00160\u00150\u00120\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010cR/\u0010g\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020'0\\8V@\u0016X\u0002¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010`R\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00118\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010cR\"\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00118\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bh\u0010cR$\u0010j\u001a\u0004\u0018\u00010i8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010p\u001a\u00028\u00008\u0016@\u0016X.¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0016\u0010w\u001a\u00020v8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\"\u0010z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060y8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bz\u0010{R'\u0010}\u001a\u0004\u0018\u00010|8\u0016@\u0016X\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u0010\u0001\"\u0006\b\u0001\u0010\u0001R6\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00028\u00000\u00018\u0016@\u0016X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u0010:\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u0017\n\u0005\b:\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u0010\u0005\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u0017\n\u0005\b\u0005\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u00030\u00018\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001RC\u0010\u0001\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00160\u00150\u00120\u00118V@\u0016X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R%\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00118V@\u0016X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00048V@\u0016X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0019\u0010 \u0001\u001a\u00020!8V@\u0016X\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001¨\u0006¥\u0001"}, d2 = {"Lcom/youku/arch/v3/core/PageContainer;", "Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/IContainer;", "", "index", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "oldModule", "newModule", "Ltb/ur2;", "replaceModuleImpl", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "pool", "", "modules", "preLoadViewHolder", "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "getAdapters", "Lcom/youku/arch/v3/io/IRequest;", "request", "Lcom/youku/arch/v3/io/Callback;", WXBridgeManager.METHOD_CALLBACK, "", "", "", Constants.CONFIG, "createRequest", "", "loadMore", wj2.HAS_NEXT, "reload", "getModules", "Lcom/youku/arch/v3/core/Config;", "Lcom/youku/arch/v3/core/Node;", "createModule", "module", "addModule", "Lcom/youku/arch/v3/core/OnChildAttachStateChangeListener;", "listener", "notifyUiUpdate", "replaceModule", "removeModule", "updateModules", "nodes", "createModules", "preAsyncLoadMVP", "clearModules", "adapters", "addChildAdapters", "updateContentAdapter", "data", "initProperties", "type", "params", "onMessage", "onAdd", "onRemove", "updateChildIndex", "notifyFirstScreenRender", "Lcom/youku/arch/v3/core/IContext;", Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/IContext;", "getPageContext", "()Lcom/youku/arch/v3/core/IContext;", "setPageContext", "(Lcom/youku/arch/v3/core/IContext;)V", "node", "Lcom/youku/arch/v3/core/Node;", "getNode", "()Lcom/youku/arch/v3/core/Node;", "setNode", "(Lcom/youku/arch/v3/core/Node;)V", "Lcom/youku/arch/v3/loader/PageLoader;", "pageLoader", "Lcom/youku/arch/v3/loader/PageLoader;", "getPageLoader", "()Lcom/youku/arch/v3/loader/PageLoader;", "setPageLoader", "(Lcom/youku/arch/v3/loader/PageLoader;)V", "Lcom/youku/arch/v3/adapter/ContentAdapter;", "contentAdapter", "Lcom/youku/arch/v3/adapter/ContentAdapter;", "getContentAdapter", "()Lcom/youku/arch/v3/adapter/ContentAdapter;", "setContentAdapter", "(Lcom/youku/arch/v3/adapter/ContentAdapter;)V", "Lcom/youku/arch/v3/GenericFactory;", "adapterFactory", "Lcom/youku/arch/v3/GenericFactory;", "getAdapterFactory", "()Lcom/youku/arch/v3/GenericFactory;", "setAdapterFactory", "(Lcom/youku/arch/v3/GenericFactory;)V", "Ljava/util/List;", "moduleFactory$delegate", "Lkotlin/Lazy;", "getModuleFactory", "moduleFactory", "unmodifiableModules", "Lcom/youku/arch/v3/io/RequestBuilder;", "requestBuilder", "Lcom/youku/arch/v3/io/RequestBuilder;", "getRequestBuilder", "()Lcom/youku/arch/v3/io/RequestBuilder;", "setRequestBuilder", "(Lcom/youku/arch/v3/io/RequestBuilder;)V", "property", "Lcom/youku/arch/v3/core/ModelValue;", "getProperty", "()Lcom/youku/arch/v3/core/ModelValue;", "setProperty", "(Lcom/youku/arch/v3/core/ModelValue;)V", "Lcom/youku/arch/v3/ChildState;", "childState", "Lcom/youku/arch/v3/ChildState;", "Lcom/youku/arch/v3/core/ChildIndexUpdater;", "childIndexUpdater", "Lcom/youku/arch/v3/core/ChildIndexUpdater;", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", "Lcom/youku/arch/v3/event/EventHandler;", "getEventHandler", "()Lcom/youku/arch/v3/event/EventHandler;", "setEventHandler", "(Lcom/youku/arch/v3/event/EventHandler;)V", "Lcom/youku/arch/v3/core/parser/IParser;", "parser", "Lcom/youku/arch/v3/core/parser/IParser;", "getParser", "()Lcom/youku/arch/v3/core/parser/IParser;", "setParser", "(Lcom/youku/arch/v3/core/parser/IParser;)V", "refreshThreshold", "I", "getRefreshThreshold", "()I", "setRefreshThreshold", "(I)V", "getType", "setType", "getIndex", "setIndex", "Lcom/youku/arch/v3/core/Coordinate;", "coordinate", "Lcom/youku/arch/v3/core/Coordinate;", "getCoordinate", "()Lcom/youku/arch/v3/core/Coordinate;", "getChildAdapters", "()Ljava/util/List;", "childAdapters", "getCurrentModules", "currentModules", "getChildCount", "childCount", "isChildStateDirty", "()Z", "<init>", "(Lcom/youku/arch/v3/core/IContext;Lcom/youku/arch/v3/core/Node;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class PageContainer<VALUE extends ModelValue> implements IContainer<VALUE> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.PageContainer";
    @Nullable
    private GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> adapterFactory;
    @NotNull
    private List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> adapters = new ArrayList();
    @NotNull
    private ChildIndexUpdater<IModule<ModuleValue>> childIndexUpdater;
    @NotNull
    private ChildState childState;
    public ContentAdapter contentAdapter;
    @NotNull
    private final Coordinate coordinate;
    @Nullable
    private EventHandler eventHandler;
    private int index;
    @NotNull
    private final Lazy moduleFactory$delegate = b.b(new PageContainer$moduleFactory$2(this));
    @JvmField
    @NotNull
    public final List<IModule<ModuleValue>> modules;
    @Nullable
    private Node node;
    @NotNull
    private IContext pageContext;
    public PageLoader pageLoader;
    public IParser<Node, VALUE> parser;
    public VALUE property;
    private int refreshThreshold;
    @Nullable
    private RequestBuilder requestBuilder;
    private int type;
    @JvmField
    @NotNull
    public final List<IModule<ModuleValue>> unmodifiableModules;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/core/PageContainer$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    public PageContainer(@NotNull IContext iContext, @Nullable Node node2) {
        k21.i(iContext, Constants.PAGE_CONTEXT);
        this.pageContext = iContext;
        this.node = node2;
        ArrayList arrayList = new ArrayList();
        this.modules = arrayList;
        List<IModule<ModuleValue>> unmodifiableList = Collections.unmodifiableList(arrayList);
        k21.h(unmodifiableList, "unmodifiableList(modules)");
        this.unmodifiableModules = unmodifiableList;
        this.childState = new ChildState();
        this.childIndexUpdater = new ChildIndexUpdater<>();
        this.refreshThreshold = 7;
        this.coordinate = new Coordinate(-2, -2, -2);
    }

    private final List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> getAdapters(List<IModule<ModuleValue>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953855626")) {
            return (List) ipChange.ipc$dispatch("1953855626", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getAdapters());
        }
        List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> unmodifiableList = Collections.unmodifiableList(arrayList);
        k21.h(unmodifiableList, "unmodifiableList(adapters)");
        return unmodifiableList;
    }

    private final void preLoadViewHolder(RecyclerView.RecycledViewPool recycledViewPool, List<? extends IModule<ModuleValue>> list) {
        IModule iModule;
        int i;
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter;
        GenericFragment fragment;
        List<? extends IModule<ModuleValue>> list2 = list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636532384")) {
            ipChange.ipc$dispatch("-636532384", new Object[]{this, recycledViewPool, list2});
            return;
        }
        GenericRecycledViewPool genericRecycledViewPool = (GenericRecycledViewPool) recycledViewPool;
        int size = list.size();
        GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> adapterFactory2 = getAdapterFactory();
        ICreator<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> defaultCreator = adapterFactory2 == null ? null : adapterFactory2.getDefaultCreator();
        SparseArray sparseArray = new SparseArray();
        if (size > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                IModule iModule2 = (IModule) list2.get(i2);
                int size2 = iModule2.getComponents().size() - 1;
                if (size2 >= 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        IComponent<ComponentValue> iComponent = iModule2.getComponents().get(i4);
                        int size3 = iComponent.getItems().size() - 1;
                        if (size3 >= 0) {
                            int i6 = 0;
                            while (true) {
                                int i7 = i6 + 1;
                                IItem<ItemValue> iItem = iComponent.getItems().get(i6);
                                int type2 = iItem.getType();
                                int viewHolderMaxSize = genericRecycledViewPool.getViewHolderMaxSize(type2) - genericRecycledViewPool.getRecycledViewCount(type2);
                                if (viewHolderMaxSize > 0) {
                                    HashMap hashMap = new HashMap(8);
                                    iModule = iModule2;
                                    hashMap.put("data", iComponent.getItems());
                                    hashMap.put("render", null);
                                    hashMap.put("pageName", getPageContext().getPageName());
                                    hashMap.put(Constants.PAGE_CONTEXT, getPageContext());
                                    if (defaultCreator == null) {
                                        i = type2;
                                        vBaseAdapter = null;
                                    } else {
                                        i = type2;
                                        vBaseAdapter = defaultCreator.create(new Config<>(getPageContext(), i, hashMap, 0, false, 24, null));
                                    }
                                    if (vBaseAdapter != null) {
                                        vBaseAdapter.setData(iComponent.getItems());
                                        if ((vBaseAdapter instanceof VDefaultAdapter) && (fragment = getPageContext().getFragment()) != null) {
                                            RecyclerView recyclerView = fragment.getRecyclerView();
                                            k21.f(recyclerView);
                                            RecyclerView.ViewHolder createViewHolder = ((VDefaultAdapter) vBaseAdapter).createViewHolder(recyclerView, i);
                                            VBaseHolder vBaseHolder = (VBaseHolder) createViewHolder;
                                            vBaseHolder.resetData(iItem);
                                            k21.h(createViewHolder, "adapter.createViewHolder…                        }");
                                            if (sparseArray.indexOfKey(i) < 0) {
                                                sparseArray.put(i, new ArrayList());
                                            }
                                            if (((List) sparseArray.get(i)).size() < viewHolderMaxSize) {
                                                ((List) sparseArray.get(i)).add(vBaseHolder);
                                            }
                                        }
                                    }
                                } else {
                                    iModule = iModule2;
                                }
                                if (i7 > size3) {
                                    break;
                                }
                                i6 = i7;
                                iModule2 = iModule;
                            }
                        } else {
                            iModule = iModule2;
                        }
                        if (i5 > size2) {
                            break;
                        }
                        i4 = i5;
                        iModule2 = iModule;
                    }
                }
                if (i3 >= size) {
                    break;
                }
                list2 = list;
                i2 = i3;
            }
        }
        getPageContext().runOnUIThreadLocked(new PageContainer$preLoadViewHolder$2(sparseArray, genericRecycledViewPool));
    }

    /* access modifiers changed from: private */
    public final void replaceModuleImpl(int i, IModule<ModuleValue> iModule, IModule<ModuleValue> iModule2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326267837")) {
            ipChange.ipc$dispatch("326267837", new Object[]{this, Integer.valueOf(i), iModule, iModule2});
            return;
        }
        getPageContext().runOnLoaderThreadLocked(new PageContainer$replaceModuleImpl$1(this, iModule, iModule2, i));
    }

    @Override // com.youku.arch.v3.IContainer
    public void addChildAdapters(@NotNull List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821620458")) {
            ipChange.ipc$dispatch("-821620458", new Object[]{this, list});
            return;
        }
        k21.i(list, "adapters");
        getPageContext().runOnUIThreadLocked(new PageContainer$addChildAdapters$1(this, list));
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void addModule(int i, @NotNull IModule<ModuleValue> iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "166495791")) {
            ipChange.ipc$dispatch("166495791", new Object[]{this, Integer.valueOf(i), iModule});
            return;
        }
        k21.i(iModule, "module");
        addModule(i, iModule, (OnChildAttachStateChangeListener) null);
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void clearModules() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736633750")) {
            ipChange.ipc$dispatch("-736633750", new Object[]{this});
            return;
        }
        getPageContext().runOnLoaderThreadLocked(new PageContainer$clearModules$1(this));
    }

    @Override // com.youku.arch.v3.IModuleManager
    @NotNull
    public IModule<ModuleValue> createModule(@NotNull Config<Node> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "597585193")) {
            return (IModule) ipChange.ipc$dispatch("597585193", new Object[]{this, config});
        }
        k21.i(config, Constants.CONFIG);
        IModule<ModuleValue> create = getModuleFactory().create(config);
        k21.f(create);
        IModule<ModuleValue> iModule = create;
        iModule.initProperties(config.getData());
        iModule.setChildState(this.childState);
        iModule.setContainer(this);
        iModule.setIndex(config.getIndex());
        List<Node> children = iModule.getProperty().getChildren();
        if (children != null) {
            iModule.createComponents(children);
        }
        return iModule;
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void createModules(@NotNull List<Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "259145164")) {
            ipChange.ipc$dispatch("259145164", new Object[]{this, list});
            return;
        }
        k21.i(list, "nodes");
        getPageContext().runOnLoaderThreadLocked(new PageContainer$createModules$1(this, new Ref$IntRef(), list));
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public IRequest createRequest(@NotNull Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009489921")) {
            return (IRequest) ipChange.ipc$dispatch("1009489921", new Object[]{this, map});
        }
        k21.i(map, Constants.CONFIG);
        RequestBuilder requestBuilder2 = getRequestBuilder();
        if (requestBuilder2 == null) {
            return null;
        }
        return requestBuilder2.build(map);
    }

    @Override // com.youku.arch.v3.IContainer
    @Nullable
    public GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> getAdapterFactory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342433968")) {
            return (GenericFactory) ipChange.ipc$dispatch("-1342433968", new Object[]{this});
        }
        if (this.adapterFactory == null) {
            this.adapterFactory = PageUtil.INSTANCE.getDefaultAdapterFactory(getPageContext());
        }
        return this.adapterFactory;
    }

    @Override // com.youku.arch.v3.IContainer
    @NotNull
    public List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> getChildAdapters() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1736177619")) {
            return (List) ipChange.ipc$dispatch("-1736177619", new Object[]{this});
        }
        Util.throwIf(!k21.d(Looper.getMainLooper(), Looper.myLooper()));
        if (!this.childState.hasChanged()) {
            return this.adapters;
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.d(TAG, "getChildAdapters update");
        }
        return getAdapters(this.modules);
    }

    @Override // com.youku.arch.v3.DomainObject, com.youku.arch.v3.IModuleManager
    public int getChildCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1746430032")) {
            return this.modules.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-1746430032", new Object[]{this})).intValue();
    }

    @Override // com.youku.arch.v3.IContainer
    @NotNull
    public ContentAdapter getContentAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-83579160")) {
            return (ContentAdapter) ipChange.ipc$dispatch("-83579160", new Object[]{this});
        }
        ContentAdapter contentAdapter2 = this.contentAdapter;
        if (contentAdapter2 != null) {
            return contentAdapter2;
        }
        k21.A("contentAdapter");
        return null;
    }

    @Override // com.youku.arch.v3.Addressable
    @NotNull
    public Coordinate getCoordinate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "456938254")) {
            return this.coordinate;
        }
        return (Coordinate) ipChange.ipc$dispatch("456938254", new Object[]{this});
    }

    @Override // com.youku.arch.v3.IModuleManager
    @NotNull
    public List<IModule<ModuleValue>> getCurrentModules() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1405067227")) {
            return this.modules;
        }
        return (List) ipChange.ipc$dispatch("-1405067227", new Object[]{this});
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public EventHandler getEventHandler() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-908780813")) {
            return this.eventHandler;
        }
        return (EventHandler) ipChange.ipc$dispatch("-908780813", new Object[]{this});
    }

    @Override // com.youku.arch.v3.Addressable
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-328996357")) {
            return this.index;
        }
        return ((Integer) ipChange.ipc$dispatch("-328996357", new Object[]{this})).intValue();
    }

    @Override // com.youku.arch.v3.IModuleManager
    @NotNull
    public GenericFactory<IModule<ModuleValue>, Node> getModuleFactory() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1198521513")) {
            return (GenericFactory) this.moduleFactory$delegate.getValue();
        }
        return (GenericFactory) ipChange.ipc$dispatch("1198521513", new Object[]{this});
    }

    @Override // com.youku.arch.v3.IModuleManager
    @NotNull
    public List<IModule<ModuleValue>> getModules() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1501302796")) {
            return this.unmodifiableModules;
        }
        return (List) ipChange.ipc$dispatch("-1501302796", new Object[]{this});
    }

    @Nullable
    public final Node getNode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-842903942")) {
            return this.node;
        }
        return (Node) ipChange.ipc$dispatch("-842903942", new Object[]{this});
    }

    @Override // com.youku.arch.v3.DomainObject
    @NotNull
    public IContext getPageContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1079886142")) {
            return this.pageContext;
        }
        return (IContext) ipChange.ipc$dispatch("-1079886142", new Object[]{this});
    }

    @Override // com.youku.arch.v3.IContainer
    @NotNull
    public PageLoader getPageLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360109394")) {
            return (PageLoader) ipChange.ipc$dispatch("-1360109394", new Object[]{this});
        }
        PageLoader pageLoader2 = this.pageLoader;
        if (pageLoader2 != null) {
            return pageLoader2;
        }
        k21.A("pageLoader");
        return null;
    }

    @Override // com.youku.arch.v3.IContainer
    @NotNull
    public IParser<Node, VALUE> getParser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202129913")) {
            return (IParser) ipChange.ipc$dispatch("-202129913", new Object[]{this});
        }
        IParser<Node, VALUE> iParser = this.parser;
        if (iParser != null) {
            return iParser;
        }
        k21.A("parser");
        return null;
    }

    @Override // com.youku.arch.v3.IContainer
    @NotNull
    public VALUE getProperty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975716673")) {
            return (VALUE) ((ModelValue) ipChange.ipc$dispatch("1975716673", new Object[]{this}));
        }
        VALUE value = this.property;
        if (value != null) {
            return value;
        }
        k21.A("property");
        return null;
    }

    @Override // com.youku.arch.v3.IContainer
    public int getRefreshThreshold() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1634592723")) {
            return this.refreshThreshold;
        }
        return ((Integer) ipChange.ipc$dispatch("1634592723", new Object[]{this})).intValue();
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public RequestBuilder getRequestBuilder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1825209645")) {
            return this.requestBuilder;
        }
        return (RequestBuilder) ipChange.ipc$dispatch("1825209645", new Object[]{this});
    }

    @Override // com.youku.arch.v3.IContainer
    public int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-590290775")) {
            return this.type;
        }
        return ((Integer) ipChange.ipc$dispatch("-590290775", new Object[]{this})).intValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x007f  */
    @Override // com.youku.arch.v3.DomainObject
    public boolean hasNext() {
        Exception e;
        IModule<ModuleValue> iModule;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1189566819")) {
            return ((Boolean) ipChange.ipc$dispatch("-1189566819", new Object[]{this})).booleanValue();
        }
        try {
            boolean more = getProperty().getMore();
            if (more) {
                return more;
            }
            try {
                if (!this.modules.isEmpty()) {
                    List<IModule<ModuleValue>> list = this.modules;
                    iModule = list.get(list.size() - 1);
                } else {
                    iModule = null;
                }
                if (iModule != null && iModule.hasNext()) {
                    z = true;
                }
                if (!z && iModule != null && (!iModule.getComponents().isEmpty())) {
                    IComponent<ComponentValue> iComponent = iModule.getComponents().get(iModule.getComponents().size() - 1);
                    if (iComponent.hasNext()) {
                        return iComponent.hasNext();
                    }
                }
            } catch (Exception e2) {
                e = e2;
                z = more;
                if (AppInfoProviderProxy.isDebuggable()) {
                }
                return z;
            }
            return z;
        } catch (Exception e3) {
            e = e3;
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
            return z;
        }
    }

    @Override // com.youku.arch.v3.DomainObject
    public void initProperties(@NotNull Node node2) {
        ConfigManager.ParserConfig parserConfig;
        SparseArray<IParser<?, ?>> parsers;
        IParser<?, ?> iParser;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798105691")) {
            ipChange.ipc$dispatch("1798105691", new Object[]{this, node2});
            return;
        }
        k21.i(node2, "data");
        ConfigManager configManager = getPageContext().getConfigManager();
        IParser<Node, VALUE> iParser2 = null;
        if (!(configManager == null || (parserConfig = configManager.getParserConfig(0)) == null || (parsers = parserConfig.getParsers()) == null || (iParser = parsers.get(0)) == null)) {
            setParser(iParser);
            iParser2 = iParser;
        }
        if (iParser2 == null) {
            setParser(new DefaultModelParser());
        }
        setProperty(getParser().parseElement(node2));
        setType(node2.getType());
    }

    @Override // com.youku.arch.v3.IModuleManager
    public boolean isChildStateDirty() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1675490007")) {
            return this.childState.hasChanged();
        }
        return ((Boolean) ipChange.ipc$dispatch("1675490007", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.arch.v3.DomainObject
    public boolean loadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792308371")) {
            return ((Boolean) ipChange.ipc$dispatch("-1792308371", new Object[]{this})).booleanValue();
        }
        if (!this.modules.isEmpty()) {
            List<IModule<ModuleValue>> list = this.modules;
            if (list.get(list.size() - 1).loadMore()) {
                return true;
            }
        }
        PageLoader pageLoader2 = getPageLoader();
        if (pageLoader2.canLoadNextPage()) {
            pageLoader2.loadNextPage();
        }
        return false;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    @MainThread
    public void notifyFirstScreenRender() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503244771")) {
            ipChange.ipc$dispatch("-503244771", new Object[]{this});
            return;
        }
        getPageContext().runOnUIThreadLocked(new PageContainer$notifyFirstScreenRender$1(this));
    }

    @Override // com.youku.arch.v3.DomainObject
    public void onAdd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1813787356")) {
            ipChange.ipc$dispatch("-1813787356", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985990721")) {
            return ((Boolean) ipChange.ipc$dispatch("1985990721", new Object[]{this, str, map})).booleanValue();
        }
        k21.i(str, "type");
        if (getEventHandler() == null) {
            setEventHandler(new PageContainer$onMessage$1(this));
        }
        EventHandler eventHandler2 = getEventHandler();
        k21.f(eventHandler2);
        return eventHandler2.onMessage(str, map);
    }

    @Override // com.youku.arch.v3.DomainObject
    public void onRemove() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1267817343")) {
            ipChange.ipc$dispatch("-1267817343", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void preAsyncLoadMVP(@NotNull List<IModule<ModuleValue>> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-522604529")) {
            ipChange.ipc$dispatch("-522604529", new Object[]{this, list});
            return;
        }
        k21.i(list, "modules");
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            z = false;
        }
        if (!z) {
            throw new IllegalStateException("preAsyncLoadMVP should to be called in async thread".toString());
        } else if (!list.isEmpty()) {
            try {
                GenericFragment fragment = getPageContext().getFragment();
                RecyclerView.RecycledViewPool recycledViewPool = null;
                if (fragment != null) {
                    RecyclerView recyclerView = fragment.getRecyclerView();
                    if (recyclerView != null) {
                        recycledViewPool = recyclerView.getRecycledViewPool();
                    }
                }
                if (recycledViewPool != null) {
                    if (recycledViewPool instanceof GenericRecycledViewPool) {
                        PerformanceLogUtil performanceLogUtil = PerformanceLogUtil.INSTANCE;
                        performanceLogUtil.markStartPoint("preLoadMVP");
                        preLoadViewHolder(recycledViewPool, list);
                        performanceLogUtil.markEndPoint("preLoadMVP");
                    }
                }
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
            }
        }
    }

    @Override // com.youku.arch.v3.IContainer
    public void reload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-203765205")) {
            ipChange.ipc$dispatch("-203765205", new Object[]{this});
            return;
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.d(TAG, this + " reload");
        }
        getPageLoader().reload();
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void removeModule(@NotNull IModule<ModuleValue> iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479425435")) {
            ipChange.ipc$dispatch("-479425435", new Object[]{this, iModule});
            return;
        }
        k21.i(iModule, "module");
        removeModule(iModule, (OnChildAttachStateChangeListener) null);
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void replaceModule(int i, @NotNull IModule<ModuleValue> iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427436924")) {
            ipChange.ipc$dispatch("427436924", new Object[]{this, Integer.valueOf(i), iModule});
            return;
        }
        k21.i(iModule, "module");
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.v(TAG, k21.r("replaceModule at index of ", Integer.valueOf(i)));
        }
        if (i >= 0) {
            getPageContext().runOnLoaderThreadLocked(new PageContainer$replaceModule$1(this, i, iModule));
        }
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void replaceModule(int i, @NotNull IModule<ModuleValue> iModule, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "676077391")) {
            ipChange.ipc$dispatch("676077391", new Object[]{this, Integer.valueOf(i), iModule, onChildAttachStateChangeListener});
            return;
        }
        k21.i(iModule, "module");
    }

    @Override // com.youku.arch.v3.io.RequestClient
    public void request(@NotNull IRequest iRequest, @NotNull Callback callback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1471234200")) {
            ipChange.ipc$dispatch("1471234200", new Object[]{this, iRequest, callback});
            return;
        }
        k21.i(iRequest, "request");
        k21.i(callback, WXBridgeManager.METHOD_CALLBACK);
        getPageContext().runOnLoaderThread(new PageContainer$request$1(iRequest, callback));
    }

    @Override // com.youku.arch.v3.IContainer
    public void setAdapterFactory(@Nullable GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> genericFactory) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "315623032")) {
            ipChange.ipc$dispatch("315623032", new Object[]{this, genericFactory});
            return;
        }
        this.adapterFactory = genericFactory;
    }

    @Override // com.youku.arch.v3.IContainer
    public void setContentAdapter(@NotNull ContentAdapter contentAdapter2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198466950")) {
            ipChange.ipc$dispatch("-198466950", new Object[]{this, contentAdapter2});
            return;
        }
        k21.i(contentAdapter2, "<set-?>");
        this.contentAdapter = contentAdapter2;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setEventHandler(@Nullable EventHandler eventHandler2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "72540433")) {
            ipChange.ipc$dispatch("72540433", new Object[]{this, eventHandler2});
            return;
        }
        this.eventHandler = eventHandler2;
    }

    @Override // com.youku.arch.v3.Addressable
    public void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-59930001")) {
            ipChange.ipc$dispatch("-59930001", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.index = i;
    }

    public final void setNode(@Nullable Node node2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "85182906")) {
            ipChange.ipc$dispatch("85182906", new Object[]{this, node2});
            return;
        }
        this.node = node2;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setPageContext(@NotNull IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711309614")) {
            ipChange.ipc$dispatch("-1711309614", new Object[]{this, iContext});
            return;
        }
        k21.i(iContext, "<set-?>");
        this.pageContext = iContext;
    }

    @Override // com.youku.arch.v3.IContainer
    public void setPageLoader(@NotNull PageLoader pageLoader2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798572142")) {
            ipChange.ipc$dispatch("798572142", new Object[]{this, pageLoader2});
            return;
        }
        k21.i(pageLoader2, "<set-?>");
        this.pageLoader = pageLoader2;
    }

    @Override // com.youku.arch.v3.IContainer
    public void setParser(@NotNull IParser<Node, VALUE> iParser) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-515352351")) {
            ipChange.ipc$dispatch("-515352351", new Object[]{this, iParser});
            return;
        }
        k21.i(iParser, "<set-?>");
        this.parser = iParser;
    }

    public void setProperty(@NotNull VALUE value) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1715780537")) {
            ipChange.ipc$dispatch("-1715780537", new Object[]{this, value});
            return;
        }
        k21.i(value, "<set-?>");
        this.property = value;
    }

    @Override // com.youku.arch.v3.IContainer
    public void setRefreshThreshold(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1185068591")) {
            ipChange.ipc$dispatch("1185068591", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.refreshThreshold = i;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setRequestBuilder(@Nullable RequestBuilder requestBuilder2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-917924863")) {
            ipChange.ipc$dispatch("-917924863", new Object[]{this, requestBuilder2});
            return;
        }
        this.requestBuilder = requestBuilder2;
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1207694823")) {
            ipChange.ipc$dispatch("-1207694823", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.type = i;
    }

    @Override // com.youku.arch.v3.IContainer
    public void updateChildIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1917202299")) {
            ipChange.ipc$dispatch("-1917202299", new Object[]{this});
        } else if (this.childIndexUpdater.hasChanged() || isChildStateDirty()) {
            this.childIndexUpdater.updateChildIndex(this.modules);
        }
    }

    @Override // com.youku.arch.v3.IContainer
    public void updateContentAdapter() {
        RecyclerView recyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "429823493")) {
            ipChange.ipc$dispatch("429823493", new Object[]{this});
            return;
        }
        GenericFragment fragment = getPageContext().getFragment();
        if ((fragment == null || (recyclerView = fragment.getRecyclerView()) == null || !recyclerView.isComputingLayout()) ? false : true) {
            LogUtil.d("OneArch", "recyclerView isComputingLayout, ignore this refresh");
            return;
        }
        this.adapters = getChildAdapters();
        if (this.childState.hasChanged()) {
            this.childState.clearChanged();
        }
        Activity activity = getPageContext().getActivity();
        if (activity != null) {
            for (T t : this.adapters) {
                t.setContext(activity);
                VBaseAdapter innerAdapter = t.getInnerAdapter();
                if (innerAdapter != null) {
                    innerAdapter.setContext(activity);
                }
            }
        }
        if (this.contentAdapter != null) {
            getContentAdapter().setAdapters(this.adapters);
        }
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void updateModules(@NotNull List<Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2019065689")) {
            ipChange.ipc$dispatch("2019065689", new Object[]{this, list});
            return;
        }
        k21.i(list, "modules");
        getPageContext().runOnLoaderThreadLocked(new PageContainer$updateModules$1(list, this));
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void addModule(int i, @NotNull IModule<ModuleValue> iModule, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744973820")) {
            ipChange.ipc$dispatch("1744973820", new Object[]{this, Integer.valueOf(i), iModule, onChildAttachStateChangeListener});
            return;
        }
        k21.i(iModule, "module");
        getPageContext().runOnLoaderThreadLocked(new PageContainer$addModule$1(i, this, iModule, onChildAttachStateChangeListener));
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void removeModule(@NotNull IModule<ModuleValue> iModule, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2029008250")) {
            ipChange.ipc$dispatch("-2029008250", new Object[]{this, iModule, onChildAttachStateChangeListener});
            return;
        }
        k21.i(iModule, "module");
        getPageContext().runOnLoaderThreadLocked(new PageContainer$removeModule$1(this, iModule, onChildAttachStateChangeListener));
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void addModule(int i, @NotNull IModule<ModuleValue> iModule, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "866448005")) {
            ipChange.ipc$dispatch("866448005", new Object[]{this, Integer.valueOf(i), iModule, Boolean.valueOf(z)});
            return;
        }
        k21.i(iModule, "module");
        addModule(i, iModule, new PageContainer$addModule$2(z, this, i, iModule));
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void removeModule(@NotNull IModule<ModuleValue> iModule, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1977240817")) {
            ipChange.ipc$dispatch("-1977240817", new Object[]{this, iModule, Boolean.valueOf(z)});
            return;
        }
        k21.i(iModule, "module");
        removeModule(iModule, new PageContainer$removeModule$2(this, z, iModule));
    }
}
