package com.youku.resource.utils;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.DimenRes;
import androidx.collection.LruCache;

/* compiled from: Taobao */
public class DimenUtils {
    private static LruCache<Integer, Integer> sDimens = new LruCache<>(100);

    public static int getDimensionPixelSize(Context context, @DimenRes int i) {
        return getDimensionPixelSize(context, i, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r0.intValue() == 0) goto L_0x0017;
     */
    public static int getDimensionPixelSize(Context context, @DimenRes int i, int i2) {
        if (context == null) {
            return i2;
        }
        Integer num = sDimens.get(Integer.valueOf(i));
        if (num != null) {
            try {
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
                num = Integer.valueOf(i2);
            }
        }
        num = Integer.valueOf(context.getResources().getDimensionPixelSize(i));
        if (num.intValue() != 0) {
            sDimens.put(Integer.valueOf(i), num);
        }
        return num.intValue();
    }
}
