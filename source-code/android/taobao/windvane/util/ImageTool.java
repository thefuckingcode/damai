package android.taobao.windvane.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.util.AndroidRuntimeException;
import android.util.Base64;
import android.webkit.URLUtil;
import com.taobao.weex.ui.component.WXComponent;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import tb.jl1;

/* compiled from: Taobao */
public class ImageTool {
    private static final int MAX_LENGTH = 10240;

    /* compiled from: Taobao */
    public interface ImageSaveCallback {
        void error(String str);

        void success();
    }

    public static byte[] bitmapToBytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static int readRotationDegree(String str) {
        if (str == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
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

    public static Bitmap readZoomImage(String str, int i) {
        if (i > 10240) {
            i = 10240;
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

    public static Bitmap rotate(Bitmap bitmap, int i) {
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

    public static boolean saveImage(Context context, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 29) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File file = new File(externalStoragePublicDirectory, String.valueOf(System.currentTimeMillis()) + ".jpg");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                MediaScannerConnection.scanFile(context, new String[]{file.getAbsolutePath()}, new String[]{"image/jpeg"}, null);
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        } else if (saveImageQ(context, bitmap)) {
            return true;
        } else {
            TaoLog.e(com.alipay.ma.util.ImageTool.TAG, "save image failed");
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c3 A[SYNTHETIC, Splitter:B:34:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ce A[Catch:{ IOException -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00da A[SYNTHETIC, Splitter:B:45:0x00da] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e5 A[Catch:{ IOException -> 0x00e1 }] */
    @SuppressLint({"NewApi"})
    private static boolean saveImageQ(Context context, Bitmap bitmap) {
        Throwable th;
        ParcelFileDescriptor parcelFileDescriptor;
        IOException e;
        FileOutputStream fileOutputStream;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", String.valueOf(System.currentTimeMillis()));
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("is_pending", (Integer) 1);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + File.separator + "wv_save_image");
        Uri contentUri = MediaStore.Images.Media.getContentUri("external_primary");
        ContentResolver contentResolver = context.getContentResolver();
        Uri insert = contentResolver.insert(contentUri, contentValues);
        FileOutputStream fileOutputStream2 = null;
        if (insert == null) {
            try {
                new AndroidRuntimeException("android Q: save image error for uri is null").printStackTrace();
                return false;
            } catch (IOException e2) {
                e = e2;
                parcelFileDescriptor = null;
                fileOutputStream = null;
                try {
                    e.printStackTrace();
                    contentResolver.delete(insert, null, null);
                    if (fileOutputStream != null) {
                    }
                    if (parcelFileDescriptor != null) {
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            throw th;
                        }
                    }
                    if (parcelFileDescriptor != null) {
                        parcelFileDescriptor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                parcelFileDescriptor = null;
                if (fileOutputStream2 != null) {
                }
                if (parcelFileDescriptor != null) {
                }
                throw th;
            }
        } else {
            parcelFileDescriptor = contentResolver.openFileDescriptor(insert, WXComponent.PROP_FS_WRAP_CONTENT, null);
            try {
                fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                try {
                    if (!bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                        new AndroidRuntimeException("android Q: save image failed").printStackTrace();
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            parcelFileDescriptor.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        return false;
                    }
                    contentValues.clear();
                    contentValues.put("is_pending", (Integer) 0);
                    contentResolver.update(insert, contentValues, null, null);
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        parcelFileDescriptor.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                } catch (IOException e6) {
                    e = e6;
                    e.printStackTrace();
                    contentResolver.delete(insert, null, null);
                    if (fileOutputStream != null) {
                    }
                    if (parcelFileDescriptor != null) {
                    }
                    return false;
                }
            } catch (IOException e7) {
                e = e7;
                fileOutputStream = null;
                e.printStackTrace();
                contentResolver.delete(insert, null, null);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                        return false;
                    }
                }
                if (parcelFileDescriptor != null) {
                    parcelFileDescriptor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (fileOutputStream2 != null) {
                }
                if (parcelFileDescriptor != null) {
                }
                throw th;
            }
        }
    }

    public static void saveImageToDCIM(final Context context, String str, final ImageSaveCallback imageSaveCallback) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            ConnectManager.getInstance().connect(str, new HttpConnectListener<HttpResponse>() {
                /* class android.taobao.windvane.util.ImageTool.AnonymousClass1 */

                @Override // android.taobao.windvane.connect.HttpConnectListener
                public void onError(int i, String str) {
                    ImageSaveCallback imageSaveCallback = imageSaveCallback;
                    if (imageSaveCallback != null) {
                        imageSaveCallback.error("error get resource, code=[" + i + "],msg=[" + str + jl1.ARRAY_END_STR);
                    }
                }

                public void onFinish(HttpResponse httpResponse, int i) {
                    try {
                        if (httpResponse.isSuccess() && "mounted".equals(Environment.getExternalStorageState())) {
                            if (ImageTool.saveImage(context, BitmapFactory.decodeStream(new ByteArrayInputStream(httpResponse.getData())))) {
                                ImageSaveCallback imageSaveCallback = imageSaveCallback;
                                if (imageSaveCallback != null) {
                                    imageSaveCallback.success();
                                    return;
                                }
                                return;
                            }
                        }
                        ImageSaveCallback imageSaveCallback2 = imageSaveCallback;
                        if (imageSaveCallback2 != null) {
                            imageSaveCallback2.error("bad resource");
                        }
                    } catch (Exception e) {
                        ImageSaveCallback imageSaveCallback3 = imageSaveCallback;
                        if (imageSaveCallback3 != null) {
                            imageSaveCallback3.error(e.getMessage());
                        }
                    } catch (OutOfMemoryError e2) {
                        ImageSaveCallback imageSaveCallback4 = imageSaveCallback;
                        if (imageSaveCallback4 != null) {
                            imageSaveCallback4.error(e2.getMessage());
                        }
                    }
                }
            });
        } else if (str.startsWith("data:")) {
            try {
                byte[] decode = Base64.decode(str.substring(str.indexOf(",") + 1).getBytes(), 0);
                if (saveImage(context, BitmapFactory.decodeByteArray(decode, 0, decode.length)) && imageSaveCallback != null) {
                    imageSaveCallback.success();
                }
            } catch (Throwable th) {
                if (imageSaveCallback != null) {
                    imageSaveCallback.error(th.getMessage());
                }
            }
        }
    }

    public static Drawable toDrawable(Resources resources, String str) {
        if (str == null) {
            return null;
        }
        try {
            try {
                return new BitmapDrawable(resources, BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(str, 0))));
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                return null;
            }
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int i) {
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

    public static Bitmap zoomBitmap(Bitmap bitmap, long j, long j2) {
        int i;
        int i2;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            i2 = width;
            i = height;
        } else {
            i = width;
            i2 = height;
        }
        if (((long) i2) <= j && ((long) i) <= j2) {
            return bitmap;
        }
        float f = ((float) j) / ((float) i2);
        float f2 = ((float) j2) / ((float) i);
        if (f >= f2) {
            f = f2;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static void saveImageToDCIM(Context context, String str, final Handler handler) {
        saveImageToDCIM(context, str, new ImageSaveCallback() {
            /* class android.taobao.windvane.util.ImageTool.AnonymousClass2 */

            @Override // android.taobao.windvane.util.ImageTool.ImageSaveCallback
            public void error(String str) {
                Handler handler = handler;
                if (handler != null) {
                    handler.sendEmptyMessage(405);
                }
            }

            @Override // android.taobao.windvane.util.ImageTool.ImageSaveCallback
            public void success() {
                Handler handler = handler;
                if (handler != null) {
                    handler.sendEmptyMessage(404);
                }
            }
        });
    }
}
