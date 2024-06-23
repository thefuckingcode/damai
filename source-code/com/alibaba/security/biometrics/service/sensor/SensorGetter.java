package com.alibaba.security.biometrics.service.sensor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.security.common.c.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class SensorGetter implements SensorEventListener {
    private static final String TAG = "SensorGetter";
    @SuppressLint({"StaticFieldLeak"})
    private static SensorGetter mSensorGetter;
    private Context context;
    private ThreadPoolExecutor executorService;
    private Sensor mLightSensor;
    private float mLightValue = -1.0f;
    private Sensor mProximitySensor;
    private float mProximityValue = -1.0f;
    private SensorManager mSensorManager;
    private Handler mUiHandler;
    private boolean started;

    /* compiled from: Taobao */
    public interface SensorCallback {
        void onGetSensorValue(float f);
    }

    private SensorGetter() {
    }

    public static SensorGetter getDefault() {
        if (mSensorGetter == null) {
            synchronized (SensorGetter.class) {
                if (mSensorGetter == null) {
                    mSensorGetter = new SensorGetter();
                }
            }
        }
        return mSensorGetter;
    }

    public void collectLightSensorInfo(SensorCallback sensorCallback) {
        collectOneShotAsync(5, sensorCallback);
    }

    public void collectOneShotAsync(final int i, final SensorCallback sensorCallback) {
        if (this.executorService == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                /* class com.alibaba.security.biometrics.service.sensor.SensorGetter.AnonymousClass1 */

                public Thread newThread(Runnable runnable) {
                    return new Thread(runnable, "rpsdk-sensorGetter");
                }
            });
            this.executorService = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        if (this.mUiHandler == null) {
            this.mUiHandler = new Handler(Looper.getMainLooper());
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.executorService;
        if (threadPoolExecutor2 != null) {
            threadPoolExecutor2.submit(new Runnable() {
                /* class com.alibaba.security.biometrics.service.sensor.SensorGetter.AnonymousClass2 */

                public void run() {
                    final long currentTimeMillis = System.currentTimeMillis();
                    if (sensorCallback == null) {
                        a.d(SensorGetter.TAG, "sensorCallback is null");
                        return;
                    }
                    if (SensorGetter.this.mSensorManager == null) {
                        SensorGetter sensorGetter = SensorGetter.this;
                        sensorGetter.mSensorManager = (SensorManager) sensorGetter.context.getApplicationContext().getSystemService("sensor");
                    }
                    if (SensorGetter.this.mSensorManager == null) {
                        sensorCallback.onGetSensorValue(-1.0f);
                        return;
                    }
                    Sensor defaultSensor = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(SensorGetter.this.mSensorManager, i);
                    if (defaultSensor == null) {
                        sensorCallback.onGetSensorValue(-1.0f);
                        return;
                    }
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    final float[] fArr = new float[1];
                    AnonymousClass1 r9 = new SensorEventListener() {
                        /* class com.alibaba.security.biometrics.service.sensor.SensorGetter.AnonymousClass2.AnonymousClass1 */

                        public void onAccuracyChanged(Sensor sensor, int i) {
                        }

                        /* JADX WARNING: Can't wrap try/catch for region: R(2:5|6) */
                        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0043, code lost:
                            r7 = move-exception;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
                            com.alibaba.security.common.c.a.b();
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0049, code lost:
                            r7.countDown();
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:8:0x004e, code lost:
                            throw r7;
                         */
                        /* JADX WARNING: Failed to process nested try/catch */
                        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0045 */
                        public void onSensorChanged(SensorEvent sensorEvent) {
                            fArr[0] = sensorEvent.values[0];
                            a.b(SensorGetter.TAG, "name:" + sensorEvent.sensor.getName() + "\tvalue:" + sensorEvent.values[0] + "\tcost:" + (System.currentTimeMillis() - currentTimeMillis));
                            countDownLatch.countDown();
                        }
                    };
                    if (Build.VERSION.SDK_INT >= 19) {
                        SensorGetter.this.mSensorManager.registerListener(r9, defaultSensor, 3, 0);
                    } else {
                        SensorGetter.this.mSensorManager.registerListener(r9, defaultSensor, 3);
                    }
                    try {
                        countDownLatch.await(500, TimeUnit.MILLISECONDS);
                    } catch (Exception unused) {
                        a.b();
                    }
                    SensorGetter.this.mUiHandler.post(new Runnable() {
                        /* class com.alibaba.security.biometrics.service.sensor.SensorGetter.AnonymousClass2.AnonymousClass2 */

                        public void run() {
                            sensorCallback.onGetSensorValue(fArr[0]);
                        }
                    });
                    if (SensorGetter.this.mSensorManager != null) {
                        SensorGetter.this.mSensorManager.unregisterListener(r9, defaultSensor);
                    }
                }
            });
        }
    }

    public void collectProximityInfo(SensorCallback sensorCallback) {
        collectOneShotAsync(8, sensorCallback);
    }

    public float getCurrentLightValue() {
        return this.mLightValue;
    }

    public float getProximityValue() {
        return this.mProximityValue;
    }

    public void init(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 5) {
                this.mLightValue = sensorEvent.values[0];
            }
            if (sensorEvent.sensor.getType() == 8) {
                this.mProximityValue = sensorEvent.values[0];
            }
        } catch (Exception unused) {
            a.b();
        }
    }

    public void start() {
        if (!this.started) {
            if (this.mSensorManager == null) {
                this.mSensorManager = (SensorManager) this.context.getApplicationContext().getSystemService("sensor");
            }
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager != null) {
                Sensor defaultSensor = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 5);
                this.mLightSensor = defaultSensor;
                if (defaultSensor != null) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.mSensorManager.registerListener(this, defaultSensor, 3, 0);
                    } else {
                        this.mSensorManager.registerListener(this, defaultSensor, 3);
                    }
                }
                Sensor defaultSensor2 = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.mSensorManager, 8);
                this.mProximitySensor = defaultSensor2;
                if (defaultSensor2 != null) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.mSensorManager.registerListener(this, defaultSensor2, 3, 0);
                    } else {
                        this.mSensorManager.registerListener(this, defaultSensor2, 3);
                    }
                }
            }
            this.started = true;
        }
    }

    public void stop() {
        if (this.started) {
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager != null) {
                Sensor sensor = this.mLightSensor;
                if (sensor != null) {
                    sensorManager.unregisterListener(this, sensor);
                }
                Sensor sensor2 = this.mProximitySensor;
                if (sensor2 != null) {
                    this.mSensorManager.unregisterListener(this, sensor2);
                }
            }
            this.mSensorManager = null;
            this.started = false;
        }
    }
}
