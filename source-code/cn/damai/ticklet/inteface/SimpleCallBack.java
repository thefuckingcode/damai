package cn.damai.ticklet.inteface;

/* compiled from: Taobao */
public interface SimpleCallBack<T> {
    void onFail(String str, String str2);

    void onSuccess(T t);
}
