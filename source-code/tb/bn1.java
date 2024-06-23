package tb;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.alibaba.pictures.responsive.page.orientation.OrientationListener;
import com.alibaba.pictures.responsive.state.ResponsivePageStateCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class bn1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Activity a;
    @Nullable
    private OrientationListener b;
    @NotNull
    private final Handler c;
    @NotNull
    private final ContentObserver d;
    @NotNull
    private OrientationListener.OrientationChangeCallback e = new a(this);

    /* compiled from: Taobao */
    public static final class a implements OrientationListener.OrientationChangeCallback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ bn1 a;

        a(bn1 bn1) {
            this.a = bn1;
        }

        @Override // com.alibaba.pictures.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void land() {
            int requestedOrientation;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1867383514")) {
                ipChange.ipc$dispatch("1867383514", new Object[]{this});
            } else if (this.a.f() || (requestedOrientation = this.a.a.getRequestedOrientation()) == 0) {
            } else {
                if (requestedOrientation == 6 || requestedOrientation == 8) {
                    dn1.INSTANCE.b(this.a.a, 0);
                    return;
                }
                bn1 bn1 = this.a;
                if (bn1.e(bn1.a)) {
                    dn1.INSTANCE.b(this.a.a, 0);
                }
            }
        }

        @Override // com.alibaba.pictures.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void port() {
            int requestedOrientation;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1527409796")) {
                ipChange.ipc$dispatch("1527409796", new Object[]{this});
                return;
            }
            try {
                if (this.a.f() || (requestedOrientation = this.a.a.getRequestedOrientation()) == 1) {
                    return;
                }
                if (requestedOrientation == 9) {
                    dn1.INSTANCE.b(this.a.a, 1);
                    return;
                }
                bn1 bn1 = this.a;
                if (bn1.e(bn1.a)) {
                    dn1.INSTANCE.b(this.a.a, 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.alibaba.pictures.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void reverseLand() {
            int requestedOrientation;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1544348984")) {
                ipChange.ipc$dispatch("1544348984", new Object[]{this});
            } else if (this.a.f() || (requestedOrientation = this.a.a.getRequestedOrientation()) == 8) {
            } else {
                if (requestedOrientation == 0 || requestedOrientation == 6) {
                    dn1.INSTANCE.b(this.a.a, 8);
                    return;
                }
                bn1 bn1 = this.a;
                if (bn1.e(bn1.a)) {
                    dn1.INSTANCE.b(this.a.a, 8);
                }
            }
        }

        @Override // com.alibaba.pictures.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void reversePort() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1204375266")) {
                ipChange.ipc$dispatch("1204375266", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    public static final class b extends ContentObserver {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ bn1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(bn1 bn1, Handler handler) {
            super(handler);
            this.a = bn1;
        }

        public boolean deliverSelfNotifications() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1620134387")) {
                return true;
            }
            return ((Boolean) ipChange.ipc$dispatch("-1620134387", new Object[]{this})).booleanValue();
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
        public void onChange(boolean z) {
            OrientationListener orientationListener;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-478515197")) {
                ipChange.ipc$dispatch("-478515197", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            super.onChange(z);
            if (!this.a.a.isFinishing()) {
                int requestedOrientation = this.a.a.getRequestedOrientation();
                int i = 1001;
                if (requestedOrientation != 0) {
                    if (requestedOrientation != 1) {
                        switch (requestedOrientation) {
                            case 8:
                                i = 1003;
                                break;
                            case 9:
                                i = 1004;
                                break;
                        }
                    }
                    orientationListener = this.a.b;
                    if (orientationListener == null) {
                        orientationListener.c(i);
                        return;
                    }
                    return;
                }
                i = 1002;
                orientationListener = this.a.b;
                if (orientationListener == null) {
                }
            }
        }
    }

    public bn1(@NotNull Activity activity) {
        k21.i(activity, "activity");
        this.a = activity;
        Handler handler = new Handler();
        this.c = handler;
        b bVar = new b(this, handler);
        this.d = bVar;
        OrientationListener orientationListener = new OrientationListener(activity, this.e);
        orientationListener.b();
        ur2 ur2 = ur2.INSTANCE;
        this.b = orientationListener;
        activity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, bVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1876527605")) {
            return ((Boolean) ipChange.ipc$dispatch("-1876527605", new Object[]{this, context})).booleanValue();
        }
        try {
            if (Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139469807")) {
            return ((Boolean) ipChange.ipc$dispatch("139469807", new Object[]{this})).booleanValue();
        }
        int d2 = ResponsivePageStateCache.Companion.a().d(this.a);
        if (!e70.g(this.a) || d2 > bd2.b()) {
            return false;
        }
        return true;
    }

    public final void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055250616")) {
            ipChange.ipc$dispatch("1055250616", new Object[]{this});
            return;
        }
        OrientationListener orientationListener = this.b;
        if (orientationListener != null) {
            orientationListener.a();
        }
        this.c.removeCallbacksAndMessages(null);
        this.a.getContentResolver().unregisterContentObserver(this.d);
    }
}
