package com.youku.uplayer;

/* compiled from: Taobao */
public interface OnScreenShotFinishListener {
    void onPreviewChange(Object obj);

    void onPreviewEnd();

    void onScreenShotError(int i);

    void onScreenShotFinished();

    void onScreenShotProgress(int i);

    void onScreenShotVideoEncoderMode(int i);
}
