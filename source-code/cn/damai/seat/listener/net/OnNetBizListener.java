package cn.damai.seat.listener.net;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
public interface OnNetBizListener<T> {
    void onNetFail(String str, String str2);

    void onNetSuccess(@NonNull T t);
}
