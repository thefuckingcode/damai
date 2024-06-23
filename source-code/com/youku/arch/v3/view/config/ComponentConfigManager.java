package com.youku.arch.v3.view.config;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.util.ConfigParser;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.render.GenericRenderPluginFactory;
import com.youku.arch.v3.view.render.RenderPluginConfigCenter;
import com.youku.arch.v3.view.render.RenderPluginFactory;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.a;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 &2\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006J\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/youku/arch/v3/view/config/ComponentConfigManager;", "", "Lcom/youku/arch/v3/view/config/ComponentConfigBean;", "componentConfig", "Ltb/ur2;", "addUniversallyComponentConfigs", "", "page", WXBridgeManager.METHOD_REGISTER_COMPONENTS, "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean$ItemBean;", "itemBean", "", "isContainer", "setSupportRenderPlugin", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "componentConfigPath", "getComponentConfig", "Landroid/util/SparseArray;", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "getComponentConfigs", "Ljava/util/concurrent/ConcurrentHashMap;", "componentConfigMap", "Ljava/util/concurrent/ConcurrentHashMap;", "componentMap", "Lcom/youku/arch/v3/view/render/RenderPluginFactory;", "renderPluginFactory", "Lcom/youku/arch/v3/view/render/RenderPluginFactory;", "universallyComponentConfig", "Lcom/youku/arch/v3/view/config/ComponentConfigBean;", "universallyComponentConfigPath", "Ljava/lang/String;", "getUniversallyComponentConfigPath", "()Ljava/lang/String;", "setUniversallyComponentConfigPath", "(Ljava/lang/String;)V", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ComponentConfigManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String UNIVERSALLY_COMPONENT_CONFIG_PATH = "android.resource://onecomponent/raw/universally_component_config";
    @NotNull
    private static final Lazy<ComponentConfigManager> instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, ComponentConfigManager$Companion$instance$2.INSTANCE);
    @NotNull
    private final ConcurrentHashMap<String, ComponentConfigBean> componentConfigMap;
    @NotNull
    private final ConcurrentHashMap<String, SparseArray<ComponentConfigBean.ComponentBean>> componentMap;
    @NotNull
    private final RenderPluginFactory renderPluginFactory;
    @Nullable
    private ComponentConfigBean universallyComponentConfig;
    @Nullable
    private String universallyComponentConfigPath;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/youku/arch/v3/view/config/ComponentConfigManager$Companion;", "", "Lcom/youku/arch/v3/view/config/ComponentConfigManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/arch/v3/view/config/ComponentConfigManager;", "instance", "", "UNIVERSALLY_COMPONENT_CONFIG_PATH", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final ComponentConfigManager getInstance() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2128147299")) {
                return (ComponentConfigManager) ComponentConfigManager.instance$delegate.getValue();
            }
            return (ComponentConfigManager) ipChange.ipc$dispatch("2128147299", new Object[]{this});
        }
    }

    private ComponentConfigManager() {
        this.componentConfigMap = new ConcurrentHashMap<>();
        this.componentMap = new ConcurrentHashMap<>();
        this.renderPluginFactory = new GenericRenderPluginFactory();
        this.universallyComponentConfigPath = UNIVERSALLY_COMPONENT_CONFIG_PATH;
    }

    public /* synthetic */ ComponentConfigManager(m40 m40) {
        this();
    }

    private final void addUniversallyComponentConfigs(ComponentConfigBean componentConfigBean) {
        List<ComponentConfigBean.ComponentBean> components;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928424070")) {
            ipChange.ipc$dispatch("-928424070", new Object[]{this, componentConfigBean});
            return;
        }
        if (this.universallyComponentConfig == null) {
            ConfigParser configParser = new ConfigParser();
            Application application = AppInfoProviderProxy.getApplication();
            k21.h(application, "getApplication()");
            this.universallyComponentConfig = (ComponentConfigBean) configParser.parse(application, Uri.parse(this.universallyComponentConfigPath), ComponentConfigBean.class);
        }
        HashMap hashMap = new HashMap();
        ComponentConfigBean componentConfigBean2 = this.universallyComponentConfig;
        List<ComponentConfigBean.ComponentBean> list = null;
        if (!(componentConfigBean2 == null || (components = componentConfigBean2.getComponents()) == null)) {
            if (!(!components.isEmpty())) {
                components = null;
            }
            if (components != null) {
                for (ComponentConfigBean.ComponentBean componentBean : components) {
                    Integer type = componentBean.getType();
                    k21.h(type, "componentBean.type");
                    k21.h(componentBean, "componentBean");
                    hashMap.put(type, componentBean);
                }
            }
        }
        List<ComponentConfigBean.ComponentBean> components2 = componentConfigBean.getComponents();
        if (components2 != null) {
            if (true ^ components2.isEmpty()) {
                list = components2;
            }
            if (list != null) {
                for (ComponentConfigBean.ComponentBean componentBean2 : list) {
                    Integer type2 = componentBean2.getType();
                    k21.h(type2, "componentBean.type");
                    k21.h(componentBean2, "componentBean");
                    hashMap.put(type2, componentBean2);
                }
            }
        }
        componentConfigBean.setComponents(new ArrayList(hashMap.values()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        if (tb.k21.d(com.youku.arch.v3.data.Constants.LayoutType.PAGER, r6) != false) goto L_0x007e;
     */
    private final void registerComponents(String str) {
        List<ComponentConfigBean.ComponentBean> components;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1983205628")) {
            ipChange.ipc$dispatch("-1983205628", new Object[]{this, str});
            return;
        }
        ComponentConfigBean componentConfigBean = this.componentConfigMap.get(str);
        if (!(componentConfigBean == null || (components = componentConfigBean.getComponents()) == null)) {
            for (T t : components) {
                ComponentConfigBean.ComponentBean.ItemBean container = t.getContainer();
                if (container != null) {
                    ComponentConfigBean.ComponentBean.LayoutBean layout = t.getLayout();
                    String str2 = null;
                    if (!k21.d("list", layout == null ? null : layout.getLayoutType())) {
                        ComponentConfigBean.ComponentBean.LayoutBean layout2 = t.getLayout();
                        if (!k21.d(Constants.LayoutType.RAW_LIST, layout2 == null ? null : layout2.getLayoutType())) {
                            ComponentConfigBean.ComponentBean.LayoutBean layout3 = t.getLayout();
                            if (layout3 != null) {
                                str2 = layout3.getLayoutType();
                            }
                        }
                    }
                    setSupportRenderPlugin(str, container, true);
                }
                List<ComponentConfigBean.ComponentBean.ItemBean> viewTypes = t.getViewTypes();
                if (!(viewTypes == null || viewTypes.isEmpty())) {
                    for (ComponentConfigBean.ComponentBean.ItemBean itemBean : t.getViewTypes()) {
                        k21.h(itemBean, "item");
                        setSupportRenderPlugin(str, itemBean, false);
                    }
                }
            }
        }
    }

    private final void setSupportRenderPlugin(String str, ComponentConfigBean.ComponentBean.ItemBean itemBean, boolean z) {
        Integer num;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-1106421635")) {
            ipChange.ipc$dispatch("-1106421635", new Object[]{this, str, itemBean, Boolean.valueOf(z)});
            return;
        }
        RenderPluginFactory renderPluginFactory2 = null;
        if (z) {
            Integer type = itemBean.getType();
            num = type == null ? null : Integer.valueOf(type.intValue() << 16);
        } else {
            num = itemBean.getType();
        }
        String valueOf = String.valueOf(num);
        if (itemBean.isMVPArchitecture()) {
            RenderPluginConfigCenter.Companion.getInstance().setSupportRenderPlugin(str, valueOf, this.renderPluginFactory);
            return;
        }
        String renderPluginFactory3 = itemBean.getRenderPluginFactory();
        if (!(renderPluginFactory3 == null || renderPluginFactory3.length() == 0)) {
            z2 = false;
        }
        if (!z2) {
            Object f = a.j(itemBean.getRenderPluginFactory()).b().f();
            if (f instanceof RenderPluginFactory) {
                renderPluginFactory2 = (RenderPluginFactory) f;
            }
            if (renderPluginFactory2 != null) {
                RenderPluginConfigCenter.Companion.getInstance().setSupportRenderPlugin(str, valueOf, renderPluginFactory2);
            }
        }
    }

    @Nullable
    public final synchronized ComponentConfigBean getComponentConfig(@NotNull Context context, @NotNull String str) {
        ComponentConfigBean componentConfigBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-188408358")) {
            return (ComponentConfigBean) ipChange.ipc$dispatch("-188408358", new Object[]{this, context, str});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "componentConfigPath");
        if (!this.componentConfigMap.containsKey(str) && (componentConfigBean = (ComponentConfigBean) new ConfigParser().parse(context, Uri.parse(str), ComponentConfigBean.class)) != null) {
            addUniversallyComponentConfigs(componentConfigBean);
            this.componentConfigMap.put(str, componentConfigBean);
            registerComponents(str);
        }
        return this.componentConfigMap.get(str);
    }

    @Nullable
    public final synchronized SparseArray<ComponentConfigBean.ComponentBean> getComponentConfigs(@NotNull Context context, @NotNull String str) {
        ComponentConfigBean componentConfig;
        List<ComponentConfigBean.ComponentBean> components;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-553244556")) {
            return (SparseArray) ipChange.ipc$dispatch("-553244556", new Object[]{this, context, str});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "componentConfigPath");
        if (!(this.componentMap.containsKey(str) || (componentConfig = getComponentConfig(context, str)) == null || (components = componentConfig.getComponents()) == null)) {
            SparseArray<ComponentConfigBean.ComponentBean> sparseArray = new SparseArray<>();
            for (ComponentConfigBean.ComponentBean componentBean : components) {
                Integer type = componentBean.getType();
                if (type != null) {
                    sparseArray.put(type.intValue(), componentBean);
                }
            }
            this.componentMap.put(str, sparseArray);
        }
        return this.componentMap.get(str);
    }

    @Nullable
    public final String getUniversallyComponentConfigPath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "634577387")) {
            return this.universallyComponentConfigPath;
        }
        return (String) ipChange.ipc$dispatch("634577387", new Object[]{this});
    }

    public final void setUniversallyComponentConfigPath(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922291027")) {
            ipChange.ipc$dispatch("1922291027", new Object[]{this, str});
            return;
        }
        this.universallyComponentConfigPath = str;
    }
}
