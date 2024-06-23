package com.youku.network.call;

import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.aidl.ParcelableInputStream;
import java.io.ByteArrayOutputStream;
import mtopsdk.network.util.NetworkUtils;

/* compiled from: Taobao */
class NetworkListener$1 implements Runnable {
    final /* synthetic */ l this$0;
    final /* synthetic */ Object val$context;
    final /* synthetic */ ParcelableInputStream val$inputStream;

    NetworkListener$1(l lVar, ParcelableInputStream parcelableInputStream, Object obj) {
        this.this$0 = lVar;
        this.val$inputStream = parcelableInputStream;
        this.val$context = obj;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        if (r0 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r4.this$0.i = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        r0 = r4.val$inputStream;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        if (r0 == null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        r1 = r4.val$inputStream;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0078, code lost:
        if (r1 != null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007d, code lost:
        mtopsdk.network.util.NetworkUtils.closeQuietly(r4.this$0.i);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0086, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x003e */
    public void run() {
        this.this$0.i = new ByteArrayOutputStream(this.val$inputStream.length() > 0 ? this.val$inputStream.length() : this.this$0.d);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = this.val$inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            this.this$0.i.write(bArr, 0, read);
        }
        ParcelableInputStream parcelableInputStream = this.val$inputStream;
        NetworkUtils.closeQuietly(this.this$0.i);
        synchronized (this.this$0) {
            if (this.this$0.g != null) {
                l lVar = this.this$0;
                lVar.a((l) lVar.g, (NetworkEvent$FinishEvent) this.val$context);
            } else {
                this.this$0.h = true;
            }
        }
    }
}
