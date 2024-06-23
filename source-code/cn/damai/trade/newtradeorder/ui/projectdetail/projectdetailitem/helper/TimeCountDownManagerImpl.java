package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper;

import android.os.CountDownTimer;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.xt1;

/* compiled from: Taobao */
public class TimeCountDownManagerImpl implements ITimeCountDownManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private b a;
    private long b;
    private OnTimeCountDownListener c;
    private OnTimeCountDownCallback d = new a();

    /* compiled from: Taobao */
    private interface OnTimeCountDownCallback {
        void onCountDownFinished();

        void onCountDownTip(long j);
    }

    /* compiled from: Taobao */
    public class a implements OnTimeCountDownCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.TimeCountDownManagerImpl.OnTimeCountDownCallback
        public void onCountDownFinished() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1435275481")) {
                ipChange.ipc$dispatch("1435275481", new Object[]{this});
            } else if (TimeCountDownManagerImpl.this.c != null) {
                TimeCountDownManagerImpl.this.c.onCountDownFinished(TimeCountDownManagerImpl.this.b);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.TimeCountDownManagerImpl.OnTimeCountDownCallback
        public void onCountDownTip(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-846257376")) {
                ipChange.ipc$dispatch("-846257376", new Object[]{this, Long.valueOf(j)});
            } else if (TimeCountDownManagerImpl.this.c != null) {
                String[] a2 = xt1.a(j);
                TimeCountDownManagerImpl.this.c.onCountDownTip(j, !TextUtils.isEmpty(a2[0]) ? a2[0] : "00", a2[1], a2[2], a2[3]);
            }
        }
    }

    /* compiled from: Taobao */
    public static class b extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;
        private long a;
        private OnTimeCountDownCallback b;

        public b(long j, long j2, OnTimeCountDownCallback onTimeCountDownCallback) {
            super(1000 * j, j2);
            this.a = j;
            this.b = onTimeCountDownCallback;
        }

        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "122760044")) {
                ipChange.ipc$dispatch("122760044", new Object[]{this});
                return;
            }
            OnTimeCountDownCallback onTimeCountDownCallback = this.b;
            if (onTimeCountDownCallback != null) {
                onTimeCountDownCallback.onCountDownFinished();
            }
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1920394850")) {
                ipChange.ipc$dispatch("1920394850", new Object[]{this, Long.valueOf(j)});
                return;
            }
            OnTimeCountDownCallback onTimeCountDownCallback = this.b;
            if (onTimeCountDownCallback != null) {
                onTimeCountDownCallback.onCountDownTip(this.a);
            }
            this.a--;
        }
    }

    private TimeCountDownManagerImpl(OnTimeCountDownListener onTimeCountDownListener) {
        this.c = onTimeCountDownListener;
    }

    public static TimeCountDownManagerImpl c(OnTimeCountDownListener onTimeCountDownListener) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1888735101")) {
            return new TimeCountDownManagerImpl(onTimeCountDownListener);
        }
        return (TimeCountDownManagerImpl) ipChange.ipc$dispatch("1888735101", new Object[]{onTimeCountDownListener});
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ITimeCountDownManager
    public void cancelCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431636339")) {
            ipChange.ipc$dispatch("1431636339", new Object[]{this});
            return;
        }
        b bVar = this.a;
        if (bVar != null) {
            bVar.cancel();
            this.a = null;
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ITimeCountDownManager
    public void setCountDown(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "252854803")) {
            ipChange.ipc$dispatch("252854803", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.b = j;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ITimeCountDownManager
    public void startCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1595723793")) {
            ipChange.ipc$dispatch("1595723793", new Object[]{this});
            return;
        }
        cancelCountDown();
        if (this.a == null) {
            this.a = new b(this.b, 1000, this.d);
        }
        this.a.start();
        if (this.c != null) {
            String[] a2 = xt1.a(this.b);
            this.c.onCountDownStart(!TextUtils.isEmpty(a2[0]) ? a2[0] : "00", a2[1], a2[2], a2[3]);
        }
    }
}
