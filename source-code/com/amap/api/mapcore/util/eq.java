package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.mapcore.util.gm;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FPoint3;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.taobao.weex.ui.component.WXComponent;
import com.youku.alixplayer.MsgID;
import com.youku.playerservice.axp.utils.Utils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
public class eq {
    private static FPoint[] a = {FPoint.obtain(), FPoint.obtain(), FPoint.obtain(), FPoint.obtain()};
    private static List<Float> b = new ArrayList(4);
    private static List<Float> c = new ArrayList(4);

    public static double a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    public static Bitmap a(Context context, String str) {
        try {
            InputStream open = ek.a(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            hd.c(th, "Util", "fromAsset");
            a(th);
            return null;
        }
    }

    public static boolean a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d3 - d;
        double d10 = d8 - d6;
        double d11 = d4 - d2;
        double d12 = d7 - d5;
        double d13 = (d9 * d10) - (d11 * d12);
        if (d13 != 0.0d) {
            double d14 = d2 - d6;
            double d15 = d - d5;
            double d16 = ((d12 * d14) - (d10 * d15)) / d13;
            double d17 = ((d14 * d9) - (d15 * d11)) / d13;
            return d16 >= 0.0d && d16 <= 1.0d && d17 >= 0.0d && d17 <= 1.0d;
        }
    }

    public static int b(int i, Bitmap bitmap, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i == 0) {
            int[] iArr = {0};
            GLES20.glGenTextures(1, iArr, 0);
            i = iArr[0];
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, MsgID.MEDIA_INFO_VIDEO_START_RECOVER, 9729.0f);
        if (z) {
            GLES20.glTexParameterf(3553, 10242, 10497.0f);
            GLES20.glTexParameterf(3553, 10243, 10497.0f);
        } else {
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return i;
    }

    public static String c(Context context) {
        String a2 = a(context);
        if (a2 == null) {
            return null;
        }
        File file = new File(a2, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    public static boolean d(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null || (state = activeNetworkInfo.getState()) == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) {
            return false;
        }
        return true;
    }

    public static gm e() {
        try {
            if (m.e == null) {
                m.e = new gm.a("3dmap", "7.4.0", m.c).a(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("7.4.0").a();
            }
            return m.e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 12;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static boolean e(Context context) {
        File file = new File(b(context));
        if (!file.exists()) {
            return true;
        }
        return FileUtil.deleteFile(file);
    }

    public static void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001d A[SYNTHETIC, Splitter:B:14:0x001d] */
    private static byte[] c(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return byteArray;
            } catch (Throwable unused) {
                if (byteArrayOutputStream != null) {
                }
                return null;
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            return null;
        }
    }

    public static String a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static float a(IMapConfig iMapConfig, float f, float f2) {
        boolean z;
        boolean z2 = false;
        if (iMapConfig != null) {
            boolean isAbroadEnable = iMapConfig.isAbroadEnable();
            if (iMapConfig.getAbroadState() != 1) {
                z2 = true;
            }
            z = z2;
            z2 = isAbroadEnable;
        } else {
            z = false;
        }
        int i = 40;
        if (z2 && z) {
            float f3 = (float) 40;
            return f > f3 ? f3 : f;
        } else if (f <= 40.0f) {
            return f;
        } else {
            if (f2 > 15.0f) {
                if (f2 <= 16.0f) {
                    i = 56;
                } else if (f2 <= 17.0f) {
                    i = 66;
                } else {
                    int i2 = (f2 > 18.0f ? 1 : (f2 == 18.0f ? 0 : -1));
                    i = i2 <= 0 ? 74 : i2 <= 0 ? 78 : 80;
                }
            }
            float f4 = (float) i;
            return f > f4 ? f4 : f;
        }
    }

    public static float a(IMapConfig iMapConfig, float f) {
        if (iMapConfig != null) {
            if (f > iMapConfig.getMaxZoomLevel()) {
                return iMapConfig.getMaxZoomLevel();
            }
            return f < iMapConfig.getMinZoomLevel() ? iMapConfig.getMinZoomLevel() : f;
        } else if (f > 20.0f) {
            return 20.0f;
        } else {
            if (f < 3.0f) {
                return 3.0f;
            }
            return f;
        }
    }

    public static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(FileUtil.getMapBaseStorage(context));
        String str = File.separator;
        sb.append(str);
        sb.append("data");
        sb.append(str);
        return sb.toString();
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static FloatBuffer a(float[] fArr) {
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            return asFloatBuffer;
        } catch (Throwable th) {
            hd.c(th, "Util", "makeFloatBuffer1");
            th.printStackTrace();
            return null;
        }
    }

    public static void b(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean b(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.abs(a(d, d2, d3, d4, d5, d6)) < 1.0E-9d && (d - d3) * (d - d5) <= 0.0d && (d2 - d4) * (d2 - d6) <= 0.0d;
    }

    public static List<FPoint> b(FPoint[] fPointArr, List<FPoint> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        for (byte b2 = 0; b2 < 4; b2 = (byte) (b2 + 1)) {
            arrayList.clear();
            int size = arrayList2.size();
            int i = 0;
            while (true) {
                if (i >= (z ? size : size - 1)) {
                    break;
                }
                FPoint3 fPoint3 = (FPoint3) arrayList2.get(i % size);
                int i2 = i + 1;
                FPoint3 fPoint32 = (FPoint3) arrayList2.get(i2 % size);
                if (i == 0 && a(fPoint3, fPointArr[b2], fPointArr[(b2 + 1) % fPointArr.length])) {
                    arrayList.add(fPoint3);
                }
                int i3 = b2 + 1;
                if (a(fPoint3, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                    if (a(fPoint32, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                        arrayList.add(fPoint32);
                    } else {
                        arrayList.add(a(fPointArr[b2], fPointArr[i3 % fPointArr.length], fPoint3, fPoint32, fPoint32.colorIndex));
                    }
                } else if (a(fPoint32, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                    arrayList.add(a(fPointArr[b2], fPointArr[i3 % fPointArr.length], fPoint3, fPoint32, fPoint3.colorIndex));
                    arrayList.add(fPoint32);
                }
                i = i2;
            }
            arrayList2.clear();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                arrayList2.add(arrayList.get(i4));
            }
        }
        return arrayList2;
    }

    public static FloatBuffer a(float[] fArr, FloatBuffer floatBuffer) {
        try {
            floatBuffer.clear();
            floatBuffer.put(fArr);
            floatBuffer.position(0);
            return floatBuffer;
        } catch (Throwable th) {
            hd.c(th, "Util", "makeFloatBuffer2");
            th.printStackTrace();
            return null;
        }
    }

    public static int a(int i, int i2) {
        return a(0, Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888), true);
    }

    public static int a(Bitmap bitmap) {
        return a(bitmap, false);
    }

    public static int a(Bitmap bitmap, boolean z) {
        return a(0, bitmap, z);
    }

    public static int a(int i, Bitmap bitmap, boolean z) {
        int b2 = b(i, bitmap, z);
        b(bitmap);
        return b2;
    }

    public static int a(int i, Bitmap bitmap, int i2, int i3) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i == 0) {
            int[] iArr = {0};
            GLES20.glGenTextures(1, iArr, 0);
            i = iArr[0];
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLUtils.texSubImage2D(3553, 0, i2, i3, bitmap);
        return i;
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    private static void b(View view) {
        int i = 0;
        if (view instanceof ViewGroup) {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i < viewGroup.getChildCount()) {
                    b(viewGroup.getChildAt(i));
                    i++;
                } else {
                    return;
                }
            }
        } else if (view instanceof TextView) {
            ((TextView) view).setHorizontallyScrolling(false);
        }
    }

    public static float b(IMapConfig iMapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float sz = iMapConfig.getSZ();
        if (i == i3 || i2 == i4) {
            return sz;
        }
        return Math.max((float) a(iMapConfig.getMapZoomScale(), (double) i5, (double) Math.abs(i3 - i)), (float) a(iMapConfig.getMapZoomScale(), (double) i6, (double) Math.abs(i4 - i2)));
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f), (int) (((float) bitmap.getHeight()) * f), true);
    }

    public static boolean b(int i, int i2) {
        if (i > 0 && i2 > 0) {
            return true;
        }
        Log.w("3dmap", "the map must have a size");
        return false;
    }

    public static String a(Context context) {
        File file = new File(FileUtil.getMapBaseStorage(context), AeUtil.ROOT_DATA_PATH_NAME);
        if (!file.exists()) {
            file.mkdir();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file.toString());
        String str = File.separator;
        sb.append(str);
        File file2 = new File(sb.toString());
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file.toString() + str;
    }

    public static void b(Rect rect, int i, int i2) {
        if (rect != null) {
            if (i < rect.left) {
                rect.left = i;
            }
            if (i > rect.right) {
                rect.right = i;
            }
            if (i2 > rect.top) {
                rect.top = i2;
            }
            if (i2 < rect.bottom) {
                rect.bottom = i2;
            }
        }
    }

    public static String a(int i) {
        if (i < 1000) {
            return i + WXComponent.PROP_FS_MATCH_PARENT;
        }
        return (i / 1000) + "km";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
        return true;
     */
    public static boolean b(List<LatLng> list, CircleHoleOptions circleHoleOptions) {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i));
            }
            arrayList.add(list.get(0));
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList.size()) {
                    break;
                }
                int i3 = i2 + 1;
                if (i3 >= arrayList.size()) {
                    break;
                } else if (circleHoleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i2)))) {
                    break;
                } else if (circleHoleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i3)))) {
                    break;
                } else {
                    arrayList2.clear();
                    arrayList2.add(arrayList.get(i2));
                    arrayList2.add(arrayList.get(i3));
                    if (circleHoleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) SpatialRelationUtil.calShortestDistancePoint(arrayList2, circleHoleOptions.getCenter()).second))) {
                        return true;
                    }
                    i2 = i3;
                }
            }
        } catch (Throwable th) {
            hd.c(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
        }
        return false;
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 8;
    }

    public static String a(InputStream inputStream) {
        try {
            return new String(b(inputStream), "utf-8");
        } catch (Throwable th) {
            hd.c(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0069 A[SYNTHETIC, Splitter:B:42:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0098 A[SYNTHETIC, Splitter:B:62:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00c2 A[SYNTHETIC, Splitter:B:82:0x00c2] */
    public static String a(File file) {
        BufferedReader bufferedReader;
        Throwable th;
        FileInputStream fileInputStream;
        FileNotFoundException e;
        IOException e2;
        StringBuffer stringBuffer = new StringBuffer();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            try {
                                break;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                bufferedReader.close();
                            } catch (Throwable th2) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                                throw th2;
                            }
                        }
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        hd.c(e, "Util", "readFile fileNotFound");
                        e.printStackTrace();
                        if (fileInputStream != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        return stringBuffer.toString();
                    } catch (IOException e6) {
                        e2 = e6;
                        try {
                            hd.c(e2, "Util", "readFile io");
                            e2.printStackTrace();
                            if (fileInputStream != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            return stringBuffer.toString();
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            throw th;
                        }
                    }
                }
                fileInputStream.close();
                try {
                    bufferedReader.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            } catch (FileNotFoundException e8) {
                e = e8;
                bufferedReader = null;
                hd.c(e, "Util", "readFile fileNotFound");
                e.printStackTrace();
                if (fileInputStream != null) {
                }
                if (bufferedReader != null) {
                }
                return stringBuffer.toString();
            } catch (IOException e9) {
                e2 = e9;
                bufferedReader = null;
                hd.c(e2, "Util", "readFile io");
                e2.printStackTrace();
                if (fileInputStream != null) {
                }
                if (bufferedReader != null) {
                }
                return stringBuffer.toString();
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e10) {
            fileInputStream = null;
            e = e10;
            bufferedReader = null;
            hd.c(e, "Util", "readFile fileNotFound");
            e.printStackTrace();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (Throwable th5) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    throw th5;
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return stringBuffer.toString();
        } catch (IOException e13) {
            fileInputStream = null;
            e2 = e13;
            bufferedReader = null;
            hd.c(e2, "Util", "readFile io");
            e2.printStackTrace();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (Throwable th6) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e15) {
                            e15.printStackTrace();
                        }
                    }
                    throw th6;
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return stringBuffer.toString();
        } catch (Throwable th7) {
            th = th7;
            bufferedReader = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                } catch (Throwable th8) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th8;
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return stringBuffer.toString();
    }

    private static boolean b(List<LatLng> list, List<LatLng> list2) {
        int i = 0;
        while (true) {
            try {
                if (i >= list.size()) {
                    break;
                }
                int i2 = i + 1;
                if (i2 >= list.size()) {
                    break;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= list2.size()) {
                        break;
                    }
                    int i4 = i3 + 1;
                    if (i4 >= list2.size()) {
                        break;
                    }
                    boolean a2 = el.a(list.get(i), list.get(i2), list2.get(i3), list2.get(i4));
                    if (a2) {
                        return a2;
                    }
                    i3 = i4;
                }
                i = i2;
            } catch (Throwable th) {
                hd.c(th, "Util", "isSegmentsIntersect");
                th.printStackTrace();
            }
        }
        return false;
    }

    public static void b(Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT <= 10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009f, code lost:
        if (r6 > r2) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00bc, code lost:
        if (r2 > r6) goto L_0x00a1;
     */
    public static boolean a(LatLng latLng, List<LatLng> list) {
        double d;
        double d2 = latLng.longitude;
        double d3 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (!list.get(0).equals(list.get(list.size() - 1))) {
            list.add(list.get(0));
        }
        int i = 0;
        int i2 = 0;
        while (i < list.size() - 1) {
            double d4 = list.get(i).longitude;
            double d5 = list.get(i).latitude;
            i++;
            double d6 = list.get(i).longitude;
            double d7 = list.get(i).latitude;
            if (b(d2, d3, d4, d5, d6, d7)) {
                return true;
            }
            if (Math.abs(d7 - d5) >= 1.0E-9d) {
                if (!b(d4, d5, d2, d3, 180.0d, d3)) {
                    if (!b(d6, d7, d2, d3, 180.0d, d3)) {
                        d = d2;
                        if (a(d4, d5, d6, d7, d2, d3, 180.0d, d3)) {
                            i2++;
                        }
                        d2 = d;
                        d3 = d3;
                    }
                }
                i2++;
            }
            d = d2;
            d2 = d;
            d3 = d3;
        }
        return i2 % 2 != 0;
    }

    public static boolean a(BaseHoleOptions baseHoleOptions, LatLng latLng) {
        if (baseHoleOptions instanceof CircleHoleOptions) {
            CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
            LatLng center = circleHoleOptions.getCenter();
            double radius = circleHoleOptions.getRadius();
            if (center != null && ((double) AMapUtils.calculateLineDistance(center, latLng)) <= radius) {
                return true;
            }
            return false;
        }
        List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
        if (points == null || points.size() == 0) {
            return false;
        }
        return a(latLng, points);
    }

    public static List<FPoint> a(FPoint[] fPointArr, List<FPoint> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        for (byte b2 = 0; b2 < 4; b2 = (byte) (b2 + 1)) {
            arrayList.clear();
            int size = arrayList2.size();
            int i = 0;
            while (true) {
                if (i >= (z ? size : size - 1)) {
                    break;
                }
                FPoint fPoint = (FPoint) arrayList2.get(i % size);
                int i2 = i + 1;
                FPoint fPoint2 = (FPoint) arrayList2.get(i2 % size);
                if (i == 0 && a(fPoint, fPointArr[b2], fPointArr[(b2 + 1) % fPointArr.length])) {
                    arrayList.add(fPoint);
                }
                int i3 = b2 + 1;
                if (a(fPoint, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                    if (a(fPoint2, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                        arrayList.add(fPoint2);
                    } else {
                        arrayList.add(a(fPointArr[b2], fPointArr[i3 % fPointArr.length], fPoint, fPoint2));
                    }
                } else if (a(fPoint2, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                    arrayList.add(a(fPointArr[b2], fPointArr[i3 % fPointArr.length], fPoint, fPoint2));
                    arrayList.add(fPoint2);
                }
                i = i2;
            }
            arrayList2.clear();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                arrayList2.add(arrayList.get(i4));
            }
        }
        return arrayList2;
    }

    public static FPoint[] a(IAMapDelegate iAMapDelegate, boolean z) {
        int i;
        int i2;
        float skyHeight = iAMapDelegate.getSkyHeight();
        if (z) {
            i = 100;
            i2 = 10;
        } else {
            i = 0;
            i2 = 0;
        }
        FPoint obtain = FPoint.obtain();
        int i3 = -i;
        int i4 = (int) (skyHeight - ((float) i2));
        iAMapDelegate.pixel2Map(i3, i4, obtain);
        a[0].set(((PointF) obtain).x, ((PointF) obtain).y);
        FPoint obtain2 = FPoint.obtain();
        iAMapDelegate.pixel2Map(iAMapDelegate.getMapWidth() + i, i4, obtain2);
        a[1].set(((PointF) obtain2).x, ((PointF) obtain2).y);
        FPoint obtain3 = FPoint.obtain();
        iAMapDelegate.pixel2Map(iAMapDelegate.getMapWidth() + i, iAMapDelegate.getMapHeight() + i, obtain3);
        a[2].set(((PointF) obtain3).x, ((PointF) obtain3).y);
        FPoint obtain4 = FPoint.obtain();
        iAMapDelegate.pixel2Map(i3, iAMapDelegate.getMapHeight() + i, obtain4);
        a[3].set(((PointF) obtain4).x, ((PointF) obtain4).y);
        obtain.recycle();
        obtain2.recycle();
        obtain3.recycle();
        obtain4.recycle();
        return a;
    }

    private static FPoint3 a(FPoint fPoint, FPoint fPoint2, FPoint3 fPoint3, FPoint3 fPoint32, int i) {
        FPoint3 fPoint33 = new FPoint3(0.0f, 0.0f, i);
        float f = ((PointF) fPoint2).y;
        float f2 = ((PointF) fPoint).y;
        float f3 = ((PointF) fPoint).x;
        float f4 = ((PointF) fPoint3).x;
        float f5 = ((PointF) fPoint2).x;
        float f6 = ((PointF) fPoint3).y;
        double d = (double) (((f - f2) * (f3 - f4)) - ((f5 - f3) * (f2 - f6)));
        float f7 = f - f2;
        float f8 = ((PointF) fPoint32).x;
        float f9 = f5 - f3;
        float f10 = ((PointF) fPoint32).y;
        double d2 = (double) ((f7 * (f8 - f4)) - (f9 * (f10 - f6)));
        ((PointF) fPoint33).x = (float) (((double) f4) + ((((double) (f8 - f4)) * d) / d2));
        ((PointF) fPoint33).y = (float) (((double) f6) + ((((double) (f10 - f6)) * d) / d2));
        return fPoint33;
    }

    private static FPoint a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3, FPoint fPoint4) {
        FPoint obtain = FPoint.obtain(0.0f, 0.0f);
        float f = ((PointF) fPoint2).y;
        float f2 = ((PointF) fPoint).y;
        float f3 = ((PointF) fPoint).x;
        float f4 = ((PointF) fPoint3).x;
        float f5 = ((PointF) fPoint2).x;
        float f6 = ((PointF) fPoint3).y;
        double d = (double) (((f - f2) * (f3 - f4)) - ((f5 - f3) * (f2 - f6)));
        float f7 = f - f2;
        float f8 = ((PointF) fPoint4).x;
        float f9 = f5 - f3;
        float f10 = ((PointF) fPoint4).y;
        double d2 = (double) ((f7 * (f8 - f4)) - (f9 * (f10 - f6)));
        ((PointF) obtain).x = (float) (((double) f4) + ((((double) (f8 - f4)) * d) / d2));
        ((PointF) obtain).y = (float) (((double) f6) + ((((double) (f10 - f6)) * d) / d2));
        return obtain;
    }

    public static boolean a(FPoint fPoint, FPoint[] fPointArr) {
        if (fPointArr == null) {
            return false;
        }
        byte b2 = 0;
        while (b2 < fPointArr.length) {
            FPoint fPoint2 = fPointArr[b2];
            int i = b2 + 1;
            if (!a(fPoint, fPoint2, fPointArr[i % fPointArr.length])) {
                return false;
            }
            b2 = (byte) i;
        }
        return true;
    }

    private static boolean a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        float f = ((PointF) fPoint3).x;
        float f2 = ((PointF) fPoint2).x;
        float f3 = ((PointF) fPoint).y;
        float f4 = ((PointF) fPoint2).y;
        return ((double) (((f - f2) * (f3 - f4)) - ((((PointF) fPoint).x - f2) * (((PointF) fPoint3).y - f4)))) >= 0.0d;
    }

    public static List<IPoint> a(IPoint[] iPointArr, List<IPoint> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        for (byte b2 = 0; b2 < 4; b2 = (byte) (b2 + 1)) {
            arrayList.clear();
            int size = arrayList2.size();
            int i = 0;
            while (true) {
                if (i >= (z ? size : size - 1)) {
                    break;
                }
                IPoint iPoint = (IPoint) arrayList2.get(i % size);
                int i2 = i + 1;
                IPoint iPoint2 = (IPoint) arrayList2.get(i2 % size);
                if (i == 0 && a(iPoint, iPointArr[b2], iPointArr[(b2 + 1) % iPointArr.length])) {
                    arrayList.add(iPoint);
                }
                int i3 = b2 + 1;
                if (a(iPoint, iPointArr[b2], iPointArr[i3 % iPointArr.length])) {
                    if (a(iPoint2, iPointArr[b2], iPointArr[i3 % iPointArr.length])) {
                        arrayList.add(iPoint2);
                    } else {
                        arrayList.add(a(iPointArr[b2], iPointArr[i3 % iPointArr.length], iPoint, iPoint2));
                    }
                } else if (a(iPoint2, iPointArr[b2], iPointArr[i3 % iPointArr.length])) {
                    arrayList.add(a(iPointArr[b2], iPointArr[i3 % iPointArr.length], iPoint, iPoint2));
                    arrayList.add(iPoint2);
                }
                i = i2;
            }
            arrayList2.clear();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                arrayList2.add(arrayList.get(i4));
            }
        }
        return arrayList2;
    }

    private static IPoint a(IPoint iPoint, IPoint iPoint2, IPoint iPoint3, IPoint iPoint4) {
        IPoint obtain = IPoint.obtain(0, 0);
        int yVar = Point.gety(iPoint2);
        int yVar2 = Point.gety(iPoint);
        int xVar = Point.getx(iPoint);
        int xVar2 = Point.getx(iPoint3);
        int xVar3 = Point.getx(iPoint2);
        int yVar3 = Point.gety(iPoint3);
        double d = (((double) (yVar - yVar2)) * ((double) (xVar - xVar2))) - (((double) (xVar3 - xVar)) * ((double) (yVar2 - yVar3)));
        int xVar4 = Point.getx(iPoint4);
        int yVar4 = Point.gety(iPoint4);
        double d2 = (((double) (yVar - yVar2)) * ((double) (xVar4 - xVar2))) - (((double) (xVar3 - xVar)) * ((double) (yVar4 - yVar3)));
        ((android.graphics.Point) obtain).x = (int) (((double) xVar2) + ((((double) (xVar4 - xVar2)) * d) / d2));
        ((android.graphics.Point) obtain).y = (int) (((double) yVar3) + ((((double) (yVar4 - yVar3)) * d) / d2));
        return obtain;
    }

    public static boolean a(List<IPoint> list, int i, int i2) {
        if (i2 < 3) {
            return false;
        }
        int i3 = i2 - 1;
        double d = 0.0d;
        for (int i4 = 0; i4 < i2; i4++) {
            IPoint iPoint = list.get(i3);
            IPoint iPoint2 = list.get(i4);
            d += ((((double) Point.getx(iPoint)) / 1000000.0d) * (((double) Point.gety(iPoint2)) / 1000000.0d)) - ((((double) Point.getx(iPoint2)) / 1000000.0d) * (((double) Point.gety(iPoint)) / 1000000.0d));
            i3 = i4;
        }
        if (d < 0.0d) {
            return true;
        }
        return false;
    }

    private static boolean a(IPoint iPoint, IPoint iPoint2, IPoint iPoint3) {
        return a(Point.getx(iPoint), Point.gety(iPoint), iPoint2, iPoint3);
    }

    private static boolean a(int i, int i2, IPoint iPoint, IPoint iPoint2) {
        int xVar = Point.getx(iPoint2);
        int xVar2 = Point.getx(iPoint);
        int yVar = Point.gety(iPoint);
        return (((double) (xVar - xVar2)) * ((double) (i2 - yVar))) - (((double) (i - xVar2)) * ((double) (Point.gety(iPoint2) - yVar))) >= 0.0d;
    }

    public static Bitmap a(int i, int i2, int i3, int i4) {
        int i5 = i3 * i4;
        try {
            int[] iArr = new int[i5];
            int[] iArr2 = new int[i5];
            IntBuffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            GLES20.glReadPixels(i, i2, i3, i4, 6408, 5121, wrap);
            for (int i6 = 0; i6 < i4; i6++) {
                for (int i7 = 0; i7 < i3; i7++) {
                    int i8 = iArr[(i6 * i3) + i7];
                    iArr2[(((i4 - i6) - 1) * i3) + i7] = (i8 & -16711936) | ((i8 << 16) & 16711680) | ((i8 >> 16) & 255);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i3, 0, 0, i3, i4);
            return createBitmap;
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImpGLSurfaceView", "SavePixels");
            th.printStackTrace();
            return null;
        }
    }

    public static Bitmap a(View view) {
        try {
            b(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (Throwable th) {
            hd.c(th, Utils.TAG, "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static DPoint a(LatLng latLng) {
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return DPoint.obtain(((latLng.longitude / 360.0d) + 0.5d) * 1.0d, (((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * 1.0d);
    }

    public static boolean a(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }

    public static Pair<Float, IPoint> a(AbstractCameraUpdateMessage abstractCameraUpdateMessage, IGLMapState iGLMapState, IMapConfig iMapConfig) {
        return a(iMapConfig, Math.max(abstractCameraUpdateMessage.paddingLeft, 1), Math.max(abstractCameraUpdateMessage.paddingRight, 1), Math.max(abstractCameraUpdateMessage.paddingTop, 1), Math.max(abstractCameraUpdateMessage.paddingBottom, 1), abstractCameraUpdateMessage.bounds, abstractCameraUpdateMessage.width, abstractCameraUpdateMessage.height);
    }

    public static Pair<Float, IPoint> a(IMapConfig iMapConfig, int i, int i2, int i3, int i4, LatLngBounds latLngBounds, int i5, int i6) {
        LatLng latLng;
        int xVar;
        float yVar;
        float f;
        int yVar2;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || latLngBounds.southwest == null || iMapConfig == null) {
            return null;
        }
        android.graphics.Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
        LatLng latLng2 = latLngBounds.southwest;
        android.graphics.Point latLongToPixels2 = VirtualEarthProjection.latLongToPixels(latLng2.latitude, latLng2.longitude, 20);
        int xVar2 = Point.getx(latLongToPixels);
        int xVar3 = Point.getx(latLongToPixels2);
        int i7 = xVar2 - xVar3;
        int yVar3 = Point.gety(latLongToPixels2);
        int yVar4 = Point.gety(latLongToPixels);
        int i8 = yVar3 - yVar4;
        int i9 = i5 - (i + i2);
        int i10 = i6 - (i3 + i4);
        if (i7 < 0 && i8 < 0) {
            return null;
        }
        if (i7 <= 0) {
            i7 = 1;
        }
        int i11 = i8 <= 0 ? 1 : i8;
        if (i9 <= 0) {
            i9 = 1;
        }
        if (i10 <= 0) {
            i10 = 1;
        }
        Pair<Float, Boolean> a2 = a(iMapConfig, xVar2, yVar4, xVar3, yVar3, i9, i10);
        float floatValue = ((Float) a2.first).floatValue();
        boolean booleanValue = ((Boolean) a2.second).booleanValue();
        float a3 = a(iMapConfig.getMapZoomScale(), floatValue, (double) i7);
        float a4 = a(iMapConfig.getMapZoomScale(), floatValue, (double) i11);
        if (floatValue >= iMapConfig.getMaxZoomLevel()) {
            xVar = (int) (((float) Point.getx(latLongToPixels2)) + (((((float) (i2 - i)) + a3) * ((float) i7)) / (a3 * 2.0f)));
            yVar2 = Point.gety(latLongToPixels);
        } else if (booleanValue) {
            xVar = (int) (((float) Point.getx(latLongToPixels2)) + ((((float) ((i5 / 2) - i)) / a3) * ((float) i7)));
            yVar2 = Point.gety(latLongToPixels);
        } else {
            xVar = (int) (((float) Point.getx(latLongToPixels2)) + (((((float) (i2 - i)) + a3) * ((float) i7)) / (a3 * 2.0f)));
            yVar = (float) Point.gety(latLongToPixels);
            f = (((float) ((i6 / 2) - i3)) / a4) * ((float) i11);
            return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (((float) xVar) + a(iMapConfig.getMapZoomScale(), floatValue, (float) (iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1)))), (int) (((float) ((int) (yVar + f))) + a(iMapConfig.getMapZoomScale(), floatValue, (float) (iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1))))));
        }
        yVar = (float) yVar2;
        f = ((((float) (i4 - i3)) + a4) * ((float) i11)) / (a4 * 2.0f);
        return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (((float) xVar) + a(iMapConfig.getMapZoomScale(), floatValue, (float) (iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1)))), (int) (((float) ((int) (yVar + f))) + a(iMapConfig.getMapZoomScale(), floatValue, (float) (iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1))))));
    }

    public static double a(float f, double d, double d2) {
        return 20.0d - (Math.log(d2 / (d * ((double) f))) / Math.log(2.0d));
    }

    private static float a(float f, float f2, double d) {
        return (float) (d / (Math.pow(2.0d, (double) (20.0f - f2)) * ((double) f)));
    }

    private static float a(float f, float f2, float f3) {
        return (float) (((double) f3) * Math.pow(2.0d, (double) (20.0f - f2)) * ((double) f));
    }

    public static Pair<Float, Boolean> a(IMapConfig iMapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float f;
        iMapConfig.getSZ();
        boolean z = true;
        if (i == i3 && i2 == i4) {
            f = iMapConfig.getMaxZoomLevel();
        } else {
            float a2 = (float) a(iMapConfig.getMapZoomScale(), (double) i6, (double) Math.abs(i4 - i2));
            float a3 = (float) a(iMapConfig.getMapZoomScale(), (double) i5, (double) Math.abs(i3 - i));
            float min = Math.min(a3, a2);
            if (min != a3) {
                z = false;
            }
            f = Math.min(iMapConfig.getMaxZoomLevel(), Math.max(iMapConfig.getMinZoomLevel(), min));
        }
        return new Pair<>(Float.valueOf(f), Boolean.valueOf(z));
    }

    public static synchronized int[] a(int i, int i2, int i3, int i4, IMapConfig iMapConfig, IGLMapState iGLMapState, int i5, int i6) {
        int[] iArr;
        synchronized (eq.class) {
            int mapWidth = iMapConfig.getMapWidth();
            int mapHeight = iMapConfig.getMapHeight();
            int anchorX = iMapConfig.getAnchorX();
            int anchorY = iMapConfig.getAnchorY();
            float f = (float) i5;
            iArr = new int[]{(int) Math.max(((float) i3) + a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), (float) anchorX), Math.min(f, ((float) i) - a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), (float) (mapWidth - anchorX)))), (int) Math.max(((float) i2) + a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), (float) anchorY), Math.min((float) i6, ((float) i4) - a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), (float) (mapHeight - anchorY))))};
        }
        return iArr;
    }

    public static void a(Rect rect) {
        if (rect != null) {
            rect.set(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    public static byte[] a(byte[] bArr, int[] iArr) {
        try {
            int i = 0;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Bitmap copy = decodeByteArray.copy(decodeByteArray.getConfig(), true);
            decodeByteArray.getWidth();
            decodeByteArray.getHeight();
            int i2 = 6;
            int i3 = 6;
            for (int i4 = 1; i4 < 72; i4++) {
                for (int i5 = 8; i5 < 12; i5++) {
                    decodeByteArray.getPixel(i5, i4);
                    if (i4 < 4 * i3) {
                        copy.setPixel(i5, i4, iArr[i]);
                    } else {
                        i++;
                        i2--;
                        i3 += i2;
                    }
                }
            }
            byte[] c2 = c(copy);
            if (c2 == null) {
                c2 = bArr;
            }
            b(copy);
            b(decodeByteArray);
            return c2;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr;
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, i, i, true);
    }

    public static byte[] a(byte[] bArr, int i, int i2, boolean z) {
        try {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Bitmap copy = decodeByteArray.copy(decodeByteArray.getConfig(), true);
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            for (int i3 = 0; i3 < width; i3++) {
                for (int i4 = 0; i4 < height; i4++) {
                    if (i3 != 0) {
                        if (i4 != 0) {
                            copy.setPixel(i3, i4, i);
                        }
                    }
                    if (!z) {
                        copy.setPixel(i3, i4, i2);
                    }
                }
            }
            byte[] c2 = c(copy);
            if (c2 == null) {
                c2 = bArr;
            }
            b(copy);
            b(decodeByteArray);
            return c2;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr;
        }
    }

    public static boolean a(List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            BaseHoleOptions baseHoleOptions = list.get(i);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z = a(((PolygonHoleOptions) baseHoleOptions).getPoints(), polygonHoleOptions.getPoints());
                if (z) {
                    return true;
                }
            } else if ((baseHoleOptions instanceof CircleHoleOptions) && (z = b(polygonHoleOptions.getPoints(), (CircleHoleOptions) baseHoleOptions))) {
                return true;
            }
        }
        return z;
    }

    public static boolean a(List<BaseHoleOptions> list, CircleHoleOptions circleHoleOptions) {
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            BaseHoleOptions baseHoleOptions = list.get(i);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z = b(((PolygonHoleOptions) baseHoleOptions).getPoints(), circleHoleOptions);
                if (z) {
                    return true;
                }
            } else if ((baseHoleOptions instanceof CircleHoleOptions) && (z = a(circleHoleOptions, (CircleHoleOptions) baseHoleOptions))) {
                return true;
            }
        }
        return z;
    }

    public static boolean a(CircleHoleOptions circleHoleOptions, CircleHoleOptions circleHoleOptions2) {
        try {
            if (((double) AMapUtils.calculateLineDistance(circleHoleOptions2.getCenter(), circleHoleOptions.getCenter())) < circleHoleOptions.getRadius() + circleHoleOptions2.getRadius()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            hd.c(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
            return false;
        }
    }

    public static boolean a(List<LatLng> list, List<LatLng> list2) {
        for (int i = 0; i < list2.size(); i++) {
            try {
                if (a(list2.get(i), list)) {
                    return true;
                }
            } catch (Throwable th) {
                hd.c(th, "Util", "isPolygon2PolygonIntersect");
                th.printStackTrace();
                return false;
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (a(list.get(i2), list2)) {
                return true;
            }
        }
        return b(list, list2);
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        if (dPoint == null || dPoint2 == null) {
            return 0.0f;
        }
        double d = dPoint.x;
        double d2 = dPoint2.x;
        return (float) ((Math.atan2(dPoint2.y - dPoint.y, d2 - d) / 3.141592653589793d) * 180.0d);
    }

    public static void a(Throwable th) {
        try {
            if (MapsInitializer.getExceptionLogger() != null) {
                MapsInitializer.getExceptionLogger().onException(th);
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse.getAuthority().startsWith("dualstack-")) {
                return str;
            }
            Uri.Builder buildUpon = parse.buildUpon();
            return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
