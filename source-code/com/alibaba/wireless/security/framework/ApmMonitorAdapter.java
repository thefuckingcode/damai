package com.alibaba.wireless.security.framework;

import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
public class ApmMonitorAdapter {
    public static boolean isEnableFullTrackRecord() {
        return SGApmMonitorManager.getInstance().isEnableFullTrackRecord();
    }

    public static boolean isForeground() {
        return SGApmMonitorManager.getInstance().isForeground();
    }

    public static void jstage(String str, String str2) {
        SGApmMonitorManager instance = SGApmMonitorManager.getInstance();
        instance.addTrackInfo("j_" + str + JSMethod.NOT_SET + str2);
    }

    public static void jstageEnd(String str, String str2) {
        SGApmMonitorManager instance = SGApmMonitorManager.getInstance();
        instance.addTrackInfo("j_" + str + JSMethod.NOT_SET + str2 + "_e");
    }

    public static void jstageStart(String str, String str2) {
        SGApmMonitorManager instance = SGApmMonitorManager.getInstance();
        instance.addTrackInfo("j_" + str + JSMethod.NOT_SET + str2 + "_s");
    }

    public static void stage(String str, String str2) {
        SGApmMonitorManager instance = SGApmMonitorManager.getInstance();
        instance.addTrackInfo(str + JSMethod.NOT_SET + str2);
    }

    public static void stageEnd(String str, String str2) {
        SGApmMonitorManager instance = SGApmMonitorManager.getInstance();
        instance.addTrackInfo(str + JSMethod.NOT_SET + str2 + "_e");
    }

    public static void stageStart(String str, String str2) {
        SGApmMonitorManager instance = SGApmMonitorManager.getInstance();
        instance.addTrackInfo(str + JSMethod.NOT_SET + str2 + "_s");
    }
}
