package cn.damai.seat.presenter;

import cn.damai.common.app.base.a;
import cn.damai.seat.contract.BaseSeatModel;
import cn.damai.seat.contract.BaseSeatView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s72;

/* compiled from: Taobao */
public abstract class BaseSeatPresenter<V extends BaseSeatView, M extends BaseSeatModel> extends a<V, M> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.app.base.a
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "843535062")) {
            ipChange.ipc$dispatch("843535062", new Object[]{this});
            return;
        }
        s72.f("Presenter onDestroy");
        super.onDestroy();
        M m = this.mModel;
        if (m != null) {
            m.onDestroy();
        }
    }
}
