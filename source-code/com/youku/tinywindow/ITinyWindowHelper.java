package com.youku.tinywindow;

/* compiled from: Taobao */
public interface ITinyWindowHelper {
    void destroyTinyWindow();

    void enterTinyWindow();

    void hideTinyWindow();

    void setTinyWindowHelperListener(TinyWindowHelperListener tinyWindowHelperListener);

    void updateWithMute(boolean z);

    void updateWithPause(boolean z);
}
