package com.taobao.android.launcher.statistics.common.processes;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class AndroidAppProcess extends AndroidProcess {
    private static final Pattern PROCESS_NAME_PATTERN = Pattern.compile("^([A-Za-z]{1}[A-Za-z0-9_]*[\\.|:])*[A-Za-z][A-Za-z0-9_]*$");
    private static final boolean SYS_SUPPORTS_SCHEDGROUPS = new File("/dev/cpuctl/tasks").exists();
    public final boolean foreground;
    public final int uid;

    /* compiled from: Taobao */
    public static final class NotAndroidAppProcessException extends Exception {
        public NotAndroidAppProcessException(int i) {
            super(String.format(Locale.ENGLISH, "The process %d does not belong to any application", Integer.valueOf(i)));
        }
    }

    public AndroidAppProcess(int i) throws IOException, NotAndroidAppProcessException {
        super(i);
        boolean z;
        int i2;
        String str = this.name;
        if (str == null || !PROCESS_NAME_PATTERN.matcher(str).matches() || !new File("/data/data", getPackageName()).exists()) {
            throw new NotAndroidAppProcessException(i);
        }
        boolean z2 = true;
        if (SYS_SUPPORTS_SCHEDGROUPS) {
            Cgroup cgroup = cgroup();
            ControlGroup group = cgroup.getGroup("cpuacct");
            ControlGroup group2 = cgroup.getGroup("cpu");
            if (Build.VERSION.SDK_INT >= 21) {
                if (group2 == null || group == null || !group.group.contains("pid_")) {
                    throw new NotAndroidAppProcessException(i);
                }
                z = !group2.group.contains("bg_non_interactive");
                try {
                    i2 = Integer.parseInt(group.group.split("/")[1].replace("uid_", ""));
                } catch (Exception unused) {
                    i2 = status().getUid();
                }
            } else if (group2 == null || group == null || !group2.group.contains("apps")) {
                throw new NotAndroidAppProcessException(i);
            } else {
                z = !group2.group.contains("bg_non_interactive");
                try {
                    String str2 = group.group;
                    i2 = Integer.parseInt(str2.substring(str2.lastIndexOf("/") + 1));
                } catch (Exception unused2) {
                    i2 = status().getUid();
                }
            }
        } else {
            Stat stat = stat();
            Status status = status();
            z2 = stat.policy() != 0 ? false : z2;
            i2 = status.getUid();
            z = z2;
        }
        this.foreground = z;
        this.uid = i2;
    }

    public PackageInfo getPackageInfo(Context context, int i) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(getPackageName(), i);
    }

    public String getPackageName() {
        return this.name.split(":")[0];
    }

    protected AndroidAppProcess(Parcel parcel) {
        super(parcel);
        this.foreground = parcel.readByte() != 0;
        this.uid = parcel.readInt();
    }
}
