package com.taobao.phenix.cache.memory;

import tb.pz1;

/* compiled from: Taobao */
public interface ReleasableReferenceListener {
    void onReferenceDowngrade2Passable(pz1 pz1);

    void onReferenceReleased(pz1 pz1);
}
