package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.log.TLogConstant;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import tb.v;

/* compiled from: Taobao */
public class CropUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final boolean DEBUG = false;
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_FILE = "file";
    private static final String TAG = "CropUtil";

    public static int calculateBitmapSampleSize(Context context, Uri uri) throws IOException {
        Throwable th;
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "1832750109")) {
            return ((Integer) ipChange.ipc$dispatch("1832750109", new Object[]{context, uri})).intValue();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(openInputStream, null, options);
                closeSilently(openInputStream);
                int maxImageSize = getMaxImageSize(context);
                while (true) {
                    if (options.outHeight / i <= maxImageSize && options.outWidth / i <= maxImageSize) {
                        return i;
                    }
                    i <<= 1;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = openInputStream;
                closeSilently(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            closeSilently(inputStream);
            throw th;
        }
    }

    public static void closeSilently(Closeable closeable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1686598278")) {
            ipChange.ipc$dispatch("-1686598278", new Object[]{closeable});
        } else if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean copyExifRotation(File file, File file2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78936850")) {
            return ((Boolean) ipChange.ipc$dispatch("-78936850", new Object[]{file, file2})).booleanValue();
        }
        if (!(file == null || file2 == null)) {
            try {
                ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
                ExifInterface exifInterface2 = new ExifInterface(file2.getAbsolutePath());
                exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION));
                exifInterface2.saveAttributes();
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:? A[ExcHandler: FileNotFoundException | IOException | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:18:0x008f] */
    public static Bitmap decodeRegionCrop(Context context, Uri uri, Rect rect, int i, int i2, int i3) {
        InputStream inputStream;
        Throwable th;
        Rect rect2 = rect;
        IpChange ipChange = $ipChange;
        boolean z = false;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "2072573940")) {
            return (Bitmap) ipChange.ipc$dispatch("2072573940", new Object[]{context, uri, rect2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        Bitmap bitmap = null;
        bitmap = null;
        InputStream inputStream2 = null;
        try {
            inputStream = context.getContentResolver().openInputStream(uri);
            try {
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
                int width = newInstance.getWidth();
                int height = newInstance.getHeight();
                if (i3 != 0) {
                    Matrix matrix = new Matrix();
                    matrix.setRotate((float) (-i3));
                    RectF rectF = new RectF();
                    matrix.mapRect(rectF, new RectF(rect2));
                    float f = 0.0f;
                    float f2 = rectF.left < 0.0f ? (float) width : 0.0f;
                    if (rectF.top < 0.0f) {
                        f = (float) height;
                    }
                    rectF.offset(f2, f);
                    rect2 = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                }
                try {
                    int maxImageSize = getMaxImageSize(context);
                    int i4 = 1;
                    while (true) {
                        if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2) / i4 <= maxImageSize) {
                            if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2) / i4 <= maxImageSize) {
                                break;
                            }
                        }
                        i4 <<= 1;
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = i4;
                    Bitmap decodeRegion = newInstance.decodeRegion(rect2, options);
                    Matrix matrix2 = new Matrix();
                    if (i3 != 0) {
                        matrix2.postRotate((float) i3);
                        z = true;
                    }
                    if (i <= 0 || i2 <= 0) {
                        z2 = z;
                    } else {
                        RotateBitmap rotateBitmap = new RotateBitmap(decodeRegion, i3);
                        matrix2.postScale(((float) i) / ((float) rotateBitmap.getWidth()), ((float) i2) / ((float) rotateBitmap.getHeight()));
                    }
                    if (z2) {
                        decodeRegion = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix2, true);
                    }
                    bitmap = decodeRegion;
                } catch (FileNotFoundException | IOException | OutOfMemoryError unused) {
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                closeSilently(inputStream2);
                throw th;
            }
        } catch (FileNotFoundException | IOException | OutOfMemoryError unused2) {
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            closeSilently(inputStream2);
            throw th;
        }
        closeSilently(inputStream);
        return bitmap;
    }

    public static int getExifRotation(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790156625")) {
            return ((Integer) ipChange.ipc$dispatch("790156625", new Object[]{file})).intValue();
        } else if (file == null) {
            return 0;
        } else {
            try {
                int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
                if (attributeInt == 3) {
                    return 180;
                }
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt != 8) {
                    return 0;
                }
                return AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
            } catch (IOException unused) {
                return 0;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008e, code lost:
        if (r3 != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0094, code lost:
        if (r3 != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0096, code lost:
        r3.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x009a */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a6  */
    public static File getFromMediaUri(Context context, Uri uri) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "108324843")) {
            return (File) ipChange.ipc$dispatch("108324843", new Object[]{context, uri});
        }
        cursor = null;
        if (uri == null) {
            return null;
        }
        if ("file".equals(uri.getScheme())) {
            return new File(uri.getPath());
        }
        if ("content".equals(uri.getScheme())) {
            try {
                cursor2 = context.getContentResolver().query(uri, new String[]{"_data", "_display_name"}, null, null, null);
                if (cursor2 != null) {
                    try {
                        if (cursor2.moveToFirst()) {
                            if (uri.toString().startsWith("content://com.google.android.gallery3d")) {
                                i = cursor2.getColumnIndex("_display_name");
                            } else {
                                i = cursor2.getColumnIndex("_data");
                            }
                            if (i != -1) {
                                String string = cursor2.getString(i);
                                if (!TextUtils.isEmpty(string)) {
                                    File file = new File(string);
                                    cursor2.close();
                                    return file;
                                }
                            }
                        }
                    } catch (IllegalArgumentException unused) {
                        cursor = cursor2;
                        try {
                            File fromMediaUriPfd = getFromMediaUriPfd(context, uri);
                            if (cursor != null) {
                            }
                            return fromMediaUriPfd;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (SecurityException unused2) {
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = cursor2;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
            } catch (IllegalArgumentException unknown) {
                File fromMediaUriPfd2 = getFromMediaUriPfd(context, uri);
                if (cursor != null) {
                    cursor.close();
                }
                return fromMediaUriPfd2;
            } catch (SecurityException unused3) {
                cursor2 = null;
            }
        }
        return null;
    }

    private static File getFromMediaUriPfd(Context context, Uri uri) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        String tempFilename;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-359928299")) {
            return (File) ipChange.ipc$dispatch("-359928299", new Object[]{context, uri});
        }
        FileInputStream fileInputStream2 = null;
        if (uri == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(context.getContentResolver().openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME).getFileDescriptor());
            try {
                tempFilename = getTempFilename(context);
                fileOutputStream = new FileOutputStream(tempFilename);
            } catch (IOException unused) {
                fileOutputStream = null;
                closeSilently(fileInputStream);
                closeSilently(fileOutputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                closeSilently(fileInputStream2);
                closeSilently(fileOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        File file = new File(tempFilename);
                        closeSilently(fileInputStream);
                        closeSilently(fileOutputStream);
                        return file;
                    }
                }
            } catch (IOException unused2) {
                closeSilently(fileInputStream);
                closeSilently(fileOutputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                closeSilently(fileInputStream2);
                closeSilently(fileOutputStream);
                throw th;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            fileInputStream = null;
            closeSilently(fileInputStream);
            closeSilently(fileOutputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            closeSilently(fileInputStream2);
            closeSilently(fileOutputStream);
            throw th;
        }
    }

    private static int getMaxImageSize(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "268315838")) {
            return ((Integer) ipChange.ipc$dispatch("268315838", new Object[]{context})).intValue();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        Point point = new Point();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
        return (int) Math.sqrt(Math.pow((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), 2.0d) + Math.pow((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), 2.0d));
    }

    private static String getTempFilename(Context context) throws IOException {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "293821714")) {
            return File.createTempFile("image", TLogConstant.RUBBISH_DIR, context.getCacheDir()).getAbsolutePath();
        }
        return (String) ipChange.ipc$dispatch("293821714", new Object[]{context});
    }

    public static boolean saveOutput(Context context, Uri uri, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "95250226")) {
            return saveOutput(context, uri, bitmap, 100);
        }
        return ((Boolean) ipChange.ipc$dispatch("95250226", new Object[]{context, uri, bitmap})).booleanValue();
    }

    public static boolean saveOutput(Context context, Uri uri, Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342180967")) {
            return ((Boolean) ipChange.ipc$dispatch("-1342180967", new Object[]{context, uri, bitmap, Integer.valueOf(i)})).booleanValue();
        }
        if (uri != null) {
            Closeable closeable = null;
            try {
                closeable = context.getContentResolver().openOutputStream(uri);
                if (closeable != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, closeable);
                }
                return true;
            } catch (FileNotFoundException unused) {
            } finally {
                closeSilently(closeable);
            }
        }
        return false;
    }
}
