package com.youku.arch.v3.util;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.DimenRes;
import androidx.collection.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
public final class DimenUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final LruCache<Integer, Integer> sDimens = new LruCache<>(100);
    private static final LruCache<String, Integer> sIdCaches = new LruCache<>(32);

    private DimenUtil() {
    }

    public static int getDimensionPixelSize(Context context, @DimenRes int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1461883111")) {
            return getDimensionPixelSize(context, i, 0);
        }
        return ((Integer) ipChange.ipc$dispatch("-1461883111", new Object[]{context, Integer.valueOf(i)})).intValue();
    }

    public static int getIdentifier(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1295055166")) {
            return ((Integer) ipChange.ipc$dispatch("-1295055166", new Object[]{context, str})).intValue();
        }
        String str2 = Constants.DIMEN + "&" + str;
        LruCache<String, Integer> lruCache = sIdCaches;
        Integer num = lruCache.get(str2);
        if (num != null && num.intValue() > 0) {
            return num.intValue();
        }
        int identifier = context.getResources().getIdentifier(str, Constants.DIMEN, context.getClass().getPackage().getName());
        int identifier2 = identifier == 0 ? context.getResources().getIdentifier(str, Constants.DIMEN, context.getPackageName()) : identifier;
        if (identifier2 <= 0) {
            return identifier2;
        }
        lruCache.put(str2, Integer.valueOf(identifier2));
        return identifier2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        if (r1.intValue() == 0) goto L_0x0040;
     */
    public static int getDimensionPixelSize(Context context, @DimenRes int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1926293648")) {
            return ((Integer) ipChange.ipc$dispatch("1926293648", new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        } else if (context == null) {
            return i2;
        } else {
            LruCache<Integer, Integer> lruCache = sDimens;
            Integer num = lruCache.get(Integer.valueOf(i));
            if (num != null) {
                try {
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                    num = Integer.valueOf(i2);
                }
            }
            num = Integer.valueOf(context.getResources().getDimensionPixelSize(i));
            if (num.intValue() != 0) {
                lruCache.put(Integer.valueOf(i), num);
            }
            return num.intValue();
        }
    }
}
