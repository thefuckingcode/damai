package com.youku.alixplayer.opensdk.interceptor;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class RealInterceptionWrapper {
    public RealInterceptionWrapper(int i, Object obj, List<Interceptor> list, Interceptor interceptor) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(interceptor);
        new RealInterceptionChain(arrayList, i, 0, obj).proceed();
    }
}
