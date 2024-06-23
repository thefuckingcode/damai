package tb;

import com.taobao.android.task.Coordinator;
import com.taobao.application.common.IAppPreferences;
import com.taobao.application.common.b;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;

/* compiled from: Taobao */
public class zh2 implements Scheduler {
    private final Coordinator.CoordThreadPoolExecutor a = ((Coordinator.CoordThreadPoolExecutor) Coordinator.getDefaultThreadPoolExecutor());

    private zh2() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0060 A[Catch:{ RuntimeException -> 0x00a9 }] */
    public static void a(boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4;
        if (z) {
            try {
                tp1.o().schedulerBuilder().b(new zh2());
                vr2.f("TBScheduler4Phenix", "enable unify thread pool", new Object[0]);
            } catch (RuntimeException e) {
                vr2.c("TBScheduler4Phenix", "init running scheduler error=%s", e);
                return;
            }
        }
        IAppPreferences d = b.d();
        int i5 = -1;
        int i6 = d != null ? d.getInt("oldDeviceScore", -1) : 0;
        if (i6 > 0) {
            if (i6 <= 40) {
                i = 4;
                i4 = 2;
                i3 = 3;
            } else if (i6 <= 60) {
                i = 5;
                i4 = 3;
                i3 = 4;
            } else {
                if (i6 <= 75) {
                    i = 6;
                    i4 = 3;
                    i3 = 5;
                } else {
                    if (i6 <= 90) {
                        i = 7;
                        i4 = 3;
                    } else if (z) {
                        i = 8;
                        i4 = 4;
                    }
                    i3 = 6;
                }
                i2 = 3;
                if (z2) {
                    i5 = f42.VALID_NETWORK_RUNNING_EXPIRED;
                }
                vr2.f("TBScheduler4Phenix", "setup max running=%d, decode=%d, fast network=%d, slow network=%d, network expired=%d, score=%d", Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(i6));
                tp1.o().schedulerBuilder().g(i).d(i4).e(i3).f(i2).h(i5);
            }
            i2 = 2;
            if (z2) {
            }
            vr2.f("TBScheduler4Phenix", "setup max running=%d, decode=%d, fast network=%d, slow network=%d, network expired=%d, score=%d", Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(i6));
            tp1.o().schedulerBuilder().g(i).d(i4).e(i3).f(i2).h(i5);
        }
        i = 6;
        i4 = 3;
        i3 = 5;
        i2 = 2;
        if (z2) {
        }
        vr2.f("TBScheduler4Phenix", "setup max running=%d, decode=%d, fast network=%d, slow network=%d, network expired=%d, score=%d", Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(i6));
        tp1.o().schedulerBuilder().g(i).d(i4).e(i3).f(i2).h(i5);
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public int getQueueSize() {
        return this.a.getQueue().size();
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public String getStatus() {
        return "TBScheduler4Phenix[queue=" + getQueueSize() + ",active=" + this.a.getActiveCount() + ",pool=" + this.a.getPoolSize() + ",largest=" + this.a.getLargestPoolSize() + ",tasks=" + this.a.getTaskCount() + ",completes=" + this.a.getCompletedTaskCount() + jl1.ARRAY_END_STR;
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public boolean isScheduleMainThread() {
        return false;
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public void schedule(ScheduledAction scheduledAction) {
        this.a.execute(scheduledAction, 27);
    }
}
