package cn.damai.trade.coupon.ui.orderdeatile;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class OrderDetailRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String dmChannel;
    @Nullable
    private String orderId;
    @Nullable
    private String sVersion;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    @NotNull
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-87798861")) {
            return "mtop.damai.wireless.secondaryorde.orderdetail";
        }
        return (String) ipChange.ipc$dispatch("-87798861", new Object[]{this});
    }

    @Nullable
    public final String getDmChannel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1693328104")) {
            return this.dmChannel;
        }
        return (String) ipChange.ipc$dispatch("1693328104", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-90595110")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-90595110", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "52337366")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("52337366", new Object[]{this})).booleanValue();
    }

    @Nullable
    public final String getOrderId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "637283063")) {
            return this.orderId;
        }
        return (String) ipChange.ipc$dispatch("637283063", new Object[]{this});
    }

    @Nullable
    public final String getSVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1314530323")) {
            return this.sVersion;
        }
        return (String) ipChange.ipc$dispatch("-1314530323", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    @NotNull
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2079937862")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("2079937862", new Object[]{this});
    }

    public final void setDmChannel(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1011641202")) {
            ipChange.ipc$dispatch("-1011641202", new Object[]{this, str});
            return;
        }
        this.dmChannel = str;
    }

    public final void setOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "959652191")) {
            ipChange.ipc$dispatch("959652191", new Object[]{this, str});
            return;
        }
        this.orderId = str;
    }

    public final void setSVersion(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1978062191")) {
            ipChange.ipc$dispatch("-1978062191", new Object[]{this, str});
            return;
        }
        this.sVersion = str;
    }
}
