package com.uc.webview.export.internal.uc.wa;

import android.content.SharedPreferences;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.utility.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class e implements Runnable {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0109 A[SYNTHETIC, Splitter:B:58:0x0109] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0104 A[EDGE_INSN: B:79:0x0104->B:55:0x0104 ?: BREAK  , SYNTHETIC] */
    public final void run() {
        boolean z;
        boolean z2;
        int i;
        Throwable th;
        try {
            this.a.f();
            synchronized (this.a) {
                SharedPreferences sharedPreferences = this.a.k.getSharedPreferences("UC_WA_STAT", 4);
                long j = sharedPreferences.getLong(a.i(), 0);
                if (a.b) {
                    Log.d("SDKWaStat", "==handlUpload==last upload time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j)));
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (!a.a(currentTimeMillis, j)) {
                    if (a.b) {
                        Log.d("SDKWaStat", "cannot upload because of not out of inverval or in crest time");
                    }
                    return;
                }
                String[] strArr = {null};
                int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i2 != 0) {
                    String str = this.a.a(sharedPreferences);
                    boolean z3 = true;
                    if (SDKFactory.l == null || !this.a.k.getPackageName().equals("com.taobao.taobao")) {
                        byte[] a2 = a.a(this.a, strArr);
                        if (a2 != null) {
                            ValueCallback<String> valueCallback = SDKFactory.m;
                            if (valueCallback != null) {
                                try {
                                    valueCallback.onReceiveValue(new String(a2, "UTF-8"));
                                } catch (Exception e) {
                                    Log.d("SDKWaStat", "byte 转 String异常!", e);
                                }
                            }
                            if (f.a()) {
                                a2 = f.b(a2);
                            }
                            try {
                                a2 = f.a(a2);
                                try {
                                    if (a.b) {
                                        Log.d("SDKWaStat", "getUploadData encrypt:" + a2.length);
                                    }
                                    z2 = true;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z2 = true;
                                    Log.e("SDKWaStat", "data encrypt error:", th);
                                    String a3 = a.a(str, z2);
                                    if (a.b) {
                                    }
                                    i = 3;
                                    while (true) {
                                        int i3 = i - 1;
                                        if (i <= 0) {
                                        }
                                        i = i3;
                                    }
                                    if (SDKFactory.l != null) {
                                    }
                                    if (z) {
                                    }
                                    if (i2 == 0) {
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                z2 = false;
                                Log.e("SDKWaStat", "data encrypt error:", th);
                                String a32 = a.a(str, z2);
                                if (a.b) {
                                }
                                i = 3;
                                while (true) {
                                    int i32 = i - 1;
                                    if (i <= 0) {
                                    }
                                    i = i32;
                                }
                                if (SDKFactory.l != null) {
                                }
                                if (z) {
                                }
                                if (i2 == 0) {
                                }
                            }
                            String a322 = a.a(str, z2);
                            if (a.b) {
                                Log.d("SDKWaStat", "request url:" + a322);
                            }
                            i = 3;
                            while (true) {
                                int i322 = i - 1;
                                if (i <= 0) {
                                    break;
                                } else if (a.b(a322, a2)) {
                                    z = true;
                                    break;
                                } else {
                                    i = i322;
                                }
                            }
                            if (SDKFactory.l != null) {
                                try {
                                    String str2 = this.a.l();
                                    if (str2 != null) {
                                        Log.i("SDKWaStat", str2);
                                        SDKFactory.l.onReceiveValue(str2);
                                    } else {
                                        z3 = z;
                                    }
                                    z = z3;
                                } catch (Exception e2) {
                                    Log.d("SDKWaStat", "第三方上传数据出错!", e2);
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    z = false;
                    if (SDKFactory.l != null) {
                    }
                } else {
                    z = false;
                }
                if (z) {
                    new File(this.a.g(), a.h()).delete();
                    a.a(this.a, currentTimeMillis, strArr[0]);
                }
                if (i2 == 0) {
                    Log.d("SDKWaStat", "首次不上传数据");
                    a.a(this.a, currentTimeMillis, strArr[0]);
                }
            }
        } catch (Throwable th4) {
            Log.i("SDKWaStat", "handlUpload", th4);
        }
    }
}
