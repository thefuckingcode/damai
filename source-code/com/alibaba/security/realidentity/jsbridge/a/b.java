package com.alibaba.security.realidentity.jsbridge.a;

import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.biometrics.service.model.result.SensorInfo;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.realidentity.jsbridge.a;
import com.alibaba.security.realidentity.jsbridge.f;
import com.alibaba.security.realidentity.jsbridge.h;

@f(a = "rpGetSensor")
/* compiled from: Taobao */
public class b extends a {
    private static final String as = "b";

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final String a() {
        return "rpGetSensor";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, final h hVar) {
        SensorGetter.getDefault().collectLightSensorInfo(new SensorGetter.SensorCallback() {
            /* class com.alibaba.security.realidentity.jsbridge.a.b.AnonymousClass1 */

            @Override // com.alibaba.security.biometrics.service.sensor.SensorGetter.SensorCallback
            public final void onGetSensorValue(float f) {
                SensorInfo sensorInfo = new SensorInfo(f);
                WVResult wVResult = new WVResult();
                wVResult.addData(a.ae, com.alibaba.security.common.d.h.a(sensorInfo));
                wVResult.setSuccess();
                hVar.b(wVResult);
                b.this.a((b) wVResult, (WVResult) true);
            }
        });
        return true;
    }
}
