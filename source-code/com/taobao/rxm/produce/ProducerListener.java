package com.taobao.rxm.produce;

import tb.c02;

/* compiled from: Taobao */
public interface ProducerListener<T extends c02> {
    void onEnterIn(T t, Class cls, boolean z, boolean z2);

    void onExitOut(T t, Class cls, boolean z, boolean z2, boolean z3);
}
