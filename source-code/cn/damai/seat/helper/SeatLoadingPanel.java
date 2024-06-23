package cn.damai.seat.helper;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewStub;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SeatLoadingPanel {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewStub a;
    private View b;
    private Handler c = new Handler(Looper.getMainLooper());

    public SeatLoadingPanel(ViewStub viewStub) {
        this.a = viewStub;
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-336725116")) {
            ipChange.ipc$dispatch("-336725116", new Object[]{this});
        } else if (this.b == null) {
            this.b = this.a.inflate();
        }
    }

    private void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857364127")) {
            ipChange.ipc$dispatch("857364127", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.b;
        if (view != null) {
            if (z) {
                view.setVisibility(4);
                this.c.postDelayed(new Runnable() {
                    /* class cn.damai.seat.helper.SeatLoadingPanel.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-540890634")) {
                            ipChange.ipc$dispatch("-540890634", new Object[]{this});
                            return;
                        }
                        SeatLoadingPanel.this.b.setVisibility(0);
                    }
                }, 300);
                return;
            }
            this.c.removeCallbacksAndMessages(null);
            this.b.setVisibility(8);
        }
    }

    public void d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "99674218")) {
            ipChange.ipc$dispatch("99674218", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            b();
        }
        c(z);
    }
}
