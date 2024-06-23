package com.youku.arch.v3.page;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.m.x.d;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.uc.webview.export.media.MessageID;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.core.ActivityContext;
import com.youku.arch.v3.core.ActivityValue;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.event.FragmentEvent;
import com.youku.arch.v3.event.FragmentEventPoster;
import com.youku.arch.v3.event.RefreshEvent;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.loader.LoadingViewManager;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.arch.v3.loader.PagingLoader;
import com.youku.arch.v3.loader.RefreshLayoutManger;
import com.youku.arch.v3.page.DelegateConfigure;
import com.youku.arch.v3.page.state.PageStateManager;
import com.youku.arch.v3.page.state.State;
import com.youku.arch.v3.page.state.StateSuccessView;
import com.youku.arch.v3.style.Style;
import com.youku.arch.v3.style.StyleManager;
import com.youku.arch.v3.util.ArchMontior;
import com.youku.arch.v3.util.ArchMontiorManager;
import com.youku.arch.v3.util.LogUtil;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.kubus.Subscribe;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.a;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\t¢\u0006\u0006\bã\u0001\u0010ä\u0001J\u001e\u0010\t\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0006\u0018\u00010\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\nH\u0014J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0001H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u001e\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020!2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020\bH\u0016J\b\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\bH\u0016J\"\u00100\u001a\u00020\b2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00102\u001a\u00020\b2\u0006\u00101\u001a\u00020\u000eH\u0016J\u0012\u00103\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u00106\u001a\u00020\b2\u0006\u00105\u001a\u000204H\u0016J\u0010\u00108\u001a\u00020\b2\u0006\u00107\u001a\u000204H\u0016J\u0010\u0010;\u001a\u00020\b2\u0006\u0010:\u001a\u000209H\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010<\u001a\u000204H\u0016J\u0010\u0010?\u001a\u00020\b2\u0006\u0010>\u001a\u000204H\u0016J-\u0010E\u001a\u00020\b2\u0006\u0010,\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ\"\u0010K\u001a\u0004\u0018\u00010J2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020\nH\u0016J\"\u0010M\u001a\u0004\u0018\u00010L2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020\nH\u0016J\b\u0010N\u001a\u00020\bH\u0016J\u0010\u0010Q\u001a\u00020\b2\u0006\u0010P\u001a\u00020OH\u0016J\b\u0010R\u001a\u00020\bH\u0016J\u001c\u0010V\u001a\u00020\b2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020T0SH\u0016J\b\u0010W\u001a\u00020\bH\u0016J\b\u0010X\u001a\u00020\bH$J\b\u0010Y\u001a\u00020\bH\u0014J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010[\u001a\u00020ZH$J\b\u0010_\u001a\u00020\bH\u0014J\u0012\u0010_\u001a\u00020\b2\b\u0010`\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010c\u001a\u00020\b2\b\u0010b\u001a\u0004\u0018\u00010aH\u0014J\b\u0010d\u001a\u00020\bH&J\n\u0010e\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010g\u001a\u00020\b2\u0006\u0010f\u001a\u000204H\u0016J\u000e\u0010i\u001a\u00020\b2\u0006\u0010h\u001a\u000204J\u0014\u0010k\u001a\u0004\u0018\u00010!2\b\u0010j\u001a\u0004\u0018\u00010\u001fH\u0014J\u0014\u0010m\u001a\u0004\u0018\u00010!2\b\u0010l\u001a\u0004\u0018\u00010!H\u0014J\u0006\u0010n\u001a\u00020\bJ\u0006\u0010p\u001a\u00020oJ\u0016\u0010r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0006\u0018\u00010qH\u0016J\u001e\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00060q2\b\u0010s\u001a\u0004\u0018\u00010AH\u0016J,\u0010u\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0006\u0018\u00010q2\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0006\u0018\u00010qH\u0016J\u0010\u0010x\u001a\u00020\b2\u0006\u0010w\u001a\u00020vH\u0017J\u0010\u0010y\u001a\u00020\b2\u0006\u0010w\u001a\u00020vH\u0017J\u0010\u0010{\u001a\u00020\b2\u0006\u0010z\u001a\u000204H\u0016J\b\u0010}\u001a\u00020|H\u0016J\b\u0010~\u001a\u00020|H\u0016J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001a\u00020\nJ\u0013\u0010\u0001\u001a\u00020\b2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001R/\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020]0\\8\u0016@\u0016X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u00030\u00018\u0016@\u0016X.¢\u0006\u0017\n\u0006\b\u0001\u0010\u0001\u001a\u0005\bp\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u0010[\u001a\u00020Z8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b[\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R,\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R5\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0006\u0018\u00010q8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b\u0007\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010 \u0001R,\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R*\u0010©\u0001\u001a\u00030¨\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b­\u0001\u0010®\u0001R)\u0010b\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\bb\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R,\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R,\u0010¼\u0001\u001a\u0005\u0018\u00010»\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R2\u0010Ã\u0001\u001a\u0002042\u0007\u0010Â\u0001\u001a\u0002048\u0006@DX\u000e¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÃ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R/\u0010h\u001a\u0002042\u0007\u0010Â\u0001\u001a\u0002048\u0006@DX\u000e¢\u0006\u0016\n\u0005\bh\u0010Ä\u0001\u001a\u0005\bh\u0010Å\u0001\"\u0006\bÈ\u0001\u0010Ç\u0001R.\u0010É\u0001\u001a\u0004\u0018\u00010!2\t\u0010Â\u0001\u001a\u0004\u0018\u00010!8\u0006@BX\u000e¢\u0006\u0010\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R+\u0010Í\u0001\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bÍ\u0001\u0010Ê\u0001\u001a\u0006\bÎ\u0001\u0010Ì\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R+\u0010Ñ\u0001\u001a\u0004\u0018\u00010O8\u0014@\u0014X\u000e¢\u0006\u0018\n\u0006\bÑ\u0001\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R,\u0010Ø\u0001\u001a\u0005\u0018\u00010×\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010Ù\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R\u0019\u0010à\u0001\u001a\u00020A8$@$X¤\u0004¢\u0006\b\u001a\u0006\bÞ\u0001\u0010ß\u0001R\u001b\u0010â\u0001\u001a\u0004\u0018\u00010A8$@$X¤\u0004¢\u0006\b\u001a\u0006\bá\u0001\u0010ß\u0001¨\u0006å\u0001"}, d2 = {"Lcom/youku/arch/v3/page/GenericFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/youku/arch/v3/io/Callback;", "Lcom/youku/arch/v3/page/IStatics;", "Ljava/io/Serializable;", "", "Lcom/youku/arch/v3/page/IDelegate;", "delegateList", "Ltb/ur2;", "unRegisterDelegates", "", "getLayoutResId", "getRecyclerViewResId", "getRefreshLayoutResId", "Landroid/os/Bundle;", "args", "setArguments", "childFragment", "onAttachFragment", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "onAttach", "savedInstanceState", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED, "onCreate", "Landroid/view/LayoutInflater;", "onGetLayoutInflater", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "onInflate", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onStart", "onResume", MessageID.onPause, MessageID.onStop, "onDestroyView", "onDestroy", "onDetach", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "outState", "onSaveInstanceState", "onViewStateRestored", "", "isInMultiWindowMode", "onMultiWindowModeChanged", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "hidden", "onHiddenChanged", "isVisibleToUser", "setUserVisibleHint", "", "", "permissions", "", WXModule.GRANT_RESULTS, "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "transit", "enter", "nextAnim", "Landroid/view/animation/Animation;", "onCreateAnimation", "Landroid/animation/Animator;", "onCreateAnimator", "onLowMemory", "Lcom/youku/arch/v3/io/IResponse;", "response", "onResponse", "updatePvStatics", "", "", com.youku.arch.v3.core.Constants.CONFIG, "load", "doRequest", "initConfigManager", "initPageLoader", "Lcom/youku/arch/v3/core/PageContext;", com.youku.arch.v3.data.Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "initPageContainer", "initPageStateManager", "successView", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "refreshLayout", "initLoadingViewManager", "initRecycleViewSettings", "getDelegatePathPrefix", "isVisible", "onFragmentVisibleChange", "isSelected", "setPageSelected", "viewGroup", "getPreContentView", "contentView", "onContentViewInflated", "autoRefresh", "Lcom/youku/arch/v3/loader/PagingLoader;", "getPageLoader", "", "getDelegates", "pathPrefix", "initDelegates", "wrapperDelegates", "Lcom/youku/kubus/Event;", "event", "onLoadMore", d.p, DXRecyclerLayout.LOAD_MORE_NO_DATA_STRING, "setNoMore", "", "getLoadingFootHeight", "getNoMoreFootHeight", "color", "setFragmentBackGroundColor", "Landroid/graphics/drawable/Drawable;", "drawable", "setFragmentBackGroundDrawable", "pageContainer", "Lcom/youku/arch/v3/IContainer;", "getPageContainer", "()Lcom/youku/arch/v3/IContainer;", "setPageContainer", "(Lcom/youku/arch/v3/IContainer;)V", "Lcom/youku/arch/v3/loader/PageLoader;", "pageLoader", "Lcom/youku/arch/v3/loader/PageLoader;", "()Lcom/youku/arch/v3/loader/PageLoader;", "setPageLoader", "(Lcom/youku/arch/v3/loader/PageLoader;)V", "Lcom/youku/arch/v3/core/PageContext;", "getPageContext", "()Lcom/youku/arch/v3/core/PageContext;", "setPageContext", "(Lcom/youku/arch/v3/core/PageContext;)V", "Lcom/youku/arch/v3/core/IContext;", "attachBaseContext", "Lcom/youku/arch/v3/core/IContext;", "getAttachBaseContext", "()Lcom/youku/arch/v3/core/IContext;", "setAttachBaseContext", "(Lcom/youku/arch/v3/core/IContext;)V", "Ljava/util/List;", "getDelegateList", "()Ljava/util/List;", "setDelegateList", "(Ljava/util/List;)V", "Lcom/youku/arch/v3/page/FragmentInterceptor;", "fragmentInterceptor", "Lcom/youku/arch/v3/page/FragmentInterceptor;", "getFragmentInterceptor", "()Lcom/youku/arch/v3/page/FragmentInterceptor;", "setFragmentInterceptor", "(Lcom/youku/arch/v3/page/FragmentInterceptor;)V", "Lcom/youku/arch/v3/page/state/PageStateManager;", "pageStateManager", "Lcom/youku/arch/v3/page/state/PageStateManager;", "getPageStateManager", "()Lcom/youku/arch/v3/page/state/PageStateManager;", "setPageStateManager", "(Lcom/youku/arch/v3/page/state/PageStateManager;)V", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "getRefreshLayout", "()Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "setRefreshLayout", "(Lcom/scwang/smartrefresh/layout/api/RefreshLayout;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/youku/arch/v3/page/RecycleViewSettings;", "recycleViewSettings", "Lcom/youku/arch/v3/page/RecycleViewSettings;", "getRecycleViewSettings", "()Lcom/youku/arch/v3/page/RecycleViewSettings;", "setRecycleViewSettings", "(Lcom/youku/arch/v3/page/RecycleViewSettings;)V", "<set-?>", "isFragmentVisible", "Z", "()Z", "setFragmentVisible", "(Z)V", "setSelected", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "realView", "getRealView", "setRealView", "(Landroid/view/View;)V", "initResponse", "Lcom/youku/arch/v3/io/IResponse;", "getInitResponse", "()Lcom/youku/arch/v3/io/IResponse;", "setInitResponse", "(Lcom/youku/arch/v3/io/IResponse;)V", "Lcom/youku/arch/v3/page/GenericFragmentPreloadDelegate;", "fragmentPreloadDelegate", "Lcom/youku/arch/v3/page/GenericFragmentPreloadDelegate;", "getFragmentPreloadDelegate", "()Lcom/youku/arch/v3/page/GenericFragmentPreloadDelegate;", "setFragmentPreloadDelegate", "(Lcom/youku/arch/v3/page/GenericFragmentPreloadDelegate;)V", "getConfigPath", "()Ljava/lang/String;", "configPath", "getPageName", "pageName", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public abstract class GenericFragment extends Fragment implements Callback, IStatics, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private IContext attachBaseContext;
    @Nullable
    private List<IDelegate<GenericFragment>> delegateList;
    @Nullable
    private FragmentInterceptor fragmentInterceptor;
    @Nullable
    private GenericFragmentPreloadDelegate fragmentPreloadDelegate;
    @Nullable
    private IResponse initResponse;
    private boolean isFragmentVisible;
    private boolean isSelected;
    public IContainer<ModelValue> pageContainer;
    @NotNull
    private PageContext pageContext;
    public PageLoader pageLoader;
    public PageStateManager pageStateManager;
    @Nullable
    private View realView;
    @Nullable
    private RecycleViewSettings recycleViewSettings;
    @Nullable
    private RecyclerView recyclerView;
    @Nullable
    private RefreshLayout refreshLayout;
    @Nullable
    private View rootView;

    public GenericFragment() {
        PageContext pageContext2 = new PageContext();
        this.pageContext = pageContext2;
        EventBus eventBus = pageContext2.getEventBus();
        if (eventBus != null) {
            setFragmentInterceptor(new FragmentEventPoster(eventBus));
        }
    }

    private final void unRegisterDelegates(List<? extends IDelegate<GenericFragment>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1417905056")) {
            ipChange.ipc$dispatch("-1417905056", new Object[]{this, list});
        } else if (list != null) {
            for (T t : list) {
                EventBus eventBus = getPageContext().getEventBus();
                if (eventBus != null) {
                    eventBus.unregister(t);
                }
            }
        }
    }

    public final void autoRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1355013227")) {
            ipChange.ipc$dispatch("-1355013227", new Object[]{this});
            return;
        }
        RefreshLayout refreshLayout2 = this.refreshLayout;
        if (refreshLayout2 != null) {
            refreshLayout2.autoRefresh();
        }
    }

    public void doRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1592687043")) {
            ipChange.ipc$dispatch("-1592687043", new Object[]{this});
            return;
        }
        LogUtil.d("OneArch.GenericFragment", "doRequest");
        IResponse initResponse2 = getInitResponse();
        IResponse iResponse = null;
        if (!(initResponse2 != null)) {
            initResponse2 = null;
        }
        if (initResponse2 != null) {
            getPageLoader().handleLoadSuccess(initResponse2, 1);
            setInitResponse(null);
            iResponse = initResponse2;
        }
        if (iResponse == null) {
            getPageLoader().refreshLoad();
            setNoMore(false);
        }
    }

    @Nullable
    public final IContext getAttachBaseContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "411882862")) {
            return this.attachBaseContext;
        }
        return (IContext) ipChange.ipc$dispatch("411882862", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract String getConfigPath();

    @Nullable
    public final List<IDelegate<GenericFragment>> getDelegateList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "43179743")) {
            return this.delegateList;
        }
        return (List) ipChange.ipc$dispatch("43179743", new Object[]{this});
    }

    @Nullable
    public String getDelegatePathPrefix() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1946931185")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1946931185", new Object[]{this});
    }

    @Nullable
    public List<IDelegate<GenericFragment>> getDelegates() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-673970474")) {
            return null;
        }
        return (List) ipChange.ipc$dispatch("-673970474", new Object[]{this});
    }

    @Nullable
    public final FragmentInterceptor getFragmentInterceptor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1515955769")) {
            return this.fragmentInterceptor;
        }
        return (FragmentInterceptor) ipChange.ipc$dispatch("1515955769", new Object[]{this});
    }

    @Nullable
    public final GenericFragmentPreloadDelegate getFragmentPreloadDelegate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1722977880")) {
            return this.fragmentPreloadDelegate;
        }
        return (GenericFragmentPreloadDelegate) ipChange.ipc$dispatch("1722977880", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Nullable
    public IResponse getInitResponse() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1654232989")) {
            return this.initResponse;
        }
        return (IResponse) ipChange.ipc$dispatch("1654232989", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "209636513")) {
            return -1;
        }
        return ((Integer) ipChange.ipc$dispatch("209636513", new Object[]{this})).intValue();
    }

    public float getLoadingFootHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1220385698")) {
            return 53.0f;
        }
        return ((Float) ipChange.ipc$dispatch("-1220385698", new Object[]{this})).floatValue();
    }

    public float getNoMoreFootHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1167251856")) {
            return 63.0f;
        }
        return ((Float) ipChange.ipc$dispatch("1167251856", new Object[]{this})).floatValue();
    }

    @NotNull
    public IContainer<ModelValue> getPageContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923453747")) {
            return (IContainer) ipChange.ipc$dispatch("923453747", new Object[]{this});
        }
        IContainer<ModelValue> iContainer = this.pageContainer;
        if (iContainer != null) {
            return iContainer;
        }
        k21.A("pageContainer");
        return null;
    }

    @NotNull
    public final PageContext getPageContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "869757257")) {
            return this.pageContext;
        }
        return (PageContext) ipChange.ipc$dispatch("869757257", new Object[]{this});
    }

    @NotNull
    public PageLoader getPageLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1396861897")) {
            return (PageLoader) ipChange.ipc$dispatch("1396861897", new Object[]{this});
        }
        PageLoader pageLoader2 = this.pageLoader;
        if (pageLoader2 != null) {
            return pageLoader2;
        }
        k21.A("pageLoader");
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract String getPageName();

    @NotNull
    public final PageStateManager getPageStateManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-216883723")) {
            return (PageStateManager) ipChange.ipc$dispatch("-216883723", new Object[]{this});
        }
        PageStateManager pageStateManager2 = this.pageStateManager;
        if (pageStateManager2 != null) {
            return pageStateManager2;
        }
        k21.A("pageStateManager");
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public View getPreContentView(@Nullable ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1315348399")) {
            return null;
        }
        return (View) ipChange.ipc$dispatch("-1315348399", new Object[]{this, viewGroup});
    }

    @Nullable
    public final View getRealView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "134189578")) {
            return this.realView;
        }
        return (View) ipChange.ipc$dispatch("134189578", new Object[]{this});
    }

    @Nullable
    public final RecycleViewSettings getRecycleViewSettings() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1070845831")) {
            return this.recycleViewSettings;
        }
        return (RecycleViewSettings) ipChange.ipc$dispatch("-1070845831", new Object[]{this});
    }

    @Nullable
    public final RecyclerView getRecyclerView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-697484178")) {
            return this.recyclerView;
        }
        return (RecyclerView) ipChange.ipc$dispatch("-697484178", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public int getRecyclerViewResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1256437893")) {
            return -1;
        }
        return ((Integer) ipChange.ipc$dispatch("-1256437893", new Object[]{this})).intValue();
    }

    @Nullable
    public final RefreshLayout getRefreshLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2003193231")) {
            return this.refreshLayout;
        }
        return (RefreshLayout) ipChange.ipc$dispatch("-2003193231", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public int getRefreshLayoutResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1251012040")) {
            return -1;
        }
        return ((Integer) ipChange.ipc$dispatch("1251012040", new Object[]{this})).intValue();
    }

    @Nullable
    public final View getRootView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1587323066")) {
            return this.rootView;
        }
        return (View) ipChange.ipc$dispatch("-1587323066", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public abstract void initConfigManager();

    @NotNull
    public List<IDelegate<GenericFragment>> initDelegates(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-245098886")) {
            return (List) ipChange.ipc$dispatch("-245098886", new Object[]{this, str});
        }
        List<IDelegate<GenericFragment>> delegates = getDelegates();
        if (!(delegates == null || delegates.isEmpty())) {
            return delegates;
        }
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            return new ArrayList();
        }
        Context requireContext = requireContext();
        k21.h(requireContext, "requireContext()");
        DelegateConfigure delegateConfigure = new DelegateManager(str, requireContext).getDelegateConfigure();
        if (delegateConfigure == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (DelegateConfigure.DelegatesBean delegatesBean : delegateConfigure.getDelegates()) {
            if (delegatesBean.isEnable()) {
                Object f = a.j(delegatesBean.getClassX()).b().f();
                IDelegate iDelegate = f instanceof IDelegate ? (IDelegate) f : null;
                if (iDelegate != null) {
                    arrayList.add(iDelegate);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void initLoadingViewManager(@Nullable RefreshLayout refreshLayout2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1901165054")) {
            ipChange.ipc$dispatch("-1901165054", new Object[]{this, refreshLayout2});
            return;
        }
        LoadingViewManager loadingViewManager = getPageContainer().getPageLoader().getLoadingViewManager();
        if (refreshLayout2 != null) {
            refreshLayout2.setOnMultiPurposeListener(getFragmentInterceptor());
            RefreshLayoutManger refreshLayoutManger = new RefreshLayoutManger();
            refreshLayoutManger.setRefreshLayout(refreshLayout2);
            loadingViewManager.addLoadingStateListener(refreshLayoutManger);
        }
        loadingViewManager.addLoadingStateListener(getPageStateManager());
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract IContainer<ModelValue> initPageContainer(@NotNull PageContext pageContext2);

    /* access modifiers changed from: protected */
    public void initPageLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027980343")) {
            ipChange.ipc$dispatch("1027980343", new Object[]{this});
            return;
        }
        setPageLoader(new PageLoader(getPageContainer()));
        getPageLoader().setCallback(this);
        getPageContainer().setPageLoader(getPageLoader());
    }

    /* access modifiers changed from: protected */
    public void initPageStateManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-274038258")) {
            ipChange.ipc$dispatch("-274038258", new Object[]{this});
            return;
        }
        setPageStateManager(new PageStateManager(getContext()));
    }

    public abstract void initRecycleViewSettings();

    public final boolean isFragmentVisible() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-949632051")) {
            return this.isFragmentVisible;
        }
        return ((Boolean) ipChange.ipc$dispatch("-949632051", new Object[]{this})).booleanValue();
    }

    public final boolean isSelected() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "287371304")) {
            return this.isSelected;
        }
        return ((Boolean) ipChange.ipc$dispatch("287371304", new Object[]{this})).booleanValue();
    }

    public void load(@NotNull Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785216674")) {
            ipChange.ipc$dispatch("785216674", new Object[]{this, map});
            return;
        }
        k21.i(map, com.youku.arch.v3.core.Constants.CONFIG);
        getPageContainer().getPageLoader().load(map);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1262648429")) {
            ipChange.ipc$dispatch("1262648429", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onActivityCreated(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1759059941")) {
            ipChange.ipc$dispatch("-1759059941", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-976443965")) {
            ipChange.ipc$dispatch("-976443965", new Object[]{this, context});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (!(arguments == null || (obj = arguments.get(com.youku.arch.v3.data.Constants.ACTIVITY_CONTEXT)) == null)) {
            getPageContext().attachBaseContext((IContext) obj);
        }
        EventBus eventBus = this.pageContext.getEventBus();
        if (eventBus != null && !eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onFragmentAttach(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(@NotNull Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157967917")) {
            ipChange.ipc$dispatch("157967917", new Object[]{this, fragment});
            return;
        }
        k21.i(fragment, "childFragment");
        super.onAttachFragment(fragment);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onAttachFragment(fragment);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153903932")) {
            ipChange.ipc$dispatch("-1153903932", new Object[]{this, configuration});
            return;
        }
        k21.i(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onConfigurationChanged(configuration);
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public View onContentViewInflated(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1040206161")) {
            return view;
        }
        return (View) ipChange.ipc$dispatch("-1040206161", new Object[]{this, view});
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        PageContext pageContext2;
        FragmentInterceptor fragmentInterceptor2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1664685702")) {
            ipChange.ipc$dispatch("1664685702", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        GenericFragmentPreloadDelegate genericFragmentPreloadDelegate = this.fragmentPreloadDelegate;
        ActivityContext activityContext = null;
        if (genericFragmentPreloadDelegate != null) {
            k21.f(genericFragmentPreloadDelegate);
            if (genericFragmentPreloadDelegate.getPageContext() != null) {
                GenericFragmentPreloadDelegate genericFragmentPreloadDelegate2 = this.fragmentPreloadDelegate;
                k21.f(genericFragmentPreloadDelegate2);
                if (genericFragmentPreloadDelegate2.getPageContainer() != null) {
                    GenericFragmentPreloadDelegate genericFragmentPreloadDelegate3 = this.fragmentPreloadDelegate;
                    k21.f(genericFragmentPreloadDelegate3);
                    PageContainer<ModelValue> pageContainer2 = genericFragmentPreloadDelegate3.getPageContainer();
                    k21.f(pageContainer2);
                    setPageContainer(pageContainer2);
                    getPageContainer().setAdapterFactory(null);
                    GenericFragmentPreloadDelegate genericFragmentPreloadDelegate4 = this.fragmentPreloadDelegate;
                    k21.f(genericFragmentPreloadDelegate4);
                    PageContext pageContext3 = genericFragmentPreloadDelegate4.getPageContext();
                    k21.f(pageContext3);
                    pageContext3.setEventBus(this.pageContext.getEventBus());
                    GenericFragmentPreloadDelegate genericFragmentPreloadDelegate5 = this.fragmentPreloadDelegate;
                    k21.f(genericFragmentPreloadDelegate5);
                    this.recycleViewSettings = genericFragmentPreloadDelegate5.getRecyclerViewSettings();
                    GenericFragmentPreloadDelegate genericFragmentPreloadDelegate6 = this.fragmentPreloadDelegate;
                    k21.f(genericFragmentPreloadDelegate6);
                    PageContext pageContext4 = genericFragmentPreloadDelegate6.getPageContext();
                    k21.f(pageContext4);
                    this.pageContext = pageContext4;
                    IContext base = pageContext4.getBase();
                    if (base != null) {
                        base.setActivity(getActivity());
                    }
                    this.pageContext.setActivity(getActivity());
                    this.pageContext.setFragment(this);
                    PageContext pageContext5 = this.pageContext;
                    GenericFragmentPreloadDelegate genericFragmentPreloadDelegate7 = this.fragmentPreloadDelegate;
                    k21.f(genericFragmentPreloadDelegate7);
                    pageContext5.setConfigManager(genericFragmentPreloadDelegate7.getConfigManager());
                    this.pageContext.setStyleManager(new StyleManager(this));
                    initPageLoader();
                    pageContext2 = this.pageContext;
                    if (pageContext2.getBaseContext() == null) {
                        if (pageContext2.getActivity() instanceof GenericActivity) {
                            Activity activity = pageContext2.getActivity();
                            GenericActivity genericActivity = activity instanceof GenericActivity ? (GenericActivity) activity : null;
                            if (genericActivity != null) {
                                activityContext = genericActivity.getActivityContext();
                            }
                            pageContext2.attachBaseContext(activityContext);
                        } else if (getAttachBaseContext() != null) {
                            pageContext2.attachBaseContext(getAttachBaseContext());
                        } else {
                            pageContext2.attachBaseContext(new ActivityContext());
                        }
                    }
                    initPageStateManager();
                    fragmentInterceptor2 = this.fragmentInterceptor;
                    if (fragmentInterceptor2 == null) {
                        fragmentInterceptor2.onFragmentCreate(bundle);
                        return;
                    }
                    return;
                }
            }
        }
        setPageContainer(initPageContainer(this.pageContext));
        this.pageContext.setPageContainer(getPageContainer());
        this.pageContext.setFragment(this);
        this.pageContext.setActivity(getActivity());
        this.pageContext.setPageName(getPageName());
        this.pageContext.setStyleManager(new StyleManager(this));
        initConfigManager();
        ConfigManager configManager = this.pageContext.getConfigManager();
        if (configManager != null) {
            configManager.setPathConfig(ConfigManager.COMPONENT_CONFIG_FILE, k21.r("android.resource", getConfigPath()));
        }
        initPageLoader();
        pageContext2 = this.pageContext;
        if (pageContext2.getBaseContext() == null) {
        }
        initPageStateManager();
        fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1018832892")) {
            return (Animation) ipChange.ipc$dispatch("1018832892", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        }
        Animation onCreateAnimation = super.onCreateAnimation(i, z, i2);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onCreateAnimation(i, z, i2);
        }
        return onCreateAnimation;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public Animator onCreateAnimator(int i, boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493526440")) {
            return (Animator) ipChange.ipc$dispatch("1493526440", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        }
        Animator onCreateAnimator = super.onCreateAnimator(i, z, i2);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onCreateAnimation(i, z, i2);
        }
        return onCreateAnimator;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122218178")) {
            return (View) ipChange.ipc$dispatch("-122218178", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        k21.i(layoutInflater, "inflater");
        ViewGroup viewGroup2 = null;
        if (getPageStateManager().isStateViewEnable()) {
            viewGroup2 = getPageStateManager().getContentView();
        }
        if (this.realView == null) {
            ViewGroup viewGroup3 = getPageStateManager().isStateViewEnable() ? viewGroup2 : viewGroup;
            View preContentView = getPreContentView(viewGroup3);
            this.realView = preContentView;
            if (preContentView == null) {
                this.realView = layoutInflater.inflate(getLayoutResId(), viewGroup3, false);
            }
        }
        View view = this.realView;
        if (view != null) {
            if (getRefreshLayoutResId() > 0) {
                setRefreshLayout((RefreshLayout) view.findViewById(getRefreshLayoutResId()));
                RefreshLayout refreshLayout2 = getRefreshLayout();
                if (refreshLayout2 != null) {
                    refreshLayout2.setEnableRefresh(false);
                }
                RefreshLayout refreshLayout3 = getRefreshLayout();
                if (refreshLayout3 != null) {
                    refreshLayout3.setEnableLoadMore(true);
                }
            }
            if (getRecyclerViewResId() > 0) {
                setRecyclerView((RecyclerView) view.findViewById(getRecyclerViewResId()));
            }
        }
        initLoadingViewManager(this.refreshLayout);
        initPageStateManager(onContentViewInflated(this.realView));
        List<IDelegate<GenericFragment>> initDelegates = initDelegates(getDelegatePathPrefix());
        this.delegateList = initDelegates;
        wrapperDelegates(initDelegates);
        List<IDelegate<GenericFragment>> list = this.delegateList;
        if (list != null) {
            for (IDelegate<GenericFragment> iDelegate : list) {
                iDelegate.setDelegatedContainer(this);
            }
        }
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onCreateView(layoutInflater, viewGroup, bundle);
        }
        return getPageStateManager().isStateViewEnable() ? viewGroup2 : this.realView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247820474")) {
            ipChange.ipc$dispatch("-1247820474", new Object[]{this});
            return;
        }
        super.onDestroy();
        String pageName = getPageName();
        if (pageName != null) {
            ArchMontiorManager.Companion companion = ArchMontiorManager.Companion;
            ArchMontior archMontior = companion.get(pageName);
            if (archMontior != null) {
                archMontior.uploadComponentsMonitor();
            }
            companion.release(pageName);
        }
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onFragmentDestroy();
        }
        this.isFragmentVisible = false;
        this.rootView = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1716612127")) {
            ipChange.ipc$dispatch("-1716612127", new Object[]{this});
            return;
        }
        super.onDestroyView();
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onDestroyView();
        }
        this.isFragmentVisible = false;
        this.rootView = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427705751")) {
            ipChange.ipc$dispatch("427705751", new Object[]{this});
            return;
        }
        super.onDetach();
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onFragmentDetach();
        }
        EventBus eventBus = this.pageContext.getEventBus();
        if (eventBus != null) {
            eventBus.removeAllStickyEvents();
        }
        EventBus eventBus2 = this.pageContext.getEventBus();
        if (eventBus2 != null) {
            eventBus2.unregister(this);
        }
        unRegisterDelegates(this.delegateList);
        this.pageContext.release();
    }

    public void onFragmentVisibleChange(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741458458")) {
            ipChange.ipc$dispatch("-1741458458", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        try {
            Bundle bundle = this.pageContext.getBundle();
            if (bundle != null) {
                bundle.putBoolean(FragmentEvent.KEY_FRAGMENT_VISIBLE_STATE, z);
            }
        } catch (Throwable th) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw th;
            }
        }
        if (z) {
            updatePvStatics();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1819525327")) {
            return (LayoutInflater) ipChange.ipc$dispatch("-1819525327", new Object[]{this, bundle});
        }
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        k21.h(onGetLayoutInflater, "super.onGetLayoutInflater(savedInstanceState)");
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onGetLayoutInflater(bundle);
        }
        return onGetLayoutInflater;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1279005758")) {
            ipChange.ipc$dispatch("1279005758", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        boolean z2 = !z;
        this.isFragmentVisible = z2;
        onFragmentVisibleChange(z2);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onHiddenChanged(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(@NotNull Context context, @NotNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766386069")) {
            ipChange.ipc$dispatch("1766386069", new Object[]{this, context, attributeSet, bundle});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(attributeSet, TemplateDom.KEY_ATTRS);
        super.onInflate(context, attributeSet, bundle);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onInflate(context, attributeSet, bundle);
        }
    }

    @Subscribe(eventType = {RefreshEvent.ON_LOAD_MORE})
    public void onLoadMore(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246412741")) {
            ipChange.ipc$dispatch("246412741", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        if (getPageContainer().hasNext()) {
            getPageContainer().loadMore();
            return;
        }
        Object obj = event.data;
        RefreshLayout refreshLayout2 = null;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        Object obj2 = hashMap == null ? null : hashMap.get("refreshLayout");
        if (obj2 instanceof RefreshLayout) {
            refreshLayout2 = (RefreshLayout) obj2;
        }
        if (refreshLayout2 != null) {
            refreshLayout2.finishLoadMoreWithNoMoreData();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1491262251")) {
            ipChange.ipc$dispatch("1491262251", new Object[]{this});
            return;
        }
        super.onLowMemory();
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onLowMemory();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-615039662")) {
            ipChange.ipc$dispatch("-615039662", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onMultiWindowModeChanged(z);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onMultiWindowModeChanged(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835322230")) {
            ipChange.ipc$dispatch("-1835322230", new Object[]{this});
            return;
        }
        super.onPause();
        if (this.isSelected && this.isFragmentVisible) {
            setUserVisibleHint(false);
        }
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onFragmentPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76050518")) {
            ipChange.ipc$dispatch("-76050518", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onPictureInPictureModeChanged(z);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onPictureInPictureModeChanged(z);
        }
    }

    @Subscribe(eventType = {RefreshEvent.ON_REFRESH})
    public void onRefresh(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262104015")) {
            ipChange.ipc$dispatch("262104015", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        getPageContainer().reload();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-309911070")) {
            ipChange.ipc$dispatch("-309911070", new Object[]{this, Integer.valueOf(i), strArr, iArr});
            return;
        }
        k21.i(strArr, "permissions");
        k21.i(iArr, WXModule.GRANT_RESULTS);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.youku.arch.v3.io.Callback
    public void onResponse(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1975010710")) {
            ipChange.ipc$dispatch("-1975010710", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onApiResponse(iResponse);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "587372221")) {
            ipChange.ipc$dispatch("587372221", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.isSelected && !this.isFragmentVisible) {
            setUserVisibleHint(true);
        }
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onFragmentResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1775035309")) {
            ipChange.ipc$dispatch("-1775035309", new Object[]{this, bundle});
            return;
        }
        k21.i(bundle, "outState");
        super.onSaveInstanceState(bundle);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792217442")) {
            ipChange.ipc$dispatch("-1792217442", new Object[]{this});
            return;
        }
        super.onStart();
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onFragmentStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647719944")) {
            ipChange.ipc$dispatch("647719944", new Object[]{this});
            return;
        }
        super.onStop();
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onFragmentStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        ContentAdapter adapter;
        Style style;
        StyleManager styleManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1940639647")) {
            ipChange.ipc$dispatch("1940639647", new Object[]{this, view, bundle});
            return;
        }
        k21.i(view, "view");
        this.rootView = view;
        super.onViewCreated(view, bundle);
        if (this.recycleViewSettings == null) {
            this.recycleViewSettings = new RecycleViewSettings(getActivity());
            initRecycleViewSettings();
        }
        RecycleViewSettings recycleViewSettings2 = this.recycleViewSettings;
        if (!(recycleViewSettings2 == null || (adapter = recycleViewSettings2.getAdapter()) == null)) {
            ActivityValue activityValue = getPageContext().getActivityValue();
            if (!(activityValue == null || (style = activityValue.getStyle()) == null || (styleManager = getPageContext().getStyleManager()) == null)) {
                styleManager.updateStyle(style);
            }
            getPageContainer().setContentAdapter(adapter);
            getPageContainer().updateContentAdapter();
        }
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onViewCreated(view, bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175579190")) {
            ipChange.ipc$dispatch("1175579190", new Object[]{this, bundle});
            return;
        }
        super.onViewStateRestored(bundle);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onViewStateRestored(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1251964129")) {
            ipChange.ipc$dispatch("-1251964129", new Object[]{this, bundle});
            return;
        }
        super.setArguments(bundle);
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.setArguments(bundle);
        }
    }

    public final void setAttachBaseContext(@Nullable IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "419419302")) {
            ipChange.ipc$dispatch("419419302", new Object[]{this, iContext});
            return;
        }
        this.attachBaseContext = iContext;
    }

    public final void setDelegateList(@Nullable List<IDelegate<GenericFragment>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "134235341")) {
            ipChange.ipc$dispatch("134235341", new Object[]{this, list});
            return;
        }
        this.delegateList = list;
    }

    public final void setFragmentBackGroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2072138243")) {
            ipChange.ipc$dispatch("-2072138243", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View view = this.realView;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public final void setFragmentBackGroundDrawable(@Nullable Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "524477095")) {
            ipChange.ipc$dispatch("524477095", new Object[]{this, drawable});
            return;
        }
        View view = this.realView;
        if (view != null) {
            view.setBackground(drawable);
        }
    }

    public final void setFragmentInterceptor(@Nullable FragmentInterceptor fragmentInterceptor2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593936451")) {
            ipChange.ipc$dispatch("593936451", new Object[]{this, fragmentInterceptor2});
            return;
        }
        this.fragmentInterceptor = fragmentInterceptor2;
    }

    public final void setFragmentPreloadDelegate(@Nullable GenericFragmentPreloadDelegate genericFragmentPreloadDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869880838")) {
            ipChange.ipc$dispatch("-869880838", new Object[]{this, genericFragmentPreloadDelegate});
            return;
        }
        this.fragmentPreloadDelegate = genericFragmentPreloadDelegate;
    }

    /* access modifiers changed from: protected */
    public final void setFragmentVisible(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913606923")) {
            ipChange.ipc$dispatch("1913606923", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isFragmentVisible = z;
    }

    /* access modifiers changed from: protected */
    public void setInitResponse(@Nullable IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "850372847")) {
            ipChange.ipc$dispatch("850372847", new Object[]{this, iResponse});
            return;
        }
        this.initResponse = iResponse;
    }

    public void setNoMore(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1402885525")) {
            ipChange.ipc$dispatch("-1402885525", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        RefreshLayout refreshLayout2 = this.refreshLayout;
        if (refreshLayout2 != null) {
            if (z) {
                refreshLayout2.finishLoadMoreWithNoMoreData();
            } else {
                refreshLayout2.setEnableLoadMore(true);
            }
            refreshLayout2.setEnableAutoLoadMore(!z);
            if (z) {
                refreshLayout2.setFooterHeight(getNoMoreFootHeight());
            } else {
                refreshLayout2.setFooterHeight(getLoadingFootHeight());
            }
            refreshLayout2.setNoMoreData(z);
        }
    }

    public void setPageContainer(@NotNull IContainer<ModelValue> iContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257683869")) {
            ipChange.ipc$dispatch("-1257683869", new Object[]{this, iContainer});
            return;
        }
        k21.i(iContainer, "<set-?>");
        this.pageContainer = iContainer;
    }

    public final void setPageContext(@NotNull PageContext pageContext2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1119558627")) {
            ipChange.ipc$dispatch("-1119558627", new Object[]{this, pageContext2});
            return;
        }
        k21.i(pageContext2, "<set-?>");
        this.pageContext = pageContext2;
    }

    public void setPageLoader(@NotNull PageLoader pageLoader2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "365336243")) {
            ipChange.ipc$dispatch("365336243", new Object[]{this, pageLoader2});
            return;
        }
        k21.i(pageLoader2, "<set-?>");
        this.pageLoader = pageLoader2;
    }

    public final void setPageSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1503536511")) {
            ipChange.ipc$dispatch("1503536511", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isSelected = z;
        if (z) {
            setUserVisibleHint(true);
        }
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.onPageSelected(z);
        }
    }

    public final void setPageStateManager(@NotNull PageStateManager pageStateManager2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1320227089")) {
            ipChange.ipc$dispatch("1320227089", new Object[]{this, pageStateManager2});
            return;
        }
        k21.i(pageStateManager2, "<set-?>");
        this.pageStateManager = pageStateManager2;
    }

    public final void setRealView(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618593814")) {
            ipChange.ipc$dispatch("1618593814", new Object[]{this, view});
            return;
        }
        this.realView = view;
    }

    public final void setRecycleViewSettings(@Nullable RecycleViewSettings recycleViewSettings2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-853229321")) {
            ipChange.ipc$dispatch("-853229321", new Object[]{this, recycleViewSettings2});
            return;
        }
        this.recycleViewSettings = recycleViewSettings2;
    }

    public final void setRecyclerView(@Nullable RecyclerView recyclerView2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1260504804")) {
            ipChange.ipc$dispatch("-1260504804", new Object[]{this, recyclerView2});
            return;
        }
        this.recyclerView = recyclerView2;
    }

    public final void setRefreshLayout(@Nullable RefreshLayout refreshLayout2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1654236763")) {
            ipChange.ipc$dispatch("1654236763", new Object[]{this, refreshLayout2});
            return;
        }
        this.refreshLayout = refreshLayout2;
    }

    /* access modifiers changed from: protected */
    public final void setSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1504552880")) {
            ipChange.ipc$dispatch("-1504552880", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isSelected = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-829482409")) {
            ipChange.ipc$dispatch("-829482409", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        if (isAdded() && this.isFragmentVisible != z) {
            this.isFragmentVisible = z;
            onFragmentVisibleChange(z);
        }
        FragmentInterceptor fragmentInterceptor2 = this.fragmentInterceptor;
        if (fragmentInterceptor2 != null) {
            fragmentInterceptor2.setUserVisibleHint(z);
        }
    }

    @Override // com.youku.arch.v3.page.IStatics
    public void updatePvStatics() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-942774421")) {
            ipChange.ipc$dispatch("-942774421", new Object[]{this});
        }
    }

    @Nullable
    public List<IDelegate<GenericFragment>> wrapperDelegates(@Nullable List<IDelegate<GenericFragment>> list) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "878255208")) {
            return list;
        }
        return (List) ipChange.ipc$dispatch("878255208", new Object[]{this, list});
    }

    @NotNull
    /* renamed from: getPageLoader  reason: collision with other method in class */
    public final PagingLoader m887getPageLoader() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1959912404")) {
            return getPageContainer().getPageLoader();
        }
        return (PagingLoader) ipChange.ipc$dispatch("-1959912404", new Object[]{this});
    }

    public void initPageStateManager(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-812994556")) {
            ipChange.ipc$dispatch("-812994556", new Object[]{this, view});
            return;
        }
        PageStateManager pageStateManager2 = getPageStateManager();
        pageStateManager2.setOnConfigStateViewListener(new GenericFragment$initPageStateManager$1$1(this));
        pageStateManager2.setStateProperty(State.SUCCESS, new StateSuccessView(view));
    }
}
