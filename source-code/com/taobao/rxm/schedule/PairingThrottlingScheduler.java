package com.taobao.rxm.schedule;

import android.util.SparseArray;
import com.taobao.rxm.request.RequestCancelListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import tb.c02;
import tb.kg0;

/* compiled from: Taobao */
public class PairingThrottlingScheduler implements ThrottlingScheduler, ScheduledActionListener, RequestCancelListener<c02> {
    private final Scheduler a;
    private final Queue<ScheduledAction> b = new LinkedList();
    private final SparseArray<Long> c = new SparseArray<>();
    private final List<Integer> d = new ArrayList();
    private final long e;
    private int f;
    private int g;
    private int h;
    private long i;
    private DegradationListener j;

    /* compiled from: Taobao */
    public interface DegradationListener {
        void onDegrade2Unlimited();
    }

    public PairingThrottlingScheduler(Scheduler scheduler, int i2, int i3) {
        this.a = scheduler;
        this.g = i2;
        this.e = ((long) i3) * 1000000;
    }

    private void a() {
        ScheduledAction scheduledAction = ScheduledAction.sActionCallerThreadLocal.get();
        while (true) {
            ScheduledAction scheduledAction2 = null;
            synchronized (this) {
                b();
                if (this.h < this.g) {
                    scheduledAction2 = this.b.poll();
                }
                if (scheduledAction2 != null) {
                    d(scheduledAction2);
                }
            }
            if (scheduledAction2 != null) {
                scheduledAction2.unregisterCancelListener(this);
                this.a.schedule(scheduledAction2);
                ScheduledAction.sActionCallerThreadLocal.set(scheduledAction);
            } else {
                return;
            }
        }
    }

    private synchronized void b() {
        long nanoTime = System.nanoTime();
        if (nanoTime - this.i >= 30000000) {
            this.i = nanoTime;
            this.d.clear();
            int size = this.c.size();
            long nanoTime2 = System.nanoTime();
            for (int i2 = 0; i2 < size; i2++) {
                Long valueAt = this.c.valueAt(i2);
                if (valueAt != null && nanoTime2 - valueAt.longValue() >= this.e) {
                    this.d.add(Integer.valueOf(this.c.keyAt(i2)));
                }
            }
            int size2 = this.d.size();
            boolean z = false;
            for (int i3 = 0; i3 < size2; i3++) {
                int intValue = this.d.get(i3).intValue();
                kg0.f("RxSysLog", "[PairingThrottling] remove expired pair, id=%d", Integer.valueOf(intValue));
                z = g(intValue) || z;
            }
            int i4 = this.f;
            if (i4 < 3) {
                int i5 = i4 + size2;
                this.f = i5;
                if (i5 >= 3) {
                    this.g = Integer.MAX_VALUE;
                    kg0.i("RxSysLog", "[PairingThrottling] auto degrade to unlimited scheduler, expired total=%d", Integer.valueOf(i5));
                    DegradationListener degradationListener = this.j;
                    if (degradationListener != null) {
                        degradationListener.onDegrade2Unlimited();
                    }
                }
            }
            if (z) {
                a();
            }
        }
    }

    private synchronized void d(ScheduledAction scheduledAction) {
        int contextId = scheduledAction.getContextId();
        if (contextId <= 0) {
            this.h++;
        } else if (scheduledAction.isProduceAction() && this.c.get(contextId) == null) {
            this.c.put(contextId, Long.valueOf(System.nanoTime()));
            this.h++;
        }
    }

    private boolean e(ScheduledAction scheduledAction) {
        return scheduledAction.getContextId() > 0 && !scheduledAction.isProduceAction() && scheduledAction.isConsumeAction();
    }

    private boolean g(int i2) {
        synchronized (this) {
            if (i2 <= 0) {
                this.h--;
                return true;
            } else if (this.c.get(i2) == null) {
                return false;
            } else {
                this.c.remove(i2);
                this.h--;
                return true;
            }
        }
    }

    public void c(int i2) {
        if (g(i2)) {
            a();
        }
    }

    public void f(DegradationListener degradationListener) {
        this.j = degradationListener;
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public synchronized int getQueueSize() {
        return this.b.size();
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public synchronized String getStatus() {
        return this.a.getStatus();
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public synchronized boolean isScheduleMainThread() {
        return this.a.isScheduleMainThread();
    }

    @Override // com.taobao.rxm.schedule.ScheduledActionListener
    public void onActionFinished(ScheduledAction scheduledAction) {
        int contextId = scheduledAction.getContextId();
        if ((contextId <= 0 || scheduledAction.isConsumeAction()) && g(contextId)) {
            a();
        }
    }

    @Override // com.taobao.rxm.request.RequestCancelListener
    public void onCancel(c02 c02) {
        if (c02 != null) {
            int d2 = c02.d();
            ScheduledAction scheduledAction = null;
            synchronized (this) {
                Iterator<ScheduledAction> it = this.b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ScheduledAction next = it.next();
                    if (d2 == next.getContextId()) {
                        scheduledAction = next;
                        break;
                    }
                }
                if (scheduledAction != null) {
                    this.b.remove(scheduledAction);
                }
            }
            if (scheduledAction != null) {
                scheduledAction.cancelActing();
                scheduledAction.unregisterCancelListener(this);
                kg0.f("RxSysLog", "[PairingThrottling] ID=%d cancelled before scheduling the action in queue", Integer.valueOf(d2));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b  */
    @Override // com.taobao.rxm.schedule.Scheduler
    public void schedule(ScheduledAction scheduledAction) {
        boolean z;
        scheduledAction.setBranchActionListener(this);
        boolean e2 = e(scheduledAction);
        synchronized (this) {
            if (scheduledAction.isProduceAction()) {
                b();
            }
            if (!e2 && this.h >= this.g) {
                if (this.b.offer(scheduledAction)) {
                    z = false;
                    if (!z) {
                        d(scheduledAction);
                    } else {
                        scheduledAction.registerCancelListener(this);
                    }
                }
            }
            z = true;
            if (!z) {
            }
        }
        if (z) {
            this.a.schedule(scheduledAction);
        }
    }

    @Override // com.taobao.rxm.schedule.ThrottlingScheduler
    public synchronized void setMaxRunningCount(int i2) {
        boolean z;
        synchronized (this) {
            z = this.f < 3 && i2 != this.g;
            if (z) {
                this.g = i2;
            }
        }
        if (z) {
            a();
        }
    }
}
