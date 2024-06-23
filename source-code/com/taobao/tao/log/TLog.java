package com.taobao.tao.log;

import android.text.TextUtils;
import android.util.Log;
import com.youku.alixplayer.MsgID;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
public class TLog {

    /* access modifiers changed from: package-private */
    /* renamed from: com.taobao.tao.log.TLog$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$tao$log$LogLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$taobao$tao$log$LogLevel = iArr;
            iArr[LogLevel.D.ordinal()] = 1;
            $SwitchMap$com$taobao$tao$log$LogLevel[LogLevel.I.ordinal()] = 2;
            $SwitchMap$com$taobao$tao$log$LogLevel[LogLevel.W.ordinal()] = 3;
            $SwitchMap$com$taobao$tao$log$LogLevel[LogLevel.E.ordinal()] = 4;
            $SwitchMap$com$taobao$tao$log$LogLevel[LogLevel.V.ordinal()] = 5;
        }
    }

    private static String getExceptionMsg(String str, Throwable th) {
        if (th == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str) && str.length() > 10240) {
            str = String.format("%s...", str.substring(0, MsgID.MEDIA_INFO_VIDEO_START_RECOVER));
        }
        StringBuilder sb = new StringBuilder();
        String message = th.getMessage();
        String name = th.getClass().getName();
        sb.append("\t");
        sb.append(str + "\t");
        sb.append(name);
        sb.append(AltriaXLaunchTime.SPACE);
        sb.append(message);
        sb.append(SocketClient.NETASCII_EOL);
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            int i = 0;
            while (true) {
                if (i >= stackTrace.length) {
                    break;
                } else if (sb.length() >= 30720) {
                    sb.append(String.format("\t... total %d.\r\n", Integer.valueOf(stackTrace.length)));
                    break;
                } else {
                    sb.append("\tat  ");
                    sb.append(stackTrace[i]);
                    sb.append(SocketClient.NETASCII_EOL);
                    i++;
                }
            }
        }
        return sb.toString();
    }

    private static void log(LogLevel logLevel, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str6)) {
            Log.e(String.format("%s:%s", str, str2), "Log content is null!!!");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str = "module";
            } else if (str2.contains(".")) {
                String substring = str2.substring(0, str2.indexOf("."));
                str2 = str2.substring(str2.indexOf(".") + 1);
                str = substring;
            } else {
                str = str2;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "tag";
        }
        TLogNative.writeCodeLog(logLevel.getIndex(), str, str2, str6);
        if (TLogInitializer.getInstance().getOnTrackTLogListener() != null) {
            try {
                TLogInitializer.getInstance().getOnTrackTLogListener().onTrackTLog(logLevel, str, str2, str6);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void logThrowable(LogLevel logLevel, String str, String str2, String str3) {
        if (TLogInitializer.getInstance().isDebugable()) {
            toLogcat(logLevel, str, str2, str3);
        }
        log(logLevel, str, str2, String.valueOf(LogCategory.CodeLog.getIndex()), "", "", str3);
    }

    public static void logd(String str, String str2, String str3) {
        log(LogLevel.D, str, str2, str3);
    }

    public static void loge(String str, String str2, String str3) {
        log(LogLevel.E, str, str2, str3);
    }

    public static void logi(String str, String str2, String str3) {
        log(LogLevel.I, str, str2, str3);
    }

    public static void logv(String str, String str2, String str3) {
        log(LogLevel.V, str, str2, str3);
    }

    public static void logw(String str, String str2, String str3) {
        log(LogLevel.W, str, str2, str3);
    }

    private static void toLogcat(LogLevel logLevel, String str, String str2, String str3) {
        int i;
        if (str3 == null) {
            str3 = "";
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str + "." + str2;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$taobao$tao$log$LogLevel[logLevel.ordinal()];
        if (i2 == 1) {
            i = Log.d(str2, str3);
        } else if (i2 == 2) {
            i = Log.i(str2, str3);
        } else if (i2 == 3) {
            i = Log.w(str2, str3);
        } else if (i2 != 4) {
            i = Log.v(str2, str3);
        } else {
            i = Log.e(str2, str3);
        }
        if (i == -100) {
            try {
                Log.class.getMethod(logLevel.getName().toLowerCase(), String.class, String.class).invoke(null, str2, str3);
            } catch (Exception unused) {
            }
        }
    }

    @Deprecated
    public static void traceLog(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            log(LogLevel.F, "", "Trace", "T", str, str2, "NULL == log");
        }
    }

    @Deprecated
    public static void logd(String str, String str2) {
        logd("", str, str2);
    }

    @Deprecated
    public static void loge(String str, String str2) {
        loge("", str, str2);
    }

    @Deprecated
    public static void logi(String str, String str2) {
        logi("", str, str2);
    }

    @Deprecated
    public static void logv(String str, String str2) {
        logv("", str, str2);
    }

    @Deprecated
    public static void logw(String str, String str2) {
        logw("", str, str2);
    }

    @Deprecated
    public static void logd(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                logd("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            logd("", str, sb.toString());
        }
    }

    @Deprecated
    public static void loge(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                loge("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            loge("", str, sb.toString());
        }
    }

    @Deprecated
    public static void logi(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                logi("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            logi("", str, sb.toString());
        }
    }

    @Deprecated
    public static void logv(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                logv("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            logv("", str, sb.toString());
        }
    }

    @Deprecated
    public static void logw(String str, String... strArr) {
        if (strArr != null) {
            if (strArr.length == 1) {
                logw("", str, strArr[0]);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(" ");
            }
            logw("", str, sb.toString());
        }
    }

    @Deprecated
    public static void loge(String str, String str2, Throwable th) {
        loge("", str, str2, th);
    }

    @Deprecated
    public static void logw(String str, String str2, Throwable th) {
        logw("", str, str2, th);
    }

    public static void loge(String str, String str2, String str3, Throwable th) {
        String str4;
        if (th == null) {
            str4 = str3 + "******* NULL == e *******";
        } else {
            str4 = getExceptionMsg(str3, th);
        }
        logThrowable(LogLevel.E, str, str2, str4);
    }

    public static void logw(String str, String str2, String str3, Throwable th) {
        String str4;
        if (th == null) {
            str4 = str3 + "******* NULL == e *******";
        } else {
            str4 = getExceptionMsg(str3, th);
        }
        logThrowable(LogLevel.W, str, str2, str4);
    }

    private static void log(LogLevel logLevel, String str, String str2, String str3) {
        if (TLogInitializer.getInstance().isDebugable()) {
            toLogcat(logLevel, str, str2, str3);
        }
        if (!TextUtils.isEmpty(str3)) {
            log(logLevel, str, str2, String.valueOf(LogCategory.CodeLog.getIndex()), "", "", str3);
        }
    }
}
