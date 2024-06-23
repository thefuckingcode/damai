package tb;

import android.app.ActivityManager;
import android.content.Context;
import com.efs.sdk.base.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public final class g63 {
    public static String a;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050 A[SYNTHETIC, Splitter:B:20:0x0050] */
    public static String a(int i) {
        Throwable th;
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i + "/cmdline")));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader2.read();
                    if (read > 0) {
                        sb.append((char) read);
                    } else {
                        sb.trimToSize();
                        String sb2 = sb.toString();
                        try {
                            bufferedReader2.close();
                            return sb2;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return sb2;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
                try {
                    t43.c(Constants.TAG, "get process name error", th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    return "";
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        } catch (Throwable th6) {
            th = th6;
            t43.c(Constants.TAG, "get process name error", th);
            if (bufferedReader != null) {
            }
            return "";
        }
        throw th;
    }

    public static boolean b(Context context, String str) {
        try {
            int intValue = Integer.valueOf(str).intValue();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == intValue) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            t43.c(Constants.TAG, "Process exist judge error", th);
            return true;
        }
    }
}
