package com.youku.upsplayer;

import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.module.VideoInfo;

/* compiled from: Taobao */
public interface IVideoInfoCallBack {
    void onGetVideoInfoResult(VideoInfo videoInfo, ConnectStat connectStat);
}
