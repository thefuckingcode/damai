package com.taobao.update.apk.processor;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.downloader.request.DownloadListener;
import com.taobao.update.adapter.UINotify;
import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.apk.MainUpdateData;
import com.taobao.update.framework.Processor;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import org.android.agoo.common.AgooConstants;
import tb.ab1;
import tb.eb;
import tb.io1;
import tb.jl1;
import tb.ns2;
import tb.sb0;
import tb.u21;
import tb.ub0;

/* compiled from: Taobao */
public class ApkDownloadProcessor implements Processor<ApkUpdateContext> {
    private UINotify a;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements DownloadListener {
        int a = -1;
        final /* synthetic */ boolean b;
        final /* synthetic */ ApkUpdateContext c;
        final /* synthetic */ CountDownLatch d;

        a(boolean z, ApkUpdateContext apkUpdateContext, CountDownLatch countDownLatch) {
            this.b = z;
            this.c = apkUpdateContext;
            this.d = countDownLatch;
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadError(String str, int i, String str2) {
            if (this.b) {
                ApkDownloadProcessor.this.e(str2, this.c.isForceUpdate());
            }
            Log.d("ApkDownloadProcessor", "onDownloadError " + i + jl1.G + str2);
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadFinish(String str, String str2) {
            if (this.b) {
                ApkDownloadProcessor.this.f(str2, this.c.isForceUpdate());
            }
            this.c.apkPath = str2;
            Log.d("ApkDownloadProcessor", "onDownloadFinish " + str2);
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadProgress(int i) {
            Log.d("ApkDownloadProcessor", "on process " + i);
            if (this.b && this.a != i) {
                this.a = i;
                ApkDownloadProcessor.this.g(i, this.c.isForceUpdate());
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadStateChange(String str, boolean z) {
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onFinish(boolean z) {
            Log.d("ApkDownloadProcessor", "onFinish " + z);
            this.c.success = z;
            this.d.countDown();
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(final String str, final boolean z) {
        ab1.execute(new Runnable() {
            /* class com.taobao.update.apk.processor.ApkDownloadProcessor.AnonymousClass3 */

            public void run() {
                ApkDownloadProcessor.this.h(z).notifyDownloadError(TextUtils.isEmpty(str) ? "下载失败" : str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(final String str, final boolean z) {
        ab1.execute(new Runnable() {
            /* class com.taobao.update.apk.processor.ApkDownloadProcessor.AnonymousClass4 */

            public void run() {
                ApkDownloadProcessor.this.h(z).notifyDownloadFinish(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g(final int i, boolean z) {
        if (i(z)) {
            ab1.execute(new Runnable() {
                /* class com.taobao.update.apk.processor.ApkDownloadProcessor.AnonymousClass2 */

                public void run() {
                    ApkDownloadProcessor.this.h(true).notifyDownloadProgress(i);
                }
            });
        } else {
            h(false).notifyDownloadProgress(i);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private UINotify h(boolean z) {
        UINotify uINotify = this.a;
        if (uINotify != null) {
            return uINotify;
        }
        if (z) {
            this.a = (UINotify) eb.getInstance(AgooConstants.MESSAGE_NOTIFICATION, UINotify.class);
        } else {
            this.a = (UINotify) eb.getInstance("sysnotify", UINotify.class);
        }
        return this.a;
    }

    private boolean i(boolean z) {
        return !ns2.isNotificationPermissioned() || z;
    }

    public DownloadListener getListener(CountDownLatch countDownLatch, ApkUpdateContext apkUpdateContext, boolean z) {
        return new a(z, apkUpdateContext, countDownLatch);
    }

    public void execute(ApkUpdateContext apkUpdateContext) {
        if (TextUtils.isEmpty(apkUpdateContext.apkPath)) {
            MainUpdateData mainUpdateData = apkUpdateContext.mainUpdate;
            String str = ns2.getStorePath(apkUpdateContext.context) + "/apkupdate/";
            String str2 = str + mainUpdateData.version;
            try {
                Runtime.getRuntime().exec("chmod 775 " + str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Runtime.getRuntime().exec("chmod 775 " + str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            ArrayList arrayList = new ArrayList(1);
            u21 u21 = new u21();
            arrayList.add(u21);
            u21.a = mainUpdateData.getDownloadUrl();
            u21.b = mainUpdateData.size;
            u21.c = mainUpdateData.md5;
            io1 io1 = new io1();
            sb0 sb0 = new sb0();
            sb0.a = arrayList;
            sb0.b = io1;
            io1.c = 7;
            io1.f = str2;
            io1.d = 0;
            io1.a = "apkupdate";
            io1.b = 20;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ub0.c().b(sb0, getListener(countDownLatch, apkUpdateContext, apkUpdateContext.hasNotified));
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
