package android.taobao.windvane.jsbridge.api;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.taobao.windvane.util.TaoLog;

/* compiled from: Taobao */
public class ShakeListener implements SensorEventListener {
    private static final int SPEED_THRESHOLD = 10;
    protected long TIME_INTERVAL_THRESHOLD = 100;
    private long mCheckFrequency = 100;
    private Context mContext;
    private long mLastUpdateTime;
    private float mLastX;
    private float mLastY;
    private float mLastZ;
    private SensorManager mSensorManager;
    private OnShakeListener mShakeListener;

    /* compiled from: Taobao */
    public interface OnShakeListener {
        void onShake();
    }

    public ShakeListener(Context context, long j) {
        long j2 = 100;
        this.mContext = context;
        long j3 = j / 10;
        this.mCheckFrequency = j3 > 100 ? j3 : j2;
        start();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        OnShakeListener onShakeListener;
        if (sensorEvent.sensor.getType() == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastUpdateTime >= this.mCheckFrequency) {
                float[] fArr = sensorEvent.values;
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = fArr[2];
                float f4 = f - this.mLastX;
                float f5 = f2 - this.mLastY;
                float f6 = f3 - this.mLastZ;
                if (Math.sqrt((double) ((f4 * f4) + (f5 * f5) + (f6 * f6))) > 10.0d && (onShakeListener = this.mShakeListener) != null && onShakeListener != null && Math.abs(this.mLastX) > 0.0f && Math.abs(this.mLastY) > 0.0f && Math.abs(this.mLastZ) > 0.0f) {
                    this.mShakeListener.onShake();
                }
                this.mLastUpdateTime = currentTimeMillis;
                this.mLastX = f;
                this.mLastY = f2;
                this.mLastZ = f3;
            }
        }
    }

    public void pause() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public void resume() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null && !sensorManager.registerListener(this, com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 1), 2)) {
            this.mSensorManager.unregisterListener(this);
            TaoLog.w("ShakeListener", "start: Accelerometer not supported");
        }
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.mShakeListener = onShakeListener;
    }

    public void start() {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        if (sensorManager == null) {
            TaoLog.w("ShakeListener", "start: Sensors not supported");
        } else if (!sensorManager.registerListener(this, com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 1), 2)) {
            this.mSensorManager.unregisterListener(this);
            TaoLog.w("ShakeListener", "start: Accelerometer not supported");
        }
    }

    public void stop() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.mSensorManager = null;
        }
    }
}
