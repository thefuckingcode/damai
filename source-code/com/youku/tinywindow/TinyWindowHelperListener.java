package com.youku.tinywindow;

/* compiled from: Taobao */
public interface TinyWindowHelperListener {
    void onHelperWindowClick();

    void onHelperWindowClosed();

    void onHelperWindowMutePlayer(boolean z);

    void onHelperWindowPausePlayer(boolean z);

    void onHelperWindowShowFailed(int i);

    void onHelperWindowShowSuccess();
}
