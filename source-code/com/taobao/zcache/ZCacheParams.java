package com.taobao.zcache;

import android.content.Context;

@Deprecated
/* compiled from: Taobao */
public class ZCacheParams {
    public String appKey;
    public String appVersion;
    public String configPrefix;
    public Context context;
    public int env;
    public String locale;
    public double updateInterval = 0.0d;
    public boolean useOldPlatform = false;
    public String zipPrefix;

    public static Environment getEnvironment(int i) {
        if (i == 1) {
            return Environment.Debug;
        }
        if (i != 2) {
            return Environment.Release;
        }
        return Environment.Daily;
    }
}
