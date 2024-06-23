package com.youku.player.util;

import androidx.annotation.Keep;
import java.util.Map;

/* compiled from: Taobao */
public class Watchdog {

    /* compiled from: Taobao */
    public interface QueryCallback {
        @Keep
        void onResult(String str, Map<String, String> map);
    }

    /* compiled from: Taobao */
    public enum StreamQulity {
        P540,
        P720,
        P1080,
        P2160
    }

    private native void _query(QueryCallback queryCallback);
}
