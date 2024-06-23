package com.alipay.camera.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.jl1;

/* compiled from: Taobao */
public final class CameraConfigurationUtils {
    private static int a = 768000;
    private static int b = 3075200;
    private static boolean c = false;
    private static boolean d = false;
    private static int e = 1555200;
    private static int f = 540000;
    private static boolean g = false;
    private static String h = "default";
    private static int i = 0;
    private static float j = 4.0f;

    private CameraConfigurationUtils() {
    }

    private static Rect a(Rect rect, Camera.Size size) {
        int i2;
        MPaasLogger.d("CameraConfiguration", new Object[]{"adjustScanRectSize, originalScanRect:", rect, ", sRegionBoxProportion:", Integer.valueOf(i)});
        if (size == null || (i2 = i) <= 0 || i2 > 10) {
            return rect;
        }
        int min = (int) (((((float) Math.min(size.width, size.height)) * 0.5f) * ((float) i)) / 10.0f);
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int i3 = size.width / 2;
        int i4 = size.height / 2;
        int centerX2 = (int) (((float) rect.centerX()) * ((((float) (centerX - i3)) / ((float) i3)) + 1.0f));
        int centerY2 = (int) (((float) rect.centerY()) * ((((float) (centerY - i4)) / ((float) i4)) + 1.0f));
        Rect rect2 = new Rect(centerX2 - min, centerY2 - min, centerX2 + min, centerY2 + min);
        rect2.left = b(rect2.left, 0, size.width);
        rect2.top = b(rect2.top, 0, size.height);
        rect2.right = b(rect2.right, 0, size.width);
        rect2.bottom = b(rect2.bottom, 0, size.height);
        MPaasLogger.d("CameraConfiguration", new Object[]{"adjustScanRectSize result:", rect2});
        return rect2;
    }

    private static int b(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    private static Point c(List<Point> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new Comparator<Point>() {
            /* class com.alipay.camera.util.CameraConfigurationUtils.AnonymousClass3 */

            public int compare(Point point, Point point2) {
                int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
                int yVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2);
                if (yVar2 < yVar) {
                    return -1;
                }
                return yVar2 > yVar ? 1 : 0;
            }
        });
        return (Point) arrayList.get(0);
    }

    private static String d(String str, Collection<String> collection, String... strArr) {
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    MPaasLogger.i("CameraConfiguration", new Object[]{"Can set ", str, " to: ", str2});
                    return str2;
                }
            }
        }
        MPaasLogger.i("CameraConfiguration", new Object[]{"No supported values match"});
        return null;
    }

    private static void e(Camera.Parameters parameters, Point point, Point point2) {
        try {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null) {
                ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
                Collections.sort(arrayList, new Comparator<Camera.Size>() {
                    /* class com.alipay.camera.util.CameraConfigurationUtils.AnonymousClass5 */

                    public int compare(Camera.Size size, Camera.Size size2) {
                        int i = size.height * size.width;
                        int i2 = size2.height * size2.width;
                        if (i2 < i) {
                            return -1;
                        }
                        return i2 > i ? 1 : 0;
                    }
                });
                double xVar = ((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)) / ((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
                if (!(xVar < 1.0d)) {
                    xVar = 1.0d / xVar;
                }
                Point point3 = null;
                double d2 = Double.POSITIVE_INFINITY;
                for (Camera.Size size : arrayList) {
                    int i2 = size.width;
                    int i3 = size.height;
                    boolean z = i2 > i3;
                    double abs = Math.abs((((double) (z ? i3 : i2)) / ((double) (z ? i2 : i3))) - xVar);
                    if (abs < d2) {
                        point3 = new Point(i2, i3);
                        d2 = abs;
                    }
                }
                if (point3 != null) {
                    int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3);
                    int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3);
                    if (!(xVar2 == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2) && yVar == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2))) {
                        Class cls = Integer.TYPE;
                        WalletBury.addWalletBury("recordCameraPreviewSizeWithNoLimit", new Class[]{cls, cls, cls, cls}, new Object[]{Integer.valueOf(xVar2), Integer.valueOf(yVar), Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2)), Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2))});
                    }
                }
            }
        } catch (Throwable th) {
            MPaasLogger.e("CameraConfiguration", new Object[]{th.getMessage()});
        }
    }

    private static String f(Iterable<Camera.Area> iterable) {
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

    public static Point findBestPictureSize(List<Point> list) {
        return c(list);
    }

    public static Point findBestPictureSizeValue(Camera.Parameters parameters, int i2) {
        ArrayList arrayList = new ArrayList(parameters.getSupportedPictureSizes());
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            /* class com.alipay.camera.util.CameraConfigurationUtils.AnonymousClass2 */

            public int compare(Camera.Size size, Camera.Size size2) {
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }
        });
        Camera.Size size = (Camera.Size) arrayList.get(0);
        return new Point(size.width, size.height);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (java.lang.Math.min(r14, r15) >= 720) goto L_0x0060;
     */
    public static Point findBestPreviewSizeValue(List<Point> list, Point point, boolean z) {
        String str;
        double d2;
        double xVar = ((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)) / ((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        if (z) {
            str = "small";
        } else {
            str = h;
        }
        if (!(xVar < 1.0d)) {
            xVar = 1.0d / xVar;
        }
        Point point2 = null;
        double d3 = Double.POSITIVE_INFINITY;
        for (Point point3 : list) {
            int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3);
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3);
            int i2 = xVar2 * yVar;
            if (c) {
                if (i2 < b && i2 > a) {
                    int xVar3 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
                    int yVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
                    if (xVar3 * yVar2 < i2) {
                    }
                    boolean z2 = xVar2 > yVar;
                    int i3 = z2 ? yVar : xVar2;
                    int i4 = z2 ? xVar2 : yVar;
                    if (!"big".equalsIgnoreCase(str) && !"small".equalsIgnoreCase(str) && i3 == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) && i4 == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) {
                        return new Point(xVar2, yVar);
                    }
                    d2 = d3;
                    double abs = Math.abs((((double) i3) / ((double) i4)) - xVar);
                    boolean z3 = "small".equalsIgnoreCase(str) && Math.abs(abs - d2) < 1.0E-6d;
                    if (abs < d2 || z3) {
                        point2 = new Point(xVar2, yVar);
                        d3 = abs;
                    }
                    d3 = d2;
                }
            } else if (d) {
            }
            d2 = d3;
            d3 = d2;
        }
        return point2 == null ? list.get(0) : point2;
    }

    public static Point findPictureSizeByTimes(Camera.Parameters parameters, Point point, boolean z) {
        if (parameters == null || point == null) {
            return null;
        }
        float f2 = z ? 1.0f : j;
        ArrayList arrayList = new ArrayList(parameters.getSupportedPictureSizes());
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            /* class com.alipay.camera.util.CameraConfigurationUtils.AnonymousClass1 */

            public int compare(Camera.Size size, Camera.Size size2) {
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }
        });
        float xVar = ((float) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point))) * f2;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Camera.Size size = (Camera.Size) arrayList.get(i2);
            int i3 = size.width;
            if (((float) (size.height * i3)) <= xVar) {
                MPaasLogger.d("CameraConfiguration", new Object[]{"findPictureSizeByTimes:", Integer.valueOf(i3), Constants.Name.X, Integer.valueOf(size.height)});
                return new Point(size.width, size.height);
            }
        }
        if (arrayList.size() <= 0) {
            return point;
        }
        Camera.Size size2 = (Camera.Size) arrayList.get(0);
        if (z) {
            size2 = (Camera.Size) arrayList.get(arrayList.size() - 1);
        }
        return new Point(size2.width, size2.height);
    }

    private static String g(Collection<int[]> collection) {
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

    public static boolean getEnableDynamicPreviewSize() {
        return g;
    }

    public static boolean getPreviewOptimize() {
        return c;
    }

    public static void reducePreviewSize(String str) {
        if (str.equalsIgnoreCase(BQCCameraParam.VALUE_YES)) {
            d = true;
            MPaasLogger.i("CameraConfiguration", new Object[]{"reducePreviewSize"});
        }
    }

    public static boolean setAutoFocus(Camera.Parameters parameters) {
        if (parameters == null) {
            return false;
        }
        String d2 = d("focus mode", parameters.getSupportedFocusModes(), "auto");
        if (!TextUtils.equals(d2, "auto")) {
            return false;
        }
        MPaasLogger.d("CameraConfiguration", new Object[]{"setFocusMode to Auto."});
        parameters.setFocusMode(d2);
        return true;
    }

    public static void setBarcodeSceneMode(Camera.Parameters parameters, String str) {
        if ("barcode".equals(parameters.getSceneMode())) {
            MPaasLogger.i("CameraConfiguration", new Object[]{"Barcode scene mode already set"});
            return;
        }
        String d2 = d("scene mode", parameters.getSupportedSceneModes(), str);
        if (d2 != null) {
            parameters.setSceneMode(d2);
        }
    }

    public static void setBestExposure(Camera.Parameters parameters, boolean z) {
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
                    MPaasLogger.i("CameraConfiguration", new Object[]{"Exposure compensation already set to ", Integer.valueOf(max), " / ", Float.valueOf(f3)});
                    return;
                }
                MPaasLogger.i("CameraConfiguration", new Object[]{"Setting exposure compensation to ", Integer.valueOf(max), " / ", Float.valueOf(f3)});
                parameters.setExposureCompensation(max);
                return;
            }
        }
        MPaasLogger.i("CameraConfiguration", new Object[]{"Camera does not support exposure compensation"});
    }

    public static void setBestPreviewFPS(Camera.Parameters parameters, int i2, int i3) {
        int i4;
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        MPaasLogger.i("CameraConfiguration", new Object[]{"Supported FPS ranges: ", g(supportedPreviewFpsRange)});
        if (!(supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty())) {
            int[] iArr = null;
            int i5 = 0;
            for (int[] iArr2 : supportedPreviewFpsRange) {
                int i6 = iArr2[0];
                int i7 = iArr2[1];
                if (i6 >= i2 * 1000 && i7 <= i3 * 1000 && (i4 = (i6 / 1000) * (i7 / 1000)) > i5) {
                    iArr = iArr2;
                    i5 = i4;
                }
            }
            if (iArr == null) {
                MPaasLogger.i("CameraConfiguration", new Object[]{"No suitable FPS range?"});
                return;
            }
            int[] iArr3 = new int[2];
            parameters.getPreviewFpsRange(iArr3);
            if (Arrays.equals(iArr3, iArr)) {
                MPaasLogger.i("CameraConfiguration", new Object[]{"FPS range already set to ", Arrays.toString(iArr)});
                return;
            }
            MPaasLogger.i("CameraConfiguration", new Object[]{"Setting FPS range to ", Arrays.toString(iArr)});
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    public static void setEnableDynamicPreviewSize(String str) {
        if (BQCCameraParam.VALUE_YES.equalsIgnoreCase(str)) {
            g = true;
            MPaasLogger.d("CameraConfiguration", new Object[]{"setEnableDynamicPreviewSize"});
        }
    }

    public static void setExposureState(Camera.Parameters parameters, int i2) {
        if (parameters != null) {
            int minExposureCompensation = parameters.getMinExposureCompensation();
            int maxExposureCompensation = parameters.getMaxExposureCompensation();
            MPaasLogger.d("CameraConfiguration", new Object[]{"setExposureState: min = ", Integer.valueOf(minExposureCompensation), ", max = ", Integer.valueOf(maxExposureCompensation)});
            if (minExposureCompensation == 0 && maxExposureCompensation == 0) {
                MPaasLogger.d("CameraConfiguration", new Object[]{"The device is not support exposure state"});
            } else if (i2 < minExposureCompensation || i2 > maxExposureCompensation) {
                MPaasLogger.d("CameraConfiguration", new Object[]{"The state is invalid: ", Integer.valueOf(i2)});
            } else {
                parameters.setExposureCompensation(i2);
            }
        }
    }

    public static void setFocus(Camera.Parameters parameters, boolean z) {
        setFocus(parameters, "continuous-picture", z);
    }

    public static void setFocusArea(Camera.Parameters parameters) {
        setFocusArea(parameters, null, null, 90);
    }

    public static void setMetering(Camera.Parameters parameters) {
        setMetering(parameters, null, null, 90);
    }

    public static void setPictureSizeTimes(String str) {
        MPaasLogger.d("CameraConfiguration", new Object[]{"setPictureSizeTimes:", str});
        if (!TextUtils.isEmpty(str)) {
            try {
                j = Float.parseFloat(str);
            } catch (Throwable th) {
                MPaasLogger.e("CameraConfiguration", new Object[]{"setPictureSizeTimes parse error:"}, th);
            }
        }
    }

    public static void setPreviewOptimize(String str) {
        if (BQCCameraParam.VALUE_YES.equalsIgnoreCase(str)) {
            c = true;
            MPaasLogger.d("CameraConfiguration", new Object[]{"setPreviewOptimize"});
        }
    }

    public static void setPreviewSize(String str, String str2) {
        String[] split;
        String[] split2;
        MPaasLogger.d("CameraConfiguration", new Object[]{"setPreviewSize: max=", str, ", min=", str2});
        if (!(str == null || (split2 = str.split("\\*")) == null || split2.length != 2)) {
            try {
                int parseInt = Integer.parseInt(split2[0]) * Integer.parseInt(split2[1]);
                if (parseInt > 0) {
                    b = parseInt;
                }
            } catch (Exception e2) {
                MPaasLogger.e("CameraConfiguration", new Object[]{str}, e2);
            }
        }
        if (!(str2 == null || (split = str2.split("\\*")) == null || split.length != 2)) {
            try {
                int parseInt2 = Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
                if (parseInt2 > 0) {
                    a = parseInt2;
                }
            } catch (Exception e3) {
                MPaasLogger.e("CameraConfiguration", new Object[]{str}, e3);
            }
        }
        MPaasLogger.d("CameraConfiguration", new Object[]{"After: max=", Integer.valueOf(b), ", min=", Integer.valueOf(a)});
    }

    public static void setPreviewSizeRule(String str) {
        if (!TextUtils.isEmpty(str)) {
            h = str;
            MPaasLogger.d("CameraConfiguration", new Object[]{"setPreviewSizeRule:", str});
        }
    }

    public static void setRegionBoxProportion(int i2) {
        MPaasLogger.d("CameraConfiguration", new Object[]{"setRegionBoxRatio:", Integer.valueOf(i2)});
        i = i2;
    }

    public static void setTorch(Camera.Parameters parameters, boolean z) {
        String str;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            str = d("flash mode", supportedFlashModes, "torch", "on");
        } else {
            str = d("flash mode", supportedFlashModes, "off");
        }
        if (str == null) {
            return;
        }
        if (!str.equals(parameters.getFlashMode())) {
            MPaasLogger.d("CameraConfiguration", new Object[]{"Setting flash mode to ", str});
            parameters.setFlashMode(str);
            return;
        }
        MPaasLogger.d("CameraConfiguration", new Object[]{"Flash mode already set to ", str});
    }

    public static List<Camera.Area> translateToCameraArea(Rect rect, Point point, Camera.Size size, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        MPaasLogger.d("CameraConfiguration", new Object[]{"translateToCameraArea(): previewViewSize = ", Integer.valueOf(size.width), AltriaXLaunchTime.SPACE, Integer.valueOf(size.height), ", rotateAngle = ", Integer.valueOf(i2), rect.toString()});
        Rect a2 = a(rect, size);
        if (i2 == 90) {
            i4 = a2.left;
            i3 = a2.right;
            i6 = a2.top;
            i5 = a2.bottom;
        } else {
            int i7 = size.width;
            int i8 = i7 - a2.right;
            int i9 = i7 - a2.left;
            int i10 = size.height;
            i5 = i10 - a2.top;
            i6 = i10 - a2.bottom;
            i3 = i9;
            i4 = i8;
        }
        int i11 = size.width;
        int i12 = size.height;
        Rect rect2 = new Rect(((i4 * 2000) / i11) - 1000, ((i6 * 2000) / i12) - 1000, (((i3 * 2000) / i11) + 1) - 1000, (((i5 * 2000) / i12) + 1) - 1000);
        rect2.left = b(rect2.left, -1000, 1000);
        rect2.top = b(rect2.top, -1000, 1000);
        rect2.right = b(rect2.right, -1000, 1000);
        rect2.bottom = b(rect2.bottom, -1000, 1000);
        MPaasLogger.d("CameraConfiguration", new Object[]{"translateToCameraArea:", rect2.toString()});
        return Collections.singletonList(new Camera.Area(rect2, 1000));
    }

    public static void setFocus(Camera.Parameters parameters, String str, boolean z) {
        String str2;
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        MPaasLogger.i("CameraConfiguration", new Object[]{"setFocus(): focusMode = ", str});
        if (z) {
            str2 = d("focus mode", supportedFocusModes, "auto");
        } else {
            str2 = d("focus mode", supportedFocusModes, str, "continuous-picture", "continuous-video", "auto");
        }
        if (str2 == null) {
            str2 = d("focus mode", supportedFocusModes, BQCCameraParam.FOCUS_TYPE_MACRO, BQCCameraParam.FOCUS_TYPE_EDOF);
        }
        if (str2 == null) {
            MPaasLogger.i("CameraConfiguration", new Object[]{"Cannot set Focus mode: autoFocus is ", Boolean.valueOf(z)});
        } else if (!str2.equals(parameters.getFocusMode())) {
            parameters.setFocusMode(str2);
            MPaasLogger.d("CameraConfiguration", new Object[]{"setFocusMode:", str2});
        } else {
            MPaasLogger.i("CameraConfiguration", new Object[]{"Focus mode already set to ", str2});
        }
    }

    public static void setFocusArea(Camera.Parameters parameters, Rect rect) {
        setFocusArea(parameters, null, rect, 90);
    }

    public static void setMetering(Camera.Parameters parameters, Point point, Rect rect, int i2) {
        MPaasLogger.d("CameraConfiguration", new Object[]{"setMetering: ", rect});
        if (parameters.getMaxNumMeteringAreas() <= 0 || point == null || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) <= 0 || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) <= 0 || !(i2 == 90 || i2 == 270)) {
            MPaasLogger.d("CameraConfiguration", new Object[]{"Device does not support Metering areas"});
            return;
        }
        Camera.Size previewSize = parameters.getPreviewSize();
        if (rect != null) {
            List<Camera.Area> translateToCameraArea = translateToCameraArea(rect, point, previewSize, i2);
            parameters.setMeteringAreas(translateToCameraArea);
            MPaasLogger.d("CameraConfiguration", new Object[]{"Setting Metering area to : ", f(translateToCameraArea)});
            return;
        }
        parameters.setMeteringAreas(null);
        MPaasLogger.d("CameraConfiguration", new Object[]{"Setting default Metering area to default center"});
    }

    public static void setFocusArea(Camera.Parameters parameters, Point point, Rect rect, int i2) {
        if (parameters.getMaxNumFocusAreas() <= 0 || point == null || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) <= 0 || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) <= 0 || !(i2 == 90 || i2 == 270)) {
            MPaasLogger.d("CameraConfiguration", new Object[]{"Device does not support focus areas"});
            return;
        }
        Camera.Size previewSize = parameters.getPreviewSize();
        if (rect != null) {
            List<Camera.Area> translateToCameraArea = translateToCameraArea(rect, point, previewSize, i2);
            parameters.setFocusAreas(translateToCameraArea);
            MPaasLogger.d("CameraConfiguration", new Object[]{"Setting focus area to : ", f(translateToCameraArea)});
            return;
        }
        parameters.setFocusAreas(null);
        MPaasLogger.d("CameraConfiguration", new Object[]{"Setting default focus area to default center"});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0093, code lost:
        if (java.lang.Math.min(r15, r1) >= 720) goto L_0x0095;
     */
    public static Point findBestPreviewSizeValue(Camera.Parameters parameters, Point point, boolean z) {
        String str;
        Iterator it;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (z) {
            str = "small";
        } else {
            str = h;
        }
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        ArrayList arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            /* class com.alipay.camera.util.CameraConfigurationUtils.AnonymousClass4 */

            public int compare(Camera.Size size, Camera.Size size2) {
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }
        });
        if (c && arrayList.size() > 0) {
            arrayList.remove(0);
        }
        double xVar = ((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)) / ((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        if (!(xVar < 1.0d)) {
            xVar = 1.0d / xVar;
        }
        Point point2 = null;
        double d2 = Double.POSITIVE_INFINITY;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Camera.Size size = (Camera.Size) it2.next();
            int i2 = size.width;
            int i3 = size.height;
            int i4 = i2 * i3;
            if (c) {
                if (i4 < b && i4 > a) {
                    int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
                    int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
                    if (xVar2 * yVar < i4) {
                    }
                    boolean z2 = i2 > i3;
                    int i5 = z2 ? i3 : i2;
                    int i6 = z2 ? i2 : i3;
                    if (!"big".equalsIgnoreCase(str) && !"small".equalsIgnoreCase(str) && i5 == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) && i6 == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) {
                        return new Point(i2, i3);
                    }
                    it = it2;
                    double abs = Math.abs((((double) i5) / ((double) i6)) - xVar);
                    boolean z3 = "small".equalsIgnoreCase(str) && Math.abs(abs - d2) < 1.0E-6d;
                    if (abs < d2 || z3) {
                        point2 = new Point(i2, i3);
                        d2 = abs;
                        it2 = it;
                    } else {
                        it2 = it;
                    }
                }
            } else if (d) {
            }
            it = it2;
            it2 = it;
        }
        if (point2 == null) {
            Camera.Size previewSize2 = parameters.getPreviewSize();
            if (previewSize2 != null) {
                Point point3 = new Point(previewSize2.width, previewSize2.height);
                Class cls = Integer.TYPE;
                WalletBury.addWalletBury("recordCameraPreviewSize", new Class[]{cls, cls, Boolean.TYPE, cls, cls}, new Object[]{Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3)), Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3)), Boolean.FALSE, Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)), Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point))});
                return point3;
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        Class cls2 = Integer.TYPE;
        WalletBury.addWalletBury("recordCameraPreviewSize", new Class[]{cls2, cls2, Boolean.TYPE, cls2, cls2}, new Object[]{Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2)), Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2)), Boolean.FALSE, Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)), Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point))});
        e(parameters, point, point2);
        return point2;
    }
}
