package com.youku.a;

import com.youku.media.arch.instruments.ConfigFetcher;

/* compiled from: Taobao */
public class d {
    public static int a() {
        try {
            return Integer.parseInt(ConfigFetcher.getInstance().getConfig("youku_alixplayerpool_config", "alixplayerpool_maxcount", "8"));
        } catch (Exception unused) {
            return 8;
        }
    }

    public static int b() {
        try {
            return Integer.parseInt(ConfigFetcher.getInstance().getConfig("youku_alixplayerpool_config", "alixplayerpool_maxinusecount", "6"));
        } catch (Exception unused) {
            return 4;
        }
    }
}
