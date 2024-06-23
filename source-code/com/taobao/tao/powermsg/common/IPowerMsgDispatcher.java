package com.taobao.tao.powermsg.common;

import tb.wr1;

/* compiled from: Taobao */
public interface IPowerMsgDispatcher {
    void onDispatch(wr1 wr1);

    void onError(int i, Object obj);
}
