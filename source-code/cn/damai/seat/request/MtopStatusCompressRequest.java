package cn.damai.seat.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.seat.bean.biz.CompressSeatStatus;
import cn.damai.seat.listener.net.MtopStatusCompressListener;
import cn.damai.tool2.bufferkit.BufferListener;
import cn.damai.tool2.bufferkit.BufferRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import tb.bd;
import tb.lk1;

/* compiled from: Taobao */
public class MtopStatusCompressRequest extends DMBaseMtopRequest implements BufferRequest<CompressSeatStatus> {
    private static transient /* synthetic */ IpChange $ipChange;
    public String areaInfoVersion;
    public String dmChannel = "*@damai_android_*";
    private long itemId;
    private MtopBusiness mRequest;
    public String performanceId;
    public String projectId;
    @Nullable
    public String serialNumber;
    @Nullable
    public String standIds;

    public MtopStatusCompressRequest(long j, long j2, long j3, int i, @Nullable String str, @Nullable String str2) {
        this.projectId = j2 + "";
        this.performanceId = j3 + "";
        this.areaInfoVersion = i + "";
        this.standIds = str;
        this.serialNumber = str2;
        this.itemId = j;
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494950151")) {
            ipChange.ipc$dispatch("1494950151", new Object[]{this});
            return;
        }
        MtopBusiness mtopBusiness = this.mRequest;
        if (mtopBusiness != null && !mtopBusiness.isTaskCanceled()) {
            this.mRequest.cancelRequest();
        }
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public void doRequest(final BufferListener<CompressSeatStatus> bufferListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-751494497")) {
            ipChange.ipc$dispatch("-751494497", new Object[]{this, bufferListener});
            return;
        }
        this.mRequest = request(new MtopStatusCompressListener(this.itemId, lk1.k(this.performanceId, -1)) {
            /* class cn.damai.seat.request.MtopStatusCompressRequest.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-719909996")) {
                    ipChange.ipc$dispatch("-719909996", new Object[]{this, str, str2});
                    return;
                }
                bufferListener.onFail(str, str2);
            }

            public void onNetSuccess(@NonNull CompressSeatStatus compressSeatStatus) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2077450739")) {
                    ipChange.ipc$dispatch("2077450739", new Object[]{this, compressSeatStatus});
                    return;
                }
                bufferListener.onSuccess(compressSeatStatus);
            }
        });
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1033233678")) {
            return "mtop.damai.wireless.seat.queryperformseatstatus";
        }
        return (String) ipChange.ipc$dispatch("1033233678", new Object[]{this});
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public String getGroupType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "572105250")) {
            return bd.BUFFER_GROUP_1;
        }
        return (String) ipChange.ipc$dispatch("572105250", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1096688417")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1096688417", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-435689061")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-435689061", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public String getUniKey() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25347108")) {
            return (String) ipChange.ipc$dispatch("-25347108", new Object[]{this});
        }
        return getApiName() + getVersion() + this.projectId + this.performanceId + this.areaInfoVersion + this.standIds + this.serialNumber;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1093996895")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1093996895", new Object[]{this});
    }
}
