package com.loc;

import com.loc.bl;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.network.util.Constants;
import tb.l63;
import tb.t13;

/* compiled from: Taobao */
public final class h extends l63 {
    private byte[] l;
    private String m = "1";

    public h(byte[] bArr, String str) {
        this.l = (byte[]) bArr.clone();
        this.m = str;
        d(bl.a.SINGLE);
        f(bl.c.HTTP);
    }

    @Override // com.loc.bl
    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put(Constants.Protocol.CONTENT_LENGTH, String.valueOf(this.l.length));
        return hashMap;
    }

    @Override // com.loc.bl
    public final String j() {
        String v = v1.v(t13.b);
        byte[] p = v1.p(t13.a);
        byte[] bArr = new byte[(p.length + 50)];
        System.arraycopy(this.l, 0, bArr, 0, 50);
        System.arraycopy(p, 0, bArr, 50, p.length);
        return String.format(v, "1", this.m, "1", "open", r1.b(bArr));
    }

    @Override // com.loc.bl
    public final boolean p() {
        return false;
    }

    @Override // com.loc.bl
    public final Map<String, String> q() {
        return null;
    }

    @Override // com.loc.bl
    public final byte[] r() {
        return this.l;
    }
}
