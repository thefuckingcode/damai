package com.alipay.mobile.bqcscanservice.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.alipay.camera.CameraConfigurationManager;
import com.alipay.camera.CameraManager;
import com.alipay.camera.CameraPreControl;
import com.alipay.camera.base.AntCamera;
import com.alipay.camera.base.CameraPerformanceRecorder;
import com.alipay.camera.compatible.CompatibleManager;
import com.alipay.camera.open.OpenCameraInterface;
import com.alipay.camera.util.CameraConfigurationUtils;
import com.alipay.camera.util.CameraFocusParamConfig;
import com.alipay.camera.util.FocusWhiteList;
import com.alipay.camera.util.FpsWhiteList;
import com.alipay.camera.util.ManufacturerPermissionChecker;
import com.alipay.camera2.Camera2AvailabilityCallback;
import com.alipay.camera2.CameraFocusStateDescription;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.BQCScanCallback;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.alipay.mobile.bqcscanservice.BQCScanError;
import com.alipay.mobile.bqcscanservice.CameraHandler;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.MPaasScanService;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.alipay.mobile.bqcscanservice.executor.ScanRecognizedExecutor;
import com.alipay.mobile.bqcscanservice.monitor.ScanCodeState;
import com.alipay.mobile.watchdog.BQCWatchCallback;
import com.alipay.performance.memory.DeviceMemoryUtils;
import com.alipay.util.CameraFrameWatchdog;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class MPaasScanServiceImpl implements MPaasScanService {
    public static final String TAG = "MPaasScanServiceImpl";
    private int A = 0;
    private SurfaceView B;
    private SurfaceHolder C;
    private boolean D;
    private boolean E;
    private boolean F = false;
    private boolean G = false;
    private long H = 0;
    private long I = 0;
    private long J;
    private int K = 0;
    private boolean L = false;
    private CameraFrameWatchdog M;
    protected boolean a = true;
    protected CameraHandler b;
    private Camera2AvailabilityCallback c;
    private CameraManager d = null;
    private BQCScanController e = null;
    private TextureView f = null;
    private SurfaceTexture g = null;
    private TextureView.SurfaceTextureListener h;
    private volatile long i = 0;
    private volatile long j = 0;
    private Camera.Parameters k;
    private Point l;
    private Point m;
    private ScanCodeState n;
    private CameraPreControl o;
    private Point p;
    private boolean q;
    private Context r;
    private Context s;
    public int startPreviewRetryNum = 0;
    private volatile boolean t = true;
    private Camera.Parameters u;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    protected Map<String, Map<String, Object>> z = new HashMap();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class BQCSurfaceCallback implements TextureView.SurfaceTextureListener {
        private BQCSurfaceCallback() {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            MPaasLogger.d(MPaasScanServiceImpl.TAG, new Object[]{"BQCSurfaceCallback:onSurfaceTextureAvailable():width: ", Integer.valueOf(i), ", height: ", Integer.valueOf(i2)});
            try {
                MPaasScanServiceImpl.this.g = surfaceTexture;
                if (MPaasScanServiceImpl.this.e != null) {
                    MPaasScanServiceImpl.this.e.reportSurfaceViewAvailable();
                }
            } catch (Exception e) {
                MPaasLogger.e(MPaasScanServiceImpl.TAG, new Object[]{"onSurfaceTextureAvailable: "}, e);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            MPaasLogger.d(MPaasScanServiceImpl.TAG, new Object[]{"onSurfaceTextureDestroyed"});
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            MPaasLogger.d(MPaasScanServiceImpl.TAG, new Object[]{"onSurfaceTextureSizeChanged: width=", Integer.valueOf(i), ", height=", Integer.valueOf(i2)});
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (MPaasScanServiceImpl.this.I == 0) {
                MPaasScanServiceImpl.this.H = SystemClock.elapsedRealtime();
                try {
                    if (MPaasScanServiceImpl.this.e != null) {
                        MPaasScanServiceImpl.this.e.reportSurfaceTextureUpdated();
                    }
                } catch (Exception e) {
                    MPaasLogger.e(MPaasScanServiceImpl.TAG, new Object[]{"onSurfaceTextureUpdated"}, e);
                }
            }
            MPaasScanServiceImpl.l(MPaasScanServiceImpl.this);
            MPaasScanServiceImpl.this.i += 10;
        }
    }

    static /* synthetic */ long l(MPaasScanServiceImpl mPaasScanServiceImpl) {
        long j2 = mPaasScanServiceImpl.I;
        mPaasScanServiceImpl.I = 1 + j2;
        return j2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("###cameraHandlerStacktrace=");
        sb.append(str);
        String staticBlockEvent = CameraPerformanceRecorder.getStaticBlockEvent();
        CameraManager cameraManager = this.d;
        String str2 = null;
        String dynamicBlockEvent = cameraManager == null ? null : cameraManager.getDynamicBlockEvent();
        if (staticBlockEvent == null && dynamicBlockEvent == null) {
            CameraManager cameraManager2 = this.d;
            if (cameraManager2 != null) {
                str2 = cameraManager2.getCameraLatestErrorEventInfo();
            }
            if (str2 != null) {
                sb.append(str2);
                this.M.buryWatchDogErrorDetails(CameraFrameWatchdog.NoFrameReason.CAMERA_ERROR, sb.toString(), false);
                return;
            }
            this.M.buryWatchDogErrorDetails(CameraFrameWatchdog.NoFrameReason.CAMERA_HAL_NOT_PRODUCE_FRAME, sb.toString(), false);
            return;
        }
        sb.append(String.valueOf(staticBlockEvent));
        sb.append(String.valueOf(dynamicBlockEvent));
        this.M.buryWatchDogErrorDetails(CameraFrameWatchdog.NoFrameReason.CAMERA_METHOD_BLOCK, sb.toString(), false);
    }

    private void n(String str) {
        try {
            CameraFrameWatchdog cameraFrameWatchdog = this.M;
            if (cameraFrameWatchdog != null) {
                cameraFrameWatchdog.postCameraFailRetryNotice(str, false);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o(CameraFrameWatchdog.WatcherState watcherState) {
        try {
            CameraFrameWatchdog cameraFrameWatchdog = this.M;
            if (cameraFrameWatchdog != null) {
                cameraFrameWatchdog.setWatcherState(watcherState);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void adjustExposureState(int i2) {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.adjustExposureState(i2);
            }
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"adjustExposureState: "}, e2);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void changeCameraFeature(BQCCameraParam.CameraConfigType cameraConfigType, Object... objArr) {
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean checkEngineRegister(String str) {
        BQCScanController bQCScanController = this.e;
        if (bQCScanController != null) {
            return bQCScanController.checkEngineRegister(str);
        }
        return false;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void cleanup(long j2) {
        MPaasLogger.d(TAG, new Object[]{"CAMERA_STEP_5 cleanup"});
        this.r = null;
        this.a = false;
        this.o = null;
        this.d = null;
        BQCScanController bQCScanController = this.e;
        if (bQCScanController != null) {
            bQCScanController.setResultCallback(null);
            this.e.setmPaasScanService(null);
            this.e.destroy();
            this.e = null;
        }
        TextureView textureView = this.f;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
            this.f = null;
        }
        if (this.D) {
            this.C = null;
            this.B = null;
        }
        this.g = null;
        if (this.B != null) {
            this.B = null;
        }
        this.y = false;
        this.h = null;
        this.v = false;
        this.w = false;
        this.x = false;
        ScanRecognizedExecutor.close();
        this.A = 0;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void enableCameraOpenWatcher(boolean z2) {
        MPaasLogger.d(TAG, new Object[]{"enableCameraOpenWatcher: enabled=", Boolean.valueOf(z2)});
        this.t = z2;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Camera getCamera() {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager == null || cameraManager.getCamera() == null) {
                return null;
            }
            return this.d.getCamera().getCamera();
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"getCamera(): "}, e2);
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public int getCameraDisplayOrientation() {
        CameraManager cameraManager = this.d;
        if (cameraManager != null) {
            try {
                return cameraManager.getCameraDisplayOrientation();
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public CameraFocusStateDescription getCameraFocusStateDescription() {
        CameraManager cameraManager = this.d;
        if (cameraManager == null || cameraManager.getCamera() == null) {
            return null;
        }
        AntCamera camera = this.d.getCamera();
        return new CameraFocusStateDescription((long) camera.getFrameCount(), false, -1.0f, -1.0f, camera.getFocusNotStartedFrameCount(), -1, String.valueOf(camera.getFocusTriggerHistory()), -1, -1, -1, false, "UNKNOWN");
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public CameraHandler getCameraHandler() {
        return this.b;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Object getCameraParam(String str) {
        CameraManager cameraManager;
        if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.PREVIEW_HEIGHT)) {
            CameraManager cameraManager2 = this.d;
            if (cameraManager2 != null) {
                try {
                    return Integer.valueOf(cameraManager2.getPreviewHeight());
                } catch (Exception unused) {
                }
            }
            return -1;
        } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.PREVIEW_WIDTH)) {
            CameraManager cameraManager3 = this.d;
            if (cameraManager3 != null) {
                try {
                    return Integer.valueOf(cameraManager3.getPreviewWidth());
                } catch (Exception unused2) {
                }
            }
            return -1;
        } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.PREVIEW_SIZE)) {
            CameraManager cameraManager4 = this.d;
            if (cameraManager4 != null) {
                try {
                    int previewWidth = cameraManager4.getPreviewWidth();
                    int previewHeight = this.d.getPreviewHeight();
                    if (previewWidth > 0 && previewHeight > 0) {
                        return new Point(previewWidth, previewHeight);
                    }
                } catch (Exception unused3) {
                }
            }
            return null;
        } else {
            if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.MAX_EXPOSURE_INDEX)) {
                CameraManager cameraManager5 = this.d;
                if (cameraManager5 != null) {
                    try {
                        return cameraManager5.getMaxExposureIndex();
                    } catch (Exception unused4) {
                        return null;
                    }
                }
            } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.MIN_EXPOSURE_INDEX)) {
                CameraManager cameraManager6 = this.d;
                if (cameraManager6 != null) {
                    try {
                        return cameraManager6.getMinExposureIndex();
                    } catch (Exception unused5) {
                        return null;
                    }
                }
            } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.BACK_CAMERA_INDEX)) {
                CameraManager cameraManager7 = this.d;
                if (cameraManager7 != null) {
                    try {
                        return Integer.valueOf(cameraManager7.getBackCameraIndex());
                    } catch (Exception unused6) {
                        return null;
                    }
                }
            } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.MAX_PICTURE_SIZE_VALID)) {
                CameraManager cameraManager8 = this.d;
                if (cameraManager8 != null) {
                    try {
                        return Boolean.valueOf(cameraManager8.getMaxPictureSizeValid());
                    } catch (Exception unused7) {
                        return null;
                    }
                }
            } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.CAMERA_FACING)) {
                return Integer.valueOf(this.A);
            } else {
                if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.CAMERA_ROTATE_ORIENTATION) && (cameraManager = this.d) != null) {
                    try {
                        return cameraManager.getCameraRotation();
                    } catch (Exception unused8) {
                    }
                }
            }
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Context getContext() {
        return this.r;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public String getCurCameraVitalParameters() {
        Rect rect;
        Rect rect2;
        if (this.u != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("focusMode", this.u.getFocusMode());
                List<Camera.Area> focusAreas = this.u.getFocusAreas();
                if (!(focusAreas == null || focusAreas.size() <= 0 || (rect2 = focusAreas.get(0).rect) == null)) {
                    jSONObject.put("focusArea", jl1.ARRAY_START_STR + rect2.left + AVFSCacheConstants.COMMA_SEP + rect2.top + AVFSCacheConstants.COMMA_SEP + rect2.right + AVFSCacheConstants.COMMA_SEP + rect2.bottom + jl1.ARRAY_END_STR);
                }
                List<Camera.Area> meteringAreas = this.u.getMeteringAreas();
                if (!(meteringAreas == null || meteringAreas.size() <= 0 || (rect = meteringAreas.get(0).rect) == null)) {
                    jSONObject.put("meteringArea", jl1.ARRAY_START_STR + rect.left + AVFSCacheConstants.COMMA_SEP + rect.top + AVFSCacheConstants.COMMA_SEP + rect.right + AVFSCacheConstants.COMMA_SEP + rect.bottom + jl1.ARRAY_END_STR);
                }
                Camera.Size previewSize = this.u.getPreviewSize();
                if (previewSize != null) {
                    jSONObject.put("previewSize", "" + previewSize.width + jl1.MUL + previewSize.height);
                }
                Camera.Size pictureSize = this.u.getPictureSize();
                if (pictureSize != null) {
                    jSONObject.put("pictureSize", "" + pictureSize.width + jl1.MUL + pictureSize.height);
                }
                long j2 = this.J;
                if (j2 > 0) {
                    jSONObject.put("inFrameRate", String.valueOf((int) (1000 / j2)));
                }
                jSONObject.put("zsl", CompatibleManager.sOpenZsl ? BQCCameraParam.VALUE_YES : "no");
                jSONObject.put("paramDetail", this.u.flatten());
                return jSONObject.toString();
            } catch (Exception e2) {
                MPaasLogger.e(TAG, new Object[]{"getCurCameraVitalParameters:"}, e2);
                return null;
            }
        } else {
            MPaasLogger.e(TAG, new Object[]{"getCurCameraVitalParameters: this.parameters=null"});
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean getCurrentWhetherUseManualFocus() {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                return cameraManager.getCanInvokeManualFocus();
            }
            return false;
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"getCurrentWhetherUseManualFocus"}, e2);
            return false;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public int getCurrentZoom() {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager == null || !cameraManager.isOpen()) {
                return -1;
            }
            return this.d.getZoomParameter();
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"getCurrentZoom: "}, e2);
            return -1;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Map<String, String> getEngineRunningInfo(String str) {
        try {
            if (this.e != null) {
                MPaasLogger.d(TAG, new Object[]{"getEngineRunningInfo: ", str, ", scanController!=null"});
                return this.e.getEngineRunningInfo(str);
            }
            MPaasLogger.d(TAG, new Object[]{"getEngineRunningInfo: ", str, ", scanController=null"});
            return null;
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"getSpecEngineExtInfo: "}, e2);
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean getFirstSetup() {
        return false;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public long getFrameCountInCamera() {
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                return bQCScanController.getFrameCountInCamera();
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public int getMaxZoom() {
        CameraManager cameraManager = this.d;
        if (cameraManager != null && cameraManager.isOpen()) {
            try {
                return this.d.getMaxZoom();
            } catch (Exception unused) {
                MPaasLogger.e(TAG, new Object[]{"getMaxZoom exception"});
            }
        }
        return -1;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public long[] getRecognizeResult() {
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                return bQCScanController.getRecognizeResult();
            }
            return null;
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"getRecognizeResult()"}, e2);
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public ScanCodeState getScanCodeState() {
        return this.n;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Map<String, String> getSpecEngineExtInfo(String str) {
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                return bQCScanController.getSpecEngineExtInfo(str);
            }
            return null;
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"getSpecEngineExtInfo: "}, e2);
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Runnable getWatchdogRunnable() {
        try {
            return new Runnable() {
                /* class com.alipay.mobile.bqcscanservice.impl.MPaasScanServiceImpl.AnonymousClass1 */

                public void run() {
                    MPaasLogger.d(MPaasScanServiceImpl.TAG, new Object[]{"watchDogRunnable start, Camera1"});
                    try {
                        if (MPaasScanServiceImpl.this.M != null) {
                            MPaasScanServiceImpl.this.o(CameraFrameWatchdog.WatcherState.TIMEOUT);
                            String str = "stackTrace=null";
                            if (MPaasScanServiceImpl.this.b != null) {
                                str = "stackTrace=" + MPaasScanServiceImpl.this.b.getStackTrace();
                            }
                            MPaasScanServiceImpl.this.M.postCameraPreviewTimeOut(false, str);
                            MPaasScanServiceImpl.this.m(str);
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean isCameraClosed() {
        return getCamera() == null;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean isPreviewing() {
        throw new UnsupportedOperationException("Do not use this");
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean isScanEnable() {
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                return bQCScanController.isScanEnable();
            }
            return false;
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"isScanEnable()"}, e2);
            return false;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean isTorchOn() {
        return this.x;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void needDowngrade(boolean z2) {
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                bQCScanController.needDowngrade(z2);
            }
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"needDowngrade: "}, e2);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void onMovementStatusChanged(boolean z2) {
        MPaasLogger.d(TAG, new Object[]{"onMovementStatusChanged:", Boolean.valueOf(z2)});
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:0x0366 A[SYNTHETIC, Splitter:B:132:0x0366] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0391 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0410  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0459  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0149 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0361 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0117 A[SYNTHETIC, Splitter:B:50:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0152 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0240  */
    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void onSurfaceAvailable() {
        String message;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str;
        boolean z6;
        Throwable th;
        Exception e2;
        SurfaceView surfaceView;
        String str2;
        Exception e3;
        boolean z7;
        BQCScanController bQCScanController;
        String message2;
        int i3;
        boolean z8;
        String str3;
        boolean z9;
        String str4;
        boolean z10;
        boolean z11;
        Throwable th2;
        Exception e4;
        String str5 = "retry startPreview Num:#";
        if (!this.D) {
            Object[] objArr = new Object[3];
            objArr[0] = "CAMERA_STEP_3 onSurfaceAvailable:surfaceTexture:";
            objArr[1] = Boolean.valueOf(this.g == null);
            objArr[2] = ", surfaceAlreadySet:" + this.y;
            MPaasLogger.d(TAG, objArr);
            if (this.g != null && !this.y && this.d != null && this.v) {
                MPaasLogger.d(TAG, new Object[]{" Start to set preview surface"});
                this.y = true;
                try {
                    BQCScanController bQCScanController2 = this.e;
                    if (bQCScanController2 != null) {
                        bQCScanController2.reportStartingPreview();
                        str2 = TAG;
                        try {
                            this.e.setFistFrameTimestamp(System.currentTimeMillis());
                        } catch (Exception e5) {
                            e3 = e5;
                            MPaasLogger.e(str2, new Object[]{"Set Preview Exception : "}, e3);
                            return;
                        }
                    } else {
                        str2 = TAG;
                    }
                    o(CameraFrameWatchdog.WatcherState.PREVIEW_START);
                    this.d.setPreviewTexture(this.g);
                    try {
                        this.d.startPreview();
                        z7 = true;
                    } catch (Exception e6) {
                        message2 = e6.getMessage();
                        i3 = this.startPreviewRetryNum;
                        if (i3 > 0) {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            z8 = false;
                            while (true) {
                                str3 = message2;
                                if (i3 <= 0) {
                                    break;
                                }
                                try {
                                    MPaasLogger.d(str2, new Object[]{str5, Integer.valueOf((this.startPreviewRetryNum - i3) + 1), "flag:", Boolean.valueOf(this.L)});
                                    Camera.Parameters cameraParameters = this.d.getCameraParameters();
                                    int cameraDisplayOrientation = this.d.getCameraDisplayOrientation();
                                    z10 = z8;
                                    try {
                                        this.d.closeDriver();
                                        str4 = str5;
                                        try {
                                            this.d.openDriver(this.A);
                                            this.d.getCamera().setDisplayOrientation(cameraDisplayOrientation);
                                            this.d.getCamera().setParameters(cameraParameters);
                                            setPreviewCallback();
                                            this.d.setPreviewTexture(this.g);
                                            this.d.startPreview();
                                            z11 = false;
                                        } catch (Exception e7) {
                                            e4 = e7;
                                            str3 = e4.getMessage();
                                            z11 = true;
                                            if (z11) {
                                            }
                                            if (i3 > 0) {
                                            }
                                            MPaasLogger.d(str2, new Object[]{"retry startPreview end1, tmpRetryNum=", Integer.valueOf(i3), " retryStopFlag=", Boolean.valueOf(z8), " isRetryFailed=", Boolean.valueOf(z9)});
                                            if (!z9) {
                                            }
                                        }
                                    } catch (Exception e8) {
                                        e4 = e8;
                                        str4 = str5;
                                        str3 = e4.getMessage();
                                        z11 = true;
                                        if (z11) {
                                        }
                                        if (i3 > 0) {
                                        }
                                        MPaasLogger.d(str2, new Object[]{"retry startPreview end1, tmpRetryNum=", Integer.valueOf(i3), " retryStopFlag=", Boolean.valueOf(z8), " isRetryFailed=", Boolean.valueOf(z9)});
                                        if (!z9) {
                                        }
                                    }
                                } catch (Exception e9) {
                                    e4 = e9;
                                    z10 = z8;
                                    str4 = str5;
                                    str3 = e4.getMessage();
                                    z11 = true;
                                    if (z11) {
                                        message2 = str3;
                                        z8 = z10;
                                        break;
                                    }
                                    z8 = this.L;
                                    if (z8) {
                                        message2 = str3;
                                        break;
                                    }
                                    if ((this.startPreviewRetryNum - i3) + 1 == 3) {
                                        n("Preview");
                                    }
                                    Thread.sleep(1000);
                                    i3--;
                                    message2 = str3;
                                    str5 = str4;
                                    z9 = i3 > 0 || z8;
                                    MPaasLogger.d(str2, new Object[]{"retry startPreview end1, tmpRetryNum=", Integer.valueOf(i3), " retryStopFlag=", Boolean.valueOf(z8), " isRetryFailed=", Boolean.valueOf(z9)});
                                    if (!z9) {
                                        MPaasLogger.d(str2, new Object[]{"start Preview retry end and finally failed, throws Exception"});
                                        Class cls = Boolean.TYPE;
                                        WalletBury.addWalletBury("recordStartPreviewRetryInfo", new Class[]{cls, Integer.TYPE, Long.TYPE, cls, String.class}, new Object[]{Boolean.FALSE, Integer.valueOf(this.startPreviewRetryNum), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), Boolean.valueOf(this.L), message2});
                                        z7 = false;
                                        if (!z7) {
                                            MPaasLogger.e(str2, new Object[]{"start Preview error: ", message2});
                                            BQCScanController bQCScanController3 = this.e;
                                            if (bQCScanController3 != null) {
                                                bQCScanController3.reportError(new BQCScanError(BQCScanError.ErrorType.CameraPreviewError, "startPreview_error", 0, BQCScanError.CameraAPIType.API1));
                                            }
                                        }
                                        bQCScanController = this.e;
                                        if (bQCScanController != null) {
                                        }
                                        if (z7) {
                                        }
                                    } else {
                                        Class cls2 = Boolean.TYPE;
                                        WalletBury.addWalletBury("recordStartPreviewRetryInfo", new Class[]{cls2, Integer.TYPE, Long.TYPE, cls2, String.class}, new Object[]{Boolean.TRUE, Integer.valueOf(this.startPreviewRetryNum - i3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), Boolean.valueOf(this.L), message2});
                                        z7 = true;
                                        if (!z7) {
                                        }
                                        bQCScanController = this.e;
                                        if (bQCScanController != null) {
                                        }
                                        if (z7) {
                                        }
                                    }
                                }
                                if (z11) {
                                }
                            }
                            if (i3 > 0) {
                            }
                            MPaasLogger.d(str2, new Object[]{"retry startPreview end1, tmpRetryNum=", Integer.valueOf(i3), " retryStopFlag=", Boolean.valueOf(z8), " isRetryFailed=", Boolean.valueOf(z9)});
                            if (!z9) {
                            }
                        }
                        z7 = true;
                        if (!z7) {
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        MPaasLogger.e(str2, new Object[]{"start Preview retry sleep error:"}, th2);
                        i3--;
                        message2 = str3;
                        str5 = str4;
                    }
                    bQCScanController = this.e;
                    if (bQCScanController != null) {
                        bQCScanController.reportCameraReady();
                    }
                    if (z7) {
                        o(CameraFrameWatchdog.WatcherState.PREVIEW_END);
                        return;
                    }
                    return;
                } catch (Exception e10) {
                    e3 = e10;
                    str2 = TAG;
                    MPaasLogger.e(str2, new Object[]{"Set Preview Exception : "}, e3);
                    return;
                }
            } else {
                return;
            }
        } else {
            Object[] objArr2 = new Object[4];
            objArr2[0] = "CAMERA_STEP_3 onSurfaceAvailable:surfaceHolder is null:";
            objArr2[1] = Boolean.valueOf(this.C == null);
            objArr2[2] = "surfaceAlreadySet: ";
            objArr2[3] = Boolean.valueOf(this.y);
            MPaasLogger.d(TAG, objArr2);
            if (!(this.C == null && ((surfaceView = this.B) == null || surfaceView.getHolder().getSurface() == null || !this.B.getHolder().getSurface().isValid())) && !this.y && this.d != null && this.v) {
                MPaasLogger.d(TAG, new Object[]{"Start to set preview surface"});
                this.y = true;
                try {
                    BQCScanController bQCScanController4 = this.e;
                    if (bQCScanController4 != null) {
                        bQCScanController4.reportStartingPreview();
                        this.e.setFistFrameTimestamp(System.currentTimeMillis());
                    }
                    o(CameraFrameWatchdog.WatcherState.PREVIEW_START);
                    this.d.setPreviewTexture(this.C);
                    try {
                        this.d.startPreview();
                    } catch (Exception e11) {
                        message = e11.getMessage();
                        i2 = this.startPreviewRetryNum;
                        if (i2 > 0) {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            z3 = false;
                            while (true) {
                                if (i2 <= 0) {
                                    break;
                                }
                                try {
                                    MPaasLogger.d(TAG, new Object[]{str5, Integer.valueOf((this.startPreviewRetryNum - i2) + 1), " flag:", Boolean.valueOf(this.L)});
                                    Camera.Parameters cameraParameters2 = this.d.getCameraParameters();
                                    int cameraDisplayOrientation2 = this.d.getCameraDisplayOrientation();
                                    str = message;
                                    this.d.closeDriver();
                                    z5 = z3;
                                    try {
                                        this.d.openDriver(this.A);
                                        this.d.getCamera().setDisplayOrientation(cameraDisplayOrientation2);
                                        this.d.getCamera().setParameters(cameraParameters2);
                                        setPreviewCallback();
                                        this.d.setPreviewTexture(this.C);
                                        this.d.startPreview();
                                        z6 = false;
                                    } catch (Exception e12) {
                                        e2 = e12;
                                        str = e2.getMessage();
                                        z6 = true;
                                        if (!z6) {
                                        }
                                        if (i2 > 0) {
                                        }
                                        MPaasLogger.d(TAG, new Object[]{" retry startPreview end2, tmpRetryNum=", Integer.valueOf(i2), " retryStopFlag=", Boolean.valueOf(z3), " isRetryFailed=", Boolean.valueOf(z4)});
                                        if (z4) {
                                        }
                                    }
                                } catch (Exception e13) {
                                    e2 = e13;
                                    z5 = z3;
                                    str = e2.getMessage();
                                    z6 = true;
                                    if (!z6) {
                                    }
                                    if (i2 > 0) {
                                    }
                                    MPaasLogger.d(TAG, new Object[]{" retry startPreview end2, tmpRetryNum=", Integer.valueOf(i2), " retryStopFlag=", Boolean.valueOf(z3), " isRetryFailed=", Boolean.valueOf(z4)});
                                    if (z4) {
                                    }
                                }
                                if (!z6) {
                                    message = str;
                                    z3 = z5;
                                    break;
                                }
                                z3 = this.L;
                                if (z3) {
                                    message = str;
                                    break;
                                }
                                Thread.sleep(1000);
                                i2--;
                                message = str;
                            }
                            z4 = i2 > 0 || z3;
                            MPaasLogger.d(TAG, new Object[]{" retry startPreview end2, tmpRetryNum=", Integer.valueOf(i2), " retryStopFlag=", Boolean.valueOf(z3), " isRetryFailed=", Boolean.valueOf(z4)});
                            if (z4) {
                                MPaasLogger.d(TAG, new Object[]{"start Preview retry end and finally failed, throws Exception"});
                                Class cls3 = Boolean.TYPE;
                                WalletBury.addWalletBury("recordStartPreviewRetryInfo", new Class[]{cls3, Integer.TYPE, Long.TYPE, cls3, String.class}, new Object[]{Boolean.FALSE, Integer.valueOf(this.startPreviewRetryNum), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime2), Boolean.valueOf(this.L), message});
                                z2 = false;
                                if (!z2) {
                                    MPaasLogger.e(TAG, new Object[]{"start Preview error: ", message});
                                    BQCScanController bQCScanController5 = this.e;
                                    if (bQCScanController5 != null) {
                                        bQCScanController5.reportError(new BQCScanError(BQCScanError.ErrorType.CameraPreviewError, "startPreview_error", 0, BQCScanError.CameraAPIType.API1));
                                    }
                                }
                            } else {
                                Class cls4 = Boolean.TYPE;
                                WalletBury.addWalletBury("recordStartPreviewRetryInfo", new Class[]{cls4, Integer.TYPE, Long.TYPE, cls4, String.class}, new Object[]{Boolean.TRUE, Integer.valueOf(this.startPreviewRetryNum - i2), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime2), Boolean.valueOf(this.L), message});
                            }
                        }
                        z2 = true;
                        if (!z2) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    BQCScanController bQCScanController6 = this.e;
                    if (bQCScanController6 != null) {
                        bQCScanController6.reportCameraReady();
                    }
                    o(CameraFrameWatchdog.WatcherState.PREVIEW_END);
                    return;
                } catch (Exception e14) {
                    MPaasLogger.e(TAG, new Object[]{"Set Preview Exception : "}, e14);
                    return;
                }
            } else {
                return;
            }
        }
        MPaasLogger.e(TAG, new Object[]{"start Preview retry sleep error:"}, th);
        i2--;
        message = str;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void postCloseCamera() {
        CameraHandler cameraHandler = this.b;
        if (cameraHandler != null) {
            cameraHandler.postCloseCamera();
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void preOpenCamera() {
        CameraHandler cameraHandler = this.b;
        if (cameraHandler != null) {
            cameraHandler.preOpenCamera();
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void processWhetherStopMaRecognize(boolean z2, Runnable runnable) {
        if (this.e != null) {
            MPaasLogger.d(TAG, new Object[]{"ScanNetworkChangeMonitor processWhetherStopMaRecognize stopRecognize=", Boolean.valueOf(z2)});
            this.e.processWhetherStopMaRecognize(z2, runnable);
            return;
        }
        MPaasLogger.d(TAG, new Object[]{"ScanNetworkChangeMonitor processWhetherStopMaRecognize error,scanController=null"});
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void reconnectCamera() {
        if (this.g != null) {
            Camera camera = getCamera();
            if (this.d != null && camera != null) {
                MPaasLogger.d(TAG, new Object[]{"reconnectCamera"});
                try {
                    this.d.setPreviewTexture(this.g);
                    setPreviewCallback();
                    camera.startPreview();
                } catch (Exception e2) {
                    MPaasLogger.e(TAG, new Object[]{"reconnectCamera Exception : "}, e2);
                }
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void refocus() {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.refocus();
            }
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"refocus: "}, e2);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void regScanEngine(String str, Class<? extends BQCScanEngine> cls, BQCScanEngine.EngineCallback engineCallback) {
        MPaasLogger.d(TAG, new Object[]{"regScanEngine()"});
        BQCScanController bQCScanController = this.e;
        if (bQCScanController != null) {
            bQCScanController.regScanEngine(str, cls, engineCallback);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void registerExecutorCallback(ScanRecognizedExecutor.RecognizeExecutorCallback recognizeExecutorCallback) {
        ScanRecognizedExecutor.registerRecognizeCallback(recognizeExecutorCallback);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void release() {
        this.p = null;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void requestCameraPreviewWatcherDog(long j2, BQCWatchCallback bQCWatchCallback) {
        try {
            if (this.M == null) {
                if (j2 <= 0) {
                    j2 = 10000;
                }
                this.M = new CameraFrameWatchdog(bQCWatchCallback, j2, getWatchdogRunnable());
            }
            MPaasLogger.d(TAG, new Object[]{"requestCameraPreviewWatcherDog camera1"});
            startWatchDogMonitor();
            o(CameraFrameWatchdog.WatcherState.INIT);
        } catch (Exception unused) {
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void sendOperationCameraInstructions(BQCCameraParam.CameraOperationInstruction cameraOperationInstruction, String str, String str2) {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.sendOperationCameraInstructions(cameraOperationInstruction, str, str2);
            }
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"sendOperationCameraInstructions: "}, e2);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void serviceInit(Bundle bundle) {
        CameraHandler cameraHandler = new CameraHandler();
        this.b = cameraHandler;
        cameraHandler.setBqcScanService(this);
        String str = null;
        this.k = null;
        this.l = null;
        this.m = null;
        if (bundle != null) {
            str = bundle.getString(BQCCameraParam.ServicePropertyParam.NOT_SELF_DIAGNOSE, null);
        }
        ScanCodeState scanCodeState = new ScanCodeState(1);
        this.n = scanCodeState;
        scanCodeState.setEnable(!TextUtils.equals(str, BQCCameraParam.VALUE_YES));
        if (Build.VERSION.SDK_INT >= 21) {
            this.c = new Camera2AvailabilityCallback(this.s, getCameraHandler().getCameraHandler());
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void serviceOut(Bundle bundle) {
        this.b.destroy();
        this.k = null;
        this.l = null;
        this.m = null;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setCameraId(int i2) {
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setCameraParam(String str, Object obj) {
        int i2;
        String[] split;
        CameraManager cameraManager;
        CameraManager cameraManager2;
        CameraManager cameraManager3;
        CameraManager cameraManager4;
        CameraManager cameraManager5;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.E || !str.equalsIgnoreCase(BQCCameraParam.ConfigParam.KEY_MERGE_CAMERA_PARAM)) {
                    if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_SUPPORT_FRAME_CALLBACK) && (obj instanceof String)) {
                        BQCScanController bQCScanController = this.e;
                        if (bQCScanController != null) {
                            bQCScanController.setSupportFrameCallback(TextUtils.equals(BQCCameraParam.VALUE_YES, (String) obj));
                        }
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA_PERMISSION_DETECT) && (obj instanceof String)) {
                        ManufacturerPermissionChecker.setCheckerSwitcher(BQCCameraParam.VALUE_YES.equalsIgnoreCase((String) obj));
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_STOP_CANCEL_FOCUS) && (obj instanceof String)) {
                        CameraManager cameraManager6 = this.d;
                        if (cameraManager6 != null) {
                            cameraManager6.setStopCancelFocus(BQCCameraParam.VALUE_YES.equalsIgnoreCase((String) obj));
                        }
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_OPEN_CAMERA_FAULT_TOLERANT) && (obj instanceof String)) {
                        OpenCameraInterface.setEnableCameraDefaultTolerant(BQCCameraParam.VALUE_YES.equalsIgnoreCase((String) obj));
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA_ID_BACKUP) && (obj instanceof String)) {
                        OpenCameraInterface.setCameraIdBackup((String) obj);
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_DYNAMICAL_PREVIEWSIZE) && (obj instanceof String)) {
                        CameraConfigurationUtils.setEnableDynamicPreviewSize((String) obj);
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_MIN_PREVIEW) && (obj instanceof String)) {
                        CameraConfigurationUtils.setPreviewSize(null, (String) obj);
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_MAX_PREVIEW) && (obj instanceof String)) {
                        CameraConfigurationUtils.setPreviewSize((String) obj, null);
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_NEW_FOCUS_CONFIG) && (obj instanceof String)) {
                        FocusWhiteList.useNewFocusWhiteList = BQCCameraParam.VALUE_YES.equalsIgnoreCase((String) obj);
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.LOCAL_MAX_PICTURE_VALID) && (obj instanceof String)) {
                        FocusWhiteList.maxPictureSizeValid = BQCCameraParam.VALUE_YES.equalsIgnoreCase((String) obj);
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA_FINGERPRINT) && (obj instanceof String)) {
                        FocusWhiteList.updateDeviceFingerPrint((String) obj);
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_OPEN_CAMERA_RETRY_TIME) && (obj instanceof String)) {
                        try {
                            this.K = Integer.parseInt((String) obj);
                        } catch (Exception unused) {
                            this.K = 0;
                        }
                        MPaasLogger.d(TAG, new Object[]{"retryNum =", Integer.valueOf(this.K)});
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_START_PREVIEW_RETRY_TIME) && (obj instanceof String)) {
                        try {
                            this.startPreviewRetryNum = Integer.parseInt((String) obj);
                        } catch (Exception unused2) {
                            this.startPreviewRetryNum = 0;
                        }
                        MPaasLogger.d(TAG, new Object[]{"startPreview retryNum =", Integer.valueOf(this.startPreviewRetryNum)});
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_SERVICE_CONFIG_PREVIEW_SIZE_RULE) && (obj instanceof String)) {
                        CameraConfigurationUtils.setPreviewSizeRule((String) obj);
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_AE_AF_REGION_BOX_PROPORTION) && (obj instanceof String)) {
                        try {
                            i2 = Integer.parseInt((String) obj);
                        } catch (Exception unused3) {
                            i2 = 0;
                        }
                        CameraConfigurationUtils.setRegionBoxProportion(i2);
                        MPaasLogger.d(TAG, new Object[]{"RegionBoxProportion =", Integer.valueOf(this.K)});
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_PICTURE_SIZE_TIMES) && (obj instanceof String)) {
                        CameraConfigurationUtils.setPictureSizeTimes((String) obj);
                        MPaasLogger.d(TAG, new Object[]{"setPictureSizeTimes =", obj});
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_ENABLE_AUTO_FOCUS_QUICK_SWITCH) && (obj instanceof String)) {
                        CameraManager cameraManager7 = this.d;
                        if (cameraManager7 != null) {
                            cameraManager7.setEnableAutoFocusQuickSwitch((String) obj);
                        }
                        MPaasLogger.d(TAG, new Object[]{"setEnableAutoFocusQuickSwitch:", obj});
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_ENABLE_INIT_FOCUS_TO_AUTO) && (obj instanceof String)) {
                        CameraConfigurationManager.setEnableInitFocusToAuto((String) obj);
                        MPaasLogger.d(TAG, new Object[]{"setEnableInitFocusToAuto =", obj});
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_NOT_RUN_STOP_PREVIEW) && (obj instanceof String)) {
                        CameraManager cameraManager8 = this.d;
                        if (cameraManager8 != null) {
                            cameraManager8.setNotRunStopPrev((String) obj);
                        }
                        MPaasLogger.d(TAG, new Object[]{"setNotRunStopPrev =", obj});
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_ENABLE_OPTIMIZE_PARAMETERS) && (obj instanceof String)) {
                        CompatibleManager.enableOptimizeParameters((String) obj);
                        MPaasLogger.d(TAG, new Object[]{"enableOptimizeParameters =", obj});
                    } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_THRESHOLD_SWITCH_TO_AUTO_DURATION) && (obj instanceof String)) {
                        CameraFocusParamConfig.updateThresholdSwitchToAutoDuration((String) obj);
                        MPaasLogger.d(TAG, new Object[]{"updateThresholdSwitchToAutoDuration =", obj});
                    }
                } else if (obj != null && (obj instanceof String) && (split = ((String) obj).split(",")) != null) {
                    if (split.length >= 1) {
                        FpsWhiteList.refreshCurrentDeviceInList(split[0]);
                    }
                    if (split.length >= 4) {
                        CameraConfigurationUtils.reducePreviewSize(split[3]);
                    }
                    if (split.length >= 6) {
                        CameraConfigurationUtils.setPreviewOptimize(split[5]);
                    }
                    CameraManager cameraManager9 = this.d;
                    if (cameraManager9 != null) {
                        if (split.length >= 3) {
                            cameraManager9.setAutoFocusDelayTime(split[2]);
                        }
                        if (split.length >= 5 && (cameraManager5 = this.d) != null) {
                            cameraManager5.setSupportFocusArea(BQCCameraParam.VALUE_YES.equalsIgnoreCase(split[4]));
                        }
                        if (split.length >= 7 && (cameraManager4 = this.d) != null) {
                            cameraManager4.setConfigSupportMeteringArea(BQCCameraParam.VALUE_YES.equalsIgnoreCase(split[6]));
                        }
                        if (split.length >= 8 && (cameraManager3 = this.d) != null) {
                            cameraManager3.setConfigFocusMode(split[7]);
                        }
                        if (split.length >= 9 && (cameraManager2 = this.d) != null) {
                            cameraManager2.setConfigFocusRadius(split[8]);
                        }
                        if (split.length >= 10 && (cameraManager = this.d) != null) {
                            cameraManager.setConfigSupportExposure(BQCCameraParam.VALUE_YES.equalsIgnoreCase(split[9]));
                        }
                    }
                    if (split.length >= 11) {
                        this.F = BQCCameraParam.VALUE_YES.equalsIgnoreCase(split[10]);
                    }
                    if (split.length >= 12 && BQCCameraParam.VALUE_YES.equalsIgnoreCase(split[11])) {
                        this.G = true;
                        MPaasLogger.d(TAG, new Object[]{"mUseCameraParamsCache is true"});
                    }
                    if (split.length >= 13) {
                        boolean equalsIgnoreCase = BQCCameraParam.VALUE_YES.equalsIgnoreCase(split[12]);
                        CameraManager cameraManager10 = this.d;
                        if (cameraManager10 != null) {
                            cameraManager10.setNeedCancelAutoFocus(equalsIgnoreCase);
                        }
                    }
                }
            } catch (Exception e2) {
                MPaasLogger.e(TAG, new Object[]{"setCameraParam: "}, e2);
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setContext(Context context) {
        this.s = context;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setDisplay(TextureView textureView) {
        if (textureView == null) {
            MPaasLogger.d(TAG, new Object[]{"setDisplay(): view = null"});
            TextureView textureView2 = this.f;
            if (textureView2 != null) {
                textureView2.setSurfaceTextureListener(null);
                return;
            }
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = "CAMERA_STEP setDisplay():surfaceCallback is null:";
        objArr[1] = Boolean.valueOf(this.h == null);
        MPaasLogger.d(TAG, objArr);
        textureView.setSurfaceTextureListener(this.h);
        if (textureView.isAvailable()) {
            SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
            this.g = surfaceTexture;
            Object[] objArr2 = new Object[2];
            objArr2[0] = "setDisplay: surfaceTexture is null : ";
            objArr2[1] = Boolean.valueOf(surfaceTexture == null);
            MPaasLogger.d(TAG, objArr2);
        } else {
            this.g = null;
        }
        this.f = textureView;
        CameraPerformanceRecorder.setPreviewUseSurfaceView(false);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setDisplayTexture(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            this.g = surfaceTexture;
            CameraPerformanceRecorder.setPreviewUseSurfaceView(false);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setEngineExtInfo(String str, Object obj) {
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                bQCScanController.setEngineExtInfo(str, obj);
            }
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"setSpecEngineExtInfo: "}, e2);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setEngineParameters(Map<String, Object> map) {
        setEngineParameters("MA", map);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setExposureState(int i2) {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.setExposureState(i2);
            }
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"setExposureState: "}, e2);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setFocusArea(Rect rect) {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.setFocusRegion(rect);
            }
            CameraManager cameraManager2 = this.d;
            if (cameraManager2 != null) {
                cameraManager2.setMeteringRegion(rect);
            }
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"setFocusArea: "}, e2);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setFocusPosition(int i2, int i3) {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.setFocusPosition(i2, i3);
            }
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"setFocusPosition: "}, e2);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setOpenRetryStopFlag(boolean z2) {
        MPaasLogger.d(TAG, new Object[]{"setOpenRetryStopFlag flag=", Boolean.valueOf(z2)});
        this.L = z2;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setPreviewCallback() {
        MPaasLogger.d(TAG, new Object[]{"setPreviewCallback()"});
        CameraManager cameraManager = this.d;
        if (cameraManager != null && cameraManager.getCamera() != null) {
            int previewWidth = this.d.getPreviewWidth();
            int previewHeight = this.d.getPreviewHeight();
            int pictureFormat = this.d.getPictureFormat();
            if (previewWidth != -1 && previewHeight != -1 && pictureFormat != -1) {
                try {
                    int bitsPerPixel = ((previewWidth * previewHeight) * ImageFormat.getBitsPerPixel(pictureFormat)) / 8;
                    byte[] bArr = new byte[bitsPerPixel];
                    this.d.getCamera().addCallbackBuffer(bArr);
                    byte[] bArr2 = null;
                    if (this.e.getDoubleBufferEnable()) {
                        bArr2 = new byte[bitsPerPixel];
                    }
                    this.e.setCameraBuffers(bArr, bArr2);
                    MPaasLogger.d(TAG, new Object[]{"requestPreviewFrameWithBuffer"});
                    this.d.requestPreviewFrameWithBuffer(this.e);
                } catch (Throwable th) {
                    MPaasLogger.e(TAG, new Object[]{"setPreviewCallback error: "}, th);
                }
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setScanEnable(boolean z2) {
        BQCScanController bQCScanController;
        try {
            Object[] objArr = new Object[6];
            objArr[0] = "setScanEnable(enable=";
            objArr[1] = Boolean.valueOf(z2);
            objArr[2] = ", cameraManager=null?";
            objArr[3] = Boolean.valueOf(this.d == null);
            objArr[4] = ", scanController=null?";
            objArr[5] = Boolean.valueOf(this.e == null);
            MPaasLogger.d(TAG, objArr);
            if (this.d != null && (bQCScanController = this.e) != null) {
                bQCScanController.setScanEnable(z2);
            }
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{e2.getMessage()});
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setScanRegion(Rect rect) {
        setScanRegion(rect, this.p);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean setScanType(String str) {
        return setScanType(str, null, null);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setServiceParameters(Map<String, String> map) {
        if (map != null) {
            String str = map.get(BQCCameraParam.ServicePropertyParam.USE_NEW_SCAN_EXECUTOR);
            if (str != null) {
                if (TextUtils.equals(str, BQCCameraParam.VALUE_YES)) {
                    ScanRecognizedExecutor.sUseNewExecutor = true;
                } else {
                    ScanRecognizedExecutor.sUseNewExecutor = false;
                }
            }
            String str2 = map.get(BQCCameraParam.ServicePropertyParam.SERVICE_OPERATION_CONFIG);
            if (str2 != null) {
                byte[] bytes = str2.getBytes();
                if (str2.length() < 1 || bytes[0] != 49) {
                    this.q = false;
                } else {
                    this.q = true;
                }
                if (str2.length() < 2 || bytes[1] != 49) {
                    BQCScanController.gcFirstFrame = false;
                } else {
                    BQCScanController.gcFirstFrame = true;
                }
                if (str2.length() < 4 || bytes[3] != 49) {
                    CameraHandler.mConsiderContext = false;
                } else {
                    CameraHandler.mConsiderContext = true;
                }
            } else {
                this.q = false;
                BQCScanController.gcFirstFrame = false;
                CameraHandler.mConsiderContext = false;
            }
            if (BQCCameraParam.VALUE_YES.equalsIgnoreCase(map.get("debug"))) {
                this.E = true;
            } else {
                this.E = false;
            }
            String str3 = map.get(BQCCameraParam.ServicePropertyParam.USE_NEW_SURFACE);
            if (str3 != null) {
                if (TextUtils.equals(str3, BQCCameraParam.VALUE_YES)) {
                    this.D = true;
                } else {
                    this.D = false;
                }
            }
            String str4 = map.get(BQCCameraParam.ServicePropertyParam.CAMERA_FRAME_DELAY);
            if (TextUtils.isEmpty(str4)) {
                BQCScanController.cameraFrameDelay = 0;
            } else {
                try {
                    BQCScanController.cameraFrameDelay = Integer.parseInt(str4);
                } catch (Exception unused) {
                    BQCScanController.cameraFrameDelay = 0;
                    MPaasLogger.d(TAG, new Object[]{"exception occurred on getValue(", BQCCameraParam.ServicePropertyParam.CAMERA_FRAME_DELAY, jl1.BRACKET_END_STR, str4});
                }
            }
            if (BQCCameraParam.VALUE_YES.equalsIgnoreCase(map.get(BQCCameraParam.ServicePropertyParam.SERVICE_STATISTICS_CAMERA))) {
                CameraManager.sStatisticsCameraInfo = true;
            } else {
                CameraManager.sStatisticsCameraInfo = false;
            }
            DeviceMemoryUtils.needMemoryStatistics = BQCCameraParam.VALUE_YES.equalsIgnoreCase(map.get(DeviceMemoryUtils.KEY_MEMORY_STATISTICS));
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setTorch(boolean z2) {
        CameraManager cameraManager = this.d;
        if (cameraManager != null && cameraManager.isOpen()) {
            this.d.setTorch(z2);
            this.x = z2;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setTraceLogger(MPaasLogger.BqcLogger bqcLogger) {
        if (bqcLogger != null) {
            MPaasLogger.registerBqcLogger(bqcLogger);
        } else {
            MPaasLogger.unRegisterBqcLogger();
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setZoom(int i2) {
        CameraManager cameraManager = this.d;
        if (cameraManager != null && cameraManager.isOpen()) {
            try {
                this.d.setZoomParameter(i2);
            } catch (Exception unused) {
                MPaasLogger.e(TAG, new Object[]{"setZoom exception"});
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setZoomAbsoluteRatio(int i2) {
        CameraManager cameraManager = this.d;
        if (cameraManager != null && cameraManager.isOpen()) {
            try {
                this.d.setAbsoluteZoomParameter(i2);
            } catch (Exception unused) {
                MPaasLogger.e(TAG, new Object[]{"setZoom exception"});
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setup(Context context, BQCScanCallback bQCScanCallback, int i2) {
        MPaasLogger.d(TAG, new Object[]{"CAMERA_STEP_1 setup()"});
        if (context != null) {
            this.r = context;
            Context context2 = this.s;
            if (context2 != null) {
                context = context2;
            }
            this.d = new CameraManager(context, this.k, this.l, this.m, this.b, this.p, this.n);
            CameraPreControl cameraPreControl = this.o;
            if (!(cameraPreControl == null || cameraPreControl.getTheCamera() == null)) {
                MPaasLogger.d(TAG, new Object[]{"CAMERA_STEP_1_0 use pre Camera"});
                this.d.setCameraOpened(this.o.getTheCamera());
            }
            BQCScanController bQCScanController = new BQCScanController(context, this.z, this.b, this.a, this.q, this.d, this.n);
            this.e = bQCScanController;
            bQCScanController.setResultCallback(bQCScanCallback);
            this.e.setmPaasScanService(this);
            if (!this.D) {
                this.h = new BQCSurfaceCallback();
            }
            this.f = null;
            this.g = null;
            this.B = null;
            this.C = null;
            ScanRecognizedExecutor.open();
            this.e.reportParametersSet(0);
            this.A = i2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x034a  */
    /* JADX WARNING: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    @TargetApi(19)
    public void startPreview() {
        String str;
        String str2;
        Throwable th;
        String str3;
        boolean z2;
        String str4 = "";
        this.H = 0;
        this.I = 0;
        this.J = 0;
        Object[] objArr = new Object[3];
        objArr[0] = "CAMERA_STEP_2 startPreviewing,cameraFacingType= ";
        objArr[1] = Integer.valueOf(this.A);
        Camera2AvailabilityCallback camera2AvailabilityCallback = this.c;
        if (camera2AvailabilityCallback == null) {
            str = "null";
        } else {
            str = camera2AvailabilityCallback.getCameraAvailableInfo();
        }
        objArr[2] = str;
        MPaasLogger.d(TAG, objArr);
        CameraManager cameraManager = this.d;
        if (cameraManager == null) {
            MPaasLogger.e(TAG, new Object[]{"startPreview(): cameraManager is null"});
            return;
        }
        try {
            cameraManager.setInDebugMode(this.E);
            this.d.setBqcScanController(this.e);
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"startPreview: cameraManagerControl"}, e2);
        }
        if (this.w) {
            MPaasLogger.e(TAG, new Object[]{"startPreview(): camera is previewing"});
            return;
        }
        this.w = true;
        this.i = 0;
        this.j = System.currentTimeMillis();
        o(CameraFrameWatchdog.WatcherState.CAMERA_START);
        try {
            int tryToFetchCameraPermissionStatus = ManufacturerPermissionChecker.tryToFetchCameraPermissionStatus();
            if (tryToFetchCameraPermissionStatus != 0) {
                if (tryToFetchCameraPermissionStatus == 2) {
                    str2 = "permissionDenied_timeout";
                    try {
                        MPaasLogger.d(ManufacturerPermissionChecker.TAG, new Object[]{"detect permission is denied success,permissionDenied_timeout"});
                        CameraManager cameraManager2 = this.d;
                        if (cameraManager2 == null || !cameraManager2.isOpen()) {
                            this.v = false;
                            MPaasLogger.e(TAG, new Object[]{"camera open false"});
                        }
                        if (!this.v) {
                            this.w = false;
                            this.k = null;
                            this.l = null;
                            this.m = null;
                            if (this.e != null && this.t) {
                                this.e.reportError(new BQCScanError(BQCScanError.ErrorType.CameraOpenError, str2, 0, BQCScanError.CameraAPIType.API1));
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            this.v = false;
                            str2 = th.getMessage();
                            MPaasLogger.e(TAG, new Object[]{"camera open error"});
                            CameraManager cameraManager3 = this.d;
                            this.v = false;
                            MPaasLogger.e(TAG, new Object[]{"camera open false"});
                            if (this.v) {
                            }
                        } catch (Throwable th3) {
                            CameraManager cameraManager4 = this.d;
                            if (cameraManager4 == null || !cameraManager4.isOpen()) {
                                this.v = false;
                                MPaasLogger.e(TAG, new Object[]{"camera open false"});
                            }
                            if (!this.v) {
                                this.w = false;
                                this.k = null;
                                this.l = null;
                                this.m = null;
                                if (this.e != null && this.t) {
                                    BQCScanController bQCScanController = this.e;
                                    BQCScanError.ErrorType errorType = BQCScanError.ErrorType.CameraOpenError;
                                    if (str2 != null) {
                                        str4 = str2;
                                    }
                                    bQCScanController.reportError(new BQCScanError(errorType, str4, 0, BQCScanError.CameraAPIType.API1));
                                }
                            }
                            throw th3;
                        }
                    }
                } else if (tryToFetchCameraPermissionStatus == 1) {
                    MPaasLogger.d(ManufacturerPermissionChecker.TAG, new Object[]{"detect permission is denied success,permissionDenied_openError"});
                    CameraManager cameraManager5 = this.d;
                    if (cameraManager5 == null || !cameraManager5.isOpen()) {
                        this.v = false;
                        MPaasLogger.e(TAG, new Object[]{"camera open false"});
                    }
                    if (!this.v) {
                        this.w = false;
                        this.k = null;
                        this.l = null;
                        this.m = null;
                        if (this.e != null && this.t) {
                            this.e.reportError(new BQCScanError(BQCScanError.ErrorType.CameraOpenError, "permissionDenied_openError", 0, BQCScanError.CameraAPIType.API1));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            BQCScanController bQCScanController2 = this.e;
            if (bQCScanController2 != null) {
                bQCScanController2.reportPreOpenCamera();
            }
            if (this.K <= 0) {
                this.d.openDriver(this.A);
            } else {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int i2 = this.K;
                String str5 = str4;
                boolean z3 = false;
                while (true) {
                    if (i2 <= 0) {
                        break;
                    }
                    try {
                        MPaasLogger.d(TAG, new Object[]{"retry open camera Num:#", Integer.valueOf((this.K - i2) + 1), "^flag:", Boolean.valueOf(this.L)});
                        this.d.openDriver(this.A);
                        str3 = str5;
                        z2 = false;
                    } catch (Exception e3) {
                        str3 = e3.getMessage();
                        z2 = true;
                    }
                    if (!z2) {
                        break;
                    }
                    try {
                        z3 = this.L;
                        if (z3) {
                            break;
                        }
                        if (this.K - i2 == 3) {
                            n("Camera");
                        }
                        Thread.sleep(1000);
                        i2--;
                        str5 = str3;
                    } catch (Throwable th4) {
                        MPaasLogger.e(TAG, new Object[]{"retry sleep error"}, th4);
                    }
                }
                str5 = str3;
                boolean z4 = i2 <= 0 || z3;
                MPaasLogger.d(TAG, new Object[]{"open Camera retry, tmpRetryNum=", Integer.valueOf(i2), ",tmpRetryStopFlag=", Boolean.valueOf(z3), ",isRetryFailed=", Boolean.valueOf(z4)});
                if (!z4) {
                    Class cls = Boolean.TYPE;
                    WalletBury.addWalletBury("recordOpenCameraRetryInfo", new Class[]{cls, Integer.TYPE, Long.TYPE, cls, String.class}, new Object[]{Boolean.TRUE, Integer.valueOf(this.K - i2), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), Boolean.valueOf(this.L), str5});
                } else {
                    MPaasLogger.d(TAG, new Object[]{"retry end and finally failed, throws Exception"});
                    Class cls2 = Boolean.TYPE;
                    WalletBury.addWalletBury("recordOpenCameraRetryInfo", new Class[]{cls2, Integer.TYPE, Long.TYPE, cls2, String.class}, new Object[]{Boolean.FALSE, Integer.valueOf(this.K), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), Boolean.valueOf(this.L), str5});
                    throw new RuntimeException(str5);
                }
            }
            CameraManager cameraManager6 = this.d;
            if (!(cameraManager6 == null || cameraManager6.getCamera() == null)) {
                this.d.getCamera().setErrorCallback((AntCamera.ErrorCallbackProxy) new AntCamera.ErrorCallbackProxy() {
                    /* class com.alipay.mobile.bqcscanservice.impl.MPaasScanServiceImpl.AnonymousClass2 */

                    @Override // com.alipay.camera.base.AntCamera.ErrorCallbackProxy
                    public void onErrorProxy(int i, AntCamera antCamera) {
                        try {
                            if (MPaasScanServiceImpl.this.e != null) {
                                MPaasScanServiceImpl.this.e.reportCameraErrorResult(i);
                            }
                        } catch (Throwable unused) {
                        }
                        MPaasLogger.d(MPaasScanServiceImpl.TAG, new Object[]{"ErrorCallback error: ", Integer.valueOf(i)});
                        Class cls = Integer.TYPE;
                        WalletBury.addWalletBury("recordCameraErrorCallback", new Class[]{cls, cls, Boolean.TYPE}, new Object[]{Integer.valueOf(i), 0, Boolean.FALSE});
                    }
                });
            }
            BQCScanController bQCScanController3 = this.e;
            if (bQCScanController3 != null) {
                bQCScanController3.setCameraValid(true);
                this.e.reportCameraOpened();
            }
            o(CameraFrameWatchdog.WatcherState.CAMERA_END);
            if (!this.G) {
                this.d.resetCurCameraParameters();
                MPaasLogger.d(TAG, new Object[]{"resetCurCameraParameters"});
            }
            this.d.setPreviewParameters();
            setPreviewCallback();
            this.v = true;
            this.k = this.d.getCameraParameters();
            this.l = this.d.getScreenResolution();
            this.m = this.d.getPreviewResolution();
            Object[] objArr2 = new Object[2];
            objArr2[0] = "setPreviewParameters: surfaceTexture is null:";
            objArr2[1] = Boolean.valueOf(this.g == null);
            MPaasLogger.d(TAG, objArr2);
            this.e.setmCurParameters(this.k);
            if (!this.D) {
                if (this.g != null) {
                    onSurfaceAvailable();
                }
            } else if (this.C != null) {
                onSurfaceAvailable();
            }
            if (this.t && !this.D) {
                final int i3 = this.a ? 20 : 10;
                new Thread(new Runnable() {
                    /* class com.alipay.mobile.bqcscanservice.impl.MPaasScanServiceImpl.AnonymousClass3 */

                    public void run() {
                        long j = MPaasScanServiceImpl.this.j;
                        int i = 0;
                        do {
                            try {
                                TimeUnit.SECONDS.sleep(2);
                                i += 2;
                            } catch (Exception e) {
                                MPaasLogger.e(MPaasScanServiceImpl.TAG, new Object[]{e.getMessage()});
                            }
                        } while (i < i3);
                        if (!MPaasScanServiceImpl.this.t) {
                            MPaasLogger.d(MPaasScanServiceImpl.TAG, new Object[]{"enableCameraOpenWatcher is false, not check camera open status"});
                            return;
                        }
                        MPaasLogger.d(MPaasScanServiceImpl.TAG, new Object[]{"The Postcode is ", Long.valueOf(MPaasScanServiceImpl.this.j), ", the bqcCode is ", Long.valueOf(j), ", the statisticCamera is ", Long.valueOf(MPaasScanServiceImpl.this.i)});
                        if (j == MPaasScanServiceImpl.this.j && MPaasScanServiceImpl.this.i == 0 && MPaasScanServiceImpl.this.e != null) {
                            MPaasScanServiceImpl.this.e.reportError(new BQCScanError(BQCScanError.ErrorType.CameraOpenError, "preview_error", 0, BQCScanError.CameraAPIType.API1));
                        }
                    }
                }).start();
            }
            CameraManager cameraManager7 = this.d;
            if (cameraManager7 == null || !cameraManager7.isOpen()) {
                this.v = false;
                MPaasLogger.e(TAG, new Object[]{"camera open false"});
            }
            if (!this.v) {
                this.w = false;
                this.k = null;
                this.l = null;
                this.m = null;
                if (this.e != null && this.t) {
                    this.e.reportError(new BQCScanError(BQCScanError.ErrorType.CameraOpenError, str4, 0, BQCScanError.CameraAPIType.API1));
                }
            }
        } catch (Throwable th5) {
            th = th5;
            str2 = null;
            this.v = false;
            str2 = th.getMessage();
            MPaasLogger.e(TAG, new Object[]{"camera open error"});
            CameraManager cameraManager32 = this.d;
            if (cameraManager32 == null || !cameraManager32.isOpen()) {
                this.v = false;
                MPaasLogger.e(TAG, new Object[]{"camera open false"});
            }
            if (this.v) {
                this.w = false;
                this.k = null;
                this.l = null;
                this.m = null;
                if (this.e != null && this.t) {
                    BQCScanController bQCScanController4 = this.e;
                    BQCScanError.ErrorType errorType2 = BQCScanError.ErrorType.CameraOpenError;
                    if (str2 != null) {
                        str4 = str2;
                    }
                    bQCScanController4.reportError(new BQCScanError(errorType2, str4, 0, BQCScanError.CameraAPIType.API1));
                }
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void startWatchDogMonitor() {
        try {
            CameraFrameWatchdog cameraFrameWatchdog = this.M;
            if (cameraFrameWatchdog != null) {
                cameraFrameWatchdog.startWatch();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void stopAutoFocus() {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.stopAutoFocus();
            }
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"stopAutoFocus: "}, e2);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void stopPreview() {
        BQCScanController bQCScanController = this.e;
        if (bQCScanController != null) {
            bQCScanController.setScanEnable(false);
            this.e.setCameraValid(false);
        }
        CameraManager cameraManager = this.d;
        if (cameraManager != null) {
            this.u = cameraManager.getCameraParameters();
            try {
                MPaasLogger.d(TAG, new Object[]{"CAMERA_STEP_4 stopPreview() start"});
                this.d.setBqcScanController(null);
                if (this.F) {
                    MPaasLogger.d(TAG, new Object[]{"先关闭TextureView"});
                    if (!this.D) {
                        this.d.setPreviewTextureNull();
                    } else {
                        this.d.setPreviewDisplayNull();
                    }
                }
                this.d.requestPreviewFrameWithBuffer(null);
                this.d.stopPreview();
                this.y = false;
                if (!this.D) {
                    this.g = null;
                    this.f = null;
                } else {
                    this.C = null;
                    this.B = null;
                }
                this.d.closeDriver();
                MPaasLogger.d(TAG, new Object[]{"stopPreview(), surfaceTexture = null; textureView=null"});
            } catch (Throwable th) {
                MPaasLogger.e(TAG, new Object[]{"camera stopPreview error: "}, th);
            }
        }
        this.v = false;
        this.w = false;
        this.x = false;
        this.i = 0;
        BQCScanController bQCScanController2 = this.e;
        if (bQCScanController2 != null) {
            bQCScanController2.reportCameraClosed();
            this.e.destroy();
        }
        if (this.H == 0 || this.I == 0) {
            MPaasLogger.d(TAG, new Object[]{"Cannot get the Camera Frame Rate"});
            this.J = 0;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.H;
            long j2 = this.I;
            this.J = elapsedRealtime / j2;
            MPaasLogger.d(TAG, new Object[]{"The Camera FrameRate: mFrameNum=", Long.valueOf(j2), ", duration=", Long.valueOf(elapsedRealtime), ", frame(ms)=", Long.valueOf(this.J)});
            WalletBury.addWalletBury("recordCameraFrameRate", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf((int) this.J)});
        }
        this.H = 0;
        this.I = 0;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void stopWatchDogMonitor() {
        try {
            CameraFrameWatchdog cameraFrameWatchdog = this.M;
            if (cameraFrameWatchdog != null) {
                cameraFrameWatchdog.stopWatch();
                this.M = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void takePicture(MPaasScanService.OnPictureTakenListener onPictureTakenListener) {
        if (onPictureTakenListener != null) {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.takePicture(onPictureTakenListener);
            } else {
                onPictureTakenListener.onTakenFailed();
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void tryPostCloseCamera() {
        CameraPreControl cameraPreControl = this.o;
        if (cameraPreControl != null) {
            cameraPreControl.closeCamera();
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void tryPreOpenCamera() {
        Object[] objArr = new Object[2];
        objArr[0] = "tryPreOpenCamera, mCamera2AvailabilityCallback == null?";
        objArr[1] = Boolean.valueOf(this.c == null);
        MPaasLogger.d(TAG, objArr);
        if (this.o != null) {
            MPaasLogger.d(TAG, new Object[]{"cameraPreControl is not null"});
            return;
        }
        CameraPreControl cameraPreControl = new CameraPreControl();
        this.o = cameraPreControl;
        cameraPreControl.openCamera();
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void updateServiceInitInfo(String str) {
        CameraPerformanceRecorder.updateServiceInitInfo(str);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean useAPI2() {
        return false;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void useViewFrameToRecognize(Bitmap bitmap) {
        BQCScanController bQCScanController = this.e;
        if (bQCScanController != null) {
            bQCScanController.useViewFrameToRecognize(bitmap);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setEngineParameters(String str, Map<String, Object> map) {
        if (str != null) {
            try {
                BQCScanController bQCScanController = this.e;
                if (bQCScanController != null) {
                    bQCScanController.setEngineParams(str, map);
                }
            } catch (Exception e2) {
                MPaasLogger.e(TAG, new Object[]{"setEngineParameters: "}, e2);
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setScanRegion(Rect rect, Point point) {
        BQCScanController bQCScanController;
        try {
            this.p = point;
            if (this.d != null && (bQCScanController = this.e) != null) {
                bQCScanController.setScanRegion(rect);
            }
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"setScanRegion()"}, e2);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean setScanType(String str, BQCCameraParam.MaEngineType maEngineType) {
        return setScanType(str, maEngineType, null);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean setScanType(String str, BQCCameraParam.MaEngineType maEngineType, String str2) {
        BQCScanController bQCScanController;
        MPaasLogger.d(TAG, new Object[]{"setScanType(", str, AVFSCacheConstants.COMMA_SEP + maEngineType, AVFSCacheConstants.COMMA_SEP, str2, jl1.BRACKET_END_STR});
        if (!(this.d == null || (bQCScanController = this.e) == null)) {
            try {
                return bQCScanController.setScanType(str, maEngineType, str2);
            } catch (Exception e2) {
                MPaasLogger.e(TAG, new Object[]{"setScanType error:"}, e2);
            }
        }
        return false;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setDisplay(TextureView textureView, boolean z2) {
        Object[] objArr = new Object[4];
        objArr[0] = "CAMERA_STEP setDisplay(): view != null?";
        boolean z3 = true;
        objArr[1] = Boolean.valueOf(textureView != null);
        objArr[2] = ", surfaceTextureSet:";
        objArr[3] = Boolean.valueOf(z2);
        MPaasLogger.d(TAG, objArr);
        if (textureView == null) {
            TextureView textureView2 = this.f;
            if (textureView2 != null) {
                textureView2.setSurfaceTextureListener(null);
                return;
            }
            return;
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = "setDisplay():surfaceCallback==null?";
        objArr2[1] = Boolean.valueOf(this.h == null);
        MPaasLogger.d(TAG, objArr2);
        textureView.setSurfaceTextureListener(this.h);
        if (!z2) {
            boolean isAvailable = textureView.isAvailable();
            if (isAvailable) {
                this.g = textureView.getSurfaceTexture();
            } else {
                this.g = null;
            }
            Object[] objArr3 = new Object[4];
            objArr3[0] = "setDisplay():texture.isAvailable()";
            objArr3[1] = Boolean.valueOf(isAvailable);
            objArr3[2] = "surfaceTexture==null?";
            if (this.g != null) {
                z3 = false;
            }
            objArr3[3] = Boolean.valueOf(z3);
            MPaasLogger.d(TAG, objArr3);
        }
        this.f = textureView;
        CameraPerformanceRecorder.setPreviewUseSurfaceView(false);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setup(Context context, BQCScanCallback bQCScanCallback) {
        setup(context, bQCScanCallback, 0);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setDisplay(SurfaceView surfaceView) {
        Object[] objArr = new Object[2];
        boolean z2 = false;
        objArr[0] = "CAMERA_STEP setDisplay(): view==null?";
        if (surfaceView == null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        MPaasLogger.d(TAG, objArr);
        if (this.D) {
            this.B = surfaceView;
            this.C = surfaceView.getHolder();
            CameraPerformanceRecorder.setPreviewUseSurfaceView(true);
        }
    }
}
