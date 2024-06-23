package com.youku.resource.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import androidx.collection.LruCache;

/* compiled from: Taobao */
public class ColorResourceUtils {
    private static int DefColor = Color.parseColor("#66000000");
    public static int color_99000000 = Color.parseColor("#99000000");
    public static int color_e6f92253 = Color.parseColor("#e6f92253");
    private static LruCache<Integer, Integer> sColors = new LruCache<>(100);

    public static int getColorByDef(Context context, int i) {
        return getColorByDef(context, i, DefColor);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r0.intValue() == 0) goto L_0x0017;
     */
    public static int getColorByDef(Context context, int i, int i2) {
        if (context == null) {
            return i2;
        }
        Integer num = sColors.get(Integer.valueOf(i));
        if (num != null) {
            try {
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
                num = Integer.valueOf(i2);
            }
        }
        num = Integer.valueOf(context.getResources().getColor(i));
        if (num.intValue() != 0) {
            sColors.put(Integer.valueOf(i), num);
        }
        return num.intValue();
    }
}
