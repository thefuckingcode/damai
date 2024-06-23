package com.youku.arch.probe.plugins;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.probe.a.a;
import com.youku.arch.probe.a.b;
import com.youku.arch.probe.a.d;
import java.util.HashMap;

/* compiled from: Taobao */
public class NetConnMonitorPlugin$4 extends Thread {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ b this$0;

    NetConnMonitorPlugin$4(b bVar) {
        this.this$0 = bVar;
    }

    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2097390107")) {
            ipChange.ipc$dispatch("2097390107", new Object[]{this});
            return;
        }
        try {
            d.a().b();
            this.this$0.D.putAll(d.a().d());
            d.a().e();
            this.this$0.C = d.a().f();
            String b = b.b(this.this$0.b);
            this.this$0.y = b;
            this.this$0.z = d.a().a(b);
            if (a.r > 0) {
                HashMap hashMap = new HashMap();
                this.this$0.A = d.a().a(this.this$0.C, hashMap);
                this.this$0.B = d.a().b(hashMap);
            }
            d.a().c();
            this.this$0.h();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
