package com.caverock.androidsvg;

import android.graphics.Canvas;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: Taobao */
class a {
    static final int a;
    private static final Method b;

    static {
        try {
            a = ((Integer) Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
            b = Canvas.class.getMethod("save", Integer.TYPE);
        } catch (Throwable th) {
            throw b(th);
        }
    }

    static void a(Canvas canvas, int i) {
        try {
            b.invoke(canvas, Integer.valueOf(i));
        } catch (Throwable th) {
            throw b(th);
        }
    }

    private static RuntimeException b(Throwable th) {
        Objects.requireNonNull(th, "t");
        return (RuntimeException) c(th);
    }

    private static <T extends Throwable> T c(Throwable th) throws Throwable {
        throw th;
    }
}
