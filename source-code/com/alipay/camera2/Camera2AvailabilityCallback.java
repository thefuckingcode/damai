package com.alipay.camera2;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import com.alipay.camera.base.CameraStateTracer;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import tb.jl1;

@TargetApi(21)
/* compiled from: Taobao */
public class Camera2AvailabilityCallback extends CameraManager.AvailabilityCallback {
    private static boolean c;
    private ConcurrentHashMap<String, Stack<String>> a;
    private LimitedStateRecord b;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class LimitedStateRecord {
        private int a;
        private LinkedList<String> b = new LinkedList<>();

        public LimitedStateRecord(Camera2AvailabilityCallback camera2AvailabilityCallback, int i) {
            this.a = i;
        }

        public void offer(String str) {
            if (this.b.size() >= this.a) {
                this.b.poll();
            }
            this.b.offer(str);
        }

        public int size() {
            return this.b.size();
        }

        public String toString() {
            return this.b.toString();
        }
    }

    public Camera2AvailabilityCallback(final Context context, final Handler handler) {
        if (!c || context == null || handler == null) {
            MPaasLogger.e("Camera2AvailableCb", new Object[]{"Camera2AvailabilityCallback not enable."});
            return;
        }
        this.a = new ConcurrentHashMap<>();
        this.b = new LimitedStateRecord(this, 50);
        handler.post(new Runnable() {
            /* class com.alipay.camera2.Camera2AvailabilityCallback.AnonymousClass1 */

            public void run() {
                try {
                    ((CameraManager) context.getSystemService("camera")).registerAvailabilityCallback(Camera2AvailabilityCallback.this, handler);
                } catch (Throwable th) {
                    MPaasLogger.e("Camera2AvailableCb", new Object[]{"Camera2AvailabilityCallback construct with error:"}, th);
                }
            }
        });
    }

    public static void enableAvailableCallback(boolean z) {
        MPaasLogger.d("Camera2AvailableCb", new Object[]{"enableAvailableCallback:", Boolean.valueOf(z)});
        c = z;
    }

    public static boolean isAvailableCallbackCheckEnable() {
        return c;
    }

    public String getCameraAvailableInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Camera available history:" + getHistoryStates());
        sb.append(" ");
        sb.append("Current camera available:" + getStates());
        return sb.toString();
    }

    public String getHistoryStates() {
        LimitedStateRecord limitedStateRecord = this.b;
        if (limitedStateRecord == null) {
            return "null";
        }
        return limitedStateRecord.toString();
    }

    public String getStates() {
        if (this.a == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : this.a.keySet()) {
            Stack<String> stack = this.a.get(str);
            if (stack != null) {
                if (stack.empty()) {
                    sb.append(" " + str + "-UnAvailable.");
                } else {
                    sb.append(" " + str + "-Available(" + stack.firstElement() + ").");
                }
            }
        }
        return sb.toString();
    }

    public void onCameraAvailable(String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            MPaasLogger.d("Camera2AvailableCb", new Object[]{Long.valueOf(currentTimeMillis), ":onCameraAvailable, camera id:", str});
            Stack<String> stack = this.a.get(str);
            if (stack == null) {
                stack = new Stack<>();
                this.a.put(str, stack);
            }
            stack.push(String.valueOf(currentTimeMillis));
            LimitedStateRecord limitedStateRecord = this.b;
            limitedStateRecord.offer(str + "-Available(" + currentTimeMillis + jl1.BRACKET_END_STR);
            CameraStateTracer.recordCameraAvailable(currentTimeMillis, str);
        } catch (Throwable th) {
            MPaasLogger.e("Camera2AvailableCb", new Object[]{"onCameraAvailable with exception:"}, th);
        }
    }

    public void onCameraUnavailable(String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            MPaasLogger.d("Camera2AvailableCb", new Object[]{Long.valueOf(currentTimeMillis), ":onCameraUnavailable, camera id:", str});
            Stack<String> stack = this.a.get(str);
            if (stack != null) {
                stack.pop();
            }
            LimitedStateRecord limitedStateRecord = this.b;
            limitedStateRecord.offer(str + "-UnAvailable(" + currentTimeMillis + jl1.BRACKET_END_STR);
            CameraStateTracer.recordCameraUnAvailable(currentTimeMillis, str);
        } catch (Throwable th) {
            MPaasLogger.e("Camera2AvailableCb", new Object[]{"onCameraUnavailable with exception:"}, th);
        }
    }
}
