package com.taobao.phenix.compat.effects;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.annotation.NonNull;
import androidx.core.view.MotionEventCompat;
import com.taobao.pexode.PexodeOptions;
import com.taobao.phenix.bitmap.BitmapProcessor;
import com.taobao.phenix.compat.effects.internal.NdkCore;
import java.lang.reflect.Array;
import tb.cs1;
import tb.kg0;

/* compiled from: Taobao */
public class a implements BitmapProcessor {
    private static int d = 25;
    private static int e = 1;
    private final Context a;
    private final int b;
    private final int c;

    public a(Context context) {
        this(context, d, e);
    }

    public static Bitmap a(Bitmap bitmap, int i, boolean z) {
        int[] iArr;
        int i2 = i;
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i2 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[] iArr8 = new int[2];
        iArr8[1] = 3;
        iArr8[0] = i6;
        int[][] iArr9 = (int[][]) Array.newInstance(int.class, iArr8);
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = -i2;
            int i24 = 0;
            while (i23 <= i2) {
                int i25 = iArr2[i13 + Math.min(i4, Math.max(i23, 0))];
                int[] iArr10 = iArr9[i23 + i2];
                iArr10[0] = (i25 & 16711680) >> 16;
                iArr10[1] = (i25 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i25 & 255;
                int abs = i11 - Math.abs(i23);
                i24 += iArr10[0] * abs;
                i15 += iArr10[1] * abs;
                i16 += iArr10[2] * abs;
                if (i23 > 0) {
                    i20 += iArr10[0];
                    i21 += iArr10[1];
                    i22 += iArr10[2];
                } else {
                    i17 += iArr10[0];
                    i18 += iArr10[1];
                    i19 += iArr10[2];
                }
                i23++;
                i5 = i5;
                iArr6 = iArr6;
            }
            int i26 = i2;
            int i27 = i24;
            int i28 = 0;
            while (i28 < width) {
                iArr3[i13] = iArr7[i27];
                iArr4[i13] = iArr7[i15];
                iArr5[i13] = iArr7[i16];
                int i29 = i27 - i17;
                int i30 = i15 - i18;
                int i31 = i16 - i19;
                int[] iArr11 = iArr9[((i26 - i2) + i6) % i6];
                int i32 = i17 - iArr11[0];
                int i33 = i18 - iArr11[1];
                int i34 = i19 - iArr11[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr6[i28] = Math.min(i28 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i35 = iArr2[i14 + iArr6[i28]];
                iArr11[0] = (i35 & 16711680) >> 16;
                iArr11[1] = (i35 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[2] = i35 & 255;
                int i36 = i20 + iArr11[0];
                int i37 = i21 + iArr11[1];
                int i38 = i22 + iArr11[2];
                i27 = i29 + i36;
                i15 = i30 + i37;
                i16 = i31 + i38;
                i26 = (i26 + 1) % i6;
                int[] iArr12 = iArr9[i26 % i6];
                i17 = i32 + iArr12[0];
                i18 = i33 + iArr12[1];
                i19 = i34 + iArr12[2];
                i20 = i36 - iArr12[0];
                i21 = i37 - iArr12[1];
                i22 = i38 - iArr12[2];
                i13++;
                i28++;
                iArr7 = iArr;
            }
            i14 += width;
            i12++;
            copy = copy;
            height = height;
            i5 = i5;
            iArr6 = iArr6;
        }
        int i39 = i5;
        int i40 = height;
        int i41 = 0;
        while (i41 < width) {
            int i42 = -i2;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = i42;
            int i51 = i42 * width;
            int i52 = 0;
            int i53 = 0;
            while (i50 <= i2) {
                int max = Math.max(0, i51) + i41;
                int[] iArr13 = iArr9[i50 + i2];
                iArr13[0] = iArr3[max];
                iArr13[1] = iArr4[max];
                iArr13[2] = iArr5[max];
                int abs2 = i11 - Math.abs(i50);
                i52 += iArr3[max] * abs2;
                i53 += iArr4[max] * abs2;
                i43 += iArr5[max] * abs2;
                if (i50 > 0) {
                    i47 += iArr13[0];
                    i48 += iArr13[1];
                    i49 += iArr13[2];
                } else {
                    i44 += iArr13[0];
                    i45 += iArr13[1];
                    i46 += iArr13[2];
                }
                if (i50 < i39) {
                    i51 += width;
                }
                i50++;
                i39 = i39;
                width = width;
            }
            int i54 = i2;
            int i55 = i41;
            int i56 = i53;
            int i57 = i52;
            int i58 = 0;
            while (i58 < i40) {
                iArr2[i55] = (iArr2[i55] & -16777216) | (iArr7[i57] << 16) | (iArr7[i56] << 8) | iArr7[i43];
                int i59 = i57 - i44;
                int i60 = i56 - i45;
                int i61 = i43 - i46;
                int[] iArr14 = iArr9[((i54 - i2) + i6) % i6];
                int i62 = i44 - iArr14[0];
                int i63 = i45 - iArr14[1];
                int i64 = i46 - iArr14[2];
                if (i41 == 0) {
                    iArr6[i58] = Math.min(i58 + i11, i39) * width;
                }
                int i65 = iArr6[i58] + i41;
                iArr14[0] = iArr3[i65];
                iArr14[1] = iArr4[i65];
                iArr14[2] = iArr5[i65];
                int i66 = i47 + iArr14[0];
                int i67 = i48 + iArr14[1];
                int i68 = i49 + iArr14[2];
                i57 = i59 + i66;
                i56 = i60 + i67;
                i43 = i61 + i68;
                i54 = (i54 + 1) % i6;
                int[] iArr15 = iArr9[i54];
                i44 = i62 + iArr15[0];
                i45 = i63 + iArr15[1];
                i46 = i64 + iArr15[2];
                i47 = i66 - iArr15[0];
                i48 = i67 - iArr15[1];
                i49 = i68 - iArr15[2];
                i55 += width;
                i58++;
                i2 = i;
            }
            i41++;
            i2 = i;
            i39 = i39;
            i40 = i40;
            i6 = i6;
            iArr2 = iArr2;
            width = width;
        }
        copy.setPixels(iArr2, 0, width, 0, 0, width, i40);
        return copy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
    @TargetApi(18)
    public static Bitmap b(Context context, Bitmap bitmap, int i) throws RSRuntimeException {
        Throwable th;
        ScriptIntrinsicBlur scriptIntrinsicBlur;
        Allocation allocation;
        Allocation allocation2;
        RenderScript renderScript = null;
        ScriptIntrinsicBlur scriptIntrinsicBlur2 = null;
        try {
            RenderScript create = RenderScript.create(context);
            try {
                create.setMessageHandler(new RenderScript.RSMessageHandler());
                allocation2 = Allocation.createFromBitmap(create, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            } catch (Throwable th2) {
                th = th2;
                allocation2 = null;
                allocation = null;
                renderScript = create;
                scriptIntrinsicBlur = allocation;
                if (renderScript != null) {
                }
                if (allocation2 != null) {
                }
                if (allocation != null) {
                }
                if (scriptIntrinsicBlur != null) {
                }
                throw th;
            }
            try {
                allocation = Allocation.createTyped(create, allocation2.getType());
                try {
                    scriptIntrinsicBlur2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                    scriptIntrinsicBlur2.setInput(allocation2);
                    scriptIntrinsicBlur2.setRadius((float) i);
                    scriptIntrinsicBlur2.forEach(allocation);
                    allocation.copyTo(bitmap);
                    create.destroy();
                    allocation2.destroy();
                    allocation.destroy();
                    scriptIntrinsicBlur2.destroy();
                    return bitmap;
                } catch (Throwable th3) {
                    th = th3;
                    renderScript = create;
                    scriptIntrinsicBlur = scriptIntrinsicBlur2;
                    if (renderScript != null) {
                    }
                    if (allocation2 != null) {
                    }
                    if (allocation != null) {
                    }
                    if (scriptIntrinsicBlur != null) {
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                allocation = null;
                renderScript = create;
                scriptIntrinsicBlur = allocation;
                if (renderScript != null) {
                    renderScript.destroy();
                }
                if (allocation2 != null) {
                    allocation2.destroy();
                }
                if (allocation != null) {
                    allocation.destroy();
                }
                if (scriptIntrinsicBlur != null) {
                    scriptIntrinsicBlur.destroy();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            scriptIntrinsicBlur = null;
            allocation2 = null;
            allocation = null;
            if (renderScript != null) {
            }
            if (allocation2 != null) {
            }
            if (allocation != null) {
            }
            if (scriptIntrinsicBlur != null) {
            }
            throw th;
        }
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public String getId() {
        return "R" + this.b + "$S" + this.c;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public Bitmap process(@NonNull String str, @NonNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NonNull Bitmap bitmap) {
        int i;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = this.c;
        Bitmap bitmap2 = bitmapSupplier.get(width / i2, height / i2, bitmap.getConfig() != null ? bitmap.getConfig() : PexodeOptions.CONFIG);
        Canvas canvas = new Canvas(bitmap2);
        int i3 = this.c;
        canvas.scale(1.0f / ((float) i3), 1.0f / ((float) i3));
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        Bitmap a2 = NdkCore.a(bitmap2, this.b);
        if (a2 == null && Build.VERSION.SDK_INT >= 18 && (i = this.b) <= d) {
            try {
                a2 = b(this.a, bitmap2, i);
            } catch (RSRuntimeException e2) {
                kg0.f("Effects4Phenix", "render script blur error=%s", e2);
            }
        }
        return a2 == null ? a(bitmap2, this.b, true) : a2;
    }

    public a(Context context, int i, int i2) {
        boolean z = true;
        cs1.b(i > 0, "blur radius must be greater than zero");
        cs1.b(i2 <= 0 ? false : z, "blur sampling must be greater than zero");
        this.a = context;
        this.b = i;
        this.c = i2;
    }
}
