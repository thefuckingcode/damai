package com.taobao.login4android.thread;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.login4android.utils.ReflectionHelper;

/* compiled from: Taobao */
public class LoginThreadHelper {
    public static final String TAG = "login.LoginThreadHelper";
    private static Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|(1:4)|5|6|(4:8|(3:11|(3:18|13|14)|9)|19|21)(1:20)) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
        return "GetCurProcessException";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0025 */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[Catch:{ Exception -> 0x0051 }, ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0033 A[Catch:{ Exception -> 0x0051 }] */
    public static String getCurProcessName(Context context) {
        Class<?> cls = Class.forName("com.taobao.tao.TaobaoApplication");
        String str = (String) ReflectionHelper.invokeMethod(cls, cls.getDeclaredMethod("getProcessName", Context.class), context);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            return "ProcessNameNotFound";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "ProcessNameNotFound";
    }

    public static boolean isMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static void runOnUIThread(Runnable runnable) {
        try {
            if (!isMainThread()) {
                mMainThreadHandler.post(runnable);
            } else {
                runnable.run();
            }
        } catch (Exception e) {
            LoginTLogAdapter.w(TAG, "runOnUIThread failed", e);
            e.printStackTrace();
        }
    }
}
