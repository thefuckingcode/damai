package com.youku.arch.v3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.util.ArchMontior;
import com.youku.arch.v3.util.ArchMontiorManager;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.util.PerformanceLogUtil;
import com.youku.arch.v3.util.Util;
import com.youku.arch.v3.view.render.AbsRenderPlugin;
import com.youku.arch.v3.view.render.DefaultViewHolder;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.arch.v3.view.render.RenderPluginConfigCenter;
import com.youku.arch.v3.view.render.RenderPluginFactory;
import com.youku.middlewareservice.provider.analytics.AnalyticsProviderProxy;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001a2&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u0001:\u0002\u001a\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0007\u001a\u00020\u0006H\u0016J*\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0006H\u0016J*\u0010\u0011\u001a\u00020\u00102\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\"\u0010\u0012\u001a\u00020\u00102\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\"\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u001c"}, d2 = {"Lcom/youku/arch/v3/adapter/VDefaultAdapter;", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "", "getItemCount", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "", "getPageName", "holder", "position", "Ltb/ur2;", "onBindViewHolder", "onViewRecycled", "getSafetyViewHolder", "Lcom/youku/arch/v3/adapter/ViewTypeConfig;", "getViewTypeConfig", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion", "PlaceHolderViewHolder", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class VDefaultAdapter extends VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.VDefaultAdapter";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/adapter/VDefaultAdapter$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0014¨\u0006\f"}, d2 = {"Lcom/youku/arch/v3/adapter/VDefaultAdapter$PlaceHolderViewHolder;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "Ltb/ur2;", "initData", "refreshData", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class PlaceHolderViewHolder extends VBaseHolder<IItem<ItemValue>, GenericRenderConfig> {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PlaceHolderViewHolder(@NotNull View view) {
            super(view);
            k21.i(view, "itemView");
        }

        /* access modifiers changed from: protected */
        @Override // com.youku.arch.v3.adapter.VBaseHolder
        public void initData() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1242551482")) {
                ipChange.ipc$dispatch("1242551482", new Object[]{this});
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.youku.arch.v3.adapter.VBaseHolder
        public void refreshData() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1755712369")) {
                ipChange.ipc$dispatch("1755712369", new Object[]{this});
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VDefaultAdapter(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter, com.youku.arch.v3.adapter.VBaseAdapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1186715423")) {
            return ((Integer) ipChange.ipc$dispatch("-1186715423", new Object[]{this})).intValue();
        }
        int i = getRenderCount().get() == 0 ? this.dataCount : getRenderCount().get();
        List<DATA> list = this.data;
        if (list == null) {
            z = false;
        }
        List<DATA> list2 = null;
        if (!z) {
            list = null;
        }
        if (list != null) {
            if (i > list.size()) {
                i = list.size();
            }
            list2 = list;
        }
        if (list2 == null) {
            return 0;
        }
        return i;
    }

    @Nullable
    public String getPageName(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-383834461")) {
            return (String) ipChange.ipc$dispatch("-383834461", new Object[]{this, Integer.valueOf(i)});
        }
        ConfigManager configManager = getPageContext().getConfigManager();
        if (configManager == null) {
            return null;
        }
        return configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @NotNull
    public VBaseHolder<IItem<ItemValue>, GenericRenderConfig> getSafetyViewHolder(int i) {
        DefaultViewHolder defaultViewHolder;
        Throwable th;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138911631")) {
            return (VBaseHolder) ipChange.ipc$dispatch("-2138911631", new Object[]{this, Integer.valueOf(i)});
        }
        try {
            defaultViewHolder = new DefaultViewHolder(new FrameLayout(getContext()));
            try {
                defaultViewHolder.setPageContext(getPageContext());
                defaultViewHolder.setContext(getContext());
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            defaultViewHolder = null;
            th = th3;
            LogUtil.e(TAG, k21.r("getSafetyViewHolder: ", th.getMessage()));
            ViewTypeConfig viewTypeConfig = getViewTypeConfig(i);
            HashMap hashMap = new HashMap();
            hashMap.put("error", th.getMessage());
            String str2 = "null";
            if (viewTypeConfig == null || (str = viewTypeConfig.toLogString()) == null) {
                str = str2;
            }
            hashMap.put(Constants.CONFIG, str);
            if (defaultViewHolder != null) {
                str2 = defaultViewHolder.getClass().getName();
            }
            hashMap.put("holder", str2);
            AnalyticsProviderProxy.utCustomEvent("NULL_VIEW_HOLDER", 19999, "GOT_ERROR", "", String.valueOf(i), hashMap);
            if (defaultViewHolder != null) {
            }
        }
        return defaultViewHolder != null ? new PlaceHolderViewHolder(new FrameLayout(getContext())) : defaultViewHolder;
    }

    @Nullable
    public ViewTypeConfig getViewTypeConfig(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1421036115")) {
            return (ViewTypeConfig) ipChange.ipc$dispatch("1421036115", new Object[]{this, Integer.valueOf(i)});
        }
        ViewTypeSupport viewTypeSupport = getViewTypeSupport();
        if (viewTypeSupport == null) {
            return null;
        }
        return viewTypeSupport.getViewTypeConfig(i);
    }

    public void onBindViewHolder(@NotNull VBaseHolder<IItem<ItemValue>, GenericRenderConfig> vBaseHolder, int i) {
        ArchMontior archMontior;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2085180497")) {
            ipChange.ipc$dispatch("-2085180497", new Object[]{this, vBaseHolder, Integer.valueOf(i)});
            return;
        }
        k21.i(vBaseHolder, "holder");
        List<DATA> list = this.data;
        if (list != null) {
            DATA data = list.get((i + getRenderStart()) % list.size());
            Util.throwIfNull(data);
            data.setEventHandler(vBaseHolder);
            long currentTimeMillis = System.currentTimeMillis();
            String pageName = getPageContext().getPageName();
            if (AppInfoProviderProxy.isDebuggable()) {
                PerformanceLogUtil.INSTANCE.markStartPoint(k21.r("bindData type=", Integer.valueOf(PageUtil.INSTANCE.getItemType(data))));
            }
            vBaseHolder.setPageContext(getPageContext());
            vBaseHolder.setContext(getContext());
            vBaseHolder.setData(data);
            if (AppInfoProviderProxy.isDebuggable()) {
                PerformanceLogUtil.INSTANCE.markEndPoint(k21.r("bindData type=", Integer.valueOf(PageUtil.INSTANCE.getItemType(data))));
            }
            if (!(pageName == null || (archMontior = ArchMontiorManager.Companion.get(pageName)) == null)) {
                archMontior.setBindTime(String.valueOf(vBaseHolder.getItemViewType()), System.currentTimeMillis() - currentTimeMillis);
            }
        }
        AnalyticsProviderProxy.scanView(vBaseHolder.itemView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public VBaseHolder<IItem<ItemValue>, GenericRenderConfig> onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        ArchMontior archMontior;
        ArchMontior archMontior2;
        AbsRenderPlugin<IItem<ItemValue>, GenericRenderConfig> absRenderPlugin;
        View view;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1114686951")) {
            return (VBaseHolder) ipChange.ipc$dispatch("1114686951", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        k21.i(viewGroup, "parent");
        ViewTypeConfig viewTypeConfig = getViewTypeConfig(i);
        VBaseHolder<IItem<ItemValue>, GenericRenderConfig> vBaseHolder = null;
        if (viewTypeConfig != null) {
            GenericRenderConfig genericRenderConfig = new GenericRenderConfig();
            genericRenderConfig.setType(String.valueOf(i));
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
            String pageName = getPageName(i);
            if (AppInfoProviderProxy.isDebuggable()) {
                PerformanceLogUtil.INSTANCE.markStartPoint(k21.r("createViewHolder type: ", Integer.valueOf(PageUtil.INSTANCE.getItemTypeByConfig(genericRenderConfig))));
            }
            RenderPluginConfigCenter.Companion companion = RenderPluginConfigCenter.Companion;
            if (companion.getInstance().isSupportRenderPlugin(getPageContext(), pageName, String.valueOf(i))) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    RenderPluginFactory renderPluginFactory = companion.getInstance().getRenderPluginFactory(pageName, String.valueOf(i));
                    if (renderPluginFactory == null) {
                        absRenderPlugin = null;
                    } else {
                        absRenderPlugin = renderPluginFactory.create();
                    }
                    AbsRenderPlugin<IItem<ItemValue>, GenericRenderConfig> absRenderPlugin2 = absRenderPlugin instanceof AbsRenderPlugin ? absRenderPlugin : null;
                    if (absRenderPlugin2 != null) {
                        absRenderPlugin2.attachContext(getPageContext());
                    }
                    if (absRenderPlugin2 == null) {
                        view = null;
                    } else {
                        view = absRenderPlugin2.createView(getContext(), genericRenderConfig, viewGroup);
                    }
                    Class<?> viewHolderClass = viewTypeConfig.getViewHolderClass();
                    Constructor<?> constructor = viewHolderClass == null ? null : viewHolderClass.getConstructor(View.class);
                    if (!(constructor instanceof Constructor)) {
                        constructor = null;
                    }
                    if (constructor != null) {
                        VBaseHolder<IItem<ItemValue>, GenericRenderConfig> vBaseHolder2 = (VBaseHolder) constructor.newInstance(view);
                        if (vBaseHolder2 != null) {
                            vBaseHolder2.setPageContext(getPageContext());
                            vBaseHolder2.setContext(getContext());
                            vBaseHolder2.setRenderPlugin(absRenderPlugin2);
                            ur2 ur2 = ur2.INSTANCE;
                            vBaseHolder = vBaseHolder2;
                        }
                    }
                } catch (Exception unused) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", Integer.valueOf(i));
                    hashMap.put("mvp", "layoutStr " + ((Object) genericRenderConfig.getLayoutStr()) + " mClassName " + ((Object) genericRenderConfig.getMClassName()) + " pClassName " + ((Object) genericRenderConfig.getPClassName()) + " vClassName " + ((Object) genericRenderConfig.getVClassName()));
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.e(TAG, hashMap.toString());
                    } else {
                        EventDispatcher eventDispatcher = getPageContext().getEventDispatcher();
                        if (eventDispatcher != null) {
                            eventDispatcher.dispatchEvent(ArchExceptionEvent.COMPONENT_RENDER_FAILED, hashMap);
                        }
                    }
                }
                String pageName2 = getPageContext().getPageName();
                if (!(pageName2 == null || (archMontior2 = ArchMontiorManager.Companion.get(pageName2)) == null)) {
                    archMontior2.setRenderTime(String.valueOf(i), System.currentTimeMillis() - currentTimeMillis);
                }
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    Integer layoutId = genericRenderConfig.getLayoutId();
                    if (!(layoutId != null && layoutId.intValue() > 0)) {
                        layoutId = null;
                    }
                    if (layoutId != null) {
                        View inflate = LayoutInflater.from(getContext()).inflate(layoutId.intValue(), viewGroup, false);
                        Class<?> viewHolderClass2 = viewTypeConfig.getViewHolderClass();
                        Constructor<?> constructor2 = viewHolderClass2 == null ? null : viewHolderClass2.getConstructor(View.class);
                        if (!(constructor2 instanceof Constructor)) {
                            constructor2 = null;
                        }
                        if (constructor2 != null) {
                            VBaseHolder<IItem<ItemValue>, GenericRenderConfig> vBaseHolder3 = (VBaseHolder) constructor2.newInstance(inflate);
                            if (vBaseHolder3 != null) {
                                vBaseHolder3.setPageContext(getPageContext());
                                vBaseHolder3.setContext(getContext());
                                ur2 ur22 = ur2.INSTANCE;
                                vBaseHolder = vBaseHolder3;
                            }
                        }
                    }
                } catch (Exception unused2) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("type", Integer.valueOf(i));
                    hashMap2.put("viewHolderClass", k21.r("viewHolderClass ", viewTypeConfig.getViewHolderClass()));
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.e(TAG, hashMap2.toString());
                    } else {
                        EventDispatcher eventDispatcher2 = getPageContext().getEventDispatcher();
                        if (eventDispatcher2 != null) {
                            eventDispatcher2.dispatchEvent(ArchExceptionEvent.COMPONENT_RENDER_FAILED, hashMap2);
                        }
                    }
                }
                String pageName3 = getPageContext().getPageName();
                if (!(pageName3 == null || (archMontior = ArchMontiorManager.Companion.get(pageName3)) == null)) {
                    archMontior.setRenderTime(String.valueOf(i), System.currentTimeMillis() - currentTimeMillis2);
                }
            }
            if (AppInfoProviderProxy.isDebuggable()) {
                PerformanceLogUtil.INSTANCE.markEndPoint(k21.r("createViewHolder type: ", Integer.valueOf(PageUtil.INSTANCE.getItemTypeByConfig(genericRenderConfig))));
            }
        } else {
            if (AppInfoProviderProxy.isDebuggable()) {
                Toast.makeText(getContext(), k21.r("not support viewType：", Integer.valueOf(i)), 0).show();
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put("type", Integer.valueOf(i));
            EventDispatcher eventDispatcher3 = getPageContext().getEventDispatcher();
            if (eventDispatcher3 != null) {
                eventDispatcher3.dispatchEvent(ArchExceptionEvent.COMPONENT_NOT_SUPPORT, hashMap3);
            }
        }
        if (vBaseHolder != null) {
            vBaseHolder.setContext(getContext());
        }
        if (vBaseHolder != null) {
            vBaseHolder.onCreate();
        }
        return vBaseHolder == null ? getSafetyViewHolder(i) : vBaseHolder;
    }

    @Override // com.youku.arch.v3.adapter.VBaseAdapter
    public void onViewRecycled(@NotNull VBaseHolder<IItem<ItemValue>, GenericRenderConfig> vBaseHolder) {
        IItem<ItemValue> data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822954756")) {
            ipChange.ipc$dispatch("-822954756", new Object[]{this, vBaseHolder});
            return;
        }
        k21.i(vBaseHolder, "holder");
        super.onViewRecycled((VBaseHolder) vBaseHolder);
        if (vBaseHolder.getData() != null && (data = vBaseHolder.getData()) != null) {
            data.setEventHandler(null);
        }
    }
}
