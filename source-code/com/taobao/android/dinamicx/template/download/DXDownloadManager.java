package com.taobao.android.dinamicx.template.download;

import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.notification.DXNotificationCenter;
import com.taobao.android.dinamicx.thread.DXDownLoadRunnable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import tb.at;
import tb.c00;
import tb.hy;
import tb.oy0;
import tb.ry;
import tb.v00;
import tb.xz;

/* compiled from: Taobao */
public class DXDownloadManager {
    private IDXDownloader a;
    private WeakReference<DXNotificationCenter> b;
    private Map<String, DXTemplateItem> c;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface IDXDownloadCallback {
        void onFailed(xz<DXTemplateItem> xzVar);

        void onFinished(DXTemplateItem dXTemplateItem);
    }

    public DXDownloadManager(IDXDownloader iDXDownloader, DXNotificationCenter dXNotificationCenter, Map<String, DXTemplateItem> map) {
        if (iDXDownloader == null) {
            this.a = new oy0();
        } else {
            this.a = iDXDownloader;
        }
        this.b = new WeakReference<>(dXNotificationCenter);
        this.c = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.taobao.android.dinamicx.template.download.DXTemplateItem */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(String str, DXTemplateItem dXTemplateItem, IDXUnzipCallback iDXUnzipCallback, IDXDownloadCallback iDXDownloadCallback) {
        byte[] bArr;
        xz<DXTemplateItem> xzVar = new xz<>();
        e eVar = new e(str);
        IDXDownloader iDXDownloader = this.a;
        if (iDXDownloader instanceof oy0) {
            bArr = ((oy0) iDXDownloader).a(dXTemplateItem.templateUrl, str, dXTemplateItem);
        } else {
            bArr = iDXDownloader.download(dXTemplateItem.templateUrl);
        }
        if (bArr == null) {
            e.a aVar = new e.a("Downloader", "Downloader_download", 60000);
            xzVar.a = dXTemplateItem;
            eVar.b = dXTemplateItem;
            eVar.c.add(aVar);
            xzVar.d(eVar);
            iDXDownloadCallback.onFailed(xzVar);
            return;
        }
        if (b.g(dXTemplateItem, bArr, hy.c().b() + v00.DIR + str + v00.DIR + dXTemplateItem.name + v00.DIR + dXTemplateItem.version + v00.DIR, iDXUnzipCallback, eVar)) {
            iDXDownloadCallback.onFinished(dXTemplateItem);
            return;
        }
        xzVar.a = dXTemplateItem;
        xzVar.d(eVar);
        iDXDownloadCallback.onFailed(xzVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean h(DXTemplateItem dXTemplateItem) {
        Map<String, DXTemplateItem> map;
        if (!(dXTemplateItem == null || (map = this.c) == null || map.isEmpty())) {
            for (Map.Entry<String, DXTemplateItem> entry : this.c.entrySet()) {
                if (dXTemplateItem.getIdentifier().equals(entry.getKey())) {
                    this.c.remove(entry.getKey());
                    if (DinamicXEngine.x()) {
                        ry.b("DXDownloadManager", dXTemplateItem.getIdentifier() + " 已在下载完成，从队列移除 " + this.c.size());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i(String str, String str2, DXTemplateItem dXTemplateItem, long j) {
        DXAppMonitor.s(2, str2, "Downloader", str, dXTemplateItem, DXAppMonitor.g((float) j), (double) j, true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(e eVar) {
        DXAppMonitor.n(eVar);
    }

    public void g(final String str, final List<DXTemplateItem> list, final IDXUnzipCallback iDXUnzipCallback, final boolean z) {
        if (list != null && list.size() > 0) {
            DXDownLoadRunnable dXDownLoadRunnable = new DXDownLoadRunnable(0, new Runnable() {
                /* class com.taobao.android.dinamicx.template.download.DXDownloadManager.AnonymousClass1 */

                /* renamed from: com.taobao.android.dinamicx.template.download.DXDownloadManager$1$a */
                /* compiled from: Taobao */
                class a implements IDXDownloadCallback {
                    final /* synthetic */ a a;
                    final /* synthetic */ long b;

                    a(a aVar, long j) {
                        this.a = aVar;
                        this.b = j;
                    }

                    @Override // com.taobao.android.dinamicx.template.download.DXDownloadManager.IDXDownloadCallback
                    public void onFailed(xz<DXTemplateItem> xzVar) {
                        if (at.i0()) {
                            DXDownloadManager.this.h(xzVar.a);
                        }
                        a aVar = this.a;
                        aVar.b = false;
                        aVar.a = xzVar.a;
                        DXNotificationCenter dXNotificationCenter = (DXNotificationCenter) DXDownloadManager.this.b.get();
                        if (dXNotificationCenter != null && z) {
                            dXNotificationCenter.d(this.a);
                        }
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        DXDownloadManager.this.i("Downloader_download", str, this.a.a, System.nanoTime() - this.b);
                        DXDownloadManager.this.j(xzVar.a());
                    }

                    @Override // com.taobao.android.dinamicx.template.download.DXDownloadManager.IDXDownloadCallback
                    public void onFinished(DXTemplateItem dXTemplateItem) {
                        if (at.i0()) {
                            DXDownloadManager.this.h(dXTemplateItem);
                        }
                        a aVar = this.a;
                        aVar.b = true;
                        aVar.a = dXTemplateItem;
                        DXNotificationCenter dXNotificationCenter = (DXNotificationCenter) DXDownloadManager.this.b.get();
                        if (dXNotificationCenter != null && z) {
                            dXNotificationCenter.d(this.a);
                        }
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        DXDownloadManager.this.i("Downloader_download", str, dXTemplateItem, System.nanoTime() - this.b);
                    }
                }

                public void run() {
                    for (DXTemplateItem dXTemplateItem : list) {
                        long nanoTime = System.nanoTime();
                        a aVar = new a();
                        DXDownloadManager.this.f(str, dXTemplateItem, iDXUnzipCallback, new a(aVar, nanoTime));
                    }
                }
            });
            if (z) {
                c00.f(dXDownLoadRunnable);
            } else {
                dXDownLoadRunnable.run();
            }
        }
    }
}
