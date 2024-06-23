package com.youku.alixplayer.opensdk;

import com.youku.alixplayer.opensdk.statistics.track.business.OnBusinessTrackListener;

/* compiled from: Taobao */
public interface IBusinessTrack {
    void addBusinessTrackListener(OnBusinessTrackListener onBusinessTrackListener);

    void didAppear();

    void didDisappear();

    boolean put(String str, String str2);

    void removeBusinessTrackListener(OnBusinessTrackListener onBusinessTrackListener);
}
