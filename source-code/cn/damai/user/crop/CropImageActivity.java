package cn.damai.user.crop;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.crop.Crop;
import cn.damai.user.crop.ImageViewTouchBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import tb.jl1;
import tb.w12;
import tb.w81;

/* compiled from: Taobao */
public class CropImageActivity extends MonitoredActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Handler b = new Handler();
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private Uri i;
    private Uri j;
    private boolean k;
    private int l;
    private w12 m;
    private CropImageView n;
    private HighlightView o;

    /* compiled from: Taobao */
    public class Cropper {
        private static transient /* synthetic */ IpChange $ipChange;

        private Cropper() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void c() {
            int i;
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-520007659")) {
                ipChange.ipc$dispatch("-520007659", new Object[]{this});
            } else if (CropImageActivity.this.m != null) {
                HighlightView highlightView = new HighlightView(CropImageActivity.this.n);
                int e = CropImageActivity.this.m.e();
                int b = CropImageActivity.this.m.b();
                Rect rect = new Rect(0, 0, e, b);
                int min = (Math.min(e, b) * 4) / 5;
                if (CropImageActivity.this.c == 0 || CropImageActivity.this.d == 0) {
                    i = min;
                } else if (CropImageActivity.this.c > CropImageActivity.this.d) {
                    i = (CropImageActivity.this.d * min) / CropImageActivity.this.c;
                } else {
                    i = min;
                    min = (CropImageActivity.this.c * min) / CropImageActivity.this.d;
                }
                int i2 = (e - min) / 2;
                int i3 = (b - i) / 2;
                RectF rectF = new RectF((float) i2, (float) i3, (float) (i2 + min), (float) (i3 + i));
                Matrix unrotatedMatrix = CropImageActivity.this.n.getUnrotatedMatrix();
                if (CropImageActivity.this.c == 0 || CropImageActivity.this.d == 0) {
                    z = false;
                }
                highlightView.s(unrotatedMatrix, rect, rectF, z);
                CropImageActivity.this.n.add(highlightView);
            }
        }

        public void b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "690660434")) {
                ipChange.ipc$dispatch("690660434", new Object[]{this});
                return;
            }
            CropImageActivity.this.b.post(new Runnable() {
                /* class cn.damai.user.crop.CropImageActivity.Cropper.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "221746768")) {
                        ipChange.ipc$dispatch("221746768", new Object[]{this});
                        return;
                    }
                    Cropper.this.c();
                    CropImageActivity.this.n.invalidate();
                    if (CropImageActivity.this.n.highlightViews.size() == 1) {
                        CropImageActivity cropImageActivity = CropImageActivity.this;
                        cropImageActivity.o = cropImageActivity.n.highlightViews.get(0);
                        CropImageActivity.this.o.q(true);
                    }
                }
            });
        }

        /* synthetic */ Cropper(CropImageActivity cropImageActivity, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    public class a implements ImageViewTouchBase.Recycler {
        private static transient /* synthetic */ IpChange $ipChange;

        a(CropImageActivity cropImageActivity) {
        }

        @Override // cn.damai.user.crop.ImageViewTouchBase.Recycler
        public void recycle(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1275230691")) {
                ipChange.ipc$dispatch("-1275230691", new Object[]{this, bitmap});
                return;
            }
            bitmap.recycle();
            System.gc();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1308419032")) {
                ipChange.ipc$dispatch("1308419032", new Object[]{this, view});
                return;
            }
            CropImageActivity.this.setResult(0);
            CropImageActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-875257895")) {
                ipChange.ipc$dispatch("-875257895", new Object[]{this, view});
                return;
            }
            CropImageActivity.this.s();
        }
    }

    private int l(Uri uri) throws IOException {
        Throwable th;
        IpChange ipChange = $ipChange;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-1257429207")) {
            return ((Integer) ipChange.ipc$dispatch("-1257429207", new Object[]{this, uri})).intValue();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            InputStream openInputStream = getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(openInputStream, null, options);
                CropUtil.a(openInputStream);
                int o2 = o();
                while (true) {
                    if (options.outHeight / i2 <= o2 && options.outWidth / i2 <= o2) {
                        return i2;
                    }
                    i2 <<= 1;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = openInputStream;
                CropUtil.a(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CropUtil.a(inputStream);
            throw th;
        }
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287995994")) {
            ipChange.ipc$dispatch("-287995994", new Object[]{this});
            return;
        }
        this.n.clear();
        w12 w12 = this.m;
        if (w12 != null) {
            w12.g();
        }
        System.gc();
    }

    private Bitmap n(Rect rect, int i2, int i3) {
        Throwable th;
        Bitmap bitmap;
        IOException iOException;
        OutOfMemoryError outOfMemoryError;
        Rect rect2 = rect;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1854386832")) {
            return (Bitmap) ipChange.ipc$dispatch("1854386832", new Object[]{this, rect2, Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        m();
        InputStream inputStream = null;
        try {
            InputStream openInputStream = getContentResolver().openInputStream(this.i);
            try {
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(openInputStream, false);
                int width = newInstance.getWidth();
                int height = newInstance.getHeight();
                if (this.g != 0) {
                    Matrix matrix = new Matrix();
                    matrix.setRotate((float) (-this.g));
                    RectF rectF = new RectF();
                    matrix.mapRect(rectF, new RectF(rect2));
                    float f2 = 0.0f;
                    float f3 = rectF.left < 0.0f ? (float) width : 0.0f;
                    if (rectF.top < 0.0f) {
                        f2 = (float) height;
                    }
                    rectF.offset(f3, f2);
                    rect2 = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                }
                try {
                    Bitmap decodeRegion = newInstance.decodeRegion(rect2, new BitmapFactory.Options());
                    if (decodeRegion != null && (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2) > i2 || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2) > i3)) {
                        Matrix matrix2 = new Matrix();
                        matrix2.postScale(((float) i2) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2)), ((float) i3) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2)));
                        decodeRegion = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix2, true);
                    }
                    CropUtil.a(openInputStream);
                    return decodeRegion;
                } catch (IllegalArgumentException e2) {
                    throw new IllegalArgumentException("Rectangle " + rect2 + " is outside of the image (" + width + "," + height + "," + this.g + jl1.BRACKET_END_STR, e2);
                }
            } catch (IOException e3) {
                iOException = e3;
                bitmap = null;
                inputStream = openInputStream;
                w81.a("Error cropping image: " + iOException.getMessage(), iOException);
                v(iOException);
                CropUtil.a(inputStream);
                return bitmap;
            } catch (OutOfMemoryError e4) {
                outOfMemoryError = e4;
                bitmap = null;
                inputStream = openInputStream;
                w81.a("OOM cropping image: " + outOfMemoryError.getMessage(), outOfMemoryError);
                v(outOfMemoryError);
                CropUtil.a(inputStream);
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                inputStream = openInputStream;
                CropUtil.a(inputStream);
                throw th;
            }
        } catch (IOException e5) {
            iOException = e5;
            bitmap = null;
            w81.a("Error cropping image: " + iOException.getMessage(), iOException);
            v(iOException);
            CropUtil.a(inputStream);
            return bitmap;
        } catch (OutOfMemoryError e6) {
            outOfMemoryError = e6;
            bitmap = null;
            w81.a("OOM cropping image: " + outOfMemoryError.getMessage(), outOfMemoryError);
            v(outOfMemoryError);
            CropUtil.a(inputStream);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            CropUtil.a(inputStream);
            throw th;
        }
    }

    private int o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1404526634")) {
            return ((Integer) ipChange.ipc$dispatch("-1404526634", new Object[]{this})).intValue();
        }
        int p = p();
        if (p == 0) {
            return 2048;
        }
        return Math.min(p, 4096);
    }

    private int p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-748885610")) {
            return ((Integer) ipChange.ipc$dispatch("-748885610", new Object[]{this})).intValue();
        }
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        return iArr[0];
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0069 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context, cn.damai.user.crop.CropImageActivity, android.app.Activity] */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.alibaba.ip.runtime.IpChange] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARNING: Unknown variable types count: 4 */
    private void r() {
        ?? r1;
        Throwable th;
        ?? r12;
        Object obj;
        IOException e2;
        OutOfMemoryError e3;
        ?? r0 = $ipChange;
        if (AndroidInstantRuntime.support(r0, "-1150609395")) {
            r0.ipc$dispatch("-1150609395", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.c = extras.getInt("aspect_x");
            this.d = extras.getInt("aspect_y");
            this.e = extras.getInt(Crop.Extra.MAX_X);
            this.f = extras.getInt(Crop.Extra.MAX_Y);
            this.h = extras.getBoolean(Crop.Extra.AS_PNG, false);
            this.j = (Uri) extras.getParcelable("output");
        }
        Uri data = intent.getData();
        this.i = data;
        if (data != null) {
            ContentResolver contentResolver = getContentResolver();
            Uri uri = this.i;
            this.g = CropUtil.c(CropUtil.d(this, contentResolver, uri));
            try {
                this.l = l(this.i);
                InputStream openInputStream = getContentResolver().openInputStream(this.i);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.l;
                    this.m = new w12(BitmapFactory.decodeStream(openInputStream, null, options), this.g);
                    r12 = openInputStream;
                } catch (IOException e4) {
                    e2 = e4;
                    obj = openInputStream;
                } catch (OutOfMemoryError e5) {
                    e3 = e5;
                    uri = openInputStream;
                    w81.a("OOM reading image: " + e3.getMessage(), e3);
                    v(e3);
                    r12 = uri;
                    CropUtil.a(r12);
                }
            } catch (IOException e6) {
                obj = null;
                e2 = e6;
                w81.a("Error reading image: " + e2.getMessage(), e2);
                v(e2);
                r12 = obj;
                CropUtil.a(r12);
            } catch (OutOfMemoryError e7) {
                uri = null;
                e3 = e7;
                w81.a("OOM reading image: " + e3.getMessage(), e3);
                v(e3);
                r12 = uri;
                CropUtil.a(r12);
            } catch (Throwable th2) {
                th = th2;
                r1 = uri;
                CropUtil.a(r1);
                throw th;
            }
            CropUtil.a(r12);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void s() {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1461099866")) {
            ipChange.ipc$dispatch("-1461099866", new Object[]{this});
            return;
        }
        HighlightView highlightView = this.o;
        if (highlightView != null && !this.k) {
            this.k = true;
            Rect i3 = highlightView.i((float) this.l);
            int width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(i3);
            int height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(i3);
            int i4 = this.e;
            if (i4 > 0 && (i2 = this.f) > 0 && (width > i4 || height > i2)) {
                float f2 = ((float) width) / ((float) height);
                if (((float) i4) / ((float) i2) > f2) {
                    width = (int) ((((float) i2) * f2) + 0.5f);
                    height = i2;
                } else {
                    height = (int) ((((float) i4) / f2) + 0.5f);
                    width = i4;
                }
            }
            try {
                Bitmap n2 = n(i3, width, height);
                if (n2 != null) {
                    this.n.setImageRotateBitmapResetBase(new w12(n2, this.g), true);
                    this.n.center();
                    this.n.highlightViews.clear();
                }
                t(n2);
            } catch (IllegalArgumentException e2) {
                v(e2);
                finish();
            }
        }
    }

    private void t(final Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "271624987")) {
            ipChange.ipc$dispatch("271624987", new Object[]{this, bitmap});
        } else if (bitmap != null) {
            CropUtil.g(this, null, "保存中", new Runnable() {
                /* class cn.damai.user.crop.CropImageActivity.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-528161227")) {
                        ipChange.ipc$dispatch("-528161227", new Object[]{this});
                        return;
                    }
                    CropImageActivity.this.u(bitmap);
                }
            }, this.b);
        } else {
            finish();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void u(final Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217672403")) {
            ipChange.ipc$dispatch("217672403", new Object[]{this, bitmap});
            return;
        }
        if (this.j != null) {
            OutputStream outputStream = null;
            try {
                outputStream = getContentResolver().openOutputStream(this.j);
                if (outputStream != null) {
                    bitmap.compress(this.h ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 90, outputStream);
                }
            } catch (IOException e2) {
                v(e2);
                w81.a("Cannot open file: " + this.j, e2);
            } catch (Throwable th) {
                CropUtil.a(null);
                throw th;
            }
            CropUtil.a(outputStream);
            CropUtil.b(CropUtil.d(this, getContentResolver(), this.i), CropUtil.d(this, getContentResolver(), this.j));
            w(this.j);
        }
        this.b.post(new Runnable() {
            /* class cn.damai.user.crop.CropImageActivity.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-724674732")) {
                    ipChange.ipc$dispatch("-724674732", new Object[]{this});
                    return;
                }
                CropImageActivity.this.n.clear();
                bitmap.recycle();
            }
        });
        finish();
    }

    private void v(Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1008524332")) {
            ipChange.ipc$dispatch("1008524332", new Object[]{this, th});
            return;
        }
        setResult(404, new Intent().putExtra("error", th));
    }

    private void w(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2066921637")) {
            ipChange.ipc$dispatch("-2066921637", new Object[]{this, uri});
            return;
        }
        setResult(-1, new Intent().putExtra("output", uri));
    }

    private void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2088389064")) {
            ipChange.ipc$dispatch("2088389064", new Object[]{this});
            return;
        }
        setContentView(R$layout.activity_crop_image);
        CropImageView cropImageView = (CropImageView) findViewById(R$id.crop_image);
        this.n = cropImageView;
        cropImageView.context = this;
        cropImageView.setRecycler(new a(this));
        findViewById(R$id.btn_cancel).setOnClickListener(new b());
        findViewById(R$id.btn_done).setOnClickListener(new c());
    }

    @TargetApi(19)
    private void y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1182056865")) {
            ipChange.ipc$dispatch("-1182056865", new Object[]{this});
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            requestWindowFeature(1);
            if (i2 >= 19) {
                getWindow().clearFlags(ConfigReporter.BIT_GETTER_IMP);
            }
        }
    }

    private void z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001332801")) {
            ipChange.ipc$dispatch("-2001332801", new Object[]{this});
        } else if (!isFinishing()) {
            this.n.setImageRotateBitmapResetBase(this.m, true);
            CropUtil.g(this, null, "稍等片刻", new Runnable() {
                /* class cn.damai.user.crop.CropImageActivity.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-331647722")) {
                        ipChange.ipc$dispatch("-331647722", new Object[]{this});
                        return;
                    }
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    CropImageActivity.this.b.post(new Runnable() {
                        /* class cn.damai.user.crop.CropImageActivity.AnonymousClass4.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "755386153")) {
                                ipChange.ipc$dispatch("755386153", new Object[]{this});
                                return;
                            }
                            if (CropImageActivity.this.n.getScale() == 1.0f) {
                                CropImageActivity.this.n.center();
                            }
                            countDownLatch.countDown();
                        }
                    });
                    try {
                        countDownLatch.await();
                        new Cropper(CropImageActivity.this, null).b();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, this.b);
        }
    }

    @Override // cn.damai.user.crop.MonitoredActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "731831126")) {
            ipChange.ipc$dispatch("731831126", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        y();
        x();
        r();
        if (this.m == null) {
            finish();
        } else {
            z();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.user.crop.MonitoredActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1895570966")) {
            ipChange.ipc$dispatch("1895570966", new Object[]{this});
            return;
        }
        super.onDestroy();
        w12 w12 = this.m;
        if (w12 != null) {
            w12.g();
        }
    }

    public boolean onSearchRequested() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "758248686")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("758248686", new Object[]{this})).booleanValue();
    }

    public boolean q() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-127258855")) {
            return this.k;
        }
        return ((Boolean) ipChange.ipc$dispatch("-127258855", new Object[]{this})).booleanValue();
    }
}
