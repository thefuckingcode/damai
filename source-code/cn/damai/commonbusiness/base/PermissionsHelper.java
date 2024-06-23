package cn.damai.commonbusiness.base;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.f4;

/* compiled from: Taobao */
public class PermissionsHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-552233472")) {
            return ((Boolean) ipChange.ipc$dispatch("-552233472", new Object[]{context})).booleanValue();
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return notificationManager.areNotificationsEnabled();
        }
        if (i < 19) {
            return true;
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i2 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            if (((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void b(final Activity activity, final String str, final String str2, final DialogInterface.OnClickListener onClickListener, final String str3, final DialogInterface.OnClickListener onClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030530753")) {
            ipChange.ipc$dispatch("-1030530753", new Object[]{activity, str, str2, onClickListener, str3, onClickListener2});
        } else if (!TextUtils.isEmpty(str) && activity != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class cn.damai.commonbusiness.base.PermissionsHelper.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1520974559")) {
                        ipChange.ipc$dispatch("1520974559", new Object[]{this});
                        return;
                    }
                    new f4(activity).e(str).h(str2, onClickListener).f(str3, onClickListener2).j();
                }
            });
        }
    }

    public static void c(final Activity activity, final String str, final boolean z, final String str2, final String str3, final DialogInterface.OnClickListener onClickListener, final String str4, final DialogInterface.OnClickListener onClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849116737")) {
            ipChange.ipc$dispatch("-1849116737", new Object[]{activity, str, Boolean.valueOf(z), str2, str3, onClickListener, str4, onClickListener2});
        } else if (!TextUtils.isEmpty(str2) && activity != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class cn.damai.commonbusiness.base.PermissionsHelper.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1324461054")) {
                        ipChange.ipc$dispatch("1324461054", new Object[]{this});
                        return;
                    }
                    new f4(activity).i(str).c(z).e(str2).h(str3, onClickListener).f(str4, onClickListener2).j();
                }
            });
        }
    }
}
