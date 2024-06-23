package cn.damai.commonbusiness.seatbiz.promotion.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class CouponCreditsBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String returnCode;

    public String getReturnMsg() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1000200139")) {
            return (String) ipChange.ipc$dispatch("1000200139", new Object[]{this});
        } else if (TextUtils.isEmpty(this.returnCode) || !"0".equals(this.returnCode)) {
            return "兑换失败，请重试";
        } else {
            return "兑换成功";
        }
    }

    public boolean isSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2146199013")) {
            return !TextUtils.isEmpty(this.returnCode) && "0".equals(this.returnCode);
        }
        return ((Boolean) ipChange.ipc$dispatch("2146199013", new Object[]{this})).booleanValue();
    }
}
