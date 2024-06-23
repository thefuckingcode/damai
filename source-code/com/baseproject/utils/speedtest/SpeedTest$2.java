package com.baseproject.utils.speedtest;

import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.b.a.a;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class SpeedTest$2 implements Runnable {
    final /* synthetic */ j this$0;

    SpeedTest$2(j jVar) {
        this.this$0 = jVar;
    }

    public void run() {
        if (this.this$0.e < this.this$0.c.b.d.length) {
            a.a("SpeedTest", "exec task: index=" + this.this$0.e);
            AdapterForTLog.loge("SpeedTest", "exec task: index=" + this.this$0.e);
            this.this$0.b = new SpeedTestRequest(this.this$0.c.a.a, this.this$0.c.b, this.this$0.c.b.d[this.this$0.e], this.this$0.e, this.this$0.c.b.d.length);
            this.this$0.b.e(this.this$0);
            j.k(this.this$0);
            this.this$0.b.d();
            return;
        }
        this.this$0.c();
    }
}
