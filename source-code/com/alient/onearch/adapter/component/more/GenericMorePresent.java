package com.alient.onearch.adapter.component.more;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.component.more.GenericMoreContract;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B3\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001d\u0010\u001eJ0\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/alient/onearch/adapter/component/more/GenericMorePresent;", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/more/GenericMoreModel;", "Lcom/alient/onearch/adapter/component/more/GenericMoreView;", "Lcom/alient/onearch/adapter/component/more/GenericMoreContract$Presenter;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "", "", "data", "paramName", "", "getDimenId", "item", "Ltb/ur2;", UCCore.LEGACY_EVENT_INIT, "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "componentConfig", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "mClassName", "vClassName", "Landroid/view/View;", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class GenericMorePresent extends AbsPresenter<GenericItem<ItemValue>, GenericMoreModel, GenericMoreView> implements GenericMoreContract.Presenter {
    private ComponentConfigBean.ComponentBean componentConfig;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericMorePresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
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

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        String string;
        Context context;
        ComponentConfigBean.ComponentBean.LayoutBean layout;
        HashMap<String, Object> params;
        View renderView;
        ViewGroup.LayoutParams layoutParams;
        View renderView2;
        ViewGroup.LayoutParams layoutParams2;
        String pathConfig;
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        View renderView3 = ((GenericMoreView) getView()).getRenderView();
        if (!(renderView3 == null || (context = renderView3.getContext()) == null)) {
            ConfigManager configManager = genericItem.getPageContext().getConfigManager();
            RecyclerView.LayoutParams layoutParams3 = null;
            if (!(configManager == null || (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) == null)) {
                SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = ComponentConfigManager.Companion.getInstance().getComponentConfigs(context, pathConfig);
                this.componentConfig = componentConfigs != null ? componentConfigs.get(genericItem.getComponent().getType()) : null;
            }
            ComponentConfigBean.ComponentBean componentBean = this.componentConfig;
            if (!(componentBean == null || (layout = componentBean.getLayout()) == null || (params = layout.getParams()) == null)) {
                int dimenId = getDimenId(context, params, "moreItemWidth");
                if (!(dimenId == 0 || (renderView2 = ((GenericMoreView) getView()).getRenderView()) == null || (layoutParams2 = renderView2.getLayoutParams()) == null)) {
                    layoutParams2.width = context.getResources().getDimensionPixelSize(dimenId);
                }
                int dimenId2 = getDimenId(context, params, "moreItemHeight");
                if (!(dimenId2 == 0 || (renderView = ((GenericMoreView) getView()).getRenderView()) == null || (layoutParams = renderView.getLayoutParams()) == null)) {
                    layoutParams.height = context.getResources().getDimensionPixelSize(dimenId2);
                }
                int dimenId3 = getDimenId(context, params, "moreItemPaddingTop");
                if (dimenId3 != 0) {
                    View renderView4 = ((GenericMoreView) getView()).getRenderView();
                    ViewGroup.LayoutParams layoutParams4 = renderView4 != null ? renderView4.getLayoutParams() : null;
                    if (layoutParams4 instanceof RecyclerView.LayoutParams) {
                        layoutParams3 = layoutParams4;
                    }
                    RecyclerView.LayoutParams layoutParams5 = layoutParams3;
                    if (layoutParams5 != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = context.getResources().getDimensionPixelSize(dimenId3);
                    }
                }
            }
        }
        JSONObject data = genericItem.getProperty().getData();
        if (data != null && (string = data.getString("text")) != null) {
            ((GenericMoreView) getView()).renderContent(string);
        }
    }
}
