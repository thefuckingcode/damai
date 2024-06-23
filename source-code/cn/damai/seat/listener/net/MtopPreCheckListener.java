package cn.damai.seat.listener.net;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.seat.bean.biz.PreCheckResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kf1;

/* compiled from: Taobao */
public abstract class MtopPreCheckListener extends DMMtopRequestListener<PreCheckResult> implements OnNetBizListener<PreCheckResult> {
    private static transient /* synthetic */ IpChange $ipChange;
    private kf1 mMonitor = new kf1(true);

    public MtopPreCheckListener() {
        super(PreCheckResult.class);
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "472948307")) {
            ipChange.ipc$dispatch("472948307", new Object[]{this, str, str2});
            return;
        }
        onNetFail(str, str2);
    }

    public void onSuccess(PreCheckResult preCheckResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1580343927")) {
            ipChange.ipc$dispatch("-1580343927", new Object[]{this, preCheckResult});
        } else if (preCheckResult == null) {
            onFail("", "麦麦开小差了，请稍后重试哦");
        } else {
            this.mMonitor.a("mtop.damai.wireless.seat.precheck");
            if (!preCheckResult.isCanOpenNextPage() || TextUtils.isEmpty(preCheckResult.serialNumber)) {
                kf1.d(kf1.TYPE_PRE_LOCK_RATE, null, null);
            } else {
                kf1.g(kf1.TYPE_PRE_LOCK_RATE);
            }
            onNetSuccess(preCheckResult);
        }
    }
}
