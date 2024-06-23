package com.alibaba.pictures.share.qqshare;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class QQShareActivity$onCreate$2 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ QQShareActivity this$0;

    QQShareActivity$onCreate$2(QQShareActivity qQShareActivity) {
        this.this$0 = qQShareActivity;
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340326326")) {
            ipChange.ipc$dispatch("-1340326326", new Object[]{this});
            return;
        }
        QQShareActivity qQShareActivity = this.this$0;
        qQShareActivity.f(qQShareActivity, qQShareActivity.c);
    }
}
