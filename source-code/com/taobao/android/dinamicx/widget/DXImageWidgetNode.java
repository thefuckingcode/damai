package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.taobao.analysis.v3.FalcoGlobalTracer;
import com.taobao.analysis.v3.FalcoTracer;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.PrefetchListener;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.a00;
import tb.at;
import tb.c00;
import tb.c80;
import tb.ht;
import tb.ry;
import tb.vx;
import tb.wz0;

/* compiled from: Taobao */
public class DXImageWidgetNode extends DXWidgetNode implements PrefetchListener {
    public static final int DX_IMAGEVIEW_FILTERTYPE_GRAY = 1;
    public static final int DX_IMAGEVIEW_FILTERTYPE_NONE = 0;
    public static final String HEIGHT_LIMIT = "heightLimit";
    public static final int OPT_TYPE_DEFAULT = 0;
    public static final int OPT_TYPE_ORIGINAL = 1;
    public static final int OPT_TYPE_WEBP = 2;
    public static final String TAG = "DXImageWidgetNode";
    public static final String WIDTH_LIMIT = "widthLimit";
    static LruCache<String, Double> t = new LruCache<>(1024);
    static LruCache<String, Integer> u = new LruCache<>(100);
    private String a;
    private int b;
    private Drawable c;
    private double d = -1.0d;
    private String e;
    private String f;
    private Drawable g;
    private boolean h;
    private boolean i = true;
    private boolean j = true;
    private String k;
    private boolean l = false;
    private int m = 0;
    private int n;
    private int o;
    private String p;
    private boolean q;
    private double r = 0.5d;
    private int s = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DOWNLOAD_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface FILTER_TYPE {
    }

    /* compiled from: Taobao */
    public interface ImageLoadListener {
        boolean onHappen(d dVar);
    }

    /* compiled from: Taobao */
    class a implements ImageLoadListener {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode.ImageLoadListener
        public boolean onHappen(d dVar) {
            throw null;
        }
    }

    /* compiled from: Taobao */
    public static class b implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new DXImageWidgetNode();
        }
    }

    /* compiled from: Taobao */
    public static class c {
        public int[] a;
        public int b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        public boolean h;
        private boolean i;
        private double j;
        private int k;
        private Map<String, String> l;
        private Map<String, String> m;
        public boolean n;

        public Map<String, String> k() {
            return this.l;
        }

        public boolean l() {
            return this.f;
        }

        public boolean m() {
            return this.h;
        }

        public void n(String str, String str2) {
            if (this.l == null) {
                this.l = new ConcurrentHashMap();
            }
            this.l.put(str, str2);
        }

        public void o(Map<String, String> map) {
            this.m = map;
        }
    }

    /* compiled from: Taobao */
    public static class d {
    }

    /* compiled from: Taobao */
    public static class e extends AsyncTask<Void, Void, Drawable> {
        private String a;
        private WeakReference<ImageView> b;
        private Context c;

        public e(ImageView imageView, String str) {
            this.b = new WeakReference<>(imageView);
            this.a = str;
            this.c = imageView.getContext().getApplicationContext();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Drawable doInBackground(Void... voidArr) {
            return b();
        }

        @Nullable
        public Drawable b() {
            Drawable drawable;
            int d = DXImageWidgetNode.d(this.c, this.a);
            if (d == 0) {
                return null;
            }
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable = this.c.getDrawable(d);
                } else {
                    drawable = this.c.getResources().getDrawable(d);
                }
                return drawable;
            } catch (Exception e) {
                Log.e(DXImageWidgetNode.TAG, "Get layout parser exception", e);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(Drawable drawable) {
            ImageView imageView = this.b.get();
            if (imageView != null) {
                if (this.a.equals((String) imageView.getTag(c80.TAG_CURRENT_IMAGE_NAME))) {
                    imageView.setImageDrawable(drawable);
                    imageView.setTag(c80.TAG_IMAGE_NAME, this.a);
                }
            }
        }
    }

    public DXImageWidgetNode() {
        this.cornerRadius = -1;
        this.cornerRadiusLeftBottom = -1;
        this.cornerRadiusRightBottom = -1;
        this.cornerRadiusRightTop = -1;
        this.cornerRadiusLeftTop = -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A[Catch:{ all -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b5 A[Catch:{ all -> 0x00b8 }] */
    private c b(boolean z) {
        boolean z2;
        String str;
        String str2;
        long nanoTime = System.nanoTime();
        c cVar = null;
        try {
            IDXWebImageUrlInterface g2 = DXGlobalCenter.g();
            if (g2 != null) {
                if (!this.h && !this.l) {
                    if (this.m != 1) {
                        z2 = false;
                        if (z2) {
                            if (!needHandleDark()) {
                                str = this.a;
                            } else if (!TextUtils.isEmpty(this.p)) {
                                str = this.p;
                            } else {
                                str = this.a;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                cVar = a();
                                this.k = g2.decideUrl(str, f() ? this.o : getMeasuredWidth(), f() ? this.n : getMeasuredHeight(), cVar);
                                if (DinamicXEngine.x()) {
                                    String[] strArr = new String[1];
                                    if (z) {
                                        str2 = "执行了异步时测量阶段decideUrl";
                                    } else {
                                        str2 = "预先decideUrl by expectedSize " + this.o + " x " + this.n;
                                    }
                                    strArr[0] = str2;
                                    ry.i("PrefetchImageUrl", strArr);
                                    ry.i("PrefetchImageUrl", "realImageUrl=" + str + ", \n decidedUrl=" + this.k);
                                }
                            }
                        } else {
                            this.k = null;
                        }
                    }
                }
                z2 = true;
                if (z2) {
                }
            }
        } catch (Throwable th) {
            com.taobao.android.dinamicx.e eVar = new com.taobao.android.dinamicx.e(getDXRuntimeContext().getBizType());
            e.a aVar = new e.a("Engine", "Engine_Render", com.taobao.android.dinamicx.e.DX_SIMPLE_PREFETCH_LISTENER_CRASH);
            aVar.e = vx.a(th);
            eVar.c.add(aVar);
            DXAppMonitor.n(eVar);
        }
        if (DinamicXEngine.x()) {
            ry.i("PrefetchImageUrl", "cost " + (((float) (System.nanoTime() - nanoTime)) / 1000000.0f) + "ms");
        }
        return cVar;
    }

    public static int d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        Integer num = u.get(str);
        if (num == null) {
            try {
                num = Integer.valueOf(context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
                u.put(str, num);
            } catch (Exception unused) {
                return 0;
            }
        }
        return num.intValue();
    }

    private void g(ImageView imageView, c cVar) {
        if (cVar != null && imageView != null) {
            int i2 = R$id.dx_imageview_renderview_timestamp_key;
            boolean z = imageView.getTag(i2) != null;
            long currentTimeMillis = System.currentTimeMillis();
            imageView.setTag(i2, Long.valueOf(currentTimeMillis));
            cVar.n("DXImageViewOnCreateTimestampKey", String.valueOf(imageView.getTag(R$id.dx_imageview_createview_timestamp_key)));
            cVar.n("DXImageViewOnRenderTimestampKey", String.valueOf(currentTimeMillis));
            cVar.n("DXImageViewIsReuseKey", String.valueOf(z));
            cVar.n("DXImageViewRenderTypeKey", String.valueOf(getDXRuntimeContext().getRenderType()));
            cVar.n("DXImageViewIsMainKey", String.valueOf(Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()));
            if (DinamicXEngine.x()) {
                ry.b("DXImageOption", JSON.toJSONString(cVar.k()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public c a() {
        c cVar = new c();
        getDXRuntimeContext().getConfig().g();
        getDXRuntimeContext().getConfig().f();
        cVar.k = this.m;
        int i2 = this.layoutWidth;
        if (i2 == -2 && this.layoutHeight != -2) {
            cVar.g = true;
        } else if (i2 != -2 && this.layoutHeight == -2) {
            cVar.g = true;
        }
        return cVar;
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new DXImageWidgetNode();
    }

    public double c() {
        return this.d;
    }

    public String e() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean extraHandleDark() {
        return !TextUtils.isEmpty(this.p) || this.q;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.o > 0 && this.n > 0;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j2) {
        if (-2989625047271068027L == j2 || -273786109416499313L == j2) {
            return 1;
        }
        if (-699001992808524026L == j2 || -7195088064603432654L == j2) {
            return 0;
        }
        return super.getDefaultValueForIntAttr(j2);
    }

    /* access modifiers changed from: protected */
    public void h(ImageView imageView, int i2) {
        if (i2 == 0) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else if (i2 == 1) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else if (i2 != 2) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    /* access modifiers changed from: protected */
    public void i(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void j(ImageView imageView, String str) {
        if (str == null) {
            imageView.setImageDrawable(null);
            imageView.setTag(c80.TAG_IMAGE_NAME, null);
            return;
        }
        int i2 = c80.TAG_IMAGE_NAME;
        if (!str.equals((String) imageView.getTag(i2))) {
            e eVar = new e(imageView, str);
            if (this.i) {
                imageView.setTag(c80.TAG_CURRENT_IMAGE_NAME, str);
                c00.q(eVar, new Void[0]);
                return;
            }
            imageView.setImageDrawable(eVar.b());
            imageView.setTag(i2, str);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXImageWidgetNode) {
            DXImageWidgetNode dXImageWidgetNode = (DXImageWidgetNode) dXWidgetNode;
            this.d = dXImageWidgetNode.d;
            this.e = dXImageWidgetNode.e;
            this.a = dXImageWidgetNode.a;
            this.b = dXImageWidgetNode.b;
            this.c = dXImageWidgetNode.c;
            this.h = dXImageWidgetNode.h;
            this.j = dXImageWidgetNode.j;
            this.i = dXImageWidgetNode.i;
            this.f = dXImageWidgetNode.f;
            this.g = dXImageWidgetNode.g;
            this.l = dXImageWidgetNode.l;
            this.m = dXImageWidgetNode.m;
            this.p = dXImageWidgetNode.p;
            this.r = dXImageWidgetNode.r;
            this.q = dXImageWidgetNode.q;
            this.s = dXImageWidgetNode.s;
            this.o = dXImageWidgetNode.o;
            this.n = dXImageWidgetNode.n;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IDXWebImageInterface f2 = DXGlobalCenter.f(getDXRuntimeContext());
        ImageView imageView = f2 == null ? new ImageView(context) : f2.buildView(context);
        imageView.setTag(R$id.dx_imageview_createview_timestamp_key, Long.valueOf(System.currentTimeMillis()));
        return imageView;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int a2 = DXWidgetNode.DXMeasureSpec.a(i2);
        int a3 = DXWidgetNode.DXMeasureSpec.a(i3);
        boolean z = true;
        int i7 = 0;
        boolean z2 = a2 != 1073741824;
        if (a3 == 1073741824) {
            z = false;
        }
        if (z2 || z) {
            double d2 = this.d;
            if (d2 <= 0.0d) {
                if (!TextUtils.isEmpty(this.a)) {
                    Double d3 = t.get(this.a);
                    if (d3 != null) {
                        d2 = d3.doubleValue();
                    }
                } else {
                    Drawable drawable = this.c;
                    if (drawable != null) {
                        int intrinsicWidth = drawable.getIntrinsicWidth();
                        int intrinsicHeight = this.c.getIntrinsicHeight();
                        if (intrinsicHeight > 0) {
                            d2 = ((double) intrinsicWidth) / ((double) intrinsicHeight);
                        }
                    }
                }
            }
            if (!z2 || z) {
                if (!z2 && z) {
                    int size = View.MeasureSpec.getSize(i2);
                    if (d2 > 0.0d) {
                        i7 = size;
                        i6 = (int) (((double) size) / d2);
                    } else {
                        i7 = size;
                    }
                }
                i6 = 0;
            } else {
                i6 = View.MeasureSpec.getSize(i3);
                if (d2 > 0.0d) {
                    i7 = (int) (((double) i6) * d2);
                }
            }
            int max = Math.max(i7, getSuggestedMinimumWidth());
            i4 = Math.max(i6, getSuggestedMinimumHeight());
            i5 = max;
        } else {
            i5 = DXWidgetNode.DXMeasureSpec.b(i2);
            i4 = DXWidgetNode.DXMeasureSpec.b(i3);
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(i5, i2), DXWidgetNode.resolveSize(i4, i3));
    }

    @Override // com.taobao.android.dinamicx.PrefetchListener
    public void onPrefetchSuccess() {
        if (at.v0()) {
            b(true);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        ImageView imageView = (ImageView) view;
        int[] iArr = null;
        c b2 = (!f() || this.k != null) ? null : b(false);
        if (b2 == null) {
            b2 = a();
        }
        b2.n = this.k != null;
        h(imageView, this.b);
        wz0.b(imageView, this.s);
        String str = this.k;
        if (str == null) {
            if (!needHandleDark()) {
                str = this.a;
            } else if (!TextUtils.isEmpty(this.p)) {
                str = this.p;
            } else {
                str = this.a;
            }
        }
        try {
            FalcoTracer falcoTracer = FalcoGlobalTracer.get();
            if (!(falcoTracer == null || getDXRuntimeContext().getOpenTracerSpan() == null)) {
                b2.o(falcoTracer.injectContextToMap(getDXRuntimeContext().getOpenTracerSpan().context()));
            }
        } catch (Throwable th) {
            vx.b(th);
        }
        if (!TextUtils.isEmpty(str)) {
            b2.h = true;
            if (getMeasuredHeight() == 0 || getMeasuredWidth() == 0) {
                new a(str);
            }
        } else {
            Drawable drawable = this.c;
            if (drawable != null) {
                i(imageView, drawable);
            } else if (!TextUtils.isEmpty(this.e)) {
                j(imageView, this.e);
            } else {
                imageView.setImageDrawable(null);
                b2.h = true;
            }
        }
        if (b2.h) {
            b2.b = d(context, this.f);
        }
        if (this.needSetBackground) {
            int tryFetchDarkModeColor = tryFetchDarkModeColor("borderColor", 2, this.borderColor);
            this.borderColor = tryFetchDarkModeColor;
            if (tryFetchDarkModeColor != 0) {
                b2.d = true;
            }
            if (this.borderWidth > 0) {
                b2.e = true;
            }
            int i2 = this.cornerRadius;
            if (i2 > 0) {
                iArr = new int[]{i2, i2, i2, i2};
            } else if (this.cornerRadiusLeftTop > 0 || this.cornerRadiusRightTop > 0 || this.cornerRadiusLeftBottom > 0 || this.cornerRadiusRightBottom > 0 || b2.d || b2.e) {
                iArr = new int[]{this.cornerRadiusLeftTop, this.cornerRadiusRightTop, this.cornerRadiusRightBottom, this.cornerRadiusLeftBottom};
            }
            if (iArr != null) {
                b2.a = iArr;
                b2.f = true;
            }
        }
        if (!(getDXRuntimeContext().getEngineContext() == null || getDXRuntimeContext().getEngineContext().b() == null || !this.j)) {
            getDXRuntimeContext().getEngineContext().b().o();
        }
        b2.c = this.l;
        b2.j = this.r;
        b2.i = this.q;
        IDXWebImageInterface f2 = DXGlobalCenter.f(getDXRuntimeContext());
        if (f2 != null) {
            try {
                g(imageView, b2);
            } catch (Throwable th2) {
                ry.d(TAG, "setImagePerformanceOption", th2);
                vx.b(th2);
            }
            f2.setImage(imageView, str, b2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j2, double d2) {
        if (7594222789952419722L == j2) {
            this.d = d2;
        } else if (j2 == 1360906811535693304L) {
            this.r = d2;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i2) {
        if (1015096712691932083L == j2) {
            this.b = i2;
            return;
        }
        boolean z = false;
        if (1166125168016292427L == j2) {
            if (i2 == 1) {
                z = true;
            }
            this.h = z;
        } else if (-2989625047271068027L == j2) {
            if (i2 == 1) {
                z = true;
            }
            this.j = z;
        } else if (-273786109416499313L == j2) {
            if (i2 == 1) {
                z = true;
            }
            this.i = z;
        } else if (j2 == a00.DXRICHTEXT_FORCEORIGINAL) {
            if (i2 != 0) {
                z = true;
            }
            this.l = z;
        } else if (j2 == -699001992808524026L) {
            this.m = i2;
        } else if (j2 == 3833148244587386529L) {
            this.n = i2;
        } else if (j2 == -5982835989037571513L) {
            this.o = i2;
        } else if (j2 == -6984348415839913320L) {
            if (i2 != 0) {
                z = true;
            }
            this.q = z;
        } else if (j2 == -7195088064603432654L) {
            this.s = i2;
        } else {
            super.onSetIntAttribute(j2, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetObjAttribute(long j2, Object obj) {
        if (18039699017736L == j2) {
            if (obj instanceof Drawable) {
                this.c = (Drawable) obj;
            }
        } else if (5980555813819279758L == j2 && (obj instanceof Drawable)) {
            this.g = (Drawable) obj;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j2, String str) {
        if (j2 == 6852849553340606541L) {
            this.p = str;
        } else if (ht.DXDMCOLORFRAMELAYOUT_IMAGEURL == j2) {
            this.k = null;
            this.a = str;
        } else if (8842287408427345805L == j2) {
            this.e = str;
        } else if (5362226530917353491L == j2) {
            this.f = str;
        } else {
            super.onSetStringAttribute(j2, str);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        if (this.needSetBackground) {
            view.setBackgroundColor(tryFetchDarkModeColor("backGroundColor", 1, this.backGroundColor));
        }
    }
}
