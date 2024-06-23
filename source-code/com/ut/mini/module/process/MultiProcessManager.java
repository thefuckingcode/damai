package com.ut.mini.module.process;

/* compiled from: Taobao */
public class MultiProcessManager {
    private static AbsMultiProcessAdapter multiProcessAdapter;

    public static AbsMultiProcessAdapter getMultiProcessAdapter() {
        return multiProcessAdapter;
    }

    public static void setMultiProcessAdapter(AbsMultiProcessAdapter absMultiProcessAdapter) {
        multiProcessAdapter = absMultiProcessAdapter;
    }
}
