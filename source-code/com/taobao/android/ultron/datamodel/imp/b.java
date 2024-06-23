package com.taobao.android.ultron.datamodel.imp;

import android.util.Base64;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.ISubmitModule;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import tb.tr2;

/* compiled from: Taobao */
public class b {
    private c a = new c();
    private ISubmitModule b = new d();
    boolean c = true;

    public b(boolean z) {
        this.c = z;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0035 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032 A[SYNTHETIC, Splitter:B:18:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0041 A[SYNTHETIC, Splitter:B:29:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0045  */
    private static String b(String str) {
        Throwable th;
        if (str == null || str.isEmpty()) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        boolean z = true;
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(str.getBytes("utf-8"));
                try {
                    gZIPOutputStream2.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                }
                z = false;
                if (!z) {
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                }
                try {
                    throw th;
                } catch (Throwable th3) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused3) {
                    }
                    throw th3;
                }
            }
        } catch (IOException unused4) {
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            z = false;
            if (!z) {
            }
        } catch (Throwable th4) {
            th = th4;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            throw th;
        }
        if (!z) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused5) {
            }
            return "";
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused6) {
        }
        return Base64.encodeToString(byteArray, 0);
    }

    public String a(a aVar, IDMComponent iDMComponent) {
        String jSONString = JSON.toJSONString(this.b.asyncRequestData(aVar, iDMComponent));
        tr2.b("DMEngine", "asyncRequestData: " + jSONString);
        return this.c ? b(jSONString) : jSONString;
    }

    /* access modifiers changed from: package-private */
    public List<IDMComponent> c(a aVar, String str) {
        return this.a.f(aVar, str);
    }

    /* access modifiers changed from: package-private */
    public IDMComponent d() {
        return this.a.k();
    }

    /* access modifiers changed from: package-private */
    public boolean e(a aVar, JSONObject jSONObject) {
        return this.a.n(aVar, jSONObject);
    }

    public void f(ISubmitModule iSubmitModule) {
        if (iSubmitModule != null) {
            this.b = iSubmitModule;
        }
    }

    /* access modifiers changed from: package-private */
    public String g(a aVar) {
        String jSONString = JSON.toJSONString(this.b.submitRequestData(aVar));
        tr2.b("DMEngine", "submitRequestData: " + jSONString);
        return this.c ? b(jSONString) : jSONString;
    }
}
