package cn.damai.pay.alipay;

import android.text.TextUtils;
import com.alipay.sdk.m.u.l;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
public class PayResult {
    private static transient /* synthetic */ IpChange $ipChange;
    private String memo;
    private String result;
    private String resultStatus;

    public PayResult(Map<String, String> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                if (TextUtils.equals(str, l.a)) {
                    this.resultStatus = map.get(str);
                } else if (TextUtils.equals(str, "result")) {
                    this.result = map.get(str);
                } else if (TextUtils.equals(str, l.b)) {
                    this.memo = map.get(str);
                }
            }
        }
    }

    public String getMemo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2113618075")) {
            return this.memo;
        }
        return (String) ipChange.ipc$dispatch("-2113618075", new Object[]{this});
    }

    public String getResult() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-277132600")) {
            return this.result;
        }
        return (String) ipChange.ipc$dispatch("-277132600", new Object[]{this});
    }

    public String getResultStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-516433894")) {
            return this.resultStatus;
        }
        return (String) ipChange.ipc$dispatch("-516433894", new Object[]{this});
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195242611")) {
            return (String) ipChange.ipc$dispatch("-1195242611", new Object[]{this});
        }
        return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + "}";
    }
}
