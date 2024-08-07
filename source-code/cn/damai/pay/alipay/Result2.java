package cn.damai.pay.alipay;

import com.alipay.sdk.m.u.l;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class Result2 {
    private static transient /* synthetic */ IpChange $ipChange;
    public String memo;
    public String result;
    public String resultStatus;

    public Result2(String str) {
        try {
            String[] split = str.split(";");
            for (String str2 : split) {
                if (str2.startsWith(l.a)) {
                    this.resultStatus = gatValue(str2, l.a);
                }
                if (str2.startsWith("result")) {
                    this.result = gatValue(str2, "result");
                }
                if (str2.startsWith(l.b)) {
                    this.memo = gatValue(str2, l.b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String gatValue(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833934156")) {
            return (String) ipChange.ipc$dispatch("-1833934156", new Object[]{this, str, str2});
        }
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "493984893")) {
            return (String) ipChange.ipc$dispatch("493984893", new Object[]{this});
        }
        return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + "}";
    }
}
