package com.youku.live.dsl.network;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class INetResponseImp implements INetResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean mIsSuccess;
    private byte[] mRawData;
    private String mRetCode;
    private String mRetMessage;
    private String mSource;

    @Override // com.youku.live.dsl.network.INetResponse
    public byte[] getRawData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1424239919")) {
            return this.mRawData;
        }
        return (byte[]) ipChange.ipc$dispatch("1424239919", new Object[]{this});
    }

    @Override // com.youku.live.dsl.network.INetResponse
    public String getRetCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1237278418")) {
            return this.mRetCode;
        }
        return (String) ipChange.ipc$dispatch("-1237278418", new Object[]{this});
    }

    @Override // com.youku.live.dsl.network.INetResponse
    public String getRetMessage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2004214428")) {
            return this.mRetMessage;
        }
        return (String) ipChange.ipc$dispatch("2004214428", new Object[]{this});
    }

    @Override // com.youku.live.dsl.network.INetResponse
    public String getSource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-77581423")) {
            return this.mSource;
        }
        return (String) ipChange.ipc$dispatch("-77581423", new Object[]{this});
    }

    @Override // com.youku.live.dsl.network.INetResponse
    public boolean isSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-559011957")) {
            return this.mIsSuccess;
        }
        return ((Boolean) ipChange.ipc$dispatch("-559011957", new Object[]{this})).booleanValue();
    }

    public INetResponseImp setRawData(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "286665007")) {
            return (INetResponseImp) ipChange.ipc$dispatch("286665007", new Object[]{this, bArr});
        }
        this.mRawData = bArr;
        return this;
    }

    public INetResponseImp setRetCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1960034680")) {
            return (INetResponseImp) ipChange.ipc$dispatch("-1960034680", new Object[]{this, str});
        }
        this.mRetCode = str;
        return this;
    }

    public INetResponseImp setRetMessage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "532272014")) {
            return (INetResponseImp) ipChange.ipc$dispatch("532272014", new Object[]{this, str});
        }
        this.mRetMessage = str;
        return this;
    }

    public INetResponseImp setSource(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1881616131")) {
            return (INetResponseImp) ipChange.ipc$dispatch("1881616131", new Object[]{this, str});
        }
        this.mSource = str;
        return this;
    }

    public INetResponseImp setSuccess(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1138867845")) {
            return (INetResponseImp) ipChange.ipc$dispatch("1138867845", new Object[]{this, Boolean.valueOf(z)});
        }
        this.mIsSuccess = z;
        return this;
    }
}
