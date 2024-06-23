package com.alipay.camera2.operation.callback;

import android.annotation.TargetApi;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import com.alipay.camera.base.CameraFocusPerformanceHelper;
import com.alipay.camera2.CameraFocusStateDescription;
import com.alipay.camera2.operation.Camera2FocusManager;
import com.alipay.camera2.util.Camera2CharacteristicsCache;
import com.alipay.camera2.util.Camera2Utils;
import com.alipay.camera2.util.SystraceWrapper;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(21)
/* compiled from: Taobao */
public class Camera2CaptureCallback extends CameraCaptureSession.CaptureCallback {
    public static final String TAG = "Camera2CaptureCallback";
    private LimitedFrameRecord a = new LimitedFrameRecord(150);
    private final Camera2CharacteristicsCache b;
    private final Camera2FocusManager c;
    private final Camera2CaptureCallbackListener d;
    private long e;
    private PHONE_MOVEMENT_STATE f = PHONE_MOVEMENT_STATE.UNKNOWN;

    /* compiled from: Taobao */
    public interface Camera2CaptureCallbackListener {
        long getDurationOfBlur();

        long getDurationOfNonNeedCheckBlur();
    }

    /* compiled from: Taobao */
    public class LimitedFrameRecord {
        private int a;
        private ConcurrentLinkedQueue<String> b = new ConcurrentLinkedQueue<>();
        private float c = -1.0f;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private boolean i;
        private int j = Integer.MAX_VALUE;
        private ConcurrentHashMap<Integer, Long> k = new ConcurrentHashMap<>();
        private long l = 0;
        private float m = -1.0f;
        private float n = -1.0f;
        private long o = 0;
        private CameraFocusPerformanceHelper p = new CameraFocusPerformanceHelper();

        public LimitedFrameRecord(int i2) {
            this.a = i2;
            this.d = 0;
            this.e = 0;
        }

        private String b() {
            try {
                ConcurrentHashMap<Integer, Long> concurrentHashMap = this.k;
                if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                    return "NULL";
                }
                if (Camera2CaptureCallback.this.e == 0) {
                    return "NULL";
                }
                StringBuilder sb = new StringBuilder(256);
                for (Integer num : this.k.keySet()) {
                    Long l2 = this.k.get(num);
                    sb.append(num);
                    sb.append("=");
                    sb.append(l2);
                    sb.append("-");
                    sb.append(((float) l2.longValue()) / ((float) Camera2CaptureCallback.this.e));
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                }
                return sb.toString();
            } catch (Throwable th) {
                MPaasLogger.e(Camera2CaptureCallback.TAG, new Object[]{"getFocusDistanceStatistics with error:"}, th);
                return "UNKNOWN";
            }
        }

        private void c(float f2) {
            Long l2;
            int normalizeFocusDistance = Camera2Utils.normalizeFocusDistance(f2);
            Long l3 = this.k.get(Integer.valueOf(normalizeFocusDistance));
            if (l3 == null) {
                l2 = 1L;
            } else {
                l2 = Long.valueOf(l3.longValue() + 1);
            }
            this.k.put(Integer.valueOf(normalizeFocusDistance), l2);
            if (this.l <= l2.longValue()) {
                this.l = l2.longValue();
                this.m = (float) normalizeFocusDistance;
            }
            if (Camera2CaptureCallback.this.e > 0) {
                this.n = ((float) this.l) / ((float) Camera2CaptureCallback.this.e);
            }
        }

        public int getActiveScanFrameCount() {
            return this.f;
        }

        public int getFocusFailedFrameCount() {
            return this.d;
        }

        public int getFocusNotStartedFrameCount() {
            return this.e;
        }

        public long getFrameCount() {
            return Camera2CaptureCallback.this.e;
        }

        public boolean getInitFocusDistanceMatched() {
            return this.i;
        }

        public float getLastFocusDistance() {
            return this.c;
        }

        public float getMaxProportion() {
            return this.n;
        }

        public float getMaxProportionFocusDistance() {
            return this.m;
        }

        public int getPassiveScanFrameCount() {
            return this.g;
        }

        public int getSameFocusDistanceFrameCount() {
            return this.h;
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00a2  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0128  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0133  */
        public void offer(boolean z, int i2, float f2, int i3) {
            float f3;
            long j2;
            long j3;
            if (this.o <= 0) {
                this.o = System.currentTimeMillis();
            }
            this.p.offerCamera2FocusState(i2, Camera2CaptureCallback.this.e);
            c(f2);
            boolean z2 = Camera2CaptureCallback.this.f != PHONE_MOVEMENT_STATE.MOVING;
            if (Camera2CaptureCallback.this.e == 1 && Camera2CaptureCallback.this.c != null) {
                float initFocusDistance = Camera2CaptureCallback.this.c.getInitFocusDistance();
                if (initFocusDistance > 0.0f) {
                    this.i = ((double) Math.abs(initFocusDistance - f2)) < 0.005d;
                }
            }
            if (z2 && i2 != 0 && this.j == Integer.MAX_VALUE) {
                this.j = this.e;
            }
            if (z2) {
                float f4 = this.c;
                if (f4 >= 0.0f && ((double) Math.abs(f4 - f2)) <= 0.5d) {
                    this.h++;
                    this.c = f2;
                    if (z) {
                        this.f = 0;
                    }
                    if (i2 != 3) {
                        this.f++;
                    } else {
                        this.f = 0;
                    }
                    if (i2 != 1) {
                        this.g++;
                    } else {
                        this.g = 0;
                    }
                    if (z2 || i2 != 0) {
                        this.e = 0;
                    } else {
                        this.e++;
                    }
                    if ((z2 || i2 != 6) && i2 != 5) {
                        this.d = 0;
                    } else {
                        this.d++;
                    }
                    if (Camera2CaptureCallback.this.c == null) {
                        Camera2CaptureCallback.this.c.offerFocusState(z, i2, this.e, this.d, this.f);
                        if (Camera2CaptureCallback.this.d != null) {
                            j3 = Camera2CaptureCallback.this.d.getDurationOfBlur();
                            j2 = Camera2CaptureCallback.this.d.getDurationOfNonNeedCheckBlur();
                        } else {
                            j3 = -1;
                            j2 = 0;
                        }
                        f3 = f2;
                        Camera2CaptureCallback.this.c.offerFocusDistanceInfo(this.n, this.m, f2, this.o, i3, Camera2CaptureCallback.this.e, j3, j2);
                    } else {
                        f3 = f2;
                    }
                    if (this.b.size() >= this.a) {
                        this.b.poll();
                    }
                    this.b.offer(Camera2CaptureCallback.this.e + "-" + i2 + "-" + f3);
                }
            }
            this.h = 0;
            this.c = f2;
            if (z) {
            }
            if (i2 != 3) {
            }
            if (i2 != 1) {
            }
            if (z2) {
            }
            this.e = 0;
            if (z2) {
            }
            this.d = 0;
            if (Camera2CaptureCallback.this.c == null) {
            }
            if (this.b.size() >= this.a) {
            }
            this.b.offer(Camera2CaptureCallback.this.e + "-" + i2 + "-" + f3);
        }

        public int size() {
            return this.b.size();
        }

        public String toString() {
            return this.b.toString() + this.p.getString() + "###lastFocusDistance=" + this.c + "###FocusDistanceStatistics=" + b();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum PHONE_MOVEMENT_STATE {
        UNKNOWN,
        MOVING,
        STABLE
    }

    public Camera2CaptureCallback(Camera2CharacteristicsCache camera2CharacteristicsCache, Camera2FocusManager camera2FocusManager, Camera2CaptureCallbackListener camera2CaptureCallbackListener) {
        this.b = camera2CharacteristicsCache;
        this.c = camera2FocusManager;
        this.d = camera2CaptureCallbackListener;
        this.e = 0;
    }

    public String getAfState() {
        return this.a.toString();
    }

    public CameraFocusStateDescription getCameraFocusStateDescription() {
        CameraFocusStateDescription cameraFocusStateDescription = new CameraFocusStateDescription(this.a.getFrameCount(), this.b.isManualControlSupport(), this.b.getHyperFocusDistance(), this.a.getLastFocusDistance(), this.a.getFocusNotStartedFrameCount(), this.a.getFocusFailedFrameCount(), this.a.toString(), this.a.getActiveScanFrameCount(), this.a.getPassiveScanFrameCount(), this.a.getSameFocusDistanceFrameCount(), this.a.getInitFocusDistanceMatched(), String.valueOf(this.f));
        cameraFocusStateDescription.setMaxProportion(this.a.getMaxProportion());
        cameraFocusStateDescription.setMaxProportionFocusDistance(this.a.getMaxProportionFocusDistance());
        cameraFocusStateDescription.setMaxFocusDistance(this.b.getMaxFocusDistance());
        return cameraFocusStateDescription;
    }

    public int getFocusFirstTriggerFrameCount() {
        return this.a.j;
    }

    public long getFrameCount() {
        return this.a.getFrameCount();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025 A[Catch:{ all -> 0x0020 }] */
    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        boolean z;
        Camera2CharacteristicsCache camera2CharacteristicsCache;
        SystraceWrapper.beginTrace("onCaptureCompleted");
        this.e++;
        if (captureRequest != null) {
            try {
                if (((Integer) captureRequest.get(CaptureRequest.CONTROL_AF_TRIGGER)).intValue() == 1) {
                    z = true;
                    if (totalCaptureResult != null) {
                        int intValue = ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)).intValue();
                        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                        Float f2 = (Float) totalCaptureResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
                        if (!(num == null || f2 == null)) {
                            this.a.offer(z, num.intValue(), f2.floatValue(), intValue);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 28 && this.e == 1 && ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_SCENE_CHANGE)) != null && (camera2CharacteristicsCache = this.b) != null) {
                        camera2CharacteristicsCache.setSupportAfSceneChangedDetection();
                    }
                    SystraceWrapper.endTrace();
                }
            } catch (Throwable th) {
                MPaasLogger.e(TAG, new Object[]{"onCaptureCompleted with error:"}, th);
            }
        }
        z = false;
        if (totalCaptureResult != null) {
        }
        camera2CharacteristicsCache.setSupportAfSceneChangedDetection();
        SystraceWrapper.endTrace();
    }

    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
    }

    public void onMovementStatusChanged(boolean z) {
        this.f = z ? PHONE_MOVEMENT_STATE.MOVING : PHONE_MOVEMENT_STATE.STABLE;
    }
}
