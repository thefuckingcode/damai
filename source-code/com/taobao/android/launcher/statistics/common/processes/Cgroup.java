package com.taobao.android.launcher.statistics.common.processes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public final class Cgroup extends ProcFile {
    public final ArrayList<ControlGroup> groups = new ArrayList<>();

    private Cgroup(String str) throws IOException {
        super(str);
        for (String str2 : this.content.split(StringUtils.LF)) {
            try {
                this.groups.add(new ControlGroup(str2));
            } catch (Exception unused) {
            }
        }
    }

    public static Cgroup get(int i) throws IOException {
        return new Cgroup(String.format(Locale.ENGLISH, "/proc/%d/cgroup", Integer.valueOf(i)));
    }

    public ControlGroup getGroup(String str) {
        Iterator<ControlGroup> it = this.groups.iterator();
        while (it.hasNext()) {
            ControlGroup next = it.next();
            String[] split = next.subsystems.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (split[i].equals(str)) {
                        return next;
                    }
                    i++;
                }
            }
        }
        return null;
    }
}
