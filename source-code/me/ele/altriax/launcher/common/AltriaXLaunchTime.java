package me.ele.altriax.launcher.common;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.launcher.common.Switches;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
public class AltriaXLaunchTime {
    private static final String EMPTY_STRING = "";
    private static final byte[] LOCK = new byte[0];
    public static final String LOG_FORMAT = "%-10s %-60s   %s\n";
    private static final CopyOnWriteArrayList<LaunchLog> LOG_LIST = new CopyOnWriteArrayList<>();
    private static final boolean LOG_OPEN = Switches.isSwitchOn(LOG_OPEN_POINT_FILE);
    private static final String LOG_OPEN_POINT_FILE = ".altriax_launch_time";
    public static final String SP = "LaunchSharedPreferences";
    public static final String SPACE = "  ";
    public static final String TAG = "AltriaXLaunchTime";
    private static final int VERBOSE = 2;

    /* compiled from: Taobao */
    public static class LaunchLog {
        public final String[] messageList;
        public final String tag;

        public LaunchLog(@NonNull String str, @Nullable String[] strArr) {
            this.tag = str;
            this.messageList = strArr;
        }
    }

    public static void begin(@NonNull String str) {
        LOG_LIST.add(new LaunchLog(TAG, new String[]{str}));
        if (isOpen(TAG, 2)) {
            synchronized (LOCK) {
                Log.e(TAG, formatLog(str, null));
            }
        }
    }

    public static String formatLog(@NonNull String str, @Nullable String str2) {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = isMainThread() ? "[UI]" : "[Work]";
        objArr[1] = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        objArr[2] = str2;
        return String.format(locale, LOG_FORMAT, objArr);
    }

    public static CopyOnWriteArrayList<LaunchLog> getLogList() {
        return LOG_LIST;
    }

    private static boolean isLogOpen() {
        return LOG_OPEN;
    }

    private static boolean isLoggable(@NonNull String str, int i) {
        return true;
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean isOpen() {
        return isLoggable(TAG, 2) && isLogOpen();
    }

    public static String processMessage(@Nullable String... strArr) {
        if (strArr != null) {
            if (strArr.length > 1) {
                StringBuilder sb = new StringBuilder("");
                for (int i = 1; i < strArr.length; i++) {
                    sb.append(strArr[i]);
                    sb.append(SPACE);
                }
                return sb.toString();
            }
        }
        return "";
    }

    public static void sp(@Nullable String... strArr) {
        verbose(SP, strArr);
    }

    public static void v(@Nullable String... strArr) {
        verboseReport(TAG, strArr);
    }

    public static void v2(@NonNull String str, @Nullable String... strArr) {
        verboseReport(str, strArr);
    }

    public static void v3(@NonNull String str, @Nullable String... strArr) {
        verboseReport(str, strArr);
    }

    public static void v4(@NonNull String str, @Nullable String... strArr) {
        verboseReport(str, strArr);
    }

    private static void verbose(@NonNull String str, @Nullable String... strArr) {
        if (isOpen(str, 2) && strArr != null && strArr.length != 0) {
            String str2 = strArr[0];
            String str3 = null;
            if (strArr.length >= 2) {
                str3 = processMessage(strArr);
            }
            synchronized (LOCK) {
                Log.e(str, formatLog(str2, str3));
            }
        }
    }

    private static void verboseReport(@NonNull String str, @Nullable String... strArr) {
        LOG_LIST.add(new LaunchLog(str, strArr));
        verbose(str, strArr);
    }

    private static void verboseReportCalculate(@NonNull String str, @Nullable String... strArr) {
        LOG_LIST.add(new LaunchLog(str, strArr));
        verbose(str, strArr);
    }

    public static boolean isOpen(@NonNull String str, int i) {
        return isLoggable(str, i) && isLogOpen();
    }
}
