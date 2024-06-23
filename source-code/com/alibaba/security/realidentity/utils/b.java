package com.alibaba.security.realidentity.utils;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import com.alibaba.security.common.c.a;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import tb.jl1;

@TargetApi(15)
/* compiled from: Taobao */
public final class b {
    private static final String a = "CameraConfiguration";
    private static final Pattern b = Pattern.compile(";");
    private static final int c = 153600;
    private static final int d = 1024000;
    private static final int e = 307200;
    private static final int f = 384000;
    private static int g = -1;
    private static int h = -1;
    private static final float i = 1.5f;
    private static final float j = 0.0f;
    private static final double k = 0.15d;
    private static final int l = 10;
    private static final int m = 20;
    private static final int n = 400;

    private b() {
    }

    public static void a(Camera.Parameters parameters, boolean z, boolean z2, boolean z3) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String a2 = z ? (z3 || z2) ? a(supportedFocusModes, "auto") : a(supportedFocusModes, "continuous-picture", "continuous-video", "auto") : null;
        if (!z3 && a2 == null) {
            a2 = a(supportedFocusModes, BQCCameraParam.FOCUS_TYPE_MACRO, BQCCameraParam.FOCUS_TYPE_EDOF);
        }
        if (a2 == null) {
            return;
        }
        if (a2.equals(parameters.getFocusMode())) {
            a.b(a, "Focus mode already set to ".concat(a2));
        } else {
            parameters.setFocusMode(a2);
        }
    }

    public static void b(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (!(minExposureCompensation == 0 && maxExposureCompensation == 0)) {
            float f2 = 0.0f;
            if (exposureCompensationStep > 0.0f) {
                if (!z) {
                    f2 = 1.5f;
                }
                int round = Math.round(f2 / exposureCompensationStep);
                float f3 = exposureCompensationStep * ((float) round);
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    a.b(a, "Exposure compensation already set to " + max + " / " + f3);
                    return;
                }
                a.b(a, "Setting exposure compensation to " + max + " / " + f3);
                parameters.setExposureCompensation(max);
                return;
            }
        }
        a.b(a, "Camera does not support exposure compensation");
    }

    public static void c(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            a.b(a, "This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            a.b(a, "Video stabilization already enabled");
        } else {
            a.b(a, "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    public static void d(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            a.b(a, "Barcode scene mode already set");
            return;
        }
        String a2 = a(parameters.getSupportedSceneModes(), "barcode");
        if (a2 != null) {
            parameters.setSceneMode(a2);
        }
    }

    public static void e(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            a.b(a, "Negative effect already set");
            return;
        }
        String a2 = a(parameters.getSupportedColorEffects(), "negative");
        if (a2 != null) {
            parameters.setColorEffect(a2);
        }
    }

    private static void f(Camera.Parameters parameters) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        a.b(a, "Supported FPS ranges: " + a((Collection<int[]>) supportedPreviewFpsRange));
        if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
            int[] iArr = null;
            Iterator<int[]> it = supportedPreviewFpsRange.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int[] next = it.next();
                int i2 = next[0];
                int i3 = next[1];
                if (i2 >= 10000 && i3 <= 20000) {
                    iArr = next;
                    break;
                }
            }
            if (iArr == null) {
                a.b(a, "No suitable FPS range?");
                return;
            }
            int[] iArr2 = new int[2];
            parameters.getPreviewFpsRange(iArr2);
            if (Arrays.equals(iArr2, iArr)) {
                a.b(a, "FPS range already set to " + Arrays.toString(iArr));
                return;
            }
            a.b(a, "Setting FPS range to " + Arrays.toString(iArr));
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    private static void g(Camera.Parameters parameters) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        a.b(a, "Supported FPS ranges: " + a((Collection<int[]>) supportedPreviewFpsRange));
        if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
            int[] iArr = null;
            Iterator<int[]> it = supportedPreviewFpsRange.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int[] next = it.next();
                int i2 = next[0];
                int i3 = next[1];
                if (i2 >= 10000 && i3 <= 20000) {
                    iArr = next;
                    break;
                }
            }
            if (iArr == null) {
                a.b(a, "No suitable FPS range?");
                return;
            }
            int[] iArr2 = new int[2];
            parameters.getPreviewFpsRange(iArr2);
            if (Arrays.equals(iArr2, iArr)) {
                a.b(a, "FPS range already set to " + Arrays.toString(iArr));
                return;
            }
            a.b(a, "Setting FPS range to " + Arrays.toString(iArr));
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    private static String h(Camera.Parameters parameters) {
        String flatten = parameters.flatten();
        StringBuilder sb = new StringBuilder(1000);
        sb.append("BOARD=");
        sb.append(Build.BOARD);
        sb.append('\n');
        sb.append("BRAND=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND());
        sb.append('\n');
        sb.append("CPU_ABI=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI());
        sb.append('\n');
        sb.append("DEVICE=");
        sb.append(Build.DEVICE);
        sb.append('\n');
        sb.append("DISPLAY=");
        sb.append(Build.DISPLAY);
        sb.append('\n');
        sb.append("FINGERPRINT=");
        sb.append(Build.FINGERPRINT);
        sb.append('\n');
        sb.append("HOST=");
        sb.append(Build.HOST);
        sb.append('\n');
        sb.append("ID=");
        sb.append(Build.ID);
        sb.append('\n');
        sb.append("MANUFACTURER=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
        sb.append('\n');
        sb.append("MODEL=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL());
        sb.append('\n');
        sb.append("PRODUCT=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getPRODUCT());
        sb.append('\n');
        sb.append("TAGS=");
        sb.append(Build.TAGS);
        sb.append('\n');
        sb.append("TIME=");
        sb.append(Build.TIME);
        sb.append('\n');
        sb.append("TYPE=");
        sb.append(Build.TYPE);
        sb.append('\n');
        sb.append("USER=");
        sb.append(Build.USER);
        sb.append('\n');
        sb.append("VERSION.CODENAME=");
        sb.append(Build.VERSION.CODENAME);
        sb.append('\n');
        sb.append("VERSION.INCREMENTAL=");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append('\n');
        sb.append("VERSION.RELEASE=");
        sb.append(Build.VERSION.getRELEASE());
        sb.append('\n');
        sb.append("VERSION.SDK_INT=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append('\n');
        if (flatten != null) {
            String[] split = b.split(flatten);
            Arrays.sort(split);
            for (String str : split) {
                sb.append(str);
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    private static int c() {
        int i2 = g;
        return i2 > 0 ? i2 : e;
    }

    public static void a(Camera.Parameters parameters, boolean z) {
        String str;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            str = a(supportedFlashModes, "torch", "on");
        } else {
            str = a(supportedFlashModes, "off");
        }
        if (str == null) {
            return;
        }
        if (str.equals(parameters.getFlashMode())) {
            a.b(a, "Flash mode already set to ".concat(str));
            return;
        }
        a.b(a, "Setting flash mode to ".concat(str));
        parameters.setFlashMode(str);
    }

    public static void b(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            a.b(a, "Old metering areas: " + parameters.getMeteringAreas());
            List<Camera.Area> a2 = a();
            a.b(a, "Setting metering area to : " + a((Iterable<Camera.Area>) a2));
            parameters.setMeteringAreas(a2);
            return;
        }
        a.b(a, "Device does not support metering areas");
    }

    public static void a(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            a.b(a, "Old focus areas: " + a((Iterable<Camera.Area>) parameters.getFocusAreas()));
            List<Camera.Area> a2 = a();
            a.b(a, "Setting focus area to : " + a((Iterable<Camera.Area>) a2));
            parameters.setFocusAreas(a2);
            return;
        }
        a.b(a, "Device does not support focus areas");
    }

    private static int b() {
        int i2 = h;
        return i2 > 0 ? i2 : f;
    }

    private static Integer b(Camera.Parameters parameters, double d2) {
        List<Integer> zoomRatios = parameters.getZoomRatios();
        a.b(a, "Zoom ratios: ".concat(String.valueOf(zoomRatios)));
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios == null || zoomRatios.isEmpty() || zoomRatios.size() != maxZoom + 1) {
            a.e(a, "Invalid zoom ratios!");
            return null;
        }
        double d3 = d2 * 100.0d;
        double d4 = Double.POSITIVE_INFINITY;
        int i2 = 0;
        for (int i3 = 0; i3 < zoomRatios.size(); i3++) {
            double abs = Math.abs(((double) zoomRatios.get(i3).intValue()) - d3);
            if (abs < d4) {
                i2 = i3;
                d4 = abs;
            }
        }
        a.b(a, "Chose zoom ratio of " + (((double) zoomRatios.get(i2).intValue()) / 100.0d));
        return Integer.valueOf(i2);
    }

    private static List<Camera.Area> a() {
        return Collections.singletonList(new Camera.Area(new Rect(-400, -400, 400, 400), 1));
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001b  */
    public static Point a(Camera.Parameters parameters, int i2) {
        int i3;
        int i4;
        ArrayList<Camera.Size> arrayList = new ArrayList(parameters.getSupportedPictureSizes());
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            /* class com.alibaba.security.realidentity.utils.b.AnonymousClass1 */

            private static int a(Camera.Size size, Camera.Size size2) {
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
                Camera.Size size3 = size;
                Camera.Size size4 = size2;
                int i = size3.height * size3.width;
                int i2 = size4.height * size4.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }
        });
        for (Camera.Size size : arrayList) {
            int i5 = size.width;
            int i6 = size.height;
            int i7 = i5 * i6;
            int i8 = h;
            if (i8 <= 0) {
                i8 = f;
            }
            if (i7 <= i8 || "LA6-L".equals(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL())) {
                return new Point(i5, i6);
            }
            while (r5.hasNext()) {
            }
        }
        Camera.Size size2 = (Camera.Size) arrayList.get(0);
        if (i2 % 180 == 0) {
            i3 = size2.width;
            i4 = size2.height;
        } else {
            i3 = size2.height;
            i4 = size2.width;
        }
        return new Point(i3, i4);
    }

    private static void a(Camera.Parameters parameters, double d2) {
        Integer num;
        if (parameters.isZoomSupported()) {
            List<Integer> zoomRatios = parameters.getZoomRatios();
            a.b(a, "Zoom ratios: ".concat(String.valueOf(zoomRatios)));
            int maxZoom = parameters.getMaxZoom();
            if (zoomRatios == null || zoomRatios.isEmpty() || zoomRatios.size() != maxZoom + 1) {
                a.e(a, "Invalid zoom ratios!");
                num = null;
            } else {
                double d3 = d2 * 100.0d;
                double d4 = Double.POSITIVE_INFINITY;
                int i2 = 0;
                for (int i3 = 0; i3 < zoomRatios.size(); i3++) {
                    double abs = Math.abs(((double) zoomRatios.get(i3).intValue()) - d3);
                    if (abs < d4) {
                        i2 = i3;
                        d4 = abs;
                    }
                }
                a.b(a, "Chose zoom ratio of " + (((double) zoomRatios.get(i2).intValue()) / 100.0d));
                num = Integer.valueOf(i2);
            }
            if (num != null) {
                if (parameters.getZoom() == num.intValue()) {
                    a.b(a, "Zoom is already set to ".concat(String.valueOf(num)));
                    return;
                }
                a.b(a, "Setting zoom to ".concat(String.valueOf(num)));
                parameters.setZoom(num.intValue());
                return;
            }
            return;
        }
        a.b(a, "Zoom is not supported");
    }

    public static Point a(Camera.Parameters parameters, Point point) {
        String str;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        String str2 = "Parameters contained no preview size!";
        if (supportedPreviewSizes == null) {
            a.e(a, "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException(str2);
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            /* class com.alibaba.security.realidentity.utils.b.AnonymousClass2 */

            private static int a(Camera.Size size, Camera.Size size2) {
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
                Camera.Size size3 = size;
                Camera.Size size4 = size2;
                int i = size3.height * size3.width;
                int i2 = size4.height * size4.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }
        });
        if (a.a()) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            a.b(a, "Supported preview sizes: ".concat(String.valueOf(sb)));
        }
        double xVar = ((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)) / ((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        if (!(xVar < 1.0d)) {
            xVar = 1.0d / xVar;
        }
        a.b(a, "SQY:" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) + Constants.Name.X + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        Point point2 = null;
        double d2 = Double.POSITIVE_INFINITY;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            int i2 = size2.width;
            int i3 = size2.height;
            int i4 = i2 * i3;
            if (i4 < c || i4 > d) {
                str = str2;
                it.remove();
            } else {
                boolean z = i2 > i3;
                int i5 = z ? i3 : i2;
                int i6 = z ? i2 : i3;
                if (i5 == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) && i6 == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) {
                    return new Point(i2, i3);
                }
                str = str2;
                double abs = Math.abs((((double) i5) / ((double) i6)) - xVar);
                if (abs < d2) {
                    point2 = new Point(i2, i3);
                    d2 = abs;
                }
            }
            str2 = str;
        }
        if (point2 != null) {
            return point2;
        }
        Camera.Size previewSize2 = parameters.getPreviewSize();
        if (previewSize2 != null) {
            return new Point(previewSize2.width, previewSize2.height);
        }
        throw new IllegalStateException(str2);
    }

    private static void a(List<Camera.Size> list) {
        String str = "";
        for (Camera.Size size : list) {
            str = str + size.width + Constants.Name.X + size.height + StringUtils.LF;
        }
    }

    private static String a(Collection<String> collection, String... strArr) {
        if (collection == null) {
            return null;
        }
        for (String str : strArr) {
            if (collection.contains(str)) {
                return str;
            }
        }
        return null;
    }

    private static String a(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(jl1.ARRAY_START);
        Iterator<int[]> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(Arrays.toString(it.next()));
            if (it.hasNext()) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
        }
        sb.append(jl1.ARRAY_END);
        return sb.toString();
    }

    private static String a(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area area : iterable) {
            sb.append(area.rect);
            sb.append(jl1.CONDITION_IF_MIDDLE);
            sb.append(area.weight);
            sb.append(' ');
        }
        return sb.toString();
    }

    private static String a(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("BOARD=");
        sb.append(android.os.Build.BOARD);
        sb.append('\n');
        sb.append("BRAND=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND());
        sb.append('\n');
        sb.append("CPU_ABI=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI());
        sb.append('\n');
        sb.append("DEVICE=");
        sb.append(android.os.Build.DEVICE);
        sb.append('\n');
        sb.append("DISPLAY=");
        sb.append(android.os.Build.DISPLAY);
        sb.append('\n');
        sb.append("FINGERPRINT=");
        sb.append(android.os.Build.FINGERPRINT);
        sb.append('\n');
        sb.append("HOST=");
        sb.append(android.os.Build.HOST);
        sb.append('\n');
        sb.append("ID=");
        sb.append(android.os.Build.ID);
        sb.append('\n');
        sb.append("MANUFACTURER=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
        sb.append('\n');
        sb.append("MODEL=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL());
        sb.append('\n');
        sb.append("PRODUCT=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getPRODUCT());
        sb.append('\n');
        sb.append("TAGS=");
        sb.append(android.os.Build.TAGS);
        sb.append('\n');
        sb.append("TIME=");
        sb.append(android.os.Build.TIME);
        sb.append('\n');
        sb.append("TYPE=");
        sb.append(android.os.Build.TYPE);
        sb.append('\n');
        sb.append("USER=");
        sb.append(android.os.Build.USER);
        sb.append('\n');
        sb.append("VERSION.CODENAME=");
        sb.append(Build.VERSION.CODENAME);
        sb.append('\n');
        sb.append("VERSION.INCREMENTAL=");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append('\n');
        sb.append("VERSION.RELEASE=");
        sb.append(Build.VERSION.getRELEASE());
        sb.append('\n');
        sb.append("VERSION.SDK_INT=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append('\n');
        if (charSequence != null) {
            String[] split = b.split(charSequence);
            Arrays.sort(split);
            for (String str : split) {
                sb.append(str);
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}
