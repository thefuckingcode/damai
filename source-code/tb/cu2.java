package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
public class cu2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String a = f(cu2.class);

    public static File a(Context context, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1537301454")) {
            return (File) ipChange.ipc$dispatch("1537301454", new Object[]{context, str});
        }
        if (d()) {
            str2 = context.getExternalCacheDir() + File.separator + str;
        } else {
            str2 = context.getCacheDir().getPath() + File.separator + str;
        }
        File file = new File(str2);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            Log.i(a, str2 + " has created. " + mkdirs);
        }
        return file;
    }

    public static void b(File file, boolean z) {
        File[] listFiles;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1617034660")) {
            ipChange.ipc$dispatch("-1617034660", new Object[]{file, Boolean.valueOf(z)});
        } else if (file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    b(file2, true);
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    public static long c(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1812929152")) {
            return ((Long) ipChange.ipc$dispatch("1812929152", new Object[]{file})).longValue();
        }
        long j = 0;
        if (!file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return 0 + file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            j += c(file2);
        }
        return j;
    }

    public static boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824846481")) {
            return ((Boolean) ipChange.ipc$dispatch("1824846481", new Object[0])).booleanValue();
        }
        boolean i = hp1.i(lp1.STORAGE);
        if (!Environment.getExternalStorageState().equals("mounted") || !i) {
            return false;
        }
        return true;
    }

    public static boolean e(File file, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "841326597")) {
            return new File(file, str).exists();
        }
        return ((Boolean) ipChange.ipc$dispatch("841326597", new Object[]{file, str})).booleanValue();
    }

    public static String f(Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-532380543")) {
            return cls.getSimpleName();
        }
        return (String) ipChange.ipc$dispatch("-532380543", new Object[]{cls});
    }

    public static void g(File file, String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-556969133")) {
            ipChange.ipc$dispatch("-556969133", new Object[]{file, str, bitmap});
        } else if (bitmap != null) {
            File file2 = new File(file, str);
            try {
                file2.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
