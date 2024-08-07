package tb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import cn.damai.uikit.view.DMThemeDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.update.adapter.UIConfirm;
import com.taobao.update.adapter.UserAction;

/* compiled from: Taobao */
public class np2 implements UIConfirm {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static DMThemeDialog a = null;
    private static boolean b = true;
    public static boolean c;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ UserAction a;

        a(np2 np2, UserAction userAction) {
            this.a = userAction;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1674201534")) {
                ipChange.ipc$dispatch("-1674201534", new Object[]{this, view});
                return;
            }
            try {
                this.a.onCancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ UserAction b;

        b(np2 np2, String str, UserAction userAction) {
            this.a = str;
            this.b = userAction;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-618037300")) {
                ipChange.ipc$dispatch("-618037300", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else if (!"立即安装".equals(this.a)) {
                this.b.onConfirm();
            } else if (np2.a()) {
                try {
                    this.b.onConfirm();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dialogInterface.dismiss();
            } else {
                np2.c(xs0.a());
                np2.c = true;
                this.b.onCancel();
            }
        }
    }

    public static boolean a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-402835662")) {
            return ((Boolean) ipChange.ipc$dispatch("-402835662", new Object[0])).booleanValue();
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return xs0.a().getPackageManager().canRequestPackageInstalls();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private void b(Context context, String str, UserAction userAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "90955822")) {
            ipChange.ipc$dispatch("90955822", new Object[]{this, context, str, userAction});
        } else if (!b) {
            b = true;
        } else {
            if (!TextUtils.isEmpty(userAction.getCancelText())) {
                userAction.getCancelText();
            }
            String confirmText = !TextUtils.isEmpty(userAction.getConfirmText()) ? userAction.getConfirmText() : "马上升级";
            DMThemeDialog dMThemeDialog = new DMThemeDialog(context);
            a = dMThemeDialog;
            dMThemeDialog.o("升级提示").k(str).r(DMThemeDialog.DMDialogTheme.THEME_SYS_UPDATE).i(confirmText, new b(this, confirmText, userAction)).g(true, new a(this, userAction)).f(false).l(3).show();
        }
    }

    public static boolean c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "703067101")) {
            return ((Boolean) ipChange.ipc$dispatch("703067101", new Object[]{context})).booleanValue();
        } else if (Build.VERSION.SDK_INT < 26) {
            return false;
        } else {
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        }
    }

    @Override // com.taobao.update.adapter.UIConfirm
    public void alertForConfirm(String str, UserAction userAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790798328")) {
            ipChange.ipc$dispatch("790798328", new Object[]{this, str, userAction});
            return;
        }
        try {
            b(j3.getInstance().peekTopActivity(), !xf2.j(str) ? str.replace("淘宝", "大麦") : "", userAction);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
