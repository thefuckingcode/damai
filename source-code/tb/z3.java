package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.address.bean.PhoneAllowableResult;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public final class z3 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(PhoneAllowableResult phoneAllowableResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-988819406")) {
            ipChange.ipc$dispatch("-988819406", new Object[]{phoneAllowableResult});
        } else if (phoneAllowableResult != null) {
            try {
                d20.T("supported_phone_allowable", JSON.toJSONString(phoneAllowableResult));
            } catch (Exception unused) {
            }
        }
    }

    private static PhoneAllowableResult b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-973901985")) {
            return (PhoneAllowableResult) ipChange.ipc$dispatch("-973901985", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            try {
                return (PhoneAllowableResult) JSON.parseObject(str, PhoneAllowableResult.class);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static PhoneAllowableResult c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1306087134") ? (PhoneAllowableResult) ipChange.ipc$dispatch("-1306087134", new Object[0]) : b(d20.B("supported_phone_allowable"));
    }
}
