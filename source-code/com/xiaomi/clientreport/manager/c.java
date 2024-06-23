package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;

/* compiled from: Taobao */
class c implements Runnable {
    final /* synthetic */ PerfClientReport a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f18a;

    c(a aVar, PerfClientReport perfClientReport) {
        this.f18a = aVar;
        this.a = perfClientReport;
    }

    public void run() {
        this.f18a.b((a) this.a);
    }
}
