package com.youku.arch.ntk;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.ntk.a.h;
import com.youku.b.a.a;

/* compiled from: Taobao */
public class NetworkInspector$2 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ b this$0;
    final /* synthetic */ h val$info;

    NetworkInspector$2(b bVar, h hVar) {
        this.this$0 = bVar;
        this.val$info = hVar;
    }

    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1292425732")) {
            ipChange.ipc$dispatch("-1292425732", new Object[]{this});
            return;
        }
        String str = b.a;
        a.b(str, "start inspectNetwork:" + this.val$info.t);
        this.this$0.c = true;
        this.this$0.a((b) this.val$info);
        this.this$0.c = false;
        String str2 = b.a;
        a.b(str2, "finish inspectNetwork:" + this.val$info.t);
    }
}
