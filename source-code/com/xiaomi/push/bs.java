package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.clientreport.processor.c;

/* compiled from: Taobao */
public class bs implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private c f139a;

    public void a(Context context) {
        this.a = context;
    }

    public void a(c cVar) {
        this.f139a = cVar;
    }

    public void run() {
        bw a2;
        String str;
        long currentTimeMillis;
        try {
            c cVar = this.f139a;
            if (cVar != null) {
                cVar.a();
            }
            b.c("begin read and send perf / event");
            c cVar2 = this.f139a;
            if (cVar2 instanceof IEventProcessor) {
                a2 = bw.a(this.a);
                str = "event_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else if (cVar2 instanceof IPerfProcessor) {
                a2 = bw.a(this.a);
                str = "perf_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else {
                return;
            }
            a2.m300a("sp_client_report_status", str, currentTimeMillis);
        } catch (Exception e) {
            b.a(e);
        }
    }
}
