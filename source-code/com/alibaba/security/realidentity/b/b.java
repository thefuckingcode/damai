package com.alibaba.security.realidentity.b;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alibaba.security.common.c.a;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.IOException;
import java.util.Map;
import tb.v;

/* compiled from: Taobao */
public final class b {
    private static final String b = "b";
    private static final int c = 240;
    private static final int d = 240;
    private static final int e = 1200;
    private static final int f = 675;
    public Camera a;
    private final Context g;
    private final a h;
    private Rect i;
    private Rect j;
    private boolean k;
    private boolean l;
    private int m = -1;
    private int n;
    private int o;
    private long p = 0;
    private long q = 2000;

    public b(Context context) {
        this.g = context;
        this.h = new a(context);
    }

    public static int d() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras < 0) {
            return -1;
        }
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 0) {
                return i2;
            }
        }
        return -1;
    }

    private synchronized boolean e() {
        return this.a != null;
    }

    private synchronized Rect f() {
        if (this.i == null) {
            if (this.a == null) {
                return null;
            }
            Point point = this.h.b;
            if (point == null) {
                return null;
            }
            int a2 = a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), 1200);
            int a3 = a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), (int) f);
            int xVar = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) - a2) / 2;
            int yVar = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) - a3) / 2;
            this.i = new Rect(xVar, yVar, a2 + xVar, a3 + yVar);
        }
        return this.i;
    }

    private synchronized Rect g() {
        if (this.j == null) {
            Rect f2 = f();
            if (f2 == null) {
                return null;
            }
            Rect rect = new Rect(f2);
            a aVar = this.h;
            Point point = aVar.c;
            Point point2 = aVar.b;
            if (point == null || point2 == null) {
                return null;
            }
            int i2 = rect.left;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2);
            rect.left = (i2 * xVar) / xVar2;
            rect.right = (rect.right * xVar) / xVar2;
            int i3 = rect.top;
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            int yVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2);
            rect.top = (i3 * yVar) / yVar2;
            rect.bottom = (rect.bottom * yVar) / yVar2;
            this.j = rect;
        }
        return this.j;
    }

    private int h() {
        return this.a.getParameters().getZoom();
    }

    private int i() {
        return this.a.getParameters().getMaxZoom();
    }

    private Camera j() {
        return this.a;
    }

    private void k() {
        this.a.cancelAutoFocus();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b1  */
    public final synchronized void a(SurfaceHolder surfaceHolder) throws IOException {
        String str;
        int i2;
        int i3;
        Camera camera = this.a;
        if (camera == null) {
            camera = c.a(this.m);
            if (camera != null) {
                this.a = camera;
            } else {
                throw new IOException();
            }
        }
        camera.setPreviewDisplay(surfaceHolder);
        if (!this.k) {
            this.k = true;
            a aVar = this.h;
            Camera.Parameters parameters = camera.getParameters();
            Display defaultDisplay = ((WindowManager) aVar.a.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 13) {
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
            }
            aVar.b = point;
            aVar.c = com.alibaba.security.realidentity.utils.b.a(parameters, point);
            String model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
            if ((!model.contains("HTC") || !model.contains("One")) && !model.contains("GT-N7100")) {
                if (!model.contains("GT-I9300")) {
                    if (model.equals("u8800")) {
                        aVar.c = new Point(LoginConstant.RESULT_WINDWANE_CLOSEW, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);
                    } else if (model.equals("MI PAD")) {
                        aVar.c = new Point(2048, 1536);
                    }
                    aVar.e = com.alibaba.security.realidentity.utils.b.a(parameters, aVar.d);
                    if (model.contains("ASUS_Z00ADB")) {
                        aVar.e = new Point(1280, LoginConstant.RESULT_WINDWANE_CLOSEW);
                    }
                    i2 = this.n;
                    if (i2 > 0 && (i3 = this.o) > 0) {
                        b(i2, i3);
                        this.n = 0;
                        this.o = 0;
                    }
                }
            }
            aVar.c = new Point(1280, LoginConstant.RESULT_WINDWANE_CLOSEW);
            aVar.e = com.alibaba.security.realidentity.utils.b.a(parameters, aVar.d);
            if (model.contains("ASUS_Z00ADB")) {
            }
            i2 = this.n;
            b(i2, i3);
            this.n = 0;
            this.o = 0;
        }
        Camera.Parameters parameters2 = camera.getParameters();
        if (parameters2 == null) {
            str = null;
        } else {
            str = parameters2.flatten();
        }
        try {
            this.h.a(camera, false);
        } catch (RuntimeException unused) {
            if (str != null) {
                Camera.Parameters parameters3 = camera.getParameters();
                parameters3.unflatten(str);
                try {
                    camera.setParameters(parameters3);
                    this.h.a(camera, true);
                } catch (RuntimeException unused2) {
                    a.e(b, "Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
    }

    public final synchronized void b() {
        long currentTimeMillis = System.currentTimeMillis();
        Camera camera = this.a;
        if (camera != null && !this.l) {
            camera.startPreview();
            String str = b;
            a.b(str, "SQY: startPreview.theCamera.startPreview Costs" + (System.currentTimeMillis() - currentTimeMillis));
            this.l = true;
            a.b(str, "SQY: startPreview new AutoFocusManager Costs" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final synchronized void c() {
        Camera camera = this.a;
        if (camera != null && this.l) {
            camera.stopPreview();
            this.l = false;
        }
    }

    private synchronized void b(int i2, int i3) {
        if (this.k) {
            Point point = this.h.b;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            if (i2 > xVar) {
                i2 = xVar;
            }
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            if (i3 > yVar) {
                i3 = yVar;
            }
            int i4 = (xVar - i2) / 2;
            int i5 = (yVar - i3) / 2;
            this.i = new Rect(i4, i5, i2 + i4, i3 + i5);
            this.j = null;
            return;
        }
        this.n = i2;
        this.o = i3;
    }

    private void b(int i2) {
        Camera.Parameters parameters = this.a.getParameters();
        parameters.setZoom(i2);
        this.a.setParameters(parameters);
    }

    private void b(long j2) {
        this.q = j2;
    }

    public final synchronized void a() {
        try {
            Camera camera = this.a;
            if (camera != null) {
                camera.release();
                this.a = null;
                this.i = null;
                this.j = null;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private synchronized void a(boolean z) {
        Camera camera;
        if (!(z == a.a(this.a) || (camera = this.a) == null)) {
            a aVar = this.h;
            Camera.Parameters parameters = camera.getParameters();
            aVar.a(parameters, z, false);
            camera.setParameters(parameters);
        }
    }

    private synchronized void a(Camera.PreviewCallback previewCallback) {
        Camera camera = this.a;
        if (camera != null && this.l) {
            camera.setPreviewCallback(previewCallback);
        }
    }

    private static int a(int i2, int i3) {
        int i4 = (i2 * 5) / 8;
        if (i4 < 240) {
            return GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
        }
        return i4 > i3 ? i3 : i4;
    }

    public final synchronized void a(int i2) {
        this.m = i2;
    }

    private void a(long j2) {
        this.p = j2;
    }

    private void a(Map<String, Integer> map) {
        this.h.f = map;
    }

    private void a(Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback) {
        Camera camera = this.a;
        if (camera != null) {
            camera.takePicture(shutterCallback, null, pictureCallback);
        }
    }

    public final void a(Camera.AutoFocusCallback autoFocusCallback) {
        Camera camera = this.a;
        if (camera != null) {
            String focusMode = camera.getParameters().getFocusMode();
            if (focusMode.equals("auto") || focusMode.equals(BQCCameraParam.FOCUS_TYPE_MACRO)) {
                this.a.autoFocus(autoFocusCallback);
            }
        }
    }
}
