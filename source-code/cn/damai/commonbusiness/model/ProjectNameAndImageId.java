package cn.damai.commonbusiness.model;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectNameAndImageId {
    private static transient /* synthetic */ IpChange $ipChange;
    public int stateImageId;
    public String stateName;
    public int stateTextId;

    public boolean isAvailable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1844571902")) {
            return (this.stateImageId == 0 || this.stateTextId == 0 || TextUtils.isEmpty(this.stateName)) ? false : true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1844571902", new Object[]{this})).booleanValue();
    }
}
