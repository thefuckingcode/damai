package com.youku.network;

/* compiled from: Taobao */
class YKNetwork$2 implements Runnable {
    final /* synthetic */ b this$0;
    final /* synthetic */ a val$callback;

    YKNetwork$2(b bVar, a aVar) {
        this.this$0 = bVar;
        this.val$callback = aVar;
    }

    public void run() {
        this.this$0.a();
        this.this$0.d.b(this.val$callback);
    }
}
