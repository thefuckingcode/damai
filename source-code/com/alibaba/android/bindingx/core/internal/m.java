package com.alibaba.android.bindingx.core.internal;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import java.util.List;
import tb.f91;

/* compiled from: Taobao */
class m implements SensorManagerProxy {
    private final SensorManager a;

    m(SensorManager sensorManager) {
        this.a = sensorManager;
    }

    @Override // com.alibaba.android.bindingx.core.internal.SensorManagerProxy
    public boolean registerListener(SensorEventListener sensorEventListener, int i, int i2, Handler handler) {
        List<Sensor> sensorList = this.a.getSensorList(i);
        if (sensorList.isEmpty()) {
            return false;
        }
        return this.a.registerListener(sensorEventListener, sensorList.get(0), i2, handler);
    }

    @Override // com.alibaba.android.bindingx.core.internal.SensorManagerProxy
    public void unregisterListener(SensorEventListener sensorEventListener, int i) {
        List<Sensor> sensorList = this.a.getSensorList(i);
        if (!sensorList.isEmpty()) {
            try {
                this.a.unregisterListener(sensorEventListener, sensorList.get(0));
            } catch (Throwable unused) {
                f91.f("Failed to unregister device sensor " + sensorList.get(0).getName());
            }
        }
    }
}
