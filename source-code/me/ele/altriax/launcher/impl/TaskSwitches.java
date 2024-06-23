package me.ele.altriax.launcher.impl;

import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.android.launcher.common.Switches;

/* compiled from: Taobao */
class TaskSwitches {
    private static final String SWITCH_TASK_OFF = ".dag_switch_task_off_";

    TaskSwitches() {
    }

    static boolean isTaskSwitchOn(String str) {
        boolean z = LauncherRuntime.sDebuggable;
        return Switches.isSwitchOn(SWITCH_TASK_OFF + str);
    }
}
