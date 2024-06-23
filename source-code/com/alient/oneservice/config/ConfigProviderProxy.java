package com.alient.oneservice.config;

import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
public class ConfigProviderProxy {
    private static ConfigProvider sProxy;

    public static boolean enableGaiaxConvert() {
        try {
            if (sProxy == null) {
                sProxy = (ConfigProvider) a.j("com.alient.oneservice.provider.impl.config.ConfigProviderImpl").b().f();
            }
            return sProxy.enableGaiaxConvert();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.config.ConfigProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static String getConfig(String str, String str2, String str3) {
        try {
            if (sProxy == null) {
                sProxy = (ConfigProvider) a.j("com.alient.oneservice.provider.impl.config.ConfigProviderImpl").b().f();
            }
            return sProxy.getConfig(str, str2, str3);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.config.ConfigProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static ConfigProvider getProxy() {
        if (sProxy == null) {
            sProxy = (ConfigProvider) a.j("com.alient.oneservice.provider.impl.config.ConfigProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && ConfigProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (ConfigProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getConfig(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (ConfigProvider) a.j("com.alient.oneservice.provider.impl.config.ConfigProviderImpl").b().f();
            }
            return sProxy.getConfig(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.config.ConfigProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }
}
