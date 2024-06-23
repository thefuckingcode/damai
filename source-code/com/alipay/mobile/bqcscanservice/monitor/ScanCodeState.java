package com.alipay.mobile.bqcscanservice.monitor;

/* compiled from: Taobao */
public class ScanCodeState {
    public static final String TAG = "ScanCodeState";
    private boolean a;
    private volatile boolean b;
    private int c;
    protected int d;
    protected long e;
    protected int f;
    protected long g;
    protected long h;
    protected long i;
    protected long j;
    protected long k;
    protected boolean l;
    protected int m;
    protected boolean n;

    public ScanCodeState(int i2) {
        this.c = i2;
    }

    private boolean a() {
        return this.a && this.b;
    }

    public void accumulateFrameGap(long j2) {
        if (a()) {
            this.d++;
            this.e += j2;
        }
    }

    public void accumulateFrameRecognize(long j2, long j3, long j4) {
        if (a()) {
            this.f++;
            this.g += j3;
            this.h += j4;
            this.i += j2;
        }
    }

    public boolean dumpValid() {
        return this.a;
    }

    public int getCameraApi() {
        return this.c;
    }

    public long getCodeSize() {
        return this.k;
    }

    public long getFrameGap() {
        return this.e;
    }

    public int getFrameNumRound() {
        return this.d;
    }

    public int getFrameRecognized() {
        return this.f;
    }

    public long getPreviewSize() {
        return this.j;
    }

    public long getRecognizeCpu() {
        return this.h;
    }

    public long getRecognizeSpent() {
        return this.g;
    }

    public long getToRecognizeSpent() {
        return this.i;
    }

    public int getZoom() {
        return this.m;
    }

    public boolean isTorchState() {
        return this.l;
    }

    public boolean isUseSurface() {
        return this.n;
    }

    public void setCameraClosed() {
        if (this.a) {
            this.b = false;
        }
    }

    public void setCameraOpened() {
        if (this.a) {
            this.m = 0;
            this.l = false;
            this.k = 0;
            this.j = 0;
            this.b = true;
            this.d = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.e = 0;
            this.i = 0;
            this.n = false;
        }
    }

    public void setCodeSize(long j2) {
        if (a()) {
            this.k = j2;
        }
    }

    public void setEnable(boolean z) {
        this.a = z;
    }

    public void setPreviewSize(long j2) {
        if (a()) {
            this.j = j2;
        }
    }

    public void setTorchState(boolean z) {
        if (a()) {
            this.l = z;
        }
    }

    public void setUseSurface(boolean z) {
        if (a()) {
            this.n = z;
        }
    }

    public void setZoom(int i2) {
        if (a()) {
            this.m = i2;
        }
    }
}
