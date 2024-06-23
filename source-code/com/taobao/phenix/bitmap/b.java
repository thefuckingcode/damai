package com.taobao.phenix.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.taobao.pexode.Pexode;
import com.taobao.phenix.bitmap.BitmapProcessor;
import tb.a8;
import tb.tp1;

/* compiled from: Taobao */
public class b implements BitmapProcessor.BitmapSupplier {
    private static final b a = new b();

    public static b a() {
        return a;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor.BitmapSupplier
    @NonNull
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap;
        if (Pexode.j()) {
            bitmap = a8.a().newBitmapWithPin(i, i2, config);
        } else {
            BitmapPool a2 = tp1.o().a().build();
            bitmap = a2 != null ? a2.getFromPool(i, i2, config) : null;
        }
        return bitmap == null ? Bitmap.createBitmap(i, i2, config) : bitmap;
    }
}
