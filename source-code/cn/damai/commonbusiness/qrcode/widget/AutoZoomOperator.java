package cn.damai.commonbusiness.qrcode.widget;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import cn.damai.commonbusiness.qrcode.QRCodeActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AutoZoomOperator {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Handler c = new Handler(Looper.getMainLooper());
    private volatile boolean a;
    private QRCodeActivity b;

    public AutoZoomOperator(QRCodeActivity qRCodeActivity) {
        this.b = qRCodeActivity;
    }

    private void d(final int i, final int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-976228941")) {
            ipChange.ipc$dispatch("-976228941", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        c.postDelayed(new Runnable() {
            /* class cn.damai.commonbusiness.qrcode.widget.AutoZoomOperator.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "746544324")) {
                    ipChange.ipc$dispatch("746544324", new Object[]{this});
                    return;
                }
                int i = i;
                if (i < 10) {
                    AutoZoomOperator autoZoomOperator = AutoZoomOperator.this;
                    int i2 = i2;
                    autoZoomOperator.e(((int) ((((float) i2) * 1.0f) / 10.0f)) * (i + 1), i, i2);
                    return;
                }
                AutoZoomOperator.this.a = false;
            }
        }, 20);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1980973988")) {
            ipChange.ipc$dispatch("-1980973988", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        QRCodeActivity qRCodeActivity = this.b;
        if (qRCodeActivity != null) {
            qRCodeActivity.setZoom(i);
            d(i2 + 1, i3);
        }
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1820711200")) {
            ipChange.ipc$dispatch("1820711200", new Object[]{this});
            return;
        }
        this.b = null;
    }

    public void f(float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990105285")) {
            ipChange.ipc$dispatch("-990105285", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)});
            return;
        }
        Log.d("AutoZoomOperator", "startAutoZoom : rate is " + f + ", curIndex is " + i);
        if (f < 0.0f || this.a || i >= 10) {
            this.a = false;
            return;
        }
        this.a = true;
        d(0, (int) f);
    }
}
