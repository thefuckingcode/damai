package com.alipay.ma.decode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.security.realidentity.jsbridge.a;
import com.alipay.ma.MaBuryRecord;
import com.alipay.ma.MaLogger;
import com.alipay.ma.analyze.api.MaEngineAPI;
import com.alipay.ma.analyze.helper.MaResultTypeHelper;
import com.alipay.ma.common.result.ResultMaType;
import com.alipay.ma.strategies.MaInterceptOperation;
import com.alipay.ma.util.ImageTool;
import com.alipay.ma.util.StringEncodeUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import tb.v;

/* compiled from: Taobao */
public class MaDecode {
    public static final String CAMERA2_UPLOAD_IMAGE = "camera2_upload_image";
    public static final String DIAGNOSE_SCAN_FOCUS = "diagnose_scan_focus";
    public static final String FRAME_READ_INFO_BINARIZE_ID = "BINARIZE_ID";
    public static final String FRAME_READ_INFO_FRAME_ID = "FRAME_ID";
    public static final String FRAME_READ_INFO_READ_STEPS = "READ_STEPS";
    public static final String IMAGE_INFO_BLOCK_MAX_STDDEV = "imageInfoBlockMaxStdDev";
    public static final String IMAGE_INFO_ENTROPY = "imageInfoEntropy";
    public static final String IMAGE_INFO_GLOBAL_STDDEV = "imageInfoGlobalStdDev";
    public static final String KEY_SCANNOTHINGDURATION = "scanNothingDuration";
    public static final int QR_PARTITION_SOURCE_TRADITION = 0;
    public static final int QR_PARTITION_SOURCE_XNN = 1;
    public static final String SCAN_STATISTICS_PERF = "scan_statistics_perf";
    public static final String SCAN_UPLOAD_IMAGE = "scan_upload_image";
    public static final String SO_NAME = "decode100198";
    public static final String TAG = "MaDecode";
    private static MaInterceptOperation a = null;
    private static boolean b = false;
    public static int decodeThreadTID = 0;
    public static boolean dynamicCodeDev = false;
    public static long firstFrameIn = -1;
    public static long frameEngineIn = -1;
    public static long sEngineSoLoadedTimestamp = 0;
    public static String sInitedReaderParams = null;
    public static String scanSourceId = "null";
    public static String scanUIType = "oldUI";

    static {
        init();
    }

    public static native int AISetup(String str, String str2, String str3, String str4, String str5);

    public static int AISetupJ(String str, String str2, String str3, String str4, String str5) {
        try {
            return AISetup(str, str2, str3, str4, str5);
        } catch (Throwable th) {
            MaLogger.e(TAG, "AISetupJ: ", th);
            return 0;
        }
    }

    public static native int AIUninstall();

    public static int AIUninstallJ() {
        try {
            return AIUninstall();
        } catch (Throwable th) {
            MaLogger.e(TAG, "AIUninstallJ: ", th);
            return 0;
        }
    }

    public static native long RegistDSLReader(String str, boolean z);

    public static synchronized long RegistDSLReaderJ(String str, boolean z) {
        long RegistDSLReader;
        synchronized (MaDecode.class) {
            try {
                RegistDSLReader = RegistDSLReader(str, z);
            } catch (Throwable th) {
                MaLogger.e(TAG, "RegistDSLReaderJ", th);
                return 0;
            }
        }
        return RegistDSLReader;
    }

    public static native long UnRegistDSLReader(boolean z);

    public static synchronized long UnRegistDSLReaderJ(boolean z) {
        long UnRegistDSLReader;
        synchronized (MaDecode.class) {
            try {
                UnRegistDSLReader = UnRegistDSLReader(z);
            } catch (Throwable th) {
                MaLogger.e(TAG, "UnRegistDSLReaderJ", th);
                return 0;
            }
        }
        return UnRegistDSLReader;
    }

    private static void a(String str) {
        try {
            StringBuilder sb = new StringBuilder(128);
            String name = Thread.currentThread().getName();
            sb.append("id=");
            sb.append(Process.myTid());
            sb.append("^name=");
            sb.append(name);
            sb.append("^");
            sb.append(str);
            if (MaLogger.isDebuggable()) {
                MaBuryRecord.reportNativeInterfaceResult(sb.toString());
            }
        } catch (Exception e) {
            MaLogger.e(TAG, "buryInformation: " + e.getMessage());
        }
    }

    private static DecodeResult b(DecodeResult decodeResult) {
        byte[] bArr;
        if (decodeResult == null || (bArr = decodeResult.bytes) == null || bArr.length <= 0) {
            return null;
        }
        try {
            long j = decodeResult.strLen;
            if (j > 0) {
                byte[] bArr2 = new byte[((int) j)];
                System.arraycopy(bArr, 0, bArr2, 0, (int) j);
                String stringEncode = StringEncodeUtils.getStringEncode(bArr2, false);
                if (TextUtils.isEmpty(stringEncode)) {
                    decodeResult.strCode = new String(bArr2, "utf-8");
                    decodeResult.encodeCharset = "utf-8";
                } else {
                    decodeResult.strCode = new String(bArr2, stringEncode);
                    decodeResult.encodeCharset = stringEncode;
                    if (TextUtils.equals(stringEncode, StringEncodeUtils.UTF8) && decodeResult.strCode.charAt(0) == 65279) {
                        decodeResult.strCode = decodeResult.strCode.substring(1);
                    }
                }
                if (TextUtils.isEmpty(decodeResult.strCode)) {
                    decodeResult = null;
                }
            } else if (j == 0) {
                if (MaResultTypeHelper.getMaType(decodeResult) == ResultMaType.QR) {
                    decodeResult.strCode = "null";
                    decodeResult.encodeCharset = null;
                }
                MaBuryRecord.recodeDecodeFailedMaInfo(MaResultTypeHelper.getMaType(decodeResult) != null ? MaResultTypeHelper.getMaType(decodeResult).name() : null);
            }
            return decodeResult;
        } catch (UnsupportedEncodingException | Exception unused) {
            return null;
        }
    }

    private static native DecodeResult[] bitmapDecode(Bitmap bitmap, int i, int i2, boolean z);

    public static synchronized DecodeResult[] bitmapDecodeJ(Bitmap bitmap, int i, int i2, boolean z, MaInterceptOperation maInterceptOperation) {
        DecodeResult[] bitmapDecode;
        synchronized (MaDecode.class) {
            MaLogger.d(TAG, "bitmap_scan_opt()");
            Log.i(TAG, "bitmap_scan_opt bitmapDecodeJ start");
            try {
                a = maInterceptOperation;
                bitmapDecode = bitmapDecode(bitmap, i, i2, z);
                a = null;
                Log.i(TAG, "bitmap_scan_opt bitmapDecodeJ end");
            } catch (Throwable th) {
                MaLogger.e(TAG, "bitmapDecodeJ call native exception", th);
                return null;
            }
        }
        return bitmapDecode;
    }

    private static boolean c() {
        try {
            return ((Boolean) Class.forName("com.alipay.mobile.mascanengine.AlipayMaEngineUtils").getMethod("isNeedBitmapInterfaceOpt", null).invoke(null, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static native int cameraDecodeInit();

    public static int cameraDecodeInitJ() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int cameraDecodeInit = cameraDecodeInit();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a("function=cameraDecodeInitJ^duration=" + elapsedRealtime2);
            return cameraDecodeInit;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "cameraDecodeInitJ: " + e.getMessage());
            return 0;
        } catch (Error e2) {
            MaLogger.e(TAG, "cameraDecodeInitJ: " + e2.getMessage());
            return 0;
        }
    }

    public static native int cameraDecodeUnInit();

    public static int cameraDecodeUnInitJ() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int cameraDecodeUnInit = cameraDecodeUnInit();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a("function=cameraDecodeUnInitJ^duration=" + elapsedRealtime2);
            return cameraDecodeUnInit;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "cameraDecodeUnInitJ: " + e);
            return 0;
        } catch (Error e2) {
            MaLogger.e(TAG, "cameraDecodeUnInitJ: " + e2);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c  */
    public static synchronized DecodeResult[] codeDecode(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, String str, String[] strArr, float f) {
        DecodeResult[] decodeResultArr;
        synchronized (MaDecode.class) {
            if (b) {
                return null;
            }
            b = true;
            if (bArr == null) {
                MaLogger.w(TAG, "codeDecode data is null");
                return null;
            }
            try {
                decodeResultArr = yuvcodeDecode(bArr, i, i2, i3, rect, i4, str, strArr, f);
            } catch (UnsatisfiedLinkError e) {
                MaLogger.e(TAG, "Failed to load decode100198, " + e.getMessage());
                init();
            } catch (Exception e2) {
                MaLogger.e(TAG, e2.getMessage());
            }
            b = false;
            if (decodeResultArr != null) {
                String str2 = new String(decodeResultArr[0].bytes);
                if (dynamicCodeDev && str2.startsWith("alipay_dsl_code_reg://")) {
                    final String replace = str2.replace("alipay_dsl_code_reg://", "");
                    RegistDSLReaderJ(replace, false);
                    MaLogger.d(TAG, "DSL Reader registed " + replace.substring(0, 40) + "...");
                    try {
                        final Context context = (Context) Class.forName("com.alipay.mobile.quinox.LauncherApplication").getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.alipay.ma.decode.MaDecode.AnonymousClass1 */

                            public void run() {
                                Context context = context;
                                Toast.makeText(context, "dsl reader registed" + replace.substring(0, 40) + "...", 1).show();
                            }
                        });
                    } catch (Throwable th) {
                        MaLogger.e(TAG, "dsl regist", th);
                    }
                    return null;
                }
            }
            if (decodeResultArr != null || decodeResultArr.length == 0) {
                return null;
            }
            for (int i5 = 0; i5 < decodeResultArr.length; i5++) {
                decodeResultArr[i5] = b(decodeResultArr[i5]);
                MaLogger.d(TAG, "read result " + decodeResultArr[i5].strCode);
            }
            return decodeResultArr;
        }
        decodeResultArr = null;
        b = false;
        if (decodeResultArr != null) {
        }
        if (decodeResultArr != null) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    public static synchronized DecodeResult[] codeDecodeBinarizedData(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, int i5, String str, String[] strArr) {
        boolean z;
        DecodeResult[] decodeResultArr;
        synchronized (MaDecode.class) {
            if (b) {
                return null;
            }
            z = true;
            b = true;
            if (bArr == null) {
                MaLogger.w(TAG, "codeDecode data is null");
                return null;
            }
            try {
                decodeResultArr = codeDecodeWithBinary(bArr, i, i2, i3, rect, i4, i5, str, strArr);
            } catch (UnsatisfiedLinkError e) {
                MaLogger.e(TAG, "Failed to load decode100198, " + e.getMessage());
                init();
            } catch (Exception e2) {
                MaLogger.e(TAG, e2.getMessage());
            }
            b = false;
            StringBuilder sb = new StringBuilder();
            sb.append("result is null:");
            if (decodeResultArr != null) {
                z = false;
            }
            sb.append(z);
            MaLogger.d(TAG, sb.toString());
            if (decodeResultArr != null || decodeResultArr.length == 0) {
                return null;
            }
            for (int i6 = 0; i6 < decodeResultArr.length; i6++) {
                decodeResultArr[i6] = b(decodeResultArr[i6]);
            }
            return decodeResultArr;
        }
        decodeResultArr = null;
        b = false;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("result is null:");
        if (decodeResultArr != null) {
        }
        sb2.append(z);
        MaLogger.d(TAG, sb2.toString());
        if (decodeResultArr != null) {
        }
        return null;
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(String str, int i, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(str, i, 4, z);
        }
        return codeDecodePictureWithQr;
    }

    private static native DecodeResult[] codeDecodeWithBinary(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, int i5, String str, String[] strArr);

    private static native DecodeResult[] codeDecodeWithQr(byte[] bArr, int i, int i2, int i3, int i4, int i5, boolean z);

    private static void d(int i, String str, int i2, int i3, int i4) {
        Map map;
        if (i == -1 || i == -2 || i == -3) {
            map = new HashMap();
        } else {
            map = getDecodeInfoJ();
        }
        if (map != null) {
            map.put("scanMode", Integer.valueOf(i2));
            map.put("resultCode", Integer.valueOf(i));
            if (str != null) {
                map.put(a.V, str);
            }
            if (i3 > 0 && i4 > 0) {
                map.put("originWidth", Integer.valueOf(i3));
                map.put(v.TAK_ABILITY_SHOW_POP_INIT_SHOW_HEIGHT, Integer.valueOf(i4));
            }
            if (i == 0) {
                MaBuryRecord.recordScanDecodeTrack("SCAN_IMAGE_CODE", "SCAN_IMAGE_SUCCEED", map);
            } else {
                MaBuryRecord.recordScanDecodeTrack("SCAN_IMAGE_CODE", "SCAN_IMAGE_FAILED", map);
            }
        }
    }

    public static void decodeInit() {
        MaLogger.d(TAG, "decodeInit()");
        firstFrameIn = -1;
        frameEngineIn = -1;
        cameraDecodeInitJ();
    }

    public static void decodeUnInit() {
        MaLogger.d(TAG, "decodeUnInit()");
        firstFrameIn = -1;
        frameEngineIn = -1;
        cameraDecodeUnInitJ();
    }

    private static native Object enableFastBitmapDecode();

    public static Object enableFastBitmapDecodeJ() {
        MaLogger.d(TAG, "enableFastBitmapDecodeJ()");
        try {
            enableFastBitmapDecode();
            return null;
        } catch (Throwable th) {
            MaLogger.e(TAG, "enableFastBitmapDecodeJ call native exception", th);
            return null;
        }
    }

    public static native Map getDecodeInfo();

    public static Map getDecodeInfoJ() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Map decodeInfo = getDecodeInfo();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a("function=getDecodeInfoJ^duration=" + elapsedRealtime2);
            return decodeInfo;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getDecodeInfoJ: " + e.getMessage());
            return null;
        } catch (Error e2) {
            MaLogger.e(TAG, "getDecodeInfoJ: " + e2.getMessage());
            return null;
        }
    }

    public static native Map getFrameReadInfo();

    public static Map getFrameReadInfoJ() {
        try {
            return getFrameReadInfo();
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getFrameReadInfoJ: " + e);
            return null;
        } catch (Error e2) {
            MaLogger.e(TAG, "getFrameReadInfoJ: " + e2);
            return null;
        }
    }

    public static native Map getImageInfo(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static Map getImageInfoJ(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        try {
            return getImageInfo(bArr, i, i2, i3, i4, i5, i6, i7);
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getImageInfoJ: " + e.getMessage());
            return null;
        } catch (Error e2) {
            MaLogger.e(TAG, "getImageInfoJ: " + e2.getMessage());
            return null;
        }
    }

    public static int getLastFrameAverageGray() {
        try {
            return getLastFrameAvgGray();
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "Failed to load decode100198, " + e.getMessage());
            init();
        } catch (Exception e2) {
            MaLogger.e(TAG, e2.getMessage());
        }
        return 0;
    }

    public static native int getLastFrameAvgGray();

    public static native float getLimitZoomFactor();

    public static float getLimitZoomFactorJ() {
        try {
            return getLimitZoomFactor();
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    public static native float getMaProportion();

    public static float getMaProportionJ() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            float maProportion = getMaProportion();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a("function=getMaProportionJ^duration=" + elapsedRealtime2);
            return maProportion;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getMaProportionJ: " + e.getMessage());
            return -1.0f;
        } catch (Error e2) {
            MaLogger.e(TAG, "getMaProportionJ: " + e2.getMessage());
            return -1.0f;
        }
    }

    public static native int getMaProportionSource();

    public static int getMaProportionSourceJ() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int maProportionSource = getMaProportionSource();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a("function=getMaProportionSourceJ^duration=" + elapsedRealtime2);
            return maProportionSource;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getMaProportionSourceJ: " + e.getMessage());
            return -1;
        } catch (Error e2) {
            MaLogger.e(TAG, "getMaProportionSourceJ: " + e2.getMessage());
            return -1;
        }
    }

    public static native int getQrSizeAndCenter(float[] fArr);

    public static int getQrSizeAndCenterJ(float[] fArr) {
        try {
            return getQrSizeAndCenter(fArr);
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getQrSizeAndCenterJ: " + e.getMessage());
            return 0;
        } catch (Error e2) {
            MaLogger.e(TAG, "getQrSizeAndCenterJ: " + e2.getMessage());
            return 0;
        }
    }

    public static native String getReaderParams();

    public static String getReaderParamsJ() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String readerParams = getReaderParams();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a("function=getReaderParamsJ^duration=" + elapsedRealtime2);
            return readerParams;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getReaderParmasJ: " + e.getMessage());
            return null;
        } catch (Error e2) {
            MaLogger.e(TAG, "getReaderParmasJ: " + e2.getMessage());
            return null;
        }
    }

    public static void init() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class.forName("com.alipay.mobile.common.utils.load.LibraryLoadUtils").getDeclaredMethod("loadLibrary", String.class, Boolean.TYPE).invoke(null, SO_NAME, Boolean.FALSE);
            long currentTimeMillis2 = System.currentTimeMillis();
            sEngineSoLoadedTimestamp = currentTimeMillis2;
            long j = currentTimeMillis2 - currentTimeMillis;
            MaBuryRecord.reportSoLoadResult(0, j);
            MaEngineAPI.sEngineSoLoaded = true;
            Log.e(TAG, "decode so load duration " + j);
            MaLogger.w(TAG, "decode so load duration " + j);
        } catch (Throwable unused) {
            MaLogger.w(TAG, "so load with framework failed, fall back: decode100198");
            try {
                System.loadLibrary(SO_NAME);
                long currentTimeMillis3 = System.currentTimeMillis();
                sEngineSoLoadedTimestamp = currentTimeMillis3;
                MaBuryRecord.reportSoLoadResult(1, currentTimeMillis3 - currentTimeMillis);
                MaEngineAPI.sEngineSoLoaded = true;
            } catch (UnsatisfiedLinkError e) {
                MaLogger.e(TAG, "Failed to load decode100198, " + e.getMessage());
                MaBuryRecord.reportSoLoadResult(-1, -1);
            }
        }
    }

    public static boolean isIntercepted(byte[] bArr) {
        MaInterceptOperation maInterceptOperation = a;
        if (maInterceptOperation != null) {
            return maInterceptOperation.isIntercepted(bArr);
        }
        return false;
    }

    public static void markEngineFrameIn(long j) {
        frameEngineIn = j;
    }

    public static void markFirstFrameIn(long j) {
        firstFrameIn = j;
    }

    public static native String needA();

    public static String needAJ() {
        try {
            return needA();
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "needAJ: " + e.getMessage());
            return null;
        } catch (Error e2) {
            MaLogger.e(TAG, "needAJ: " + e2.getMessage());
            return null;
        }
    }

    public static native void needDownGradeSdkMemoryAllocate();

    public static void needDownGradeSdkMemoryAllocateJ() {
        MaLogger.d(TAG, "needDownGradeSdkMemoryAllocate()");
        try {
            needDownGradeSdkMemoryAllocate();
        } catch (Throwable th) {
            MaLogger.e(TAG, "needDownGradeSdkMemoryAllocate call native exception", th);
        }
    }

    public static void recordScanDecodeLog(String str, String str2) {
        MaLogger.d(str, str2);
    }

    public static void recordScanDecodeTrack(String str, String str2, HashMap hashMap) {
        if (hashMap != null) {
            hashMap.put("scanUIType", scanUIType);
            hashMap.put("scan_SourceId", scanSourceId);
        }
        MaBuryRecord.recordScanDecodeTrack(str, str2, hashMap);
    }

    public static void refreshInitedReaderParams() {
        sInitedReaderParams = getReaderParamsJ();
    }

    public static native int setBinarizerOrder(int[][] iArr);

    public static native int setReaderParams(String str, String str2);

    public static int setReaderParamsJ(String str, String str2) {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int readerParams = setReaderParams(str, str2);
            a("function=setReaderParamsJ^duration=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
            return readerParams;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "setReaderParams: " + e.getMessage());
            return 0;
        } catch (Error e2) {
            MaLogger.e(TAG, "setReaderParams: " + e2.getMessage());
            return 0;
        }
    }

    public static DecodeResult[] yuvcodeDecode(YuvImage yuvImage, Rect rect, int i, String str, String[] strArr) {
        return codeDecode(yuvImage.getYuvData(), yuvImage.getWidth(), yuvImage.getHeight(), yuvImage.getStrides()[0], rect, i, str, strArr, 1.0f);
    }

    private static native DecodeResult[] yuvcodeDecode(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, String str, String[] strArr, float f);

    public static synchronized DecodeResult[] codeDecodePictureWithQr(String str, int i, int i2, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(str, i, i2, z, (MaInterceptOperation) null);
        }
        return codeDecodePictureWithQr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static synchronized DecodeResult[] codeDecodePictureWithQr(String str, int i, int i2, boolean z, MaInterceptOperation maInterceptOperation) {
        synchronized (MaDecode.class) {
            if (TextUtils.isEmpty(str)) {
                d(-1, str, i, 0, 0);
                return null;
            }
            File file = new File(str);
            if (!file.exists()) {
                d(-2, str, i, 0, 0);
                return null;
            }
            return codeDecodePictureWithQr(ImageTool.createThumbnail(file, 1500, 1500), i, str, i2, z, maInterceptOperation);
        }
    }

    public static long RegistDSLReaderJ(String str) {
        return RegistDSLReaderJ(str, false);
    }

    public static long UnRegistDSLReaderJ(long j) {
        return UnRegistDSLReaderJ(false);
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(String str, Context context, int i, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(str, context, i, 4, z);
        }
        return codeDecodePictureWithQr;
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(String str, Context context, int i, int i2, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(str, context, i, i2, z, (MaInterceptOperation) null);
        }
        return codeDecodePictureWithQr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a A[SYNTHETIC, Splitter:B:34:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bd A[SYNTHETIC, Splitter:B:42:0x00bd] */
    public static synchronized DecodeResult[] codeDecodePictureWithQr(String str, Context context, int i, int i2, boolean z, MaInterceptOperation maInterceptOperation) {
        ParcelFileDescriptor parcelFileDescriptor;
        Throwable th;
        synchronized (MaDecode.class) {
            ParcelFileDescriptor parcelFileDescriptor2 = null;
            if (TextUtils.isEmpty(str)) {
                d(-1, str, i, 0, 0);
                return null;
            }
            try {
                MaLogger.d(TAG, "codeDecodePictureWithQr uriStr=" + str);
                parcelFileDescriptor = context.getContentResolver().openFileDescriptor(Uri.parse(str), UploadQueueMgr.MSGTYPE_REALTIME);
                if (parcelFileDescriptor == null) {
                    try {
                        d(-2, str, i, 0, 0);
                        if (parcelFileDescriptor != null) {
                            try {
                                parcelFileDescriptor.close();
                            } catch (Exception e) {
                                MaLogger.e(TAG, "error:" + e.getMessage());
                            }
                        }
                        return null;
                    } catch (Exception unused) {
                        if (parcelFileDescriptor != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        parcelFileDescriptor2 = parcelFileDescriptor;
                        if (parcelFileDescriptor2 != null) {
                        }
                        throw th;
                    }
                } else {
                    DecodeResult[] codeDecodePictureWithQr = codeDecodePictureWithQr(ImageTool.createThumbnail(parcelFileDescriptor.getFileDescriptor(), 1500, 1500), i, str, i2, z, maInterceptOperation);
                    try {
                        parcelFileDescriptor.close();
                    } catch (Exception e2) {
                        MaLogger.e(TAG, "error:" + e2.getMessage());
                    }
                    return codeDecodePictureWithQr;
                }
            } catch (Exception unused2) {
                parcelFileDescriptor = null;
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (Exception e3) {
                        MaLogger.e(TAG, "error:" + e3.getMessage());
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (parcelFileDescriptor2 != null) {
                    try {
                        parcelFileDescriptor2.close();
                    } catch (Exception e4) {
                        MaLogger.e(TAG, "error:" + e4.getMessage());
                    }
                }
                throw th;
            }
        }
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(Bitmap bitmap, int i, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(bitmap, i, 4, z);
        }
        return codeDecodePictureWithQr;
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(Bitmap bitmap, int i, int i2, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(bitmap, i, (String) null, i2, z);
        }
        return codeDecodePictureWithQr;
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(Bitmap bitmap, int i, String str, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(bitmap, i, str, 4, z);
        }
        return codeDecodePictureWithQr;
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(Bitmap bitmap, int i, String str, int i2, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(bitmap, i, str, i2, z, (MaInterceptOperation) null);
        }
        return codeDecodePictureWithQr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0106  */
    public static synchronized DecodeResult[] codeDecodePictureWithQr(Bitmap bitmap, int i, String str, int i2, boolean z, MaInterceptOperation maInterceptOperation) {
        OutOfMemoryError e;
        Bitmap bitmap2;
        UnsatisfiedLinkError e2;
        Exception e3;
        synchronized (MaDecode.class) {
            DecodeResult[] decodeResultArr = null;
            if (bitmap == null) {
                d(-3, str, i, 0, 0);
                return null;
            }
            try {
                Bitmap.Config config = bitmap.getConfig();
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                if (config != config2) {
                    bitmap2 = bitmap.copy(config2, true);
                    bitmap.recycle();
                } else {
                    bitmap2 = bitmap;
                }
                if (c()) {
                    try {
                        decodeResultArr = bitmapDecodeJ(bitmap2, i, i2, z, maInterceptOperation);
                    } catch (UnsatisfiedLinkError e4) {
                        MaLogger.e(TAG, "Failed to load decode100198," + e4.getMessage());
                        init();
                    } catch (Exception e5) {
                        MaLogger.e(TAG, e5.getMessage());
                    }
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(bitmap2.getHeight() * bitmap2.getRowBytes());
                    allocate.order(ByteOrder.BIG_ENDIAN);
                    bitmap2.copyPixelsToBuffer(allocate);
                    try {
                        a = maInterceptOperation;
                        DecodeResult[] codeDecodeWithQr = codeDecodeWithQr(allocate.array(), bitmap2.getWidth(), bitmap2.getHeight(), bitmap2.getRowBytes(), i, i2, z);
                        try {
                            a = null;
                            decodeResultArr = codeDecodeWithQr;
                        } catch (UnsatisfiedLinkError e6) {
                            e2 = e6;
                            decodeResultArr = codeDecodeWithQr;
                            MaLogger.e(TAG, "Failed to load decode100198," + e2.getMessage());
                            init();
                            if (decodeResultArr != null) {
                            }
                            d(-5, str, i, bitmap.getWidth(), bitmap.getHeight());
                            if (decodeResultArr == null) {
                            }
                            return decodeResultArr;
                        } catch (Exception e7) {
                            e3 = e7;
                            decodeResultArr = codeDecodeWithQr;
                            MaLogger.e(TAG, e3.getMessage());
                            if (decodeResultArr != null) {
                            }
                            d(-5, str, i, bitmap.getWidth(), bitmap.getHeight());
                            if (decodeResultArr == null) {
                            }
                            return decodeResultArr;
                        } catch (OutOfMemoryError e8) {
                            e = e8;
                            decodeResultArr = codeDecodeWithQr;
                            MaLogger.e(TAG, "codeDecodePictureWithQr error : " + e.getMessage());
                            d(-4, str, i, bitmap.getWidth(), bitmap.getHeight());
                            return decodeResultArr;
                        }
                    } catch (UnsatisfiedLinkError e9) {
                        e2 = e9;
                        MaLogger.e(TAG, "Failed to load decode100198," + e2.getMessage());
                        init();
                        if (decodeResultArr != null) {
                        }
                        d(-5, str, i, bitmap.getWidth(), bitmap.getHeight());
                        if (decodeResultArr == null) {
                        }
                        return decodeResultArr;
                    } catch (Exception e10) {
                        e3 = e10;
                        MaLogger.e(TAG, e3.getMessage());
                        if (decodeResultArr != null) {
                        }
                        d(-5, str, i, bitmap.getWidth(), bitmap.getHeight());
                        if (decodeResultArr == null) {
                        }
                        return decodeResultArr;
                    }
                }
                if (decodeResultArr != null || decodeResultArr.length == 0) {
                    d(-5, str, i, bitmap.getWidth(), bitmap.getHeight());
                } else {
                    int i3 = 0;
                    while (decodeResultArr.length > 0 && i3 < decodeResultArr.length) {
                        decodeResultArr[i3] = b(decodeResultArr[i3]);
                        i3++;
                    }
                }
                if (decodeResultArr == null) {
                    d(-6, str, i, bitmap.getWidth(), bitmap.getHeight());
                } else {
                    d(0, str, i, bitmap.getWidth(), bitmap.getHeight());
                }
            } catch (OutOfMemoryError e11) {
                e = e11;
                MaLogger.e(TAG, "codeDecodePictureWithQr error : " + e.getMessage());
                d(-4, str, i, bitmap.getWidth(), bitmap.getHeight());
                return decodeResultArr;
            }
            return decodeResultArr;
        }
    }
}
