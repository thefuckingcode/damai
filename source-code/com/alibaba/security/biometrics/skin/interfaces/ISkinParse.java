package com.alibaba.security.biometrics.skin.interfaces;

import android.graphics.Bitmap;

/* compiled from: Taobao */
public interface ISkinParse {
    String convertWebPath(String str);

    Bitmap parseBitmap(String str);
}
