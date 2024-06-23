package tb;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public final class at1 {
    private static String a;

    public static String a() {
        Context a2 = us1.d().a();
        if (TextUtils.isEmpty(a)) {
            String c = c();
            if (TextUtils.isEmpty(c) && a2 != null) {
                c = b(a2);
            }
            a = c;
        }
        return a;
    }

    private static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        String str = a;
        if (str != null) {
            return str;
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (true) {
            if (it.hasNext()) {
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next != null && next.pid == myPid) {
                    a = next.processName;
                    break;
                }
            } else {
                break;
            }
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037 A[SYNTHETIC, Splitter:B:13:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A[SYNTHETIC, Splitter:B:20:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    private static String c() {
        int i;
        FileInputStream fileInputStream;
        Throwable th;
        byte[] bArr = new byte[1024];
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream("/proc/" + Process.myPid() + "/cmdline");
            try {
                i = fileInputStream.read(bArr);
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                if (fileInputStream != null) {
                }
                i = 0;
                if (i > 0) {
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused4) {
                }
            }
            i = 0;
            if (i > 0) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
        if (i > 0) {
            return new String(bArr, 0, i).trim();
        }
        return null;
    }
}
