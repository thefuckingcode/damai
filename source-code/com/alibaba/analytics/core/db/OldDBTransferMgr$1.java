package com.alibaba.analytics.core.db;

import android.content.Context;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import java.io.File;
import java.util.List;
import tb.tp;
import tb.u81;
import tb.xd0;

/* compiled from: Taobao */
final class OldDBTransferMgr$1 implements Runnable {
    final /* synthetic */ Context val$context;
    final /* synthetic */ File val$dbfile;

    OldDBTransferMgr$1(Context context, File file) {
        this.val$context = context;
        this.val$dbfile = file;
    }

    public void run() {
        tp tpVar = new tp(this.val$context, a.a);
        while (true) {
            List<? extends xd0> i = tpVar.i(u81.class, null, "time", 100);
            if (i.size() == 0) {
                Logger.f("OldDBTransferMgr", "delete old db file:", this.val$dbfile.getAbsoluteFile());
                this.val$dbfile.delete();
                return;
            }
            tpVar.g(i);
            Variables.n().k().q(i);
        }
    }
}
