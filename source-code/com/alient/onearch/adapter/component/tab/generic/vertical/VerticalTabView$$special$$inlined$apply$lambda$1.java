package com.alient.onearch.adapter.component.tab.generic.vertical;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Ltb/ur2;", "run", "()V", "com/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabView$scrollToTop$1$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class VerticalTabView$$special$$inlined$apply$lambda$1 implements Runnable {
    final /* synthetic */ int $position$inlined;
    final /* synthetic */ RecyclerView $this_apply;

    VerticalTabView$$special$$inlined$apply$lambda$1(RecyclerView recyclerView, int i) {
        this.$this_apply = recyclerView;
        this.$position$inlined = i;
    }

    public final void run() {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.$this_apply.findViewHolderForAdapterPosition(this.$position$inlined + 1);
        if (findViewHolderForAdapterPosition != null) {
            RecyclerView recyclerView = this.$this_apply;
            View view = findViewHolderForAdapterPosition.itemView;
            k21.h(view, "itemView");
            recyclerView.scrollBy(0, view.getTop());
        }
    }
}
