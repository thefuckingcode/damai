package tb;

import android.app.ActivityManager;
import android.os.Process;
import com.taobao.login4android.session.SessionManager;
import java.io.File;
import java.util.List;

/* compiled from: Taobao */
public class bt1 {
    public static long a() {
        File file = new File("/proc/" + Process.myPid() + "/comm");
        if (file.exists()) {
            return file.lastModified();
        }
        return -1;
    }

    public static boolean b() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            String str = qs0.e().a().getPackageName() + SessionManager.CHANNEL_PROCESS;
            ActivityManager activityManager = (ActivityManager) qs0.e().a().getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && str.equals(runningAppProcessInfo.processName)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            i20.a("ProcessUtils", th);
        }
    }
}
