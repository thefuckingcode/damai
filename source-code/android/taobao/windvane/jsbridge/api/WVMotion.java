package android.taobao.windvane.jsbridge.api;

import android.annotation.TargetApi;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.ShakeListener;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alibaba.security.realidentity.jsbridge.a;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class WVMotion extends WVApiPlugin implements Handler.Callback {
    private static final int SHAKE_STOP = 1;
    private static final String TAG = "WVMotion";
    private BlowSensor blowSensor;
    private long currentTime = 0;
    private long currentTime2 = 0;
    private long frequency = 0;
    private long frequency2 = 0;
    private Handler handler = new Handler(Looper.getMainLooper(), this);
    private WVCallBackContext mCallback = null;
    protected SensorEventListener mSensorListener = new SensorEventListener() {
        /* class android.taobao.windvane.jsbridge.api.WVMotion.AnonymousClass3 */

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (9 == sensorEvent.sensor.getType() && WVMotion.this.frequency <= System.currentTimeMillis() - WVMotion.this.currentTime) {
                float[] fArr = sensorEvent.values;
                String str = "{\"x\":\"" + ((-fArr[0]) / 10.0f) + "\",\"y\":\"" + ((-fArr[1]) / 10.0f) + "\",\"z\":\"" + ((-fArr[2]) / 10.0f) + "\"}";
                if (WVMotion.this.mCallback != null) {
                    WVMotion.this.mCallback.fireEvent("motion.gyro", str);
                } else {
                    WVMotion.this.stopListenGyro();
                }
                WVMotion.this.currentTime = System.currentTimeMillis();
            }
        }
    };
    protected SensorEventListener mSensorListener2 = new SensorEventListener() {
        /* class android.taobao.windvane.jsbridge.api.WVMotion.AnonymousClass4 */

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (4 == sensorEvent.sensor.getType() && WVMotion.this.frequency2 <= System.currentTimeMillis() - WVMotion.this.currentTime2) {
                float[] fArr = sensorEvent.values;
                String str = "{\"alpha\":\"" + fArr[0] + "\",\"beta\":\"" + fArr[1] + "\",\"gama\":\"" + fArr[2] + "\"}";
                if (WVMotion.this.mCallback != null) {
                    WVMotion.this.mCallback.fireEvent("WV.Event.Motion.RotationRate", str);
                } else {
                    WVMotion.this.stopListenRota();
                }
                WVMotion.this.currentTime2 = System.currentTimeMillis();
            }
        }
    };
    private ShakeListener mShakeListener = null;
    private SensorManager sm = null;
    private Vibrator vibrator;

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public class MyShakeListener implements ShakeListener.OnShakeListener {
        private long frequency = 0;
        private long mLastUpdateTime = 0;
        private WVCallBackContext wvCallback = null;

        public MyShakeListener(WVCallBackContext wVCallBackContext, long j) {
            this.wvCallback = wVCallBackContext;
            this.frequency = j;
        }

        @Override // android.taobao.windvane.jsbridge.api.ShakeListener.OnShakeListener
        public void onShake() {
            if (((WVApiPlugin) WVMotion.this).isAlive) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.mLastUpdateTime >= this.frequency) {
                    WVResult wVResult = new WVResult();
                    wVResult.setSuccess();
                    WVCallBackContext wVCallBackContext = this.wvCallback;
                    if (wVCallBackContext != null) {
                        wVCallBackContext.fireEvent("motion.shake", wVResult.toJsonString());
                    }
                    this.mLastUpdateTime = currentTimeMillis;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void stopListenGyro() {
        SensorManager sensorManager = this.sm;
        if (sensorManager != null) {
            SensorEventListener sensorEventListener = this.mSensorListener;
            if (sensorEventListener != null) {
                sensorManager.unregisterListener(sensorEventListener);
            }
            this.sm = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void stopListenRota() {
        SensorManager sensorManager = this.sm;
        if (sensorManager != null) {
            SensorEventListener sensorEventListener = this.mSensorListener2;
            if (sensorEventListener != null) {
                sensorManager.unregisterListener(sensorEventListener);
            }
            this.sm = null;
        }
    }

    private void stopShake() {
        ShakeListener shakeListener = this.mShakeListener;
        if (shakeListener != null) {
            shakeListener.stop();
            this.mShakeListener = null;
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, final String str2, final WVCallBackContext wVCallBackContext) {
        if ("listeningShake".equals(str)) {
            listeningShake(wVCallBackContext, str2);
            return true;
        } else if ("vibrate".equals(str)) {
            vibrate(wVCallBackContext, str2);
            return true;
        } else if ("listenBlow".equals(str)) {
            try {
                PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.RECORD_AUDIO"}).setTaskOnPermissionGranted(new Runnable() {
                    /* class android.taobao.windvane.jsbridge.api.WVMotion.AnonymousClass2 */

                    public void run() {
                        WVMotion.this.listenBlow(wVCallBackContext, str2);
                    }
                }).setTaskOnPermissionDenied(new Runnable() {
                    /* class android.taobao.windvane.jsbridge.api.WVMotion.AnonymousClass1 */

                    public void run() {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("msg", a.al);
                        wVCallBackContext.error(wVResult);
                    }
                }).execute();
                return true;
            } catch (Exception unused) {
                return true;
            }
        } else if ("stopListenBlow".equals(str)) {
            stopListenBlow(wVCallBackContext, str2);
            return true;
        } else if ("listenGyro".equals(str)) {
            listenGyro(wVCallBackContext, str2);
            return true;
        } else if (!"listenRotationRate".equals(str)) {
            return false;
        } else {
            listenRotationRate(wVCallBackContext, str2);
            return true;
        }
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            stopShake();
            Object obj = message.obj;
            if (obj instanceof WVCallBackContext) {
                ((WVCallBackContext) obj).success(new WVResult());
            }
            return true;
        } else if (i != 4101) {
            if (i != 4102) {
                return false;
            }
            WVCallBackContext wVCallBackContext = this.mCallback;
            if (wVCallBackContext != null) {
                wVCallBackContext.error(new WVResult());
            }
            return true;
        } else if (!this.isAlive) {
            return true;
        } else {
            WVResult wVResult = new WVResult();
            wVResult.setSuccess();
            wVResult.addData("pass", "1");
            WVCallBackContext wVCallBackContext2 = this.mCallback;
            if (wVCallBackContext2 != null) {
                wVCallBackContext2.fireEvent("motion.blow", wVResult.toJsonString());
            }
            return true;
        }
    }

    public synchronized void listenBlow(WVCallBackContext wVCallBackContext, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVMotion", "listenBlow: start. " + str);
        }
        this.mCallback = wVCallBackContext;
        BlowSensor blowSensor2 = this.blowSensor;
        if (blowSensor2 != null) {
            blowSensor2.stop();
        }
        BlowSensor blowSensor3 = new BlowSensor(this.handler);
        this.blowSensor = blowSensor3;
        blowSensor3.start();
        wVCallBackContext.success(new WVResult());
    }

    public synchronized void listenGyro(WVCallBackContext wVCallBackContext, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVMotion", "listenGyro:  " + str);
        }
        WVResult wVResult = new WVResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.frequency = (long) jSONObject.optInt("frequency", 100);
            boolean optBoolean = jSONObject.optBoolean("on");
            this.mCallback = wVCallBackContext;
            if (this.sm == null) {
                this.sm = (SensorManager) this.mContext.getSystemService("sensor");
            }
            if (optBoolean) {
                SensorManager sensorManager = this.sm;
                sensorManager.registerListener(this.mSensorListener, com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 9), 3);
                this.currentTime = System.currentTimeMillis();
            } else {
                stopListenGyro();
            }
            wVCallBackContext.success(new WVResult());
        } catch (JSONException unused) {
            TaoLog.e("WVMotion", "vibrate: param parse to JSON error, param=" + str);
            wVResult.setResult("HY_PARAM_ERR");
            wVCallBackContext.error(wVResult);
        }
    }

    public synchronized void listenRotationRate(WVCallBackContext wVCallBackContext, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVMotion", "listenRotationRate:  " + str);
        }
        WVResult wVResult = new WVResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.frequency2 = (long) jSONObject.optInt("frequency", 100);
            boolean optBoolean = jSONObject.optBoolean("on");
            this.mCallback = wVCallBackContext;
            if (this.sm == null) {
                this.sm = (SensorManager) this.mContext.getSystemService("sensor");
            }
            if (optBoolean) {
                SensorManager sensorManager = this.sm;
                sensorManager.registerListener(this.mSensorListener2, com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 4), 3);
                this.currentTime = System.currentTimeMillis();
            } else {
                stopListenRota();
            }
            wVCallBackContext.success(new WVResult());
        } catch (JSONException unused) {
            TaoLog.e("WVMotion", "vibrate: param parse to JSON error, param=" + str);
            wVResult.setResult("HY_PARAM_ERR");
            wVCallBackContext.error(wVResult);
        }
    }

    public synchronized void listeningShake(WVCallBackContext wVCallBackContext, String str) {
        boolean z;
        WVResult wVResult = new WVResult();
        long j = 500;
        boolean z2 = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLDecoder.decode(str, "utf-8");
            } catch (Exception unused) {
                TaoLog.e("WVMotion", "listeningShake: param decode error, param=" + str);
                z2 = true;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                z = jSONObject.getBoolean("on");
                j = jSONObject.optLong("frequency");
            } catch (JSONException unused2) {
                TaoLog.e("WVMotion", "listeningShake: param parse to JSON error, param=" + str);
                wVResult.setResult("HY_PARAM_ERR");
                wVCallBackContext.error(wVResult);
                return;
            }
        } else {
            z = false;
        }
        if (z2) {
            if (TaoLog.getLogStatus()) {
                TaoLog.w("WVMotion", "listeningShake: isFail");
            }
            wVCallBackContext.error(wVResult);
            return;
        }
        if (z) {
            TaoLog.d("WVMotion", "listeningShake: start ...");
            if (this.mShakeListener == null) {
                this.mShakeListener = new ShakeListener(this.mContext, j);
            }
            this.mShakeListener.setOnShakeListener(new MyShakeListener(wVCallBackContext, j));
            wVCallBackContext.success(wVResult);
        } else {
            TaoLog.d("WVMotion", "listeningShake: stop.");
            Message message = new Message();
            message.what = 1;
            message.obj = wVCallBackContext;
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.sendMessage(message);
            }
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onDestroy() {
        stopShake();
        stopListenGyro();
        stopListenRota();
        Vibrator vibrator2 = this.vibrator;
        if (vibrator2 != null) {
            vibrator2.cancel();
            this.vibrator = null;
        }
        this.mCallback = null;
        BlowSensor blowSensor2 = this.blowSensor;
        if (blowSensor2 != null) {
            blowSensor2.stop();
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onPause() {
        SensorEventListener sensorEventListener;
        SensorManager sensorManager = this.sm;
        if (!(sensorManager == null || (sensorEventListener = this.mSensorListener) == null)) {
            sensorManager.unregisterListener(sensorEventListener);
        }
        ShakeListener shakeListener = this.mShakeListener;
        if (shakeListener != null) {
            shakeListener.pause();
        }
        BlowSensor blowSensor2 = this.blowSensor;
        if (blowSensor2 != null) {
            blowSensor2.stop();
        }
        super.onPause();
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    @TargetApi(9)
    public void onResume() {
        SensorEventListener sensorEventListener;
        SensorManager sensorManager = this.sm;
        if (!(sensorManager == null || (sensorEventListener = this.mSensorListener) == null)) {
            sensorManager.registerListener(sensorEventListener, com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 9), 3);
        }
        ShakeListener shakeListener = this.mShakeListener;
        if (shakeListener != null) {
            shakeListener.resume();
        }
        BlowSensor blowSensor2 = this.blowSensor;
        if (blowSensor2 != null) {
            blowSensor2.start();
        }
        super.onResume();
    }

    public synchronized void stopListenBlow(WVCallBackContext wVCallBackContext, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVMotion", "stopListenBlow: stopped. " + str);
        }
        BlowSensor blowSensor2 = this.blowSensor;
        if (blowSensor2 != null) {
            blowSensor2.stop();
            this.blowSensor = null;
        }
        wVCallBackContext.success(new WVResult());
    }

    public synchronized void vibrate(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        try {
            int i = 350;
            int optInt = new JSONObject(str).optInt("duration", 350);
            if (optInt >= 0) {
                i = optInt;
            }
            if (this.vibrator == null) {
                this.vibrator = (Vibrator) this.mContext.getSystemService("vibrator");
            }
            this.vibrator.vibrate((long) i);
            TaoLog.d("WVMotion", "vibrate: start ...");
            wVCallBackContext.success(new WVResult());
        } catch (JSONException unused) {
            TaoLog.e("WVMotion", "vibrate: param parse to JSON error, param=" + str);
            wVResult.setResult("HY_PARAM_ERR");
            wVCallBackContext.error(wVResult);
        }
    }
}
