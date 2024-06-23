package cn.damai.commonbusiness.tab.download;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import tb.cu2;
import tb.xs0;
import tb.yt2;

/* compiled from: Taobao */
public class ImageDownLoader {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String e = cu2.f(ImageDownLoader.class);
    private Hashtable<String, Integer> a = new Hashtable<>();
    private LruCache<String, Bitmap> b = new a(this, ((int) Runtime.getRuntime().maxMemory()) / 8);
    private ExecutorService c = Executors.newFixedThreadPool(10);
    private File d;

    /* compiled from: Taobao */
    public interface AsyncImageLoaderListener {
        void onImageLoader(Bitmap bitmap);
    }

    /* compiled from: Taobao */
    public class a extends LruCache<String, Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;

        a(ImageDownLoader imageDownLoader, int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "975745633")) {
                return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
            }
            return ((Integer) ipChange.ipc$dispatch("975745633", new Object[]{this, str, bitmap})).intValue();
        }
    }

    /* compiled from: Taobao */
    public static class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private AsyncImageLoaderListener a;

        public b(AsyncImageLoaderListener asyncImageLoaderListener) {
            this.a = asyncImageLoaderListener;
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1584089626")) {
                ipChange.ipc$dispatch("1584089626", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            this.a.onImageLoader((Bitmap) message.obj);
        }
    }

    public ImageDownLoader(Context context) {
        this.d = cu2.a(context, "cache");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662763377")) {
            ipChange.ipc$dispatch("-662763377", new Object[]{this, str, bitmap});
        } else if (i(str) == null && bitmap != null) {
            this.b.put(str, bitmap);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x019c A[SYNTHETIC, Splitter:B:102:0x019c] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ec A[SYNTHETIC, Splitter:B:57:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0103 A[SYNTHETIC, Splitter:B:67:0x0103] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x011a A[SYNTHETIC, Splitter:B:77:0x011a] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0192 A[SYNTHETIC, Splitter:B:97:0x0192] */
    private Bitmap g(String str, int i, int i2) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ClientProtocolException e2;
        ConnectTimeoutException e3;
        Exception e4;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "5341502")) {
            return (Bitmap) ipChange.ipc$dispatch("5341502", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Bitmap h = h(str);
        if (h != null) {
            Log.i(e, "has cache: " + str);
            return h;
        }
        InputStream inputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setReadTimeout(6000);
            inputStream = openConnection.getInputStream();
            if (inputStream != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (ClientProtocolException e5) {
                    byteArrayOutputStream = null;
                    e2 = e5;
                    e2.printStackTrace();
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (this.a.get(str) != null) {
                    }
                    String str2 = e;
                    StringBuilder sb = new StringBuilder();
                    sb.append("download success:  bitmap == null -> ");
                    if (h != null) {
                    }
                    sb.append(z);
                    sb.append(" - ");
                    sb.append(str);
                    Log.i(str2, sb.toString());
                    return h;
                } catch (ConnectTimeoutException e6) {
                    byteArrayOutputStream = null;
                    e3 = e6;
                    e3.printStackTrace();
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (this.a.get(str) != null) {
                    }
                    String str22 = e;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("download success:  bitmap == null -> ");
                    if (h != null) {
                    }
                    sb2.append(z);
                    sb2.append(" - ");
                    sb2.append(str);
                    Log.i(str22, sb2.toString());
                    return h;
                } catch (Exception e7) {
                    byteArrayOutputStream = null;
                    e4 = e7;
                    try {
                        e4.printStackTrace();
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        if (this.a.get(str) != null) {
                        }
                        String str222 = e;
                        StringBuilder sb22 = new StringBuilder();
                        sb22.append("download success:  bitmap == null -> ");
                        if (h != null) {
                        }
                        sb22.append(z);
                        sb22.append(" - ");
                        sb22.append(str);
                        Log.i(str222, sb22.toString());
                        return h;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byteArrayOutputStream.toByteArray();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.toByteArray().length, options);
                    int ceil = (int) Math.ceil((double) (options.outHeight / i2));
                    int ceil2 = (int) Math.ceil((double) (options.outWidth / i));
                    if (ceil > 1 && ceil2 > 1) {
                        if (ceil <= ceil2) {
                            ceil = ceil2;
                        }
                        options.inSampleSize = ceil;
                    }
                    options.inJustDecodeBounds = false;
                    h = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.toByteArray().length, options);
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (ClientProtocolException e10) {
                    e2 = e10;
                    e2.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (this.a.get(str) != null) {
                    }
                    String str2222 = e;
                    StringBuilder sb222 = new StringBuilder();
                    sb222.append("download success:  bitmap == null -> ");
                    if (h != null) {
                    }
                    sb222.append(z);
                    sb222.append(" - ");
                    sb222.append(str);
                    Log.i(str2222, sb222.toString());
                    return h;
                } catch (ConnectTimeoutException e12) {
                    e3 = e12;
                    e3.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (this.a.get(str) != null) {
                    }
                    String str22222 = e;
                    StringBuilder sb2222 = new StringBuilder();
                    sb2222.append("download success:  bitmap == null -> ");
                    if (h != null) {
                    }
                    sb2222.append(z);
                    sb2222.append(" - ");
                    sb2222.append(str);
                    Log.i(str22222, sb2222.toString());
                    return h;
                } catch (Exception e14) {
                    e4 = e14;
                    e4.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e15) {
                            e15.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (this.a.get(str) != null) {
                    }
                    String str222222 = e;
                    StringBuilder sb22222 = new StringBuilder();
                    sb22222.append("download success:  bitmap == null -> ");
                    if (h != null) {
                    }
                    sb22222.append(z);
                    sb22222.append(" - ");
                    sb22222.append(str);
                    Log.i(str222222, sb22222.toString());
                    return h;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            }
        } catch (ClientProtocolException e18) {
            byteArrayOutputStream = null;
            e2 = e18;
            inputStream = null;
            e2.printStackTrace();
            if (inputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            if (this.a.get(str) != null) {
            }
            String str2222222 = e;
            StringBuilder sb222222 = new StringBuilder();
            sb222222.append("download success:  bitmap == null -> ");
            if (h != null) {
            }
            sb222222.append(z);
            sb222222.append(" - ");
            sb222222.append(str);
            Log.i(str2222222, sb222222.toString());
            return h;
        } catch (ConnectTimeoutException e19) {
            byteArrayOutputStream = null;
            e3 = e19;
            inputStream = null;
            e3.printStackTrace();
            if (inputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            if (this.a.get(str) != null) {
            }
            String str22222222 = e;
            StringBuilder sb2222222 = new StringBuilder();
            sb2222222.append("download success:  bitmap == null -> ");
            if (h != null) {
            }
            sb2222222.append(z);
            sb2222222.append(" - ");
            sb2222222.append(str);
            Log.i(str22222222, sb2222222.toString());
            return h;
        } catch (Exception e20) {
            byteArrayOutputStream = null;
            e4 = e20;
            inputStream = null;
            e4.printStackTrace();
            if (inputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            if (this.a.get(str) != null) {
            }
            String str222222222 = e;
            StringBuilder sb22222222 = new StringBuilder();
            sb22222222.append("download success:  bitmap == null -> ");
            if (h != null) {
            }
            sb22222222.append(z);
            sb22222222.append(" - ");
            sb22222222.append(str);
            Log.i(str222222222, sb22222222.toString());
            return h;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            if (inputStream2 != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
        if (this.a.get(str) != null) {
            int intValue = this.a.get(str).intValue();
            if (h == null && intValue < 2) {
                int i3 = intValue + 1;
                this.a.put(str, Integer.valueOf(i3));
                h = g(str, i, i2);
                Log.i(e, "Re-download " + str + ":" + i3);
            }
        }
        String str2222222222 = e;
        StringBuilder sb222222222 = new StringBuilder();
        sb222222222.append("download success:  bitmap == null -> ");
        if (h != null) {
            z = false;
        }
        sb222222222.append(z);
        sb222222222.append(" - ");
        sb222222222.append(str);
        Log.i(str2222222222, sb222222222.toString());
        return h;
    }

    private Bitmap i(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-661038091")) {
            return this.b.get(str);
        }
        return (Bitmap) ipChange.ipc$dispatch("-661038091", new Object[]{this, str});
    }

    public Bitmap h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1751876788")) {
            return (Bitmap) ipChange.ipc$dispatch("-1751876788", new Object[]{this, str});
        }
        String replaceAll = str.replaceAll("[^\\w]", "");
        if (i(str) != null) {
            return i(str);
        }
        if (!cu2.e(this.d, replaceAll) || cu2.c(new File(this.d, replaceAll)) <= 0) {
            return null;
        }
        Application a2 = xs0.a();
        Bitmap c2 = yt2.c(a2, this.d.getPath() + File.separator + replaceAll);
        f(str, c2);
        return c2;
    }

    public void j(final String str, final int i, final int i2, AsyncImageLoaderListener asyncImageLoaderListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "65852165")) {
            ipChange.ipc$dispatch("65852165", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), asyncImageLoaderListener});
            return;
        }
        String str2 = e;
        Log.i(str2, "download: " + str);
        final b bVar = new b(asyncImageLoaderListener);
        AnonymousClass2 r14 = new Runnable() {
            /* class cn.damai.commonbusiness.tab.download.ImageDownLoader.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1140338704")) {
                    ipChange.ipc$dispatch("1140338704", new Object[]{this});
                    return;
                }
                Bitmap g = ImageDownLoader.this.g(str, i, i2);
                if (g == null) {
                    String str = ImageDownLoader.e;
                    Log.d(str, "download failure: " + str);
                    return;
                }
                Message obtainMessage = bVar.obtainMessage();
                obtainMessage.obj = g;
                bVar.sendMessage(obtainMessage);
                ImageDownLoader.this.f(str, g);
                long c = cu2.c(ImageDownLoader.this.d);
                if (c > 10485760) {
                    String str2 = ImageDownLoader.e;
                    Log.i(str2, ImageDownLoader.this.d + " size has exceed limit." + c);
                    cu2.b(ImageDownLoader.this.d, false);
                    ImageDownLoader.this.a.clear();
                }
                cu2.g(ImageDownLoader.this.d, str.replaceAll("[^\\w]", ""), g);
            }
        };
        this.a.put(str, 0);
        this.c.execute(r14);
    }
}
