package cn.damai.common.app.base;

/* compiled from: Taobao */
public interface BaseView {
    void showEmptyView();

    void showErrorTips(String str);

    void showLoading(String str);

    void stopLoading();
}
