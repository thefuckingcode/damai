package com.alient.onearch.adapter.component.horizontal;

import com.alient.onearch.adapter.component.horizontal.GenericHorizontalContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalModel;", "Lcom/alient/onearch/adapter/view/AbsModel;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "", "Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalContract$Model;", "item", "Ltb/ur2;", "parseModelImpl", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class GenericHorizontalModel extends AbsModel<GenericItem<ItemValue>, Object> implements GenericHorizontalContract.Model {
    /* access modifiers changed from: protected */
    public void parseModelImpl(@NotNull GenericItem<ItemValue> genericItem) {
        k21.i(genericItem, "item");
    }
}
