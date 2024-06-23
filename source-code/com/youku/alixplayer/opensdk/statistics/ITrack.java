package com.youku.alixplayer.opensdk.statistics;

import com.youku.alixplayer.opensdk.PlayVideoInfo;

/* compiled from: Taobao */
public interface ITrack {
    PlayVideoInfo getPlayVideoInfo();

    String getString(String str);

    boolean isDataReady();

    boolean isRealVideoCompletion();

    boolean isRealVideoStarted();

    void putString(String str, String str2);
}
