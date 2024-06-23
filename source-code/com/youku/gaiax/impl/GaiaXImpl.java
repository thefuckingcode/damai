package com.youku.gaiax.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.taobao.weex.common.Constants;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.IExperiment;
import com.youku.gaiax.IGaiaXApi;
import com.youku.gaiax.IStable;
import com.youku.gaiax.LoadType;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.impl.GaiaXContext;
import com.youku.gaiax.impl.js.GaiaXJSDelegate;
import com.youku.gaiax.impl.utils.ExceptionUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.wq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010(R\u0018\u0010\u001f\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010*¨\u0006-"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXImpl;", "Lcom/youku/gaiax/IGaiaXApi;", "Lcom/youku/gaiax/impl/GaiaXContext;", "gaiaXContext", "Ltb/ur2;", "onViewPrepareRefresh", "Lcom/youku/gaiax/GaiaX$Params;", "params", "onViewReload", "onViewPrepareCreate", "onPageVisible", "onPageInvisible", "onViewVisible", "onViewInvisible", "onViewDispatcher", "onViewDestroy", "onViewDestroyByReload", "onViewCreateSync", "onViewRefreshSync", "onViewCreateAsync", "onViewRefreshAsync", "onViewRefreshDispatcher", "Landroid/view/View;", "gxView", "onViewCreateDispatcher", "Landroid/view/ViewGroup;", "container", "fixContainerSize", "Lcom/youku/gaiax/IExperiment;", "experiment", "Lcom/youku/gaiax/IStable;", Constants.Name.STABLE, "visibleView", "invisibleView", "visiblePage", "invisiblePage", "reloadView", "bindView", "unbindView", "Lcom/youku/gaiax/impl/GaiaXExperimentApiImpl;", "Lcom/youku/gaiax/impl/GaiaXExperimentApiImpl;", "Lcom/youku/gaiax/impl/GaiaXStableApiImpl;", "Lcom/youku/gaiax/impl/GaiaXStableApiImpl;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXImpl implements IGaiaXApi {
    @Nullable
    private GaiaXExperimentApiImpl experiment;
    @Nullable
    private GaiaXStableApiImpl stable;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.SYNC_NORMAL.ordinal()] = 1;
            iArr[LoadType.ASYNC_NORMAL.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void fixContainerSize(ViewGroup viewGroup, View view) {
        ViewGroup.LayoutParams layoutParams = viewGroup == null ? null : viewGroup.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = view.getLayoutParams().width;
        }
    }

    private final void onPageInvisible(GaiaX.Params params) {
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("onPageInvisible ", containerContext));
        }
        if (containerContext != null) {
            containerContext.setLifeStatus(2);
            GaiaXJSDelegate.INSTANCE.onHiddenComponent(containerContext);
            GaiaXContainerHelper.INSTANCE.notifyOnPageInvisible(containerContext);
        }
    }

    private final void onPageVisible(GaiaX.Params params) {
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("onPageVisible ", containerContext));
        }
        if (containerContext != null) {
            containerContext.setLifeStatus(1);
            GaiaXJSDelegate.INSTANCE.onShowComponent(containerContext);
            GaiaXContainerHelper.INSTANCE.notifyOnPageVisible(containerContext);
        }
    }

    private final void onViewCreateAsync(GaiaXContext gaiaXContext) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("onViewCreateAsync() called with: context = ", gaiaXContext));
        }
        GaiaXMonitor.INSTANCE.onCreateA(gaiaXContext);
        gaiaXContext.setTypeStatus(1);
        gaiaXContext.workerTask(new GaiaXImpl$onViewCreateAsync$1(gaiaXContext, this));
    }

    /* access modifiers changed from: private */
    public final void onViewCreateDispatcher(GaiaXContext gaiaXContext, View view) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", "onViewCreateDispatcher() called with: gaiaXContext = " + gaiaXContext + ", gxView = " + view);
        }
        gaiaXContext.setRootView(view);
        gaiaXContext.setTypeStatus(2);
        gaiaXContext.setLifeStatus(4);
        View container = gaiaXContext.getParams().getContainer();
        ViewGroup viewGroup = container instanceof ViewGroup ? (ViewGroup) container : null;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
        GaiaXJSDelegate gaiaXJSDelegate = GaiaXJSDelegate.INSTANCE;
        gaiaXJSDelegate.registerComponent(gaiaXContext);
        gaiaXJSDelegate.onReadyComponent(gaiaXContext);
        int indexPosition$GaiaX_Android = gaiaXContext.getParams().getIndexPosition$GaiaX_Android();
        if (indexPosition$GaiaX_Android != -1) {
            fixContainerSize(viewGroup, view);
            GaiaX.IScrollItemStatusDelegate scrollItemStatusDelegate = gaiaXContext.getParams().getScrollItemStatusDelegate();
            if (scrollItemStatusDelegate != null) {
                scrollItemStatusDelegate.onViewInjected(gaiaXContext.getParams(), view, indexPosition$GaiaX_Android);
            }
        } else {
            GaiaX.IStatusDelegate statusDelegate = gaiaXContext.getParams().getStatusDelegate();
            if (statusDelegate != null) {
                statusDelegate.onViewInjected(gaiaXContext.getParams(), view);
            }
        }
        if (viewGroup != null) {
            viewGroup.setMinimumHeight(0);
        }
    }

    private final void onViewCreateSync(GaiaXContext gaiaXContext) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("onViewCreateSync() called with: context = ", gaiaXContext));
        }
        GaiaXMonitor gaiaXMonitor = GaiaXMonitor.INSTANCE;
        gaiaXMonitor.onCreateA(gaiaXContext);
        Context context = gaiaXContext.getParams().getContext();
        if (context != null) {
            gaiaXContext.setTypeStatus(1);
            GXTemplateEngine.h hVar = new GXTemplateEngine.h(context, gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId());
            hVar.g(gaiaXContext.getParams().getForceLocalTemplate());
            GXTemplateEngine.e eVar = new GXTemplateEngine.e(gaiaXContext.getParams().getViewPort().b(), gaiaXContext.getParams().getViewPort().a());
            JSONObject data = gaiaXContext.getParams().getData();
            if (data == null) {
                data = new JSONObject();
            }
            GXTemplateEngine.g gVar = new GXTemplateEngine.g(data);
            gVar.j(gaiaXContext.getParams());
            gVar.g(gaiaXContext.getGxDataListener());
            gVar.i(gaiaXContext.getParams().getScrollPosition$GaiaX_Android());
            gVar.h(gaiaXContext.getGxEventListener());
            gVar.k(gaiaXContext.getGxTrackListener());
            gaiaXMonitor.onStep1A(gaiaXContext);
            GXTemplateEngine.a aVar = GXTemplateEngine.Companion;
            wq0 i = aVar.a().i(hVar, eVar, gaiaXContext.getParams().getChildVisualNestTemplateNode());
            if (i != null) {
                gaiaXContext.setGXTemplateContext(i);
                gaiaXMonitor.onStep1B(gaiaXContext);
                gaiaXMonitor.onStep2A(gaiaXContext);
                View j = aVar.a().j(i);
                if (j != null) {
                    gaiaXMonitor.onStep2B(gaiaXContext);
                    gaiaXMonitor.onStep3A(gaiaXContext);
                    aVar.a().d(j, gVar, eVar);
                    gaiaXMonitor.onStep3B(gaiaXContext);
                    gaiaXMonitor.onStep4A(gaiaXContext);
                    aVar.a().e(j, gVar, eVar);
                    gaiaXMonitor.onStep4B(gaiaXContext);
                    onViewCreateDispatcher(gaiaXContext, j);
                    gaiaXMonitor.onCreateBSync(gaiaXContext);
                    return;
                }
                throw new IllegalArgumentException("GXView create fail");
            }
            throw new IllegalArgumentException("GXTemplateContext create fail");
        }
        throw new IllegalArgumentException("context null");
    }

    private final void onViewDestroy(GaiaX.Params params) {
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        if (containerContext != null) {
            String templateId = containerContext.getParams().getTemplateId();
            Log log = Log.INSTANCE;
            if (log.isLog()) {
                log.d("[GaiaX]", "onViewDestroy 模板ID = [" + params.getTemplateId() + "] 已存储模板ID = [" + templateId + "] 模板绑定类型 = [" + containerContext.getTypeStatus() + "] 视口 = " + params.getViewPort() + " 加载类型 = " + params.getMode());
            }
            GaiaXJSDelegate gaiaXJSDelegate = GaiaXJSDelegate.INSTANCE;
            gaiaXJSDelegate.onDestroyComponent(containerContext);
            gaiaXJSDelegate.unregisterComponent(containerContext);
            containerContext.releaseCanAsync();
        }
    }

    private final void onViewDestroyByReload(GaiaX.Params params) {
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        if (containerContext != null) {
            String templateId = containerContext.getParams().getTemplateId();
            Log log = Log.INSTANCE;
            if (log.isLog()) {
                log.d("[GaiaX]", "onViewDestroyByReload 模板ID = [" + params.getTemplateId() + "] 已存储模板ID = [" + templateId + "] 模板绑定类型 = [" + containerContext.getTypeStatus() + "] 视口 = " + params.getViewPort() + " 加载类型 = " + params.getMode());
            }
            GaiaXJSDelegate gaiaXJSDelegate = GaiaXJSDelegate.INSTANCE;
            gaiaXJSDelegate.onDestroyComponent(containerContext);
            gaiaXJSDelegate.unregisterComponent(containerContext);
            containerContext.releaseCanAsync();
        }
    }

    private final void onViewDispatcher(GaiaX.Params params) {
        IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
        if (features != null) {
            features.sendRibutMessage(params.getTemplateId(), params.getData());
        }
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("onViewDispatcher params.data = ", params.getData()));
            JSONObject data = params.getData();
            log.d("[GaiaX]", k21.r("onViewDispatcher params.data = ", data == null ? null : Integer.valueOf(data.hashCode())));
        }
        GaiaXContext.Companion companion = GaiaXContext.Companion;
        GaiaXContext initContext = companion.initContext(params);
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("onViewDispatcher gaiaXContext = ", initContext));
        }
        boolean isInvalidContainer = initContext.isInvalidContainer();
        boolean isInvalidStatus = initContext.isInvalidStatus();
        boolean isInvalidGXRootView = initContext.isInvalidGXRootView();
        if (isInvalidContainer || isInvalidStatus || isInvalidGXRootView) {
            if (isInvalidContainer) {
                ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, new IllegalArgumentException(k21.r("渲染状态异常 onViewDispatcher invalidContainer ", params)));
            }
            if (isInvalidStatus) {
                ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, new IllegalArgumentException(k21.r("渲染状态异常 onViewDispatcher invalidStatus ", params)));
            }
            if (isInvalidGXRootView) {
                ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, new IllegalArgumentException(k21.r("渲染状态异常 onViewDispatcher invalidGXRootView ", params)));
            }
            onViewDestroyByReload(params);
            initContext = companion.forceInitContext(params);
        }
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("onViewDispatcher gaiaXContext = ", initContext));
        }
        View rootView = initContext.getRootView();
        int typeStatus = initContext.getTypeStatus();
        if (typeStatus == 0 && rootView == null) {
            if (log.isLog()) {
                log.d("[GaiaX]", "onViewDispatcher 状态1：创建UI");
            }
            onViewPrepareCreate(initContext);
        } else if ((2 == typeStatus || 4 == typeStatus) && rootView != null) {
            if (log.isLog()) {
                log.d("[GaiaX]", "onViewDispatcher 状态2：重建UI");
            }
            onViewPrepareRefresh(initContext);
        } else if (1 == typeStatus && rootView == null) {
            if (log.isLog()) {
                log.d("[GaiaX]", "onViewDispatcher 状态3：创建UI中");
            }
            onViewPrepareCreate(initContext);
        } else if (3 != typeStatus || rootView == null) {
            if (log.isLog()) {
                log.d("[GaiaX]", "onViewDispatcher 状态5：异常");
            }
            throw new IllegalArgumentException("渲染状态异常 onViewDispatcher status = " + typeStatus + " rootView = " + rootView);
        } else {
            if (log.isLog()) {
                log.d("[GaiaX]", "onViewDispatcher 状态4：更新UI中");
            }
            onViewPrepareRefresh(initContext);
        }
    }

    private final void onViewInvisible(GaiaX.Params params) {
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("onViewInvisible ", containerContext));
        }
        if (containerContext != null) {
            containerContext.setLifeStatus(2);
            GaiaXJSDelegate.INSTANCE.onHiddenComponent(containerContext);
        }
    }

    private final void onViewPrepareCreate(GaiaXContext gaiaXContext) {
        int i = WhenMappings.$EnumSwitchMapping$0[gaiaXContext.getParams().getMode().ordinal()];
        if (i == 1) {
            onViewCreateSync(gaiaXContext);
        } else if (i == 2) {
            onViewCreateAsync(gaiaXContext);
        }
    }

    private final void onViewPrepareRefresh(GaiaXContext gaiaXContext) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("onViewPrepareRefresh() called with: gaiaXContext = ", gaiaXContext));
        }
        if (gaiaXContext.getJsStatus() == 10 || gaiaXContext.isChanged()) {
            gaiaXContext.setJsStatus(0);
            onViewReload(gaiaXContext.getParams());
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[gaiaXContext.getParams().getMode().ordinal()];
        if (i == 1) {
            onViewRefreshSync(gaiaXContext);
        } else if (i == 2) {
            onViewRefreshAsync(gaiaXContext);
        }
    }

    private final void onViewRefreshAsync(GaiaXContext gaiaXContext) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("refreshViewAsync() called with: context = ", gaiaXContext));
        }
        GaiaXMonitor.INSTANCE.onRefreshA(gaiaXContext);
        gaiaXContext.setTypeStatus(3);
        gaiaXContext.workerTask(new GaiaXImpl$onViewRefreshAsync$1(gaiaXContext, this));
    }

    /* access modifiers changed from: private */
    public final void onViewRefreshDispatcher(GaiaXContext gaiaXContext) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("onViewRefreshDispatcher() called with: gaiaXContext = ", gaiaXContext));
        }
        View rootView = gaiaXContext.getRootView();
        if (rootView != null) {
            gaiaXContext.setTypeStatus(4);
            GaiaXJSDelegate.INSTANCE.onReuseComponent(gaiaXContext);
            View container = gaiaXContext.getParams().getContainer();
            ViewGroup viewGroup = container instanceof ViewGroup ? (ViewGroup) container : null;
            int indexPosition$GaiaX_Android = gaiaXContext.getParams().getIndexPosition$GaiaX_Android();
            if (indexPosition$GaiaX_Android != -1) {
                fixContainerSize(viewGroup, rootView);
                GaiaX.IScrollItemStatusDelegate scrollItemStatusDelegate = gaiaXContext.getParams().getScrollItemStatusDelegate();
                if (scrollItemStatusDelegate != null) {
                    scrollItemStatusDelegate.onViewUpdated(gaiaXContext.getParams(), rootView, indexPosition$GaiaX_Android);
                    return;
                }
                return;
            }
            GaiaX.IStatusDelegate statusDelegate = gaiaXContext.getParams().getStatusDelegate();
            if (statusDelegate != null) {
                statusDelegate.onViewUpdated(gaiaXContext.getParams(), rootView);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(k21.r("rootView null, gaiaXContext = ", gaiaXContext));
    }

    private final void onViewRefreshSync(GaiaXContext gaiaXContext) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("refreshViewSyncNormal() called with: context = ", gaiaXContext));
        }
        GaiaXMonitor gaiaXMonitor = GaiaXMonitor.INSTANCE;
        gaiaXMonitor.onRefreshA(gaiaXContext);
        gaiaXContext.setTypeStatus(3);
        View rootView = gaiaXContext.getRootView();
        if (rootView != null) {
            GXTemplateEngine.e eVar = new GXTemplateEngine.e(gaiaXContext.getParams().getViewPort().b(), gaiaXContext.getParams().getViewPort().a());
            JSONObject data = gaiaXContext.getParams().getData();
            if (data == null) {
                data = new JSONObject();
            }
            GXTemplateEngine.g gVar = new GXTemplateEngine.g(data);
            gVar.j(gaiaXContext.getParams());
            gVar.g(gaiaXContext.getGxDataListener());
            gVar.i(gaiaXContext.getParams().getScrollPosition$GaiaX_Android());
            gVar.h(gaiaXContext.getGxEventListener());
            gVar.k(gaiaXContext.getGxTrackListener());
            gaiaXMonitor.onStep3A(gaiaXContext);
            GXTemplateEngine.a aVar = GXTemplateEngine.Companion;
            aVar.a().d(rootView, gVar, eVar);
            gaiaXMonitor.onStep3B(gaiaXContext);
            gaiaXMonitor.onStep4A(gaiaXContext);
            aVar.a().e(rootView, gVar, eVar);
            gaiaXMonitor.onStep4B(gaiaXContext);
            onViewRefreshDispatcher(gaiaXContext);
            gaiaXMonitor.onRefreshBSync(gaiaXContext);
            return;
        }
        throw new IllegalArgumentException(k21.r("rootView null, gaiaXContext = ", gaiaXContext));
    }

    private final void onViewReload(GaiaX.Params params) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("onViewReload() called with: params = ", params));
        }
        onViewInvisible(params);
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        if (containerContext != null) {
            containerContext.setTypeStatus(5);
        }
        onViewDispatcher(params);
    }

    private final void onViewVisible(GaiaX.Params params) {
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("onViewVisible ", containerContext));
        }
        if (containerContext != null) {
            containerContext.setLifeStatus(1);
            GaiaXJSDelegate.INSTANCE.onShowComponent(containerContext);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void bindView(@NotNull GaiaX.Params params) {
        k21.i(params, "params");
        try {
            if (params.isReleased$GaiaX_Android()) {
                ExceptionUtils.INSTANCE.throwParamsReleaseAlarm();
            } else {
                onViewDispatcher(params);
            }
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    @NotNull
    public IExperiment experiment() {
        if (this.experiment == null) {
            this.experiment = new GaiaXExperimentApiImpl();
        }
        GaiaXExperimentApiImpl gaiaXExperimentApiImpl = this.experiment;
        if (gaiaXExperimentApiImpl != null) {
            return gaiaXExperimentApiImpl;
        }
        throw new IllegalArgumentException("GaiaXExperimentApiImpl not exist");
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void invisiblePage(@NotNull GaiaX.Params params) {
        k21.i(params, "params");
        try {
            onPageInvisible(params);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void invisibleView(@NotNull GaiaX.Params params) {
        k21.i(params, "params");
        try {
            onViewInvisible(params);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void reloadView(@NotNull GaiaX.Params params) {
        k21.i(params, "params");
        try {
            GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
            if (containerContext != null) {
                if (containerContext.getLifeStatus() == 1 || containerContext.getLifeStatus() == 4) {
                    onViewReload(params);
                }
            }
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    @NotNull
    public IStable stable() {
        if (this.stable == null) {
            this.stable = new GaiaXStableApiImpl();
        }
        GaiaXStableApiImpl gaiaXStableApiImpl = this.stable;
        if (gaiaXStableApiImpl != null) {
            return gaiaXStableApiImpl;
        }
        throw new IllegalArgumentException("GaiaXStableApiImpl not exist");
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void unbindView(@NotNull GaiaX.Params params) {
        k21.i(params, "params");
        try {
            onViewDestroy(params);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void visiblePage(@NotNull GaiaX.Params params) {
        k21.i(params, "params");
        try {
            onPageVisible(params);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void visibleView(@NotNull GaiaX.Params params) {
        k21.i(params, "params");
        try {
            onViewVisible(params);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }
}
