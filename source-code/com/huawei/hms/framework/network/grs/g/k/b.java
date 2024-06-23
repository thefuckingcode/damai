package com.huawei.hms.framework.network.grs.g.k;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.g.d;
import java.util.concurrent.Future;

/* compiled from: Taobao */
public class b {
    private final Future<d> a;
    private final long b = SystemClock.elapsedRealtime();

    public b(Future<d> future) {
        this.a = future;
    }

    public Future<d> a() {
        return this.a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.b <= 300000;
    }
}
