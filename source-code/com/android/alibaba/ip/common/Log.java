package com.android.alibaba.ip.common;

import java.util.logging.Level;

/* compiled from: Taobao */
public class Log {
    public static Logging logging;

    /* compiled from: Taobao */
    public interface Logging {
        boolean isLoggable(Level level);

        void log(Level level, String str);

        void log(Level level, String str, Throwable th);
    }
}
