package com.taobao.android.dinamicx.widget.recycler.expose;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
public class ExposeScrollerListener extends RecyclerView.OnScrollListener {
    private final ExposeChildAttachListener a;
    private long b = 0;

    ExposeScrollerListener(ExposeChildAttachListener exposeChildAttachListener) {
        this.a = exposeChildAttachListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        ExposeChildAttachListener exposeChildAttachListener;
        super.onScrolled(recyclerView, i, i2);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.b > 500 && (exposeChildAttachListener = this.a) != null) {
            exposeChildAttachListener.b();
            this.b = currentTimeMillis;
        }
    }
}
