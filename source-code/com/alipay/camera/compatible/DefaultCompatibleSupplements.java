package com.alipay.camera.compatible;

import android.hardware.Camera;
import android.os.Build;
import com.alipay.mobile.bqcscanservice.MPaasLogger;

/* compiled from: Taobao */
public class DefaultCompatibleSupplements extends BaseCompatibleSupplements {
    public static final String TAG = "DefaultCompatibleSupplements";

    public DefaultCompatibleSupplements(Camera.Parameters parameters) {
        super(parameters);
        MPaasLogger.d(TAG, new Object[]{"adjustContrast: hardware=", Build.HARDWARE});
    }
}
