package com.taobao.uikit.feature.callback;

import android.graphics.Rect;

/* compiled from: Taobao */
public interface FocusCallback {
    void afterOnFocusChanged(boolean z, int i, Rect rect);

    void afterOnWindowFocusChanged(boolean z);

    void beforeOnFocusChanged(boolean z, int i, Rect rect);

    void beforeOnWindowFocusChanged(boolean z);
}
