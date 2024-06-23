package com.alibaba.aliweex.adapter.module.blur;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
public interface BlurAlgorithm {
    @Nullable
    Bitmap blur(Bitmap bitmap, int i);

    boolean canModifyBitmap();

    @NonNull
    Bitmap.Config getSupportedBitmapConfig();
}
