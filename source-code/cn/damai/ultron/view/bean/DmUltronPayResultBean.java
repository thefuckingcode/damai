package cn.damai.ultron.view.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class DmUltronPayResultBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bizOrderId;
    public String nextUrl;
    public String partSuccess;

    public boolean getPartSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1640659434")) {
            return !TextUtils.isEmpty(this.partSuccess) && this.partSuccess.equals("true");
        }
        return ((Boolean) ipChange.ipc$dispatch("1640659434", new Object[]{this})).booleanValue();
    }
}
