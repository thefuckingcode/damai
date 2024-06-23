package mtopsdk.extra.antiattack;

import android.util.Log;
import com.taobao.tlog.adapter.AdapterForTLog;

/* compiled from: Taobao */
public final class LogTool {
    public static final int D = 2;
    public static final int E = 16;
    public static final int I = 4;
    public static final int N = 32;
    public static final int V = 1;
    public static final int W = 8;
    public static volatile boolean mEnableLog = true;
    public static volatile boolean mEnableTLog = true;
    public static volatile int mLogLevel = 4;

    private LogTool() {
    }

    public static int print(int i, String str, String str2, Throwable th) {
        if (!mEnableLog) {
            return 0;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i == 16) {
                            try {
                                if (!mEnableTLog) {
                                    return Log.e(str, str2, th);
                                }
                                AdapterForTLog.loge(str, str2, th);
                                return 0;
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        return 0;
                    } else if (!mEnableTLog) {
                        return Log.w(str, str2, th);
                    } else {
                        AdapterForTLog.logw(str, str2, th);
                        return 0;
                    }
                } else if (!mEnableTLog) {
                    return Log.i(str, str2);
                } else {
                    AdapterForTLog.logi(str, str2);
                    return 0;
                }
            } else if (!mEnableTLog) {
                return Log.d(str, str2);
            } else {
                AdapterForTLog.logd(str, str2);
                return 0;
            }
        } else if (!mEnableTLog) {
            return Log.v(str, str2);
        } else {
            AdapterForTLog.logv(str, str2);
            return 0;
        }
    }
}
