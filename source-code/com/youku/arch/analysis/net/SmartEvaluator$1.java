package com.youku.arch.analysis.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SmartEvaluator$1 extends Thread {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ c this$0;
    final /* synthetic */ String val$info;

    SmartEvaluator$1(c cVar, String str) {
        this.this$0 = cVar;
        this.val$info = str;
    }

    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82068951")) {
            ipChange.ipc$dispatch("82068951", new Object[]{this});
            return;
        }
        c cVar = this.this$0;
        cVar.a(cVar.c, this.val$info);
    }
}
