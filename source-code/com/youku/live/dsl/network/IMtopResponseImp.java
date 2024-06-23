package com.youku.live.dsl.network;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
public class IMtopResponseImp implements IMtopResponseAttacher, IResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    private volatile MtopResponse mtopResponse;
    private volatile String source;

    public IMtopResponseImp(MtopResponse mtopResponse2) {
        this.mtopResponse = mtopResponse2;
    }

    @Override // com.youku.live.dsl.network.IMtopResponseAttacher
    public void attachResponse(MtopResponse mtopResponse2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-200968776")) {
            ipChange.ipc$dispatch("-200968776", new Object[]{this, mtopResponse2});
            return;
        }
        this.mtopResponse = mtopResponse2;
    }

    @Override // com.youku.live.dsl.network.IResponse
    public byte[] getRawData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1851880864")) {
            return (byte[]) ipChange.ipc$dispatch("1851880864", new Object[]{this});
        } else if (this.mtopResponse != null) {
            return this.mtopResponse.getBytedata();
        } else {
            return null;
        }
    }

    @Override // com.youku.live.dsl.network.IResponse
    public String getRetCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1758926945")) {
            return this.mtopResponse != null ? this.mtopResponse.getRetCode() : "";
        }
        return (String) ipChange.ipc$dispatch("-1758926945", new Object[]{this});
    }

    @Override // com.youku.live.dsl.network.IResponse
    public String getRetMessage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "764623499")) {
            return this.mtopResponse != null ? this.mtopResponse.getRetMsg() : "";
        }
        return (String) ipChange.ipc$dispatch("764623499", new Object[]{this});
    }

    @Override // com.youku.live.dsl.network.IResponse
    public String getSource() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1341334784")) {
            return (String) ipChange.ipc$dispatch("-1341334784", new Object[]{this});
        }
        if (this.source == null) {
            try {
                this.source = new String(getRawData());
            } catch (Throwable unused) {
            }
        }
        if (this.source == null) {
            this.source = "";
        }
        return this.source;
    }

    @Override // com.youku.live.dsl.network.IResponse
    public boolean isRequestSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1396767263")) {
            return this.mtopResponse != null && !this.mtopResponse.isMtopSdkError() && !this.mtopResponse.isMtopServerError();
        }
        return ((Boolean) ipChange.ipc$dispatch("1396767263", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.dsl.network.IResponse
    public boolean isResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "716645725")) {
            return ((Boolean) ipChange.ipc$dispatch("716645725", new Object[]{this})).booleanValue();
        } else if (this.mtopResponse != null) {
            return this.mtopResponse.isApiSuccess();
        } else {
            return false;
        }
    }

    public IMtopResponseImp() {
    }
}
