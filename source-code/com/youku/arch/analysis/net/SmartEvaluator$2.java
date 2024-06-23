package com.youku.arch.analysis.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SmartEvaluator$2 extends Thread {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ c this$0;

    SmartEvaluator$2(c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-114444554")) {
            ipChange.ipc$dispatch("-114444554", new Object[]{this});
            return;
        }
        this.this$0.c();
    }
}
