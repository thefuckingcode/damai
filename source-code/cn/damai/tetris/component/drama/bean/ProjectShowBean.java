package cn.damai.tetris.component.drama.bean;

import android.os.SystemClock;
import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.MarketTabBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectShowBean extends MarketTabBase {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String REQUEST_FINISH_TIME = "requestFinishTime";
    public static final String SERVER_TIME = "serverTime";
    public static final int STATUS_IN_SALE = 2;
    public static final int STATUS_SALE_OUT = 3;
    public static final int STATUS_SALE_SOON = 1;
    public String categoryName;
    public String cityName;
    public long countdownTime;
    public String ipvuv;
    public String itemId;
    public String itemScore;
    public String itemStar;
    public String name;
    public String onSaleTime;
    public int postColor = -1;
    public String priceLow;
    public long requestFinishTime = -1;
    public String schema;
    public long serverTime = -1;
    public String showTime;
    public int status;
    public String title;
    public long upTime = -1;
    public String venueName;
    public String verticalPic;

    public long getCountdownTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654602787")) {
            return ((Long) ipChange.ipc$dispatch("-654602787", new Object[]{this})).longValue();
        }
        long j = this.countdownTime;
        long j2 = 0;
        if (this.requestFinishTime > 0) {
            j2 = SystemClock.elapsedRealtime() - this.requestFinishTime;
        }
        return j - j2;
    }

    public double getItemScoreValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2015527711")) {
            return ((Double) ipChange.ipc$dispatch("2015527711", new Object[]{this})).doubleValue();
        } else if (TextUtils.isEmpty(this.itemScore)) {
            return -1.0d;
        } else {
            try {
                return Double.parseDouble(this.itemScore);
            } catch (Exception e) {
                e.printStackTrace();
                return -1.0d;
            }
        }
    }
}
