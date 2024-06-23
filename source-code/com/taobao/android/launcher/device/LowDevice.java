package com.taobao.android.launcher.device;

import android.util.Pair;
import tb.l4;

/* compiled from: Taobao */
public class LowDevice {
    private static Pair<Boolean, Float> pair;

    private static Pair<Boolean, Float> createPair() {
        int a = l4.a();
        float f = 30.0f;
        boolean z = true;
        if (a == 0) {
            f = 90.0f;
        } else if (a != 1 && a == 2) {
            f = 10.0f;
        }
        if (f <= 0.0f || f > 20.0f) {
            z = false;
        }
        return Pair.create(Boolean.valueOf(z), Float.valueOf(f));
    }

    public static Pair<Boolean, Float> identify() {
        Pair<Boolean, Float> pair2 = pair;
        if (pair2 == null) {
            Pair<Boolean, Float> createPair = createPair();
            pair = createPair;
            return createPair;
        } else if (((Float) pair2.second).floatValue() > 0.0f) {
            return pair;
        } else {
            Pair<Boolean, Float> createPair2 = createPair();
            pair = createPair2;
            return createPair2;
        }
    }
}
