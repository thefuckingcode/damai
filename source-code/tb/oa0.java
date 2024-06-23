package tb;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.net.mtop.netfit.ERROR;
import cn.damai.commonbusiness.address.api.AddressApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.ErrorConstant;

/* compiled from: Taobao */
public class oa0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static oa0 b;
    private List<String> a = new ArrayList();

    private oa0() {
        h();
    }

    private String e(Context context, String str, String str2, String str3, String str4) {
        String str5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "61658720")) {
            return (String) ipChange.ipc$dispatch("61658720", new Object[]{this, context, str, str2, str3, str4});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("dmUltron:jsonData={");
        String str6 = ",";
        if (!TextUtils.isEmpty(str)) {
            sb.append("apiName:" + str);
            str5 = str6;
        } else {
            str5 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str5);
            sb.append(da.ERROR_CODE + str2);
            str5 = str6;
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str5);
            sb.append(da.ERROR_MSG + str3);
        } else {
            str6 = str5;
        }
        if (w90.b(context) > 0) {
            sb.append(str6);
            sb.append("itemId:");
            sb.append(w90.b(context));
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str6);
            sb.append(str4);
        }
        sb.append("}");
        return sb.toString();
    }

    public static synchronized oa0 f() {
        synchronized (oa0.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "266083385")) {
                return (oa0) ipChange.ipc$dispatch("266083385", new Object[0]);
            }
            if (b == null) {
                b = new oa0();
            }
            return b;
        }
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-951803084")) {
            ipChange.ipc$dispatch("-951803084", new Object[]{this});
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.clear();
        this.a.add("ANDROID_SYS_NETWORK_ERROR");
        this.a.add("ANDROID_SYS_NO_NETWORK");
        this.a.add("FAIL_SYS_SYSTEM_BUSY_ERROR");
        this.a.add(oz0.FAIL_SYS_TRAFFIC_LIMIT);
        this.a.add(ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_CANCEL);
        this.a.add("ANDROID_SYS_API_FLOW_LIMIT_LOCKED");
        this.a.add(ErrorConstant.ERRCODE_JSONDATA_BLANK);
        this.a.add(ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK);
        this.a.add("FCADE0002");
        this.a.add("F-10012-01-16-001");
        this.a.add("F-10012-01-16-003");
        this.a.add("F-10001-03-16-113");
        this.a.add("F-10007-10-10-025");
        this.a.add("CUSTOM_REASON_CANNOT_BUY_C");
        this.a.add("CUSTOM_REASON_CANNOT_BUY");
        this.a.add("MAX_BUY_QUANTITY_EXCEEDED");
    }

    public static void i(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63798394")) {
            ipChange.ipc$dispatch("-63798394", new Object[]{mtopResponse});
        } else if (mtopResponse != null) {
            try {
                yz2.c(mtopResponse.getApi(), "mtop", s41.e(mtopResponse), mtopResponse.getRetCode(), mtopResponse.getRetMsg());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void j(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "5843373")) {
            ipChange.ipc$dispatch("5843373", new Object[]{mtopResponse});
        } else if (mtopResponse != null) {
            try {
                yz2.f(mtopResponse.getApi(), "mtop", ERROR.MTOP_XFLUSH_SUCCESS_CODE, "-", Util.getTraceId(mtopResponse));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179157525")) {
            ipChange.ipc$dispatch("-1179157525", new Object[]{this, context, str, str2});
            return;
        }
        try {
            yz2.a(e(context, AddressApi.API_GET_ADDRESS_LIST, str, str2, null), "-4320", "候鸟项目获取地址列表接口失败");
        } catch (Exception unused) {
        }
    }

    public void b(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "831744476")) {
            ipChange.ipc$dispatch("831744476", new Object[]{this, context, str, str2, str3});
            return;
        }
        try {
            yz2.g(e(context, str, str2, str3, "fromWhere:新奥创下单刷新接口失败"), "-4310", "下单接口失败");
        } catch (Exception unused) {
        }
    }

    public void c(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329866695")) {
            ipChange.ipc$dispatch("-1329866695", new Object[]{this, context, str, str2, str3});
            return;
        }
        try {
            yz2.g(e(context, str, str2, str3, "fromWhere:新奥创下单渲染接口失败"), "-4310", "下单接口失败");
        } catch (Exception unused) {
        }
    }

    public void d(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653156913")) {
            ipChange.ipc$dispatch("-653156913", new Object[]{this, context, str, str2, str3});
            return;
        }
        try {
            yz2.g(e(context, str, str2, str3, "fromWhere:新奥创提交订单接口失败"), "-4330", "提交订单接口失败");
        } catch (Exception unused) {
        }
    }

    public boolean g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1505803302")) {
            return ((Boolean) ipChange.ipc$dispatch("-1505803302", new Object[]{this, str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            if (str.startsWith("B-00203")) {
                return true;
            }
            if (this.a == null) {
                h();
            }
            return this.a.contains(str);
        }
    }

    public void k(Context context, String str, String str2, String str3) {
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975724901")) {
            ipChange.ipc$dispatch("1975724901", new Object[]{this, context, str, str2, str3});
            return;
        }
        if ("mtop.trade.order.build".equals(str)) {
            str4 = "新奥创下单渲染接口失败";
        } else {
            str4 = "mtop.trade.order.adjust".equals(str) ? "新奥创下单刷新接口失败" : "新奥创提交订单接口失败";
        }
        HashMap hashMap = new HashMap();
        if (context != null && w90.b(context) > 0) {
            hashMap.put("itemId", w90.b(context) + "");
        }
        hashMap.put("fromWhere", str4);
        dr.INSTANCE.a().a(str).c(str2).d(str3).e(hashMap).g("订单确认页面").j("confirm").f(false).b();
    }

    public void l(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1756348964")) {
            ipChange.ipc$dispatch("1756348964", new Object[]{this, context, str, str2});
            return;
        }
        try {
            yz2.g(e(context, null, str, str2, "fromWhere:新奥创绑定优酷账号失败"), "-1700", "优酷账号绑定失败");
        } catch (Exception unused) {
        }
    }
}
