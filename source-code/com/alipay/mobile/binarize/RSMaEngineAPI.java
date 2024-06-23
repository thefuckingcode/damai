package com.alipay.mobile.binarize;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import com.alipay.ma.MaBuryRecord;
import com.alipay.ma.MaLogger;
import com.alipay.ma.analyze.api.MaEngineAPI;
import com.alipay.ma.decode.DecodeResult;
import com.uc.webview.export.extension.UCCore;
import java.util.Map;

@TargetApi(24)
/* compiled from: Taobao */
public class RSMaEngineAPI extends MaEngineAPI {
    public int classicFrameCount = 0;
    private HandlerThread e;
    private Handler f;
    private BinarizeHandler g;
    private volatile boolean h;
    private byte[] i;
    private int j;
    private int k;
    private boolean l;
    private volatile boolean m;
    private boolean n;
    private Context o;
    private DecodeResult[] p;
    private SharedPreferences q;
    public boolean rsBinarized;
    public int rsBinarizedCount = 0;
    public int rsFrameCount = 0;
    public long rsInitCost = 0;
    public long rsInitStartTime = 0;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private DecodeResult[] l(byte[] bArr, Camera camera, Rect rect, Camera.Size size, int i2, boolean z, int i3, float f2) {
        return super.doProcess(bArr, camera, rect, size, i2, z, i3, f2);
    }

    private byte[] m(byte[] bArr, int i2, int i3, Rect rect) {
        int min;
        int i4 = rect.left;
        int i5 = rect.top;
        int i6 = rect.right;
        this.j = i6;
        int i7 = rect.bottom;
        this.k = i7;
        if (i6 % 8 != 0) {
            this.j = (i6 / 8) * 8;
        }
        if (i7 % 8 != 0) {
            this.k = (i7 / 8) * 8;
        }
        int min2 = Math.min((i2 - i4) - 1, this.j);
        if (min2 <= 0 || (min = Math.min((i3 - i5) - 1, this.k)) <= 0) {
            return null;
        }
        byte[] bArr2 = this.i;
        if (bArr2 == null) {
            this.i = new byte[(this.j * this.k)];
        } else {
            int length = bArr2.length;
            int i8 = this.j;
            int i9 = this.k;
            if (length != i8 * i9) {
                this.i = new byte[(i8 * i9)];
            }
        }
        for (int i10 = i5; i10 < min + i5; i10++) {
            System.arraycopy(bArr, (i10 * i2) + i4, this.i, (i10 - i5) * this.j, min2);
        }
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < this.k; i13 += 32) {
            int i14 = 0;
            while (true) {
                int i15 = this.j;
                if (i14 >= i15) {
                    break;
                }
                i12++;
                i11 += this.i[(i15 * i13) + i14] & 255;
                i14 += 32;
            }
        }
        this.c = i11 / i12;
        return this.i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int n() {
        Context context;
        if (this.q == null && (context = this.o) != null) {
            this.q = context.getSharedPreferences("scan_rs_pref", 0);
        }
        SharedPreferences sharedPreferences = this.q;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("pref_rs_exception", 0);
        }
        return 0;
    }

    private DecodeResult[] o(byte[] bArr, final Camera camera, final Rect rect, final Camera.Size size, final int i2, final float f2) {
        DecodeResult[] decodeResultArr = this.p;
        if (decodeResultArr != null) {
            return decodeResultArr;
        }
        MaLogger.d("RSMaEngineAPI", "rs before binarize");
        if (rect != null) {
            if (rect.left < 0) {
                rect.left = 0;
            }
            if (rect.top < 0) {
                rect.top = 0;
            }
            int i3 = rect.right;
            int i4 = size.width;
            if (i3 > i4) {
                rect.right = i4;
            }
            int i5 = rect.bottom;
            int i6 = size.height;
            if (i5 > i6) {
                rect.bottom = i6;
            }
            m(bArr, i4, i6, rect);
            int i7 = this.j;
            rect.right = i7;
            int i8 = this.k;
            rect.bottom = i8;
            this.g.doBinarize(this.i, i7, i8);
            this.rsBinarizedCount++;
            MaLogger.d("RSMaEngineAPI", "rs after binarize");
            DecodeResult[] decodeResultArr2 = this.p;
            if (decodeResultArr2 != null) {
                return decodeResultArr2;
            }
            if (this.h) {
                return null;
            }
            this.f.post(new Runnable() {
                /* class com.alipay.mobile.binarize.RSMaEngineAPI.AnonymousClass2 */

                public void run() {
                    RSMaEngineAPI.this.h = true;
                    while (true) {
                        if (RSMaEngineAPI.this.g.isBinarizePoolEmpty()) {
                            break;
                        }
                        MaLogger.d("RSMaEngineAPI", "rs start recognize");
                        BinarizeResult popFirstBinarizeResult = RSMaEngineAPI.this.g.popFirstBinarizeResult();
                        if (popFirstBinarizeResult == null) {
                            break;
                        }
                        RSMaEngineAPI rSMaEngineAPI = RSMaEngineAPI.this;
                        rSMaEngineAPI.rsFrameCount++;
                        try {
                            DecodeResult[] l = rSMaEngineAPI.l(popFirstBinarizeResult.bitMatrixData, camera, rect, size, i2, true, popFirstBinarizeResult.methodId, f2);
                            if (l != null) {
                                RSMaEngineAPI.this.p = l;
                                RSMaEngineAPI rSMaEngineAPI2 = RSMaEngineAPI.this;
                                rSMaEngineAPI2.rsBinarized = true;
                                rSMaEngineAPI2.h = false;
                                MaLogger.d("RSMaEngineAPI", "recognize rs binarize code");
                                break;
                            }
                        } catch (Exception e) {
                            MaLogger.w("RSMaEngineAPI", "doProcessBinary exception:" + e);
                        }
                    }
                    RSMaEngineAPI.this.h = false;
                }
            });
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void p(int i2) {
        Context context;
        if (this.q == null && (context = this.o) != null) {
            this.q = context.getSharedPreferences("scan_rs_pref", 0);
        }
        SharedPreferences sharedPreferences = this.q;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("pref_rs_exception", i2).apply();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public int a() {
        if (this.l) {
            return this.c;
        }
        return super.a();
    }

    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public void destroy() {
        super.destroy();
        if (this.l) {
            this.e.quit();
            StringBuilder sb = new StringBuilder();
            sb.append("destroy, binarizeHandler == null:");
            sb.append(this.g == null);
            MaLogger.d("RSMaEngineAPI", sb.toString());
            if (this.g != null) {
                try {
                    int n2 = n();
                    p(n2 + 1);
                    this.g.destroy();
                    p(n2);
                } catch (Exception e2) {
                    MaLogger.d("RSMaEngineAPI", "release binarizer exception2 " + e2);
                    MaBuryRecord.recordRsBinarizeException("release");
                }
            }
            this.h = false;
            this.m = false;
        }
        this.n = true;
    }

    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public DecodeResult[] doProcess(byte[] bArr, Camera camera, Rect rect, Camera.Size size, int i2, boolean z, int i3, float f2) {
        if (!this.l || !this.m) {
            this.classicFrameCount++;
            return super.doProcess(bArr, camera, rect, size, i2, false, 0, f2);
        }
        MaLogger.d("RSMaEngineAPI", "process binary");
        try {
            return o(bArr, camera, rect, size, i2, f2);
        } catch (Exception e2) {
            MaLogger.d("RSMaEngineAPI", "process binarize exception " + e2);
            this.l = false;
            this.e.quit();
            if (this.g != null) {
                this.g.destroy();
            }
            this.m = false;
            MaBuryRecord.recordRsBinarizeException("binarize");
            return null;
        }
    }

    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public boolean init(Context context, Map<String, Object> map) {
        this.o = context;
        if (map == null || !map.containsKey(BinarizeUtils.KEY_ENABLE_RS_BINARIZE)) {
            this.l = false;
        } else {
            boolean z = ((Boolean) map.get(BinarizeUtils.KEY_ENABLE_RS_BINARIZE)).booleanValue() && BinarizeUtils.supportRsBinarize();
            this.l = z;
            if (z && n() >= 2) {
                MaBuryRecord.recordRsExceptionLimitation();
                this.l = false;
            }
        }
        this.n = false;
        this.m = false;
        this.classicFrameCount = 0;
        this.rsFrameCount = 0;
        if (this.l) {
            MaLogger.d("RSMaEngineAPI", "before init");
            this.o = context;
            this.rsBinarizedCount = 0;
            this.rsInitStartTime = System.currentTimeMillis();
            HandlerThread handlerThread = new HandlerThread("Scan-Recognize", 10);
            this.e = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.e.getLooper());
            this.f = handler;
            handler.post(new Runnable() {
                /* class com.alipay.mobile.binarize.RSMaEngineAPI.AnonymousClass1 */

                public void run() {
                    int n = RSMaEngineAPI.this.n();
                    RSMaEngineAPI.this.p(n + 1);
                    try {
                        RSMaEngineAPI.this.g = new BinarizeHandler(RSMaEngineAPI.this.o);
                        RSMaEngineAPI.this.m = true;
                        RSMaEngineAPI.this.rsInitCost = System.currentTimeMillis() - RSMaEngineAPI.this.rsInitStartTime;
                    } catch (Exception e) {
                        MaLogger.d("RSMaEngineAPI", "init binarizer exception " + e);
                        MaBuryRecord.recordRsBinarizeException(UCCore.LEGACY_EVENT_INIT);
                    }
                    if (RSMaEngineAPI.this.n && RSMaEngineAPI.this.g != null) {
                        try {
                            RSMaEngineAPI.this.g.destroy();
                            RSMaEngineAPI.this.m = false;
                        } catch (Exception e2) {
                            MaLogger.d("RSMaEngineAPI", "release binarizer exception1 " + e2);
                            MaBuryRecord.recordRsBinarizeException("release");
                        }
                    }
                    RSMaEngineAPI.this.p(n);
                }
            });
            this.h = false;
        }
        return super.init(context, map);
    }

    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public void resetRecognizeResults() {
        this.p = null;
    }

    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public boolean useRsBinary() {
        return this.l;
    }

    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public DecodeResult[] doProcess(byte[] bArr, Rect rect, Point point, int i2, int i3, boolean z, int i4, float f2) {
        this.classicFrameCount++;
        return super.doProcess(bArr, rect, point, i2, i3, z, i4, f2);
    }
}
