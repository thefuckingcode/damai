package tv.cjump.jni;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import java.lang.reflect.Field;

/* compiled from: Taobao */
public class NativeBitmapFactory {
    private static final String a = "NativeBitmapFactory";
    static Field b;
    static boolean c;
    static boolean d;

    public static Bitmap a(int i, int i2, Bitmap.Config config) {
        return b(i, i2, config, config.equals(Bitmap.Config.ARGB_8888));
    }

    public static Bitmap b(int i, int i2, Bitmap.Config config, boolean z) {
        if (!c || b == null) {
            return Bitmap.createBitmap(i, i2, config);
        }
        return c(i, i2, config, z);
    }

    private static Bitmap c(int i, int i2, Bitmap.Config config, boolean z) {
        int d2 = d(config);
        if (Build.VERSION.SDK_INT == 19) {
            return createBitmap19(i, i2, d2, z);
        }
        return createBitmap(i, i2, d2, z);
    }

    private static native Bitmap createBitmap(int i, int i2, int i3, boolean z);

    private static native Bitmap createBitmap19(int i, int i2, int i3, boolean z);

    public static int d(Bitmap.Config config) {
        try {
            Field field = b;
            if (field == null) {
                return 0;
            }
            return field.getInt(config);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    static void e() {
        try {
            Field declaredField = Bitmap.Config.class.getDeclaredField("nativeInt");
            b = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            b = null;
            e.printStackTrace();
        }
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT < 11 || (c && b != null);
    }

    public static void g() {
        if (!d) {
            if (!DeviceUtils.g() && !DeviceUtils.h()) {
                d = true;
                c = false;
            } else if (!c) {
                try {
                    int i = Build.VERSION.SDK_INT;
                    if (i < 11 || i >= 23) {
                        d = true;
                        c = false;
                        Log.d(a, "os version not loadLibrary ndkbitmap");
                    } else {
                        System.loadLibrary("ndkbitmap");
                        c = true;
                        Log.d(a, "loadLibrary ndkbitmap");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d = true;
                    c = false;
                    Log.d(a, "loadLibrary Exception");
                } catch (Error e2) {
                    e2.printStackTrace();
                    d = true;
                    c = false;
                    Log.d(a, "loadLibrary Error");
                }
                if (c) {
                    try {
                        boolean init = init();
                        String str = a;
                        Log.d(str, "libInit init");
                        if (!init) {
                            release();
                            d = true;
                            c = false;
                            Log.d(str, "init error");
                        } else {
                            e();
                            if (!i()) {
                                release();
                                d = true;
                                c = false;
                                Log.d(str, "testLib Error");
                            }
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        d = true;
                        c = false;
                        Log.d(a, "init Exception");
                    }
                }
                String str2 = a;
                Log.e(str2, "loadLibs " + c);
            }
        }
    }

    public static void h() {
        if (c) {
            release();
        }
        b = null;
        c = false;
    }

    @SuppressLint({"NewApi"})
    private static boolean i() {
        if (b == null) {
            return false;
        }
        Bitmap bitmap = null;
        try {
            Bitmap c2 = c(2, 2, Bitmap.Config.ARGB_8888, true);
            boolean z = c2 != null && c2.getWidth() == 2 && c2.getHeight() == 2;
            if (z) {
                int i = Build.VERSION.SDK_INT;
                if (i >= 17 && !c2.isPremultiplied()) {
                    c2.setPremultiplied(true);
                }
                Canvas canvas = new Canvas(c2);
                Paint paint = new Paint();
                paint.setColor(SupportMenu.CATEGORY_MASK);
                paint.setTextSize(20.0f);
                canvas.drawRect(0.0f, 0.0f, (float) c2.getWidth(), (float) c2.getHeight(), paint);
                canvas.drawText("TestLib", 0.0f, 0.0f, paint);
                if (i >= 17) {
                    z = c2.isPremultiplied();
                }
            }
            if (c2 != null) {
                c2.recycle();
            }
            return z;
        } catch (Exception e) {
            Log.e(a, "exception:" + e.toString());
            if (0 != 0) {
                bitmap.recycle();
            }
            return false;
        } catch (Error unused) {
            if (0 != 0) {
                bitmap.recycle();
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    private static native boolean init();

    private static native boolean release();
}
