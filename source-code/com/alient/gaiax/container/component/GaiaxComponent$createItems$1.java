package com.alient.gaiax.container.component;

import com.alient.gaiax.container.item.GaiaxItem;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class GaiaxComponent$createItems$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ GaiaxComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaxComponent$createItems$1(GaiaxComponent gaiaxComponent) {
        super(0);
        this.this$0 = gaiaxComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        GaiaxItem gaiaxItem = new GaiaxItem(this.this$0.getPageContext());
        gaiaxItem.initProperties(this.this$0.getNode());
        gaiaxItem.setProperty(new ItemValue());
        gaiaxItem.getProperty().setType(this.this$0.getType());
        gaiaxItem.getProperty().setRenders(this.this$0.getProperty().getRenders());
        gaiaxItem.getProperty().setData(this.this$0.getNode().getRawJson());
        gaiaxItem.setType(this.this$0.getType());
        GaiaxComponent gaiaxComponent = this.this$0;
        gaiaxComponent.addItem(gaiaxComponent.childItems.size(), (IItem<ItemValue>) gaiaxItem, false);
    }
}
