package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener;

import android.os.Handler;
import android.os.Looper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kl1;

/* compiled from: Taobao */
public class MainThreadRequestListener<T, E> implements RequestListener<T, E> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Handler a;
    private final RequestListener<T, E> b;

    public MainThreadRequestListener(RequestListener<T, E> requestListener) {
        this.b = requestListener;
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-940031490")) {
            ipChange.ipc$dispatch("-940031490", new Object[]{this});
        } else if (this.a == null) {
            this.a = new Handler(Looper.getMainLooper());
        }
    }

    private boolean c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1783826281")) {
            return Looper.getMainLooper().getThread() == Thread.currentThread();
        }
        return ((Boolean) ipChange.ipc$dispatch("-1783826281", new Object[]{this})).booleanValue();
    }

    private void d(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "781584480")) {
            ipChange.ipc$dispatch("781584480", new Object[]{this, runnable});
            return;
        }
        b();
        this.a.post(runnable);
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onFail(final kl1<E> kl1, final String str, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-452434807")) {
            ipChange.ipc$dispatch("-452434807", new Object[]{this, kl1, str, str2});
        } else if (this.b != null) {
            if (c()) {
                this.b.onFail(kl1, str, str2);
            } else {
                d(new Runnable() {
                    /* class cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.MainThreadRequestListener.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1696523121")) {
                            ipChange.ipc$dispatch("1696523121", new Object[]{this});
                            return;
                        }
                        MainThreadRequestListener.this.b.onFail(kl1, str, str2);
                    }
                });
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onSuccess(final kl1<E> kl1, final T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671146830")) {
            ipChange.ipc$dispatch("671146830", new Object[]{this, kl1, t});
        } else if (this.b != null) {
            if (c()) {
                this.b.onSuccess(kl1, t);
            } else {
                d(new Runnable() {
                    /* class cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.MainThreadRequestListener.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener */
                    /* JADX WARN: Multi-variable type inference failed */
                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1893036626")) {
                            ipChange.ipc$dispatch("1893036626", new Object[]{this});
                            return;
                        }
                        MainThreadRequestListener.this.b.onSuccess(kl1, t);
                    }
                });
            }
        }
    }
}
