package com.amap.api.mapcore.util;

import android.graphics.Bitmap;

/* compiled from: Taobao */
public class eh {
    private static boolean a;
    private static boolean b;
    private static boolean c;
    private boolean d = false;
    private int e = 0;
    private int f = 20;

    public static void a(boolean z) {
        a = z;
    }

    public static void b(boolean z) {
        b = z;
    }

    public static void c(boolean z) {
        c = z;
    }

    public boolean d() {
        return this.d;
    }

    public void e() {
        this.e++;
    }

    public boolean f() {
        return this.e >= this.f;
    }

    public void g() {
        hd.c(new Exception("BlackScreen"), "PureScreenCheckTool", "uploadInfo");
    }

    public static boolean a() {
        return a;
    }

    public static boolean b() {
        return b;
    }

    public static boolean c() {
        return c;
    }

    public boolean a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i = -1;
                for (int i2 = (int) (((float) width) / 4.0f); ((float) i2) < ((float) (width * 3)) / 4.0f; i2++) {
                    for (int i3 = (int) (((float) height) / 4.0f); ((float) i3) < ((float) (height * 3)) / 4.0f; i3++) {
                        int pixel = bitmap.getPixel(i2, i3);
                        if (i == -1) {
                            i = pixel;
                        }
                        if (pixel != i) {
                            this.d = true;
                            return false;
                        } else if (pixel != -16777216) {
                            this.d = true;
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                this.d = true;
                throw th;
            }
        }
        this.d = true;
        return true;
    }
}
