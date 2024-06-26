package cn.damai.tool2.bufferkit;

import android.os.Handler;
import android.os.Looper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MainThreadListener<T> implements BufferListener<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final BufferListener<T> a;
    private final Handler b = new Handler(Looper.getMainLooper());

    public MainThreadListener(BufferListener<T> bufferListener) {
        this.a = bufferListener;
    }

    private boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-319248556")) {
            return Looper.getMainLooper().getThread() == Thread.currentThread();
        }
        return ((Boolean) ipChange.ipc$dispatch("-319248556", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.tool2.bufferkit.BufferListener
    public void doRequestAsync() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "968332805")) {
            ipChange.ipc$dispatch("968332805", new Object[]{this});
        } else if (b()) {
            this.a.doRequestAsync();
        } else {
            this.b.post(new Runnable() {
                /* class cn.damai.tool2.bufferkit.MainThreadListener.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1396452917")) {
                        ipChange.ipc$dispatch("1396452917", new Object[]{this});
                        return;
                    }
                    MainThreadListener.this.a.doRequestAsync();
                }
            });
        }
    }

    @Override // cn.damai.tool2.bufferkit.BufferListener
    public void onFail(final String str, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1578813260")) {
            ipChange.ipc$dispatch("-1578813260", new Object[]{this, str, str2});
        } else if (b()) {
            this.a.onFail(str, str2);
        } else {
            this.b.post(new Runnable() {
                /* class cn.damai.tool2.bufferkit.MainThreadListener.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1003425907")) {
                        ipChange.ipc$dispatch("1003425907", new Object[]{this});
                        return;
                    }
                    MainThreadListener.this.a.onFail(str, str2);
                }
            });
        }
    }

    @Override // cn.damai.tool2.bufferkit.BufferListener
    public void onSuccess(final T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "415312773")) {
            ipChange.ipc$dispatch("415312773", new Object[]{this, t});
        } else if (b()) {
            this.a.onSuccess(t);
        } else {
            this.b.post(new Runnable() {
                /* class cn.damai.tool2.bufferkit.MainThreadListener.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: cn.damai.tool2.bufferkit.BufferListener */
                /* JADX WARN: Multi-variable type inference failed */
                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1199939412")) {
                        ipChange.ipc$dispatch("1199939412", new Object[]{this});
                        return;
                    }
                    MainThreadListener.this.a.onSuccess(t);
                }
            });
        }
    }
}
