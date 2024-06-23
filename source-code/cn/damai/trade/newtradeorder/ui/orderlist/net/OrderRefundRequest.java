package cn.damai.trade.newtradeorder.ui.orderlist.net;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.util.ReflectUtil;
import tb.d20;
import tb.g70;
import tb.n6;
import tb.xs0;
import tb.zm1;

/* compiled from: Taobao */
public class OrderRefundRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String apiVersion = (AppConfig.r() + "");
    public String appClientKey = zm1.b("appClientKey");
    public String appType = "1";
    public String channelFrom = n6.a(xs0.a());
    public String clientGUID = (g70.a(xs0.a()) + "1");
    public String id;
    public String loginKey = d20.q();
    public String osType = "2";
    public String phoneModels = g70.b();
    public String sign;
    public String source = "10101";
    public String systemVersion = g70.e();
    public String timestamp = ((System.currentTimeMillis() / 1000) + "");

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2065720148")) {
            return "mtop.damai.wireless.order.zlorderrefundprogress";
        }
        return (String) ipChange.ipc$dispatch("-2065720148", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "936195118")) {
            return DMBaseMtopRequest.HttpMethod.GET;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("936195118", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1652581119")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1652581119", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2072630979")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-2072630979", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "102016575")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("102016575", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public void setRequestData(MtopBusiness mtopBusiness) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "760744906")) {
            ipChange.ipc$dispatch("760744906", new Object[]{this, mtopBusiness});
        } else if (mtopBusiness != null) {
            MtopRequest mtopRequest = mtopBusiness.request;
            mtopRequest.setData(ReflectUtil.converMapToDataStr(mtopRequest.dataParams));
        }
    }
}
