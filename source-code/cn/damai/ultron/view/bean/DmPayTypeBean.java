package cn.damai.ultron.view.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DmPayTypeBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String activityId;
    public String bankCode;
    public String cashierOrderNo;
    public String code;
    public String fpActId;
    public String icon;
    public String isUsed;
    public String name;
    public String orgCode;
    public String payPromotionAmount;
    public String payPromotionCode;
    public String promotionDesc;

    public boolean isSelect() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1052054959")) {
            return !TextUtils.isEmpty(this.isUsed) && this.isUsed.equals("true");
        }
        return ((Boolean) ipChange.ipc$dispatch("1052054959", new Object[]{this})).booleanValue();
    }
}
