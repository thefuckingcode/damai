package me.ele.altriax.launcher.impl;

import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.helper.TimeHelpers;
import com.taobao.android.job.core.task.DelegateTask;
import com.taobao.android.job.core.task.ExecutionResults;
import com.taobao.android.job.core.task.Task;
import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.android.launcher.statistics.MotuCrash;
import com.taobao.android.launcher.statistics.TaoApm;
import com.taobao.android.launcher.statistics.trace.DAGTraceX;
import com.taobao.orange.OrangeConfig;

/* compiled from: Taobao */
public class LauncherTask extends DelegateTask<String, Void> {
    private static final String ORANGE_CATEGORY = "launch_config";
    private static final String ORANGE_SWITCH_NEED_REPORT = "1";
    private static final String ORANGE_SWITCH_REPORT = "is_report_crash";
    private static final String ORANGE_SWITCH_WHITE_LIST = "crash_white_list";
    private static final String TAG = "LauncherTask";

    LauncherTask(@NonNull Task<String, Void> task) {
        super(task);
    }

    private void onError(Throwable th) {
        if (LauncherRuntime.sDebuggable) {
            Log.e(TAG, "execute task '%s' failed with exception:", getId(), th);
        }
        OrangeConfig instance = OrangeConfig.getInstance();
        String config = instance.getConfig(ORANGE_CATEGORY, ORANGE_SWITCH_REPORT, "1");
        String config2 = instance.getConfig(ORANGE_CATEGORY, ORANGE_SWITCH_WHITE_LIST, "");
        if (!"1".equals(config)) {
            return;
        }
        if (TextUtils.isEmpty(config2) || !config2.contains((CharSequence) getId())) {
            MotuCrash.reportCrash(LauncherRuntime.sContext, (String) getId(), th);
        }
    }

    @Override // com.taobao.android.job.core.task.DelegateTask, com.taobao.android.job.core.task.Task
    public boolean intercept(ExecutionResults<String, Void> executionResults) {
        return !TaskSwitches.isTaskSwitchOn((String) getId()) && getTargetTask().intercept(executionResults);
    }

    @Override // com.taobao.android.job.core.task.Task
    public Void execute() {
        long j;
        if (LauncherRuntime.sDebuggable) {
            j = System.currentTimeMillis();
            Log.v(TAG, "Executing launcher # %s, thread priority:%d", getId(), Integer.valueOf(Process.getThreadPriority(Process.myTid())));
        } else {
            j = 0;
        }
        String str = (String) getId();
        try {
            DAGTraceX.beginSection(str);
            TaoApm.startTask(str);
            Void r6 = (Void) getTargetTask().execute();
            TaoApm.endTask(str);
            DAGTraceX.end();
            if (LauncherRuntime.sDebuggable) {
                Log.v(TAG, "Executed launcher # %s, Execution Done with result=%s, cost=%d ms", getId(), r6, Long.valueOf(TimeHelpers.since(j)));
            }
            return r6;
        } catch (Throwable th) {
            TaoApm.endTask(str);
            DAGTraceX.end();
            if (LauncherRuntime.sDebuggable) {
                Log.v(TAG, "Executed launcher # %s, Execution Done with result=%s, cost=%d ms", getId(), null, Long.valueOf(TimeHelpers.since(j)));
            }
            throw th;
        }
    }
}
