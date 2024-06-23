package com.alient.onearch.adapter.component.pager;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.alient.onearch.adapter.component.pager.PagerGridContract;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B3\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010\"\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b#\u0010$J0\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R@\u0010\u0018\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0015\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0015\u0012\u0004\u0012\u00020\u00170\u00160\u00140\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/alient/onearch/adapter/component/pager/PagerGridPresenter;", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/pager/PagerGridModel;", "Lcom/alient/onearch/adapter/component/pager/PagerGridView;", "Lcom/alient/onearch/adapter/component/pager/PagerGridContract$Presenter;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "", "", "data", "paramName", "", "getDimenId", "item", "Ltb/ur2;", UCCore.LEGACY_EVENT_INIT, "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "childAdapters", "Ljava/util/List;", "historyItem", "Lcom/youku/arch/v3/core/item/GenericItem;", "mClassName", "vClassName", "Landroid/view/View;", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class PagerGridPresenter extends AbsPresenter<GenericItem<ItemValue>, PagerGridModel, PagerGridView> implements PagerGridContract.Presenter {
    private List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> childAdapters = new ArrayList();
    private GenericItem<ItemValue> historyItem;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerGridPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    /* access modifiers changed from: private */
    public final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), com.youku.arch.v3.data.Constants.DIMEN);
        }
        return 0;
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        Activity activity;
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        if (!k21.d(this.historyItem, genericItem) && (activity = genericItem.getPageContext().getActivity()) != null) {
            this.historyItem = genericItem;
            this.childAdapters.clear();
            genericItem.getPageContext().runOnLoaderThread(new PagerGridPresenter$init$1(this, genericItem, activity));
        }
    }
}
