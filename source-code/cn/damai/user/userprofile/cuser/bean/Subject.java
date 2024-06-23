package cn.damai.user.userprofile.cuser.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class Subject {
    private static transient /* synthetic */ IpChange $ipChange;
    public int status;
    private String subjectDesc;
    private String subjectId;
    private String subjectImg;
    private String subjectName;
    private int type;

    public String getSubjectDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-36072854")) {
            return this.subjectDesc;
        }
        return (String) ipChange.ipc$dispatch("-36072854", new Object[]{this});
    }

    public String getSubjectId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-488914060")) {
            return this.subjectId;
        }
        return (String) ipChange.ipc$dispatch("-488914060", new Object[]{this});
    }

    public String getSubjectImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1298732096")) {
            return this.subjectImg;
        }
        return (String) ipChange.ipc$dispatch("-1298732096", new Object[]{this});
    }

    public String getSubjectName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1624093340")) {
            return this.subjectName;
        }
        return (String) ipChange.ipc$dispatch("-1624093340", new Object[]{this});
    }

    public int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-887230672")) {
            return this.type;
        }
        return ((Integer) ipChange.ipc$dispatch("-887230672", new Object[]{this})).intValue();
    }

    public void setSubjectDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "876757580")) {
            ipChange.ipc$dispatch("876757580", new Object[]{this, str});
            return;
        }
        this.subjectDesc = str;
    }

    public void setSubjectId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58328450")) {
            ipChange.ipc$dispatch("58328450", new Object[]{this, str});
            return;
        }
        this.subjectId = str;
    }

    public void setSubjectImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "579094558")) {
            ipChange.ipc$dispatch("579094558", new Object[]{this, str});
            return;
        }
        this.subjectImg = str;
    }

    public void setSubjectName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107237230")) {
            ipChange.ipc$dispatch("-1107237230", new Object[]{this, str});
            return;
        }
        this.subjectName = str;
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1822897038")) {
            ipChange.ipc$dispatch("-1822897038", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.type = i;
    }
}
