package com.huawei.hms.aaid.plugin;

/* compiled from: Taobao */
public class ProxyCenter {
    public PushProxy proxy;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        public static ProxyCenter a = new ProxyCenter();
    }

    public static ProxyCenter getInstance() {
        return a.a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}
