package com.alipay.camera2;

import android.text.TextUtils;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
public class Camera2FocusAbnormalChecker {
    private static float l = 0.7f;
    private static float m = 0.9f;
    private static float n = 0.6f;
    private static float o = 0.7f;
    private long a;
    private long b;
    private long c;
    private float d;
    private float e;
    private float f;
    private boolean g = false;
    private long h = 0;
    private float i;
    private float j;
    private float k;

    public static void updateFocusAbnormalCheckParams(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                if (split == null) {
                    return;
                }
                if (split.length >= 4) {
                    l = Float.valueOf(split[0]).floatValue();
                    m = Float.valueOf(split[1]).floatValue();
                    n = Float.valueOf(split[2]).floatValue();
                    o = Float.valueOf(split[3]).floatValue();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public float getFirstStageBlurRatio() {
        return this.i;
    }

    public float getFirstStageLargestProportion() {
        return this.j;
    }

    public float getFirstStageLargestProportionDistance() {
        return this.k;
    }

    public long getTotalBlurDuration() {
        return this.a;
    }

    public float getTotalBlurRatio() {
        return this.d;
    }

    public float getTotalLargestProportion() {
        return this.e;
    }

    public float getTotalLargestProportionDistance() {
        return this.f;
    }

    public long getTotalScanDuratioin() {
        return this.b;
    }

    public String toString() {
        return "###mTotalBlurDuration=" + String.valueOf(this.a) + "###mNonNeedCheckBlurDuration=" + String.valueOf(this.c) + "###mTotalScanDuration=" + String.valueOf(this.b) + "###mTotalBlurRatio=" + String.valueOf(this.d) + "###mFocusAbnormal=" + String.valueOf(this.g) + "###checkFocusAbnormalDuration=" + String.valueOf(this.h) + "###mTotalLargestProportion=" + String.valueOf(this.e) + "###mTotalLargestProportionDistance=" + String.valueOf(this.f) + "###mFirstStageBlurRatio=" + String.valueOf(this.i) + "###mFirstStageLargestProportion=" + String.valueOf(this.j) + "###mFirstStageLargestProportionDistance=" + String.valueOf(this.k) + "###sFirstStageBlurRatioThreshold=" + String.valueOf(l) + "###sFirstStageProportionRatioThreshold=" + String.valueOf(m) + "###sTotalBlurRatioThreshold=" + String.valueOf(n) + "###sTotalProportionRatioThreshold=" + String.valueOf(o);
    }

    public boolean whetherFocusAbnormal(long j2, long j3, long j4, float f2, float f3) {
        boolean z = false;
        if (j4 >= 1000 && j4 > 0 && f2 > 0.0f) {
            long j5 = j4 - j3;
            if (j5 <= 0) {
                return false;
            }
            float f4 = ((float) j2) / ((float) j5);
            this.c = j3;
            this.a = j2;
            this.b = j4;
            this.d = f4;
            this.e = f2;
            this.f = f3;
            if (j4 < 2000) {
                this.i = f4;
                this.j = f2;
                this.k = f3;
                if (f4 < 0.0f || f4 > 1.0f) {
                    if (f2 >= m) {
                        z = true;
                    }
                    if (z && this.h <= 0) {
                        this.h = j4;
                        this.g = z;
                    }
                    return z;
                }
                if (f4 >= l && f2 >= m) {
                    z = true;
                }
                if (z && this.h <= 0) {
                    this.h = j4;
                    this.g = z;
                }
                return z;
            } else if (f4 < 0.0f || f4 > 1.0f) {
                if (f2 >= o) {
                    z = true;
                }
                if (z && this.h <= 0) {
                    this.h = j4;
                    this.g = z;
                }
            } else {
                if (f4 >= n && f2 >= o) {
                    z = true;
                }
                if (z && this.h <= 0) {
                    this.h = j4;
                    this.g = z;
                }
                return z;
            }
        }
        return z;
    }
}
