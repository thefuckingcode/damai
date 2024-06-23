package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener;

import tb.kl1;

/* compiled from: Taobao */
public interface RequestListener<T, E> {
    void onFail(kl1<E> kl1, String str, String str2);

    void onSuccess(kl1<E> kl1, T t);
}
