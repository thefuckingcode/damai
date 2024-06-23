package tb;

import com.taobao.tao.log.upload.LogFileUploadManager;

/* compiled from: Taobao */
public final /* synthetic */ class y81 implements Runnable {
    public final /* synthetic */ LogFileUploadManager a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ y81(LogFileUploadManager logFileUploadManager, boolean z) {
        this.a = logFileUploadManager;
        this.b = z;
    }

    public final void run() {
        this.a.lambda$uploadFile$4(this.b);
    }
}
