package tb;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class sv2 {
    private static transient /* synthetic */ IpChange $ipChange;

    @TargetApi(16)
    /* compiled from: Taobao */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;

        public static void a(View view, Runnable runnable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1095458876")) {
                ipChange.ipc$dispatch("-1095458876", new Object[]{view, runnable});
                return;
            }
            view.postOnAnimation(runnable);
        }

        public static void b(View view, Drawable drawable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1732409035")) {
                ipChange.ipc$dispatch("-1732409035", new Object[]{view, drawable});
                return;
            }
            view.setBackground(drawable);
        }
    }

    public static void a(View view, Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-761765911")) {
            ipChange.ipc$dispatch("-761765911", new Object[]{view, runnable});
        } else if (Build.VERSION.SDK_INT >= 16) {
            a.a(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    public static void b(View view, Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "801612954")) {
            ipChange.ipc$dispatch("801612954", new Object[]{view, drawable});
        } else if (Build.VERSION.SDK_INT >= 16) {
            a.b(view, drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
