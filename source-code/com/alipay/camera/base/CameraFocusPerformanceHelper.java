package com.alipay.camera.base;

import com.alipay.camera.util.CameraLog;

/* compiled from: Taobao */
public class CameraFocusPerformanceHelper {
    private long a = 0;
    private long b = 0;
    private float c = 0.0f;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 0.0f;
    private int g;

    public String getString() {
        try {
            return "###CameraFocusPerf" + "###focusTriggerCount=" + String.valueOf(this.g) + "###firstFocusDuration=" + String.valueOf(this.c) + "###firstFocusCount=" + String.valueOf(this.d) + "###avgFocusDuration=" + String.valueOf(this.e) + "###avgFocusCount=" + String.valueOf(this.f);
        } catch (Exception e2) {
            CameraLog.e("CameraFocusPerformanceHelper", "toString with error" + e2.toString());
            return "NULL";
        }
    }

    public void offerCamera1FocusState(boolean z, long j) {
        if (!z && this.a > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            long j2 = j - this.b;
            CameraLog.d("CameraFocusPerformanceHelper", "offerCamera1FocusState, consume:" + currentTimeMillis + ", frameCount:" + j2);
            if (this.c == 0.0f || this.d == 0.0f) {
                this.c = (float) currentTimeMillis;
                this.d = (float) j2;
            }
            float f2 = this.e;
            int i = this.g;
            this.e = ((f2 * ((float) i)) + ((float) currentTimeMillis)) / ((float) (i + 1));
            this.f = ((this.f * ((float) i)) + ((float) j2)) / ((float) (i + 1));
            this.g = i + 1;
            this.a = 0;
            this.b = 0;
        } else if (z && this.a == 0) {
            this.a = System.currentTimeMillis();
            this.b = j;
        }
    }

    public void offerCamera2FocusState(int i, long j) {
        if (i == 4 || i == 2) {
            if (this.a > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.a;
                long j2 = j - this.b;
                CameraLog.d("CameraFocusPerformanceHelper", "offerCamera2FocusState, consume:" + currentTimeMillis + ", frameCount:" + j2);
                if (this.c == 0.0f || this.d == 0.0f) {
                    this.c = (float) currentTimeMillis;
                    this.d = (float) j2;
                }
                float f2 = this.e;
                int i2 = this.g;
                this.e = ((f2 * ((float) i2)) + ((float) currentTimeMillis)) / ((float) (i2 + 1));
                this.f = ((this.f * ((float) i2)) + ((float) j2)) / ((float) (i2 + 1));
                this.g = i2 + 1;
                this.a = 0;
                this.b = 0;
            }
        } else if (this.a == 0) {
            this.a = System.currentTimeMillis();
            this.b = j;
        }
    }
}
