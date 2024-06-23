package com.amap.api.mapcore.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import tb.v;

/* compiled from: Taobao */
public class aa implements SensorEventListener {
    private SensorManager a;
    private Sensor b;
    private long c = 0;
    private float d;
    private Context e;
    private IAMapDelegate f;
    private Marker g;
    private boolean h = true;

    public aa(Context context, IAMapDelegate iAMapDelegate) {
        this.e = context.getApplicationContext();
        this.f = iAMapDelegate;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.a = sensorManager;
            if (sensorManager != null) {
                this.b = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(final SensorEvent sensorEvent) {
        try {
            if (System.currentTimeMillis() - this.c >= 100) {
                if (this.f.getGLMapEngine() == null || this.f.getGLMapEngine().getAnimateionsCount() <= 0) {
                    ep.a().a(new Runnable() {
                        /* class com.amap.api.mapcore.util.aa.AnonymousClass1 */

                        public void run() {
                            if (sensorEvent.sensor.getType() == 3) {
                                float a2 = (sensorEvent.values[0] + ((float) aa.a(aa.this.e))) % 360.0f;
                                if (a2 > 180.0f) {
                                    a2 -= 360.0f;
                                } else if (a2 < -180.0f) {
                                    a2 += 360.0f;
                                }
                                if (Math.abs(aa.this.d - a2) >= 3.0f) {
                                    aa aaVar = aa.this;
                                    if (Float.isNaN(a2)) {
                                        a2 = 0.0f;
                                    }
                                    aaVar.d = a2;
                                    if (aa.this.g != null) {
                                        try {
                                            if (aa.this.h) {
                                                aa.this.f.moveCamera(ah.d(aa.this.d));
                                                aa.this.g.setRotateAngle(-aa.this.d);
                                            } else {
                                                aa.this.g.setRotateAngle(360.0f - aa.this.d);
                                            }
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                    aa.this.c = System.currentTimeMillis();
                                }
                            }
                        }
                    });
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b() {
        Sensor sensor;
        SensorManager sensorManager = this.a;
        if (sensorManager != null && (sensor = this.b) != null) {
            sensorManager.unregisterListener(this, sensor);
        }
    }

    public void a() {
        Sensor sensor;
        SensorManager sensorManager = this.a;
        if (sensorManager != null && (sensor = this.b) != null) {
            sensorManager.registerListener(this, sensor, 3);
        }
    }

    public void a(Marker marker) {
        this.g = marker;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public static int a(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)) == null) {
            return 0;
        }
        try {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (rotation == 1) {
                return 90;
            }
            if (rotation != 2) {
                return rotation != 3 ? 0 : -90;
            }
            return 180;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
