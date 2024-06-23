package com.alibaba.appmonitor.event;

import com.alibaba.appmonitor.pool.Reusable;
import tb.rq2;

@Deprecated
/* compiled from: Taobao */
public interface IRawEvent extends Reusable {
    rq2 dumpToUTEvent();
}
