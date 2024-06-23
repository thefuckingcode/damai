package com.taobao.weex.ui.component.list;

import android.content.Context;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class SimpleRecyclerView extends WXRecyclerView implements ListComponentView {
    private RecyclerViewBaseAdapter mAdapter = null;

    public SimpleRecyclerView(Context context) {
        super(context);
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public WXRecyclerView getInnerView() {
        return this;
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public RecyclerViewBaseAdapter getRecyclerViewBaseAdapter() {
        return this.mAdapter;
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void notifyStickyRemove(WXCell wXCell) {
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void notifyStickyShow(WXCell wXCell) {
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void setRecyclerViewBaseAdapter(RecyclerViewBaseAdapter recyclerViewBaseAdapter) {
        setAdapter(recyclerViewBaseAdapter);
        this.mAdapter = recyclerViewBaseAdapter;
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void updateStickyView(int i) {
    }
}
