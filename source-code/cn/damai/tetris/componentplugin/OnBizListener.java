package cn.damai.tetris.componentplugin;

/* compiled from: Taobao */
public interface OnBizListener<T> {
    void onFail(String str, String str2);

    void onSuccess(T t);
}
