package com.youku.uplayer;

import android.media.MediaPlayer;

/* compiled from: Taobao */
public interface OnNetworkErrorListener {
    void onError(MediaPlayer mediaPlayer, int i, int i2, int i3, Object obj);

    void onStartLoading(Object obj);
}
