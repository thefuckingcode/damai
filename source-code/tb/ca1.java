package tb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.event.Subject;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ca1 {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        private final Intent a(Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "357013598")) {
                return (Intent) ipChange.ipc$dispatch("357013598", new Object[]{this, context});
            }
            Intent intent = new Intent();
            intent.putExtra(LoginManager.ACTION_DO_LOGIN, 0);
            intent.setClassName(context, "cn.damai.login.havana.LoginActivity");
            return intent;
        }

        public final void b(@NotNull Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-618596099")) {
                ipChange.ipc$dispatch("-618596099", new Object[]{this, context});
                return;
            }
            k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
            context.startActivity(ca1.Companion.a(context));
        }

        public final void c(@NotNull Activity activity, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1794559800")) {
                ipChange.ipc$dispatch("1794559800", new Object[]{this, activity, Integer.valueOf(i)});
                return;
            }
            k21.i(activity, WPKFactory.INIT_KEY_CONTEXT);
            activity.startActivityForResult(ca1.Companion.a(activity), i);
        }

        public final void d(@NotNull Fragment fragment, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1812537746")) {
                ipChange.ipc$dispatch("1812537746", new Object[]{this, fragment, Integer.valueOf(i)});
                return;
            }
            k21.i(fragment, Subject.FRAGMENT);
            Context context = fragment.getContext();
            if (context != null) {
                fragment.startActivityForResult(ca1.Companion.a(context), i);
            }
        }
    }
}
