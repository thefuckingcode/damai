package com.alibaba.pictures.share.ddshare;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DDApi$share$1$onPermissionGranted$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ DDApi$share$1 this$0;

    DDApi$share$1$onPermissionGranted$1(DDApi$share$1 dDApi$share$1) {
        this.this$0 = dDApi$share$1;
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1216793643")) {
            ipChange.ipc$dispatch("1216793643", new Object[]{this});
            return;
        }
        DDApi$share$1 dDApi$share$1 = this.this$0;
        dDApi$share$1.a.b(dDApi$share$1.b, dDApi$share$1.c, dDApi$share$1.d);
    }
}
