package cn.damai.seat.helper;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.seat.bean.biz.PreCheckResult;
import cn.damai.seat.listener.net.MtopPreCheckListener;
import cn.damai.seat.request.MtopPreCheckRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.List;
import tb.g72;

/* compiled from: Taobao */
public class SeatPreLocker {
    private static transient /* synthetic */ IpChange $ipChange;
    private long a;
    private long b;
    private String c;
    private List<Long> d;

    /* compiled from: Taobao */
    public interface OnPreLockResultListener {
        void onOpenNextPage(boolean z, String str, String str2);

        void onPreLockFailed();
    }

    public SeatPreLocker(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "902989305")) {
            ipChange.ipc$dispatch("902989305", new Object[]{this});
            return;
        }
        this.d = null;
    }

    public List<Long> d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-181389167")) {
            return this.d;
        }
        return (List) ipChange.ipc$dispatch("-181389167", new Object[]{this});
    }

    public String e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1415562236")) {
            return this.c;
        }
        return (String) ipChange.ipc$dispatch("1415562236", new Object[]{this});
    }

    public MtopBusiness f(List<SeatNew> list, final OnPreLockResultListener onPreLockResultListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "60070705")) {
            return (MtopBusiness) ipChange.ipc$dispatch("60070705", new Object[]{this, list, onPreLockResultListener});
        }
        return new MtopPreCheckRequest(this.a, this.b, g72.e(list), this.c).request(new MtopPreCheckListener() {
            /* class cn.damai.seat.helper.SeatPreLocker.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1978501724")) {
                    ipChange.ipc$dispatch("1978501724", new Object[]{this, str, str2});
                    return;
                }
                onPreLockResultListener.onOpenNextPage(false, str, str2);
            }

            public void onNetSuccess(@NonNull PreCheckResult preCheckResult) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-649994542")) {
                    ipChange.ipc$dispatch("-649994542", new Object[]{this, preCheckResult});
                    return;
                }
                SeatPreLocker.this.c = preCheckResult.serialNumber;
                SeatPreLocker.this.d = preCheckResult.greySeats;
                if (preCheckResult.isCanOpenNextPage()) {
                    onPreLockResultListener.onOpenNextPage(true, null, null);
                } else {
                    onPreLockResultListener.onPreLockFailed();
                }
            }
        });
    }
}
