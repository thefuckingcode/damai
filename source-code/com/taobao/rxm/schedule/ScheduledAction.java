package com.taobao.rxm.schedule;

import android.os.Process;
import androidx.annotation.NonNull;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.request.RequestCancelListener;
import tb.c02;
import tb.d42;
import tb.e42;
import tb.j22;
import tb.jl1;

/* compiled from: Taobao */
public abstract class ScheduledAction implements Runnable, Comparable<ScheduledAction> {
    private static final int MAX_REJECT_STACK_DEPTH = 10;
    private static final int STATE_READY = 1;
    private static final int STATE_RECYCLING = 3;
    private static final int STATE_RUNNING = 2;
    static ThreadLocal<ScheduledAction> sActionCallerThreadLocal = new ThreadLocal<>();
    private e42 mActionPool;
    private boolean mAllowedDirectRun;
    private ScheduledActionListener mBranchActionListener;
    private Consumer<?, ? extends c02> mConsumer;
    private boolean mIsNotConsumeAction;
    private ScheduledActionListener mMasterActionListener;
    private int mPriority = 1;
    private Integer mRejectedStackDepth;
    private d42 mResultWrapper;
    private long mRunningThreadId;
    private int mState;
    private long mTimeStamp;

    public ScheduledAction(int i, Consumer<?, ? extends c02> consumer, d42 d42) {
        reset(i, consumer, d42);
    }

    private synchronized c02 getRequest() {
        Consumer<?, ? extends c02> consumer = this.mConsumer;
        if (consumer == null || consumer.getContext() == null) {
            return null;
        }
        return (c02) this.mConsumer.getContext();
    }

    public boolean canRunDirectly() {
        return !j22.b() && !mayStackOverflowAfterRejected() && this.mAllowedDirectRun;
    }

    /* access modifiers changed from: package-private */
    public synchronized void cancelActing() {
        d42 d42 = this.mResultWrapper;
        if (d42 != null) {
            OUT out = d42.c;
            if (out instanceof Releasable) {
                out.release();
            }
        }
        Consumer<?, ? extends c02> consumer = this.mConsumer;
        if (consumer != null) {
            consumer.onCancellation();
            e42 e42 = this.mActionPool;
            if (e42 != null) {
                e42.recycle(this);
            }
        }
    }

    public int getContextId() {
        c02 request = getRequest();
        if (request != null) {
            return request.d();
        }
        return -1;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public Integer getRejectedStackDepth() {
        return this.mRejectedStackDepth;
    }

    public long getRunningThreadId() {
        return this.mRunningThreadId;
    }

    public int getState() {
        return this.mState;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public boolean isConsumeAction() {
        return !this.mIsNotConsumeAction || this.mResultWrapper != null;
    }

    public boolean isProduceAction() {
        return this.mResultWrapper == null;
    }

    public boolean mayStackOverflowAfterRejected() {
        ScheduledAction scheduledAction;
        if (this.mRejectedStackDepth == null) {
            if (j22.b() || (scheduledAction = sActionCallerThreadLocal.get()) == null || scheduledAction.getState() != 2 || scheduledAction.getRunningThreadId() != Thread.currentThread().getId()) {
                this.mRejectedStackDepth = 0;
            } else {
                this.mRejectedStackDepth = scheduledAction.getRejectedStackDepth();
            }
        }
        Integer num = this.mRejectedStackDepth;
        if (num == null || num.intValue() < 10) {
            return false;
        }
        return true;
    }

    public void notConsumeAction(boolean z) {
        this.mIsNotConsumeAction = z;
    }

    public void registerCancelListener(RequestCancelListener requestCancelListener) {
        c02 request = getRequest();
        if (request != null) {
            request.l(requestCancelListener);
        }
    }

    public ScheduledAction reset() {
        reset(1, null, null);
        return this;
    }

    public void run() {
        this.mRunningThreadId = Thread.currentThread().getId();
        if (!j22.b()) {
            try {
                Process.setThreadPriority(10);
            } catch (Throwable unused) {
            }
            ScheduledAction scheduledAction = sActionCallerThreadLocal.get();
            int i = 0;
            if (scheduledAction != null && scheduledAction.getState() == 2 && scheduledAction.getRunningThreadId() == Thread.currentThread().getId()) {
                Integer num = this.mRejectedStackDepth;
                if (num != null) {
                    i = num.intValue();
                }
                this.mRejectedStackDepth = Integer.valueOf(i + 1);
            } else {
                this.mRejectedStackDepth = 0;
            }
            sActionCallerThreadLocal.set(this);
        }
        this.mState = 2;
        run(this.mConsumer, this.mResultWrapper);
        if (!j22.b()) {
            sActionCallerThreadLocal.set(this);
        }
        ScheduledActionListener scheduledActionListener = this.mMasterActionListener;
        if (scheduledActionListener != null) {
            scheduledActionListener.onActionFinished(this);
        }
        ScheduledActionListener scheduledActionListener2 = this.mBranchActionListener;
        if (scheduledActionListener2 != null) {
            scheduledActionListener2.onActionFinished(this);
        }
        this.mState = 3;
        synchronized (this) {
            e42 e42 = this.mActionPool;
            if (e42 != null) {
                e42.recycle(this);
            }
        }
    }

    public abstract void run(Consumer consumer, d42 d42);

    public void setBranchActionListener(ScheduledActionListener scheduledActionListener) {
        this.mBranchActionListener = scheduledActionListener;
    }

    public void setMasterActionListener(ScheduledActionListener scheduledActionListener) {
        this.mMasterActionListener = scheduledActionListener;
    }

    public synchronized void setScheduledActionPool(e42 e42) {
        this.mActionPool = e42;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(hashCode()));
        sb.append("@(");
        Object obj = this.mConsumer;
        if (obj == null) {
            obj = "NullConsumer";
        }
        sb.append(obj);
        sb.append(")[");
        sb.append(this.mPriority);
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append(this.mTimeStamp);
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }

    public synchronized void unregisterCancelListener(RequestCancelListener requestCancelListener) {
        c02 request = getRequest();
        if (request != null) {
            request.s(requestCancelListener);
        }
    }

    public int compareTo(@NonNull ScheduledAction scheduledAction) {
        int priority = scheduledAction.getPriority() - getPriority();
        return priority == 0 ? (int) (this.mTimeStamp - scheduledAction.getTimeStamp()) : priority;
    }

    public ScheduledAction reset(int i, Consumer<?, ? extends c02> consumer, d42 d42) {
        return reset(i, consumer, d42, true);
    }

    public synchronized ScheduledAction reset(int i, Consumer<?, ? extends c02> consumer, d42 d42, boolean z) {
        this.mTimeStamp = System.nanoTime();
        this.mPriority = i;
        this.mConsumer = consumer;
        this.mResultWrapper = d42;
        this.mAllowedDirectRun = z;
        this.mRejectedStackDepth = null;
        this.mState = 1;
        this.mRunningThreadId = 0;
        this.mMasterActionListener = null;
        this.mBranchActionListener = null;
        this.mIsNotConsumeAction = false;
        return this;
    }

    public ScheduledAction(int i, Consumer<?, ? extends c02> consumer, d42 d42, boolean z) {
        reset(i, consumer, d42, z);
    }
}
