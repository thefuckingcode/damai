package com.alibaba.analytics.core.store;

import android.content.Context;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import java.util.List;
import tb.tp;
import tb.u81;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a implements ILogStore {
    a(Context context) {
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized void clear() {
        Variables.n().k().b(u81.class);
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized int clearOldLogByCount(int i) {
        String p;
        tp k;
        Logger.d();
        p = Variables.n().k().p(u81.class);
        k = Variables.n().k();
        return k.f(u81.class, " _id in ( select _id from " + p + "  ORDER BY " + "priority" + " ASC , _id ASC LIMIT " + i + " )", null);
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized int clearOldLogByField(String str, String str2) {
        tp k;
        Logger.d();
        k = Variables.n().k();
        return k.f(u81.class, str + "< ?", new String[]{str2});
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized int count() {
        return Variables.n().k().d(u81.class);
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized int delete(List<u81> list) {
        return Variables.n().k().g(list);
    }

    /* JADX DEBUG: Type inference failed for r5v2. Raw type applied. Possible types: java.util.List<? extends tb.xd0>, java.util.List<tb.u81> */
    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized List<u81> get(int i) {
        return Variables.n().k().i(u81.class, null, "priority DESC , time DESC ", i);
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized double getDbFileSize() {
        return Variables.n().k().m();
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized boolean insert(List<u81> list) {
        Variables.n().k().q(list);
        return true;
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized void update(List<u81> list) {
        Variables.n().k().s(list);
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized void updateLogPriority(List<u81> list) {
        Variables.n().k().t(list);
    }
}
