package com.alibaba.security.biometrics.service.video;

import android.content.Context;
import com.alibaba.security.common.d.l;
import com.alibaba.security.common.e.a;
import com.alibaba.security.common.e.c;

/* compiled from: Taobao */
public class X264CameraVideoRecorder extends BaseCameraVideoRecorder {
    private a mCameraVideoReorder;

    public X264CameraVideoRecorder(Context context) {
        super(context);
        try {
            this.mCameraVideoReorder = (a) Class.forName("com.alibaba.security.videorecorder.CameraVideoRecorderManager").newInstance();
        } catch (Exception unused) {
            if (l.d(context)) {
                com.alibaba.security.common.c.a.c("CameraVideoRecorder", "no camera video recorder ability");
            }
        }
    }

    private boolean isSupportBioRecorder() {
        return this.mCameraVideoReorder != null;
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder
    public boolean canNewStream() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder
    public boolean doInit(int i, int i2, int i3, int i4, String str) {
        if (!isSupportBioRecorder()) {
            return false;
        }
        try {
            this.mCameraVideoReorder.init(i, i2, i3, i4, str);
            this.mCameraVideoReorder.setOnH264EncoderListener(new c() {
                /* class com.alibaba.security.biometrics.service.video.X264CameraVideoRecorder.AnonymousClass1 */

                @Override // com.alibaba.security.common.e.c
                public void h264(byte[] bArr, int i) {
                    X264CameraVideoRecorder.this.saveVideo(bArr, i);
                }
            });
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder
    public void doRecord(byte[] bArr, int i, int i2) {
        this.mCameraVideoReorder.record(bArr);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder
    public void doRelease(boolean z) {
        this.mCameraVideoReorder.release(null, z);
    }
}
