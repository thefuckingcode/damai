package cn.damai.ultron.view.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class DmViewerBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String hashIdentityNo;
    public int idType;
    public String idTypeDesc;
    public String identityNo;
    public String isDisabled;
    public String isUsed;
    public String seatId;
    public String viewerId;
    public String viewerName;

    public boolean isDisabled() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1989760557")) {
            return !TextUtils.isEmpty(this.isDisabled) && this.isDisabled.equals("true");
        }
        return ((Boolean) ipChange.ipc$dispatch("-1989760557", new Object[]{this})).booleanValue();
    }

    public boolean isUsed() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-451379214")) {
            return !TextUtils.isEmpty(this.isUsed) && this.isUsed.equals("true");
        }
        return ((Boolean) ipChange.ipc$dispatch("-451379214", new Object[]{this})).booleanValue();
    }
}
