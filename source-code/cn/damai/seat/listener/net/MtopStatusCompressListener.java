package cn.damai.seat.listener.net;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.seat.bean.biz.CompressSeatStatus;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kf1;
import tb.oz0;
import tb.u62;

/* compiled from: Taobao */
public abstract class MtopStatusCompressListener extends DMMtopRequestListener<CompressSeatStatus> implements OnNetBizListener<CompressSeatStatus> {
    private static transient /* synthetic */ IpChange $ipChange;
    private long itemId;
    private kf1 mMonitor = new kf1(true);
    private long performId;

    public MtopStatusCompressListener(long j, long j2) {
        super(CompressSeatStatus.class);
        this.itemId = j;
        this.performId = j2;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "705687330")) {
            ipChange.ipc$dispatch("705687330", new Object[]{this, str, str2});
            return;
        }
        kf1.e("mtop.damai.wireless.seat.queryperformseatstatus", str, str2);
        onNetFail(str, str2);
        if (!oz0.b().c(str)) {
            if (str == null) {
                str = "unknown";
            }
            if (str2 == null) {
                str2 = "unknown";
            }
            u62.n("mtop.damai.wireless.seat.queryperformseatstatus", str, str2, this.itemId + "", this.performId + "");
        }
    }

    public void onSuccess(CompressSeatStatus compressSeatStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1546103809")) {
            ipChange.ipc$dispatch("1546103809", new Object[]{this, compressSeatStatus});
        } else if (compressSeatStatus == null) {
            onFail("", "麦麦开小差了，请稍后重试哦");
        } else {
            this.mMonitor.a("mtop.damai.wireless.seat.queryperformseatstatus");
            kf1.f("mtop.damai.wireless.seat.queryperformseatstatus");
            onNetSuccess(compressSeatStatus);
        }
    }
}
