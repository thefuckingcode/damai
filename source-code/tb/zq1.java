package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class zq1 implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final int PAINT_FLAGS = 6;
    private final int a;
    private final int b;
    private PointF c;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public zq1(int i, int i2, @Nullable PointF pointF) {
        this.a = i;
        this.b = i2;
        this.c = pointF;
    }

    private final Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846926901")) {
            return (Bitmap) ipChange.ipc$dispatch("1846926901", new Object[]{this, bitmap, bitmap2, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (bitmap2 == null) {
            return null;
        } else {
            if (bitmap2.getWidth() == 0 || bitmap2.getHeight() == 0 || (bitmap2.getWidth() == i && bitmap2.getHeight() == i2)) {
                return bitmap2;
            }
            Matrix matrix = new Matrix();
            float f3 = 0.0f;
            if (this.c == null) {
                this.c = new PointF(0.0f, 0.0f);
            }
            PointF pointF = this.c;
            if (pointF != null) {
                float f4 = (float) 0;
                if (pointF.x < f4) {
                    pointF.x = 0.0f;
                }
                if (pointF.x > 1.0f) {
                    pointF.x = 1.0f;
                }
                if (pointF.y < f4) {
                    pointF.y = 0.0f;
                }
                if (pointF.y > 1.0f) {
                    pointF.y = 1.0f;
                }
            }
            if (bitmap2.getWidth() * i2 > bitmap2.getHeight() * i) {
                f2 = ((float) i2) / ((float) bitmap2.getHeight());
                float width = ((float) i) - (((float) bitmap2.getWidth()) * f2);
                PointF pointF2 = this.c;
                f3 = width * (pointF2 != null ? pointF2.x : 0.0f);
                f = 0.0f;
            } else {
                f2 = ((float) i) / ((float) bitmap2.getWidth());
                float height = ((float) i2) - (((float) bitmap2.getHeight()) * f2);
                PointF pointF3 = this.c;
                f = height * (pointF3 != null ? pointF3.y : 0.0f);
            }
            matrix.setScale(f2, f2);
            matrix.postTranslate(f3 + 0.5f, f + 0.5f);
            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(i, i2, ke1.INSTANCE.e(bitmap2));
            }
            te1 te1 = te1.INSTANCE;
            k21.h(bitmap, "result");
            te1.j(bitmap2, bitmap);
            new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
            return bitmap;
        }
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-915065160")) {
            return "com.alibaba.pictures.phenix.PointFocusCropProcessor";
        }
        return (String) ipChange.ipc$dispatch("-915065160", new Object[]{this});
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1485087537")) {
            return (Bitmap) ipChange.ipc$dispatch("-1485087537", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        k21.i(str, "s");
        k21.i(bitmapSupplier, "bitmapSupplier");
        k21.i(bitmap, "toTransform");
        Bitmap bitmap2 = bitmapSupplier.get(this.a, this.b, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        k21.h(bitmap2, "bitmapSupplier.get(outWi… Bitmap.Config.ARGB_8888)");
        Bitmap a2 = a(bitmap2, bitmap, this.a, this.b);
        k21.f(a2);
        if (bitmap2 != null && (!k21.d(bitmap2, a2))) {
            bitmap2.recycle();
        }
        return a2;
    }
}
