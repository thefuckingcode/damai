package com.alimm.xadsdk.business.playerad.interfaces;

import com.alimm.xadsdk.base.model.AdInfo;

/* compiled from: Taobao */
public interface OnAdEventListener {
    void onDataPrepared(int i, AdInfo adInfo);

    void onReadyToClose(int i, AdInfo adInfo);

    void onReadyToShow(int i, AdInfo adInfo);
}
