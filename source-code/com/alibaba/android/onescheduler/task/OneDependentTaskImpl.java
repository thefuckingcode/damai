package com.alibaba.android.onescheduler.task;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.onescheduler.OneDependentTask;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.al1;
import tb.kj2;
import tb.ve0;

/* compiled from: Taobao */
public class OneDependentTaskImpl extends OneCommonTaskImpl implements OneDependentTask, InnerDepentTask {
    private boolean mIsAnchorTask;
    @NonNull
    private Set<OneDependentTask> mPredecessorSet;
    private Set<OneDependentTask> mSuccessorSet;

    OneDependentTaskImpl(@NonNull a aVar) {
        super(aVar);
        this.mIsAnchorTask = aVar.h;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerDepentTask
    public void addPredecessor(OneDependentTask oneDependentTask) {
        if (this.mPredecessorSet == null) {
            this.mPredecessorSet = new CopyOnWriteArraySet();
        }
        this.mPredecessorSet.add(oneDependentTask);
    }

    @Override // com.alibaba.android.onescheduler.task.InnerDepentTask
    public void addSuccessor(OneDependentTask oneDependentTask) {
        if (this.mSuccessorSet == null) {
            this.mSuccessorSet = new CopyOnWriteArraySet();
        }
        this.mSuccessorSet.add(oneDependentTask);
    }

    @Override // com.alibaba.android.onescheduler.OneDependentTask
    public void after(@Nullable OneDependentTask oneDependentTask) {
        if (oneDependentTask != null) {
            addPredecessor(oneDependentTask);
            ((InnerDepentTask) oneDependentTask).addSuccessor(this);
        }
    }

    @Override // com.alibaba.android.onescheduler.OneDependentTask
    public void removePredecessor(OneDependentTask oneDependentTask) {
        Set<OneDependentTask> set = this.mPredecessorSet;
        if (set != null && oneDependentTask != null) {
            set.remove(oneDependentTask);
        }
    }

    @Override // com.alibaba.android.onescheduler.task.InnerDepentTask
    public void removePredecessorTryRun(OneDependentTask oneDependentTask) {
        Set<OneDependentTask> set = this.mPredecessorSet;
        if (set != null) {
            set.remove(oneDependentTask);
            if (this.mPredecessorSet.isEmpty()) {
                run();
            }
        }
    }

    @Override // com.alibaba.android.onescheduler.OneDependentTask
    public void removeSuccessor(OneDependentTask oneDependentTask) {
        Set<OneDependentTask> set = this.mSuccessorSet;
        if (set != null && oneDependentTask != null) {
            set.remove(oneDependentTask);
        }
    }

    @Override // com.alibaba.android.onescheduler.task.OneCommonTaskImpl
    public void run() {
        if (this.mStarted || this.mIsCancelled) {
            al1.a("Warnning: OneScheduler task %s is reused !!!", this.mName);
            return;
        }
        ve0.a().f(this);
        if (this.mIsAnchorTask) {
            tryRunSuccessor();
        } else {
            kj2.f().h(this);
        }
        this.mStarted = true;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerDepentTask
    public void tryRunSuccessor() {
        Set<OneDependentTask> set = this.mSuccessorSet;
        if (set != null && !set.isEmpty()) {
            Iterator<OneDependentTask> it = this.mSuccessorSet.iterator();
            while (it.hasNext()) {
                ((InnerDepentTask) it.next()).removePredecessorTryRun(this);
            }
        }
    }
}
