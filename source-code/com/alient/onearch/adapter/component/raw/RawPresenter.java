package com.alient.onearch.adapter.component.raw;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.adapter.ViewTypeConfig;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.View;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.arch.v3.view.render.AbsRenderPlugin;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.arch.v3.view.render.GenericRenderPlugin;
import com.youku.arch.v3.view.render.RenderPluginConfigCenter;
import com.youku.arch.v3.view.render.RenderPluginFactory;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0014\b\u0000\u0010\u0004*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\b\b\u0001\u0010\u0006*\u00020\u00052\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007B5\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020(\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u00100\u001a\u0004\u0018\u00010/¢\u0006\u0004\b1\u00102B5\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020(\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u00100\u001a\u0004\u0018\u00010(¢\u0006\u0004\b1\u00103B=\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020(\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u0010.\u001a\u00020-\u0012\u0010\u00100\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u000104¢\u0006\u0004\b1\u00105B+\b\u0016\u0012\u0006\u00106\u001a\u00028\u0000\u0012\u0006\u00107\u001a\u00028\u0001\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u00100\u001a\u0004\u0018\u00010(¢\u0006\u0004\b1\u00108J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J(\u0010\u0015\u001a\u00020\f2\u001e\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R.\u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00069"}, d2 = {"Lcom/alient/onearch/adapter/component/raw/RawPresenter;", "Lcom/youku/arch/v3/view/IContract$Model;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "M", "Lcom/youku/arch/v3/view/IContract$View;", "V", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/core/Node;", "componentNode", "", "index", "Ltb/ur2;", "createChildComponent", "item", UCCore.LEGACY_EVENT_INIT, "", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "viewHolders", "showComponentsInView", "", "changed", "responsiveLayoutStateChanged", "", "componentViewHolders", "Ljava/util/List;", "oldItem", "Lcom/youku/arch/v3/core/item/GenericItem;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "componentConfig", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "getComponentConfig", "()Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "setComponentConfig", "(Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;)V", "", "mClassName", "vClassName", "Landroid/view/View;", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", "Lcom/alibaba/fastjson/JSONObject;", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Lcom/alibaba/fastjson/JSONObject;)V", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/util/Map;)V", "model", "view", "(Lcom/youku/arch/v3/view/IContract$Model;Lcom/youku/arch/v3/view/IContract$View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class RawPresenter<M extends IContract.Model<GenericItem<ItemValue>>, V extends IContract.View> extends AbsPresenter<GenericItem<ItemValue>, M, V> {
    @Nullable
    private ComponentConfigBean.ComponentBean componentConfig;
    private final List<VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> componentViewHolders = new ArrayList();
    private Context context;
    private GenericItem<ItemValue> oldItem;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RawPresenter(@NotNull String str, @NotNull String str2, @Nullable android.view.View view, @NotNull EventHandler eventHandler, @Nullable JSONObject jSONObject) {
        super(str, str2, view, eventHandler, jSONObject);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v4, resolved type: java.util.List<com.youku.arch.v3.adapter.VBaseHolder<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.view.render.GenericRenderConfig>> */
    /* JADX DEBUG: Multi-variable search result rejected for r11v7, resolved type: java.util.List<com.youku.arch.v3.adapter.VBaseHolder<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.view.render.GenericRenderConfig>> */
    /* JADX WARN: Multi-variable type inference failed */
    private final void createChildComponent(Node node, int i) {
        ViewTypeSupport viewTypeSupport;
        ViewTypeConfig viewTypeConfig;
        Integer layoutResId;
        if (this.context != null && (viewTypeSupport = ((GenericItem) getItem()).getPageContext().getViewTypeSupport()) != null && (viewTypeConfig = viewTypeSupport.getViewTypeConfig(node.getType() << 16)) != null && (layoutResId = viewTypeConfig.getLayoutResId()) != null) {
            GenericRenderPlugin genericRenderPlugin = null;
            android.view.View inflate = LayoutInflater.from(this.context).inflate(layoutResId.intValue(), (ViewGroup) null, false);
            if (inflate != null) {
                Class<?> viewHolderClass = viewTypeConfig.getViewHolderClass();
                Constructor<?> constructor = viewHolderClass != null ? viewHolderClass.getConstructor(android.view.View.class) : null;
                VBaseHolder vBaseHolder = constructor != null ? (VBaseHolder) constructor.newInstance(inflate) : null;
                ConfigManager configManager = ((GenericItem) getItem()).getPageContext().getConfigManager();
                String pathConfig = configManager != null ? configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE) : null;
                RenderPluginConfigCenter.Companion companion = RenderPluginConfigCenter.Companion;
                if (companion.getInstance().isSupportRenderPlugin(((GenericItem) getItem()).getPageContext(), pathConfig, String.valueOf(viewTypeConfig.getViewType()))) {
                    GenericRenderConfig genericRenderConfig = new GenericRenderConfig();
                    genericRenderConfig.setType(String.valueOf(viewTypeConfig.getViewType()));
                    genericRenderConfig.setMClassName(viewTypeConfig.getModel());
                    genericRenderConfig.setMClassNameOpt(viewTypeConfig.getModelOpt());
                    genericRenderConfig.setVClassName(viewTypeConfig.getView());
                    genericRenderConfig.setVClassNameOpt(viewTypeConfig.getViewOpt());
                    genericRenderConfig.setPClassName(viewTypeConfig.getPresenter());
                    genericRenderConfig.setPClassNameOpt(viewTypeConfig.getPresenterOpt());
                    genericRenderConfig.setLayoutId(viewTypeConfig.getLayoutResId());
                    genericRenderConfig.setLayoutIdOpt(viewTypeConfig.getLayoutResIdOpt());
                    genericRenderConfig.setLayoutStr(viewTypeConfig.getLayoutResString());
                    genericRenderConfig.setLayoutStrOpt(viewTypeConfig.getLayoutResStringOpt());
                    genericRenderConfig.setExtra(viewTypeConfig.wrapParams(genericRenderConfig.getExtra()));
                    RenderPluginFactory renderPluginFactory = companion.getInstance().getRenderPluginFactory(pathConfig, String.valueOf(viewTypeConfig.getViewType()));
                    AbsRenderPlugin<?, ?> create = renderPluginFactory != null ? renderPluginFactory.create() : null;
                    if (!(create instanceof AbsRenderPlugin)) {
                        create = null;
                    }
                    if (create != null) {
                        create.attachContext(((GenericItem) getItem()).getPageContext());
                    }
                    if (create instanceof GenericRenderPlugin) {
                        genericRenderPlugin = create;
                    }
                    GenericRenderPlugin genericRenderPlugin2 = genericRenderPlugin;
                    if (genericRenderPlugin2 != null) {
                        genericRenderPlugin2.setRenderView(inflate);
                    }
                    if (create != null) {
                        try {
                            create.setConfig(genericRenderConfig);
                        } catch (Exception e) {
                            if (AppInfoProviderProxy.isDebuggable()) {
                                throw e;
                            }
                            return;
                        }
                    }
                    if (vBaseHolder != null) {
                        vBaseHolder.setPageContext(((GenericItem) getItem()).getPageContext());
                        Context context2 = inflate.getContext();
                        k21.h(context2, WPKFactory.INIT_KEY_CONTEXT);
                        vBaseHolder.setContext(context2);
                        vBaseHolder.setRenderPlugin(create);
                        GenericItem genericItem = new GenericItem(((GenericItem) getItem()).getPageContext());
                        genericItem.setProperty(new ItemValue(node));
                        genericItem.setType(node.getType());
                        genericItem.setComponent(((GenericItem) getItem()).getComponent());
                        genericItem.getProperty().setData(node.getData());
                        genericItem.getExtra().putInt("index", i);
                        vBaseHolder.setData(genericItem);
                        this.componentViewHolders.add(vBaseHolder);
                    }
                } else if (vBaseHolder != null) {
                    try {
                        vBaseHolder.setPageContext(((GenericItem) getItem()).getPageContext());
                        Context context3 = inflate.getContext();
                        k21.h(context3, WPKFactory.INIT_KEY_CONTEXT);
                        vBaseHolder.setContext(context3);
                        vBaseHolder.onCreate();
                        GenericItem genericItem2 = new GenericItem(((GenericItem) getItem()).getPageContext());
                        genericItem2.setProperty(new ItemValue(node));
                        genericItem2.setType(node.getType());
                        genericItem2.setComponent(((GenericItem) getItem()).getComponent());
                        genericItem2.getProperty().setData(node.getData());
                        genericItem2.getExtra().putInt("index", i);
                        vBaseHolder.setData(genericItem2);
                        this.componentViewHolders.add(vBaseHolder);
                    } catch (Exception e2) {
                        if (AppInfoProviderProxy.isDebuggable()) {
                            throw e2;
                        }
                    }
                }
            }
        }
    }

    @Nullable
    public final ComponentConfigBean.ComponentBean getComponentConfig() {
        return this.componentConfig;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter
    public void responsiveLayoutStateChanged(boolean z) {
        super.responsiveLayoutStateChanged(z);
        if (z) {
            this.oldItem = null;
        }
    }

    public final void setComponentConfig(@Nullable ComponentConfigBean.ComponentBean componentBean) {
        this.componentConfig = componentBean;
    }

    public void showComponentsInView(@NotNull List<? extends VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> list) {
        k21.i(list, "viewHolders");
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        String pathConfig;
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        if (!k21.d(this.oldItem, genericItem)) {
            this.oldItem = genericItem;
            Activity activity = genericItem.getPageContext().getActivity();
            ComponentConfigBean.ComponentBean componentBean = null;
            if (activity != null) {
                ConfigManager configManager = genericItem.getPageContext().getConfigManager();
                if (!(configManager == null || (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) == null)) {
                    SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = ComponentConfigManager.Companion.getInstance().getComponentConfigs(activity, pathConfig);
                    if (componentConfigs != null) {
                        componentBean = componentConfigs.get(PageUtil.INSTANCE.getItemType(genericItem));
                    }
                    this.componentConfig = componentBean;
                }
                ur2 ur2 = ur2.INSTANCE;
            } else {
                activity = null;
            }
            this.context = activity;
            this.componentViewHolders.clear();
            List<Node> children = genericItem.getProperty().getChildren();
            if (children != null) {
                int i = 0;
                for (T t : children) {
                    int i2 = i + 1;
                    if (i < 0) {
                        m.p();
                    }
                    createChildComponent(t, i);
                    showComponentsInView(this.componentViewHolders);
                    i = i2;
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RawPresenter(@NotNull String str, @NotNull String str2, @Nullable android.view.View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RawPresenter(@NotNull String str, @NotNull String str2, @Nullable android.view.View view, @NotNull EventHandler eventHandler, @Nullable Map<?, ?> map) {
        super(str, str2, view, eventHandler, map);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RawPresenter(@NotNull M m, @NotNull V v, @NotNull EventHandler eventHandler, @Nullable String str) {
        super(m, v, eventHandler, str);
        k21.i(m, "model");
        k21.i(v, "view");
        k21.i(eventHandler, "eventHandler");
    }
}
