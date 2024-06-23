package com.vivo.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.vivo.push.d.r;
import com.vivo.push.m;
import com.vivo.push.model.InsideNotificationItem;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public final class k extends AsyncTask<String, Void, List<Bitmap>> {
    private Context a;
    private InsideNotificationItem b;
    private long c;
    private boolean d;
    private int e = 0;
    private r.a f;

    public k(Context context, InsideNotificationItem insideNotificationItem, long j, boolean z, r.a aVar) {
        this.a = context;
        this.b = insideNotificationItem;
        this.c = j;
        this.d = z;
        this.f = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(List<Bitmap> list) {
        List<Bitmap> list2 = list;
        super.onPostExecute(list2);
        p.c("ImageDownTask", "onPostExecute");
        m.c(new l(this, list2));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        if (r5 != null) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0094, code lost:
        if (r5 == null) goto L_0x0097;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0 A[SYNTHETIC, Splitter:B:41:0x00a0] */
    /* renamed from: a */
    public List<Bitmap> doInBackground(String... strArr) {
        ArrayList arrayList;
        int i;
        Throwable th;
        Bitmap bitmap;
        InputStream inputStream;
        this.e = this.b.getNotifyDisplayStatus();
        InputStream inputStream2 = null;
        if (!this.d) {
            p.d("ImageDownTask", "bitmap is not display by forbid net");
            return null;
        }
        arrayList = new ArrayList();
        for (i = 0; i < 2; i++) {
            String str = strArr[i];
            p.d("ImageDownTask", "imgUrl=" + str + " i=" + i);
            if (!TextUtils.isEmpty(str)) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    p.c("ImageDownTask", "code=".concat(String.valueOf(responseCode)));
                    if (responseCode == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            bitmap = BitmapFactory.decodeStream(inputStream);
                        } catch (MalformedURLException unused) {
                        } catch (IOException unused2) {
                            try {
                                p.a("ImageDownTask", "IOException");
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                }
                                throw th;
                            }
                        }
                    } else {
                        inputStream = null;
                        bitmap = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (MalformedURLException unused4) {
                    inputStream = null;
                    p.a("ImageDownTask", "MalformedURLException");
                } catch (IOException unused5) {
                    inputStream = null;
                    p.a("ImageDownTask", "IOException");
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception unused6) {
                        }
                    }
                    throw th;
                }
                arrayList.add(bitmap);
            } else if (i == 0) {
                arrayList.add(null);
            }
        }
        return arrayList;
        bitmap = null;
        arrayList.add(bitmap);
    }
}
