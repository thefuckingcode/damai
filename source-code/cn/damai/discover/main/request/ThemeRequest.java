package cn.damai.discover.main.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ThemeRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int order;
    public String pageNo;
    public String pageSize = "15";
    public String themeId;

    public ThemeRequest(String str, int i, int i2) {
        this.themeId = str;
        this.pageNo = i + "";
        this.order = i2;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-976988287")) {
            return "mtop.damai.wireless.discovery.theme.get";
        }
        return (String) ipChange.ipc$dispatch("-976988287", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1447637708")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1447637708", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "825325640")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("825325640", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1190748436")) {
            return "1.2";
        }
        return (String) ipChange.ipc$dispatch("1190748436", new Object[]{this});
    }
}
