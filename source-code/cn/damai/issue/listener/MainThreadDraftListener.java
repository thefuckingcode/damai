package cn.damai.issue.listener;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import cn.damai.issue.bean.DraftBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MainThreadDraftListener implements OnDraftListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final OnDraftListener a;

    public MainThreadDraftListener(OnDraftListener onDraftListener) {
        this.a = onDraftListener;
    }

    @Override // cn.damai.issue.listener.OnDraftListener
    public void onDraft(@Nullable final DraftBean draftBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-717421765")) {
            ipChange.ipc$dispatch("-717421765", new Object[]{this, draftBean});
        } else if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            this.a.onDraft(draftBean);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class cn.damai.issue.listener.MainThreadDraftListener.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1615427885")) {
                        ipChange.ipc$dispatch("1615427885", new Object[]{this});
                        return;
                    }
                    MainThreadDraftListener.this.a.onDraft(draftBean);
                }
            });
        }
    }
}
