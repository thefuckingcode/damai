package cn.damai.uikit.pulltorefresh.library.internal;

/* compiled from: Taobao */
public interface PullLoadingLayoutInferface {
    void onPullImpl(float f);

    void pullToRefreshImpl();

    void refreshingImpl();

    void releaseToRefreshImpl();

    void resetImpl();
}
