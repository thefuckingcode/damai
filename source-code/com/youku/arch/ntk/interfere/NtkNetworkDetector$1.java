package com.youku.arch.ntk.interfere;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.ntk.interfere.g;

/* compiled from: Taobao */
public class NtkNetworkDetector$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ g this$0;
    final /* synthetic */ g.a val$result;
    final /* synthetic */ int val$timeMs;
    final /* synthetic */ String val$urlOrIp;

    NtkNetworkDetector$1(g gVar, String str, int i, g.a aVar) {
        this.this$0 = gVar;
        this.val$urlOrIp = str;
        this.val$timeMs = i;
        this.val$result = aVar;
    }

    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "879133654")) {
            ipChange.ipc$dispatch("879133654", new Object[]{this});
            return;
        }
        this.this$0.a(this.val$urlOrIp, this.val$timeMs, this.val$result);
    }
}
