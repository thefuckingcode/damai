package com.loc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
public final class z0 implements SensorEventListener {
    private Context a = null;
    SensorManager b = null;
    Sensor c = null;
    Sensor d = null;
    Sensor e = null;
    public boolean f = false;
    public double g = 0.0d;
    private float h = 1013.25f;
    private float i = 0.0f;
    Handler j = new Handler();
    double k = 0.0d;
    double l = 0.0d;
    double m = 0.0d;
    double n = 0.0d;
    double[] o = new double[3];
    volatile double p = 0.0d;
    long q = 0;
    long r = 0;

    /* JADX WARNING: Can't wrap try/catch for region: R(10:1|2|(1:4)|5|6|7|8|9|10|15) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(1:4)|5|6|7|8|9|10|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0052 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x005c */
    public z0(Context context) {
        try {
            this.a = context;
            if (this.b == null) {
                this.b = (SensorManager) context.getSystemService("sensor");
            }
            this.c = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.b, 6);
            this.d = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.b, 11);
            this.e = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.b, 1);
        } catch (Throwable th) {
            j1.h(th, "AMapSensorManager", "<init>");
        }
    }

    private void b(float[] fArr) {
        double[] dArr = this.o;
        dArr[0] = (dArr[0] * 0.800000011920929d) + ((double) (fArr[0] * 0.19999999f));
        dArr[1] = (dArr[1] * 0.800000011920929d) + ((double) (fArr[1] * 0.19999999f));
        dArr[2] = (dArr[2] * 0.800000011920929d) + ((double) (fArr[2] * 0.19999999f));
        this.k = ((double) fArr[0]) - dArr[0];
        this.l = ((double) fArr[1]) - dArr[1];
        this.m = ((double) fArr[2]) - dArr[2];
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.q >= 100) {
            double d2 = this.k;
            double d3 = this.l;
            double d4 = (d2 * d2) + (d3 * d3);
            double d5 = this.m;
            double sqrt = Math.sqrt(d4 + (d5 * d5));
            this.r++;
            this.q = currentTimeMillis;
            this.p += sqrt;
            if (this.r >= 30) {
                this.n = this.p / ((double) this.r);
                this.p = 0.0d;
                this.r = 0;
            }
        }
    }

    private void d(float[] fArr) {
        if (fArr != null) {
            this.g = (double) m1.b(SensorManager.getAltitude(this.h, fArr[0]));
        }
    }

    private void f(float[] fArr) {
        if (fArr != null) {
            float[] fArr2 = new float[9];
            SensorManager.getRotationMatrixFromVector(fArr2, fArr);
            float[] fArr3 = new float[3];
            SensorManager.getOrientation(fArr2, fArr3);
            float degrees = (float) Math.toDegrees((double) fArr3[0]);
            this.i = degrees;
            if (degrees <= 0.0f) {
                degrees += 360.0f;
            }
            this.i = (float) Math.floor((double) degrees);
        }
    }

    public final void a() {
        SensorManager sensorManager = this.b;
        if (sensorManager != null && !this.f) {
            this.f = true;
            try {
                Sensor sensor = this.c;
                if (sensor != null) {
                    sensorManager.registerListener(this, sensor, 3, this.j);
                }
            } catch (Throwable th) {
                j1.h(th, "AMapSensorManager", "registerListener mPressure");
            }
            try {
                Sensor sensor2 = this.d;
                if (sensor2 != null) {
                    this.b.registerListener(this, sensor2, 3, this.j);
                }
            } catch (Throwable th2) {
                j1.h(th2, "AMapSensorManager", "registerListener mRotationVector");
            }
            try {
                Sensor sensor3 = this.e;
                if (sensor3 != null) {
                    this.b.registerListener(this, sensor3, 3, this.j);
                }
            } catch (Throwable th3) {
                j1.h(th3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|6|(1:8)|9|10|(1:12)|13|14|(2:16|18)(1:22)) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0016 A[Catch:{ all -> 0x001b }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x001f A[Catch:{ all -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    public final void c() {
        SensorManager sensorManager = this.b;
        if (sensorManager != null && this.f) {
            this.f = false;
            Sensor sensor = this.c;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.d;
            if (sensor2 != null) {
                this.b.unregisterListener(this, sensor2);
            }
            Sensor sensor3 = this.e;
            if (sensor3 != null) {
                this.b.unregisterListener(this, sensor3);
            }
        }
    }

    public final double e() {
        return this.g;
    }

    public final float g() {
        return this.i;
    }

    public final double h() {
        return this.n;
    }

    public final void i() {
        try {
            c();
            this.c = null;
            this.d = null;
            this.b = null;
            this.e = null;
            this.f = false;
        } catch (Throwable th) {
            j1.h(th, "AMapSensorManager", Constants.Event.SLOT_LIFECYCLE.DESTORY);
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                int type = sensorEvent.sensor.getType();
                if (type != 1) {
                    if (type == 6) {
                        try {
                            if (this.c != null) {
                                float[] fArr = (float[]) sensorEvent.values.clone();
                                float f2 = fArr[0];
                                d(fArr);
                            }
                        } catch (Throwable unused) {
                        }
                    } else if (type == 11) {
                        try {
                            if (this.d != null) {
                                f((float[]) sensorEvent.values.clone());
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                } else if (this.e != null) {
                    b((float[]) sensorEvent.values.clone());
                }
            } catch (Throwable unused3) {
            }
        }
    }
}
