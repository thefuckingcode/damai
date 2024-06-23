package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class yi0 implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final int PAINT_FLAGS = 6;
    private final int a;
    private final int b;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public yi0(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Nullable
    public final Bitmap a(@Nullable Bitmap bitmap, @Nullable Bitmap bitmap2, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289858811")) {
            return (Bitmap) ipChange.ipc$dispatch("289858811", new Object[]{this, bitmap, bitmap2, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (bitmap2 == null) {
            return null;
        } else {
            if (bitmap2.getWidth() == 0 || bitmap2.getHeight() == 0 || (bitmap2.getWidth() == i && bitmap2.getHeight() == i2)) {
                return bitmap2;
            }
            Matrix matrix = new Matrix();
            matrix.setScale(((float) i) / ((float) bitmap2.getWidth()), ((float) i2) / ((float) bitmap2.getHeight()));
            matrix.postTranslate(0.5f, 0.5f);
            if (bitmap != null) {
                me1 me1 = me1.INSTANCE;
                me1.a("fitXyCrop: recycler Bitmap + w=" + i + ",h=" + i2 + "this=" + toString());
            } else {
                Bitmap.Config e = ke1.INSTANCE.e(bitmap2);
                k21.f(e);
                bitmap = Bitmap.createBitmap(i, i2, e);
                k21.h(bitmap, "Bitmap.createBitmap(widt… getSafeConfig(toCrop)!!)");
                me1 me12 = me1.INSTANCE;
                me12.a("fitXyCrop: creat new Bitmap + w=" + i + ",h=" + i2 + "this=" + toString());
            }
            te1.INSTANCE.j(bitmap2, bitmap);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawBitmap(bitmap2, matrix, new Paint(6));
            canvas.setBitmap(null);
            return bitmap;
        }
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "351393970")) {
            return "com.alibaba.pictures.phenix.FitXYCropProcessor";
        }
        return (String) ipChange.ipc$dispatch("351393970", new Object[]{this});
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374044949")) {
            return (Bitmap) ipChange.ipc$dispatch("374044949", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        k21.i(str, "s");
        k21.i(bitmapSupplier, "bitmapSupplier");
        k21.i(bitmap, "toTransform");
        int i2 = this.b;
        if (i2 <= 0 || (i = this.a) <= 0) {
            return bitmap;
        }
        Bitmap bitmap2 = bitmapSupplier.get(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        k21.h(bitmap2, "bitmapSupplier[outWidth,… Bitmap.Config.ARGB_8888]");
        Bitmap a2 = a(bitmap2, bitmap, this.a, this.b);
        k21.f(a2);
        if (bitmap2 != null && (!k21.d(bitmap2, a2))) {
            bitmap2.recycle();
        }
        return a2;
    }
}
