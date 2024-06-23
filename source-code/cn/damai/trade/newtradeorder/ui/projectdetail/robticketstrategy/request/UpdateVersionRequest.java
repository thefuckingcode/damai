package cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class UpdateVersionRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String API_NAME = "mtop.client.mudp.update";
    public String VERSION = "1.0";
    public long apiLevel = 0;
    public String appVersion = null;
    public String brand = null;
    public String city = null;
    public String dexcode;
    public long dexpatchVersion = 0;
    public String identifier = null;
    public boolean isYunos;
    public String locale = null;
    public String md5Sum = null;
    public String model = null;
    public long patchVersion = 0;
    public List<String> updateTypes;

    public UpdateVersionRequest(boolean z) {
        if (z) {
            this.API_NAME = "mtop.client.mudp.update.outer";
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-218960774")) {
            return this.API_NAME;
        }
        return (String) ipChange.ipc$dispatch("-218960774", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "578579187")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("578579187", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1116257617")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1116257617", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1948775949")) {
            return this.VERSION;
        }
        return (String) ipChange.ipc$dispatch("1948775949", new Object[]{this});
    }
}
