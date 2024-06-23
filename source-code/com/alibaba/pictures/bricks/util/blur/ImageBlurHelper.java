package com.alibaba.pictures.bricks.util.blur;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import com.alibaba.pictures.bricks.util.PriorityTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Array;
import tb.i01;
import tb.ps1;
import tb.sc1;
import tb.wb;

/* compiled from: Taobao */
public class ImageBlurHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static a a = new a();
    private static sc1<String, Bitmap> b = new sc1<>(new wb(), KeyTransformer.IDENTITY);

    /* compiled from: Taobao */
    public interface BlurImageCallback {
        void onBlurResult(String str, Bitmap bitmap);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }
    }

    @Deprecated
    public static Bitmap d(@Nullable Context context, Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1312808156")) {
            return e(context, null, bitmap, i, i2);
        }
        return (Bitmap) ipChange.ipc$dispatch("1312808156", new Object[]{context, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static Bitmap e(@Nullable Context context, String str, Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "497911506")) {
            return (Bitmap) ipChange.ipc$dispatch("497911506", new Object[]{context, str, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (!TextUtils.isEmpty(str) && (bitmap2 = b.get(str)) != null && !bitmap2.isRecycled()) {
            return bitmap2;
        }
        Bitmap k = k(context, bitmap, i, i2);
        if (!TextUtils.isEmpty(str) && k != null && !k.isRecycled()) {
            b.save(str, k);
        }
        return k;
    }

    public static void f(final Context context, final String str, final Bitmap bitmap, final int i, final int i2, final BlurImageCallback blurImageCallback) {
        Bitmap bitmap2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "907259337")) {
            ipChange.ipc$dispatch("907259337", new Object[]{context, str, bitmap, Integer.valueOf(i), Integer.valueOf(i2), blurImageCallback});
        } else if (blurImageCallback != null) {
            if (TextUtils.isEmpty(str) || (bitmap2 = b.get(str)) == null || bitmap2.isRecycled()) {
                ps1.a(new PriorityTask("TASK_BLUR_BITMAP", null) {
                    /* class com.alibaba.pictures.bricks.util.blur.ImageBlurHelper.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.alibaba.pictures.bricks.util.PriorityTask
                    public void doTask() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1226999691")) {
                            ipChange.ipc$dispatch("1226999691", new Object[]{this});
                            return;
                        }
                        final Bitmap k = ImageBlurHelper.k(context, bitmap, i, i2);
                        if (!TextUtils.isEmpty(str) && k != null && !k.isRecycled()) {
                            ImageBlurHelper.b.save(str, k);
                        }
                        ImageBlurHelper.a.post(new Runnable() {
                            /* class com.alibaba.pictures.bricks.util.blur.ImageBlurHelper.AnonymousClass1.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "505914007")) {
                                    ipChange.ipc$dispatch("505914007", new Object[]{this});
                                    return;
                                }
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                blurImageCallback.onBlurResult(str, k);
                            }
                        });
                    }
                });
            } else {
                blurImageCallback.onBlurResult(str, bitmap2);
            }
        }
    }

    public static void g(Context context, String str, Bitmap bitmap, BlurImageCallback blurImageCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-893176407")) {
            ipChange.ipc$dispatch("-893176407", new Object[]{context, str, bitmap, blurImageCallback});
            return;
        }
        f(context, str, bitmap, j(bitmap), 20, blurImageCallback);
    }

    private static Bitmap h(Bitmap bitmap, int i, boolean z) {
        int[] iArr;
        Bitmap bitmap2 = bitmap;
        int i2 = i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954094238")) {
            return (Bitmap) ipChange.ipc$dispatch("954094238", new Object[]{bitmap2, Integer.valueOf(i), Boolean.valueOf(z)});
        }
        if (!z) {
            bitmap2 = bitmap2.copy(bitmap.getConfig(), true);
        }
        if (i2 < 1) {
            return null;
        }
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
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
            int i15 = -i2;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i15 <= i2) {
                int i25 = iArr2[i13 + Math.min(i4, Math.max(i15, 0))];
                int[] iArr10 = iArr9[i15 + i2];
                iArr10[0] = (i25 & 16711680) >> 16;
                iArr10[1] = (i25 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i25 & 255;
                int abs = i11 - Math.abs(i15);
                i16 += iArr10[0] * abs;
                i17 += iArr10[1] * abs;
                i18 += iArr10[2] * abs;
                if (i15 > 0) {
                    i22 += iArr10[0];
                    i23 += iArr10[1];
                    i24 += iArr10[2];
                } else {
                    i19 += iArr10[0];
                    i20 += iArr10[1];
                    i21 += iArr10[2];
                }
                i15++;
                bitmap2 = bitmap2;
                height = height;
            }
            int i26 = i2;
            int i27 = 0;
            while (i27 < width) {
                iArr3[i13] = iArr7[i16];
                iArr4[i13] = iArr7[i17];
                iArr5[i13] = iArr7[i18];
                int i28 = i16 - i19;
                int i29 = i17 - i20;
                int i30 = i18 - i21;
                int[] iArr11 = iArr9[((i26 - i2) + i6) % i6];
                int i31 = i19 - iArr11[0];
                int i32 = i20 - iArr11[1];
                int i33 = i21 - iArr11[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr6[i27] = Math.min(i27 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i34 = iArr2[i14 + iArr6[i27]];
                iArr11[0] = (i34 & 16711680) >> 16;
                iArr11[1] = (i34 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[2] = i34 & 255;
                int i35 = i22 + iArr11[0];
                int i36 = i23 + iArr11[1];
                int i37 = i24 + iArr11[2];
                i16 = i28 + i35;
                i17 = i29 + i36;
                i18 = i30 + i37;
                i26 = (i26 + 1) % i6;
                int[] iArr12 = iArr9[i26 % i6];
                i19 = i31 + iArr12[0];
                i20 = i32 + iArr12[1];
                i21 = i33 + iArr12[2];
                i22 = i35 - iArr12[0];
                i23 = i36 - iArr12[1];
                i24 = i37 - iArr12[2];
                i13++;
                i27++;
                iArr7 = iArr;
            }
            i14 += width;
            i12++;
            bitmap2 = bitmap2;
            height = height;
        }
        int i38 = height;
        int i39 = 0;
        while (i39 < width) {
            int i40 = -i2;
            int i41 = i40 * width;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            while (i40 <= i2) {
                int max = Math.max(0, i41) + i39;
                int[] iArr13 = iArr9[i40 + i2];
                iArr13[0] = iArr3[max];
                iArr13[1] = iArr4[max];
                iArr13[2] = iArr5[max];
                int abs2 = i11 - Math.abs(i40);
                i42 += iArr3[max] * abs2;
                i43 += iArr4[max] * abs2;
                i44 += iArr5[max] * abs2;
                if (i40 > 0) {
                    i48 += iArr13[0];
                    i49 += iArr13[1];
                    i50 += iArr13[2];
                } else {
                    i45 += iArr13[0];
                    i46 += iArr13[1];
                    i47 += iArr13[2];
                }
                if (i40 < i5) {
                    i41 += width;
                }
                i40++;
                iArr6 = iArr6;
            }
            int i51 = i39;
            int i52 = i2;
            int i53 = 0;
            while (i53 < i38) {
                iArr2[i51] = (iArr2[i51] & -16777216) | (iArr7[i42] << 16) | (iArr7[i43] << 8) | iArr7[i44];
                int i54 = i42 - i45;
                int i55 = i43 - i46;
                int i56 = i44 - i47;
                int[] iArr14 = iArr9[((i52 - i2) + i6) % i6];
                int i57 = i45 - iArr14[0];
                int i58 = i46 - iArr14[1];
                int i59 = i47 - iArr14[2];
                if (i39 == 0) {
                    iArr6[i53] = Math.min(i53 + i11, i5) * width;
                }
                int i60 = iArr6[i53] + i39;
                iArr14[0] = iArr3[i60];
                iArr14[1] = iArr4[i60];
                iArr14[2] = iArr5[i60];
                int i61 = i48 + iArr14[0];
                int i62 = i49 + iArr14[1];
                int i63 = i50 + iArr14[2];
                i42 = i54 + i61;
                i43 = i55 + i62;
                i44 = i56 + i63;
                i52 = (i52 + 1) % i6;
                int[] iArr15 = iArr9[i52];
                i45 = i57 + iArr15[0];
                i46 = i58 + iArr15[1];
                i47 = i59 + iArr15[2];
                i48 = i61 - iArr15[0];
                i49 = i62 - iArr15[1];
                i50 = i63 - iArr15[2];
                i51 += width;
                i53++;
                i2 = i;
            }
            i39++;
            i2 = i;
            i38 = i38;
            iArr6 = iArr6;
        }
        bitmap2.setPixels(iArr2, 0, width, 0, 0, width, i38);
        return bitmap2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081  */
    @TargetApi(18)
    private static Bitmap i(Context context, Bitmap bitmap, int i) throws RSRuntimeException {
        Throwable th;
        ScriptIntrinsicBlur scriptIntrinsicBlur;
        Allocation allocation;
        Allocation allocation2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1423536965")) {
            return (Bitmap) ipChange.ipc$dispatch("-1423536965", new Object[]{context, bitmap, Integer.valueOf(i)});
        }
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

    private static int j(Bitmap bitmap) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443446308")) {
            return ((Integer) ipChange.ipc$dispatch("443446308", new Object[]{bitmap})).intValue();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            i = bitmap.getAllocationByteCount();
        } else {
            i = bitmap.getByteCount();
        }
        float f = (float) i;
        if (f < 3774873.5f) {
            return 2;
        }
        return f < 8703181.0f ? 4 : 8;
    }

    /* access modifiers changed from: private */
    public static Bitmap k(@Nullable Context context, Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004795584")) {
            return (Bitmap) ipChange.ipc$dispatch("1004795584", new Object[]{context, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Bitmap c = i01.c(bitmap, i);
        if (c == null || c.isRecycled()) {
            return null;
        }
        Bitmap b2 = LibBlur.a().b(c, i2);
        if (b2 == null && context != null && Build.VERSION.SDK_INT >= 18 && i2 <= 25) {
            try {
                b2 = i(context, c, i2);
            } catch (RSRuntimeException e) {
                Log.i("TASK_BLUR_BITMAP", "render script blur error=%s :" + e);
            }
        }
        if (b2 != null) {
            return b2;
        }
        try {
            return h(bitmap, i2, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            return b2;
        }
    }
}
