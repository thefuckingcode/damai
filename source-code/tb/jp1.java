package tb;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import kotlin.text.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class jp1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CODE_SETTING_REQUEST = 2168;
    private static final String a;

    static {
        String manufacturer = Build.getMANUFACTURER();
        k21.h(manufacturer, "Build.MANUFACTURER");
        Objects.requireNonNull(manufacturer, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = manufacturer.toLowerCase();
        k21.h(lowerCase, "(this as java.lang.String).toLowerCase()");
        a = lowerCase;
    }

    private static final Intent a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634408381")) {
            return (Intent) ipChange.ipc$dispatch("-1634408381", new Object[]{context});
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    @NotNull
    public static final String b(@NotNull String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365730473")) {
            return (String) ipChange.ipc$dispatch("-1365730473", new Object[]{str});
        }
        k21.i(str, "propName");
        BufferedReader bufferedReader = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec("getprop " + str);
            k21.h(exec, "p");
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                str2 = bufferedReader2.readLine();
                k21.h(str2, "input.readLine()");
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                bufferedReader = bufferedReader2;
                str2 = "";
                if (bufferedReader != null) {
                }
                return str2;
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
            str2 = "";
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return str2;
        }
        return str2;
    }

    private static final Intent c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-87480975")) {
            return (Intent) ipChange.ipc$dispatch("-87480975", new Object[]{context});
        } else if (Build.VERSION.SDK_INT >= 23) {
            return a(context);
        } else {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            return intent;
        }
    }

    private static final Intent d(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-722272370")) {
            return (Intent) ipChange.ipc$dispatch("-722272370", new Object[]{context});
        } else if (Build.VERSION.SDK_INT >= 24) {
            return a(context);
        } else {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
            return intent;
        }
    }

    public static final boolean e(@NotNull String[] strArr, @NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340114095")) {
            return ((Boolean) ipChange.ipc$dispatch("-1340114095", new Object[]{strArr, context})).booleanValue();
        }
        k21.i(strArr, "permissions");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (k21.d(strArr[0], "")) {
            return false;
        }
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return true;
            }
        }
        return false;
    }

    public static final void f(@Nullable Activity activity) {
        Intent intent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222841354")) {
            ipChange.ipc$dispatch("1222841354", new Object[]{activity});
        } else if (activity != null) {
            String str = a;
            if (g.Q(str, "huawei", false, 2, null)) {
                intent = c(activity);
            } else if (g.Q(str, "xiaomi", false, 2, null)) {
                intent = g(activity);
            } else if (g.Q(str, "oppo", false, 2, null)) {
                intent = a(activity);
            } else if (g.Q(str, "vivo", false, 2, null)) {
                intent = a(activity);
            } else if (g.Q(str, "meizu", false, 2, null)) {
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

    private static final Intent g(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1871876421")) {
            return (Intent) ipChange.ipc$dispatch("1871876421", new Object[]{context});
        }
        String b = b("ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(b) && !g.Q(b, "7", false, 2, null) && !g.Q(b, "8", false, 2, null)) {
            return a(context);
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        return intent;
    }
}
