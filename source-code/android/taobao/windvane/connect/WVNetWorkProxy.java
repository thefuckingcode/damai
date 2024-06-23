package android.taobao.windvane.connect;

/* compiled from: Taobao */
public class WVNetWorkProxy {
    private static WVNetWorkProxy mConnectManager;
    private WVNetWorkProxyInterface mNetWorkProxy = null;

    public static synchronized WVNetWorkProxy getInstance() {
        WVNetWorkProxy wVNetWorkProxy;
        synchronized (WVNetWorkProxy.class) {
            if (mConnectManager == null) {
                mConnectManager = new WVNetWorkProxy();
            }
            wVNetWorkProxy = mConnectManager;
        }
        return wVNetWorkProxy;
    }

    public WVNetWorkProxyInterface getNetWorkProxy() {
        return this.mNetWorkProxy;
    }

    public void registerNetWork(WVNetWorkProxyInterface wVNetWorkProxyInterface) {
        this.mNetWorkProxy = wVNetWorkProxyInterface;
    }
}
