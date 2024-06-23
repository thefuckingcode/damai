package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

@Deprecated
/* compiled from: Taobao */
public class ProjectDynamicArtistBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -3421669709263056768L;
    private String archives;
    private long artistId;
    private String artistName;
    private String picUrl;
    private String tag;
    private String type;

    public String getArchives() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "122714831")) {
            return this.archives;
        }
        return (String) ipChange.ipc$dispatch("122714831", new Object[]{this});
    }

    public long getArtistId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1282391692")) {
            return this.artistId;
        }
        return ((Long) ipChange.ipc$dispatch("-1282391692", new Object[]{this})).longValue();
    }

    public String getArtistName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-778948080")) {
            return this.artistName;
        }
        return (String) ipChange.ipc$dispatch("-778948080", new Object[]{this});
    }

    public String getPicUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "915419427")) {
            return this.picUrl;
        }
        return (String) ipChange.ipc$dispatch("915419427", new Object[]{this});
    }

    public String getTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-649118478")) {
            return this.tag;
        }
        return (String) ipChange.ipc$dispatch("-649118478", new Object[]{this});
    }

    public String getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1711740184")) {
            return this.type;
        }
        return (String) ipChange.ipc$dispatch("1711740184", new Object[]{this});
    }

    public void setArchives(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-373135377")) {
            ipChange.ipc$dispatch("-373135377", new Object[]{this, str});
            return;
        }
        this.archives = str;
    }

    public void setArtistId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-188653488")) {
            ipChange.ipc$dispatch("-188653488", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.artistId = j;
    }

    public void setArtistName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487470130")) {
            ipChange.ipc$dispatch("-487470130", new Object[]{this, str});
            return;
        }
        this.artistName = str;
    }

    public void setPicUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213106459")) {
            ipChange.ipc$dispatch("1213106459", new Object[]{this, str});
            return;
        }
        this.picUrl = str;
    }

    public void setTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1524255548")) {
            ipChange.ipc$dispatch("-1524255548", new Object[]{this, str});
            return;
        }
        this.tag = str;
    }

    public void setType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1231581382")) {
            ipChange.ipc$dispatch("1231581382", new Object[]{this, str});
            return;
        }
        this.type = str;
    }
}
