package com.youku.alixplayer.opensdk;

import com.youku.alixplayer.opensdk.ups.data.BitStream;
import java.util.List;

/* compiled from: Taobao */
public interface IVideoStream {
    void changeSource(boolean z, String str, int i);

    AlixVideoItem getCurAlixVideoItem();

    BitStream getCurrentBitStream();

    List<String> getLanguageList();

    PlayVideoInfo getPlayVideoInfo();

    List<AlixVideoItem> getVideoList(String str);

    YoukuVideoInfo getYoukuVideoInfo();
}
