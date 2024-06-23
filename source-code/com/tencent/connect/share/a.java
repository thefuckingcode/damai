package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.d;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import tb.jl1;

/* compiled from: Taobao */
public class a {
    /* access modifiers changed from: private */
    public static final boolean b(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e);
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (options.mCancel || i3 == -1 || i4 == -1) {
            return false;
        }
        int i5 = i3 > i4 ? i3 : i4;
        if (i3 >= i4) {
            i3 = i4;
        }
        SLog.d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i5 + "shortSide=" + i3);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (i5 > i2 || i3 > i) {
            return true;
        }
        return false;
    }

    public static final void a(final Context context, final String str, final d dVar) {
        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (TextUtils.isEmpty(str)) {
            dVar.a(1, (String) null);
        } else if (!m.a()) {
            dVar.a(2, (String) null);
        } else {
            final AnonymousClass1 r0 = new Handler(context.getMainLooper()) {
                /* class com.tencent.connect.share.a.AnonymousClass1 */

                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i == 101) {
                        dVar.a(0, (ArrayList) message.obj);
                    } else if (i != 102) {
                        super.handleMessage(message);
                    } else {
                        dVar.a(message.arg1, (String) null);
                    }
                }
            };
            new Thread(new Runnable() {
                /* class com.tencent.connect.share.a.AnonymousClass2 */

                public void run() {
                    String str;
                    String str2;
                    try {
                        Bitmap a2 = a.a(str, 840);
                        if (a2 != null) {
                            File a3 = g.a("Images");
                            String str3 = null;
                            if (a3 != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(a3.getAbsolutePath());
                                String str4 = File.separator;
                                sb.append(str4);
                                sb.append(Constants.QQ_SHARE_TEMP_DIR);
                                sb.append(str4);
                                str2 = sb.toString();
                                str = null;
                            } else {
                                File d = g.d();
                                if (d == null) {
                                    SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() getCacheDir = null,return error");
                                    Message obtainMessage = r0.obtainMessage();
                                    obtainMessage.arg1 = 102;
                                    r0.sendMessage(obtainMessage);
                                    return;
                                }
                                String absolutePath = d.getAbsolutePath();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(absolutePath);
                                String str5 = File.separator;
                                sb2.append(str5);
                                sb2.append(Constants.QQ_SHARE_TEMP_DIR);
                                sb2.append(str5);
                                String sb3 = sb2.toString();
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() use cache dir=" + sb3);
                                str = absolutePath;
                                str2 = sb3;
                            }
                            String str6 = "share2qq_temp" + m.g(str) + ".jpg";
                            String str7 = str;
                            if (!a.b(str7, 840, 840)) {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() not out of bound,not compress!");
                            } else {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() out of bound,compress!");
                                String a4 = a.a(a2, str2, str6);
                                if (!TextUtils.isEmpty(a4)) {
                                    str7 = a4;
                                }
                            }
                            boolean m = m.m(str7);
                            SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + m);
                            ArrayList arrayList = new ArrayList(2);
                            if (m) {
                                str3 = str7;
                            } else if (TextUtils.isEmpty(str)) {
                                String str8 = str2 + str6;
                                boolean a5 = m.a(context, str7, str8);
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str8 + ",isSuccess=" + a5);
                                if (a5) {
                                    str3 = str8;
                                }
                            }
                            arrayList.add(str7);
                            arrayList.add(str3);
                            if (arrayList.size() >= 2 && !(arrayList.get(0) == null && arrayList.get(1) == null)) {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((String) arrayList.get(0)) + "," + ((String) arrayList.get(1)) + jl1.ARRAY_END_STR);
                                Message obtainMessage2 = r0.obtainMessage(101);
                                obtainMessage2.obj = arrayList;
                                r0.sendMessage(obtainMessage2);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage runnable exception e:", e);
                    }
                    SLog.d("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return failed!");
                    Message obtainMessage3 = r0.obtainMessage(102);
                    obtainMessage3.arg1 = 3;
                    r0.sendMessage(obtainMessage3);
                }
            }).start();
        }
    }

    private static Bitmap a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f = ((float) i) / ((float) width);
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static int b(BitmapFactory.Options options, int i, int i2) {
        int i3;
        int i4;
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        if (i2 == -1) {
            i3 = 1;
        } else {
            i3 = (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        }
        if (i == -1) {
            i4 = 128;
        } else {
            double d3 = (double) i;
            i4 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (i4 < i3) {
            return i3;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? i3 : i4;
    }

    protected static final String a(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        String stringBuffer2 = stringBuffer.toString();
        File file2 = new File(stringBuffer2);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap == null) {
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
            return stringBuffer2;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005a  */
    public static final Bitmap a(String str, int i) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception1:", e);
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (options.mCancel || i2 == -1 || i3 == -1) {
            return null;
        }
        if (i2 <= i3) {
            i2 = i3;
        }
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (i2 > i) {
            options.inSampleSize = a(options, -1, i * i);
        }
        options.inJustDecodeBounds = false;
        try {
            bitmap = BitmapFactory.decodeFile(str, options);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception2:", e2);
        } catch (OutOfMemoryError e3) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap OutOfMemoryError:", e3);
        }
        if (bitmap != null) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap return null");
            return null;
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i4 <= i5) {
            i4 = i5;
        }
        return i4 > i ? a(bitmap, i) : bitmap;
        bitmap = null;
        if (bitmap != null) {
        }
    }

    public static final int a(BitmapFactory.Options options, int i, int i2) {
        int b = b(options, i, i2);
        if (b > 8) {
            return ((b + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < b) {
            i3 <<= 1;
        }
        return i3;
    }
}
