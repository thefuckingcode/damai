package com.taobao.accs.asp;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.utils.IPCUtils;
import com.taobao.login4android.session.SessionManager;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class Utils {
    private static final String TAG = "Utils";
    private static volatile String sCoreProviderProcess;
    private static volatile String sCurrentProcess;

    Utils() {
    }

    static String getCoreProviderProcess() {
        if (sCoreProviderProcess != null) {
            return sCoreProviderProcess;
        }
        try {
            ComponentName componentName = new ComponentName(ARanger.getContext(), PrefsIPCChannel.CORE_CONTENT_PROVIDER);
            PackageManager packageManager = ARanger.getContext().getPackageManager();
            if (packageManager != null) {
                sCoreProviderProcess = packageManager.getProviderInfo(componentName, 0).processName;
            }
        } catch (Exception e) {
            ALog.e("Utils", "getCoreProviderProcess", e, new Object[0]);
        }
        return sCoreProviderProcess;
    }

    static String getCurrentProcess() {
        if (sCurrentProcess != null) {
            return sCurrentProcess;
        }
        sCurrentProcess = IPCUtils.getCurrentProcessName();
        return sCurrentProcess;
    }

    static boolean isCoreProcess() {
        return getCurrentProcess().endsWith(SessionManager.CHANNEL_PROCESS);
    }

    protected static boolean isCoreProcessLive() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String coreProviderProcess = getCoreProviderProcess();
        if (TextUtils.isEmpty(coreProviderProcess) || (runningAppProcesses = GlobalClientInfo.getInstance(ARanger.getContext()).getActivityManager().getRunningAppProcesses()) == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(coreProviderProcess)) {
                return true;
            }
        }
        return false;
    }
}
