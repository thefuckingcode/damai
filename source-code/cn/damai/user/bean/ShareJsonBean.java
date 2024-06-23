package cn.damai.user.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class ShareJsonBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String ipName;
    public List<String> verticalPicList;

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "248421382")) {
            return !TextUtils.isEmpty(this.id) && !f92.d(this.verticalPicList);
        }
        return ((Boolean) ipChange.ipc$dispatch("248421382", new Object[]{this})).booleanValue();
    }
}
