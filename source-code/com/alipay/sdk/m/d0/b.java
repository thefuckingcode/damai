package com.alipay.sdk.m.d0;

import com.alipay.sdk.m.z.a;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* compiled from: Taobao */
public class b implements Runnable {
    public final /* synthetic */ DataReportRequest a;
    public final /* synthetic */ c b;

    public b(c cVar, DataReportRequest dataReportRequest) {
        this.b = cVar;
        this.a = dataReportRequest;
    }

    public void run() {
        try {
            DataReportResult unused = c.e = this.b.c.reportData(this.a);
        } catch (Throwable th) {
            DataReportResult unused2 = c.e = new DataReportResult();
            c.e.success = false;
            DataReportResult dataReportResult = c.e;
            dataReportResult.resultCode = "static data rpc upload error, " + a.a(th);
            a.a(th);
        }
    }
}
