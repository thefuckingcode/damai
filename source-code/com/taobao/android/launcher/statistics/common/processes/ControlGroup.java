package com.taobao.android.launcher.statistics.common.processes;

import java.util.Locale;

/* compiled from: Taobao */
public class ControlGroup {
    public final String group;
    public final int id;
    public final String subsystems;

    protected ControlGroup(String str) throws NumberFormatException, IndexOutOfBoundsException {
        String[] split = str.split(":");
        this.id = Integer.parseInt(split[0]);
        this.subsystems = split[1];
        this.group = split[2];
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "%d:%s:%s", Integer.valueOf(this.id), this.subsystems, this.group);
    }
}
