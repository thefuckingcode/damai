package com.youku.arch.solid.log;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SLog {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ILogger logger = new DefaultLoggerImpl(false);

    public static void d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "32393272")) {
            ipChange.ipc$dispatch("32393272", new Object[]{str, str2});
            return;
        }
        logger.d(str, str2);
    }

    public static void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493973271")) {
            ipChange.ipc$dispatch("1493973271", new Object[]{str, str2});
            return;
        }
        logger.e(str, str2);
    }

    public static void setLogger(ILogger iLogger) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1429161760")) {
            ipChange.ipc$dispatch("1429161760", new Object[]{iLogger});
        } else if (iLogger != null) {
            logger = iLogger;
        }
    }

    public static void v(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "571029478")) {
            ipChange.ipc$dispatch("571029478", new Object[]{str, str2});
            return;
        }
        logger.v(str, str2);
    }

    public static void w(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2032609477")) {
            ipChange.ipc$dispatch("2032609477", new Object[]{str, str2});
            return;
        }
        logger.w(str, str2);
    }
}
