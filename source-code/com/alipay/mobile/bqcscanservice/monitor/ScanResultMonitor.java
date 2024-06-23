package com.alipay.mobile.bqcscanservice.monitor;

/* compiled from: Taobao */
public class ScanResultMonitor {
    private volatile long a;
    public boolean enabled;
    public volatile long scanDuration;
    public volatile int scanFrameNum;
    public volatile float size;
    public volatile boolean succeed;

    public void disableScan() {
        if (this.succeed) {
            this.scanFrameNum = -1;
            this.size = 0.0f;
            this.a = 0;
            return;
        }
        this.scanDuration = System.currentTimeMillis() - this.a;
    }

    public void endScan(boolean z) {
        if (this.enabled && this.a > 0) {
            this.succeed = z;
        }
    }

    public void setCodeSize(float f) {
        if (f != 0.0f) {
            this.size = f;
        }
    }

    public void startScan() {
        if (!this.enabled) {
            this.a = 0;
            this.size = 0.0f;
            this.scanFrameNum = -1;
            this.succeed = false;
        } else if (this.a == 0) {
            this.a = System.currentTimeMillis();
            this.scanFrameNum = 0;
        } else {
            this.scanFrameNum++;
        }
    }
}
