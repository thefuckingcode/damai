package tb;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;
import cn.damai.common.askpermission.IPermissionAction;
import cn.damai.common.askpermission.OnGrantListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
public class hp1 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements IPermissionAction {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnGrantListener a;

        a(OnGrantListener onGrantListener) {
            this.a = onGrantListener;
        }

        @Override // cn.damai.common.askpermission.IPermissionAction
        public void onCall(j02 j02, List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-975672238")) {
                ipChange.ipc$dispatch("-975672238", new Object[]{this, j02, list});
                return;
            }
            OnGrantListener onGrantListener = this.a;
            if (onGrantListener != null) {
                onGrantListener.onGranted();
            }
        }
    }

    /* compiled from: Taobao */
    public class b extends nt0 {
        private static transient /* synthetic */ IpChange $ipChange;

        b(boolean z, String str) {
            super(z);
        }
    }

    /* compiled from: Taobao */
    public class c extends xf0 {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(boolean z, String str) {
            super(z);
            this.b = str;
        }

        /* access modifiers changed from: protected */
        @Override // tb.xf0
        public CharSequence a(List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2111731798")) {
                return (CharSequence) ipChange.ipc$dispatch("-2111731798", new Object[]{this, list});
            }
            return String.format("%1$s%2$s", hp1.e(list), this.b);
        }
    }

    public static void a(Activity activity, boolean z, String str, String str2, OnGrantListener onGrantListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "568421142")) {
            ipChange.ipc$dispatch("568421142", new Object[]{activity, Boolean.valueOf(z), str, str2, onGrantListener});
            return;
        }
        try {
            b(activity, z, new String[]{str}, str2, onGrantListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(Activity activity, boolean z, String[] strArr, String str, OnGrantListener onGrantListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584788275")) {
            ipChange.ipc$dispatch("-584788275", new Object[]{activity, Boolean.valueOf(z), strArr, str, onGrantListener});
            return;
        }
        try {
            b8.a(activity).a().permission(strArr).showRationale(new c(z, str)).onDenied(new b(z, str)).onGranted(new a(onGrantListener)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void c(Fragment fragment, boolean z, String[] strArr, String str, OnGrantListener onGrantListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482396697")) {
            ipChange.ipc$dispatch("-1482396697", new Object[]{fragment, Boolean.valueOf(z), strArr, str, onGrantListener});
            return;
        }
        try {
            b(fragment.getActivity(), z, strArr, str, onGrantListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String d(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-509640683")) {
            return (String) ipChange.ipc$dispatch("-509640683", new Object[]{list});
        }
        String[] b2 = lp1.b(list);
        StringBuilder sb = new StringBuilder();
        sb.append("授权获取");
        for (String str : b2) {
            sb.append(str);
            sb.append("、");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("权限，以便使用相关产品功能");
        return sb.toString();
    }

    public static String e(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744837753")) {
            return (String) ipChange.ipc$dispatch("-744837753", new Object[]{list});
        }
        String[] b2 = lp1.b(list);
        StringBuilder sb = new StringBuilder();
        sb.append("授权获取");
        for (String str : b2) {
            sb.append(str);
            sb.append("、");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("权限，");
        return sb.toString();
    }

    public static boolean f(Context context, List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "576803634")) {
            return ((Boolean) ipChange.ipc$dispatch("576803634", new Object[]{context, list})).booleanValue();
        } else if (Build.VERSION.SDK_INT < 23) {
            return true;
        } else {
            AppOpsManager appOpsManager = null;
            for (String str : list) {
                int checkSelfPermission = PermissionChecker.checkSelfPermission(context, str);
                if (checkSelfPermission == -1) {
                    return false;
                }
                String permissionToOp = AppOpsManager.permissionToOp(str);
                if (!TextUtils.isEmpty(permissionToOp)) {
                    if (appOpsManager == null) {
                        appOpsManager = (AppOpsManager) context.getSystemService("appops");
                    }
                    if (appOpsManager != null) {
                        checkSelfPermission = appOpsManager.checkOpNoThrow(permissionToOp, Process.myUid(), context.getPackageName());
                    }
                    if (!(checkSelfPermission == 0 || checkSelfPermission == 4)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static boolean g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "65781497")) {
            return ((Boolean) ipChange.ipc$dispatch("65781497", new Object[]{str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            return i(new String[]{str});
        }
    }

    public static boolean h(List<String> list) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1350463712")) {
            return f(xs0.a(), list);
        }
        return ((Boolean) ipChange.ipc$dispatch("1350463712", new Object[]{list})).booleanValue();
    }

    public static boolean i(String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-65317544")) {
            return ((Boolean) ipChange.ipc$dispatch("-65317544", new Object[]{strArr})).booleanValue();
        } else if (strArr != null) {
            return h(Arrays.asList(strArr));
        } else {
            return false;
        }
    }
}
