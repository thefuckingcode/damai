package com.taobao.android.launcher.schedulers;

import androidx.annotation.NonNull;
import com.taobao.android.job.core.DAGStage;
import com.taobao.android.job.core.DAGTaskChain;
import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.launcher.Constants;
import com.taobao.android.launcher.LaunchScheduler;
import com.taobao.android.launcher.StageRunnable;
import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.android.launcher.report.ExecutionReporter;
import com.taobao.android.launcher.switches.LauncherSwitches;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class IdleTaskHandler implements Runnable {
    private final LaunchScheduler scheduler;

    IdleTaskHandler(@NonNull LaunchScheduler launchScheduler) {
        this.scheduler = launchScheduler;
    }

    private void scheduleIdle() {
        LauncherRuntime.sCold = false;
        if (LauncherSwitches.isStageSwitchOn(Constants.STAGE_MAIN_IDLE)) {
            Log.e(Constants.TAG_LIFE_CYCLE, "onIdled, but ignore because of switch m-idle", new Object[0]);
            return;
        }
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdled", new Object[0]);
        long idleDelay = LauncherSwitches.getIdleDelay();
        if (idleDelay == 0) {
            idleDelay = 200;
        }
        DAGStage<String, Void> createStage = this.scheduler.createStage(Constants.STAGE_MAIN_IDLE);
        this.scheduler.generator.genMainIdle(DAGTaskChain.from(createStage));
        this.scheduler.schedule(createStage, idleDelay, TimeUnit.MILLISECONDS, new StageRunnable<String, Void>() {
            /* class com.taobao.android.launcher.schedulers.IdleTaskHandler.AnonymousClass1 */

            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
                IdleTaskHandler.this.scheduleIdle2s();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scheduleIdle10s() {
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdled10s", new Object[0]);
        DAGStage<String, Void> createStage = this.scheduler.createStage(Constants.STAGE_MAIN_IDLE_10s);
        this.scheduler.generator.genMainIdle10s(DAGTaskChain.from(createStage));
        this.scheduler.schedule(createStage, 5, TimeUnit.SECONDS, new StageRunnable<String, Void>() {
            /* class com.taobao.android.launcher.schedulers.IdleTaskHandler.AnonymousClass4 */

            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
                IdleTaskHandler.this.scheduleIdle15s();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scheduleIdle15s() {
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdled15s", new Object[0]);
        DAGStage<String, Void> createStage = this.scheduler.createStage(Constants.STAGE_MAIN_IDLE_15s);
        this.scheduler.generator.genMainIdle15s(DAGTaskChain.from(createStage));
        this.scheduler.schedule(createStage, 5, TimeUnit.SECONDS, new StageRunnable<String, Void>() {
            /* class com.taobao.android.launcher.schedulers.IdleTaskHandler.AnonymousClass5 */

            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
                IdleTaskHandler.this.scheduleIdle30s();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scheduleIdle2s() {
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdled2s", new Object[0]);
        DAGStage<String, Void> createStage = this.scheduler.createStage(Constants.STAGE_MAIN_IDLE_2s);
        this.scheduler.generator.genMainIdle2s(DAGTaskChain.from(createStage));
        this.scheduler.schedule(createStage, 2, TimeUnit.SECONDS, new StageRunnable<String, Void>() {
            /* class com.taobao.android.launcher.schedulers.IdleTaskHandler.AnonymousClass2 */

            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
                IdleTaskHandler.this.scheduleIdle5s();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scheduleIdle30s() {
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdled30s", new Object[0]);
        DAGStage<String, Void> createStage = this.scheduler.createStage(Constants.STAGE_MAIN_IDLE_30s);
        this.scheduler.generator.genMainIdle30s(DAGTaskChain.from(createStage));
        this.scheduler.schedule(createStage, 15, TimeUnit.SECONDS, new StageRunnable<String, Void>() {
            /* class com.taobao.android.launcher.schedulers.IdleTaskHandler.AnonymousClass6 */

            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scheduleIdle5s() {
        Log.e(Constants.TAG_LIFE_CYCLE, "onIdled5s", new Object[0]);
        DAGStage<String, Void> createStage = this.scheduler.createStage(Constants.STAGE_MAIN_IDLE_5s);
        this.scheduler.generator.genMainIdle5s(DAGTaskChain.from(createStage));
        this.scheduler.schedule(createStage, 5, TimeUnit.SECONDS, new StageRunnable<String, Void>() {
            /* class com.taobao.android.launcher.schedulers.IdleTaskHandler.AnonymousClass3 */

            @Override // com.taobao.android.launcher.StageRunnable
            public void onComplete(DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
                ExecutionReporter.reportDAGStage(LauncherRuntime.sContext, dAGStage, executionSummary);
                IdleTaskHandler.this.scheduleIdle10s();
            }
        });
    }

    public void run() {
        scheduleIdle();
    }
}
