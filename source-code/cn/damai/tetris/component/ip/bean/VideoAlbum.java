package cn.damai.tetris.component.ip.bean;

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
        if (!AndroidInstantRuntime.support(ipChange, "-1469364682")) {
            return this.content;
        }
        return (String) ipChange.ipc$dispatch("-1469364682", new Object[]{this});
    }

    public String getHeadImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-163606912")) {
            return this.headImg;
        }
        return (String) ipChange.ipc$dispatch("-163606912", new Object[]{this});
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2063977908")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("2063977908", new Object[]{this});
    }

    public int getIsFeature() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1163401910")) {
            return this.isFeature;
        }
        return ((Integer) ipChange.ipc$dispatch("-1163401910", new Object[]{this})).intValue();
    }

    public String getNickname() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2080313095")) {
            return this.nickname;
        }
        return (String) ipChange.ipc$dispatch("2080313095", new Object[]{this});
    }

    public String getPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-628188729")) {
            return this.pic;
        }
        return (String) ipChange.ipc$dispatch("-628188729", new Object[]{this});
    }

    public VideoInfo getVideoInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "229346918")) {
            return this.videoInfo;
        }
        return (VideoInfo) ipChange.ipc$dispatch("229346918", new Object[]{this});
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "78081536")) {
            ipChange.ipc$dispatch("78081536", new Object[]{this, str});
            return;
        }
        this.content = str;
    }

    public void setHeadImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1901866742")) {
            ipChange.ipc$dispatch("1901866742", new Object[]{this, str});
            return;
        }
        this.headImg = str;
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599842134")) {
            ipChange.ipc$dispatch("-1599842134", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public void setIsFeature(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757833472")) {
            ipChange.ipc$dispatch("757833472", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.isFeature = i;
    }

    public void setNickname(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182868663")) {
            ipChange.ipc$dispatch("182868663", new Object[]{this, str});
            return;
        }
        this.nickname = str;
    }

    public void setPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-875433329")) {
            ipChange.ipc$dispatch("-875433329", new Object[]{this, str});
            return;
        }
        this.pic = str;
    }

    public void setVideoInfo(VideoInfo videoInfo2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1856723638")) {
            ipChange.ipc$dispatch("1856723638", new Object[]{this, videoInfo2});
            return;
        }
        this.videoInfo = videoInfo2;
    }
}
