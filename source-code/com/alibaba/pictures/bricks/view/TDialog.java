package com.alibaba.pictures.bricks.view;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Timer;
import java.util.TimerTask;
import tb.d3;
import tb.f3;

/* compiled from: Taobao */
public class TDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnDialogShowTimeListener a;
    public long b;
    public long c;
    private Application d;
    private Activity e;
    private boolean f = false;
    private d3 g = new a();

    /* compiled from: Taobao */
    public interface OnDialogShowTimeListener {
        void exposureTime(long j);
    }

    /* compiled from: Taobao */
    public class a extends d3 {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // tb.d3
        public boolean a(Activity activity) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1023780606")) {
                return TDialog.this.e != null && TDialog.this.e == activity;
            }
            return ((Boolean) ipChange.ipc$dispatch("1023780606", new Object[]{this, activity})).booleanValue();
        }

        @Override // tb.d3
        public void onActivityPaused(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1819778958")) {
                ipChange.ipc$dispatch("1819778958", new Object[]{this, activity});
            } else if (TDialog.this.f) {
                TDialog.this.c = System.currentTimeMillis();
                TDialog.this.d();
            }
        }

        @Override // tb.d3
        public void onActivityResumed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "190071227")) {
                ipChange.ipc$dispatch("190071227", new Object[]{this, activity});
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
        if (AndroidInstantRuntime.support(ipChange, "2059453450")) {
            ipChange.ipc$dispatch("2059453450", new Object[]{this});
            return;
        }
        OnDialogShowTimeListener onDialogShowTimeListener = this.a;
        if (onDialogShowTimeListener != null) {
            onDialogShowTimeListener.exposureTime(this.c - this.b);
        }
    }

    private void e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1928860217")) {
            ipChange.ipc$dispatch("1928860217", new Object[]{this, context});
        } else if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.e = activity;
            Application application = activity.getApplication();
            this.d = application;
            if (application != null) {
                f3.d(application).b(this.g);
            }
        }
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-55692316")) {
            ipChange.ipc$dispatch("-55692316", new Object[]{this});
            return;
        }
        Application application = this.d;
        if (application != null && this.g != null) {
            f3.d(application).e(this.g);
        }
    }

    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1594210325")) {
            ipChange.ipc$dispatch("1594210325", new Object[]{this});
            return;
        }
        this.f = false;
        this.c = System.currentTimeMillis();
        super.dismiss();
        d();
        f();
    }

    public void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "159543224")) {
            ipChange.ipc$dispatch("159543224", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            /* class com.alibaba.pictures.bricks.view.TDialog.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2074742054")) {
                    ipChange.ipc$dispatch("2074742054", new Object[]{this});
                    return;
                }
                TDialog.this.dismiss();
                timer.cancel();
            }
        }, (long) (i * 1000));
    }

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308486711")) {
            ipChange.ipc$dispatch("-1308486711", new Object[]{this});
            return;
        }
        this.f = false;
        super.hide();
        d();
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-153814994")) {
            ipChange.ipc$dispatch("-153814994", new Object[]{this});
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
