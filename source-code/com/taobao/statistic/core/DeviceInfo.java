package com.taobao.statistic.core;

import android.content.Context;
import com.ut.device.UTDevice;
import tb.eq1;

@Deprecated
/* compiled from: Taobao */
public class DeviceInfo {
    private static Device s_device;

    @Deprecated
    public static Device getDevice(Context context) {
        Device device = s_device;
        if (device != null) {
            return device;
        }
        Device device2 = new Device();
        device2.setImei(eq1.b(context));
        device2.setImsi(eq1.d(context));
        device2.setUdid(UTDevice.getUtdid(context));
        s_device = device2;
        return device2;
    }
}
