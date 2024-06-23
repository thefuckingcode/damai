package com.alipay.camera2.operation;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.alipay.camera.base.CameraPerformanceRecorder;
import com.alipay.camera.base.CameraStateTracer;
import com.alipay.camera.util.CameraConfigurationUtils;
import com.alipay.camera2.Camera2Config;
import com.alipay.camera2.Camera2FocusAbnormalChecker;
import com.alipay.camera2.CameraFocusStateDescription;
import com.alipay.camera2.operation.Camera2FocusManager;
import com.alipay.camera2.operation.callback.Camera2CaptureCallback;
import com.alipay.camera2.operation.callback.OnReadImageListener;
import com.alipay.camera2.util.Camera2CharacteristicsCache;
import com.alipay.camera2.util.Camera2Utils;
import com.alipay.camera2.util.SystraceWrapper;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.CameraHandler;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.alipay.mobile.bqcscanservice.monitor.ScanCodeState;
import com.alipay.performance.ScanPerformanceConfig;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tb.v;

@TargetApi(26)
/* compiled from: Taobao */
public class Camera2Manager implements Camera2FocusManager.Camera2Operation, Camera2CaptureCallback.Camera2CaptureCallbackListener, CameraHandler.OnMessageHandleCallback {
    public static final int DEFAULT_MAX_RETRY_NUM = 4;
    private static int G = 4;
    private static int H = 4;
    private static boolean I = true;
    private int A = 0;
    private boolean B = false;
    private long C;
    private int D = 0;
    private ScanCodeState E;
    private final boolean F;
    private Context a;
    private CameraHandler b;
    private CameraManager c;
    private Camera2Config d;
    private CameraDevice.StateCallback e;
    private OnCameraStateCallback f;
    private Camera2CaptureCallback g;
    private CameraDevice h;
    private CaptureRequest.Builder i;
    private CameraCaptureSession j;
    private CameraCaptureSession.StateCallback k;
    private OnReadImageListener l;
    private volatile int m;
    private Rect n;
    private Rect o;
    private Camera2FocusManager p;
    private Camera2FocusParameterConfig q;
    private Surface r;
    private OutputConfiguration s;
    private OutputConfiguration t;
    private OutputConfiguration u;
    private Camera2CharacteristicsCache v;
    private CameraOpenStates w = CameraOpenStates.IDLE;
    private final CameraPerformanceRecorder x = new CameraPerformanceRecorder(true, "Scan2");
    private long y;
    private int z = 0;

    /* compiled from: Taobao */
    public enum Camera2RetryFlag {
        OPEN_EXCEPTION_RETRY,
        OPEN_CALLBACK_RETRY,
        CREATE_SESSION_FAIL_RETRY
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum CameraOpenStates {
        IDLE,
        OPENING,
        OPENED,
        DISCONNECTED,
        CALL_CLOSED
    }

    /* compiled from: Taobao */
    public interface OnCameraStateCallback {
        void onCamera2Closed();

        void onCamera2Opened();

        void onCaptureSessionConfigureFailed();

        void onCaptureSessionConfigured();

        void onCreateCaptureSessionError(int i, String str);

        void onError(CameraDevice cameraDevice, int i, boolean z);

        void onFinalizeOutputConfigurationsError(int i, String str);

        void onRetryOpenCameraError(int i, String str);

        void onSetCaptureRequestError(int i, String str);

        void onTorchModeChanged(boolean z);

        void showRetryInfoToUser(String str);
    }

    public Camera2Manager(Context context, CameraHandler cameraHandler, Camera2Config camera2Config, OnReadImageListener onReadImageListener, Camera2CharacteristicsCache camera2CharacteristicsCache, ScanCodeState scanCodeState) {
        this.a = context;
        this.b = cameraHandler;
        this.l = onReadImageListener;
        this.d = camera2Config == null ? new Camera2Config() : camera2Config;
        this.q = new Camera2FocusParameterConfig(camera2CharacteristicsCache);
        this.v = camera2CharacteristicsCache;
        this.p = new Camera2FocusManager(this.b, this, this.f, this.q, this.v);
        this.g = new Camera2CaptureCallback(camera2CharacteristicsCache, this.p, this);
        this.c = this.v.getSystemCameraManager();
        this.E = scanCodeState;
        this.F = ScanPerformanceConfig.needDowngradeCameraParams();
        F();
        this.e = new CameraDevice.StateCallback() {
            /* class com.alipay.camera2.operation.Camera2Manager.AnonymousClass1 */

            public void onClosed(CameraDevice cameraDevice) {
                MPaasLogger.d("Camera2Manager", new Object[]{"CameraDevice.StateCallback.onClosed"});
                if (Camera2Manager.this.E != null) {
                    Camera2Manager.this.E.setCameraClosed();
                }
            }

            public void onDisconnected(CameraDevice cameraDevice) {
                MPaasLogger.d("Camera2Manager", new Object[]{"CameraDevice.StateCallback.onDisconnected:", cameraDevice.getId()});
                if (Camera2Manager.this.h != null) {
                    cameraDevice.close();
                    if (cameraDevice.toString().equalsIgnoreCase(Camera2Manager.this.h.toString())) {
                        Camera2Manager.this.w = CameraOpenStates.DISCONNECTED;
                        Camera2Manager.this.h = null;
                        Camera2Manager.this.j = null;
                        return;
                    }
                    return;
                }
                MPaasLogger.d("Camera2Manager", new Object[]{"CameraDevice onDisconnected ignored."});
            }

            public void onError(CameraDevice cameraDevice, int i) {
                MPaasLogger.d("Camera2Manager", new Object[]{"CameraDevice.StateCallback.onError, errorCode:", Integer.valueOf(i), ", mOpenCameraExceptionRetryCount:", Integer.valueOf(Camera2Manager.this.D)});
                CameraStateTracer.recordOnErrorEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.ON_ERROR, i);
                if (Camera2Manager.this.h == null || cameraDevice == null || Camera2Manager.this.h.toString().equalsIgnoreCase(cameraDevice.toString())) {
                    Camera2Manager.this.w = CameraOpenStates.IDLE;
                    if (Camera2Manager.this.h != null) {
                        Camera2Manager.this.h = null;
                        Camera2Manager.this.j = null;
                        if (Camera2Manager.this.f != null) {
                            Camera2Manager.this.f.onError(cameraDevice, i, false);
                        }
                    } else if (Camera2Manager.this.D > 0) {
                        MPaasLogger.d("Camera2Manager", new Object[]{"CameraDevice.StateCallback.onError ignore."});
                    } else {
                        boolean E = Camera2Manager.this.E();
                        MPaasLogger.d("Camera2Manager", new Object[]{"CameraDevice.StateCallback.onError, retry open camera, canContinueRetry:", Boolean.valueOf(E), ", errorCode:", Integer.valueOf(i), ", mRetryStopFlag:", Boolean.valueOf(Camera2Manager.this.B)});
                        if (!E) {
                            Camera2Manager.this.z(false, String.valueOf(i));
                            if (!Camera2Manager.this.B && Camera2Manager.this.f != null) {
                                Camera2Manager.this.f.onError(cameraDevice, i, true);
                            }
                        }
                    }
                } else {
                    MPaasLogger.w("Camera2Manager", new Object[]{"ignore previous camera device error, device!=mCameraDevice"});
                }
            }

            public void onOpened(CameraDevice cameraDevice) {
                Object[] objArr = new Object[4];
                objArr[0] = "CameraDevice.StateCallback.onOpened: camera != null?";
                objArr[1] = Boolean.valueOf(cameraDevice != null);
                objArr[2] = ",retry start preview num:";
                objArr[3] = Integer.valueOf(Camera2Manager.this.z);
                MPaasLogger.d("Camera2Manager", objArr);
                Camera2Manager.this.z(true, "NULL");
                if (Camera2Manager.this.w == CameraOpenStates.CALL_CLOSED) {
                    cameraDevice.close();
                    Camera2Manager.this.w = CameraOpenStates.IDLE;
                    return;
                }
                Camera2Manager.this.x.setEndOpenCamera(System.currentTimeMillis());
                SystraceWrapper.beginTrace("onOpened");
                Camera2Manager.this.h = cameraDevice;
                Camera2Manager.this.w = CameraOpenStates.OPENED;
                if (Camera2Manager.this.z > 0) {
                    Camera2Manager camera2Manager = Camera2Manager.this;
                    camera2Manager.createCameraPreviewSession(camera2Manager.r);
                } else if (Camera2Manager.this.f != null) {
                    Camera2Manager.this.f.onCamera2Opened();
                }
                Camera2Manager.this.D = 0;
                SystraceWrapper.endTrace();
                if (Camera2Manager.this.E != null) {
                    Camera2Manager.this.E.setCameraOpened();
                }
            }
        };
        this.k = new CameraCaptureSession.StateCallback() {
            /* class com.alipay.camera2.operation.Camera2Manager.AnonymousClass2 */

            public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                MPaasLogger.e("Camera2Manager", new Object[]{"CameraCaptureSession onConfigureFailed, retry start preview num:", Integer.valueOf(Camera2Manager.this.z)});
                if (Camera2Manager.this.z <= 0 && Camera2Manager.this.f != null) {
                    Camera2Manager.this.f.onCaptureSessionConfigureFailed();
                }
            }

            public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                MPaasLogger.d("Camera2Manager", new Object[]{"CameraCaptureSession onConfigured"});
                if (Camera2Manager.this.h != null) {
                    SystraceWrapper.beginTrace("onConfigured");
                    Camera2Manager.this.j = cameraCaptureSession;
                    if (Camera2Manager.this.v != null && Camera2Manager.this.i != null) {
                        Camera2ConfigurationUtils.setup3AControlsLocked(Camera2Manager.this.v, Camera2Manager.this.d, Camera2Manager.this.i, Camera2Manager.this.q.getInitFocusMode(), Camera2Manager.this.q.getHistoryAvgFocusDistance());
                        if ((Camera2Manager.this.s != null ? Camera2Manager.this.s.getSurface() != null ? Camera2Manager.this.C() : false : true) && Camera2Manager.this.K()) {
                            Camera2Manager.this.L();
                        }
                        Camera2Manager.this.x.setEndStartPreview(System.currentTimeMillis());
                        if (Camera2Manager.this.f != null) {
                            Camera2Manager.this.f.onCaptureSessionConfigured();
                        }
                        MPaasLogger.d("Camera2Manager", new Object[]{"CameraCaptureSession onConfigured end"});
                        SystraceWrapper.endTrace();
                    }
                }
            }
        };
    }

    private boolean A() {
        if (!G()) {
            MPaasLogger.e("Camera2Manager", new Object[]{"doChangeFocusModeInRepeating, but device is invalid."});
            return false;
        }
        this.i.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.q.getSecondFocusMode()));
        if (this.q.secondFocusModeIsAuto()) {
            Camera2ConfigurationUtils.setAfAeRegion(this.v, this.i, this.d.previewSize, this.o, this.n);
        }
        MPaasLogger.d("Camera2Manager", new Object[]{"autofocus change af mode to auto."});
        return K();
    }

    private boolean B() {
        Camera2CharacteristicsCache camera2CharacteristicsCache = this.v;
        if (!(camera2CharacteristicsCache == null || this.q == null || this.b == null || this.o == null)) {
            boolean hasFocuser = camera2CharacteristicsCache.hasFocuser();
            boolean secondFocusModeIsAuto = this.q.secondFocusModeIsAuto();
            if (hasFocuser && secondFocusModeIsAuto) {
                this.b.sendMessage(CameraHandler.SECOND_FOCUS_DELAY_MESSAGE.intValue());
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean C() {
        if (this.j == null || this.s == null || this.i == null) {
            MPaasLogger.d("Camera2Manager", new Object[]{"doFinalizePreviewOutputConfiguration return false."});
            return false;
        }
        MPaasLogger.d("Camera2Manager", new Object[]{"doFinalizePreviewOutputConfiguration"});
        SystraceWrapper.beginTrace("Finalize-OutputConfiguration");
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.s);
        try {
            this.j.finalizeOutputConfigurations(arrayList);
            this.i.addTarget(this.s.getSurface());
            SystraceWrapper.endTrace();
            return true;
        } catch (CameraAccessException e2) {
            MPaasLogger.e("Camera2Manager", new Object[]{"doFinalizePreviewOutputConfiguration:"}, e2);
            OnCameraStateCallback onCameraStateCallback = this.f;
            if (onCameraStateCallback != null) {
                onCameraStateCallback.onFinalizeOutputConfigurationsError(e2.getReason(), e2.getMessage());
            }
            return false;
        } catch (IllegalArgumentException e3) {
            MPaasLogger.e("Camera2Manager", new Object[]{"doFinalizePreviewOutputConfiguration"}, e3);
            OnCameraStateCallback onCameraStateCallback2 = this.f;
            if (onCameraStateCallback2 != null) {
                onCameraStateCallback2.onFinalizeOutputConfigurationsError(-888, e3.getMessage());
            }
            return false;
        }
    }

    private boolean D() {
        int i2;
        MPaasLogger.d("Camera2Manager", new Object[]{"doRestartCamera, mRetryStopFlag:", Boolean.valueOf(this.B), ",mCurrentStartPreviewRetryNum:", Integer.valueOf(this.z)});
        if (this.B || (i2 = this.z) >= H - 1) {
            MPaasLogger.d("Camera2Manager", new Object[]{"doRestartCamera return false."});
            return false;
        }
        if (i2 == 0) {
            try {
                this.C = SystemClock.elapsedRealtime();
            } catch (Exception e2) {
                MPaasLogger.e("Camera2Manager", new Object[]{"doRestartCamera fail:"}, e2);
                this.z = 0;
                OnCameraStateCallback onCameraStateCallback = this.f;
                if (onCameraStateCallback != null) {
                    onCameraStateCallback.onRetryOpenCameraError(1204, e2.getMessage());
                }
                return false;
            }
        }
        CameraDevice cameraDevice = this.h;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.h = null;
            this.w = CameraOpenStates.IDLE;
        }
        OnCameraStateCallback onCameraStateCallback2 = this.f;
        if (onCameraStateCallback2 != null && this.z == 3) {
            onCameraStateCallback2.showRetryInfoToUser("Preview");
        }
        Thread.sleep(1000);
        if (this.B) {
            MPaasLogger.d("Camera2Manager", new Object[]{"doRestartCamera retry canceled."});
            return false;
        }
        this.z++;
        openCamera();
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean E() {
        int i2;
        MPaasLogger.d("Camera2Manager", new Object[]{"doRetryOpenCameraForCallbackError, mRetryStopFlag:", Boolean.valueOf(this.B), ", mCurrentOpenRetryNum:", Integer.valueOf(this.A), ", MAX_RETRY_NUM:", Integer.valueOf(G)});
        if (this.B || (i2 = this.A) >= G - 1) {
            MPaasLogger.d("Camera2Manager", new Object[]{"doRetryOpenCameraForCallbackError return false."});
            return false;
        }
        if (i2 == 0) {
            try {
                this.C = SystemClock.elapsedRealtime();
            } catch (Exception e2) {
                MPaasLogger.e("Camera2Manager", new Object[]{"doRetryOpenCameraForCallbackError fail:"}, e2);
                OnCameraStateCallback onCameraStateCallback = this.f;
                if (onCameraStateCallback != null) {
                    onCameraStateCallback.onRetryOpenCameraError(1205, e2.getMessage());
                }
                return true;
            }
        }
        OnCameraStateCallback onCameraStateCallback2 = this.f;
        if (onCameraStateCallback2 != null && this.A == 3) {
            onCameraStateCallback2.showRetryInfoToUser("Camera");
        }
        Thread.sleep(1000);
        if (this.B) {
            MPaasLogger.d("Camera2Manager", new Object[]{"doRetryOpenCameraForCallbackError retry canceled."});
            return false;
        }
        this.A++;
        openCamera();
        return true;
    }

    private void F() {
        Camera2CharacteristicsCache camera2CharacteristicsCache;
        String str;
        Object[] objArr = new Object[4];
        objArr[0] = "init, camera2CharacteristicsCache==null?";
        objArr[1] = Boolean.valueOf(this.v == null);
        objArr[2] = ",sChooseBestForRecognizeYUV:";
        objArr[3] = Boolean.valueOf(I);
        MPaasLogger.d("Camera2Manager", objArr);
        if (this.d == null || (camera2CharacteristicsCache = this.v) == null || this.a == null || this.b == null || !camera2CharacteristicsCache.valid()) {
            MPaasLogger.e("Camera2Manager", new Object[]{"init, Camera2Manager may destroy, ignore this."});
            return;
        }
        if (H()) {
            Display defaultDisplay = ((WindowManager) this.a.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
            Point point = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
            Camera2Config camera2Config = this.d;
            camera2Config.screenResolution = point;
            camera2Config.needDowngradeCameraParams = this.F;
            if (I) {
                camera2Config.previewSize = Camera2Utils.findBestForScanPreviewSize(this.v.getOrderedOutputYuvSizeList(), point, this.d.needDowngradeCameraParams);
            }
            if (this.d.previewSize == null) {
                MPaasLogger.d("Camera2Manager", new Object[]{"Best for recognize not found, try find preview size again."});
                this.d.previewSize = CameraConfigurationUtils.findBestPreviewSizeValue(this.v.getOrderedOutputYuvSizeList(), point, this.d.needDowngradeCameraParams);
            }
            Camera2Config camera2Config2 = this.d;
            List<Point> orderedOutputYuvSizeList = this.v.getOrderedOutputYuvSizeList();
            Camera2Config camera2Config3 = this.d;
            camera2Config2.downgradePreviewSize = Camera2Utils.findCloseToScreenPreviewSize(orderedOutputYuvSizeList, camera2Config3.screenResolution, camera2Config3.previewSize);
            this.d.pictureSize = Camera2Utils.findBestJpegSize(this.v.getOrderedOutputYuvSizeList().get(0), this.v.getOrderedOutputJpegSizeList(), this.d.previewSize);
        }
        Object[] objArr2 = new Object[12];
        objArr2[0] = "init preview size:";
        objArr2[1] = Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.d.previewSize));
        objArr2[2] = Constants.Name.X;
        objArr2[3] = Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.d.previewSize));
        objArr2[4] = ", picture size:";
        objArr2[5] = Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.d.pictureSize));
        objArr2[6] = Constants.Name.X;
        objArr2[7] = Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.d.pictureSize));
        objArr2[8] = ", downgrade preview size:";
        Point point2 = this.d.downgradePreviewSize;
        if (point2 == null) {
            str = "null";
        } else {
            str = point2.toString();
        }
        objArr2[9] = str;
        objArr2[10] = ", support picture size:";
        objArr2[11] = Boolean.valueOf(this.d.supportPictureSize());
        MPaasLogger.d("Camera2Manager", objArr2);
        this.n = this.v.getCropRegionForNonZoom();
        this.d.objCameraId = this.v.getCameraIdStr();
        this.d.previewFormat = this.v.getYuvFormat();
        Camera2Config camera2Config4 = this.d;
        Camera2CharacteristicsCache camera2CharacteristicsCache2 = this.v;
        Point point3 = this.d.previewSize;
        camera2Config4.fpsRange = camera2CharacteristicsCache2.getFpsRange(new Size(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3)));
        this.d.initImageReader();
        this.d.yuvImageReader.setOnImageAvailableListener(this.l, this.b.getCameraHandler());
    }

    private boolean G() {
        return (this.h == null || this.i == null || this.j == null) ? false : true;
    }

    private boolean H() {
        Camera2Config camera2Config = this.d;
        if (camera2Config == null || this.a == null) {
            return false;
        }
        if (!camera2Config.valid()) {
            return true;
        }
        Display defaultDisplay = ((WindowManager) this.a.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        Point point = new Point();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
        if (!this.d.screenResolution.equals(point) || (!this.d.needDowngradeCameraParams) != this.F) {
            return true;
        }
        return false;
    }

    private void I() {
        CameraHandler cameraHandler = this.b;
        if (cameraHandler != null) {
            Integer num = CameraHandler.SECOND_FOCUS_DELAY_MESSAGE;
            cameraHandler.clearMessages(num.intValue());
            this.b.removeCallback(num);
        }
    }

    private void J(int i2) {
        CaptureRequest.Builder builder;
        Camera2CharacteristicsCache camera2CharacteristicsCache = this.v;
        if (camera2CharacteristicsCache == null || (builder = this.i) == null) {
            MPaasLogger.e("Camera2Manager", new Object[]{"setZoomParameter status error."});
            return;
        }
        Rect zoom = Camera2ConfigurationUtils.setZoom(camera2CharacteristicsCache, builder, i2);
        this.n = zoom;
        if (!(this.o == null || zoom == null || !this.d.valid())) {
            Camera2ConfigurationUtils.setAfAeRegion(this.v, this.i, this.d.previewSize, this.o, this.n);
        }
        K();
        this.m = i2;
        ScanCodeState scanCodeState = this.E;
        if (scanCodeState != null) {
            scanCodeState.setZoom(i2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean K() {
        CameraCaptureSession cameraCaptureSession;
        MPaasLogger.d("Camera2Manager", new Object[]{"setRepeatingRequest"});
        if (MPaasLogger.isDebuggable()) {
            SystraceWrapper.beginTrace("setRepeatingRequest");
        }
        try {
            CaptureRequest.Builder builder = this.i;
            if (!(builder == null || (cameraCaptureSession = this.j) == null)) {
                cameraCaptureSession.setRepeatingRequest(builder.build(), this.g, this.b.getCameraHandler());
            }
            SystraceWrapper.endTrace();
            MPaasLogger.d("Camera2Manager", new Object[]{"setRepeatingRequest end"});
            return true;
        } catch (CameraAccessException e2) {
            MPaasLogger.e("Camera2Manager", new Object[]{"setRepeatingRequest exception:"}, e2);
            OnCameraStateCallback onCameraStateCallback = this.f;
            if (onCameraStateCallback != null) {
                onCameraStateCallback.onSetCaptureRequestError(e2.getReason(), e2.getMessage());
            }
            return false;
        } catch (Exception e3) {
            MPaasLogger.e("Camera2Manager", new Object[]{"setRepeatingRequest exception:"}, e3);
            OnCameraStateCallback onCameraStateCallback2 = this.f;
            if (onCameraStateCallback2 != null) {
                onCameraStateCallback2.onSetCaptureRequestError(1402, e3.getMessage());
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void L() {
        Camera2CharacteristicsCache camera2CharacteristicsCache = this.v;
        if (camera2CharacteristicsCache != null && this.q != null && this.b != null && this.p != null) {
            boolean hasFocuser = camera2CharacteristicsCache.hasFocuser();
            boolean initFocusModeIsAuto = this.q.initFocusModeIsAuto();
            if (hasFocuser && initFocusModeIsAuto) {
                MPaasLogger.d("Camera2Manager", new Object[]{"startAutoFocusTriggerForInitAutoMode"});
                this.p.startAutoFocusTrigger();
            }
        }
    }

    public static void setEnableChooseBestForRecognizeYUV(String str) {
        MPaasLogger.d("Camera2Manager", new Object[]{"setEnableChooseBestForRecognizeYUV:", str});
        if (!TextUtils.isEmpty(str)) {
            I = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
        }
    }

    public static void setEnableSecondFocusModeSwitch(String str) {
        Camera2FocusManager.setEnableSecondFocusModeSwitch(str);
    }

    public static void setMaxRetryNum(int i2) {
        MPaasLogger.d("Camera2Manager", new Object[]{"setMaxRetryNum:", Integer.valueOf(i2)});
        G = i2;
    }

    public static void setMaxRetryStartPreviewNum(int i2) {
        MPaasLogger.d("Camera2Manager", new Object[]{"setMaxRetryStartPreviewNum:", Integer.valueOf(i2)});
        H = i2;
    }

    private void x() {
        CameraHandler cameraHandler = this.b;
        if (cameraHandler != null) {
            cameraHandler.addCallback(CameraHandler.SECOND_FOCUS_DELAY_MESSAGE, this);
        }
    }

    private void y() {
        Camera2FocusAbnormalChecker camera2FocusAbnormalChecker;
        try {
            StringBuilder sb = new StringBuilder();
            Camera2Config camera2Config = this.d;
            if (camera2Config != null) {
                if (camera2Config.previewSize != null) {
                    sb.append("###yuvSizeWidth=" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.d.previewSize));
                    sb.append("###yuvSizeHeight=" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.d.previewSize));
                }
                if (this.d.downgradePreviewSize != null) {
                    sb.append("###downgradePreviewSizeWidth=" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.d.downgradePreviewSize));
                    sb.append("###downgradePreviewSizeHeight=" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.d.downgradePreviewSize));
                }
                if (this.d.pictureSize != null) {
                    sb.append("###jpegSizeWidth=" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.d.pictureSize));
                    sb.append("###jpegSizeHeight=" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.d.pictureSize));
                }
                sb.append("###useJpegStream=" + this.d.supportPictureSize());
            }
            Camera2CharacteristicsCache camera2CharacteristicsCache = this.v;
            if (camera2CharacteristicsCache != null) {
                List<Point> orderedOutputYuvSizeList = camera2CharacteristicsCache.getOrderedOutputYuvSizeList();
                List<Point> orderedOutputJpegSizeList = this.v.getOrderedOutputJpegSizeList();
                int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(orderedOutputJpegSizeList.get(0)) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(orderedOutputJpegSizeList.get(0));
                int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(orderedOutputYuvSizeList.get(0)) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(orderedOutputYuvSizeList.get(0));
                sb.append("###cameraid=" + this.v.getCameraIdStr());
                sb.append("###hardwareLevel=" + this.v.getHardwareLevel());
                List<CaptureRequest.Key<?>> availableSessionKeys = this.v.getAvailableSessionKeys();
                if (availableSessionKeys != null && availableSessionKeys.size() > 0) {
                    sb.append("###sessionKeySize=" + String.valueOf(availableSessionKeys.size()));
                    sb.append("###availableSessionKeys=" + availableSessionKeys);
                }
                sb.append("###availableFpsRanges=" + Camera2Utils.rangeArrayToString(this.v.getAvailableFpsRangeList()));
                sb.append("###availableAFModes=" + Arrays.toString(this.v.getAvailableAfModes()));
                sb.append("###availableYuvSizes=" + orderedOutputYuvSizeList);
                sb.append("###availableJpegSize=" + orderedOutputJpegSizeList);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("###maxJpegLargerMaxYuv=");
                sb2.append(xVar > xVar2);
                sb.append(sb2.toString());
                sb.append("###afSceneChangeDetection=" + String.valueOf(this.v.isSupportAfSceneChangedDetection()));
                sb.append("###activeArraySize=");
                sb.append(String.valueOf(this.v.getActiveArraySize()));
            }
            if (this.q != null) {
                sb.append("###firstFocusMode=" + this.q.getInitFocusMode());
                sb.append("###secondFocusMode=" + this.q.getSecondFocusMode());
            }
            CaptureRequest.Builder builder = this.i;
            if (builder != null) {
                Integer num = (Integer) builder.get(CaptureRequest.CONTROL_AF_MODE);
                if (num != null) {
                    sb.append("###lastFocusMode=" + num);
                }
                Range range = (Range) this.i.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
                if (range != null) {
                    sb.append("###fpsRange=" + range);
                }
                MeteringRectangle[] meteringRectangleArr = (MeteringRectangle[]) this.i.get(CaptureRequest.CONTROL_AF_REGIONS);
                if (meteringRectangleArr != null && meteringRectangleArr.length > 0) {
                    sb.append("###afRegion=" + meteringRectangleArr[0].toString());
                }
                MeteringRectangle[] meteringRectangleArr2 = (MeteringRectangle[]) this.i.get(CaptureRequest.CONTROL_AE_REGIONS);
                if (meteringRectangleArr != null && meteringRectangleArr.length > 0) {
                    sb.append("###aeRegions=" + meteringRectangleArr2[0].toString());
                }
            }
            sb.append("###currentCropRegion=");
            sb.append(String.valueOf(this.n));
            Camera2FocusManager camera2FocusManager = this.p;
            if (!(camera2FocusManager == null || (camera2FocusAbnormalChecker = camera2FocusManager.getCamera2FocusAbnormalChecker()) == null)) {
                sb.append(camera2FocusAbnormalChecker.toString());
            }
            sb.append("###pipelineMode=");
            sb.append(String.valueOf(Camera2ConfigurationUtils.sPipelineMode));
            if (sb.length() > 0) {
                if (MPaasLogger.isDebuggable()) {
                    MPaasLogger.d("Camera2Manager", new Object[]{"buryCamera2Params:", sb.toString()});
                }
                WalletBury.addWalletBury("recordCamera2ParamsDetail", new Class[]{String.class}, new Object[]{sb.toString()});
            }
        } catch (Throwable th) {
            MPaasLogger.e("Camera2Manager", new Object[]{"buryCamera2Params error:"}, th);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void z(boolean z2, String str) {
        MPaasLogger.d("Camera2Manager", new Object[]{"buryRetryOpenCameraForCallback, retry num:", Integer.valueOf(this.A), ",mRetryStopFlag:", Boolean.valueOf(this.B), ",retrySuccess:", Boolean.valueOf(z2)});
        if (this.A > 0) {
            Class cls = Boolean.TYPE;
            WalletBury.addWalletBury("recordCamera2RetryInfo", new Class[]{String.class, cls, Integer.TYPE, Long.TYPE, cls, String.class}, new Object[]{String.valueOf(Camera2RetryFlag.OPEN_CALLBACK_RETRY), Boolean.valueOf(z2), Integer.valueOf(this.A), Long.valueOf(SystemClock.elapsedRealtime() - this.C), Boolean.valueOf(this.B), str});
            this.A = 0;
        }
    }

    public void addCameraStateCallback(OnCameraStateCallback onCameraStateCallback) {
        MPaasLogger.d("Camera2Manager", new Object[]{"addCameraStateCallback"});
        this.f = onCameraStateCallback;
        x();
    }

    @Override // com.alipay.camera2.operation.Camera2FocusManager.Camera2Operation
    public boolean changeToSecondFocusMode() {
        return B();
    }

    public void closeCamera() {
        MPaasLogger.d("Camera2Manager", new Object[]{"start to closeCamera"});
        y();
        try {
            if (this.w == CameraOpenStates.OPENING) {
                this.w = CameraOpenStates.CALL_CLOSED;
            }
            this.d.yuvImageReader.setOnImageAvailableListener(null, null);
            Camera2FocusManager camera2FocusManager = this.p;
            if (camera2FocusManager != null) {
                camera2FocusManager.stopAutoFocusTrigger();
            }
            if (this.j != null) {
                CameraStateTracer.recordEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.STOP_PREVIEW);
                this.x.setBeginStopPreview(System.currentTimeMillis());
                this.j.abortCaptures();
                this.x.setEndStopPreview(System.currentTimeMillis());
                this.j = null;
            }
            if (this.h != null) {
                CameraStateTracer.recordEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.RELEASE);
                this.x.setBeginCloseCamera(System.currentTimeMillis());
                this.h.close();
                Camera2CaptureCallback camera2CaptureCallback = this.g;
                if (camera2CaptureCallback != null) {
                    this.x.setFirstTriggerFrameCount(camera2CaptureCallback.getFocusFirstTriggerFrameCount());
                }
                this.x.setEndCloseCamera(System.currentTimeMillis());
                this.h = null;
                this.w = CameraOpenStates.IDLE;
                OnCameraStateCallback onCameraStateCallback = this.f;
                if (onCameraStateCallback != null) {
                    onCameraStateCallback.onCamera2Closed();
                }
            }
            this.r = null;
            this.s = null;
            this.t = null;
            this.u = null;
            this.d.yuvImageReader.close();
            this.d.jpegImageReader.close();
            this.v = null;
            this.i = null;
            MPaasLogger.d("Camera2Manager", new Object[]{"end to closeCamera"});
        } catch (Exception unused) {
        }
    }

    public void createCameraPreviewSession(Surface surface) {
        String str;
        String str2;
        if (surface == null || !surface.isValid()) {
            MPaasLogger.e("Camera2Manager", new Object[]{"createCameraPreviewSession with surface status invalid."});
        } else if (this.h == null) {
            MPaasLogger.w("Camera2Manager", new Object[]{"createCameraPreviewSession with mCameraDevice == null."});
            if (this.w == CameraOpenStates.DISCONNECTED) {
                D();
            }
        } else {
            Exception exc = null;
            try {
                MPaasLogger.d("Camera2Manager", new Object[]{"doCreateCameraPreviewSession begin, max retry num:", Integer.valueOf(H)});
                SystraceWrapper.beginTrace("createCaptureRequest");
                this.r = surface;
                this.i = this.h.createCaptureRequest(1);
                SystraceWrapper.endTrace();
                ArrayList arrayList = new ArrayList();
                this.i.addTarget(surface);
                arrayList.add(surface);
                if (this.d != null && Camera2Config.supportYuvStream()) {
                    this.i.addTarget(this.d.yuvImageReader.getSurface());
                    arrayList.add(this.d.yuvImageReader.getSurface());
                }
                Camera2Config camera2Config = this.d;
                if (camera2Config != null && camera2Config.supportPictureSize()) {
                    arrayList.add(this.d.jpegImageReader.getSurface());
                }
                SystraceWrapper.beginTrace("createCaptureSession");
                CameraStateTracer.recordEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.START_PREVIEW);
                this.x.setBeginStartPreview(System.currentTimeMillis());
                MPaasLogger.d("Camera2Manager", new Object[]{"createCameraPreviewSession surface size:", Integer.valueOf(arrayList.size())});
                this.h.createCaptureSession(arrayList, this.k, this.b.getCameraHandler());
                SystraceWrapper.endTrace();
            } catch (Exception e2) {
                exc = e2;
                MPaasLogger.e("Camera2Manager", new Object[]{"doCreateCameraPreviewSession Exception, retry start preview num:", Integer.valueOf(this.z)}, exc);
                if (!D()) {
                    OnCameraStateCallback onCameraStateCallback = this.f;
                    if (onCameraStateCallback != null && !this.B) {
                        onCameraStateCallback.onCreateCaptureSessionError(1400, exc.getMessage());
                    }
                } else {
                    return;
                }
            }
            int i2 = this.z;
            if (i2 > 0) {
                Object[] objArr = new Object[6];
                objArr[0] = "createCameraPreviewSession with retry, retry start preview num:";
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = ",mRetryStopFlag:";
                objArr[3] = Boolean.valueOf(this.B);
                objArr[4] = ",sessionException:";
                if (exc == null) {
                    str = "null";
                } else {
                    str = exc.getMessage();
                }
                objArr[5] = str;
                MPaasLogger.d("Camera2Manager", objArr);
                Class cls = Boolean.TYPE;
                Class[] clsArr = {String.class, cls, Integer.TYPE, Long.TYPE, cls, String.class};
                Object[] objArr2 = new Object[6];
                objArr2[0] = String.valueOf(Camera2RetryFlag.CREATE_SESSION_FAIL_RETRY);
                objArr2[1] = Boolean.valueOf(exc == null);
                objArr2[2] = Integer.valueOf(this.z);
                objArr2[3] = Long.valueOf(SystemClock.elapsedRealtime() - this.C);
                objArr2[4] = Boolean.valueOf(this.B);
                if (exc == null) {
                    str2 = "Null";
                } else {
                    str2 = exc.getMessage();
                }
                objArr2[5] = str2;
                WalletBury.addWalletBury("recordCamera2RetryInfo", clsArr, objArr2);
                this.z = 0;
            }
        }
    }

    public void createCameraPreviewSessionByOutputConfiguration(OutputConfiguration outputConfiguration) {
        MPaasLogger.d("Camera2Manager", new Object[]{"createCameraPreviewSessionByOutputConfiguration"});
        if (this.h == null) {
            MPaasLogger.w("Camera2Manager", new Object[]{"createCameraPreviewSessionByOutputConfiguration with mCameraDevice == null."});
            if (this.w == CameraOpenStates.DISCONNECTED) {
                D();
                return;
            }
            return;
        }
        try {
            if (MPaasLogger.isDebuggable()) {
                SystraceWrapper.beginTrace("createCaptureRequest");
            }
            this.i = this.h.createCaptureRequest(1);
            SystraceWrapper.endTrace();
            ArrayList arrayList = new ArrayList();
            this.s = outputConfiguration;
            arrayList.add(outputConfiguration);
            if (this.d != null && Camera2Config.supportYuvStream()) {
                Surface surface = this.d.yuvImageReader.getSurface();
                this.i.addTarget(surface);
                OutputConfiguration outputConfiguration2 = new OutputConfiguration(surface);
                this.t = outputConfiguration2;
                arrayList.add(outputConfiguration2);
            }
            Camera2Config camera2Config = this.d;
            if (camera2Config != null && camera2Config.supportPictureSize()) {
                OutputConfiguration outputConfiguration3 = new OutputConfiguration(this.d.jpegImageReader.getSurface());
                this.u = outputConfiguration3;
                arrayList.add(outputConfiguration3);
            }
            if (MPaasLogger.isDebuggable()) {
                SystraceWrapper.beginTrace("createCaptureSession");
            }
            MPaasLogger.d("Camera2Manager", new Object[]{"createCameraPreviewSessionByOutputConfiguration surface size:", Integer.valueOf(arrayList.size())});
            CameraStateTracer.recordEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.START_PREVIEW);
            this.x.setBeginStartPreview(System.currentTimeMillis());
            this.h.createCaptureSessionByOutputConfigurations(arrayList, this.k, this.b.getCameraHandler());
            SystraceWrapper.endTrace();
        } catch (CameraAccessException e2) {
            MPaasLogger.e("Camera2Manager", new Object[]{"createCameraPreviewSessionByOutputConfiguration"}, e2);
            OnCameraStateCallback onCameraStateCallback = this.f;
            if (onCameraStateCallback != null) {
                onCameraStateCallback.onCreateCaptureSessionError(e2.getReason(), e2.getMessage());
            }
        }
    }

    public void destroy() {
        this.a = null;
        this.f = null;
        this.e = null;
        this.v = null;
        this.i = null;
        this.j = null;
        Camera2FocusManager camera2FocusManager = this.p;
        if (camera2FocusManager != null) {
            camera2FocusManager.destroy();
            this.p = null;
        }
        if (this.g != null && MPaasLogger.isDebuggable()) {
            MPaasLogger.d("Camera2Manager", new Object[]{"destroy camera arrived frame num:", this.x.toString(), ", CameraFocusStateDescription:", String.valueOf(getCameraFocusStateDescription())});
        }
        I();
    }

    public void finalizePreviewOutputConfiguration(Surface surface) {
        OutputConfiguration outputConfiguration;
        if (surface != null && this.h != null && (outputConfiguration = this.s) != null && outputConfiguration.getSurface() == null) {
            this.s.addSurface(surface);
            if (this.j != null && C()) {
                K();
                L();
            }
        }
    }

    public String getAfStateHistory() {
        try {
            Camera2CaptureCallback camera2CaptureCallback = this.g;
            if (camera2CaptureCallback != null) {
                return camera2CaptureCallback.getAfState();
            }
            return "NULL";
        } catch (Exception e2) {
            MPaasLogger.d("Camera2Manager", new Object[]{"getAfStateHistory error:", e2});
            return "NULL";
        }
    }

    public Camera2Config getCameraConfig() {
        return this.d;
    }

    public CameraFocusStateDescription getCameraFocusStateDescription() {
        Camera2FocusAbnormalChecker camera2FocusAbnormalChecker;
        try {
            Camera2CaptureCallback camera2CaptureCallback = this.g;
            if (camera2CaptureCallback == null) {
                return null;
            }
            CameraFocusStateDescription cameraFocusStateDescription = camera2CaptureCallback.getCameraFocusStateDescription();
            Camera2FocusParameterConfig camera2FocusParameterConfig = this.q;
            if (camera2FocusParameterConfig != null) {
                cameraFocusStateDescription.setHistorySuccessfulFocusDistanceCount(camera2FocusParameterConfig.getHistorySuccessfulFocusDistanceCount());
                cameraFocusStateDescription.setHistoryAvgSuccessfulFocusDistance(this.q.getHistoryAvgFocusDistance());
            }
            Camera2FocusManager camera2FocusManager = this.p;
            if (!(camera2FocusManager == null || (camera2FocusAbnormalChecker = camera2FocusManager.getCamera2FocusAbnormalChecker()) == null)) {
                cameraFocusStateDescription.setMaxProportionForFirstSecond(camera2FocusAbnormalChecker.getFirstStageLargestProportion());
                cameraFocusStateDescription.setMaxProportionFocusDistanceForFirstSecond(camera2FocusAbnormalChecker.getFirstStageLargestProportionDistance());
            }
            return cameraFocusStateDescription;
        } catch (Throwable unused) {
            return null;
        }
    }

    public CameraPerformanceRecorder getCameraPerformanceRecorder() {
        return this.x;
    }

    @Override // com.alipay.camera2.operation.Camera2FocusManager.Camera2Operation
    public CameraCaptureSession.CaptureCallback getCaptureCallback() {
        return this.g;
    }

    @Override // com.alipay.camera2.operation.Camera2FocusManager.Camera2Operation
    public CameraCaptureSession getCaptureSession() {
        return this.j;
    }

    public int getCurZoom() {
        return this.m;
    }

    @Override // com.alipay.camera2.operation.callback.Camera2CaptureCallback.Camera2CaptureCallbackListener
    public long getDurationOfBlur() {
        OnReadImageListener onReadImageListener = this.l;
        if (onReadImageListener != null) {
            return onReadImageListener.getDurationOfBlur();
        }
        return -1;
    }

    @Override // com.alipay.camera2.operation.callback.Camera2CaptureCallback.Camera2CaptureCallbackListener
    public long getDurationOfNonNeedCheckBlur() {
        OnReadImageListener onReadImageListener = this.l;
        if (onReadImageListener != null) {
            return onReadImageListener.getDurationOfNonNeedCheckBlur();
        }
        return 0;
    }

    public String getDynamicBlockEvent() {
        CameraPerformanceRecorder cameraPerformanceRecorder = this.x;
        if (cameraPerformanceRecorder != null) {
            return cameraPerformanceRecorder.getDynamicBlockEvent();
        }
        return null;
    }

    public long getOpenCameraExecuteDuration() {
        return this.y;
    }

    public int getPreviewHeight() {
        Camera2Config camera2Config = this.d;
        if (camera2Config == null || !camera2Config.valid()) {
            return -1;
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.d.previewSize);
    }

    public int getPreviewWidth() {
        Camera2Config camera2Config = this.d;
        if (camera2Config == null || !camera2Config.valid()) {
            return -1;
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.d.previewSize);
    }

    @Override // com.alipay.camera2.operation.Camera2FocusManager.Camera2Operation
    public CaptureRequest.Builder getRequestBuilder() {
        return this.i;
    }

    public void onFirstFrameArrived(long j2) {
        this.x.setEndFirstPreviewFrame(j2);
    }

    @Override // com.alipay.mobile.bqcscanservice.CameraHandler.OnMessageHandleCallback
    public void onHandleMessage(Message message) {
        int i2;
        if (message != null && (i2 = message.what) == CameraHandler.SECOND_FOCUS_DELAY_MESSAGE.intValue()) {
            MPaasLogger.d("Camera2Manager", new Object[]{"autofocus SECOND_FOCUS_DELAY_MESSAGE received."});
            try {
                if (this.q.secondFocusModeIsAuto()) {
                    boolean A2 = A();
                    MPaasLogger.d("Camera2Manager", new Object[]{"autofocus repeatingChangeToAuto:", Boolean.valueOf(A2)});
                    if (A2) {
                        MPaasLogger.d("Camera2Manager", new Object[]{"autofocus trigger"});
                        this.p.startAutoFocusTrigger();
                    }
                }
            } catch (Exception e2) {
                MPaasLogger.e("Camera2Manager", new Object[]{"onHandleMessage: ", Integer.valueOf(i2)}, e2);
            }
        }
    }

    public void onMovementStatusChanged(boolean z2) {
        Camera2CaptureCallback camera2CaptureCallback = this.g;
        if (camera2CaptureCallback != null) {
            camera2CaptureCallback.onMovementStatusChanged(z2);
        }
    }

    public void openCamera() throws CameraAccessException, SecurityException {
        CameraOpenStates cameraOpenStates = this.w;
        CameraOpenStates cameraOpenStates2 = CameraOpenStates.OPENING;
        if (cameraOpenStates != cameraOpenStates2 && cameraOpenStates != CameraOpenStates.OPENED) {
            MPaasLogger.d("Camera2Manager", new Object[]{"openCamera"});
            SystraceWrapper.beginTrace("openCamera");
            try {
                CameraStateTracer.recordOpenEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.OPEN);
                this.x.setBeginOpenCamera(System.currentTimeMillis());
                long currentTimeMillis = System.currentTimeMillis();
                this.h = null;
                this.c.openCamera(this.d.objCameraId, this.e, this.b.getCameraHandler());
                this.y = System.currentTimeMillis() - currentTimeMillis;
                this.w = cameraOpenStates2;
                SystraceWrapper.endTrace();
            } catch (Exception e2) {
                MPaasLogger.e("Camera2Manager", new Object[]{"openCamera with exception"}, e2);
                throw e2;
            }
        } else if (this.h != null && this.f != null) {
            MPaasLogger.d("Camera2Manager", new Object[]{"openCamera onCamera2Opened"});
            this.f.onCamera2Opened();
        }
    }

    public void preOpenCamera() {
        CameraOpenStates cameraOpenStates = this.w;
        CameraOpenStates cameraOpenStates2 = CameraOpenStates.OPENING;
        if (cameraOpenStates != cameraOpenStates2 && cameraOpenStates != CameraOpenStates.OPENED) {
            MPaasLogger.d("Camera2Manager", new Object[]{"preOpenCamera"});
            if (MPaasLogger.isDebuggable()) {
                SystraceWrapper.beginTrace("preOpenCamera");
            }
            try {
                CameraStateTracer.recordOpenEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.OPEN);
                this.x.setBeginOpenCamera(System.currentTimeMillis());
                long currentTimeMillis = System.currentTimeMillis();
                this.h = null;
                this.c.openCamera(this.d.objCameraId, this.e, this.b.getCameraHandler());
                this.y = System.currentTimeMillis() - currentTimeMillis;
                this.w = cameraOpenStates2;
            } catch (SecurityException e2) {
                MPaasLogger.e("Camera2Manager", new Object[]{"preOpenCamera securityException"}, e2);
            } catch (Exception e3) {
                MPaasLogger.e("Camera2Manager", new Object[]{"preOpenCamera exception"}, e3);
            }
            SystraceWrapper.endTrace();
        }
    }

    public void setAbsoluteZoomParameter(int i2) {
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= 100) {
            i2 = 100;
        }
        J(i2);
    }

    public void setCurTorchState(boolean z2) {
        CaptureRequest.Builder builder;
        Camera2CharacteristicsCache camera2CharacteristicsCache = this.v;
        if (camera2CharacteristicsCache != null && (builder = this.i) != null && Camera2ConfigurationUtils.setTorchState(camera2CharacteristicsCache, builder, z2)) {
            K();
            OnCameraStateCallback onCameraStateCallback = this.f;
            if (onCameraStateCallback != null) {
                onCameraStateCallback.onTorchModeChanged(z2);
            }
            ScanCodeState scanCodeState = this.E;
            if (scanCodeState != null) {
                scanCodeState.setTorchState(z2);
            }
        }
    }

    public void setOpenCameraRetryCount(int i2) {
        MPaasLogger.d("Camera2Manager", new Object[]{"setOpenCameraRetryCount:", Integer.valueOf(i2)});
        this.D = i2;
    }

    public void setRetryStopFlag(boolean z2) {
        MPaasLogger.d("Camera2Manager", new Object[]{"setRetryStopFlag, flag:", Boolean.valueOf(z2)});
        this.B = z2;
    }

    public void setScanRegion(Rect rect) {
        CaptureRequest.Builder builder;
        if (rect != null && this.n != null && this.d.valid()) {
            MPaasLogger.d("Camera2Manager", new Object[]{"setScanRegion scanRegion:", rect.toString()});
            this.o = rect;
            if (this.d.valid() && (builder = this.i) != null) {
                Camera2ConfigurationUtils.setAfAeRegion(this.v, builder, this.d.previewSize, this.o, this.n);
                K();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        if (r3.m < 100) goto L_0x0014;
     */
    public void setZoomParameter(int i2) {
        int i3 = 0;
        if (i2 != Integer.MIN_VALUE) {
            int i4 = this.m + i2;
            if (i4 >= 0) {
                if (i4 <= 100) {
                    i3 = i4;
                }
            }
            J(i3);
        }
        i3 = 100;
        J(i3);
    }

    public boolean valid() {
        Camera2Config camera2Config = this.d;
        if (camera2Config == null) {
            return false;
        }
        return camera2Config.valid();
    }
}
