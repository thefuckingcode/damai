package com.alibaba.security.biometrics.service.video;

import android.content.Context;
import android.media.MediaCodec;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.security.common.d.e;
import com.alibaba.security.common.d.j;
import com.alibaba.security.common.e.a;
import com.alibaba.security.common.e.b;
import com.alibaba.security.common.e.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
public abstract class BaseCameraVideoRecorder implements a {
    protected static final int FRAME_RATE = 30;
    protected static final int IFRAME_INTERVAL = 1;
    private static final int MSG_FINISH = 1;
    protected static final String TAG = "CameraVideoRecorder";
    protected static final int TIMEOUT_USEC = 10000;
    protected static final String VIDEO_MIME_TYPE = "video/avc";
    protected final Context mContext;
    protected int mHeight;
    protected boolean mInitSuccess = false;
    private int mRotate;
    private final UiHandler mUiHandler = new UiHandler(this);
    protected BufferedOutputStream mVOutputStream;
    protected String mVideoSavePath;
    protected int mWidth;

    /* compiled from: Taobao */
    class CameraVideoRecorderImpl implements b {
        private final b mOnCameraVideoReorderListener;

        public CameraVideoRecorderImpl(b bVar) {
            this.mOnCameraVideoReorderListener = bVar;
        }

        @Override // com.alibaba.security.common.e.b
        public void onFinish(String str, int i) {
            VideoMsg videoMsg = new VideoMsg();
            videoMsg.listener = this.mOnCameraVideoReorderListener;
            videoMsg.path = str;
            videoMsg.rotate = i;
            BaseCameraVideoRecorder.this.mUiHandler.obtainMessage(1, videoMsg).sendToTarget();
        }
    }

    /* compiled from: Taobao */
    public static class MuxerData {
        MediaCodec.BufferInfo bufferInfo;
        ByteBuffer byteBuf;
        int trackIndex;

        public MuxerData(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo2) {
            this.trackIndex = i;
            this.byteBuf = byteBuffer;
            this.bufferInfo = bufferInfo2;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class UiHandler extends Handler {
        private final BaseCameraVideoRecorder mService;

        public UiHandler(BaseCameraVideoRecorder baseCameraVideoRecorder) {
            super(Looper.getMainLooper());
            this.mService = baseCameraVideoRecorder;
        }

        public void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            this.mService.dispatchMessage(message);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class VideoMsg {
        public b listener;
        public String path;
        public int rotate;

        private VideoMsg() {
        }
    }

    public BaseCameraVideoRecorder(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchMessage(Message message) {
        if (message.what == 1) {
            doCallback((VideoMsg) message.obj);
        }
    }

    private void doCallback(VideoMsg videoMsg) {
        b bVar = videoMsg.listener;
        if (bVar != null) {
            bVar.onFinish(videoMsg.path, videoMsg.rotate);
        }
    }

    /* access modifiers changed from: protected */
    public byte[] NV21ToNV12(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = i * i2;
        byte[] bArr2 = new byte[((i4 * 3) / 2)];
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        for (int i5 = 0; i5 < i4; i5++) {
            bArr2[i5] = bArr[i5];
        }
        int i6 = 0;
        while (true) {
            i3 = i4 / 2;
            if (i6 >= i3) {
                break;
            }
            int i7 = i4 + i6;
            bArr2[i7 - 1] = bArr[i7];
            i6 += 2;
        }
        for (int i8 = 0; i8 < i3; i8 += 2) {
            int i9 = i4 + i8;
            bArr2[i9] = bArr[i9 - 1];
        }
        return bArr2;
    }

    /* access modifiers changed from: protected */
    public abstract boolean canNewStream();

    /* access modifiers changed from: protected */
    public abstract boolean doInit(int i, int i2, int i3, int i4, String str);

    /* access modifiers changed from: protected */
    public abstract void doRecord(byte[] bArr, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void doRelease(boolean z);

    /* access modifiers changed from: protected */
    public String getSaveVideoPath() {
        String str = this.mContext.getExternalCacheDir().toString() + "/" + (j.a("video_" + System.currentTimeMillis() + (Math.random() * 10000.0d)) + ".mp4");
        com.alibaba.security.common.c.a.a(TAG, "视频存储路径：".concat(String.valueOf(str)));
        return str;
    }

    @Override // com.alibaba.security.common.e.a
    public void init(int i, int i2, int i3, int i4, String str) {
        if (!this.mInitSuccess) {
            this.mRotate = i4;
            this.mVideoSavePath = getSaveVideoPath();
            if (canNewStream()) {
                try {
                    if (!new File(this.mVideoSavePath).exists()) {
                        new File(this.mVideoSavePath).createNewFile();
                    }
                    this.mVOutputStream = new BufferedOutputStream(new FileOutputStream(this.mVideoSavePath));
                } catch (Exception unused) {
                }
            }
            this.mWidth = i;
            this.mHeight = i2;
            this.mInitSuccess = doInit(i, i2, i3, i4, str);
        }
    }

    @Override // com.alibaba.security.common.e.a
    public void record(byte[] bArr) {
        if (!this.mInitSuccess) {
            com.alibaba.security.common.c.a.e(TAG, "record video fail because init fail");
        } else {
            doRecord(bArr, this.mWidth, this.mHeight);
        }
    }

    @Override // com.alibaba.security.common.e.a
    public void release(b bVar, boolean z) {
        doRelease(z);
        this.mInitSuccess = false;
        new CameraVideoRecorderImpl(bVar).onFinish(this.mVideoSavePath, this.mRotate);
        BufferedOutputStream bufferedOutputStream = this.mVOutputStream;
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.flush();
                this.mVOutputStream.close();
            } catch (Exception unused) {
            }
        }
        if (z) {
            e.b(this.mVideoSavePath);
        }
    }

    /* access modifiers changed from: protected */
    public void saveVideo(byte[] bArr, int i) {
        BufferedOutputStream bufferedOutputStream = this.mVOutputStream;
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.write(bArr, 0, i);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.alibaba.security.common.e.a
    public void setOnH264EncoderListener(c cVar) {
    }
}
