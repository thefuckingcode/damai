package tb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.format.DateFormat;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: Taobao */
public class k01 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static int a(BitmapFactory.Options options, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091710167")) {
            return ((Integer) ipChange.ipc$dispatch("2091710167", new Object[]{options, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 <= i || i4 <= i2) {
            return 1;
        }
        return Math.max(Math.round(((float) i3) / ((float) i)), Math.round(((float) i4) / ((float) i2)));
    }

    public static Bitmap b(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1089190787")) {
            return (Bitmap) ipChange.ipc$dispatch("1089190787", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            int i3 = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE : 90 : 180;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inSampleSize = a(options, i, i2);
                options.inJustDecodeBounds = false;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (i3 == 0) {
                    return decodeFile;
                }
                Bitmap c = c(decodeFile, i3);
                if (c != decodeFile) {
                    decodeFile.recycle();
                }
                return c;
            } catch (OutOfMemoryError unused) {
                Log.e("eee", "内存泄露！");
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public static Bitmap c(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1577518730")) {
            return (Bitmap) ipChange.ipc$dispatch("1577518730", new Object[]{bitmap, Integer.valueOf(i)});
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void d(Context context, File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1563605451")) {
            ipChange.ipc$dispatch("1563605451", new Object[]{context, file});
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0085 A[SYNTHETIC, Splitter:B:26:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0095 A[SYNTHETIC, Splitter:B:31:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    public static String e(Bitmap bitmap, String str) {
        Throwable th;
        FileNotFoundException e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598820794")) {
            return (String) ipChange.ipc$dispatch("-1598820794", new Object[]{bitmap, str});
        }
        StringBuilder sb = new StringBuilder();
        new DateFormat();
        sb.append((Object) DateFormat.format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)));
        sb.append(".png");
        String sb2 = sb.toString();
        FileOutputStream fileOutputStream = null;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = str + File.separator + sb2;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream2);
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return str2;
            } catch (FileNotFoundException e3) {
                e = e3;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        return "";
                    }
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return "";
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return "";
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            e.printStackTrace();
            if (fileOutputStream != null) {
            }
        }
    }

    public static Bitmap f(Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491042432")) {
            return (Bitmap) ipChange.ipc$dispatch("-491042432", new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = Math.min(((float) i) / ((float) width), ((float) i2) / ((float) height));
        Matrix matrix = new Matrix();
        matrix.postScale(min, min);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
