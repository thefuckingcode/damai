package cn.damai.tetris.core;

import android.view.View;

/* compiled from: Taobao */
public interface IRecyclerView {

    /* compiled from: Taobao */
    public interface OnLoadMoreListener {
        void onLoadMore(View view);
    }

    /* compiled from: Taobao */
    public interface OnRefreshListener {
        void onRefresh();
    }

    void setLoadMoreEnabled(boolean z);

    void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener);

    void setOnRefreshListener(OnRefreshListener onRefreshListener);

    void setRefreshEnabled(boolean z);

    void setRefreshHeaderView(View view);
}
