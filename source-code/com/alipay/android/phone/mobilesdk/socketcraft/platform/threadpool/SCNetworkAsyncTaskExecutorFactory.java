package com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool;

import com.alipay.android.phone.mobilesdk.socketcraft.integrated.threadpool.MPaaSNetworkAsyncTaskExecutor;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.PlatformUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;

/* compiled from: Taobao */
public class SCNetworkAsyncTaskExecutorFactory {
    private static SCNetworkAsyncTaskExecutor a;

    public static final SCNetworkAsyncTaskExecutor getInstance() {
        SCNetworkAsyncTaskExecutor sCNetworkAsyncTaskExecutor = a;
        if (sCNetworkAsyncTaskExecutor != null) {
            return sCNetworkAsyncTaskExecutor;
        }
        synchronized (SCNetworkAsyncTaskExecutorFactory.class) {
            SCNetworkAsyncTaskExecutor sCNetworkAsyncTaskExecutor2 = a;
            if (sCNetworkAsyncTaskExecutor2 != null) {
                return sCNetworkAsyncTaskExecutor2;
            }
            if (PlatformUtil.isAndroidMPaaSPlatform()) {
                try {
                    SCNetworkAsyncTaskExecutor sCNetworkAsyncTaskExecutor3 = (SCNetworkAsyncTaskExecutor) MPaaSNetworkAsyncTaskExecutor.class.newInstance();
                    a = sCNetworkAsyncTaskExecutor3;
                    return sCNetworkAsyncTaskExecutor3;
                } catch (Throwable th) {
                    SCLogCatUtil.error("SCNetworkAsyncTaskExecutorFactory", String.format("Instance class: %s error", "com.alipay.android.phone.mobilesdk.socketcraft.integrated.threadpool.MPaaSNetworkAsyncTaskExecutor"), th);
                }
            }
            if (a == null) {
                a = new DefaultSCNetworkAsyncTaskExecutor();
            }
            return a;
        }
    }
}
