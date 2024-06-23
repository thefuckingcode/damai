package com.taobao.weex.ui.view.gesture;

import androidx.annotation.Nullable;

/* compiled from: Taobao */
public interface WXGestureObservable {
    WXGesture getGestureListener();

    void registerGestureListener(@Nullable WXGesture wXGesture);
}
