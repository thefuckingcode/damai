package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class OrderDetailCanResellBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String canResell;
    public String errorCode;
    public String errorMsg;
    public String resellUrl;

    public boolean isCanResell() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1669487231")) {
            return !TextUtils.isEmpty(this.canResell) && !this.canResell.equals("false");
        }
        return ((Boolean) ipChange.ipc$dispatch("-1669487231", new Object[]{this})).booleanValue();
    }
}
