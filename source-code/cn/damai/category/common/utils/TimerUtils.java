package cn.damai.category.common.utils;

import android.os.Handler;
import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class TimerUtils implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -8016485049514819227L;
    public long diffTime = 0;
    private RecyclerView.Adapter mAdapter;
    private Handler mHandler;
    private Runnable mRunnable = new Runnable() {
        /* class cn.damai.category.common.utils.TimerUtils.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1517528899")) {
                ipChange.ipc$dispatch("-1517528899", new Object[]{this});
            } else if (TimerUtils.this.mHandler != null && TimerUtils.this.mAdapter != null) {
                TimerUtils.this.mHandler.postDelayed(this, 1000);
                TimerUtils timerUtils = TimerUtils.this;
                timerUtils.second++;
                timerUtils.mAdapter.notifyDataSetChanged();
            }
        }
    };
    public int second = 0;
    public long serverTime = 0;

    public void setServiceTimeAndDiff(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2020293195")) {
            ipChange.ipc$dispatch("2020293195", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.serverTime = j;
        this.diffTime = j - SystemClock.elapsedRealtime();
    }

    public void startTimer(RecyclerView.Adapter adapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849829850")) {
            ipChange.ipc$dispatch("849829850", new Object[]{this, adapter});
        } else if (adapter != null) {
            stopTimer();
            if (this.mHandler == null) {
                this.mAdapter = adapter;
                Handler handler = new Handler();
                this.mHandler = handler;
                handler.postDelayed(this.mRunnable, 0);
            }
        }
    }

    public void stopTimer() {
        Runnable runnable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1343647442")) {
            ipChange.ipc$dispatch("1343647442", new Object[]{this});
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null && (runnable = this.mRunnable) != null) {
            handler.removeCallbacks(runnable);
            this.mHandler = null;
            this.second = 0;
        }
    }
}
