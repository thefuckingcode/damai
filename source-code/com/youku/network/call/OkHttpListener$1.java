package com.youku.network.call;

import com.youku.network.d;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class OkHttpListener$1 implements Runnable {
    final /* synthetic */ n this$0;
    final /* synthetic */ d val$ykResponse;

    OkHttpListener$1(n nVar, d dVar) {
        this.this$0 = nVar;
        this.val$ykResponse = dVar;
    }

    public void run() {
        this.this$0.b.a(this.val$ykResponse);
    }
}
