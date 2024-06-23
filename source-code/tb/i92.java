package tb;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class i92 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CODE_SETTING_REQUEST = 2168;
    private static final String a = Build.getMANUFACTURER().toLowerCase();

    private static Intent a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1757444371")) {
            return (Intent) ipChange.ipc$dispatch("-1757444371", new Object[]{context});
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054 A[SYNTHETIC, Splitter:B:20:0x0054] */
    public static String b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465777791")) {
            return (String) ipChange.ipc$dispatch("-1465777791", new Object[]{str});
        }
        BufferedReader bufferedReader = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(runtime.exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader2.readLine();
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (IOException unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                }
                return "";
            } catch (Throwable th) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused5) {
                }
            }
            return "";
        }
    }

    private static Intent c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "878381447")) {
            return (Intent) ipChange.ipc$dispatch("878381447", new Object[]{context});
        } else if (Build.VERSION.SDK_INT >= 23) {
            return a(context);
        } else {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            return intent;
        }
    }

    private static Intent d(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109999800")) {
            return (Intent) ipChange.ipc$dispatch("1109999800", new Object[]{context});
        } else if (Build.VERSION.SDK_INT >= 24) {
            return a(context);
        } else {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
            return intent;
        }
    }

    public static void e(Activity activity) {
        Intent intent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1147939764")) {
            ipChange.ipc$dispatch("1147939764", new Object[]{activity});
        } else if (activity != null) {
            String str = a;
            if (str.contains("huawei")) {
                intent = c(activity);
            } else if (str.contains("xiaomi")) {
                intent = f(activity);
            } else if (str.contains("oppo")) {
                intent = a(activity);
            } else if (str.contains("vivo")) {
                intent = a(activity);
            } else if (str.contains("meizu")) {
                intent = d(activity);
            } else {
                intent = a(activity);
            }
            try {
                activity.startActivityForResult(intent, 2168);
            } catch (Exception unused) {
                try {
                    activity.startActivityForResult(a(activity), 2168);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Intent f(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1457228453")) {
            return (Intent) ipChange.ipc$dispatch("-1457228453", new Object[]{context});
        }
        String b = b("ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(b) && !b.contains("7") && !b.contains("8")) {
            return a(context);
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        return intent;
    }
}
