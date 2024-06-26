package cn.damai.ticklet.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class TicketSouvenirParams implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public String performId;
    public String productSystemId;
    public String venueName;

    public TicketSouvenirParams() {
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "491277587")) {
            return !TextUtils.isEmpty(this.performId);
        }
        return ((Boolean) ipChange.ipc$dispatch("491277587", new Object[]{this})).booleanValue();
    }

    public TicketSouvenirParams(String str, String str2, String str3) {
        this.performId = str;
        this.venueName = str2;
        this.productSystemId = str3;
    }
}
