package com.alient.onearch.adapter.component.empty;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.component.empty.GenericEmptyContract;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B3\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0014"}, d2 = {"Lcom/alient/onearch/adapter/component/empty/GenericEmptyPresent;", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/empty/GenericEmptyModel;", "Lcom/alient/onearch/adapter/component/empty/GenericEmptyView;", "Lcom/alient/onearch/adapter/component/empty/GenericEmptyContract$Presenter;", "item", "Ltb/ur2;", UCCore.LEGACY_EVENT_INIT, "", "mClassName", "vClassName", "Landroid/view/View;", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class GenericEmptyPresent extends AbsPresenter<GenericItem<ItemValue>, GenericEmptyModel, GenericEmptyView> implements GenericEmptyContract.Presenter {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericEmptyPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        String string;
        String string2;
        String string3;
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        JSONObject data = genericItem.getProperty().getData();
        if (!(data == null || (string3 = data.getString("holderPicUrl")) == null)) {
            ((GenericEmptyView) getView()).renderImage(string3);
        }
        JSONObject data2 = genericItem.getProperty().getData();
        if (!(data2 == null || (string2 = data2.getString("mainDesc")) == null)) {
            ((GenericEmptyView) getView()).renderMainDesc(string2);
        }
        JSONObject data3 = genericItem.getProperty().getData();
        if (data3 != null && (string = data3.getString("subDesc")) != null) {
            ((GenericEmptyView) getView()).renderSubDesc(string);
        }
    }
}
