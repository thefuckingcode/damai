package com.meizu.cloud.pushsdk.c.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.NetworkOnMainThreadException;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.b.a;
import com.meizu.cloud.pushsdk.c.c.k;
import com.meizu.cloud.pushsdk.c.g.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

/* compiled from: Taobao */
public class b {
    public static int a(int i, int i2, int i3, int i4) {
        double min = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (((double) f2) > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        } else if (i2 == 0) {
            return i;
        } else {
            double d = ((double) i4) / ((double) i3);
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d2 = (double) i2;
                return ((double) i) * d < d2 ? (int) (d2 / d) : i;
            }
            double d3 = (double) i2;
            return ((double) i) * d > d3 ? (int) (d3 / d) : i;
        }
    }

    public static c<Bitmap> a(k kVar, int i, int i2, Bitmap.Config config, ImageView.ScaleType scaleType) {
        Bitmap bitmap;
        byte[] bArr = new byte[0];
        try {
            bArr = g.a(kVar.b().a()).i();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i == 0 && i2 == 0) {
            options.inPreferredConfig = config;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            int a = a(i, i2, i3, i4, scaleType);
            int a2 = a(i2, i, i4, i3, scaleType);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i3, i4, a, a2);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (a(decodeByteArray, a, a2)) {
                bitmap = Bitmap.createScaledBitmap(decodeByteArray, a, a2, true);
                decodeByteArray.recycle();
            } else {
                bitmap = decodeByteArray;
            }
        }
        return bitmap == null ? c.a(b(new a(kVar))) : c.a(bitmap);
    }

    public static a a(a aVar) {
        aVar.a("connectionError");
        aVar.a(0);
        aVar.b(aVar.getMessage());
        return aVar;
    }

    public static a a(a aVar, com.meizu.cloud.pushsdk.c.a.b bVar, int i) {
        a a = bVar.a(aVar);
        a.a(i);
        a.a("responseFromServerError");
        return a;
    }

    public static a a(Exception exc) {
        a aVar = new a(exc);
        aVar.a((Build.VERSION.SDK_INT < 11 || !(exc instanceof NetworkOnMainThreadException)) ? "connectionError" : "networkOnMainThreadError");
        aVar.a(0);
        return aVar;
    }

    public static String a(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        return contentTypeFor == null ? "application/octet-stream" : contentTypeFor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x004f A[SYNTHETIC, Splitter:B:28:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0059 A[SYNTHETIC, Splitter:B:33:0x0059] */
    public static void a(k kVar, String str, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        Throwable th;
        byte[] bArr = new byte[2048];
        InputStream inputStream = null;
        try {
            InputStream b = kVar.b().b();
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                fileOutputStream = new FileOutputStream(new File(file, str2));
                while (true) {
                    try {
                        int read = b.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = b;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                fileOutputStream.flush();
                try {
                    b.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                inputStream = b;
                if (inputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    private static boolean a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return false;
        }
        return bitmap.getWidth() > i || bitmap.getHeight() > i2;
    }

    public static a b(a aVar) {
        aVar.a(0);
        aVar.a("parseError");
        aVar.b(aVar.getMessage());
        return aVar;
    }
}
