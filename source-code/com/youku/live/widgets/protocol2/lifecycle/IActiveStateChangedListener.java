package com.youku.live.widgets.protocol2.lifecycle;

/* compiled from: Taobao */
public interface IActiveStateChangedListener {
    void didActive();

    void didDeactive();

    void willActive();

    void willDeactive();
}
