package com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget;

import android.view.View;

/* compiled from: Taobao */
public interface ITipsContainerView {
    void animHide();

    void animShow();

    View getView();

    void onControlShowChange(int i, boolean z);

    void onScreenModeChanged(int i, boolean z);
}
