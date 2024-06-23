package com.youku.gaiax;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.taobao.weex.WXGlobalEventReceiver;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import com.youku.gaiax.api.context.IContextParams;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.PipelineParams;
import com.youku.gaiax.api.data.TrackParams;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.api.proxy.IProxyViews;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.common.utils.ScreenUtils;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.register.GXExtensionColor;
import com.youku.gaiax.impl.register.GXExtensionCompatibility;
import com.youku.gaiax.impl.register.GXExtensionContainerDataUpdate;
import com.youku.gaiax.impl.register.GXExtensionContainerItemBind;
import com.youku.gaiax.impl.register.GXExtensionDataBinding;
import com.youku.gaiax.impl.register.GXExtensionDynamicProperty;
import com.youku.gaiax.impl.register.GXExtensionException;
import com.youku.gaiax.impl.register.GXExtensionExpression;
import com.youku.gaiax.impl.register.GXExtensionGrid;
import com.youku.gaiax.impl.register.GXExtensionLottieAnimation;
import com.youku.gaiax.impl.register.GXExtensionNodeEvent;
import com.youku.gaiax.impl.register.GXExtensionScroll;
import com.youku.gaiax.impl.register.GXExtensionSize;
import com.youku.gaiax.impl.register.GXExtensionStaticProperty;
import com.youku.gaiax.impl.register.GXExtensionTemplateAssetsSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateInfoSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateRealTimeSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource;
import com.youku.gaiax.impl.register.remote.GaiaXRemoteSourceUtils;
import com.youku.gaiax.impl.utils.GaiaXUtils;
import com.youku.gaiax.impl.utils.PropUtils;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ob2;
import tb.xq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u00142\u00020\u0001:\r\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f B\u0011\b\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/youku/gaiax/GaiaX;", "Lcom/youku/gaiax/IGaiaXApi;", "Lcom/youku/gaiax/GaiaX$Params;", "params", "Ltb/ur2;", "reloadView", "bindView", "unbindView", "visibleView", "invisibleView", "visiblePage", "invisiblePage", "Lcom/youku/gaiax/IExperiment;", "experiment", "Lcom/youku/gaiax/IStable;", Constants.Name.STABLE, "impl", "Lcom/youku/gaiax/IGaiaXApi;", "<init>", "(Lcom/youku/gaiax/IGaiaXApi;)V", "Companion", "IAnimationDelegate", "IDataPipeline5", "IEventDelegate", "IHostMessage", "IRouterDelegate2", "IRule", "IScrollDataDiffCallBack", "IScrollDelegate", "IScrollItemStatusDelegate", "IStatusDelegate", "ITrackDelegate3", "Params", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaX implements IGaiaXApi {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "[GaiaX]";
    @Nullable
    private static Context appContext;
    @NotNull
    private static final Lazy<GaiaX> instance$delegate = b.b(GaiaX$Companion$instance$2.INSTANCE);
    @NotNull
    private final IGaiaXApi impl;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8F@\u0006X\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/youku/gaiax/GaiaX$Companion;", "", "Ltb/ur2;", "injectImpl", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, UCCore.LEGACY_EVENT_INIT, "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "Lcom/youku/gaiax/GaiaX;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/GaiaX;", "instance", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        /* access modifiers changed from: private */
        public final void injectImpl() {
            Class<?> lottieViewClass;
            Class<?> imageViewClass;
            Log log = Log.INSTANCE;
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - 开始");
                log.d("[GaiaX]", k21.r("GaiaX初始化逻辑 - 应用上下文 = ", getAppContext()));
            }
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - GaiaXProxy - start");
            }
            GaiaXProxy.Companion companion = GaiaXProxy.Companion;
            companion.getInstance().initModules();
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - GaiaXProxy - end");
            }
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - GXTemplateEngine - start");
            }
            Context appContext = getAppContext();
            if (appContext != null) {
                GXTemplateEngine.Companion.a().q(appContext);
                GXRegisterCenter.a aVar = GXRegisterCenter.Companion;
                aVar.a().u(new GXExtensionDataBinding()).x(GXExtensionExpression.Companion.getInstance()).q(new GXExtensionColor()).C(new GXExtensionSize()).r(new GXExtensionCompatibility()).v(new GXExtensionDynamicProperty()).D(new GXExtensionStaticProperty()).B(new GXExtensionScroll()).y(new GXExtensionGrid()).A(new GXExtensionNodeEvent()).s(new GXExtensionContainerDataUpdate()).t(new GXExtensionContainerItemBind()).E(GXExtensionTemplateInfoSource.Companion.getInstance(), 0).F(GXExtensionTemplateAssetsSource.Companion.assetsInstance(), 1).F(GXExtensionTemplateRemoteSource.Companion.remoteInstance(), 2).F(GXExtensionTemplateRealTimeSource.Companion.getInstance(), 15).z(new GXExtensionLottieAnimation()).w(new GXExtensionException());
                IProxyViews views = companion.getInstance().getViews();
                if (!(views == null || (imageViewClass = views.getImageViewClass()) == null)) {
                    aVar.a().G("image", imageViewClass);
                }
                IProxyViews views2 = companion.getInstance().getViews();
                if (!(views2 == null || (lottieViewClass = views2.getLottieViewClass()) == null)) {
                    aVar.a().G("lottie", lottieViewClass);
                }
            }
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - GXTemplateEngine - end");
            }
            if (log.isLaunchLog()) {
                IProxyApp app2 = companion.getInstance().getApp();
                String str = null;
                log.e("[GaiaX]", k21.r("GaiaX初始化逻辑 - 基础信息[UTDID] = ", app2 == null ? null : app2.getUtdid()));
                GaiaXRemoteSourceUtils gaiaXRemoteSourceUtils = GaiaXRemoteSourceUtils.INSTANCE;
                log.e("[GaiaX]", k21.r("GaiaX初始化逻辑 - 基础信息[环境] = ", gaiaXRemoteSourceUtils.getOnlineStatusText()));
                log.e("[GaiaX]", k21.r("GaiaX初始化逻辑 - 基础信息[环境-转义]= ", gaiaXRemoteSourceUtils.getOnlineStatus()));
                IProxyApp app3 = companion.getInstance().getApp();
                if (app3 != null) {
                    str = app3.getAppVersionName();
                }
                log.e("[GaiaX]", k21.r("GaiaX初始化逻辑 - 基础信息[应用版本] = ", str));
                log.e("[GaiaX]", k21.r("GaiaX初始化逻辑 - 基础信息[应用版本-转义] = ", Long.valueOf(gaiaXRemoteSourceUtils.getAppVersion())));
                log.e("[GaiaX]", k21.r("GaiaX初始化逻辑 - 基础信息[是否正式版] = ", Boolean.valueOf(GaiaXUtils.INSTANCE.isAppPublishVersion())));
                PropUtils propUtils = PropUtils.INSTANCE;
                log.e("[GaiaX]", k21.r("GaiaX初始化逻辑 - 开关状态[日志] = ", Boolean.valueOf(propUtils.isLog())));
                log.e("[GaiaX]", k21.r("GaiaX初始化逻辑 - 开关状态[远程模板] = ", Boolean.valueOf(propUtils.m900isRemote())));
                log.e("[GaiaX]", k21.r("GaiaX初始化逻辑 - 开关状态[JSLog] = ", Boolean.valueOf(propUtils.isJSLog())));
            }
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - 结束");
            }
        }

        @Nullable
        public final Context getAppContext() {
            return GaiaX.appContext;
        }

        @NotNull
        public final GaiaX getInstance() {
            return (GaiaX) GaiaX.instance$delegate.getValue();
        }

        public final void init(@NotNull Context context) {
            k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
            setAppContext(context);
            PropUtils.INSTANCE.init(context);
            Log log = Log.INSTANCE;
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - init");
            }
        }

        public final void setAppContext(@Nullable Context context) {
            GaiaX.appContext = context;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/GaiaX$IAnimationDelegate;", "", "", "targetId", "Landroid/view/View;", "targetView", "Lcom/alibaba/fastjson/JSONObject;", "animationData", "Ltb/ur2;", "onAnimationStart", "onAnimationFinish", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface IAnimationDelegate {
        void onAnimationFinish(@NotNull String str, @NotNull View view, @NotNull JSONObject jSONObject);

        void onAnimationStart(@NotNull String str, @NotNull View view, @NotNull JSONObject jSONObject);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/youku/gaiax/GaiaX$IDataPipeline5;", "", "Lcom/youku/gaiax/api/data/PipelineParams;", "pipelineParams", "process", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface IDataPipeline5 {
        @Nullable
        Object process(@NotNull PipelineParams pipelineParams);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/youku/gaiax/GaiaX$IEventDelegate;", "", "Lcom/youku/gaiax/api/data/EventParams;", WXGlobalEventReceiver.EVENT_PARAMS, "Ltb/ur2;", "onEvent", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface IEventDelegate {
        void onEvent(@NotNull EventParams eventParams);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/GaiaX$IHostMessage;", "", "", "type", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onMessage", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface IHostMessage {
        boolean onMessage(@NotNull String str, @NotNull JSONObject jSONObject);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\u000e"}, d2 = {"Lcom/youku/gaiax/GaiaX$IRouterDelegate2;", "", "Landroid/view/View;", "targetView", "", "targetViewId", "", "targetPosition", "Lcom/alibaba/fastjson/JSONObject;", "targetData", "Lcom/youku/gaiax/GaiaX$Params;", "targetParams", "Ltb/ur2;", "onAction", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    @Deprecated(message = "")
    /* compiled from: Taobao */
    public interface IRouterDelegate2 {
        void onAction(@NotNull View view, @NotNull String str, int i, @NotNull JSONObject jSONObject, @NotNull Params params);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/GaiaX$IRule;", "", "", "targetViewId", "Landroid/view/View;", "targetView", "", "isRule", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface IRule {
        boolean isRule(@NotNull String str, @NotNull View view);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/youku/gaiax/GaiaX$IScrollDataDiffCallBack;", "", "", "templateId", "Lcom/alibaba/fastjson/JSONArray;", "oldDatas", "newDatas", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "doDiff", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface IScrollDataDiffCallBack {
        @Nullable
        DiffUtil.Callback doDiff(@NotNull String str, @NotNull JSONArray jSONArray, @NotNull JSONArray jSONArray2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/GaiaX$IScrollDelegate;", "", "Landroid/view/View;", "view", "", "newState", "Ltb/ur2;", GXTemplateEngine.f.TYPE_ON_SCROLL_STATE_CHANGED, "dx", Constants.Name.DISTANCE_Y, GXTemplateEngine.f.TYPE_ON_SCROLLED, "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface IScrollDelegate {
        void onScrollStateChanged(@NotNull View view, int i);

        void onScrolled(@NotNull View view, int i, int i2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/GaiaX$IScrollItemStatusDelegate;", "", "Lcom/youku/gaiax/GaiaX$Params;", "params", "Landroid/view/View;", "resultView", "", "position", "Ltb/ur2;", "onViewInjected", "onViewUpdated", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface IScrollItemStatusDelegate {
        void onViewInjected(@NotNull Params params, @NotNull View view, int i);

        void onViewUpdated(@NotNull Params params, @NotNull View view, int i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/youku/gaiax/GaiaX$IStatusDelegate;", "", "Lcom/youku/gaiax/GaiaX$Params;", "params", "Landroid/view/View;", "resultView", "Ltb/ur2;", "onViewInjected", "onViewUpdated", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface IStatusDelegate {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class DefaultImpls {
            public static void onViewInjected(@NotNull IStatusDelegate iStatusDelegate, @NotNull Params params, @NotNull View view) {
                k21.i(iStatusDelegate, "this");
                k21.i(params, "params");
                k21.i(view, "resultView");
            }

            public static void onViewUpdated(@NotNull IStatusDelegate iStatusDelegate, @NotNull Params params, @NotNull View view) {
                k21.i(iStatusDelegate, "this");
                k21.i(params, "params");
                k21.i(view, "resultView");
            }
        }

        void onViewInjected(@NotNull Params params, @NotNull View view);

        void onViewUpdated(@NotNull Params params, @NotNull View view);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/youku/gaiax/GaiaX$ITrackDelegate3;", "", "Lcom/youku/gaiax/api/data/TrackParams;", "trackParams", "Ltb/ur2;", "onTrack", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface ITrackDelegate3 {
        void onTrack(@NotNull TrackParams trackParams);
    }

    private GaiaX(IGaiaXApi iGaiaXApi) {
        this.impl = iGaiaXApi;
    }

    public /* synthetic */ GaiaX(IGaiaXApi iGaiaXApi, m40 m40) {
        this(iGaiaXApi);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void bindView(@NotNull Params params) {
        k21.i(params, "params");
        this.impl.bindView(params);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    @Nullable
    public IExperiment experiment() {
        return this.impl.experiment();
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void invisiblePage(@NotNull Params params) {
        k21.i(params, "params");
        this.impl.invisiblePage(params);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void invisibleView(@NotNull Params params) {
        k21.i(params, "params");
        this.impl.invisibleView(params);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void reloadView(@NotNull Params params) {
        k21.i(params, "params");
        this.impl.reloadView(params);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    @Nullable
    public IStable stable() {
        return this.impl.stable();
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void unbindView(@NotNull Params params) {
        k21.i(params, "params");
        this.impl.unbindView(params);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void visiblePage(@NotNull Params params) {
        k21.i(params, "params");
        this.impl.visiblePage(params);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void visibleView(@NotNull Params params) {
        k21.i(params, "params");
        this.impl.visibleView(params);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ¦\u00012\u00020\u0001:\u0004§\u0001¦\u0001BX\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\u0013\b\u0002\u0010\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u00010\u0001¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u00101\u001a\u00020'8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u0010)\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR*\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bJ\u0010K\u0012\u0004\bP\u0010Q\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010S\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Z\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010a\u001a\u0004\u0018\u00010`8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010h\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR$\u0010o\u001a\u0004\u0018\u00010n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010v\u001a\u00020u8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R$\u0010|\u001a\u0004\u0018\u00010u8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b|\u0010w\u001a\u0004\b}\u0010y\"\u0004\b~\u0010{R)\u0010\u0001\u001a\u000208\u0000@\u0000X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u000208\u0000@\u0000X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R&\u0010\u0001\u001a\u00020'8\u0000@\u0000X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010)\u001a\u0005\b\u0001\u0010+\"\u0005\b\u0001\u0010-R8\u0010\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0001\u0012\u0005\u0012\u00030\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R3\u0010\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R,\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001¨\u0006¨\u0001"}, d2 = {"Lcom/youku/gaiax/GaiaX$Params;", "Lcom/youku/gaiax/api/context/IContextParams;", "Ltb/ur2;", "release", "", "toString", "templateId", "Ljava/lang/String;", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "templateVersion", "getTemplateVersion", "setTemplateVersion", "templateBiz", "getTemplateBiz", "setTemplateBiz", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Landroid/view/View;", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "setContainer", "(Landroid/view/View;)V", "Lcom/alibaba/fastjson/JSONObject;", "data", "Lcom/alibaba/fastjson/JSONObject;", "getData", "()Lcom/alibaba/fastjson/JSONObject;", "setData", "(Lcom/alibaba/fastjson/JSONObject;)V", "", "openMinHeight", "Z", "getOpenMinHeight", "()Z", "setOpenMinHeight", "(Z)V", "forceCreate", "getForceCreate", "setForceCreate", "forceLocalTemplate", "getForceLocalTemplate", "setForceLocalTemplate", "Lcom/youku/gaiax/GaiaX$IScrollDataDiffCallBack;", "scrollDataDiffCallBackDelegate", "Lcom/youku/gaiax/GaiaX$IScrollDataDiffCallBack;", "getScrollDataDiffCallBackDelegate", "()Lcom/youku/gaiax/GaiaX$IScrollDataDiffCallBack;", "setScrollDataDiffCallBackDelegate", "(Lcom/youku/gaiax/GaiaX$IScrollDataDiffCallBack;)V", "Lcom/youku/gaiax/GaiaX$IScrollDelegate;", "scrollDelegate", "Lcom/youku/gaiax/GaiaX$IScrollDelegate;", "getScrollDelegate", "()Lcom/youku/gaiax/GaiaX$IScrollDelegate;", "setScrollDelegate", "(Lcom/youku/gaiax/GaiaX$IScrollDelegate;)V", "Lcom/youku/gaiax/GaiaX$IHostMessage;", "message", "Lcom/youku/gaiax/GaiaX$IHostMessage;", "getMessage", "()Lcom/youku/gaiax/GaiaX$IHostMessage;", "setMessage", "(Lcom/youku/gaiax/GaiaX$IHostMessage;)V", "Lcom/youku/gaiax/GaiaX$IRouterDelegate2;", "routerDelegate2", "Lcom/youku/gaiax/GaiaX$IRouterDelegate2;", "getRouterDelegate2", "()Lcom/youku/gaiax/GaiaX$IRouterDelegate2;", "setRouterDelegate2", "(Lcom/youku/gaiax/GaiaX$IRouterDelegate2;)V", "getRouterDelegate2$annotations", "()V", "Lcom/youku/gaiax/GaiaX$IEventDelegate;", "eventDelegate", "Lcom/youku/gaiax/GaiaX$IEventDelegate;", "getEventDelegate", "()Lcom/youku/gaiax/GaiaX$IEventDelegate;", "setEventDelegate", "(Lcom/youku/gaiax/GaiaX$IEventDelegate;)V", "Lcom/youku/gaiax/GaiaX$ITrackDelegate3;", "trackDelegate3", "Lcom/youku/gaiax/GaiaX$ITrackDelegate3;", "getTrackDelegate3", "()Lcom/youku/gaiax/GaiaX$ITrackDelegate3;", "setTrackDelegate3", "(Lcom/youku/gaiax/GaiaX$ITrackDelegate3;)V", "Lcom/youku/gaiax/GaiaX$IStatusDelegate;", "statusDelegate", "Lcom/youku/gaiax/GaiaX$IStatusDelegate;", "getStatusDelegate", "()Lcom/youku/gaiax/GaiaX$IStatusDelegate;", "setStatusDelegate", "(Lcom/youku/gaiax/GaiaX$IStatusDelegate;)V", "Lcom/youku/gaiax/GaiaX$IScrollItemStatusDelegate;", "scrollItemStatusDelegate", "Lcom/youku/gaiax/GaiaX$IScrollItemStatusDelegate;", "getScrollItemStatusDelegate", "()Lcom/youku/gaiax/GaiaX$IScrollItemStatusDelegate;", "setScrollItemStatusDelegate", "(Lcom/youku/gaiax/GaiaX$IScrollItemStatusDelegate;)V", "Lcom/youku/gaiax/GaiaX$IAnimationDelegate;", "animationDelegate", "Lcom/youku/gaiax/GaiaX$IAnimationDelegate;", "getAnimationDelegate", "()Lcom/youku/gaiax/GaiaX$IAnimationDelegate;", "setAnimationDelegate", "(Lcom/youku/gaiax/GaiaX$IAnimationDelegate;)V", "Lcom/youku/gaiax/LoadType;", "mode", "Lcom/youku/gaiax/LoadType;", "getMode", "()Lcom/youku/gaiax/LoadType;", "setMode", "(Lcom/youku/gaiax/LoadType;)V", "childLoadMode", "getChildLoadMode$GaiaX_Android", "setChildLoadMode$GaiaX_Android", "", "indexPosition", "I", "getIndexPosition$GaiaX_Android", "()I", "setIndexPosition$GaiaX_Android", "(I)V", "scrollPosition", "getScrollPosition$GaiaX_Android", "setScrollPosition$GaiaX_Android", "isReleased", "isReleased$GaiaX_Android", "setReleased$GaiaX_Android", "", "Lcom/youku/gaiax/GaiaX$IRule;", "Lcom/youku/gaiax/GaiaX$IDataPipeline5;", "dataPipelines5", "Ljava/util/Map;", "getDataPipelines5", "()Ljava/util/Map;", "setDataPipelines5", "(Ljava/util/Map;)V", "Ltb/ob2;", "", "viewPort", "Ltb/ob2;", "getViewPort", "()Ltb/ob2;", "setViewPort", "(Ltb/ob2;)V", "Ltb/xq0;", "childVisualNestTemplateNode", "Ltb/xq0;", "getChildVisualNestTemplateNode", "()Ltb/xq0;", "setChildVisualNestTemplateNode", "(Ltb/xq0;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Landroid/view/View;Lcom/alibaba/fastjson/JSONObject;Ltb/ob2;)V", "Companion", "Builder", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Params implements IContextParams {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @Nullable
        private IAnimationDelegate animationDelegate;
        @Nullable
        private LoadType childLoadMode;
        @Nullable
        private xq0 childVisualNestTemplateNode;
        @Nullable
        private View container;
        @Nullable
        private Context context;
        @Nullable
        private JSONObject data;
        @NotNull
        private Map<IRule, IDataPipeline5> dataPipelines5;
        @Nullable
        private IEventDelegate eventDelegate;
        private boolean forceCreate;
        private boolean forceLocalTemplate;
        private int indexPosition;
        private boolean isReleased;
        @Nullable
        private IHostMessage message;
        @NotNull
        private LoadType mode;
        private boolean openMinHeight;
        @Nullable
        private IRouterDelegate2 routerDelegate2;
        @Nullable
        private IScrollDataDiffCallBack scrollDataDiffCallBackDelegate;
        @Nullable
        private IScrollDelegate scrollDelegate;
        @Nullable
        private IScrollItemStatusDelegate scrollItemStatusDelegate;
        private int scrollPosition;
        @Nullable
        private IStatusDelegate statusDelegate;
        @NotNull
        private String templateBiz;
        @NotNull
        private String templateId;
        @NotNull
        private String templateVersion;
        @Nullable
        private ITrackDelegate3 trackDelegate3;
        @NotNull
        private ob2<Float> viewPort;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001dR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010 R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010!R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010!R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\"R\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\"R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\"R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010&¨\u0006)"}, d2 = {"Lcom/youku/gaiax/GaiaX$Params$Builder;", "", "", "id", "templateId", "templateBiz", "templateVersion", "Landroid/view/View;", "container", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/alibaba/fastjson/JSONObject;", "data", "Lcom/youku/gaiax/LoadType;", "mode", "childMode", "", "state", "forceCreate", "forceLocalTemplate", "openMinHeight", "", "scrollPosition", "Lcom/youku/gaiax/GaiaX$Params;", "buildWithScreenWidth", "", "width", "height", "build", "Ljava/lang/String;", "Landroid/view/View;", "Landroid/content/Context;", "Lcom/alibaba/fastjson/JSONObject;", "Ljava/lang/Float;", "Z", "loadMode", "Lcom/youku/gaiax/LoadType;", "childLoadMode", "I", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Builder {
            @Nullable
            private LoadType childLoadMode;
            @Nullable
            private View container;
            @Nullable
            private Context context;
            @Nullable
            private JSONObject data;
            private boolean forceCreate;
            private boolean forceLocalTemplate;
            @Nullable
            private Float height;
            @NotNull
            private LoadType loadMode = LoadType.ASYNC_NORMAL;
            private boolean openMinHeight;
            private int scrollPosition;
            @Nullable
            private String templateBiz;
            @Nullable
            private String templateId;
            @Nullable
            private String templateVersion;
            @Nullable
            private Float width;

            @NotNull
            public final Params build() {
                View view = this.container;
                if (view != null) {
                    String str = this.templateId;
                    if (str != null) {
                        String str2 = this.templateBiz;
                        if (str2 != null) {
                            String str3 = this.templateVersion;
                            if (str3 == null) {
                                str3 = "";
                            }
                            Params newInstance$GaiaX_Android = Params.Companion.newInstance$GaiaX_Android(str, str3, str2, view, this.data, this.width, this.height);
                            newInstance$GaiaX_Android.setForceCreate(this.forceCreate);
                            newInstance$GaiaX_Android.setOpenMinHeight(this.openMinHeight);
                            newInstance$GaiaX_Android.setForceLocalTemplate(this.forceLocalTemplate);
                            newInstance$GaiaX_Android.setMode(this.loadMode);
                            newInstance$GaiaX_Android.setChildLoadMode$GaiaX_Android(this.childLoadMode);
                            newInstance$GaiaX_Android.setScrollPosition$GaiaX_Android(this.scrollPosition);
                            return newInstance$GaiaX_Android;
                        }
                        throw new IllegalArgumentException("param templateBiz is null");
                    }
                    throw new IllegalArgumentException("param templateId is null");
                }
                throw new IllegalArgumentException("param container is null");
            }

            @NotNull
            public final Params buildWithScreenWidth() {
                if (this.container != null) {
                    this.width = Float.valueOf(ScreenUtils.INSTANCE.getScreenWidthPx());
                }
                return build();
            }

            @NotNull
            public final Builder childMode(@Nullable LoadType loadType) {
                this.childLoadMode = loadType;
                return this;
            }

            @NotNull
            public final Builder container(@Nullable View view) {
                this.container = view;
                return this;
            }

            @NotNull
            public final Builder context(@Nullable Context context2) {
                this.context = context2;
                return this;
            }

            @NotNull
            public final Builder data(@Nullable JSONObject jSONObject) {
                this.data = jSONObject;
                return this;
            }

            @NotNull
            public final Builder forceCreate(boolean z) {
                this.forceCreate = z;
                return this;
            }

            @NotNull
            public final Builder forceLocalTemplate(boolean z) {
                this.forceLocalTemplate = z;
                return this;
            }

            @NotNull
            public final Builder height(float f) {
                this.height = Float.valueOf(f);
                return this;
            }

            @Deprecated(message = "")
            @NotNull
            public final Builder id(@Nullable String str) {
                this.templateId = str;
                return this;
            }

            @NotNull
            public final Builder mode(@NotNull LoadType loadType) {
                k21.i(loadType, "mode");
                this.loadMode = loadType;
                return this;
            }

            @NotNull
            public final Builder openMinHeight(boolean z) {
                this.openMinHeight = z;
                return this;
            }

            @NotNull
            public final Builder scrollPosition(int i) {
                this.scrollPosition = i;
                return this;
            }

            @NotNull
            public final Builder templateBiz(@Nullable String str) {
                this.templateBiz = str;
                return this;
            }

            @NotNull
            public final Builder templateId(@Nullable String str) {
                this.templateId = str;
                return this;
            }

            @NotNull
            public final Builder templateVersion(@Nullable String str) {
                this.templateVersion = str;
                return this;
            }

            @NotNull
            public final Builder width(float f) {
                this.width = Float.valueOf(f);
                return this;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016JK\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJS\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/GaiaX$Params$Companion;", "", "", "templateId", "templateBiz", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/alibaba/fastjson/JSONObject;", "data", "", "viewWidth", Constants.Name.VIEW_HEIGHT, "Lcom/youku/gaiax/GaiaX$Params;", "newPreLoadInstance", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/Float;Ljava/lang/Float;)Lcom/youku/gaiax/GaiaX$Params;", "templateVersion", "Landroid/view/View;", "container", "newInstance$GaiaX_Android", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/Float;Ljava/lang/Float;)Lcom/youku/gaiax/GaiaX$Params;", "newInstance", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            public static /* synthetic */ Params newInstance$GaiaX_Android$default(Companion companion, String str, String str2, String str3, View view, JSONObject jSONObject, Float f, Float f2, int i, Object obj) {
                return companion.newInstance$GaiaX_Android(str, str2, str3, view, (i & 16) != 0 ? null : jSONObject, (i & 32) != 0 ? null : f, (i & 64) != 0 ? null : f2);
            }

            private final Params newPreLoadInstance(String str, String str2, Context context, JSONObject jSONObject, Float f, Float f2) {
                return new Params(str, "", str2, context, null, jSONObject, new ob2(f, f2), null);
            }

            static /* synthetic */ Params newPreLoadInstance$default(Companion companion, String str, String str2, Context context, JSONObject jSONObject, Float f, Float f2, int i, Object obj) {
                return companion.newPreLoadInstance(str, str2, context, (i & 8) != 0 ? null : jSONObject, (i & 16) != 0 ? null : f, (i & 32) != 0 ? null : f2);
            }

            @NotNull
            public final Params newInstance$GaiaX_Android(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull View view, @Nullable JSONObject jSONObject, @Nullable Float f, @Nullable Float f2) {
                k21.i(str, "templateId");
                k21.i(str2, "templateVersion");
                k21.i(str3, "templateBiz");
                k21.i(view, "container");
                return new Params(str, str2, str3, view.getContext(), view, jSONObject, new ob2(f, f2), null);
            }
        }

        private Params(String str, String str2, String str3, Context context2, View view, JSONObject jSONObject, ob2<Float> ob2) {
            this.templateId = str;
            this.templateVersion = str2;
            this.templateBiz = str3;
            this.context = context2;
            this.container = view;
            this.data = jSONObject;
            this.viewPort = ob2;
            LoadType loadType = LoadType.ASYNC_NORMAL;
            this.mode = loadType;
            this.childLoadMode = loadType;
            this.indexPosition = -1;
            this.dataPipelines5 = new ConcurrentHashMap();
        }

        public /* synthetic */ Params(String str, String str2, String str3, Context context2, View view, JSONObject jSONObject, ob2 ob2, m40 m40) {
            this(str, str2, str3, context2, view, jSONObject, ob2);
        }

        @Deprecated(message = "")
        public static /* synthetic */ void getRouterDelegate2$annotations() {
        }

        @Nullable
        public final IAnimationDelegate getAnimationDelegate() {
            return this.animationDelegate;
        }

        @Nullable
        public final LoadType getChildLoadMode$GaiaX_Android() {
            return this.childLoadMode;
        }

        @Nullable
        public final xq0 getChildVisualNestTemplateNode() {
            return this.childVisualNestTemplateNode;
        }

        @Nullable
        public final View getContainer() {
            return this.container;
        }

        @Nullable
        public final Context getContext() {
            return this.context;
        }

        @Nullable
        public final JSONObject getData() {
            return this.data;
        }

        @NotNull
        public final Map<IRule, IDataPipeline5> getDataPipelines5() {
            return this.dataPipelines5;
        }

        @Nullable
        public final IEventDelegate getEventDelegate() {
            return this.eventDelegate;
        }

        public final boolean getForceCreate() {
            return this.forceCreate;
        }

        public final boolean getForceLocalTemplate() {
            return this.forceLocalTemplate;
        }

        public final int getIndexPosition$GaiaX_Android() {
            return this.indexPosition;
        }

        @Nullable
        public final IHostMessage getMessage() {
            return this.message;
        }

        @NotNull
        public final LoadType getMode() {
            return this.mode;
        }

        public final boolean getOpenMinHeight() {
            return this.openMinHeight;
        }

        @Nullable
        public final IRouterDelegate2 getRouterDelegate2() {
            return this.routerDelegate2;
        }

        @Nullable
        public final IScrollDataDiffCallBack getScrollDataDiffCallBackDelegate() {
            return this.scrollDataDiffCallBackDelegate;
        }

        @Nullable
        public final IScrollDelegate getScrollDelegate() {
            return this.scrollDelegate;
        }

        @Nullable
        public final IScrollItemStatusDelegate getScrollItemStatusDelegate() {
            return this.scrollItemStatusDelegate;
        }

        public final int getScrollPosition$GaiaX_Android() {
            return this.scrollPosition;
        }

        @Nullable
        public final IStatusDelegate getStatusDelegate() {
            return this.statusDelegate;
        }

        @NotNull
        public final String getTemplateBiz() {
            return this.templateBiz;
        }

        @NotNull
        public final String getTemplateId() {
            return this.templateId;
        }

        @NotNull
        public final String getTemplateVersion() {
            return this.templateVersion;
        }

        @Nullable
        public final ITrackDelegate3 getTrackDelegate3() {
            return this.trackDelegate3;
        }

        @NotNull
        public final ob2<Float> getViewPort() {
            return this.viewPort;
        }

        public final boolean isReleased$GaiaX_Android() {
            return this.isReleased;
        }

        public final void release() {
            Log log = Log.INSTANCE;
            if (log.isLog()) {
                log.d("[GaiaX]", k21.r("release() called: ", this));
            }
            this.context = null;
            this.container = null;
            this.data = null;
            this.viewPort = new ob2<>(null, null);
            this.dataPipelines5.clear();
            this.scrollItemStatusDelegate = null;
            this.scrollDataDiffCallBackDelegate = null;
            this.scrollDelegate = null;
            this.scrollPosition = 0;
            this.indexPosition = -1;
            this.isReleased = true;
        }

        public final void setAnimationDelegate(@Nullable IAnimationDelegate iAnimationDelegate) {
            this.animationDelegate = iAnimationDelegate;
        }

        public final void setChildLoadMode$GaiaX_Android(@Nullable LoadType loadType) {
            this.childLoadMode = loadType;
        }

        public final void setChildVisualNestTemplateNode(@Nullable xq0 xq0) {
            this.childVisualNestTemplateNode = xq0;
        }

        public final void setContainer(@Nullable View view) {
            this.container = view;
        }

        public final void setContext(@Nullable Context context2) {
            this.context = context2;
        }

        public final void setData(@Nullable JSONObject jSONObject) {
            this.data = jSONObject;
        }

        public final void setDataPipelines5(@NotNull Map<IRule, IDataPipeline5> map) {
            k21.i(map, "<set-?>");
            this.dataPipelines5 = map;
        }

        public final void setEventDelegate(@Nullable IEventDelegate iEventDelegate) {
            this.eventDelegate = iEventDelegate;
        }

        public final void setForceCreate(boolean z) {
            this.forceCreate = z;
        }

        public final void setForceLocalTemplate(boolean z) {
            this.forceLocalTemplate = z;
        }

        public final void setIndexPosition$GaiaX_Android(int i) {
            this.indexPosition = i;
        }

        public final void setMessage(@Nullable IHostMessage iHostMessage) {
            this.message = iHostMessage;
        }

        public final void setMode(@NotNull LoadType loadType) {
            k21.i(loadType, "<set-?>");
            this.mode = loadType;
        }

        public final void setOpenMinHeight(boolean z) {
            this.openMinHeight = z;
        }

        public final void setReleased$GaiaX_Android(boolean z) {
            this.isReleased = z;
        }

        public final void setRouterDelegate2(@Nullable IRouterDelegate2 iRouterDelegate2) {
            this.routerDelegate2 = iRouterDelegate2;
        }

        public final void setScrollDataDiffCallBackDelegate(@Nullable IScrollDataDiffCallBack iScrollDataDiffCallBack) {
            this.scrollDataDiffCallBackDelegate = iScrollDataDiffCallBack;
        }

        public final void setScrollDelegate(@Nullable IScrollDelegate iScrollDelegate) {
            this.scrollDelegate = iScrollDelegate;
        }

        public final void setScrollItemStatusDelegate(@Nullable IScrollItemStatusDelegate iScrollItemStatusDelegate) {
            this.scrollItemStatusDelegate = iScrollItemStatusDelegate;
        }

        public final void setScrollPosition$GaiaX_Android(int i) {
            this.scrollPosition = i;
        }

        public final void setStatusDelegate(@Nullable IStatusDelegate iStatusDelegate) {
            this.statusDelegate = iStatusDelegate;
        }

        public final void setTemplateBiz(@NotNull String str) {
            k21.i(str, "<set-?>");
            this.templateBiz = str;
        }

        public final void setTemplateId(@NotNull String str) {
            k21.i(str, "<set-?>");
            this.templateId = str;
        }

        public final void setTemplateVersion(@NotNull String str) {
            k21.i(str, "<set-?>");
            this.templateVersion = str;
        }

        public final void setTrackDelegate3(@Nullable ITrackDelegate3 iTrackDelegate3) {
            this.trackDelegate3 = iTrackDelegate3;
        }

        public final void setViewPort(@NotNull ob2<Float> ob2) {
            k21.i(ob2, "<set-?>");
            this.viewPort = ob2;
        }

        @NotNull
        public String toString() {
            return "Params(templateId='" + this.templateId + "', templateVersion='" + this.templateVersion + "', container=" + this.container + ", viewPort=" + this.viewPort + ", mode=" + this.mode + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ Params(String str, String str2, String str3, Context context2, View view, JSONObject jSONObject, ob2 ob2, int i, m40 m40) {
            this(str, str2, str3, context2, view, (i & 32) != 0 ? null : jSONObject, (i & 64) != 0 ? new ob2(null, null) : ob2);
        }
    }
}
