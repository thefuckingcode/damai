package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.File;

/* compiled from: TbsUtils */
public class q {
    private static File a;

    public static long a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    public static boolean a(Context context) {
        File tbsFolderDir;
        if (context == null) {
            return false;
        }
        if (a != null) {
            return true;
        }
        try {
            if (context.getApplicationInfo().processName.contains(TbsConfig.APP_WX) && (tbsFolderDir = QbSdk.getTbsFolderDir(context)) != null) {
                if (tbsFolderDir.isDirectory()) {
                    File file = new File(tbsFolderDir, "share");
                    if (!file.isDirectory() && !file.mkdir()) {
                        return false;
                    }
                    a = file;
                    file.setExecutable(true, false);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
