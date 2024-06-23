package com.alient.gaiax.container.render;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.event.GaiaXEventDispatcher;
import com.alient.gaiax.container.render.GenericGaiaxContract;
import com.alient.gaiax.container.util.DisplayUtil;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Render;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.event.FragmentEvent;
import com.youku.arch.v3.event.ViewHolderEvent;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.k;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.if1;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 -2\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0001-B3\u0012\u0006\u0010%\u001a\u00020\n\u0012\u0006\u0010&\u001a\u00020\n\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010*\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b+\u0010,J0\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J&\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\n2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016J$\u0010\u001b\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001aH\u0016J\u0016\u0010\u001d\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006."}, d2 = {"Lcom/alient/gaiax/container/render/GenericGaiaxPresenter;", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/gaiax/container/render/GenericGaiaxModel;", "Lcom/alient/gaiax/container/render/GenericGaiaxView;", "Lcom/alient/gaiax/container/render/GenericGaiaxContract$Presenter;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "", "", "data", "paramName", "", "getDimenId", "item", "Ltb/ur2;", UCCore.LEGACY_EVENT_INIT, "type", "params", "", "onMessage", "Landroid/view/View;", "view", "eventName", "Lcom/alibaba/fastjson/JSONObject;", "processEvent", "Lcom/youku/arch/v3/IItem;", "measureWidth", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "componentConfig", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "getComponentConfig", "()Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "setComponentConfig", "(Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;)V", "mClassName", "vClassName", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "Companion", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class GenericGaiaxPresenter extends AbsPresenter<GenericItem<ItemValue>, GenericGaiaxModel, GenericGaiaxView> implements GenericGaiaxContract.Presenter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String GAIAX_RECYCLER_VIEW_ITEM_EVENT_NAME = "eventName";
    @NotNull
    public static final String GAIAX_RECYCLER_VIEW_ITEM_EVENT_VALUE = "item";
    @Nullable
    private ComponentConfigBean.ComponentBean componentConfig;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/alient/gaiax/container/render/GenericGaiaxPresenter$Companion;", "", "", "GAIAX_RECYCLER_VIEW_ITEM_EVENT_NAME", "Ljava/lang/String;", "GAIAX_RECYCLER_VIEW_ITEM_EVENT_VALUE", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericGaiaxPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    private final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), com.youku.arch.v3.data.Constants.DIMEN);
        }
        return 0;
    }

    @Nullable
    public final ComponentConfigBean.ComponentBean getComponentConfig() {
        return this.componentConfig;
    }

    public int measureWidth(@NotNull IItem<ItemValue> iItem) {
        ComponentConfigBean.ComponentBean.LayoutBean layout;
        HashMap<String, Object> params;
        k21.i(iItem, "item");
        Activity activity = iItem.getPageContext().getActivity();
        int i = 0;
        Integer num = null;
        if (!(activity != null)) {
            activity = null;
        }
        if (activity == null) {
            return 0;
        }
        ComponentConfigBean.ComponentBean componentConfig2 = getComponentConfig();
        if (!(componentConfig2 == null || (layout = componentConfig2.getLayout()) == null || (params = layout.getParams()) == null)) {
            int dimenId = getDimenId(activity, params, "itemWidth");
            if (dimenId != 0) {
                i = activity.getResources().getDimensionPixelSize(dimenId);
            } else {
                i = DisplayUtil.INSTANCE.getDisplayWidthInPx(activity);
                Object obj = params.get("screenAverage");
                Integer num2 = obj instanceof Integer ? (Integer) obj : null;
                if (num2 != null) {
                    i /= num2.intValue();
                }
                Object obj2 = params.get("span");
                if (obj2 instanceof Integer) {
                    num = (Integer) obj2;
                }
                if (num != null) {
                    int intValue = num.intValue();
                    int dimenId2 = getDimenId(activity, params, com.youku.arch.v3.data.Constants.GAP);
                    if (dimenId2 != 0) {
                        i -= activity.getResources().getDimensionPixelSize(dimenId2) * (intValue - 1);
                    }
                    int dimenId3 = getDimenId(activity, params, Constants.Name.MARGIN_LEFT);
                    if (dimenId3 != 0) {
                        i -= activity.getResources().getDimensionPixelSize(dimenId3);
                    }
                    int dimenId4 = getDimenId(activity, params, Constants.Name.MARGIN_RIGHT);
                    if (dimenId4 != 0) {
                        i -= activity.getResources().getDimensionPixelSize(dimenId4);
                    }
                    i /= intValue;
                }
            }
            num = params;
        }
        return num == null ? DisplayUtil.INSTANCE.getDisplayWidthInPx(activity) : i;
    }

    @Override // com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter, com.alient.onearch.adapter.view.AbsPresenter
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        Object obj;
        k21.i(str, "type");
        if (o.w(FragmentEvent.ON_FRAGMENT_RESUME, str, true)) {
            Boolean bool = null;
            if (map == null) {
                obj = null;
            } else {
                obj = map.get("state");
            }
            if (obj instanceof Boolean) {
                bool = (Boolean) obj;
            }
            if (bool != null) {
                if (bool.booleanValue()) {
                    ((GenericGaiaxView) getView()).viewVisible();
                } else {
                    ((GenericGaiaxView) getView()).viewInvisible();
                }
            }
        } else if (o.w(ViewHolderEvent.ON_VIEW_ATTACHED_TO_WINDOW, str, true)) {
            ((GenericGaiaxView) getView()).viewVisible();
        } else if (o.w(ViewHolderEvent.ON_VIEW_DETACHED_FROM_WINDOW, str, true)) {
            ((GenericGaiaxView) getView()).viewInvisible();
        }
        return super.onMessage(str, map);
    }

    @Override // com.alient.gaiax.container.render.GenericGaiaxContract.Presenter
    public void processEvent(@Nullable View view, @NotNull String str, @Nullable JSONObject jSONObject) {
        String pageName;
        Map<String, ? extends Object> map;
        k21.i(str, "eventName");
        Activity activity = ((GenericItem) getItem()).getPageContext().getActivity();
        if (activity != null && (pageName = ((GenericItem) getItem()).getPageContext().getPageName()) != null) {
            GaiaXEventDispatcher instance = GaiaXEventDispatcher.Companion.getInstance();
            JSONObject data = ((GenericItem) getItem()).getProperty().getData();
            Map<String, Action> actions = getActions();
            if (jSONObject == null) {
                map = null;
            } else {
                map = jSONObject.getInnerMap();
            }
            instance.dispatch(view, activity, pageName, str, data, actions, map);
        }
    }

    public final void setComponentConfig(@Nullable ComponentConfigBean.ComponentBean componentBean) {
        this.componentConfig = componentBean;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ad A[Catch:{ Exception -> 0x00e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bb A[Catch:{ Exception -> 0x00e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        Render render;
        boolean z;
        boolean z2;
        ConfigManager configManager;
        String pathConfig;
        ComponentConfigBean.ComponentBean componentBean;
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        Activity activity = genericItem.getPageContext().getActivity();
        if (!(activity == null || (configManager = genericItem.getPageContext().getConfigManager()) == null || (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) == null || getComponentConfig() != null)) {
            SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = ComponentConfigManager.Companion.getInstance().getComponentConfigs(activity, pathConfig);
            if (componentConfigs == null) {
                componentBean = null;
            } else {
                componentBean = componentConfigs.get(genericItem.getComponent().getType());
            }
            setComponentConfig(componentBean);
        }
        List<Render> renders = genericItem.getProperty().getRenders();
        if (renders != null && (render = (Render) k.P(renders)) != null) {
            try {
                Uri parse = Uri.parse(render.url);
                String queryParameter = parse.getQueryParameter(if1.DIMEN_BIZ);
                String queryParameter2 = parse.getQueryParameter("templateId");
                String queryParameter3 = parse.getQueryParameter("templateVersion");
                JSONObject data = genericItem.getProperty().getData();
                boolean z3 = true;
                JSONObject jSONObject = data != null ? data : null;
                if (jSONObject != null) {
                    jSONObject.put("isLastChild", (Object) Boolean.valueOf(isLastChild()));
                    if (queryParameter != null) {
                        if (queryParameter.length() != 0) {
                            z = false;
                            if (z) {
                                if (queryParameter2 != null) {
                                    if (queryParameter2.length() != 0) {
                                        z2 = false;
                                        if (z2) {
                                            if (queryParameter3 != null) {
                                                if (queryParameter3.length() != 0) {
                                                    z3 = false;
                                                }
                                            }
                                            if (!z3) {
                                                k21.h(queryParameter, if1.DIMEN_BIZ);
                                                k21.h(queryParameter2, "templateId");
                                                k21.h(queryParameter3, "version");
                                                ((GenericGaiaxView) getView()).renderGaiax(queryParameter, queryParameter2, queryParameter3, measureWidth(genericItem), jSONObject);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                z2 = true;
                                if (z2) {
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    z = true;
                    if (z) {
                    }
                }
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
            }
        }
    }
}
