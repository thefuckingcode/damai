package com.taobao.android.dinamic.tempate.manager;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import com.taobao.android.dinamic.tempate.manager.TemplateCache;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import tb.tj2;

/* compiled from: Taobao */
public class a {
    private String a = "default_layout";
    private String b = "default_layout.db";
    private TemplateCache c;
    protected LruCache<String, DinamicTemplate> d;

    /* access modifiers changed from: package-private */
    /* renamed from: com.taobao.android.dinamic.tempate.manager.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0202a implements FilenameFilter {
        int a = -1;
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ DinamicTemplate d;

        C0202a(a aVar, String str, int i, DinamicTemplate dinamicTemplate) {
            this.b = str;
            this.c = i;
            this.d = dinamicTemplate;
        }

        public boolean accept(File file, String str) {
            int lastIndexOf;
            if (!str.startsWith(this.b) || (lastIndexOf = str.lastIndexOf(JSMethod.NOT_SET)) == -1) {
                return false;
            }
            try {
                int intValue = Integer.valueOf(str.substring(lastIndexOf + 1)).intValue();
                if (intValue > this.a && intValue < this.c) {
                    this.a = intValue;
                    this.d.version = String.valueOf(intValue);
                }
                return true;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
    }

    public a(@NonNull Context context, String str) {
        if (context != null) {
            context.getApplicationContext();
        }
        this.a = str + "_layout";
        this.b = str + "_layout.db";
        this.d = new LruCache<>(16);
        this.c = new TemplateCache.c().h(context).i(this.b).l(this.a).k(16).j(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE).g();
    }

    private TemplateCache c() {
        return this.c;
    }

    public DinamicTemplate a(DinamicTemplate dinamicTemplate) {
        String str = dinamicTemplate.name;
        try {
            int intValue = Integer.valueOf(dinamicTemplate.version).intValue();
            DinamicTemplate dinamicTemplate2 = this.d.get(str);
            if (dinamicTemplate2 != null) {
                return dinamicTemplate2;
            }
            DinamicTemplate dinamicTemplate3 = new DinamicTemplate();
            String[] list = this.c.g().list(new C0202a(this, str, intValue, dinamicTemplate3));
            if (!(list == null || list.length == 0)) {
                dinamicTemplate3.name = str;
                return dinamicTemplate3;
            }
            return null;
        } catch (NumberFormatException unused) {
        }
    }

    public byte[] b(DinamicTemplate dinamicTemplate, String str, String str2, tj2 tj2) {
        return c().h(dinamicTemplate, str, str2, tj2);
    }

    public boolean d(@NonNull String str) {
        return c().i.get(str) != null || new File(this.c.g(), str).exists();
    }

    public byte[] e(String str, String str2) {
        String str3 = str + "/" + str2 + ".xml";
        try {
            return com.taobao.android.dinamic.parser.a.a(b.a().getAssets().open(str3));
        } catch (IOException e) {
            Log.e("LayoutFileManager", "readAssert exception: " + str3, e);
            return null;
        }
    }

    @Nullable
    public byte[] f(@NonNull String str) {
        Throwable th;
        TemplateCache c2 = c();
        byte[] bArr = null;
        try {
            byte[] bArr2 = c2.i.get(str);
            if (bArr2 != null) {
                return bArr2;
            }
            try {
                return c2.c(str, new tj2());
            } catch (Throwable th2) {
                th = th2;
                bArr = bArr2;
            }
        } catch (Throwable th3) {
            th = th3;
            Log.e("LayoutFileManager", "read local layout file exception", th);
            return bArr;
        }
    }

    public byte[] g(String str, String str2) {
        Throwable th;
        byte[] bArr = null;
        try {
            byte[] bArr2 = c().i.get(str2);
            if (bArr2 != null) {
                return bArr2;
            }
            try {
                return e(str, str2);
            } catch (Throwable th2) {
                th = th2;
                bArr = bArr2;
            }
        } catch (Throwable th3) {
            th = th3;
            Log.e("LayoutFileManager", "read local layout file from asset exception", th);
            return bArr;
        }
    }

    public byte[] h(@NonNull String str) throws IOException {
        TemplateCache c2 = c();
        byte[] bArr = c2.i.get(str);
        if (bArr != null) {
            return bArr;
        }
        File file = new File(c2.g(), str);
        if (!file.exists()) {
            return null;
        }
        byte[] l = c2.l(file);
        c2.i.put(str, l);
        return l;
    }

    public void i(TemplateCache.HttpLoader httpLoader) {
        if (httpLoader != null) {
            this.c.j = httpLoader;
        }
    }
}
