package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.log.SLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: Taobao */
public class c {
    private static String c;
    private String a;
    private d b;
    private long d;
    private Handler e;
    private WeakReference<Activity> f;
    private Runnable g = new Runnable() {
        /* class com.tencent.open.utils.c.AnonymousClass2 */

        public void run() {
            boolean z;
            SLog.v("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + m.g(c.this.a) + ".jpg";
            String str2 = c.c + str;
            File file = new File(str2);
            Message obtainMessage = c.this.e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                SLog.v("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - c.this.d));
            } else {
                Bitmap a2 = c.a(c.this.a);
                if (a2 != null) {
                    z = c.this.a(a2, str);
                } else {
                    SLog.v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z = false;
                }
                if (z) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                SLog.v("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - c.this.d));
            }
            c.this.e.sendMessage(obtainMessage);
        }
    };

    public c(Activity activity) {
        this.f = new WeakReference<>(activity);
        this.e = new Handler(activity.getMainLooper()) {
            /* class com.tencent.open.utils.c.AnonymousClass1 */

            public void handleMessage(Message message) {
                SLog.v("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    c.this.b.a(message.arg1, (String) message.obj);
                } else {
                    c.this.b.a(message.arg1, (String) null);
                }
            }
        };
    }

    public void a(String str, d dVar) {
        SLog.v("AsynLoadImg", "--save---");
        if (str == null || str.equals("")) {
            dVar.a(1, (String) null);
        } else if (!m.a()) {
            dVar.a(2, (String) null);
        } else {
            if (this.f.get() != null) {
                Activity activity = this.f.get();
                File h = m.h(activity, "Images");
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (h == null) {
                    SLog.e("AsynLoadImg", "externalImageFile is null");
                    dVar.a(2, (String) null);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(k.d(activity) ? h.getAbsolutePath() : externalStorageDirectory.getAbsolutePath());
                sb.append("/tmp/");
                c = sb.toString();
            }
            this.d = System.currentTimeMillis();
            this.a = str;
            this.b = dVar;
            new Thread(this.g).start();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d A[SYNTHETIC, Splitter:B:22:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078 A[SYNTHETIC, Splitter:B:28:0x0078] */
    public boolean a(Bitmap bitmap, String str) {
        Throwable th;
        IOException e2;
        String str2 = c;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdir();
            }
            SLog.v("AsynLoadImg", "saveFile:" + str);
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                bufferedOutputStream2.flush();
                try {
                    bufferedOutputStream2.close();
                    return true;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return true;
                }
            } catch (IOException e4) {
                e2 = e4;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    e2.printStackTrace();
                    SLog.e("AsynLoadImg", "saveFile bmp fail---", e2);
                    if (bufferedOutputStream != null) {
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e6) {
            e2 = e6;
            e2.printStackTrace();
            SLog.e("AsynLoadImg", "saveFile bmp fail---", e2);
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            return false;
        }
    }

    public static Bitmap a(String str) {
        SLog.v("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            SLog.v("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
