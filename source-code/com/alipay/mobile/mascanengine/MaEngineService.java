package com.alipay.mobile.mascanengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alipay.ma.EngineType;
import com.alipay.ma.MaBuryRecord;
import com.alipay.ma.MaLogger;
import com.alipay.ma.analyze.api.MaEngineAPI;
import com.alipay.ma.analyze.helper.MaResultTypeHelper;
import com.alipay.ma.decode.DecodeResult;
import com.alipay.ma.decode.MaDecode;
import com.alipay.ma.statistics.classification.BlurSVC;
import com.alipay.ma.statistics.classification.BlurSVM;
import com.alipay.mobile.binarize.RSMaEngineAPI;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.alipay.mobile.bqcscanservice.BQCScanResult;
import com.alipay.mobile.bqcscanservice.Constants;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.mascanengine.MultiMaScanResult;
import com.alipay.mobile.mascanengine.impl.MaPictureEngineServiceImpl;
import com.alipay.mobile.mascanengine.impl.MaScanResultUtils;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: Taobao */
public class MaEngineService extends BQCScanEngine {
    public static final String KEY_CALLBACK_PACE_SECOND = "callback_pace_second";
    public static final String KEY_ENGINE_PERF = "key_engine_perf";
    public static Map<Integer, Integer> SDK_STEP_NUMBER = null;
    public static final String TAG = "MaEngineService";
    private static long s = 200;
    public static boolean statisticsPerfData = false;
    private static long t = 200;
    protected static long u;
    protected long a;
    protected long b;
    private long c;
    protected MaScanCallback d = null;
    protected float e;
    protected MaEngineAPI f;
    protected float g;
    protected float h;
    protected boolean i;
    protected boolean j;
    protected BlurSVM k = new BlurSVM();
    protected long l;
    Map<String, Object> m = new HashMap();
    protected boolean n;
    protected Point o = new Point();
    private int p = 0;
    protected Map<String, String> q;
    private boolean r;

    static {
        HashMap hashMap = new HashMap();
        SDK_STEP_NUMBER = hashMap;
        hashMap.put(1000, 1);
        SDK_STEP_NUMBER.put(1002, 2);
        SDK_STEP_NUMBER.put(2001, 3);
        SDK_STEP_NUMBER.put(2002, 4);
        SDK_STEP_NUMBER.put(2020, 5);
        SDK_STEP_NUMBER.put(2030, 6);
        SDK_STEP_NUMBER.put(2040, 7);
        SDK_STEP_NUMBER.put(2050, 8);
        SDK_STEP_NUMBER.put(Integer.valueOf((int) GLMapStaticValue.MAP_PARAMETERNAME_POLYGON_FILL_CONTROL), 9);
        SDK_STEP_NUMBER.put(Integer.valueOf((int) GLMapStaticValue.AM_PARAMETERNAME_TEXT_GL_UNIT), 10);
        SDK_STEP_NUMBER.put(2060, 11);
        SDK_STEP_NUMBER.put(3001, 12);
        SDK_STEP_NUMBER.put(Integer.valueOf((int) GlobalErrorCode.ERROR_SERVER_CODE_3101), 13);
        SDK_STEP_NUMBER.put(Integer.valueOf((int) GlobalErrorCode.ERROR_SERVER_CODE_3102), 14);
        SDK_STEP_NUMBER.put(3200, 15);
        SDK_STEP_NUMBER.put(3404, 16);
    }

    private void c(MultiMaScanResult multiMaScanResult, MaEngineAPI maEngineAPI) {
        if (multiMaScanResult != null && maEngineAPI != null && (maEngineAPI instanceof RSMaEngineAPI)) {
            RSMaEngineAPI rSMaEngineAPI = (RSMaEngineAPI) maEngineAPI;
            multiMaScanResult.rsInitTime = rSMaEngineAPI.rsInitCost;
            multiMaScanResult.rsBinarized = rSMaEngineAPI.rsBinarized;
            multiMaScanResult.rsBinarizedCount = rSMaEngineAPI.rsBinarizedCount;
            int i2 = rSMaEngineAPI.classicFrameCount;
            multiMaScanResult.classicFrameCount = i2;
            multiMaScanResult.frameCount = rSMaEngineAPI.rsFrameCount + i2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    private int d(String str) {
        int i2;
        Integer num;
        Exception e2;
        if (str == null) {
            return 0;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            i2 = 0;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONArray jSONArray2 = jSONArray.getJSONArray(i3);
                    if (jSONArray2.length() >= 2) {
                        int parseInt = Integer.parseInt(jSONArray2.getString(1));
                        if (parseInt > i2) {
                            i2 = parseInt;
                        }
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    MaLogger.e(TAG, "getRecognizeStage: " + str, e2);
                    num = SDK_STEP_NUMBER.get(Integer.valueOf(i2));
                    if (num == null) {
                    }
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            i2 = 0;
            MaLogger.e(TAG, "getRecognizeStage: " + str, e2);
            num = SDK_STEP_NUMBER.get(Integer.valueOf(i2));
            if (num == null) {
            }
        }
        num = SDK_STEP_NUMBER.get(Integer.valueOf(i2));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public MultiMaScanResult a(byte[] bArr, Rect rect, Point point, int i2, int i3) {
        String str;
        float f2;
        int i4;
        MaScanCallback maScanCallback;
        Map frameReadInfoJ;
        int i5;
        if (this.r) {
            MaLogger.d(TAG, "MaEngineService.doProcess(api2)");
            this.r = false;
        }
        this.i = false;
        this.j = false;
        if (this.c <= 0) {
            this.c = SystemClock.elapsedRealtime();
        }
        DecodeResult[] decodeResultArr = null;
        float floatValue = (!this.m.containsKey(Constants.EXT_INFO_KEY_ZOOM) || !(this.m.get(Constants.EXT_INFO_KEY_ZOOM) instanceof Float)) ? 1.0f : ((Float) this.m.get(Constants.EXT_INFO_KEY_ZOOM)).floatValue();
        MaEngineAPI maEngineAPI = this.f;
        if (maEngineAPI != null) {
            decodeResultArr = maEngineAPI.doProcess(bArr, rect, point, i2, i3, false, -1, floatValue);
        }
        if (this.n && (maScanCallback = this.d) != null && (maScanCallback instanceof IOnMaSDKDecodeInfo) && (frameReadInfoJ = MaDecode.getFrameReadInfoJ()) != null) {
            Object obj = frameReadInfoJ.get(MaDecode.FRAME_READ_INFO_READ_STEPS);
            if (obj instanceof byte[]) {
                String str2 = new String((byte[]) obj);
                MPaasLogger.d(TAG, new Object[]{str2});
                i5 = d(str2);
            } else {
                i5 = 0;
            }
            MPaasLogger.d(TAG, new Object[]{"stage is ", Integer.valueOf(i5)});
            ((IOnMaSDKDecodeInfo) this.d).onGetRecognizeStage(i5);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        MaScanCallback maScanCallback2 = this.d;
        if (maScanCallback2 == null || decodeResultArr != null || elapsedRealtime - this.c < s) {
            MaLogger.d(TAG, "Not Reach The Threshold");
        } else if (maScanCallback2 == null || !(maScanCallback2 instanceof IOnMaSDKDecodeInfo)) {
            boolean z = false;
            StringBuilder sb = new StringBuilder();
            sb.append("maCallback is null ? ");
            if (this.d == null) {
                z = true;
            }
            sb.append(z);
            sb.append(", (curTimestamp - lastTimestamp) = ");
            sb.append(elapsedRealtime - this.a);
            MaLogger.d(TAG, sb.toString());
        } else {
            int i6 = -1;
            if (elapsedRealtime - this.b > u) {
                this.b = elapsedRealtime;
                MaEngineAPI maEngineAPI2 = this.f;
                float f3 = -1.0f;
                if (maEngineAPI2 != null) {
                    f3 = maEngineAPI2.getMaProportion();
                    i4 = this.f.getMaProportionSource();
                    f2 = this.f.getMaLimitFactor();
                } else {
                    i4 = -1;
                    f2 = -1.0f;
                }
                if (MaLogger.isDebuggable()) {
                    MaLogger.d(TAG, " qrAreaProportion=" + f3 + ", factor=" + f2);
                }
                if (f2 > 1.0f) {
                    try {
                        ((IOnMaSDKDecodeInfo) this.d).onGetMaProportionAndSource(f2, i4);
                    } catch (Throwable th) {
                        MaLogger.e(TAG, "onGetQRAreaProportion: " + th.getMessage());
                    }
                }
            }
            long j2 = this.a;
            long j3 = t;
            if (elapsedRealtime - j2 > j3) {
                if (j2 == 0) {
                    this.l = j3;
                } else {
                    this.l = elapsedRealtime - j2;
                }
                this.a = elapsedRealtime;
                MaEngineAPI maEngineAPI3 = this.f;
                if (maEngineAPI3 != null) {
                    i6 = maEngineAPI3.getAvgGray();
                }
                if (MaLogger.isDebuggable()) {
                    str = TAG;
                    MaLogger.d(str, "avgGray: " + i6);
                } else {
                    str = TAG;
                }
                if (i6 >= 0) {
                    try {
                        ((IOnMaSDKDecodeInfo) this.d).onGetAvgGray(i6);
                    } catch (Throwable th2) {
                        MaLogger.e(str, "onGetAvgGray: " + th2.getMessage());
                    }
                }
                if (BlurSVC.getEnableBlur()) {
                    Map imageInfoJ = MaDecode.getImageInfoJ(new byte[0], 0, 0, 0, 0, 0, 0, 0);
                    if (imageInfoJ != null) {
                        try {
                            if (BlurSVM.getEnableBlur()) {
                                Object obj2 = imageInfoJ.get("imageInfoLaplaceMean");
                                Object obj3 = imageInfoJ.get("imageInfoLaplaceStd");
                                Object obj4 = imageInfoJ.get("imageInfoLaplaceTime");
                                Object obj5 = imageInfoJ.get("imageInfoMaxGrayRatio");
                                if (!(obj2 == null || obj3 == null || obj4 == null)) {
                                    float parseFloat = Float.parseFloat(new String((byte[]) obj2));
                                    float parseFloat2 = Float.parseFloat(new String((byte[]) obj3));
                                    float parseFloat3 = Float.parseFloat(new String((byte[]) obj4));
                                    float parseFloat4 = Float.parseFloat(new String((byte[]) obj5));
                                    if (parseFloat3 > 0.0f) {
                                        this.j = this.k.checkBlur(parseFloat, parseFloat2, parseFloat3, parseFloat4, this.l);
                                    }
                                }
                                if (this.d != null) {
                                    ((IOnMaSDKDecodeInfo) this.d).onGetWhetherFrameBlurSVM(this.j, getDurationOfBlur(), getDurationOfNonNeedCheckBlur());
                                }
                            }
                        } catch (Exception e2) {
                            MaLogger.e(str, "getImageInfoException: " + e2.toString());
                        }
                    }
                    if (MaLogger.isDebuggable()) {
                        MaLogger.d(str, "BlurCheck: whetherBlur=" + this.i + ", localStd=" + this.g + ", globalStd=" + this.h);
                    }
                }
            }
        }
        if (decodeResultArr != null && this.q == null) {
            this.q = MaDecode.getDecodeInfoJ();
        }
        MultiMaScanResult fromMaResults = MaScanResultUtils.fromMaResults(decodeResultArr, this.q);
        if (fromMaResults != null) {
            c(fromMaResults, this.f);
            fromMaResults.readerParams = MaDecode.getReaderParamsJ();
        }
        return fromMaResults;
    }

    /* access modifiers changed from: protected */
    public MultiMaScanResult b(byte[] bArr, Camera camera, Rect rect, Camera.Size size, int i2) {
        if (this.r) {
            MaLogger.d(TAG, "MaEngineService.doProcess(api1)");
            this.r = false;
        }
        if (camera == null) {
            MaLogger.d(TAG, "doProcess mCamera == null");
            MaBuryRecord.reportUnusualScanCase(2, "mCamera is null");
            return null;
        }
        if (size == null || i2 < 0) {
            size = camera.getParameters().getPreviewSize();
        }
        if (size == null) {
            return null;
        }
        Point point = this.o;
        int i3 = size.width;
        point.x = i3;
        point.y = size.height;
        return a(bArr, rect, point, i3, i2);
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void destroy() {
        this.d = null;
        MaEngineAPI maEngineAPI = this.f;
        if (maEngineAPI != null) {
            maEngineAPI.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public List<String> e(BQCScanResult bQCScanResult) {
        MaScanResult[] maScanResultArr;
        ArrayList arrayList = null;
        if ((bQCScanResult instanceof MultiMaScanResult) && bQCScanResult != null && (maScanResultArr = ((MultiMaScanResult) bQCScanResult).maScanResults) != null && maScanResultArr.length > 0) {
            for (MaScanResult maScanResult : maScanResultArr) {
                String str = maScanResult.text;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(maScanResult.text);
                }
            }
        }
        return arrayList;
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public float getCodeSize() {
        return this.e;
    }

    public Class<? extends BQCScanEngine> getEngineClazz() {
        return MaEngineService.class;
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public boolean init(Context context, Map<String, Object> map) {
        if (this.f == null) {
            this.f = new RSMaEngineAPI();
        }
        MaEngineAPI maEngineAPI = this.f;
        if (maEngineAPI != null) {
            maEngineAPI.init(context, map);
        }
        this.r = true;
        return true;
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public boolean isQrCodeEngine() {
        return true;
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public boolean onProcessFinish(BQCScanResult bQCScanResult) {
        MaScanCallback maScanCallback;
        if (bQCScanResult != null && (maScanCallback = this.d) != null && maScanCallback.onMaCodeInterceptor(e(bQCScanResult))) {
            MaLogger.d(TAG, "scan ma code is intercepted,result=" + bQCScanResult);
            return false;
        } else if (bQCScanResult == null || this.d == null || !(bQCScanResult instanceof MultiMaScanResult)) {
            return false;
        } else {
            MaLogger.d(TAG, "The macallback is " + this.d);
            MaScanCallback maScanCallback2 = this.d;
            if (maScanCallback2 == null) {
                return true;
            }
            maScanCallback2.onResultMa((MultiMaScanResult) bQCScanResult);
            return true;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public BQCScanResult process(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        this.p++;
        MaDecode.enableFastBitmapDecodeJ();
        DecodeResult[] codeDecodePictureWithQr = MaDecode.codeDecodePictureWithQr(bitmap, MaPictureEngineServiceImpl.PICTURE_RECOG_TYPE, false);
        if (codeDecodePictureWithQr == null) {
            return null;
        }
        for (int i2 = 0; i2 < codeDecodePictureWithQr.length; i2++) {
            codeDecodePictureWithQr[i2].resultMaType = MaResultTypeHelper.getMaType(codeDecodePictureWithQr[i2]);
        }
        MultiMaScanResult fromMaResults = MaScanResultUtils.fromMaResults(codeDecodePictureWithQr, null);
        fromMaResults.frameType = MultiMaScanResult.ScanFrameType.FRAME_TYPE_VIEW;
        fromMaResults.frameCount = this.p;
        return fromMaResults;
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void setEngineMemoryDownGrade() {
        MaDecode.needDownGradeSdkMemoryAllocateJ();
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void setExtInfo(String str, Object obj) {
        this.m.put(str, obj);
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void setResultCallback(BQCScanEngine.EngineCallback engineCallback) {
        if (engineCallback != null && (engineCallback instanceof MaScanCallback)) {
            MaLogger.d(TAG, "setResultCallback(): " + engineCallback);
            this.d = (MaScanCallback) engineCallback;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void setSubScanType(BQCCameraParam.MaEngineType maEngineType) {
        setSubScanType(maEngineType, null);
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void start() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.p = 0;
        this.m.clear();
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void setSubScanType(BQCCameraParam.MaEngineType maEngineType, String str) {
        MaEngineAPI maEngineAPI = this.f;
        if (maEngineAPI == null) {
            return;
        }
        if (maEngineType != null) {
            maEngineAPI.setSubScanType(EngineType.getType(maEngineType.getType()), str);
        } else if (maEngineType != null || str == null) {
            maEngineAPI.setSubScanType(EngineType.getType(BQCCameraParam.MaEngineType.DEFAULT.getType()), null);
        } else {
            maEngineAPI.setSubScanType(null, str);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public BQCScanResult process(byte[] bArr, Camera camera, Rect rect, Camera.Size size, int i2) {
        return b(bArr, camera, rect, size, i2);
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public BQCScanResult process(byte[] bArr, Rect rect, Point point, int i2, int i3) {
        return a(bArr, rect, point, i2, i3);
    }
}
