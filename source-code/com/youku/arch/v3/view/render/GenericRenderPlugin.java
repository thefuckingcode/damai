package com.youku.arch.v3.view.render;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IPresenterCreator;
import com.youku.arch.v3.IViewCreator;
import com.youku.arch.v3.IViewDataBinder;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.arch.v3.view.AbsPresenter;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.View;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 T*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\b\b\u0002\u0010\u0007*\u00020\u0006*\u001c\b\u0003\u0010\t*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\b*\b\b\u0004\u0010\u000b*\u00020\n2\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00040\f:\u0002TUB\u0007¢\u0006\u0004\bR\u0010SJ\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J&\u0010 \u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001b2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002J\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00028\u0004H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\"2\u0006\u0010!\u001a\u00028\u0004H\u0002¢\u0006\u0004\b%\u0010$J\u0017\u0010&\u001a\u00020\"2\u0006\u0010!\u001a\u00028\u0004H\u0002¢\u0006\u0004\b&\u0010$J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010(\u001a\u00020'H\u0016J)\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010!\u001a\u00028\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010*J!\u0010+\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0004\b+\u0010,J\b\u0010-\u001a\u00020\u0016H\u0016J&\u00100\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u001b2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u00101R8\u00103\u001a$02R \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00018\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R$\u00107\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R0\u0010>\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010=8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006V"}, d2 = {"Lcom/youku/arch/v3/view/render/GenericRenderPlugin;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "DATA", "Lcom/youku/arch/v3/view/IContract$Model;", "MODEL", "Lcom/youku/arch/v3/view/IContract$View;", "VIEW", "Lcom/youku/arch/v3/view/AbsPresenter;", "PRESENTER", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "CONFIG", "Lcom/youku/arch/v3/view/render/AbsRenderPlugin;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "layoutId", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "createView", "data", "Ltb/ur2;", "bindDataImpl", "(Lcom/youku/arch/v3/IItem;)V", "ensurePresenter", "ensurePresenterOpt", "", "type", "", "", "map", "onReceiveEvent", Constants.CONFIG, "", "isSimpleLayout", "(Lcom/youku/arch/v3/view/render/GenericRenderConfig;)Z", "checkOptConfig", "checkNormalConfig", "Lcom/youku/arch/v3/core/IContext;", com.youku.arch.v3.data.Constants.PAGE_CONTEXT, "attachContext", "(Landroid/content/Context;Lcom/youku/arch/v3/view/render/GenericRenderConfig;Landroid/view/ViewGroup;)Landroid/view/View;", "bindData", "(Landroid/content/Context;Lcom/youku/arch/v3/IItem;)V", "destroyRenderPlugin", "eventName", "params", WXBridgeManager.METHOD_FIRE_EVENT, "Lcom/youku/arch/v3/core/IContext;", "Lcom/youku/arch/v3/view/render/GenericRenderPlugin$RenderEventHandler;", "eventHandler", "Lcom/youku/arch/v3/view/render/GenericRenderPlugin$RenderEventHandler;", "presenter", "Lcom/youku/arch/v3/view/AbsPresenter;", "renderView", "Landroid/view/View;", "getRenderView", "()Landroid/view/View;", "setRenderView", "(Landroid/view/View;)V", "Lcom/youku/arch/v3/IPresenterCreator;", "presenterCreator", "Lcom/youku/arch/v3/IPresenterCreator;", "getPresenterCreator", "()Lcom/youku/arch/v3/IPresenterCreator;", "setPresenterCreator", "(Lcom/youku/arch/v3/IPresenterCreator;)V", "Lcom/youku/arch/v3/IViewCreator;", "viewCreator", "Lcom/youku/arch/v3/IViewCreator;", "getViewCreator", "()Lcom/youku/arch/v3/IViewCreator;", "setViewCreator", "(Lcom/youku/arch/v3/IViewCreator;)V", "Lcom/youku/arch/v3/IViewDataBinder;", "viewDataBinder", "Lcom/youku/arch/v3/IViewDataBinder;", "getViewDataBinder", "()Lcom/youku/arch/v3/IViewDataBinder;", "setViewDataBinder", "(Lcom/youku/arch/v3/IViewDataBinder;)V", "<init>", "()V", "Companion", "RenderEventHandler", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GenericRenderPlugin<DATA extends IItem<ItemValue>, MODEL extends IContract.Model<DATA>, VIEW extends IContract.View, PRESENTER extends AbsPresenter<DATA, MODEL, VIEW>, CONFIG extends GenericRenderConfig> extends AbsRenderPlugin<DATA, CONFIG> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.GenericRenderPlugin";
    @NotNull
    private final GenericRenderPlugin<DATA, MODEL, VIEW, PRESENTER, CONFIG>.RenderEventHandler eventHandler = new RenderEventHandler(this);
    @Nullable
    private IContext pageContext;
    @Nullable
    private PRESENTER presenter;
    @Nullable
    private IPresenterCreator<?, ?, ?> presenterCreator;
    @Nullable
    private android.view.View renderView;
    @Nullable
    private IViewCreator viewCreator;
    @Nullable
    private IViewDataBinder viewDataBinder;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/view/render/GenericRenderPlugin$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lcom/youku/arch/v3/view/render/GenericRenderPlugin$RenderEventHandler;", "Lcom/youku/arch/v3/event/EventHandler;", "", "type", "", "", "params", "", "onMessage", "<init>", "(Lcom/youku/arch/v3/view/render/GenericRenderPlugin;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public final class RenderEventHandler implements EventHandler {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ GenericRenderPlugin<DATA, MODEL, VIEW, PRESENTER, CONFIG> this$0;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public RenderEventHandler(GenericRenderPlugin genericRenderPlugin) {
            k21.i(genericRenderPlugin, "this$0");
            this.this$0 = genericRenderPlugin;
        }

        @Override // com.youku.arch.v3.event.EventHandler
        public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1417788840")) {
                return ((Boolean) ipChange.ipc$dispatch("-1417788840", new Object[]{this, str, map})).booleanValue();
            }
            k21.i(str, "type");
            this.this$0.onReceiveEvent(str, map);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.youku.arch.v3.view.render.GenericRenderPlugin<DATA extends com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, MODEL extends com.youku.arch.v3.view.IContract$Model<DATA>, VIEW extends com.youku.arch.v3.view.IContract$View, PRESENTER extends com.youku.arch.v3.view.AbsPresenter<DATA, MODEL, VIEW>, CONFIG extends com.youku.arch.v3.view.render.GenericRenderConfig> */
    /* JADX WARN: Multi-variable type inference failed */
    private final void bindDataImpl(DATA data) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027760696")) {
            ipChange.ipc$dispatch("1027760696", new Object[]{this, data});
            return;
        }
        if (isSimpleLayout((GenericRenderConfig) getConfig())) {
            ensurePresenterOpt();
        } else {
            ensurePresenter();
        }
        PRESENTER presenter2 = this.presenter;
        if (presenter2 == null) {
            PageUtil pageUtil = PageUtil.INSTANCE;
            LogUtil.e(TAG, k21.r("presenter is null type: ", Integer.valueOf(pageUtil.getItemType(data))));
            OnRenderListener onRenderListener = getOnRenderListener();
            if (onRenderListener != null) {
                onRenderListener.onRenderFailed(this, this.renderView, new RenderError(5, k21.r("cannot create presenter for type: ", Integer.valueOf(pageUtil.getItemType(data)))));
                return;
            }
            return;
        }
        if (presenter2 != null) {
            presenter2.onCreate();
        }
        if (k21.d(Looper.myLooper(), Looper.getMainLooper())) {
            PRESENTER presenter3 = this.presenter;
            if (presenter3 != null) {
                presenter3.init(data);
                return;
            }
            return;
        }
        PRESENTER presenter4 = this.presenter;
        if (presenter4 != null) {
            presenter4.preAsyncInit(data);
        }
    }

    private final boolean checkNormalConfig(CONFIG config) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1234704134")) {
            return !TextUtils.isEmpty(config.getPClassName());
        }
        return ((Boolean) ipChange.ipc$dispatch("-1234704134", new Object[]{this, config})).booleanValue();
    }

    private final boolean checkOptConfig(CONFIG config) {
        Integer layoutIdOpt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371391458")) {
            return ((Boolean) ipChange.ipc$dispatch("-1371391458", new Object[]{this, config})).booleanValue();
        }
        if (TextUtils.isEmpty(config.getMClassNameOpt()) || TextUtils.isEmpty(config.getVClassNameOpt()) || TextUtils.isEmpty(config.getPClassNameOpt()) || ((layoutIdOpt = config.getLayoutIdOpt()) != null && layoutIdOpt.intValue() == 0)) {
            return false;
        }
        return true;
    }

    private final void ensurePresenter() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1446332609")) {
            ipChange.ipc$dispatch("-1446332609", new Object[]{this});
        } else if (this.presenter == null) {
            IPresenterCreator<?, ?, ?> iPresenterCreator = this.presenterCreator;
            if (iPresenterCreator != null) {
                PRESENTER presenter2 = (PRESENTER) iPresenterCreator.createPresenter(((GenericRenderConfig) getConfig()).getType(), ((GenericRenderConfig) getConfig()).getPClassName(), ((GenericRenderConfig) getConfig()).getMClassName(), ((GenericRenderConfig) getConfig()).getVClassName(), getRenderView(), this.eventHandler, ((GenericRenderConfig) getConfig()).getExtra());
                this.presenter = presenter2;
                if (presenter2 != null) {
                    return;
                }
            }
            if (this.presenter == null) {
                Object newInstance = ViewUtil.newInstance(GenericRenderPlugin.class.getClassLoader(), ((GenericRenderConfig) getConfig()).getPClassName(), ((GenericRenderConfig) getConfig()).getMClassName(), ((GenericRenderConfig) getConfig()).getVClassName(), this.renderView, this.eventHandler, JSON.toJSONString(((GenericRenderConfig) getConfig()).getExtra()));
                if (newInstance != null) {
                    z = newInstance instanceof AbsPresenter;
                }
                this.presenter = z ? (PRESENTER) ((AbsPresenter) newInstance) : null;
            }
        }
    }

    private final void ensurePresenterOpt() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "600199160")) {
            ipChange.ipc$dispatch("600199160", new Object[]{this});
        } else if (this.presenter == null) {
            IPresenterCreator<?, ?, ?> iPresenterCreator = this.presenterCreator;
            if (iPresenterCreator != null) {
                PRESENTER presenter2 = (PRESENTER) iPresenterCreator.createPresenter(((GenericRenderConfig) getConfig()).getType(), ((GenericRenderConfig) getConfig()).getPClassNameOpt(), ((GenericRenderConfig) getConfig()).getMClassNameOpt(), ((GenericRenderConfig) getConfig()).getVClassNameOpt(), getRenderView(), this.eventHandler, ((GenericRenderConfig) getConfig()).getExtra());
                this.presenter = presenter2;
                if (presenter2 != null) {
                    return;
                }
            }
            if (this.presenter == null) {
                Object newInstance = ViewUtil.newInstance(GenericRenderPlugin.class.getClassLoader(), ((GenericRenderConfig) getConfig()).getPClassNameOpt(), ((GenericRenderConfig) getConfig()).getMClassNameOpt(), ((GenericRenderConfig) getConfig()).getVClassNameOpt(), this.renderView, this.eventHandler, JSON.toJSONString(((GenericRenderConfig) getConfig()).getExtra()));
                if (newInstance != null) {
                    z = newInstance instanceof AbsPresenter;
                }
                this.presenter = z ? (PRESENTER) ((AbsPresenter) newInstance) : null;
            }
        }
    }

    private final boolean isSimpleLayout(CONFIG config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "504961911")) {
            return ((Boolean) ipChange.ipc$dispatch("504961911", new Object[]{this, config})).booleanValue();
        } else if (!checkNormalConfig(config)) {
            return true;
        } else {
            return checkOptConfig(config);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void onReceiveEvent(String str, Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1164991056")) {
            ipChange.ipc$dispatch("-1164991056", new Object[]{this, str, map});
            return;
        }
        OnRenderListener onRenderListener = getOnRenderListener();
        if (onRenderListener != null) {
            onRenderListener.onReceiveEvent(this, this.renderView, str, map);
        }
    }

    @Override // com.youku.arch.v3.view.render.AbsRenderPlugin
    public void attachContext(@NotNull IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1139952743")) {
            ipChange.ipc$dispatch("-1139952743", new Object[]{this, iContext});
            return;
        }
        k21.i(iContext, com.youku.arch.v3.data.Constants.PAGE_CONTEXT);
        ConfigManager configManager = iContext.getConfigManager();
        if (configManager != null) {
            setPresenterCreator(configManager.getPresenterCreator());
            setViewCreator(configManager.getViewCreator());
            setViewDataBinder(configManager.getViewDataBinder());
        }
        ur2 ur2 = ur2.INSTANCE;
        this.pageContext = iContext;
    }

    @Override // com.youku.arch.v3.view.render.AbsRenderPlugin
    public void destroyRenderPlugin() {
        ViewParent parent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-140986074")) {
            ipChange.ipc$dispatch("-140986074", new Object[]{this});
            return;
        }
        PRESENTER presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.saveState();
        }
        PRESENTER presenter3 = this.presenter;
        if (presenter3 != null) {
            presenter3.onDestroy();
        }
        android.view.View view = this.renderView;
        if (view != null && (parent = view.getParent()) != null) {
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(getRenderView());
            }
        }
    }

    @Override // com.youku.arch.v3.view.render.AbsRenderPlugin
    public void fireEvent(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-799166698")) {
            ipChange.ipc$dispatch("-799166698", new Object[]{this, str, map});
            return;
        }
        k21.i(str, "eventName");
        PRESENTER presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.onMessage(str, map);
        }
    }

    @Nullable
    public final IPresenterCreator<?, ?, ?> getPresenterCreator() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-507320672")) {
            return this.presenterCreator;
        }
        return (IPresenterCreator) ipChange.ipc$dispatch("-507320672", new Object[]{this});
    }

    @Nullable
    public final android.view.View getRenderView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "722564058")) {
            return this.renderView;
        }
        return (android.view.View) ipChange.ipc$dispatch("722564058", new Object[]{this});
    }

    @Nullable
    public final IViewCreator getViewCreator() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1232301066")) {
            return this.viewCreator;
        }
        return (IViewCreator) ipChange.ipc$dispatch("1232301066", new Object[]{this});
    }

    @Nullable
    public final IViewDataBinder getViewDataBinder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-533928970")) {
            return this.viewDataBinder;
        }
        return (IViewDataBinder) ipChange.ipc$dispatch("-533928970", new Object[]{this});
    }

    public final void setPresenterCreator(@Nullable IPresenterCreator<?, ?, ?> iPresenterCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1304927166")) {
            ipChange.ipc$dispatch("1304927166", new Object[]{this, iPresenterCreator});
            return;
        }
        this.presenterCreator = iPresenterCreator;
    }

    public final void setRenderView(@Nullable android.view.View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951380154")) {
            ipChange.ipc$dispatch("-1951380154", new Object[]{this, view});
            return;
        }
        this.renderView = view;
    }

    public final void setViewCreator(@Nullable IViewCreator iViewCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "964171616")) {
            ipChange.ipc$dispatch("964171616", new Object[]{this, iViewCreator});
            return;
        }
        this.viewCreator = iViewCreator;
    }

    public final void setViewDataBinder(@Nullable IViewDataBinder iViewDataBinder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340169762")) {
            ipChange.ipc$dispatch("-1340169762", new Object[]{this, iViewDataBinder});
            return;
        }
        this.viewDataBinder = iViewDataBinder;
    }

    private final android.view.View createView(Context context, int i, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-268581188")) {
            return (android.view.View) ipChange.ipc$dispatch("-268581188", new Object[]{this, context, Integer.valueOf(i), viewGroup});
        }
        IViewCreator iViewCreator = this.viewCreator;
        if (iViewCreator == null) {
            return null;
        }
        return iViewCreator.createView(context, i, viewGroup);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: com.youku.arch.v3.IViewDataBinder */
    /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: com.youku.arch.v3.IViewDataBinder */
    /* JADX WARN: Multi-variable type inference failed */
    public void bindData(@Nullable Context context, @NotNull DATA data) {
        OnRenderListener onRenderListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-683266844")) {
            ipChange.ipc$dispatch("-683266844", new Object[]{this, context, data});
            return;
        }
        k21.i(data, "data");
        super.bindData(context, (Object) data);
        OnRenderListener onRenderListener2 = getOnRenderListener();
        if (onRenderListener2 != null) {
            onRenderListener2.onRenderStart(this, this.renderView);
        }
        IViewDataBinder iViewDataBinder = this.viewDataBinder;
        if (iViewDataBinder != 0) {
            iViewDataBinder.preBindData(this.renderView, (GenericRenderConfig) getConfig(), data, this.eventHandler);
        }
        bindDataImpl(data);
        IViewDataBinder iViewDataBinder2 = this.viewDataBinder;
        if (iViewDataBinder2 != 0) {
            iViewDataBinder2.bindData(this.renderView, (GenericRenderConfig) getConfig(), data, this.eventHandler);
        }
        android.view.View view = this.renderView;
        if (view != null && (onRenderListener = getOnRenderListener()) != null) {
            onRenderListener.onRenderSuccess(this, view, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.youku.arch.v3.view.render.GenericRenderPlugin<DATA extends com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, MODEL extends com.youku.arch.v3.view.IContract$Model<DATA>, VIEW extends com.youku.arch.v3.view.IContract$View, PRESENTER extends com.youku.arch.v3.view.AbsPresenter<DATA, MODEL, VIEW>, CONFIG extends com.youku.arch.v3.view.render.GenericRenderConfig> */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public android.view.View createView(@NotNull Context context, @NotNull CONFIG config, @NotNull ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "32160935")) {
            return (android.view.View) ipChange.ipc$dispatch("32160935", new Object[]{this, context, config, viewGroup});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(config, Constants.CONFIG);
        k21.i(viewGroup, "parent");
        setConfig(config);
        if (isSimpleLayout((GenericRenderConfig) getConfig())) {
            Integer layoutIdOpt = ((GenericRenderConfig) getConfig()).getLayoutIdOpt();
            if (layoutIdOpt != null) {
                int intValue = layoutIdOpt.intValue();
                setRenderView(createView(context, intValue, viewGroup));
                if (getRenderView() == null) {
                    setRenderView(LayoutInflater.from(context).inflate(intValue, viewGroup, false));
                }
            }
        } else {
            Integer layoutId = ((GenericRenderConfig) getConfig()).getLayoutId();
            if (layoutId != null) {
                int intValue2 = layoutId.intValue();
                setRenderView(createView(context, intValue2, viewGroup));
                if (getRenderView() == null) {
                    setRenderView(LayoutInflater.from(context).inflate(intValue2, viewGroup, false));
                }
            }
        }
        return this.renderView;
    }
}
