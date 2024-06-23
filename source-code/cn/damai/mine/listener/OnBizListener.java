package cn.damai.mine.listener;

/* compiled from: Taobao */
public interface OnBizListener<T> {
    void onBizFail(String str, String str2);

    void onBizSuccess(T t);
}
