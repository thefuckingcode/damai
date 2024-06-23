package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetter;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetterCallBack;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
public class DefaultImageGetter implements ImageGetter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String f = "DefaultImageGetter";
    private static Set<BitmapWorkerTask> g = new HashSet();
    private static ExecutorService h = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private Context a;
    private e b;
    private int c;
    private final int d = ((int) (HtmlView.h * 2.5f));
    private String e;

    /* compiled from: Taobao */
    public class BitmapWorkerTask implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private ImageGetterCallBack callBack;
        private int end;
        private String imageUrl;
        private boolean isCancel;
        private int start;

        public BitmapWorkerTask(String str, int i, int i2, ImageGetterCallBack imageGetterCallBack) {
            this.imageUrl = str;
            this.start = i;
            this.end = i2;
            this.callBack = imageGetterCallBack;
        }

        public void cancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "868736188")) {
                ipChange.ipc$dispatch("868736188", new Object[]{this});
                return;
            }
            this.isCancel = true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e4, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e5, code lost:
            r3 = r0;
            r0 = r1;
            r1 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ea, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00eb, code lost:
            r1 = r0;
            r0 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f5, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f6, code lost:
            r5 = null;
            r0 = r1;
            r1 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x010d, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x010e, code lost:
            r5 = null;
            r0 = r1;
            r1 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0132, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0137, code lost:
            r5.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x013c, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0161, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            r5.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x016a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x016e, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0172, code lost:
            r0.printStackTrace();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00ea A[ExcHandler: all (r0v19 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:34:0x00c9] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x010d A[ExcHandler: all (r3v9 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:13:0x0056] */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0132  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0137  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x013c  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x014a A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0161  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0166 A[SYNTHETIC, Splitter:B:83:0x0166] */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x016e A[Catch:{ IOException -> 0x016a }] */
        /* JADX WARNING: Removed duplicated region for block: B:92:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        public void run() {
            BufferedOutputStream bufferedOutputStream;
            BufferedInputStream bufferedInputStream;
            Throwable th;
            Bitmap bitmap;
            IOException e;
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1356841303")) {
                ipChange.ipc$dispatch("-1356841303", new Object[]{this});
                return;
            }
            DefaultImageGetter.g.add(this);
            HttpURLConnection httpURLConnection = null;
            r0 = null;
            BufferedOutputStream bufferedOutputStream2 = null;
            httpURLConnection = null;
            try {
                if (this.imageUrl.startsWith("http")) {
                    str = this.imageUrl;
                } else {
                    str = DefaultImageGetter.this.e + this.imageUrl;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream(), 8192);
                } catch (IOException e2) {
                    bitmap = null;
                    bufferedOutputStream = null;
                    httpURLConnection = httpURLConnection2;
                    e = e2;
                    bufferedInputStream = null;
                    try {
                        e.printStackTrace();
                        if (httpURLConnection != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        DefaultImageGetter.g.remove(this);
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
                    bufferedOutputStream = null;
                    httpURLConnection = httpURLConnection2;
                    th = th3;
                    bufferedInputStream = null;
                    if (httpURLConnection != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    throw th;
                }
                try {
                    bitmap = BitmapFactory.decodeStream(bufferedInputStream);
                    if (bitmap != null) {
                        if (!this.isCancel) {
                            Log.d(DefaultImageGetter.f, "download image compete " + this.imageUrl);
                            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                            if (!this.imageUrl.endsWith(".jpg") && !this.imageUrl.endsWith(".jpeg") && !this.imageUrl.endsWith(".JPG")) {
                                if (!this.imageUrl.endsWith(".JPEG")) {
                                    if (this.imageUrl.endsWith(".webp")) {
                                        compressFormat = Bitmap.CompressFormat.WEBP;
                                    }
                                    bufferedOutputStream = new BufferedOutputStream(DefaultImageGetter.this.b.a(this.imageUrl), 4096);
                                    bitmap.compress(compressFormat, 90, bufferedOutputStream);
                                    Bitmap l = DefaultImageGetter.l(bitmap, DefaultImageGetter.this.c);
                                    DefaultImageGetter.this.b.b(this.imageUrl, l);
                                    bitmap = l;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                }
                            }
                            compressFormat = Bitmap.CompressFormat.JPEG;
                            bufferedOutputStream = new BufferedOutputStream(DefaultImageGetter.this.b.a(this.imageUrl), 4096);
                            try {
                                bitmap.compress(compressFormat, 90, bufferedOutputStream);
                                Bitmap l2 = DefaultImageGetter.l(bitmap, DefaultImageGetter.this.c);
                                DefaultImageGetter.this.b.b(this.imageUrl, l2);
                                bitmap = l2;
                                bufferedOutputStream2 = bufferedOutputStream;
                            } catch (IOException e3) {
                                e = e3;
                                httpURLConnection = httpURLConnection2;
                                e.printStackTrace();
                                if (httpURLConnection != null) {
                                }
                                if (bufferedOutputStream != null) {
                                }
                                if (bufferedInputStream != null) {
                                }
                                DefaultImageGetter.g.remove(this);
                                if (!this.isCancel) {
                                }
                            } catch (Throwable th4) {
                            }
                        }
                    }
                    httpURLConnection2.disconnect();
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    bufferedInputStream.close();
                } catch (IOException e5) {
                    bufferedOutputStream = null;
                    httpURLConnection = httpURLConnection2;
                    e = e5;
                    bitmap = null;
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    DefaultImageGetter.g.remove(this);
                    if (!this.isCancel) {
                    }
                } catch (Throwable th5) {
                }
            } catch (IOException e6) {
                e = e6;
                bufferedInputStream = null;
                bitmap = null;
                bufferedOutputStream = null;
                e.printStackTrace();
                if (httpURLConnection != null) {
                }
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                DefaultImageGetter.g.remove(this);
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
            DefaultImageGetter.g.remove(this);
            if (!this.isCancel && bitmap != null) {
                ImageGetterCallBack imageGetterCallBack = this.callBack;
                String str2 = this.imageUrl;
                imageGetterCallBack.onImageReady(str2, this.start, this.end, DefaultImageGetter.this.g(str2, bitmap));
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageGetterCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;

        a(ImageGetterCallBack imageGetterCallBack, String str, int i, int i2) {
            this.a = imageGetterCallBack;
            this.b = str;
            this.c = i;
            this.d = i2;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "195558006")) {
                ipChange.ipc$dispatch("195558006", new Object[]{this, eVar});
            } else if (eVar != null && (drawable = eVar.a) != null) {
                Bitmap j = DefaultImageGetter.this.j(drawable);
                ImageGetterCallBack imageGetterCallBack = this.a;
                String str = this.b;
                imageGetterCallBack.onImageReady(str, this.c, this.d, DefaultImageGetter.this.g(str, j));
            }
        }
    }

    static {
        if (h == null) {
        }
    }

    public DefaultImageGetter(String str, int i, Context context) {
        this.a = context;
        this.c = i;
        if (str == null) {
            str = "";
        } else if (!str.endsWith("/")) {
            str = str + "/";
        }
        this.e = str;
    }

    private static int h(BitmapFactory.Options options, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-1211792490")) {
            return ((Integer) ipChange.ipc$dispatch("-1211792490", new Object[]{options, Integer.valueOf(i)})).intValue();
        }
        int i3 = options.outWidth;
        if (i3 > i) {
            while ((i3 / 2) / i2 >= i) {
                i2 *= 2;
            }
        }
        return i2;
    }

    public static Bitmap i(InputStream inputStream, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "836191381")) {
            return (Bitmap) ipChange.ipc$dispatch("836191381", new Object[]{inputStream, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (inputStream == null) {
            return null;
        } else {
            if (!z) {
                return l(BitmapFactory.decodeStream(inputStream), i);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);
            options.inSampleSize = h(options, i);
            options.inJustDecodeBounds = false;
            return l(BitmapFactory.decodeStream(inputStream, null, options), i);
        }
    }

    private Drawable k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425616357")) {
            return (Drawable) ipChange.ipc$dispatch("-425616357", new Object[]{this, str});
        }
        ColorDrawable colorDrawable = new ColorDrawable(-3355444);
        if (str == null || str.isEmpty()) {
            colorDrawable.setBounds(0, 0, 120, 120);
        } else if (str.startsWith("/smiley")) {
            int i = this.d;
            colorDrawable.setBounds(0, 0, i, i);
        } else {
            int i2 = this.c;
            colorDrawable.setBounds(0, 0, i2, i2 / 2);
        }
        return colorDrawable;
    }

    /* access modifiers changed from: private */
    public static Bitmap l(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "617369298")) {
            return (Bitmap) ipChange.ipc$dispatch("617369298", new Object[]{bitmap, Integer.valueOf(i)});
        } else if (bitmap == null) {
            return null;
        } else {
            return Bitmap.createScaledBitmap(bitmap, i, (int) (((((float) i) * 1.0f) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight())), false);
        }
    }

    public Drawable g(String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-387872560")) {
            return (Drawable) ipChange.ipc$dispatch("-387872560", new Object[]{this, str, bitmap});
        } else if (bitmap == null) {
            return k(str);
        } else {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.a.getResources(), bitmap);
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            return bitmapDrawable;
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.ImageGetter
    public void getDrawable(String str, int i, int i2, ImageGetterCallBack imageGetterCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400138878")) {
            ipChange.ipc$dispatch("-1400138878", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), imageGetterCallBack});
        } else if (imageGetterCallBack == null || TextUtils.isEmpty(str) || "null".equals(str) || "NULL".equals(str)) {
        } else {
            if (str.startsWith("smiley/")) {
                try {
                    imageGetterCallBack.onImageReady(str, i, i2, g(str, i(this.a.getAssets().open(str), false, this.d)));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } else if (str.startsWith("http://") || str.startsWith("https://")) {
                cn.damai.common.image.a.b().c(str).k(new DMRoundedCornersBitmapProcessor(5, 0)).n(new a(imageGetterCallBack, str, i, i2)).f();
            }
        }
    }

    public Bitmap j(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491698004")) {
            return (Bitmap) ipChange.ipc$dispatch("-491698004", new Object[]{this, drawable});
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
