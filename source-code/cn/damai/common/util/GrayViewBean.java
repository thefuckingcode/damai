package cn.damai.common.util;

import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class GrayViewBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public String classNames;
    public String enableConfig;
    public String endTimeConfig;
    public String startTimeConfig;

    public long getEndTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2028456037")) {
            return xf2.a(this.endTimeConfig);
        }
        return ((Long) ipChange.ipc$dispatch("-2028456037", new Object[]{this})).longValue();
    }

    public List<String> getJsonArray() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306285559")) {
            return (List) ipChange.ipc$dispatch("-1306285559", new Object[]{this});
        }
        try {
            return JSON.parseArray(this.classNames, String.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public long getStartTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-451915852")) {
            return xf2.a(this.startTimeConfig);
        }
        return ((Long) ipChange.ipc$dispatch("-451915852", new Object[]{this})).longValue();
    }

    public boolean isAllGray() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1189720603")) {
            return "2".equals(this.enableConfig);
        }
        return ((Boolean) ipChange.ipc$dispatch("1189720603", new Object[]{this})).booleanValue();
    }

    public boolean isContainClass(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-160719879")) {
            return ((Boolean) ipChange.ipc$dispatch("-160719879", new Object[]{this, str})).booleanValue();
        }
        if (xf2.e(getJsonArray()) > 0) {
            for (int i = 0; i < getJsonArray().size(); i++) {
                if (str.equals(getJsonArray().get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEnableGrayConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721421557")) {
            return ((Boolean) ipChange.ipc$dispatch("-721421557", new Object[]{this})).booleanValue();
        }
        String str = this.enableConfig;
        return str != null && !"0".equals(str);
    }

    public boolean isPageGray(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1841142485")) {
            return ((Boolean) ipChange.ipc$dispatch("-1841142485", new Object[]{this, str})).booleanValue();
        }
        if (isValidTime()) {
            if (isAllGray()) {
                return true;
            }
            if ((isPartGray() || isPartPageGray()) && isContainClass(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPartGray() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-974934339")) {
            return "1".equals(this.enableConfig);
        }
        return ((Boolean) ipChange.ipc$dispatch("-974934339", new Object[]{this})).booleanValue();
    }

    public boolean isPartPageGray() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-16901714")) {
            return "3".equals(this.enableConfig);
        }
        return ((Boolean) ipChange.ipc$dispatch("-16901714", new Object[]{this})).booleanValue();
    }

    public boolean isValidTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1431102154")) {
            return ((Boolean) ipChange.ipc$dispatch("-1431102154", new Object[]{this})).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= getStartTime() || currentTimeMillis >= getEndTime()) {
            return false;
        }
        return true;
    }
}
