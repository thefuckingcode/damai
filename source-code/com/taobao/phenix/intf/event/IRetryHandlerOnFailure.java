package com.taobao.phenix.intf.event;

import tb.vp1;

/* compiled from: Taobao */
public interface IRetryHandlerOnFailure {
    String getRetryUrl(vp1 vp1, Throwable th);
}
