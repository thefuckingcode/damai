package cn.damai.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class SDCardCacheEntity implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String data;
    public String etag = "";
    public long time = 0;
    public String url = "";

    public String getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "254711522")) {
            return this.data;
        }
        return (String) ipChange.ipc$dispatch("254711522", new Object[]{this});
    }

    public String getEtag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-595104563")) {
            return this.etag;
        }
        return (String) ipChange.ipc$dispatch("-595104563", new Object[]{this});
    }

    public long getTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1584230255")) {
            return this.time;
        }
        return ((Long) ipChange.ipc$dispatch("1584230255", new Object[]{this})).longValue();
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1618888275")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("-1618888275", new Object[]{this});
    }

    public void setData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-986634180")) {
            ipChange.ipc$dispatch("-986634180", new Object[]{this, str});
            return;
        }
        this.data = str;
    }

    public void setEtag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1561129039")) {
            ipChange.ipc$dispatch("-1561129039", new Object[]{this, str});
            return;
        }
        this.etag = str;
    }

    public void setTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1777948597")) {
            ipChange.ipc$dispatch("1777948597", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.time = j;
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522348183")) {
            ipChange.ipc$dispatch("-1522348183", new Object[]{this, str});
            return;
        }
        this.url = str;
    }
}
