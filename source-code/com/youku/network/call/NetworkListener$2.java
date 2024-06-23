package com.youku.network.call;

import anetwork.channel.NetworkEvent$FinishEvent;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class NetworkListener$2 implements Runnable {
    final /* synthetic */ l this$0;
    final /* synthetic */ Object val$context;
    final /* synthetic */ NetworkEvent$FinishEvent val$finishEvent;

    NetworkListener$2(l lVar, NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
        this.this$0 = lVar;
        this.val$finishEvent = networkEvent$FinishEvent;
        this.val$context = obj;
    }

    public void run() {
        this.this$0.b((l) this.val$finishEvent, (NetworkEvent$FinishEvent) this.val$context);
    }
}
