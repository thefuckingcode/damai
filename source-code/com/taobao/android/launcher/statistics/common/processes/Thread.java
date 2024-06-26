package com.taobao.android.launcher.statistics.common.processes;

import java.io.IOException;
import java.util.Locale;

/* compiled from: Taobao */
public final class Thread extends ProcFile {
    public final String name = this.content.trim();
    public final int tid;

    private Thread(int i, String str) throws IOException {
        super(str);
        this.tid = i;
    }

    public static Thread get(int i, int i2) throws IOException {
        return new Thread(i2, String.format(Locale.ENGLISH, "/proc/%d/task/%d/comm", Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public String toString() {
        return "[tid:" + this.tid + ", name:\"" + this.name + "\"]";
    }
}
