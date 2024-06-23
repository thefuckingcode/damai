package cn.damai.tetris.component.ip.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class Content implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String content;
    private String headImg;
    private long id;
    private int isFeature;
    private String nickname;
    private String pic;
    private VideoInfo videoInfo;

    public String getContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-603697231")) {
            return this.content;
        }
        return (String) ipChange.ipc$dispatch("-603697231", new Object[]{this});
    }

    public String getHeadImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "702060539")) {
            return this.headImg;
        }
        return (String) ipChange.ipc$dispatch("702060539", new Object[]{this});
    }

    public long getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-696097765")) {
            return this.id;
        }
        return ((Long) ipChange.ipc$dispatch("-696097765", new Object[]{this})).longValue();
    }

    public int getIsFeature() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1396340015")) {
            return this.isFeature;
        }
        return ((Integer) ipChange.ipc$dispatch("1396340015", new Object[]{this})).intValue();
    }

    public String getNickname() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1148766996")) {
            return this.nickname;
        }
        return (String) ipChange.ipc$dispatch("-1148766996", new Object[]{this});
    }

    public String getPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1341810494")) {
            return this.pic;
        }
        return (String) ipChange.ipc$dispatch("-1341810494", new Object[]{this});
    }

    public VideoInfo getVideoInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1313760565")) {
            return this.videoInfo;
        }
        return (VideoInfo) ipChange.ipc$dispatch("-1313760565", new Object[]{this});
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143968741")) {
            ipChange.ipc$dispatch("1143968741", new Object[]{this, str});
            return;
        }
        this.content = str;
    }

    public void setHeadImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1327213349")) {
            ipChange.ipc$dispatch("-1327213349", new Object[]{this, str});
            return;
        }
        this.headImg = str;
    }

    public void setId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-318780535")) {
            ipChange.ipc$dispatch("-318780535", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.id = j;
    }

    public void setIsFeature(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1494545477")) {
            ipChange.ipc$dispatch("-1494545477", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.isFeature = i;
    }

    public void setNickname(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1134366350")) {
            ipChange.ipc$dispatch("-1134366350", new Object[]{this, str});
            return;
        }
        this.nickname = str;
    }

    public void setPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522871564")) {
            ipChange.ipc$dispatch("-1522871564", new Object[]{this, str});
            return;
        }
        this.pic = str;
    }

    public void setVideoInfo(VideoInfo videoInfo2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1265031921")) {
            ipChange.ipc$dispatch("1265031921", new Object[]{this, videoInfo2});
            return;
        }
        this.videoInfo = videoInfo2;
    }
}
