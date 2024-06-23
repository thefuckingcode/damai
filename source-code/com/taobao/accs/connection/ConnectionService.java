package com.taobao.accs.connection;

import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
public abstract class ConnectionService {
    private static final String TAG = "ConnectionService";
    protected IConnection conn;
    protected boolean isProxyConnection;

    /* access modifiers changed from: package-private */
    public abstract IConnection getConnection(String str, AccsClientConfig accsClientConfig);

    /* access modifiers changed from: package-private */
    public abstract boolean isProxyConnection();

    public void onBackground() {
    }

    public void onChannelConnectionChanged(boolean z) {
    }

    public void onForeground() {
    }

    public void reset() {
        ALog.e(TAG, "reset", new Object[0]);
        this.conn = null;
    }
}
