package com.alibaba.aliweex.interceptor.phenix;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alibaba.aliweex.interceptor.IWeexAnalyzerInspector;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.taobao.weex.utils.WXLogUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;
import mtopsdk.network.util.Constants;
import tb.gn2;
import tb.j11;
import tb.k11;
import tb.qg0;
import tb.th1;
import tb.ug2;
import tb.vp1;

/* compiled from: Taobao */
public class PhenixTracker {
    private static boolean g = true;
    private th1 a;
    private IWeexAnalyzerInspector b;
    private ExecutorService c = null;
    @Nullable
    private String d;
    private final int e = gn2.a();
    private boolean f = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            a = iArr;
            iArr[Bitmap.CompressFormat.WEBP.ordinal()] = 1;
            a[Bitmap.CompressFormat.PNG.ordinal()] = 2;
        }
    }

    private PhenixTracker() {
        if (WXEnvironment.isApkDebugable()) {
            this.a = th1.d();
            this.b = com.alibaba.aliweex.interceptor.a.a();
            this.c = Executors.newSingleThreadExecutor();
            this.f = this.a.g();
            WXLogUtils.d("PhenixTracker", "Create new instance " + toString());
        }
    }

    private boolean f() {
        return g && WXEnvironment.isApkDebugable() && this.a != null && this.f;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String g(Bitmap.CompressFormat compressFormat) {
        int i = a.a[compressFormat.ordinal()];
        if (i != 1) {
            return i != 2 ? "image/jpeg" : "image/png";
        }
        return "image/webp";
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Bitmap.CompressFormat h(String str) {
        if (str != null) {
            if (str.endsWith(".webp") || str.endsWith(".WEBP")) {
                return Bitmap.CompressFormat.WEBP;
            }
            if (str.endsWith(".png") || str.endsWith(".PNG")) {
                return Bitmap.CompressFormat.PNG;
            }
        }
        return Bitmap.CompressFormat.JPEG;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String i() {
        if (this.d == null) {
            this.d = String.valueOf(this.e);
        }
        return this.d;
    }

    public static PhenixTracker j() {
        return new PhenixTracker();
    }

    public void k(final qg0 qg0) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (f()) {
            this.a.c(new Runnable() {
                /* class com.alibaba.aliweex.interceptor.phenix.PhenixTracker.AnonymousClass4 */

                public void run() {
                    th1 th1 = PhenixTracker.this.a;
                    String i = PhenixTracker.this.i();
                    th1.e(i, "Error code: " + qg0.f());
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                this.b.onResponse("image", new IWeexAnalyzerInspector.b(TextUtils.isEmpty(qg0.b()) ? "unknown" : qg0.b(), "download failed", 200, null));
            } catch (Exception e2) {
                WXLogUtils.e("PhenixTracker", e2.getMessage());
            }
        }
    }

    public void l(final ug2 ug2) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        ExecutorService executorService;
        if (f()) {
            this.a.c(new Runnable() {
                /* class com.alibaba.aliweex.interceptor.phenix.PhenixTracker.AnonymousClass2 */

                public void run() {
                    k11 k11 = new k11();
                    k11.h(PhenixTracker.this.i());
                    k11.k(ug2.g());
                    k11.m(ug2.g() ? 304 : 200);
                    k11.l(ug2.g() ? "FROM DISK CACHE" : WXModalUIModule.OK);
                    k11.i(ug2.b());
                    Bitmap bitmap = ug2.f().getBitmap();
                    if (bitmap == null) {
                        PhenixTracker.this.a.j(PhenixTracker.this.i(), "event getbitmap obj is null");
                        return;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    Bitmap.CompressFormat h = PhenixTracker.this.h(ug2.b());
                    bitmap.compress(h, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    k11.a("Content-Type", PhenixTracker.this.g(h));
                    k11.a(Constants.Protocol.CONTENT_LENGTH, byteArray.length + "");
                    PhenixTracker.this.a.i(k11);
                    PhenixTracker.this.a.f(PhenixTracker.this.i(), PhenixTracker.this.g(h), null, new ByteArrayInputStream(byteArray), false);
                    PhenixTracker.this.a.k(PhenixTracker.this.i());
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled() && (executorService = this.c) != null && !executorService.isShutdown()) {
            this.c.execute(new Runnable() {
                /* class com.alibaba.aliweex.interceptor.phenix.PhenixTracker.AnonymousClass3 */

                public void run() {
                    int i;
                    try {
                        Bitmap bitmap = ug2.f().getBitmap();
                        if (bitmap == null) {
                            i = 0;
                        } else {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(PhenixTracker.this.h(ug2.b()), 100, byteArrayOutputStream);
                            i = byteArrayOutputStream.toByteArray().length;
                        }
                        IWeexAnalyzerInspector iWeexAnalyzerInspector = PhenixTracker.this.b;
                        String b = TextUtils.isEmpty(ug2.b()) ? "unknown" : ug2.b();
                        iWeexAnalyzerInspector.onResponse("image", new IWeexAnalyzerInspector.b(b, Collections.singletonMap(Constants.Protocol.CONTENT_LENGTH, i + "").toString(), ug2.g() ? 304 : 200, null));
                    } catch (Exception e) {
                        WXLogUtils.e("PhenixTracker", e.getMessage());
                    }
                }
            });
        }
    }

    public void m(final vp1 vp1, final Map<String, String> map) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (f()) {
            this.a.c(new Runnable() {
                /* class com.alibaba.aliweex.interceptor.phenix.PhenixTracker.AnonymousClass1 */

                public void run() {
                    j11 j11 = new j11();
                    j11.i(vp1.R());
                    j11.h(PhenixTracker.this.i());
                    j11.m("GET");
                    j11.l("Phenix");
                    for (Map.Entry entry : map.entrySet()) {
                        j11.a((String) entry.getKey(), (String) entry.getValue());
                    }
                    PhenixTracker.this.a.h(j11);
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                this.b.onRequest("image", new IWeexAnalyzerInspector.a(TextUtils.isEmpty(vp1.R()) ? "unknown" : vp1.R(), "GET", map));
            } catch (Exception e2) {
                WXLogUtils.e("PhenixTracker", e2.getMessage());
            }
        }
    }
}
