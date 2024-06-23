package com.youku.network.call;

import com.youku.network.a;
import com.youku.network.d;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class BaseCall$1 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ a val$callback;
    final /* synthetic */ d val$ykResponse;

    BaseCall$1(a aVar, a aVar2, d dVar) {
        this.this$0 = aVar;
        this.val$callback = aVar2;
        this.val$ykResponse = dVar;
    }

    public void run() {
        this.val$callback.a(this.val$ykResponse);
    }
}
