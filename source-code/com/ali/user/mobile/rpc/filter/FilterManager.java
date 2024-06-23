package com.ali.user.mobile.rpc.filter;

import com.ali.user.mobile.rpc.RpcResponse;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class FilterManager {
    public static final String CONTINUE = "CONTINUE";
    public static final String STOP = "STOP";
    private static final String TAG = "FilterManager";
    private static FilterManager instance;

    private FilterManager() {
    }

    public static FilterManager getInstance() {
        if (instance == null) {
            synchronized (FilterManager.class) {
                if (instance == null) {
                    instance = new FilterManager();
                }
            }
        }
        return instance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x000d  */
    public void afterRpc(List<IAfterFilter> list, RpcResponse rpcResponse) {
        if (list != null) {
            Iterator<IAfterFilter> it = list.iterator();
            while (it.hasNext() && (r0 = it.next().doAfter(rpcResponse)) != null && !"STOP".equals(r0)) {
                while (it.hasNext()) {
                    while (it.hasNext()) {
                    }
                }
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x000d  */
    public void beforeRpc(List<IBeforeFilter> list) {
        if (list != null) {
            Iterator<IBeforeFilter> it = list.iterator();
            while (it.hasNext() && (r0 = it.next().doBefore()) != null && !"STOP".equals(r0)) {
                while (it.hasNext()) {
                    while (it.hasNext()) {
                    }
                }
                return;
            }
        }
    }
}
