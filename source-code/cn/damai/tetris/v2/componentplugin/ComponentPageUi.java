package cn.damai.tetris.v2.componentplugin;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.v2.structure.container.IContainer;
import tb.w9;

/* compiled from: Taobao */
public interface ComponentPageUi {
    w9 getBaseContext();

    IContainer getPageContainer();

    RecyclerView getRecycler();

    View getRootView();

    void hideErrorViewV2();

    void hideNoMoreV2();

    void loadMoreResetV2(boolean z);

    void showErrorViewV2(String str, String str2, OnErrClickListener onErrClickListener);

    void showLoadMoreV2();

    void showNoMoreV2();

    void showNoMoreV2(String str);

    void startProgressDialog();

    void stopProgressDialog();
}
