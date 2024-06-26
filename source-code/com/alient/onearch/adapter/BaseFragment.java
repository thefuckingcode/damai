package com.alient.onearch.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.responsive.page.IResponsivePage;
import com.alibaba.pictures.ut.ClickCat;
import com.alibaba.pictures.ut.DogCat;
import com.alibaba.pictures.ut.IUTPageOperation;
import com.alibaba.pictures.ut.MovieShowUTHelper;
import com.alient.gaiax.container.component.GaiaxComponentCreator;
import com.alient.gaiax.container.config.GaiaxViewTypeConfigCreator;
import com.alient.onearch.adapter.component.footer.ComponentFooterDelegateManager;
import com.alient.onearch.adapter.delegate.OneArchAlarmDelegate;
import com.alient.onearch.adapter.event.IEventFeature;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.monitor.CMSRenderMonitorPoint;
import com.alient.onearch.adapter.monitor.MonitorConstant;
import com.alient.onearch.adapter.parser.component.BasicComponentParser;
import com.alient.onearch.adapter.parser.item.BasicItemParser;
import com.alient.onearch.adapter.parser.model.BasicModelParser;
import com.alient.onearch.adapter.parser.module.BasicModuleParser;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.onearch.adapter.util.RecyclerViewUtil;
import com.alient.oneservice.ut.TrackInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.weex.bridge.WXBridgeManager;
import com.uc.webview.export.media.MessageID;
import com.ut.mini.UTAnalytics;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.core.TypeRange;
import com.youku.arch.v3.creator.ComponentCreatorManager;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.FragmentEvent;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.IDelegate;
import com.youku.arch.v3.page.RecycleViewSettings;
import com.youku.arch.v3.page.state.IStateView;
import com.youku.arch.v3.page.state.State;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g12;
import tb.k21;
import tb.m40;
import tb.oq2;
import tb.uq2;
import tb.ur2;
import tb.w02;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 Ç\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004Ç\u0001È\u0001B\t¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\u0012\u0010\u001e\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0016J\u0010\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\fH\u0016J\u0010\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u001cH\u0016J\u0012\u0010*\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020+H\u0016J\"\u00100\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020+H\u0016J*\u00108\u001a\u00020\f2\f\u00103\u001a\b\u0012\u0004\u0012\u000202012\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060504H\u0014J*\u0010:\u001a\u00020\f2\f\u00109\u001a\b\u0012\u0004\u0012\u000206052\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060504H\u0014J\u000e\u0010;\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010<\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010>\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0016J\b\u0010?\u001a\u00020+H\u0016J\u0010\u0010C\u001a\u00020B2\u0006\u0010A\u001a\u00020@H\u0014J\"\u0010H\u001a\u0004\u0018\u00010G2\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020E\u0018\u00010DH$J\b\u0010I\u001a\u00020\fH\u0014J\b\u0010J\u001a\u00020\fH\u0014J\u0010\u0010M\u001a\u00020L2\u0006\u0010K\u001a\u00020BH\u0016J\b\u0010N\u001a\u00020\fH\u0014J&\u0010P\u001a\u00020\f2\u0006\u0010O\u001a\u00020\n2\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020E\u0018\u00010DH\u0016J&\u0010Q\u001a\u00020\f2\u0006\u0010O\u001a\u00020\n2\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020E\u0018\u00010DH\u0016J&\u0010R\u001a\u00020\f2\u0006\u0010O\u001a\u00020\n2\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020E\u0018\u00010DH\u0016J,\u0010U\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010S\u0018\u0001042\u0014\u0010T\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010S\u0018\u000104H\u0016J\b\u0010V\u001a\u0004\u0018\u00010\nJ\b\u0010W\u001a\u0004\u0018\u00010\nJ/\u0010[\u001a\u00020\f2\b\u0010X\u001a\u0004\u0018\u00010\n2\u0016\u0010Z\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0Y\"\u0004\u0018\u00010\n¢\u0006\u0004\b[\u0010\\J\u0012\u0010^\u001a\u0004\u0018\u00010\n2\b\u0010]\u001a\u0004\u0018\u00010\nJ\u000e\u0010`\u001a\u00020\f2\u0006\u0010_\u001a\u00020+J\u0010\u0010b\u001a\u00020\f2\b\u0010a\u001a\u0004\u0018\u00010\nJ\u0010\u0010e\u001a\u00020\f2\b\u0010d\u001a\u0004\u0018\u00010cJ\u0010\u0010g\u001a\u00020\f2\b\u0010f\u001a\u0004\u0018\u00010\nJ\u0010\u0010j\u001a\u00020\f2\b\u0010i\u001a\u0004\u0018\u00010hJ\b\u0010k\u001a\u00020+H\u0016J\n\u0010l\u001a\u0004\u0018\u00010hH\u0016J\u0016\u0010n\u001a\u00020\f2\u0006\u0010]\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nJ\u0018\u0010r\u001a\u00020\f2\u0006\u0010o\u001a\u00020\u00182\b\b\u0002\u0010q\u001a\u00020pJ\u001c\u0010w\u001a\u00020\u00182\u0006\u0010t\u001a\u00020s2\n\u0010v\u001a\u0006\u0012\u0002\b\u00030uH\u0016J\b\u0010x\u001a\u00020\fH\u0016J\u0012\u0010|\u001a\u0004\u0018\u00010{2\u0006\u0010z\u001a\u00020yH\u0016J\u0012\u0010\u001a\u00020\f2\b\u0010~\u001a\u0004\u0018\u00010}H\u0014J\t\u0010\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u0001\u001a\u00020\f2\b\u0010\u0001\u001a\u00030\u0001H\u0007J\u0011\u0010\u0001\u001a\u00020\f2\b\u0010\u0001\u001a\u00030\u0001J\t\u0010\u0001\u001a\u00020\fH\u0016J\u0016\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010d\u001a\u0004\u0018\u00010cH\u0016J\u0016\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010d\u001a\u0004\u0018\u00010cH\u0016J'\u0010\u0001\u001a\u00020\f2\b\u0010d\u001a\u0004\u0018\u00010c2\t\u0010\u0001\u001a\u0004\u0018\u00010\n2\u0007\u0010\u0001\u001a\u00020+H\u0016J\u0013\u0010\u0001\u001a\u00020\f2\b\u0010d\u001a\u0004\u0018\u00010cH\u0016J5\u0010\u0001\u001a\u00020\f2\b\u0010d\u001a\u0004\u0018\u00010c2\t\u0010\u0001\u001a\u0004\u0018\u00010\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\n2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020\f2\b\u0010d\u001a\u0004\u0018\u00010cH\u0016J\u0012\u0010\u0001\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020\nH\u0016J\u0013\u0010\u0001\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001e\u0010\u0001\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\t\u0010\u0001\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010\u0001\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0007\u0010\u0001\u001a\u00020\u0018H\u0016J'\u0010\u0001\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0007\u0010\u0001\u001a\u00020\u00182\t\u0010\u0001\u001a\u0004\u0018\u00010\u001cH\u0016R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010 \u0001R+\u0010¡\u0001\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R\u001f\u0010¨\u0001\u001a\u00030§\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001R+\u0010¬\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010­\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R+\u0010²\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010­\u0001\u001a\u0006\b³\u0001\u0010¯\u0001\"\u0006\b´\u0001\u0010±\u0001R,\u0010µ\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R,\u0010»\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010¶\u0001\u001a\u0006\b¼\u0001\u0010¸\u0001\"\u0006\b½\u0001\u0010º\u0001R*\u0010¿\u0001\u001a\u00030¾\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001¨\u0006É\u0001"}, d2 = {"Lcom/alient/onearch/adapter/BaseFragment;", "Lcom/youku/arch/v3/page/GenericFragment;", "Lcom/alient/onearch/adapter/event/IEventFeature;", "Lcom/alibaba/pictures/responsive/page/IResponsivePage;", "Lcom/alibaba/pictures/ut/IUTPageOperation;", "Lcom/alient/onearch/adapter/state/StateViewManager$IStateFeature;", "Lcom/alient/onearch/adapter/PageInfoBean;", "pageInfo", "Lcom/alient/onearch/adapter/PageRefreshCallBack;", "callBack", "", "pageSection", "Ltb/ur2;", "refreshBasePageInfo", "pageName", "Landroid/view/ViewGroup;", "parent", "Lcom/youku/arch/v3/page/state/State;", "state", "Lcom/youku/arch/v3/page/state/IStateView;", "createStateView", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "beforeStartActivity", "", "getLayoutResId", "getRecyclerViewResId", "getRefreshLayoutResId", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/view/View;", "view", "onViewCreated", "onResume", MessageID.onPause, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onDestroy", "outState", "onSaveInstanceState", "onViewStateRestored", "", "isVisible", "onFragmentVisibleChange", "responsiveLayoutState", "responsiveLayoutStateChanged", "onResponsiveLayout", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "module", "", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "updatedComponents", "traverseModule", "component", "traversComponent", "refreshTopBasePageInfo", "refreshBottomBasePageInfo", "spmB", "updateUTPageNameFromRemote", "isUpdatePageNameFromRemote", "Lcom/youku/arch/v3/core/PageContext;", Constants.PAGE_CONTEXT, "Lcom/alient/onearch/adapter/GenericPageContainer;", "initPageContainer", "", "", "params", "Lcom/youku/arch/v3/io/RequestBuilder;", "createRequestBuilder", "initConfigManager", "initPageLoader", "container", "Lcom/alient/onearch/adapter/loader/v2/GenericPagerLoader;", "createPageLoader", "initPageStateManager", "type", "fireComponentEvent", "firePageEvent", "fireGlobalEvent", "Lcom/youku/arch/v3/page/IDelegate;", "delegateList", "wrapperDelegates", "getPageSPM", "getUTPageName", "controlName", "", "kvs", "onUTButtonClick", "(Ljava/lang/String;[Ljava/lang/String;)V", "key", "querySavedPageProperty", "enable", "setUTPageEnable", "spmPageName", "setUTPageName", "Landroid/app/Activity;", "activity", "startExpoTrack", "spm", "updateSPM", "Ljava/util/Properties;", "properties", "updateUTPageProperties", "enableUTReport", "getUTPageData", "value", "addUTPageParams", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "", "millisecondsPerInch", "scrollToComponent", "Lcom/alibaba/android/vlayout/DelegateAdapter;", "delegateAdapter", "Lcom/alibaba/android/vlayout/DelegateAdapter$Adapter;", "innerAdapter", "getRealPositionForAdapter", "initRecycleViewSettings", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/alibaba/android/vlayout/VirtualLayoutManager;", "createLayoutManager", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "addRecyclerViewFeature", "initComponentFooterDelegate", "Lcom/youku/kubus/Event;", "event", "onFragmentLifecycle", "Lcom/youku/arch/v3/core/Node;", "pageNode", "updateABBucket", "updatePvStatics", "Lcom/scwang/smartrefresh/layout/api/RefreshInternal;", "createLoadingHeaderView", "createLoadingFooterView", "msg", "canCancel", "showLoadingDialog", "hideLoadingDialog", "code", "Lcom/alient/onearch/adapter/state/StateViewManager$IStateViewListener;", "listener", "showErrorView", "hideErrorView", LoginConstants.SHOW_TOAST, "startActivity", WXBridgeManager.OPTIONS, "requestCode", "startActivityForResult", "Landroid/os/Handler;", "responsiveHandler", "Landroid/os/Handler;", "isDisplayed", "Z", "Lcom/alibaba/pictures/ut/MovieShowUTHelper;", "utHelper", "Lcom/alibaba/pictures/ut/MovieShowUTHelper;", "utPageName", "Ljava/lang/String;", "getUtPageName", "()Ljava/lang/String;", "setUtPageName", "(Ljava/lang/String;)V", "Lcom/alient/oneservice/ut/TrackInfo;", "trackInfo", "Lcom/alient/oneservice/ut/TrackInfo;", "getTrackInfo", "()Lcom/alient/oneservice/ut/TrackInfo;", "topBasePageInfo", "Lcom/alient/onearch/adapter/PageInfoBean;", "getTopBasePageInfo", "()Lcom/alient/onearch/adapter/PageInfoBean;", "setTopBasePageInfo", "(Lcom/alient/onearch/adapter/PageInfoBean;)V", "bottomBasePageInfo", "getBottomBasePageInfo", "setBottomBasePageInfo", "refreshHeader", "Lcom/scwang/smartrefresh/layout/api/RefreshInternal;", "getRefreshHeader", "()Lcom/scwang/smartrefresh/layout/api/RefreshInternal;", "setRefreshHeader", "(Lcom/scwang/smartrefresh/layout/api/RefreshInternal;)V", "refreshFooter", "getRefreshFooter", "setRefreshFooter", "Ltb/w02;", "responsiveFragmentStateManager", "Ltb/w02;", "getResponsiveFragmentStateManager", "()Ltb/w02;", "setResponsiveFragmentStateManager", "(Ltb/w02;)V", "<init>", "()V", "Companion", "ResponsiveHandler", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public abstract class BaseFragment extends GenericFragment implements IResponsivePage, IUTPageOperation, IEventFeature, StateViewManager.IStateFeature {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int RECOVER_ITEM_ANIMATOR_MSG = 1024;
    @Nullable
    private PageInfoBean bottomBasePageInfo;
    private boolean isDisplayed;
    @Nullable
    private RefreshInternal refreshFooter;
    @Nullable
    private RefreshInternal refreshHeader;
    public w02 responsiveFragmentStateManager;
    private Handler responsiveHandler;
    @Nullable
    private PageInfoBean topBasePageInfo;
    @NotNull
    private final TrackInfo trackInfo;
    private MovieShowUTHelper utHelper;
    @Nullable
    private String utPageName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/alient/onearch/adapter/BaseFragment$Companion;", "", "", "RECOVER_ITEM_ANIMATOR_MSG", "I", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/alient/onearch/adapter/BaseFragment$ResponsiveHandler;", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "Ltb/ur2;", "handleMessage", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "getRecyclerViewRef", "()Ljava/lang/ref/WeakReference;", "setRecyclerViewRef", "(Ljava/lang/ref/WeakReference;)V", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "itemAnimatorRef", "getItemAnimatorRef", "setItemAnimatorRef", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    private static final class ResponsiveHandler extends Handler {
        @NotNull
        private WeakReference<RecyclerView.ItemAnimator> itemAnimatorRef;
        @NotNull
        private WeakReference<RecyclerView> recyclerViewRef;

        public ResponsiveHandler(@NotNull RecyclerView recyclerView) {
            k21.i(recyclerView, "recyclerView");
            this.recyclerViewRef = new WeakReference<>(recyclerView);
            this.itemAnimatorRef = new WeakReference<>(recyclerView.getItemAnimator());
        }

        @NotNull
        public final WeakReference<RecyclerView.ItemAnimator> getItemAnimatorRef() {
            return this.itemAnimatorRef;
        }

        @NotNull
        public final WeakReference<RecyclerView> getRecyclerViewRef() {
            return this.recyclerViewRef;
        }

        public void handleMessage(@NotNull Message message) {
            k21.i(message, "msg");
            RecyclerView recyclerView = this.recyclerViewRef.get();
            if (recyclerView != null) {
                recyclerView.setItemAnimator(this.itemAnimatorRef.get());
            }
        }

        public final void setItemAnimatorRef(@NotNull WeakReference<RecyclerView.ItemAnimator> weakReference) {
            k21.i(weakReference, "<set-?>");
            this.itemAnimatorRef = weakReference;
        }

        public final void setRecyclerViewRef(@NotNull WeakReference<RecyclerView> weakReference) {
            k21.i(weakReference, "<set-?>");
            this.recyclerViewRef = weakReference;
        }
    }

    public BaseFragment() {
        TrackInfo trackInfo2 = new TrackInfo();
        trackInfo2.setArgs(new HashMap<>());
        ur2 ur2 = ur2.INSTANCE;
        this.trackInfo = trackInfo2;
        initComponentFooterDelegate();
    }

    private final void beforeStartActivity(Intent intent) {
        FragmentActivity activity;
        if (intent != null && !intent.hasExtra(oq2.UT_CONST_SQM) && (activity = getActivity()) != null) {
            k21.h(activity, AdvanceSetting.NETWORK_TYPE);
            if (activity.getIntent().hasExtra(oq2.UT_CONST_SQM)) {
                intent.putExtra(oq2.UT_CONST_SQM, activity.getIntent().getStringExtra(oq2.UT_CONST_SQM));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.alient.onearch.adapter.BaseFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RequestBuilder createRequestBuilder$default(BaseFragment baseFragment, Map map, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                map = null;
            }
            return baseFragment.createRequestBuilder(map);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRequestBuilder");
    }

    /* access modifiers changed from: private */
    public final IStateView createStateView(String str, ViewGroup viewGroup, State state) {
        StateViewManager.IStateViewDelegate stateViewDelegate = StateViewManager.Companion.getInstance().getStateViewDelegate(str);
        if (getContext() == null || stateViewDelegate == null) {
            return null;
        }
        Context requireContext = requireContext();
        k21.h(requireContext, "requireContext()");
        return stateViewDelegate.createStateView(requireContext, viewGroup, state, new BaseFragment$createStateView$1(this));
    }

    private final void refreshBasePageInfo(PageInfoBean pageInfoBean, PageRefreshCallBack pageRefreshCallBack, String str) {
        IRequest build;
        String str2 = pageInfoBean.layerId;
        boolean z = false;
        if (!(str2 == null || str2.length() == 0)) {
            String str3 = pageInfoBean.sectionId;
            if (str3 == null || str3.length() == 0) {
                z = true;
            }
            if (!z) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str4 = pageInfoBean.layerId;
                k21.h(str4, "pageInfo.layerId");
                linkedHashMap.put("layerId", str4);
                String str5 = pageInfoBean.sectionId;
                k21.h(str5, "pageInfo.sectionId");
                linkedHashMap.put("sectionId", str5);
                linkedHashMap.put("strategy", 2L);
                RequestBuilder createRequestBuilder$default = createRequestBuilder$default(this, null, 1, null);
                if (createRequestBuilder$default != null && (build = createRequestBuilder$default.build(linkedHashMap)) != null) {
                    getPageContext().runOnLoaderThread(new BaseFragment$refreshBasePageInfo$$inlined$let$lambda$1(build, this, str, pageRefreshCallBack));
                }
            }
        }
    }

    public static /* synthetic */ void scrollToComponent$default(BaseFragment baseFragment, int i, float f, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                f = 50.0f;
            }
            baseFragment.scrollToComponent(i, f);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToComponent");
    }

    /* access modifiers changed from: protected */
    public void addRecyclerViewFeature(@Nullable RecyclerView recyclerView) {
    }

    public final void addUTPageParams(@NotNull String str, @NotNull String str2) {
        k21.i(str, "key");
        k21.i(str2, "value");
        HashMap<String, String> args = this.trackInfo.getArgs();
        k21.h(args, "trackInfo.args");
        args.put(str, str2);
    }

    @Nullable
    public VirtualLayoutManager createLayoutManager(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        GenericVirtualLayoutManager genericVirtualLayoutManager = new GenericVirtualLayoutManager(context);
        genericVirtualLayoutManager.setItemPrefetchEnabled(true);
        genericVirtualLayoutManager.setInitialPrefetchItemCount(5);
        return genericVirtualLayoutManager;
    }

    @Nullable
    public RefreshInternal createLoadingFooterView(@Nullable Activity activity) {
        StateViewManager.IStateViewDelegate stateViewDelegate;
        String pageName = getPageName();
        if (pageName == null || (stateViewDelegate = StateViewManager.Companion.getInstance().getStateViewDelegate(pageName)) == null) {
            return null;
        }
        return stateViewDelegate.createLoadingFooterView(activity);
    }

    @Nullable
    public RefreshInternal createLoadingHeaderView(@Nullable Activity activity) {
        StateViewManager.IStateViewDelegate stateViewDelegate;
        String pageName = getPageName();
        if (pageName == null || (stateViewDelegate = StateViewManager.Companion.getInstance().getStateViewDelegate(pageName)) == null) {
            return null;
        }
        return stateViewDelegate.createLoadingHeaderView(activity);
    }

    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        k21.i(genericPageContainer, "container");
        return new GenericPagerLoader(genericPageContainer);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract RequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map);

    public boolean enableUTReport() {
        return false;
    }

    @Override // com.alient.onearch.adapter.event.IEventFeature
    public void fireComponentEvent(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        RecyclerView.Adapter adapter;
        k21.i(str, "type");
        RecyclerView recyclerView = getRecyclerView();
        if (!(recyclerView == null || (adapter = recyclerView.getAdapter()) == null)) {
            int itemCount = adapter.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                try {
                    RecyclerView recyclerView2 = getRecyclerView();
                    RecyclerView.ViewHolder viewHolder = null;
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView2 != null ? recyclerView2.findViewHolderForAdapterPosition(i) : null;
                    if (findViewHolderForAdapterPosition instanceof VBaseHolder) {
                        viewHolder = findViewHolderForAdapterPosition;
                    }
                    VBaseHolder vBaseHolder = (VBaseHolder) viewHolder;
                    if (vBaseHolder != null) {
                        vBaseHolder.onMessage(str, map);
                    }
                } catch (Exception e) {
                    if (AppInfoProviderProxy.isDebuggable()) {
                        throw e;
                    }
                }
            }
        }
    }

    @Override // com.alient.onearch.adapter.event.IEventFeature
    public void fireGlobalEvent(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        k21.i(str, "type");
    }

    @Override // com.alient.onearch.adapter.event.IEventFeature
    public void firePageEvent(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        k21.i(str, "type");
        EventDispatcher eventDispatcher = getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(str, map);
        }
    }

    @Nullable
    public final PageInfoBean getBottomBasePageInfo() {
        return this.bottomBasePageInfo;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    public int getLayoutResId() {
        return R.layout.one_arch_fragment_layout;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public final String getPageSPM() {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            return movieShowUTHelper.getPageSPM();
        }
        return null;
    }

    public int getRealPositionForAdapter(@NotNull DelegateAdapter delegateAdapter, @NotNull DelegateAdapter.Adapter<?> adapter) {
        k21.i(delegateAdapter, "delegateAdapter");
        k21.i(adapter, "innerAdapter");
        int itemCount = delegateAdapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            Pair<DelegateAdapter.AdapterDataObserver, DelegateAdapter.Adapter> findAdapterByPosition = delegateAdapter.findAdapterByPosition(i);
            if (findAdapterByPosition != null && ((DelegateAdapter.Adapter) findAdapterByPosition.second) == adapter) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    public int getRecyclerViewResId() {
        return R.id.one_arch_recyclerView;
    }

    @Nullable
    public final RefreshInternal getRefreshFooter() {
        return this.refreshFooter;
    }

    @Nullable
    public final RefreshInternal getRefreshHeader() {
        return this.refreshHeader;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    public int getRefreshLayoutResId() {
        return R.id.one_arch_refresh_layout;
    }

    @NotNull
    public final w02 getResponsiveFragmentStateManager() {
        w02 w02 = this.responsiveFragmentStateManager;
        if (w02 == null) {
            k21.A("responsiveFragmentStateManager");
        }
        return w02;
    }

    @Nullable
    public final PageInfoBean getTopBasePageInfo() {
        return this.topBasePageInfo;
    }

    @NotNull
    public final TrackInfo getTrackInfo() {
        return this.trackInfo;
    }

    @Nullable
    public Properties getUTPageData() {
        return null;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public final String getUTPageName() {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            return movieShowUTHelper.getUTPageName();
        }
        return null;
    }

    @Nullable
    public String getUtPageName() {
        return this.utPageName;
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void hideErrorView(@Nullable Activity activity) {
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void hideLoadingDialog(@Nullable Activity activity) {
        StateViewManager.IStateViewDelegate stateViewDelegate;
        String pageName = getPageName();
        if (pageName != null && (stateViewDelegate = StateViewManager.Companion.getInstance().getStateViewDelegate(pageName)) != null) {
            stateViewDelegate.hideLoadingDialog(activity);
        }
    }

    public void initComponentFooterDelegate() {
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    public void initConfigManager() {
        ConfigManager configManager = new ConfigManager();
        configManager.getParserConfig(0).addParser(0, new BasicModelParser());
        configManager.getParserConfig(1).addParser(0, new BasicModuleParser());
        configManager.getParserConfig(2).addParser(0, new BasicComponentParser());
        configManager.getParserConfig(3).addParser(0, new BasicItemParser());
        getPageContext().setConfigManager(configManager);
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    public void initPageLoader() {
        IContainer<ModelValue> pageContainer = getPageContainer();
        Objects.requireNonNull(pageContainer, "null cannot be cast to non-null type com.alient.onearch.adapter.GenericPageContainer");
        setPageLoader(createPageLoader((GenericPageContainer) pageContainer));
        getPageLoader().setCallback(this);
        getPageContainer().setPageLoader(getPageLoader());
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    public void initPageStateManager() {
        super.initPageStateManager();
        String pageName = getPageName();
        if (pageName != null) {
            getPageStateManager().setStateProperty(State.LOADING, new BaseFragment$initPageStateManager$$inlined$let$lambda$1(pageName, this));
            getPageStateManager().setStateProperty(State.FAILED, new BaseFragment$initPageStateManager$$inlined$let$lambda$2(pageName, this));
            getPageStateManager().setStateProperty(State.NO_NETWORK, new BaseFragment$initPageStateManager$$inlined$let$lambda$3(pageName, this));
            getPageStateManager().setStateProperty(State.NO_DATA, new BaseFragment$initPageStateManager$$inlined$let$lambda$4(pageName, this));
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    public void initRecycleViewSettings() {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            RecycleViewSettings recycleViewSettings = getRecycleViewSettings();
            if (recycleViewSettings != null) {
                Context requireContext = requireContext();
                k21.h(requireContext, "requireContext()");
                recycleViewSettings.setLayoutManager(createLayoutManager(requireContext));
                recycleViewSettings.setAdapter(new ContentAdapter(recycleViewSettings.getLayoutManager(), true));
                recycleViewSettings.config(recyclerView);
            }
            recyclerView.setItemAnimator(null);
            addRecyclerViewFeature(recyclerView);
        }
    }

    public boolean isUpdatePageNameFromRemote() {
        return true;
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        k21.i(configuration, "newConfig");
        w02 w02 = this.responsiveFragmentStateManager;
        if (w02 == null) {
            k21.A("responsiveFragmentStateManager");
        }
        w02.b(configuration);
        super.onConfigurationChanged(configuration);
        w02 w022 = this.responsiveFragmentStateManager;
        if (w022 == null) {
            k21.A("responsiveFragmentStateManager");
        }
        w022.c(configuration);
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getPageContext().getComponentCreatorManager() != null) {
            ComponentCreatorManager componentCreatorManager = getPageContext().getComponentCreatorManager();
            k21.f(componentCreatorManager);
            componentCreatorManager.register(new TypeRange(9000, 9800), new GaiaxComponentCreator());
        }
        if (getPageContext().getViewTypeSupport() != null) {
            ViewTypeSupport viewTypeSupport = getPageContext().getViewTypeSupport();
            k21.f(viewTypeSupport);
            viewTypeSupport.registerViewTypeConfigCreator(new TypeRange(9000, 9800), new GaiaxViewTypeConfigCreator());
        }
        FragmentActivity requireActivity = requireActivity();
        k21.h(requireActivity, "requireActivity()");
        this.responsiveFragmentStateManager = new w02(requireActivity, this);
        if (enableUTReport()) {
            String utPageName2 = getUtPageName();
            if (!(utPageName2 == null || utPageName2.length() == 0)) {
                MovieShowUTHelper movieShowUTHelper = new MovieShowUTHelper(this);
                movieShowUTHelper.setUTPageName(getUtPageName());
                movieShowUTHelper.setUTPageEnable(true);
                ur2 ur2 = ur2.INSTANCE;
                this.utHelper = movieShowUTHelper;
            }
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ComponentFooterDelegateManager.Companion.getInstance().unregister(getPageContext().toString());
        Handler handler = this.responsiveHandler;
        if (handler != null) {
            handler.removeMessages(1024);
        }
        super.onDestroy();
    }

    @Subscribe(eventType = {FragmentEvent.ON_FRAGMENT_RESUME, FragmentEvent.ON_FRAGMENT_PAUSE, FragmentEvent.ON_FRAGMENT_START, FragmentEvent.ON_FRAGMENT_STOP, FragmentEvent.ON_FRAGMENT_CONFIGURATION_CHANGED, FragmentEvent.ON_FRAGMENT_DESTROY, FragmentEvent.ON_FRAGMENT_HIDDEN_CHANGED, FragmentEvent.ON_FRAGMENT_USER_VISIBLE_HINT})
    public final void onFragmentLifecycle(@NotNull Event event) {
        Map<String, ? extends Object> map;
        k21.i(event, "event");
        Object obj = event.data;
        if (obj instanceof Map) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            map = (Map) obj;
        } else {
            map = new HashMap<>();
        }
        String str = event.type;
        k21.h(str, "event.type");
        fireComponentEvent(str, map);
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    public void onFragmentVisibleChange(boolean z) {
        super.onFragmentVisibleChange(z);
        if (!enableUTReport()) {
            return;
        }
        if (z) {
            this.isDisplayed = true;
            MovieShowUTHelper movieShowUTHelper = this.utHelper;
            if (movieShowUTHelper != null) {
                movieShowUTHelper.setUTPageName(getUtPageName());
            }
            MovieShowUTHelper movieShowUTHelper2 = this.utHelper;
            if (movieShowUTHelper2 != null) {
                movieShowUTHelper2.h();
            }
            updateUTPageProperties(getUTPageData());
            return;
        }
        MovieShowUTHelper movieShowUTHelper3 = this.utHelper;
        if (movieShowUTHelper3 != null) {
            movieShowUTHelper3.i();
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isDisplayed = false;
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.i();
        }
    }

    @Override // com.alibaba.pictures.responsive.page.IResponsivePage
    public void onResponsiveLayout(@Nullable Configuration configuration, int i, boolean z) {
        g12.INSTANCE.b(getRecyclerView());
        CountDownLatch countDownLatch = new CountDownLatch(1);
        getPageContext().runOnLoaderThread(new BaseFragment$onResponsiveLayout$1(this, countDownLatch));
        try {
            countDownLatch.await(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
            if (this.responsiveHandler == null) {
                this.responsiveHandler = new ResponsiveHandler(recyclerView);
            }
        }
        Handler handler = this.responsiveHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.responsiveHandler;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(1024, 2000);
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setFragmentVisible(getUserVisibleHint() && !isHidden());
        if (enableUTReport() && isFragmentVisible() && !this.isDisplayed) {
            this.isDisplayed = true;
            MovieShowUTHelper movieShowUTHelper = this.utHelper;
            if (movieShowUTHelper != null) {
                movieShowUTHelper.i();
            }
            MovieShowUTHelper movieShowUTHelper2 = this.utHelper;
            if (movieShowUTHelper2 != null) {
                movieShowUTHelper2.setUTPageName(getUtPageName());
            }
            MovieShowUTHelper movieShowUTHelper3 = this.utHelper;
            if (movieShowUTHelper3 != null) {
                movieShowUTHelper3.h();
            }
            updateUTPageProperties(getUTPageData());
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        k21.i(bundle, "outState");
        try {
            if (getClass().getClassLoader() != null) {
                bundle.setClassLoader(getClass().getClassLoader());
            }
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
            CMSRenderMonitorPoint.Companion.commitCMSRenderMonitorFail(MonitorConstant.INSTANCE.getSAVE_STATE_DATA_ERROR(), "\"ErrorMsg:\" + e.message + \"---SuperInfo:\" + javaClass.superclass.name + \"---\" + \"Method: onSaveInstanceState\"", new LinkedHashMap());
            ClickCat k = DogCat.INSTANCE.d().k("SaveStateError");
            Class<? super Object> superclass = getClass().getSuperclass();
            k21.h(superclass, "javaClass.superclass");
            k.p("ErrorMsg", e.getMessage(), "SuperInfo", superclass.getName(), "Method", "onSaveInstanceState").j();
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void onUTButtonClick(@Nullable String str, @NotNull String... strArr) {
        k21.i(strArr, "kvs");
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.onUTButtonClick(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        k21.i(view, "view");
        super.onViewCreated(view, bundle);
        RefreshInternal createLoadingHeaderView = createLoadingHeaderView(getActivity());
        RefreshInternal refreshInternal = null;
        if (createLoadingHeaderView != null) {
            View view2 = (View) (!(createLoadingHeaderView instanceof View) ? null : createLoadingHeaderView);
            if (view2 != null) {
                view2.setId(R.id.one_arch_header);
            }
            RefreshLayout refreshLayout = getRefreshLayout();
            if (refreshLayout != null) {
                refreshLayout.setRefreshHeader((RefreshHeader) createLoadingHeaderView);
            }
            ur2 ur2 = ur2.INSTANCE;
        } else {
            createLoadingHeaderView = null;
        }
        this.refreshHeader = createLoadingHeaderView;
        RefreshInternal createLoadingFooterView = createLoadingFooterView(getActivity());
        if (createLoadingFooterView != null) {
            if (createLoadingFooterView instanceof View) {
                refreshInternal = createLoadingFooterView;
            }
            View view3 = (View) refreshInternal;
            if (view3 != null) {
                view3.setId(R.id.one_arch_footer);
            }
            RefreshLayout refreshLayout2 = getRefreshLayout();
            if (refreshLayout2 != null) {
                refreshLayout2.setRefreshFooter((RefreshFooter) createLoadingFooterView);
            }
            RefreshLayout refreshLayout3 = getRefreshLayout();
            if (refreshLayout3 != null) {
                refreshLayout3.setEnableLoadMore(false);
            }
            ur2 ur22 = ur2.INSTANCE;
            refreshInternal = createLoadingFooterView;
        }
        this.refreshFooter = refreshInternal;
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        if (bundle != null) {
            try {
                if (getClass().getClassLoader() != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                }
            } catch (Exception e) {
                CMSRenderMonitorPoint.Companion.commitCMSRenderMonitorFail(MonitorConstant.INSTANCE.getSAVE_STATE_DATA_ERROR(), "\"ErrorMsg:\" + e.message + \"---SuperInfo:\" + javaClass.superclass.name + \"---\" + \"Method: onViewStateRestored\"\n", new LinkedHashMap());
                ClickCat k = DogCat.INSTANCE.d().k("SaveStateError");
                Class<? super Object> superclass = getClass().getSuperclass();
                k21.h(superclass, "javaClass.superclass");
                k.p("ErrorMsg", e.getMessage(), "SuperInfo", superclass.getName(), "Method", "onViewStateRestored").j();
                return;
            }
        }
        super.onViewStateRestored(bundle);
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public final String querySavedPageProperty(@Nullable String str) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            return movieShowUTHelper.querySavedPageProperty(str);
        }
        return null;
    }

    public final void refreshBottomBasePageInfo(@NotNull PageRefreshCallBack pageRefreshCallBack) {
        k21.i(pageRefreshCallBack, "callBack");
        PageInfoBean pageInfoBean = this.bottomBasePageInfo;
        if (pageInfoBean != null) {
            refreshBasePageInfo(pageInfoBean, pageRefreshCallBack, "bottom");
        }
    }

    public final void refreshTopBasePageInfo(@NotNull PageRefreshCallBack pageRefreshCallBack) {
        k21.i(pageRefreshCallBack, "callBack");
        PageInfoBean pageInfoBean = this.topBasePageInfo;
        if (pageInfoBean != null) {
            refreshBasePageInfo(pageInfoBean, pageRefreshCallBack, "top");
        }
    }

    public final void scrollToComponent(int i, float f) {
        int realPositionForAdapter;
        if (getActivity() != null && getRecyclerView() != null) {
            Iterator<T> it = getPageContainer().getCurrentModules().iterator();
            while (it.hasNext()) {
                Iterator<T> it2 = it.next().getComponents().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    T next = it2.next();
                    if (next.getType() == i) {
                        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = next.getAdapter();
                        if (adapter != null && (realPositionForAdapter = getRealPositionForAdapter(getPageContainer().getContentAdapter(), adapter)) > 0) {
                            RecyclerViewUtil recyclerViewUtil = RecyclerViewUtil.INSTANCE;
                            FragmentActivity activity = getActivity();
                            RecyclerView recyclerView = getRecyclerView();
                            k21.f(recyclerView);
                            recyclerViewUtil.smoothScrollToPositionSpeed(activity, recyclerView, realPositionForAdapter, f);
                        }
                    }
                }
            }
        }
    }

    public final void setBottomBasePageInfo(@Nullable PageInfoBean pageInfoBean) {
        this.bottomBasePageInfo = pageInfoBean;
    }

    public final void setRefreshFooter(@Nullable RefreshInternal refreshInternal) {
        this.refreshFooter = refreshInternal;
    }

    public final void setRefreshHeader(@Nullable RefreshInternal refreshInternal) {
        this.refreshHeader = refreshInternal;
    }

    public final void setResponsiveFragmentStateManager(@NotNull w02 w02) {
        k21.i(w02, "<set-?>");
        this.responsiveFragmentStateManager = w02;
    }

    public final void setTopBasePageInfo(@Nullable PageInfoBean pageInfoBean) {
        this.topBasePageInfo = pageInfoBean;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void setUTPageEnable(boolean z) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.setUTPageEnable(z);
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void setUTPageName(@Nullable String str) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.setUTPageName(str);
        }
    }

    public void setUtPageName(@Nullable String str) {
        this.utPageName = str;
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void showErrorView(@Nullable Activity activity, @Nullable String str, @Nullable String str2, @Nullable StateViewManager.IStateViewListener iStateViewListener) {
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void showLoadingDialog(@Nullable Activity activity, @Nullable String str, boolean z) {
        StateViewManager.IStateViewDelegate stateViewDelegate;
        String pageName = getPageName();
        if (pageName != null && (stateViewDelegate = StateViewManager.Companion.getInstance().getStateViewDelegate(pageName)) != null) {
            stateViewDelegate.showLoadingDialog(activity, str, z);
        }
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void showToast(@NotNull String str) {
        StateViewManager.IStateViewDelegate stateViewDelegate;
        k21.i(str, "msg");
        String pageName = getPageName();
        if (pageName != null && (stateViewDelegate = StateViewManager.Companion.getInstance().getStateViewDelegate(pageName)) != null) {
            stateViewDelegate.showToast(str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivity(@Nullable Intent intent) {
        beforeStartActivity(intent);
        super.startActivity(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(@Nullable Intent intent, int i) {
        beforeStartActivity(intent);
        super.startActivityForResult(intent, i);
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void startExpoTrack(@Nullable Activity activity) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.startExpoTrack(activity);
        }
    }

    /* access modifiers changed from: protected */
    public void traversComponent(@NotNull IComponent<ComponentValue> iComponent, @NotNull List<IComponent<ComponentValue>> list) {
        k21.i(iComponent, "component");
        k21.i(list, "updatedComponents");
        if (!list.contains(iComponent)) {
            list.add(iComponent);
        }
    }

    /* access modifiers changed from: protected */
    public void traverseModule(@NotNull IModule<ModuleValue> iModule, @NotNull List<IComponent<ComponentValue>> list) {
        k21.i(iModule, "module");
        k21.i(list, "updatedComponents");
        Iterator<T> it = iModule.getComponents().iterator();
        while (it.hasNext()) {
            traversComponent(it.next(), list);
        }
    }

    public final void updateABBucket(@NotNull Node node) {
        JSONObject data;
        String string;
        MovieShowUTHelper movieShowUTHelper;
        k21.i(node, "pageNode");
        if (getUserVisibleHint() && (data = node.getData()) != null && (string = data.getString("pabBucket")) != null) {
            if ((string.length() > 0) && (movieShowUTHelper = this.utHelper) != null) {
                Properties properties = new Properties();
                properties.put("ABTrackInfo", string);
                ur2 ur2 = ur2.INSTANCE;
                movieShowUTHelper.updateUTPageProperties(properties);
            }
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.youku.arch.v3.page.IStatics
    public void updatePvStatics() {
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void updateSPM(@Nullable String str) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.updateSPM(str);
        }
    }

    public void updateUTPageNameFromRemote(@NotNull String str, @NotNull String str2) {
        String str3;
        k21.i(str, "pageName");
        k21.i(str2, "spmB");
        if (enableUTReport() && isUpdatePageNameFromRemote()) {
            uq2 uq2 = uq2.INSTANCE;
            String e = uq2.e();
            if (e == null || e.length() == 0) {
                str3 = "Page_" + str;
            } else {
                str3 = k21.r(uq2.e(), str);
            }
            UTAnalytics instance = UTAnalytics.getInstance();
            k21.h(instance, "UTAnalytics.getInstance()");
            instance.getDefaultTracker().updatePageName(getActivity(), str3);
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void updateUTPageProperties(@Nullable Properties properties) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper != null) {
            movieShowUTHelper.updateUTPageProperties(properties);
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    @Nullable
    public List<IDelegate<GenericFragment>> wrapperDelegates(@Nullable List<IDelegate<GenericFragment>> list) {
        List<IDelegate<GenericFragment>> wrapperDelegates = super.wrapperDelegates(list);
        if (wrapperDelegates == null) {
            wrapperDelegates = new ArrayList<>();
        }
        wrapperDelegates.add(new OneArchAlarmDelegate());
        return wrapperDelegates;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public GenericPageContainer initPageContainer(@NotNull PageContext pageContext) {
        k21.i(pageContext, Constants.PAGE_CONTEXT);
        GenericPageContainer genericPageContainer = new GenericPageContainer(pageContext);
        genericPageContainer.setRefreshThreshold(4);
        genericPageContainer.setRequestBuilder(createRequestBuilder(new HashMap()));
        return genericPageContainer;
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivity(@Nullable Intent intent, @Nullable Bundle bundle) {
        beforeStartActivity(intent);
        super.startActivity(intent, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(@Nullable Intent intent, int i, @Nullable Bundle bundle) {
        beforeStartActivity(intent);
        super.startActivityForResult(intent, i, bundle);
    }
}
