package com.taobao.phenix.bitmap;

import android.graphics.Bitmap;
import tb.me;

/* compiled from: Taobao */
public interface BitmapPool {
    int available();

    void clear();

    Bitmap getFromPool(int i, int i2, Bitmap.Config config);

    void maxPoolSize(int i);

    boolean putIntoPool(me meVar);

    void trimPool(int i);
}
