package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class fe1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRANCH_NAME = "mine";
    public static final String MINE_ORDERDETAIL_ERROR_CODE = "-7001";
    public static final String MINE_ORDERDETAIL_ERROR_MSG = "订单详情加载失败";

    public static void a(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058219956")) {
            ipChange.ipc$dispatch("-1058219956", new Object[]{str, str2, str3});
            return;
        }
        yz2.a(b("mtop.damai.wireless.order.orderinfo", str, str2, str3), MINE_ORDERDETAIL_ERROR_CODE, MINE_ORDERDETAIL_ERROR_MSG);
    }

    public static String b(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-223036718")) {
            return (String) ipChange.ipc$dispatch("-223036718", new Object[]{str, str2, str3, str4});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("mine");
        sb.append(":jsondata={apiName: ");
        String str5 = "";
        if (TextUtils.isEmpty(str)) {
            str = str5;
        }
        sb.append(str);
        sb.append(", retCode: ");
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        sb.append(str2);
        sb.append(", retMsg: ");
        if (TextUtils.isEmpty(str3)) {
            str3 = str5;
        }
        sb.append(str3);
        sb.append(", loginKey: ");
        if (!TextUtils.isEmpty(d20.q())) {
            str5 = d20.q();
        }
        sb.append(str5);
        sb.append(", orderId: ");
        if (TextUtils.isEmpty(str4)) {
            str4 = "0";
        }
        sb.append(str4);
        sb.append("}");
        return sb.toString();
    }
}
