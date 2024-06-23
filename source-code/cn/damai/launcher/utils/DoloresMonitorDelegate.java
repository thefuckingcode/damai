package cn.damai.launcher.utils;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.ERROR;
import com.alibaba.pictures.dolores.monitor.IMtopMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.fb0;
import tb.s41;
import tb.vf2;
import tb.yz2;
import tb.zl2;

/* compiled from: Taobao */
public class DoloresMonitorDelegate implements IMtopMonitor {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<String> a;

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void commitRequestError(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "861299532")) {
            ipChange.ipc$dispatch("861299532", new Object[]{this, str, str2, str3, str4});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "commitRequestError";
        }
        yz2.c(str, "mtop", str4, TextUtils.isEmpty(str2) ? "-" : "DOLORES_REQUEST_ERROR", str3);
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopJsonEmpty(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1421921281")) {
            ipChange.ipc$dispatch("-1421921281", new Object[]{this, str, obj});
        } else if (vf2.b(this.a) == 0 || !this.a.contains(str)) {
            yz2.c(str, "mtop", s41.e(obj), "DOLORES_DATA_EMPTY", "data为空");
        }
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopJsonFailure(String str, String str2, Object obj, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-700601994")) {
            ipChange.ipc$dispatch("-700601994", new Object[]{this, str, str2, obj, str3});
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("┋");
        stringBuffer.append(s41.e(obj));
        stringBuffer.append("┋apiVersion=");
        stringBuffer.append(str2);
        stringBuffer.append("┋traceId=");
        stringBuffer.append(str3);
        stringBuffer.append("┋");
        yz2.c(str, "mtop", stringBuffer.toString(), "DOLORES_JSON_PARSE", "parse Json失败");
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopLoginCancel(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1793794031")) {
            ipChange.ipc$dispatch("1793794031", new Object[]{this, str, str2});
        }
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public <BizResponse> void mtopRequestAndResponse(String str, fb0<BizResponse> fb0, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-707209469")) {
            ipChange.ipc$dispatch("-707209469", new Object[]{this, str, fb0, str2});
        }
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopRequestTime(String str, String str2, zl2 zl2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1091459843")) {
            ipChange.ipc$dispatch("1091459843", new Object[]{this, str, str2, zl2});
        }
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopResponseError(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2064086189")) {
            ipChange.ipc$dispatch("-2064086189", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("┋");
        stringBuffer.append(s41.e(str5));
        stringBuffer.append("┋apiVersion=");
        stringBuffer.append(str2);
        stringBuffer.append("┋traceId=");
        stringBuffer.append(str6);
        stringBuffer.append("┋");
        yz2.c(str, "mtop", stringBuffer.toString(), str3, str4);
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopResponseFailure(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-138679023")) {
            ipChange.ipc$dispatch("-138679023", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("┋");
        stringBuffer.append(s41.e(str5));
        stringBuffer.append("┋apiVersion=");
        stringBuffer.append(str2);
        stringBuffer.append("┋traceId=");
        stringBuffer.append(str6);
        stringBuffer.append("┋");
        yz2.c(str, "mtop", stringBuffer.toString(), str3, str4);
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopResponseSuccess(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1978876134")) {
            ipChange.ipc$dispatch("-1978876134", new Object[]{this, str, str2, str3});
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("┋");
        stringBuffer.append("apiVersion=");
        stringBuffer.append(str2);
        stringBuffer.append("┋traceId=");
        stringBuffer.append(str3);
        stringBuffer.append("┋");
        yz2.f(str, "mtop", ERROR.MTOP_XFLUSH_SUCCESS_CODE, "-", stringBuffer.toString());
    }
}
