package tb;

import android.text.TextUtils;
import com.taobao.downloader.request.DownloadListener;
import com.taobao.update.instantpatch.model.InstantUpdateInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
public class to1 {
    private n11 a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class b implements DownloadListener {
        CountDownLatch a;

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadError(String str, int i, String str2) {
            to1.this.a.success = false;
            to1.this.a.errorMsg = str2;
            to1.this.a.errorCode = i;
            CountDownLatch countDownLatch = this.a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadFinish(String str, String str2) {
            to1.this.a.path = str2;
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadProgress(int i) {
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadStateChange(String str, boolean z) {
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onFinish(boolean z) {
            CountDownLatch countDownLatch = this.a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            to1.this.a.success = z;
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback) {
        }

        private b(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }
    }

    public to1(n11 n11) {
        this.a = n11;
    }

    public void download(InstantUpdateInfo instantUpdateInfo) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        sb0 sb0 = new sb0();
        u21 u21 = new u21(instantUpdateInfo.patchUrl);
        u21.c = instantUpdateInfo.md5;
        u21.b = Long.valueOf(instantUpdateInfo.size).longValue();
        io1 io1 = new io1();
        io1.f = this.a.getPatchPath();
        io1.a = js2.HOTPATCH;
        io1.b = 10;
        sb0.b = io1;
        ArrayList arrayList = new ArrayList();
        sb0.a = arrayList;
        arrayList.add(u21);
        ub0.c().b(sb0, new b(countDownLatch));
        try {
            countDownLatch.await();
            n11 n11 = this.a;
            if (n11.success && !xb1.isMd5Same(instantUpdateInfo.md5, n11.path)) {
                n11 n112 = this.a;
                n112.success = false;
                n112.errorMsg = "download fail: md5 mismatch";
            }
        } catch (Throwable th) {
            th.printStackTrace();
            n11 n113 = this.a;
            n113.success = false;
            n113.errorMsg = th.getMessage();
        }
        if (TextUtils.isEmpty(this.a.path) || !new File(this.a.path).exists()) {
            n11 n114 = this.a;
            n114.success = false;
            n114.errorMsg = "download fail";
        }
    }
}
