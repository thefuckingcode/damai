package cn.damai.tetris.component.brand.bean;

import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class VideoDO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String coverUrl;
    private String fileId;
    private String sourceLabel;
    private String type;
    private String url;
    private String videoId;
    private String videoTime;

    public String getCoverUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1239784075")) {
            return this.coverUrl;
        }
        return (String) ipChange.ipc$dispatch("-1239784075", new Object[]{this});
    }

    public String getFileId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1900194292")) {
            return this.fileId;
        }
        return (String) ipChange.ipc$dispatch("1900194292", new Object[]{this});
    }

    public String getSourceLabel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1469732814")) {
            return this.sourceLabel;
        }
        return (String) ipChange.ipc$dispatch("-1469732814", new Object[]{this});
    }

    public String getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1006723465")) {
            return this.type;
        }
        return (String) ipChange.ipc$dispatch("-1006723465", new Object[]{this});
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2108773640")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("2108773640", new Object[]{this});
    }

    public String getVideoId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1465850383")) {
            return this.videoId;
        }
        return (String) ipChange.ipc$dispatch("1465850383", new Object[]{this});
    }

    public String getVideoTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "969968769")) {
            return this.videoTime;
        }
        return (String) ipChange.ipc$dispatch("969968769", new Object[]{this});
    }

    public void setCoverUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "339071497")) {
            ipChange.ipc$dispatch("339071497", new Object[]{this, str});
            return;
        }
        this.coverUrl = str;
    }

    public void setFileId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1676356202")) {
            ipChange.ipc$dispatch("1676356202", new Object[]{this, str});
            return;
        }
        this.fileId = str;
    }

    public void setSourceLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-617028220")) {
            ipChange.ipc$dispatch("-617028220", new Object[]{this, str});
            return;
        }
        this.sourceLabel = str;
    }

    public void setType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436413113")) {
            ipChange.ipc$dispatch("-1436413113", new Object[]{this, str});
            return;
        }
        this.type = str;
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1928945810")) {
            ipChange.ipc$dispatch("-1928945810", new Object[]{this, str});
            return;
        }
        this.url = str;
    }

    public void setVideoId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "875435335")) {
            ipChange.ipc$dispatch("875435335", new Object[]{this, str});
            return;
        }
        this.videoId = str;
    }

    public void setVideoTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1960944107")) {
            ipChange.ipc$dispatch("-1960944107", new Object[]{this, str});
            return;
        }
        this.videoTime = str;
    }

    public VideoInfo transform() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1238009243")) {
            return (VideoInfo) ipChange.ipc$dispatch("1238009243", new Object[]{this});
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoId(getVideoId());
        videoInfo.setPicUrl(getCoverUrl());
        videoInfo.setVideoUrl(getUrl());
        videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
        videoInfo.setTitle(getSourceLabel());
        return videoInfo;
    }
}
