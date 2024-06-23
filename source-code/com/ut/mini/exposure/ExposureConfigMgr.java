package com.ut.mini.exposure;

import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.fastjson.JSON;
import java.util.Map;
import tb.yi;
import tb.zc2;

/* compiled from: Taobao */
public class ExposureConfigMgr {
    private static final String EXP_CONFIG_TAG = "autoExposure";
    public static double dimThreshold = 0.5d;
    private static String mConfig = null;
    public static int maxTimeThreshold = 3600000;
    public static boolean notClearTagAfterDisAppear = false;
    public static int timeThreshold = 500;
    public static boolean trackerExposureOpen = true;

    public static void init() {
        updateExposureConfig(zc2.a(yi.c().b(), EXP_CONFIG_TAG));
        TrackerManager.getInstance().getThreadHandle().postDelayed(new Runnable() {
            /* class com.ut.mini.exposure.ExposureConfigMgr.AnonymousClass1 */

            public void run() {
                ExposureConfigMgr.updateExposureConfig();
            }
        }, 15000);
    }

    public static void updateExposureConfig() {
        try {
            updateExposureConfig(AnalyticsMgr.K(EXP_CONFIG_TAG));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        if (r10.equalsIgnoreCase(com.ut.mini.exposure.ExposureConfigMgr.mConfig) == false) goto L_0x0013;
     */
    private static void updateExposureConfig(String str) {
        if (str != null) {
        }
        if (str == null && mConfig == null) {
            ExpLogger.d("ExposureConfigMgr", "trackerExposureOpen", Boolean.valueOf(trackerExposureOpen), "timeThreshold", Integer.valueOf(timeThreshold), " dimThreshold", Double.valueOf(dimThreshold));
        }
        mConfig = str;
        zc2.b(yi.c().b(), EXP_CONFIG_TAG, mConfig);
        String str2 = mConfig;
        if (str2 != null) {
            try {
                Map map = (Map) JSON.parseObject(str2, Map.class);
                if (map != null && map.size() > 0) {
                    if (("" + map.get("turnOn")).equals("1")) {
                        trackerExposureOpen = true;
                    } else {
                        trackerExposureOpen = false;
                    }
                    int i = -1;
                    try {
                        i = Integer.parseInt("" + map.get("timeThreshold"));
                    } catch (Exception unused) {
                    }
                    if (i >= 0) {
                        timeThreshold = i;
                    }
                    double d = -1.0d;
                    try {
                        d = Double.parseDouble("" + map.get("areaThreshold"));
                    } catch (Exception unused2) {
                    }
                    if (d >= 0.0d) {
                        dimThreshold = d;
                    }
                    if (("" + map.get("notClearTag")).equals("1")) {
                        notClearTagAfterDisAppear = true;
                    } else {
                        notClearTagAfterDisAppear = false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            trackerExposureOpen = true;
            timeThreshold = 500;
            dimThreshold = 0.5d;
        }
        ExpLogger.d("ExposureConfigMgr", "trackerExposureOpen", Boolean.valueOf(trackerExposureOpen), "timeThreshold", Integer.valueOf(timeThreshold), " dimThreshold", Double.valueOf(dimThreshold));
    }
}
