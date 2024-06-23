package com.youku.alixplayer.util;

/* compiled from: Taobao */
public class AlixLogger {
    private static volatile TLogAdapter sTLogAdapter;

    /* compiled from: Taobao */
    public interface TLogAdapter {
        void tlog(String str);
    }

    public static void setTLogAdapter(TLogAdapter tLogAdapter) {
        sTLogAdapter = tLogAdapter;
    }

    public static void tlog(String str) {
        if (sTLogAdapter != null) {
            sTLogAdapter.tlog(str);
        }
    }
}
