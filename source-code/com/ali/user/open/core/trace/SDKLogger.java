package com.ali.user.open.core.trace;

import android.content.Context;
import android.util.Log;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.taobao.tlog.adapter.AdapterForTLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class SDKLogger {
    private static final String TAG_PREFIX = "AliMemberSDK_";
    private static boolean isTlogValid;

    static {
        try {
            int i = AdapterForTLog.a;
            isTlogValid = true;
        } catch (ClassNotFoundException unused) {
            isTlogValid = false;
        }
    }

    private static String appendCurrentTime() {
        return StringUtils.LF + "time =" + getDateStringByMill();
    }

    public static void d(String str, String str2) {
        try {
            if (!isDebugEnabled()) {
                return;
            }
            if (isTlogValid) {
                TLogAdapter.d(TAG_PREFIX + str, str2 + appendCurrentTime());
                return;
            }
            Log.d(TAG_PREFIX + str, str2 + appendCurrentTime());
        } catch (Throwable unused) {
        }
    }

    public static void e(String str, String str2, Throwable th) {
        try {
            if (isTlogValid) {
                TLogAdapter.e(TAG_PREFIX + str, str2 + appendCurrentTime(), th);
                return;
            }
            Log.e(TAG_PREFIX + str, str2 + appendCurrentTime(), th);
        } catch (Throwable unused) {
        }
    }

    private static String getDateStringByMill() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date(System.currentTimeMillis()));
    }

    public static void i(String str, String str2) {
        try {
            if (!isDebugEnabled()) {
                return;
            }
            if (isTlogValid) {
                TLogAdapter.i(TAG_PREFIX + str, str2 + appendCurrentTime());
                return;
            }
            Log.i(TAG_PREFIX + str, str2 + appendCurrentTime());
        } catch (Throwable unused) {
        }
    }

    public static boolean isApkDebugable(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isDebugEnabled() {
        return ConfigManager.DEBUG || isApkDebugable(KernelContext.getApplicationContext());
    }

    public static void w(String str, String str2) {
        try {
            if (!isDebugEnabled()) {
                return;
            }
            if (isTlogValid) {
                TLogAdapter.w(TAG_PREFIX + str, str2 + appendCurrentTime());
                return;
            }
            Log.w(TAG_PREFIX + str, str2 + appendCurrentTime());
        } catch (Throwable unused) {
        }
    }

    public static void e(String str, String str2) {
        try {
            if (isTlogValid) {
                TLogAdapter.e(TAG_PREFIX + str, str2 + appendCurrentTime());
                return;
            }
            Log.e(TAG_PREFIX + str, str2 + appendCurrentTime());
        } catch (Throwable unused) {
        }
    }
}
