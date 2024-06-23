package cn.damai.user.userprofile.cuser.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class FocusList {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Feeds> data;
    private boolean hasNext;

    public List<Feeds> getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1882274116")) {
            return this.data;
        }
        return (List) ipChange.ipc$dispatch("1882274116", new Object[]{this});
    }

    public boolean getHasNext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2031777388")) {
            return this.hasNext;
        }
        return ((Boolean) ipChange.ipc$dispatch("-2031777388", new Object[]{this})).booleanValue();
    }

    public void setData(List<Feeds> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2032145656")) {
            ipChange.ipc$dispatch("-2032145656", new Object[]{this, list});
            return;
        }
        this.data = list;
    }

    public void setHasNext(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332280136")) {
            ipChange.ipc$dispatch("-332280136", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.hasNext = z;
    }
}
