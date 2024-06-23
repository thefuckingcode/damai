package cn.damai.seat.listener;

import android.os.Handler;
import android.os.Looper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s72;

/* compiled from: Taobao */
public class OnTMainThreadListener<T> implements OnTListener<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final OnTListener<T> a;

    public OnTMainThreadListener(OnTListener<T> onTListener) {
        this.a = onTListener;
    }

    @Override // cn.damai.seat.listener.OnTListener
    public void call(final T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-700075053")) {
            ipChange.ipc$dispatch("-700075053", new Object[]{this, t});
        } else if (this.a != null) {
            if (s72.a()) {
                this.a.call(t);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class cn.damai.seat.listener.OnTMainThreadListener.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: cn.damai.seat.listener.OnTListener */
                    /* JADX WARN: Multi-variable type inference failed */
                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1429579075")) {
                            ipChange.ipc$dispatch("-1429579075", new Object[]{this});
                            return;
                        }
                        OnTMainThreadListener.this.a.call(t);
                    }
                });
            }
        }
    }
}
