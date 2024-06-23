package cn.damai.tetris.component.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class ActorBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String artistId;
    private String damaiId;
    private String description;
    private String headPic;
    private String name;
    private String subtype;

    public String getArtistId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "282345800")) {
            return this.artistId;
        }
        return (String) ipChange.ipc$dispatch("282345800", new Object[]{this});
    }

    public String getDescription() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1004154924")) {
            return this.description;
        }
        return (String) ipChange.ipc$dispatch("1004154924", new Object[]{this});
    }

    public String getHeadPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-181243078")) {
            return this.headPic;
        }
        return (String) ipChange.ipc$dispatch("-181243078", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-16064495")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-16064495", new Object[]{this});
    }

    public String getSubtype() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1985489194")) {
            return this.subtype;
        }
        return (String) ipChange.ipc$dispatch("1985489194", new Object[]{this});
    }

    public void setArtistId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "280457366")) {
            ipChange.ipc$dispatch("280457366", new Object[]{this, str});
            return;
        }
        this.artistId = str;
    }

    public void setDescription(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235919670")) {
            ipChange.ipc$dispatch("-1235919670", new Object[]{this, str});
            return;
        }
        this.description = str;
    }

    public void setHeadPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1355145596")) {
            ipChange.ipc$dispatch("1355145596", new Object[]{this, str});
            return;
        }
        this.headPic = str;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790756115")) {
            ipChange.ipc$dispatch("-790756115", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void setSubtype(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-195630708")) {
            ipChange.ipc$dispatch("-195630708", new Object[]{this, str});
            return;
        }
        this.subtype = str;
    }
}
