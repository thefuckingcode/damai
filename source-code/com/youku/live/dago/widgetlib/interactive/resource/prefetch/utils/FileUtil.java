package com.youku.live.dago.widgetlib.interactive.resource.prefetch.utils;

import android.os.Build;
import android.os.Environment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
public class FileUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void deleteDir(File file) {
        File[] listFiles;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235981919")) {
            ipChange.ipc$dispatch("-1235981919", new Object[]{file});
        } else if (file != null && file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteDir(file);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public String getStorageState(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743857591")) {
            return (String) ipChange.ipc$dispatch("-743857591", new Object[]{this, file});
        } else if (Build.VERSION.SDK_INT >= 19) {
            return Environment.getStorageState(file);
        } else {
            try {
                if (file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath())) {
                    return Environment.getExternalStorageState();
                }
                return "unknown";
            } catch (IOException e) {
                e.printStackTrace();
                return "unknown";
            }
        }
    }

    public String getStorageState(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1289925206")) {
            return getStorageState(new File(str));
        }
        return (String) ipChange.ipc$dispatch("1289925206", new Object[]{this, str});
    }
}
