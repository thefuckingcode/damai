package cn.damai.commonbusiness.seatbiz.sku.qilin.request;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SkuRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bizCode = "ali.china.damai";
    public SkuItem exParams = new SkuItem();
    public String itemId;
    public String scenario = "itemsku";

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-692005514")) {
            return (!AppConfig.v() || AppConfig.g() != AppConfig.EnvMode.prepare) ? "mtop.alibaba.detail.subpage.getdetail" : "mtop.alibaba.detail.subpage.getdetail.center";
        }
        return (String) ipChange.ipc$dispatch("-692005514", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1240389257")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1240389257", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1093242829")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1093242829", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1475731209")) {
            return (String) ipChange.ipc$dispatch("1475731209", new Object[]{this});
        }
        if (AppConfig.v()) {
            AppConfig.g();
            AppConfig.EnvMode envMode = AppConfig.EnvMode.prepare;
        }
        return "2.0";
    }
}
