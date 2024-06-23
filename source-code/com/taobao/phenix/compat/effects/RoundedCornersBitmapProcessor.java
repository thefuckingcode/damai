package com.taobao.phenix.compat.effects;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.pexode.PexodeOptions;
import com.taobao.phenix.bitmap.BitmapProcessor;

/* compiled from: Taobao */
public class RoundedCornersBitmapProcessor implements BitmapProcessor {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final CornerType e;

    /* compiled from: Taobao */
    public enum CornerType {
        ALL,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[CornerType.values().length];
            a = iArr;
            iArr[CornerType.ALL.ordinal()] = 1;
            a[CornerType.TOP.ordinal()] = 2;
            a[CornerType.BOTTOM.ordinal()] = 3;
            a[CornerType.LEFT.ordinal()] = 4;
            a[CornerType.RIGHT.ordinal()] = 5;
        }
    }

    public RoundedCornersBitmapProcessor(int i, int i2) {
        this(0, 0, i, i2, CornerType.ALL);
    }

    private void a(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF;
        int i = this.d;
        float f3 = f - ((float) i);
        float f4 = f2 - ((float) i);
        int i2 = a.a[this.e.ordinal()];
        RectF rectF2 = null;
        if (i2 == 1) {
            int i3 = this.d;
            rectF2 = new RectF((float) i3, (float) i3, f3, f4);
            rectF = null;
        } else if (i2 == 2) {
            int i4 = this.d;
            rectF2 = new RectF((float) i4, (float) i4, f3, (float) (i4 + (this.c * 2)));
            int i5 = this.d;
            rectF = new RectF((float) i5, (float) (i5 + this.c), f3, f4);
        } else if (i2 == 3) {
            rectF2 = new RectF((float) this.d, f4 - ((float) (this.c * 2)), f3, f4);
            int i6 = this.d;
            rectF = new RectF((float) i6, (float) i6, f3, f4 - ((float) this.c));
        } else if (i2 == 4) {
            int i7 = this.d;
            rectF2 = new RectF((float) i7, (float) i7, (float) (i7 + (this.c * 2)), f4);
            int i8 = this.d;
            rectF = new RectF((float) (this.c + i8), (float) i8, f3, f4);
        } else if (i2 != 5) {
            rectF = null;
        } else {
            rectF2 = new RectF(f3 - ((float) (this.c * 2)), (float) this.d, f3, f4);
            int i9 = this.d;
            rectF = new RectF((float) i9, (float) i9, f3 - ((float) this.c), f4);
        }
        int i10 = this.c;
        canvas.drawRoundRect(rectF2, (float) i10, (float) i10, paint);
        if (rectF != null) {
            canvas.drawRect(rectF, paint);
        }
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public String getId() {
        return ExifInterface.LONGITUDE_WEST + this.a + "$H" + this.b + "$R" + this.c + "$M" + this.d + "$P" + this.e.ordinal();
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public Bitmap process(@NonNull String str, @NonNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NonNull Bitmap bitmap) {
        float f;
        int i;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = this.a;
        boolean z = i2 > 0 && (i = this.b) > 0 && !(i2 == width && i == height);
        if (z) {
            int i3 = this.b;
            if (width * i3 > height * i2) {
                f = ((float) i3) / ((float) height);
                width = (int) (((double) (((float) width) * f)) + 0.5d);
                height = i3;
            } else {
                float f2 = ((float) i2) / ((float) width);
                height = (int) (((double) (((float) height) * f2)) + 0.5d);
                f = f2;
                width = i2;
            }
        } else {
            f = 1.0f;
        }
        Bitmap bitmap2 = bitmapSupplier.get(width, height, bitmap.getConfig() != null ? bitmap.getConfig() : PexodeOptions.CONFIG);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        if (z) {
            Matrix matrix = new Matrix();
            matrix.setScale(f, f);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        a(canvas, paint, (float) width, (float) height);
        return bitmap2;
    }

    public RoundedCornersBitmapProcessor(int i, int i2, int i3, int i4, CornerType cornerType) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = cornerType;
    }
}
