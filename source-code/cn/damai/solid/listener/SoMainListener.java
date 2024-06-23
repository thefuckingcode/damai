package cn.damai.solid.listener;

import android.os.Handler;
import android.os.Looper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.lifecycle.OnSoGroupStatusChangeListener;
import com.youku.arch.solid.lifecycle.SolidResponse;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class SoMainListener implements OnSoGroupStatusChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final WeakReference<OnSoGroupStatusChangeListener> a;

    public SoMainListener(OnSoGroupStatusChangeListener onSoGroupStatusChangeListener) {
        this.a = new WeakReference<>(onSoGroupStatusChangeListener);
    }

    @Override // com.youku.arch.solid.lifecycle.SolidListener
    public void onResponse(final SolidResponse solidResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2017888843")) {
            ipChange.ipc$dispatch("2017888843", new Object[]{this, solidResponse});
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class cn.damai.solid.listener.SoMainListener.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1514143640")) {
                    ipChange.ipc$dispatch("1514143640", new Object[]{this});
                    return;
                }
                OnSoGroupStatusChangeListener onSoGroupStatusChangeListener = (OnSoGroupStatusChangeListener) SoMainListener.this.a.get();
                if (onSoGroupStatusChangeListener != null) {
                    onSoGroupStatusChangeListener.onResponse(solidResponse);
                }
            }
        });
    }
}
