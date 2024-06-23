package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
public class VideoAlbum implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CONTENT_TAG_ARTICAL = 1;
    public static final int CONTENT_TAG_VIDEO = 2;
    public BaseUserDO baseUserDO;
    private String content;
    public ContentInfo contentInfo;
    public int contentTag;
    private String headImg;
    private String id;
    public ArrayList<String> imgList;
    public String ipvuv;
    private int isFeature;
    private String nickname;
    private String pic;
    public String publishTime;
    public String publishTimeStr;
    private VideoInfo videoInfo;

    public String getContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1176951607")) {
            return this.content;
        }
        return (String) ipChange.ipc$dispatch("1176951607", new Object[]{this});
    }

    public String getHeadImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1812257919")) {
            return this.headImg;
        }
        return (String) ipChange.ipc$dispatch("-1812257919", new Object[]{this});
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1093622803")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("1093622803", new Object[]{this});
    }

    public int getIsFeature() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-381743511")) {
            return this.isFeature;
        }
        return ((Integer) ipChange.ipc$dispatch("-381743511", new Object[]{this})).intValue();
    }

    public String getNickname() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1783227866")) {
            return this.nickname;
        }
        return (String) ipChange.ipc$dispatch("-1783227866", new Object[]{this});
    }

    public String getPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-644425912")) {
            return this.pic;
        }
        return (String) ipChange.ipc$dispatch("-644425912", new Object[]{this});
    }

    public VideoInfo getVideoInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1440229694")) {
            return this.videoInfo;
        }
        return (VideoInfo) ipChange.ipc$dispatch("1440229694", new Object[]{this});
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "509507871")) {
            ipChange.ipc$dispatch("509507871", new Object[]{this, str});
            return;
        }
        this.content = str;
    }

    public void setHeadImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961674219")) {
            ipChange.ipc$dispatch("-1961674219", new Object[]{this, str});
            return;
        }
        this.headImg = str;
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1616079317")) {
            ipChange.ipc$dispatch("-1616079317", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public void setIsFeature(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-780559935")) {
            ipChange.ipc$dispatch("-780559935", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.isFeature = i;
    }

    public void setNickname(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "672183160")) {
            ipChange.ipc$dispatch("672183160", new Object[]{this, str});
            return;
        }
        this.nickname = str;
    }

    public void setPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1378786002")) {
            ipChange.ipc$dispatch("-1378786002", new Object[]{this, str});
            return;
        }
        this.pic = str;
    }

    public void setVideoInfo(VideoInfo videoInfo2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052773254")) {
            ipChange.ipc$dispatch("1052773254", new Object[]{this, videoInfo2});
            return;
        }
        this.videoInfo = videoInfo2;
    }
}
