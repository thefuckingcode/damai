package com.youku.alixplayer.opensdk;

import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.ups.data.BitStream;

/* compiled from: Taobao */
public interface IPlaylistBuilder {
    Period buildPlaylistByBitStream(PlayVideoInfo playVideoInfo, BitStream bitStream, int i) throws RuntimeException;

    Period buildPlaylistByLiveInfo(PlayVideoInfo playVideoInfo, LiveInfo liveInfo) throws RuntimeException;
}
