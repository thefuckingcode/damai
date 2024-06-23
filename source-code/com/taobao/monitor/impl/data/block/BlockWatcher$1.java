package com.taobao.monitor.impl.data.block;

import com.taobao.application.common.IAppPreferences;
import com.taobao.application.common.b;
import com.taobao.application.common.impl.a;
import java.util.HashMap;
import org.json.JSONObject;
import tb.c70;
import tb.gc;
import tb.i20;
import tb.k3;

/* compiled from: Taobao */
class BlockWatcher$1 implements Runnable {
    final /* synthetic */ gc this$0;
    final /* synthetic */ long val$blockTime;
    final /* synthetic */ int val$gc;
    final /* synthetic */ StringBuilder val$sb;

    BlockWatcher$1(gc gcVar, long j, StringBuilder sb, int i) {
        this.val$blockTime = j;
        this.val$sb = sb;
        this.val$gc = i;
    }

    public void run() {
        IAppPreferences d = b.d();
        HashMap hashMap = new HashMap();
        hashMap.put("blockTime", Long.valueOf(this.val$blockTime));
        hashMap.put("mainThreadStackTrace", this.val$sb.toString());
        hashMap.put("topActivity", k3.b(a.g().getTopActivity()));
        hashMap.put("deviceLevel", Integer.valueOf(d.getInt("deviceLevel", -1)));
        hashMap.put("gcCount", Integer.valueOf(this.val$gc));
        hashMap.put("activeThread", Integer.valueOf(Thread.activeCount()));
        hashMap.put("runtimeInfo", c70.a().b("Block").toString());
        i20.a("BlockWatcher", new JSONObject(hashMap));
    }
}
