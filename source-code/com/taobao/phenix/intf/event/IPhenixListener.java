package com.taobao.phenix.intf.event;

import tb.wp1;

/* compiled from: Taobao */
public interface IPhenixListener<T extends wp1> {
    boolean onHappen(T t);
}
