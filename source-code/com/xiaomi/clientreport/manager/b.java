package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;

/* compiled from: Taobao */
class b implements Runnable {
    final /* synthetic */ EventClientReport a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f17a;

    b(a aVar, EventClientReport eventClientReport) {
        this.f17a = aVar;
        this.a = eventClientReport;
    }

    public void run() {
        this.f17a.b((a) this.a);
    }
}
