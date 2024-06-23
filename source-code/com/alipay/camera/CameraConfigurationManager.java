package com.alipay.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.camera.base.AntCamera;
import com.alipay.camera.compatible.CompatibleManager;
import com.alipay.camera.util.CameraConfigurationUtils;
import com.alipay.camera.util.CameraFocusParamConfig;
import com.alipay.camera.util.CameraSceneParamConfig;
import com.alipay.camera.util.FocusWhiteList;
import com.alipay.camera.util.FpsWhiteList;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.alipay.mobile.bqcscanservice.monitor.ScanExceptionHandler;
import com.alipay.util.ScanDeviceProperty;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.util.List;
import tb.jl1;
import tb.v;

/* compiled from: Taobao */
public final class CameraConfigurationManager {
    private static boolean t;
    private final Context a;
    private Point b;
    private Point c;
    private Point d;
    private int e;
    private String f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private CameraFocusParamConfig k;
    private CameraSceneParamConfig l;
    private boolean m;
    private Rect n;
    private int o;
    private Rect p;
    private final boolean q;
    private final boolean r;
    private int s;

    public CameraConfigurationManager(Context context, Point point, Point point2, boolean z, boolean z2) {
        this.e = 90;
        this.o = 50;
        this.s = 0;
        this.a = context;
        this.b = point;
        this.c = point2;
        this.k = new CameraFocusParamConfig();
        this.l = new CameraSceneParamConfig();
        this.q = z;
        this.r = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0072  */
    private int a(int i2) {
        int i3;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        AntCamera.getCameraInfo(i2, cameraInfo, "Scan");
        if (TextUtils.equals("MIX 2", Build.getMODEL())) {
            int rotation = ((WindowManager) this.a.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getRotation();
            this.s = rotation;
            if (rotation != 0) {
                if (rotation == 1) {
                    i3 = 90;
                } else if (rotation == 2) {
                    i3 = 180;
                } else if (rotation == 3) {
                    i3 = AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
                }
                MPaasLogger.d("CameraConfiguration", new Object[]{"getCameraPreviewOrientation(orientation : ", Integer.valueOf(cameraInfo.orientation), " degrees :", Integer.valueOf(i3), jl1.BRACKET_END_STR});
                if (cameraInfo.facing != 1) {
                    return (360 - ((cameraInfo.orientation + i3) % 360)) % 360;
                }
                return ((cameraInfo.orientation - i3) + 360) % 360;
            }
        }
        i3 = 0;
        MPaasLogger.d("CameraConfiguration", new Object[]{"getCameraPreviewOrientation(orientation : ", Integer.valueOf(cameraInfo.orientation), " degrees :", Integer.valueOf(i3), jl1.BRACKET_END_STR});
        if (cameraInfo.facing != 1) {
        }
    }

    private void b(int i2) {
        StringBuilder sb = new StringBuilder();
        String brand = Build.getBRAND();
        sb.append(brand);
        sb.append("|");
        String model = Build.getMODEL();
        sb.append(model);
        sb.append("|");
        sb.append(android.os.Build.DISPLAY);
        String sb2 = sb.toString();
        int a2 = a(i2);
        this.e = a2;
        if (a2 == 90 || a2 == 270) {
            WalletBury.addWalletBury("recordPreviewOrientationNewCal", new Class[]{String.class, Integer.TYPE}, new Object[]{sb2, Integer.valueOf(a2)});
            return;
        }
        WalletBury.addWalletBury("recordPreviewOrientationOld", new Class[]{String.class, Integer.TYPE}, new Object[]{sb2, Integer.valueOf(a2)});
        if (model != null) {
            MPaasLogger.d("CameraConfiguration", new Object[]{"The device is ", brand, AVFSCacheConstants.COMMA_SEP, model});
            if (!model.contains("M9") || !brand.contains("Meizu")) {
                this.e = 90;
            } else {
                this.e = 180;
            }
        }
    }

    private Camera.Parameters c(Camera camera, Camera.Parameters parameters) {
        try {
            CameraConfigurationUtils.setFocusArea(parameters, this.b, this.n, this.e);
            camera.setParameters(parameters);
            MPaasLogger.d("CameraConfiguration", new Object[]{"invokeFocusRegion succeed"});
            WalletBury.addWalletBury("recordCameraParametersSet", new Class[]{String.class, String.class}, new String[]{"focus-area", "true"});
        } catch (Exception e2) {
            MPaasLogger.e("CameraConfiguration", new Object[]{"invokeFocusRegion failed"}, e2);
            WalletBury.addWalletBury("recordCameraParametersSet", new Class[]{String.class, String.class}, new String[]{"focus-area", "false"});
        }
        return camera.getParameters();
    }

    private void d(Camera.Parameters parameters, boolean z) {
        CameraConfigurationUtils.setTorch(parameters, z);
    }

    private int e(Camera.Parameters parameters) {
        List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        if (supportedPreviewFormats.contains(17)) {
            return 17;
        }
        if (supportedPreviewFormats.contains(842094169)) {
            return 842094169;
        }
        return -1;
    }

    private void f(Camera.Parameters parameters) {
        d(parameters, false);
    }

    private boolean g() {
        if (!"xiaomi".equalsIgnoreCase(Build.getBRAND()) || Build.VERSION.SDK_INT < 17 || Settings.Global.getInt(this.a.getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
            return false;
        }
        return true;
    }

    public static void setEnableInitFocusToAuto(String str) {
        MPaasLogger.d("CameraConfiguration", new Object[]{"setEnableInitFocusToAuto:", str});
        if (!TextUtils.isEmpty(str)) {
            t = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
        }
    }

    public Camera.Parameters adjustExposure(AntCamera antCamera, Camera.Parameters parameters, int i2) {
        return antCamera == null ? parameters : adjustExposure(antCamera.getCamera(), parameters, i2);
    }

    public Camera.Parameters forceInvokeFocusRegion(AntCamera antCamera, Camera.Parameters parameters) {
        return (antCamera == null || parameters == null) ? parameters : c(antCamera.getCamera(), parameters);
    }

    public int getCameraDisplayOrientation() {
        return this.e;
    }

    public String getFocusMode() {
        MPaasLogger.d("CameraConfiguration", new Object[]{"The focus mode is ", this.f});
        return this.f;
    }

    public CameraFocusParamConfig getFocusParamConfig() {
        return this.k;
    }

    public Point getPictureSize() {
        return this.d;
    }

    public int getPreviewFmt() {
        return this.g;
    }

    public Point getPreviewResolution() {
        return this.c;
    }

    public Point getPreviewSize() {
        return this.c;
    }

    public Point getScreenResolution() {
        return this.b;
    }

    public boolean getSupportExposure() {
        return this.j;
    }

    public boolean getSupportFocusArea() {
        return this.h;
    }

    public boolean getSupportMeteringArea() {
        return this.i;
    }

    public boolean getTorchState(AntCamera antCamera) {
        if (antCamera == null) {
            return false;
        }
        return getTorchState(antCamera.getCamera());
    }

    public Camera.Parameters initFromCameraParameters(AntCamera antCamera) {
        if (antCamera == null) {
            return null;
        }
        return initFromCameraParameters(antCamera.getCamera(), (Point) null);
    }

    public Camera.Parameters invokeExposure(AntCamera antCamera, Camera.Parameters parameters, int i2) {
        return antCamera == null ? parameters : invokeExposure(antCamera.getCamera(), parameters, i2);
    }

    public Camera.Parameters invokeFocusParameters(AntCamera antCamera, Camera.Parameters parameters) {
        return antCamera == null ? parameters : invokeFocusParameters(antCamera.getCamera(), parameters);
    }

    public Camera.Parameters invokeFocusRegion(AntCamera antCamera, Camera.Parameters parameters) {
        return antCamera == null ? parameters : invokeFocusRegion(antCamera.getCamera(), parameters);
    }

    public Camera.Parameters invokeMeteringRegion(AntCamera antCamera, Camera.Parameters parameters) {
        return antCamera == null ? parameters : invokeMeteringRegion(antCamera.getCamera(), parameters);
    }

    public Camera.Parameters setCameraScene(Camera.Parameters parameters, String str) {
        CameraSceneParamConfig cameraSceneParamConfig = this.l;
        if (cameraSceneParamConfig != null) {
            cameraSceneParamConfig.updateScene(str);
            if (this.l.getCurCameraScene() != null) {
                CameraConfigurationUtils.setBarcodeSceneMode(parameters, str);
            }
        }
        return parameters;
    }

    public void setConfigFocusMode(String str) {
        CameraFocusParamConfig cameraFocusParamConfig = this.k;
        if (cameraFocusParamConfig != null) {
            cameraFocusParamConfig.updateFocusMode(str);
        }
    }

    public void setConfigSecondAutoDelayDuration(long j2) {
        CameraFocusParamConfig cameraFocusParamConfig = this.k;
        if (cameraFocusParamConfig != null) {
            cameraFocusParamConfig.setSecondDelayDuration(j2);
        }
    }

    public void setDebugMode(boolean z) {
        this.m = z;
        if (z) {
            this.k.updateFocusMode("debug");
        }
    }

    public Camera.Parameters setDesiredCameraParameters(AntCamera antCamera, Camera.Parameters parameters, int i2) {
        return antCamera == null ? parameters : setDesiredCameraParameters(antCamera.getCamera(), parameters, i2);
    }

    public void setFocusPosition(int i2, int i3) {
        if (this.b != null && this.c != null) {
            int i4 = this.o;
            int i5 = 0;
            int i6 = i2 - i4 < 0 ? 0 : i2 - i4;
            if (i3 - i4 >= 0) {
                i5 = i3 - i4;
            }
            int i7 = i2 + i4;
            Point point = this.b;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            if (i7 <= xVar) {
                xVar = i2 + i4;
            }
            int i8 = i3 + i4;
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            if (i8 <= yVar) {
                yVar = i3 + i4;
            }
            Rect rect = new Rect(i6, i5, xVar, yVar);
            Rect rect2 = new Rect();
            int i9 = this.e;
            if (i9 == 90) {
                Point point2 = this.c;
                int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2);
                Point point3 = this.b;
                int yVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3);
                rect2.left = (rect.top * xVar2) / yVar2;
                int yVar3 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2);
                int xVar3 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3);
                rect2.top = ((xVar3 - rect.right) * yVar3) / xVar3;
                rect2.right = (xVar2 * rect.bottom) / yVar2;
                rect2.bottom = (yVar3 * (xVar3 - rect.left)) / xVar3;
            } else if (i9 == 270) {
                Point point4 = this.c;
                int xVar4 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point4);
                Point point5 = this.b;
                int yVar4 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point5);
                rect2.left = ((yVar4 - rect.bottom) * xVar4) / yVar4;
                int yVar5 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point4);
                int xVar5 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point5);
                rect2.top = (rect.left * yVar5) / xVar5;
                rect2.right = (xVar4 * (yVar4 - rect.top)) / yVar4;
                rect2.bottom = (yVar5 * rect.right) / xVar5;
            } else {
                return;
            }
            int i10 = rect2.right;
            int i11 = rect2.left;
            int i12 = i10 - i11;
            int i13 = rect2.bottom;
            int i14 = rect2.top;
            int i15 = i13 - i14;
            if (i12 < i15) {
                rect2.right = i11 + i15;
            } else {
                rect2.bottom = i14 + i12;
            }
            this.n = rect2;
        }
    }

    public void setFocusRadius(int i2) {
        this.o = i2;
    }

    public void setFocusRegion(Rect rect) {
        this.n = rect;
    }

    public void setMeteringRegion(Rect rect) {
        this.p = rect;
    }

    public void setSupportExposureState(boolean z) {
        this.j = z;
    }

    public void setSupportFocusArea(boolean z) {
        this.h = z;
    }

    public void setSupportMeteringArea(boolean z) {
        this.i = z;
    }

    public void setTorch(AntCamera antCamera, boolean z) throws ScanExceptionHandler.TorchException {
        if (antCamera != null) {
            setTorch(antCamera.getCamera(), z);
        }
    }

    public void updateAutoFocusConfig(String str, long j2) {
        CameraFocusParamConfig cameraFocusParamConfig = this.k;
        if (cameraFocusParamConfig != null) {
            cameraFocusParamConfig.setSecondDelayDuration(j2);
            this.k.setSecondFocusMode(str);
        }
    }

    public void updateFocusMode(String str) {
        MPaasLogger.d("CameraConfiguration", new Object[]{"The origin focus mode is ", this.f, ", the input focus mode is ", str});
        this.f = str;
    }

    public Camera.Parameters adjustExposure(Camera camera, Camera.Parameters parameters, int i2) {
        if (!this.j || camera == null || parameters == null) {
            return parameters;
        }
        try {
            int minExposureCompensation = parameters.getMinExposureCompensation();
            int maxExposureCompensation = parameters.getMaxExposureCompensation();
            if (minExposureCompensation != 0) {
                if (maxExposureCompensation != 0) {
                    int exposureCompensation = parameters.getExposureCompensation();
                    MPaasLogger.d("CameraConfiguration", new Object[]{"Old Exposure State: ", Integer.valueOf(exposureCompensation), ", difference: ", Integer.valueOf(i2)});
                    int i3 = exposureCompensation + i2;
                    if (i3 >= minExposureCompensation) {
                        minExposureCompensation = i3;
                    }
                    if (minExposureCompensation <= maxExposureCompensation) {
                        maxExposureCompensation = minExposureCompensation;
                    }
                    CameraConfigurationUtils.setExposureState(parameters, maxExposureCompensation);
                    camera.setParameters(parameters);
                    return camera.getParameters();
                }
            }
            MPaasLogger.d("CameraConfiguration", new Object[]{"did not support exposure"});
            return parameters;
        } catch (Exception e2) {
            MPaasLogger.e("CameraConfiguration", new Object[]{"invokeExposure failed"}, e2);
        }
    }

    public boolean getTorchState(Camera camera) {
        Camera.Parameters parameters;
        String flashMode;
        if (camera == null || (parameters = camera.getParameters()) == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        if ("on".equals(flashMode) || "torch".equals(flashMode)) {
            return true;
        }
        return false;
    }

    public Camera.Parameters initFromCameraParameters(Camera camera) {
        return initFromCameraParameters(camera, (Point) null);
    }

    public Camera.Parameters invokeExposure(Camera camera, Camera.Parameters parameters, int i2) {
        if (!this.j || camera == null || parameters == null) {
            return parameters;
        }
        try {
            CameraConfigurationUtils.setExposureState(parameters, i2);
            camera.setParameters(parameters);
        } catch (Exception e2) {
            MPaasLogger.e("CameraConfiguration", new Object[]{"invokeExposure failed"}, e2);
        }
        return camera.getParameters();
    }

    public Camera.Parameters invokeFocusParameters(Camera camera, Camera.Parameters parameters) {
        CameraFocusParamConfig cameraFocusParamConfig = this.k;
        if (cameraFocusParamConfig == null) {
            return parameters;
        }
        CameraConfigurationUtils.setFocus(parameters, cameraFocusParamConfig.getInitFocusMode(), this.k.getInitFocusAuto());
        camera.setParameters(parameters);
        Camera.Parameters parameters2 = camera.getParameters();
        String focusMode = parameters2.getFocusMode();
        this.f = focusMode;
        this.k.confirmInitFocusMode(focusMode);
        return parameters2;
    }

    public Camera.Parameters invokeFocusRegion(Camera camera, Camera.Parameters parameters) {
        MPaasLogger.d("CameraConfiguration", new Object[]{"invokeFocusRegion: ", this.n, ", mSupportFocusArea:" + this.h});
        return (this.n == null || !this.h || camera == null || parameters == null) ? parameters : c(camera, parameters);
    }

    public Camera.Parameters invokeMeteringRegion(Camera camera, Camera.Parameters parameters) {
        MPaasLogger.d("CameraConfiguration", new Object[]{"invokeMeteringRegion: ", this.p});
        if (this.p == null || !this.i || camera == null || parameters == null) {
            return parameters;
        }
        try {
            CameraConfigurationUtils.setMetering(parameters, this.b, this.n, this.e);
            camera.setParameters(parameters);
            MPaasLogger.d("CameraConfiguration", new Object[]{"invokeMeteringRegion succeed"});
            WalletBury.addWalletBury("recordCameraParametersSet", new Class[]{String.class, String.class}, new String[]{"metering-area", "true"});
        } catch (Exception e2) {
            MPaasLogger.e("CameraConfiguration", new Object[]{"invokeMeteringRegion failed"}, e2);
            WalletBury.addWalletBury("recordCameraParametersSet", new Class[]{String.class, String.class}, new String[]{"metering-area", "false"});
        }
        return camera.getParameters();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0050 */
    public Camera.Parameters setDesiredCameraParameters(Camera camera, Camera.Parameters parameters, int i2) {
        Point point;
        int xVar;
        if (camera == null) {
            return parameters;
        }
        if (parameters == null) {
            parameters = camera.getParameters();
        }
        if (FpsWhiteList.inWhiteList(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND(), com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL())) {
            CameraConfigurationUtils.setBestPreviewFPS(parameters, 20, 30);
        }
        f(parameters);
        try {
            b(i2);
            camera.setDisplayOrientation(this.e);
            MPaasLogger.d("CameraConfiguration", new Object[]{"setDisplayOrientation: ", Integer.valueOf(this.e)});
        } catch (Exception unknown) {
            camera.setDisplayOrientation(this.e);
            MPaasLogger.d("CameraConfiguration", new Object[]{"setDisplayOrientation again: ", Integer.valueOf(this.e)});
        } catch (NoSuchMethodError e2) {
            parameters.setRotation(this.e);
            MPaasLogger.e("CameraConfiguration", new Object[]{"method error"}, e2);
        }
        try {
            camera.setDisplayOrientation(this.e);
            MPaasLogger.d("CameraConfiguration", new Object[]{"setDisplayOrientation again: ", Integer.valueOf(this.e)});
        } catch (Exception e3) {
            MPaasLogger.e("CameraConfiguration", new Object[]{"method error again "}, e3);
            parameters.setRotation(90);
        }
        int e4 = e(parameters);
        this.g = e4;
        if (e4 >= 0) {
            parameters.setPreviewFormat(e4);
        }
        Point point2 = this.c;
        parameters.setPreviewSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
        Point findPictureSizeByTimes = CameraConfigurationUtils.findPictureSizeByTimes(parameters, this.c, this.q);
        this.d = findPictureSizeByTimes;
        boolean z = this.r || this.q;
        MPaasLogger.d("CameraConfiguration", new Object[]{"setDesiredCameraParameters, setPicSizeAndZsl: ", Boolean.valueOf(z)});
        if (z && findPictureSizeByTimes != null) {
            parameters.setPictureSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(findPictureSizeByTimes), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(findPictureSizeByTimes));
        }
        if (parameters.isZoomSupported()) {
            parameters.setZoom((int) (((double) (((float) parameters.getMaxZoom()) * 0.0f)) + 0.5d));
        }
        if (findPictureSizeByTimes != null) {
            String postValidFocusMode = FocusWhiteList.postValidFocusMode("" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(findPictureSizeByTimes) + jl1.MUL + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(findPictureSizeByTimes));
            MPaasLogger.d("CameraConfiguration", new Object[]{"setDesiredParameters: postFocusType=", postValidFocusMode});
            if (this.k != null && !TextUtils.isEmpty(postValidFocusMode)) {
                this.k.postValidFocusMode(postValidFocusMode);
            }
        }
        if (t && ScanDeviceProperty.isXiaomiDevDevice() && this.k != null) {
            MPaasLogger.d("CameraConfiguration", new Object[]{"xiaomi dev device, switch to auto mode"});
            this.k.postValidFocusMode("auto");
            WalletBury.addWalletBury("recordForceSwitchToAutoFocusMode", new Class[]{Boolean.TYPE, String.class}, new Object[]{Boolean.FALSE, String.valueOf(ScanDeviceProperty.getRomVersion())});
        }
        String str = null;
        if (!this.m) {
            CameraFocusParamConfig cameraFocusParamConfig = this.k;
            boolean initFocusAuto = cameraFocusParamConfig != null ? cameraFocusParamConfig.getInitFocusAuto() : true;
            CameraFocusParamConfig cameraFocusParamConfig2 = this.k;
            if (cameraFocusParamConfig2 != null) {
                str = cameraFocusParamConfig2.getInitFocusMode();
            }
            CameraConfigurationUtils.setFocus(parameters, str, initFocusAuto);
            String focusMode = parameters.getFocusMode();
            this.f = focusMode;
            this.k.confirmInitFocusMode(focusMode);
        } else {
            CameraConfigurationUtils.setBarcodeSceneMode(parameters, "auto");
            CameraConfigurationUtils.setFocus(parameters, null, true);
            String focusMode2 = parameters.getFocusMode();
            this.f = focusMode2;
            this.k.confirmInitFocusMode(focusMode2);
        }
        if (z) {
            CompatibleManager.enableSetZSLValue(true);
            CompatibleManager.setZslValue(parameters, !this.q);
        }
        MPaasLogger.d("CameraConfiguration", new Object[]{"The Object focusMode is ", this.f});
        long elapsedRealtime = SystemClock.elapsedRealtime();
        CompatibleManager.optimizeParameters(parameters);
        camera.setParameters(parameters);
        Camera.Parameters parameters2 = camera.getParameters();
        MPaasLogger.i("CameraConfiguration", new Object[]{"duringSetParam2 =", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)});
        Camera.Size previewSize = parameters2.getPreviewSize();
        if (!(previewSize == null || ((xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx((point = this.c))) == previewSize.width && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) == previewSize.height))) {
            Class cls = Integer.TYPE;
            WalletBury.addWalletBury("recordCameraPreviewParametersNotEqual", new Class[]{cls, cls, cls, cls}, new Object[]{Integer.valueOf(xVar), Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.c)), Integer.valueOf(previewSize.width), Integer.valueOf(previewSize.height)});
            Point point3 = this.c;
            point3.x = previewSize.width;
            point3.y = previewSize.height;
        }
        return parameters2;
    }

    public void setTorch(Camera camera, boolean z) throws ScanExceptionHandler.TorchException {
        Camera.Parameters parameters = camera.getParameters();
        d(parameters, z);
        try {
            camera.setParameters(parameters);
        } catch (Exception e2) {
            Log.d("CameraConfiguration", "Toggle Torch Error");
            throw new ScanExceptionHandler.TorchException(z, 4001, e2.getMessage());
        }
    }

    public Camera.Parameters initFromCameraParameters(AntCamera antCamera, Point point) {
        if (antCamera == null) {
            return null;
        }
        return initFromCameraParameters(antCamera.getCamera(), point);
    }

    public Camera.Parameters initFromCameraParameters(Camera camera, Point point) {
        if (camera == null) {
            return null;
        }
        Camera.Parameters parameters = camera.getParameters();
        MPaasLogger.d("CameraConfiguration", new Object[]{"The first time to get parameters"});
        Display defaultDisplay = ((WindowManager) this.a.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        if (CameraConfigurationUtils.getPreviewOptimize()) {
            Point point2 = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point2);
            this.b = point2;
        } else if (!g() || !CameraConfigurationUtils.getEnableDynamicPreviewSize()) {
            Point point3 = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point3);
            this.b = point3;
        } else {
            MPaasLogger.d("CameraConfiguration", new Object[]{"needFetchRealSize"});
            Point point4 = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point4);
            this.b = point4;
        }
        if (point == null || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) < 480 || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) < 800) {
            point = this.b;
        }
        this.c = CameraConfigurationUtils.findBestPreviewSizeValue(parameters, point, this.q);
        String model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        if ((model.contains("HTC") && model.contains("One")) || model.contains("GT-N7100") || model.contains("GT-I9300")) {
            this.c = new Point(1280, LoginConstant.RESULT_WINDWANE_CLOSEW);
        } else if (model.equals("u8800")) {
            this.c = new Point(LoginConstant.RESULT_WINDWANE_CLOSEW, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);
        } else if (model.equals("MI PAD")) {
            this.c = new Point(2048, 1536);
        }
        return parameters;
    }

    public CameraConfigurationManager(Context context, Point point, Point point2) {
        this.e = 90;
        this.o = 50;
        this.s = 0;
        this.a = context;
        this.b = point;
        this.c = point2;
        this.k = new CameraFocusParamConfig();
        this.l = new CameraSceneParamConfig();
        this.q = false;
        this.r = false;
    }

    public CameraConfigurationManager(Context context, Point point, Point point2, Point point3) {
        this(context, point, point2);
        MPaasLogger.d("CameraConfiguration", new Object[]{"pictureResolution: ", point3});
    }
}
