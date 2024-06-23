package tb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.tlog.protocol.Constants;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.uplayer.AliMediaPlayer;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class tm2 extends Handler {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final b Companion = new b(null);
    @Nullable
    private static WeakReference<Activity> d;
    @NotNull
    private final Toast a;
    @NotNull
    private final String b;
    private boolean c;

    /* compiled from: Taobao */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ tm2 a;

        a(tm2 tm2) {
            this.a = tm2;
        }

        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2018302424")) {
                ipChange.ipc$dispatch("2018302424", new Object[]{this, activity, bundle});
                return;
            }
            k21.i(activity, "activity");
            Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED);
        }

        public void onActivityDestroyed(@NotNull Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-258846677")) {
                ipChange.ipc$dispatch("-258846677", new Object[]{this, activity});
                return;
            }
            k21.i(activity, "activity");
            Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED);
        }

        public void onActivityPaused(@NotNull Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1412545124")) {
                ipChange.ipc$dispatch("-1412545124", new Object[]{this, activity});
                return;
            }
            k21.i(activity, "activity");
            try {
                Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED);
                this.a.c();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void onActivityResumed(@NotNull Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1227727507")) {
                ipChange.ipc$dispatch("-1227727507", new Object[]{this, activity});
                return;
            }
            k21.i(activity, "activity");
            try {
                Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1616503599")) {
                ipChange.ipc$dispatch("1616503599", new Object[]{this, activity, bundle});
                return;
            }
            k21.i(activity, "activity");
            k21.i(bundle, "outState");
        }

        public void onActivityStarted(@NotNull Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2041983485")) {
                ipChange.ipc$dispatch("-2041983485", new Object[]{this, activity});
                return;
            }
            k21.i(activity, "activity");
            b bVar = tm2.Companion;
            tm2.d = new WeakReference(activity);
        }

        public void onActivityStopped(@NotNull Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2044152375")) {
                ipChange.ipc$dispatch("2044152375", new Object[]{this, activity});
                return;
            }
            k21.i(activity, "activity");
            Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STOPPED);
            if (activity == tm2.Companion.a()) {
                tm2.d = null;
            }
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private static transient /* synthetic */ IpChange $ipChange;

        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }

        @Nullable
        public final Activity a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1512025589")) {
                return (Activity) ipChange.ipc$dispatch("1512025589", new Object[]{this});
            } else if (tm2.d == null) {
                return null;
            } else {
                WeakReference weakReference = tm2.d;
                k21.f(weakReference);
                return (Activity) weakReference.get();
            }
        }

        @NotNull
        public final WindowManager b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1096362984")) {
                return (WindowManager) ipChange.ipc$dispatch("-1096362984", new Object[]{this});
            } else if (a() != null) {
                Activity a = a();
                k21.f(a);
                Object systemService = a.getSystemService(v.ATTACH_MODE_WINDOW);
                k21.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                return (WindowManager) systemService;
            } else {
                Object systemService2 = AppInfoProviderProxy.getApplication().getSystemService(v.ATTACH_MODE_WINDOW);
                k21.g(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
                return (WindowManager) systemService2;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tm2(@NotNull Toast toast, @NotNull Application application) {
        super(Looper.getMainLooper());
        k21.i(toast, "mToast");
        k21.i(application, "application");
        this.a = toast;
        String packageName = application.getPackageName();
        k21.h(packageName, "application.packageName");
        this.b = packageName;
        application.registerActivityLifecycleCallbacks(new a(this));
    }

    public final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-629587041")) {
            ipChange.ipc$dispatch("-629587041", new Object[]{this});
            return;
        }
        removeMessages(0);
        if (this.c) {
            try {
                Companion.b().removeView(this.a.getView());
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
            this.c = false;
        }
    }

    public final void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-798716612")) {
            ipChange.ipc$dispatch("-798716612", new Object[]{this});
        } else if (!this.c) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = 16973828;
            layoutParams.setTitle("Toast");
            layoutParams.flags = AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR;
            layoutParams.packageName = this.b;
            layoutParams.gravity = this.a.getGravity();
            layoutParams.x = this.a.getXOffset();
            layoutParams.y = this.a.getYOffset();
            try {
                Companion.b().addView(this.a.getView(), layoutParams);
                this.c = true;
                sendEmptyMessageDelayed(0, ((Long) (this.a.getDuration() == 1 ? 3500 : 2000L)).longValue());
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            } catch (WindowManager.BadTokenException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void handleMessage(@NotNull Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1126097595")) {
            ipChange.ipc$dispatch("-1126097595", new Object[]{this, message});
            return;
        }
        k21.i(message, "msg");
        c();
    }
}
