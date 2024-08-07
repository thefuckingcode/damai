package com.youku.alixplayer;

/* compiled from: Taobao */
public interface IMediaSource {

    /* compiled from: Taobao */
    public interface OnMediaSourceUpdatedListener {
        void onPeriodUpdate(int i, IPeriod iPeriod);

        void onPlaylistFailed();

        void onPlaylistPrepared(IMediaSource iMediaSource, IPlaylist iPlaylist);

        void onPlaylistUpdate(IPlaylist iPlaylist);
    }

    void addMediaSourceUpdatedListener(OnMediaSourceUpdatedListener onMediaSourceUpdatedListener);

    void deinit();

    String getSourceKey();

    void preparePlaylist();

    void removeMediaSourceUpdatedListener(OnMediaSourceUpdatedListener onMediaSourceUpdatedListener);
}
