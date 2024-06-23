package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.di;
import com.xiaomi.push.dj;
import java.io.File;

/* compiled from: Taobao */
public class Logger {
    private static boolean sDisablePushLog;
    private static LoggerInterface sUserLogger;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    @Deprecated
    public static File getLogFile(String str) {
        return null;
    }

    protected static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    private static boolean hasWritePermission(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        if (hasWritePermission(r4) != false) goto L_0x0017;
     */
    public static void setPushLog(Context context) {
        boolean z = true;
        boolean z2 = false;
        boolean z3 = sUserLogger != null;
        if (!sDisablePushLog) {
            z2 = z3;
        }
        z = false;
        dj djVar = null;
        LoggerInterface loggerInterface = z2 ? sUserLogger : null;
        if (z) {
            djVar = dj.a(context);
        }
        b.a(new di(loggerInterface, djVar));
    }

    @Deprecated
    public static void uploadLogFile(Context context, boolean z) {
    }
}
