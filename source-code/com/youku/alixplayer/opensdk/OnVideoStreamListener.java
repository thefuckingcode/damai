package com.youku.alixplayer.opensdk;

/* compiled from: Taobao */
public interface OnVideoStreamListener {
    void onDataFail(VideoRequestError videoRequestError);

    void onDataReady(YoukuVideoInfo youkuVideoInfo);

    void onNewRequest(PlayVideoInfo playVideoInfo);
}
