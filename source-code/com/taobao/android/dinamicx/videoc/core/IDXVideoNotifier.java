package com.taobao.android.dinamicx.videoc.core;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
public interface IDXVideoNotifier<Video> {
    boolean isVideoPlaying(Video video);

    void notifyVideoPlay(IDXVideoController<?, Video> iDXVideoController, @NonNull Video video, @NonNull String str);

    void notifyVideoStop(IDXVideoController<?, Video> iDXVideoController, @NonNull Video video, @NonNull String str);

    int remainingVideoCount();

    void removePlayingVideo(@NonNull Video video);
}
