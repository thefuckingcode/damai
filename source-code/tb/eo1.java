package tb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.ticklet.bean.UserTicketTable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class eo1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-464009156")) {
            ipChange.ipc$dispatch("-464009156", new Object[]{context, str, str2, str3});
        } else if (context == null) {
        } else {
            if (!TextUtils.isEmpty(str)) {
                Bundle bundle = new Bundle();
                bundle.putString("backPage", "ticklet_detail");
                bundle.putString("orderId", str);
                bundle.putString("projectId", str3);
                if ("1".equals(str2)) {
                    DMNav.from(context).withExtras(bundle).toUri(NavUri.b("my_orderdetails"));
                } else if (UserTicketTable.COUPON_TICKET.equals(str2)) {
                    DMNav withExtras = DMNav.from(context).withExtras(bundle);
                    withExtras.toUri("damai://V1/CouponOrderDetail?orderId=" + str);
                } else {
                    DMNav.from(context).withExtras(bundle).toUri(NavUri.b("my_hn_orderdetails"));
                }
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putString("backPage", "ticklet_detail");
                if (UserTicketTable.COUPON_TICKET.equals(str2)) {
                    bundle2.putString("pageType", "jubensha");
                }
                DMNav.from(context).withExtras(bundle2).toUri(NavUri.b("my_showorder"));
            }
        }
    }
}
