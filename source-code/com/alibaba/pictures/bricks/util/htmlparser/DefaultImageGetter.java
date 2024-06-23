package com.alibaba.pictures.bricks.util.htmlparser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetter;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetterCallBack;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ky0;
import tb.m40;
import tb.v00;
import tb.w40;
import tb.x40;

/* compiled from: Taobao */
public final class DefaultImageGetter implements ImageGetter {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static final String f = DefaultImageGetter.class.getSimpleName();
    @Nullable
    private static Set<BitmapWorkerTask> g = new HashSet();
    @Nullable
    private static ExecutorService h = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final int a;
    @NotNull
    private final Context b;
    @Nullable
    private final b c;
    private final int d = ((int) (ky0.Companion.a() * 2.5f));
    @NotNull
    private final String e;

    /* compiled from: Taobao */
    public final class BitmapWorkerTask implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final ImageGetterCallBack callBack;
        private final int end;
        @NotNull
        private final String imageUrl;
        private boolean isCancel;
        private final int start;
        final /* synthetic */ DefaultImageGetter this$0;

        public BitmapWorkerTask(@NotNull DefaultImageGetter defaultImageGetter, String str, int i, @NotNull int i2, ImageGetterCallBack imageGetterCallBack) {
            k21.i(str, "imageUrl");
            k21.i(imageGetterCallBack, "callBack");
            this.this$0 = defaultImageGetter;
            this.imageUrl = str;
            this.start = i;
            this.end = i2;
            this.callBack = imageGetterCallBack;
        }

        public final void cancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1615243960")) {
                ipChange.ipc$dispatch("1615243960", new Object[]{this});
                return;
            }
            this.isCancel = true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f2, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f3, code lost:
            r9 = r4;
            r4 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f6, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f7, code lost:
            r1 = r0;
            r0 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0101, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0102, code lost:
            r9 = r3;
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0104, code lost:
            r0 = r1;
            r1 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x011a, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x011b, code lost:
            r3 = null;
            r0 = r1;
            r1 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0140, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0145, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x014a, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x0172, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x017b, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x017f, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0183, code lost:
            r0.printStackTrace();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00f6 A[ExcHandler: all (r0v19 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:34:0x00d5] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x011a A[ExcHandler: all (r3v10 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:13:0x005f] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0140  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x0145  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x014a  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x015b A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0172  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0177 A[SYNTHETIC, Splitter:B:84:0x0177] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x017f A[Catch:{ IOException -> 0x017b }] */
        /* JADX WARNING: Removed duplicated region for block: B:93:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        public void run() {
            BufferedOutputStream bufferedOutputStream;
            BufferedInputStream bufferedInputStream;
            Throwable th;
            Bitmap bitmap;
            IOException e;
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1972933165")) {
                ipChange.ipc$dispatch("1972933165", new Object[]{this});
                return;
            }
            Set set = DefaultImageGetter.g;
            k21.f(set);
            set.add(this);
            HttpURLConnection httpURLConnection = null;
            r0 = null;
            BufferedOutputStream bufferedOutputStream2 = null;
            httpURLConnection = null;
            try {
                if (o.L(this.imageUrl, "http", false, 2, null)) {
                    str = this.imageUrl;
                } else {
                    str = this.this$0.e + this.imageUrl;
                }
                URLConnection openConnection = new URL(str).openConnection();
                k21.g(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
                try {
                    bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream(), 8192);
                    try {
                        bitmap = BitmapFactory.decodeStream(bufferedInputStream);
                        if (bitmap != null) {
                            if (!this.isCancel) {
                                Log.d(DefaultImageGetter.f, "download image compete " + this.imageUrl);
                                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                                if (!(o.v(this.imageUrl, ".jpg", false, 2, null)) && !(o.v(this.imageUrl, ".jpeg", false, 2, null)) && !(o.v(this.imageUrl, ".JPG", false, 2, null))) {
                                    if (!(o.v(this.imageUrl, ".JPEG", false, 2, null))) {
                                        if (o.v(this.imageUrl, ".webp", false, 2, null)) {
                                            compressFormat = Bitmap.CompressFormat.WEBP;
                                        }
                                        b bVar = this.this$0.c;
                                        k21.f(bVar);
                                        bufferedOutputStream = new BufferedOutputStream(bVar.f(this.imageUrl), 4096);
                                        bitmap.compress(compressFormat, 90, bufferedOutputStream);
                                        Bitmap d = DefaultImageGetter.Companion.d(bitmap, this.this$0.a);
                                        this.this$0.c.g(this.imageUrl, d);
                                        bitmap = d;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                    }
                                }
                                compressFormat = Bitmap.CompressFormat.JPEG;
                                b bVar2 = this.this$0.c;
                                k21.f(bVar2);
                                bufferedOutputStream = new BufferedOutputStream(bVar2.f(this.imageUrl), 4096);
                                try {
                                    bitmap.compress(compressFormat, 90, bufferedOutputStream);
                                    Bitmap d2 = DefaultImageGetter.Companion.d(bitmap, this.this$0.a);
                                    this.this$0.c.g(this.imageUrl, d2);
                                    bitmap = d2;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                } catch (IOException e2) {
                                    e = e2;
                                    httpURLConnection = httpURLConnection2;
                                    try {
                                        e.printStackTrace();
                                        if (httpURLConnection != null) {
                                        }
                                        if (bufferedOutputStream != null) {
                                        }
                                        if (bufferedInputStream != null) {
                                        }
                                        Set set2 = DefaultImageGetter.g;
                                        k21.f(set2);
                                        set2.remove(this);
                                        if (!this.isCancel) {
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (httpURLConnection != null) {
                                        }
                                        if (bufferedOutputStream != null) {
                                        }
                                        if (bufferedInputStream != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                }
                            }
                        }
                        httpURLConnection2.disconnect();
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                        bitmap = null;
                        httpURLConnection = httpURLConnection2;
                        e = e4;
                        bufferedOutputStream = null;
                        e.printStackTrace();
                        if (httpURLConnection != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        Set set22 = DefaultImageGetter.g;
                        k21.f(set22);
                        set22.remove(this);
                        if (!this.isCancel) {
                        }
                    } catch (Throwable th4) {
                    }
                } catch (IOException e5) {
                    bufferedOutputStream = null;
                    bitmap = null;
                    httpURLConnection = httpURLConnection2;
                    e = e5;
                    bufferedInputStream = null;
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    Set set222 = DefaultImageGetter.g;
                    k21.f(set222);
                    set222.remove(this);
                    if (!this.isCancel) {
                    }
                } catch (Throwable th5) {
                    bufferedOutputStream = null;
                    httpURLConnection = httpURLConnection2;
                    th = th5;
                    bufferedInputStream = null;
                    if (httpURLConnection != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                bufferedInputStream = null;
                bufferedOutputStream = null;
                bitmap = null;
                e.printStackTrace();
                if (httpURLConnection != null) {
                }
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                Set set2222 = DefaultImageGetter.g;
                k21.f(set2222);
                set2222.remove(this);
                if (!this.isCancel) {
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
                bufferedOutputStream = null;
                if (httpURLConnection != null) {
                }
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                throw th;
            }
            Set set22222 = DefaultImageGetter.g;
            k21.f(set22222);
            set22222.remove(this);
            if (!this.isCancel && bitmap != null) {
                ImageGetterCallBack imageGetterCallBack = this.callBack;
                String str2 = this.imageUrl;
                imageGetterCallBack.onImageReady(str2, this.start, this.end, this.this$0.h(str2, bitmap));
            }
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        private final int b(BitmapFactory.Options options, int i) {
            IpChange ipChange = $ipChange;
            int i2 = 1;
            if (AndroidInstantRuntime.support(ipChange, "-602999518")) {
                return ((Integer) ipChange.ipc$dispatch("-602999518", new Object[]{this, options, Integer.valueOf(i)})).intValue();
            }
            int i3 = options.outWidth;
            if (i3 > i) {
                while ((i3 / 2) / i2 >= i) {
                    i2 *= 2;
                }
            }
            return i2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final Bitmap d(Bitmap bitmap, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1745386438")) {
                return (Bitmap) ipChange.ipc$dispatch("1745386438", new Object[]{this, bitmap, Integer.valueOf(i)});
            } else if (bitmap == null) {
                return null;
            } else {
                return Bitmap.createScaledBitmap(bitmap, i, (int) (((((float) i) * 1.0f) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight())), false);
            }
        }

        @Nullable
        public final Bitmap c(@Nullable InputStream inputStream, boolean z, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1923007095")) {
                return (Bitmap) ipChange.ipc$dispatch("-1923007095", new Object[]{this, inputStream, Boolean.valueOf(z), Integer.valueOf(i)});
            } else if (inputStream == null) {
                return null;
            } else {
                if (!z) {
                    return d(BitmapFactory.decodeStream(inputStream), i);
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream, null, options);
                options.inSampleSize = b(options, i);
                options.inJustDecodeBounds = false;
                return d(BitmapFactory.decodeStream(inputStream, null, options), i);
            }
        }
    }

    static {
        if (h == null) {
        }
    }

    public DefaultImageGetter(@Nullable String str, int i, @NotNull Context context) {
        k21.i(context, "mContext");
        this.a = i;
        this.b = context;
        if (str == null) {
            str = "";
        } else if (!(o.v(str, "/", false, 2, null))) {
            str = str + v00.DIR;
        }
        this.e = str;
    }

    /* access modifiers changed from: private */
    public static final void j(DefaultImageGetter defaultImageGetter, ImageGetterCallBack imageGetterCallBack, String str, int i, int i2, SuccessEvent successEvent) {
        Drawable drawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-276506914")) {
            ipChange.ipc$dispatch("-276506914", new Object[]{defaultImageGetter, imageGetterCallBack, str, Integer.valueOf(i), Integer.valueOf(i2), successEvent});
            return;
        }
        k21.i(defaultImageGetter, "this$0");
        if (successEvent != null && (drawable = successEvent.drawable) != null) {
            imageGetterCallBack.onImageReady(str, i, i2, defaultImageGetter.h(str, defaultImageGetter.i(drawable)));
        }
    }

    /* access modifiers changed from: private */
    public static final void k(FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "829268426")) {
            ipChange.ipc$dispatch("829268426", new Object[]{failEvent});
        }
    }

    private final Drawable l(String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1071620073")) {
            return (Drawable) ipChange.ipc$dispatch("-1071620073", new Object[]{this, str});
        }
        ColorDrawable colorDrawable = new ColorDrawable(-3355444);
        if (str != null) {
            if (str.length() != 0) {
                z = false;
            }
            if (!z) {
                if (o.L(str, "/smiley", false, 2, null)) {
                    int i = this.d;
                    colorDrawable.setBounds(0, 0, i, i);
                } else {
                    int i2 = this.a;
                    colorDrawable.setBounds(0, 0, i2, i2 / 2);
                }
                return colorDrawable;
            }
        }
        colorDrawable.setBounds(0, 0, 120, 120);
        return colorDrawable;
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetter
    public void getDrawable(@Nullable String str, int i, int i2, @Nullable ImageGetterCallBack imageGetterCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1895517284")) {
            ipChange.ipc$dispatch("-1895517284", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), imageGetterCallBack});
        } else if (imageGetterCallBack != null && !TextUtils.isEmpty(str) && !k21.d("null", str) && !k21.d("NULL", str)) {
            k21.f(str);
            if (o.L(str, "smiley/", false, 2, null)) {
                try {
                    imageGetterCallBack.onImageReady(str, i, i2, h(str, Companion.c(this.b.getAssets().open(str), false, this.d)));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } else if ((o.L(str, "http://", false, 2, null)) || (o.L(str, "https://", false, 2, null))) {
                ImageLoaderProviderProxy.getProxy().load(str, R$drawable.bricks_shape_rect_corners_6_solid_ffffff, new x40(this, imageGetterCallBack, str, i, i2), w40.a);
            }
        }
    }

    @NotNull
    public final Drawable h(@Nullable String str, @Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835853620")) {
            return (Drawable) ipChange.ipc$dispatch("-1835853620", new Object[]{this, str, bitmap});
        } else if (bitmap == null) {
            return l(str);
        } else {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.b.getResources(), bitmap);
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            return bitmapDrawable;
        }
    }

    @Nullable
    public final Bitmap i(@Nullable Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080639536")) {
            return (Bitmap) ipChange.ipc$dispatch("1080639536", new Object[]{this, drawable});
        } else if (drawable == null) {
            return null;
        } else {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            if (createBitmap != null) {
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                drawable.draw(canvas);
            }
            return createBitmap;
        }
    }
}
