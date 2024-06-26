package com.youku.live.dago.widgetlib.interactive.resource.utils;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;

/* compiled from: Taobao */
public class FileUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean deleteDirectory(String str) {
        File[] listFiles;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860909333")) {
            return ((Boolean) ipChange.ipc$dispatch("1860909333", new Object[]{str})).booleanValue();
        }
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return false;
        }
        boolean z = true;
        for (int i = 0; i < listFiles.length; i++) {
            if (!listFiles[i].isFile()) {
                z = deleteDirectory(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            } else {
                z = deleteFile(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            }
        }
        return z && file.delete();
    }

    public static boolean deleteFile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "310276936")) {
            return ((Boolean) ipChange.ipc$dispatch("310276936", new Object[]{str})).booleanValue();
        }
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return false;
        }
        file.delete();
        return true;
    }

    public static boolean deleteFolder(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "252193622")) {
            return ((Boolean) ipChange.ipc$dispatch("252193622", new Object[]{str})).booleanValue();
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return deleteFile(str);
        }
        return deleteDirectory(str);
    }

    public static String subStringFileName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1828226789")) {
            return (String) ipChange.ipc$dispatch("1828226789", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            if (!str.contains("/")) {
                return str.contains(".") ? str.substring(0, str.lastIndexOf(".")) : str;
            }
            String substring = str.substring(str.lastIndexOf("/") + 1, str.length());
            return substring.contains(".") ? substring.substring(0, substring.lastIndexOf(".")) : substring;
        }
    }
}
