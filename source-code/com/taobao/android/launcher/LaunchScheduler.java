package com.taobao.android.launcher;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.job.core.DAGScheduler;
import com.taobao.android.job.core.DAGSchedulerConfig;
import com.taobao.android.job.core.DAGSchedulers;
import com.taobao.android.job.core.DAGStage;
import com.taobao.android.job.core.SchedulePolicy;
import com.taobao.android.job.core.task.ExecutionResults;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.launcher.common.OnDemandReceiver;
import com.taobao.android.launcher.config.Configuration;
import com.taobao.android.launcher.config.Generator;
import com.taobao.android.launcher.schedulers.ChannelScheduler;
import com.taobao.android.launcher.schedulers.EmptyScheduler;
import com.taobao.android.launcher.schedulers.MainScheduler;
import com.taobao.android.launcher.statistics.trace.DAGTraceX;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Taobao */
public abstract class LaunchScheduler {
    private final Configuration configuration;
    @Nullable
    private final DAGScheduler<String, Void> demandScheduler;
    public final Generator<String> generator;
    private final AtomicReference<ScheduledExecutorService> scheduledDemandRef = new AtomicReference<>(null);
    private final AtomicReference<ScheduledExecutorService> scheduledRef = new AtomicReference<>(null);
    @Nullable
    private final DAGScheduler<String, Void> scheduler;

    protected LaunchScheduler(Configuration configuration2) {
        this.configuration = configuration2;
        this.generator = configuration2.generator;
        DAGSchedulerConfig<String, Void> createConfig = createConfig();
        if (createConfig != null) {
            this.scheduler = DAGSchedulers.with(createConfig);
        } else {
            this.scheduler = null;
        }
        DAGSchedulerConfig<String, Void> createDemandConfig = createDemandConfig();
        if (createDemandConfig != null) {
            this.demandScheduler = DAGSchedulers.with(createDemandConfig);
        } else {
            this.demandScheduler = null;
        }
    }

    public static LaunchScheduler create(String str, Configuration configuration2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("processName invalid");
        } else if ("cn.damai".equals(str)) {
            return new MainScheduler(configuration2);
        } else {
            if ("cn.damai:channel".equals(str)) {
                return new ChannelScheduler(configuration2);
            }
            return new EmptyScheduler(configuration2);
        }
    }

    public abstract OnDemandReceiver asReceiver();

    /* access modifiers changed from: protected */
    public abstract DAGSchedulerConfig<String, Void> createConfig();

    /* access modifiers changed from: protected */
    public abstract DAGSchedulerConfig<String, Void> createDemandConfig();

    /* access modifiers changed from: protected */
    public DAGStage<String, Void> createDemandStage(String str) {
        DAGScheduler<String, Void> dAGScheduler = this.demandScheduler;
        if (dAGScheduler == null) {
            return null;
        }
        Configuration configuration2 = this.configuration;
        return dAGScheduler.createStage(str, configuration2.provider, configuration2.factory);
    }

    public DAGStage<String, Void> createStage(String str) {
        DAGScheduler<String, Void> dAGScheduler = this.scheduler;
        if (dAGScheduler == null) {
            return null;
        }
        Configuration configuration2 = this.configuration;
        return dAGScheduler.createStage(str, configuration2.provider, configuration2.factory, configuration2.deffer);
    }

    /* access modifiers changed from: package-private */
    public Future<Pair<ExecutionResults<String, Void>, ExecutionSummary>> schedule(DAGStage<String, Void> dAGStage, long j, TimeUnit timeUnit) {
        return schedule(dAGStage, j, timeUnit, null);
    }

    public abstract void schedule();

    /* access modifiers changed from: package-private */
    public Future<Pair<ExecutionResults<String, Void>, ExecutionSummary>> scheduleDemand(DAGStage<String, Void> dAGStage, long j, TimeUnit timeUnit) {
        return scheduleDemand(dAGStage, j, timeUnit, null);
    }

    public Future<Pair<ExecutionResults<String, Void>, ExecutionSummary>> schedule(DAGStage<String, Void> dAGStage, long j, TimeUnit timeUnit, @Nullable StageRunnable<String, Void> stageRunnable) {
        if (this.scheduler == null) {
            return null;
        }
        this.scheduledRef.compareAndSet(null, DAGExecutors.createSingleScheduled("launcher"));
        return schedule(this.scheduledRef.get(), this.scheduler, dAGStage, j, timeUnit, stageRunnable);
    }

    /* access modifiers changed from: protected */
    public Future<Pair<ExecutionResults<String, Void>, ExecutionSummary>> scheduleDemand(DAGStage<String, Void> dAGStage, long j, TimeUnit timeUnit, @Nullable StageRunnable<String, Void> stageRunnable) {
        if (this.demandScheduler == null) {
            return null;
        }
        this.scheduledDemandRef.compareAndSet(null, DAGExecutors.createSingleScheduled("launcher-onDemand"));
        return schedule(this.scheduledDemandRef.get(), this.demandScheduler, dAGStage, j, timeUnit, stageRunnable);
    }

    private Future<Pair<ExecutionResults<String, Void>, ExecutionSummary>> schedule(@NonNull ScheduledExecutorService scheduledExecutorService, @NonNull final DAGScheduler<String, Void> dAGScheduler, final DAGStage<String, Void> dAGStage, long j, TimeUnit timeUnit, @Nullable final StageRunnable<String, Void> stageRunnable) {
        return scheduledExecutorService.schedule(new Callable<Pair<ExecutionResults<String, Void>, ExecutionSummary>>() {
            /* class com.taobao.android.launcher.LaunchScheduler.AnonymousClass1 */

            @Override // java.util.concurrent.Callable
            public Pair<ExecutionResults<String, Void>, ExecutionSummary> call() {
                Pair<ExecutionResults<String, Void>, ExecutionSummary> schedule = dAGScheduler.schedule(SchedulePolicy.IMMEDIATE_NON_TERMINATING, dAGStage);
                StageRunnable stageRunnable = stageRunnable;
                if (stageRunnable != null) {
                    stageRunnable.onComplete(dAGStage, (ExecutionSummary) schedule.second);
                }
                return schedule;
            }
        }, j, timeUnit);
    }

    /* access modifiers changed from: package-private */
    public Pair<ExecutionResults<String, Void>, ExecutionSummary> schedule(DAGStage<String, Void> dAGStage) {
        return schedule(dAGStage, null);
    }

    /* access modifiers changed from: protected */
    public Pair<ExecutionResults<String, Void>, ExecutionSummary> schedule(DAGStage<String, Void> dAGStage, @Nullable StageRunnable<String, Void> stageRunnable) {
        return schedule(dAGStage, SchedulePolicy.IMMEDIATE_NON_TERMINATING, stageRunnable);
    }

    /* access modifiers changed from: protected */
    public Pair<ExecutionResults<String, Void>, ExecutionSummary> schedule(DAGStage<String, Void> dAGStage, SchedulePolicy schedulePolicy, @Nullable StageRunnable<String, Void> stageRunnable) {
        if (this.scheduler == null) {
            return null;
        }
        DAGTraceX.beginSection(dAGStage.getName());
        Pair<ExecutionResults<String, Void>, ExecutionSummary> schedule = this.scheduler.schedule(schedulePolicy, dAGStage);
        if (stageRunnable != null) {
            stageRunnable.onComplete(dAGStage, (ExecutionSummary) schedule.second);
        }
        DAGTraceX.end();
        return schedule;
    }
}
