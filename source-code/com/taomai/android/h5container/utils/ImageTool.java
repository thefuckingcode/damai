package com.taomai.android.h5container.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.util.Base64;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.tencent.open.SocialConstants;
import com.youku.alixplayer.MsgID;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Taobao */
public class ImageTool {

    /* compiled from: Taobao */
    public interface ImageSaveCallback {
        void error(String str);

        void success();
    }

    public static Uri a(Context context, String str) {
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            return g(context, file, String.format("%d_temp.jpg", Long.valueOf(System.currentTimeMillis())), "temp");
        }
        int i = query.getInt(query.getColumnIndex("_id"));
        Uri parse = Uri.parse("content://media/external/images/media");
        return Uri.withAppendedPath(parse, "" + i);
    }

    public static void b(String str, final ImageView imageView) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            ConnectManager.getInstance().connect(str, new HttpConnectListener<HttpResponse>() {
                /* class com.taomai.android.h5container.utils.ImageTool.AnonymousClass3 */

                @Override // android.taobao.windvane.connect.HttpConnectListener
                public void onError(int i, String str) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.taomai.android.h5container.utils.ImageTool.AnonymousClass3.AnonymousClass2 */

                        public void run() {
                            ImageView imageView = imageView;
                            if (imageView != null) {
                                imageView.setImageBitmap(null);
                            }
                        }
                    });
                }

                public void onFinish(HttpResponse httpResponse, int i) {
                    try {
                        if (httpResponse.isSuccess() && "mounted".equals(Environment.getExternalStorageState())) {
                            final Bitmap decodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(httpResponse.getData()));
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                /* class com.taomai.android.h5container.utils.ImageTool.AnonymousClass3.AnonymousClass1 */

                                public void run() {
                                    ImageView imageView = imageView;
                                    if (imageView != null) {
                                        imageView.setImageBitmap(decodeStream);
                                    }
                                }
                            });
                        }
                    } catch (Exception | OutOfMemoryError e) {
                        e.printStackTrace();
                    }
                }
            });
        } else if (str.startsWith("data:")) {
            try {
                byte[] decode = Base64.decode(str.substring(str.indexOf(",") + 1).getBytes(), 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                if (imageView != null) {
                    imageView.setImageBitmap(decodeByteArray);
                }
            } catch (Throwable unused) {
                if (imageView != null) {
                    imageView.setImageBitmap(null);
                }
            }
        }
    }

    public static int c(Context context, String str, Uri uri) {
        ExifInterface exifInterface;
        if (str == null) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                if (uri == null) {
                    uri = a(context, str);
                }
                if (uri == null) {
                    return 0;
                }
                exifInterface = new ExifInterface(context.getContentResolver().openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME).getFileDescriptor());
            } else {
                exifInterface = new ExifInterface(str);
            }
            int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
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
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap d(String str, int i) {
        if (i > 10240) {
            i = MsgID.MEDIA_INFO_VIDEO_START_RECOVER;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i4) {
            i3 = i4;
        }
        int round = Math.round(((float) i3) / ((float) i));
        if (round >= 1) {
            i2 = round;
        }
        options.inSampleSize = i2;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap e(Context context, String str, int i, Uri uri) throws IOException {
        if (i > 10240) {
            i = MsgID.MEDIA_INFO_VIDEO_START_RECOVER;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        if (Build.VERSION.SDK_INT < 29) {
            BitmapFactory.decodeFile(str, options);
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            if (i3 <= i4) {
                i3 = i4;
            }
            int round = Math.round(((float) i3) / ((float) i));
            if (round >= 1) {
                i2 = round;
            }
            options.inSampleSize = i2;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } else if (uri == null && (uri = a(context, str)) == null) {
            return null;
        } else {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME);
            FileDescriptor fileDescriptor = openFileDescriptor.getFileDescriptor();
            BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            int i5 = options.outHeight;
            int i6 = options.outWidth;
            if (i5 <= i6) {
                i5 = i6;
            }
            int round2 = Math.round(((float) i5) / ((float) i));
            if (round2 >= 1) {
                i2 = round2;
            }
            options.inSampleSize = i2;
            options.inJustDecodeBounds = false;
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            openFileDescriptor.close();
            return decodeFileDescriptor;
        }
    }

    public static Bitmap f(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return bitmap != createBitmap ? createBitmap : bitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|(6:1|2|(2:4|5)(1:9)|(5:11|12|13|(2:14|(1:16)(1:48))|17)|21|(2:23|24))|25|26|(1:50)(2:47|49)|(1:(0))) */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0097, code lost:
        if (r1 != null) goto L_0x0079;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0079 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083 A[SYNTHETIC, Splitter:B:31:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008a A[SYNTHETIC, Splitter:B:35:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0092 A[SYNTHETIC, Splitter:B:42:0x0092] */
    public static Uri g(Context context, File file, String str, String str2) {
        OutputStream outputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        ContentValues contentValues = new ContentValues();
        contentValues.put(SocialConstants.PARAM_COMMENT, "This is an image");
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", "image/png");
        contentValues.put("title", "Image.png");
        contentValues.put("relative_path", "Pictures/" + str2);
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = context.getContentResolver();
        Uri insert = contentResolver.insert(uri, contentValues);
        boolean z = false;
        OutputStream outputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            if (insert != null) {
                try {
                    outputStream = contentResolver.openOutputStream(insert);
                } catch (IOException unused) {
                    outputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } else {
                outputStream = null;
            }
            if (outputStream != null) {
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                    }
                    outputStream.flush();
                } catch (IOException unused4) {
                    if (outputStream != null) {
                    }
                } catch (Throwable th3) {
                    outputStream2 = outputStream;
                    th = th3;
                    if (outputStream2 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    throw th;
                }
            }
            z = true;
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException unused5) {
            outputStream = null;
            bufferedInputStream = null;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused6) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
            if (outputStream2 != null) {
            }
            if (bufferedInputStream != null) {
            }
            throw th;
        }
        bufferedInputStream.close();
        if (z) {
            return insert;
        }
        return null;
    }

    public static Bitmap h(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width > height ? width : height;
        if (i2 <= i) {
            return bitmap;
        }
        float f = ((float) i) / ((float) i2);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
