package com.youku.ups.request;

import com.youku.ups.data.b;
import com.youku.upsplayer.data.ConnectStat;

/* compiled from: Taobao */
public interface a<T> {
    void onFailure(com.youku.ups.data.a aVar);

    void onSuccess(b<T> bVar, ConnectStat connectStat);
}
