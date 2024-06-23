package cn.damai.ticklet.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class TicketSouvenirInfo {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String CLOSED = "0";
    private static final String EXCHANGED = "2";
    private static final String NORMAL = "1";
    public String collectMethodNote;
    public String exchangeSiteStatus;
    public String funcNote;
    public String funcTitle;
    public String methodTitle;
    public String openTime;
    public String status;
    public String timeTitle;
    public String topNote;

    private boolean is(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-354444683")) {
            return ((Boolean) ipChange.ipc$dispatch("-354444683", new Object[]{this, str})).booleanValue();
        } else if (TextUtils.isEmpty(this.status)) {
            return false;
        } else {
            return this.status.contentEquals(str);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r0.equals("2") != false) goto L_0x004b;
     */
    public String getStateText() {
        IpChange ipChange = $ipChange;
        char c = 0;
        if (AndroidInstantRuntime.support(ipChange, "1936702615")) {
            return (String) ipChange.ipc$dispatch("1936702615", new Object[]{this});
        } else if (TextUtils.isEmpty(this.status)) {
            return "";
        } else {
            String str = this.status;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 49:
                    if (str.equals("1")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 50:
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                return null;
            }
            return "暂无可换";
        }
    }

    public boolean isClosedState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1608975678")) {
            return is("0");
        }
        return ((Boolean) ipChange.ipc$dispatch("-1608975678", new Object[]{this})).booleanValue();
    }

    public boolean isNormalState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1965020355")) {
            return is("1");
        }
        return ((Boolean) ipChange.ipc$dispatch("-1965020355", new Object[]{this})).booleanValue();
    }
}
