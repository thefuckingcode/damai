package cn.damai.seat.request;

import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MtopPreCheckRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String dmChannel = "*@damai_android_*";
    public String performanceId;
    public String projectId;
    public String serialNumber;
    public String standSeats;

    public MtopPreCheckRequest(long j, long j2, String str, @Nullable String str2) {
        this.projectId = j + "";
        this.performanceId = j2 + "";
        this.standSeats = str;
        this.serialNumber = str2;
        useWua();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-277800705")) {
            return "mtop.damai.wireless.seat.precheck";
        }
        return (String) ipChange.ipc$dispatch("-277800705", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "540455803")) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("540455803", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1896703246")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1896703246", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1414389238")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1414389238", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1889936018")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1889936018", new Object[]{this});
    }
}
