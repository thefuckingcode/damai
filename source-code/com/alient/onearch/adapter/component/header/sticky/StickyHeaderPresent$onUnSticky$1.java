package com.alient.onearch.adapter.component.header.sticky;

import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
final class StickyHeaderPresent$onUnSticky$1 implements Runnable {
    final /* synthetic */ StickyHeaderPresent this$0;

    StickyHeaderPresent$onUnSticky$1(StickyHeaderPresent stickyHeaderPresent) {
        this.this$0 = stickyHeaderPresent;
    }

    public final void run() {
        try {
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = ((GenericItem) this.this$0.getItem()).getComponent().getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
