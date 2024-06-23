package com.youku.alixplayer.opensdk.live;

import android.text.TextUtils;
import com.youku.alixplayer.opensdk.FileFormat;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Quality;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.android.liveservice.bean.WaterMarkV2;
import java.util.List;

/* compiled from: Taobao */
public class LiveInfo {
    public String adInfo;
    public BypassPlayInfo bypassPlayInfo;
    private FileFormat fileFormat = FileFormat.UNKNOWN;
    public boolean isTrail;
    private Quality mQuality;
    public LivePlayControl playControl;
    public long requestCostTime = 0;
    public long timeshift = -1;
    private String url;
    public VideoInfo videoInfo;
    public List<WaterMarkV2> waterMarkV2List;

    public LiveInfo(FileFormat fileFormat2, String str) {
        this.fileFormat = fileFormat2;
        this.url = str;
    }

    public FileFormat getFileFormat() {
        return this.fileFormat;
    }

    public Quality getQuality() {
        return this.mQuality;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean hasAd() {
        VideoInfo videoInfo2 = this.videoInfo;
        return videoInfo2 != null && !TextUtils.isEmpty(videoInfo2.adInfo) && this.videoInfo.ad;
    }

    public LiveInfo(FileFormat fileFormat2, LivePlayControl livePlayControl) {
        this.fileFormat = fileFormat2;
        this.playControl = livePlayControl;
        this.mQuality = livePlayControl.getDefaultQuality();
    }
}
