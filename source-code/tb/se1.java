package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.compat.mtop.MtopCertificateException;
import com.taobao.phenix.compat.mtop.MtopConnectTimeoutException;
import com.taobao.phenix.compat.mtop.MtopIndifferentException;
import com.taobao.phenix.compat.mtop.MtopInvalidHostException;
import com.taobao.phenix.compat.mtop.MtopInvalidUrlException;
import com.taobao.phenix.compat.mtop.MtopReadTimeoutException;
import com.taobao.phenix.compat.stat.NetworkAnalyzer;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class se1 implements NetworkAnalyzer {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isCertificateException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1392185522")) {
            return th instanceof MtopCertificateException;
        }
        return ((Boolean) ipChange.ipc$dispatch("1392185522", new Object[]{this, th})).booleanValue();
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isConnectTimeoutException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1734236090")) {
            return th instanceof MtopConnectTimeoutException;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1734236090", new Object[]{this, th})).booleanValue();
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isIndifferentException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "442346805")) {
            return th instanceof MtopIndifferentException;
        }
        return ((Boolean) ipChange.ipc$dispatch("442346805", new Object[]{this, th})).booleanValue();
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isInvalidHostException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1844887798")) {
            return th instanceof MtopInvalidHostException;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1844887798", new Object[]{this, th})).booleanValue();
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isInvalidUrlException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "236919429")) {
            return th instanceof MtopInvalidUrlException;
        }
        return ((Boolean) ipChange.ipc$dispatch("236919429", new Object[]{this, th})).booleanValue();
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isNoNetworkException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "728248668")) {
            return (th instanceof MtopIndifferentException) && ((MtopIndifferentException) th).getExtraCode() == -200;
        }
        return ((Boolean) ipChange.ipc$dispatch("728248668", new Object[]{this, th})).booleanValue();
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isReadTimeoutException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1335061026")) {
            return th instanceof MtopReadTimeoutException;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1335061026", new Object[]{this, th})).booleanValue();
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfCdnIpPort() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1008795274")) {
            return rf1.MTOP_EXTRA_CDN_IP_PORT;
        }
        return (String) ipChange.ipc$dispatch("-1008795274", new Object[]{this});
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfConnectType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-729945883")) {
            return rf1.MTOP_EXTRA_CONNECT_TYPE;
        }
        return (String) ipChange.ipc$dispatch("-729945883", new Object[]{this});
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfFirstData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1987647131")) {
            return rf1.MTOP_EXTRA_FIRST_DATA;
        }
        return (String) ipChange.ipc$dispatch("1987647131", new Object[]{this});
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfHitCdnCache() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2094338135")) {
            return rf1.MTOP_EXTRA_HIT_CDN_CACHE;
        }
        return (String) ipChange.ipc$dispatch("-2094338135", new Object[]{this});
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfResponseCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1275420035")) {
            return rf1.MTOP_EXTRA_RESPONSE_CODE;
        }
        return (String) ipChange.ipc$dispatch("1275420035", new Object[]{this});
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfSendBefore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "418935004")) {
            return rf1.MTOP_EXTRA_SEND_BEFORE;
        }
        return (String) ipChange.ipc$dispatch("418935004", new Object[]{this});
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfServerRt() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1358772250")) {
            return rf1.MTOP_EXTRA_SERVER_RT;
        }
        return (String) ipChange.ipc$dispatch("1358772250", new Object[]{this});
    }
}
