package tb;

import android.content.DialogInterface;
import cn.damai.common.askpermission.IRationale;
import cn.damai.common.askpermission.IRequestExecutor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class xf0 implements IRationale {
    private static transient /* synthetic */ IpChange $ipChange;
    protected boolean a = false;

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ j02 a;

        a(xf0 xf0, j02 j02) {
            this.a = j02;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-609923622")) {
                ipChange.ipc$dispatch("-609923622", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            i92.e(this.a.b());
        }
    }

    /* compiled from: Taobao */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IRequestExecutor a;

        b(xf0 xf0, IRequestExecutor iRequestExecutor) {
            this.a = iRequestExecutor;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "359657401")) {
                ipChange.ipc$dispatch("359657401", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            this.a.cancel();
        }
    }

    public xf0() {
    }

    /* access modifiers changed from: protected */
    public CharSequence a(List<String> list) {
        throw null;
    }

    @Override // cn.damai.common.askpermission.IRationale
    public void showRationale(List<String> list, IRequestExecutor iRequestExecutor, j02 j02) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870010551")) {
            ipChange.ipc$dispatch("870010551", new Object[]{this, list, iRequestExecutor, j02});
        } else if (j02 != null && j02.c()) {
            fp1.a(j02.b(), a(list), list, this.a, new a(this, j02), new b(this, iRequestExecutor));
        }
    }

    public xf0(boolean z) {
        this.a = z;
    }
}
