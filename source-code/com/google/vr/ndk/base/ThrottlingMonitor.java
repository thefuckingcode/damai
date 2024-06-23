package com.google.vr.ndk.base;

import android.os.Handler;
import com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback;

/* compiled from: Taobao */
public class ThrottlingMonitor implements AutoCloseable {
    public static final int ERROR_NOT_ACCURATE = -4;
    public static final int ERROR_NOT_CONNECTED = -3;
    public static final int ERROR_NOT_SUPPORTED = -1;
    public static final int ERROR_NO_PERMISSION = -2;
    public static final int ERROR_UNKNOWN = -5;
    public static final int SUCCESS = 0;

    /* compiled from: Taobao */
    public interface SetupCallback {
        void onInitialized();
    }

    /* compiled from: Taobao */
    public interface TemperatureTrigger {
        void onTemperatureEvent(float f, long j);
    }

    /* compiled from: Taobao */
    static class ThrottlingTriggerCallback extends IThrottlingTriggerCallback.Stub {
        private final Handler handler;
        private final TemperatureTrigger trigger;

        public ThrottlingTriggerCallback(TemperatureTrigger temperatureTrigger, Handler handler2) {
            this.trigger = temperatureTrigger;
            this.handler = handler2;
        }

        @Override // com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback
        public void onTriggerActivated(final float f, final long j) {
            Handler handler2 = this.handler;
            if (handler2 == null) {
                this.trigger.onTemperatureEvent(f, j);
            } else {
                handler2.post(new Runnable() {
                    /* class com.google.vr.ndk.base.ThrottlingMonitor.ThrottlingTriggerCallback.AnonymousClass1 */

                    public void run() {
                        ThrottlingTriggerCallback.this.trigger.onTemperatureEvent(f, j);
                    }
                });
            }
        }
    }
}
