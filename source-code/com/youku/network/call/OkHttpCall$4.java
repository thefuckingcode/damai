package com.youku.network.call;

import anet.channel.status.NetworkStatusHelper;
import com.youku.network.a;
import com.youku.network.d;

/* compiled from: Taobao */
class OkHttpCall$4 implements Runnable {
    final /* synthetic */ m this$0;
    final /* synthetic */ a val$callback;

    OkHttpCall$4(m mVar, a aVar) {
        this.this$0 = mVar;
        this.val$callback = aVar;
    }

    public void run() {
        this.this$0.e();
        if (this.this$0.j != null) {
            m mVar = this.this$0;
            mVar.a(a.a, this.val$callback, mVar.j);
        } else if (!NetworkStatusHelper.n()) {
            this.this$0.j = d.a();
            this.this$0.j.a(-3018);
            m mVar2 = this.this$0;
            mVar2.a(null, this.val$callback, mVar2.j);
        } else if (this.this$0.k.beforeCall()) {
            d a = d.a();
            a.b(420);
            this.this$0.a(null, this.val$callback, a);
        } else {
            m mVar3 = this.this$0;
            mVar3.g = mVar3.f.newCall(this.this$0.h);
            n nVar = new n(a.a, this.val$callback, this.this$0.d);
            this.this$0.g.enqueue(nVar);
            this.this$0.a((m) nVar);
        }
    }
}
