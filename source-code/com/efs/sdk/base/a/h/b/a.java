package com.efs.sdk.base.a.h.b;

import androidx.annotation.Nullable;
import com.efs.sdk.base.a.h.a.c;
import java.io.File;
import java.util.Map;
import tb.gl1;
import tb.py0;
import tb.t43;
import tb.vy0;

/* compiled from: Taobao */
public final class a implements c<vy0> {
    String a;
    Map<String, String> b;
    public byte[] c;
    public File d;
    public String e;
    public Map<String, String> f;
    public boolean g = false;

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.efs.sdk.base.a.h.a.c
    @Nullable
    public final /* synthetic */ vy0 a() {
        String str = this.e;
        str.hashCode();
        if (str.equals(gl1.TYPE_OPEN_URL_METHOD_GET)) {
            return py0.c().b().get(this.a, this.b);
        }
        if (!str.equals(gl1.TYPE_OPEN_URL_METHOD_POST)) {
            t43.c("efs.util.http", "request not support method '" + this.e + "'", null);
            return null;
        }
        byte[] bArr = this.c;
        return (bArr == null || bArr.length <= 0) ? py0.c().b().post(this.a, this.b, this.d) : this.g ? py0.c().b().postAsFile(this.a, this.b, this.c) : py0.c().b().post(this.a, this.b, this.c);
    }
}
