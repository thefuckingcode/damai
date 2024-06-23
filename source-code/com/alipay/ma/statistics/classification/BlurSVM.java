package com.alipay.ma.statistics.classification;

import android.text.TextUtils;
import com.alipay.ma.MaLogger;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
public class BlurSVM {
    public static final String KEY_BLUR_SVM_PARAMS = "key_blur_svm_params";
    public static final String KEY_ENABLE_BLUR_SVM = "key_enable_blur_svm";
    public static final String TAG = "BlurSVM";
    private static float i = 2.0f;
    private static float j = 0.3f;
    private static float k = 0.1f;
    private static boolean l = true;
    private static float m = 5.426211f;
    private static float n = 3.4279332f;
    private static float o = 7.310401f;
    private static float p = 6.2331066f;
    private static float q = 1.6728085f;
    private static float r = -5.1614676f;
    private static float s = 8.0f;
    private static float t;
    private float a = 0.0f;
    private float b = 0.0f;
    private float c = 0.0f;
    private long d = 0;
    private float e = 0.0f;
    private long f = 0;
    private boolean g = false;
    private int h = 0;

    private void a(float f2) {
        float f3 = this.e;
        long j2 = this.d;
        this.e = ((f3 * ((float) j2)) + f2) / ((float) (j2 + 1));
        this.d = j2 + 1;
    }

    public static boolean getEnableBlur() {
        return l;
    }

    public static void setBlurParams(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) >= 0) {
            try {
                String[] split = str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                if (split == null) {
                    return;
                }
                if (split.length >= 9) {
                    m = Float.valueOf(split[0]).floatValue();
                    n = Float.valueOf(split[1]).floatValue();
                    o = Float.valueOf(split[2]).floatValue();
                    p = Float.valueOf(split[3]).floatValue();
                    q = Float.valueOf(split[4]).floatValue();
                    r = Float.valueOf(split[5]).floatValue();
                    s = Float.valueOf(split[6]).floatValue();
                    t = Float.valueOf(split[7]).floatValue();
                    j = Float.valueOf(split[8]).floatValue();
                    StringBuilder sb = new StringBuilder(256);
                    sb.append("setBlurParams: sNormalMean_1=");
                    sb.append(m);
                    sb.append(",sNormalStd_1:");
                    sb.append(n);
                    sb.append(",sNormalMean_2:");
                    sb.append(o);
                    sb.append(",sNormalStd_2:");
                    sb.append(p);
                    sb.append(",sCoef1:");
                    sb.append(q);
                    sb.append(",sCoef2:");
                    sb.append(r);
                    sb.append(",sClearThresholdStd:");
                    sb.append(s);
                    sb.append(",sMargin:");
                    sb.append(t);
                    sb.append(",sSingleColorThresholdMaxGray:");
                    sb.append(j);
                    MaLogger.d(TAG, sb.toString());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void setEnableBlur(boolean z) {
        StringBuilder sb = new StringBuilder(32);
        sb.append("setEnableBlur: ");
        sb.append(z);
        MaLogger.d(TAG, sb.toString());
        l = z;
    }

    public boolean checkBlur(float f2, float f3, float f4, float f5, long j2) {
        MaLogger.d(TAG, "checkBlur: laplaceMean:" + f2 + ", laplaceStd:" + f3 + ", laplaceDuration:" + f4 + ", maxGrayRatio:" + f5 + ", mNoNeedCheckBlurDuration:" + this.f);
        if (f2 > 0.0f && f3 > 0.0f && f4 > 0.0f) {
            if (this.a == 0.0f) {
                this.a = f2;
            }
            if (this.b == 0.0f) {
                this.b = f3;
            }
            if (Math.abs(this.a - f2) <= 1.0E-5f && Math.abs(this.b - f3) <= 1.0E-5f) {
                int i2 = this.h + 1;
                this.h = i2;
                if (i2 > 1) {
                    this.f += j2;
                    this.g = true;
                    MaLogger.d(TAG, "checkBlur: false return. with same laplace mean & std.");
                } else {
                    MaLogger.d(TAG, "checkBlur: false return. first no care.");
                }
                return false;
            } else if (f3 > s) {
                this.c = Math.abs(this.a - f2) / this.a;
                this.a = f2;
                this.b = f3;
                MaLogger.d(TAG, "checkBlur: false return. > sClearThresholdStd:" + s);
                return false;
            } else {
                a(f4);
                float abs = Math.abs(this.a - f2) / this.a;
                this.a = f2;
                this.b = f3;
                MaLogger.d(TAG, "checkBlur: laplaceMeanDiffRatio:" + abs + ", lastLaplaceMeanDiffRatio:" + this.c);
                if (f2 < i || f5 >= j) {
                    this.c = abs;
                    this.f += j2;
                    MaLogger.d(TAG, "checkBlur: singleColor return. laplaceMean:" + f2 + ", maxGrayRatio:" + f5);
                } else {
                    float f6 = k;
                    boolean z = abs > f6 || this.c > f6;
                    this.c = abs;
                    if (z) {
                        this.f += j2;
                        MaLogger.d(TAG, "checkBlur: false return. isMoving");
                        return false;
                    }
                    float f7 = (((f2 - m) / n) * q) + (((f3 - o) / p) * r) + t;
                    StringBuilder sb = new StringBuilder();
                    sb.append("checkBlur: result:");
                    int i3 = (f7 > 0.0f ? 1 : (f7 == 0.0f ? 0 : -1));
                    sb.append(i3 > 0);
                    MaLogger.d(TAG, sb.toString());
                    if (i3 > 0) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public float getAvgLaplaceDetectDuration() {
        return this.e;
    }

    public long getBlurCheckFrameCount() {
        return this.d;
    }

    public long getNoNeedCheckBlurDuration() {
        return this.f;
    }

    public int getTheSameLaplaceValueCount() {
        return this.h;
    }

    public boolean isWhetherGetTheSameLaplaceValue() {
        return this.g;
    }
}
