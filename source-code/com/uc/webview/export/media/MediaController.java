package com.uc.webview.export.media;

import android.view.View;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: Taobao */
public interface MediaController {

    @Api
    /* compiled from: Taobao */
    public interface MediaPlayerControl {
        Object execute(String str, int i, int i2, Object obj);
    }

    View asView();

    void onMessage(String str, long j, long j2, Object obj);

    void setMediaPlayerControl(MediaPlayerControl mediaPlayerControl);
}
