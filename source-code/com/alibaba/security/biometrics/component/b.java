package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.view.KeyEvent;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.sensor.api.RpSecException;
import com.alibaba.security.biometrics.sensor.api.a;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.TrackLog;
import java.util.HashMap;

/* compiled from: Taobao */
public class b extends a {
    private static final String d = "b";
    private a e;
    private String f;

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        com.alibaba.security.common.c.a.a(d, "Data collect initialized");
        super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        if (activity != null) {
            this.f = activity.getClass().getSimpleName();
        }
        this.e = new com.alibaba.security.biometrics.sensor.a(activity);
        HashMap<String, String> hashMap = new HashMap<>();
        if (aLBiometricsParams != null) {
            hashMap.put(com.alibaba.security.biometrics.sensor.a.a, String.valueOf(aLBiometricsParams.needCollect));
            hashMap.put(com.alibaba.security.biometrics.sensor.a.b, aLBiometricsParams.enabledSensors);
            hashMap.put(com.alibaba.security.biometrics.sensor.a.c, String.valueOf(aLBiometricsParams.collectInterval));
            hashMap.put(com.alibaba.security.biometrics.sensor.a.d, String.valueOf(aLBiometricsParams.maxClickCount));
            hashMap.put(com.alibaba.security.biometrics.sensor.a.e, String.valueOf(aLBiometricsParams.maxSensorCount));
        }
        try {
            this.e.a(hashMap);
            return false;
        } catch (RpSecException e2) {
            com.alibaba.security.common.c.a.b();
            a("Data Collect init failed: " + e2.getErrorCode() + "::" + e2.getMessage());
            return false;
        }
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean b() {
        e();
        return super.b();
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean c() {
        return super.c();
    }

    public final void d() {
        com.alibaba.security.common.c.a.a(d, "<SENSOR_TEST_LOG> SensorData collect started >>> 1");
        a aVar = this.e;
        if (aVar != null) {
            try {
                aVar.a(1);
                a(true);
            } catch (RpSecException e2) {
                com.alibaba.security.common.c.a.b();
                a("Data Collect start failed: " + e2.getErrorCode() + "::" + e2.getMessage());
            }
        }
    }

    public final void e() {
        com.alibaba.security.common.c.a.a(d, "<SENSOR_TEST_LOG> SensorData collect stopped >>> 5");
        a aVar = this.e;
        if (aVar != null) {
            try {
                aVar.a(3);
                a(false);
            } catch (RpSecException e2) {
                com.alibaba.security.common.c.a.b();
                a("Data Collect stop failed: " + e2.getErrorCode() + "::" + e2.getMessage());
            }
        }
    }

    public final String f() {
        com.alibaba.security.common.c.a.a(d, "<SENSOR_TEST_LOG> SensorData upload >>> 4");
        a aVar = this.e;
        if (aVar == null) {
            return null;
        }
        try {
            return (String) aVar.a(2).get("data");
        } catch (RpSecException e2) {
            com.alibaba.security.common.c.a.b();
            a("Data Collect failed: " + e2.getErrorCode() + "::" + e2.getMessage());
            return null;
        }
    }

    public final void g() {
        a aVar = this.e;
        if (aVar != null) {
            try {
                aVar.a(4);
            } catch (RpSecException e2) {
                com.alibaba.security.common.c.a.b();
                a("Data Collect reset failed: " + e2.getErrorCode() + "::" + e2.getMessage());
            }
        }
    }

    private static HashMap<String, String> a(ALBiometricsParams aLBiometricsParams) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (aLBiometricsParams == null) {
            return hashMap;
        }
        hashMap.put(com.alibaba.security.biometrics.sensor.a.a, String.valueOf(aLBiometricsParams.needCollect));
        hashMap.put(com.alibaba.security.biometrics.sensor.a.b, aLBiometricsParams.enabledSensors);
        hashMap.put(com.alibaba.security.biometrics.sensor.a.c, String.valueOf(aLBiometricsParams.collectInterval));
        hashMap.put(com.alibaba.security.biometrics.sensor.a.d, String.valueOf(aLBiometricsParams.maxClickCount));
        hashMap.put(com.alibaba.security.biometrics.sensor.a.e, String.valueOf(aLBiometricsParams.maxSensorCount));
        return hashMap;
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
        super.a(aLBiometricsActivityParentView);
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a() {
        d();
        return super.a();
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a(int i, KeyEvent keyEvent) {
        return super.a(i, keyEvent);
    }

    private void a(String str) {
        TrackLog createDataCollectionExceptionLog = TrackLog.createDataCollectionExceptionLog(str);
        ALBiometricsParams aLBiometricsParams = this.b;
        if (aLBiometricsParams != null) {
            createDataCollectionExceptionLog.setVerifyToken(aLBiometricsParams.mVerifyToken);
        }
        createDataCollectionExceptionLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        createDataCollectionExceptionLog.addTag10("Android");
        a.C0102a.a.a(createDataCollectionExceptionLog);
        a.C0102a.a.a(false);
    }

    private void a(boolean z) {
        TrackLog trackLog;
        if (z) {
            trackLog = TrackLog.createCollectSensorStartLog(this.f);
        } else {
            trackLog = TrackLog.createCollectSensorEndLog(this.f);
        }
        ALBiometricsParams aLBiometricsParams = this.b;
        if (aLBiometricsParams != null) {
            trackLog.setVerifyToken(aLBiometricsParams.mVerifyToken);
        }
        trackLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        trackLog.addTag10("Android");
        a.C0102a.a.a(trackLog);
        a.C0102a.a.a(false);
    }
}
