package com.alibaba.pictures.moimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Lazy;
import tb.dj;
import tb.jl1;
import tb.k21;
import tb.ke1;
import tb.m40;
import tb.me1;
import tb.qg0;
import tb.tp1;
import tb.ug2;
import tb.ur2;
import tb.vb0;
import tb.vp1;
import tb.wd;
import tb.wp1;

public final class MoImageDownloader {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final a Companion = new a(null);
    private static final Lazy d = kotlin.b.b(MoImageDownloader$Companion$executorService$2.INSTANCE);
    private String a;
    private IBitmapTransform b;
    private final Context c;

    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public static /* synthetic */ MoImageDownloader b(a aVar, Context context, int i, Object obj) {
            if ((i & 1) != 0) {
                context = null;
            }
            return aVar.a(context);
        }

        public final MoImageDownloader a(Context context) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1055933428")) {
                return new MoImageDownloader(context, null);
            }
            return (MoImageDownloader) ipChange.ipc$dispatch("1055933428", new Object[]{this, context});
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public static final class b implements DownloadImgListener<Drawable> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DownloadImgListener a;

        b(DownloadImgListener downloadImgListener) {
            this.a = downloadImgListener;
        }

        /* renamed from: a */
        public void onDownloaded(String str, Drawable drawable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1873258792")) {
                ipChange.ipc$dispatch("-1873258792", new Object[]{this, str, drawable});
                return;
            }
            k21.i(drawable, "sourceDrawable");
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap != null) {
                    DownloadImgListener downloadImgListener = this.a;
                    if (downloadImgListener != null) {
                        downloadImgListener.onDownloaded(str, bitmap);
                        return;
                    }
                    return;
                }
                DownloadImgListener downloadImgListener2 = this.a;
                if (downloadImgListener2 != null) {
                    downloadImgListener2.onFail(new MoImageLoadException("bitmap == null,can't convert to a bitmap,please check it!"), "downloadImageAsBitmap fail!");
                    ur2 ur2 = ur2.INSTANCE;
                }
            } else if (!(drawable instanceof Animatable) && !(drawable instanceof AnimatedImageDrawable)) {
                Bitmap d = ke1.d(ke1.INSTANCE, drawable, null, null, 6, null);
                if (d != null) {
                    DownloadImgListener downloadImgListener3 = this.a;
                    if (downloadImgListener3 != null) {
                        downloadImgListener3.onDownloaded(str, d);
                        return;
                    }
                    return;
                }
                DownloadImgListener downloadImgListener4 = this.a;
                if (downloadImgListener4 != null) {
                    downloadImgListener4.onFail(new MoImageLoadException("this is a " + drawable + ",can't convert to a bitmap,please check it!"), "downloadImageAsBitmap fail!");
                    ur2 ur22 = ur2.INSTANCE;
                }
            } else {
                DownloadImgListener downloadImgListener5 = this.a;
                if (downloadImgListener5 != null) {
                    downloadImgListener5.onFail(new MoImageLoadException("this is a Animatable resource,can't convert to a bitmap,please check it!"), "downloadImageAsBitmap fail!");
                }
            }
        }

        @Override // com.alibaba.pictures.moimage.DownloadImgListener
        public void onFail(MoImageLoadException moImageLoadException, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "210478841")) {
                ipChange.ipc$dispatch("210478841", new Object[]{this, moImageLoadException, str});
                return;
            }
            k21.i(moImageLoadException, "exception");
            DownloadImgListener downloadImgListener = this.a;
            if (downloadImgListener != null) {
                downloadImgListener.onFail(moImageLoadException, str);
            }
        }
    }

    public static final class c<T extends wp1> implements IPhenixListener<qg0> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MoImageDownloader a;
        final /* synthetic */ DownloadImgListener b;

        c(MoImageDownloader moImageDownloader, DownloadImgListener downloadImgListener) {
            this.a = moImageDownloader;
            this.b = downloadImgListener;
        }

        /* renamed from: a */
        public final boolean onHappen(qg0 qg0) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1015628098")) {
                return ((Boolean) ipChange.ipc$dispatch("-1015628098", new Object[]{this, qg0})).booleanValue();
            }
            MoImageLoadException moImageLoadException = new MoImageLoadException("Phenix load fail");
            moImageLoadException.setTag(qg0);
            DownloadImgListener downloadImgListener = this.b;
            if (downloadImgListener != null) {
                StringBuilder sb = new StringBuilder();
                k21.h(qg0, AdvanceSetting.NETWORK_TYPE);
                sb.append(qg0.e());
                sb.append(jl1.CONDITION_IF_MIDDLE);
                sb.append(this.a.a);
                downloadImgListener.onFail(moImageLoadException, sb.toString());
            }
            return true;
        }
    }

    public static final class d<T extends wp1> implements IPhenixListener<ug2> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MoImageDownloader a;
        final /* synthetic */ DownloadImgListener b;

        d(MoImageDownloader moImageDownloader, DownloadImgListener downloadImgListener) {
            this.a = moImageDownloader;
            this.b = downloadImgListener;
        }

        /* renamed from: a */
        public final boolean onHappen(ug2 ug2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1417167715")) {
                return ((Boolean) ipChange.ipc$dispatch("1417167715", new Object[]{this, ug2})).booleanValue();
            }
            k21.h(ug2, AdvanceSetting.NETWORK_TYPE);
            BitmapDrawable f = ug2.f();
            if (f != null) {
                DownloadImgListener downloadImgListener = this.b;
                if (downloadImgListener != null) {
                    downloadImgListener.onDownloaded(this.a.a, f);
                }
            } else {
                DownloadImgListener downloadImgListener2 = this.b;
                if (downloadImgListener2 != null) {
                    downloadImgListener2.onFail(new MoImageLoadException("drawable == null!"), "image load success！but the drawable == null！ ");
                    ur2 ur2 = ur2.INSTANCE;
                }
            }
            return true;
        }
    }

    public static final class e<T extends wp1> implements IPhenixListener<wp1> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DownloadImgListener a;

        e(DownloadImgListener downloadImgListener) {
            this.a = downloadImgListener;
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        public final boolean onHappen(wp1 wp1) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-491857662")) {
                return ((Boolean) ipChange.ipc$dispatch("-491857662", new Object[]{this, wp1})).booleanValue();
            }
            DownloadImgListener downloadImgListener = this.a;
            if (downloadImgListener != null) {
                downloadImgListener.onFail(new MoImageLoadException("process cancel..."), "image load success！but the drawable == null！ ");
            }
            return true;
        }
    }

    private MoImageDownloader(Context context) {
        this.c = context;
    }

    public static /* synthetic */ MoImageDownloader g(MoImageDownloader moImageDownloader, String str, Integer num, Integer num2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = -1;
        }
        if ((i & 4) != 0) {
            num2 = -1;
        }
        return moImageDownloader.f(str, num, num2);
    }

    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        tb.dj.a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0089, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008d, code lost:
        tb.dj.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0090, code lost:
        throw r1;
     */
    private final File h(String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1143322203")) {
            return (File) ipChange.ipc$dispatch("-1143322203", new Object[]{this, str});
        }
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z || this.c == null) {
            throw new MoImageLoadException("fullUrl.isNullOrEmpty||context==null");
        }
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(10000);
                if (httpURLConnection.getResponseCode() == 200) {
                    File createTempFile = File.createTempFile("mo_download", "png", k21.d("mounted", Environment.getExternalStorageState()) ? this.c.getExternalCacheDir() : this.c.getCacheDir());
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                        wd.a(inputStream, fileOutputStream, 32768);
                        dj.a(fileOutputStream, null);
                        dj.a(inputStream, null);
                    }
                    return createTempFile;
                }
                throw new MoImageLoadException("responseCode != 200");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        } catch (Exception e2) {
            me1 me1 = me1.INSTANCE;
            me1.c("MoImageDownloader:downloadImageAsFile" + e2);
            throw new MoImageLoadException(e2);
        }
    }

    public static final MoImageDownloader i(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "809172076")) {
            return Companion.a(context);
        }
        return (MoImageDownloader) ipChange.ipc$dispatch("809172076", new Object[]{context});
    }

    public final void c(DownloadImgListener<Bitmap> downloadImgListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443355810")) {
            ipChange.ipc$dispatch("443355810", new Object[]{this, downloadImgListener});
            return;
        }
        d(new b(downloadImgListener));
    }

    public final void d(DownloadImgListener<Drawable> downloadImgListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839447725")) {
            ipChange.ipc$dispatch("-839447725", new Object[]{this, downloadImgListener});
            return;
        }
        String str = this.a;
        if ((str == null || str.length() == 0) && downloadImgListener != null) {
            MoImageLoadException moImageLoadException = new MoImageLoadException("url.isNullOrEmpty!");
            downloadImgListener.onFail(moImageLoadException, "downloadImageAsBitmap fail:" + this.a);
        }
        tp1 o = tp1.o();
        Context context = this.c;
        if (context != null) {
            o.z(context);
        }
        vp1 i = o.s(this.a).m(new c(this, downloadImgListener)).Q(new d(this, downloadImgListener)).i(new e(downloadImgListener));
        IBitmapTransform iBitmapTransform = this.b;
        if (iBitmapTransform != null) {
            i.h(new vb0(iBitmapTransform));
        }
        i.n();
    }

    public final MoImageDownloader e(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2064482000")) {
            return g(this, str, null, null, 6, null);
        }
        return (MoImageDownloader) ipChange.ipc$dispatch("-2064482000", new Object[]{this, str});
    }

    public final MoImageDownloader f(String str, Integer num, Integer num2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-400060656")) {
            return (MoImageDownloader) ipChange.ipc$dispatch("-400060656", new Object[]{this, str, num, num2});
        }
        this.a = ke1.INSTANCE.b(str, num, num2);
        return this;
    }

    public /* synthetic */ MoImageDownloader(Context context, m40 m40) {
        this(context);
    }
}
