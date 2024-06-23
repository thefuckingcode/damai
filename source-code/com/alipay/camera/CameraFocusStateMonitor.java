package com.alipay.camera;

import com.alipay.camera.base.AntCamera;

/* compiled from: Taobao */
public class CameraFocusStateMonitor {
    private static float h = 0.7f;
    private static float i = 0.6f;
    private long a = 0;
    private long b;
    private long c;
    private float d;
    private float e;
    private long f = 0;
    private boolean g;

    public String getString() {
        return "###mTotalBlurDuration=" + String.valueOf(this.b) + "###mTotalScanDuration=" + String.valueOf(this.c) + "###mTotalBlurRatio=" + String.valueOf(this.d) + "###checkFocusAbnormalDuration=" + String.valueOf(this.f) + "###mFocusAbnormal=" + String.valueOf(this.g) + "###mFirstStageBlurRatio=" + String.valueOf(this.e) + "###sFirstStageBlurRatioThreshold=" + String.valueOf(h) + "###sTotalBlurRatioThreshold=" + String.valueOf(i);
    }

    public boolean whetherFocusAbnormal(AntCamera antCamera, long j, long j2) {
        boolean z = false;
        if (antCamera == null) {
            return false;
        }
        if (this.a <= 0) {
            this.a = System.currentTimeMillis();
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.a;
        if (currentTimeMillis >= 1000 && currentTimeMillis > 0) {
            long j3 = currentTimeMillis - j2;
            if (j3 <= 0) {
                return false;
            }
            float f2 = ((float) j) / ((float) j3);
            this.b = j;
            this.c = currentTimeMillis;
            this.d = f2;
            if (currentTimeMillis < 2000) {
                this.e = f2;
                if (f2 >= h) {
                    z = true;
                }
                if (z && this.f <= 0) {
                    this.f = currentTimeMillis;
                    this.g = z;
                }
                return z;
            }
            if (f2 >= i) {
                z = true;
            }
            if (z && this.f <= 0) {
                this.f = currentTimeMillis;
                this.g = z;
            }
        }
        return z;
    }
}
