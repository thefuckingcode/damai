package cn.damai.category.discountticket.model;

/* compiled from: Taobao */
public interface BaseListener<T> {
    void onFail(String str, String str2);

    void onSuccess(T t);
}
