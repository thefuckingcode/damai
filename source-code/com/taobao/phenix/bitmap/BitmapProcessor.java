package com.taobao.phenix.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
public interface BitmapProcessor {

    /* compiled from: Taobao */
    public interface BitmapSupplier {
        @NonNull
        Bitmap get(int i, int i2, Bitmap.Config config);
    }

    String getId();

    Bitmap process(@NonNull String str, @NonNull BitmapSupplier bitmapSupplier, @NonNull Bitmap bitmap);
}
