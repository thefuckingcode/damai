package cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.Serializable;

/* compiled from: Taobao */
public class PriceSummary implements Serializable, Comparable<PriceSummary> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 21212;
    public String color;
    public boolean maxPrice;
    public String priceId;
    public float priceValue;
    public String status;

    public String getFormatColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917629663")) {
            return (String) ipChange.ipc$dispatch("917629663", new Object[]{this});
        } else if (TextUtils.isEmpty(this.color)) {
            return null;
        } else {
            if (this.color.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                return this.color;
            }
            return Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.color;
        }
    }

    public int compareTo(@NonNull PriceSummary priceSummary) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1308589261")) {
            return (int) (priceSummary.priceValue - this.priceValue);
        }
        return ((Integer) ipChange.ipc$dispatch("-1308589261", new Object[]{this, priceSummary})).intValue();
    }
}
