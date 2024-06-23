package tb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import cn.damai.common.app.base.BaseActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class j70 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static j70 d;
    private Dialog a;
    private final List<Dialog> b = new ArrayList();
    private final DialogInterface.OnDismissListener c = new a();

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1129761278")) {
                ipChange.ipc$dispatch("-1129761278", new Object[]{this, dialogInterface});
                return;
            }
            j70.this.b.remove(j70.this.a);
            j70.this.e();
        }
    }

    public static j70 d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1121380015")) {
            return (j70) ipChange.ipc$dispatch("-1121380015", new Object[0]);
        }
        if (d == null) {
            d = new j70();
        }
        return d;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1761799081")) {
            ipChange.ipc$dispatch("1761799081", new Object[]{this});
        } else if (this.b.size() > 0) {
            Dialog dialog = this.b.get(0);
            this.a = dialog;
            if (dialog != null && !dialog.isShowing()) {
                this.a.show();
                this.a.setOnDismissListener(this.c);
            }
        } else {
            this.a = null;
        }
    }

    public void f(BaseActivity baseActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1276995249")) {
            ipChange.ipc$dispatch("1276995249", new Object[]{this, baseActivity});
        } else if (baseActivity.isFinishing()) {
        } else {
            if ((Build.VERSION.SDK_INT < 17 || !baseActivity.isDestroyed()) && baseActivity.isActivityForeground()) {
                try {
                    e();
                } catch (Exception e) {
                    g91.c("DialogHelper", e.getMessage());
                }
            }
        }
    }
}
