package com.youku.middlewareservice.provider.os;

import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
public class OSFeatureProviderProxy {
    private static OSFeatureProvider sProxy;

    public static OSFeatureProvider getProxy() {
        if (sProxy == null) {
            sProxy = (OSFeatureProvider) a.j("com.youku.middlewareservice_impl.provider.os.OSFeatureProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void init() {
        try {
            if (sProxy == null) {
                sProxy = (OSFeatureProvider) a.j("com.youku.middlewareservice_impl.provider.os.OSFeatureProviderImpl").b().f();
            }
            sProxy.init();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.os.OSFeatureProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && OSFeatureProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (OSFeatureProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
