package com.youku.live.livesdk.wkit;

import android.content.res.Configuration;

/* compiled from: Taobao */
public interface ILiveActivityActions {
    void deInit();

    void enterPipBySlidingRoom();

    void init();

    boolean isEnterPipMode();

    boolean isInPipMode();

    void onActivityPictureInPictureModeChanged(boolean z, Configuration configuration);

    void onBackPressed();
}
