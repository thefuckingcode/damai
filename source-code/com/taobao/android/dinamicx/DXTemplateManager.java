package com.taobao.android.dinamicx;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.DXDownloadManager;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.DXTemplatePackageInfo;
import com.taobao.android.dinamicx.template.download.IDXUnzipCallback;
import com.taobao.android.dinamicx.template.download.b;
import com.taobao.android.dinamicx.thread.DXDownLoadRunnable;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tb.at;
import tb.c00;
import tb.ez;
import tb.hy;
import tb.ry;
import tb.s00;
import tb.t00;
import tb.u00;
import tb.v00;
import tb.wz;
import tb.x10;

/* compiled from: Taobao */
public class DXTemplateManager extends b {
    protected ez d = new ez();
    private DXDownloadManager e;
    private t00 f = new t00(this.a.d);
    protected Context g;
    private long h = this.a.e();
    private Map<String, DXTemplateItem> i = new ConcurrentHashMap();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class a {
        List<DXTemplateItem> a = new ArrayList();

        a(DXTemplateManager dXTemplateManager) {
        }
    }

    DXTemplateManager(d dVar, final Context context) {
        super(dVar);
        this.g = context;
        this.e = new DXDownloadManager(DXGlobalCenter.d, dVar.e().l, this.i);
        c00.p(new Runnable() {
            /* class com.taobao.android.dinamicx.DXTemplateManager.AnonymousClass1 */

            public void run() {
                s00.b().c(context, v00.DB_NAME);
            }
        });
        hy.c().d(context);
        l();
    }

    private boolean d(DXTemplateItem dXTemplateItem) {
        if (dXTemplateItem.getTemplateType() == 0) {
            return false;
        }
        for (Map.Entry<String, DXTemplateItem> entry : this.i.entrySet()) {
            if (dXTemplateItem.getIdentifier().equals(entry.getKey())) {
                if (DinamicXEngine.x()) {
                    ry.b("DXTemplateManager", dXTemplateItem.getIdentifier() + " 已在下载队列中，无需下载 " + this.i.size());
                }
                return true;
            }
        }
        this.i.put(dXTemplateItem.getIdentifier(), dXTemplateItem);
        return false;
    }

    private a i(List<DXTemplateItem> list) {
        a aVar = new a(this);
        if (list != null && !list.isEmpty()) {
            HashSet<DXTemplateItem> hashSet = new HashSet(list);
            if (hashSet.size() > 0) {
                for (DXTemplateItem dXTemplateItem : hashSet) {
                    if (v00.b(dXTemplateItem) && !k(dXTemplateItem)) {
                        if (!at.i0() || !d(dXTemplateItem)) {
                            aVar.a.add(dXTemplateItem);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private void l() {
        if (u00.f().l(this.b)) {
            u00 f2 = u00.f();
            String str = this.b;
            f2.m(str, b.f(str));
        }
    }

    private void n(String str, String str2, DXTemplateItem dXTemplateItem, long j) {
        DXAppMonitor.s(2, str2, "Template", str, dXTemplateItem, DXAppMonitor.g((float) j), (double) j, true);
    }

    /* access modifiers changed from: package-private */
    public void e(DXTemplateItem dXTemplateItem) {
        this.f.c(this.b, this.h, dXTemplateItem);
    }

    /* access modifiers changed from: package-private */
    public void f(List<DXTemplateItem> list) {
        this.e.g(this.b, i(list).a, new IDXUnzipCallback() {
            /* class com.taobao.android.dinamicx.DXTemplateManager.AnonymousClass2 */

            @Override // com.taobao.android.dinamicx.template.download.IDXUnzipCallback
            public void onUnzipFinished(final DXTemplateItem dXTemplateItem, Map<String, byte[]> map) {
                if (map != null && map.size() > 0) {
                    final int size = map.size();
                    final AtomicInteger atomicInteger = new AtomicInteger();
                    for (Map.Entry<String, byte[]> entry : map.entrySet()) {
                        final String key = entry.getKey();
                        final byte[] value = entry.getValue();
                        hy.c().f(key, value);
                        c00.f(new DXDownLoadRunnable(2, new Runnable() {
                            /* class com.taobao.android.dinamicx.DXTemplateManager.AnonymousClass2.AnonymousClass1 */

                            public void run() {
                                if (hy.c().g(key, value) && atomicInteger.incrementAndGet() == size) {
                                    s00.b().d(DXTemplateManager.this.b, dXTemplateItem);
                                }
                            }
                        }));
                    }
                    u00 f = u00.f();
                    DXTemplateManager dXTemplateManager = DXTemplateManager.this;
                    f.r(dXTemplateManager.b, dXTemplateManager.h, dXTemplateItem);
                }
            }
        }, true);
    }

    /* access modifiers changed from: package-private */
    public void g(List<DXTemplateItem> list, final IDXDownloadCallback iDXDownloadCallback, boolean z) {
        this.e.g(this.b, i(list).a, new IDXUnzipCallback() {
            /* class com.taobao.android.dinamicx.DXTemplateManager.AnonymousClass3 */

            @Override // com.taobao.android.dinamicx.template.download.IDXUnzipCallback
            public void onUnzipFinished(final DXTemplateItem dXTemplateItem, Map<String, byte[]> map) {
                if (map != null && map.size() > 0) {
                    final int size = map.size();
                    final AtomicInteger atomicInteger = new AtomicInteger();
                    for (Map.Entry<String, byte[]> entry : map.entrySet()) {
                        final String key = entry.getKey();
                        final byte[] value = entry.getValue();
                        hy.c().f(key, value);
                        c00.f(new DXDownLoadRunnable(2, new Runnable() {
                            /* class com.taobao.android.dinamicx.DXTemplateManager.AnonymousClass3.AnonymousClass1 */

                            public void run() {
                                if (hy.c().g(key, value) && atomicInteger.incrementAndGet() == size) {
                                    s00.b().d(DXTemplateManager.this.b, dXTemplateItem);
                                }
                            }
                        }));
                    }
                    u00 f = u00.f();
                    DXTemplateManager dXTemplateManager = DXTemplateManager.this;
                    f.r(dXTemplateManager.b, dXTemplateManager.h, dXTemplateItem);
                    iDXDownloadCallback.callback(dXTemplateItem);
                }
            }
        }, z);
    }

    /* access modifiers changed from: package-private */
    public DXTemplateItem h(DXTemplateItem dXTemplateItem) {
        long nanoTime = System.nanoTime();
        DXTemplateItem a2 = this.f.a(this.b, this.h, dXTemplateItem);
        n("Template_Fetch", this.b, dXTemplateItem, System.nanoTime() - nanoTime);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public synchronized DXWidgetNode j(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null) {
            return null;
        }
        DXRuntimeContext cloneWithWidgetNode = dXRuntimeContext.cloneWithWidgetNode(null);
        e eVar = new e(this.a.a);
        cloneWithWidgetNode.dxError = eVar;
        eVar.b = dXRuntimeContext.dxTemplateItem;
        cloneWithWidgetNode.dxUserContext = null;
        DXTemplateItem dXTemplateItem = cloneWithWidgetNode.dxTemplateItem;
        if (!k(dXTemplateItem)) {
            return null;
        }
        DXTemplatePackageInfo dXTemplatePackageInfo = dXTemplateItem.packageInfo;
        if (dXTemplatePackageInfo == null || TextUtils.isEmpty(dXTemplatePackageInfo.mainFilePath)) {
            dXTemplateItem.packageInfo = u00.f().g(this.b, dXTemplateItem);
        }
        if (dXTemplateItem.packageInfo == null) {
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline_Render", "Pipeline_Stage_Get_Template_Widget", e.DX_GET_PACKAGEINFO_NULL));
            wz.b("templateItem.packageInfo == null");
            return null;
        }
        DXWidgetNode b = x10.d().b(this.b, dXTemplateItem);
        if (b == null) {
            wz.b(" cache widgetTree == null");
            long nanoTime = System.nanoTime();
            b = this.d.a(dXTemplateItem, cloneWithWidgetNode, this.g);
            if (b == null) {
                wz.b(" load widgetTree == null");
                dXRuntimeContext.getDxError().c.add(new e.a("Pipeline_Render", "Pipeline_Stage_Get_Template_Widget", e.DX_LOAD_WT_NULL));
            }
            long nanoTime2 = System.nanoTime() - nanoTime;
            DXAppMonitor.s(3, this.b, "Template", "Pipeline_Stage_Load_Binary", dXTemplateItem, DXAppMonitor.g((float) nanoTime2), (double) nanoTime2, true);
            if (b != null) {
                b.setStatFlag(1);
                x10.d().g(this.b, dXTemplateItem, b);
            }
        }
        if (!(b != null || dXRuntimeContext.getDxError() == null || dXRuntimeContext.getDxError().c == null || cloneWithWidgetNode.getDxError() == null || cloneWithWidgetNode.getDxError().c == null)) {
            dXRuntimeContext.getDxError().c.addAll(cloneWithWidgetNode.getDxError().c);
        }
        return b;
    }

    /* access modifiers changed from: package-private */
    public boolean k(DXTemplateItem dXTemplateItem) {
        long nanoTime = System.nanoTime();
        boolean k = u00.f().k(this.b, dXTemplateItem);
        n("Template_Exist", this.b, dXTemplateItem, System.nanoTime() - nanoTime);
        return k;
    }

    /* access modifiers changed from: package-private */
    public void m(int i2) {
        this.f.b(i2);
    }
}
