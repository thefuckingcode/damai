package com.youku.live.widgets.protocol;

import com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener;
import com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener;
import com.youku.live.widgets.protocol2.lifecycle.IWidgetViewAttachStateChangedListener;

/* compiled from: Taobao */
public interface IWidgetLifecycle extends IAppearStateChangedListener, IMountStateChangedListener, IWidgetViewAttachStateChangedListener {
    @Deprecated
    void didViewAttach();
}
