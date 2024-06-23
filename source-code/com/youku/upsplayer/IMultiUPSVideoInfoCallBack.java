package com.youku.upsplayer;

import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.module.VideoCacheInfo;
import java.util.List;

/* compiled from: Taobao */
public interface IMultiUPSVideoInfoCallBack {
    void onGetVideoInfoResult(List<VideoCacheInfo> list, ConnectStat connectStat);
}
