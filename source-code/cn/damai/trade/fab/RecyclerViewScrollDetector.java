package cn.damai.trade.fab;

import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class RecyclerViewScrollDetector extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;

    RecyclerViewScrollDetector() {
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public abstract void b();

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1533813280")) {
            ipChange.ipc$dispatch("-1533813280", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (Math.abs(i2) <= this.a) {
            z = false;
        }
        if (!z) {
            return;
        }
        if (i2 > 0) {
            b();
        } else {
            a();
        }
    }
}
