package tb;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import cn.damai.common.askpermission.IPermissionRequest;
import cn.damai.common.askpermission.MRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class j02 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static class a extends j02 {
        private static transient /* synthetic */ IpChange $ipChange;
        private final Activity a;

        a(@NonNull Activity activity) {
            this.a = activity;
        }

        @Override // tb.j02
        public Activity b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1928534671")) {
                return this.a;
            }
            return (Activity) ipChange.ipc$dispatch("-1928534671", new Object[]{this});
        }

        @Override // tb.j02
        public boolean d(String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2082610416")) {
                return ActivityCompat.shouldShowRequestPermissionRationale(this.a, str);
            }
            return ((Boolean) ipChange.ipc$dispatch("-2082610416", new Object[]{this, str})).booleanValue();
        }
    }

    public final IPermissionRequest a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1911288798")) {
            return (IPermissionRequest) ipChange.ipc$dispatch("1911288798", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            return new MRequest(this);
        } else {
            return new m61(this);
        }
    }

    @Nullable
    public abstract Activity b();

    public boolean c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572226860")) {
            return ((Boolean) ipChange.ipc$dispatch("-1572226860", new Object[]{this})).booleanValue();
        }
        Activity b = b();
        if (b == null || b.isFinishing()) {
            return false;
        }
        return true;
    }

    public abstract boolean d(String str);
}
