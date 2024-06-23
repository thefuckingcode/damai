package cn.damai.uikit.util;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Timer;
import java.util.TimerTask;
import tb.e3;
import tb.g3;

/* compiled from: Taobao */
public class TDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnDialogShowTimeListener a;
    public long b;
    public long c;
    private Application d;
    private Activity e;
    private boolean f = false;
    private e3 g = new a();

    /* compiled from: Taobao */
    public interface OnDialogShowTimeListener {
        void exposureTime(long j);
    }

    /* compiled from: Taobao */
    public class a extends e3 {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // tb.e3
        public boolean a(Activity activity) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-247403979")) {
                return TDialog.this.e != null && TDialog.this.e == activity;
            }
            return ((Boolean) ipChange.ipc$dispatch("-247403979", new Object[]{this, activity})).booleanValue();
        }

        @Override // tb.e3
        public void onActivityPaused(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "974323639")) {
                ipChange.ipc$dispatch("974323639", new Object[]{this, activity});
            } else if (TDialog.this.f) {
                TDialog.this.c = System.currentTimeMillis();
                TDialog.this.d();
            }
        }

        @Override // tb.e3
        public void onActivityResumed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-249239886")) {
                ipChange.ipc$dispatch("-249239886", new Object[]{this, activity});
            } else if (TDialog.this.f) {
                TDialog.this.b = System.currentTimeMillis();
            }
        }
    }

    public TDialog(@NonNull Context context) {
        super(context);
        e(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185886413")) {
            ipChange.ipc$dispatch("-1185886413", new Object[]{this});
            return;
        }
        OnDialogShowTimeListener onDialogShowTimeListener = this.a;
        if (onDialogShowTimeListener != null) {
            onDialogShowTimeListener.exposureTime(this.c - this.b);
        }
    }

    private void e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1488113680")) {
            ipChange.ipc$dispatch("-1488113680", new Object[]{this, context});
        } else if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.e = activity;
            Application application = activity.getApplication();
            this.d = application;
            if (application != null) {
                g3.d(application).b(this.g);
            }
        }
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1823046733")) {
            ipChange.ipc$dispatch("1823046733", new Object[]{this});
            return;
        }
        Application application = this.d;
        if (application != null && this.g != null) {
            g3.d(application).e(this.g);
        }
    }

    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687565620")) {
            ipChange.ipc$dispatch("-1687565620", new Object[]{this});
            return;
        }
        this.f = false;
        this.c = System.currentTimeMillis();
        super.dismiss();
        d();
        f();
    }

    public void g(OnDialogShowTimeListener onDialogShowTimeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-692575178")) {
            ipChange.ipc$dispatch("-692575178", new Object[]{this, onDialogShowTimeListener});
            return;
        }
        this.a = onDialogShowTimeListener;
    }

    public void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805999407")) {
            ipChange.ipc$dispatch("1805999407", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            /* class cn.damai.uikit.util.TDialog.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1418813853")) {
                    ipChange.ipc$dispatch("1418813853", new Object[]{this});
                    return;
                }
                TDialog.this.dismiss();
                timer.cancel();
            }
        }, (long) (i * 1000));
    }

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2134037618")) {
            ipChange.ipc$dispatch("2134037618", new Object[]{this});
            return;
        }
        this.f = false;
        super.hide();
        d();
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006257961")) {
            ipChange.ipc$dispatch("-1006257961", new Object[]{this});
            return;
        }
        this.f = true;
        this.b = System.currentTimeMillis();
        super.show();
    }

    public TDialog(@NonNull Context context, int i) {
        super(context, i);
        e(context);
    }
}
