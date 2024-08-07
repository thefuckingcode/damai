package com.alibaba.android.onescheduler.group;

import android.os.Build;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.CallableCallback;
import com.alibaba.android.onescheduler.IScheduler;
import com.alibaba.android.onescheduler.Priority;
import com.alibaba.android.onescheduler.task.InnerOneTask;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class Group implements IGroup {
    private static ExecutorService i = Executors.newSingleThreadExecutor(new a());
    private int a = 1;
    private volatile boolean b = false;
    private volatile boolean c = false;
    private Priority d;
    @NonNull
    private Queue<InnerOneTask> e = new PriorityBlockingQueue(5, new b(this));
    @NonNull
    private List<InnerOneTask> f = new ArrayList();
    private final ReentrantLock g = new ReentrantLock();
    private IScheduler h;

    /* compiled from: Taobao */
    static class a implements ThreadFactory {
        a() {
        }

        @NonNull
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OST-Group");
            thread.setPriority(5);
            return thread;
        }
    }

    /* compiled from: Taobao */
    class b implements Comparator<InnerOneTask> {
        b(Group group) {
        }

        /* renamed from: a */
        public int compare(@NonNull InnerOneTask innerOneTask, @NonNull InnerOneTask innerOneTask2) {
            long prioritySequence;
            long prioritySequence2;
            if (innerOneTask.getPriority() == null && innerOneTask2.getPriority() == null) {
                prioritySequence = innerOneTask.getPrioritySequence();
                prioritySequence2 = innerOneTask2.getPrioritySequence();
            } else if (innerOneTask.getPriority() == null) {
                return -1;
            } else {
                if (innerOneTask2 == null || innerOneTask2.getPriority() == null) {
                    return 1;
                }
                int compareTo = innerOneTask.getPriority().compareTo((Enum) innerOneTask2.getPriority()) * -1;
                if (compareTo != 0) {
                    return compareTo;
                }
                prioritySequence = innerOneTask.getPrioritySequence();
                prioritySequence2 = innerOneTask2.getPrioritySequence();
            }
            return (int) (prioritySequence - prioritySequence2);
        }
    }

    public Group(IScheduler iScheduler) {
        this.h = iScheduler;
    }

    private InnerOneTask b() {
        if (this.c || this.b || this.e.isEmpty() || this.f.size() >= this.a) {
            return null;
        }
        InnerOneTask poll = this.e.poll();
        if (poll != null) {
            this.f.add(poll);
            poll.setRunningState(true);
        }
        return poll;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("concurrents", this.a);
            StringBuilder sb = new StringBuilder();
            if (this.f.size() > 0) {
                jSONObject.put("runningSize", this.f.size());
                for (InnerOneTask innerOneTask : new ArrayList(this.f)) {
                    if (innerOneTask != null) {
                        sb.append(innerOneTask.getName());
                        sb.append(":");
                        sb.append("isCancelled=");
                        sb.append(innerOneTask.isCancelled());
                        sb.append(";");
                    }
                }
            }
            jSONObject.put("runningTasks", sb.toString());
            sb.setLength(0);
            if (this.e.size() > 0) {
                jSONObject.put("waitingSize", this.e.size());
                for (InnerOneTask innerOneTask2 : new ArrayList(this.e)) {
                    if (innerOneTask2 != null) {
                        sb.append(innerOneTask2.getName());
                        sb.append(":");
                        sb.append("isCancelled=");
                        sb.append(innerOneTask2.isCancelled());
                        sb.append(";");
                    }
                }
            }
            jSONObject.put("waitingTasks", sb.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void addTask(@NonNull InnerOneTask innerOneTask) {
        if (Build.VERSION.SDK_INT >= 17) {
            innerOneTask.setPrioritySequence(SystemClock.elapsedRealtimeNanos());
        } else {
            innerOneTask.setPrioritySequence(SystemClock.elapsedRealtime());
        }
        innerOneTask.setGroupPriority(this.d);
        try {
            this.g.lock();
            if (this.b || this.f.size() >= this.a) {
                this.e.add(innerOneTask);
            } else {
                this.f.add(innerOneTask);
                innerOneTask.setRunningState(true);
                this.h.schedule(innerOneTask);
            }
        } finally {
            this.g.unlock();
        }
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void destroy() {
        this.c = true;
        try {
            this.g.lock();
            ArrayList<InnerOneTask> arrayList = null;
            ArrayList<InnerOneTask> arrayList2 = !this.e.isEmpty() ? new ArrayList(this.e) : null;
            if (!this.f.isEmpty()) {
                arrayList = new ArrayList(this.f);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (InnerOneTask innerOneTask : arrayList2) {
                    innerOneTask.cancel(true);
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                for (InnerOneTask innerOneTask2 : arrayList) {
                    innerOneTask2.cancel(true);
                }
            }
        } finally {
            this.g.unlock();
        }
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public int getConcurrents() {
        return this.a;
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void pause() {
        this.b = true;
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void removeCanceledTask(@NonNull InnerOneTask innerOneTask) {
        if (innerOneTask.isRunningState()) {
            try {
                this.g.lock();
                this.f.remove(innerOneTask);
                InnerOneTask b2 = b();
                if (b2 != null) {
                    this.h.schedule(b2);
                }
            } finally {
                this.g.unlock();
            }
        } else {
            try {
                this.g.lock();
                this.e.remove(innerOneTask);
            } finally {
                this.g.unlock();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r5.getCallback();
     */
    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void removeFinishedTask(@NonNull InnerOneTask innerOneTask) {
        final CallableCallback callback;
        if (!innerOneTask.isCancelled() && callback != null) {
            try {
                final Object obj = innerOneTask.getFutureTask().get();
                i.execute(new Runnable() {
                    /* class com.alibaba.android.onescheduler.group.Group.AnonymousClass2 */

                    public void run() {
                        callback.onTaskFinished(obj);
                    }
                });
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            } catch (ExecutionException e3) {
                e3.printStackTrace();
            }
        }
        try {
            this.g.lock();
            this.f.remove(innerOneTask);
            InnerOneTask b2 = b();
            if (b2 != null) {
                this.h.schedule(b2);
            }
        } finally {
            this.g.unlock();
        }
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void resume() {
        this.b = false;
        try {
            this.g.lock();
            InnerOneTask b2 = b();
            if (b2 != null) {
                this.h.schedule(b2);
            }
        } finally {
            this.g.unlock();
        }
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void setConcurrents(int i2) {
        this.a = i2;
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void setPriority(Priority priority) {
        this.d = priority;
    }
}
