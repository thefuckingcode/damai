package com.youku.live.dago.widgetlib.interactive.gift.star.timer;

import android.os.SystemClock;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
public class SYTimer {
    private static transient /* synthetic */ IpChange $ipChange;
    private static SYTimer instance;
    private ComparatorTask comparatorTask = new ComparatorTask();
    private boolean isWaked;
    private ExecutorService pool = Executors.newFixedThreadPool(10);
    private Runnable r = new Runnable() {
        /* class com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimer.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1349238580")) {
                ipChange.ipc$dispatch("1349238580", new Object[]{this});
                return;
            }
            while (!SYTimer.this.thread.isInterrupted()) {
                if (SYTimer.this.tasks.isEmpty()) {
                    try {
                        SYTimer.this.status = STATUS.WAITING;
                        synchronized (SYTimer.class) {
                            SYTimer.class.wait();
                        }
                    } catch (InterruptedException unused) {
                        SYTimer.this.status = STATUS.STOP;
                        SYTimer.this.thread.interrupt();
                        return;
                    }
                } else {
                    try {
                        synchronized (SYTimer.class) {
                            SYTimerTask sYTimerTask = null;
                            if (SYTimer.this.tasks.size() > 0) {
                                sYTimerTask = (SYTimerTask) SYTimer.this.tasks.get(0);
                            }
                            if (sYTimerTask != null) {
                                long surplus = sYTimerTask.getSurplus();
                                if (surplus > 0) {
                                    SYTimer.this.isWaked = false;
                                    SYTimer.class.wait(surplus);
                                    if (SYTimer.this.isWaked) {
                                    }
                                }
                                SYTimer.this.pool.execute(sYTimerTask);
                                if (SYTimer.this.tasks.contains(sYTimerTask)) {
                                    SYTimer.this.tasks.remove(sYTimerTask);
                                }
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        SYTimer.this.status = STATUS.STOP;
                        SYTimer.this.thread.interrupt();
                        return;
                    }
                }
                SYTimer.this.status = STATUS.RUNNING;
            }
        }
    };
    private STATUS status = STATUS.IDLE;
    private List<SYTimerTask> tasks = new ArrayList();
    private Thread thread;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class ComparatorTask implements Comparator<SYTimerTask> {
        private ComparatorTask() {
        }

        public boolean equals(Object obj) {
            return false;
        }

        public int compare(SYTimerTask sYTimerTask, SYTimerTask sYTimerTask2) {
            return (int) (sYTimerTask.getSurplus() - sYTimerTask2.getSurplus());
        }
    }

    /* compiled from: Taobao */
    public enum STATUS {
        IDLE,
        RUNNING,
        WAITING,
        STOP
    }

    private SYTimer() {
        Thread thread2 = new Thread(this.r);
        this.thread = thread2;
        thread2.setName("SYTimer");
        this.thread.start();
    }

    private void checkThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197289766")) {
            ipChange.ipc$dispatch("-197289766", new Object[]{this});
        } else if (this.status == STATUS.STOP) {
            Thread thread2 = new Thread(this.r);
            this.thread = thread2;
            thread2.start();
        }
    }

    public static SYTimer getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1268702671")) {
            return (SYTimer) ipChange.ipc$dispatch("-1268702671", new Object[0]);
        }
        if (instance == null) {
            synchronized (SYTimer.class) {
                if (instance == null) {
                    instance = new SYTimer();
                }
            }
        }
        return instance;
    }

    private SYTimerTask getTaskByName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1699889636")) {
            return (SYTimerTask) ipChange.ipc$dispatch("1699889636", new Object[]{this, str});
        }
        for (SYTimerTask sYTimerTask : this.tasks) {
            if (sYTimerTask.getName().equals(str)) {
                return sYTimerTask;
            }
        }
        return null;
    }

    private void updateTask(SYTimerTask sYTimerTask, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-77775399")) {
            ipChange.ipc$dispatch("-77775399", new Object[]{this, sYTimerTask, Long.valueOf(j)});
            return;
        }
        synchronized (SYTimer.class) {
            sYTimerTask.setOffsetTimeMillis(j);
            Log.d("updateTask", "now = " + SystemClock.elapsedRealtime() + "update time to " + sYTimerTask.getWhen());
            this.isWaked = true;
            SYTimer.class.notifyAll();
        }
    }

    public void addNotify(final SYTimerListener sYTimerListener, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271146490")) {
            ipChange.ipc$dispatch("1271146490", new Object[]{this, sYTimerListener, Long.valueOf(j)});
            return;
        }
        SYTimerTask taskByName = getTaskByName(String.valueOf(sYTimerListener.getClass().hashCode()));
        if (taskByName == null) {
            addTask(new SYTimerTask(j, String.valueOf(sYTimerListener.getClass().hashCode())) {
                /* class com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimer.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerTask
                public void onTimeOver() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1554532300")) {
                        ipChange.ipc$dispatch("1554532300", new Object[]{this});
                        return;
                    }
                    synchronized (SYTimer.class) {
                        SYTimer.this.isWaked = true;
                        SYTimer.class.notifyAll();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerTask
                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1152725075")) {
                        ipChange.ipc$dispatch("1152725075", new Object[]{this});
                        return;
                    }
                    sYTimerListener.onNotify();
                }
            });
        } else {
            updateTask(taskByName, j);
        }
    }

    public void addTask(SYTimerTask sYTimerTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1084655019")) {
            ipChange.ipc$dispatch("-1084655019", new Object[]{this, sYTimerTask});
            return;
        }
        synchronized (SYTimer.class) {
            checkThread();
            this.tasks.add(sYTimerTask);
            Log.d("addTask", "now = " + SystemClock.elapsedRealtime() + "addTask time to " + sYTimerTask.getWhen());
            Collections.sort(this.tasks, this.comparatorTask);
            this.isWaked = true;
            SYTimer.class.notifyAll();
        }
    }

    public void cancelNotify(SYTimerListener sYTimerListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069443249")) {
            ipChange.ipc$dispatch("2069443249", new Object[]{this, sYTimerListener});
            return;
        }
        cancelTask(String.valueOf(sYTimerListener.hashCode()));
    }

    public void cancelTask(SYTimerTask sYTimerTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-879155652")) {
            ipChange.ipc$dispatch("-879155652", new Object[]{this, sYTimerTask});
        } else if (sYTimerTask != null) {
            sYTimerTask.cancel();
            synchronized (SYTimer.class) {
                if (this.tasks.contains(sYTimerTask)) {
                    this.tasks.remove(sYTimerTask);
                    this.isWaked = true;
                    SYTimer.class.notifyAll();
                }
            }
        }
    }

    public void addNotify(final SYTimerListener sYTimerListener, long j, SYTimerTask.SYTimerStepListener sYTimerStepListener, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "764685278")) {
            ipChange.ipc$dispatch("764685278", new Object[]{this, sYTimerListener, Long.valueOf(j), sYTimerStepListener, Long.valueOf(j2)});
            return;
        }
        SYTimerTask taskByName = getTaskByName(String.valueOf(sYTimerListener.hashCode()));
        if (taskByName == null) {
            addTask(new SYTimerTask(j, String.valueOf(sYTimerListener.hashCode()), sYTimerStepListener, j2) {
                /* class com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimer.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerTask
                public void onTimeOver() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1387125299")) {
                        ipChange.ipc$dispatch("-1387125299", new Object[]{this});
                        return;
                    }
                    synchronized (SYTimer.class) {
                        SYTimer.this.isWaked = true;
                        SYTimer.class.notifyAll();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerTask
                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "956211570")) {
                        ipChange.ipc$dispatch("956211570", new Object[]{this});
                        return;
                    }
                    sYTimerListener.onNotify();
                }
            });
        } else {
            updateTask(taskByName, j);
        }
    }

    public void cancelTask(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2013426359")) {
            ipChange.ipc$dispatch("-2013426359", new Object[]{this, str});
            return;
        }
        SYTimerTask taskByName = getTaskByName(str);
        if (taskByName != null) {
            taskByName.cancel();
            synchronized (SYTimer.class) {
                if (this.tasks.contains(taskByName)) {
                    this.tasks.remove(taskByName);
                    this.isWaked = true;
                    SYTimer.class.notifyAll();
                }
            }
        }
    }

    public void cancelTask(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1477281188")) {
            ipChange.ipc$dispatch("1477281188", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        synchronized (SYTimer.class) {
            if (this.tasks.size() > i) {
                this.tasks.get(i).cancel();
                this.tasks.remove(i);
                this.isWaked = true;
                SYTimer.class.notifyAll();
            }
        }
    }
}
