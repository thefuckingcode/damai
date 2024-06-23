package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class VideoInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 3419910089794360719L;
    public String coverUrl;
    public String height;
    public String sourceLabel;
    public String status;
    public String url;
    public String videoTime;
    public String width;

    public static int str2Int(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197511821")) {
            return ((Integer) ipChange.ipc$dispatch("-197511821", new Object[]{str, Integer.valueOf(i)})).intValue();
        } else if (TextUtils.isEmpty(str)) {
            return i;
        } else {
            try {
                return Integer.parseInt(str);
            } catch (Exception e) {
                e.printStackTrace();
                return i;
            }
        }
    }

    public String formatVideoTime() {
        int str2Int;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505057674")) {
            return (String) ipChange.ipc$dispatch("1505057674", new Object[]{this});
        }
        if (TextUtils.isEmpty(this.videoTime) || (str2Int = str2Int(this.videoTime, -1)) <= 0) {
            return null;
        }
        int i = (str2Int % 60000) / 1000;
        int i2 = (str2Int % 3600000) / 60000;
        int i3 = str2Int / 3600000;
        StringBuilder sb = new StringBuilder();
        if (i3 > 0) {
            sb.append(i3);
            sb.append(":");
        }
        if (i2 <= 9) {
            sb.append("0");
        }
        sb.append(i2);
        sb.append(":");
        if (i <= 9) {
            sb.append("0");
        }
        sb.append(i);
        return sb.toString();
    }

    public String getCoverUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "539108871")) {
            return this.coverUrl;
        }
        return (String) ipChange.ipc$dispatch("539108871", new Object[]{this});
    }

    public String getHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1746292854")) {
            return this.height;
        }
        return (String) ipChange.ipc$dispatch("1746292854", new Object[]{this});
    }

    public String getSourceLabel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2071443872")) {
            return this.sourceLabel;
        }
        return (String) ipChange.ipc$dispatch("-2071443872", new Object[]{this});
    }

    public String getStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-404014143")) {
            return this.status;
        }
        return (String) ipChange.ipc$dispatch("-404014143", new Object[]{this});
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "485753142")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("485753142", new Object[]{this});
    }

    public int getVideoTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-803509628")) {
            return str2Int(this.videoTime, -1);
        }
        return ((Integer) ipChange.ipc$dispatch("-803509628", new Object[]{this})).intValue();
    }

    public String getWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1425533197")) {
            return this.width;
        }
        return (String) ipChange.ipc$dispatch("1425533197", new Object[]{this});
    }

    public boolean isVideoUnderReviewStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1866154634")) {
            return TextUtils.equals("0", this.status);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1866154634", new Object[]{this})).booleanValue();
    }

    public void setCoverUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-349822025")) {
            ipChange.ipc$dispatch("-349822025", new Object[]{this, str});
            return;
        }
        this.coverUrl = str;
    }

    public void setHeight(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1200378920")) {
            ipChange.ipc$dispatch("1200378920", new Object[]{this, str});
            return;
        }
        this.height = str;
    }

    public void setSourceLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2090201834")) {
            ipChange.ipc$dispatch("-2090201834", new Object[]{this, str});
            return;
        }
        this.sourceLabel = str;
    }

    public void setStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1034628547")) {
            ipChange.ipc$dispatch("-1034628547", new Object[]{this, str});
            return;
        }
        this.status = str;
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-702973696")) {
            ipChange.ipc$dispatch("-702973696", new Object[]{this, str});
            return;
        }
        this.url = str;
    }

    public void setVideoTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1841806809")) {
            ipChange.ipc$dispatch("-1841806809", new Object[]{this, str});
            return;
        }
        this.videoTime = str;
    }

    public void setWidth(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-561743607")) {
            ipChange.ipc$dispatch("-561743607", new Object[]{this, str});
            return;
        }
        this.width = str;
    }
}
