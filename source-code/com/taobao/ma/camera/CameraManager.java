package com.taobao.ma.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.ma.camera.AutoFocusManager;
import com.taobao.ma.camera.open.OpenCameraInterface;
import com.taobao.ma.camera.util.PlanarYUVLuminanceSource;
import com.taobao.ma.common.log.MaLogger;
import java.io.IOException;
import java.util.Map;

/* compiled from: Taobao */
public final class CameraManager {
    private static final int MAX_FRAME_HEIGHT = 675;
    private static final int MAX_FRAME_WIDTH = 1200;
    private static final int MIN_FRAME_HEIGHT = 240;
    private static final int MIN_FRAME_WIDTH = 240;
    private static final String TAG = "CameraManager";
    private long autoFocusInterval = 2000;
    private AutoFocusManager autoFocusManager;
    private Camera camera;
    private final CameraConfigurationManager configManager;
    private final Context context;
    private long firstFocusDelay = 0;
    private AutoFocusManager.OnAutoFocusListener focusListener = null;
    private Rect framingRect;
    private Rect framingRectInPreview;
    private boolean initialized;
    private boolean previewing;
    private int requestedCameraId = -1;
    private int requestedFramingRectHeight;
    private int requestedFramingRectWidth;

    public CameraManager(Context context2) {
        this.context = context2;
        this.configManager = new CameraConfigurationManager(context2);
    }

    private static int findDesiredDimensionInRange(int i, int i2, int i3) {
        int i4 = (i * 5) / 8;
        if (i4 < i2) {
            return i2;
        }
        return i4 > i3 ? i3 : i4;
    }

    public PlanarYUVLuminanceSource buildLuminanceSource(byte[] bArr, int i, int i2) {
        Rect framingRectInPreview2 = getFramingRectInPreview();
        if (framingRectInPreview2 == null) {
            return null;
        }
        return new PlanarYUVLuminanceSource(bArr, i, i2, framingRectInPreview2.left, framingRectInPreview2.top, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(framingRectInPreview2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(framingRectInPreview2), false);
    }

    public synchronized void closeDriver() {
        Camera camera2 = this.camera;
        if (camera2 != null) {
            camera2.release();
            this.camera = null;
            this.framingRect = null;
            this.framingRectInPreview = null;
        }
    }

    public Camera getCamera() {
        return this.camera;
    }

    public synchronized Rect getFramingRect() {
        if (this.framingRect == null) {
            if (this.camera == null) {
                return null;
            }
            Point screenResolution = this.configManager.getScreenResolution();
            if (screenResolution == null) {
                return null;
            }
            int findDesiredDimensionInRange = findDesiredDimensionInRange(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(screenResolution), GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 1200);
            int findDesiredDimensionInRange2 = findDesiredDimensionInRange(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(screenResolution), GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, MAX_FRAME_HEIGHT);
            int xVar = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(screenResolution) - findDesiredDimensionInRange) / 2;
            int yVar = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(screenResolution) - findDesiredDimensionInRange2) / 2;
            this.framingRect = new Rect(xVar, yVar, findDesiredDimensionInRange + xVar, findDesiredDimensionInRange2 + yVar);
            String str = TAG;
            Log.d(str, "Calculated framing rect: " + this.framingRect);
        }
        return this.framingRect;
    }

    public synchronized Rect getFramingRectInPreview() {
        if (this.framingRectInPreview == null) {
            Rect framingRect2 = getFramingRect();
            if (framingRect2 == null) {
                return null;
            }
            Rect rect = new Rect(framingRect2);
            Point cameraResolution = this.configManager.getCameraResolution();
            Point screenResolution = this.configManager.getScreenResolution();
            if (cameraResolution == null || screenResolution == null) {
                return null;
            }
            int i = rect.left;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(cameraResolution);
            int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(screenResolution);
            rect.left = (i * xVar) / xVar2;
            rect.right = (rect.right * xVar) / xVar2;
            int i2 = rect.top;
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(cameraResolution);
            int yVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(screenResolution);
            rect.top = (i2 * yVar) / yVar2;
            rect.bottom = (rect.bottom * yVar) / yVar2;
            this.framingRectInPreview = rect;
        }
        return this.framingRectInPreview;
    }

    public int getMaxZoom() {
        return this.camera.getParameters().getMaxZoom();
    }

    public int getZoomParameter() {
        return this.camera.getParameters().getZoom();
    }

    public synchronized boolean isOpen() {
        return this.camera != null;
    }

    public synchronized void openDriver(SurfaceHolder surfaceHolder) throws IOException {
        String str;
        int i;
        Camera camera2 = this.camera;
        if (camera2 == null) {
            camera2 = OpenCameraInterface.open(this.requestedCameraId);
            if (camera2 != null) {
                this.camera = camera2;
            } else {
                throw new IOException();
            }
        }
        camera2.setPreviewDisplay(surfaceHolder);
        if (!this.initialized) {
            this.initialized = true;
            this.configManager.initFromCameraParameters(camera2);
            int i2 = this.requestedFramingRectWidth;
            if (i2 > 0 && (i = this.requestedFramingRectHeight) > 0) {
                setManualFramingRect(i2, i);
                this.requestedFramingRectWidth = 0;
                this.requestedFramingRectHeight = 0;
            }
        }
        Camera.Parameters parameters = camera2.getParameters();
        if (parameters == null) {
            str = null;
        } else {
            str = parameters.flatten();
        }
        try {
            this.configManager.setDesiredCameraParameters(camera2, false);
        } catch (RuntimeException unused) {
            String str2 = TAG;
            Log.w(str2, "Camera rejected parameters. Setting only minimal safe-mode parameters");
            Log.i(str2, "Resetting to saved camera params: " + str);
            if (str != null) {
                Camera.Parameters parameters2 = camera2.getParameters();
                parameters2.unflatten(str);
                try {
                    camera2.setParameters(parameters2);
                    this.configManager.setDesiredCameraParameters(camera2, true);
                } catch (RuntimeException unused2) {
                    Log.w(TAG, "Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
    }

    public synchronized void requestPreviewFrame(Camera.PreviewCallback previewCallback) {
        Camera camera2 = this.camera;
        if (camera2 != null && this.previewing) {
            camera2.setPreviewCallback(previewCallback);
        }
    }

    public void setAutoFocusInterval(long j) {
        this.autoFocusInterval = j;
    }

    public void setCompatibleRotation(Map<String, Integer> map) {
        this.configManager.setCompatibleRotation(map);
    }

    public void setFirstFocusDelay(long j) {
        this.firstFocusDelay = j;
    }

    public void setFocusListener(AutoFocusManager.OnAutoFocusListener onAutoFocusListener) {
        this.focusListener = onAutoFocusListener;
    }

    public synchronized void setManualCameraId(int i) {
        this.requestedCameraId = i;
    }

    public synchronized void setManualFramingRect(int i, int i2) {
        if (this.initialized) {
            Point screenResolution = this.configManager.getScreenResolution();
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(screenResolution);
            if (i > xVar) {
                i = xVar;
            }
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(screenResolution);
            if (i2 > yVar) {
                i2 = yVar;
            }
            int i3 = (xVar - i) / 2;
            int i4 = (yVar - i2) / 2;
            this.framingRect = new Rect(i3, i4, i + i3, i2 + i4);
            String str = TAG;
            Log.d(str, "Calculated manual framing rect: " + this.framingRect);
            this.framingRectInPreview = null;
        } else {
            this.requestedFramingRectWidth = i;
            this.requestedFramingRectHeight = i2;
        }
    }

    public synchronized void setTorch(boolean z) {
        try {
            if (!(z == this.configManager.getTorchState(this.camera) || this.camera == null)) {
                AutoFocusManager autoFocusManager2 = this.autoFocusManager;
                if (autoFocusManager2 != null) {
                    autoFocusManager2.stop();
                }
                this.configManager.setTorch(this.camera, z);
                AutoFocusManager autoFocusManager3 = this.autoFocusManager;
                if (autoFocusManager3 != null) {
                    autoFocusManager3.restart();
                }
            }
        } catch (Exception unused) {
            MaLogger.i("maybe light hardware broken ");
        }
        return;
    }

    public void setZoomParameter(int i) {
        Camera.Parameters parameters = this.camera.getParameters();
        parameters.setZoom(i);
        this.camera.setParameters(parameters);
    }

    public synchronized void startPreview() {
        long currentTimeMillis = System.currentTimeMillis();
        Camera camera2 = this.camera;
        if (camera2 != null && !this.previewing) {
            camera2.startPreview();
            String str = TAG;
            Log.i(str, "SQY: startPreview.theCamera.startPreview Costs" + (System.currentTimeMillis() - currentTimeMillis));
            this.previewing = true;
            AutoFocusManager autoFocusManager2 = new AutoFocusManager(this.context, this.camera);
            this.autoFocusManager = autoFocusManager2;
            autoFocusManager2.setAutoFocusInterval(this.autoFocusInterval);
            this.autoFocusManager.startAutoFocus(this.firstFocusDelay);
            this.autoFocusManager.setFocusListener(this.focusListener);
            Log.i(str, "SQY: startPreview new AutoFocusManager Costs" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public synchronized void stopPreview() {
        AutoFocusManager autoFocusManager2 = this.autoFocusManager;
        if (autoFocusManager2 != null) {
            autoFocusManager2.stop();
            this.autoFocusManager.setFocusListener(null);
            this.autoFocusManager = null;
        }
        Camera camera2 = this.camera;
        if (camera2 != null && this.previewing) {
            camera2.stopPreview();
            this.previewing = false;
        }
    }
}
