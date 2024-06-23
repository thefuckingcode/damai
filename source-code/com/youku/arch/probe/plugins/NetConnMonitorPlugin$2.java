package com.youku.arch.probe.plugins;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.probe.a.d;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class NetConnMonitorPlugin$2 extends Thread {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ b this$0;
    final /* synthetic */ List val$speedInfoList;

    NetConnMonitorPlugin$2(b bVar, List list) {
        this.this$0 = bVar;
        this.val$speedInfoList = list;
    }

    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804550179")) {
            ipChange.ipc$dispatch("-1804550179", new Object[]{this});
            return;
        }
        try {
            d.a().b();
            d.a().a(this.val$speedInfoList);
            Map<String, String> b = d.a().b(this.val$speedInfoList);
            this.this$0.D.putAll(b);
            d.a().a(b);
            String str = this.this$0.y;
            this.this$0.z = d.a().a(str);
            d.a().c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
