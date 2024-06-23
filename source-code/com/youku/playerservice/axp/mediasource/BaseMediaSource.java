package com.youku.playerservice.axp.mediasource;

import com.youku.playerservice.axp.playinfo.PlayInfo;

/* compiled from: Taobao */
public class BaseMediaSource extends com.youku.alixplayer.BaseMediaSource {
    protected OnMediaSourceListener mOnMediaSourceListener;

    /* compiled from: Taobao */
    public interface OnMediaSourceListener {
        void onPlaylistFailed(int i);
    }

    public PlayInfo getPlayInfo() {
        return null;
    }

    @Override // com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        return null;
    }

    @Override // com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
    }

    public void setOnMediaSourceListener(OnMediaSourceListener onMediaSourceListener) {
        this.mOnMediaSourceListener = onMediaSourceListener;
    }
}
